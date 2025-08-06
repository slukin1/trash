package com.tencent.ugc.beauty.decoder;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.beauty.decoder.Stage;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Decoder extends ProvidedStage<Frame> {
    private static final String TAG = "Decoder";
    private final MediaCodec.BufferInfo mBufferInfo;
    private final Extractor mExtractor;
    private boolean mIsLooping;
    private MediaCodec mMediaCodec;
    private final Object mNativeWindow;
    private long mSkipFrameBeforeInThisLoop;

    public Decoder(Extractor extractor) {
        this(extractor, (SurfaceTexture) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0 != -3) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        com.tencent.liteav.base.util.LiteavLog.i(TAG, "decoder output buffers changed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r0 != -2) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        com.tencent.liteav.base.util.LiteavLog.i(TAG, "decoder output format changed: ".concat(java.lang.String.valueOf(r7.mMediaCodec.getOutputFormat())));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r0 < 0) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt() < 21) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        r1 = r7.mMediaCodec.getOutputBuffer(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r1 = r7.mMediaCodec.getOutputBuffers()[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        r2 = new com.tencent.ugc.beauty.decoder.Frame();
        r2.buffer = r1;
        r2.bufferIndex = r0;
        r0 = r7.mBufferInfo;
        r2.offset = r0.offset;
        r2.size = r0.size;
        r3 = r0.presentationTimeUs;
        r2.presentationTimeUs = r3;
        r0 = r0.flags;
        r2.flags = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        if (r7.mSkipFrameBeforeInThisLoop <= r3) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        if (com.tencent.ugc.beauty.decoder.MediaUtils.hasEosFlag(r0) != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        r7.mMediaCodec.releaseOutputBuffer(r2.bufferIndex, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r7.mWaitOutBuffers.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0095, code lost:
        if (com.tencent.ugc.beauty.decoder.MediaUtils.hasEosFlag(r2.flags) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        setState(com.tencent.ugc.beauty.decoder.Stage.State.ALL_DATA_READY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00af, code lost:
        throw new java.lang.RuntimeException("unexpected result from decoder.dequeueOutputBuffer: ".concat(java.lang.String.valueOf(r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        r0 = r7.mMediaCodec.dequeueOutputBuffer(r7.mBufferInfo, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r0 != -1) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drainDecodedFrame() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Queue<T> r0 = r7.mWaitOutBuffers     // Catch:{ all -> 0x00b0 }
            int r0 = r0.size()     // Catch:{ all -> 0x00b0 }
            r1 = 3
            if (r0 < r1) goto L_0x000c
            monitor-exit(r7)     // Catch:{ all -> 0x00b0 }
            return
        L_0x000c:
            monitor-exit(r7)     // Catch:{ all -> 0x00b0 }
            android.media.MediaCodec r0 = r7.mMediaCodec
            android.media.MediaCodec$BufferInfo r1 = r7.mBufferInfo
            r2 = 0
            int r0 = r0.dequeueOutputBuffer(r1, r2)
            r1 = -1
            if (r0 != r1) goto L_0x001b
            return
        L_0x001b:
            r1 = -3
            if (r0 != r1) goto L_0x0026
            java.lang.String r0 = "Decoder"
            java.lang.String r1 = "decoder output buffers changed"
            com.tencent.liteav.base.util.LiteavLog.i(r0, r1)
            return
        L_0x0026:
            r1 = -2
            if (r0 != r1) goto L_0x003f
            android.media.MediaCodec r0 = r7.mMediaCodec
            android.media.MediaFormat r0 = r0.getOutputFormat()
            java.lang.String r1 = "Decoder"
            java.lang.String r2 = "decoder output format changed: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r2.concat(r0)
            com.tencent.liteav.base.util.LiteavLog.i(r1, r0)
            return
        L_0x003f:
            if (r0 < 0) goto L_0x00a0
            int r1 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r2 = 21
            if (r1 < r2) goto L_0x0050
            android.media.MediaCodec r1 = r7.mMediaCodec
            java.nio.ByteBuffer r1 = r1.getOutputBuffer(r0)
            goto L_0x0058
        L_0x0050:
            android.media.MediaCodec r1 = r7.mMediaCodec
            java.nio.ByteBuffer[] r1 = r1.getOutputBuffers()
            r1 = r1[r0]
        L_0x0058:
            com.tencent.ugc.beauty.decoder.Frame r2 = new com.tencent.ugc.beauty.decoder.Frame
            r2.<init>()
            r2.buffer = r1
            r2.bufferIndex = r0
            android.media.MediaCodec$BufferInfo r0 = r7.mBufferInfo
            int r1 = r0.offset
            r2.offset = r1
            int r1 = r0.size
            r2.size = r1
            long r3 = r0.presentationTimeUs
            r2.presentationTimeUs = r3
            int r0 = r0.flags
            r2.flags = r0
            long r5 = r7.mSkipFrameBeforeInThisLoop
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0088
            boolean r0 = com.tencent.ugc.beauty.decoder.MediaUtils.hasEosFlag(r0)
            if (r0 != 0) goto L_0x0088
            android.media.MediaCodec r0 = r7.mMediaCodec
            int r1 = r2.bufferIndex
            r3 = 0
            r0.releaseOutputBuffer(r1, r3)
            goto L_0x008f
        L_0x0088:
            monitor-enter(r7)
            java.util.Queue<T> r0 = r7.mWaitOutBuffers     // Catch:{ all -> 0x009d }
            r0.add(r2)     // Catch:{ all -> 0x009d }
            monitor-exit(r7)     // Catch:{ all -> 0x009d }
        L_0x008f:
            int r0 = r2.flags
            boolean r0 = com.tencent.ugc.beauty.decoder.MediaUtils.hasEosFlag(r0)
            if (r0 == 0) goto L_0x009c
            com.tencent.ugc.beauty.decoder.Stage$State r0 = com.tencent.ugc.beauty.decoder.Stage.State.ALL_DATA_READY
            r7.setState(r0)
        L_0x009c:
            return
        L_0x009d:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x009d }
            throw r0
        L_0x00a0:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unexpected result from decoder.dequeueOutputBuffer: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L_0x00b0:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00b0 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.beauty.decoder.Decoder.drainDecodedFrame():void");
    }

    private void feedDataToMediaCodec() throws SetupException {
        int dequeueInputBuffer;
        if (!isAllDataReady() && (dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(0)) >= 0) {
            MediaCodec.BufferInfo readSampleData = this.mExtractor.readSampleData(this.mMediaCodec.getInputBuffers()[dequeueInputBuffer]);
            if (this.mIsLooping && MediaUtils.hasEosFlag(readSampleData.flags)) {
                this.mExtractor.restart();
                readSampleData.set(0, 0, 0, 0);
                this.mSkipFrameBeforeInThisLoop = 0;
            }
            this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, readSampleData.offset, readSampleData.size, readSampleData.presentationTimeUs, readSampleData.flags);
        }
    }

    private Surface getOutputSurface(Object obj) throws ExecutionException, InterruptedException {
        if (obj == null) {
            return null;
        }
        while (obj instanceof Future) {
            obj = ((Future) obj).get();
        }
        if (obj instanceof Surface) {
            return (Surface) obj;
        }
        if (obj instanceof SurfaceTexture) {
            return new Surface((SurfaceTexture) obj);
        }
        return null;
    }

    public void processFrame() throws ProcessException {
        try {
            super.processFrame();
            feedDataToMediaCodec();
            drainDecodedFrame();
        } catch (Throwable th2) {
            throw new ProcessException("decode failed", th2);
        }
    }

    public void recycleBuffers(List<Frame> list) {
        for (Frame next : list) {
            if (this.mNativeWindow == null || LiteavSystemInfo.getSystemOSVersionInt() < 21) {
                this.mMediaCodec.releaseOutputBuffer(next.bufferIndex, this.mNativeWindow != null);
            } else {
                this.mMediaCodec.releaseOutputBuffer(next.bufferIndex, TimeUnit.MICROSECONDS.toNanos(next.presentationTimeUs));
            }
        }
    }

    public void release() {
        LiteavLog.i(TAG, "released decoder");
        this.mExtractor.release();
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Throwable th2) {
                LiteavLog.e(TAG, "MediaCodec stop failed.".concat(String.valueOf(th2)));
            }
            try {
                this.mMediaCodec.release();
            } catch (Throwable th3) {
                LiteavLog.e(TAG, "MediaCodec release failed.".concat(String.valueOf(th3)));
            }
        }
    }

    public void setLooping(boolean z11) {
        this.mIsLooping = z11;
    }

    public void setup() throws SetupException {
        Surface surface;
        try {
            surface = getOutputSurface(this.mNativeWindow);
            try {
                LiteavLog.i(TAG, "output surface: ".concat(String.valueOf(surface)));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            surface = null;
            LiteavLog.e(TAG, "get output surface failed.", th);
            this.mExtractor.setup();
            MediaFormat mediaFormat = this.mExtractor.getMediaFormat();
            String string = mediaFormat.getString("mime");
            LiteavLog.i(TAG, "Decoder[%d] for %s", Integer.valueOf(this.mExtractor.getTraceIndex()), string);
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
            this.mMediaCodec = createDecoderByType;
            createDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            this.mMediaCodec.start();
            setState(Stage.State.SETUPED);
        }
        this.mExtractor.setup();
        MediaFormat mediaFormat2 = this.mExtractor.getMediaFormat();
        String string2 = mediaFormat2.getString("mime");
        LiteavLog.i(TAG, "Decoder[%d] for %s", Integer.valueOf(this.mExtractor.getTraceIndex()), string2);
        try {
            MediaCodec createDecoderByType2 = MediaCodec.createDecoderByType(string2);
            this.mMediaCodec = createDecoderByType2;
            createDecoderByType2.configure(mediaFormat2, surface, (MediaCrypto) null, 0);
            this.mMediaCodec.start();
            setState(Stage.State.SETUPED);
        } catch (IOException e11) {
            throw new SetupException("configure MediaCodec failed.", e11);
        }
    }

    public Decoder(Extractor extractor, SurfaceTexture surfaceTexture) {
        this.mIsLooping = false;
        this.mSkipFrameBeforeInThisLoop = 0;
        this.mExtractor = extractor;
        this.mNativeWindow = surfaceTexture;
        this.mBufferInfo = new MediaCodec.BufferInfo();
    }
}
