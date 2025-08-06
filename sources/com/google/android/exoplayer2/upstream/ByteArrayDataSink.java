package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ByteArrayDataSink implements DataSink {
    private ByteArrayOutputStream stream;

    public void close() throws IOException {
        ((ByteArrayOutputStream) Util.castNonNull(this.stream)).close();
    }

    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.stream;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void open(DataSpec dataSpec) {
        long j11 = dataSpec.length;
        if (j11 == -1) {
            this.stream = new ByteArrayOutputStream();
            return;
        }
        Assertions.checkArgument(j11 <= 2147483647L);
        this.stream = new ByteArrayOutputStream((int) dataSpec.length);
    }

    public void write(byte[] bArr, int i11, int i12) {
        ((ByteArrayOutputStream) Util.castNonNull(this.stream)).write(bArr, i11, i12);
    }
}
