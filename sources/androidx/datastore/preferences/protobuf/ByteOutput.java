package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class ByteOutput {
    public abstract void a(ByteBuffer byteBuffer) throws IOException;

    public abstract void b(byte[] bArr, int i11, int i12) throws IOException;
}
