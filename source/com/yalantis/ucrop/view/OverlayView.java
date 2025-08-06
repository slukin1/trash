package com.yalantis.ucrop.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.DensityUtil;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class OverlayView extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private static final long SMOOTH_CENTER_DURATION = 1000;
    private boolean isDragCenter;
    /* access modifiers changed from: private */
    public OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private Path mCircularPath;
    private Paint mCropFrameCornersPaint;
    private Paint mCropFramePaint;
    public float[] mCropGridCenter;
    private int mCropGridColumnCount;
    public float[] mCropGridCorners;
    private Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private int mCropRectMinSize;
    /* access modifiers changed from: private */
    public final RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint;
    private int mFreestyleCropMode;
    private float[] mGridPoints;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private float mTargetAspectRatio;
    private final RectF mTempRect;
    public int mThisHeight;
    public int mThisWidth;
    private int mTouchPointThreshold;
    private ValueAnimator smoothAnimator;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FreestyleMode {
    }

    public OverlayView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getCurrentTouchIndex(float f11, float f12) {
        double d11 = (double) this.mTouchPointThreshold;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12 += 2) {
            double sqrt = Math.sqrt(Math.pow((double) (f11 - this.mCropGridCorners[i12]), 2.0d) + Math.pow((double) (f12 - this.mCropGridCorners[i12 + 1]), 2.0d));
            if (sqrt < d11) {
                i11 = i12 / 2;
                d11 = sqrt;
            }
        }
        if (this.mFreestyleCropMode != 1 || i11 >= 0 || !this.mCropViewRect.contains(f11, f12)) {
            return i11;
        }
        return 4;
    }

    private void initCropFrameStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth((float) dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        this.mCropFramePaint.setStyle(Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth((float) (dimensionPixelSize * 3));
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
    }

    private void initCropGridStyle(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth((float) dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void smoothToCenter() {
        Point point = new Point((getRight() + getLeft()) / 2, (getTop() + getBottom()) / 2);
        final int centerY = (int) (((float) point.y) - this.mCropViewRect.centerY());
        final int centerX = (int) (((float) point.x) - this.mCropViewRect.centerX());
        final RectF rectF = new RectF(this.mCropViewRect);
        new RectF(this.mCropViewRect).offset((float) centerX, (float) centerY);
        ValueAnimator valueAnimator = this.smoothAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.smoothAnimator = ofFloat;
        ofFloat.setDuration(1000);
        this.smoothAnimator.setInterpolator(new OvershootInterpolator(1.0f));
        this.smoothAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (OverlayView.this.mCallback != null) {
                    OverlayView.this.mCallback.onCropRectUpdated(OverlayView.this.mCropViewRect);
                }
            }
        });
        this.smoothAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public float lastAnimationValue = 0.0f;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((float) centerX) * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float floatValue2 = ((float) centerY) * ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RectF access$100 = OverlayView.this.mCropViewRect;
                RectF rectF = rectF;
                access$100.set(new RectF(rectF.left + floatValue, rectF.top + floatValue2, rectF.right + floatValue, rectF.bottom + floatValue2));
                OverlayView.this.updateGridPoints();
                OverlayView.this.postInvalidate();
                if (OverlayView.this.mCallback != null) {
                    OverlayView.this.mCallback.postTranslate(((float) centerX) * (((Float) valueAnimator.getAnimatedValue()).floatValue() - this.lastAnimationValue), ((float) centerY) * (((Float) valueAnimator.getAnimatedValue()).floatValue() - this.lastAnimationValue));
                }
                this.lastAnimationValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.smoothAnimator.start();
    }

    private void updateCropViewRect(float f11, float f12) {
        this.mTempRect.set(this.mCropViewRect);
        int i11 = this.mCurrentTouchCornerIndex;
        boolean z11 = true;
        if (i11 == 0) {
            RectF rectF = this.mTempRect;
            RectF rectF2 = this.mCropViewRect;
            rectF.set(f11, f12, rectF2.right, rectF2.bottom);
        } else if (i11 == 1) {
            RectF rectF3 = this.mTempRect;
            RectF rectF4 = this.mCropViewRect;
            rectF3.set(rectF4.left, f12, f11, rectF4.bottom);
        } else if (i11 == 2) {
            RectF rectF5 = this.mTempRect;
            RectF rectF6 = this.mCropViewRect;
            rectF5.set(rectF6.left, rectF6.top, f11, f12);
        } else if (i11 == 3) {
            RectF rectF7 = this.mTempRect;
            RectF rectF8 = this.mCropViewRect;
            rectF7.set(f11, rectF8.top, rectF8.right, f12);
        } else if (i11 == 4) {
            this.mTempRect.offset(f11 - this.mPreviousTouchX, f12 - this.mPreviousTouchY);
            if (this.mTempRect.left > ((float) getLeft()) && this.mTempRect.top > ((float) getTop()) && this.mTempRect.right < ((float) getRight()) && this.mTempRect.bottom < ((float) getBottom())) {
                this.mCropViewRect.set(this.mTempRect);
                updateGridPoints();
                postInvalidate();
                return;
            }
            return;
        }
        boolean z12 = this.mTempRect.height() >= ((float) this.mCropRectMinSize);
        if (this.mTempRect.width() < ((float) this.mCropRectMinSize)) {
            z11 = false;
        }
        RectF rectF9 = this.mCropViewRect;
        rectF9.set(z11 ? this.mTempRect.left : rectF9.left, z12 ? this.mTempRect.top : rectF9.top, z11 ? this.mTempRect.right : rectF9.right, z12 ? this.mTempRect.bottom : rectF9.bottom);
        if (z12 || z11) {
            updateGridPoints();
            postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, Path.Direction.CW);
    }

    public void drawCropGrid(Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                this.mGridPoints = new float[((this.mCropGridRowCount * 4) + (this.mCropGridColumnCount * 4))];
                int i11 = 0;
                for (int i12 = 0; i12 < this.mCropGridRowCount; i12++) {
                    float[] fArr = this.mGridPoints;
                    int i13 = i11 + 1;
                    RectF rectF = this.mCropViewRect;
                    fArr[i11] = rectF.left;
                    int i14 = i13 + 1;
                    float f11 = ((float) i12) + 1.0f;
                    float height = rectF.height() * (f11 / ((float) (this.mCropGridRowCount + 1)));
                    RectF rectF2 = this.mCropViewRect;
                    fArr[i13] = height + rectF2.top;
                    float[] fArr2 = this.mGridPoints;
                    int i15 = i14 + 1;
                    fArr2[i14] = rectF2.right;
                    i11 = i15 + 1;
                    fArr2[i15] = (rectF2.height() * (f11 / ((float) (this.mCropGridRowCount + 1)))) + this.mCropViewRect.top;
                }
                for (int i16 = 0; i16 < this.mCropGridColumnCount; i16++) {
                    float[] fArr3 = this.mGridPoints;
                    int i17 = i11 + 1;
                    float f12 = ((float) i16) + 1.0f;
                    float width = this.mCropViewRect.width() * (f12 / ((float) (this.mCropGridColumnCount + 1)));
                    RectF rectF3 = this.mCropViewRect;
                    fArr3[i11] = width + rectF3.left;
                    float[] fArr4 = this.mGridPoints;
                    int i18 = i17 + 1;
                    fArr4[i17] = rectF3.top;
                    int i19 = i18 + 1;
                    float width2 = rectF3.width() * (f12 / ((float) (this.mCropGridColumnCount + 1)));
                    RectF rectF4 = this.mCropViewRect;
                    fArr4[i18] = width2 + rectF4.left;
                    i11 = i19 + 1;
                    this.mGridPoints[i19] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.mGridPoints;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode != 0) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF5 = this.mTempRect;
            int i21 = this.mCropRectCornerTouchAreaLineLength;
            rectF5.inset((float) i21, (float) (-i21));
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            RectF rectF6 = this.mTempRect;
            int i22 = this.mCropRectCornerTouchAreaLineLength;
            rectF6.inset((float) (-i22), (float) i22);
            canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    public void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    public void init() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, (Paint) null);
        }
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        return this.mFreestyleCropMode == 1;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (z11) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = (getHeight() - getPaddingBottom()) - paddingTop;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z11 = false;
        if (!this.mCropViewRect.isEmpty() && this.mFreestyleCropMode != 0) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                int currentTouchIndex = getCurrentTouchIndex(x11, y11);
                this.mCurrentTouchCornerIndex = currentTouchIndex;
                if (currentTouchIndex != -1) {
                    z11 = true;
                }
                if (!z11) {
                    this.mPreviousTouchX = -1.0f;
                    this.mPreviousTouchY = -1.0f;
                } else if (this.mPreviousTouchX < 0.0f) {
                    this.mPreviousTouchX = x11;
                    this.mPreviousTouchY = y11;
                }
                return z11;
            } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
                float min = Math.min(Math.max(x11, (float) getPaddingLeft()), (float) (getWidth() - getPaddingRight()));
                float min2 = Math.min(Math.max(y11, (float) getPaddingTop()), (float) (getHeight() - getPaddingBottom()));
                updateCropViewRect(min, min2);
                this.mPreviousTouchX = min;
                this.mPreviousTouchY = min2;
                return true;
            } else if ((motionEvent.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
                if (overlayViewChangeListener != null) {
                    overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
                }
                if (this.isDragCenter) {
                    smoothToCenter();
                }
            }
        }
        return false;
    }

    public void processStyledAttributes(TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedColor = color;
        this.mDimmedStrokePaint.setColor(color);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth((float) DensityUtil.dip2px(getContext(), 1.0f));
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void setCircleDimmedLayer(boolean z11) {
        this.mCircleDimmedLayer = z11;
    }

    public void setCircleStrokeColor(int i11) {
        this.mDimmedStrokePaint.setColor(i11);
    }

    public void setCropFrameColor(int i11) {
        this.mCropFramePaint.setColor(i11);
    }

    public void setCropFrameStrokeWidth(int i11) {
        this.mCropFramePaint.setStrokeWidth((float) i11);
    }

    public void setCropGridColor(int i11) {
        this.mCropGridPaint.setColor(i11);
    }

    public void setCropGridColumnCount(int i11) {
        this.mCropGridColumnCount = i11;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(int i11) {
        this.mCropGridRowCount = i11;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(int i11) {
        this.mCropGridPaint.setStrokeWidth((float) i11);
    }

    public void setDimmedColor(int i11) {
        this.mDimmedColor = i11;
    }

    public void setDimmedStrokeWidth(int i11) {
        this.mDimmedStrokePaint.setStrokeWidth((float) i11);
    }

    public void setDragSmoothToCenter(boolean z11) {
        this.isDragCenter = z11;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z11) {
        this.mFreestyleCropMode = z11 ? 1 : 0;
    }

    public void setFreestyleCropMode(int i11) {
        this.mFreestyleCropMode = i11;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z11) {
        this.mShowCropFrame = z11;
    }

    public void setShowCropGrid(boolean z11) {
        this.mShowCropGrid = z11;
    }

    public void setTargetAspectRatio(float f11) {
        this.mTargetAspectRatio = f11;
        if (this.mThisWidth > 0) {
            setupCropBounds();
            postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public void setupCropBounds() {
        int i11 = this.mThisWidth;
        float f11 = this.mTargetAspectRatio;
        int i12 = (int) (((float) i11) / f11);
        int i13 = this.mThisHeight;
        if (i12 > i13) {
            int i14 = (int) (((float) i13) * f11);
            int i15 = (i11 - i14) / 2;
            this.mCropViewRect.set((float) (getPaddingLeft() + i15), (float) getPaddingTop(), (float) (getPaddingLeft() + i14 + i15), (float) (getPaddingTop() + this.mThisHeight));
        } else {
            int i16 = (i13 - i12) / 2;
            this.mCropViewRect.set((float) getPaddingLeft(), (float) (getPaddingTop() + i16), (float) (getPaddingLeft() + this.mThisWidth), (float) (getPaddingTop() + i12 + i16));
        }
        OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mFreestyleCropMode = 0;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }
}
