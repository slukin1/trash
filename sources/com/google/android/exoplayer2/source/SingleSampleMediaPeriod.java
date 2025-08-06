package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    private static final int INITIAL_SAMPLE_SIZE = 1024;
    private static final String TAG = "SingleSampleMediaPeriod";
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher eventDispatcher;
    public final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    public final Loader loader = new Loader(TAG);
    public boolean loadingFinished;
    public byte[] sampleData;
    public int sampleSize;
    private final ArrayList<SampleStreamImpl> sampleStreams = new ArrayList<>();
    private final TrackGroupArray tracks;
    private final TransferListener transferListener;
    public final boolean treatLoadErrorsAsEndOfStream;

    public final class SampleStreamImpl implements SampleStream {
        private static final int STREAM_STATE_END_OF_STREAM = 2;
        private static final int STREAM_STATE_SEND_FORMAT = 0;
        private static final int STREAM_STATE_SEND_SAMPLE = 1;
        private boolean notifiedDownstreamFormat;
        private int streamState;

        private SampleStreamImpl() {
        }

        private void maybeNotifyDownstreamFormat() {
            if (!this.notifiedDownstreamFormat) {
                SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(SingleSampleMediaPeriod.this.format.sampleMimeType), SingleSampleMediaPeriod.this.format, 0, (Object) null, 0);
                this.notifiedDownstreamFormat = true;
            }
        }

        public boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        public void maybeThrowError() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (!singleSampleMediaPeriod.treatLoadErrorsAsEndOfStream) {
                singleSampleMediaPeriod.loader.maybeThrowError();
            }
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
            maybeNotifyDownstreamFormat();
            int i12 = this.streamState;
            if (i12 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if ((i11 & 2) != 0 || i12 == 0) {
                formatHolder.format = SingleSampleMediaPeriod.this.format;
                this.streamState = 1;
                return -5;
            } else {
                SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
                if (!singleSampleMediaPeriod.loadingFinished) {
                    return -3;
                }
                if (singleSampleMediaPeriod.sampleData == null) {
                    decoderInputBuffer.addFlag(4);
                    this.streamState = 2;
                    return -4;
                }
                decoderInputBuffer.addFlag(1);
                decoderInputBuffer.timeUs = 0;
                if ((i11 & 4) == 0) {
                    decoderInputBuffer.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
                    ByteBuffer byteBuffer = decoderInputBuffer.data;
                    SingleSampleMediaPeriod singleSampleMediaPeriod2 = SingleSampleMediaPeriod.this;
                    byteBuffer.put(singleSampleMediaPeriod2.sampleData, 0, singleSampleMediaPeriod2.sampleSize);
                }
                if ((i11 & 1) == 0) {
                    this.streamState = 2;
                }
                return -4;
            }
        }

        public void reset() {
            if (this.streamState == 2) {
                this.streamState = 1;
            }
        }

        public int skipData(long j11) {
            maybeNotifyDownstreamFormat();
            if (j11 <= 0 || this.streamState == 2) {
                return 0;
            }
            this.streamState = 2;
            return 1;
        }
    }

    public static final class SourceLoadable implements Loader.Loadable {
        /* access modifiers changed from: private */
        public final StatsDataSource dataSource;
        public final DataSpec dataSpec;
        public final long loadTaskId = LoadEventInfo.getNewId();
        /* access modifiers changed from: private */
        public byte[] sampleData;

        public SourceLoadable(DataSpec dataSpec2, DataSource dataSource2) {
            this.dataSpec = dataSpec2;
            this.dataSource = new StatsDataSource(dataSource2);
        }

        public void cancelLoad() {
        }

        public void load() throws IOException {
            this.dataSource.resetBytesRead();
            try {
                this.dataSource.open(this.dataSpec);
                int i11 = 0;
                while (i11 != -1) {
                    int bytesRead = (int) this.dataSource.getBytesRead();
                    byte[] bArr = this.sampleData;
                    if (bArr == null) {
                        this.sampleData = new byte[1024];
                    } else if (bytesRead == bArr.length) {
                        this.sampleData = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    StatsDataSource statsDataSource = this.dataSource;
                    byte[] bArr2 = this.sampleData;
                    i11 = statsDataSource.read(bArr2, bytesRead, bArr2.length - bytesRead);
                }
            } finally {
                Util.closeQuietly((DataSource) this.dataSource);
            }
        }
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec2, DataSource.Factory factory, TransferListener transferListener2, Format format2, long j11, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, boolean z11) {
        this.dataSpec = dataSpec2;
        this.dataSourceFactory = factory;
        this.transferListener = transferListener2;
        this.format = format2;
        this.durationUs = j11;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.eventDispatcher = eventDispatcher2;
        this.treatLoadErrorsAsEndOfStream = z11;
        this.tracks = new TrackGroupArray(new TrackGroup(format2));
    }

    public boolean continueLoading(long j11) {
        if (this.loadingFinished || this.loader.isLoading() || this.loader.hasFatalError()) {
            return false;
        }
        DataSource createDataSource = this.dataSourceFactory.createDataSource();
        TransferListener transferListener2 = this.transferListener;
        if (transferListener2 != null) {
            createDataSource.addTransferListener(transferListener2);
        }
        SourceLoadable sourceLoadable = new SourceLoadable(this.dataSpec, createDataSource);
        this.eventDispatcher.loadStarted(new LoadEventInfo(sourceLoadable.loadTaskId, this.dataSpec, this.loader.startLoading(sourceLoadable, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1))), 1, -1, this.format, 0, (Object) null, 0, this.durationUs);
        return true;
    }

    public void discardBuffer(long j11, boolean z11) {
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        return j11;
    }

    public long getBufferedPositionUs() {
        return this.loadingFinished ? Long.MIN_VALUE : 0;
    }

    public long getNextLoadPositionUs() {
        return (this.loadingFinished || this.loader.isLoading()) ? Long.MIN_VALUE : 0;
    }

    public /* synthetic */ List getStreamKeys(List list) {
        return d.a(this, list);
    }

    public TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    public boolean isLoading() {
        return this.loader.isLoading();
    }

    public void maybeThrowPrepareError() {
    }

    public void prepare(MediaPeriod.Callback callback, long j11) {
        callback.onPrepared(this);
    }

    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long j11) {
    }

    public void release() {
        this.loader.release();
    }

    public long seekToUs(long j11) {
        for (int i11 = 0; i11 < this.sampleStreams.size(); i11++) {
            this.sampleStreams.get(i11).reset();
        }
        return j11;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
        for (int i11 = 0; i11 < exoTrackSelectionArr.length; i11++) {
            if (sampleStreamArr[i11] != null && (exoTrackSelectionArr[i11] == null || !zArr[i11])) {
                this.sampleStreams.remove(sampleStreamArr[i11]);
                sampleStreamArr[i11] = null;
            }
            if (sampleStreamArr[i11] == null && exoTrackSelectionArr[i11] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.sampleStreams.add(sampleStreamImpl);
                sampleStreamArr[i11] = sampleStreamImpl;
                zArr2[i11] = true;
            }
        }
        return j11;
    }

    public void onLoadCanceled(SourceLoadable sourceLoadable, long j11, long j12, boolean z11) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        StatsDataSource access$100 = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.loadTaskId, sourceLoadable2.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j11, j12, access$100.getBytesRead());
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(sourceLoadable2.loadTaskId);
        this.eventDispatcher.loadCanceled(loadEventInfo, 1, -1, (Format) null, 0, (Object) null, 0, this.durationUs);
    }

    public void onLoadCompleted(SourceLoadable sourceLoadable, long j11, long j12) {
        SourceLoadable sourceLoadable2 = sourceLoadable;
        this.sampleSize = (int) sourceLoadable.dataSource.getBytesRead();
        this.sampleData = (byte[]) Assertions.checkNotNull(sourceLoadable.sampleData);
        this.loadingFinished = true;
        StatsDataSource access$100 = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.loadTaskId, sourceLoadable2.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j11, j12, (long) this.sampleSize);
        this.loadErrorHandlingPolicy.onLoadTaskConcluded(sourceLoadable2.loadTaskId);
        this.eventDispatcher.loadCompleted(loadEventInfo, 1, -1, this.format, 0, (Object) null, 0, this.durationUs);
    }

    public Loader.LoadErrorAction onLoadError(SourceLoadable sourceLoadable, long j11, long j12, IOException iOException, int i11) {
        Loader.LoadErrorAction loadErrorAction;
        SourceLoadable sourceLoadable2 = sourceLoadable;
        IOException iOException2 = iOException;
        int i12 = i11;
        StatsDataSource access$100 = sourceLoadable.dataSource;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable2.loadTaskId, sourceLoadable2.dataSpec, access$100.getLastOpenedUri(), access$100.getLastResponseHeaders(), j11, j12, access$100.getBytesRead());
        long retryDelayMsFor = this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(1, -1, this.format, 0, (Object) null, 0, C.usToMs(this.durationUs)), iOException2, i12));
        int i13 = (retryDelayMsFor > -9223372036854775807L ? 1 : (retryDelayMsFor == -9223372036854775807L ? 0 : -1));
        boolean z11 = i13 == 0 || i12 >= this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1);
        if (this.treatLoadErrorsAsEndOfStream && z11) {
            Log.w(TAG, "Loading failed, treating as end-of-stream.", iOException2);
            this.loadingFinished = true;
            loadErrorAction = Loader.DONT_RETRY;
        } else if (i13 != 0) {
            loadErrorAction = Loader.createRetryAction(false, retryDelayMsFor);
        } else {
            loadErrorAction = Loader.DONT_RETRY_FATAL;
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean z12 = !loadErrorAction2.isRetry();
        this.eventDispatcher.loadError(loadEventInfo, 1, -1, this.format, 0, (Object) null, 0, this.durationUs, iOException, z12);
        if (z12) {
            this.loadErrorHandlingPolicy.onLoadTaskConcluded(sourceLoadable2.loadTaskId);
        }
        return loadErrorAction2;
    }
}
