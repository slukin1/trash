package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.w;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.common.d;
import com.tencent.liteav.videobase.videobase.c;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoconsumer.decoder.SpsInfo;
import com.tencent.liteav.videoproducer.encoder.e;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.a;
import com.tencent.ugc.videobase.base.VideoPersistStorageKey;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class b {
    private long A = 0;
    private long B = 0;
    private long C = 0;
    private long D = 0;
    private long E = 0;
    private final Deque<Long> F = new LinkedList();
    private int G = 0;
    private final List<Long> H = new ArrayList();
    private final AtomicLong I = new AtomicLong(0);

    /* renamed from: a  reason: collision with root package name */
    public String f22664a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f22665b;

    /* renamed from: c  reason: collision with root package name */
    public CustomHandler f22666c;

    /* renamed from: d  reason: collision with root package name */
    public MediaCodec f22667d;

    /* renamed from: e  reason: collision with root package name */
    public e.a f22668e;

    /* renamed from: f  reason: collision with root package name */
    public VideoEncodeParams f22669f;

    /* renamed from: g  reason: collision with root package name */
    public long f22670g = 0;

    /* renamed from: h  reason: collision with root package name */
    public w f22671h = null;

    /* renamed from: i  reason: collision with root package name */
    public final Deque<Long> f22672i = new LinkedList();

    /* renamed from: j  reason: collision with root package name */
    public final AtomicLong f22673j = new AtomicLong(0);

    /* renamed from: k  reason: collision with root package name */
    public final Runnable f22674k = c.a(this);

    /* renamed from: l  reason: collision with root package name */
    private final c f22675l;

    /* renamed from: m  reason: collision with root package name */
    private final a.C0177a f22676m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f22677n = null;

    /* renamed from: o  reason: collision with root package name */
    private boolean f22678o = true;

    /* renamed from: p  reason: collision with root package name */
    private long f22679p = 0;

    /* renamed from: q  reason: collision with root package name */
    private long f22680q = 0;

    /* renamed from: r  reason: collision with root package name */
    private long f22681r = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f22682s = -1;

    /* renamed from: t  reason: collision with root package name */
    private long f22683t = 0;

    /* renamed from: u  reason: collision with root package name */
    private long f22684u = 0;

    /* renamed from: v  reason: collision with root package name */
    private long f22685v = 0;

    /* renamed from: w  reason: collision with root package name */
    private long f22686w = Long.MIN_VALUE;

    /* renamed from: x  reason: collision with root package name */
    private boolean f22687x = false;

    /* renamed from: y  reason: collision with root package name */
    private ServerVideoProducerConfig f22688y;

    /* renamed from: z  reason: collision with root package name */
    private double f22689z = 0.0d;

    public b(Bundle bundle, c cVar, String str) {
        this.f22675l = cVar;
        this.f22665b = bundle;
        this.f22676m = a.C0177a.STREAM_TYPE_BIG_VIDEO;
        this.f22664a = str + "SurfaceInputVideoEncoder_" + hashCode();
    }

    private void e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime <= this.A + TimeUnit.SECONDS.toMillis(2)) {
            this.B++;
            return;
        }
        this.f22689z = (((double) this.B) * 1000.0d) / ((double) (elapsedRealtime - this.A));
        this.B = 1;
        this.A = elapsedRealtime;
        long j11 = -1;
        for (Long longValue : this.H) {
            long longValue2 = longValue.longValue();
            if (j11 < longValue2) {
                j11 = longValue2;
            }
        }
        this.I.set(j11);
        this.H.clear();
    }

    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
        this.f22688y = serverVideoProducerConfig;
        String str = this.f22664a;
        LiteavLog.i(str, "Set serverConfig: " + this.f22688y);
    }

    public final void b() {
        if (this.f22671h != null) {
            LiteavLog.i(this.f22664a, "stopEosTimer");
            this.f22671h.a();
            this.f22671h = null;
        }
    }

    public final void c() {
        ByteBuffer byteBuffer;
        int i11;
        byte[] bArr;
        long j11;
        boolean z11;
        Long peekFirst;
        if (this.f22667d != null) {
            while (true) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                try {
                    int dequeueOutputBuffer = this.f22667d.dequeueOutputBuffer(bufferInfo, 0);
                    if (dequeueOutputBuffer == -1) {
                        break;
                    } else if (dequeueOutputBuffer == -3) {
                        LiteavLog.i(this.f22664a, "encoder output buffers changed");
                    } else if (dequeueOutputBuffer == -2) {
                        try {
                            MediaFormat outputFormat = this.f22667d.getOutputFormat();
                            e.a aVar = this.f22668e;
                            if (aVar != null) {
                                aVar.onOutputFormatChanged(outputFormat);
                            }
                            LiteavLog.i(this.f22664a, "encoder output format changed: %s", outputFormat);
                        } catch (Throwable th2) {
                            a("getOutputFormat failed." + th2.getMessage());
                        }
                    } else if (dequeueOutputBuffer < 0) {
                        a("dequeueOutputBuffer return ".concat(String.valueOf(dequeueOutputBuffer)));
                        break;
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        this.H.add(Long.valueOf(elapsedRealtime - this.f22673j.getAndSet(elapsedRealtime)));
                        try {
                            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                                byteBuffer = this.f22667d.getOutputBuffer(dequeueOutputBuffer);
                            } else {
                                byteBuffer = this.f22667d.getOutputBuffers()[dequeueOutputBuffer];
                            }
                            if (byteBuffer == null || ((i11 = bufferInfo.size) == 0 && (bufferInfo.flags & 4) == 0)) {
                                a("size is zero, but it isn't end of stream");
                            } else {
                                byte[] a11 = com.tencent.liteav.videobase.utils.e.a(i11);
                                if (a11 == null) {
                                    bArr = null;
                                } else {
                                    byteBuffer.position(bufferInfo.offset);
                                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                    byteBuffer.get(a11);
                                    bArr = a(a11);
                                    VideoEncodeParams videoEncodeParams = this.f22669f;
                                    if (videoEncodeParams != null && !videoEncodeParams.annexb) {
                                        bArr = b(bArr);
                                    }
                                }
                                if (bArr == null) {
                                    a("modifyEncodedData return null byte array");
                                } else {
                                    int i12 = bufferInfo.flags;
                                    boolean z12 = (i12 & 2) > 0;
                                    boolean z13 = (i12 & 1) > 0;
                                    if (z12 && z13) {
                                        VideoEncodeParams videoEncodeParams2 = this.f22669f;
                                        this.f22677n = SpsInfo.nativeGetSpsPps(bArr, videoEncodeParams2 == null || videoEncodeParams2.codecType == CodecType.H264, videoEncodeParams2 == null || videoEncodeParams2.annexb);
                                    } else if (z12) {
                                        this.f22677n = (byte[]) bArr.clone();
                                    } else if (this.f22678o && z13) {
                                        byte[] bArr2 = this.f22677n;
                                        if (bArr2 != null) {
                                            byte[] a12 = com.tencent.liteav.videobase.utils.e.a(bArr2.length + bArr.length);
                                            if (a12 != null) {
                                                byte[] bArr3 = this.f22677n;
                                                System.arraycopy(bArr3, 0, a12, 0, bArr3.length);
                                                System.arraycopy(bArr, 0, a12, this.f22677n.length, bArr.length);
                                                bArr = a12;
                                            } else {
                                                a("add spspps for I frame, allocate buffer failed.");
                                            }
                                        } else {
                                            a("mSpsPps is null.");
                                        }
                                    }
                                    boolean z14 = (bufferInfo.flags & 1) > 0;
                                    if (z14) {
                                        this.f22682s = -1;
                                    }
                                    VideoEncodeParams videoEncodeParams3 = this.f22669f;
                                    if (videoEncodeParams3 != null && !videoEncodeParams3.fullIFrame) {
                                        int i13 = this.f22682s + 1;
                                        this.f22682s = i13;
                                        if (i13 == videoEncodeParams3.fps * videoEncodeParams3.gop) {
                                            d();
                                        }
                                    }
                                    long length = (long) bArr.length;
                                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                    if (z14) {
                                        long j12 = this.D;
                                        if (elapsedRealtime2 > j12 + 1000) {
                                            this.C = (long) (((((double) this.E) * 8000.0d) / ((double) (elapsedRealtime2 - j12))) / 1024.0d);
                                            this.E = 0;
                                            this.D = elapsedRealtime2;
                                            if (!this.F.isEmpty()) {
                                                int i14 = this.f22669f.fps;
                                                if (((float) (((double) i14) - this.f22689z)) <= Math.max(((float) i14) / 2.0f, 5.0f) && (peekFirst = this.F.peekFirst()) != null && SystemClock.elapsedRealtime() > peekFirst.longValue()) {
                                                    this.F.removeFirst();
                                                    if (((long) this.G) - this.C > ((long) Math.max(this.f22669f.bitrate / 2, 100))) {
                                                        LiteavLog.w(this.f22664a, "restart hardware encoder because real bitrate is too low.expectBitrate: " + this.G + ", realBitrate=" + this.C);
                                                        this.f22665b.putBoolean("need_restart_when_down_bitrate", true);
                                                        this.f22674k.run();
                                                        this.F.clear();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    this.E += length;
                                    e();
                                    if (z14) {
                                        this.f22680q++;
                                        this.f22681r = 0;
                                    } else {
                                        this.f22681r++;
                                    }
                                    this.f22679p++;
                                    Long pollFirst = this.f22672i.pollFirst();
                                    if (pollFirst == null) {
                                        j11 = 0;
                                    } else {
                                        j11 = pollFirst.longValue();
                                    }
                                    long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
                                    if (this.f22683t == 0) {
                                        this.f22683t = j11;
                                    }
                                    if (this.f22684u == 0) {
                                        this.f22684u = millis;
                                    }
                                    long j13 = millis + (this.f22683t - this.f22684u);
                                    long j14 = this.f22685v;
                                    if (j11 <= j14) {
                                        j11 = j14 + 1;
                                    }
                                    if (j11 > j13) {
                                        j11 = j13;
                                    }
                                    this.f22685v = j11;
                                    EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
                                    VideoEncodeParams videoEncodeParams4 = this.f22669f;
                                    if (videoEncodeParams4 == null || !videoEncodeParams4.isEnablesUnlimitedGop()) {
                                        encodedVideoFrame.nalType = z14 ? d.IDR : d.P;
                                    } else {
                                        encodedVideoFrame.nalType = z14 ? d.IDR : d.P_MULTI_REF;
                                    }
                                    ByteBuffer b11 = com.tencent.liteav.videobase.utils.e.b(bArr.length);
                                    encodedVideoFrame.data = b11;
                                    if (b11 == null) {
                                        a("allocate direct buffer for nal failed");
                                    } else {
                                        b11.put(bArr);
                                        encodedVideoFrame.data.rewind();
                                        encodedVideoFrame.dts = j11;
                                        encodedVideoFrame.pts = j13;
                                        encodedVideoFrame.info = bufferInfo;
                                        encodedVideoFrame.gopIndex = this.f22680q;
                                        long j15 = this.f22681r;
                                        encodedVideoFrame.frameIndex = j15;
                                        encodedVideoFrame.gopFrameIndex = j15;
                                        if (!z14) {
                                            j15--;
                                        }
                                        encodedVideoFrame.refFrameIndex = j15;
                                        encodedVideoFrame.profileType = com.tencent.liteav.videobase.common.e.BASELINE;
                                        VideoEncodeParams videoEncodeParams5 = this.f22669f;
                                        encodedVideoFrame.codecType = videoEncodeParams5.codecType;
                                        encodedVideoFrame.width = videoEncodeParams5.width;
                                        encodedVideoFrame.height = videoEncodeParams5.height;
                                        if ((bufferInfo.flags & 4) > 0) {
                                            b();
                                            z11 = true;
                                        } else {
                                            boolean z15 = videoEncodeParams5.enableBFrame;
                                            if (!z15 && !this.f22687x && j13 < this.f22686w) {
                                                LiteavLog.i(this.f22664a, "has B frame,isEnablesBframe=%b,mLastPresentationTimestamp=%d,packet.pts=%d", Boolean.valueOf(z15), Long.valueOf(this.f22686w), Long.valueOf(encodedVideoFrame.pts));
                                                this.f22687x = true;
                                                PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
                                                persistStorage.put(VideoPersistStorageKey.CONFIG_KEY_LOCAL_RTC_ENCODE_HIGH_PROFILE, 0);
                                                persistStorage.commit();
                                                e.a aVar2 = this.f22668e;
                                                if (aVar2 != null) {
                                                    aVar2.a();
                                                }
                                            }
                                            this.f22686w = encodedVideoFrame.pts;
                                            z11 = false;
                                        }
                                        e.a aVar3 = this.f22668e;
                                        if (aVar3 != null) {
                                            aVar3.onEncodedNAL(encodedVideoFrame, z11);
                                        }
                                    }
                                }
                            }
                            MediaCodec mediaCodec = this.f22667d;
                            if (mediaCodec != null) {
                                try {
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    a("releaseOutputBuffer failed." + th4.getMessage());
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th5) {
                            a("getOutputBuffer failed." + th5.getMessage());
                        }
                    }
                } catch (Throwable th6) {
                    a("dequeueOutputBuffer failed." + th6.getMessage());
                }
            }
            if (!this.f22672i.isEmpty()) {
                int i15 = this.f22669f.fps;
                int i16 = i15 != 0 ? 500 / i15 : 10;
                if (!this.f22666c.hasMessages(10)) {
                    this.f22666c.sendEmptyMessageDelayed(10, (long) i16);
                }
            }
        }
    }

    public final void d() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 19 && this.f22667d != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.f22667d.setParameters(bundle);
            } catch (Throwable th2) {
                LiteavLog.e(this.f22664a, "requestSyncFrame failed.", th2);
            }
        }
    }

    public final void a(int i11) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i12 = 1; i12 <= 3; i12++) {
            this.F.addLast(Long.valueOf(((long) (i12 * 2000)) + elapsedRealtime));
        }
        this.G = i11;
    }

    private static byte[] b(byte[] bArr) {
        int i11;
        int length = bArr.length;
        ArrayList<int[]> arrayList = new ArrayList<>(20);
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 <= length) {
            int i15 = i12 + 2;
            if (i15 < length && bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i15] == 1) {
                i11 = 3;
            } else {
                int i16 = i12 + 3;
                i11 = (i16 < length && bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i15] == 0 && bArr[i16] == 1) ? 4 : 1;
            }
            if (i11 == 3 || i11 == 4 || i12 == length) {
                if (i14 != i12) {
                    arrayList.add(new int[]{i14, i12});
                    i13 += i12 - i14;
                }
                i14 = i12 + i11;
            }
            i12 += i11;
        }
        byte[] a11 = com.tencent.liteav.videobase.utils.e.a(i13 + (arrayList.size() * 4));
        if (a11 == null) {
            return bArr;
        }
        int i17 = 0;
        for (int[] iArr : arrayList) {
            int i18 = iArr[1] - iArr[0];
            ByteBuffer order = ByteBuffer.wrap(new byte[4]).order(ByteOrder.BIG_ENDIAN);
            order.putInt(i18);
            System.arraycopy(order.array(), 0, a11, i17, 4);
            int i19 = i17 + 4;
            System.arraycopy(bArr, iArr[0], a11, i19, i18);
            i17 = i19 + i18;
        }
        return a11;
    }

    public final void a(MediaCodec mediaCodec, int i11) {
        if (mediaCodec != null && LiteavSystemInfo.getSystemOSVersionInt() >= 19) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", i11 * 1024);
                mediaCodec.setParameters(bundle);
            } catch (Throwable th2) {
                LiteavLog.e(this.f22664a, "updateBitrateToMediaCodec failed.", th2);
            }
        }
    }

    private void a(String str) {
        LiteavLog.e(this.f22664a, "notifyEncodeError message = ".concat(String.valueOf(str)));
        e.a aVar = this.f22668e;
        if (aVar != null) {
            aVar.onEncodedFail(e.a.ERR_VIDEO_ENCODE_FAIL);
        }
    }

    public final void a() {
        this.f22666c.removeMessages(10);
        a(this.f22667d);
        this.f22667d = null;
    }

    private MediaCodec b(String str) throws Throwable {
        String str2;
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        try {
            str2 = createEncoderByType.getName();
        } catch (Throwable th2) {
            LiteavLog.e(this.f22664a, "mediaCodec getName failed.", th2);
            str2 = null;
        }
        LiteavLog.i(this.f22664a, "codecName=".concat(String.valueOf(str2)));
        if (str2 == null || !str2.equals("OMX.google.h264.encoder")) {
            return createEncoderByType;
        }
        LiteavLog.w(this.f22664a, "will be destroyed codecName=".concat(str2));
        a(createEncoderByType);
        throw new IOException("this is a Google H264 soft encoder. cancel use MediaCodec.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (a(r1, r3) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.Surface a(com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r9) {
        /*
            r8 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            r8.f22670g = r0
            r0 = -9223372036854775808
            r8.f22686w = r0
            int r0 = r9.bitrate
            if (r0 != 0) goto L_0x0023
            int r0 = r9.width
            int r0 = r0 * r0
            int r1 = r9.height
            int r1 = r1 * r1
            int r0 = r0 + r1
            double r0 = (double) r0
            double r0 = java.lang.Math.sqrt(r0)
            r2 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r0 = r0 * r2
            int r0 = (int) r0
            r9.bitrate = r0
        L_0x0023:
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = new com.tencent.liteav.videoproducer.encoder.VideoEncodeParams
            r0.<init>(r9)
            r8.f22669f = r0
            long r1 = r0.baseFrameIndex
            r8.f22679p = r1
            long r1 = r0.baseGopIndex
            r8.f22680q = r1
            r1 = 0
            r8.f22681r = r1
            com.tencent.liteav.videobase.common.CodecType r9 = r0.codecType
            com.tencent.liteav.videobase.common.CodecType r1 = com.tencent.liteav.videobase.common.CodecType.H265
            if (r9 != r1) goto L_0x003f
            java.lang.String r9 = "video/hevc"
            goto L_0x0041
        L_0x003f:
            java.lang.String r9 = "video/avc"
        L_0x0041:
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r1 = r0.encoderProfile
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r2 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.PROFILE_MAIN
            if (r1 != r2) goto L_0x004b
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r1 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.PROFILE_HIGH
            r0.encoderProfile = r1
        L_0x004b:
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r0 = r0.encoderProfile
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r1 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.PROFILE_HIGH
            if (r0 == r1) goto L_0x0053
            if (r0 != r2) goto L_0x0064
        L_0x0053:
            com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig r0 = r8.f22688y
            if (r0 == 0) goto L_0x0064
            boolean r0 = r0.isHardwareEncoderHighProfileAllowed()
            if (r0 == 0) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r8.f22669f
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r3 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.PROFILE_BASELINE
            r0.encoderProfile = r3
        L_0x0064:
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r8.f22669f
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r3 = r0.encoderProfile
            if (r3 == r1) goto L_0x006c
            if (r3 != r2) goto L_0x009b
        L_0x006c:
            boolean r0 = r0.enableBFrame
            if (r0 != 0) goto L_0x009b
            com.tencent.liteav.base.storage.PersistStorage r0 = new com.tencent.liteav.base.storage.PersistStorage
            java.lang.String r1 = "com.liteav.storage.global"
            r0.<init>(r1)
            java.lang.String r1 = "Liteav.Video.android.local.rtc.enable.high.profile"
            java.lang.Integer r0 = r0.getInt(r1)
            java.lang.String r1 = r8.f22664a
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "enable high profile from persist storage:"
            java.lang.String r2 = r3.concat(r2)
            com.tencent.liteav.base.util.LiteavLog.i(r1, r2)
            if (r0 == 0) goto L_0x009b
            int r0 = r0.intValue()
            if (r0 == 0) goto L_0x0095
            goto L_0x009b
        L_0x0095:
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r8.f22669f
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r1 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.PROFILE_BASELINE
            r0.encoderProfile = r1
        L_0x009b:
            r0 = 0
            android.media.MediaCodec r1 = r8.b((java.lang.String) r9)     // Catch:{ all -> 0x0164 }
            com.tencent.liteav.videoproducer.encoder.a r2 = new com.tencent.liteav.videoproducer.encoder.a     // Catch:{ all -> 0x0161 }
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r3 = r8.f22669f     // Catch:{ all -> 0x0161 }
            com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig r4 = r8.f22688y     // Catch:{ all -> 0x0161 }
            java.lang.Boolean r4 = r4.isHardwareEncoderBitrateModeCBRSupported()     // Catch:{ all -> 0x0161 }
            r2.<init>(r1, r9, r3, r4)     // Catch:{ all -> 0x0161 }
            r9 = 1
            r2.f22656a = r9     // Catch:{ all -> 0x0161 }
            android.media.MediaFormat r3 = r2.a()     // Catch:{ all -> 0x0161 }
            boolean r4 = r8.a((android.media.MediaCodec) r1, (android.media.MediaFormat) r3)     // Catch:{ all -> 0x0161 }
            r5 = 0
            if (r4 != 0) goto L_0x00c7
            r2.f22657b = r5     // Catch:{ all -> 0x0161 }
            android.media.MediaFormat r3 = r2.a()     // Catch:{ all -> 0x0161 }
            boolean r2 = r8.a((android.media.MediaCodec) r1, (android.media.MediaFormat) r3)     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x00c8
        L_0x00c7:
            r5 = r9
        L_0x00c8:
            if (r5 == 0) goto L_0x0159
            android.view.Surface r2 = r1.createInputSurface()     // Catch:{ all -> 0x0161 }
            r1.start()     // Catch:{ all -> 0x0157 }
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r4 = r8.f22669f     // Catch:{ all -> 0x013d }
            java.lang.String r5 = "width"
            int r5 = r3.getInteger(r5)     // Catch:{ all -> 0x013d }
            r4.width = r5     // Catch:{ all -> 0x013d }
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r4 = r8.f22669f     // Catch:{ all -> 0x013d }
            java.lang.String r5 = "height"
            int r5 = r3.getInteger(r5)     // Catch:{ all -> 0x013d }
            r4.height = r5     // Catch:{ all -> 0x013d }
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r4 = r8.f22669f     // Catch:{ all -> 0x013d }
            java.lang.String r5 = "bitrate"
            int r5 = r3.getInteger(r5)     // Catch:{ all -> 0x013d }
            int r5 = r5 / 1024
            r4.bitrate = r5     // Catch:{ all -> 0x013d }
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r4 = r8.f22669f     // Catch:{ all -> 0x013d }
            int r4 = r4.bitrate     // Catch:{ all -> 0x013d }
            int r5 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()     // Catch:{ all -> 0x013d }
            r6 = 30
            if (r5 > r6) goto L_0x00fe
            goto L_0x0110
        L_0x00fe:
            java.lang.String r5 = r8.f22664a     // Catch:{ all -> 0x013d }
            java.lang.String r6 = "resetBitrateAfterApiLevel30,bitrate="
            java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x013d }
            java.lang.String r6 = r6.concat(r7)     // Catch:{ all -> 0x013d }
            com.tencent.liteav.base.util.LiteavLog.i(r5, r6)     // Catch:{ all -> 0x013d }
            r8.a((android.media.MediaCodec) r1, (int) r4)     // Catch:{ all -> 0x013d }
        L_0x0110:
            com.tencent.liteav.videoproducer.encoder.e$a r4 = r8.f22668e     // Catch:{ all -> 0x013d }
            if (r4 == 0) goto L_0x0145
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode r4 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.BitrateMode.UNKNOWN     // Catch:{ all -> 0x013d }
            int r5 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()     // Catch:{ all -> 0x013d }
            r6 = 21
            if (r5 < r6) goto L_0x0137
            java.lang.String r5 = "bitrate-mode"
            r6 = -1
            int r5 = r3.getInteger(r5, r6)     // Catch:{ all -> 0x013d }
            if (r5 == r6) goto L_0x0137
            if (r5 == 0) goto L_0x0135
            if (r5 == r9) goto L_0x0132
            r9 = 2
            if (r5 == r9) goto L_0x012f
            goto L_0x0137
        L_0x012f:
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode r4 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.BitrateMode.CBR     // Catch:{ all -> 0x013d }
            goto L_0x0137
        L_0x0132:
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode r4 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.BitrateMode.VBR     // Catch:{ all -> 0x013d }
            goto L_0x0137
        L_0x0135:
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode r4 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.BitrateMode.CQ     // Catch:{ all -> 0x013d }
        L_0x0137:
            com.tencent.liteav.videoproducer.encoder.e$a r9 = r8.f22668e     // Catch:{ all -> 0x013d }
            r9.onBitrateModeUpdated(r4)     // Catch:{ all -> 0x013d }
            goto L_0x0145
        L_0x013d:
            r9 = move-exception
            java.lang.String r4 = r8.f22664a     // Catch:{ all -> 0x0157 }
            java.lang.String r5 = "MediaFormat get key fail"
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r4, (java.lang.String) r5, (java.lang.Throwable) r9)     // Catch:{ all -> 0x0157 }
        L_0x0145:
            java.lang.String r9 = r8.f22664a     // Catch:{ all -> 0x0157 }
            java.lang.String r4 = "start MediaCodec with format: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0157 }
            java.lang.String r3 = r4.concat(r3)     // Catch:{ all -> 0x0157 }
            com.tencent.liteav.base.util.LiteavLog.i(r9, r3)     // Catch:{ all -> 0x0157 }
            r8.f22667d = r1
            return r2
        L_0x0157:
            r9 = move-exception
            goto L_0x0167
        L_0x0159:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0161 }
            java.lang.String r2 = "configure encoder failed."
            r9.<init>(r2)     // Catch:{ all -> 0x0161 }
            throw r9     // Catch:{ all -> 0x0161 }
        L_0x0161:
            r9 = move-exception
            r2 = r0
            goto L_0x0167
        L_0x0164:
            r9 = move-exception
            r1 = r0
            r2 = r1
        L_0x0167:
            if (r2 == 0) goto L_0x016c
            r2.release()
        L_0x016c:
            r8.a((android.media.MediaCodec) r1)
            com.tencent.liteav.videobase.videobase.e$c r1 = com.tencent.liteav.videobase.videobase.e.c.WARNING_VIDEO_ENCODE_START_FAILED
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Start encoder failed:"
            r2.<init>(r3)
            java.lang.String r3 = r9.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            int r3 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r4 = 23
            if (r3 < r4) goto L_0x01ae
            boolean r3 = r9 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x01ae
            r3 = r9
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            int r3 = r3.getErrorCode()
            r4 = 1100(0x44c, float:1.541E-42)
            if (r3 != r4) goto L_0x01ae
            com.tencent.liteav.videobase.videobase.e$c r1 = com.tencent.liteav.videobase.videobase.e.c.WARNING_VIDEO_ENCODE_START_FAILED_INSUFFICIENT_RESOURCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Insufficient resource, Start encoder failed:"
            r2.<init>(r3)
            java.lang.String r3 = r9.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
        L_0x01ae:
            com.tencent.liteav.videobase.videobase.c r3 = r8.f22675l
            com.tencent.liteav.videobase.videobase.f r4 = com.tencent.liteav.videobase.videobase.f.STATUS_VIDEO_HW_ENCODE_START_ERROR_TYPE
            com.tencent.liteav.videoproducer.producer.a$a r5 = r8.f22676m
            int r5 = r5.mValue
            int r6 = r1.mValue
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3.updateStatus(r4, r5, r6)
            com.tencent.liteav.videobase.videobase.c r3 = r8.f22675l
            r3.notifyWarning(r1, r2)
            java.lang.String r1 = r8.f22664a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Start MediaCodec failed,encode params:"
            r2.<init>(r3)
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r3 = r8.f22669f
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.b.a(com.tencent.liteav.videoproducer.encoder.VideoEncodeParams):android.view.Surface");
    }

    private boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return false;
        }
        try {
            LiteavLog.i(this.f22664a, "configure format: %s", mediaFormat);
            mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return true;
        } catch (Throwable th2) {
            LiteavLog.e(this.f22664a, "configure failed.", th2);
            return false;
        }
    }

    private static byte[] a(byte[] bArr) {
        byte[] a11;
        if (bArr.length > 5 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 3;
                if (i12 < bArr.length) {
                    if ((bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 0 && bArr[i12] == 1) || (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 1)) {
                        break;
                    }
                    i11++;
                } else {
                    i11 = 0;
                    break;
                }
            }
            if (i11 == 0 || (a11 = com.tencent.liteav.videobase.utils.e.a(bArr.length - i11)) == null) {
                return bArr;
            }
            System.arraycopy(bArr, i11, a11, 0, a11.length);
            return a11;
        }
        return bArr;
    }

    private void a(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Throwable th2) {
                LiteavLog.e(this.f22664a, "destroy mediaCodec stop failed.", th2);
            }
            try {
                mediaCodec.release();
            } catch (Throwable th3) {
                LiteavLog.e(this.f22664a, "destroy mediaCodec release failed.", th3);
            }
            LiteavLog.i(this.f22664a, "destroy mediaCodec");
        }
    }
}
