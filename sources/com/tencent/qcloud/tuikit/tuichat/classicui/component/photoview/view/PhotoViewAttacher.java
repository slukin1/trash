package com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnGestureListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnMatrixChangedListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnOutsidePhotoTapListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnPhotoTapListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnScaleChangedListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnSingleFlingListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnViewDragListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.listener.OnViewTapListener;

public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float DEFAULT_MAX_SCALE = 3.0f;
    private static float DEFAULT_MID_SCALE = 1.75f;
    /* access modifiers changed from: private */
    public static float DEFAULT_MIN_SCALE = 1.0f;
    private static int DEFAULT_ZOOM_DURATION = 200;
    private static final int EDGE_BOTH = 2;
    private static final int EDGE_LEFT = 0;
    private static final int EDGE_NONE = -1;
    private static final int EDGE_RIGHT = 1;
    /* access modifiers changed from: private */
    public static int SINGLE_TOUCH = 1;
    /* access modifiers changed from: private */
    public boolean mAllowParentInterceptOnEdge = true;
    private final Matrix mBaseMatrix = new Matrix();
    private float mBaseRotation;
    /* access modifiers changed from: private */
    public boolean mBlockParentIntercept = false;
    /* access modifiers changed from: private */
    public FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect = new RectF();
    private final Matrix mDrawMatrix = new Matrix();
    private GestureDetector mGestureDetector;
    /* access modifiers changed from: private */
    public ImageView mImageView;
    /* access modifiers changed from: private */
    public Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */
    public View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float[] mMatrixValues = new float[9];
    /* access modifiers changed from: private */
    public float mMaxScale = DEFAULT_MAX_SCALE;
    private float mMidScale = DEFAULT_MID_SCALE;
    /* access modifiers changed from: private */
    public float mMinScale = DEFAULT_MIN_SCALE;
    /* access modifiers changed from: private */
    public View.OnClickListener mOnClickListener;
    /* access modifiers changed from: private */
    public OnViewDragListener mOnViewDragListener;
    /* access modifiers changed from: private */
    public OnOutsidePhotoTapListener mOutsidePhotoTapListener;
    /* access modifiers changed from: private */
    public OnPhotoTapListener mPhotoTapListener;
    /* access modifiers changed from: private */
    public OnScaleChangedListener mScaleChangeListener;
    /* access modifiers changed from: private */
    public CustomGestureDetector mScaleDragDetector;
    private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
    /* access modifiers changed from: private */
    public int mScrollEdge = 2;
    /* access modifiers changed from: private */
    public OnSingleFlingListener mSingleFlingListener;
    /* access modifiers changed from: private */
    public final Matrix mSuppMatrix = new Matrix();
    /* access modifiers changed from: private */
    public OnViewTapListener mViewTapListener;
    /* access modifiers changed from: private */
    public int mZoomDuration = DEFAULT_ZOOM_DURATION;
    private boolean mZoomEnabled = true;
    /* access modifiers changed from: private */
    public OnGestureListener onGestureListener = new OnGestureListener() {
        public void onDrag(float f11, float f12) {
            if (!PhotoViewAttacher.this.mScaleDragDetector.isScaling()) {
                if (PhotoViewAttacher.this.mOnViewDragListener != null) {
                    PhotoViewAttacher.this.mOnViewDragListener.onDrag(f11, f12);
                }
                PhotoViewAttacher.this.mSuppMatrix.postTranslate(f11, f12);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                ViewParent parent = PhotoViewAttacher.this.mImageView.getParent();
                if (!PhotoViewAttacher.this.mAllowParentInterceptOnEdge || PhotoViewAttacher.this.mScaleDragDetector.isScaling() || PhotoViewAttacher.this.mBlockParentIntercept) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((PhotoViewAttacher.this.mScrollEdge == 2 || ((PhotoViewAttacher.this.mScrollEdge == 0 && f11 >= 1.0f) || (PhotoViewAttacher.this.mScrollEdge == 1 && f11 <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        public void onFling(float f11, float f12, float f13, float f14) {
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            FlingRunnable unused = photoViewAttacher.mCurrentFlingRunnable = new FlingRunnable(photoViewAttacher.mImageView.getContext());
            FlingRunnable access$800 = PhotoViewAttacher.this.mCurrentFlingRunnable;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int access$900 = photoViewAttacher2.getImageViewWidth(photoViewAttacher2.mImageView);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            access$800.fling(access$900, photoViewAttacher3.getImageViewHeight(photoViewAttacher3.mImageView), (int) f13, (int) f14);
            ThreadUtils.runOnUiThread(PhotoViewAttacher.this.mCurrentFlingRunnable);
        }

        public void onScale(float f11, float f12, float f13) {
            if (PhotoViewAttacher.this.getScale() >= PhotoViewAttacher.this.mMaxScale && f11 >= 1.0f) {
                return;
            }
            if (PhotoViewAttacher.this.getScale() > PhotoViewAttacher.this.mMinScale || f11 > 1.0f) {
                if (PhotoViewAttacher.this.mScaleChangeListener != null) {
                    PhotoViewAttacher.this.mScaleChangeListener.onScaleChange(f11, f12, f13);
                }
                PhotoViewAttacher.this.mSuppMatrix.postScale(f11, f11, f12, f13);
                PhotoViewAttacher.this.checkAndDisplayMatrix();
            }
        }
    };

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$widget$ImageView$ScaleType = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher.AnonymousClass4.<clinit>():void");
        }
    }

    public class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f11, float f12, float f13, float f14) {
            this.mFocalX = f13;
            this.mFocalY = f14;
            this.mZoomStart = f11;
            this.mZoomEnd = f12;
        }

        private float interpolate() {
            return PhotoViewAttacher.this.mInterpolator.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / ((float) PhotoViewAttacher.this.mZoomDuration)));
        }

        public void run() {
            float interpolate = interpolate();
            float f11 = this.mZoomStart;
            PhotoViewAttacher.this.onGestureListener.onScale((f11 + ((this.mZoomEnd - f11) * interpolate)) / PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
            if (interpolate < 1.0f) {
                Compat.postOnAnimation(PhotoViewAttacher.this.mImageView, this);
            }
        }
    }

    public class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final OverScroller mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = new OverScroller(context);
        }

        public void cancelFling() {
            this.mScroller.forceFinished(true);
        }

        public void fling(int i11, int i12, int i13, int i14) {
            int i15;
            int i16;
            int i17;
            int i18;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect != null) {
                int round = Math.round(-displayRect.left);
                float f11 = (float) i11;
                if (f11 < displayRect.width()) {
                    i15 = Math.round(displayRect.width() - f11);
                    i16 = 0;
                } else {
                    i16 = round;
                    i15 = i16;
                }
                int round2 = Math.round(-displayRect.top);
                float f12 = (float) i12;
                if (f12 < displayRect.height()) {
                    i17 = Math.round(displayRect.height() - f12);
                    i18 = 0;
                } else {
                    i18 = round2;
                    i17 = i18;
                }
                this.mCurrentX = round;
                this.mCurrentY = round2;
                if (round != i15 || round2 != i17) {
                    this.mScroller.fling(round, round2, i13, i14, i16, i15, i18, i17, 0, 0);
                }
            }
        }

        public void run() {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                PhotoViewAttacher.this.mSuppMatrix.postTranslate((float) (this.mCurrentX - currX), (float) (this.mCurrentY - currY));
                PhotoViewAttacher.this.checkAndDisplayMatrix();
                this.mCurrentX = currX;
                this.mCurrentY = currY;
                Compat.postOnAnimation(PhotoViewAttacher.this.mImageView, this);
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this.mImageView = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.mBaseRotation = 0.0f;
            this.mScaleDragDetector = new CustomGestureDetector(imageView.getContext(), this.onGestureListener);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
                    if (PhotoViewAttacher.this.mSingleFlingListener == null || PhotoViewAttacher.this.getScale() > PhotoViewAttacher.DEFAULT_MIN_SCALE || motionEvent.getPointerCount() > PhotoViewAttacher.SINGLE_TOUCH || motionEvent2.getPointerCount() > PhotoViewAttacher.SINGLE_TOUCH) {
                        return false;
                    }
                    return PhotoViewAttacher.this.mSingleFlingListener.onFling(motionEvent, motionEvent2, f11, f12);
                }

                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.mLongClickListener != null) {
                        PhotoViewAttacher.this.mLongClickListener.onLongClick(PhotoViewAttacher.this.mImageView);
                    }
                }
            });
            this.mGestureDetector = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    try {
                        float scale = PhotoViewAttacher.this.getScale();
                        float x11 = motionEvent.getX();
                        float y11 = motionEvent.getY();
                        if (scale < PhotoViewAttacher.this.getMediumScale()) {
                            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
                            photoViewAttacher.setScale(photoViewAttacher.getMediumScale(), x11, y11, true);
                        } else if (scale < PhotoViewAttacher.this.getMediumScale() || scale >= PhotoViewAttacher.this.getMaximumScale()) {
                            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
                            photoViewAttacher2.setScale(photoViewAttacher2.getMinimumScale(), x11, y11, true);
                        } else {
                            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
                            photoViewAttacher3.setScale(photoViewAttacher3.getMaximumScale(), x11, y11, true);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                    return true;
                }

                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.mOnClickListener != null) {
                        PhotoViewAttacher.this.mOnClickListener.onClick(PhotoViewAttacher.this.mImageView);
                    }
                    RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
                    float x11 = motionEvent.getX();
                    float y11 = motionEvent.getY();
                    if (PhotoViewAttacher.this.mViewTapListener != null) {
                        PhotoViewAttacher.this.mViewTapListener.onViewTap(PhotoViewAttacher.this.mImageView, x11, y11);
                    }
                    if (displayRect == null) {
                        return false;
                    }
                    if (displayRect.contains(x11, y11)) {
                        float width = (x11 - displayRect.left) / displayRect.width();
                        float height = (y11 - displayRect.top) / displayRect.height();
                        if (PhotoViewAttacher.this.mPhotoTapListener == null) {
                            return true;
                        }
                        PhotoViewAttacher.this.mPhotoTapListener.onPhotoTap(PhotoViewAttacher.this.mImageView, width, height);
                        return true;
                    } else if (PhotoViewAttacher.this.mOutsidePhotoTapListener == null) {
                        return false;
                    } else {
                        PhotoViewAttacher.this.mOutsidePhotoTapListener.onOutsidePhotoTap(PhotoViewAttacher.this.mImageView);
                        return false;
                    }
                }
            });
        }
    }

    private void cancelFling() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    /* access modifiers changed from: private */
    public void checkAndDisplayMatrix() {
        if (checkMatrixBounds()) {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkMatrixBounds() {
        /*
            r11 = this;
            android.graphics.Matrix r0 = r11.getDrawMatrix()
            android.graphics.RectF r0 = r11.getDisplayRect(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            float r2 = r0.height()
            float r3 = r0.width()
            android.widget.ImageView r4 = r11.mImageView
            int r4 = r11.getImageViewHeight(r4)
            float r4 = (float) r4
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = 3
            r8 = 2
            r9 = 0
            if (r5 > 0) goto L_0x003f
            int[] r5 = com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher.AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType
            android.widget.ImageView$ScaleType r10 = r11.mScaleType
            int r10 = r10.ordinal()
            r5 = r5[r10]
            if (r5 == r8) goto L_0x003c
            if (r5 == r7) goto L_0x0037
            float r4 = r4 - r2
            float r4 = r4 / r6
            float r2 = r0.top
            goto L_0x003a
        L_0x0037:
            float r4 = r4 - r2
            float r2 = r0.top
        L_0x003a:
            float r4 = r4 - r2
            goto L_0x004f
        L_0x003c:
            float r2 = r0.top
            goto L_0x0045
        L_0x003f:
            float r2 = r0.top
            int r5 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0047
        L_0x0045:
            float r4 = -r2
            goto L_0x004f
        L_0x0047:
            float r2 = r0.bottom
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x004e
            goto L_0x003a
        L_0x004e:
            r4 = r9
        L_0x004f:
            android.widget.ImageView r2 = r11.mImageView
            int r2 = r11.getImageViewWidth(r2)
            float r2 = (float) r2
            int r5 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            r10 = 1
            if (r5 > 0) goto L_0x007b
            int[] r1 = com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher.AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType
            android.widget.ImageView$ScaleType r5 = r11.mScaleType
            int r5 = r5.ordinal()
            r1 = r1[r5]
            if (r1 == r8) goto L_0x0074
            if (r1 == r7) goto L_0x006e
            float r2 = r2 - r3
            float r2 = r2 / r6
            float r0 = r0.left
            goto L_0x0071
        L_0x006e:
            float r2 = r2 - r3
            float r0 = r0.left
        L_0x0071:
            float r2 = r2 - r0
            r9 = r2
            goto L_0x0078
        L_0x0074:
            float r0 = r0.left
            float r0 = -r0
            r9 = r0
        L_0x0078:
            r11.mScrollEdge = r8
            goto L_0x0093
        L_0x007b:
            float r3 = r0.left
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0085
            r11.mScrollEdge = r1
            float r9 = -r3
            goto L_0x0093
        L_0x0085:
            float r0 = r0.right
            int r1 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0090
            float r9 = r2 - r0
            r11.mScrollEdge = r10
            goto L_0x0093
        L_0x0090:
            r0 = -1
            r11.mScrollEdge = r0
        L_0x0093:
            android.graphics.Matrix r0 = r11.mSuppMatrix
            r0.postTranslate(r9, r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher.checkMatrixBounds():boolean");
    }

    private Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    /* access modifiers changed from: private */
    public int getImageViewHeight(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* access modifiers changed from: private */
    public int getImageViewWidth(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float getValue(Matrix matrix, int i11) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i11];
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        setRotationBy(this.mBaseRotation);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    private void setImageViewMatrix(Matrix matrix) {
        RectF displayRect;
        this.mImageView.setImageMatrix(matrix);
        if (this.mMatrixChangeListener != null && (displayRect = getDisplayRect(matrix)) != null) {
            this.mMatrixChangeListener.onMatrixChanged(displayRect);
        }
    }

    private void updateBaseMatrix(Drawable drawable) {
        if (drawable != null) {
            float imageViewWidth = (float) getImageViewWidth(this.mImageView);
            float imageViewHeight = (float) getImageViewHeight(this.mImageView);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.mBaseMatrix.reset();
            float f11 = (float) intrinsicWidth;
            float f12 = imageViewWidth / f11;
            float f13 = (float) intrinsicHeight;
            float f14 = imageViewHeight / f13;
            ImageView.ScaleType scaleType = this.mScaleType;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.mBaseMatrix.postTranslate((imageViewWidth - f11) / 2.0f, (imageViewHeight - f13) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f12, f14);
                this.mBaseMatrix.postScale(max, max);
                this.mBaseMatrix.postTranslate((imageViewWidth - (f11 * max)) / 2.0f, (imageViewHeight - (f13 * max)) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f12, f14));
                this.mBaseMatrix.postScale(min, min);
                this.mBaseMatrix.postTranslate((imageViewWidth - (f11 * min)) / 2.0f, (imageViewHeight - (f13 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f11, f13);
                RectF rectF2 = new RectF(0.0f, 0.0f, imageViewWidth, imageViewHeight);
                if (((int) this.mBaseRotation) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f13, f11);
                }
                int i11 = AnonymousClass4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
                if (i11 == 1) {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i11 == 2) {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i11 == 3) {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i11 == 4) {
                    this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            resetMatrix();
        }
    }

    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(getDrawMatrix());
    }

    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public Matrix getImageMatrix() {
        return this.mDrawMatrix;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getScale() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow((double) getValue(this.mSuppMatrix, 3), 2.0d))));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void getSuppMatrix(Matrix matrix) {
        matrix.set(this.mSuppMatrix);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    public boolean isZoomable() {
        return this.mZoomEnabled;
    }

    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i11 != i15 || i12 != i16 || i13 != i17 || i14 != i18) {
            updateBaseMatrix(this.mImageView.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.mZoomEnabled
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00be
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewUtil.hasDrawable(r0)
            if (r0 == 0) goto L_0x00be
            int r0 = r12.getAction()
            if (r0 == 0) goto L_0x006e
            if (r0 == r2) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x001b
            goto L_0x007a
        L_0x001b:
            float r0 = r10.getScale()
            float r3 = r10.mMinScale
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0044
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L_0x007a
            com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.mMinScale
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L_0x006c
        L_0x0044:
            float r0 = r10.getScale()
            float r3 = r10.mMaxScale
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x007a
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L_0x007a
            com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher$AnimatedZoomRunnable r9 = new com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.mMaxScale
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L_0x006c:
            r11 = r2
            goto L_0x007b
        L_0x006e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L_0x0077
            r11.requestDisallowInterceptTouchEvent(r2)
        L_0x0077:
            r10.cancelFling()
        L_0x007a:
            r11 = r1
        L_0x007b:
            com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.CustomGestureDetector r0 = r10.mScaleDragDetector
            if (r0 == 0) goto L_0x00b2
            boolean r11 = r0.isScaling()
            com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.CustomGestureDetector r0 = r10.mScaleDragDetector
            boolean r0 = r0.isDragging()
            com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.CustomGestureDetector r3 = r10.mScaleDragDetector
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L_0x009b
            com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.CustomGestureDetector r11 = r10.mScaleDragDetector
            boolean r11 = r11.isScaling()
            if (r11 != 0) goto L_0x009b
            r11 = r2
            goto L_0x009c
        L_0x009b:
            r11 = r1
        L_0x009c:
            if (r0 != 0) goto L_0x00a8
            com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.CustomGestureDetector r0 = r10.mScaleDragDetector
            boolean r0 = r0.isDragging()
            if (r0 != 0) goto L_0x00a8
            r0 = r2
            goto L_0x00a9
        L_0x00a8:
            r0 = r1
        L_0x00a9:
            if (r11 == 0) goto L_0x00ae
            if (r0 == 0) goto L_0x00ae
            r1 = r2
        L_0x00ae:
            r10.mBlockParentIntercept = r1
            r1 = r3
            goto L_0x00b3
        L_0x00b2:
            r1 = r11
        L_0x00b3:
            android.view.GestureDetector r11 = r10.mGestureDetector
            if (r11 == 0) goto L_0x00be
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00be
            r1 = r2
        L_0x00be:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.component.photoview.view.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAllowParentInterceptOnEdge(boolean z11) {
        this.mAllowParentInterceptOnEdge = z11;
    }

    public void setBaseRotation(float f11) {
        this.mBaseRotation = f11 % 360.0f;
        update();
        setRotationBy(this.mBaseRotation);
        checkAndDisplayMatrix();
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        } else if (this.mImageView.getDrawable() == null) {
            return false;
        } else {
            this.mSuppMatrix.set(matrix);
            checkAndDisplayMatrix();
            return true;
        }
    }

    public void setMaximumScale(float f11) {
        PhotoViewUtil.checkZoomLevels(this.mMinScale, this.mMidScale, f11);
        this.mMaxScale = f11;
    }

    public void setMediumScale(float f11) {
        PhotoViewUtil.checkZoomLevels(this.mMinScale, f11, this.mMaxScale);
        this.mMidScale = f11;
    }

    public void setMinimumScale(float f11) {
        PhotoViewUtil.checkZoomLevels(f11, this.mMidScale, this.mMaxScale);
        this.mMinScale = f11;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.mMatrixChangeListener = onMatrixChangedListener;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.mOutsidePhotoTapListener = onOutsidePhotoTapListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.mScaleChangeListener = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.mSingleFlingListener = onSingleFlingListener;
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.mOnViewDragListener = onViewDragListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    public void setRotationBy(float f11) {
        this.mSuppMatrix.postRotate(f11 % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setRotationTo(float f11) {
        this.mSuppMatrix.setRotate(f11 % 360.0f);
        checkAndDisplayMatrix();
    }

    public void setScale(float f11) {
        setScale(f11, false);
    }

    public void setScaleLevels(float f11, float f12, float f13) {
        PhotoViewUtil.checkZoomLevels(f11, f12, f13);
        this.mMinScale = f11;
        this.mMidScale = f12;
        this.mMaxScale = f13;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (PhotoViewUtil.isSupportedScaleType(scaleType) && scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            update();
        }
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setZoomTransitionDuration(int i11) {
        this.mZoomDuration = i11;
    }

    public void setZoomable(boolean z11) {
        this.mZoomEnabled = z11;
        update();
    }

    public void update() {
        if (this.mZoomEnabled) {
            updateBaseMatrix(this.mImageView.getDrawable());
        } else {
            resetMatrix();
        }
    }

    public void setScale(float f11, boolean z11) {
        setScale(f11, (float) (this.mImageView.getRight() / 2), (float) (this.mImageView.getBottom() / 2), z11);
    }

    private RectF getDisplayRect(Matrix matrix) {
        Drawable drawable = this.mImageView.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.mDisplayRect.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    public void setScale(float f11, float f12, float f13, boolean z11) {
        if (f11 < this.mMinScale || f11 > this.mMaxScale) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z11) {
            ThreadUtils.runOnUiThread(new AnimatedZoomRunnable(getScale(), f11, f12, f13));
        } else {
            this.mSuppMatrix.setScale(f11, f11, f12, f13);
            checkAndDisplayMatrix();
        }
    }
}
