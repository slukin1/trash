package com.tencent.liteav.videobase.videobase;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;

@JNINamespace("liteav::video")
public class DisplayTarget {
    private static final String TAG = "DisplayTarget";
    private boolean mIsViewFromTXCloudVideoView;
    private Surface mSurface;
    private WeakReference<SurfaceView> mSurfaceView;
    private final String mTAG;
    private final a mTargetType;
    private WeakReference<TextureView> mTextureView;
    private WeakReference<TXCloudVideoView> mTxCloudVideoView;
    private final CustomHandler mUIHandler;

    /* renamed from: com.tencent.liteav.videobase.videobase.DisplayTarget$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22277a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.liteav.videobase.videobase.DisplayTarget$a[] r0 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22277a = r0
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.SURFACEVIEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22277a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.TEXTUREVIEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22277a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.SURFACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22277a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.TXCLOUDVIEW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.videobase.DisplayTarget.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        TEXTUREVIEW,
        SURFACEVIEW,
        SURFACE,
        TXCLOUDVIEW
    }

    public DisplayTarget(DisplayTarget displayTarget) {
        this.mTAG = "DisplayTarget_" + hashCode();
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        this.mTargetType = displayTarget.mTargetType;
        this.mTxCloudVideoView = displayTarget.mTxCloudVideoView;
        this.mTextureView = displayTarget.mTextureView;
        this.mSurfaceView = displayTarget.mSurfaceView;
        this.mSurface = displayTarget.mSurface;
        this.mIsViewFromTXCloudVideoView = displayTarget.mIsViewFromTXCloudVideoView;
    }

    public static DisplayTarget create(Object obj) {
        if (obj instanceof DisplayTarget) {
            return new DisplayTarget((DisplayTarget) obj);
        }
        if (obj instanceof TXCloudVideoView) {
            return new DisplayTarget((TXCloudVideoView) obj);
        }
        if (obj instanceof TextureView) {
            return new DisplayTarget((TextureView) obj);
        }
        if (obj instanceof SurfaceView) {
            return new DisplayTarget((SurfaceView) obj);
        }
        LiteavLog.w(TAG, "object is unknown. object=".concat(String.valueOf(obj)));
        return null;
    }

    private void requestLayout(View view) {
        if (view != null) {
            runOnUIThread(b.a(view));
        }
    }

    private void runOnUIThread(Runnable runnable) {
        if (Looper.myLooper() == this.mUIHandler.getLooper()) {
            runnable.run();
        } else {
            this.mUIHandler.post(runnable);
        }
    }

    private void setVisibility(View view, int i11) {
        if (view != null) {
            runOnUIThread(a.a(view, i11));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DisplayTarget displayTarget = (DisplayTarget) obj;
            return this.mTargetType == displayTarget.mTargetType && CommonUtil.equals(getTXCloudVideoView(), displayTarget.getTXCloudVideoView()) && CommonUtil.equals(getTextureView(), displayTarget.getTextureView()) && CommonUtil.equals(getSurfaceView(), displayTarget.getSurfaceView()) && CommonUtil.equals(this.mSurface, displayTarget.mSurface);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r0 = r3.mTxCloudVideoView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.liteav.base.util.Size getSize() {
        /*
            r3 = this;
            com.tencent.liteav.videobase.videobase.DisplayTarget$a r0 = r3.mTargetType
            com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.SURFACEVIEW
            if (r0 != r1) goto L_0x0011
            java.lang.ref.WeakReference<android.view.SurfaceView> r1 = r3.mSurfaceView
            if (r1 == 0) goto L_0x0011
            java.lang.Object r0 = r1.get()
            android.view.View r0 = (android.view.View) r0
            goto L_0x0030
        L_0x0011:
            com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.TEXTUREVIEW
            if (r0 != r1) goto L_0x0020
            java.lang.ref.WeakReference<android.view.TextureView> r1 = r3.mTextureView
            if (r1 == 0) goto L_0x0020
            java.lang.Object r0 = r1.get()
            android.view.View r0 = (android.view.View) r0
            goto L_0x0030
        L_0x0020:
            com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.TXCLOUDVIEW
            if (r0 != r1) goto L_0x002f
            java.lang.ref.WeakReference<com.tencent.rtmp.ui.TXCloudVideoView> r0 = r3.mTxCloudVideoView
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            r1 = 0
            if (r0 == 0) goto L_0x003c
            int r1 = r0.getWidth()
            int r0 = r0.getHeight()
            goto L_0x003d
        L_0x003c:
            r0 = r1
        L_0x003d:
            com.tencent.liteav.base.util.Size r2 = new com.tencent.liteav.base.util.Size
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.videobase.DisplayTarget.getSize():com.tencent.liteav.base.util.Size");
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public SurfaceView getSurfaceView() {
        WeakReference<SurfaceView> weakReference = this.mSurfaceView;
        if (weakReference != null) {
            return (SurfaceView) weakReference.get();
        }
        return null;
    }

    public TXCloudVideoView getTXCloudVideoView() {
        WeakReference<TXCloudVideoView> weakReference = this.mTxCloudVideoView;
        if (weakReference != null) {
            return (TXCloudVideoView) weakReference.get();
        }
        return null;
    }

    public TextureView getTextureView() {
        WeakReference<TextureView> weakReference = this.mTextureView;
        if (weakReference != null) {
            return (TextureView) weakReference.get();
        }
        return null;
    }

    public a getType() {
        return this.mTargetType;
    }

    public void hideAll() {
        if (!this.mIsViewFromTXCloudVideoView) {
            setVisibility(getTextureView(), 8);
            setVisibility(getSurfaceView(), 8);
        }
    }

    public boolean isUseSameView(DisplayTarget displayTarget) {
        if (equals(displayTarget)) {
            return true;
        }
        if (displayTarget == null) {
            return false;
        }
        int i11 = AnonymousClass1.f22277a[this.mTargetType.ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 == 4 && getTXCloudVideoView() == displayTarget.getTXCloudVideoView() : getSurface() == displayTarget.getSurface() : getTextureView() == displayTarget.getTextureView() : getSurfaceView() == displayTarget.getSurfaceView();
    }

    public boolean isValid() {
        int i11 = AnonymousClass1.f22277a[this.mTargetType.ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 == 4 && getTXCloudVideoView() != null : getSurface() != null : getTextureView() != null : getSurfaceView() != null;
    }

    public void showAll() {
        setVisibility(getTextureView(), 0);
        setVisibility(getSurfaceView(), 0);
        WeakReference<TXCloudVideoView> weakReference = this.mTxCloudVideoView;
        if (weakReference != null) {
            requestLayout((View) weakReference.get());
        }
        requestLayout(getTextureView());
        requestLayout(getSurfaceView());
    }

    public String toString() {
        return "DisplayTarget{mTargetType=" + this.mTargetType + ", mTXCloudVideoView=" + getTXCloudVideoView() + ", mTextureView=" + getTextureView() + ", mSurfaceView=" + getSurfaceView() + ", mSurface=" + this.mSurface + '}';
    }

    public DisplayTarget(TXCloudVideoView tXCloudVideoView) {
        this.mTAG = "DisplayTarget_" + hashCode();
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        if (tXCloudVideoView == null) {
            this.mTargetType = a.TXCLOUDVIEW;
            return;
        }
        SurfaceView surfaceView = tXCloudVideoView.getSurfaceView();
        Surface surface = tXCloudVideoView.getSurface();
        TextureView textureViewSetByUser = TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView);
        if (surfaceView != null) {
            this.mTargetType = a.SURFACEVIEW;
            this.mSurfaceView = new WeakReference<>(surfaceView);
        } else if (surface != null) {
            this.mTargetType = a.SURFACE;
            this.mSurface = surface;
        } else if (textureViewSetByUser != null) {
            this.mTargetType = a.TEXTUREVIEW;
            this.mTextureView = new WeakReference<>(textureViewSetByUser);
            this.mTxCloudVideoView = new WeakReference<>(tXCloudVideoView);
        } else {
            this.mTargetType = a.TXCLOUDVIEW;
            this.mTxCloudVideoView = new WeakReference<>(tXCloudVideoView);
        }
        this.mIsViewFromTXCloudVideoView = true;
    }

    public DisplayTarget(TextureView textureView) {
        this.mTAG = "DisplayTarget_" + hashCode();
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        this.mTargetType = a.TEXTUREVIEW;
        this.mTextureView = new WeakReference<>(textureView);
    }

    public DisplayTarget(SurfaceView surfaceView) {
        this.mTAG = "DisplayTarget_" + hashCode();
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        this.mTargetType = a.SURFACEVIEW;
        this.mSurfaceView = new WeakReference<>(surfaceView);
    }

    public DisplayTarget(Surface surface) {
        this.mTAG = "DisplayTarget_" + hashCode();
        this.mUIHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsViewFromTXCloudVideoView = false;
        this.mTargetType = a.SURFACE;
        this.mSurface = surface;
    }
}
