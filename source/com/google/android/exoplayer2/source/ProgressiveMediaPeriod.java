package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.IcyDataSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class ProgressiveMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    /* access modifiers changed from: private */
    public static final Format ICY_FORMAT = new Format.Builder().setId("icy").setSampleMimeType(MimeTypes.APPLICATION_ICY).build();
    /* access modifiers changed from: private */
    public static final Map<String, String> ICY_METADATA_HEADERS = createIcyMetadataHeaders();
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    /* access modifiers changed from: private */
    public final long continueLoadingCheckIntervalBytes;
    /* access modifiers changed from: private */
    public final String customCacheKey;
    private final DataSource dataSource;
    private int dataType;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private long durationUs;
    private int enabledTrackCount;
    private int extractedSamplesCountAtStartOfLoad;
    /* access modifiers changed from: private */
    public final Handler handler;
    private boolean haveAudioVideoTracks;
    /* access modifiers changed from: private */
    public IcyHeaders icyHeaders;
    private boolean isLive;
    private long lastSeekPositionUs;
    private long length;
    private final Listener listener;
    private final ConditionVariable loadCondition;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader = new Loader("ProgressiveMediaPeriod");
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private boolean notifyDiscontinuity;
    /* access modifiers changed from: private */
    public final Runnable onContinueLoadingRequestedRunnable;
    private boolean pendingDeferredRetry;
    private long pendingResetPositionUs;
    private boolean prepared;
    private final ProgressiveMediaExtractor progressiveMediaExtractor;
    private boolean released;
    private TrackId[] sampleQueueTrackIds;
    private SampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private TrackState trackState;
    private final Uri uri;

    public final class ExtractingLoadable implements Loader.Loadable, IcyDataSource.Listener {
        /* access modifiers changed from: private */
        public final StatsDataSource dataSource;
        /* access modifiers changed from: private */
        public DataSpec dataSpec = buildDataSpec(0);
        private final ExtractorOutput extractorOutput;
        private TrackOutput icyTrackOutput;
        /* access modifiers changed from: private */
        public long length = -1;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        /* access modifiers changed from: private */
        public final long loadTaskId = LoadEventInfo.getNewId();
        private boolean pendingExtractorSeek = true;
        private final PositionHolder positionHolder = new PositionHolder();
        private final ProgressiveMediaExtractor progressiveMediaExtractor;
        /* access modifiers changed from: private */
        public long seekTimeUs;
        private boolean seenIcyMetadata;
        private final Uri uri;

        public ExtractingLoadable(Uri uri2, DataSource dataSource2, ProgressiveMediaExtractor progressiveMediaExtractor2, ExtractorOutput extractorOutput2, ConditionVariable conditionVariable) {
            this.uri = uri2;
            this.dataSource = new StatsDataSource(dataSource2);
            this.progressiveMediaExtractor = progressiveMediaExtractor2;
            this.extractorOutput = extractorOutput2;
            this.loadCondition = conditionVariable;
        }

        private DataSpec buildDataSpec(long j11) {
            return new DataSpec.Builder().setUri(this.uri).setPosition(j11).setKey(ProgressiveMediaPeriod.this.customCacheKey).setFlags(6).setHttpRequestHeaders(ProgressiveMediaPeriod.ICY_METADATA_HEADERS).build();
        }

        /* access modifiers changed from: private */
        public void setLoadPosition(long j11, long j12) {
            this.positionHolder.position = j11;
            this.seekTimeUs = j12;
            this.pendingExtractorSeek = true;
            this.seenIcyMetadata = false;
        }

        public void cancelLoad() {
            this.loadCanceled = true;
        }

        public void load() throws IOException {
            int i11 = 0;
            while (i11 == 0 && !this.loadCanceled) {
                try {
                    long j11 = this.positionHolder.position;
                    DataSpec buildDataSpec = buildDataSpec(j11);
                    this.dataSpec = buildDataSpec;
                    long open = this.dataSource.open(buildDataSpec);
                    this.length = open;
                    if (open != -1) {
                        this.length = open + j11;
                    }
                    IcyHeaders unused = ProgressiveMediaPeriod.this.icyHeaders = IcyHeaders.parse(this.dataSource.getResponseHeaders());
                    DataReader dataReader = this.dataSource;
                    if (!(ProgressiveMediaPeriod.this.icyHeaders == null || ProgressiveMediaPeriod.this.icyHeaders.metadataInterval == -1)) {
                        dataReader = new IcyDataSource(this.dataSource, ProgressiveMediaPeriod.this.icyHeaders.metadataInterval, this);
                        TrackOutput icyTrack = ProgressiveMediaPeriod.this.icyTrack();
                        this.icyTrackOutput = icyTrack;
                        icyTrack.format(ProgressiveMediaPeriod.ICY_FORMAT);
                    }
                    long j12 = j11;
                    this.progressiveMediaExtractor.init(dataReader, this.uri, this.dataSource.getResponseHeaders(), j11, this.length, this.extractorOutput);
                    if (ProgressiveMediaPeriod.this.icyHeaders != null) {
                        this.progressiveMediaExtractor.disableSeekingOnMp3Streams();
                    }
                    if (this.pendingExtractorSeek) {
                        this.progressiveMediaExtractor.seek(j12, this.seekTimeUs);
                        this.pendingExtractorSeek = false;
                    }
                    while (true) {
                        long j13 = j12;
                        while (i11 == 0 && !this.loadCanceled) {
                            this.loadCondition.block();
                            i11 = this.progressiveMediaExtractor.read(this.positionHolder);
                            j12 = this.progressiveMediaExtractor.getCurrentInputPosition();
                            if (j12 > ProgressiveMediaPeriod.this.continueLoadingCheckIntervalBytes + j13) {
                                this.loadCondition.close();
                                ProgressiveMediaPeriod.this.handler.post(ProgressiveMediaPeriod.this.onContinueLoadingRequestedRunnable);
                            }
                        }
                    }
                    if (i11 == 1) {
                        i11 = 0;
                    } else if (this.progressiveMediaExtractor.getCurrentInputPosition() != -1) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    Util.closeQuietly((DataSource) this.dataSource);
                } catch (InterruptedException unused2) {
                    throw new InterruptedIOException();
                } catch (Throwable th2) {
                    if (!(i11 == 1 || this.progressiveMediaExtractor.getCurrentInputPosition() == -1)) {
                        this.positionHolder.position = this.progressiveMediaExtractor.getCurrentInputPosition();
                    }
                    Util.closeQuietly((DataSource) this.dataSource);
                    throw th2;
                }
            }
        }

        public void onIcyMetadata(ParsableByteArray parsableByteArray) {
            long max = !this.seenIcyMetadata ? this.seekTimeUs : Math.max(ProgressiveMediaPeriod.this.getLargestQueuedTimestampUs(), this.seekTimeUs);
            int bytesLeft = parsableByteArray.bytesLeft();
            TrackOutput trackOutput = (TrackOutput) Assertions.checkNotNull(this.icyTrackOutput);
            trackOutput.sampleData(parsableByteArray, bytesLeft);
            trackOutput.sampleMetadata(max, 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
            this.seenIcyMetadata = true;
        }
    }

    public interface Listener {
        void onSourceInfoRefreshed(long j11, boolean z11, boolean z12);
    }

    public final class SampleStreamImpl implements SampleStream {
        /* access modifiers changed from: private */
        public final int track;

        public SampleStreamImpl(int i11) {
            this.track = i11;
        }

        public boolean isReady() {
            return ProgressiveMediaPeriod.this.isReady(this.track);
        }

        public void maybeThrowError() throws IOException {
            ProgressiveMediaPeriod.this.maybeThrowError(this.track);
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
            return ProgressiveMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, i11);
        }

        public int skipData(long j11) {
            return ProgressiveMediaPeriod.this.skipData(this.track, j11);
        }
    }

    public static final class TrackId {

        /* renamed from: id  reason: collision with root package name */
        public final int f65980id;
        public final boolean isIcyTrack;

        public TrackId(int i11, boolean z11) {
            this.f65980id = i11;
            this.isIcyTrack = z11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackId.class != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            if (this.f65980id == trackId.f65980id && this.isIcyTrack == trackId.isIcyTrack) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f65980id * 31) + (this.isIcyTrack ? 1 : 0);
        }
    }

    public static final class TrackState {
        public final boolean[] trackEnabledStates;
        public final boolean[] trackIsAudioVideoFlags;
        public final boolean[] trackNotifiedDownstreamFormats;
        public final TrackGroupArray tracks;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.tracks = trackGroupArray;
            this.trackIsAudioVideoFlags = zArr;
            int i11 = trackGroupArray.length;
            this.trackEnabledStates = new boolean[i11];
            this.trackNotifiedDownstreamFormats = new boolean[i11];
        }
    }

    public ProgressiveMediaPeriod(Uri uri2, DataSource dataSource2, ProgressiveMediaExtractor progressiveMediaExtractor2, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, Listener listener2, Allocator allocator2, String str, int i11) {
        this.uri = uri2;
        this.dataSource = dataSource2;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.listener = listener2;
        this.allocator = allocator2;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = (long) i11;
        this.progressiveMediaExtractor = progressiveMediaExtractor2;
        this.loadCondition = new ConditionVariable();
        this.maybeFinishPrepareRunnable = new n(this);
        this.onContinueLoadingRequestedRunnable = new o(this);
        this.handler = Util.createHandlerForCurrentLooper();
        this.sampleQueueTrackIds = new TrackId[0];
        this.sampleQueues = new SampleQueue[0];
        this.pendingResetPositionUs = -9223372036854775807L;
        this.length = -1;
        this.durationUs = -9223372036854775807L;
        this.dataType = 1;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void assertPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackState);
        Assertions.checkNotNull(this.seekMap);
    }

    private boolean configureRetry(ExtractingLoadable extractingLoadable, int i11) {
        SeekMap seekMap2;
        if (this.length == -1 && ((seekMap2 = this.seekMap) == null || seekMap2.getDurationUs() == -9223372036854775807L)) {
            if (!this.prepared || suppressRead()) {
                this.notifyDiscontinuity = this.prepared;
                this.lastSeekPositionUs = 0;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue reset : this.sampleQueues) {
                    reset.reset();
                }
                extractingLoadable.setLoadPosition(0, 0);
                return true;
            }
            this.pendingDeferredRetry = true;
            return false;
        }
        this.extractedSamplesCountAtStartOfLoad = i11;
        return true;
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        if (this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private static Map<String, String> createIcyMetadataHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private int getExtractedSamplesCount() {
        int i11 = 0;
        for (SampleQueue writeIndex : this.sampleQueues) {
            i11 += writeIndex.getWriteIndex();
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public long getLargestQueuedTimestampUs() {
        long j11 = Long.MIN_VALUE;
        for (SampleQueue largestQueuedTimestampUs : this.sampleQueues) {
            j11 = Math.max(j11, largestQueuedTimestampUs.getLargestQueuedTimestampUs());
        }
        return j11;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (!this.released) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    /* access modifiers changed from: private */
    public void maybeFinishPrepare() {
        Metadata metadata;
        if (!this.released && !this.prepared && this.sampleQueuesBuilt && this.seekMap != null) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            int length2 = sampleQueueArr.length;
            int i11 = 0;
            while (i11 < length2) {
                if (sampleQueueArr[i11].getUpstreamFormat() != null) {
                    i11++;
                } else {
                    return;
                }
            }
            this.loadCondition.close();
            int length3 = this.sampleQueues.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length3];
            boolean[] zArr = new boolean[length3];
            for (int i12 = 0; i12 < length3; i12++) {
                Format format = (Format) Assertions.checkNotNull(this.sampleQueues[i12].getUpstreamFormat());
                String str = format.sampleMimeType;
                boolean isAudio = MimeTypes.isAudio(str);
                boolean z11 = isAudio || MimeTypes.isVideo(str);
                zArr[i12] = z11;
                this.haveAudioVideoTracks = z11 | this.haveAudioVideoTracks;
                IcyHeaders icyHeaders2 = this.icyHeaders;
                if (icyHeaders2 != null) {
                    if (isAudio || this.sampleQueueTrackIds[i12].isIcyTrack) {
                        Metadata metadata2 = format.metadata;
                        if (metadata2 == null) {
                            metadata = new Metadata(icyHeaders2);
                        } else {
                            metadata = metadata2.copyWithAppendedEntries(icyHeaders2);
                        }
                        format = format.buildUpon().setMetadata(metadata).build();
                    }
                    if (isAudio && format.averageBitrate == -1 && format.peakBitrate == -1 && icyHeaders2.bitrate != -1) {
                        format = format.buildUpon().setAverageBitrate(icyHeaders2.bitrate).build();
                    }
                }
                trackGroupArr[i12] = new TrackGroup(format.copyWithExoMediaCryptoType(this.drmSessionManager.getExoMediaCryptoType(format)));
            }
            this.trackState = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
            this.prepared = true;
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }
    }

    private void maybeNotifyDownstreamFormat(int i11) {
        assertPrepared();
        TrackState trackState2 = this.trackState;
        boolean[] zArr = trackState2.trackNotifiedDownstreamFormats;
        if (!zArr[i11]) {
            Format format = trackState2.tracks.get(i11).getFormat(0);
            this.mediaSourceEventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, (Object) null, this.lastSeekPositionUs);
            zArr[i11] = true;
        }
    }

    private void maybeStartDeferredRetry(int i11) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (this.pendingDeferredRetry && zArr[i11]) {
            if (!this.sampleQueues[i11].isReady(false)) {
                this.pendingResetPositionUs = 0;
                this.pendingDeferredRetry = false;
                this.notifyDiscontinuity = true;
                this.lastSeekPositionUs = 0;
                this.extractedSamplesCountAtStartOfLoad = 0;
                for (SampleQueue reset : this.sampleQueues) {
                    reset.reset();
                }
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
            }
        }
    }

    private TrackOutput prepareTrackOutput(TrackId trackId) {
        int length2 = this.sampleQueues.length;
        for (int i11 = 0; i11 < length2; i11++) {
            if (trackId.equals(this.sampleQueueTrackIds[i11])) {
                return this.sampleQueues[i11];
            }
        }
        SampleQueue createWithDrm = SampleQueue.createWithDrm(this.allocator, this.handler.getLooper(), this.drmSessionManager, this.drmEventDispatcher);
        createWithDrm.setUpstreamFormatChangeListener(this);
        int i12 = length2 + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.sampleQueueTrackIds, i12);
        trackIdArr[length2] = trackId;
        this.sampleQueueTrackIds = (TrackId[]) Util.castNonNullTypeArray(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i12);
        sampleQueueArr[length2] = createWithDrm;
        this.sampleQueues = (SampleQueue[]) Util.castNonNullTypeArray(sampleQueueArr);
        return createWithDrm;
    }

    private boolean seekInsideBufferUs(boolean[] zArr, long j11) {
        int length2 = this.sampleQueues.length;
        for (int i11 = 0; i11 < length2; i11++) {
            if (!this.sampleQueues[i11].seekTo(j11, false) && (zArr[i11] || !this.haveAudioVideoTracks)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: setSeekMap */
    public void lambda$seekMap$1(SeekMap seekMap2) {
        this.seekMap = this.icyHeaders == null ? seekMap2 : new SeekMap.Unseekable(-9223372036854775807L);
        this.durationUs = seekMap2.getDurationUs();
        int i11 = 1;
        boolean z11 = this.length == -1 && seekMap2.getDurationUs() == -9223372036854775807L;
        this.isLive = z11;
        if (z11) {
            i11 = 7;
        }
        this.dataType = i11;
        this.listener.onSourceInfoRefreshed(this.durationUs, seekMap2.isSeekable(), this.isLive);
        if (!this.prepared) {
            maybeFinishPrepare();
        }
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.progressiveMediaExtractor, this, this.loadCondition);
        if (this.prepared) {
            Assertions.checkState(isPendingReset());
            long j11 = this.durationUs;
            if (j11 == -9223372036854775807L || this.pendingResetPositionUs <= j11) {
                extractingLoadable.setLoadPosition(((SeekMap) Assertions.checkNotNull(this.seekMap)).getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
                for (SampleQueue startTimeUs : this.sampleQueues) {
                    startTimeUs.setStartTimeUs(this.pendingResetPositionUs);
                }
                this.pendingResetPositionUs = -9223372036854775807L;
            } else {
                this.loadingFinished = true;
                this.pendingResetPositionUs = -9223372036854775807L;
                return;
            }
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        this.mediaSourceEventDispatcher.loadStarted(new LoadEventInfo(extractingLoadable.loadTaskId, extractingLoadable.dataSpec, this.loader.startLoading(extractingLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType))), 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs);
    }

    private boolean suppressRead() {
        return this.notifyDiscontinuity || isPendingReset();
    }

    public boolean continueLoading(long j11) {
        if (this.loadingFinished || this.loader.hasFatalError() || this.pendingDeferredRetry) {
            return false;
        }
        if (this.prepared && this.enabledTrackCount == 0) {
            return false;
        }
        boolean open = this.loadCondition.open();
        if (this.loader.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    public void discardBuffer(long j11, boolean z11) {
        assertPrepared();
        if (!isPendingReset()) {
            boolean[] zArr = this.trackState.trackEnabledStates;
            int length2 = this.sampleQueues.length;
            for (int i11 = 0; i11 < length2; i11++) {
                this.sampleQueues[i11].discardTo(j11, z11, zArr[i11]);
            }
        }
    }

    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        assertPrepared();
        if (!this.seekMap.isSeekable()) {
            return 0;
        }
        SeekMap.SeekPoints seekPoints = this.seekMap.getSeekPoints(j11);
        return seekParameters.resolveSeekPositionUs(j11, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    public long getBufferedPositionUs() {
        long j11;
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length2 = this.sampleQueues.length;
            j11 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < length2; i11++) {
                if (zArr[i11] && !this.sampleQueues[i11].isLastSampleQueued()) {
                    j11 = Math.min(j11, this.sampleQueues[i11].getLargestQueuedTimestampUs());
                }
            }
        } else {
            j11 = Long.MAX_VALUE;
        }
        if (j11 == Long.MAX_VALUE) {
            j11 = getLargestQueuedTimestampUs();
        }
        return j11 == Long.MIN_VALUE ? this.lastSeekPositionUs : j11;
    }

    public long getNextLoadPositionUs() {
        if (this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    public /* synthetic */ List getStreamKeys(List list) {
        return d.a(this, list);
    }

    public TrackGroupArray getTrackGroups() {
        assertPrepared();
        return this.trackState.tracks;
    }

    public TrackOutput icyTrack() {
        return prepareTrackOutput(new TrackId(0, true));
    }

    public boolean isLoading() {
        return this.loader.isLoading() && this.loadCondition.isOpen();
    }

    public boolean isReady(int i11) {
        return !suppressRead() && this.sampleQueues[i11].isReady(this.loadingFinished);
    }

    public void maybeThrowError(int i11) throws IOException {
        this.sampleQueues[i11].maybeThrowError();
        maybeThrowError();
    }

    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
        if (this.loadingFinished && !this.prepared) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public void onLoaderReleased() {
        for (SampleQueue release : this.sampleQueues) {
            release.release();
        }
        this.progressiveMediaExtractor.release();
    }

    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void prepare(MediaPeriod.Callback callback2, long j11) {
        this.callback = callback2;
        this.loadCondition.open();
        startLoading();
    }

    public int readData(int i11, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (suppressRead()) {
            return -3;
        }
        maybeNotifyDownstreamFormat(i11);
        int read = this.sampleQueues[i11].read(formatHolder, decoderInputBuffer, i12, this.loadingFinished);
        if (read == -3) {
            maybeStartDeferredRetry(i11);
        }
        return read;
    }

    public long readDiscontinuity() {
        if (!this.notifyDiscontinuity) {
            return -9223372036854775807L;
        }
        if (!this.loadingFinished && getExtractedSamplesCount() <= this.extractedSamplesCountAtStartOfLoad) {
            return -9223372036854775807L;
        }
        this.notifyDiscontinuity = false;
        return this.lastSeekPositionUs;
    }

    public void reevaluateBuffer(long j11) {
    }

    public void release() {
        if (this.prepared) {
            for (SampleQueue preRelease : this.sampleQueues) {
                preRelease.preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages((Object) null);
        this.callback = null;
        this.released = true;
    }

    public void seekMap(SeekMap seekMap2) {
        this.handler.post(new p(this, seekMap2));
    }

    public long seekToUs(long j11) {
        assertPrepared();
        boolean[] zArr = this.trackState.trackIsAudioVideoFlags;
        if (!this.seekMap.isSeekable()) {
            j11 = 0;
        }
        int i11 = 0;
        this.notifyDiscontinuity = false;
        this.lastSeekPositionUs = j11;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j11;
            return j11;
        } else if (this.dataType != 7 && seekInsideBufferUs(zArr, j11)) {
            return j11;
        } else {
            this.pendingDeferredRetry = false;
            this.pendingResetPositionUs = j11;
            this.loadingFinished = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length2 = sampleQueueArr.length;
                while (i11 < length2) {
                    sampleQueueArr[i11].discardToEnd();
                    i11++;
                }
                this.loader.cancelLoading();
            } else {
                this.loader.clearFatalError();
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length3 = sampleQueueArr2.length;
                while (i11 < length3) {
                    sampleQueueArr2[i11].reset();
                    i11++;
                }
            }
            return j11;
        }
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
        assertPrepared();
        TrackState trackState2 = this.trackState;
        TrackGroupArray trackGroupArray = trackState2.tracks;
        boolean[] zArr3 = trackState2.trackEnabledStates;
        int i11 = this.enabledTrackCount;
        int i12 = 0;
        for (int i13 = 0; i13 < exoTrackSelectionArr.length; i13++) {
            if (sampleStreamArr[i13] != null && (exoTrackSelectionArr[i13] == null || !zArr[i13])) {
                int access$000 = sampleStreamArr[i13].track;
                Assertions.checkState(zArr3[access$000]);
                this.enabledTrackCount--;
                zArr3[access$000] = false;
                sampleStreamArr[i13] = null;
            }
        }
        boolean z11 = !this.seenFirstTrackSelection ? j11 != 0 : i11 == 0;
        for (int i14 = 0; i14 < exoTrackSelectionArr.length; i14++) {
            if (sampleStreamArr[i14] == null && exoTrackSelectionArr[i14] != null) {
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i14];
                Assertions.checkState(exoTrackSelection.length() == 1);
                Assertions.checkState(exoTrackSelection.getIndexInTrackGroup(0) == 0);
                int indexOf = trackGroupArray.indexOf(exoTrackSelection.getTrackGroup());
                Assertions.checkState(!zArr3[indexOf]);
                this.enabledTrackCount++;
                zArr3[indexOf] = true;
                sampleStreamArr[i14] = new SampleStreamImpl(indexOf);
                zArr2[i14] = true;
                if (!z11) {
                    SampleQueue sampleQueue = this.sampleQueues[indexOf];
                    z11 = !sampleQueue.seekTo(j11, true) && sampleQueue.getReadIndex() != 0;
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length2 = sampleQueueArr.length;
                while (i12 < length2) {
                    sampleQueueArr[i12].discardToEnd();
                    i12++;
                }
                this.loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length3 = sampleQueueArr2.length;
                while (i12 < length3) {
                    sampleQueueArr2[i12].reset();
                    i12++;
                }
            }
        } else if (z11) {
            j11 = seekToUs(j11);
            while (i12 < sampleStreamArr.length) {
                if (sampleStreamArr[i12] != null) {
                    zArr2[i12] = true;
                }
                i12++;
            }
        }
        this.seenFirstTrackSelection = true;
        return j11;
    }

    public int skipData(int i11, long j11) {
        if (suppressRead()) {
            return 0;
        }
        maybeNotifyDownstreamFormat(i11);
        SampleQueue sampleQueue = this.sampleQueues[i11];
        int skipCount = sampleQueue.getSkipCount(j11, this.loadingFinished);
        sampleQueue.skip(skipCount);
        if (skipCount == 0) {
            maybeStartDeferredRetry(i11);
        }
        return skipCount;
    }

    public TrackOutput track(int i11, int i12) {
        return prepareTrackOutput(new TrackId(i11, false));
    }

    public void onLoadCanceled(ExtractingLoadable extractingLoadable, long j11, long j12, boolean z11) {
        StatsDataSource access$100 = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.loadTaskId, extractingLoadable.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j11, j12, access$100.getBytesRead());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(extractingLoadable.loadTaskId);
        this.mediaSourceEventDispatcher.loadCanceled(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs);
        if (!z11) {
            copyLengthFromLoader(extractingLoadable);
            for (SampleQueue reset : this.sampleQueues) {
                reset.reset();
            }
            if (this.enabledTrackCount > 0) {
                ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
            }
        }
    }

    public void onLoadCompleted(ExtractingLoadable extractingLoadable, long j11, long j12) {
        SeekMap seekMap2;
        if (this.durationUs == -9223372036854775807L && (seekMap2 = this.seekMap) != null) {
            boolean isSeekable = seekMap2.isSeekable();
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            long j13 = largestQueuedTimestampUs == Long.MIN_VALUE ? 0 : largestQueuedTimestampUs + 10000;
            this.durationUs = j13;
            this.listener.onSourceInfoRefreshed(j13, isSeekable, this.isLive);
        }
        StatsDataSource access$100 = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.loadTaskId, extractingLoadable.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j11, j12, access$100.getBytesRead());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(extractingLoadable.loadTaskId);
        this.mediaSourceEventDispatcher.loadCompleted(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs);
        copyLengthFromLoader(extractingLoadable);
        this.loadingFinished = true;
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    public Loader.LoadErrorAction onLoadError(ExtractingLoadable extractingLoadable, long j11, long j12, IOException iOException, int i11) {
        Loader.LoadErrorAction loadErrorAction;
        ExtractingLoadable extractingLoadable2;
        boolean z11;
        copyLengthFromLoader(extractingLoadable);
        StatsDataSource access$100 = extractingLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.loadTaskId, extractingLoadable.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j11, j12, access$100.getBytesRead());
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, (Format) null, 0, (Object) null, C.usToMs(extractingLoadable.seekTimeUs), C.usToMs(this.durationUs)), iOException, i11));
        if (retryDelayMsFor == -9223372036854775807L) {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
            ExtractingLoadable extractingLoadable3 = extractingLoadable;
        } else {
            int extractedSamplesCount = getExtractedSamplesCount();
            if (extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad) {
                extractingLoadable2 = extractingLoadable;
                z11 = true;
            } else {
                z11 = false;
                extractingLoadable2 = extractingLoadable;
            }
            if (configureRetry(extractingLoadable2, extractedSamplesCount)) {
                loadErrorAction = Loader.createRetryAction(z11, retryDelayMsFor);
            } else {
                loadErrorAction = Loader.DONT_RETRY;
            }
        }
        boolean z12 = !loadErrorAction.isRetry();
        this.mediaSourceEventDispatcher.loadError(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, extractingLoadable.seekTimeUs, this.durationUs, iOException, z12);
        if (z12) {
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(extractingLoadable.loadTaskId);
        }
        return loadErrorAction;
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError(this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType));
    }
}
