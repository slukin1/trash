package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.base.b.a;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.h;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.xiaomi.mipush.sdk.Constants;

public final class k extends RenderViewHelperInterface {

    /* renamed from: a  reason: collision with root package name */
    public TextureView f22441a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f22442b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final CustomHandler f22443c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final b f22444d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f22445e;

    /* renamed from: f  reason: collision with root package name */
    private final TXCloudVideoView f22446f;

    /* renamed from: g  reason: collision with root package name */
    private final Size f22447g = new Size();

    /* renamed from: h  reason: collision with root package name */
    private GLConstants.GLScaleType f22448h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f22449i = null;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f22450j = false;

    /* renamed from: k  reason: collision with root package name */
    private Matrix f22451k = new Matrix();

    /* renamed from: l  reason: collision with root package name */
    private SurfaceTexture f22452l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Size f22453m = new Size();

    /* renamed from: n  reason: collision with root package name */
    private final TextureView.SurfaceTextureListener f22454n = new TextureView.SurfaceTextureListener() {
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            a a11 = k.this.f22444d.a("surfaceCreate");
            String d11 = k.this.f22442b;
            LiteavLog.i(a11, d11, "onSurfaceTextureAvailable, size:" + i11 + "x" + i12 + " surfaceTexture:" + surfaceTexture + " mSavedSurfaceTexture:" + k.this.f22449i, new Object[0]);
            k.this.b(k.this.a(surfaceTexture));
            k kVar = k.this;
            kVar.b(kVar.f22441a);
            k.this.f22453m.width = i11;
            k.this.f22453m.height = i12;
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            String d11 = k.this.f22442b;
            LiteavLog.i(d11, "onSurfaceTextureDestroyed surface:" + surfaceTexture + " mTextureView:" + k.this.f22441a);
            k.this.a();
            if (k.this.f22441a == null) {
                return true;
            }
            SurfaceTexture unused = k.this.f22449i = surfaceTexture;
            return false;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            boolean z11 = false;
            LiteavLog.i(k.this.f22444d.a("surfaceSizeChanged"), k.this.f22442b, "onSurfaceTextureSizeChanged, size: %dx%d", Integer.valueOf(i11), Integer.valueOf(i12));
            k.this.b(surfaceTexture);
            k kVar = k.this;
            kVar.b(kVar.f22441a);
            boolean z12 = k.this.f22453m.width > k.this.f22453m.height;
            if (i11 > i12) {
                z11 = true;
            }
            if (z12 != z11) {
                k.h(k.this);
            }
            k.this.f22453m.width = i11;
            k.this.f22453m.height = i12;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (!k.this.f22450j) {
                boolean unused = k.this.f22450j = true;
                k.this.f22443c.post(q.a(this));
            }
        }
    };

    public k(TXCloudVideoView tXCloudVideoView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "TextureViewRenderHelper_" + hashCode();
        this.f22442b = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f22443c = customHandler;
        this.f22445e = renderViewListener;
        this.f22446f = tXCloudVideoView;
        if (tXCloudVideoView == null) {
            LiteavLog.w(str, "txCloudVideoView is null.");
            return;
        }
        LiteavLog.i(str, "construct,txCloudVideoView=".concat(String.valueOf(tXCloudVideoView)));
        TextureView textureView = new TextureView(tXCloudVideoView.getContext());
        this.f22441a = textureView;
        customHandler.post(l.a(this, tXCloudVideoView, textureView));
    }

    public static /* synthetic */ void h(k kVar) {
        TextureView textureView;
        Bitmap bitmap;
        if (kVar.f22445e != null && (textureView = kVar.f22441a) != null && (bitmap = textureView.getBitmap()) != null) {
            kVar.f22445e.onRequestRedraw(bitmap);
        }
    }

    public static /* synthetic */ void m(k kVar) {
        TextureView textureView;
        TXCloudVideoView tXCloudVideoView = kVar.f22446f;
        if (tXCloudVideoView != null && (textureView = kVar.f22441a) != null) {
            TXCCloudVideoViewMethodInvoker.removeDeprecatedViews(tXCloudVideoView, textureView);
        }
    }

    public final void checkViewAvailability() {
        this.f22443c.post(o.a(this));
    }

    public final Matrix getTransformMatrix(int i11, int i12) {
        Matrix matrix = new Matrix(this.f22451k);
        matrix.postScale(1.0f, -1.0f, ((float) i11) / 2.0f, ((float) i12) / 2.0f);
        return matrix;
    }

    public final boolean isUsingTextureView() {
        return true;
    }

    public final void release(boolean z11) {
        this.f22443c.post(n.a(this, z11));
    }

    public final synchronized void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i11, int i12, boolean z11) {
        if (this.f22448h == gLScaleType) {
            Size size = this.f22447g;
            if (i11 == size.width && i12 == size.height) {
                return;
            }
        }
        this.f22448h = gLScaleType;
        this.f22447g.set(i11, i12);
        this.f22443c.runOrPost(p.a(this));
    }

    public static /* synthetic */ void a(k kVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        TXCCloudVideoViewMethodInvoker.addView(tXCloudVideoView, textureView);
        kVar.a(textureView);
    }

    public static /* synthetic */ void b(k kVar) {
        TextureView textureView = kVar.f22441a;
        if (textureView == null) {
            LiteavLog.i(kVar.f22442b, "view is not available when textureView is null");
            return;
        }
        if (!(textureView.isAvailable() && kVar.f22441a.getWidth() != 0 && kVar.f22441a.getHeight() != 0 && kVar.f22441a.isShown())) {
            String str = kVar.f22442b;
            TextureView textureView2 = kVar.f22441a;
            LiteavLog.i(str, "%s is not available when surface available:%b, isShown:%b", textureView2, Boolean.valueOf(textureView2.isAvailable()), Boolean.valueOf(kVar.f22441a.isShown()));
        }
    }

    public static /* synthetic */ void a(k kVar, boolean z11) {
        String str = kVar.f22442b;
        LiteavLog.i(str, "release,mTextureView=" + kVar.f22441a);
        if (kVar.f22441a != null) {
            kVar.a();
            if (kVar.f22441a.getSurfaceTextureListener() == kVar.f22454n) {
                kVar.f22441a.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            SurfaceTexture surfaceTexture = kVar.f22449i;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                kVar.f22449i = null;
            }
            if (kVar.f22446f != null) {
                String str2 = kVar.f22442b;
                LiteavLog.i(str2, "clearLastImage=" + z11 + ",mHasFirstFrameRendered=" + kVar.f22450j);
                TXCCloudVideoViewMethodInvoker.removeView(kVar.f22446f, kVar.f22441a, z11 | (kVar.f22450j ^ true));
            }
            kVar.f22441a = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(android.view.TextureView r12) {
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
            com.tencent.liteav.base.util.Size r1 = r11.f22447g     // Catch:{ all -> 0x00a9 }
            boolean r1 = r1.isValid()     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x00a7
            boolean r1 = r0.isValid()     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x0022
            goto L_0x00a7
        L_0x0022:
            double r1 = r0.aspectRatio()     // Catch:{ all -> 0x00a9 }
            com.tencent.liteav.base.util.Size r3 = r11.f22447g     // Catch:{ all -> 0x00a9 }
            double r3 = r3.aspectRatio()     // Catch:{ all -> 0x00a9 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r5 >= 0) goto L_0x0041
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r5 = r11.f22448h     // Catch:{ all -> 0x00a9 }
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.FIT_CENTER     // Catch:{ all -> 0x00a9 }
            if (r5 != r8) goto L_0x003c
        L_0x0038:
            double r3 = r3 / r1
            r1 = r6
            r6 = r3
            goto L_0x004f
        L_0x003c:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP     // Catch:{ all -> 0x00a9 }
            if (r5 != r8) goto L_0x004e
            goto L_0x0047
        L_0x0041:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r5 = r11.f22448h     // Catch:{ all -> 0x00a9 }
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.FIT_CENTER     // Catch:{ all -> 0x00a9 }
            if (r5 != r8) goto L_0x0049
        L_0x0047:
            double r1 = r1 / r3
            goto L_0x004f
        L_0x0049:
            com.tencent.liteav.videobase.base.GLConstants$GLScaleType r8 = com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP     // Catch:{ all -> 0x00a9 }
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
            com.tencent.liteav.base.b.b r4 = r11.f22444d     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = "updateTextureViewMatrix"
            com.tencent.liteav.base.b.a r4 = r4.a(r5)     // Catch:{ all -> 0x00a9 }
            java.lang.String r5 = r11.f22442b     // Catch:{ all -> 0x00a9 }
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
            com.tencent.liteav.base.util.Size r1 = r11.f22447g     // Catch:{ all -> 0x00a9 }
            r9[r12] = r1     // Catch:{ all -> 0x00a9 }
            r12 = 4
            r9[r12] = r0     // Catch:{ all -> 0x00a9 }
            com.tencent.liteav.base.util.LiteavLog.i(r4, r5, r8, r9)     // Catch:{ all -> 0x00a9 }
        L_0x00a3:
            r11.f22451k = r3     // Catch:{ all -> 0x00a9 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.renderer.k.b(android.view.TextureView):void");
    }

    public k(TextureView textureView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "TextureViewRenderHelper_" + hashCode();
        this.f22442b = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f22443c = customHandler;
        this.f22445e = renderViewListener;
        this.f22446f = null;
        if (textureView == null) {
            LiteavLog.w(str, "textureView is null.");
            return;
        }
        LiteavLog.i(str, "construct,textureView=".concat(String.valueOf(textureView)));
        this.f22441a = textureView;
        customHandler.post(m.a(this, textureView));
    }

    /* access modifiers changed from: private */
    public void a(TextureView textureView) {
        if (textureView == null) {
            LiteavLog.w(this.f22442b, "setup,textureView is null.");
            return;
        }
        if (textureView.isAvailable()) {
            Size size = new Size(textureView.getWidth(), textureView.getHeight());
            String str = this.f22442b;
            LiteavLog.i(str, "setup,textureView=" + textureView + Constants.ACCEPT_TIME_SEPARATOR_SP + size);
            b(textureView.getSurfaceTexture());
        } else {
            LiteavLog.i(this.f22442b, "setup,textureView not available.");
        }
        textureView.setSurfaceTextureListener(this.f22454n);
        b(textureView);
    }

    /* access modifiers changed from: private */
    public SurfaceTexture a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f22449i;
        if (!(surfaceTexture2 == null || this.f22441a == null || h.a(surfaceTexture, surfaceTexture2))) {
            try {
                this.f22441a.setSurfaceTexture(this.f22449i);
                surfaceTexture = this.f22449i;
            } catch (Throwable th2) {
                LiteavLog.e(this.f22442b, "error setting saved SurfaceTexture.", th2);
            }
            this.f22449i = null;
        }
        return surfaceTexture;
    }

    /* access modifiers changed from: private */
    public void b(SurfaceTexture surfaceTexture) {
        if (this.f22452l != surfaceTexture) {
            this.f22452l = surfaceTexture;
            RenderViewHelperInterface.RenderViewListener renderViewListener = this.f22445e;
            if (renderViewListener != null) {
                renderViewListener.onSurfaceChanged(new Surface(surfaceTexture), true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f22452l = null;
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f22445e;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }
}
