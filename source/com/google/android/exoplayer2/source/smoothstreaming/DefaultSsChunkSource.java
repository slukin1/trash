package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.List;

public class DefaultSsChunkSource implements SsChunkSource {
    private final ChunkExtractor[] chunkExtractors;
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private IOException fatalError;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final int streamElementIndex;
    private ExoTrackSelection trackSelection;

    public static final class Factory implements SsChunkSource.Factory {
        private final DataSource.Factory dataSourceFactory;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        public SsChunkSource createChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i11, ExoTrackSelection exoTrackSelection, TransferListener transferListener) {
            DataSource createDataSource = this.dataSourceFactory.createDataSource();
            if (transferListener != null) {
                createDataSource.addTransferListener(transferListener);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i11, exoTrackSelection, createDataSource);
        }
    }

    public static final class StreamElementIterator extends BaseMediaChunkIterator {
        private final SsManifest.StreamElement streamElement;
        private final int trackIndex;

        public StreamElementIterator(SsManifest.StreamElement streamElement2, int i11, int i12) {
            super((long) i12, (long) (streamElement2.chunkCount - 1));
            this.streamElement = streamElement2;
            this.trackIndex = i11;
        }

        public long getChunkEndTimeUs() {
            return getChunkStartTimeUs() + this.streamElement.getChunkDurationUs((int) getCurrentIndex());
        }

        public long getChunkStartTimeUs() {
            checkInBounds();
            return this.streamElement.getStartTimeUs((int) getCurrentIndex());
        }

        public DataSpec getDataSpec() {
            checkInBounds();
            return new DataSpec(this.streamElement.buildRequestUri(this.trackIndex, (int) getCurrentIndex()));
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i11, ExoTrackSelection exoTrackSelection, DataSource dataSource2) {
        SsManifest ssManifest2 = ssManifest;
        int i12 = i11;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.manifest = ssManifest2;
        this.streamElementIndex = i12;
        this.trackSelection = exoTrackSelection2;
        this.dataSource = dataSource2;
        SsManifest.StreamElement streamElement = ssManifest2.streamElements[i12];
        this.chunkExtractors = new ChunkExtractor[exoTrackSelection.length()];
        int i13 = 0;
        while (i13 < this.chunkExtractors.length) {
            int indexInTrackGroup = exoTrackSelection2.getIndexInTrackGroup(i13);
            Format format = streamElement.formats[indexInTrackGroup];
            TrackEncryptionBox[] trackEncryptionBoxArr = format.drmInitData != null ? ((SsManifest.ProtectionElement) Assertions.checkNotNull(ssManifest2.protectionElement)).trackEncryptionBoxes : null;
            int i14 = streamElement.type;
            int i15 = i13;
            Track track = r7;
            Track track2 = new Track(indexInTrackGroup, i14, streamElement.timescale, -9223372036854775807L, ssManifest2.durationUs, format, 0, trackEncryptionBoxArr, i14 == 2 ? 4 : 0, (long[]) null, (long[]) null);
            this.chunkExtractors[i15] = new BundledChunkExtractor(new FragmentedMp4Extractor(3, (TimestampAdjuster) null, track), streamElement.type, format);
            i13 = i15 + 1;
        }
    }

    private static MediaChunk newMediaChunk(Format format, DataSource dataSource2, Uri uri, int i11, long j11, long j12, long j13, int i12, Object obj, ChunkExtractor chunkExtractor) {
        DataSource dataSource3 = dataSource2;
        long j14 = j12;
        long j15 = j13;
        int i13 = i12;
        Object obj2 = obj;
        DataSpec dataSpec = r0;
        DataSpec dataSpec2 = new DataSpec(uri);
        return new ContainerMediaChunk(dataSource3, dataSpec, format, i13, obj2, j11, j14, j15, -9223372036854775807L, (long) i11, 1, j11, chunkExtractor);
    }

    private long resolveTimeToLiveEdgeUs(long j11) {
        SsManifest ssManifest = this.manifest;
        if (!ssManifest.isLive) {
            return -9223372036854775807L;
        }
        SsManifest.StreamElement streamElement = ssManifest.streamElements[this.streamElementIndex];
        int i11 = streamElement.chunkCount - 1;
        return (streamElement.getStartTimeUs(i11) + streamElement.getChunkDurationUs(i11)) - j11;
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        SsManifest.StreamElement streamElement = this.manifest.streamElements[this.streamElementIndex];
        int chunkIndex = streamElement.getChunkIndex(j11);
        long startTimeUs = streamElement.getStartTimeUs(chunkIndex);
        return seekParameters.resolveSeekPositionUs(j11, startTimeUs, (startTimeUs >= j11 || chunkIndex >= streamElement.chunkCount + -1) ? startTimeUs : streamElement.getStartTimeUs(chunkIndex + 1));
    }

    public final void getNextChunk(long j11, long j12, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int i11;
        long j13 = j12;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.fatalError == null) {
            SsManifest ssManifest = this.manifest;
            SsManifest.StreamElement streamElement = ssManifest.streamElements[this.streamElementIndex];
            if (streamElement.chunkCount == 0) {
                chunkHolder2.endOfStream = !ssManifest.isLive;
                return;
            }
            if (list.isEmpty()) {
                i11 = streamElement.getChunkIndex(j13);
                List<? extends MediaChunk> list2 = list;
            } else {
                i11 = (int) (((MediaChunk) list.get(list.size() - 1)).getNextChunkIndex() - ((long) this.currentManifestChunkOffset));
                if (i11 < 0) {
                    this.fatalError = new BehindLiveWindowException();
                    return;
                }
            }
            if (i11 >= streamElement.chunkCount) {
                chunkHolder2.endOfStream = !this.manifest.isLive;
                return;
            }
            long j14 = j13 - j11;
            long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j11);
            int length = this.trackSelection.length();
            MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
            for (int i12 = 0; i12 < length; i12++) {
                mediaChunkIteratorArr[i12] = new StreamElementIterator(streamElement, this.trackSelection.getIndexInTrackGroup(i12), i11);
            }
            this.trackSelection.updateSelectedTrack(j11, j14, resolveTimeToLiveEdgeUs, list, mediaChunkIteratorArr);
            long startTimeUs = streamElement.getStartTimeUs(i11);
            long chunkDurationUs = startTimeUs + streamElement.getChunkDurationUs(i11);
            if (!list.isEmpty()) {
                j13 = -9223372036854775807L;
            }
            long j15 = j13;
            int i13 = i11 + this.currentManifestChunkOffset;
            int selectedIndex = this.trackSelection.getSelectedIndex();
            ChunkExtractor chunkExtractor = this.chunkExtractors[selectedIndex];
            Uri buildRequestUri = streamElement.buildRequestUri(this.trackSelection.getIndexInTrackGroup(selectedIndex), i11);
            chunkHolder2.chunk = newMediaChunk(this.trackSelection.getSelectedFormat(), this.dataSource, buildRequestUri, i13, startTimeUs, chunkDurationUs, j15, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), chunkExtractor);
        }
    }

    public int getPreferredQueueSize(long j11, List<? extends MediaChunk> list) {
        if (this.fatalError != null || this.trackSelection.length() < 2) {
            return list.size();
        }
        return this.trackSelection.evaluateQueueSize(j11, list);
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            this.manifestLoaderErrorThrower.maybeThrowError();
            return;
        }
        throw iOException;
    }

    public void onChunkLoadCompleted(Chunk chunk) {
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z11, Exception exc, long j11) {
        if (z11 && j11 != -9223372036854775807L) {
            ExoTrackSelection exoTrackSelection = this.trackSelection;
            if (exoTrackSelection.blacklist(exoTrackSelection.indexOf(chunk.trackFormat), j11)) {
                return true;
            }
        }
        return false;
    }

    public void release() {
        for (ChunkExtractor release : this.chunkExtractors) {
            release.release();
        }
    }

    public boolean shouldCancelLoad(long j11, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.fatalError != null) {
            return false;
        }
        return this.trackSelection.shouldCancelChunkLoad(j11, chunk, list);
    }

    public void updateManifest(SsManifest ssManifest) {
        SsManifest.StreamElement[] streamElementArr = this.manifest.streamElements;
        int i11 = this.streamElementIndex;
        SsManifest.StreamElement streamElement = streamElementArr[i11];
        int i12 = streamElement.chunkCount;
        SsManifest.StreamElement streamElement2 = ssManifest.streamElements[i11];
        if (i12 == 0 || streamElement2.chunkCount == 0) {
            this.currentManifestChunkOffset += i12;
        } else {
            int i13 = i12 - 1;
            long startTimeUs = streamElement.getStartTimeUs(i13) + streamElement.getChunkDurationUs(i13);
            long startTimeUs2 = streamElement2.getStartTimeUs(0);
            if (startTimeUs <= startTimeUs2) {
                this.currentManifestChunkOffset += i12;
            } else {
                this.currentManifestChunkOffset += streamElement.getChunkIndex(startTimeUs2);
            }
        }
        this.manifest = ssManifest;
    }

    public void updateTrackSelection(ExoTrackSelection exoTrackSelection) {
        this.trackSelection = exoTrackSelection;
    }
}
