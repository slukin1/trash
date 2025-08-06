package com.tencent.liteav.videoconsumer2;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.common.base.Ascii;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.common.MediaCodecAbility;
import com.tencent.liteav.videobase.utils.c;
import com.tencent.liteav.videobase.videobase.e;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::video")
public class HardwareVideoDecoder2 implements SurfaceTexture.OnFrameAvailableListener {
    private static final int DRAIN_ERROR = -1;
    private static final int DRAIN_SUCCESS = 0;
    private static final int DRAIN_SUCCESS_MEET_END_OF_STREAM = 1;
    private final MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private final c mDecoderMediaFormatBuilder;
    private boolean mEnableLimitMaxDecFrameBufferingInH264Sps = true;
    private boolean mIsRealTime;
    private boolean mIsStarted;
    private MediaCodec mMediaCodec = null;
    private long mNativeVideoDecoderImplAndroid;
    private Surface mOutputSurface;
    private final com.tencent.liteav.videoconsumer.a.a mSPSModifier = new com.tencent.liteav.videoconsumer.a.a();
    private SurfaceTexture mSurfaceTexture;
    private final String mTAG;
    private final b mThrottlers = new b();
    private boolean mUseSoftwareDecoder = false;

    public HardwareVideoDecoder2(String str, boolean z11, boolean z12, int i11, int i12, boolean z13, long j11) {
        this.mTAG = str + "HardwareVideoDecoder2";
        this.mIsRealTime = z11;
        this.mUseSoftwareDecoder = z13;
        this.mNativeVideoDecoderImplAndroid = j11;
        c cVar = new c();
        cVar.f22244c = z12 ? "video/hevc" : "video/avc";
        cVar.f22242a = i11;
        cVar.f22243b = i12;
        this.mDecoderMediaFormatBuilder = cVar;
    }

    private boolean configureDecoder(a aVar, boolean z11) {
        String str;
        c cVar = this.mDecoderMediaFormatBuilder;
        cVar.f22245d = z11;
        MediaFormat a11 = cVar.a();
        LiteavLog.i(this.mTAG, "mediaFormat:".concat(String.valueOf(a11)));
        try {
            MediaCodec createMediaCodecInternal = createMediaCodecInternal(this.mUseSoftwareDecoder, a11.getString("mime"));
            aVar.f22511a = createMediaCodecInternal;
            createMediaCodecInternal.configure(a11, this.mOutputSurface, (MediaCrypto) null, 0);
            aVar.f22511a.setVideoScalingMode(1);
            aVar.f22511a.start();
            LiteavLog.i(this.mTAG, "Start MediaCodec(%s) success.", aVar.f22511a.getName());
            return true;
        } catch (Throwable th2) {
            LiteavLog.e(this.mTAG, "Start MediaCodec failed.", th2);
            destroyMediaCodec(aVar.f22511a);
            aVar.f22511a = null;
            e.c cVar2 = e.c.WARNING_VIDEO_DECODE_START_FAILED;
            if (th2 instanceof IllegalArgumentException) {
                cVar2 = e.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_ARGUMENT;
                str = "VideoDecode: illegal argument, Start decoder failed";
            } else if (th2 instanceof IllegalStateException) {
                cVar2 = e.c.WARNING_VIDEO_DECODE_START_FAILED_ILLEGAL_STATE;
                str = "VideoDecode: illegal state, Start decoder failed";
            } else {
                str = "VideoDecode: Start decoder failed";
            }
            aVar.f22512b = cVar2;
            aVar.f22513c = str;
            aVar.f22514d = th2;
            return false;
        }
    }

