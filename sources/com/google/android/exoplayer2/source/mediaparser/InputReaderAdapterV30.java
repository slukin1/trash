package com.google.android.exoplayer2.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

@SuppressLint({"Override"})
public final class InputReaderAdapterV30 implements MediaParser.SeekableInputReader {
    private long currentPosition;
    private DataReader dataReader;
    private long lastSeekPosition;
    private long resourceLength;

    public long getAndResetSeekPosition() {
        long j11 = this.lastSeekPosition;
        this.lastSeekPosition = -1;
        return j11;
    }

    public long getLength() {
        return this.resourceLength;
    }

    public long getPosition() {
        return this.currentPosition;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = ((DataReader) Util.castNonNull(this.dataReader)).read(bArr, i11, i12);
        this.currentPosition += (long) read;
        return read;
    }

    public void seekToPosition(long j11) {
        this.lastSeekPosition = j11;
    }

    public void setCurrentPosition(long j11) {
        this.currentPosition = j11;
    }

    public void setDataReader(DataReader dataReader2, long j11) {
        this.dataReader = dataReader2;
        this.resourceLength = j11;
        this.lastSeekPosition = -1;
    }
}
