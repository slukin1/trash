package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface DataSink {

    public interface Factory {
        DataSink createDataSink();
    }

    void close() throws IOException;

    void open(DataSpec dataSpec) throws IOException;

    void write(byte[] bArr, int i11, int i12) throws IOException;
}
