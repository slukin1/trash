package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;

public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel2) {
        this.fileChannel = fileChannel2;
    }

    public final void read(long j11, Buffer buffer, long j12) {
        if (j12 >= 0) {
            while (j12 > 0) {
                long transferTo = this.fileChannel.transferTo(j11, j12, buffer);
                j11 += transferTo;
                j12 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long j11, Buffer buffer, long j12) throws IOException {
        if (j12 < 0 || j12 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (j12 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j11, j12);
            j11 += transferFrom;
            j12 -= transferFrom;
        }
    }
}
