package okio;

import java.io.Closeable;
import java.io.IOException;

public interface Source extends Closeable {
    void close() throws IOException;

    long read(Buffer buffer, long j11) throws IOException;

    Timeout timeout();
}
