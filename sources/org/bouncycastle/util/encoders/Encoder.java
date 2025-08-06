package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public interface Encoder {
    int decode(String str, OutputStream outputStream) throws IOException;

    int decode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException;

    int encode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException;

    int getEncodedLength(int i11);

    int getMaxDecodedLength(int i11);
}
