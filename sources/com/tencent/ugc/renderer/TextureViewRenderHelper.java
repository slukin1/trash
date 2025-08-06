package com.tencent.ugc.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.h;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.renderer.RenderViewHelperInterface;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.xiaomi.mipush.sdk.Constants;

public class TextureViewRenderHelper extends RenderViewHelperInterface {
    private final Size mFrameSize = new Size();
    /* access modifiers changed from: private */
    public boolean mHasFirstFrameRendered = false;
    private SurfaceTexture mLastSurfaceTexture;
    private final RenderViewHelperInterface.RenderViewListener mListener;
    /* access modifiers changed from: private */
    public SurfaceTexture mSavedSurfaceTexture = null;
    private GLConstants.GLScaleType mScaleType = null;
    /* access modifiers changed from: private */
    public final Size mSurfaceTextureSize = new Size();
    /* access modifiers changed from: private */
    public final String mTAG;
    private final TXCloudVideoView mTXCloudVideoView;
    /* access modifiers changed from: private */
    public TextureView mTextureView;
    private final TextureView.SurfaceTextureListener mTextureViewListener = new TextureView.SurfaceTextureListener() {
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            LiteavLog.i(TextureViewRenderHelper.this.mThrottlerManager.a("surfaceCreate"), TextureViewRenderHelper.this.mTAG, "onSurfaceTextureAvailable, size: %dx%d", Integer.valueOf(i11), Integer.valueOf(i12));
            TextureViewRenderHelper.this.notifySurfaceChanged(TextureViewRenderHelper.this.setSavedSurfaceTextureToTextureView(surfaceTexture));
            TextureViewRenderHelper textureViewRenderHelper = TextureViewRenderHelper.this;
            textureViewRenderHelper.updateTextureViewRenderMatrix(textureViewRenderHelper.mTextureView);
            TextureViewRenderHelper.this.mSurfaceTextureSize.width = i11;
            TextureViewRenderHelper.this.mSurfaceTextureSize.height = i12;
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            LiteavLog.i(TextureViewRenderHelper.this.mTAG, "onSurfaceTextureDestroyed");
            TextureViewRenderHelper.this.notifySurfaceDestroy();
            if (TextureViewRenderHelper.this.mTextureView == null) {
                return true;
            }
            SurfaceTexture unused = TextureViewRenderHelper.this.mSavedSurfaceTexture = surfaceTexture;
            return false;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            boolean z11 = false;
            LiteavLog.i(TextureViewRenderHelper.this.mThrottlerManager.a("surfaceSizeChanged"), TextureViewRenderHelper.this.mTAG, "onSurfaceTextureSizeChanged, size: %dx%d", Integer.valueOf(i11), Integer.valueOf(i12));
            TextureViewRenderHelper.this.notifySurfaceChanged(surfaceTexture);
            TextureViewRenderHelper textureViewRenderHelper = TextureViewRenderHelper.this;
            textureViewRenderHelper.updateTextureViewRenderMatrix(textureViewRenderHelper.mTextureView);
            boolean z12 = TextureViewRenderHelper.this.mSurfaceTextureSize.width > TextureViewRenderHelper.this.mSurfaceTextureSize.height;
            if (i11 > i12) {
                z11 = true;
            }
            if (z12 != z11) {
                TextureViewRenderHelper.this.notifyRequestRedraw();
            }
            TextureViewRenderHelper.this.mSurfaceTextureSize.width = i11;
            TextureViewRenderHelper.this.mSurfaceTextureSize.height = i12;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (!TextureViewRenderHelper.this.mHasFirstFrameRendered) {
                boolean unused = TextureViewRenderHelper.this.mHasFirstFrameRendered = true;
                TextureViewRenderHelper.this.mUIHandler.post(m.a(this));
            }
        }
    };
    /* access modifiers changed from: private */
    public final b mThrottlerManager = new b();
    private Matrix mTransformMatrix = new Matrix();
    /* access modifiers changed from: private */
    public final CustomHandler mUIHandler;

    public TextureViewRenderHelper(TXCloudVideoView tXCloudVideoView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "TextureViewRenderHelper_" + hashCode();
        this.mTAG = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.mUIHandler = customHandler;
        this.mListener = renderViewListener;
        this.mTXCloudVideoView = tXCloudVideoView;
        if (tXCloudVideoView == null) {
            LiteavLog.w(str, "txCloudVideoView is null.");
            return;
        }
        LiteavLog.i(str, "construct,txCloudVideoView=".concat(String.valueOf(tXCloudVideoView)));
        TextureView textureView = new TextureView(tXCloudVideoView.getContext());
        this.mTextureView = textureView;
        customHandler.post(h.a(this, tXCloudVideoView, textureView));
    }

    public static /* synthetic */ void lambda$checkViewAvailability$3(TextureViewRenderHelper textureViewRenderHelper) {
        TextureView textureView = textureViewRenderHelper.mTextureView;
        if (textureView == null) {
            LiteavLog.i(textureViewRenderHelper.mTAG, "view is not available when textureView is null");
            return;
        }
        if (!(textureView.isAvailable() && textureViewRenderHelper.mTextureView.getWidth() != 0 && textureViewRenderHelper.mTextureView.getHeight() != 0 && textureViewRenderHelper.mTextureView.isShown())) {
            String str = textureViewRenderHelper.mTAG;
            TextureView textureView2 = textureViewRenderHelper.mTextureView;
            LiteavLog.i(str, "%s is not available when surface available:%b, isShown:%b", textureView2, Boolean.valueOf(textureView2.isAvailable()), Boolean.valueOf(textureViewRenderHelper.mTextureView.isShown()));
        }
    }

    public static /* synthetic */ void lambda$new$0(TextureViewRenderHelper textureViewRenderHelper, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        TXCCloudVideoViewMethodInvoker.addView(tXCloudVideoView, textureView);
        textureViewRenderHelper.setup(textureView);
    }

    public static /* synthetic */ void lambda$release$2(TextureViewRenderHelper textureViewRenderHelper, boolean z11) {
        String str = textureViewRenderHelper.mTAG;
        LiteavLog.i(str, "release,mTextureView=" + textureViewRenderHelper.mTextureView);
        if (textureViewRenderHelper.mTextureView != null) {
            textureViewRenderHelper.notifySurfaceDestroy();
            if (textureViewRenderHelper.mTextureView.getSurfaceTextureListener() == textureViewRenderHelper.mTextureViewListener) {
                textureViewRenderHelper.mTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            SurfaceTexture surfaceTexture = textureViewRenderHelper.mSavedSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                textureViewRenderHelper.mSavedSurfaceTexture = null;
            }
            if (textureViewRenderHelper.mTXCloudVideoView != null) {
                String str2 = textureViewRenderHelper.mTAG;
                LiteavLog.i(str2, "clearLastImage=" + z11 + ",mHasFirstFrameRendered=" + textureViewRenderHelper.mHasFirstFrameRendered);
                TXCCloudVideoViewMethodInvoker.removeView(textureViewRenderHelper.mTXCloudVideoView, textureViewRenderHelper.mTextureView, z11 | (textureViewRenderHelper.mHasFirstFrameRendered ^ true));
            }
            textureViewRenderHelper.mTextureView = null;
        }
    }

    /* access modifiers changed from: private */
    public void notifyFirstFrameRendered() {
        TextureView textureView;
        TXCloudVideoView tXCloudVideoView = this.mTXCloudVideoView;
        if (tXCloudVideoView != null && (textureView = this.mTextureView) != null) {
            TXCCloudVideoViewMethodInvoker.removeDeprecatedViews(tXCloudVideoView, textureView);
        }
    }

    /* access modifiers changed from: private */
    public void notifyRequestRedraw() {
        TextureView textureView;
        Bitmap bitmap;
        if (this.mListener != null && (textureView = this.mTextureView) != null && (bitmap = textureView.getBitmap()) != null) {
            this.mListener.onRequestRedraw(bitmap);
        }
    }

    /* access modifiers changed from: private */
    public void notifySurfaceChanged(SurfaceTexture surfaceTexture) {
        if (this.mLastSurfaceTexture != surfaceTexture) {
            this.mLastSurfaceTexture = surfaceTexture;
            RenderViewHelperInterface.RenderViewListener renderViewListener = this.mListener;
            if (renderViewListener != null) {
                renderViewListener.onSurfaceChanged(new Surface(surfaceTexture), true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void notifySurfaceDestroy() {
        this.mLastSurfaceTexture = null;
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.mListener;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }

    /* access modifiers changed from: private */
    public SurfaceTexture setSavedSurfaceTextureToTextureView(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.mSavedSurfaceTexture;
        if (surfaceTexture2 == null || this.mTextureView == null || h.a(surfaceTexture, surfaceTexture2)) {
            return surfaceTexture;
        }
        this.mTextureView.setSurfaceTexture(this.mSavedSurfaceTexture);
        SurfaceTexture surfaceTexture3 = this.mSavedSurfaceTexture;
        this.mSavedSurfaceTexture = null;
        return surfaceTexture3;
    }

    /* access modifiers changed from: private */
    public void setup(TextureView textureView) {
        if (textureView == null) {
            LiteavLog.w(this.mTAG, "setup,textureView is null.");
            return;
        }
        if (textureView.isAvailable()) {
            Size size = new Size(textureView.getWidth(), textureView.getHeight());
            String str = this.mTAG;
            LiteavLog.i(str, "setup,textureView=" + textureView + Constants.ACCEPT_TIME_SEPARATOR_SP + size);
            notifySurfaceChanged(textureView.getSurfaceTexture());
        } else {
            LiteavLog.i(this.mTAG, "setup,textureView not available.");
        }
        textureView.setSurfaceTextureListener(this.mTextureViewListener);
        updateTextureViewRenderMatrix(textureView);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateTextureViewRenderMatrix(android.view.TextureView r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 != 0) goto L_0x0005
            monitor-exit(r11)
            return
        L_0x0005:
            com.tencent.liteav.base.util.Size r0 = new com.tencent.liteav.base.util.Size     // Catch:{ all -> 0x00a9 }
            int r1 = r12.getWidth()     // Catch:{ all -> 0x00a9 }
            int r2 = r12.getHeight()     // Catch:{ all -> 0x00a9 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x00a9 }
            com.tencent.liteav.base.util.Size r1 = r11.mFrameSize     // Catch:{ all -> 0x00a9 }
            boolean r1 = r1.isValid()     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x00a7
            boolean r1 = r0.isValid()     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0022
            goto L_0x00a7
        L_0x0022:
            double r1 = r0.aspectRatio()     // Catch:{ all -> 0x00a9 }
            com.tencent.liteav.base.util.Size r3 = r11.mFrameSize     // Catch:{ all -> 0x00a9 }
            double r3 = r3.aspectRatio()     // Catch:{ all -> 0x00a9 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r5 >= 0) goto L_0x0041
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r5 = r11.mScaleType     // Catch:{ all -> 0x00a9 }
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r8 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.FIT_CENTER     // Catch:{ all -> 0x00a9 }
            if (r5 != r8) goto L_0x003c
        L_0x0038:
            double r3 = r3 / r1
            r1 = r6
            r6 = r3
            goto L_0x004f
        L_0x003c:
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r8 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.CENTER_CROP     // Catch:{ all -> 0x00a9 }
            if (r5 != r8) goto L_0x004e
            goto L_0x0047
        L_0x0041:
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r5 = r11.mScaleType     // Catch:{ all -> 0x00a9 }
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r8 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.FIT_CENTER     // Catch:{ all -> 0x00a9 }
            if (r5 != r8) goto L_0x0049
        L_0x0047:
            double r1 = r1 / r3
            goto L_0x004f
        L_0x0049:
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r8 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.CENTER_CROP     // Catch:{ all -> 0x00a9 }
            if (r5 != r8) goto L_0x004e
            goto L_0x0038
        L_0x004e:
            r1 = r6
        L_0x004f:
            android.graphics.Matrix r3 = new android.graphics.Matrix     // Catch:{ all -> 0x00a9 }
            r3.<init>()     // Catch:{ all -> 0x00a9 }
            float r4 = (float) r6     // Catch:{ all -> 0x00a9 }
            float r5 = (float) r1     // Catch:{ all -> 0x00a9 }
            int r8 = r0.width     // Catch:{ all -> 0x00a9 }
            float r8 = (float) r8     // Catch:{ all -> 0x00a9 }
            r9 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r9
            int r10 = r0.height     // Catch:{ all -> 0x00a9 }
            float r10 = (float) r10     // Catch:{ all -> 0x00a9 }
            float r10 = r10 / r9
            r3.setScale(r4, r5, r8, r10)     // Catch:{ all -> 0x00a9 }
            android.graphics.Matrix r4 = new android.graphics.Matrix     // Catch:{ all -> 0x00a9 }
            r4.<init>()     // Catch:{ all -> 0x00a9 }
            android.graphics.Matrix r4 = r12.getTransform(r4)     // Catch:{ all -> 0x00a9 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x00a3
            r12.setTransform(r3)     // Catch:{ all -> 0x00a9 }
            r12.postInvalidate()     // Catch:{ all -> 0x00a9 }
            com.tencent.liteav.base.b.b r4 = r11.mThrottlerManager     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = "updateTextureViewMatrix"
            com.tencent.liteav.base.b.a r4 = r4.a(r5)     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = r11.mTAG     // Catch:{ all -> 0x00a9 }
            java.lang.String r8 = "view: %s, scaleX: %.2f, scaleY: %.2f, frame: %s, view: %s"
            r9 = 5
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x00a9 }
            r10 = 0
            r9[r10] = r12     // Catch:{ all -> 0x00a9 }
            r12 = 1
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x00a9 }
            r9[r12] = r6     // Catch:{ all -> 0x00a9 }
            r12 = 2
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ all -> 0x00a9 }
            r9[r12] = r1     // Catch:{ all -> 0x00a9 }
            r12 = 3
            com.tencent.liteav.base.util.Size r1 = r11.mFrameSize     // Catch:{ all -> 0x00a9 }
            r9[r12] = r1     // Catch:{ all -> 0x00a9 }
            r12 = 4
            r9[r12] = r0     // Catch:{ all -> 0x00a9 }
            com.tencent.liteav.base.util.LiteavLog.i(r4, r5, r8, r9)     // Catch:{ all -> 0x00a9 }
        L_0x00a3:
            r11.mTransformMatrix = r3     // Catch:{ all -> 0x00a9 }
            monitor-exit(r11)
            return
        L_0x00a7:
            monitor-exit(r11)
            return
        L_0x00a9:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.renderer.TextureViewRenderHelper.updateTextureViewRenderMatrix(android.view.TextureView):void");
    }

    public void checkViewAvailability() {
        this.mUIHandler.post(k.a(this));
    }

    public TextureView getTextureView() {
        return this.mTextureView;
    }

    public Matrix getTransformMatrix(int i11, int i12) {
        Matrix matrix = new Matrix(this.mTransformMatrix);
        matrix.postScale(1.0f, -1.0f, ((float) i11) / 2.0f, ((float) i12) / 2.0f);
        return matrix;
    }

    public boolean isUsingTextureView() {
        return true;
    }

    public void release(boolean z11) {
        this.mUIHandler.post(j.a(this, z11));
    }

    public synchronized void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i11, int i12, boolean z11) {
        if (this.mScaleType == gLScaleType) {
            Size size = this.mFrameSize;
            if (i11 == size.width && i12 == size.height) {
                return;
            }
        }
        this.mScaleType = gLScaleType;
        this.mFrameSize.set(i11, i12);
        this.mUIHandler.runOrPost(l.a(this));
    }

    public TextureViewRenderHelper(TextureView textureView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "TextureViewRenderHelper_" + hashCode();
        this.mTAG = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.mUIHandler = customHandler;
        this.mListener = renderViewListener;
        this.mTXCloudVideoView = null;
        if (textureView == null) {
            LiteavLog.w(str, "textureView is null.");
            return;
        }
        LiteavLog.i(str, "construct,textureView=".concat(String.valueOf(textureView)));
        this.mTextureView = textureView;
        customHandler.post(i.a(this, textureView));
    }
}
