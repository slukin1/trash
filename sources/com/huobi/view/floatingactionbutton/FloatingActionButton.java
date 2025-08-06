package com.huobi.view.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class FloatingActionButton extends ImageButton {
    private static final int BAR_MAX_LENGTH = 270;
    private static final double BAR_SPIN_CYCLE_TIME = 500.0d;
    private static final int DEF_FAB_COLOR_DIS_VALUE = -5592406;
    private static final int DEF_FAB_COLOR_PRESS_VALUE = -1617853;
    private static final int DEF_FAB_COLOR_RIPPLE_VALUE = -1711276033;
    private static final int DEF_FAB_NORMAL_COLOR_VALUE = -2473162;
    private static final int DEF_FAB_SHADOW_VALUE = 1711276032;
    private static final int DEF_FAV_PROGRESS_VALUE = -16738680;
    private static final long PAUSE_GROWING_TIME = 200;
    /* access modifiers changed from: private */
    public static final Xfermode PORTER_DUFF_CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private boolean mAnimateProgress;
    private Drawable mBackgroundDrawable;
    private Paint mBackgroundPaint;
    private float mBarExtraLength;
    private boolean mBarGrowingFromFront;
    private int mBarLength;
    private boolean mButtonPositionSaved;
    /* access modifiers changed from: private */
    public View.OnClickListener mClickListener;
    private int mColorDisabled;
    /* access modifiers changed from: private */
    public int mColorNormal;
    private int mColorPressed;
    private int mColorRipple;
    private float mCurrentProgress;
    public int mFabSize;
    public GestureDetector mGestureDetector;
    private Animation mHideAnimation;
    private Drawable mIcon;
    private int mIconSize;
    private String mLabelText;
    private long mLastTimeAnimated;
    private float mOriginalX;
    private float mOriginalY;
    private long mPausedTimeWithoutGrowing;
    private int mProgress;
    private int mProgressBackgroundColor;
    /* access modifiers changed from: private */
    public boolean mProgressBarEnabled;
    private RectF mProgressCircleBounds;
    private int mProgressColor;
    private boolean mProgressIndeterminate;
    private int mProgressMax;
    private Paint mProgressPaint;
    /* access modifiers changed from: private */
    public int mProgressWidth;
    public int mShadowColor;
    public int mShadowRadius;
    public int mShadowXOffset;
    public int mShadowYOffset;
    private boolean mShouldProgressIndeterminate;
    private boolean mShouldSetProgress;
    private boolean mShouldUpdateButtonPosition;
    private Animation mShowAnimation;
    /* access modifiers changed from: private */
    public boolean mShowProgressBackground;
    public boolean mShowShadow;
    private float mSpinSpeed;
    private float mTargetProgress;
    private double mTimeStartGrowing;
    private boolean mUsingElevation;
    private boolean mUsingElevationCompat;

    public class CircleDrawable extends ShapeDrawable {
        private int circleInsetHorizontal;
        private int circleInsetVertical;

        public void draw(Canvas canvas) {
            setBounds(this.circleInsetHorizontal, this.circleInsetVertical, FloatingActionButton.this.calculateMeasuredWidth() - this.circleInsetHorizontal, FloatingActionButton.this.calculateMeasuredHeight() - this.circleInsetVertical);
            super.draw(canvas);
        }

        private CircleDrawable() {
        }

        private CircleDrawable(Shape shape) {
            super(shape);
            int i11 = 10;
            this.circleInsetHorizontal = FloatingActionButton.this.hasShadow() ? FloatingActionButton.this.mShadowRadius + Math.abs(FloatingActionButton.this.mShadowXOffset) : 10;
            this.circleInsetVertical = FloatingActionButton.this.hasShadow() ? Math.abs(FloatingActionButton.this.mShadowYOffset) + FloatingActionButton.this.mShadowRadius : i11;
            if (FloatingActionButton.this.mProgressBarEnabled) {
                this.circleInsetHorizontal += FloatingActionButton.this.mProgressWidth;
                this.circleInsetVertical += FloatingActionButton.this.mProgressWidth;
            }
        }
    }

    public static class ProgressSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<ProgressSavedState> CREATOR = new Parcelable.Creator<ProgressSavedState>() {
            public ProgressSavedState createFromParcel(Parcel parcel) {
                return new ProgressSavedState(parcel);
            }

            public ProgressSavedState[] newArray(int i11) {
                return new ProgressSavedState[i11];
            }
        };
        public boolean mAnimateProgress;
        public float mCurrentProgress;
        public int mProgress;
        public int mProgressBackgroundColor;
        public boolean mProgressBarEnabled;
        public boolean mProgressBarVisibilityChanged;
        public int mProgressColor;
        public boolean mProgressIndeterminate;
        public int mProgressWidth;
        public boolean mShouldProgressIndeterminate;
        public boolean mShouldSetProgress;
        public boolean mShowProgressBackground;
        public float mSpinSpeed;
        public float mTargetProgress;

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeFloat(this.mCurrentProgress);
            parcel.writeFloat(this.mTargetProgress);
            parcel.writeInt(this.mProgressBarEnabled ? 1 : 0);
            parcel.writeFloat(this.mSpinSpeed);
            parcel.writeInt(this.mProgress);
            parcel.writeInt(this.mProgressWidth);
            parcel.writeInt(this.mProgressColor);
            parcel.writeInt(this.mProgressBackgroundColor);
            parcel.writeInt(this.mProgressBarVisibilityChanged ? 1 : 0);
            parcel.writeInt(this.mProgressIndeterminate ? 1 : 0);
            parcel.writeInt(this.mShouldProgressIndeterminate ? 1 : 0);
            parcel.writeInt(this.mShouldSetProgress ? 1 : 0);
            parcel.writeInt(this.mAnimateProgress ? 1 : 0);
            parcel.writeInt(this.mShowProgressBackground ? 1 : 0);
        }

        public ProgressSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private ProgressSavedState(Parcel parcel) {
            super(parcel);
            this.mCurrentProgress = parcel.readFloat();
            this.mTargetProgress = parcel.readFloat();
            boolean z11 = true;
            this.mProgressBarEnabled = parcel.readInt() != 0;
            this.mSpinSpeed = parcel.readFloat();
            this.mProgress = parcel.readInt();
            this.mProgressWidth = parcel.readInt();
            this.mProgressColor = parcel.readInt();
            this.mProgressBackgroundColor = parcel.readInt();
            this.mProgressBarVisibilityChanged = parcel.readInt() != 0;
            this.mProgressIndeterminate = parcel.readInt() != 0;
            this.mShouldProgressIndeterminate = parcel.readInt() != 0;
            this.mShouldSetProgress = parcel.readInt() != 0;
            this.mAnimateProgress = parcel.readInt() != 0;
            this.mShowProgressBackground = parcel.readInt() == 0 ? false : z11;
        }
    }

    public class Shadow extends Drawable {
        private Paint mErase;
        private Paint mPaint;
        private float mRadius;

        private void init() {
            FloatingActionButton.this.setLayerType(1, (Paint) null);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(FloatingActionButton.this.mColorNormal);
            this.mErase.setXfermode(FloatingActionButton.PORTER_DUFF_CLEAR);
            if (!FloatingActionButton.this.isInEditMode()) {
                Paint paint = this.mPaint;
                FloatingActionButton floatingActionButton = FloatingActionButton.this;
                paint.setShadowLayer((float) floatingActionButton.mShadowRadius, (float) floatingActionButton.mShadowXOffset, (float) floatingActionButton.mShadowYOffset, floatingActionButton.mShadowColor);
            }
            this.mRadius = (float) (FloatingActionButton.this.getCircleSize() / 2);
            if (FloatingActionButton.this.mProgressBarEnabled && FloatingActionButton.this.mShowProgressBackground) {
                this.mRadius += (float) FloatingActionButton.this.mProgressWidth;
            }
        }

        public void draw(Canvas canvas) {
            canvas.drawCircle(FloatingActionButton.this.calculateCenterX(), FloatingActionButton.this.calculateCenterY(), this.mRadius, this.mPaint);
            canvas.drawCircle(FloatingActionButton.this.calculateCenterX(), FloatingActionButton.this.calculateCenterY(), this.mRadius, this.mErase);
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i11) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        private Shadow() {
            this.mPaint = new Paint(1);
            this.mErase = new Paint(1);
            init();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public float calculateCenterX() {
        return (float) (getMeasuredWidth() / 2);
    }

    /* access modifiers changed from: private */
    public float calculateCenterY() {
        return (float) (getMeasuredHeight() / 2);
    }

    /* access modifiers changed from: private */
    public int calculateMeasuredHeight() {
        int circleSize = getCircleSize() + calculateShadowHeight();
        return this.mProgressBarEnabled ? circleSize + (this.mProgressWidth * 2) : circleSize;
    }

    /* access modifiers changed from: private */
    public int calculateMeasuredWidth() {
        int circleSize = getCircleSize() + calculateShadowWidth();
        return this.mProgressBarEnabled ? circleSize + (this.mProgressWidth * 2) : circleSize;
    }

    private Drawable createCircleDrawable(int i11) {
        CircleDrawable circleDrawable = new CircleDrawable(new OvalShape());
        circleDrawable.getPaint().setColor(i11);
        return circleDrawable;
    }

    @TargetApi(21)
    private Drawable createFillDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, createCircleDrawable(this.mColorDisabled));
        stateListDrawable.addState(new int[]{16842919}, createCircleDrawable(this.mColorPressed));
        stateListDrawable.addState(new int[0], createCircleDrawable(this.mColorNormal));
        if (Util.hasLollipop()) {
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.mColorRipple}), stateListDrawable, (Drawable) null);
            setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            setClipToOutline(true);
            this.mBackgroundDrawable = rippleDrawable;
            return rippleDrawable;
        }
        this.mBackgroundDrawable = stateListDrawable;
        return stateListDrawable;
    }

    /* access modifiers changed from: private */
    public int getCircleSize() {
        return getResources().getDimensionPixelSize(this.mFabSize == 0 ? R.dimen.dimen_50 : R.dimen.dimen_45);
    }

    private int getShadowX() {
        return this.mShadowRadius + Math.abs(this.mShadowXOffset);
    }

    private int getShadowY() {
        return this.mShadowRadius + Math.abs(this.mShadowYOffset);
    }

    private void init(Context context, AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton, i11, 0);
        this.mColorNormal = obtainStyledAttributes.getColor(9, DEF_FAB_NORMAL_COLOR_VALUE);
        this.mColorPressed = obtainStyledAttributes.getColor(10, DEF_FAB_COLOR_PRESS_VALUE);
        this.mColorDisabled = obtainStyledAttributes.getColor(8, DEF_FAB_COLOR_DIS_VALUE);
        this.mColorRipple = obtainStyledAttributes.getColor(11, DEF_FAB_COLOR_RIPPLE_VALUE);
        this.mShowShadow = obtainStyledAttributes.getBoolean(26, true);
        this.mShadowColor = obtainStyledAttributes.getColor(21, DEF_FAB_SHADOW_VALUE);
        this.mShadowRadius = obtainStyledAttributes.getDimensionPixelSize(22, this.mShadowRadius);
        this.mShadowXOffset = obtainStyledAttributes.getDimensionPixelSize(23, this.mShadowXOffset);
        this.mShadowYOffset = obtainStyledAttributes.getDimensionPixelSize(24, this.mShadowYOffset);
        this.mFabSize = obtainStyledAttributes.getInt(27, 0);
        this.mLabelText = obtainStyledAttributes.getString(14);
        this.mShouldProgressIndeterminate = obtainStyledAttributes.getBoolean(18, false);
        this.mProgressColor = obtainStyledAttributes.getColor(17, DEF_FAV_PROGRESS_VALUE);
        this.mProgressBackgroundColor = obtainStyledAttributes.getColor(16, 1291845632);
        this.mProgressMax = obtainStyledAttributes.getInt(19, this.mProgressMax);
        this.mShowProgressBackground = obtainStyledAttributes.getBoolean(20, true);
        if (obtainStyledAttributes.hasValue(15)) {
            this.mProgress = obtainStyledAttributes.getInt(15, 0);
            this.mShouldSetProgress = true;
        }
        if (obtainStyledAttributes.hasValue(12)) {
            float dimensionPixelOffset = (float) obtainStyledAttributes.getDimensionPixelOffset(12, 0);
            if (isInEditMode()) {
                setElevation(dimensionPixelOffset);
            } else {
                setElevationCompat(dimensionPixelOffset);
            }
        }
        initShowAnimation(obtainStyledAttributes);
        initHideAnimation(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (isInEditMode()) {
            if (this.mShouldProgressIndeterminate) {
                setIndeterminate(true);
            } else if (this.mShouldSetProgress) {
                saveButtonOriginalPosition();
                setProgress(this.mProgress, false);
            }
        }
        setClickable(true);
    }

    private void initHideAnimation(TypedArray typedArray) {
        this.mHideAnimation = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(13, R.anim.fab_scale_down));
    }

    private void initShowAnimation(TypedArray typedArray) {
        this.mShowAnimation = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(25, R.anim.fab_scale_up));
    }

    private void saveButtonOriginalPosition() {
        if (!this.mButtonPositionSaved) {
            if (this.mOriginalX == -1.0f) {
                this.mOriginalX = getX();
            }
            if (this.mOriginalY == -1.0f) {
                this.mOriginalY = getY();
            }
            this.mButtonPositionSaved = true;
        }
    }

    @TargetApi(16)
    private void setBackgroundCompat(Drawable drawable) {
        if (Util.hasJellyBean()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void setupProgressBarPaints() {
        this.mBackgroundPaint.setColor(this.mProgressBackgroundColor);
        this.mBackgroundPaint.setStyle(Paint.Style.STROKE);
        this.mBackgroundPaint.setStrokeWidth((float) this.mProgressWidth);
        this.mProgressPaint.setColor(this.mProgressColor);
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeWidth((float) this.mProgressWidth);
    }

    private void setupProgressBounds() {
        int i11 = 0;
        int shadowX = hasShadow() ? getShadowX() : 0;
        if (hasShadow()) {
            i11 = getShadowY();
        }
        int i12 = this.mProgressWidth;
        this.mProgressCircleBounds = new RectF((float) ((i12 / 2) + shadowX), (float) ((i12 / 2) + i11), (float) ((calculateMeasuredWidth() - shadowX) - (this.mProgressWidth / 2)), (float) ((calculateMeasuredHeight() - i11) - (this.mProgressWidth / 2)));
    }

    private void updateButtonPosition() {
        float f11;
        float f12;
        if (this.mProgressBarEnabled) {
            f12 = this.mOriginalX > getX() ? getX() + ((float) this.mProgressWidth) : getX() - ((float) this.mProgressWidth);
            f11 = this.mOriginalY > getY() ? getY() + ((float) this.mProgressWidth) : getY() - ((float) this.mProgressWidth);
        } else {
            f12 = this.mOriginalX;
            f11 = this.mOriginalY;
        }
        setX(f12);
        setY(f11);
    }

    private void updateProgressLength(long j11) {
        long j12 = this.mPausedTimeWithoutGrowing;
        if (j12 >= 200) {
            double d11 = this.mTimeStartGrowing + ((double) j11);
            this.mTimeStartGrowing = d11;
            if (d11 > BAR_SPIN_CYCLE_TIME) {
                this.mTimeStartGrowing = d11 - BAR_SPIN_CYCLE_TIME;
                this.mPausedTimeWithoutGrowing = 0;
                this.mBarGrowingFromFront = !this.mBarGrowingFromFront;
            }
            float cos = (((float) Math.cos(((this.mTimeStartGrowing / BAR_SPIN_CYCLE_TIME) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            float f11 = (float) (270 - this.mBarLength);
            if (this.mBarGrowingFromFront) {
                this.mBarExtraLength = cos * f11;
                return;
            }
            float f12 = f11 * (1.0f - cos);
            this.mCurrentProgress += this.mBarExtraLength - f12;
            this.mBarExtraLength = f12;
            return;
        }
        this.mPausedTimeWithoutGrowing = j12 + j11;
    }

    public int calculateShadowHeight() {
        if (hasShadow()) {
            return getShadowY() * 2;
        }
        return 0;
    }

    public int calculateShadowWidth() {
        if (hasShadow()) {
            return getShadowX() * 2;
        }
        return 0;
    }

    public int getButtonSize() {
        return this.mFabSize;
    }

    public int getColorDisabled() {
        return this.mColorDisabled;
    }

    public int getColorNormal() {
        return this.mColorNormal;
    }

    public int getColorPressed() {
        return this.mColorPressed;
    }

    public int getColorRipple() {
        return this.mColorRipple;
    }

    public Animation getHideAnimation() {
        return this.mHideAnimation;
    }

    public Drawable getIconDrawable() {
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            return drawable;
        }
        return new ColorDrawable(0);
    }

    public String getLabelText() {
        return this.mLabelText;
    }

    public Label getLabelView() {
        return (Label) getTag(R.id.fab_label);
    }

    public int getLabelVisibility() {
        Label labelView = getLabelView();
        if (labelView != null) {
            return labelView.getVisibility();
        }
        return -1;
    }

    public synchronized int getMax() {
        return this.mProgressMax;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mClickListener;
    }

    public synchronized int getProgress() {
        return this.mProgressIndeterminate ? 0 : this.mProgress;
    }

    public int getShadowColor() {
        return this.mShadowColor;
    }

    public int getShadowRadius() {
        return this.mShadowRadius;
    }

    public int getShadowXOffset() {
        return this.mShadowXOffset;
    }

    public int getShadowYOffset() {
        return this.mShadowYOffset;
    }

    public Animation getShowAnimation() {
        return this.mShowAnimation;
    }

    public boolean hasShadow() {
        return !this.mUsingElevation && this.mShowShadow;
    }

    public void hide(boolean z11) {
        if (!isHidden()) {
            if (z11) {
                playHideAnimation();
            }
            super.setVisibility(4);
        }
    }

    public void hideButtonInMenu(boolean z11) {
        if (!isHidden() && getVisibility() != 8) {
            hide(z11);
            Label labelView = getLabelView();
            if (labelView != null) {
                labelView.hide(z11);
            }
            getHideAnimation().setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    FloatingActionButton.this.setVisibility(8);
                    FloatingActionButton.this.getHideAnimation().setAnimationListener((Animation.AnimationListener) null);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
        }
    }

    public synchronized void hideProgress() {
        this.mProgressBarEnabled = false;
        this.mShouldUpdateButtonPosition = true;
        updateBackground();
    }

    public boolean isHidden() {
        return getVisibility() == 4;
    }

    public synchronized boolean isProgressBackgroundShown() {
        return this.mShowProgressBackground;
    }

    @TargetApi(21)
    public void onActionDown() {
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{16842910, 16842919});
        } else if (Util.hasLollipop()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.mBackgroundDrawable;
            rippleDrawable.setState(new int[]{16842910, 16842919});
            rippleDrawable.setHotspot(calculateCenterX(), calculateCenterY());
            rippleDrawable.setVisible(true, true);
        }
    }

    @TargetApi(21)
    public void onActionUp() {
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{16842910});
        } else if (Util.hasLollipop()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.mBackgroundDrawable;
            rippleDrawable.setState(new int[]{16842910});
            rippleDrawable.setHotspot(calculateCenterX(), calculateCenterY());
            rippleDrawable.setVisible(true, true);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mProgressBarEnabled) {
            if (this.mShowProgressBackground) {
                canvas.drawArc(this.mProgressCircleBounds, 360.0f, 360.0f, false, this.mBackgroundPaint);
            }
            boolean z11 = false;
            boolean z12 = true;
            if (this.mProgressIndeterminate) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.mLastTimeAnimated;
                updateProgressLength(uptimeMillis);
                float f11 = this.mCurrentProgress + ((((float) uptimeMillis) * this.mSpinSpeed) / 1000.0f);
                this.mCurrentProgress = f11;
                if (f11 > 360.0f) {
                    this.mCurrentProgress = f11 - 360.0f;
                }
                this.mLastTimeAnimated = SystemClock.uptimeMillis();
                float f12 = this.mCurrentProgress - 90.0f;
                float f13 = ((float) this.mBarLength) + this.mBarExtraLength;
                if (isInEditMode()) {
                    f12 = 0.0f;
                    f13 = 135.0f;
                }
                canvas.drawArc(this.mProgressCircleBounds, f12, f13, false, this.mProgressPaint);
            } else {
                if (this.mCurrentProgress != this.mTargetProgress) {
                    float uptimeMillis2 = (((float) (SystemClock.uptimeMillis() - this.mLastTimeAnimated)) / 1000.0f) * this.mSpinSpeed;
                    float f14 = this.mCurrentProgress;
                    float f15 = this.mTargetProgress;
                    if (f14 > f15) {
                        this.mCurrentProgress = Math.max(f14 - uptimeMillis2, f15);
                    } else {
                        this.mCurrentProgress = Math.min(f14 + uptimeMillis2, f15);
                    }
                    this.mLastTimeAnimated = SystemClock.uptimeMillis();
                    z11 = true;
                }
                canvas.drawArc(this.mProgressCircleBounds, -90.0f, this.mCurrentProgress, false, this.mProgressPaint);
                z12 = z11;
            }
            if (z12) {
                invalidate();
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(calculateMeasuredWidth(), calculateMeasuredHeight());
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ProgressSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ProgressSavedState progressSavedState = (ProgressSavedState) parcelable;
        super.onRestoreInstanceState(progressSavedState.getSuperState());
        this.mCurrentProgress = progressSavedState.mCurrentProgress;
        this.mTargetProgress = progressSavedState.mTargetProgress;
        this.mSpinSpeed = progressSavedState.mSpinSpeed;
        this.mProgressWidth = progressSavedState.mProgressWidth;
        this.mProgressColor = progressSavedState.mProgressColor;
        this.mProgressBackgroundColor = progressSavedState.mProgressBackgroundColor;
        this.mShouldProgressIndeterminate = progressSavedState.mShouldProgressIndeterminate;
        this.mShouldSetProgress = progressSavedState.mShouldSetProgress;
        this.mProgress = progressSavedState.mProgress;
        this.mAnimateProgress = progressSavedState.mAnimateProgress;
        this.mShowProgressBackground = progressSavedState.mShowProgressBackground;
        this.mLastTimeAnimated = SystemClock.uptimeMillis();
    }

    public Parcelable onSaveInstanceState() {
        ProgressSavedState progressSavedState = new ProgressSavedState(super.onSaveInstanceState());
        progressSavedState.mCurrentProgress = this.mCurrentProgress;
        progressSavedState.mTargetProgress = this.mTargetProgress;
        progressSavedState.mSpinSpeed = this.mSpinSpeed;
        progressSavedState.mProgressWidth = this.mProgressWidth;
        progressSavedState.mProgressColor = this.mProgressColor;
        progressSavedState.mProgressBackgroundColor = this.mProgressBackgroundColor;
        boolean z11 = this.mProgressIndeterminate;
        progressSavedState.mShouldProgressIndeterminate = z11;
        progressSavedState.mShouldSetProgress = this.mProgressBarEnabled && this.mProgress > 0 && !z11;
        progressSavedState.mProgress = this.mProgress;
        progressSavedState.mAnimateProgress = this.mAnimateProgress;
        progressSavedState.mShowProgressBackground = this.mShowProgressBackground;
        return progressSavedState;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        saveButtonOriginalPosition();
        if (this.mShouldProgressIndeterminate) {
            setIndeterminate(true);
            this.mShouldProgressIndeterminate = false;
        } else if (this.mShouldSetProgress) {
            setProgress(this.mProgress, this.mAnimateProgress);
            this.mShouldSetProgress = false;
        } else if (this.mShouldUpdateButtonPosition) {
            updateButtonPosition();
            this.mShouldUpdateButtonPosition = false;
        }
        super.onSizeChanged(i11, i12, i13, i14);
        setupProgressBounds();
        setupProgressBarPaints();
        updateBackground();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mClickListener != null && isEnabled()) {
            Label label = (Label) getTag(R.id.fab_label);
            if (label == null) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 1) {
                label.onActionUp();
                onActionUp();
            } else if (action == 3) {
                label.onActionUp();
                onActionUp();
            }
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void playHideAnimation() {
        this.mShowAnimation.cancel();
        startAnimation(this.mHideAnimation);
    }

    public void playShowAnimation() {
        this.mHideAnimation.cancel();
        startAnimation(this.mShowAnimation);
    }

    public void setButtonSize(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("Use @FabSize constants only!");
        } else if (this.mFabSize != i11) {
            this.mFabSize = i11;
            updateBackground();
        }
    }

    public void setColorDisabled(int i11) {
        if (i11 != this.mColorDisabled) {
            this.mColorDisabled = i11;
            updateBackground();
        }
    }

    public void setColorDisabledResId(int i11) {
        setColorDisabled(getResources().getColor(i11));
    }

    public void setColorNormal(int i11) {
        if (this.mColorNormal != i11) {
            this.mColorNormal = i11;
            updateBackground();
        }
    }

    public void setColorNormalResId(int i11) {
        setColorNormal(getResources().getColor(i11));
    }

    public void setColorPressed(int i11) {
        if (i11 != this.mColorPressed) {
            this.mColorPressed = i11;
            updateBackground();
        }
    }

    public void setColorPressedResId(int i11) {
        setColorPressed(getResources().getColor(i11));
    }

    public void setColorRipple(int i11) {
        if (i11 != this.mColorRipple) {
            this.mColorRipple = i11;
            updateBackground();
        }
    }

    public void setColorRippleResId(int i11) {
        setColorRipple(getResources().getColor(i11));
    }

    public void setColors(int i11, int i12, int i13) {
        this.mColorNormal = i11;
        this.mColorPressed = i12;
        this.mColorRipple = i13;
    }

    public void setElevation(float f11) {
        if (Util.hasLollipop() && f11 > 0.0f) {
            super.setElevation(f11);
            if (!isInEditMode()) {
                this.mUsingElevation = true;
                this.mShowShadow = false;
            }
            updateBackground();
        }
    }

    @TargetApi(21)
    public void setElevationCompat(float f11) {
        this.mShadowColor = 637534208;
        float f12 = f11 / 2.0f;
        this.mShadowRadius = Math.round(f12);
        this.mShadowXOffset = 0;
        if (this.mFabSize == 0) {
            f12 = f11;
        }
        this.mShadowYOffset = Math.round(f12);
        if (Util.hasLollipop()) {
            super.setElevation(f11);
            this.mUsingElevationCompat = true;
            this.mShowShadow = false;
            updateBackground();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.mShowShadow = true;
        updateBackground();
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        Label label = (Label) getTag(R.id.fab_label);
        if (label != null) {
            label.setEnabled(z11);
        }
    }

    public void setHideAnimation(Animation animation) {
        this.mHideAnimation = animation;
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mIcon != drawable) {
            this.mIcon = drawable;
            updateBackground();
        }
    }

    public void setImageResource(int i11) {
        Drawable drawable = getResources().getDrawable(i11);
        if (this.mIcon != drawable) {
            this.mIcon = drawable;
            updateBackground();
        }
    }

    public synchronized void setIndeterminate(boolean z11) {
        if (!z11) {
            this.mCurrentProgress = 0.0f;
        }
        this.mProgressBarEnabled = z11;
        this.mShouldUpdateButtonPosition = true;
        this.mProgressIndeterminate = z11;
        this.mLastTimeAnimated = SystemClock.uptimeMillis();
        setupProgressBounds();
        updateBackground();
    }

    public void setLabelColors(int i11, int i12, int i13) {
        Label labelView = getLabelView();
        int paddingLeft = labelView.getPaddingLeft();
        int paddingTop = labelView.getPaddingTop();
        int paddingRight = labelView.getPaddingRight();
        int paddingBottom = labelView.getPaddingBottom();
        labelView.setColors(i11, i12, i13);
        labelView.updateBackground();
        labelView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public void setLabelText(String str) {
        this.mLabelText = str;
        Label labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    public void setLabelTextColor(int i11) {
        getLabelView().setTextColor(i11);
    }

    public void setLabelVisibility(int i11) {
        Label labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i11);
            labelView.setHandleVisibilityChanges(i11 == 0);
        }
    }

    @TargetApi(21)
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.mUsingElevationCompat) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin += getShadowX();
            marginLayoutParams.topMargin += getShadowY();
            marginLayoutParams.rightMargin += getShadowX();
            marginLayoutParams.bottomMargin += getShadowY();
        }
        super.setLayoutParams(layoutParams);
    }

    public synchronized void setMax(int i11) {
        this.mProgressMax = i11;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mClickListener = onClickListener;
        View view = (View) getTag(R.id.fab_label);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (FloatingActionButton.this.mClickListener != null) {
                        FloatingActionButton.this.mClickListener.onClick(FloatingActionButton.this);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    public synchronized void setProgress(int i11, boolean z11) {
        if (!this.mProgressIndeterminate) {
            this.mProgress = i11;
            this.mAnimateProgress = z11;
            if (!this.mButtonPositionSaved) {
                this.mShouldSetProgress = true;
                return;
            }
            this.mProgressBarEnabled = true;
            this.mShouldUpdateButtonPosition = true;
            setupProgressBounds();
            saveButtonOriginalPosition();
            updateBackground();
            if (i11 < 0) {
                i11 = 0;
            } else {
                int i12 = this.mProgressMax;
                if (i11 > i12) {
                    i11 = i12;
                }
            }
            float f11 = (float) i11;
            if (f11 != this.mTargetProgress) {
                int i13 = this.mProgressMax;
                this.mTargetProgress = i13 > 0 ? (f11 / ((float) i13)) * 360.0f : 0.0f;
                this.mLastTimeAnimated = SystemClock.uptimeMillis();
                if (!z11) {
                    this.mCurrentProgress = this.mTargetProgress;
                }
                invalidate();
            }
        }
    }

    public void setShadowColor(int i11) {
        if (this.mShadowColor != i11) {
            this.mShadowColor = i11;
            updateBackground();
        }
    }

    public void setShadowColorResource(int i11) {
        int color = getResources().getColor(i11);
        if (this.mShadowColor != color) {
            this.mShadowColor = color;
            updateBackground();
        }
    }

    public void setShadowRadius(int i11) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i11);
        if (this.mShadowRadius != dimensionPixelSize) {
            this.mShadowRadius = dimensionPixelSize;
            requestLayout();
            updateBackground();
        }
    }

    public void setShadowXOffset(int i11) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i11);
        if (this.mShadowXOffset != dimensionPixelSize) {
            this.mShadowXOffset = dimensionPixelSize;
            requestLayout();
            updateBackground();
        }
    }

    public void setShadowYOffset(int i11) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i11);
        if (this.mShadowYOffset != dimensionPixelSize) {
            this.mShadowYOffset = dimensionPixelSize;
            requestLayout();
            updateBackground();
        }
    }

    public void setShowAnimation(Animation animation) {
        this.mShowAnimation = animation;
    }

    public synchronized void setShowProgressBackground(boolean z11) {
        this.mShowProgressBackground = z11;
    }

    public void setShowShadow(boolean z11) {
        if (this.mShowShadow != z11) {
            this.mShowShadow = z11;
            updateBackground();
        }
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        Label label = (Label) getTag(R.id.fab_label);
        if (label != null) {
            label.setVisibility(i11);
        }
    }

    public void show(boolean z11) {
        if (isHidden()) {
            if (z11) {
                playShowAnimation();
            }
            super.setVisibility(0);
        }
    }

    public void showButtonInMenu(boolean z11) {
        if (getVisibility() != 0) {
            setVisibility(4);
            show(z11);
            Label labelView = getLabelView();
            if (labelView != null) {
                labelView.show(z11);
            }
        }
    }

    public void toggle(boolean z11) {
        if (isHidden()) {
            show(z11);
        } else {
            hide(z11);
        }
    }

    public void updateBackground() {
        LayerDrawable layerDrawable;
        int i11 = 0;
        if (hasShadow()) {
            layerDrawable = new LayerDrawable(new Drawable[]{new Shadow(), createFillDrawable(), getIconDrawable()});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{createFillDrawable(), getIconDrawable()});
        }
        int i12 = -1;
        if (getIconDrawable() != null) {
            i12 = Math.max(getIconDrawable().getIntrinsicWidth(), getIconDrawable().getIntrinsicHeight());
        }
        int circleSize = getCircleSize();
        if (i12 <= 0) {
            i12 = this.mIconSize;
        }
        int i13 = (circleSize - i12) / 2;
        int abs = hasShadow() ? this.mShadowRadius + Math.abs(this.mShadowXOffset) : 0;
        if (hasShadow()) {
            i11 = this.mShadowRadius + Math.abs(this.mShadowYOffset);
        }
        if (this.mProgressBarEnabled) {
            int i14 = this.mProgressWidth;
            abs += i14;
            i11 += i14;
        }
        int i15 = abs + i13;
        int i16 = i11 + i13;
        layerDrawable.setLayerInset(hasShadow() ? 2 : 1, i15, i16, i15, i16);
        setBackgroundCompat(layerDrawable);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        getLabelView().setTextColor(colorStateList);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mShadowRadius = PixelUtils.a(4.0f);
        this.mShadowXOffset = PixelUtils.a(1.0f);
        this.mShadowYOffset = PixelUtils.a(3.0f);
        this.mIconSize = PixelUtils.a(24.0f);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                Label label = (Label) FloatingActionButton.this.getTag(R.id.fab_label);
                if (label != null) {
                    label.onActionDown();
                }
                FloatingActionButton.this.onActionDown();
                return super.onDown(motionEvent);
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                Label label = (Label) FloatingActionButton.this.getTag(R.id.fab_label);
                if (label != null) {
                    label.onActionUp();
                }
                FloatingActionButton.this.onActionUp();
                return super.onSingleTapUp(motionEvent);
            }
        });
        this.mProgressWidth = PixelUtils.a(6.0f);
        this.mOriginalX = -1.0f;
        this.mOriginalY = -1.0f;
        this.mProgressCircleBounds = new RectF();
        this.mBackgroundPaint = new Paint(1);
        this.mProgressPaint = new Paint(1);
        this.mSpinSpeed = 195.0f;
        this.mPausedTimeWithoutGrowing = 0;
        this.mBarGrowingFromFront = true;
        this.mBarLength = 16;
        this.mProgressMax = 100;
        init(context, attributeSet, i11);
    }

    public void setShadowRadius(float f11) {
        this.mShadowRadius = PixelUtils.a(f11);
        requestLayout();
        updateBackground();
    }

    public void setShadowXOffset(float f11) {
        this.mShadowXOffset = PixelUtils.a(f11);
        requestLayout();
        updateBackground();
    }

    public void setShadowYOffset(float f11) {
        this.mShadowYOffset = PixelUtils.a(f11);
        requestLayout();
        updateBackground();
    }

    @TargetApi(21)
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.mShadowRadius = PixelUtils.a(4.0f);
        this.mShadowXOffset = PixelUtils.a(1.0f);
        this.mShadowYOffset = PixelUtils.a(3.0f);
        this.mIconSize = PixelUtils.a(24.0f);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                Label label = (Label) FloatingActionButton.this.getTag(R.id.fab_label);
                if (label != null) {
                    label.onActionDown();
                }
                FloatingActionButton.this.onActionDown();
                return super.onDown(motionEvent);
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                Label label = (Label) FloatingActionButton.this.getTag(R.id.fab_label);
                if (label != null) {
                    label.onActionUp();
                }
                FloatingActionButton.this.onActionUp();
                return super.onSingleTapUp(motionEvent);
            }
        });
        this.mProgressWidth = PixelUtils.a(6.0f);
        this.mOriginalX = -1.0f;
        this.mOriginalY = -1.0f;
        this.mProgressCircleBounds = new RectF();
        this.mBackgroundPaint = new Paint(1);
        this.mProgressPaint = new Paint(1);
        this.mSpinSpeed = 195.0f;
        this.mPausedTimeWithoutGrowing = 0;
        this.mBarGrowingFromFront = true;
        this.mBarLength = 16;
        this.mProgressMax = 100;
        init(context, attributeSet, i11);
    }
}
