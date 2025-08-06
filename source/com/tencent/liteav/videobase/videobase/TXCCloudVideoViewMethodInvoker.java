package com.tencent.liteav.videobase.videobase;

import android.view.TextureView;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.ui.OnTapListener;
import com.tencent.rtmp.ui.OnZoomListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.Method;

@JNINamespace("liteav::video")
public class TXCCloudVideoViewMethodInvoker {
    private static final String TAG = "TXCCloudVideoViewMethodInvoker";

    public static void addView(TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        callMethod(tXCloudVideoView, "addViewInternal", new Class[]{TextureView.class}, textureView);
    }

    private static Object callMethod(TXCloudVideoView tXCloudVideoView, String str, Class<?>[] clsArr, Object... objArr) {
        if (tXCloudVideoView == null) {
            LiteavLog.w(TAG, str + ",TXCloudVideoView is null.");
            return null;
        }
        try {
            Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(tXCloudVideoView, objArr);
        } catch (Throwable th2) {
            LiteavLog.e(TAG, str + ",Exception:", th2);
            return null;
        }
    }

    public static Object getGLContextFromView(DisplayTarget displayTarget) {
        if (displayTarget == null || displayTarget.getTXCloudVideoView() == null) {
            return null;
        }
        return displayTarget.getTXCloudVideoView().getOpenGLContext();
    }

    public static TextureView getTextureViewSetByUser(TXCloudVideoView tXCloudVideoView) {
        Object callMethod = callMethod(tXCloudVideoView, "getTextureViewSetByUser", (Class<?>[]) null, new Object[0]);
        if (callMethod instanceof TextureView) {
            return (TextureView) callMethod;
        }
        return null;
    }

    public static void removeDeprecatedViews(TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        callMethod(tXCloudVideoView, "removeDeprecatedViews", new Class[]{TextureView.class}, textureView);
    }

    public static void removeView(TXCloudVideoView tXCloudVideoView, TextureView textureView, boolean z11) {
        callMethod(tXCloudVideoView, "removeViewInternal", new Class[]{TextureView.class, Boolean.TYPE}, textureView, Boolean.valueOf(z11));
    }

    public static void setBackgroundColorForInternalView(TXCloudVideoView tXCloudVideoView, int i11) {
        callMethod(tXCloudVideoView, "setBackgroundColorForInternalView", new Class[]{Integer.TYPE}, Integer.valueOf(i11));
    }

    public static void setTouchToFocusEnabled(TXCloudVideoView tXCloudVideoView, boolean z11, OnTapListener onTapListener) {
        callMethod(tXCloudVideoView, "setTouchToFocusEnabled", new Class[]{Boolean.TYPE, OnTapListener.class}, Boolean.valueOf(z11), onTapListener);
    }

    public static void setZoomEnabled(TXCloudVideoView tXCloudVideoView, boolean z11, OnZoomListener onZoomListener) {
        callMethod(tXCloudVideoView, "setZoomEnabled", new Class[]{Boolean.TYPE, OnZoomListener.class}, Boolean.valueOf(z11), onZoomListener);
    }

    public static void showFocusView(TXCloudVideoView tXCloudVideoView, int i11, int i12, int i13, int i14) {
        Class cls = Integer.TYPE;
        callMethod(tXCloudVideoView, "showFocusView", new Class[]{cls, cls, cls, cls}, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
    }
}
