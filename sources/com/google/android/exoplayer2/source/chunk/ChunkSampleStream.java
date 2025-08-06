package com.google.android.exoplayer2.source.chunk;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private static final String TAG = "ChunkSampleStream";
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    /* access modifiers changed from: private */
    public BaseMediaChunk canceledMediaChunk;
    private final BaseMediaChunkOutput chunkOutput;
    private final T chunkSource;
    private final SampleQueue[] embeddedSampleQueues;
    /* access modifiers changed from: private */
    public final Format[] embeddedTrackFormats;
    /* access modifiers changed from: private */
    public final int[] embeddedTrackTypes;
    /* access modifiers changed from: private */
    public final boolean[] embeddedTracksSelected;
    /* access modifiers changed from: private */
    public long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    private Chunk loadingChunk;
    public boolean loadingFinished;
    private final ArrayList<BaseMediaChunk> mediaChunks;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private final ChunkHolder nextChunkHolder;
    private int nextNotifyPrimaryFormatMediaChunkIndex;
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final List<BaseMediaChunk> readOnlyMediaChunks;
    private ReleaseCallback<T> releaseCallback;

    public final class EmbeddedSampleStream implements SampleStream {
        private final int index;
        private boolean notifiedDownstreamFormat;
        public final ChunkSampleStream<T> parent;
        private final SampleQueue sampleQueue;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue2, int i11) {
            this.parent = chunkSampleStream;
            this.sampleQueue = sampleQueue2;
            this.index = i11;
        }

        private void maybeNotifyDownstreamFormat() {
            if (!this.notifiedDownstreamFormat) {
                ChunkSampleStream.this.mediaSourceEventDispatcher.downstreamFormatChanged(ChunkSampleStream.this.embeddedTrackTypes[this.index], ChunkSampleStream.this.embeddedTrackFormats[this.index], 0, (Object) null, ChunkSampleStream.this.lastSeekPositionUs);
                this.notifiedDownstreamFormat = true;
            }
        }

        public boolean isReady() {
            return !ChunkSampleStream.this.isPendingReset() && this.sampleQueue.isReady(ChunkSampleStream.this.loadingFinished);
        }

        public void maybeThrowError() {
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            if (ChunkSampleStream.this.canceledMediaChunk != null && ChunkSampleStream.this.canceledMediaChunk.getFirstSampleIndex(this.index + 1) <= this.sampleQueue.getReadIndex()) {
                return -3;
            }
            maybeNotifyDownstreamFormat();
            return this.sampleQueue.read(formatHolder, decoderInputBuffer, i11, ChunkSampleStream.this.loadingFinished);
        }

        public void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        public int skipData(long j11) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return 0;
            }
            int skipCount = this.sampleQueue.getSkipCount(j11, ChunkSampleStream.this.loadingFinished);
            if (ChunkSampleStream.this.canceledMediaChunk != null) {
                skipCount = Math.min(skipCount, ChunkSampleStream.this.canceledMediaChunk.getFirstSampleIndex(this.index + 1) - this.sampleQueue.getReadIndex());
            }
            this.sampleQueue.skip(skipCount);
            if (skipCount > 0) {
                maybeNotifyDownstreamFormat();
            }
            return skipCount;
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void onSampleStreamReleased(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i11, int[] iArr, Format[] formatArr, T t11, SequenceableLoader.Callback<ChunkSampleStream<T>> callback2, Allocator allocator, long j11, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2) {
        this.primaryTrackType = i11;
        int i12 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.embeddedTrackTypes = iArr;
        this.embeddedTrackFormats = formatArr == null ? new Format[0] : formatArr;
        this.chunkSource = t11;
        this.callback = callback2;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.loader = new Loader(TAG);
        this.nextChunkHolder = new ChunkHolder();
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.mediaChunks = arrayList;
        this.readOnlyMediaChunks = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.embeddedSampleQueues = new SampleQueue[length];
        this.embeddedTracksSelected = new boolean[length];
        int i13 = length + 1;
        int[] iArr2 = new int[i13];
        SampleQueue[] sampleQueueArr = new SampleQueue[i13];
        SampleQueue createWithDrm = SampleQueue.createWithDrm(allocator, (Looper) Assertions.checkNotNull(Looper.myLooper()), drmSessionManager, eventDispatcher);
        this.primarySampleQueue = createWithDrm;
        iArr2[0] = i11;
        sampleQueueArr[0] = createWithDrm;
        while (i12 < length) {
            SampleQueue createWithoutDrm = SampleQueue.createWithoutDrm(allocator);
            this.embeddedSampleQueues[i12] = createWithoutDrm;
            int i14 = i12 + 1;
            sampleQueueArr[i14] = createWithoutDrm;
            iArr2[i14] = this.embeddedTrackTypes[i12];
            i12 = i14;
        }
        this.chunkOutput = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j11;
        this.lastSeekPositionUs = j11;
    }

    private void discardDownstreamMediaChunks(int i11) {
        int min = Math.min(primarySampleIndexToMediaChunkIndex(i11, 0), this.nextNotifyPrimaryFormatMediaChunkIndex);
        if (min > 0) {
            Util.removeRange(this.mediaChunks, 0, min);
            this.nextNotifyPrimaryFormatMediaChunkIndex -= min;
        }
    }

    private void discardUpstream(int i11) {
        Assertions.checkState(!this.loader.isLoading());
        int size = this.mediaChunks.size();
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (!haveReadFromMediaChunk(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1) {
            long j11 = getLastMediaChunk().endTimeUs;
            BaseMediaChunk discardUpstreamMediaChunksFromIndex = discardUpstreamMediaChunksFromIndex(i11);
            if (this.mediaChunks.isEmpty()) {
                this.pendingResetPositionUs = this.lastSeekPositionUs;
            }
            this.loadingFinished = false;
            this.mediaSourceEventDispatcher.upstreamDiscarded(this.primaryTrackType, discardUpstreamMediaChunksFromIndex.startTimeUs, j11);
        }
    }

    private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int i11) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i11);
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        Util.removeRange(arrayList, i11, arrayList.size());
        this.nextNotifyPrimaryFormatMediaChunkIndex = Math.max(this.nextNotifyPrimaryFormatMediaChunkIndex, this.mediaChunks.size());
        int i12 = 0;
        this.primarySampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i12 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i12];
            i12++;
            sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i12));
        }
    }

    private BaseMediaChunk getLastMediaChunk() {
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean haveReadFromMediaChunk(int i11) {
        int readIndex;
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i11);
        if (this.primarySampleQueue.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i12 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i12 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i12].getReadIndex();
            i12++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i12));
        return true;
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void maybeNotifyPrimaryTrackFormatChanged() {
        int primarySampleIndexToMediaChunkIndex = primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), this.nextNotifyPrimaryFormatMediaChunkIndex - 1);
        while (true) {
            int i11 = this.nextNotifyPrimaryFormatMediaChunkIndex;
            if (i11 <= primarySampleIndexToMediaChunkIndex) {
                this.nextNotifyPrimaryFormatMediaChunkIndex = i11 + 1;
                maybeNotifyPrimaryTrackFormatChanged(i11);
            } else {
                return;
            }
        }
    }

    private int primarySampleIndexToMediaChunkIndex(int i11, int i12) {
        do {
            i12++;
            if (i12 >= this.mediaChunks.size()) {
                return this.mediaChunks.size() - 1;
            }
        } while (this.mediaChunks.get(i12).getFirstSampleIndex(0) <= i11);
        return i12 - 1;
    }

    private void resetSampleQueues() {
        this.primarySampleQueue.reset();
        for (SampleQueue reset : this.embeddedSampleQueues) {
            reset.reset();
        }
    }

    public boolean continueLoading(long j11) {
        long j12;
        List<BaseMediaChunk> list;
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        boolean isPendingReset = isPendingReset();
        if (isPendingReset) {
            list = Collections.emptyList();
            j12 = this.pendingResetPositionUs;
        } else {
            list = this.readOnlyMediaChunks;
            j12 = getLastMediaChunk().endTimeUs;
        }
        this.chunkSource.getNextChunk(j11, j12, list, this.nextChunkHolder);
        ChunkHolder chunkHolder = this.nextChunkHolder;
        boolean z11 = chunkHolder.endOfStream;
        Chunk chunk = chunkHolder.chunk;
        chunkHolder.clear();
        if (z11) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        } else if (chunk == null) {
            return false;
        } else {
            this.loadingChunk = chunk;
            if (isMediaChunk(chunk)) {
                BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
                if (isPendingReset) {
                    long j13 = baseMediaChunk.startTimeUs;
                    long j14 = this.pendingResetPositionUs;
                    if (j13 != j14) {
                        this.primarySampleQueue.setStartTimeUs(j14);
                        for (SampleQueue startTimeUs : this.embeddedSampleQueues) {
                            startTimeUs.setStartTimeUs(this.pendingResetPositionUs);
                        }
                    }
                    this.pendingResetPositionUs = -9223372036854775807L;
                }
                baseMediaChunk.init(this.chunkOutput);
                this.mediaChunks.add(baseMediaChunk);
            } else if (chunk instanceof InitializationChunk) {
                ((InitializationChunk) chunk).init(this.chunkOutput);
            }
            this.mediaSourceEventDispatcher.loadStarted(new LoadEventInfo(chunk.loadTaskId, chunk.dataSpec, this.loader.startLoading(chunk, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk.type))), chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs);
            return true;
        }
    }

    public void discardBuffer(long j11, boolean z11) {
        if (!isPendingReset()) {
            int firstIndex = this.primarySampleQueue.getFirstIndex();
            this.primarySampleQueue.discardTo(j11, z11, true);
            int firstIndex2 = this.primarySampleQueue.getFirstIndex();
            if (firstIndex2 > firstIndex) {
                long firstTimestampUs = this.primarySampleQueue.getFirstTimestampUs();
                int i11 = 0;
                while (true) {
                    SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
                    if (i11 >= sampleQueueArr.length) {
                        break;
                    }
                    sampleQueueArr[i11].discardTo(firstTimestampUs, z11, this.embeddedTracksSelected[i11]);
                    i11++;
                }
            }
            discardDownstreamMediaChunks(firstIndex2);
        }
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        return this.chunkSource.getAdjustedSeekPositionUs(j11, seekParameters);
    }

    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j11 = this.lastSeekPositionUs;
        BaseMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
                lastMediaChunk = arrayList.get(arrayList.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            j11 = Math.max(j11, lastMediaChunk.endTimeUs);
        }
        return Math.max(j11, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    public T getChunkSource() {
        return this.chunkSource;
    }

    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public boolean isPendingReset() {
        return this.pendingResetPositionUs != -9223372036854775807L;
    }

    public boolean isReady() {
        return !isPendingReset() && this.primarySampleQueue.isReady(this.loadingFinished);
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.primarySampleQueue.maybeThrowError();
        if (!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    public void onLoaderReleased() {
        this.primarySampleQueue.release();
        for (SampleQueue release : this.embeddedSampleQueues) {
            release.release();
        }
        this.chunkSource.release();
        ReleaseCallback<T> releaseCallback2 = this.releaseCallback;
        if (releaseCallback2 != null) {
            releaseCallback2.onSampleStreamReleased(this);
        }
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (isPendingReset()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.canceledMediaChunk;
        if (baseMediaChunk != null && baseMediaChunk.getFirstSampleIndex(0) <= this.primarySampleQueue.getReadIndex()) {
            return -3;
        }
        maybeNotifyPrimaryTrackFormatChanged();
        return this.primarySampleQueue.read(formatHolder, decoderInputBuffer, i11, this.loadingFinished);
    }

    public void reevaluateBuffer(long j11) {
        if (!this.loader.hasFatalError() && !isPendingReset()) {
            if (this.loader.isLoading()) {
                Chunk chunk = (Chunk) Assertions.checkNotNull(this.loadingChunk);
                if ((!isMediaChunk(chunk) || !haveReadFromMediaChunk(this.mediaChunks.size() - 1)) && this.chunkSource.shouldCancelLoad(j11, chunk, this.readOnlyMediaChunks)) {
                    this.loader.cancelLoading();
                    if (isMediaChunk(chunk)) {
                        this.canceledMediaChunk = (BaseMediaChunk) chunk;
                        return;
                    }
                    return;
                }
                return;
            }
            int preferredQueueSize = this.chunkSource.getPreferredQueueSize(j11, this.readOnlyMediaChunks);
            if (preferredQueueSize < this.mediaChunks.size()) {
                discardUpstream(preferredQueueSize);
            }
        }
    }

    public void release() {
        release((ReleaseCallback) null);
    }

    public void seekToUs(long j11) {
        boolean z11;
        this.lastSeekPositionUs = j11;
        if (isPendingReset()) {
            this.pendingResetPositionUs = j11;
            return;
        }
        BaseMediaChunk baseMediaChunk = null;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= this.mediaChunks.size()) {
                break;
            }
            BaseMediaChunk baseMediaChunk2 = this.mediaChunks.get(i12);
            int i13 = (baseMediaChunk2.startTimeUs > j11 ? 1 : (baseMediaChunk2.startTimeUs == j11 ? 0 : -1));
            if (i13 == 0 && baseMediaChunk2.clippedStartTimeUs == -9223372036854775807L) {
                baseMediaChunk = baseMediaChunk2;
                break;
            } else if (i13 > 0) {
                break;
            } else {
                i12++;
            }
        }
        if (baseMediaChunk != null) {
            z11 = this.primarySampleQueue.seekTo(baseMediaChunk.getFirstSampleIndex(0));
        } else {
            z11 = this.primarySampleQueue.seekTo(j11, j11 < getNextLoadPositionUs());
        }
        if (z11) {
            this.nextNotifyPrimaryFormatMediaChunkIndex = primarySampleIndexToMediaChunkIndex(this.primarySampleQueue.getReadIndex(), 0);
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            int length = sampleQueueArr.length;
            while (i11 < length) {
                sampleQueueArr[i11].seekTo(j11, true);
                i11++;
            }
            return;
        }
        this.pendingResetPositionUs = j11;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        this.nextNotifyPrimaryFormatMediaChunkIndex = 0;
        if (this.loader.isLoading()) {
            this.primarySampleQueue.discardToEnd();
            SampleQueue[] sampleQueueArr2 = this.embeddedSampleQueues;
            int length2 = sampleQueueArr2.length;
            while (i11 < length2) {
                sampleQueueArr2[i11].discardToEnd();
                i11++;
            }
            this.loader.cancelLoading();
            return;
        }
        this.loader.clearFatalError();
        resetSampleQueues();
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j11, int i11) {
        for (int i12 = 0; i12 < this.embeddedSampleQueues.length; i12++) {
            if (this.embeddedTrackTypes[i12] == i11) {
                Assertions.checkState(!this.embeddedTracksSelected[i12]);
                this.embeddedTracksSelected[i12] = true;
                this.embeddedSampleQueues[i12].seekTo(j11, true);
                return new EmbeddedSampleStream(this, this.embeddedSampleQueues[i12], i12);
            }
        }
        throw new IllegalStateException();
    }

    public int skipData(long j11) {
        if (isPendingReset()) {
            return 0;
        }
        int skipCount = this.primarySampleQueue.getSkipCount(j11, this.loadingFinished);
        BaseMediaChunk baseMediaChunk = this.canceledMediaChunk;
        if (baseMediaChunk != null) {
            skipCount = Math.min(skipCount, baseMediaChunk.getFirstSampleIndex(0) - this.primarySampleQueue.getReadIndex());
        }
        this.primarySampleQueue.skip(skipCount);
        maybeNotifyPrimaryTrackFormatChanged();
        return skipCount;
    }

    public void onLoadCanceled(Chunk chunk, long j11, long j12, boolean z11) {
        Chunk chunk2 = chunk;
        this.loadingChunk = null;
        this.canceledMediaChunk = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.loadTaskId, chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j11, j12, chunk.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(chunk2.loadTaskId);
        this.mediaSourceEventDispatcher.loadCanceled(loadEventInfo, chunk2.type, this.primaryTrackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs);
        if (!z11) {
            if (isPendingReset()) {
                resetSampleQueues();
            } else if (isMediaChunk(chunk)) {
                discardUpstreamMediaChunksFromIndex(this.mediaChunks.size() - 1);
                if (this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    public void onLoadCompleted(Chunk chunk, long j11, long j12) {
        Chunk chunk2 = chunk;
        this.loadingChunk = null;
        this.chunkSource.onChunkLoadCompleted(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.loadTaskId, chunk2.dataSpec, chunk.getUri(), chunk.getResponseHeaders(), j11, j12, chunk.bytesLoaded());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(chunk2.loadTaskId);
        this.mediaSourceEventDispatcher.loadCompleted(loadEventInfo, chunk2.type, this.primaryTrackType, chunk2.trackFormat, chunk2.trackSelectionReason, chunk2.trackSelectionData, chunk2.startTimeUs, chunk2.endTimeUs);
        this.callback.onContinueLoadingRequested(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.upstream.Loader.LoadErrorAction onLoadError(com.google.android.exoplayer2.source.chunk.Chunk r37, long r38, long r40, java.io.IOException r42, int r43) {
        /*
            r36 = this;
            r0 = r36
            r7 = r37
            long r18 = r37.bytesLoaded()
            boolean r20 = r36.isMediaChunk(r37)
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r1 = r0.mediaChunks
            int r1 = r1.size()
            r21 = 1
            int r5 = r1 + -1
            r1 = 0
            int r1 = (r18 > r1 ? 1 : (r18 == r1 ? 0 : -1))
            r6 = 0
            if (r1 == 0) goto L_0x0029
            if (r20 == 0) goto L_0x0029
            boolean r1 = r0.haveReadFromMediaChunk(r5)
            if (r1 != 0) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r22 = r6
            goto L_0x002b
        L_0x0029:
            r22 = r21
        L_0x002b:
            com.google.android.exoplayer2.source.LoadEventInfo r4 = new com.google.android.exoplayer2.source.LoadEventInfo
            long r9 = r7.loadTaskId
            com.google.android.exoplayer2.upstream.DataSpec r11 = r7.dataSpec
            android.net.Uri r12 = r37.getUri()
            java.util.Map r13 = r37.getResponseHeaders()
            r8 = r4
            r14 = r38
            r16 = r40
            r8.<init>(r9, r11, r12, r13, r14, r16, r18)
            com.google.android.exoplayer2.source.MediaLoadData r1 = new com.google.android.exoplayer2.source.MediaLoadData
            int r2 = r7.type
            int r3 = r0.primaryTrackType
            com.google.android.exoplayer2.Format r8 = r7.trackFormat
            int r9 = r7.trackSelectionReason
            java.lang.Object r10 = r7.trackSelectionData
            long r11 = r7.startTimeUs
            long r29 = com.google.android.exoplayer2.C.usToMs(r11)
            long r11 = r7.endTimeUs
            long r31 = com.google.android.exoplayer2.C.usToMs(r11)
            r23 = r1
            r24 = r2
            r25 = r3
            r26 = r8
            r27 = r9
            r28 = r10
            r23.<init>(r24, r25, r26, r27, r28, r29, r31)
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo r8 = new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo
            r9 = r42
            r2 = r43
            r8.<init>(r4, r1, r9, r2)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r22 == 0) goto L_0x0080
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r1 = r0.loadErrorHandlingPolicy
            long r1 = r1.getBlacklistDurationMsFor(r8)
            r12 = r1
            goto L_0x0081
        L_0x0080:
            r12 = r10
        L_0x0081:
            T r1 = r0.chunkSource
            r2 = r37
            r3 = r22
            r14 = r4
            r4 = r42
            r15 = r5
            r5 = r12
            boolean r1 = r1.onChunkLoadError(r2, r3, r4, r5)
            if (r1 == 0) goto L_0x00b9
            if (r22 == 0) goto L_0x00b2
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r1 = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY
            if (r20 == 0) goto L_0x00ba
            com.google.android.exoplayer2.source.chunk.BaseMediaChunk r3 = r0.discardUpstreamMediaChunksFromIndex(r15)
            if (r3 != r7) goto L_0x00a1
            r6 = r21
            goto L_0x00a2
        L_0x00a1:
            r6 = 0
        L_0x00a2:
            com.google.android.exoplayer2.util.Assertions.checkState(r6)
            java.util.ArrayList<com.google.android.exoplayer2.source.chunk.BaseMediaChunk> r3 = r0.mediaChunks
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x00ba
            long r3 = r0.lastSeekPositionUs
            r0.pendingResetPositionUs = r3
            goto L_0x00ba
        L_0x00b2:
            java.lang.String r1 = "ChunkSampleStream"
            java.lang.String r3 = "Ignoring attempt to cancel non-cancelable load."
            com.google.android.exoplayer2.util.Log.w(r1, r3)
        L_0x00b9:
            r1 = 0
        L_0x00ba:
            if (r1 != 0) goto L_0x00ce
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r1 = r0.loadErrorHandlingPolicy
            long r3 = r1.getRetryDelayMsFor(r8)
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 == 0) goto L_0x00cc
            r1 = 0
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r1 = com.google.android.exoplayer2.upstream.Loader.createRetryAction(r1, r3)
            goto L_0x00ce
        L_0x00cc:
            com.google.android.exoplayer2.upstream.Loader$LoadErrorAction r1 = com.google.android.exoplayer2.upstream.Loader.DONT_RETRY_FATAL
        L_0x00ce:
            boolean r3 = r1.isRetry()
            r3 = r3 ^ 1
            com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher r4 = r0.mediaSourceEventDispatcher
            int r5 = r7.type
            int r6 = r0.primaryTrackType
            com.google.android.exoplayer2.Format r8 = r7.trackFormat
            int r10 = r7.trackSelectionReason
            java.lang.Object r11 = r7.trackSelectionData
            long r12 = r7.startTimeUs
            r39 = r3
            long r2 = r7.endTimeUs
            r23 = r4
            r24 = r14
            r25 = r5
            r26 = r6
            r27 = r8
            r28 = r10
            r29 = r11
            r30 = r12
            r32 = r2
            r34 = r42
            r35 = r39
            r23.loadError(r24, r25, r26, r27, r28, r29, r30, r32, r34, r35)
            if (r39 == 0) goto L_0x0110
            r2 = 0
            r0.loadingChunk = r2
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r2 = r0.loadErrorHandlingPolicy
            long r3 = r7.loadTaskId
            r2.onLoadTaskConcluded(r3)
            com.google.android.exoplayer2.source.SequenceableLoader$Callback<com.google.android.exoplayer2.source.chunk.ChunkSampleStream<T>> r2 = r0.callback
            r2.onContinueLoadingRequested(r0)
        L_0x0110:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.ChunkSampleStream.onLoadError(com.google.android.exoplayer2.source.chunk.Chunk, long, long, java.io.IOException, int):com.google.android.exoplayer2.upstream.Loader$LoadErrorAction");
    }

    public void release(ReleaseCallback<T> releaseCallback2) {
        this.releaseCallback = releaseCallback2;
        this.primarySampleQueue.preRelease();
        for (SampleQueue preRelease : this.embeddedSampleQueues) {
            preRelease.preRelease();
        }
        this.loader.release(this);
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i11) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i11);
        Format format = baseMediaChunk.trackFormat;
        if (!format.equals(this.primaryDownstreamTrackFormat)) {
            this.mediaSourceEventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
        }
        this.primaryDownstreamTrackFormat = format;
    }
}
