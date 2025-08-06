package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import com.google.common.math.LongMath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DashMediaSource extends BaseMediaSource {
    public static final long DEFAULT_FALLBACK_TARGET_LIVE_OFFSET_MS = 30000;
    @Deprecated
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    public static final String DEFAULT_MEDIA_ID = "DashMediaSource";
    private static final long DEFAULT_NOTIFY_MANIFEST_INTERVAL_MS = 5000;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    private static final String TAG = "DashMediaSource";
    private final DashChunkSource.Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private DataSource dataSource;
    private final DrmSessionManager drmSessionManager;
    private long elapsedRealtimeOffsetMs;
    private long expiredManifestPublishTimeUs;
    private final long fallbackTargetLiveOffsetMs;
    private int firstPeriodId;
    private Handler handler;
    private Uri initialManifestUri;
    private MediaItem.LiveConfiguration liveConfiguration;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    /* access modifiers changed from: private */
    public Loader loader;
    private DashManifest manifest;
    private final ManifestCallback manifestCallback;
    private final DataSource.Factory manifestDataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    /* access modifiers changed from: private */
    public IOException manifestFatalError;
    private long manifestLoadEndTimestampMs;
    private final LoaderErrorThrower manifestLoadErrorThrower;
    private boolean manifestLoadPending;
    private long manifestLoadStartTimestampMs;
    private final ParsingLoadable.Parser<? extends DashManifest> manifestParser;
    private Uri manifestUri;
    private final Object manifestUriLock;
    private final MediaItem mediaItem;
    private TransferListener mediaTransferListener;
    private final SparseArray<DashMediaPeriod> periodsById;
    private final PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback;
    private final Runnable refreshManifestRunnable;
    private final boolean sideloadedManifest;
    private final Runnable simulateManifestRefreshRunnable;
    private int staleManifestReloadAttempt;

    public static final class DashTimeline extends Timeline {
        private final long elapsedRealtimeEpochOffsetMs;
        private final int firstPeriodId;
        private final MediaItem.LiveConfiguration liveConfiguration;
        private final DashManifest manifest;
        private final MediaItem mediaItem;
        private final long offsetInFirstPeriodUs;
        private final long presentationStartTimeMs;
        private final long windowDefaultStartPositionUs;
        private final long windowDurationUs;
        private final long windowStartTimeMs;

        public DashTimeline(long j11, long j12, long j13, int i11, long j14, long j15, long j16, DashManifest dashManifest, MediaItem mediaItem2, MediaItem.LiveConfiguration liveConfiguration2) {
            DashManifest dashManifest2 = dashManifest;
            MediaItem.LiveConfiguration liveConfiguration3 = liveConfiguration2;
            Assertions.checkState(dashManifest2.dynamic != (liveConfiguration3 != null) ? false : true);
            this.presentationStartTimeMs = j11;
            this.windowStartTimeMs = j12;
            this.elapsedRealtimeEpochOffsetMs = j13;
            this.firstPeriodId = i11;
            this.offsetInFirstPeriodUs = j14;
            this.windowDurationUs = j15;
            this.windowDefaultStartPositionUs = j16;
            this.manifest = dashManifest2;
            this.mediaItem = mediaItem2;
            this.liveConfiguration = liveConfiguration3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
            r4 = r4.adaptationSets.get(r8).representations.get(0).getIndex();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long getAdjustedWindowDefaultStartPositionUs(long r11) {
            /*
                r10 = this;
                long r0 = r10.windowDefaultStartPositionUs
                com.google.android.exoplayer2.source.dash.manifest.DashManifest r2 = r10.manifest
                boolean r2 = isMovingLiveWindow(r2)
                if (r2 != 0) goto L_0x000b
                return r0
            L_0x000b:
                r2 = 0
                int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x001e
                long r0 = r0 + r11
                long r11 = r10.windowDurationUs
                int r11 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
                if (r11 <= 0) goto L_0x001e
                r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                return r11
            L_0x001e:
                long r11 = r10.offsetInFirstPeriodUs
                long r11 = r11 + r0
                com.google.android.exoplayer2.source.dash.manifest.DashManifest r4 = r10.manifest
                r5 = 0
                long r6 = r4.getPeriodDurationUs(r5)
                r4 = r5
            L_0x0029:
                com.google.android.exoplayer2.source.dash.manifest.DashManifest r8 = r10.manifest
                int r8 = r8.getPeriodCount()
                int r8 = r8 + -1
                if (r4 >= r8) goto L_0x0041
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 < 0) goto L_0x0041
                long r11 = r11 - r6
                int r4 = r4 + 1
                com.google.android.exoplayer2.source.dash.manifest.DashManifest r6 = r10.manifest
                long r6 = r6.getPeriodDurationUs(r4)
                goto L_0x0029
            L_0x0041:
                com.google.android.exoplayer2.source.dash.manifest.DashManifest r8 = r10.manifest
                com.google.android.exoplayer2.source.dash.manifest.Period r4 = r8.getPeriod(r4)
                r8 = 2
                int r8 = r4.getAdaptationSetIndex(r8)
                r9 = -1
                if (r8 != r9) goto L_0x0050
                return r0
            L_0x0050:
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> r4 = r4.adaptationSets
                java.lang.Object r4 = r4.get(r8)
                com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r4 = (com.google.android.exoplayer2.source.dash.manifest.AdaptationSet) r4
                java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> r4 = r4.representations
                java.lang.Object r4 = r4.get(r5)
                com.google.android.exoplayer2.source.dash.manifest.Representation r4 = (com.google.android.exoplayer2.source.dash.manifest.Representation) r4
                com.google.android.exoplayer2.source.dash.DashSegmentIndex r4 = r4.getIndex()
                if (r4 == 0) goto L_0x0079
                long r8 = r4.getSegmentCount(r6)
                int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r2 != 0) goto L_0x006f
                goto L_0x0079
            L_0x006f:
                long r2 = r4.getSegmentNum(r11, r6)
                long r2 = r4.getTimeUs(r2)
                long r0 = r0 + r2
                long r0 = r0 - r11
            L_0x0079:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.DashTimeline.getAdjustedWindowDefaultStartPositionUs(long):long");
        }

        private static boolean isMovingLiveWindow(DashManifest dashManifest) {
            return dashManifest.dynamic && dashManifest.minUpdatePeriodMs != -9223372036854775807L && dashManifest.durationMs == -9223372036854775807L;
        }

        public int getIndexOfPeriod(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.firstPeriodId) >= 0 && intValue < getPeriodCount()) {
                return intValue;
            }
            return -1;
        }

        public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
            Assertions.checkIndex(i11, 0, getPeriodCount());
            Integer num = null;
            String str = z11 ? this.manifest.getPeriod(i11).f66008id : null;
            if (z11) {
                num = Integer.valueOf(this.firstPeriodId + i11);
            }
            return period.set(str, num, 0, this.manifest.getPeriodDurationUs(i11), C.msToUs(this.manifest.getPeriod(i11).startMs - this.manifest.getPeriod(0).startMs) - this.offsetInFirstPeriodUs);
        }

        public int getPeriodCount() {
            return this.manifest.getPeriodCount();
        }

        public Object getUidOfPeriod(int i11) {
            Assertions.checkIndex(i11, 0, getPeriodCount());
            return Integer.valueOf(this.firstPeriodId + i11);
        }

        public Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
            Assertions.checkIndex(i11, 0, 1);
            long adjustedWindowDefaultStartPositionUs = getAdjustedWindowDefaultStartPositionUs(j11);
            Object obj = Timeline.Window.SINGLE_WINDOW_UID;
            MediaItem mediaItem2 = this.mediaItem;
            DashManifest dashManifest = this.manifest;
            return window.set(obj, mediaItem2, dashManifest, this.presentationStartTimeMs, this.windowStartTimeMs, this.elapsedRealtimeEpochOffsetMs, true, isMovingLiveWindow(dashManifest), this.liveConfiguration, adjustedWindowDefaultStartPositionUs, this.windowDurationUs, 0, getPeriodCount() - 1, this.offsetInFirstPeriodUs);
        }

        public int getWindowCount() {
            return 1;
        }
    }

    public final class DefaultPlayerEmsgCallback implements PlayerEmsgHandler.PlayerEmsgCallback {
        private DefaultPlayerEmsgCallback() {
        }

        public void onDashManifestPublishTimeExpired(long j11) {
            DashMediaSource.this.onDashManifestPublishTimeExpired(j11);
        }

        public void onDashManifestRefreshRequested() {
            DashMediaSource.this.onDashManifestRefreshRequested();
        }
    }

    public static final class Factory implements MediaSourceFactory {
        private final DashChunkSource.Factory chunkSourceFactory;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private long fallbackTargetLiveOffsetMs;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final DataSource.Factory manifestDataSourceFactory;
        private ParsingLoadable.Parser<? extends DashManifest> manifestParser;
        private List<StreamKey> streamKeys;
        private Object tag;
        private long targetLiveOffsetOverrideMs;
        private boolean usingCustomDrmSessionManagerProvider;

        public Factory(DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ DrmSessionManager lambda$setDrmSessionManager$0(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
            return drmSessionManager;
        }

        public int[] getSupportedTypes() {
            return new int[]{0};
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2) {
            if (compositeSequenceableLoaderFactory2 == null) {
                compositeSequenceableLoaderFactory2 = new DefaultCompositeSequenceableLoaderFactory();
            }
            this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
            return this;
        }

        public Factory setFallbackTargetLiveOffsetMs(long j11) {
            this.fallbackTargetLiveOffsetMs = j11;
            return this;
        }

        @Deprecated
        public Factory setLivePresentationDelayMs(long j11, boolean z11) {
            this.targetLiveOffsetOverrideMs = z11 ? j11 : -9223372036854775807L;
            if (!z11) {
                setFallbackTargetLiveOffsetMs(j11);
            }
            return this;
        }

        public Factory setManifestParser(ParsingLoadable.Parser<? extends DashManifest> parser) {
            this.manifestParser = parser;
            return this;
        }

        @Deprecated
        public Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Factory(DashChunkSource.Factory factory, DataSource.Factory factory2) {
            this.chunkSourceFactory = (DashChunkSource.Factory) Assertions.checkNotNull(factory);
            this.manifestDataSourceFactory = factory2;
            this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.targetLiveOffsetOverrideMs = -9223372036854775807L;
            this.fallbackTargetLiveOffsetMs = 30000;
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
            this.streamKeys = Collections.emptyList();
        }

        public Factory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
            if (!this.usingCustomDrmSessionManagerProvider) {
                ((DefaultDrmSessionManagerProvider) this.drmSessionManagerProvider).setDrmHttpDataSourceFactory(factory);
            }
            return this;
        }

        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
            if (drmSessionManager == null) {
                setDrmSessionManagerProvider((DrmSessionManagerProvider) null);
            } else {
                setDrmSessionManagerProvider((DrmSessionManagerProvider) new c(drmSessionManager));
            }
            return this;
        }

        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider2) {
            if (drmSessionManagerProvider2 != null) {
                this.drmSessionManagerProvider = drmSessionManagerProvider2;
                this.usingCustomDrmSessionManagerProvider = true;
            } else {
                this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
                this.usingCustomDrmSessionManagerProvider = false;
            }
            return this;
        }

        public Factory setDrmUserAgent(String str) {
            if (!this.usingCustomDrmSessionManagerProvider) {
                ((DefaultDrmSessionManagerProvider) this.drmSessionManagerProvider).setDrmUserAgent(str);
            }
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy2) {
            if (loadErrorHandlingPolicy2 == null) {
                loadErrorHandlingPolicy2 = new DefaultLoadErrorHandlingPolicy();
            }
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
            return this;
        }

        @Deprecated
        public Factory setStreamKeys(List<StreamKey> list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.streamKeys = list;
            return this;
        }

        public DashMediaSource createMediaSource(DashManifest dashManifest) {
            return createMediaSource(dashManifest, new MediaItem.Builder().setUri(Uri.EMPTY).setMediaId("DashMediaSource").setMimeType(MimeTypes.APPLICATION_MPD).setStreamKeys(this.streamKeys).setTag(this.tag).build());
        }

        public DashMediaSource createMediaSource(DashManifest dashManifest, MediaItem mediaItem) {
            List<StreamKey> list;
            long j11;
            DashManifest dashManifest2 = dashManifest;
            MediaItem mediaItem2 = mediaItem;
            boolean z11 = true;
            Assertions.checkArgument(!dashManifest2.dynamic);
            MediaItem.PlaybackProperties playbackProperties = mediaItem2.playbackProperties;
            if (playbackProperties == null || playbackProperties.streamKeys.isEmpty()) {
                list = this.streamKeys;
            } else {
                list = mediaItem2.playbackProperties.streamKeys;
            }
            if (!list.isEmpty()) {
                dashManifest2 = dashManifest2.copy(list);
            }
            DashManifest dashManifest3 = dashManifest2;
            MediaItem.PlaybackProperties playbackProperties2 = mediaItem2.playbackProperties;
            boolean z12 = playbackProperties2 != null;
            boolean z13 = z12 && playbackProperties2.tag != null;
            if (mediaItem2.liveConfiguration.targetOffsetMs == -9223372036854775807L) {
                z11 = false;
            }
            MediaItem.Builder tag2 = mediaItem.buildUpon().setMimeType(MimeTypes.APPLICATION_MPD).setUri(z12 ? mediaItem2.playbackProperties.uri : Uri.EMPTY).setTag(z13 ? mediaItem2.playbackProperties.tag : this.tag);
            if (z11) {
                j11 = mediaItem2.liveConfiguration.targetOffsetMs;
            } else {
                j11 = this.targetLiveOffsetOverrideMs;
            }
            MediaItem build = tag2.setLiveTargetOffsetMs(j11).setStreamKeys(list).build();
            return new DashMediaSource(build, dashManifest3, (DataSource.Factory) null, (ParsingLoadable.Parser) null, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManagerProvider.get(build), this.loadErrorHandlingPolicy, this.fallbackTargetLiveOffsetMs);
        }

        @Deprecated
        public DashMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setUri(uri).setMimeType(MimeTypes.APPLICATION_MPD).setTag(this.tag).build());
        }

        public DashMediaSource createMediaSource(MediaItem mediaItem) {
            List<StreamKey> list;
            MediaItem mediaItem2 = mediaItem;
            Assertions.checkNotNull(mediaItem2.playbackProperties);
            ParsingLoadable.Parser parser = this.manifestParser;
            if (parser == null) {
                parser = new DashManifestParser();
            }
            if (mediaItem2.playbackProperties.streamKeys.isEmpty()) {
                list = this.streamKeys;
            } else {
                list = mediaItem2.playbackProperties.streamKeys;
            }
            FilteringManifestParser filteringManifestParser = !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser;
            MediaItem.PlaybackProperties playbackProperties = mediaItem2.playbackProperties;
            boolean z11 = true;
            boolean z12 = playbackProperties.tag == null && this.tag != null;
            boolean z13 = playbackProperties.streamKeys.isEmpty() && !list.isEmpty();
            if (mediaItem2.liveConfiguration.targetOffsetMs != -9223372036854775807L || this.targetLiveOffsetOverrideMs == -9223372036854775807L) {
                z11 = false;
            }
            if (z12 || z13 || z11) {
                MediaItem.Builder buildUpon = mediaItem.buildUpon();
                if (z12) {
                    buildUpon.setTag(this.tag);
                }
                if (z13) {
                    buildUpon.setStreamKeys(list);
                }
                if (z11) {
                    buildUpon.setLiveTargetOffsetMs(this.targetLiveOffsetOverrideMs);
                }
                mediaItem2 = buildUpon.build();
            }
            MediaItem mediaItem3 = mediaItem2;
            return new DashMediaSource(mediaItem3, (DashManifest) null, this.manifestDataSourceFactory, filteringManifestParser, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManagerProvider.get(mediaItem3), this.loadErrorHandlingPolicy, this.fallbackTargetLiveOffsetMs);
        }
    }

    public static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {
        private static final Pattern TIMESTAMP_WITH_TIMEZONE_PATTERN = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8)).readLine();
            try {
                Matcher matcher = TIMESTAMP_WITH_TIMEZONE_PATTERN.matcher(readLine);
                if (!matcher.matches()) {
                    String valueOf = String.valueOf(readLine);
                    throw new ParserException(valueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(valueOf) : new String("Couldn't parse timestamp: "));
                }
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j11 = "+".equals(matcher.group(4)) ? 1 : -1;
                    long parseLong = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    time -= j11 * ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0 : Long.parseLong(group2))) * 60) * 1000);
                }
                return Long.valueOf(time);
            } catch (ParseException e11) {
                throw new ParserException((Throwable) e11);
            }
        }
    }

    public final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        private ManifestCallback() {
        }

        public void onLoadCanceled(ParsingLoadable<DashManifest> parsingLoadable, long j11, long j12, boolean z11) {
            DashMediaSource.this.onLoadCanceled(parsingLoadable, j11, j12);
        }

        public void onLoadCompleted(ParsingLoadable<DashManifest> parsingLoadable, long j11, long j12) {
            DashMediaSource.this.onManifestLoadCompleted(parsingLoadable, j11, j12);
        }

        public Loader.LoadErrorAction onLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.onManifestLoadError(parsingLoadable, j11, j12, iOException, i11);
        }
    }

    public final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        private UtcTimestampCallback() {
        }

        public void onLoadCanceled(ParsingLoadable<Long> parsingLoadable, long j11, long j12, boolean z11) {
            DashMediaSource.this.onLoadCanceled(parsingLoadable, j11, j12);
        }

        public void onLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j11, long j12) {
            DashMediaSource.this.onUtcTimestampLoadCompleted(parsingLoadable, j11, j12);
        }

        public Loader.LoadErrorAction onLoadError(ParsingLoadable<Long> parsingLoadable, long j11, long j12, IOException iOException, int i11) {
            return DashMediaSource.this.onUtcTimestampLoadError(parsingLoadable, j11, j12, iOException);
        }
    }

    public static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        private XsDateTimeParser() {
        }

        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.parseXsDateTime(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    private static long getAvailableEndTimeInManifestUs(Period period, long j11, long j12) {
        Period period2 = period;
        long j13 = j11;
        long j14 = j12;
        long msToUs = C.msToUs(period2.startMs);
        boolean hasVideoOrAudioAdaptationSets = hasVideoOrAudioAdaptationSets(period);
        long j15 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < period2.adaptationSets.size(); i11++) {
            AdaptationSet adaptationSet = period2.adaptationSets.get(i11);
            List<Representation> list = adaptationSet.representations;
            if ((!hasVideoOrAudioAdaptationSets || adaptationSet.type != 3) && !list.isEmpty()) {
                DashSegmentIndex index = list.get(0).getIndex();
                if (index == null) {
                    return msToUs + j13;
                }
                long availableSegmentCount = index.getAvailableSegmentCount(j13, j14);
                if (availableSegmentCount == 0) {
                    return msToUs;
                }
                long firstAvailableSegmentNum = (index.getFirstAvailableSegmentNum(j13, j14) + availableSegmentCount) - 1;
                j15 = Math.min(j15, index.getDurationUs(firstAvailableSegmentNum, j13) + index.getTimeUs(firstAvailableSegmentNum) + msToUs);
            }
        }
        return j15;
    }

    private static long getAvailableStartTimeInManifestUs(Period period, long j11, long j12) {
        Period period2 = period;
        long j13 = j11;
        long j14 = j12;
        long msToUs = C.msToUs(period2.startMs);
        boolean hasVideoOrAudioAdaptationSets = hasVideoOrAudioAdaptationSets(period);
        long j15 = msToUs;
        for (int i11 = 0; i11 < period2.adaptationSets.size(); i11++) {
            AdaptationSet adaptationSet = period2.adaptationSets.get(i11);
            List<Representation> list = adaptationSet.representations;
            if ((!hasVideoOrAudioAdaptationSets || adaptationSet.type != 3) && !list.isEmpty()) {
                DashSegmentIndex index = list.get(0).getIndex();
                if (index == null || index.getAvailableSegmentCount(j13, j14) == 0) {
                    return msToUs;
                }
                j15 = Math.max(j15, index.getTimeUs(index.getFirstAvailableSegmentNum(j13, j14)) + msToUs);
            }
        }
        return j15;
    }

    private static long getIntervalUntilNextManifestRefreshMs(DashManifest dashManifest, long j11) {
        DashSegmentIndex index;
        DashManifest dashManifest2 = dashManifest;
        int periodCount = dashManifest.getPeriodCount() - 1;
        Period period = dashManifest2.getPeriod(periodCount);
        long msToUs = C.msToUs(period.startMs);
        long periodDurationUs = dashManifest2.getPeriodDurationUs(periodCount);
        long msToUs2 = C.msToUs(j11);
        long msToUs3 = C.msToUs(dashManifest2.availabilityStartTimeMs);
        long msToUs4 = C.msToUs(5000);
        for (int i11 = 0; i11 < period.adaptationSets.size(); i11++) {
            List<Representation> list = period.adaptationSets.get(i11).representations;
            if (!list.isEmpty() && (index = list.get(0).getIndex()) != null) {
                long nextSegmentAvailableTimeUs = ((msToUs3 + msToUs) + index.getNextSegmentAvailableTimeUs(periodDurationUs, msToUs2)) - msToUs2;
                if (nextSegmentAvailableTimeUs < msToUs4 - IndexSeeker.MIN_TIME_BETWEEN_POINTS_US || (nextSegmentAvailableTimeUs > msToUs4 && nextSegmentAvailableTimeUs < msToUs4 + IndexSeeker.MIN_TIME_BETWEEN_POINTS_US)) {
                    msToUs4 = nextSegmentAvailableTimeUs;
                }
            }
        }
        return LongMath.divide(msToUs4, 1000, RoundingMode.CEILING);
    }

    private long getManifestLoadRetryDelayMillis() {
        return (long) Math.min((this.staleManifestReloadAttempt - 1) * 1000, 5000);
    }

    private static boolean hasVideoOrAudioAdaptationSets(Period period) {
        for (int i11 = 0; i11 < period.adaptationSets.size(); i11++) {
            int i12 = period.adaptationSets.get(i11).type;
            if (i12 == 1 || i12 == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIndexExplicit(Period period) {
        for (int i11 = 0; i11 < period.adaptationSets.size(); i11++) {
            DashSegmentIndex index = period.adaptationSets.get(i11).representations.get(0).getIndex();
            if (index == null || index.isExplicit()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        processManifest(false);
    }

    private void loadNtpTimeOffset() {
        SntpClient.initialize(this.loader, new SntpClient.InitializationCallback() {
            public void onInitializationFailed(IOException iOException) {
                DashMediaSource.this.onUtcTimestampResolutionError(iOException);
            }

            public void onInitialized() {
                DashMediaSource.this.onUtcTimestampResolved(SntpClient.getElapsedRealtimeOffsetMs());
            }
        });
    }

    /* access modifiers changed from: private */
    public void onUtcTimestampResolutionError(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        processManifest(true);
    }

    /* access modifiers changed from: private */
    public void onUtcTimestampResolved(long j11) {
        this.elapsedRealtimeOffsetMs = j11;
        processManifest(true);
    }

    private void processManifest(boolean z11) {
        long j11;
        long j12;
        Period period;
        for (int i11 = 0; i11 < this.periodsById.size(); i11++) {
            int keyAt = this.periodsById.keyAt(i11);
            if (keyAt >= this.firstPeriodId) {
                this.periodsById.valueAt(i11).updateManifest(this.manifest, keyAt - this.firstPeriodId);
            }
        }
        Period period2 = this.manifest.getPeriod(0);
        int periodCount = this.manifest.getPeriodCount() - 1;
        Period period3 = this.manifest.getPeriod(periodCount);
        long periodDurationUs = this.manifest.getPeriodDurationUs(periodCount);
        long msToUs = C.msToUs(Util.getNowUnixTimeMs(this.elapsedRealtimeOffsetMs));
        long availableStartTimeInManifestUs = getAvailableStartTimeInManifestUs(period2, this.manifest.getPeriodDurationUs(0), msToUs);
        long availableEndTimeInManifestUs = getAvailableEndTimeInManifestUs(period3, periodDurationUs, msToUs);
        boolean z12 = this.manifest.dynamic && !isIndexExplicit(period3);
        if (z12) {
            long j13 = this.manifest.timeShiftBufferDepthMs;
            if (j13 != -9223372036854775807L) {
                availableStartTimeInManifestUs = Math.max(availableStartTimeInManifestUs, availableEndTimeInManifestUs - C.msToUs(j13));
            }
        }
        long j14 = availableEndTimeInManifestUs - availableStartTimeInManifestUs;
        DashManifest dashManifest = this.manifest;
        Period period4 = period2;
        if (dashManifest.dynamic) {
            Assertions.checkState(dashManifest.availabilityStartTimeMs != -9223372036854775807L);
            long msToUs2 = (msToUs - C.msToUs(this.manifest.availabilityStartTimeMs)) - availableStartTimeInManifestUs;
            updateMediaItemLiveConfiguration(msToUs2, j14);
            long usToMs = this.manifest.availabilityStartTimeMs + C.usToMs(availableStartTimeInManifestUs);
            long msToUs3 = msToUs2 - C.msToUs(this.liveConfiguration.targetOffsetMs);
            long min = Math.min(MIN_LIVE_DEFAULT_START_POSITION_US, j14 / 2);
            j12 = usToMs;
            j11 = msToUs3 < min ? min : msToUs3;
            period = period4;
        } else {
            period = period4;
            j12 = -9223372036854775807L;
            j11 = 0;
        }
        long msToUs4 = availableStartTimeInManifestUs - C.msToUs(period.startMs);
        DashManifest dashManifest2 = this.manifest;
        refreshSourceInfo(new DashTimeline(dashManifest2.availabilityStartTimeMs, j12, this.elapsedRealtimeOffsetMs, this.firstPeriodId, msToUs4, j14, j11, dashManifest2, this.mediaItem, dashManifest2.dynamic ? this.liveConfiguration : null));
        if (!this.sideloadedManifest) {
            this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
            if (z12) {
                this.handler.postDelayed(this.simulateManifestRefreshRunnable, getIntervalUntilNextManifestRefreshMs(this.manifest, Util.getNowUnixTimeMs(this.elapsedRealtimeOffsetMs)));
            }
            if (this.manifestLoadPending) {
                startLoadingManifest();
            } else if (z11) {
                DashManifest dashManifest3 = this.manifest;
                if (dashManifest3.dynamic) {
                    long j15 = dashManifest3.minUpdatePeriodMs;
                    if (j15 != -9223372036854775807L) {
                        if (j15 == 0) {
                            j15 = 5000;
                        }
                        scheduleManifestRefresh(Math.max(0, (this.manifestLoadStartTimestampMs + j15) - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }

    private void resolveUtcTimingElement(UtcTimingElement utcTimingElement) {
        String str = utcTimingElement.schemeIdUri;
        if (Util.areEqual(str, "urn:mpeg:dash:utc:direct:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:direct:2012")) {
            resolveUtcTimingElementDirect(utcTimingElement);
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            resolveUtcTimingElementHttp(utcTimingElement, new Iso8601Parser());
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            resolveUtcTimingElementHttp(utcTimingElement, new XsDateTimeParser());
        } else if (Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2014") || Util.areEqual(str, "urn:mpeg:dash:utc:ntp:2012")) {
            loadNtpTimeOffset();
        } else {
            onUtcTimestampResolutionError(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void resolveUtcTimingElementDirect(UtcTimingElement utcTimingElement) {
        try {
            onUtcTimestampResolved(Util.parseXsDateTime(utcTimingElement.value) - this.manifestLoadEndTimestampMs);
        } catch (ParserException e11) {
            onUtcTimestampResolutionError(e11);
        }
    }

    private void resolveUtcTimingElementHttp(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        startLoading(new ParsingLoadable(this.dataSource, Uri.parse(utcTimingElement.value), 5, parser), new UtcTimestampCallback(), 1);
    }

    private void scheduleManifestRefresh(long j11) {
        this.handler.postDelayed(this.refreshManifestRunnable, j11);
    }

    private <T> void startLoading(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i11) {
        this.manifestEventDispatcher.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.loader.startLoading(parsingLoadable, callback, i11)), parsingLoadable.type);
    }

    /* access modifiers changed from: private */
    public void startLoadingManifest() {
        Uri uri;
        this.handler.removeCallbacks(this.refreshManifestRunnable);
        if (!this.loader.hasFatalError()) {
            if (this.loader.isLoading()) {
                this.manifestLoadPending = true;
                return;
            }
            synchronized (this.manifestUriLock) {
                uri = this.manifestUri;
            }
            this.manifestLoadPending = false;
            startLoading(new ParsingLoadable(this.dataSource, uri, 4, this.manifestParser), this.manifestCallback, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(4));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r5 != -9223372036854775807L) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r1 != -9223372036854775807L) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateMediaItemLiveConfiguration(long r15, long r17) {
        /*
            r14 = this;
            r0 = r14
            com.google.android.exoplayer2.MediaItem r1 = r0.mediaItem
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r1 = r1.liveConfiguration
            long r1 = r1.maxOffsetMs
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0011
            goto L_0x0022
        L_0x0011:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r1 = r0.manifest
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r1 = r1.serviceDescription
            if (r1 == 0) goto L_0x001e
            long r1 = r1.maxOffsetMs
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            long r1 = com.google.android.exoplayer2.C.usToMs(r15)
        L_0x0022:
            com.google.android.exoplayer2.MediaItem r5 = r0.mediaItem
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r5 = r5.liveConfiguration
            long r5 = r5.minOffsetMs
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x002e
        L_0x002c:
            r11 = r5
            goto L_0x005a
        L_0x002e:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r5 = r0.manifest
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r5 = r5.serviceDescription
            if (r5 == 0) goto L_0x003b
            long r5 = r5.minOffsetMs
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x003b
            goto L_0x002c
        L_0x003b:
            long r5 = r15 - r17
            long r5 = com.google.android.exoplayer2.C.usToMs(r5)
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x004c
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x004c
            r5 = r7
        L_0x004c:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r7 = r0.manifest
            long r7 = r7.minBufferTimeMs
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 == 0) goto L_0x002c
            long r5 = r5 + r7
            long r5 = java.lang.Math.min(r5, r1)
            goto L_0x002c
        L_0x005a:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r5 = r0.liveConfiguration
            long r5 = r5.targetOffsetMs
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0063
            goto L_0x007a
        L_0x0063:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r5 = r0.manifest
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r6 = r5.serviceDescription
            if (r6 == 0) goto L_0x0071
            long r6 = r6.targetOffsetMs
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x0071
            r5 = r6
            goto L_0x007a
        L_0x0071:
            long r5 = r5.suggestedPresentationDelayMs
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            long r5 = r0.fallbackTargetLiveOffsetMs
        L_0x007a:
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x007f
            r5 = r11
        L_0x007f:
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x009c
            r3 = 5000000(0x4c4b40, double:2.470328E-317)
            r5 = 2
            long r5 = r17 / r5
            long r3 = java.lang.Math.min(r3, r5)
            long r3 = r15 - r3
            long r5 = com.google.android.exoplayer2.C.usToMs(r3)
            r7 = r11
            r9 = r1
            long r3 = com.google.android.exoplayer2.util.Util.constrainValue((long) r5, (long) r7, (long) r9)
            r6 = r3
            goto L_0x009d
        L_0x009c:
            r6 = r5
        L_0x009d:
            com.google.android.exoplayer2.MediaItem r3 = r0.mediaItem
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r3 = r3.liveConfiguration
            float r4 = r3.minPlaybackSpeed
            r5 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r8 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x00ab
            goto L_0x00b5
        L_0x00ab:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r4 = r0.manifest
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r4 = r4.serviceDescription
            if (r4 == 0) goto L_0x00b4
            float r4 = r4.minPlaybackSpeed
            goto L_0x00b5
        L_0x00b4:
            r4 = r5
        L_0x00b5:
            float r3 = r3.maxPlaybackSpeed
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x00bd
        L_0x00bb:
            r13 = r3
            goto L_0x00c7
        L_0x00bd:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r3 = r0.manifest
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r3 = r3.serviceDescription
            if (r3 == 0) goto L_0x00c6
            float r3 = r3.maxPlaybackSpeed
            goto L_0x00bb
        L_0x00c6:
            r13 = r5
        L_0x00c7:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r3 = new com.google.android.exoplayer2.MediaItem$LiveConfiguration
            r5 = r3
            r8 = r11
            r10 = r1
            r12 = r4
            r5.<init>(r6, r8, r10, r12, r13)
            r0.liveConfiguration = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.updateMediaItemLiveConfiguration(long, long):void");
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        int intValue = ((Integer) mediaPeriodId2.periodUid).intValue() - this.firstPeriodId;
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId2, this.manifest.getPeriod(intValue).startMs);
        DrmSessionEventListener.EventDispatcher createDrmEventDispatcher = createDrmEventDispatcher(mediaPeriodId);
        int i11 = this.firstPeriodId + intValue;
        DashManifest dashManifest = this.manifest;
        DashChunkSource.Factory factory = this.chunkSourceFactory;
        TransferListener transferListener = this.mediaTransferListener;
        DrmSessionManager drmSessionManager2 = this.drmSessionManager;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.loadErrorHandlingPolicy;
        long j12 = this.elapsedRealtimeOffsetMs;
        LoaderErrorThrower loaderErrorThrower = this.manifestLoadErrorThrower;
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(i11, dashManifest, intValue, factory, transferListener, drmSessionManager2, createDrmEventDispatcher, loadErrorHandlingPolicy2, createEventDispatcher, j12, loaderErrorThrower, allocator, this.compositeSequenceableLoaderFactory, this.playerEmsgCallback);
        this.periodsById.put(dashMediaPeriod.f66002id, dashMediaPeriod);
        return dashMediaPeriod;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Deprecated
    public Object getTag() {
        return ((MediaItem.PlaybackProperties) Util.castNonNull(this.mediaItem.playbackProperties)).tag;
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.manifestLoadErrorThrower.maybeThrowError();
    }

    public void onDashManifestPublishTimeExpired(long j11) {
        long j12 = this.expiredManifestPublishTimeUs;
        if (j12 == -9223372036854775807L || j12 < j11) {
            this.expiredManifestPublishTimeUs = j11;
        }
    }

    public void onDashManifestRefreshRequested() {
        this.handler.removeCallbacks(this.simulateManifestRefreshRunnable);
        startLoadingManifest();
    }

    public void onLoadCanceled(ParsingLoadable<?> parsingLoadable, long j11, long j12) {
        ParsingLoadable<?> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.manifestEventDispatcher.loadCanceled(loadEventInfo, parsingLoadable2.type);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onManifestLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> r19, long r20, long r22) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r14 = r20
            com.google.android.exoplayer2.source.LoadEventInfo r12 = new com.google.android.exoplayer2.source.LoadEventInfo
            long r3 = r0.loadTaskId
            com.google.android.exoplayer2.upstream.DataSpec r5 = r0.dataSpec
            android.net.Uri r6 = r19.getUri()
            java.util.Map r7 = r19.getResponseHeaders()
            long r16 = r19.bytesLoaded()
            r2 = r12
            r8 = r20
            r10 = r22
            r14 = r12
            r12 = r16
            r2.<init>(r3, r5, r6, r7, r8, r10, r12)
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r2 = r1.loadErrorHandlingPolicy
            long r3 = r0.loadTaskId
            r2.onLoadTaskConcluded(r3)
            com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher r2 = r1.manifestEventDispatcher
            int r3 = r0.type
            r2.loadCompleted((com.google.android.exoplayer2.source.LoadEventInfo) r14, (int) r3)
            java.lang.Object r2 = r19.getResult()
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r2 = (com.google.android.exoplayer2.source.dash.manifest.DashManifest) r2
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r3 = r1.manifest
            r4 = 0
            if (r3 != 0) goto L_0x003e
            r3 = r4
            goto L_0x0042
        L_0x003e:
            int r3 = r3.getPeriodCount()
        L_0x0042:
            com.google.android.exoplayer2.source.dash.manifest.Period r5 = r2.getPeriod(r4)
            long r5 = r5.startMs
            r7 = r4
        L_0x0049:
            if (r7 >= r3) goto L_0x005a
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r8 = r1.manifest
            com.google.android.exoplayer2.source.dash.manifest.Period r8 = r8.getPeriod(r7)
            long r8 = r8.startMs
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x005a
            int r7 = r7 + 1
            goto L_0x0049
        L_0x005a:
            boolean r5 = r2.dynamic
            r6 = 1
            if (r5 == 0) goto L_0x00ca
            int r5 = r3 - r7
            int r8 = r2.getPeriodCount()
            if (r5 <= r8) goto L_0x0070
            java.lang.String r5 = "DashMediaSource"
            java.lang.String r8 = "Loaded out of sync manifest"
            com.google.android.exoplayer2.util.Log.w(r5, r8)
        L_0x006e:
            r5 = r6
            goto L_0x00a6
        L_0x0070:
            long r8 = r1.expiredManifestPublishTimeUs
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00a5
            long r10 = r2.publishTimeMs
            r12 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 * r10
            int r5 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x00a5
            java.lang.String r5 = "DashMediaSource"
            r12 = 73
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            java.lang.String r12 = "Loaded stale dynamic manifest: "
            r13.append(r12)
            r13.append(r10)
            java.lang.String r10 = ", "
            r13.append(r10)
            r13.append(r8)
            java.lang.String r8 = r13.toString()
            com.google.android.exoplayer2.util.Log.w(r5, r8)
            goto L_0x006e
        L_0x00a5:
            r5 = r4
        L_0x00a6:
            if (r5 == 0) goto L_0x00c8
            int r2 = r1.staleManifestReloadAttempt
            int r3 = r2 + 1
            r1.staleManifestReloadAttempt = r3
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r3 = r1.loadErrorHandlingPolicy
            int r0 = r0.type
            int r0 = r3.getMinimumLoadableRetryCount(r0)
            if (r2 >= r0) goto L_0x00c0
            long r2 = r18.getManifestLoadRetryDelayMillis()
            r1.scheduleManifestRefresh(r2)
            goto L_0x00c7
        L_0x00c0:
            com.google.android.exoplayer2.source.dash.DashManifestStaleException r0 = new com.google.android.exoplayer2.source.dash.DashManifestStaleException
            r0.<init>()
            r1.manifestFatalError = r0
        L_0x00c7:
            return
        L_0x00c8:
            r1.staleManifestReloadAttempt = r4
        L_0x00ca:
            r1.manifest = r2
            boolean r5 = r1.manifestLoadPending
            boolean r2 = r2.dynamic
            r2 = r2 & r5
            r1.manifestLoadPending = r2
            r8 = r20
            long r10 = r8 - r22
            r1.manifestLoadStartTimestampMs = r10
            r1.manifestLoadEndTimestampMs = r8
            java.lang.Object r2 = r1.manifestUriLock
            monitor-enter(r2)
            com.google.android.exoplayer2.upstream.DataSpec r5 = r0.dataSpec     // Catch:{ all -> 0x0118 }
            android.net.Uri r5 = r5.uri     // Catch:{ all -> 0x0118 }
            android.net.Uri r8 = r1.manifestUri     // Catch:{ all -> 0x0118 }
            if (r5 != r8) goto L_0x00e7
            r4 = r6
        L_0x00e7:
            if (r4 == 0) goto L_0x00f6
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r4 = r1.manifest     // Catch:{ all -> 0x0118 }
            android.net.Uri r4 = r4.location     // Catch:{ all -> 0x0118 }
            if (r4 == 0) goto L_0x00f0
            goto L_0x00f4
        L_0x00f0:
            android.net.Uri r4 = r19.getUri()     // Catch:{ all -> 0x0118 }
        L_0x00f4:
            r1.manifestUri = r4     // Catch:{ all -> 0x0118 }
        L_0x00f6:
            monitor-exit(r2)     // Catch:{ all -> 0x0118 }
            if (r3 != 0) goto L_0x010f
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r0 = r1.manifest
            boolean r2 = r0.dynamic
            if (r2 == 0) goto L_0x010b
            com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement r0 = r0.utcTiming
            if (r0 == 0) goto L_0x0107
            r1.resolveUtcTimingElement(r0)
            goto L_0x0117
        L_0x0107:
            r18.loadNtpTimeOffset()
            goto L_0x0117
        L_0x010b:
            r1.processManifest(r6)
            goto L_0x0117
        L_0x010f:
            int r0 = r1.firstPeriodId
            int r0 = r0 + r7
            r1.firstPeriodId = r0
            r1.processManifest(r6)
        L_0x0117:
            return
        L_0x0118:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0118 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.onManifestLoadCompleted(com.google.android.exoplayer2.upstream.ParsingLoadable, long, long):void");
    }

    public Loader.LoadErrorAction onManifestLoadError(ParsingLoadable<DashManifest> parsingLoadable, long j11, long j12, IOException iOException, int i11) {
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable<DashManifest> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.type), iOException2, i11));
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        } else {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        }
        boolean z11 = !loadErrorAction.isRetry();
        this.manifestEventDispatcher.loadError(loadEventInfo, parsingLoadable2.type, iOException2, z11);
        if (z11) {
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        }
        return loadErrorAction;
    }

    public void onUtcTimestampLoadCompleted(ParsingLoadable<Long> parsingLoadable, long j11, long j12) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.manifestEventDispatcher.loadCompleted(loadEventInfo, parsingLoadable2.type);
        onUtcTimestampResolved(parsingLoadable.getResult().longValue() - j11);
    }

    public Loader.LoadErrorAction onUtcTimestampLoadError(ParsingLoadable<Long> parsingLoadable, long j11, long j12, IOException iOException) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.manifestEventDispatcher;
        LoadEventInfo loadEventInfo = r4;
        LoadEventInfo loadEventInfo2 = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        eventDispatcher.loadError(loadEventInfo, parsingLoadable2.type, iOException2, true);
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        onUtcTimestampResolutionError(iOException2);
        return Loader.DONT_RETRY;
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.drmSessionManager.prepare();
        if (this.sideloadedManifest) {
            processManifest(false);
            return;
        }
        this.dataSource = this.manifestDataSourceFactory.createDataSource();
        this.loader = new Loader("DashMediaSource");
        this.handler = Util.createHandlerForCurrentLooper();
        startLoadingManifest();
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.release();
        this.periodsById.remove(dashMediaPeriod.f66002id);
    }

    public void releaseSourceInternal() {
        this.manifestLoadPending = false;
        this.dataSource = null;
        Loader loader2 = this.loader;
        if (loader2 != null) {
            loader2.release();
            this.loader = null;
        }
        this.manifestLoadStartTimestampMs = 0;
        this.manifestLoadEndTimestampMs = 0;
        this.manifest = this.sideloadedManifest ? this.manifest : null;
        this.manifestUri = this.initialManifestUri;
        this.manifestFatalError = null;
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
        this.elapsedRealtimeOffsetMs = -9223372036854775807L;
        this.staleManifestReloadAttempt = 0;
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.firstPeriodId = 0;
        this.periodsById.clear();
        this.drmSessionManager.release();
    }

    public void replaceManifestUri(Uri uri) {
        synchronized (this.manifestUriLock) {
            this.manifestUri = uri;
            this.initialManifestUri = uri;
        }
    }

    public final class ManifestLoadErrorThrower implements LoaderErrorThrower {
        public ManifestLoadErrorThrower() {
        }

        private void maybeThrowManifestError() throws IOException {
            if (DashMediaSource.this.manifestFatalError != null) {
                throw DashMediaSource.this.manifestFatalError;
            }
        }

        public void maybeThrowError() throws IOException {
            DashMediaSource.this.loader.maybeThrowError();
            maybeThrowManifestError();
        }

        public void maybeThrowError(int i11) throws IOException {
            DashMediaSource.this.loader.maybeThrowError(i11);
            maybeThrowManifestError();
        }
    }

    private DashMediaSource(MediaItem mediaItem2, DashManifest dashManifest, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, long j11) {
        this.mediaItem = mediaItem2;
        this.liveConfiguration = mediaItem2.liveConfiguration;
        this.manifestUri = ((MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem2.playbackProperties)).uri;
        this.initialManifestUri = mediaItem2.playbackProperties.uri;
        this.manifest = dashManifest;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.fallbackTargetLiveOffsetMs = j11;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        boolean z11 = dashManifest != null;
        this.sideloadedManifest = z11;
        this.manifestEventDispatcher = createEventDispatcher((MediaSource.MediaPeriodId) null);
        this.manifestUriLock = new Object();
        this.periodsById = new SparseArray<>();
        this.playerEmsgCallback = new DefaultPlayerEmsgCallback();
        this.expiredManifestPublishTimeUs = -9223372036854775807L;
        this.elapsedRealtimeOffsetMs = -9223372036854775807L;
        if (z11) {
            Assertions.checkState(true ^ dashManifest.dynamic);
            this.manifestCallback = null;
            this.refreshManifestRunnable = null;
            this.simulateManifestRefreshRunnable = null;
            this.manifestLoadErrorThrower = new LoaderErrorThrower.Dummy();
            return;
        }
        this.manifestCallback = new ManifestCallback();
        this.manifestLoadErrorThrower = new ManifestLoadErrorThrower();
        this.refreshManifestRunnable = new a(this);
        this.simulateManifestRefreshRunnable = new b(this);
    }
}
