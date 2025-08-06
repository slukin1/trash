package okio;

import com.huobi.points.entity.PointsPack;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

public abstract class FileHandle implements Closeable {
    /* access modifiers changed from: private */
    public boolean closed;
    private final ReentrantLock lock = _JvmPlatformKt.newLock();
    /* access modifiers changed from: private */
    public int openStreamCount;
    private final boolean readWrite;

    public static final class FileHandleSink implements Sink {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSink(FileHandle fileHandle2, long j11) {
            this.fileHandle = fileHandle2;
            this.position = j11;
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                ReentrantLock lock = this.fileHandle.getLock();
                lock.lock();
                try {
                    FileHandle fileHandle2 = this.fileHandle;
                    fileHandle2.openStreamCount = fileHandle2.openStreamCount - 1;
                    if (this.fileHandle.openStreamCount == 0) {
                        if (this.fileHandle.closed) {
                            Unit unit = Unit.f56620a;
                            lock.unlock();
                            this.fileHandle.protectedClose();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        public void flush() {
            if (!this.closed) {
                this.fileHandle.protectedFlush();
                return;
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setClosed(boolean z11) {
            this.closed = z11;
        }

        public final void setPosition(long j11) {
            this.position = j11;
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }

        public void write(Buffer buffer, long j11) {
            if (!this.closed) {
                this.fileHandle.writeNoCloseCheck(this.position, buffer, j11);
                this.position += j11;
                return;
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public static final class FileHandleSource implements Source {
        private boolean closed;
        private final FileHandle fileHandle;
        private long position;

        public FileHandleSource(FileHandle fileHandle2, long j11) {
            this.fileHandle = fileHandle2;
            this.position = j11;
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                ReentrantLock lock = this.fileHandle.getLock();
                lock.lock();
                try {
                    FileHandle fileHandle2 = this.fileHandle;
                    fileHandle2.openStreamCount = fileHandle2.openStreamCount - 1;
                    if (this.fileHandle.openStreamCount == 0) {
                        if (this.fileHandle.closed) {
                            Unit unit = Unit.f56620a;
                            lock.unlock();
                            this.fileHandle.protectedClose();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public long read(Buffer buffer, long j11) {
            if (!this.closed) {
                long access$readNoCloseCheck = this.fileHandle.readNoCloseCheck(this.position, buffer, j11);
                if (access$readNoCloseCheck != -1) {
                    this.position += access$readNoCloseCheck;
                }
                return access$readNoCloseCheck;
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }

        public final void setClosed(boolean z11) {
            this.closed = z11;
        }

        public final void setPosition(long j11) {
            this.position = j11;
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    public FileHandle(boolean z11) {
        this.readWrite = z11;
    }

    /* access modifiers changed from: private */
    public final long readNoCloseCheck(long j11, Buffer buffer, long j12) {
        Buffer buffer2 = buffer;
        long j13 = j12;
        if (j13 >= 0) {
            long j14 = j11 + j13;
            long j15 = j11;
            while (true) {
                if (j15 >= j14) {
                    break;
                }
                Segment writableSegment$okio = buffer2.writableSegment$okio(1);
                byte[] bArr = writableSegment$okio.data;
                int i11 = writableSegment$okio.limit;
                int protectedRead = protectedRead(j15, bArr, i11, (int) Math.min(j14 - j15, (long) (8192 - i11)));
                if (protectedRead == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        buffer2.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (j11 == j15) {
                        return -1;
                    }
                } else {
                    writableSegment$okio.limit += protectedRead;
                    long j16 = (long) protectedRead;
                    j15 += j16;
                    buffer2.setSize$okio(buffer.size() + j16);
                }
            }
            return j15 - j11;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j13).toString());
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                j11 = 0;
            }
            return fileHandle.sink(j11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j11, int i11, Object obj) throws IOException {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                j11 = 0;
            }
            return fileHandle.source(j11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
    }

    /* access modifiers changed from: private */
    public final void writeNoCloseCheck(long j11, Buffer buffer, long j12) {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j12);
        long j13 = j12 + j11;
        while (j11 < j13) {
            Segment segment = buffer.head;
            int min = (int) Math.min(j13 - j11, (long) (segment.limit - segment.pos));
            protectedWrite(j11, segment.data, segment.pos, min);
            segment.pos += min;
            long j14 = (long) min;
            j11 += j14;
            buffer.setSize$okio(buffer.size() - j14);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final Sink appendingSink() throws IOException {
        return sink(size());
    }

    public final void close() throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                this.closed = true;
                if (this.openStreamCount != 0) {
                    reentrantLock.unlock();
                    return;
                }
                Unit unit = Unit.f56620a;
                reentrantLock.unlock();
                protectedClose();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void flush() throws IOException {
        if (this.readWrite) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.closed) {
                    Unit unit = Unit.f56620a;
                    reentrantLock.unlock();
                    protectedFlush();
                    return;
                }
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        } else {
            throw new IllegalStateException("file handle is read-only".toString());
        }
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(Source source) throws IOException {
        long j11;
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            j11 = realBufferedSource.bufferField.size();
            source = realBufferedSource.source;
        } else {
            j11 = 0;
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this) {
            FileHandleSource fileHandleSource = (FileHandleSource) source;
            if (!fileHandleSource.getClosed()) {
                return fileHandleSource.getPosition() - j11;
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    public abstract void protectedClose() throws IOException;

    public abstract void protectedFlush() throws IOException;

    public abstract int protectedRead(long j11, byte[] bArr, int i11, int i12) throws IOException;

    public abstract void protectedResize(long j11) throws IOException;

    public abstract long protectedSize() throws IOException;

    public abstract void protectedWrite(long j11, byte[] bArr, int i11, int i12) throws IOException;

    /* JADX INFO: finally extract failed */
    public final int read(long j11, byte[] bArr, int i11, int i12) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                Unit unit = Unit.f56620a;
                reentrantLock.unlock();
                return protectedRead(j11, bArr, i11, i12);
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final void reposition(Source source, long j11) throws IOException {
        boolean z11 = false;
        if (source instanceof RealBufferedSource) {
            RealBufferedSource realBufferedSource = (RealBufferedSource) source;
            Source source2 = realBufferedSource.source;
            if ((source2 instanceof FileHandleSource) && ((FileHandleSource) source2).getFileHandle() == this) {
                FileHandleSource fileHandleSource = (FileHandleSource) source2;
                if (!fileHandleSource.getClosed()) {
                    long size = realBufferedSource.bufferField.size();
                    long position = j11 - (fileHandleSource.getPosition() - size);
                    if (0 <= position && position < size) {
                        z11 = true;
                    }
                    if (z11) {
                        realBufferedSource.skip(position);
                        return;
                    }
                    realBufferedSource.bufferField.clear();
                    fileHandleSource.setPosition(j11);
                    return;
                }
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            }
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        if ((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this) {
            z11 = true;
        }
        if (z11) {
            FileHandleSource fileHandleSource2 = (FileHandleSource) source;
            if (!fileHandleSource2.getClosed()) {
                fileHandleSource2.setPosition(j11);
                return;
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
        throw new IllegalArgumentException("source was not created by this FileHandle".toString());
    }

    /* JADX INFO: finally extract failed */
    public final void resize(long j11) throws IOException {
        if (this.readWrite) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.closed) {
                    Unit unit = Unit.f56620a;
                    reentrantLock.unlock();
                    protectedResize(j11);
                    return;
                }
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        } else {
            throw new IllegalStateException("file handle is read-only".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public final Sink sink(long j11) throws IOException {
        if (this.readWrite) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.closed) {
                    this.openStreamCount++;
                    reentrantLock.unlock();
                    return new FileHandleSink(this, j11);
                }
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        } else {
            throw new IllegalStateException("file handle is read-only".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public final long size() throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                Unit unit = Unit.f56620a;
                reentrantLock.unlock();
                return protectedSize();
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public final Source source(long j11) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                this.openStreamCount++;
                reentrantLock.unlock();
                return new FileHandleSource(this, j11);
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public final void write(long j11, byte[] bArr, int i11, int i12) {
        if (this.readWrite) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.closed) {
                    Unit unit = Unit.f56620a;
                    reentrantLock.unlock();
                    protectedWrite(j11, bArr, i11, i12);
                    return;
                }
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        } else {
            throw new IllegalStateException("file handle is read-only".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public final long read(long j11, Buffer buffer, long j12) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.closed) {
                Unit unit = Unit.f56620a;
                reentrantLock.unlock();
                return readNoCloseCheck(j11, buffer, j12);
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final long position(Sink sink) throws IOException {
        long j11;
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            j11 = realBufferedSink.bufferField.size();
            sink = realBufferedSink.sink;
        } else {
            j11 = 0;
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            FileHandleSink fileHandleSink = (FileHandleSink) sink;
            if (!fileHandleSink.getClosed()) {
                return fileHandleSink.getPosition() + j11;
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }

    /* JADX INFO: finally extract failed */
    public final void write(long j11, Buffer buffer, long j12) throws IOException {
        if (this.readWrite) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.closed) {
                    Unit unit = Unit.f56620a;
                    reentrantLock.unlock();
                    writeNoCloseCheck(j11, buffer, j12);
                    return;
                }
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        } else {
            throw new IllegalStateException("file handle is read-only".toString());
        }
    }

    public final void reposition(Sink sink, long j11) throws IOException {
        boolean z11 = false;
        if (sink instanceof RealBufferedSink) {
            RealBufferedSink realBufferedSink = (RealBufferedSink) sink;
            Sink sink2 = realBufferedSink.sink;
            if ((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this) {
                z11 = true;
            }
            if (z11) {
                FileHandleSink fileHandleSink = (FileHandleSink) sink2;
                if (!fileHandleSink.getClosed()) {
                    realBufferedSink.emit();
                    fileHandleSink.setPosition(j11);
                    return;
                }
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            }
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        if ((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this) {
            z11 = true;
        }
        if (z11) {
            FileHandleSink fileHandleSink2 = (FileHandleSink) sink;
            if (!fileHandleSink2.getClosed()) {
                fileHandleSink2.setPosition(j11);
                return;
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
    }
}
