package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private final ArrayList<MediaPeriod> childrenPendingPreparation = new ArrayList<>();
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    private final MediaPeriod[] periods;
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices;
    private TrackGroupArray trackGroups;

    public static final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        private MediaPeriod.Callback callback;
        /* access modifiers changed from: private */
        public final MediaPeriod mediaPeriod;
        private final long timeOffsetUs;

        public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod2, long j11) {
            this.mediaPeriod = mediaPeriod2;
            this.timeOffsetUs = j11;
        }

        public boolean continueLoading(long j11) {
            return this.mediaPeriod.continueLoading(j11 - this.timeOffsetUs);
        }

        public void discardBuffer(long j11, boolean z11) {
            this.mediaPeriod.discardBuffer(j11 - this.timeOffsetUs, z11);
        }

        public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
            return this.mediaPeriod.getAdjustedSeekPositionUs(j11 - this.timeOffsetUs, seekParameters) + this.timeOffsetUs;
        }

        public long getBufferedPositionUs() {
            long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
            if (bufferedPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.timeOffsetUs + bufferedPositionUs;
        }

        public long getNextLoadPositionUs() {
            long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.timeOffsetUs + nextLoadPositionUs;
        }

        public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
            return this.mediaPeriod.getStreamKeys(list);
        }

        public TrackGroupArray getTrackGroups() {
            return this.mediaPeriod.getTrackGroups();
        }

        public boolean isLoading() {
            return this.mediaPeriod.isLoading();
        }

        public void maybeThrowPrepareError() throws IOException {
            this.mediaPeriod.maybeThrowPrepareError();
        }

        public void onPrepared(MediaPeriod mediaPeriod2) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }

        public void prepare(MediaPeriod.Callback callback2, long j11) {
            this.callback = callback2;
            this.mediaPeriod.prepare(this, j11 - this.timeOffsetUs);
        }

        public long readDiscontinuity() {
            long readDiscontinuity = this.mediaPeriod.readDiscontinuity();
            if (readDiscontinuity == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.timeOffsetUs + readDiscontinuity;
        }

        public void reevaluateBuffer(long j11) {
            this.mediaPeriod.reevaluateBuffer(j11 - this.timeOffsetUs);
        }

        public long seekToUs(long j11) {
            return this.mediaPeriod.seekToUs(j11 - this.timeOffsetUs) + this.timeOffsetUs;
        }

        public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
            SampleStream[] sampleStreamArr2 = sampleStreamArr;
            SampleStream[] sampleStreamArr3 = new SampleStream[sampleStreamArr2.length];
            int i11 = 0;
            while (true) {
                SampleStream sampleStream = null;
                if (i11 >= sampleStreamArr2.length) {
                    break;
                }
                TimeOffsetSampleStream timeOffsetSampleStream = (TimeOffsetSampleStream) sampleStreamArr2[i11];
                if (timeOffsetSampleStream != null) {
                    sampleStream = timeOffsetSampleStream.getChildStream();
                }
                sampleStreamArr3[i11] = sampleStream;
                i11++;
            }
            long selectTracks = this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, j11 - this.timeOffsetUs);
            for (int i12 = 0; i12 < sampleStreamArr2.length; i12++) {
                SampleStream sampleStream2 = sampleStreamArr3[i12];
                if (sampleStream2 == null) {
                    sampleStreamArr2[i12] = null;
                } else if (sampleStreamArr2[i12] == null || ((TimeOffsetSampleStream) sampleStreamArr2[i12]).getChildStream() != sampleStream2) {
                    sampleStreamArr2[i12] = new TimeOffsetSampleStream(sampleStream2, this.timeOffsetUs);
                }
            }
            return selectTracks + this.timeOffsetUs;
        }

        public void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    public static final class TimeOffsetSampleStream implements SampleStream {
        private final SampleStream sampleStream;
        private final long timeOffsetUs;

        public TimeOffsetSampleStream(SampleStream sampleStream2, long j11) {
            this.sampleStream = sampleStream2;
            this.timeOffsetUs = j11;
        }

        public SampleStream getChildStream() {
            return this.sampleStream;
        }

        public boolean isReady() {
            return this.sampleStream.isReady();
        }

        public void maybeThrowError() throws IOException {
            this.sampleStream.maybeThrowError();
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
            int readData = this.sampleStream.readData(formatHolder, decoderInputBuffer, i11);
            if (readData == -4) {
                decoderInputBuffer.timeUs = Math.max(0, decoderInputBuffer.timeUs + this.timeOffsetUs);
            }
            return readData;
        }

        public int skipData(long j11) {
            return this.sampleStream.skipData(j11 - this.timeOffsetUs);
        }
    }

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory2.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamPeriodIndices = new IdentityHashMap<>();
        this.enabledPeriods = new MediaPeriod[0];
        for (int i11 = 0; i11 < mediaPeriodArr.length; i11++) {
            if (jArr[i11] != 0) {
                this.periods[i11] = new TimeOffsetMediaPeriod(mediaPeriodArr[i11], jArr[i11]);
            }
        }
    }

    public boolean continueLoading(long j11) {
        if (this.childrenPendingPreparation.isEmpty()) {
            return this.compositeSequenceableLoader.continueLoading(j11);
        }
        int size = this.childrenPendingPreparation.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.childrenPendingPreparation.get(i11).continueLoading(j11);
        }
        return false;
    }

    public void discardBuffer(long j11, boolean z11) {
        for (MediaPeriod discardBuffer : this.enabledPeriods) {
            discardBuffer.discardBuffer(j11, z11);
        }
    }

    public long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters) {
        MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.periods[0]).getAdjustedSeekPositionUs(j11, seekParameters);
    }

    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    public MediaPeriod getChildPeriod(int i11) {
        MediaPeriod[] mediaPeriodArr = this.periods;
        if (mediaPeriodArr[i11] instanceof TimeOffsetMediaPeriod) {
            return ((TimeOffsetMediaPeriod) mediaPeriodArr[i11]).mediaPeriod;
        }
        return mediaPeriodArr[i11];
    }

    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    public /* synthetic */ List getStreamKeys(List list) {
        return d.a(this, list);
    }

    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray) Assertions.checkNotNull(this.trackGroups);
    }

    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    public void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod maybeThrowPrepareError : this.periods) {
            maybeThrowPrepareError.maybeThrowPrepareError();
        }
    }

    public void onPrepared(MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (this.childrenPendingPreparation.isEmpty()) {
            int i11 = 0;
            for (MediaPeriod trackGroups2 : this.periods) {
                i11 += trackGroups2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i11];
            int i12 = 0;
            for (MediaPeriod trackGroups3 : this.periods) {
                TrackGroupArray trackGroups4 = trackGroups3.getTrackGroups();
                int i13 = trackGroups4.length;
                int i14 = 0;
                while (i14 < i13) {
                    trackGroupArr[i12] = trackGroups4.get(i14);
                    i14++;
                    i12++;
                }
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
        }
    }

    public void prepare(MediaPeriod.Callback callback2, long j11) {
        this.callback = callback2;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (MediaPeriod prepare : this.periods) {
            prepare.prepare(this, j11);
        }
    }

    public long readDiscontinuity() {
        long j11 = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            long readDiscontinuity = mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != -9223372036854775807L) {
                if (j11 == -9223372036854775807L) {
                    MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
                    int length = mediaPeriodArr.length;
                    int i11 = 0;
                    while (i11 < length) {
                        MediaPeriod mediaPeriod2 = mediaPeriodArr[i11];
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        } else if (mediaPeriod2.seekToUs(readDiscontinuity) == readDiscontinuity) {
                            i11++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j11 = readDiscontinuity;
                } else if (readDiscontinuity != j11) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j11 == -9223372036854775807L || mediaPeriod.seekToUs(j11) == j11)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j11;
    }

    public void reevaluateBuffer(long j11) {
        this.compositeSequenceableLoader.reevaluateBuffer(j11);
    }

    public long seekToUs(long j11) {
        long seekToUs = this.enabledPeriods[0].seekToUs(j11);
        int i11 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i11 >= mediaPeriodArr.length) {
                return seekToUs;
            }
            if (mediaPeriodArr[i11].seekToUs(seekToUs) == seekToUs) {
                i11++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11) {
        int i11;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        for (int i12 = 0; i12 < exoTrackSelectionArr2.length; i12++) {
            Integer num = sampleStreamArr2[i12] == null ? null : this.streamPeriodIndices.get(sampleStreamArr2[i12]);
            if (num == null) {
                i11 = -1;
            } else {
                i11 = num.intValue();
            }
            iArr[i12] = i11;
            iArr2[i12] = -1;
            if (exoTrackSelectionArr2[i12] != null) {
                TrackGroup trackGroup = exoTrackSelectionArr2[i12].getTrackGroup();
                int i13 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i13 >= mediaPeriodArr.length) {
                        break;
                    } else if (mediaPeriodArr[i13].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i12] = i13;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
        }
        this.streamPeriodIndices.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j12 = j11;
        int i14 = 0;
        while (i14 < this.periods.length) {
            for (int i15 = 0; i15 < exoTrackSelectionArr2.length; i15++) {
                sampleStreamArr4[i15] = iArr[i15] == i14 ? sampleStreamArr2[i15] : null;
                exoTrackSelectionArr3[i15] = iArr2[i15] == i14 ? exoTrackSelectionArr2[i15] : null;
            }
            int i16 = i14;
            ArrayList arrayList2 = arrayList;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            long selectTracks = this.periods[i14].selectTracks(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j12);
            if (i16 == 0) {
                j12 = selectTracks;
            } else if (selectTracks != j12) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z11 = false;
            for (int i17 = 0; i17 < exoTrackSelectionArr2.length; i17++) {
                boolean z12 = true;
                if (iArr2[i17] == i16) {
                    sampleStreamArr3[i17] = sampleStreamArr4[i17];
                    this.streamPeriodIndices.put((SampleStream) Assertions.checkNotNull(sampleStreamArr4[i17]), Integer.valueOf(i16));
                    z11 = true;
                } else if (iArr[i17] == i16) {
                    if (sampleStreamArr4[i17] != null) {
                        z12 = false;
                    }
                    Assertions.checkState(z12);
                }
            }
            if (z11) {
                arrayList2.add(this.periods[i16]);
            }
            i14 = i16 + 1;
            arrayList = arrayList2;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        MediaPeriod[] mediaPeriodArr2 = (MediaPeriod[]) arrayList.toArray(new MediaPeriod[0]);
        this.enabledPeriods = mediaPeriodArr2;
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(mediaPeriodArr2);
        return j12;
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }
}
