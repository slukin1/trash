package com.tencent.ugc.renderer;

import android.graphics.Matrix;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.renderer.RenderViewHelperInterface;
import com.tencent.ugc.videobase.base.GLConstants;

public class SurfaceRenderHelper extends RenderViewHelperInterface {
    private final RenderViewHelperInterface.RenderViewListener mListener;
    private Surface mSurface;
    private final String mTAG;
    private final CustomHandler mUIHandler;

    public SurfaceRenderHelper(Surface surface, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "SurfaceRenderHelper_" + hashCode();
        this.mTAG = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.mUIHandler = customHandler;
        this.mListener = renderViewListener;
        if (surface == null) {
            LiteavLog.w(str, "surface is null.");
            return;
        }
        this.mSurface = surface;
        customHandler.post(a.a(this, surface));
    }

    public static /* synthetic */ void lambda$checkViewAvailability$2(SurfaceRenderHelper surfaceRenderHelper) {
        Surface surface = surfaceRenderHelper.mSurface;
        if (surface == null) {
            LiteavLog.i(surfaceRenderHelper.mTAG, "view is not available when surface is null");
        } else if (!surface.isValid()) {
            LiteavLog.i(surfaceRenderHelper.mTAG, "view is not available when %s is not valid", surfaceRenderHelper.mSurface);
        }
    }

    public static /* synthetic */ void lambda$new$0(SurfaceRenderHelper surfaceRenderHelper, Surface surface) {
        LiteavLog.i(surfaceRenderHelper.mTAG, "construct,surface=".concat(String.valueOf(surface)));
        RenderViewHelperInterface.RenderViewListener renderViewListener = surfaceRenderHelper.mListener;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    public static /* synthetic */ void lambda$release$1(SurfaceRenderHelper surfaceRenderHelper) {
        String str = surfaceRenderHelper.mTAG;
        LiteavLog.i(str, "release,mSurface=" + surfaceRenderHelper.mSurface);
        if (surfaceRenderHelper.mSurface != null) {
            RenderViewHelperInterface.RenderViewListener renderViewListener = surfaceRenderHelper.mListener;
            if (renderViewListener != null) {
                renderViewListener.onSurfaceDestroy();
            }
            surfaceRenderHelper.mSurface = null;
        }
    }

    public void checkViewAvailability() {
        this.mUIHandler.post(c.a(this));
    }

    public Matrix getTransformMatrix(int i11, int i12) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, ((float) i11) / 2.0f, ((float) i12) / 2.0f);
        return matrix;
    }

    public boolean isUsingTextureView() {
        return false;
    }

    public void release(boolean z11) {
        this.mUIHandler.post(b.a(this));
    }

    public void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i11, int i12, boolean z11) {
    }
}
