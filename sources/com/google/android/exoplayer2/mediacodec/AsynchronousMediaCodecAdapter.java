package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.common.base.Supplier;
import java.nio.ByteBuffer;
import java.util.Objects;

final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private static final int STATE_CONFIGURED = 1;
    private static final int STATE_CREATED = 0;
    private static final int STATE_SHUT_DOWN = 3;
    private static final int STATE_STARTED = 2;
    private final AsynchronousMediaCodecCallback asynchronousMediaCodecCallback;
    private final AsynchronousMediaCodecBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private boolean codecReleased;
    private int state;
    private final boolean synchronizeCodecInteractionsWithQueueing;

    public static final class Factory implements MediaCodecAdapter.Factory {
        private final Supplier<HandlerThread> callbackThreadSupplier;
        private final boolean forceQueueingSynchronizationWorkaround;
        private final Supplier<HandlerThread> queueingThreadSupplier;
        private final boolean synchronizeCodecInteractionsWithQueueing;

        public Factory(int i11) {
            this(i11, false, false);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread lambda$new$0(int i11) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.createCallbackThreadLabel(i11));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread lambda$new$1(int i11) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.createQueueingThreadLabel(i11));
        }

        public Factory(int i11, boolean z11, boolean z12) {
            this(new c(i11), new d(i11), z11, z12);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Configuration r11) throws java.io.IOException {
            /*
                r10 = this;
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r11.codecInfo
                java.lang.String r0 = r0.name
                r1 = 0
                java.lang.String r2 = "createCodec:"
                java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0069 }
                int r4 = r3.length()     // Catch:{ Exception -> 0x0069 }
                if (r4 == 0) goto L_0x0016
                java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x0069 }
                goto L_0x001c
            L_0x0016:
                java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0069 }
                r3.<init>(r2)     // Catch:{ Exception -> 0x0069 }
                r2 = r3
            L_0x001c:
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r2)     // Catch:{ Exception -> 0x0069 }
                android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x0069 }
                com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter r2 = new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter     // Catch:{ Exception -> 0x0067 }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r10.callbackThreadSupplier     // Catch:{ Exception -> 0x0067 }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0067 }
                r5 = r3
                android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x0067 }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r10.queueingThreadSupplier     // Catch:{ Exception -> 0x0067 }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0067 }
                r6 = r3
                android.os.HandlerThread r6 = (android.os.HandlerThread) r6     // Catch:{ Exception -> 0x0067 }
                boolean r7 = r10.forceQueueingSynchronizationWorkaround     // Catch:{ Exception -> 0x0067 }
                boolean r8 = r10.synchronizeCodecInteractionsWithQueueing     // Catch:{ Exception -> 0x0067 }
                r9 = 0
                r3 = r2
                r4 = r0
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0067 }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x0064 }
                java.lang.String r1 = "configureCodec"
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r1)     // Catch:{ Exception -> 0x0064 }
                android.media.MediaFormat r1 = r11.mediaFormat     // Catch:{ Exception -> 0x0064 }
                android.view.Surface r3 = r11.surface     // Catch:{ Exception -> 0x0064 }
                android.media.MediaCrypto r4 = r11.crypto     // Catch:{ Exception -> 0x0064 }
                int r11 = r11.flags     // Catch:{ Exception -> 0x0064 }
                r2.configure(r1, r3, r4, r11)     // Catch:{ Exception -> 0x0064 }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x0064 }
                java.lang.String r11 = "startCodec"
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r11)     // Catch:{ Exception -> 0x0064 }
                r2.start()     // Catch:{ Exception -> 0x0064 }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x0064 }
                return r2
            L_0x0064:
                r11 = move-exception
                r1 = r2
                goto L_0x006b
            L_0x0067:
                r11 = move-exception
                goto L_0x006b
            L_0x0069:
                r11 = move-exception
                r0 = r1
            L_0x006b:
                if (r1 != 0) goto L_0x0073
                if (r0 == 0) goto L_0x0076
                r0.release()
                goto L_0x0076
            L_0x0073:
                r1.release()
            L_0x0076:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter.Factory.createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Configuration):com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter");
        }

        public Factory(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z11, boolean z12) {
            this.callbackThreadSupplier = supplier;
            this.queueingThreadSupplier = supplier2;
            this.forceQueueingSynchronizationWorkaround = z11;
            this.synchronizeCodecInteractionsWithQueueing = z12;
        }
    }

    /* access modifiers changed from: private */
    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        this.asynchronousMediaCodecCallback.initialize(this.codec);
        this.codec.configure(mediaFormat, surface, mediaCrypto, i11);
        this.state = 1;
    }

    /* access modifiers changed from: private */
    public static String createCallbackThreadLabel(int i11) {
        return createThreadLabel(i11, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* access modifiers changed from: private */
    public static String createQueueingThreadLabel(int i11) {
        return createThreadLabel(i11, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String createThreadLabel(int i11, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i11 == 1) {
            sb2.append("Audio");
        } else if (i11 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i11);
            sb2.append(")");
        }
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnFrameRenderedListener$0(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j11, long j12) {
        onFrameRenderedListener.onFrameRendered(this, j11, j12);
    }

    private void maybeBlockOnQueueing() {
        if (this.synchronizeCodecInteractionsWithQueueing) {
            try {
                this.bufferEnqueuer.waitUntilQueueingComplete();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public void start() {
        this.bufferEnqueuer.start();
        this.codec.start();
        this.state = 2;
    }

    public int dequeueInputBufferIndex() {
        return this.asynchronousMediaCodecCallback.dequeueInputBufferIndex();
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        return this.asynchronousMediaCodecCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    public void flush() {
        this.bufferEnqueuer.flush();
        this.codec.flush();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback2 = this.asynchronousMediaCodecCallback;
        MediaCodec mediaCodec = this.codec;
        Objects.requireNonNull(mediaCodec);
        asynchronousMediaCodecCallback2.flushAsync(new b(mediaCodec));
    }

    public ByteBuffer getInputBuffer(int i11) {
        return this.codec.getInputBuffer(i11);
    }

    public ByteBuffer getOutputBuffer(int i11) {
        return this.codec.getOutputBuffer(i11);
    }

    public MediaFormat getOutputFormat() {
        return this.asynchronousMediaCodecCallback.getOutputFormat();
    }

    public void onError(MediaCodec.CodecException codecException) {
        this.asynchronousMediaCodecCallback.onError(this.codec, codecException);
    }

    public void onOutputFormatChanged(MediaFormat mediaFormat) {
        this.asynchronousMediaCodecCallback.onOutputFormatChanged(this.codec, mediaFormat);
    }

    public void queueInputBuffer(int i11, int i12, int i13, long j11, int i14) {
        this.bufferEnqueuer.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    public void queueSecureInputBuffer(int i11, int i12, CryptoInfo cryptoInfo, long j11, int i13) {
        this.bufferEnqueuer.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
    }

    public void release() {
        try {
            if (this.state == 2) {
                this.bufferEnqueuer.shutdown();
            }
            int i11 = this.state;
            if (i11 == 1 || i11 == 2) {
                this.asynchronousMediaCodecCallback.shutdown();
            }
            this.state = 3;
        } finally {
            if (!this.codecReleased) {
                this.codec.release();
                this.codecReleased = true;
            }
        }
    }

    public void releaseOutputBuffer(int i11, boolean z11) {
        this.codec.releaseOutputBuffer(i11, z11);
    }

    public void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        maybeBlockOnQueueing();
        this.codec.setOnFrameRenderedListener(new a(this, onFrameRenderedListener), handler);
    }

    public void setOutputSurface(Surface surface) {
        maybeBlockOnQueueing();
        this.codec.setOutputSurface(surface);
    }

    public void setParameters(Bundle bundle) {
        maybeBlockOnQueueing();
        this.codec.setParameters(bundle);
    }

    public void setVideoScalingMode(int i11) {
        maybeBlockOnQueueing();
        this.codec.setVideoScalingMode(i11);
    }

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z11, boolean z12) {
        this.codec = mediaCodec;
        this.asynchronousMediaCodecCallback = new AsynchronousMediaCodecCallback(handlerThread);
        this.bufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodec, handlerThread2, z11);
        this.synchronizeCodecInteractionsWithQueueing = z12;
        this.state = 0;
    }

    public void releaseOutputBuffer(int i11, long j11) {
        this.codec.releaseOutputBuffer(i11, j11);
    }
}
