package com.tencent.ugc.renderer;

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
import com.tencent.ugc.renderer.RenderViewHelperInterface;
import com.tencent.ugc.videobase.base.GLConstants;

public class SurfaceViewRenderHelper extends RenderViewHelperInterface {
    private final Size mFrameSize = new Size();
    /* access modifiers changed from: private */
    public boolean mIsHDR = false;
    /* access modifiers changed from: private */
    public final Size mLastViewSize = new Size();
    private final RenderViewHelperInterface.RenderViewListener mListener;
    private final View.OnLayoutChangeListener mOnLayoutChangeListener = new View.OnLayoutChangeListener() {
        public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            if (!SurfaceViewRenderHelper.this.mIsHDR) {
                return;
            }
            if (SurfaceViewRenderHelper.this.mLastViewSize.width != view.getWidth() || SurfaceViewRenderHelper.this.mLastViewSize.height != view.getHeight()) {
                SurfaceViewRenderHelper.this.updateViewLayoutForHDR();
            }
        }
    };
    private GLConstants.GLScaleType mScaleType = null;
    private SurfaceView mSurfaceView;
    private final SurfaceHolder.Callback mSurfaceViewListener = new SurfaceHolder.Callback() {
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            if (surfaceHolder != null) {
                LiteavLog.i(SurfaceViewRenderHelper.this.mTAG, "surfaceChanged,format=%d,Size(%dx%d)", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
                SurfaceViewRenderHelper.this.notifySurfaceChanged(surfaceHolder.getSurface());
            }
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (surfaceHolder != null) {
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                LiteavLog.i(SurfaceViewRenderHelper.this.mTAG, "surfaceCreated,Size(%dx%d)", Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
                SurfaceViewRenderHelper.this.notifySurfaceChanged(surfaceHolder.getSurface());
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            LiteavLog.i(SurfaceViewRenderHelper.this.mTAG, "surfaceDestroyed");
            SurfaceViewRenderHelper.this.notifySurfaceDestroy();
        }
    };
    /* access modifiers changed from: private */
    public final String mTAG;
    private final CustomHandler mUIHandler;

    public SurfaceViewRenderHelper(SurfaceView surfaceView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "SurfaceViewRenderHelper_" + hashCode();
        this.mTAG = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.mUIHandler = customHandler;
        this.mListener = renderViewListener;
        if (surfaceView == null) {
            LiteavLog.w(str, "surfaceView is null.");
            return;
        }
        this.mSurfaceView = surfaceView;
        customHandler.post(d.a(this, surfaceView));
    }

    public static /* synthetic */ void lambda$checkViewAvailability$2(SurfaceViewRenderHelper surfaceViewRenderHelper) {
        SurfaceView surfaceView = surfaceViewRenderHelper.mSurfaceView;
        if (surfaceView == null) {
            LiteavLog.i(surfaceViewRenderHelper.mTAG, "view is not available when surfaceView is null");
            return;
        }
        Surface surface = surfaceView.getHolder().getSurface();
        boolean z11 = surface != null && surface.isValid();
        if (!(z11 && surfaceViewRenderHelper.mSurfaceView.getWidth() != 0 && surfaceViewRenderHelper.mSurfaceView.getHeight() != 0 && surfaceViewRenderHelper.mSurfaceView.isShown())) {
            String str = surfaceViewRenderHelper.mTAG;
            SurfaceView surfaceView2 = surfaceViewRenderHelper.mSurfaceView;
            LiteavLog.i(str, "%s is not available when isShown:%b, surface isValid:%b", surfaceView2, Boolean.valueOf(surfaceView2.isShown()), Boolean.valueOf(z11));
        }
    }

    public static /* synthetic */ void lambda$new$0(SurfaceViewRenderHelper surfaceViewRenderHelper, SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        if (holder.getSurface().isValid()) {
            Surface surface = holder.getSurface();
            Rect surfaceFrame = holder.getSurfaceFrame();
            LiteavLog.i(surfaceViewRenderHelper.mTAG, "construct,surface=%s,Size(%dx%d)", surface, Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
            surfaceViewRenderHelper.notifySurfaceChanged(surface);
        } else {
            LiteavLog.i(surfaceViewRenderHelper.mTAG, "construct,surfaceView not valid.");
        }
        holder.addCallback(surfaceViewRenderHelper.mSurfaceViewListener);
    }

    public static /* synthetic */ void lambda$release$1(SurfaceViewRenderHelper surfaceViewRenderHelper) {
        String str = surfaceViewRenderHelper.mTAG;
        LiteavLog.i(str, "release,mSurfaceView=" + surfaceViewRenderHelper.mSurfaceView);
        if (surfaceViewRenderHelper.mSurfaceView != null) {
            surfaceViewRenderHelper.notifySurfaceDestroy();
            surfaceViewRenderHelper.mSurfaceView.getHolder().removeCallback(surfaceViewRenderHelper.mSurfaceViewListener);
            surfaceViewRenderHelper.mSurfaceView = null;
        }
    }

    /* access modifiers changed from: private */
    public void notifySurfaceChanged(Surface surface) {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.mListener;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    /* access modifiers changed from: private */
    public void notifySurfaceDestroy() {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.mListener;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r0 == com.tencent.ugc.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r0 == com.tencent.ugc.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        r2 = 1.0d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateViewLayoutForHDR() {
        /*
            r9 = this;
            android.view.SurfaceView r0 = r9.mSurfaceView
            if (r0 == 0) goto L_0x00b6
            android.view.ViewParent r0 = r0.getParent()
            boolean r0 = r0 instanceof com.tencent.rtmp.ui.TXCloudVideoView
            if (r0 != 0) goto L_0x000e
            goto L_0x00b6
        L_0x000e:
            android.view.SurfaceView r0 = r9.mSurfaceView
            android.view.ViewParent r0 = r0.getParent()
            com.tencent.rtmp.ui.TXCloudVideoView r0 = (com.tencent.rtmp.ui.TXCloudVideoView) r0
            com.tencent.liteav.base.util.Size r1 = new com.tencent.liteav.base.util.Size
            int r2 = r0.getWidth()
            int r3 = r0.getHeight()
            r1.<init>(r2, r3)
            com.tencent.liteav.base.util.Size r2 = r9.mFrameSize
            boolean r2 = r2.isValid()
            if (r2 == 0) goto L_0x00b6
            boolean r2 = r1.isValid()
            if (r2 != 0) goto L_0x0033
            goto L_0x00b6
        L_0x0033:
            com.tencent.liteav.base.util.Size r2 = r9.mLastViewSize
            boolean r2 = r2.isValid()
            if (r2 != 0) goto L_0x0040
            android.view.View$OnLayoutChangeListener r2 = r9.mOnLayoutChangeListener
            r0.addOnLayoutChangeListener(r2)
        L_0x0040:
            com.tencent.liteav.base.util.Size r0 = r9.mLastViewSize
            r0.set(r1)
            double r2 = r1.aspectRatio()
            com.tencent.liteav.base.util.Size r0 = r9.mFrameSize
            double r4 = r0.aspectRatio()
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 >= 0) goto L_0x0064
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r0 = r9.mScaleType
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r8 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.FIT_CENTER
            if (r0 != r8) goto L_0x005f
        L_0x005b:
            double r4 = r4 / r2
            r2 = r6
            r6 = r4
            goto L_0x0072
        L_0x005f:
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r8 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.CENTER_CROP
            if (r0 != r8) goto L_0x0071
            goto L_0x006a
        L_0x0064:
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r0 = r9.mScaleType
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r8 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.FIT_CENTER
            if (r0 != r8) goto L_0x006c
        L_0x006a:
            double r2 = r2 / r4
            goto L_0x0072
        L_0x006c:
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r8 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.CENTER_CROP
            if (r0 != r8) goto L_0x0071
            goto L_0x005b
        L_0x0071:
            r2 = r6
        L_0x0072:
            android.view.SurfaceView r0 = r9.mSurfaceView
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
            android.view.SurfaceView r1 = r9.mSurfaceView
            r1.setLayoutParams(r0)
            java.lang.String r1 = r9.mTAG
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.renderer.SurfaceViewRenderHelper.updateViewLayoutForHDR():void");
    }

    public void checkViewAvailability() {
        this.mUIHandler.post(f.a(this));
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
        this.mUIHandler.post(e.a(this));
    }

    public void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i11, int i12, boolean z11) {
        if (this.mScaleType == gLScaleType && this.mIsHDR == z11) {
            Size size = this.mFrameSize;
            if (size.width == i11 && size.height == i12) {
                return;
            }
        }
        this.mIsHDR = z11;
        this.mScaleType = gLScaleType;
        this.mFrameSize.set(i11, i12);
        if (this.mIsHDR) {
            this.mUIHandler.runOrPost(g.a(this));
        }
    }
}
