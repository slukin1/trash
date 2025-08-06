package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;

public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {
    private int availableInputBufferCount;
    private final I[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final O[] availableOutputBuffers;
    private final Thread decodeThread;
    private I dequeuedInputBuffer;
    private E exception;
    private boolean flushed;
    private final Object lock = new Object();
    private final ArrayDeque<I> queuedInputBuffers = new ArrayDeque<>();
    private final ArrayDeque<O> queuedOutputBuffers = new ArrayDeque<>();
    private boolean released;
    private int skippedOutputBufferCount;

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.availableInputBuffers = iArr;
        this.availableInputBufferCount = iArr.length;
        for (int i11 = 0; i11 < this.availableInputBufferCount; i11++) {
            this.availableInputBuffers[i11] = createInputBuffer();
        }
        this.availableOutputBuffers = oArr;
        this.availableOutputBufferCount = oArr.length;
        for (int i12 = 0; i12 < this.availableOutputBufferCount; i12++) {
            this.availableOutputBuffers[i12] = createOutputBuffer();
        }
        AnonymousClass1 r42 = new Thread("ExoPlayer:SimpleDecoder") {
            public void run() {
                SimpleDecoder.this.run();
            }
        };
        this.decodeThread = r42;
        r42.start();
    }

    private boolean canDecodeBuffer() {
        return !this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1.isEndOfStream() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.addFlag(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1.isDecodeOnly() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r3.addFlag(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = decode(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r0 = createUnexpectedDecodeException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r0 = createUnexpectedDecodeException(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean decode() throws java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r6.released     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r6.canDecodeBuffer()     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0013
            java.lang.Object r1 = r6.lock     // Catch:{ all -> 0x0090 }
            r1.wait()     // Catch:{ all -> 0x0090 }
            goto L_0x0003
        L_0x0013:
            boolean r1 = r6.released     // Catch:{ all -> 0x0090 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return r2
        L_0x001a:
            java.util.ArrayDeque<I> r1 = r6.queuedInputBuffers     // Catch:{ all -> 0x0090 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0090 }
            com.google.android.exoplayer2.decoder.DecoderInputBuffer r1 = (com.google.android.exoplayer2.decoder.DecoderInputBuffer) r1     // Catch:{ all -> 0x0090 }
            O[] r3 = r6.availableOutputBuffers     // Catch:{ all -> 0x0090 }
            int r4 = r6.availableOutputBufferCount     // Catch:{ all -> 0x0090 }
            r5 = 1
            int r4 = r4 - r5
            r6.availableOutputBufferCount = r4     // Catch:{ all -> 0x0090 }
            r3 = r3[r4]     // Catch:{ all -> 0x0090 }
            boolean r4 = r6.flushed     // Catch:{ all -> 0x0090 }
            r6.flushed = r2     // Catch:{ all -> 0x0090 }
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            boolean r0 = r1.isEndOfStream()
            if (r0 == 0) goto L_0x003c
            r0 = 4
            r3.addFlag(r0)
            goto L_0x0063
        L_0x003c:
            boolean r0 = r1.isDecodeOnly()
            if (r0 == 0) goto L_0x0047
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.addFlag(r0)
        L_0x0047:
            com.google.android.exoplayer2.decoder.DecoderException r0 = r6.decode(r1, r3, r4)     // Catch:{ RuntimeException -> 0x0052, OutOfMemoryError -> 0x004c }
            goto L_0x0057
        L_0x004c:
            r0 = move-exception
            com.google.android.exoplayer2.decoder.DecoderException r0 = r6.createUnexpectedDecodeException(r0)
            goto L_0x0057
        L_0x0052:
            r0 = move-exception
            com.google.android.exoplayer2.decoder.DecoderException r0 = r6.createUnexpectedDecodeException(r0)
        L_0x0057:
            if (r0 == 0) goto L_0x0063
            java.lang.Object r4 = r6.lock
            monitor-enter(r4)
            r6.exception = r0     // Catch:{ all -> 0x0060 }
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            return r2
        L_0x0060:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            throw r0
        L_0x0063:
            java.lang.Object r4 = r6.lock
            monitor-enter(r4)
            boolean r0 = r6.flushed     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x006e
            r3.release()     // Catch:{ all -> 0x008d }
            goto L_0x0088
        L_0x006e:
            boolean r0 = r3.isDecodeOnly()     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x007d
            int r0 = r6.skippedOutputBufferCount     // Catch:{ all -> 0x008d }
            int r0 = r0 + r5
            r6.skippedOutputBufferCount = r0     // Catch:{ all -> 0x008d }
            r3.release()     // Catch:{ all -> 0x008d }
            goto L_0x0088
        L_0x007d:
            int r0 = r6.skippedOutputBufferCount     // Catch:{ all -> 0x008d }
            r3.skippedOutputBufferCount = r0     // Catch:{ all -> 0x008d }
            r6.skippedOutputBufferCount = r2     // Catch:{ all -> 0x008d }
            java.util.ArrayDeque<O> r0 = r6.queuedOutputBuffers     // Catch:{ all -> 0x008d }
            r0.addLast(r3)     // Catch:{ all -> 0x008d }
        L_0x0088:
            r6.releaseInputBufferInternal(r1)     // Catch:{ all -> 0x008d }
            monitor-exit(r4)     // Catch:{ all -> 0x008d }
            return r5
        L_0x008d:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008d }
            throw r0
        L_0x0090:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.decoder.SimpleDecoder.decode():boolean");
    }

    private void maybeNotifyDecodeLoop() {
        if (canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    private void maybeThrowException() throws DecoderException {
        E e11 = this.exception;
        if (e11 != null) {
            throw e11;
        }
    }

    private void releaseInputBufferInternal(I i11) {
        i11.clear();
        I[] iArr = this.availableInputBuffers;
        int i12 = this.availableInputBufferCount;
        this.availableInputBufferCount = i12 + 1;
        iArr[i12] = i11;
    }

    private void releaseOutputBufferInternal(O o11) {
        o11.clear();
        O[] oArr = this.availableOutputBuffers;
        int i11 = this.availableOutputBufferCount;
        this.availableOutputBufferCount = i11 + 1;
        oArr[i11] = o11;
    }

    /* access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11);
            }
        } while (decode());
    }

    public abstract I createInputBuffer();

    public abstract O createOutputBuffer();

    public abstract E createUnexpectedDecodeException(Throwable th2);

    public abstract E decode(I i11, O o11, boolean z11);

    public final void flush() {
        synchronized (this.lock) {
            this.flushed = true;
            this.skippedOutputBufferCount = 0;
            I i11 = this.dequeuedInputBuffer;
            if (i11 != null) {
                releaseInputBufferInternal(i11);
                this.dequeuedInputBuffer = null;
            }
            while (!this.queuedInputBuffers.isEmpty()) {
                releaseInputBufferInternal((DecoderInputBuffer) this.queuedInputBuffers.removeFirst());
            }
            while (!this.queuedOutputBuffers.isEmpty()) {
                ((OutputBuffer) this.queuedOutputBuffers.removeFirst()).release();
            }
        }
    }

    public void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public void releaseOutputBuffer(O o11) {
        synchronized (this.lock) {
            releaseOutputBufferInternal(o11);
            maybeNotifyDecodeLoop();
        }
    }

    public final void setInitialInputBufferSize(int i11) {
        Assertions.checkState(this.availableInputBufferCount == this.availableInputBuffers.length);
        for (I ensureSpaceForWrite : this.availableInputBuffers) {
            ensureSpaceForWrite.ensureSpaceForWrite(i11);
        }
    }

    public final I dequeueInputBuffer() throws DecoderException {
        I i11;
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkState(this.dequeuedInputBuffer == null);
            int i12 = this.availableInputBufferCount;
            if (i12 == 0) {
                i11 = null;
            } else {
                I[] iArr = this.availableInputBuffers;
                int i13 = i12 - 1;
                this.availableInputBufferCount = i13;
                i11 = iArr[i13];
            }
            this.dequeuedInputBuffer = i11;
        }
        return i11;
    }

    public final O dequeueOutputBuffer() throws DecoderException {
        synchronized (this.lock) {
            maybeThrowException();
            if (this.queuedOutputBuffers.isEmpty()) {
                return null;
            }
            O o11 = (OutputBuffer) this.queuedOutputBuffers.removeFirst();
            return o11;
        }
    }

    public final void queueInputBuffer(I i11) throws DecoderException {
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkArgument(i11 == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(i11);
            maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }
}
