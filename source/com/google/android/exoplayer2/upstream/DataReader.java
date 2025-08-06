package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public interface DataReader {
    int read(byte[] bArr, int i11, int i12) throws IOException;
}
