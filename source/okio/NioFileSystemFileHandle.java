package okio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class NioFileSystemFileHandle extends FileHandle {
    private final FileChannel fileChannel;

    public NioFileSystemFileHandle(boolean z11, FileChannel fileChannel2) {
        super(z11);
        this.fileChannel = fileChannel2;
    }

    public synchronized void protectedClose() {
        this.fileChannel.close();
    }

    public synchronized void protectedFlush() {
        this.fileChannel.force(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int protectedRead(long r2, byte[] r4, int r5, int r6) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.nio.channels.FileChannel r0 = r1.fileChannel     // Catch:{ all -> 0x001e }
            r0.position(r2)     // Catch:{ all -> 0x001e }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r4, r5, r6)     // Catch:{ all -> 0x001e }
            r3 = 0
        L_0x000b:
            if (r3 >= r6) goto L_0x001c
            java.nio.channels.FileChannel r4 = r1.fileChannel     // Catch:{ all -> 0x001e }
            int r4 = r4.read(r2)     // Catch:{ all -> 0x001e }
            r5 = -1
            if (r4 != r5) goto L_0x001a
            if (r3 != 0) goto L_0x001c
            monitor-exit(r1)
            return r5
        L_0x001a:
            int r3 = r3 + r4
            goto L_0x000b
        L_0x001c:
            monitor-exit(r1)
            return r3
        L_0x001e:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.NioFileSystemFileHandle.protectedRead(long, byte[], int, int):int");
    }

    public synchronized void protectedResize(long j11) {
        long size = size();
        long j12 = j11 - size;
        if (j12 > 0) {
            int i11 = (int) j12;
            protectedWrite(size, new byte[i11], 0, i11);
        } else {
            this.fileChannel.truncate(j11);
        }
    }

    public synchronized long protectedSize() {
        return this.fileChannel.size();
    }

    public synchronized void protectedWrite(long j11, byte[] bArr, int i11, int i12) {
        this.fileChannel.position(j11);
        this.fileChannel.write(ByteBuffer.wrap(bArr, i11, i12));
    }
}
