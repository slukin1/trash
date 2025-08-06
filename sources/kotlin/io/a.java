package kotlin.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class a {
    public static final long a(InputStream inputStream, OutputStream outputStream, int i11) {
        byte[] bArr = new byte[i11];
        int read = inputStream.read(bArr);
        long j11 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j11 += (long) read;
            read = inputStream.read(bArr);
        }
        return j11;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 8192;
        }
        return a(inputStream, outputStream, i11);
    }

    public static final byte[] c(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, (Object) null);
        return byteArrayOutputStream.toByteArray();
    }
}
