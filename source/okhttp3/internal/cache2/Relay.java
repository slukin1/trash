package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Relay {
    public static final Companion Companion = new Companion((r) null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN;
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final Relay edit(File file, Source source, ByteString byteString, long j11) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, source, 0, byteString, j11, (r) null);
            randomAccessFile.setLength(0);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1, -1);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
            Buffer buffer = new Buffer();
            fileOperator.read(0, buffer, 32);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (x.b(buffer.readByteString((long) byteString.size()), byteString)) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(readLong + 32, buffer2, readLong2);
                return new Relay(randomAccessFile, (Source) null, readLong, buffer2.readByteString(), 0, (r) null);
            }
            throw new IOException("unreadable cache file");
        }
    }

    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.getFile().getChannel());
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                Relay relay = Relay.this;
                synchronized (relay) {
                    relay.setSourceCount(relay.getSourceCount() - 1);
                    if (relay.getSourceCount() == 0) {
                        RandomAccessFile file = relay.getFile();
                        relay.setFile((RandomAccessFile) null);
                        randomAccessFile = file;
                    }
                    Unit unit = Unit.f56620a;
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
            r9 = r5.getUpstreamPos() - r5.getBuffer().size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
            if (r1.sourcePos >= r9) goto L_0x0135;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
            if (r4 != true) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
            r2 = java.lang.Math.min(r2, r1.this$0.getUpstreamPos() - r1.sourcePos);
            r1.fileOperator.read(r1.sourcePos + 32, r20, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r5 = r1.this$0.getUpstream().read(r1.this$0.getUpstreamBuffer(), r1.this$0.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008b, code lost:
            if (r5 != -1) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
            r0 = r1.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0096, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0098, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            r2.notifyAll();
            r0 = kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a1, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r2 = java.lang.Math.min(r5, r2);
            r1.this$0.getUpstreamBuffer().copyTo(r20, 0, r2);
            r1.sourcePos += r2;
            r1.fileOperator.write(r1.this$0.getUpstreamPos() + 32, r1.this$0.getUpstreamBuffer().clone(), r5);
            r7 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d8, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r7.getBuffer().write(r7.getUpstreamBuffer(), r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f2, code lost:
            if (r7.getBuffer().size() <= r7.getBufferMaxSize()) goto L_0x0108;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f4, code lost:
            r7.getBuffer().skip(r7.getBuffer().size() - r7.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0108, code lost:
            r7.setUpstreamPos(r7.getUpstreamPos() + r5);
            r0 = kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0113, code lost:
            r5 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0115, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
            r5.setUpstreamReader((java.lang.Thread) null);
            r5.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x011c, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x011d, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0124, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0125, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0127, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            r2.notifyAll();
            r3 = kotlin.Unit.f56620a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0131, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            r2 = java.lang.Math.min(r2, r5.getUpstreamPos() - r1.sourcePos);
            r5.getBuffer().copyTo(r20, r1.sourcePos - r9, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0154, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r20, long r21) throws java.io.IOException {
            /*
                r19 = this;
                r1 = r19
                r2 = r21
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                r4 = 1
                if (r0 == 0) goto L_0x000b
                r0 = r4
                goto L_0x000c
            L_0x000b:
                r0 = 0
            L_0x000c:
                if (r0 == 0) goto L_0x0158
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r5)
            L_0x0011:
                long r6 = r5.getUpstreamPos()     // Catch:{ all -> 0x0155 }
                long r8 = r1.sourcePos     // Catch:{ all -> 0x0155 }
                int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                r6 = 2
                r7 = -1
                if (r0 != 0) goto L_0x003a
                boolean r0 = r5.getComplete()     // Catch:{ all -> 0x0155 }
                if (r0 == 0) goto L_0x0026
                monitor-exit(r5)
                return r7
            L_0x0026:
                java.lang.Thread r0 = r5.getUpstreamReader()     // Catch:{ all -> 0x0155 }
                if (r0 == 0) goto L_0x0032
                okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x0155 }
                r0.waitUntilNotified(r5)     // Catch:{ all -> 0x0155 }
                goto L_0x0011
            L_0x0032:
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0155 }
                r5.setUpstreamReader(r0)     // Catch:{ all -> 0x0155 }
                goto L_0x004e
            L_0x003a:
                long r9 = r5.getUpstreamPos()     // Catch:{ all -> 0x0155 }
                okio.Buffer r0 = r5.getBuffer()     // Catch:{ all -> 0x0155 }
                long r11 = r0.size()     // Catch:{ all -> 0x0155 }
                long r9 = r9 - r11
                long r11 = r1.sourcePos     // Catch:{ all -> 0x0155 }
                int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r0 >= 0) goto L_0x0135
                r4 = r6
            L_0x004e:
                monitor-exit(r5)
                r9 = 32
                if (r4 != r6) goto L_0x0072
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this
                long r4 = r0.getUpstreamPos()
                long r6 = r1.sourcePos
                long r4 = r4 - r6
                long r2 = java.lang.Math.min(r2, r4)
                okhttp3.internal.cache2.FileOperator r11 = r1.fileOperator
                long r4 = r1.sourcePos
                long r12 = r4 + r9
                r14 = r20
                r15 = r2
                r11.read(r12, r14, r15)
                long r4 = r1.sourcePos
                long r4 = r4 + r2
                r1.sourcePos = r4
                return r2
            L_0x0072:
                r4 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0124 }
                okio.Source r0 = r0.getUpstream()     // Catch:{ all -> 0x0124 }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0124 }
                okio.Buffer r5 = r5.getUpstreamBuffer()     // Catch:{ all -> 0x0124 }
                okhttp3.internal.cache2.Relay r6 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0124 }
                long r11 = r6.getBufferMaxSize()     // Catch:{ all -> 0x0124 }
                long r5 = r0.read(r5, r11)     // Catch:{ all -> 0x0124 }
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 != 0) goto L_0x00a6
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0124 }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x0124 }
                r0.commit(r2)     // Catch:{ all -> 0x0124 }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r4)     // Catch:{ all -> 0x00a3 }
                r2.notifyAll()     // Catch:{ all -> 0x00a3 }
                kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00a3 }
                monitor-exit(r2)
                return r7
            L_0x00a3:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x00a6:
                long r2 = java.lang.Math.min(r5, r2)     // Catch:{ all -> 0x0124 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0124 }
                okio.Buffer r11 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x0124 }
                r13 = 0
                r12 = r20
                r15 = r2
                r11.copyTo((okio.Buffer) r12, (long) r13, (long) r15)     // Catch:{ all -> 0x0124 }
                long r7 = r1.sourcePos     // Catch:{ all -> 0x0124 }
                long r7 = r7 + r2
                r1.sourcePos = r7     // Catch:{ all -> 0x0124 }
                okhttp3.internal.cache2.FileOperator r13 = r1.fileOperator     // Catch:{ all -> 0x0124 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0124 }
                long r7 = r0.getUpstreamPos()     // Catch:{ all -> 0x0124 }
                long r14 = r7 + r9
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0124 }
                okio.Buffer r0 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x0124 }
                okio.Buffer r16 = r0.clone()     // Catch:{ all -> 0x0124 }
                r17 = r5
                r13.write(r14, r16, r17)     // Catch:{ all -> 0x0124 }
                okhttp3.internal.cache2.Relay r7 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0124 }
                monitor-enter(r7)     // Catch:{ all -> 0x0124 }
                okio.Buffer r0 = r7.getBuffer()     // Catch:{ all -> 0x0121 }
                okio.Buffer r8 = r7.getUpstreamBuffer()     // Catch:{ all -> 0x0121 }
                r0.write((okio.Buffer) r8, (long) r5)     // Catch:{ all -> 0x0121 }
                okio.Buffer r0 = r7.getBuffer()     // Catch:{ all -> 0x0121 }
                long r8 = r0.size()     // Catch:{ all -> 0x0121 }
                long r10 = r7.getBufferMaxSize()     // Catch:{ all -> 0x0121 }
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 <= 0) goto L_0x0108
                okio.Buffer r0 = r7.getBuffer()     // Catch:{ all -> 0x0121 }
                okio.Buffer r8 = r7.getBuffer()     // Catch:{ all -> 0x0121 }
                long r8 = r8.size()     // Catch:{ all -> 0x0121 }
                long r10 = r7.getBufferMaxSize()     // Catch:{ all -> 0x0121 }
                long r8 = r8 - r10
                r0.skip(r8)     // Catch:{ all -> 0x0121 }
            L_0x0108:
                long r8 = r7.getUpstreamPos()     // Catch:{ all -> 0x0121 }
                long r8 = r8 + r5
                r7.setUpstreamPos(r8)     // Catch:{ all -> 0x0121 }
                kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0121 }
                monitor-exit(r7)     // Catch:{ all -> 0x0124 }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r5)
                r5.setUpstreamReader(r4)     // Catch:{ all -> 0x011e }
                r5.notifyAll()     // Catch:{ all -> 0x011e }
                monitor-exit(r5)
                return r2
            L_0x011e:
                r0 = move-exception
                monitor-exit(r5)
                throw r0
            L_0x0121:
                r0 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0124 }
                throw r0     // Catch:{ all -> 0x0124 }
            L_0x0124:
                r0 = move-exception
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r4)     // Catch:{ all -> 0x0132 }
                r2.notifyAll()     // Catch:{ all -> 0x0132 }
                kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0132 }
                monitor-exit(r2)
                throw r0
            L_0x0132:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x0135:
                long r6 = r5.getUpstreamPos()     // Catch:{ all -> 0x0155 }
                long r11 = r1.sourcePos     // Catch:{ all -> 0x0155 }
                long r6 = r6 - r11
                long r2 = java.lang.Math.min(r2, r6)     // Catch:{ all -> 0x0155 }
                okio.Buffer r11 = r5.getBuffer()     // Catch:{ all -> 0x0155 }
                long r6 = r1.sourcePos     // Catch:{ all -> 0x0155 }
                long r13 = r6 - r9
                r12 = r20
                r15 = r2
                r11.copyTo((okio.Buffer) r12, (long) r13, (long) r15)     // Catch:{ all -> 0x0155 }
                long r6 = r1.sourcePos     // Catch:{ all -> 0x0155 }
                long r6 = r6 + r2
                r1.sourcePos = r6     // Catch:{ all -> 0x0155 }
                monitor-exit(r5)
                return r2
            L_0x0155:
                r0 = move-exception
                monitor-exit(r5)
                throw r0
            L_0x0158:
                java.lang.String r0 = "Check failed."
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PREFIX_CLEAN = companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j11, ByteString byteString, long j12) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j11;
        this.metadata = byteString;
        this.bufferMaxSize = j12;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j11, ByteString byteString, long j12, r rVar) {
        this(randomAccessFile, source, j11, byteString, j12);
    }

    /* access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j11, long j12) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j11);
        buffer2.writeLong(j12);
        if (buffer2.size() == 32) {
            new FileOperator(this.file.getChannel()).write(0, buffer2, 32);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void writeMetadata(long j11) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j11, buffer2, (long) this.metadata.size());
    }

    public final void commit(long j11) throws IOException {
        writeMetadata(j11);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j11, (long) this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            Unit unit = Unit.f56620a;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly((Closeable) source);
        }
        this.upstream = null;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z11) {
        this.complete = z11;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i11) {
        this.sourceCount = i11;
    }

    public final void setUpstream(Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j11) {
        this.upstreamPos = j11;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }
}
