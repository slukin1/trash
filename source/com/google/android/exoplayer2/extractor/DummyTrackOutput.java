package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

public final class DummyTrackOutput implements TrackOutput {
    private final byte[] readBuffer = new byte[4096];

    public void format(Format format) {
    }

    public /* synthetic */ int sampleData(DataReader dataReader, int i11, boolean z11) {
        return d.a(this, dataReader, i11, z11);
    }

    public int sampleData(DataReader dataReader, int i11, boolean z11, int i12) throws IOException {
        int read = dataReader.read(this.readBuffer, 0, Math.min(this.readBuffer.length, i11));
        if (read != -1) {
            return read;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i11) {
        d.b(this, parsableByteArray, i11);
    }

    public void sampleMetadata(long j11, int i11, int i12, int i13, TrackOutput.CryptoData cryptoData) {
    }

    public void sampleData(ParsableByteArray parsableByteArray, int i11, int i12) {
        parsableByteArray.skipBytes(i11);
    }
}
