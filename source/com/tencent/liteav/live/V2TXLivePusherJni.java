package com.tencent.liteav.live;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.live2.impl.a.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

@JNINamespace("liteav")
public class V2TXLivePusherJni extends V2TXLivePusher {
    private static final String TAG = "V2TXLivePusherJni";
    private TXAudioEffectManager mAudioEffectManager;
    private TXBeautyManagerImpl mBeautyManager = new TXBeautyManagerImpl(nativeCreateBeautyManager(this.mNativeV2TXLivePusherJni));
    private TXDeviceManager mDeviceManager = new TXDeviceManagerImpl(nativeCreateDeviceManager(this.mNativeV2TXLivePusherJni));
    private long mNativeV2TXLivePusherJni;
    private V2TXLivePusherObserver mObserver;

    /* renamed from: com.tencent.liteav.live.V2TXLivePusherJni$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21593a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f21594b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f21595c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f21596d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ int[] f21597e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ int[] f21598f;

        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|(2:5|6)|7|9|10|11|13|14|(2:15|16)|17|19|20|21|22|23|24|25|27|28|(2:29|30)|31|33|34|35|36|37|38|39|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|41|42|43|44|45|46|48) */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0094 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c3 */
        static {
            /*
                com.tencent.liteav.videobase.base.GLConstants$a[] r0 = com.tencent.liteav.videobase.base.GLConstants.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21598f = r0
                r1 = 1
                com.tencent.liteav.videobase.base.GLConstants$a r2 = com.tencent.liteav.videobase.base.GLConstants.a.TEXTURE_2D     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f21598f     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.videobase.base.GLConstants$a r3 = com.tencent.liteav.videobase.base.GLConstants.a.BYTE_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f21598f     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.videobase.base.GLConstants$a r4 = com.tencent.liteav.videobase.base.GLConstants.a.BYTE_BUFFER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.tencent.liteav.videobase.base.GLConstants$PixelFormatType[] r3 = com.tencent.liteav.videobase.base.GLConstants.PixelFormatType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21597e = r3
                com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r4 = com.tencent.liteav.videobase.base.GLConstants.PixelFormatType.I420     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = f21597e     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r4 = com.tencent.liteav.videobase.base.GLConstants.PixelFormatType.RGBA     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.tencent.live2.V2TXLiveDef$V2TXLiveBufferType[] r3 = com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21596d = r3
                com.tencent.live2.V2TXLiveDef$V2TXLiveBufferType r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = f21596d     // Catch:{ NoSuchFieldError -> 0x005e }
                com.tencent.live2.V2TXLiveDef$V2TXLiveBufferType r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r3 = f21596d     // Catch:{ NoSuchFieldError -> 0x0068 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveBufferType r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                com.tencent.live2.V2TXLiveDef$V2TXLivePixelFormat[] r3 = com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21595c = r3
                com.tencent.live2.V2TXLiveDef$V2TXLivePixelFormat r4 = com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r3 = f21595c     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.tencent.live2.V2TXLiveDef$V2TXLivePixelFormat r4 = com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                com.tencent.live2.V2TXLiveDef$V2TXLiveFillMode[] r3 = com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21594b = r3
                com.tencent.live2.V2TXLiveDef$V2TXLiveFillMode r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill     // Catch:{ NoSuchFieldError -> 0x0094 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0094 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0094 }
            L_0x0094:
                int[] r3 = f21594b     // Catch:{ NoSuchFieldError -> 0x009e }
                com.tencent.live2.V2TXLiveDef$V2TXLiveFillMode r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFit     // Catch:{ NoSuchFieldError -> 0x009e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r3 = f21594b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveFillMode r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeScaleFill     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                com.tencent.live2.V2TXLiveDef$V2TXLiveRotation[] r3 = com.tencent.live2.V2TXLiveDef.V2TXLiveRotation.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21593a = r3
                com.tencent.live2.V2TXLiveDef$V2TXLiveRotation r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r1 = f21593a     // Catch:{ NoSuchFieldError -> 0x00c3 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveRotation r3 = com.tencent.live2.V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation180     // Catch:{ NoSuchFieldError -> 0x00c3 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                int[] r0 = f21593a     // Catch:{ NoSuchFieldError -> 0x00cd }
                com.tencent.live2.V2TXLiveDef$V2TXLiveRotation r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270     // Catch:{ NoSuchFieldError -> 0x00cd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cd }
            L_0x00cd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.live.V2TXLivePusherJni.AnonymousClass1.<clinit>():void");
        }
    }

    public V2TXLivePusherJni(Context context, int i11) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        long nativeCreate = nativeCreate(new WeakReference(this), i11);
        this.mNativeV2TXLivePusherJni = nativeCreate;
        this.mAudioEffectManager = new TXAudioEffectManagerImpl(nativeCreateAudioEffectManager(nativeCreate));
        if (context instanceof Activity) {
            i.a().a((Activity) context);
        }
    }

    private static Object getEglContextFromLiveVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = v2TXLiveVideoFrame.texture;
        Object obj = v2TXLiveTexture.eglContext10;
        if (obj == null) {
            obj = null;
        }
        Object obj2 = v2TXLiveTexture.eglContext14;
        if (obj2 != null) {
            obj = obj2;
        }
        return obj == null ? EGL14.eglGetCurrentContext() : obj;
    }

    private static native long nativeCreate(WeakReference<V2TXLivePusherJni> weakReference, int i11);

    private static native long nativeCreateAudioEffectManager(long j11);

    private static native long nativeCreateBeautyManager(long j11);

    private static native long nativeCreateDeviceManager(long j11);

    private static native void nativeDestroy(long j11);

    private static native int nativeEnableAudioProcessObserver(long j11, boolean z11, int i11, int i12, int i13, int i14);

    private static native int nativeEnableCustomAudioCapture(long j11, boolean z11);

    private static native int nativeEnableCustomVideoCapture(long j11, boolean z11);

    private static native int nativeEnableCustomVideoProcess(long j11, boolean z11, int i11, int i12);

    private static native void nativeEnableExtensionCallback(long j11, boolean z11);

    private static native int nativeEnableVolumeEvaluation(long j11, int i11);

    private static native int nativeIsPushing(long j11);

    private static native int nativePauseAudio(long j11);

    private static native int nativePauseVideo(long j11);

    private static native int nativeResumeAudio(long j11);

    private static native int nativeResumeVideo(long j11);

    private static native int nativeSendCustomAudioFrame(long j11, byte[] bArr, int i11, int i12, long j12);

    private static native int nativeSendCustomVideoFrame(long j11, int i11, int i12, int i13, int i14, int i15, int i16, Object obj, byte[] bArr, ByteBuffer byteBuffer);

    private static native int nativeSendSeiMessage(long j11, int i11, byte[] bArr);

    private static native int nativeSetAudioQuality(long j11, int i11);

    private static native int nativeSetEncoderMirror(long j11, boolean z11);

    private static native int nativeSetMixTranscodingConfig(long j11, String str);

    private static native int nativeSetProperty(long j11, String str, Object obj);

    private static native int nativeSetRenderFillMode(long j11, int i11);

    private static native int nativeSetRenderMirror(long j11, int i11);

    private static native int nativeSetRenderRotation(long j11, int i11);

    private static native int nativeSetRenderView(long j11, DisplayTarget displayTarget);

    private static native int nativeSetVideoQuality(long j11, int i11, int i12, int i13, int i14, int i15);

    private static native int nativeSetWatermark(long j11, Bitmap bitmap, float f11, float f12, float f13);

    private static native void nativeShowDebugView(long j11, boolean z11);

    private static native int nativeSnapshot(long j11);

    private static native int nativeStartCamera(long j11, boolean z11);

    private static native int nativeStartMicrophone(long j11);

    private static native int nativeStartPush(long j11, String str);

    private static native int nativeStartRecord(long j11, String str, int i11, int i12);

    private static native int nativeStartScreenCapture(long j11);

    private static native int nativeStartSystemAudioLoopback(long j11);

    private static native int nativeStartVirtualCamera(long j11, Bitmap bitmap);

    private static native int nativeStopCamera(long j11);

    private static native int nativeStopMicrophone(long j11);

    private static native int nativeStopPush(long j11);

    private static native void nativeStopRecord(long j11);

    private static native int nativeStopScreenCapture(long j11);

    private static native int nativeStopSystemAudioLoopback(long j11);

    private static native int nativeStopVirtualCamera(long j11);

    public static V2TXLivePusherJni weakToStrongReference(WeakReference<V2TXLivePusherJni> weakReference) {
        return (V2TXLivePusherJni) weakReference.get();
    }

    public V2TXLiveDef.V2TXLiveVideoFrame createV2TXLiveVideoFrame(int i11, int i12, int i13, int i14, int i15, int i16, Object obj, byte[] bArr, ByteBuffer byteBuffer) {
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
        int i17 = AnonymousClass1.f21597e[GLConstants.PixelFormatType.a(i14).ordinal()];
        if (i17 == 1) {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        } else if (i17 != 2) {
            return null;
        } else {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
        }
        int i18 = AnonymousClass1.f21598f[GLConstants.a.a(i13).ordinal()];
        if (i18 == 1) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
            V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = new V2TXLiveDef.V2TXLiveTexture();
            v2TXLiveVideoFrame.texture = v2TXLiveTexture;
            v2TXLiveTexture.textureId = i16;
            if (obj instanceof EGLContext) {
                v2TXLiveTexture.eglContext10 = (EGLContext) obj;
            } else if (Build.VERSION.SDK_INT >= 17 && (obj instanceof android.opengl.EGLContext)) {
                v2TXLiveTexture.eglContext14 = (android.opengl.EGLContext) obj;
            }
        } else if (i18 == 2) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
            v2TXLiveVideoFrame.data = bArr;
        } else if (i18 != 3) {
            return null;
        } else {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
            v2TXLiveVideoFrame.buffer = byteBuffer;
        }
        v2TXLiveVideoFrame.width = i11;
        v2TXLiveVideoFrame.height = i12;
        v2TXLiveVideoFrame.rotation = i15;
        return v2TXLiveVideoFrame;
    }

    public int enableAudioProcessObserver(boolean z11, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        if (v2TXLiveAudioFrameObserverFormat == null) {
            return -2;
        }
        return nativeEnableAudioProcessObserver(this.mNativeV2TXLivePusherJni, z11, v2TXLiveAudioFrameObserverFormat.sampleRate, v2TXLiveAudioFrameObserverFormat.channel, v2TXLiveAudioFrameObserverFormat.samplesPerCall, v2TXLiveAudioFrameObserverFormat.mode.ordinal());
    }

    public int enableCustomAudioCapture(boolean z11) {
        return nativeEnableCustomAudioCapture(this.mNativeV2TXLivePusherJni, z11);
    }

    public int enableCustomVideoCapture(boolean z11) {
        return nativeEnableCustomVideoCapture(this.mNativeV2TXLivePusherJni, z11);
    }

    public int enableCustomVideoProcess(boolean z11, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        if (!z11) {
            return nativeEnableCustomVideoProcess(this.mNativeV2TXLivePusherJni, z11, v2TXLivePixelFormat.ordinal(), v2TXLiveBufferType.ordinal());
        }
        boolean z12 = false;
        if ((v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer && v2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420) || (v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture && v2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D)) {
            z12 = true;
        }
        if (z12) {
            return nativeEnableCustomVideoProcess(this.mNativeV2TXLivePusherJni, z11, v2TXLivePixelFormat.ordinal(), v2TXLiveBufferType.ordinal());
        }
        return -4;
    }

    public int enableVolumeEvaluation(int i11) {
        return nativeEnableVolumeEvaluation(this.mNativeV2TXLivePusherJni, i11);
    }

    public void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public TXAudioEffectManager getAudioEffectManager() {
        return this.mAudioEffectManager;
    }

    public TXBeautyManager getBeautyManager() {
        return this.mBeautyManager;
    }

    public TXDeviceManager getDeviceManager() {
        return this.mDeviceManager;
    }

    public int getFrameBufferType(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        GLConstants.a aVar = GLConstants.a.BYTE_BUFFER;
        int i11 = AnonymousClass1.f21596d[v2TXLiveVideoFrame.bufferType.ordinal()];
        if (i11 == 1) {
            aVar = GLConstants.a.TEXTURE_2D;
        } else if (i11 == 2) {
            aVar = GLConstants.a.BYTE_ARRAY;
        }
        return aVar.mValue;
    }

    public byte[] getFrameByteArray(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.data;
    }

    public ByteBuffer getFrameByteBuffer(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.buffer;
    }

    public Object getFrameEglContext(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture;
        EGLContext eGLContext = null;
        if (v2TXLiveVideoFrame == null || (v2TXLiveTexture = v2TXLiveVideoFrame.texture) == null) {
            return null;
        }
        EGLContext eGLContext2 = v2TXLiveTexture.eglContext10;
        if (eGLContext2 != null) {
            eGLContext = eGLContext2;
        }
        android.opengl.EGLContext eGLContext3 = v2TXLiveTexture.eglContext14;
        return eGLContext3 != null ? eGLContext3 : eGLContext;
    }

    public int getFrameHeight(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.height;
    }

    public int getFramePixelFormat(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        GLConstants.PixelFormatType pixelFormatType = GLConstants.PixelFormatType.I420;
        int i11 = AnonymousClass1.f21595c[v2TXLiveVideoFrame.pixelFormat.ordinal()];
        if (i11 != 1 && i11 == 2) {
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
        }
        return pixelFormatType.getValue();
    }

    public int getFrameRotation(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.rotation;
    }

    public int getFrameTextureId(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture;
        if (v2TXLiveVideoFrame == null || (v2TXLiveTexture = v2TXLiveVideoFrame.texture) == null) {
            return -1;
        }
        return v2TXLiveTexture.textureId;
    }

    public int getFrameWidth(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        return v2TXLiveVideoFrame.width;
    }

    public int isPushing() {
        return nativeIsPushing(this.mNativeV2TXLivePusherJni);
    }

    public void onCaptureFirstAudioFrame() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onCaptureFirstAudioFrame();
        }
    }

    public void onCaptureFirstVideoFrame() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onCaptureFirstVideoFrame();
        }
    }

    public int onCustomPreprocessFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame, V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame2) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            return v2TXLivePusherObserver.onProcessVideoFrame(v2TXLiveVideoFrame, v2TXLiveVideoFrame2);
        }
        return -1;
    }

    public void onEnterRoom(int i11, String str) {
    }

    public void onError(int i11, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onError(i11, str, bundle);
        }
    }

    public void onExitRoom(int i11, String str) {
    }

    public void onGLContextCreated() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onGLContextCreated();
        }
    }

    public void onGLContextDestroyed() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onGLContextDestroyed();
        }
    }

    public void onMicrophoneVolumeUpdate(int i11) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onMicrophoneVolumeUpdate(i11);
        }
    }

    public void onNetworkQuality(int i11) {
    }

    public void onProcessAudioFrame(byte[] bArr, long j11, int i11, int i12) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
            v2TXLiveAudioFrame.data = bArr;
            v2TXLiveAudioFrame.sampleRate = i11;
            v2TXLiveAudioFrame.channel = i12;
            v2TXLiveAudioFrame.timestamp = j11;
            v2TXLivePusherObserver.onProcessAudioFrame(v2TXLiveAudioFrame);
        }
    }

    public void onPushEvent(int i11, Bundle bundle) {
    }

    public void onPushNetStatus(Bundle bundle) {
    }

    public void onPushStatusUpdate(int i11, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        V2TXLiveDef.V2TXLivePushStatus v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected;
        if (i11 == 0) {
            v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnecting;
            str = "connecting to the server.";
        } else if (i11 == 1) {
            v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess;
            str = "connected to the server successfully.";
        } else if (i11 == 2) {
            v2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusReconnecting;
            str = "reconnecting to the server.";
        } else if (i11 == 3) {
            str = "disconnected from the server.";
        }
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onPushStatusUpdate(v2TXLivePushStatus, str, bundle);
        }
    }

    public void onRecordBegin(int i11, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onLocalRecordBegin(i11, str);
        }
    }

    public void onRecordComplete(int i11, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onLocalRecordComplete(i11, str);
        }
    }

    public void onRecordProgress(long j11, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onLocalRecording(j11, str);
        }
    }

    public void onScreenCaptureStarted() {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onScreenCaptureStarted();
        }
    }

    public void onScreenCaptureStoped(int i11) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onScreenCaptureStopped(i11);
        }
    }

    public void onSetMixTranscodingConfig(int i11, String str) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onSetMixTranscodingConfig(i11, str);
        }
    }

    public void onSnapshotComplete(Bitmap bitmap) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onSnapshotComplete(bitmap);
        }
    }

    public void onStatisticsUpdate(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            V2TXLiveDef.V2TXLivePusherStatistics v2TXLivePusherStatistics = new V2TXLiveDef.V2TXLivePusherStatistics();
            v2TXLivePusherStatistics.appCpu = i11;
            v2TXLivePusherStatistics.systemCpu = i12;
            v2TXLivePusherStatistics.width = i13;
            v2TXLivePusherStatistics.height = i14;
            v2TXLivePusherStatistics.fps = i15;
            v2TXLivePusherStatistics.videoBitrate = i16;
            v2TXLivePusherStatistics.audioBitrate = i17;
            v2TXLivePusherStatistics.rtt = i18;
            v2TXLivePusherStatistics.netSpeed = i19;
            v2TXLivePusherObserver.onStatisticsUpdate(v2TXLivePusherStatistics);
        }
    }

    public void onUserAudioAvailable(String str, boolean z11) {
    }

    public void onUserOffline(String str) {
    }

    public void onUserOnline(String str) {
    }

    public void onUserVideoAvailable(String str, int i11, boolean z11) {
    }

    public void onWarning(int i11, String str, Bundle bundle) {
        V2TXLivePusherObserver v2TXLivePusherObserver = this.mObserver;
        if (v2TXLivePusherObserver != null) {
            v2TXLivePusherObserver.onWarning(i11, str, bundle);
        }
    }

    public int pauseAudio() {
        return nativePauseAudio(this.mNativeV2TXLivePusherJni);
    }

    public int pauseVideo() {
        return nativePauseVideo(this.mNativeV2TXLivePusherJni);
    }

    public void release() {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManager;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.clear();
        }
        long j11 = this.mNativeV2TXLivePusherJni;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeV2TXLivePusherJni = 0;
        }
    }

    public int resumeAudio() {
        return nativeResumeAudio(this.mNativeV2TXLivePusherJni);
    }

    public int resumeVideo() {
        return nativeResumeVideo(this.mNativeV2TXLivePusherJni);
    }

    public int sendCustomAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        if (v2TXLiveAudioFrame == null) {
            return -2;
        }
        return nativeSendCustomAudioFrame(this.mNativeV2TXLivePusherJni, v2TXLiveAudioFrame.data, v2TXLiveAudioFrame.sampleRate, v2TXLiveAudioFrame.channel, v2TXLiveAudioFrame.timestamp);
    }

    public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        GLConstants.PixelFormatType pixelFormatType;
        GLConstants.a aVar;
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame2 = v2TXLiveVideoFrame;
        if (v2TXLiveVideoFrame2 == null) {
            return -2;
        }
        Object obj = null;
        int i11 = AnonymousClass1.f21595c[v2TXLiveVideoFrame2.pixelFormat.ordinal()];
        int i12 = -1;
        if (i11 == 1) {
            pixelFormatType = GLConstants.PixelFormatType.I420;
        } else if (i11 != 2) {
            return -1;
        } else {
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
        }
        int i13 = AnonymousClass1.f21596d[v2TXLiveVideoFrame2.bufferType.ordinal()];
        if (i13 == 1) {
            aVar = GLConstants.a.TEXTURE_2D;
            V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = v2TXLiveVideoFrame2.texture;
            if (v2TXLiveTexture != null) {
                i12 = v2TXLiveTexture.textureId;
                obj = getEglContextFromLiveVideoFrame(v2TXLiveVideoFrame);
            } else {
                return -1;
            }
        } else if (i13 == 2) {
            aVar = GLConstants.a.BYTE_ARRAY;
        } else if (i13 != 3) {
            return -1;
        } else {
            aVar = GLConstants.a.BYTE_BUFFER;
        }
        return nativeSendCustomVideoFrame(this.mNativeV2TXLivePusherJni, v2TXLiveVideoFrame2.width, v2TXLiveVideoFrame2.height, aVar.mValue, pixelFormatType.getValue(), v2TXLiveVideoFrame2.rotation, i12, obj, v2TXLiveVideoFrame2.data, v2TXLiveVideoFrame2.buffer);
    }

    public int sendSeiMessage(int i11, byte[] bArr) {
        return nativeSendSeiMessage(this.mNativeV2TXLivePusherJni, i11, bArr);
    }

    public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality v2TXLiveAudioQuality) {
        return nativeSetAudioQuality(this.mNativeV2TXLivePusherJni, v2TXLiveAudioQuality.ordinal());
    }

    public int setEncoderMirror(boolean z11) {
        return nativeSetEncoderMirror(this.mNativeV2TXLivePusherJni, z11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setMixTranscodingConfig(com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            if (r9 == 0) goto L_0x00f0
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e5 }
            r2.<init>()     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r1 = "videoWidth"
            int r3 = r9.videoWidth     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "videoHeight"
            int r3 = r9.videoHeight     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "videoBitrate"
            int r3 = r9.videoBitrate     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "videoFramerate"
            int r3 = r9.videoFramerate     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "videoGOP"
            int r3 = r9.videoGOP     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "backgroundColor"
            int r3 = r9.backgroundColor     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "backgroundImage"
            java.lang.String r3 = r9.backgroundImage     // Catch:{ Exception -> 0x00e2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00e2 }
            if (r3 == 0) goto L_0x0040
            r3 = r0
            goto L_0x0042
        L_0x0040:
            java.lang.String r3 = r9.backgroundImage     // Catch:{ Exception -> 0x00e2 }
        L_0x0042:
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "audioSampleRate"
            int r3 = r9.audioSampleRate     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "audioBitrate"
            int r3 = r9.audioBitrate     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "audioChannels"
            int r3 = r9.audioChannels     // Catch:{ Exception -> 0x00e2 }
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = "outputStreamId"
            java.lang.String r3 = r9.outputStreamId     // Catch:{ Exception -> 0x00e2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00e2 }
            if (r3 == 0) goto L_0x0066
            r3 = r0
            goto L_0x0068
        L_0x0066:
            java.lang.String r3 = r9.outputStreamId     // Catch:{ Exception -> 0x00e2 }
        L_0x0068:
            r2.put(r1, r3)     // Catch:{ Exception -> 0x00e2 }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x00e2 }
            r1.<init>()     // Catch:{ Exception -> 0x00e2 }
            java.util.ArrayList<com.tencent.live2.V2TXLiveDef$V2TXLiveMixStream> r9 = r9.mixStreams     // Catch:{ Exception -> 0x00e2 }
            if (r9 == 0) goto L_0x00dc
            r3 = 0
        L_0x0075:
            int r4 = r9.size()     // Catch:{ Exception -> 0x00e2 }
            if (r3 >= r4) goto L_0x00dc
            java.lang.Object r4 = r9.get(r3)     // Catch:{ Exception -> 0x00e2 }
            com.tencent.live2.V2TXLiveDef$V2TXLiveMixStream r4 = (com.tencent.live2.V2TXLiveDef.V2TXLiveMixStream) r4     // Catch:{ Exception -> 0x00e2 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e2 }
            r5.<init>()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "userId"
            java.lang.String r7 = r4.userId     // Catch:{ Exception -> 0x00e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00e2 }
            if (r7 == 0) goto L_0x0092
            r7 = r0
            goto L_0x0094
        L_0x0092:
            java.lang.String r7 = r4.userId     // Catch:{ Exception -> 0x00e2 }
        L_0x0094:
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "streamId"
            java.lang.String r7 = r4.streamId     // Catch:{ Exception -> 0x00e2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00e2 }
            if (r7 == 0) goto L_0x00a3
            r7 = r0
            goto L_0x00a5
        L_0x00a3:
            java.lang.String r7 = r4.streamId     // Catch:{ Exception -> 0x00e2 }
        L_0x00a5:
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "x"
            int r7 = r4.f22714x     // Catch:{ Exception -> 0x00e2 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "y"
            int r7 = r4.f22715y     // Catch:{ Exception -> 0x00e2 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "width"
            int r7 = r4.width     // Catch:{ Exception -> 0x00e2 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "height"
            int r7 = r4.height     // Catch:{ Exception -> 0x00e2 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "zOrder"
            int r7 = r4.zOrder     // Catch:{ Exception -> 0x00e2 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r6 = "inputType"
            com.tencent.live2.V2TXLiveDef$V2TXLiveMixInputType r4 = r4.inputType     // Catch:{ Exception -> 0x00e2 }
            int r4 = r4.ordinal()     // Catch:{ Exception -> 0x00e2 }
            r5.put(r6, r4)     // Catch:{ Exception -> 0x00e2 }
            r1.put(r5)     // Catch:{ Exception -> 0x00e2 }
            int r3 = r3 + 1
            goto L_0x0075
        L_0x00dc:
            java.lang.String r9 = "mixStreamList"
            r2.put(r9, r1)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00ea
        L_0x00e2:
            r9 = move-exception
            r1 = r2
            goto L_0x00e6
        L_0x00e5:
            r9 = move-exception
        L_0x00e6:
            r9.printStackTrace()
            r2 = r1
        L_0x00ea:
            if (r2 == 0) goto L_0x00f0
            java.lang.String r0 = r2.toString()
        L_0x00f0:
            long r1 = r8.mNativeV2TXLivePusherJni
            int r9 = nativeSetMixTranscodingConfig(r1, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.live.V2TXLivePusherJni.setMixTranscodingConfig(com.tencent.live2.V2TXLiveDef$V2TXLiveTranscodingConfig):int");
    }

    public void setObserver(V2TXLivePusherObserver v2TXLivePusherObserver) {
        this.mObserver = v2TXLivePusherObserver;
        if (v2TXLivePusherObserver != null && (v2TXLivePusherObserver instanceof b)) {
            nativeEnableExtensionCallback(this.mNativeV2TXLivePusherJni, true);
        }
    }

    public int setProperty(String str, Object obj) {
        str.hashCode();
        if (str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize)) {
            LiteavLog.i(TAG, "set surface size is unnecessary");
            return 0;
        } else if (!str.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface)) {
            return nativeSetProperty(this.mNativeV2TXLivePusherJni, str, obj);
        } else {
            if (obj == null) {
                nativeSetRenderView(this.mNativeV2TXLivePusherJni, (DisplayTarget) null);
                return 0;
            } else if (obj instanceof Surface) {
                nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget((Surface) obj));
                return 0;
            } else {
                LiteavLog.e(TAG, "setProperty error, key:" + str + ", value:" + obj);
                return -2;
            }
        }
    }

    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        GLConstants.GLScaleType gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
        int i11 = AnonymousClass1.f21594b[v2TXLiveFillMode.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                gLScaleType = GLConstants.GLScaleType.FIT_CENTER;
            } else if (i11 == 3) {
                gLScaleType = GLConstants.GLScaleType.FILL;
            }
        }
        return nativeSetRenderFillMode(this.mNativeV2TXLivePusherJni, gLScaleType.mValue);
    }

    public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType v2TXLiveMirrorType) {
        return nativeSetRenderMirror(this.mNativeV2TXLivePusherJni, v2TXLiveMirrorType.ordinal());
    }

    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        k kVar;
        int i11 = AnonymousClass1.f21593a[v2TXLiveRotation.ordinal()];
        if (i11 == 1) {
            kVar = k.ROTATION_90;
        } else if (i11 == 2) {
            kVar = k.ROTATION_180;
        } else if (i11 != 3) {
            kVar = k.NORMAL;
        } else {
            kVar = k.ROTATION_270;
        }
        return nativeSetRenderRotation(this.mNativeV2TXLivePusherJni, kVar.mValue);
    }

    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(tXCloudVideoView));
    }

    public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoEncoderParam v2TXLiveVideoEncoderParam) {
        if (v2TXLiveVideoEncoderParam == null) {
            return -2;
        }
        return nativeSetVideoQuality(this.mNativeV2TXLivePusherJni, v2TXLiveVideoEncoderParam.videoResolution.ordinal(), v2TXLiveVideoEncoderParam.videoResolutionMode.ordinal(), v2TXLiveVideoEncoderParam.videoFps, v2TXLiveVideoEncoderParam.videoBitrate, v2TXLiveVideoEncoderParam.minVideoBitrate);
    }

    public int setWatermark(Bitmap bitmap, float f11, float f12, float f13) {
        return nativeSetWatermark(this.mNativeV2TXLivePusherJni, bitmap, f11, f12, f13);
    }

    public void showDebugView(boolean z11) {
        nativeShowDebugView(this.mNativeV2TXLivePusherJni, z11);
    }

    public int snapshot() {
        return nativeSnapshot(this.mNativeV2TXLivePusherJni);
    }

    public int startCamera(boolean z11) {
        return nativeStartCamera(this.mNativeV2TXLivePusherJni, z11);
    }

    public int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        if (v2TXLiveLocalRecordingParams == null || TextUtils.isEmpty(v2TXLiveLocalRecordingParams.filePath)) {
            return -2;
        }
        return nativeStartRecord(this.mNativeV2TXLivePusherJni, v2TXLiveLocalRecordingParams.filePath, v2TXLiveLocalRecordingParams.recordMode.ordinal(), v2TXLiveLocalRecordingParams.interval);
    }

    public int startMicrophone() {
        return nativeStartMicrophone(this.mNativeV2TXLivePusherJni);
    }

    public int startPush(String str) {
        return nativeStartPush(this.mNativeV2TXLivePusherJni, str);
    }

    public int startScreenCapture() {
        return nativeStartScreenCapture(this.mNativeV2TXLivePusherJni);
    }

    public int startSystemAudioLoopback() {
        return nativeStartSystemAudioLoopback(this.mNativeV2TXLivePusherJni);
    }

    public int startVirtualCamera(Bitmap bitmap) {
        return nativeStartVirtualCamera(this.mNativeV2TXLivePusherJni, bitmap);
    }

    public int stopCamera() {
        return nativeStopCamera(this.mNativeV2TXLivePusherJni);
    }

    public void stopLocalRecording() {
        nativeStopRecord(this.mNativeV2TXLivePusherJni);
    }

    public int stopMicrophone() {
        return nativeStopMicrophone(this.mNativeV2TXLivePusherJni);
    }

    public int stopPush() {
        return nativeStopPush(this.mNativeV2TXLivePusherJni);
    }

    public int stopScreenCapture() {
        return nativeStopScreenCapture(this.mNativeV2TXLivePusherJni);
    }

    public int stopSystemAudioLoopback() {
        return nativeStopSystemAudioLoopback(this.mNativeV2TXLivePusherJni);
    }

    public int stopVirtualCamera() {
        return nativeStopVirtualCamera(this.mNativeV2TXLivePusherJni);
    }

    public int setRenderView(TextureView textureView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(textureView));
    }

    public int setRenderView(SurfaceView surfaceView) {
        return nativeSetRenderView(this.mNativeV2TXLivePusherJni, new DisplayTarget(surfaceView));
    }
}
