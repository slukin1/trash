package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

public final class f extends RenderViewHelperInterface {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f22424a;

    /* renamed from: b  reason: collision with root package name */
    private final CustomHandler f22425b;

    /* renamed from: c  reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f22426c;

    /* renamed from: d  reason: collision with root package name */
    private SurfaceView f22427d;

    /* renamed from: e  reason: collision with root package name */
    private final Size f22428e = new Size();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Size f22429f = new Size();

    /* renamed from: g  reason: collision with root package name */
    private GLConstants.GLScaleType f22430g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f22431h = false;

    /* renamed from: i  reason: collision with root package name */
    private final SurfaceHolder.Callback f22432i = new SurfaceHolder.Callback() {
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            if (surfaceHolder != null) {
                LiteavLog.i(f.this.f22424a, "surfaceChanged,format=%d,Size(%dx%d)", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
                f.this.a(surfaceHolder.getSurface());
            }
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (surfaceHolder != null) {
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                LiteavLog.i(f.this.f22424a, "surfaceCreated,Size(%dx%d)", Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
                f.this.a(surfaceHolder.getSurface());
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LiteavLog.i(f.this.f22424a, "surfaceDestroyed");
            f.this.a();
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private final View.OnLayoutChangeListener f22433j = new View.OnLayoutChangeListener() {
        public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            if (!f.this.f22431h) {
                return;
            }
            if (f.this.f22429f.width != view.getWidth() || f.this.f22429f.height != view.getHeight()) {
                f.this.b();
            }
        }
    };

    public f(SurfaceView surfaceView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "SurfaceViewRenderHelper_" + hashCode();
        this.f22424a = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f22425b = customHandler;
        this.f22426c = renderViewListener;
        if (surfaceView == null) {
            LiteavLog.w(str, "surfaceView is null.");
            return;
        }
        this.f22427d = surfaceView;
        customHandler.post(g.a(this, surfaceView));
    }

    public static /* synthetic */ void b(f fVar) {
        SurfaceView surfaceView = fVar.f22427d;
        if (surfaceView == null) {
            LiteavLog.i(fVar.f22424a, "view is not available when surfaceView is null");
            return;
        }
        Surface surface = surfaceView.getHolder().getSurface();
        boolean z11 = surface != null && surface.isValid();
        if (!(z11 && fVar.f22427d.getWidth() != 0 && fVar.f22427d.getHeight() != 0 && fVar.f22427d.isShown())) {
            String str = fVar.f22424a;
            SurfaceView surfaceView2 = fVar.f22427d;
            LiteavLog.i(str, "%s is not available when isShown:%b, surface isValid:%b", surfaceView2, Boolean.valueOf(surfaceView2.isShown()), Boolean.valueOf(z11));
        }
    }

    public static /* synthetic */ void c(f fVar) {
        String str = fVar.f22424a;
        LiteavLog.i(str, "release,mSurfaceView=" + fVar.f22427d);
        if (fVar.f22427d != null) {
            fVar.a();
            fVar.f22427d.getHolder().removeCallback(fVar.f22432i);
            fVar.f22427d = null;
        }
    }

    public final void checkViewAvailability() {
        this.f22425b.post(i.a(this));
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
        this.f22425b.post(h.a(this));
    }

    public final void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i11, int i12, boolean z11) {
        if (this.f22430g == gLScaleType && this.f22431h == z11) {
            Size size = this.f22428e;
            if (size.width == i11 && size.height == i12) {
                return;
            }
        }
        this.f22431h = z11;
        this.f22430g = gLScaleType;
        this.f22428e.set(i11, i12);
        if (this.f22431h) {
            this.f22425b.runOrPost(j.a(this));
        }
    }

    public static /* synthetic */ void a(f fVar, SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        if (holder.getSurface().isValid()) {
            Surface surface = holder.getSurface();
            Rect surfaceFrame = holder.getSurfaceFrame();
            LiteavLog.i(fVar.f22424a, "construct,surface=%s,Size(%dx%d)", surface, Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
            fVar.a(surface);
        } else {
            LiteavLog.i(fVar.f22424a, "construct,surfaceView not valid.");
        }
        holder.addCallback(fVar.f22432i);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r0 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r0 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        r2 = 1.0d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r9 = this;
            android.view.SurfaceView r0 = r9.f22427d
            if (r0 == 0) goto L_0x00b6
            android.view.ViewParent r0 = r0.getParent()
            boolean r0 = r0 instanceof com.tencent.rtmp.ui.TXCloudVideoView
            if (r0 != 0) goto L_0x000e
            goto L_0x00b6
        L_0x000e:
            android.view.SurfaceView r0 = r9.f22427d
            android.view.ViewParent r0 = r0.getParent()
            com.tencent.rtmp.ui.TXCloudVideoView r0 = (com.tencent.rtmp.ui.TXCloudVideoView) r0
            com.tencent.liteav.base.util.Size r1 = new com.tencent.liteav.base.util.Size
            int r2 = r0.getWidth()
            int r3 = r0.getHeight()
            r1.<init>(r2, r3)
            com.tencent.liteav.base.util.Size r2 = r9.f22428e
            boolean r2 = r2.isValid()
            if (r2 == 0) goto L_0x00b6
            boolean r2 = r1.isValid()
            if (r2 != 0) goto L_0x0033
            goto L_0x00b6
        L_0x0033:
            com.tencent.liteav.base.util.Size r2 = r9.f22429f
            boolean r2 = r2.isValid()
            if (r2 != 0) goto L_0x0040
            android.view.View$OnLayoutChangeListener r2 = r9.f22433j
            r0.addOnLayoutChangeListener(r2)
        L_0x0040:
            com.tencent.liteav.base.util.Size r0 = r9.f22429f
            r0.set(r1)
            double r2 = r1.aspectRatio()
            com.tencent.liteav.base.util.Size r0 = r9.f22428e
            double r4 = r0.aspectRatio()
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 >= 0) goto L_0x0064
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r0 = r9.f22430g
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.FIT_CENTER
            if (r0 != r8) goto L_0x005f
        L_0x005b:
            double r4 = r4 / r2
            r2 = r6
            r6 = r4
            goto L_0x0072
        L_0x005f:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP
            if (r0 != r8) goto L_0x0071
            goto L_0x006a
        L_0x0064:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r0 = r9.f22430g
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.FIT_CENTER
            if (r0 != r8) goto L_0x006c
        L_0x006a:
            double r2 = r2 / r4
            goto L_0x0072
        L_0x006c:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP
            if (r0 != r8) goto L_0x0071
            goto L_0x005b
        L_0x0071:
            r2 = r6
        L_0x0072:
            android.view.SurfaceView r0 = r9.f22427d
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            int r4 = r1.getWidth()
            double r4 = (double) r4
            double r4 = r4 * r6
            int r4 = (int) r4
            r0.width = r4
            int r1 = r1.getHeight()
            double r4 = (double) r1
            double r4 = r4 * r2
            int r1 = (int) r4
            r0.height = r1
            boolean r1 = r0 instanceof android.widget.FrameLayout.LayoutParams
            if (r1 == 0) goto L_0x0095
            r1 = r0
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r2 = 17
            r1.gravity = r2
        L_0x0095:
            android.view.SurfaceView r1 = r9.f22427d
            r1.setLayoutParams(r0)
            java.lang.String r1 = r9.f22424a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            int r4 = r0.width
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            r3 = 1
            int r0 = r0.height
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2[r3] = r0
            java.lang.String r0 = "adjust view size to %d*%d"
            com.tencent.liteav.base.util.LiteavLog.i(r1, r0, r2)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.renderer.f.b():void");
    }

    /* access modifiers changed from: private */
    public void a(Surface surface) {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f22426c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f22426c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }
}
