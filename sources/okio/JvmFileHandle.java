package okio;

import java.io.RandomAccessFile;

public final class JvmFileHandle extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    public JvmFileHandle(boolean z11, RandomAccessFile randomAccessFile2) {
        super(z11);
        this.randomAccessFile = randomAccessFile2;
    }

    public synchronized void protectedClose() {
        this.randomAccessFile.close();
    }

    public synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int protectedRead(long r2, byte[] r4, int r5, int r6) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.io.RandomAccessFile r0 = r1.randomAccessFile     // Catch:{ all -> 0x001c }
            r0.seek(r2)     // Catch:{ all -> 0x001c }
            r2 = 0
        L_0x0007:
            if (r2 >= r6) goto L_0x001a
            java.io.RandomAccessFile r3 = r1.randomAccessFile     // Catch:{ all -> 0x001c }
            int r0 = r6 - r2
            int r3 = r3.read(r4, r5, r0)     // Catch:{ all -> 0x001c }
            r0 = -1
            if (r3 != r0) goto L_0x0018
            if (r2 != 0) goto L_0x001a
            monitor-exit(r1)
            return r0
        L_0x0018:
            int r2 = r2 + r3
            goto L_0x0007
        L_0x001a:
            monitor-exit(r1)
            return r2
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.JvmFileHandle.protectedRead(long, byte[], int, int):int");
    }

    public synchronized void protectedResize(long j11) {
        long size = size();
        long j12 = j11 - size;
        if (j12 > 0) {
            int i11 = (int) j12;
            protectedWrite(size, new byte[i11], 0, i11);
        } else {
            this.randomAccessFile.setLength(j11);
        }
    }

    public synchronized long protectedSize() {
        return this.randomAccessFile.length();
    }

    public synchronized void protectedWrite(long j11, byte[] bArr, int i11, int i12) {
        this.randomAccessFile.seek(j11);
        this.randomAccessFile.write(bArr, i11, i12);
    }
}
