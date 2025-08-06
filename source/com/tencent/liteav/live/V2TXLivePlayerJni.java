package com.tencent.liteav.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.live2.impl.a.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("liteav")
public class V2TXLivePlayerJni extends V2TXLivePlayer {
    private static final String TAG = "V2TXLivePlayerJni";
    private boolean mClearLastImage = true;
    public long mNativeV2TXLivePlayerJni = 0;
    private V2TXLivePlayerObserver mObserver;
    private V2TXLivePlayerImpl mProxy;

    /* renamed from: com.tencent.liteav.live.V2TXLivePlayerJni$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21588a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f21589b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f21590c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f21591d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ int[] f21592e;

        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|(2:19|20)|21|23|24|25|26|27|29|30|31|32|33|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|29|30|31|32|33|35|36|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a9 */
        static {
            /*
                com.tencent.liteav.base.util.k[] r0 = com.tencent.liteav.base.util.k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21592e = r0
                r1 = 1
                com.tencent.liteav.base.util.k r2 = com.tencent.liteav.base.util.k.NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f21592e     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.base.util.k r3 = com.tencent.liteav.base.util.k.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f21592e     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.base.util.k r4 = com.tencent.liteav.base.util.k.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f21592e     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.liteav.base.util.k r4 = com.tencent.liteav.base.util.k.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.tencent.liteav.videobase.base.GLConstants$a[] r3 = com.tencent.liteav.videobase.base.GLConstants.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21591d = r3
                com.tencent.liteav.videobase.base.GLConstants$a r4 = com.tencent.liteav.videobase.base.GLConstants.a.BYTE_BUFFER     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r3 = f21591d     // Catch:{ NoSuchFieldError -> 0x004e }
                com.tencent.liteav.videobase.base.GLConstants$a r4 = com.tencent.liteav.videobase.base.GLConstants.a.BYTE_ARRAY     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f21591d     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.tencent.liteav.videobase.base.GLConstants$a r4 = com.tencent.liteav.videobase.base.GLConstants.a.TEXTURE_2D     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                com.tencent.liteav.videobase.base.GLConstants$PixelFormatType[] r3 = com.tencent.liteav.videobase.base.GLConstants.PixelFormatType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21590c = r3
                com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r4 = com.tencent.liteav.videobase.base.GLConstants.PixelFormatType.I420     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r3 = f21590c     // Catch:{ NoSuchFieldError -> 0x0073 }
                com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r4 = com.tencent.liteav.videobase.base.GLConstants.PixelFormatType.RGBA     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                com.tencent.live2.V2TXLiveDef$V2TXLiveFillMode[] r3 = com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21589b = r3
                com.tencent.live2.V2TXLiveDef$V2TXLiveFillMode r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r3 = f21589b     // Catch:{ NoSuchFieldError -> 0x008e }
                com.tencent.live2.V2TXLiveDef$V2TXLiveFillMode r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeScaleFill     // Catch:{ NoSuchFieldError -> 0x008e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                com.tencent.live2.V2TXLiveDef$V2TXLiveRotation[] r3 = com.tencent.live2.V2TXLiveDef.V2TXLiveRotation.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f21588a = r3
                com.tencent.live2.V2TXLiveDef$V2TXLiveRotation r4 = com.tencent.live2.V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90     // Catch:{ NoSuchFieldError -> 0x009f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                int[] r1 = f21588a     // Catch:{ NoSuchFieldError -> 0x00a9 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveRotation r3 = com.tencent.live2.V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation180     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r0 = f21588a     // Catch:{ NoSuchFieldError -> 0x00b3 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveRotation r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation270     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.live.V2TXLivePlayerJni.AnonymousClass1.<clinit>():void");
        }
    }

    public V2TXLivePlayerJni(Context context, V2TXLivePlayerImpl v2TXLivePlayerImpl) {
        this.mProxy = v2TXLivePlayerImpl;
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mNativeV2TXLivePlayerJni = nativeCreate(new WeakReference(this));
    }

    private void enableExtensionCallback(boolean z11) {
        synchronized (this) {
            nativeEnableExtensionCallback(this.mNativeV2TXLivePlayerJni, z11);
        }
    }

    public static V2TXLiveDef.V2TXLivePlayerStatistics getJavaV2TXLivePlayerStatistics(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int i27) {
        V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics = new V2TXLiveDef.V2TXLivePlayerStatistics();
        v2TXLivePlayerStatistics.appCpu = i11;
        v2TXLivePlayerStatistics.systemCpu = i12;
        v2TXLivePlayerStatistics.rtt = i13;
        v2TXLivePlayerStatistics.width = i14;
        v2TXLivePlayerStatistics.height = i15;
        v2TXLivePlayerStatistics.fps = i16;
        v2TXLivePlayerStatistics.videoBitrate = i17;
        v2TXLivePlayerStatistics.audioBitrate = i18;
        v2TXLivePlayerStatistics.audioPacketLoss = i19;
        v2TXLivePlayerStatistics.videoPacketLoss = i21;
        v2TXLivePlayerStatistics.jitterBufferDelay = i22;
        v2TXLivePlayerStatistics.audioTotalBlockTime = i23;
        v2TXLivePlayerStatistics.audioBlockRate = i24;
        v2TXLivePlayerStatistics.videoTotalBlockTime = i25;
        v2TXLivePlayerStatistics.videoBlockRate = i26;
        v2TXLivePlayerStatistics.netSpeed = i27;
        return v2TXLivePlayerStatistics;
    }

    private static ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamListFormJsonString(String str) {
        ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> arrayList = new ArrayList<>();
        if (str != null && !str.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i11);
                    arrayList.add(new V2TXLiveDef.V2TXLiveStreamInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), jSONObject.getString("url")));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return arrayList;
    }

    private static native long nativeCreate(WeakReference<V2TXLivePlayerJni> weakReference);

    private static native void nativeDestroy(long j11);

    private static native int nativeEnableCustomRendering(long j11, boolean z11, int i11, int i12);

    private static native void nativeEnableExtensionCallback(long j11, boolean z11);

    private static native int nativeEnableObserveAudioFrame(long j11, boolean z11);

    private static native int nativeEnableReceiveSeiMessage(long j11, boolean z11, int i11);

    private static native int nativeEnableVolumeEvaluation(long j11, int i11);

    private static native String nativeGetStreamList(long j11);

    private static native int nativeIsPlaying(long j11);

    private static native int nativePauseAudio(long j11);

    private static native int nativePauseVideo(long j11);

    private static native int nativeResumeAudio(long j11);

    private static native int nativeResumeVideo(long j11);

    private static native int nativeSetCacheParams(long j11, float f11, float f12);

    private static native int nativeSetPlayoutVolume(long j11, int i11);

    private static native int nativeSetProperty(long j11, String str, Object obj);

    private static native int nativeSetRenderFillMode(long j11, int i11);

    private static native int nativeSetRenderRotation(long j11, int i11);

    private static native int nativeSetRenderView(long j11, DisplayTarget displayTarget);

    private static native void nativeSetSharedEGLContext(long j11, Object obj);

    private static native void nativeShowDebugView(long j11, boolean z11);

    private static native int nativeSnapshot(long j11);

    private static native int nativeStartPlay(long j11, String str);

    private static native int nativeStartRecord(long j11, String str, int i11, int i12);

    private static native int nativeStopPlay(long j11, boolean z11);

    private static native void nativeStopRecord(long j11);

    private static native int nativeSwitchStream(long j11, String str);

    public static V2TXLivePlayerJni weakToStrongReference(WeakReference<V2TXLivePlayerJni> weakReference) {
        return (V2TXLivePlayerJni) weakReference.get();
    }

    public int enableObserveAudioFrame(boolean z11) {
        return nativeEnableObserveAudioFrame(this.mNativeV2TXLivePlayerJni, z11);
    }

    public int enableObserveVideoFrame(boolean z11, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        GLConstants.a aVar;
        GLConstants.PixelFormatType pixelFormatType;
        V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat2 = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        if (v2TXLivePixelFormat == v2TXLivePixelFormat2 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray) {
            pixelFormatType = GLConstants.PixelFormatType.I420;
            aVar = GLConstants.a.BYTE_ARRAY;
        } else if (v2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture) {
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
            aVar = GLConstants.a.TEXTURE_2D;
        } else if (v2TXLivePixelFormat == v2TXLivePixelFormat2 && v2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer) {
            pixelFormatType = GLConstants.PixelFormatType.I420;
            aVar = GLConstants.a.BYTE_BUFFER;
        } else {
            LiteavLog.e(TAG, "Enable custom render failed, invalid params. format:" + v2TXLivePixelFormat + " type:" + v2TXLiveBufferType);
            return -4;
        }
        return nativeEnableCustomRendering(this.mNativeV2TXLivePlayerJni, z11, pixelFormatType.getValue(), aVar.ordinal());
    }

    public int enableReceiveSeiMessage(boolean z11, int i11) {
        return nativeEnableReceiveSeiMessage(this.mNativeV2TXLivePlayerJni, z11, i11);
    }

    public int enableVolumeEvaluation(int i11) {
        return nativeEnableVolumeEvaluation(this.mNativeV2TXLivePlayerJni, i11);
    }

    public void finalize() {
        nativeDestroy(this.mNativeV2TXLivePlayerJni);
    }

    public ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamList() {
        return getStreamListFormJsonString(nativeGetStreamList(this.mNativeV2TXLivePlayerJni));
    }

    public int isPlaying() {
        return nativeIsPlaying(this.mNativeV2TXLivePlayerJni);
    }

    public void onAudioLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioLoading(this.mProxy, bundle);
        }
    }

    public void onAudioPlaying(boolean z11, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onAudioPlaying(this.mProxy, z11, bundle);
        }
    }

    public void onConnected(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onConnected(this.mProxy, bundle);
        }
    }

    public void onError(int i11, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onError(this.mProxy, i11, str, bundle);
        }
    }

    public void onNetworkQuality(int i11) {
    }

    public void onPlayEvent(int i11, Bundle bundle) {
    }

    public void onPlayNetStatus(Bundle bundle) {
    }

    public void onPlayoutAudioFrame(byte[] bArr, int i11, int i12) {
        V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame = new V2TXLiveDef.V2TXLiveAudioFrame();
        v2TXLiveAudioFrame.data = bArr;
        v2TXLiveAudioFrame.sampleRate = i11;
        v2TXLiveAudioFrame.channel = i12;
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutAudioFrame(this.mProxy, v2TXLiveAudioFrame);
        }
    }

    public void onPlayoutVolumeUpdate(int i11) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onPlayoutVolumeUpdate(this.mProxy, i11);
        }
    }

    public void onReceiveSeiMessage(int i11, byte[] bArr) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onReceiveSeiMessage(this.mProxy, i11, bArr);
        }
    }

    public void onRecordBegin(int i11, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecordBegin(this.mProxy, i11, str);
        }
    }

    public void onRecordComplete(int i11, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecordComplete(this.mProxy, i11, str);
        }
    }

    public void onRecordProgress(long j11, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onLocalRecording(this.mProxy, j11, str);
        }
    }

    public void onRenderVideoFrame(int i11, int i12, Object obj, int i13, int i14, int i15, int i16, long j11, byte[] bArr, ByteBuffer byteBuffer) {
        Object obj2 = obj;
        V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
        GLConstants.PixelFormatType a11 = GLConstants.PixelFormatType.a(i11);
        int i17 = AnonymousClass1.f21590c[a11.ordinal()];
        if (i17 == 1) {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420;
        } else if (i17 != 2) {
            LiteavLog.e(TAG, "Invalid pixelFormat. pixelFormat:" + a11 + InstructionFileId.DOT);
        } else {
            v2TXLiveVideoFrame.pixelFormat = V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D;
        }
        GLConstants.a a12 = GLConstants.a.a(i12);
        int i18 = AnonymousClass1.f21591d[a12.ordinal()];
        if (i18 == 1) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer;
        } else if (i18 == 2) {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray;
        } else if (i18 != 3) {
            LiteavLog.e(TAG, "Invalid bufferType. bufferType:" + a12 + InstructionFileId.DOT);
        } else {
            v2TXLiveVideoFrame.bufferType = V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture;
        }
        V2TXLiveDef.V2TXLiveTexture v2TXLiveTexture = new V2TXLiveDef.V2TXLiveTexture();
        v2TXLiveTexture.textureId = i13;
        if (obj2 instanceof EGLContext) {
            v2TXLiveTexture.eglContext10 = (EGLContext) obj2;
        } else if (Build.VERSION.SDK_INT >= 17 && (obj2 instanceof android.opengl.EGLContext)) {
            v2TXLiveTexture.eglContext14 = (android.opengl.EGLContext) obj2;
        }
        v2TXLiveVideoFrame.texture = v2TXLiveTexture;
        v2TXLiveVideoFrame.data = bArr;
        v2TXLiveVideoFrame.buffer = byteBuffer;
        v2TXLiveVideoFrame.width = i14;
        v2TXLiveVideoFrame.height = i15;
        int i19 = AnonymousClass1.f21592e[k.a(i16).ordinal()];
        if (i19 == 1) {
            v2TXLiveVideoFrame.rotation = 0;
        } else if (i19 == 2) {
            v2TXLiveVideoFrame.rotation = 90;
        } else if (i19 == 3) {
            v2TXLiveVideoFrame.rotation = 180;
        } else if (i19 != 4) {
            v2TXLiveVideoFrame.rotation = 0;
        } else {
            v2TXLiveVideoFrame.rotation = 270;
        }
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onRenderVideoFrame(this.mProxy, v2TXLiveVideoFrame);
        }
    }

    public void onSnapshotComplete(Bitmap bitmap) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onSnapshotComplete(this.mProxy, bitmap);
        }
    }

    public void onStatisticsUpdate(V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStatisticsUpdate(this.mProxy, v2TXLivePlayerStatistics);
        }
    }

    public void onStreamSwitched(int i11, String str) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onStreamSwitched(this.mProxy, str, i11);
        }
    }

    public void onVideoLoading(Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoLoading(this.mProxy, bundle);
        }
    }

    public void onVideoPlaying(boolean z11, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoPlaying(this.mProxy, z11, bundle);
        }
    }

    public void onVideoResolutionChanged(int i11, int i12) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onVideoResolutionChanged(this.mProxy, i11, i12);
        }
    }

    public void onWarning(int i11, String str, Bundle bundle) {
        V2TXLivePlayerObserver v2TXLivePlayerObserver = this.mObserver;
        if (v2TXLivePlayerObserver != null) {
            v2TXLivePlayerObserver.onWarning(this.mProxy, i11, str, bundle);
        }
    }

    public int pauseAudio() {
        return nativePauseAudio(this.mNativeV2TXLivePlayerJni);
    }

    public int pauseVideo() {
        return nativePauseVideo(this.mNativeV2TXLivePlayerJni);
    }

    public int resumeAudio() {
        return nativeResumeAudio(this.mNativeV2TXLivePlayerJni);
    }

    public int resumeVideo() {
        return nativeResumeVideo(this.mNativeV2TXLivePlayerJni);
    }

    public int setCacheParams(float f11, float f12) {
        if (f11 < 0.0f || f12 < 0.0f) {
            return -2;
        }
        return nativeSetCacheParams(this.mNativeV2TXLivePlayerJni, f11, f12);
    }

    public void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver) {
        this.mObserver = v2TXLivePlayerObserver;
        if (v2TXLivePlayerObserver != null && (v2TXLivePlayerObserver instanceof a)) {
            enableExtensionCallback(true);
        }
    }

    public int setPlayoutVolume(int i11) {
        return nativeSetPlayoutVolume(this.mNativeV2TXLivePlayerJni, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00de, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setProperty(java.lang.String r7, java.lang.Object r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = -1
            int r1 = r7.hashCode()     // Catch:{ all -> 0x00df }
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case 480042124: goto L_0x002c;
                case 582452376: goto L_0x0022;
                case 1120433643: goto L_0x0018;
                case 1615550654: goto L_0x000e;
                default: goto L_0x000d;
            }     // Catch:{ all -> 0x00df }
        L_0x000d:
            goto L_0x0035
        L_0x000e:
            java.lang.String r1 = "setOpenGLContext"
            boolean r1 = r7.equals(r1)     // Catch:{ all -> 0x00df }
            if (r1 == 0) goto L_0x0035
            r0 = r3
            goto L_0x0035
        L_0x0018:
            java.lang.String r1 = "setSurface"
            boolean r1 = r7.equals(r1)     // Catch:{ all -> 0x00df }
            if (r1 == 0) goto L_0x0035
            r0 = r5
            goto L_0x0035
        L_0x0022:
            java.lang.String r1 = "clearLastImage"
            boolean r1 = r7.equals(r1)     // Catch:{ all -> 0x00df }
            if (r1 == 0) goto L_0x0035
            r0 = r2
            goto L_0x0035
        L_0x002c:
            java.lang.String r1 = "setSurfaceSize"
            boolean r1 = r7.equals(r1)     // Catch:{ all -> 0x00df }
            if (r1 == 0) goto L_0x0035
            r0 = r4
        L_0x0035:
            r1 = -2
            if (r0 == 0) goto L_0x00b4
            if (r0 == r5) goto L_0x0079
            if (r0 == r4) goto L_0x0071
            if (r0 == r3) goto L_0x0046
            long r0 = r6.mNativeV2TXLivePlayerJni     // Catch:{ all -> 0x00df }
            int r7 = nativeSetProperty(r0, r7, r8)     // Catch:{ all -> 0x00df }
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            return r7
        L_0x0046:
            boolean r0 = r8 instanceof javax.microedition.khronos.egl.EGLContext     // Catch:{ all -> 0x00df }
            if (r0 != 0) goto L_0x006b
            boolean r0 = r8 instanceof android.opengl.EGLContext     // Catch:{ all -> 0x00df }
            if (r0 != 0) goto L_0x006b
            java.lang.String r0 = "V2TXLivePlayerJni"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            java.lang.String r3 = "setProperty error, key:"
            r2.<init>(r3)     // Catch:{ all -> 0x00df }
            r2.append(r7)     // Catch:{ all -> 0x00df }
            java.lang.String r7 = ", value:"
            r2.append(r7)     // Catch:{ all -> 0x00df }
            r2.append(r8)     // Catch:{ all -> 0x00df }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x00df }
            com.tencent.liteav.base.util.LiteavLog.e(r0, r7)     // Catch:{ all -> 0x00df }
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            return r1
        L_0x006b:
            long r0 = r6.mNativeV2TXLivePlayerJni     // Catch:{ all -> 0x00df }
            nativeSetSharedEGLContext(r0, r8)     // Catch:{ all -> 0x00df }
            goto L_0x00dd
        L_0x0071:
            java.lang.String r7 = "V2TXLivePlayerJni"
            java.lang.String r8 = "set surface size is unnecessary"
            com.tencent.liteav.base.util.LiteavLog.i(r7, r8)     // Catch:{ all -> 0x00df }
            goto L_0x00dd
        L_0x0079:
            if (r8 != 0) goto L_0x0084
            long r7 = r6.mNativeV2TXLivePlayerJni     // Catch:{ all -> 0x00df }
            r0 = 0
            int r7 = nativeSetRenderView(r7, r0)     // Catch:{ all -> 0x00df }
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            return r7
        L_0x0084:
            boolean r0 = r8 instanceof android.view.Surface     // Catch:{ all -> 0x00df }
            if (r0 != 0) goto L_0x00a5
            java.lang.String r0 = "V2TXLivePlayerJni"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            java.lang.String r3 = "setProperty error, key:"
            r2.<init>(r3)     // Catch:{ all -> 0x00df }
            r2.append(r7)     // Catch:{ all -> 0x00df }
            java.lang.String r7 = ", value:"
            r2.append(r7)     // Catch:{ all -> 0x00df }
            r2.append(r8)     // Catch:{ all -> 0x00df }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x00df }
            com.tencent.liteav.base.util.LiteavLog.e(r0, r7)     // Catch:{ all -> 0x00df }
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            return r1
        L_0x00a5:
            long r0 = r6.mNativeV2TXLivePlayerJni     // Catch:{ all -> 0x00df }
            com.tencent.liteav.videobase.videobase.DisplayTarget r7 = new com.tencent.liteav.videobase.videobase.DisplayTarget     // Catch:{ all -> 0x00df }
            android.view.Surface r8 = (android.view.Surface) r8     // Catch:{ all -> 0x00df }
            r7.<init>((android.view.Surface) r8)     // Catch:{ all -> 0x00df }
            int r7 = nativeSetRenderView(r0, r7)     // Catch:{ all -> 0x00df }
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            return r7
        L_0x00b4:
            boolean r0 = r8 instanceof java.lang.Boolean     // Catch:{ all -> 0x00df }
            if (r0 != 0) goto L_0x00d5
            java.lang.String r0 = "V2TXLivePlayerJni"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            java.lang.String r3 = "setProperty error, key:"
            r2.<init>(r3)     // Catch:{ all -> 0x00df }
            r2.append(r7)     // Catch:{ all -> 0x00df }
            java.lang.String r7 = ", value:"
            r2.append(r7)     // Catch:{ all -> 0x00df }
            r2.append(r8)     // Catch:{ all -> 0x00df }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x00df }
            com.tencent.liteav.base.util.LiteavLog.e(r0, r7)     // Catch:{ all -> 0x00df }
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            return r1
        L_0x00d5:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x00df }
            boolean r7 = r8.booleanValue()     // Catch:{ all -> 0x00df }
            r6.mClearLastImage = r7     // Catch:{ all -> 0x00df }
        L_0x00dd:
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            return r2
        L_0x00df:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00df }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.live.V2TXLivePlayerJni.setProperty(java.lang.String, java.lang.Object):int");
    }

    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        GLConstants.GLScaleType gLScaleType;
        int i11 = AnonymousClass1.f21589b[v2TXLiveFillMode.ordinal()];
        if (i11 == 1) {
            gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
        } else if (i11 != 2) {
            gLScaleType = GLConstants.GLScaleType.FIT_CENTER;
        } else {
            gLScaleType = GLConstants.GLScaleType.FILL;
        }
        return nativeSetRenderFillMode(this.mNativeV2TXLivePlayerJni, gLScaleType.mValue);
    }

    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        k kVar;
        int i11 = AnonymousClass1.f21588a[v2TXLiveRotation.ordinal()];
        if (i11 == 1) {
            kVar = k.ROTATION_90;
        } else if (i11 == 2) {
            kVar = k.ROTATION_180;
        } else if (i11 != 3) {
            kVar = k.NORMAL;
        } else {
            kVar = k.ROTATION_270;
        }
        return nativeSetRenderRotation(this.mNativeV2TXLivePlayerJni, kVar.mValue);
    }

    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, tXCloudVideoView != null ? new DisplayTarget(tXCloudVideoView) : null);
    }

    public void showDebugView(boolean z11) {
        nativeShowDebugView(this.mNativeV2TXLivePlayerJni, z11);
    }

    public int snapshot() {
        return nativeSnapshot(this.mNativeV2TXLivePlayerJni);
    }

    public int startLivePlay(String str) {
        return nativeStartPlay(this.mNativeV2TXLivePlayerJni, str);
    }

    public int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        if (v2TXLiveLocalRecordingParams == null || TextUtils.isEmpty(v2TXLiveLocalRecordingParams.filePath)) {
            return -2;
        }
        return nativeStartRecord(this.mNativeV2TXLivePlayerJni, v2TXLiveLocalRecordingParams.filePath, v2TXLiveLocalRecordingParams.recordMode.ordinal(), v2TXLiveLocalRecordingParams.interval);
    }

    public void stopLocalRecording() {
        nativeStopRecord(this.mNativeV2TXLivePlayerJni);
    }

    public int stopPlay() {
        return nativeStopPlay(this.mNativeV2TXLivePlayerJni, this.mClearLastImage);
    }

    public int switchStream(String str) {
        if (!TextUtils.isEmpty(str)) {
            return nativeSwitchStream(this.mNativeV2TXLivePlayerJni, str);
        }
        LiteavLog.e(TAG, "Invalid params.");
        return -2;
    }

    public int setRenderView(TextureView textureView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, textureView != null ? new DisplayTarget(textureView) : null);
    }

    public int setRenderView(SurfaceView surfaceView) {
        return nativeSetRenderView(this.mNativeV2TXLivePlayerJni, surfaceView != null ? new DisplayTarget(surfaceView) : null);
    }
}
