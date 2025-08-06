package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
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
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
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
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SsMediaSource extends BaseMediaSource implements Loader.Callback<ParsingLoadable<SsManifest>> {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000;
    private static final int MINIMUM_MANIFEST_REFRESH_PERIOD_MS = 5000;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000;
    private final SsChunkSource.Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionManager drmSessionManager;
    private final long livePresentationDelayMs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private SsManifest manifest;
    private DataSource manifestDataSource;
    private final DataSource.Factory manifestDataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher manifestEventDispatcher;
    private long manifestLoadStartTimestamp;
    private Loader manifestLoader;
    private LoaderErrorThrower manifestLoaderErrorThrower;
    private final ParsingLoadable.Parser<? extends SsManifest> manifestParser;
    private Handler manifestRefreshHandler;
    private final Uri manifestUri;
    private final MediaItem mediaItem;
    private final ArrayList<SsMediaPeriod> mediaPeriods;
    private TransferListener mediaTransferListener;
    private final MediaItem.PlaybackProperties playbackProperties;
    private final boolean sideloadedManifest;

    public static final class Factory implements MediaSourceFactory {
        private final SsChunkSource.Factory chunkSourceFactory;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManagerProvider drmSessionManagerProvider;
        private long livePresentationDelayMs;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private final DataSource.Factory manifestDataSourceFactory;
        private ParsingLoadable.Parser<? extends SsManifest> manifestParser;
        private List<StreamKey> streamKeys;
        private Object tag;
        private boolean usingCustomDrmSessionManagerProvider;

        public Factory(DataSource.Factory factory) {
            this(new DefaultSsChunkSource.Factory(factory), factory);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ DrmSessionManager lambda$setDrmSessionManager$0(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
            return drmSessionManager;
        }

        public int[] getSupportedTypes() {
            return new int[]{1};
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2) {
            if (compositeSequenceableLoaderFactory2 == null) {
                compositeSequenceableLoaderFactory2 = new DefaultCompositeSequenceableLoaderFactory();
            }
            this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
            return this;
        }

        public Factory setLivePresentationDelayMs(long j11) {
            this.livePresentationDelayMs = j11;
            return this;
        }

        public Factory setManifestParser(ParsingLoadable.Parser<? extends SsManifest> parser) {
            this.manifestParser = parser;
            return this;
        }

        @Deprecated
        public Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Factory(SsChunkSource.Factory factory, DataSource.Factory factory2) {
            this.chunkSourceFactory = (SsChunkSource.Factory) Assertions.checkNotNull(factory);
            this.manifestDataSourceFactory = factory2;
            this.drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.livePresentationDelayMs = 30000;
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
                setDrmSessionManagerProvider((DrmSessionManagerProvider) new b(drmSessionManager));
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

        @Deprecated
        public SsMediaSource createMediaSource(Uri uri) {
            return createMediaSource(new MediaItem.Builder().setUri(uri).build());
        }

        public SsMediaSource createMediaSource(SsManifest ssManifest) {
            return createMediaSource(ssManifest, MediaItem.fromUri(Uri.EMPTY));
        }

        public SsMediaSource createMediaSource(SsManifest ssManifest, MediaItem mediaItem) {
            List<StreamKey> list;
            SsManifest ssManifest2 = ssManifest;
            MediaItem mediaItem2 = mediaItem;
            boolean z11 = true;
            Assertions.checkArgument(!ssManifest2.isLive);
            MediaItem.PlaybackProperties playbackProperties = mediaItem2.playbackProperties;
            if (playbackProperties == null || playbackProperties.streamKeys.isEmpty()) {
                list = this.streamKeys;
            } else {
                list = mediaItem2.playbackProperties.streamKeys;
            }
            if (!list.isEmpty()) {
                ssManifest2 = ssManifest2.copy(list);
            }
            SsManifest ssManifest3 = ssManifest2;
            MediaItem.PlaybackProperties playbackProperties2 = mediaItem2.playbackProperties;
            boolean z12 = playbackProperties2 != null;
            if (!z12 || playbackProperties2.tag == null) {
                z11 = false;
            }
            MediaItem build = mediaItem.buildUpon().setMimeType(MimeTypes.APPLICATION_SS).setUri(z12 ? mediaItem2.playbackProperties.uri : Uri.EMPTY).setTag(z11 ? mediaItem2.playbackProperties.tag : this.tag).setStreamKeys(list).build();
            return new SsMediaSource(build, ssManifest3, (DataSource.Factory) null, (ParsingLoadable.Parser) null, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManagerProvider.get(build), this.loadErrorHandlingPolicy, this.livePresentationDelayMs);
        }

        public SsMediaSource createMediaSource(MediaItem mediaItem) {
            List<StreamKey> list;
            MediaItem mediaItem2 = mediaItem;
            Assertions.checkNotNull(mediaItem2.playbackProperties);
            ParsingLoadable.Parser parser = this.manifestParser;
            if (parser == null) {
                parser = new SsManifestParser();
            }
            if (!mediaItem2.playbackProperties.streamKeys.isEmpty()) {
                list = mediaItem2.playbackProperties.streamKeys;
            } else {
                list = this.streamKeys;
            }
            FilteringManifestParser filteringManifestParser = !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser;
            MediaItem.PlaybackProperties playbackProperties = mediaItem2.playbackProperties;
            boolean z11 = true;
            boolean z12 = playbackProperties.tag == null && this.tag != null;
            if (!playbackProperties.streamKeys.isEmpty() || list.isEmpty()) {
                z11 = false;
            }
            if (z12 && z11) {
                mediaItem2 = mediaItem.buildUpon().setTag(this.tag).setStreamKeys(list).build();
            } else if (z12) {
                mediaItem2 = mediaItem.buildUpon().setTag(this.tag).build();
            } else if (z11) {
                mediaItem2 = mediaItem.buildUpon().setStreamKeys(list).build();
            }
            MediaItem mediaItem3 = mediaItem2;
            return new SsMediaSource(mediaItem3, (SsManifest) null, this.manifestDataSourceFactory, filteringManifestParser, this.chunkSourceFactory, this.compositeSequenceableLoaderFactory, this.drmSessionManagerProvider.get(mediaItem3), this.loadErrorHandlingPolicy, this.livePresentationDelayMs);
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    private void processManifest() {
        SinglePeriodTimeline singlePeriodTimeline;
        for (int i11 = 0; i11 < this.mediaPeriods.size(); i11++) {
            this.mediaPeriods.get(i11).updateManifest(this.manifest);
        }
        long j11 = Long.MIN_VALUE;
        long j12 = Long.MAX_VALUE;
        for (SsManifest.StreamElement streamElement : this.manifest.streamElements) {
            if (streamElement.chunkCount > 0) {
                j12 = Math.min(j12, streamElement.getStartTimeUs(0));
                j11 = Math.max(j11, streamElement.getStartTimeUs(streamElement.chunkCount - 1) + streamElement.getChunkDurationUs(streamElement.chunkCount - 1));
            }
        }
        if (j12 == Long.MAX_VALUE) {
            long j13 = this.manifest.isLive ? -9223372036854775807L : 0;
            SsManifest ssManifest = this.manifest;
            boolean z11 = ssManifest.isLive;
            singlePeriodTimeline = new SinglePeriodTimeline(j13, 0, 0, 0, true, z11, z11, (Object) ssManifest, this.mediaItem);
        } else {
            SsManifest ssManifest2 = this.manifest;
            if (ssManifest2.isLive) {
                long j14 = ssManifest2.dvrWindowLengthUs;
                if (j14 != -9223372036854775807L && j14 > 0) {
                    j12 = Math.max(j12, j11 - j14);
                }
                long j15 = j12;
                long j16 = j11 - j15;
                long msToUs = j16 - C.msToUs(this.livePresentationDelayMs);
                if (msToUs < MIN_LIVE_DEFAULT_START_POSITION_US) {
                    msToUs = Math.min(MIN_LIVE_DEFAULT_START_POSITION_US, j16 / 2);
                }
                singlePeriodTimeline = new SinglePeriodTimeline(-9223372036854775807L, j16, j15, msToUs, true, true, true, (Object) this.manifest, this.mediaItem);
            } else {
                long j17 = ssManifest2.durationUs;
                long j18 = j17 != -9223372036854775807L ? j17 : j11 - j12;
                singlePeriodTimeline = new SinglePeriodTimeline(j12 + j18, j18, j12, 0, true, false, false, (Object) this.manifest, this.mediaItem);
            }
        }
        refreshSourceInfo(singlePeriodTimeline);
    }

    private void scheduleManifestRefresh() {
        if (this.manifest.isLive) {
            this.manifestRefreshHandler.postDelayed(new a(this), Math.max(0, (this.manifestLoadStartTimestamp + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* access modifiers changed from: private */
    public void startLoadingManifest() {
        if (!this.manifestLoader.hasFatalError()) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.manifestDataSource, this.manifestUri, 4, this.manifestParser);
            this.manifestEventDispatcher.loadStarted(new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, this.manifestLoader.startLoading(parsingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable.type))), parsingLoadable.type);
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        MediaSourceEventListener.EventDispatcher createEventDispatcher = createEventDispatcher(mediaPeriodId);
        SsMediaPeriod ssMediaPeriod = new SsMediaPeriod(this.manifest, this.chunkSourceFactory, this.mediaTransferListener, this.compositeSequenceableLoaderFactory, this.drmSessionManager, createDrmEventDispatcher(mediaPeriodId), this.loadErrorHandlingPolicy, createEventDispatcher, this.manifestLoaderErrorThrower, allocator);
        this.mediaPeriods.add(ssMediaPeriod);
        return ssMediaPeriod;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    @Deprecated
    public Object getTag() {
        return this.playbackProperties.tag;
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        this.drmSessionManager.prepare();
        if (this.sideloadedManifest) {
            this.manifestLoaderErrorThrower = new LoaderErrorThrower.Dummy();
            processManifest();
            return;
        }
        this.manifestDataSource = this.manifestDataSourceFactory.createDataSource();
        Loader loader = new Loader("SsMediaSource");
        this.manifestLoader = loader;
        this.manifestLoaderErrorThrower = loader;
        this.manifestRefreshHandler = Util.createHandlerForCurrentLooper();
        startLoadingManifest();
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SsMediaPeriod) mediaPeriod).release();
        this.mediaPeriods.remove(mediaPeriod);
    }

    public void releaseSourceInternal() {
        this.manifest = this.sideloadedManifest ? this.manifest : null;
        this.manifestDataSource = null;
        this.manifestLoadStartTimestamp = 0;
        Loader loader = this.manifestLoader;
        if (loader != null) {
            loader.release();
            this.manifestLoader = null;
        }
        Handler handler = this.manifestRefreshHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.manifestRefreshHandler = null;
        }
        this.drmSessionManager.release();
    }

    private SsMediaSource(MediaItem mediaItem2, SsManifest ssManifest, DataSource.Factory factory, ParsingLoadable.Parser<? extends SsManifest> parser, SsChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, long j11) {
        Uri uri;
        boolean z11 = false;
        Assertions.checkState(ssManifest == null || !ssManifest.isLive);
        this.mediaItem = mediaItem2;
        MediaItem.PlaybackProperties playbackProperties2 = (MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem2.playbackProperties);
        this.playbackProperties = playbackProperties2;
        this.manifest = ssManifest;
        if (playbackProperties2.uri.equals(Uri.EMPTY)) {
            uri = null;
        } else {
            uri = Util.fixSmoothStreamingIsmManifestUri(playbackProperties2.uri);
        }
        this.manifestUri = uri;
        this.manifestDataSourceFactory = factory;
        this.manifestParser = parser;
        this.chunkSourceFactory = factory2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.drmSessionManager = drmSessionManager2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.livePresentationDelayMs = j11;
        this.manifestEventDispatcher = createEventDispatcher((MediaSource.MediaPeriodId) null);
        this.sideloadedManifest = ssManifest != null ? true : z11;
        this.mediaPeriods = new ArrayList<>();
    }

    public void onLoadCanceled(ParsingLoadable<SsManifest> parsingLoadable, long j11, long j12, boolean z11) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.manifestEventDispatcher.loadCanceled(loadEventInfo, parsingLoadable2.type);
    }

    public void onLoadCompleted(ParsingLoadable<SsManifest> parsingLoadable, long j11, long j12) {
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.loadTaskId, parsingLoadable2.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j11, j12, parsingLoadable.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(parsingLoadable2.loadTaskId);
        this.manifestEventDispatcher.loadCompleted(loadEventInfo, parsingLoadable2.type);
        this.manifest = parsingLoadable.getResult();
        this.manifestLoadStartTimestamp = j11 - j12;
        processManifest();
        scheduleManifestRefresh();
    }

    public Loader.LoadErrorAction onLoadError(ParsingLoadable<SsManifest> parsingLoadable, long j11, long j12, IOException iOException, int i11) {
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable<SsManifest> parsingLoadable2 = parsingLoadable;
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
}
