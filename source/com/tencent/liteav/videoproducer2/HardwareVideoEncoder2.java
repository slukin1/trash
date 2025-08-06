package com.tencent.liteav.videoproducer2;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.w;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.egl.d;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.i;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.b;
import com.tencent.liteav.videoproducer.encoder.e;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@JNINamespace("liteav::video")
public class HardwareVideoEncoder2 {
    private EGLCore mEGLCore;
    private Surface mInputSurface;
    /* access modifiers changed from: private */
    public long mNativeHandler;
    /* access modifiers changed from: private */
    public final AtomicBoolean mNeedRestart = new AtomicBoolean(false);
    private final VideoEncodeParams mParams;
    private i mPixelFrameRenderer;
    private long mPreFrameTimeStamp = 0;
    private HWEncoderServerConfig mServerConfig;
    private final Bundle mSessionStates = new Bundle();
    private Object mSharedContext;
    private b mSurfaceInputVideoEncoder;
    private final Size mSurfaceSize = new Size(0, 0);
    /* access modifiers changed from: private */
    public String mTAG;
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();
    private String mTraceId;
    private final e.a mVideoEncoderListener = new e.a() {
        public final void a() {
            HardwareVideoEncoder2.this.mNeedRestart.set(true);
        }

        public final void onBitrateModeUpdated(VideoEncoderDef.BitrateMode bitrateMode) {
            HardwareVideoEncoder2 hardwareVideoEncoder2 = HardwareVideoEncoder2.this;
            hardwareVideoEncoder2.nativeOnBitrateModeUpdated(hardwareVideoEncoder2.mNativeHandler, bitrateMode.mValue);
        }

        public final void onEncodedFail(e.a aVar) {
            e.a aVar2 = e.a.ERR_CODE_NONE;
            HardwareVideoEncoder2.this.notifyEncodeFail();
        }

        public final synchronized void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z11) {
            int i11;
            EncodedVideoFrame encodedVideoFrame2 = encodedVideoFrame;
            synchronized (this) {
                if (HardwareVideoEncoder2.this.mNativeHandler == 0 || z11) {
                    LiteavLog.d(HardwareVideoEncoder2.this.mTAG, "onEncodedNAL mNativeHandler=%d,isEos=%b", Long.valueOf(HardwareVideoEncoder2.this.mNativeHandler), Boolean.valueOf(z11));
                    return;
                }
                HardwareVideoEncoder2 hardwareVideoEncoder2 = HardwareVideoEncoder2.this;
                long access$000 = hardwareVideoEncoder2.mNativeHandler;
                ByteBuffer byteBuffer = encodedVideoFrame2.data;
                int i12 = encodedVideoFrame2.nalType.mValue;
                int i13 = encodedVideoFrame2.profileType.mValue;
                int i14 = encodedVideoFrame2.codecType.mValue;
                int i15 = encodedVideoFrame2.rotation;
                long j11 = encodedVideoFrame2.dts;
                long j12 = encodedVideoFrame2.pts;
                long j13 = encodedVideoFrame2.gopIndex;
                long j14 = encodedVideoFrame2.gopFrameIndex;
                long j15 = encodedVideoFrame2.frameIndex;
                long j16 = encodedVideoFrame2.refFrameIndex;
                int i16 = encodedVideoFrame2.width;
                int i17 = encodedVideoFrame2.height;
                Integer num = encodedVideoFrame2.svcInfo;
                boolean z12 = num != null;
                if (num == null) {
                    i11 = 0;
                } else {
                    i11 = num.intValue();
                }
                hardwareVideoEncoder2.nativeOnEncodedNAL(access$000, encodedVideoFrame, byteBuffer, i12, i13, i14, i15, j11, j12, j13, j14, j15, j16, i16, i17, z12, i11);
            }
        }
    };

    public HardwareVideoEncoder2(long j11, String str, VideoEncodeParams videoEncodeParams) {
        this.mTraceId = str;
        this.mTAG = str + "HardwareVideoEncoder2_" + hashCode();
        this.mNativeHandler = j11;
        this.mParams = videoEncodeParams;
    }

    public static PixelFrame createPixelFrameByTexture(int i11, int i12, int i13, int i14, long j11, int i15, boolean z11, boolean z12, int i16, Object obj) {
        if (i13 != GLConstants.a.TEXTURE_2D.mValue) {
            GLConstants.a aVar = GLConstants.a.TEXTURE_OES;
        }
        GLConstants.PixelFormatType.RGBA.getValue();
        PixelFrame pixelFrame = new PixelFrame(i11, i12, 0, i13, i14);
        boolean z13 = z11;
        pixelFrame.setMirrorHorizontal(z11);
        boolean z14 = z12;
        pixelFrame.setMirrorVertical(z12);
        pixelFrame.setTextureId(i16);
        pixelFrame.setGLContext(obj);
        pixelFrame.setRotation(k.a(i15));
        long j12 = j11;
        pixelFrame.setTimestamp(j11);
        return pixelFrame;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[Catch:{ d -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058 A[Catch:{ d -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[Catch:{ d -> 0x00b9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawFrameToInputSurface(com.tencent.liteav.videobase.frame.PixelFrame r7) {
        /*
            r6 = this;
            com.tencent.liteav.videobase.egl.EGLCore r0 = r6.mEGLCore
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0.makeCurrent()     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.videobase.frame.PixelFrame r0 = new com.tencent.liteav.videobase.frame.PixelFrame     // Catch:{ d -> 0x00b9 }
            r0.<init>((com.tencent.liteav.videobase.frame.PixelFrame) r7)     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.base.util.k r7 = r0.getRotation()     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_90     // Catch:{ d -> 0x00b9 }
            r2 = 1
            r3 = 0
            if (r7 == r1) goto L_0x002c
            com.tencent.liteav.base.util.k r7 = r0.getRotation()     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_270     // Catch:{ d -> 0x00b9 }
            if (r7 != r1) goto L_0x0020
            goto L_0x002c
        L_0x0020:
            boolean r7 = r0.isMirrorVertical()     // Catch:{ d -> 0x00b9 }
            if (r7 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = r3
        L_0x0028:
            r0.setMirrorVertical(r2)     // Catch:{ d -> 0x00b9 }
            goto L_0x0037
        L_0x002c:
            boolean r7 = r0.isMirrorHorizontal()     // Catch:{ d -> 0x00b9 }
            if (r7 != 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r2 = r3
        L_0x0034:
            r0.setMirrorHorizontal(r2)     // Catch:{ d -> 0x00b9 }
        L_0x0037:
            com.tencent.liteav.base.util.Size r7 = r6.mSurfaceSize     // Catch:{ d -> 0x00b9 }
            int r1 = r7.width     // Catch:{ d -> 0x00b9 }
            int r7 = r7.height     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.videobase.utils.OpenGlUtils.glViewport(r3, r3, r1, r7)     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.videobase.frame.i r7 = r6.mPixelFrameRenderer     // Catch:{ d -> 0x00b9 }
            if (r7 == 0) goto L_0x004a
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r1 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP     // Catch:{ d -> 0x00b9 }
            r2 = 0
            r7.a((com.tencent.liteav.videobase.frame.PixelFrame) r0, (com.tencent.liteav.videobase.base.GLConstants.GLScaleType) r1, (com.tencent.liteav.videobase.frame.d) r2)     // Catch:{ d -> 0x00b9 }
        L_0x004a:
            com.tencent.liteav.videoproducer.encoder.b r7 = r6.mSurfaceInputVideoEncoder     // Catch:{ d -> 0x00b9 }
            long r1 = r0.getTimestamp()     // Catch:{ d -> 0x00b9 }
            java.util.Deque<java.lang.Long> r3 = r7.f22672i     // Catch:{ d -> 0x00b9 }
            boolean r3 = r3.isEmpty()     // Catch:{ d -> 0x00b9 }
            if (r3 == 0) goto L_0x0061
            java.util.concurrent.atomic.AtomicLong r3 = r7.f22673j     // Catch:{ d -> 0x00b9 }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ d -> 0x00b9 }
            r3.set(r4)     // Catch:{ d -> 0x00b9 }
        L_0x0061:
            java.util.Deque<java.lang.Long> r3 = r7.f22672i     // Catch:{ d -> 0x00b9 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ d -> 0x00b9 }
            r3.addLast(r1)     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.base.util.CustomHandler r7 = r7.f22666c     // Catch:{ d -> 0x00b9 }
            r1 = 10
            r2 = 10
            r7.sendEmptyMessageDelayed(r1, r2)     // Catch:{ d -> 0x00b9 }
            long r1 = r0.getTimestamp()     // Catch:{ d -> 0x00b9 }
            long r3 = r6.mPreFrameTimeStamp     // Catch:{ d -> 0x00b9 }
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x009e
            java.lang.String r7 = r6.mTAG     // Catch:{ d -> 0x00b9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ d -> 0x00b9 }
            java.lang.String r2 = "timestamp is not increase. pre: "
            r1.<init>(r2)     // Catch:{ d -> 0x00b9 }
            long r2 = r6.mPreFrameTimeStamp     // Catch:{ d -> 0x00b9 }
            r1.append(r2)     // Catch:{ d -> 0x00b9 }
            java.lang.String r2 = ", cur: "
            r1.append(r2)     // Catch:{ d -> 0x00b9 }
            long r2 = r0.getTimestamp()     // Catch:{ d -> 0x00b9 }
            r1.append(r2)     // Catch:{ d -> 0x00b9 }
            java.lang.String r1 = r1.toString()     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.base.util.LiteavLog.e(r7, r1)     // Catch:{ d -> 0x00b9 }
        L_0x009e:
            long r1 = r0.getTimestamp()     // Catch:{ d -> 0x00b9 }
            r6.mPreFrameTimeStamp = r1     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.videobase.egl.EGLCore r7 = r6.mEGLCore     // Catch:{ d -> 0x00b9 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ d -> 0x00b9 }
            long r2 = r0.getTimestamp()     // Catch:{ d -> 0x00b9 }
            long r0 = r1.toNanos(r2)     // Catch:{ d -> 0x00b9 }
            r7.setPresentationTime(r0)     // Catch:{ d -> 0x00b9 }
            com.tencent.liteav.videobase.egl.EGLCore r7 = r6.mEGLCore     // Catch:{ d -> 0x00b9 }
            r7.swapBuffers()     // Catch:{ d -> 0x00b9 }
            return
        L_0x00b9:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "VideoEncode: swapBuffer error, EGLCode:"
            r0.<init>(r1)
            int r1 = r7.mErrorCode
            r0.append(r1)
            java.lang.String r1 = " message:"
            r0.append(r1)
            java.lang.String r1 = r7.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.tencent.liteav.base.b.b r1 = r6.mThrottlers
            java.lang.String r2 = "EncodeFrameError"
            com.tencent.liteav.base.b.a r1 = r1.a(r2)
            java.lang.String r2 = r6.mTAG
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "makeCurrent failed. error = "
            java.lang.String r0 = r3.concat(r0)
            com.tencent.liteav.base.util.LiteavLog.e((com.tencent.liteav.base.b.a) r1, (java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r7)
            r6.notifyEncodeFail()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer2.HardwareVideoEncoder2.drawFrameToInputSurface(com.tencent.liteav.videobase.frame.PixelFrame):void");
    }

    public static Object getCurrentContext() {
        return OpenGlUtils.getCurrentContext();
    }

    private ServerVideoProducerConfig getServerVideoProducerConfig(HWEncoderServerConfig hWEncoderServerConfig) {
        ServerVideoProducerConfig serverVideoProducerConfig = new ServerVideoProducerConfig();
        serverVideoProducerConfig.setHardwareEncodeType(hWEncoderServerConfig.getHardwareEncodeType());
        serverVideoProducerConfig.setHardwareEncoderHighProfileEnable(hWEncoderServerConfig.getHardwareEncoderHighProfileEnable());
        serverVideoProducerConfig.setHardwareEncoderHighProfileSupport(hWEncoderServerConfig.getHardwareEncoderHighProfileSupport());
        Boolean isHardwareEncoderBitrateModeCBRSupported = hWEncoderServerConfig.isHardwareEncoderBitrateModeCBRSupported();
        if (isHardwareEncoderBitrateModeCBRSupported != null) {
            serverVideoProducerConfig.setHardwareEncoderBitrateModeCBRSupported(isHardwareEncoderBitrateModeCBRSupported.booleanValue());
        }
        return serverVideoProducerConfig;
    }

    private boolean initOpenGLComponents(Object obj, Surface surface) {
        if (surface == null) {
            LiteavLog.w(this.mThrottlers.a("NoSurface"), this.mTAG, "init opengl: surface is null.", new Object[0]);
            return false;
        }
        LiteavLog.d(this.mThrottlers.a("initGL"), this.mTAG, "initOpenGLComponents", new Object[0]);
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            Size size = this.mSurfaceSize;
            eGLCore.initialize(obj, surface, size.width, size.height);
            this.mSharedContext = obj;
            Size size2 = this.mSurfaceSize;
            this.mPixelFrameRenderer = new i(size2.width, size2.height);
            return true;
        } catch (d e11) {
            LiteavLog.e(this.mThrottlers.a("initGLError"), this.mTAG, "create EGLCore failed. error = ".concat(String.valueOf("VideoEncode: create EGLCore failed, EGLCode:" + e11.mErrorCode + " message:" + e11.getMessage())), (Throwable) e11);
            notifyStartEncodedFail();
            this.mEGLCore = null;
            return false;
        }
    }

    public static boolean isInUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* access modifiers changed from: private */
    public native void nativeOnBitrateModeUpdated(long j11, int i11);

    private native void nativeOnEncodedFail(long j11);

    /* access modifiers changed from: private */
    public native void nativeOnEncodedNAL(long j11, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, int i11, int i12, int i13, int i14, long j12, long j13, long j14, long j15, long j16, long j17, int i15, int i16, boolean z11, int i17);

    private native void nativeOnStartEncodedFail(long j11);

    private boolean restart() {
        LiteavLog.d(this.mTAG, "reStart");
        stop();
        return start();
    }

    private boolean start() {
        if (this.mSurfaceInputVideoEncoder != null) {
            return this.mInputSurface != null;
        }
        LiteavLog.i(this.mTAG, "Start hw video encoder. %s", this.mParams);
        b bVar = new b(this.mSessionStates, new com.tencent.liteav.videobase.videobase.d(), this.mTraceId);
        this.mSurfaceInputVideoEncoder = bVar;
        bVar.f22666c = new CustomHandler(Looper.myLooper()) {
            public final void handleMessage(
/*
Method generation error in method: com.tencent.liteav.videoproducer.encoder.b.1.handleMessage(android.os.Message):void, dex: classes11.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.tencent.liteav.videoproducer.encoder.b.1.handleMessage(android.os.Message):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        };
        this.mSurfaceInputVideoEncoder.a(getServerVideoProducerConfig(this.mServerConfig));
        b bVar2 = this.mSurfaceInputVideoEncoder;
        VideoEncodeParams videoEncodeParams = this.mParams;
        e.a aVar = this.mVideoEncoderListener;
        LiteavLog.d(bVar2.f22664a, "start");
        bVar2.f22668e = aVar;
        Surface a11 = bVar2.a(videoEncodeParams);
        LiteavLog.i(bVar2.f22664a, "startCodecInternal success");
        Size size = new Size(720, 1280);
        VideoEncodeParams videoEncodeParams2 = bVar2.f22669f;
        if (videoEncodeParams2 != null) {
            size.set(videoEncodeParams2.width, videoEncodeParams2.height);
        }
        Pair pair = new Pair(a11, size);
        this.mInputSurface = (Surface) pair.first;
        this.mSurfaceSize.set((Size) pair.second);
        if (this.mInputSurface != null) {
            return true;
        }
        notifyStartEncodedFail();
        return false;
    }

    private void stop() {
        uninitOpenGLComponents();
        Surface surface = this.mInputSurface;
        if (surface != null) {
            surface.release();
            this.mInputSurface = null;
        }
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            LiteavLog.i(bVar.f22664a, "stop");
            bVar.b();
            bVar.a();
            this.mSurfaceInputVideoEncoder.a();
            this.mSurfaceInputVideoEncoder = null;
        }
    }

    private void uninitOpenGLComponents() {
        if (this.mEGLCore != null) {
            LiteavLog.d(this.mThrottlers.a("uninitGL"), this.mTAG, "uninitOpenGLComponents", new Object[0]);
            try {
                this.mEGLCore.makeCurrent();
                i iVar = this.mPixelFrameRenderer;
                if (iVar != null) {
                    iVar.a();
                    this.mPixelFrameRenderer = null;
                }
            } catch (d e11) {
                LiteavLog.e(this.mThrottlers.a("unintGLError"), this.mTAG, "makeCurrent failed.", (Throwable) e11);
            }
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
        }
    }

    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            if (this.mNeedRestart.getAndSet(false) && !restart()) {
                return;
            }
            if (this.mSurfaceInputVideoEncoder != null || start()) {
                pixelFrame.getGLContext();
                if (!CommonUtil.equals(pixelFrame.getGLContext(), this.mSharedContext)) {
                    uninitOpenGLComponents();
                }
                if (this.mEGLCore != null || initOpenGLComponents(pixelFrame.getGLContext(), this.mInputSurface)) {
                    this.mSurfaceInputVideoEncoder.c();
                    drawFrameToInputSurface(pixelFrame);
                }
            }
        }
    }

    public synchronized void notifyEncodeFail() {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnEncodedFail(j11);
        }
    }

    public synchronized void notifyStartEncodedFail() {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnStartEncodedFail(j11);
        }
    }

    public synchronized void release() {
        LiteavLog.d(this.mTAG, "release");
        this.mNativeHandler = 0;
        stop();
    }

    public void requestKeyFrame() {
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void setBitrate(int i11) {
        MediaCodec mediaCodec;
        LiteavLog.i(this.mTAG, "SetBitrate ".concat(String.valueOf(i11)));
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar == null) {
            this.mParams.bitrate = i11;
            return;
        }
        VideoEncodeParams videoEncodeParams = bVar.f22669f;
        if (videoEncodeParams == null) {
            String str = bVar.f22664a;
            LiteavLog.w(str, "encoder not started yet. set bitrate to " + i11 + " kbps will not take effect.");
        } else if (videoEncodeParams.bitrate != i11) {
            String str2 = bVar.f22664a;
            LiteavLog.i(str2, "set bitrate to " + i11 + " kbps");
            boolean z11 = false;
            if (i11 < bVar.f22669f.bitrate) {
                if (bVar.f22665b.getBoolean("need_restart_when_down_bitrate", false)) {
                    z11 = true;
                } else {
                    bVar.a(i11);
                }
            }
            bVar.f22669f.bitrate = i11;
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 19 && (mediaCodec = bVar.f22667d) != null) {
                if (z11) {
                    bVar.f22666c.removeCallbacks(bVar.f22674k);
                    long elapsedRealtime = SystemClock.elapsedRealtime() - bVar.f22670g;
                    if (elapsedRealtime >= TimeUnit.SECONDS.toMillis(2)) {
                        bVar.f22674k.run();
                    } else {
                        bVar.f22666c.postDelayed(bVar.f22674k, 2000 - elapsedRealtime);
                    }
                } else {
                    bVar.a(mediaCodec, i11);
                }
            }
        }
    }

    public void setHWEncoderServerConfig(HWEncoderServerConfig hWEncoderServerConfig) {
        this.mServerConfig = hWEncoderServerConfig;
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            bVar.a(getServerVideoProducerConfig(hWEncoderServerConfig));
        }
    }

    public void signalEndOfStream() {
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            LiteavLog.i(bVar.f22664a, "signalEndOfStream");
            MediaCodec mediaCodec = bVar.f22667d;
            if (mediaCodec != null) {
                try {
                    mediaCodec.signalEndOfInputStream();
                } catch (Throwable th2) {
                    LiteavLog.e(bVar.f22664a, "signalEndOfStream failed.", th2);
                }
            }
            if (bVar.f22671h == null) {
                w wVar = new w(Looper.myLooper(), new com.tencent.liteav.videoproducer.encoder.d(bVar));
                bVar.f22671h = wVar;
                wVar.a(30);
            }
        }
    }
}
