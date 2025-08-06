package y5;

import java.io.IOException;
import java.io.InputStream;

public interface a {
    InputStream a() throws IOException;

    int available() throws IOException;

    int b();

    void close() throws IOException;

    byte peek() throws IOException;

    int read(byte[] bArr, int i11, int i12) throws IOException;

    void reset() throws IOException;

    long skip(long j11) throws IOException;
}
