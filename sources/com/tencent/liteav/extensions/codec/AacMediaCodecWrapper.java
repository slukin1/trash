package com.tencent.liteav.extensions.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class AacMediaCodecWrapper {

    /* renamed from: a  reason: collision with root package name */
    public MediaFormat f21577a;

    /* renamed from: b  reason: collision with root package name */
    public int f21578b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final String f21579c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21580d;

    /* renamed from: e  reason: collision with root package name */
    private MediaCodec f21581e;

    /* renamed from: f  reason: collision with root package name */
    private final MediaCodec.BufferInfo f21582f;

    public enum a {
        ;
        

        /* renamed from: a  reason: collision with root package name */
        public static final int f21583a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f21584b = 2;

        /* access modifiers changed from: public */
        static {
            f21585c = new int[]{1, 2};
        }
    }

    public AacMediaCodecWrapper(int i11) {
        this.f21580d = i11;
        this.f21579c = i11 == a.f21583a ? "HardwareAacEncoder" : "HardwareAacDecoder";
        this.f21582f = new MediaCodec.BufferInfo();
    }

    private ByteBuffer b() {
        ByteBuffer byteBuffer;
        try {
            int dequeueOutputBuffer = this.f21581e.dequeueOutputBuffer(this.f21582f, TimeUnit.MILLISECONDS.toMicros(5));
            if (dequeueOutputBuffer == -1) {
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                Log.i(this.f21579c, "codec output buffers changed.", new Object[0]);
                return null;
            } else if (dequeueOutputBuffer == -2) {
                this.f21577a = this.f21581e.getOutputFormat();
                String str = this.f21579c;
                Log.i(str, "codec output format changed: " + this.f21577a, new Object[0]);
                return null;
            } else if (dequeueOutputBuffer < 0) {
                Log.e(this.f21579c, "unexpected result from dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)), new Object[0]);
                return null;
            } else {
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                    byteBuffer = this.f21581e.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    byteBuffer = this.f21581e.getOutputBuffers()[dequeueOutputBuffer];
                }
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f21582f.size);
                allocateDirect.put(byteBuffer);
                this.f21581e.releaseOutputBuffer(dequeueOutputBuffer, false);
                int i11 = this.f21578b;
                if (i11 > 0) {
                    this.f21578b = i11 - 1;
                }
                return allocateDirect;
            }
        } catch (Exception e11) {
            Log.e(this.f21579c, "dequeueOutputBuffer failed. ".concat(String.valueOf(e11)), new Object[0]);
            return null;
        }
    }

    public final boolean a(MediaFormat mediaFormat) {
        if (this.f21581e == null && mediaFormat != null) {
            try {
                boolean z11 = this.f21580d == a.f21583a;
                if (z11) {
                    this.f21581e = MediaCodec.createEncoderByType(MimeTypes.AUDIO_AAC);
                } else {
                    this.f21581e = MediaCodec.createDecoderByType(MimeTypes.AUDIO_AAC);
                }
                this.f21581e.configure(mediaFormat, (Surface) null, (MediaCrypto) null, z11 ? 1 : 0);
                this.f21581e.start();
                return true;
            } catch (IOException e11) {
                Log.e(this.f21579c, "create codec failed. ".concat(String.valueOf(e11)), new Object[0]);
                a();
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.nio.ByteBuffer processFrame(java.nio.ByteBuffer r14) {
        /*
            r13 = this;
            android.media.MediaCodec r0 = r13.f21581e
            r1 = 0
            if (r0 == 0) goto L_0x0066
            if (r14 != 0) goto L_0x0008
            goto L_0x0066
        L_0x0008:
            r2 = 0
            java.nio.ByteBuffer[] r0 = r0.getInputBuffers()     // Catch:{ Exception -> 0x0047 }
            if (r0 == 0) goto L_0x003d
            int r3 = r0.length     // Catch:{ Exception -> 0x0047 }
            if (r3 > 0) goto L_0x0013
            goto L_0x003d
        L_0x0013:
            android.media.MediaCodec r3 = r13.f21581e     // Catch:{ Exception -> 0x0047 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0047 }
            r5 = 5
            long r4 = r4.toMicros(r5)     // Catch:{ Exception -> 0x0047 }
            int r7 = r3.dequeueInputBuffer(r4)     // Catch:{ Exception -> 0x0047 }
            if (r7 >= 0) goto L_0x0024
            goto L_0x0059
        L_0x0024:
            int r9 = r14.remaining()     // Catch:{ Exception -> 0x0047 }
            r0 = r0[r7]     // Catch:{ Exception -> 0x0047 }
            r0.put(r14)     // Catch:{ Exception -> 0x0047 }
            android.media.MediaCodec r6 = r13.f21581e     // Catch:{ Exception -> 0x0047 }
            r8 = 0
            r10 = 0
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ Exception -> 0x0047 }
            int r14 = r13.f21578b     // Catch:{ Exception -> 0x0047 }
            int r14 = r14 + 1
            r13.f21578b = r14     // Catch:{ Exception -> 0x0047 }
            goto L_0x0059
        L_0x003d:
            java.lang.String r14 = r13.f21579c     // Catch:{ Exception -> 0x0047 }
            java.lang.String r0 = "get invalid input buffers."
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0047 }
            com.tencent.liteav.base.Log.e(r14, r0, r3)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0059
        L_0x0047:
            r14 = move-exception
            java.lang.String r0 = r13.f21579c
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r3 = "feedData failed. "
            java.lang.String r14 = r3.concat(r14)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.tencent.liteav.base.Log.e(r0, r14, r3)
        L_0x0059:
            r14 = 3
            if (r2 >= r14) goto L_0x0066
            java.nio.ByteBuffer r14 = r13.b()
            if (r14 == 0) goto L_0x0063
            return r14
        L_0x0063:
            int r2 = r2 + 1
            goto L_0x0059
        L_0x0066:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.extensions.codec.AacMediaCodecWrapper.processFrame(java.nio.ByteBuffer):java.nio.ByteBuffer");
    }

    public final void a() {
        MediaCodec mediaCodec = this.f21581e;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Exception e11) {
                Log.e(this.f21579c, "codec stop failed.".concat(String.valueOf(e11)), new Object[0]);
            }
            try {
                this.f21581e.release();
            } catch (Exception e12) {
                Log.e(this.f21579c, "codec release failed.".concat(String.valueOf(e12)), new Object[0]);
            }
            this.f21581e = null;
            this.f21578b = 0;
        }
    }
}
