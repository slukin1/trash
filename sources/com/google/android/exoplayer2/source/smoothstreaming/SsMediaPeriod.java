package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class SsMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<SsChunkSource>> {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final SsChunkSource.Factory chunkSourceFactory;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private SsManifest manifest;
    private final LoaderErrorThrower manifestLoaderErrorThrower;
    private final MediaSourceEventListener.EventDispatcher mediaSourceEventDispatcher;
    private ChunkSampleStream<SsChunkSource>[] sampleStreams;
    private final TrackGroupArray trackGroups;
    private final TransferListener transferListener;

    public SsMediaPeriod(SsManifest ssManifest, SsChunkSource.Factory factory, TransferListener transferListener2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, MediaSourceEventListener.EventDispatcher eventDispatcher2, LoaderErrorThrower loaderErrorThrower, Allocator allocator2) {
        this.manifest = ssManifest;
        this.chunkSourceFactory = factory;
        this.transferListener = transferListener2;
        this.manifestLoaderErrorThrower = loaderErrorThrower;
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.mediaSourceEventDispatcher = eventDispatcher2;
        this.allocator = allocator2;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.trackGroups = buildTrackGroups(ssManifest, drmSessionManager2);
        ChunkSampleStream<SsChunkSource>[] newSampleStreamArray = newSampleStreamArray(0);
        this.sampleStreams = newSampleStreamArray;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(newSampleStreamArray);
    }

    private ChunkSampleStream<SsChunkSource> buildSampleStream(ExoTrackSelection exoTrackSelection, long j11) {
        int indexOf = this.trackGroups.indexOf(exoTrackSelection.getTrackGroup());
        return new ChunkSampleStream(this.manifest.streamElements[indexOf].type, (int[]) null, (Format[]) null, this.chunkSourceFactory.createChunkSource(this.manifestLoaderErrorThrower, this.manifest, indexOf, exoTrackSelection, this.transferListener), this, this.allocator, j11, this.drmSessionManager, this.drmEventDispatcher, this.loadErrorHandlingPolicy, this.mediaSourceEventDispatcher);
    }

    private static TrackGroupArray buildTrackGroups(SsManifest ssManifest, DrmSessionManager drmSessionManager2) {
        TrackGroup[] trackGroupArr = new TrackGroup[ssManifest.streamElements.length];
        int i11 = 0;
        while (true) {
            SsManifest.StreamElement[] streamElementArr = ssManifest.streamElements;
            if (i11 >= streamElementArr.length) {
                return new TrackGroupArray(trackGroupArr);
            }
            Format[] formatArr = streamElementArr[i11].formats;
            Format[] formatArr2 = new Format[formatArr.length];
            for (int i12 = 0; i12 < formatArr.length; i12++) {
                Format format = formatArr[i12];
                formatArr2[i12] = format.copyWithExoMediaCryptoType(drmSessionManager2.getExoMediaCryptoType(format));
            }
            trackGroupArr[i11] = new TrackGroup(formatArr2);
            i11++;
        }
    }

    private static ChunkSampleStream<SsChunkSource>[] newSampleStreamArray(int i11) {
        return new ChunkSampleStream[i11];
    }

    public boolean continueLoading(long j11) {
        return this.compositeSequenceableLoader.continueLoading(j11);
    }

    public void discardBuffer(long j11, boolean z11) {
        for (ChunkSampleStream<SsChunkSource> discardBuffer : this.sampleStreams) {
            discardBuffer.discardBuffer(j11, z11);
        }
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.sampleStreams) {
            if (chunkSampleStream.primaryTrackType == 2) {
                return chunkSampleStream.getAdjustedSeekPositionUs(j11, seekParameters);
            }
        }
        return j11;
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            ExoTrackSelection exoTrackSelection = list.get(i11);
            int indexOf = this.trackGroups.indexOf(exoTrackSelection.getTrackGroup());
            for (int i12 = 0; i12 < exoTrackSelection.length(); i12++) {
                arrayList.add(new StreamKey(indexOf, exoTrackSelection.getIndexInTrackGroup(i12)));
            }
        }
        return arrayList;
    }

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() throws IOException {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public void prepare(MediaPeriod.Callback callback2, long j11) {
        this.callback = callback2;
        callback2.onPrepared(this);
    }

    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void reevaluateBuffer(long j11) {
        this.compositeSequenceableLoader.reevaluateBuffer(j11);
    }

    public void release() {
        for (ChunkSampleStream<SsChunkSource> release : this.sampleStreams) {
            release.release();
        }
        this.callback = null;
    }

    public long seekToUs(long j11) {
        for (ChunkSampleStream<SsChunkSource> seekToUs : this.sampleStreams) {
            seekToUs.seekToUs(j11);
        }
        return j11;
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < exoTrackSelectionArr.length; i11++) {
            if (sampleStreamArr[i11] != null) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i11];
                if (exoTrackSelectionArr[i11] == null || !zArr[i11]) {
                    chunkSampleStream.release();
                    sampleStreamArr[i11] = null;
                } else {
                    ((SsChunkSource) chunkSampleStream.getChunkSource()).updateTrackSelection(exoTrackSelectionArr[i11]);
                    arrayList.add(chunkSampleStream);
                }
            }
            if (sampleStreamArr[i11] == null && exoTrackSelectionArr[i11] != null) {
                ChunkSampleStream<SsChunkSource> buildSampleStream = buildSampleStream(exoTrackSelectionArr[i11], j11);
                arrayList.add(buildSampleStream);
                sampleStreamArr[i11] = buildSampleStream;
                zArr2[i11] = true;
            }
        }
        ChunkSampleStream<SsChunkSource>[] newSampleStreamArray = newSampleStreamArray(arrayList.size());
        this.sampleStreams = newSampleStreamArray;
        arrayList.toArray(newSampleStreamArray);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.sampleStreams);
        return j11;
    }

    public void updateManifest(SsManifest ssManifest) {
        this.manifest = ssManifest;
        for (ChunkSampleStream<SsChunkSource> chunkSource : this.sampleStreams) {
            chunkSource.getChunkSource().updateManifest(ssManifest);
        }
        this.callback.onContinueLoadingRequested(this);
    }

    public void onContinueLoadingRequested(ChunkSampleStream<SsChunkSource> chunkSampleStream) {
        this.callback.onContinueLoadingRequested(this);
    }
}
