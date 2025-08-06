package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final /* synthetic */ class d {
    public static int a(TrackOutput trackOutput, DataReader dataReader, int i11, boolean z11) throws IOException {
        return trackOutput.sampleData(dataReader, i11, z11, 0);
    }

    public static void b(TrackOutput trackOutput, ParsableByteArray parsableByteArray, int i11) {
        trackOutput.sampleData(parsableByteArray, i11, 0);
    }
}
