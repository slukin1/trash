package com.twitter.sdk.android.tweetui.internal;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;

public class MultiTouchImageView extends ImageView implements SwipeToDismissTouchListener.SwipeableViewProvider {
    private static final float DOUBLE_TAP_SCALE_FACTOR = 2.0f;
    private static final float MINIMUM_SCALE_FACTOR = 1.0f;
    private static final long SCALE_ANIMATION_DURATION = 300;
    public boolean allowIntercept;
    public final Matrix baseMatrix;
    public final Matrix drawMatrix;
    public final RectF drawRect;
    public final GestureDetector gestureDetector;
    public final float[] matrixValues;
    public final ScaleGestureDetector scaleGestureDetector;
    public final Matrix updateMatrix;
    public final RectF viewRect;

    public MultiTouchImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$animateScale$0(float f11, float f12, ValueAnimator valueAnimator) {
        setScale(((Float) valueAnimator.getAnimatedValue()).floatValue() / getScale(), f11, f12);
        setImageMatrix();
    }

    public void animateScale(float f11, float f12, float f13, float f14) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, f12});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new a(this, f13, f14));
        ofFloat.start();
    }

    public boolean canBeSwiped() {
        return getScale() == 1.0f;
    }

    public Matrix getDrawMatrix() {
        this.drawMatrix.set(this.baseMatrix);
        this.drawMatrix.postConcat(this.updateMatrix);
        return this.drawMatrix;
    }

    public RectF getDrawRect(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            this.drawRect.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            matrix.mapRect(this.drawRect);
        }
        return this.drawRect;
    }

    public float getScale() {
        this.updateMatrix.getValues(this.matrixValues);
        return this.matrixValues[0];
    }

    public void initializeBaseMatrix(Drawable drawable) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        this.baseMatrix.reset();
        this.baseMatrix.setRectToRect(rectF, this.viewRect, Matrix.ScaleToFit.CENTER);
    }

    public void initializeViewRect() {
        this.viewRect.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
    }

    public boolean isInitializationComplete() {
        Drawable drawable = getDrawable();
        return drawable != null && drawable.getIntrinsicWidth() > 0;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (isInitializationComplete()) {
            initializeViewRect();
            initializeBaseMatrix(getDrawable());
            setImageMatrix();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInitializationComplete()) {
            return false;
        }
        requestDisallowInterceptTouchEvent(true);
        if ((this.gestureDetector.onTouchEvent(motionEvent) || this.scaleGestureDetector.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    public void reset() {
        this.updateMatrix.reset();
    }

    public void setImageMatrix() {
        updateMatrixBounds();
        setScaleType(ImageView.ScaleType.MATRIX);
        setImageMatrix(getDrawMatrix());
    }

    public void setScale(float f11, float f12, float f13) {
        this.updateMatrix.postScale(f11, f11, f12, f13);
    }

    public void setTranslate(float f11, float f12) {
        this.updateMatrix.postTranslate(f11, f12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateMatrixBounds() {
        /*
            r6 = this;
            android.graphics.Matrix r0 = r6.getDrawMatrix()
            android.graphics.RectF r0 = r6.getDrawRect(r0)
            float r1 = r0.height()
            android.graphics.RectF r2 = r6.viewRect
            float r2 = r2.height()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 0
            if (r1 > 0) goto L_0x0029
            android.graphics.RectF r1 = r6.viewRect
            float r1 = r1.height()
            float r4 = r0.height()
            float r1 = r1 - r4
            float r1 = r1 / r2
            float r4 = r0.top
        L_0x0027:
            float r1 = r1 - r4
            goto L_0x0047
        L_0x0029:
            float r1 = r0.top
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0031
            float r1 = -r1
            goto L_0x0047
        L_0x0031:
            float r1 = r0.bottom
            android.graphics.RectF r4 = r6.viewRect
            float r4 = r4.height()
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0046
            android.graphics.RectF r1 = r6.viewRect
            float r1 = r1.height()
            float r4 = r0.bottom
            goto L_0x0027
        L_0x0046:
            r1 = r3
        L_0x0047:
            float r4 = r0.width()
            android.graphics.RectF r5 = r6.viewRect
            float r5 = r5.width()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r5 = 1
            if (r4 > 0) goto L_0x0068
            r6.allowIntercept = r5
            android.graphics.RectF r3 = r6.viewRect
            float r3 = r3.width()
            float r4 = r0.width()
            float r3 = r3 - r4
            float r3 = r3 / r2
            float r0 = r0.left
            float r3 = r3 - r0
            goto L_0x008e
        L_0x0068:
            float r2 = r0.left
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0072
            r6.allowIntercept = r5
            float r3 = -r2
            goto L_0x008e
        L_0x0072:
            float r2 = r0.right
            android.graphics.RectF r4 = r6.viewRect
            float r4 = r4.width()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x008b
            r6.allowIntercept = r5
            android.graphics.RectF r2 = r6.viewRect
            float r2 = r2.width()
            float r0 = r0.right
            float r3 = r2 - r0
            goto L_0x008e
        L_0x008b:
            r0 = 0
            r6.allowIntercept = r0
        L_0x008e:
            r6.setTranslate(r3, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.updateMatrixBounds():void");
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.drawMatrix = new Matrix();
        this.baseMatrix = new Matrix();
        this.updateMatrix = new Matrix();
        this.viewRect = new RectF();
        this.drawRect = new RectF();
        this.matrixValues = new float[9];
        this.scaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                MultiTouchImageView.this.setScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                MultiTouchImageView.this.setImageMatrix();
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                if (MultiTouchImageView.this.getScale() < 1.0f) {
                    MultiTouchImageView.this.reset();
                    MultiTouchImageView.this.setImageMatrix();
                }
            }
        });
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (MultiTouchImageView.this.getScale() > 1.0f) {
                    MultiTouchImageView multiTouchImageView = MultiTouchImageView.this;
                    multiTouchImageView.animateScale(multiTouchImageView.getScale(), 1.0f, motionEvent.getX(), motionEvent.getY());
                    return true;
                }
                MultiTouchImageView multiTouchImageView2 = MultiTouchImageView.this;
                multiTouchImageView2.animateScale(multiTouchImageView2.getScale(), MultiTouchImageView.DOUBLE_TAP_SCALE_FACTOR, motionEvent.getX(), motionEvent.getY());
                return true;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
                MultiTouchImageView.this.setTranslate(-f11, -f12);
                MultiTouchImageView.this.setImageMatrix();
                MultiTouchImageView multiTouchImageView = MultiTouchImageView.this;
                if (!multiTouchImageView.allowIntercept || multiTouchImageView.scaleGestureDetector.isInProgress()) {
                    return true;
                }
                MultiTouchImageView.this.requestDisallowInterceptTouchEvent(false);
                return true;
            }
        });
    }
}