    private void destroyMediaCodec(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                LiteavLog.i(this.mTAG, "mediaCodec stop");
                mediaCodec.stop();
                LiteavLog.i(this.mTAG, "mediaCodec release");
                mediaCodec.release();
            } catch (Throwable th2) {
                LiteavLog.e(this.mTAG, "release MediaCodec failed.", th2);
            }
        }
    }

    private int drainDecodedFrameInternal() {
        int dequeueOutputBuffer;
        int i11 = 0;
        while (true) {
            if (i11 >= 3 || (dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, TimeUnit.MILLISECONDS.toMicros(10))) == -1) {
                return -1;
            }
            if (dequeueOutputBuffer == -3) {
                LiteavLog.i(this.mTAG, "on output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                outputFormatChange();
            } else if (dequeueOutputBuffer >= 0) {
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                if ((this.mBufferInfo.flags & 4) == 0) {
                    return 0;
                }
                LiteavLog.i(this.mTAG, "meet end of stream.");
                return 1;
            } else {
                LiteavLog.d(this.mTAG, "dequeueOutputBuffer get invalid index: %d", Integer.valueOf(dequeueOutputBuffer));
            }
            i11++;
        }
        return -1;
    }

    private boolean feedDataToMediaCodec(EncodedVideoFrame encodedVideoFrame) {
        ByteBuffer byteBuffer;
        if (this.mMediaCodec == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            return false;
        } else if (encodedVideoFrame == null || (!encodedVideoFrame.isEosFrame && ((byteBuffer = encodedVideoFrame.data) == null || byteBuffer.remaining() == 0))) {
            LiteavLog.w(this.mTAG, "receive empty buffer.");
            return true;
        } else {
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            if (inputBuffers == null || inputBuffers.length == 0) {
                LiteavLog.e(this.mTAG, "get invalid input buffers.");
                return false;
            }
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(10000);
            if (dequeueInputBuffer < 0) {
                return false;
            }
            if (!encodedVideoFrame.isEosFrame) {
                limitMaxDecFrameBufferingInH264Sps(encodedVideoFrame);
                int remaining = encodedVideoFrame.data.remaining();
                inputBuffers[dequeueInputBuffer].put(encodedVideoFrame.data);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, remaining, TimeUnit.MILLISECONDS.toMicros(encodedVideoFrame.pts), 0);
            } else {
                LiteavLog.i(this.mTAG, "feedDataToMediaCodec BUFFER_FLAG_END_OF_STREAM");
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
            }
            return true;
        }
    }

    private byte[] getSpsData(byte[] bArr, int[] iArr) {
        int i11 = 0;
        while (true) {
            if (i11 + 4 < bArr.length && (i11 = EncodedVideoFrame.getNextNALHeaderPos(i11, ByteBuffer.wrap(bArr))) >= 0) {
                if ((bArr[i11] & Ascii.US) == 7) {
                    iArr[0] = i11;
                    break;
                }
            } else {
                break;
            }
        }
        if (iArr[0] < 0) {
            return null;
        }
        int length = bArr.length - iArr[0];
        int i12 = iArr[0];
        while (true) {
            int i13 = i12 + 3;
            if (i13 >= bArr.length) {
                break;
            } else if (!((bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1) || (bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 0 && bArr[i13] == 1))) {
                i12++;
            }
        }
        length = i12 - iArr[0];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, iArr[0], bArr2, 0, length);
        return bArr2;
    }

    private void handleDecoderError(e.c cVar, String str, Object... objArr) {
        LiteavLog.e(this.mTAG, str, objArr);
        nativeOnDecodedFrameFailed(this.mNativeVideoDecoderImplAndroid, e.a(cVar));
    }

    private boolean initializeSurface(int i11) {
        LiteavLog.i(this.mTAG, "initialize surface");
        synchronized (this) {
            try {
                this.mSurfaceTexture = new SurfaceTexture(i11);
                this.mOutputSurface = new Surface(this.mSurfaceTexture);
                this.mSurfaceTexture.setOnFrameAvailableListener(this);
            } catch (Surface.OutOfResourcesException e11) {
                LiteavLog.e(this.mThrottlers.a("surface"), this.mTAG, "create SurfaceTexture failed.", (Throwable) e11);
                e.c cVar = e.c.WARNING_VIDEO_DECODE_START_FAILED_INSUFFICIENT_RESOURCE;
                handleDecoderError(cVar, "VideoDecode: insufficient resource, Start decoder failed:" + e11.getMessage(), new Object[0]);
                return false;
            }
        }
        LiteavLog.i(this.mThrottlers.a("initializeSurface"), this.mTAG, "initializeSurface", new Object[0]);
        return true;
    }

    public static /* synthetic */ boolean lambda$limitMaxDecFrameBufferingInH264Sps$0(HardwareVideoDecoder2 hardwareVideoDecoder2, int i11, int i12, int i13, int i14) {
        String str = hardwareVideoDecoder2.mTAG;
        LiteavLog.e(str, "frame cropping flag exist, crop[l:" + i11 + ",r:" + i12 + ",t:" + i13 + ",b:" + i14 + "]");
        hardwareVideoDecoder2.mEnableLimitMaxDecFrameBufferingInH264Sps = false;
        hardwareVideoDecoder2.nativeOnFrameFlagCropExist(hardwareVideoDecoder2.mNativeVideoDecoderImplAndroid, i11, i12, i13, i14);
        return false;
    }

    private void limitMaxDecFrameBufferingInH264Sps(EncodedVideoFrame encodedVideoFrame) {
        byte[] a11;
        ByteBuffer b11;
        byte[] bArr;
        boolean z11;
        EncodedVideoFrame encodedVideoFrame2 = encodedVideoFrame;
        if (encodedVideoFrame.isIDRFrame() && encodedVideoFrame2.codecType == CodecType.H264 && this.mEnableLimitMaxDecFrameBufferingInH264Sps && this.mIsRealTime && (a11 = com.tencent.liteav.videobase.utils.e.a(encodedVideoFrame2.data.remaining())) != null) {
            encodedVideoFrame2.data.get(a11);
            encodedVideoFrame2.data.rewind();
            int[] iArr = {-1};
            byte[] spsData = getSpsData(a11, iArr);
            if (spsData != null && iArr[0] >= 0) {
                byte[] bArr2 = null;
                try {
                    com.tencent.liteav.videoconsumer.a.a aVar = this.mSPSModifier;
                    a aVar2 = new a(this);
                    byte[] bArr3 = new byte[spsData.length];
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < spsData.length) {
                        if (i11 < spsData.length - 3 && spsData[i11] == 0) {
                            int i13 = i11 + 1;
                            if (spsData[i13] == 0 && spsData[i11 + 2] == 3) {
                                int i14 = i11 + 3;
                                if (spsData[i14] <= 3) {
                                    int i15 = i12 + 1;
                                    bArr3[i12] = spsData[i11];
                                    i12 = i15 + 1;
                                    bArr3[i15] = spsData[i13];
                                    i11 = i14;
                                }
                            }
                        }
                        bArr3[i12] = spsData[i11];
                        i11++;
                        i12++;
                    }
                    if (i12 != spsData.length) {
                        bArr = new byte[i12];
                        System.arraycopy(bArr3, 0, bArr, 0, i12);
                    } else {
                        bArr = null;
                    }
                    if (bArr != null) {
                        z11 = true;
                    } else {
                        bArr = spsData;
                        z11 = false;
                    }
                    byte[] a12 = aVar.a(new ByteArrayInputStream(bArr), aVar2);
                    if (a12 != null && z11) {
                        a12 = com.tencent.liteav.videoconsumer.a.a.a(a12);
                    }
                    bArr2 = a12;
                } catch (Throwable th2) {
                    LiteavLog.e(this.mTAG, "modify dec buffer error ", th2);
                }
                if (bArr2 != null && (b11 = com.tencent.liteav.videobase.utils.e.b((a11.length - spsData.length) + bArr2.length)) != null) {
                    encodedVideoFrame2.data = b11;
                    if (iArr[0] > 0) {
                        b11.put(a11, 0, iArr[0]);
                    }
                    encodedVideoFrame2.data.put(bArr2);
                    encodedVideoFrame2.data.put(a11, iArr[0] + spsData.length, (a11.length - iArr[0]) - spsData.length);
                    encodedVideoFrame2.data.rewind();
                }
            }
        }
    }

    private native void nativeOnDecodedFrameFailed(long j11, int i11);

    private native void nativeOnFrameAvailable(long j11, long j12);

    private native void nativeOnFrameFlagCropExist(long j11, int i11, int i12, int i13, int i14);

    private void outputFormatChange() {
        MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
        LiteavLog.i(this.mTAG, "decode output format changed: ".concat(String.valueOf(outputFormat)));
        int integer = outputFormat.getInteger("width");
        int integer2 = outputFormat.getInteger("height");
        LiteavLog.i(this.mTAG, "cropWidth: %d, cropHeight: %d, frameWidth: %d, frameHeight: %d", Integer.valueOf(Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1), Integer.valueOf(Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1), Integer.valueOf(integer), Integer.valueOf(integer2));
    }

    private void uninitializeSurface() {
        LiteavLog.i(this.mTAG, "uninitialize surface");
        synchronized (this) {
            Surface surface = this.mOutputSurface;
            if (surface != null) {
                surface.release();
                this.mOutputSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }
    }

    public MediaCodec createMediaCodecInternal(boolean z11, String str) throws IOException {
        if (!z11) {
            return MediaCodec.createDecoderByType(str);
        }
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
            if (!mediaCodecInfo.isEncoder()) {
                int length = supportedTypes.length;
                int i11 = 0;
                while (i11 < length) {
                    if (!supportedTypes[i11].contains(str) || !MediaCodecAbility.isSoftOnlyDecoder(mediaCodecInfo)) {
                        i11++;
                    } else {
                        LiteavLog.i(this.mTAG, "Use soft only decoder:%s", mediaCodecInfo.getName());
                        return MediaCodec.createByCodecName(mediaCodecInfo.getName());
                    }
                }
                continue;
            }
        }
        return MediaCodec.createDecoderByType(str);
    }

    public boolean decodeFrame(EncodedVideoFrame encodedVideoFrame) {
        if (this.mMediaCodec == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            return false;
        } else if (encodedVideoFrame == null) {
            return true;
        } else {
            try {
                if (!feedDataToMediaCodec(encodedVideoFrame)) {
                    encodedVideoFrame.release();
                    return false;
                }
            } catch (Throwable th2) {
                LiteavLog.e(this.mTAG, "decode failed.", th2);
                e.c cVar = e.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR;
                handleDecoderError(cVar, "VideoDecode: decode error, restart decoder message:" + th2.getMessage(), new Object[0]);
            }
            encodedVideoFrame.release();
            return true;
        }
    }

    public int drainDecodedFrame() {
        try {
            return drainDecodedFrameInternal();
        } catch (Throwable th2) {
            LiteavLog.e(this.mTAG, "decode failed.", th2);
            e.c cVar = e.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR;
            handleDecoderError(cVar, "VideoDecode: decode error, restart decoder message:" + th2.getMessage(), new Object[0]);
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        nativeOnFrameAvailable(r4.mNativeVideoDecoderImplAndroid, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFrameAvailable(android.graphics.SurfaceTexture r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.graphics.SurfaceTexture r0 = r4.mSurfaceTexture     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0029
            if (r0 == r5) goto L_0x0008
            goto L_0x0029
        L_0x0008:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x002b }
            long r1 = r5.getTimestamp()     // Catch:{ all -> 0x002b }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x002b }
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0022
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MICROSECONDS     // Catch:{ all -> 0x002b }
            android.media.MediaCodec$BufferInfo r0 = r4.mBufferInfo     // Catch:{ all -> 0x002b }
            long r0 = r0.presentationTimeUs     // Catch:{ all -> 0x002b }
            long r0 = r5.toMillis(r0)     // Catch:{ all -> 0x002b }
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            long r2 = r4.mNativeVideoDecoderImplAndroid
            r4.nativeOnFrameAvailable(r2, r0)
            return
        L_0x0029:
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer2.HardwareVideoDecoder2.onFrameAvailable(android.graphics.SurfaceTexture):void");
    }

    public void setEnableVui(boolean z11) {
        this.mEnableLimitMaxDecFrameBufferingInH264Sps = z11;
    }

    public boolean start(int i11) {
        if (this.mIsStarted) {
            return true;
        }
        LiteavLog.i(this.mTAG, "Start");
        if (!initializeSurface(i11)) {
            return false;
        }
        a aVar = new a((byte) 0);
        if (configureDecoder(aVar, this.mIsRealTime) || configureDecoder(aVar, false)) {
            this.mMediaCodec = aVar.f22511a;
            this.mIsStarted = true;
            LiteavLog.i(this.mTAG, "Start succeed");
            return true;
        }
        e.c cVar = aVar.f22512b;
        handleDecoderError(cVar, "decoder config fail, message:" + aVar.f22513c + " exception:" + aVar.f22514d.getMessage(), new Object[0]);
        return false;
    }

    public void stop() {
        LiteavLog.i(this.mTAG, "stop");
        if (this.mIsStarted) {
            destroyMediaCodec(this.mMediaCodec);
            this.mMediaCodec = null;
            uninitializeSurface();
            this.mIsStarted = false;
        }
    }

    public float[] updateTexImage() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return null;
        }
        try {
            float[] fArr = new float[16];
            surfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(fArr);
            return fArr;
        } catch (Throwable th2) {
            LiteavLog.w(this.mThrottlers.a("updateImage"), this.mTAG, "updateTexImage exception: ".concat(String.valueOf(th2)), new Object[0]);
            return null;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public MediaCodec f22511a;

        /* renamed from: b  reason: collision with root package name */
        public e.c f22512b;

        /* renamed from: c  reason: collision with root package name */
        public String f22513c;

        /* renamed from: d  reason: collision with root package name */
        public Throwable f22514d;

        private a() {
            this.f22511a = null;
            this.f22512b = null;
            this.f22513c = null;
            this.f22514d = null;
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }
}
