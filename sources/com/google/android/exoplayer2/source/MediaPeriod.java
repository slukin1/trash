package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.List;

public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    boolean continueLoading(long j11);

    void discardBuffer(long j11, boolean z11);

    long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    List<StreamKey> getStreamKeys(List<ExoTrackSelection> list);

    TrackGroupArray getTrackGroups();

    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    void prepare(Callback callback, long j11);

    long readDiscontinuity();

    void reevaluateBuffer(long j11);

    long seekToUs(long j11);

    long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j11);
}
