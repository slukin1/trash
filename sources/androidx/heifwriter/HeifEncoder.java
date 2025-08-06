package androidx.heifwriter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class HeifEncoder implements AutoCloseable, SurfaceTexture.OnFrameAvailableListener {
    public o1.b A;
    public o1.a B;
    public int C;
    public final float[] D = new float[16];

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f9804b;

    /* renamed from: c  reason: collision with root package name */
    public final Callback f9805c;

    /* renamed from: d  reason: collision with root package name */
    public final HandlerThread f9806d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f9807e;

    /* renamed from: f  reason: collision with root package name */
    public final int f9808f;

    /* renamed from: g  reason: collision with root package name */
    public final int f9809g;

    /* renamed from: h  reason: collision with root package name */
    public final int f9810h;

    /* renamed from: i  reason: collision with root package name */
    public final int f9811i;

    /* renamed from: j  reason: collision with root package name */
    public final int f9812j;

    /* renamed from: k  reason: collision with root package name */
    public final int f9813k;

    /* renamed from: l  reason: collision with root package name */
    public final int f9814l;

    /* renamed from: m  reason: collision with root package name */
    public final int f9815m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f9816n;

    /* renamed from: o  reason: collision with root package name */
    public int f9817o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f9818p;

    /* renamed from: q  reason: collision with root package name */
    public final Rect f9819q;

    /* renamed from: r  reason: collision with root package name */
    public final Rect f9820r;

    /* renamed from: s  reason: collision with root package name */
    public ByteBuffer f9821s;

    /* renamed from: t  reason: collision with root package name */
    public final ArrayList<ByteBuffer> f9822t = new ArrayList<>();

    /* renamed from: u  reason: collision with root package name */
    public final ArrayList<ByteBuffer> f9823u = new ArrayList<>();

    /* renamed from: v  reason: collision with root package name */
    public final ArrayList<Integer> f9824v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    public d f9825w;

    /* renamed from: x  reason: collision with root package name */
    public SurfaceTexture f9826x;

    /* renamed from: y  reason: collision with root package name */
    public Surface f9827y;

    /* renamed from: z  reason: collision with root package name */
    public Surface f9828z;

    public static abstract class Callback {
        public abstract void a(HeifEncoder heifEncoder);

        public abstract void b(HeifEncoder heifEncoder, ByteBuffer byteBuffer);

        public abstract void c(HeifEncoder heifEncoder, MediaCodec.CodecException codecException);

        public abstract void d(HeifEncoder heifEncoder, MediaFormat mediaFormat);
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            HeifEncoder.this.l();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            HeifEncoder.this.p();
        }
    }

    public class c extends MediaCodec.Callback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f9831a;

        public c() {
        }

        public final void a(MediaCodec.CodecException codecException) {
            HeifEncoder.this.p();
            if (codecException == null) {
                HeifEncoder heifEncoder = HeifEncoder.this;
                heifEncoder.f9805c.a(heifEncoder);
                return;
            }
            HeifEncoder heifEncoder2 = HeifEncoder.this;
            heifEncoder2.f9805c.c(heifEncoder2, codecException);
        }

        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            if (mediaCodec == HeifEncoder.this.f9804b) {
                Log.e("HeifEncoder", "onError: " + codecException);
                a(codecException);
            }
        }

        public void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
            HeifEncoder heifEncoder = HeifEncoder.this;
            if (mediaCodec == heifEncoder.f9804b && !heifEncoder.f9818p) {
                heifEncoder.f9824v.add(Integer.valueOf(i11));
                HeifEncoder.this.l();
            }
        }

        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
            if (mediaCodec == HeifEncoder.this.f9804b && !this.f9831a) {
                if (bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
                    ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i11);
                    outputBuffer.position(bufferInfo.offset);
                    outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    d dVar = HeifEncoder.this.f9825w;
                    if (dVar != null) {
                        dVar.e(bufferInfo.presentationTimeUs);
                    }
                    HeifEncoder heifEncoder = HeifEncoder.this;
                    heifEncoder.f9805c.b(heifEncoder, outputBuffer);
                }
                this.f9831a = ((bufferInfo.flags & 4) != 0) | this.f9831a;
                mediaCodec.releaseOutputBuffer(i11, false);
                if (this.f9831a) {
                    a((MediaCodec.CodecException) null);
                }
            }
        }

        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            if (mediaCodec == HeifEncoder.this.f9804b) {
                if (!"image/vnd.android.heic".equals(mediaFormat.getString("mime"))) {
                    mediaFormat.setString("mime", "image/vnd.android.heic");
                    mediaFormat.setInteger("width", HeifEncoder.this.f9809g);
                    mediaFormat.setInteger("height", HeifEncoder.this.f9810h);
                    HeifEncoder heifEncoder = HeifEncoder.this;
                    if (heifEncoder.f9816n) {
                        mediaFormat.setInteger("tile-width", heifEncoder.f9811i);
                        mediaFormat.setInteger("tile-height", HeifEncoder.this.f9812j);
                        mediaFormat.setInteger("grid-rows", HeifEncoder.this.f9813k);
                        mediaFormat.setInteger("grid-cols", HeifEncoder.this.f9814l);
                    }
                }
                HeifEncoder heifEncoder2 = HeifEncoder.this;
                heifEncoder2.f9805c.d(heifEncoder2, mediaFormat);
            }
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f9833a;

        /* renamed from: b  reason: collision with root package name */
        public long f9834b = -1;

        /* renamed from: c  reason: collision with root package name */
        public long f9835c = -1;

        /* renamed from: d  reason: collision with root package name */
        public long f9836d = -1;

        /* renamed from: e  reason: collision with root package name */
        public long f9837e = -1;

        /* renamed from: f  reason: collision with root package name */
        public long f9838f = -1;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9839g;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                MediaCodec mediaCodec = HeifEncoder.this.f9804b;
                if (mediaCodec != null) {
                    mediaCodec.signalEndOfInputStream();
                }
            }
        }

        public d(boolean z11) {
            this.f9833a = z11;
        }

        public final void a() {
            HeifEncoder.this.f9807e.post(new a());
            this.f9839g = true;
        }

        public final void b() {
            if (!this.f9839g) {
                if (this.f9836d < 0) {
                    long j11 = this.f9834b;
                    if (j11 >= 0 && this.f9835c >= j11) {
                        long j12 = this.f9837e;
                        if (j12 < 0) {
                            a();
                            return;
                        }
                        this.f9836d = j12;
                    }
                }
                long j13 = this.f9836d;
                if (j13 >= 0 && j13 <= this.f9838f) {
                    a();
                }
            }
        }

        public synchronized void c(long j11) {
            if (this.f9833a) {
                if (this.f9834b < 0) {
                    this.f9834b = j11;
                }
            } else if (this.f9836d < 0) {
                this.f9836d = j11 / 1000;
            }
            b();
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0013  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean d(long r5, long r7) {
            /*
                r4 = this;
                monitor-enter(r4)
                long r0 = r4.f9834b     // Catch:{ all -> 0x001c }
                r2 = 0
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 < 0) goto L_0x0010
                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r0 > 0) goto L_0x000e
                goto L_0x0010
            L_0x000e:
                r0 = 0
                goto L_0x0011
            L_0x0010:
                r0 = 1
            L_0x0011:
                if (r0 == 0) goto L_0x0015
                r4.f9837e = r7     // Catch:{ all -> 0x001c }
            L_0x0015:
                r4.f9835c = r5     // Catch:{ all -> 0x001c }
                r4.b()     // Catch:{ all -> 0x001c }
                monitor-exit(r4)
                return r0
            L_0x001c:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.heifwriter.HeifEncoder.d.d(long, long):boolean");
        }

        public synchronized void e(long j11) {
            this.f9838f = j11;
            b();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HeifEncoder(int r20, int r21, boolean r22, int r23, int r24, android.os.Handler r25, androidx.heifwriter.HeifEncoder.Callback r26) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            r4 = r24
            java.lang.String r5 = "video/hevc"
            java.lang.String r6 = "image/vnd.android.heic"
            r19.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0.f9822t = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0.f9823u = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0.f9824v = r7
            r7 = 16
            float[] r7 = new float[r7]
            r0.D = r7
            if (r1 < 0) goto L_0x0269
            if (r2 < 0) goto L_0x0269
            if (r3 < 0) goto L_0x0269
            r7 = 100
            if (r3 > r7) goto L_0x0269
            r7 = 512(0x200, float:7.175E-43)
            r9 = 1
            if (r1 > r7) goto L_0x0040
            if (r2 <= r7) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r10 = 0
            goto L_0x0041
        L_0x0040:
            r10 = r9
        L_0x0041:
            r10 = r22 & r10
            r11 = 0
            android.media.MediaCodec r12 = android.media.MediaCodec.createEncoderByType(r6)     // Catch:{ Exception -> 0x006b }
            r0.f9804b = r12     // Catch:{ Exception -> 0x006b }
            android.media.MediaCodecInfo r12 = r12.getCodecInfo()     // Catch:{ Exception -> 0x006b }
            android.media.MediaCodecInfo$CodecCapabilities r12 = r12.getCapabilitiesForType(r6)     // Catch:{ Exception -> 0x006b }
            android.media.MediaCodecInfo$VideoCapabilities r13 = r12.getVideoCapabilities()     // Catch:{ Exception -> 0x006b }
            boolean r13 = r13.isSizeSupported(r1, r2)     // Catch:{ Exception -> 0x006b }
            if (r13 == 0) goto L_0x005e
            r13 = r9
            goto L_0x0084
        L_0x005e:
            android.media.MediaCodec r12 = r0.f9804b     // Catch:{ Exception -> 0x006b }
            r12.release()     // Catch:{ Exception -> 0x006b }
            r0.f9804b = r11     // Catch:{ Exception -> 0x006b }
            java.lang.Exception r12 = new java.lang.Exception     // Catch:{ Exception -> 0x006b }
            r12.<init>()     // Catch:{ Exception -> 0x006b }
            throw r12     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            android.media.MediaCodec r12 = android.media.MediaCodec.createEncoderByType(r5)
            r0.f9804b = r12
            android.media.MediaCodecInfo r12 = r12.getCodecInfo()
            android.media.MediaCodecInfo$CodecCapabilities r12 = r12.getCapabilitiesForType(r5)
            android.media.MediaCodecInfo$VideoCapabilities r13 = r12.getVideoCapabilities()
            boolean r13 = r13.isSizeSupported(r1, r2)
            r13 = r13 ^ r9
            r10 = r10 | r13
            r13 = 0
        L_0x0084:
            r0.f9808f = r4
            r14 = r26
            r0.f9805c = r14
            if (r25 == 0) goto L_0x0091
            android.os.Looper r14 = r25.getLooper()
            goto L_0x0092
        L_0x0091:
            r14 = r11
        L_0x0092:
            if (r14 != 0) goto L_0x00a6
            android.os.HandlerThread r14 = new android.os.HandlerThread
            r15 = -2
            java.lang.String r8 = "HeifEncoderThread"
            r14.<init>(r8, r15)
            r0.f9806d = r14
            r14.start()
            android.os.Looper r14 = r14.getLooper()
            goto L_0x00a8
        L_0x00a6:
            r0.f9806d = r11
        L_0x00a8:
            android.os.Handler r8 = new android.os.Handler
            r8.<init>(r14)
            r0.f9807e = r8
            r14 = 2
            if (r4 == r9) goto L_0x00b7
            if (r4 != r14) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r15 = 0
            goto L_0x00b8
        L_0x00b7:
            r15 = r9
        L_0x00b8:
            if (r15 == 0) goto L_0x00be
            r16 = 2130708361(0x7f000789, float:1.701803E38)
            goto L_0x00c1
        L_0x00be:
            r16 = 2135033992(0x7f420888, float:2.5791453E38)
        L_0x00c1:
            r11 = r16
            r0.f9809g = r1
            r0.f9810h = r2
            r0.f9816n = r10
            if (r10 == 0) goto L_0x00da
            int r14 = r2 + 512
            int r14 = r14 - r9
            int r14 = r14 / r7
            r16 = r14
            int r14 = r1 + 512
            int r14 = r14 - r9
            int r14 = r14 / r7
            r9 = r14
            r4 = r16
            r14 = r7
            goto L_0x00dd
        L_0x00da:
            r7 = r1
            r14 = r2
            r4 = r9
        L_0x00dd:
            if (r13 == 0) goto L_0x00e4
            android.media.MediaFormat r5 = android.media.MediaFormat.createVideoFormat(r6, r1, r2)
            goto L_0x00e8
        L_0x00e4:
            android.media.MediaFormat r5 = android.media.MediaFormat.createVideoFormat(r5, r7, r14)
        L_0x00e8:
            if (r10 == 0) goto L_0x00fe
            java.lang.String r6 = "tile-width"
            r5.setInteger(r6, r7)
            java.lang.String r6 = "tile-height"
            r5.setInteger(r6, r14)
            java.lang.String r6 = "grid-cols"
            r5.setInteger(r6, r9)
            java.lang.String r6 = "grid-rows"
            r5.setInteger(r6, r4)
        L_0x00fe:
            if (r13 == 0) goto L_0x010a
            r0.f9811i = r1
            r0.f9812j = r2
            r4 = 1
            r0.f9813k = r4
            r0.f9814l = r4
            goto L_0x0112
        L_0x010a:
            r0.f9811i = r7
            r0.f9812j = r14
            r0.f9813k = r4
            r0.f9814l = r9
        L_0x0112:
            int r4 = r0.f9813k
            int r6 = r0.f9814l
            int r4 = r4 * r6
            r0.f9815m = r4
            java.lang.String r6 = "i-frame-interval"
            r7 = 0
            r5.setInteger(r6, r7)
            java.lang.String r6 = "color-format"
            r5.setInteger(r6, r11)
            java.lang.String r6 = "frame-rate"
            r5.setInteger(r6, r4)
            int r4 = r4 * 30
            java.lang.String r6 = "capture-rate"
            r5.setInteger(r6, r4)
            android.media.MediaCodecInfo$EncoderCapabilities r4 = r12.getEncoderCapabilities()
            boolean r6 = r4.isBitrateModeSupported(r7)
            r11 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.String r7 = "bitrate-mode"
            java.lang.String r9 = "HeifEncoder"
            if (r6 == 0) goto L_0x018c
            java.lang.String r6 = "Setting bitrate mode to constant quality"
            android.util.Log.d(r9, r6)
            android.util.Range r4 = r4.getQualityRange()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r14 = "Quality range: "
            r6.append(r14)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r9, r6)
            r6 = 0
            r5.setInteger(r7, r6)
            java.lang.Comparable r6 = r4.getLower()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            double r6 = (double) r6
            java.lang.Comparable r9 = r4.getUpper()
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Comparable r4 = r4.getLower()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r9 = r9 - r4
            int r9 = r9 * r3
            double r3 = (double) r9
            double r3 = r3 / r11
            double r6 = r6 + r3
            int r3 = (int) r6
            java.lang.String r4 = "quality"
            r5.setInteger(r4, r3)
            goto L_0x01bd
        L_0x018c:
            r6 = 2
            boolean r4 = r4.isBitrateModeSupported(r6)
            if (r4 == 0) goto L_0x019c
            java.lang.String r4 = "Setting bitrate mode to constant bitrate"
            android.util.Log.d(r9, r4)
            r5.setInteger(r7, r6)
            goto L_0x01a5
        L_0x019c:
            java.lang.String r4 = "Setting bitrate mode to variable bitrate"
            android.util.Log.d(r9, r4)
            r4 = 1
            r5.setInteger(r7, r4)
        L_0x01a5:
            int r4 = r1 * r2
            double r6 = (double) r4
            r17 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r6 = r6 * r17
            r17 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r6 = r6 * r17
            r17 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            double r6 = r6 * r17
            double r3 = (double) r3
            double r6 = r6 * r3
            double r6 = r6 / r11
            int r3 = (int) r6
            java.lang.String r4 = "bitrate"
            r5.setInteger(r4, r3)
        L_0x01bd:
            android.media.MediaCodec r3 = r0.f9804b
            androidx.heifwriter.HeifEncoder$c r4 = new androidx.heifwriter.HeifEncoder$c
            r4.<init>()
            r3.setCallback(r4, r8)
            android.media.MediaCodec r3 = r0.f9804b
            r4 = 0
            r6 = 1
            r3.configure(r5, r4, r4, r6)
            if (r15 == 0) goto L_0x023d
            android.media.MediaCodec r3 = r0.f9804b
            android.view.Surface r3 = r3.createInputSurface()
            r0.f9828z = r3
            if (r10 == 0) goto L_0x01e0
            if (r13 == 0) goto L_0x01dd
            goto L_0x01e0
        L_0x01dd:
            r3 = r24
            goto L_0x01e5
        L_0x01e0:
            r3 = r24
            r4 = 2
            if (r3 != r4) goto L_0x01e7
        L_0x01e5:
            r4 = 1
            goto L_0x01e8
        L_0x01e7:
            r4 = 0
        L_0x01e8:
            androidx.heifwriter.HeifEncoder$d r5 = new androidx.heifwriter.HeifEncoder$d
            r5.<init>(r4)
            r0.f9825w = r5
            if (r4 == 0) goto L_0x0238
            o1.b r4 = new o1.b
            android.view.Surface r5 = r0.f9828z
            r4.<init>(r5)
            r0.A = r4
            r4.f()
            o1.a r4 = new o1.a
            o1.c r5 = new o1.c
            r6 = 2
            if (r3 != r6) goto L_0x0206
            r6 = 0
            goto L_0x0207
        L_0x0206:
            r6 = 1
        L_0x0207:
            r5.<init>(r6)
            r4.<init>(r5, r1, r2)
            r0.B = r4
            int r4 = r4.c()
            r0.C = r4
            r4 = 1
            if (r3 != r4) goto L_0x0232
            android.graphics.SurfaceTexture r3 = new android.graphics.SurfaceTexture
            int r5 = r0.C
            r3.<init>(r5, r4)
            r0.f9826x = r3
            r3.setOnFrameAvailableListener(r0)
            android.graphics.SurfaceTexture r3 = r0.f9826x
            r3.setDefaultBufferSize(r1, r2)
            android.view.Surface r1 = new android.view.Surface
            android.graphics.SurfaceTexture r2 = r0.f9826x
            r1.<init>(r2)
            r0.f9827y = r1
        L_0x0232:
            o1.b r1 = r0.A
            r1.g()
            goto L_0x0255
        L_0x0238:
            android.view.Surface r1 = r0.f9828z
            r0.f9827y = r1
            goto L_0x0255
        L_0x023d:
            r1 = 2
            r7 = 0
        L_0x023f:
            if (r7 >= r1) goto L_0x0255
            java.util.ArrayList<java.nio.ByteBuffer> r2 = r0.f9822t
            int r3 = r0.f9809g
            int r4 = r0.f9810h
            int r3 = r3 * r4
            int r3 = r3 * 3
            int r3 = r3 / r1
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocateDirect(r3)
            r2.add(r3)
            int r7 = r7 + 1
            goto L_0x023f
        L_0x0255:
            android.graphics.Rect r1 = new android.graphics.Rect
            int r2 = r0.f9811i
            int r3 = r0.f9812j
            r4 = 0
            r1.<init>(r4, r4, r2, r3)
            r0.f9820r = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.f9819q = r1
            return
        L_0x0269:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "invalid encoder inputs"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.heifwriter.HeifEncoder.<init>(int, int, boolean, int, int, android.os.Handler, androidx.heifwriter.HeifEncoder$Callback):void");
    }

    public static void g(ByteBuffer byteBuffer, Image image, int i11, int i12, Rect rect, Rect rect2) {
        int i13;
        int i14;
        Rect rect3 = rect;
        Rect rect4 = rect2;
        if (rect.width() == rect2.width() && rect.height() == rect2.height()) {
            if (i11 % 2 == 0 && i12 % 2 == 0) {
                int i15 = 2;
                if (rect3.left % 2 == 0 && rect3.top % 2 == 0 && rect3.right % 2 == 0 && rect3.bottom % 2 == 0 && rect4.left % 2 == 0 && rect4.top % 2 == 0 && rect4.right % 2 == 0 && rect4.bottom % 2 == 0) {
                    Image.Plane[] planes = image.getPlanes();
                    int i16 = 0;
                    while (i16 < planes.length) {
                        ByteBuffer buffer = planes[i16].getBuffer();
                        int pixelStride = planes[i16].getPixelStride();
                        int min = Math.min(rect.width(), i11 - rect3.left);
                        int min2 = Math.min(rect.height(), i12 - rect3.top);
                        if (i16 > 0) {
                            i14 = ((i11 * i12) * (i16 + 3)) / 4;
                            i13 = i15;
                        } else {
                            i13 = 1;
                            i14 = 0;
                        }
                        for (int i17 = 0; i17 < min2 / i13; i17++) {
                            byteBuffer.position(((((rect3.top / i13) + i17) * i11) / i13) + i14 + (rect3.left / i13));
                            buffer.position((((rect4.top / i13) + i17) * planes[i16].getRowStride()) + ((rect4.left * pixelStride) / i13));
                            int i18 = 0;
                            while (true) {
                                int i19 = min / i13;
                                if (i18 >= i19) {
                                    break;
                                }
                                buffer.put(byteBuffer.get());
                                if (pixelStride > 1 && i18 != i19 - 1) {
                                    buffer.position((buffer.position() + pixelStride) - 1);
                                }
                                i18++;
                            }
                        }
                        ByteBuffer byteBuffer2 = byteBuffer;
                        i16++;
                        i15 = 2;
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("src or dst are not aligned!");
        }
        throw new IllegalArgumentException("src and dst rect size are different!");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:19:0x0003, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.nio.ByteBuffer a() {
        /*
            r3 = this;
            java.util.ArrayList<java.nio.ByteBuffer> r0 = r3.f9822t
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r3.f9818p     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x0015
            java.util.ArrayList<java.nio.ByteBuffer> r1 = r3.f9822t     // Catch:{ all -> 0x0026 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0015
            java.util.ArrayList<java.nio.ByteBuffer> r1 = r3.f9822t     // Catch:{ InterruptedException -> 0x0003 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0003 }
            goto L_0x0003
        L_0x0015:
            boolean r1 = r3.f9818p     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x001b
            r1 = 0
            goto L_0x0024
        L_0x001b:
            java.util.ArrayList<java.nio.ByteBuffer> r1 = r3.f9822t     // Catch:{ all -> 0x0026 }
            r2 = 0
            java.lang.Object r1 = r1.remove(r2)     // Catch:{ all -> 0x0026 }
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return r1
        L_0x0026:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.heifwriter.HeifEncoder.a():java.nio.ByteBuffer");
    }

    public void b(Bitmap bitmap) {
        if (this.f9808f != 2) {
            throw new IllegalStateException("addBitmap is only allowed in bitmap input mode");
        } else if (this.f9825w.d(f(this.f9817o) * 1000, f((this.f9817o + this.f9815m) - 1))) {
            synchronized (this) {
                o1.b bVar = this.A;
                if (bVar != null) {
                    bVar.f();
                    this.B.d(this.C, bitmap);
                    j();
                    this.A.g();
                }
            }
        }
    }

    public void close() {
        synchronized (this.f9822t) {
            this.f9818p = true;
            this.f9822t.notifyAll();
        }
        this.f9807e.postAtFrontOfQueue(new b());
    }

    public final void e(byte[] bArr) {
        ByteBuffer a11 = a();
        if (a11 != null) {
            a11.clear();
            if (bArr != null) {
                a11.put(bArr);
            }
            a11.flip();
            synchronized (this.f9823u) {
                this.f9823u.add(a11);
            }
            this.f9807e.post(new a());
        }
    }

    public final long f(int i11) {
        return ((((long) i11) * 1000000) / ((long) this.f9815m)) + 132;
    }

    public final void j() {
        GLES20.glViewport(0, 0, this.f9811i, this.f9812j);
        for (int i11 = 0; i11 < this.f9813k; i11++) {
            for (int i12 = 0; i12 < this.f9814l; i12++) {
                int i13 = this.f9811i;
                int i14 = i12 * i13;
                int i15 = this.f9812j;
                int i16 = i11 * i15;
                this.f9819q.set(i14, i16, i13 + i14, i15 + i16);
                this.B.a(this.C, o1.c.f16240i, this.f9819q);
                o1.b bVar = this.A;
                int i17 = this.f9817o;
                this.f9817o = i17 + 1;
                bVar.i(f(i17) * 1000);
                this.A.j();
            }
        }
    }

    public final ByteBuffer k() {
        ByteBuffer byteBuffer;
        if (!this.f9818p && this.f9821s == null) {
            synchronized (this.f9823u) {
                if (this.f9823u.isEmpty()) {
                    byteBuffer = null;
                } else {
                    byteBuffer = this.f9823u.remove(0);
                }
                this.f9821s = byteBuffer;
            }
        }
        if (this.f9818p) {
            return null;
        }
        return this.f9821s;
    }

    public void l() {
        int i11;
        while (true) {
            ByteBuffer k11 = k();
            if (k11 != null && !this.f9824v.isEmpty()) {
                int i12 = 0;
                int intValue = this.f9824v.remove(0).intValue();
                boolean z11 = this.f9817o % this.f9815m == 0 && k11.remaining() == 0;
                if (!z11) {
                    Image inputImage = this.f9804b.getInputImage(intValue);
                    int i13 = this.f9811i;
                    int i14 = this.f9817o;
                    int i15 = this.f9814l;
                    int i16 = (i14 % i15) * i13;
                    int i17 = this.f9812j;
                    int i18 = ((i14 / i15) % this.f9813k) * i17;
                    this.f9819q.set(i16, i18, i13 + i16, i17 + i18);
                    g(k11, inputImage, this.f9809g, this.f9810h, this.f9819q, this.f9820r);
                }
                MediaCodec mediaCodec = this.f9804b;
                if (z11) {
                    i11 = 0;
                } else {
                    i11 = mediaCodec.getInputBuffer(intValue).capacity();
                }
                int i19 = this.f9817o;
                this.f9817o = i19 + 1;
                long f11 = f(i19);
                if (z11) {
                    i12 = 4;
                }
                mediaCodec.queueInputBuffer(intValue, 0, i11, f11, i12);
                if (z11 || this.f9817o % this.f9815m == 0) {
                    m(z11);
                }
            } else {
                return;
            }
        }
    }

    public final void m(boolean z11) {
        synchronized (this.f9822t) {
            this.f9818p = z11 | this.f9818p;
            this.f9822t.add(this.f9821s);
            this.f9822t.notifyAll();
        }
        this.f9821s = null;
    }

    public void n() {
        this.f9804b.start();
    }

    public void o() {
        int i11 = this.f9808f;
        if (i11 == 2) {
            this.f9825w.c(0);
        } else if (i11 == 0) {
            e((byte[]) null);
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            o1.b bVar = this.A;
            if (bVar != null) {
                bVar.f();
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(this.D);
                if (this.f9825w.d(surfaceTexture.getTimestamp(), f((this.f9817o + this.f9815m) - 1))) {
                    j();
                }
                surfaceTexture.releaseTexImage();
                this.A.g();
            }
        }
    }

    public void p() {
        MediaCodec mediaCodec = this.f9804b;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f9804b.release();
            this.f9804b = null;
        }
        synchronized (this.f9822t) {
            this.f9818p = true;
            this.f9822t.notifyAll();
        }
        synchronized (this) {
            o1.a aVar = this.B;
            if (aVar != null) {
                aVar.e(false);
                this.B = null;
            }
            o1.b bVar = this.A;
            if (bVar != null) {
                bVar.h();
                this.A = null;
            }
            SurfaceTexture surfaceTexture = this.f9826x;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.f9826x = null;
            }
        }
    }
}
