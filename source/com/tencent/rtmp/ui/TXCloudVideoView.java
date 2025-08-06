package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class TXCloudVideoView extends FrameLayout implements ScaleGestureDetector.OnScaleGestureListener {
    private static final int FOCUS_AREA_SIZE_IN_DP = 70;
    private WeakReference<b> mCallback;
    private final Rect mDashMargin;
    private final Dashboard mDashboard;
    private final a mDelayedTapRunnable;
    private final HashSet<TextureView> mDeprecatedTextureViewSet;
    private boolean mEnableShowLog;
    private boolean mEnableTouchToFocus;
    private boolean mEnableZoom;
    private FocusIndicatorView mFocusIndicatorView;
    public Object mGLContext;
    private final Runnable mHideIndicatorViewRunnable;
    private float mLastScaleFactor;
    private float mScaleFactor;
    private ScaleGestureDetector mScaleGestureDetector;
    private WeakReference<Surface> mSurface;
    private final WeakReference<SurfaceView> mSurfaceView;
    private final String mTAG;
    /* access modifiers changed from: private */
    public OnTapListener mTapListener;
    private TextureView mTopTextureView;
    private String mUserId;
    private TextureView mVideoViewSetByUser;
    private OnZoomListener mZoomListener;

    public interface b {
        void onShowLog(boolean z11);
    }

    public TXCloudVideoView(Context context) {
        this(context, (AttributeSet) null, (SurfaceView) null);
    }

    private void addViewInternal(TextureView textureView) {
        if (textureView == null) {
            LiteavLog.w(this.mTAG, "addViewInternal,TextureView is null.");
            return;
        }
        if (textureView.getParent() == null) {
            addView(textureView);
            updateTopTextureView();
        } else if (textureView.getParent() == this) {
            LiteavLog.i(this.mTAG, "view has been added.");
        } else {
            String str = this.mTAG;
            LiteavLog.w(str, "view has been added to other parent view. parent=" + textureView.getParent());
        }
        this.mDeprecatedTextureViewSet.remove(textureView);
    }

    private TextureView getTextureViewSetByUser() {
        return this.mVideoViewSetByUser;
    }

    /* access modifiers changed from: private */
    public void hideIndicatorView() {
        FocusIndicatorView focusIndicatorView = this.mFocusIndicatorView;
        if (focusIndicatorView != null) {
            focusIndicatorView.setVisibility(8);
        }
    }

    private boolean isShowLogEnabled() {
        return this.mEnableShowLog;
    }

    private static int px2dip(Context context, float f11) {
        return (int) ((f11 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void removeDeprecatedViews(TextureView textureView) {
        Iterator<TextureView> it2 = this.mDeprecatedTextureViewSet.iterator();
        while (it2.hasNext()) {
            TextureView next = it2.next();
            if (!(next == null || next == textureView)) {
                try {
                    removeView(next);
                } catch (Exception e11) {
                    LiteavLog.e(this.mTAG, "removeView view error: ", (Throwable) e11);
                }
                it2.remove();
            }
        }
        updateTopTextureView();
    }

    private void removeViewInternal(TextureView textureView, boolean z11) {
        if (textureView != null) {
            if (z11) {
                try {
                    removeView(textureView);
                } catch (Exception e11) {
                    LiteavLog.e(this.mTAG, "removeView view error: ", (Throwable) e11);
                }
                updateTopTextureView();
                this.mDeprecatedTextureViewSet.remove(textureView);
            } else if (textureView.getParent() == this) {
                removeDeprecatedViews(textureView);
                this.mDeprecatedTextureViewSet.add(textureView);
            } else if (textureView.getParent() == null) {
                LiteavLog.i(this.mTAG, "current view has been removed from the parent view. view=".concat(String.valueOf(textureView)));
            } else if (textureView.getParent() != this) {
                String str = this.mTAG;
                LiteavLog.w(str, "current view is not a child view of this view. parent=" + textureView.getParent());
            }
        }
    }

    private void repositionDashBoard() {
        try {
            removeView(this.mDashboard);
        } catch (Exception e11) {
            LiteavLog.e(this.mTAG, "removeView dashboard view error: ", (Throwable) e11);
        }
        addView(this.mDashboard);
    }

    private void setBackgroundColorForInternalView(int i11) {
        LiteavLog.i(this.mTAG, "setBackgroundColorForInternalView color:".concat(String.valueOf(i11)));
        if (this.mSurface == null && this.mSurfaceView == null) {
            int i12 = (i11 >> 16) & 255;
            super.setBackgroundColor(Color.argb(i11 & 255, (i11 >> 24) & 255, i12, (i11 >> 8) & 255));
        }
    }

    private void setShowLogCallback(WeakReference<b> weakReference) {
        this.mCallback = weakReference;
    }

    private void setTouchToFocusEnabled(boolean z11, OnTapListener onTapListener) {
        this.mEnableTouchToFocus = z11;
        this.mTapListener = onTapListener;
    }

    private void setZoomEnabled(boolean z11, OnZoomListener onZoomListener) {
        LiteavLog.i(this.mTAG, "setZoomEnabled: ".concat(String.valueOf(z11)));
        this.mEnableZoom = z11;
        this.mZoomListener = onZoomListener;
    }

    private void showFocusView(int i11, int i12, int i13, int i14) {
        post(b.a(this, i11, i12, i13, i14));
    }

    /* access modifiers changed from: private */
    public void showFocusViewInternal(int i11, int i12, int i13, int i14) {
        if ((i13 == 0 || i13 == getWidth()) && (i14 == 0 || i14 == getHeight())) {
            LiteavLog.v(this.mTAG, "show indicator view at (%d,%d)", Integer.valueOf(i11), Integer.valueOf(i12));
            removeCallbacks(this.mHideIndicatorViewRunnable);
            int i15 = (int) ((getResources().getDisplayMetrics().density * 70.0f) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i15, i15);
            int i16 = i15 / 2;
            layoutParams.leftMargin = g.a(i11 - i16, 0, getWidth() - i15);
            layoutParams.topMargin = g.a(i12 - i16, 0, getHeight() - i15);
            FocusIndicatorView focusIndicatorView = this.mFocusIndicatorView;
            if (focusIndicatorView == null) {
                FocusIndicatorView focusIndicatorView2 = new FocusIndicatorView(getContext());
                this.mFocusIndicatorView = focusIndicatorView2;
                addView(focusIndicatorView2, layoutParams);
            } else if (indexOfChild(focusIndicatorView) != getChildCount() - 1) {
                try {
                    removeView(this.mFocusIndicatorView);
                } catch (Exception e11) {
                    LiteavLog.e(this.mTAG, "removeView focus indicator view error: ", (Throwable) e11);
                }
                addView(this.mFocusIndicatorView, layoutParams);
            } else {
                this.mFocusIndicatorView.setLayoutParams(layoutParams);
            }
            this.mFocusIndicatorView.setVisibility(0);
            FocusIndicatorView focusIndicatorView3 = this.mFocusIndicatorView;
            focusIndicatorView3.startAnimation(focusIndicatorView3.f48662a);
            postDelayed(this.mHideIndicatorViewRunnable, TimeUnit.SECONDS.toMillis(1));
            return;
        }
        LiteavLog.i(this.mTAG, "ignore show indicator view when view size changed");
    }

    private void updateTopTextureView() {
        TextureView textureView;
        int childCount = getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                textureView = null;
                break;
            }
            View childAt = getChildAt(childCount);
            if (childAt instanceof TextureView) {
                textureView = (TextureView) childAt;
                break;
            }
            childCount--;
        }
        if (this.mTopTextureView != textureView) {
            this.mTopTextureView = textureView;
        }
    }

    public void addVideoView(TextureView textureView) {
        removeViewInternal(this.mVideoViewSetByUser, true);
        addViewInternal(textureView);
        this.mVideoViewSetByUser = textureView;
        repositionDashBoard();
    }

    public void clearLastFrame(boolean z11) {
        if (z11) {
            setVisibility(8);
        }
    }

    public void clearLog() {
        Dashboard dashboard = this.mDashboard;
        if (dashboard != null) {
            dashboard.f48655a.setLength(0);
            TextView textView = dashboard.f48656b;
            if (textView != null) {
                textView.setText("");
            }
            TextView textView2 = dashboard.f48657c;
            if (textView2 != null) {
                textView2.setText("");
            }
        }
    }

    public void disableLog(boolean z11) {
    }

    @Deprecated
    public TextureView getHWVideoView() {
        return getVideoView();
    }

    public Object getOpenGLContext() {
        return this.mGLContext;
    }

    public Surface getSurface() {
        WeakReference<Surface> weakReference = this.mSurface;
        if (weakReference == null) {
            return null;
        }
        Surface surface = (Surface) weakReference.get();
        if (surface == null) {
            LiteavLog.w(this.mTAG, "surface is null.");
        }
        return surface;
    }

    public SurfaceView getSurfaceView() {
        WeakReference<SurfaceView> weakReference = this.mSurfaceView;
        if (weakReference == null) {
            return null;
        }
        SurfaceView surfaceView = (SurfaceView) weakReference.get();
        if (surfaceView == null) {
            LiteavLog.w(this.mTAG, "surfaceView is null.");
        }
        return surfaceView;
    }

    public String getUserId() {
        return this.mUserId;
    }

    @Deprecated
    public TextureView getVideoView() {
        TextureView textureView = this.mVideoViewSetByUser;
        if (textureView != null) {
            return textureView;
        }
        return this.mTopTextureView;
    }

    public void onDestroy() {
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        Dashboard dashboard = this.mDashboard;
        Rect rect = this.mDashMargin;
        dashboard.a(rect.left, rect.top, rect.right, rect.bottom);
        this.mDashboard.setStatusTextSize((float) (((double) px2dip(getContext(), (float) getWidth())) / 30.0d));
        this.mDashboard.setEventTextSize((float) (((double) px2dip(getContext(), (float) getWidth())) / 25.0d));
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (!this.mEnableZoom) {
            return false;
        }
        this.mLastScaleFactor = scaleGestureDetector.getScaleFactor();
        float a11 = g.a(this.mScaleFactor + (scaleGestureDetector.getScaleFactor() - this.mLastScaleFactor), 0.0f);
        this.mScaleFactor = a11;
        OnZoomListener onZoomListener = this.mZoomListener;
        if (onZoomListener != null) {
            onZoomListener.onZoom(a11);
        }
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.mLastScaleFactor = scaleGestureDetector.getScaleFactor();
        return this.mEnableZoom;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
            if (this.mEnableTouchToFocus) {
                a aVar = this.mDelayedTapRunnable;
                int width = getWidth();
                int height = getHeight();
                Point point = aVar.f48671a;
                point.x = (int) motionEvent.getX();
                point.y = (int) motionEvent.getY();
                aVar.f48672b = width;
                aVar.f48673c = height;
                removeCallbacks(this.mDelayedTapRunnable);
                postDelayed(this.mDelayedTapRunnable, 100);
            }
        } else if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2 && this.mEnableZoom) {
            removeCallbacks(this.mDelayedTapRunnable);
            hideIndicatorView();
            if (this.mScaleGestureDetector == null) {
                this.mScaleGestureDetector = new ScaleGestureDetector(getContext(), this);
            }
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
        }
        if (!this.mEnableZoom) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            performClick();
        }
        return true;
    }

    public void removeVideoView() {
        removeViewInternal(this.mVideoViewSetByUser, true);
        this.mVideoViewSetByUser = null;
    }

    public void setDashBoardMarginInPx(int i11, int i12, int i13, int i14) {
        Rect rect = this.mDashMargin;
        rect.left = i11;
        rect.right = i12;
        rect.top = i13;
        rect.bottom = i14;
        this.mDashboard.a(i11, i13, i12, i14);
    }

    public void setDashBoardMarginInRatio(float f11, float f12, float f13, float f14) {
        final float f15 = f11;
        final float f16 = f12;
        final float f17 = f13;
        final float f18 = f14;
        postDelayed(new Runnable() {
            public final void run() {
                TXCloudVideoView tXCloudVideoView = TXCloudVideoView.this;
                tXCloudVideoView.setDashBoardMarginInPx((int) (((float) tXCloudVideoView.getWidth()) * f15), (int) (((float) TXCloudVideoView.this.getWidth()) * f16), (int) (((float) TXCloudVideoView.this.getHeight()) * f17), (int) (((float) TXCloudVideoView.this.getHeight()) * f18));
            }
        }, 100);
    }

    public void setLogMargin(float f11, float f12, float f13, float f14) {
        setDashBoardMarginInPx((int) f11, (int) f12, (int) f13, (int) f14);
    }

    public void setOpenGLContext(Object obj) {
        this.mGLContext = obj;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void showLog(boolean z11) {
        this.mEnableShowLog = z11;
        WeakReference<b> weakReference = this.mCallback;
        b bVar = weakReference == null ? null : (b) weakReference.get();
        if (bVar != null) {
            bVar.onShowLog(z11);
        }
    }

    public TXCloudVideoView(SurfaceView surfaceView) {
        this(surfaceView.getContext(), (AttributeSet) null, surfaceView);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TXCloudVideoView(Context context, Surface surface) {
        this(context, (AttributeSet) null, (SurfaceView) null);
        WeakReference<Surface> weakReference = null;
        this.mSurface = surface != null ? new WeakReference<>(surface) : weakReference;
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final Point f48671a;

        /* renamed from: b  reason: collision with root package name */
        public int f48672b;

        /* renamed from: c  reason: collision with root package name */
        public int f48673c;

        private a() {
            this.f48671a = new Point();
            this.f48672b = 0;
            this.f48673c = 0;
        }

        public final void run() {
            if (TXCloudVideoView.this.mTapListener != null) {
                OnTapListener access$100 = TXCloudVideoView.this.mTapListener;
                Point point = this.f48671a;
                access$100.onTap(point.x, point.y, this.f48672b, this.f48673c);
            }
        }

        public /* synthetic */ a(TXCloudVideoView tXCloudVideoView, byte b11) {
            this();
        }
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (SurfaceView) null);
    }

    public TXCloudVideoView(Context context, AttributeSet attributeSet, SurfaceView surfaceView) {
        super(context, attributeSet);
        this.mTAG = "TXCloudVideoView_" + hashCode();
        this.mDashMargin = new Rect();
        this.mDeprecatedTextureViewSet = new HashSet<>();
        this.mEnableTouchToFocus = false;
        this.mDelayedTapRunnable = new a(this, (byte) 0);
        this.mEnableZoom = false;
        this.mUserId = "";
        this.mHideIndicatorViewRunnable = a.a(this);
        this.mDashboard = new Dashboard(context);
        this.mSurfaceView = surfaceView != null ? new WeakReference<>(surfaceView) : null;
    }
}
