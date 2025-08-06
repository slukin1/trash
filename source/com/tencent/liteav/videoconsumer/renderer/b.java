package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

public final class b extends RenderViewHelperInterface {

    /* renamed from: a  reason: collision with root package name */
    private final String f22416a;

    /* renamed from: b  reason: collision with root package name */
    private final CustomHandler f22417b;

    /* renamed from: c  reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f22418c;

    /* renamed from: d  reason: collision with root package name */
    private Surface f22419d;

    public b(Surface surface, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "SurfaceRenderHelper_" + hashCode();
        this.f22416a = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f22417b = customHandler;
        this.f22418c = renderViewListener;
        if (surface == null) {
            LiteavLog.w(str, "surface is null.");
            return;
        }
        this.f22419d = surface;
        customHandler.post(c.a(this, surface));
    }

    public static /* synthetic */ void a(b bVar, Surface surface) {
        LiteavLog.i(bVar.f22416a, "construct,surface=".concat(String.valueOf(surface)));
        RenderViewHelperInterface.RenderViewListener renderViewListener = bVar.f22418c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    public static /* synthetic */ void b(b bVar) {
        String str = bVar.f22416a;
        LiteavLog.i(str, "release,mSurface=" + bVar.f22419d);
        if (bVar.f22419d != null) {
            RenderViewHelperInterface.RenderViewListener renderViewListener = bVar.f22418c;
            if (renderViewListener != null) {
                renderViewListener.onSurfaceDestroy();
            }
            bVar.f22419d = null;
        }
    }

    public final void checkViewAvailability() {
        this.f22417b.post(e.a(this));
    }

    public final Matrix getTransformMatrix(int i11, int i12) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, ((float) i11) / 2.0f, ((float) i12) / 2.0f);
        return matrix;
    }

    public final boolean isUsingTextureView() {
        return false;
    }

    public final void release(boolean z11) {
        this.f22417b.post(d.a(this));
    }

    public final void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i11, int i12, boolean z11) {
    }

    public static /* synthetic */ void a(b bVar) {
        Surface surface = bVar.f22419d;
        if (surface == null) {
            LiteavLog.i(bVar.f22416a, "view is not available when surface is null");
        } else if (!surface.isValid()) {
            LiteavLog.i(bVar.f22416a, "view is not available when %s is not valid", bVar.f22419d);
        }
    }
}
