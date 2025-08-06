package com.huobi.view.floatingactionbutton;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import pro.huobi.R;

public class FloatingActionMenu extends ViewGroup {
    private static final int ANIMATION_DURATION = 300;
    private static final float CLOSED_PLUS_ROTATION = 0.0f;
    private static final int DEF_COLOR_NORMAL_VALUE = -13421773;
    private static final int DEF_COLOR_PRESS_VALUE = -12303292;
    private static final int DEF_ELLIPSIZE_VALUE = 0;
    private static final int DEF_MAXLINES_VALUE = -1;
    private static final int DEF_MENU_COLOR_NORMAL_VALUE = -2473162;
    private static final int DEF_MENU_COLOR_PRESS_VALUE = -1617853;
    private static final int DEF_MENU_COLOR_RIPPLE_VALUE = -1711276033;
    private static final int DEF_PER_ITEM_VALUE = 33;
    private static final int DEF_RIPPLE_VALUE = 1728053247;
    private static final int DEF_SHADOW_COLOR_VALUE = 1711276032;
    private static final float DIMENSION_FACTOR = 0.03f;
    private static final int ELLIPSIZE_END = 3;
    private static final int ELLIPSIZE_MARQUEE = 4;
    private static final int ELLIPSIZE_MIDDLE = 2;
    private static final int ELLIPSIZE_START = 1;
    private static final int LABELS_POSITION_LEFT = 0;
    private static final float OPENED_PLUS_ROTATION_LEFT = -135.0f;
    private static final float OPENED_PLUS_ROTATION_RIGHT = 135.0f;
    private static final int OPEN_DOWN = 1;
    private static final int OPEN_UP = 0;
    private static final int TWO = 2;
    private int mAnimationDelayPerItem;
    private int mBackgroundColor;
    private int mButtonSpacing;
    private int mButtonsCount;
    private AnimatorSet mCloseAnimatorSet;
    private Interpolator mCloseInterpolator;
    private Typeface mCustomTypefaceFromFont;
    private ValueAnimator mHideBackgroundAnimator;
    private Drawable mIcon;
    private boolean mIconAnimated;
    private AnimatorSet mIconToggleSet;
    private ImageView mImageToggle;
    private Animation mImageToggleHideAnimation;
    private Animation mImageToggleShowAnimation;
    /* access modifiers changed from: private */
    public boolean mIsAnimated;
    /* access modifiers changed from: private */
    public boolean mIsMenuButtonAnimationRunning;
    private boolean mIsMenuOpening;
    private boolean mIsSetClosedOnTouchOutside;
    private int mLabelsColorNormal;
    private int mLabelsColorPressed;
    private int mLabelsColorRipple;
    private Context mLabelsContext;
    private int mLabelsCornerRadius;
    private int mLabelsEllipsize;
    private int mLabelsHideAnimation;
    private int mLabelsMargin;
    private int mLabelsMaxLines;
    private int mLabelsPaddingBottom;
    private int mLabelsPaddingLeft;
    private int mLabelsPaddingRight;
    private int mLabelsPaddingTop;
    private int mLabelsPosition;
    private int mLabelsShowAnimation;
    private boolean mLabelsShowShadow;
    private boolean mLabelsSingleLine;
    private int mLabelsStyle;
    private ColorStateList mLabelsTextColor;
    private float mLabelsTextSize;
    private int mLabelsVerticalOffset;
    private int mMaxButtonWidth;
    /* access modifiers changed from: private */
    public FloatingActionButton mMenuButton;
    /* access modifiers changed from: private */
    public Animation mMenuButtonHideAnimation;
    private Animation mMenuButtonShowAnimation;
    private int mMenuColorNormal;
    private int mMenuColorPressed;
    private int mMenuColorRipple;
    private int mMenuFabSize;
    private String mMenuLabelText;
    /* access modifiers changed from: private */
    public boolean mMenuOpened;
    private int mMenuShadowColor;
    private float mMenuShadowRadius;
    private float mMenuShadowXOffset;
    private float mMenuShadowYOffset;
    private boolean mMenuShowShadow;
    private AnimatorSet mOpenAnimatorSet;
    private int mOpenDirection;
    private Interpolator mOpenInterpolator;
    private ValueAnimator mShowBackgroundAnimator;
    /* access modifiers changed from: private */
    public OnMenuToggleListener mToggleListener;
    private Handler mUiHandler;
    private boolean mUsingMenuLabel;

    public interface OnMenuToggleListener {
        void onActionBeforeToggle(boolean z11);

        void onMenuToggle(boolean z11);
    }

    public FloatingActionMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addLabel(FloatingActionButton floatingActionButton) {
        String labelText = floatingActionButton.getLabelText();
        if (!TextUtils.isEmpty(labelText)) {
            Label label = new Label(this.mLabelsContext);
            label.setClickable(true);
            label.setFab(floatingActionButton);
            label.setShowAnimation(AnimationUtils.loadAnimation(getContext(), this.mLabelsShowAnimation));
            label.setHideAnimation(AnimationUtils.loadAnimation(getContext(), this.mLabelsHideAnimation));
            if (this.mLabelsStyle > 0) {
                label.setTextAppearance(getContext(), this.mLabelsStyle);
                label.setShowShadow(false);
                label.setUsingStyle(true);
            } else {
                label.setColors(this.mLabelsColorNormal, this.mLabelsColorPressed, this.mLabelsColorRipple);
                label.setShowShadow(this.mLabelsShowShadow);
                label.setCornerRadius(this.mLabelsCornerRadius);
                if (this.mLabelsEllipsize > 0) {
                    setLabelEllipsize(label);
                }
                label.setMaxLines(this.mLabelsMaxLines);
                label.updateBackground();
                label.setTextSize(0, this.mLabelsTextSize);
                label.setTextColor(this.mLabelsTextColor);
                int i11 = this.mLabelsPaddingLeft;
                int i12 = this.mLabelsPaddingTop;
                if (this.mLabelsShowShadow) {
                    i11 += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowXOffset());
                    i12 += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowYOffset());
                }
                label.setPadding(i11, i12, this.mLabelsPaddingLeft, this.mLabelsPaddingTop);
                if (this.mLabelsMaxLines < 0 || this.mLabelsSingleLine) {
                    label.setSingleLine(this.mLabelsSingleLine);
                }
            }
            Typeface typeface = this.mCustomTypefaceFromFont;
            if (typeface != null) {
                label.setTypeface(typeface);
            }
            label.setText(labelText);
            label.setOnClickListener(floatingActionButton.getOnClickListener());
            addView(label);
            floatingActionButton.setTag(R.id.fab_label, label);
        }
    }

    private int adjustForOvershoot(int i11) {
        float f11 = (float) i11;
        return (int) ((DIMENSION_FACTOR * f11) + f11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r0 == 0) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r0 == 0) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createDefaultIconAnimation() {
        /*
            r8 = this;
            int r0 = r8.mOpenDirection
            r1 = -1022951424(0xffffffffc3070000, float:-135.0)
            r2 = 1124532224(0x43070000, float:135.0)
            if (r0 != 0) goto L_0x0013
            int r0 = r8.mLabelsPosition
            if (r0 != 0) goto L_0x000e
            r3 = r2
            goto L_0x000f
        L_0x000e:
            r3 = r1
        L_0x000f:
            if (r0 != 0) goto L_0x001c
        L_0x0011:
            r1 = r2
            goto L_0x001c
        L_0x0013:
            int r0 = r8.mLabelsPosition
            if (r0 != 0) goto L_0x0019
            r3 = r1
            goto L_0x001a
        L_0x0019:
            r3 = r2
        L_0x001a:
            if (r0 != 0) goto L_0x0011
        L_0x001c:
            android.widget.ImageView r0 = r8.mImageToggle
            r2 = 2
            float[] r4 = new float[r2]
            r5 = 0
            r4[r5] = r3
            r3 = 1
            r6 = 0
            r4[r3] = r6
            java.lang.String r7 = "rotation"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r7, r4)
            android.widget.ImageView r4 = r8.mImageToggle
            float[] r2 = new float[r2]
            r2[r5] = r6
            r2[r3] = r1
            android.animation.ObjectAnimator r1 = android.animation.ObjectAnimator.ofFloat(r4, r7, r2)
            android.animation.AnimatorSet r2 = r8.mOpenAnimatorSet
            r2.play(r1)
            android.animation.AnimatorSet r1 = r8.mCloseAnimatorSet
            r1.play(r0)
            android.animation.AnimatorSet r0 = r8.mOpenAnimatorSet
            android.view.animation.Interpolator r1 = r8.mOpenInterpolator
            r0.setInterpolator(r1)
            android.animation.AnimatorSet r0 = r8.mCloseAnimatorSet
            android.view.animation.Interpolator r1 = r8.mCloseInterpolator
            r0.setInterpolator(r1)
            android.animation.AnimatorSet r0 = r8.mOpenAnimatorSet
            r1 = 300(0x12c, double:1.48E-321)
            r0.setDuration(r1)
            android.animation.AnimatorSet r0 = r8.mCloseAnimatorSet
            r0.setDuration(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.floatingactionbutton.FloatingActionMenu.createDefaultIconAnimation():void");
    }

    private void createLabels() {
        for (int i11 = 0; i11 < this.mButtonsCount; i11++) {
            if (getChildAt(i11) != this.mImageToggle) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i11);
                if (floatingActionButton.getTag(R.id.fab_label) == null) {
                    addLabel(floatingActionButton);
                    FloatingActionButton floatingActionButton2 = this.mMenuButton;
                    if (floatingActionButton == floatingActionButton2) {
                        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
                            @SensorsDataInstrumented
                            public void onClick(View view) {
                                FloatingActionMenu floatingActionMenu = FloatingActionMenu.this;
                                floatingActionMenu.toggle(floatingActionMenu.mIsAnimated);
                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            }
                        });
                    }
                }
            }
        }
    }

    private void createMenuButton() {
        FloatingActionButton floatingActionButton = new FloatingActionButton(getContext());
        this.mMenuButton = floatingActionButton;
        boolean z11 = this.mMenuShowShadow;
        floatingActionButton.mShowShadow = z11;
        if (z11) {
            floatingActionButton.mShadowRadius = PixelUtils.a(this.mMenuShadowRadius);
            this.mMenuButton.mShadowXOffset = PixelUtils.a(this.mMenuShadowXOffset);
            this.mMenuButton.mShadowYOffset = PixelUtils.a(this.mMenuShadowYOffset);
        }
        this.mMenuButton.setColors(this.mMenuColorNormal, this.mMenuColorPressed, this.mMenuColorRipple);
        FloatingActionButton floatingActionButton2 = this.mMenuButton;
        floatingActionButton2.mShadowColor = this.mMenuShadowColor;
        floatingActionButton2.mFabSize = this.mMenuFabSize;
        floatingActionButton2.updateBackground();
        this.mMenuButton.setLabelText(this.mMenuLabelText);
        ImageView imageView = new ImageView(getContext());
        this.mImageToggle = imageView;
        imageView.setImageDrawable(this.mIcon);
        addView(this.mMenuButton, super.generateDefaultLayoutParams());
        addView(this.mImageToggle);
        createDefaultIconAnimation();
    }

    /* access modifiers changed from: private */
    public void hideMenuButtonWithImage(boolean z11) {
        if (!isMenuButtonHidden()) {
            this.mMenuButton.hide(z11);
            if (z11) {
                this.mImageToggle.startAnimation(this.mImageToggleHideAnimation);
            }
            this.mImageToggle.setVisibility(4);
            this.mIsMenuButtonAnimationRunning = false;
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionMenu, 0, 0);
        this.mButtonSpacing = obtainStyledAttributes.getDimensionPixelSize(2, this.mButtonSpacing);
        this.mLabelsMargin = obtainStyledAttributes.getDimensionPixelSize(19, this.mLabelsMargin);
        int i11 = obtainStyledAttributes.getInt(26, 0);
        this.mLabelsPosition = i11;
        this.mLabelsShowAnimation = obtainStyledAttributes.getResourceId(27, i11 == 0 ? R.anim.fab_slide_in_from_right : R.anim.fab_slide_in_from_left);
        this.mLabelsHideAnimation = obtainStyledAttributes.getResourceId(18, this.mLabelsPosition == 0 ? R.anim.fab_slide_out_to_right : R.anim.fab_slide_out_to_left);
        this.mLabelsPaddingTop = obtainStyledAttributes.getDimensionPixelSize(25, this.mLabelsPaddingTop);
        this.mLabelsPaddingRight = obtainStyledAttributes.getDimensionPixelSize(24, this.mLabelsPaddingRight);
        this.mLabelsPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(22, this.mLabelsPaddingBottom);
        this.mLabelsPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(23, this.mLabelsPaddingLeft);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(31);
        this.mLabelsTextColor = colorStateList;
        if (colorStateList == null) {
            this.mLabelsTextColor = ColorStateList.valueOf(-1);
        }
        this.mLabelsTextSize = obtainStyledAttributes.getDimension(32, getResources().getDimension(R.dimen.labels_text_size));
        this.mLabelsCornerRadius = obtainStyledAttributes.getDimensionPixelSize(15, this.mLabelsCornerRadius);
        this.mLabelsShowShadow = obtainStyledAttributes.getBoolean(28, true);
        this.mLabelsColorNormal = obtainStyledAttributes.getColor(12, DEF_COLOR_NORMAL_VALUE);
        this.mLabelsColorPressed = obtainStyledAttributes.getColor(13, DEF_COLOR_PRESS_VALUE);
        this.mLabelsColorRipple = obtainStyledAttributes.getColor(14, DEF_RIPPLE_VALUE);
        this.mMenuShowShadow = obtainStyledAttributes.getBoolean(38, true);
        this.mMenuShadowColor = obtainStyledAttributes.getColor(34, DEF_SHADOW_COLOR_VALUE);
        this.mMenuShadowRadius = obtainStyledAttributes.getDimension(35, this.mMenuShadowRadius);
        this.mMenuShadowXOffset = obtainStyledAttributes.getDimension(36, this.mMenuShadowXOffset);
        this.mMenuShadowYOffset = obtainStyledAttributes.getDimension(37, this.mMenuShadowYOffset);
        this.mMenuColorNormal = obtainStyledAttributes.getColor(4, DEF_MENU_COLOR_NORMAL_VALUE);
        this.mMenuColorPressed = obtainStyledAttributes.getColor(5, DEF_MENU_COLOR_PRESS_VALUE);
        this.mMenuColorRipple = obtainStyledAttributes.getColor(6, DEF_MENU_COLOR_RIPPLE_VALUE);
        this.mAnimationDelayPerItem = obtainStyledAttributes.getInt(0, 33);
        Drawable drawable = obtainStyledAttributes.getDrawable(11);
        this.mIcon = drawable;
        if (drawable == null) {
            this.mIcon = getResources().getDrawable(R.drawable.account_more);
        }
        this.mLabelsSingleLine = obtainStyledAttributes.getBoolean(29, false);
        this.mLabelsEllipsize = obtainStyledAttributes.getInt(17, 0);
        this.mLabelsMaxLines = obtainStyledAttributes.getInt(20, -1);
        this.mMenuFabSize = obtainStyledAttributes.getInt(10, 0);
        this.mLabelsStyle = obtainStyledAttributes.getResourceId(30, 0);
        String string = obtainStyledAttributes.getString(16);
        try {
            if (!TextUtils.isEmpty(string)) {
                this.mCustomTypefaceFromFont = Typeface.createFromAsset(getContext().getAssets(), string);
            }
            this.mOpenDirection = obtainStyledAttributes.getInt(33, 0);
            this.mBackgroundColor = obtainStyledAttributes.getColor(1, 0);
            if (obtainStyledAttributes.hasValue(8)) {
                this.mUsingMenuLabel = true;
                this.mMenuLabelText = obtainStyledAttributes.getString(8);
            }
            if (obtainStyledAttributes.hasValue(21)) {
                initPadding(obtainStyledAttributes.getDimensionPixelSize(21, 0));
            }
            this.mOpenInterpolator = new AccelerateDecelerateInterpolator();
            this.mCloseInterpolator = new AccelerateDecelerateInterpolator();
            this.mLabelsContext = new ContextThemeWrapper(getContext(), this.mLabelsStyle);
            initBackgroundDimAnimation();
            createMenuButton();
            initMenuButtonAnimations(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        } catch (RuntimeException e11) {
            throw new IllegalArgumentException("Unable to load specified custom font: " + string, e11);
        }
    }

    private void initBackgroundDimAnimation() {
        int alpha = Color.alpha(this.mBackgroundColor);
        final int red = Color.red(this.mBackgroundColor);
        final int green = Color.green(this.mBackgroundColor);
        final int blue = Color.blue(this.mBackgroundColor);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, alpha});
        this.mShowBackgroundAnimator = ofInt;
        ofInt.setDuration(300);
        this.mShowBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), red, green, blue));
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{alpha, 0});
        this.mHideBackgroundAnimator = ofInt2;
        ofInt2.setDuration(300);
        this.mHideBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), red, green, blue));
            }
        });
    }

    private void initMenuButtonAnimations(TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(9, R.anim.fab_scale_up);
        setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getContext(), resourceId));
        this.mImageToggleShowAnimation = AnimationUtils.loadAnimation(getContext(), resourceId);
        int resourceId2 = typedArray.getResourceId(7, R.anim.fab_scale_down);
        setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getContext(), resourceId2));
        this.mImageToggleHideAnimation = AnimationUtils.loadAnimation(getContext(), resourceId2);
    }

    private void initPadding(int i11) {
        this.mLabelsPaddingTop = i11;
        this.mLabelsPaddingRight = i11;
        this.mLabelsPaddingBottom = i11;
        this.mLabelsPaddingLeft = i11;
    }

    private boolean isBackgroundEnabled() {
        return this.mBackgroundColor != 0;
    }

    private void setLabelEllipsize(Label label) {
        int i11 = this.mLabelsEllipsize;
        if (i11 == 1) {
            label.setEllipsize(TextUtils.TruncateAt.START);
        } else if (i11 == 2) {
            label.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i11 == 3) {
            label.setEllipsize(TextUtils.TruncateAt.END);
        } else if (i11 == 4) {
            label.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        }
    }

    private void showMenuButtonWithImage(boolean z11) {
        if (isMenuButtonHidden()) {
            this.mMenuButton.show(z11);
            if (z11) {
                this.mImageToggle.startAnimation(this.mImageToggleShowAnimation);
            }
            this.mImageToggle.setVisibility(0);
        }
    }

    public void addMenuButton(FloatingActionButton floatingActionButton) {
        addView(floatingActionButton, this.mButtonsCount - 2);
        this.mButtonsCount++;
        addLabel(floatingActionButton);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    public void close(final boolean z11) {
        if (isOpened()) {
            OnMenuToggleListener onMenuToggleListener = this.mToggleListener;
            if (onMenuToggleListener != null) {
                onMenuToggleListener.onActionBeforeToggle(false);
            }
            if (isBackgroundEnabled()) {
                this.mHideBackgroundAnimator.start();
            }
            if (this.mIconAnimated) {
                AnimatorSet animatorSet = this.mIconToggleSet;
                if (animatorSet != null) {
                    animatorSet.start();
                } else {
                    this.mCloseAnimatorSet.start();
                    this.mOpenAnimatorSet.cancel();
                }
            }
            this.mIsMenuOpening = false;
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                View childAt = getChildAt(i13);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i11++;
                    final FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                    this.mUiHandler.postDelayed(new Runnable() {
                        public void run() {
                            if (FloatingActionMenu.this.isOpened()) {
                                if (floatingActionButton != FloatingActionMenu.this.mMenuButton) {
                                    floatingActionButton.hide(z11);
                                }
                                Label label = (Label) floatingActionButton.getTag(R.id.fab_label);
                                if (label != null && label.isHandleVisibilityChanges()) {
                                    label.hide(z11);
                                }
                            }
                        }
                    }, (long) i12);
                    i12 += this.mAnimationDelayPerItem;
                }
            }
            this.mUiHandler.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = FloatingActionMenu.this.mMenuOpened = false;
                    if (FloatingActionMenu.this.mToggleListener != null) {
                        FloatingActionMenu.this.mToggleListener.onMenuToggle(false);
                    }
                }
            }, (long) ((i11 + 1) * this.mAnimationDelayPerItem));
        }
    }

    public int getAnimationDelayPerItem() {
        return this.mAnimationDelayPerItem;
    }

    public AnimatorSet getIconToggleAnimatorSet() {
        return this.mIconToggleSet;
    }

    public int getMenuButtonColorNormal() {
        return this.mMenuColorNormal;
    }

    public int getMenuButtonColorPressed() {
        return this.mMenuColorPressed;
    }

    public int getMenuButtonColorRipple() {
        return this.mMenuColorRipple;
    }

    public String getMenuButtonLabelText() {
        return this.mMenuLabelText;
    }

    public ImageView getMenuIconView() {
        return this.mImageToggle;
    }

    public void hideMenu(final boolean z11) {
        if (!isMenuHidden() && !this.mIsMenuButtonAnimationRunning) {
            this.mIsMenuButtonAnimationRunning = true;
            if (isOpened()) {
                close(z11);
                this.mUiHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (z11) {
                            FloatingActionMenu floatingActionMenu = FloatingActionMenu.this;
                            floatingActionMenu.startAnimation(floatingActionMenu.mMenuButtonHideAnimation);
                        }
                        FloatingActionMenu.this.setVisibility(4);
                        boolean unused = FloatingActionMenu.this.mIsMenuButtonAnimationRunning = false;
                    }
                }, (long) (this.mAnimationDelayPerItem * this.mButtonsCount));
                return;
            }
            if (z11) {
                startAnimation(this.mMenuButtonHideAnimation);
            }
            setVisibility(4);
            this.mIsMenuButtonAnimationRunning = false;
        }
    }

    public void hideMenuButton(final boolean z11) {
        if (!isMenuButtonHidden() && !this.mIsMenuButtonAnimationRunning) {
            this.mIsMenuButtonAnimationRunning = true;
            if (isOpened()) {
                close(z11);
                this.mUiHandler.postDelayed(new Runnable() {
                    public void run() {
                        FloatingActionMenu.this.hideMenuButtonWithImage(z11);
                    }
                }, (long) (this.mAnimationDelayPerItem * this.mButtonsCount));
                return;
            }
            hideMenuButtonWithImage(z11);
        }
    }

    public boolean isAnimated() {
        return this.mIsAnimated;
    }

    public boolean isIconAnimated() {
        return this.mIconAnimated;
    }

    public boolean isMenuButtonHidden() {
        return this.mMenuButton.isHidden();
    }

    public boolean isMenuHidden() {
        return getVisibility() == 4;
    }

    public boolean isOpened() {
        return this.mMenuOpened;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.mMenuButton);
        bringChildToFront(this.mImageToggle);
        this.mButtonsCount = getChildCount();
        createLabels();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        if (this.mLabelsPosition == 0) {
            i15 = ((i13 - i11) - (this.mMaxButtonWidth / 2)) - getPaddingRight();
        } else {
            i15 = (this.mMaxButtonWidth / 2) + getPaddingLeft();
        }
        boolean z12 = this.mOpenDirection == 0;
        if (z12) {
            i16 = ((i14 - i12) - this.mMenuButton.getMeasuredHeight()) - getPaddingBottom();
        } else {
            i16 = getPaddingTop();
        }
        int measuredWidth = i15 - (this.mMenuButton.getMeasuredWidth() / 2);
        FloatingActionButton floatingActionButton = this.mMenuButton;
        floatingActionButton.layout(measuredWidth, i16, floatingActionButton.getMeasuredWidth() + measuredWidth, this.mMenuButton.getMeasuredHeight() + i16);
        int measuredWidth2 = i15 - (this.mImageToggle.getMeasuredWidth() / 2);
        int measuredHeight = ((this.mMenuButton.getMeasuredHeight() / 2) + i16) - (this.mImageToggle.getMeasuredHeight() / 2);
        ImageView imageView = this.mImageToggle;
        imageView.layout(measuredWidth2, measuredHeight, imageView.getMeasuredWidth() + measuredWidth2, this.mImageToggle.getMeasuredHeight() + measuredHeight);
        if (z12) {
            i16 = i16 + this.mMenuButton.getMeasuredHeight() + this.mButtonSpacing;
        }
        for (int i18 = this.mButtonsCount - 1; i18 >= 0; i18--) {
            View childAt = getChildAt(i18);
            if (childAt != this.mImageToggle) {
                FloatingActionButton floatingActionButton2 = (FloatingActionButton) childAt;
                if (floatingActionButton2.getVisibility() != 8) {
                    int measuredWidth3 = i15 - (floatingActionButton2.getMeasuredWidth() / 2);
                    if (z12) {
                        i16 = (i16 - floatingActionButton2.getMeasuredHeight()) - this.mButtonSpacing;
                    }
                    if (floatingActionButton2 != this.mMenuButton) {
                        floatingActionButton2.layout(measuredWidth3, i16, floatingActionButton2.getMeasuredWidth() + measuredWidth3, floatingActionButton2.getMeasuredHeight() + i16);
                        if (!this.mIsMenuOpening) {
                            floatingActionButton2.hide(false);
                        }
                    }
                    View view = (View) floatingActionButton2.getTag(R.id.fab_label);
                    if (view != null) {
                        int measuredWidth4 = ((this.mUsingMenuLabel ? this.mMaxButtonWidth : floatingActionButton2.getMeasuredWidth()) / 2) + this.mLabelsMargin;
                        int i19 = this.mLabelsPosition;
                        int i21 = i19 == 0 ? i15 - measuredWidth4 : measuredWidth4 + i15;
                        if (i19 == 0) {
                            i17 = i21 - view.getMeasuredWidth();
                        } else {
                            i17 = view.getMeasuredWidth() + i21;
                        }
                        int i22 = this.mLabelsPosition;
                        int i23 = i22 == 0 ? i17 : i21;
                        if (i22 != 0) {
                            i21 = i17;
                        }
                        int measuredHeight2 = (i16 - this.mLabelsVerticalOffset) + ((floatingActionButton2.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                        view.layout(i23, measuredHeight2, i21, view.getMeasuredHeight() + measuredHeight2);
                        if (!this.mIsMenuOpening) {
                            view.setVisibility(4);
                        }
                    }
                    if (z12) {
                        i16 -= this.mButtonSpacing;
                    } else {
                        i16 = i16 + childAt.getMeasuredHeight() + this.mButtonSpacing;
                    }
                }
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        this.mMaxButtonWidth = 0;
        measureChildWithMargins(this.mImageToggle, i11, 0, i12, 0);
        for (int i13 = 0; i13 < this.mButtonsCount; i13++) {
            View childAt = getChildAt(i13);
            if (!(childAt.getVisibility() == 8 || childAt == this.mImageToggle)) {
                measureChildWithMargins(childAt, i11, 0, i12, 0);
                this.mMaxButtonWidth = Math.max(this.mMaxButtonWidth, childAt.getMeasuredWidth());
            }
        }
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            int i17 = 1;
            if (i15 >= this.mButtonsCount) {
                break;
            }
            View childAt2 = getChildAt(i15);
            if (!(childAt2.getVisibility() == 8 || childAt2 == this.mImageToggle)) {
                int measuredWidth = childAt2.getMeasuredWidth() + 0;
                int measuredHeight = i14 + childAt2.getMeasuredHeight();
                Label label = (Label) childAt2.getTag(R.id.fab_label);
                if (label != null) {
                    int measuredWidth2 = this.mMaxButtonWidth - childAt2.getMeasuredWidth();
                    if (!this.mUsingMenuLabel) {
                        i17 = 2;
                    }
                    int i18 = measuredWidth2 / i17;
                    measureChildWithMargins(label, i11, childAt2.getMeasuredWidth() + label.calculateShadowWidth() + this.mLabelsMargin + i18, i12, 0);
                    i16 = Math.max(i16, measuredWidth + label.getMeasuredWidth() + i18);
                }
                i14 = measuredHeight;
            }
            i15++;
        }
        int max = Math.max(this.mMaxButtonWidth, i16 + this.mLabelsMargin) + getPaddingLeft() + getPaddingRight();
        int adjustForOvershoot = adjustForOvershoot(i14 + (this.mButtonSpacing * (this.mButtonsCount - 1)) + getPaddingTop() + getPaddingBottom());
        if (getLayoutParams().width == -1) {
            max = ViewGroup.getDefaultSize(getSuggestedMinimumWidth(), i11);
        }
        if (getLayoutParams().height == -1) {
            adjustForOvershoot = ViewGroup.getDefaultSize(getSuggestedMinimumHeight(), i12);
        }
        setMeasuredDimension(max, adjustForOvershoot);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsSetClosedOnTouchOutside) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            return isOpened();
        }
        if (action != 1) {
            return false;
        }
        close(true);
        return true;
    }

    public void open(final boolean z11) {
        if (!isOpened()) {
            OnMenuToggleListener onMenuToggleListener = this.mToggleListener;
            if (onMenuToggleListener != null) {
                onMenuToggleListener.onActionBeforeToggle(true);
            }
            if (isBackgroundEnabled()) {
                this.mShowBackgroundAnimator.start();
            }
            if (this.mIconAnimated) {
                AnimatorSet animatorSet = this.mIconToggleSet;
                if (animatorSet != null) {
                    animatorSet.start();
                } else {
                    this.mCloseAnimatorSet.cancel();
                    this.mOpenAnimatorSet.start();
                }
            }
            this.mIsMenuOpening = true;
            int i11 = 0;
            int i12 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i11++;
                    final FloatingActionButton floatingActionButton = (FloatingActionButton) childAt;
                    this.mUiHandler.postDelayed(new Runnable() {
                        public void run() {
                            if (!FloatingActionMenu.this.isOpened()) {
                                if (floatingActionButton != FloatingActionMenu.this.mMenuButton) {
                                    floatingActionButton.show(z11);
                                }
                                Label label = (Label) floatingActionButton.getTag(R.id.fab_label);
                                if (label != null && label.isHandleVisibilityChanges()) {
                                    label.show(z11);
                                }
                            }
                        }
                    }, (long) i12);
                    i12 += this.mAnimationDelayPerItem;
                }
            }
            this.mUiHandler.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = FloatingActionMenu.this.mMenuOpened = true;
                    if (FloatingActionMenu.this.mToggleListener != null) {
                        FloatingActionMenu.this.mToggleListener.onMenuToggle(true);
                    }
                }
            }, (long) ((i11 + 1) * this.mAnimationDelayPerItem));
        }
    }

    public void removeAllMenuButtons() {
        close(true);
        ArrayList<FloatingActionButton> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (!(childAt == this.mMenuButton || childAt == this.mImageToggle || !(childAt instanceof FloatingActionButton))) {
                arrayList.add((FloatingActionButton) childAt);
            }
        }
        for (FloatingActionButton removeMenuButton : arrayList) {
            removeMenuButton(removeMenuButton);
        }
    }

    public void removeMenuButton(FloatingActionButton floatingActionButton) {
        removeView(floatingActionButton.getLabelView());
        removeView(floatingActionButton);
        this.mButtonsCount--;
    }

    public void setAnimated(boolean z11) {
        this.mIsAnimated = z11;
        long j11 = 300;
        this.mOpenAnimatorSet.setDuration(z11 ? 300 : 0);
        AnimatorSet animatorSet = this.mCloseAnimatorSet;
        if (!z11) {
            j11 = 0;
        }
        animatorSet.setDuration(j11);
    }

    public void setAnimationDelayPerItem(int i11) {
        this.mAnimationDelayPerItem = i11;
    }

    public void setClosedOnTouchOutside(boolean z11) {
        this.mIsSetClosedOnTouchOutside = z11;
    }

    public void setIconAnimated(boolean z11) {
        this.mIconAnimated = z11;
    }

    public void setIconAnimationCloseInterpolator(Interpolator interpolator) {
        this.mCloseAnimatorSet.setInterpolator(interpolator);
    }

    public void setIconAnimationInterpolator(Interpolator interpolator) {
        this.mOpenAnimatorSet.setInterpolator(interpolator);
        this.mCloseAnimatorSet.setInterpolator(interpolator);
    }

    public void setIconAnimationOpenInterpolator(Interpolator interpolator) {
        this.mOpenAnimatorSet.setInterpolator(interpolator);
    }

    public void setIconToggleAnimatorSet(AnimatorSet animatorSet) {
        this.mIconToggleSet = animatorSet;
    }

    public void setMenuButtonColorNormal(int i11) {
        this.mMenuColorNormal = i11;
        this.mMenuButton.setColorNormal(i11);
    }

    public void setMenuButtonColorNormalResId(int i11) {
        this.mMenuColorNormal = getResources().getColor(i11);
        this.mMenuButton.setColorNormalResId(i11);
    }

    public void setMenuButtonColorPressed(int i11) {
        this.mMenuColorPressed = i11;
        this.mMenuButton.setColorPressed(i11);
    }

    public void setMenuButtonColorPressedResId(int i11) {
        this.mMenuColorPressed = getResources().getColor(i11);
        this.mMenuButton.setColorPressedResId(i11);
    }

    public void setMenuButtonColorRipple(int i11) {
        this.mMenuColorRipple = i11;
        this.mMenuButton.setColorRipple(i11);
    }

    public void setMenuButtonColorRippleResId(int i11) {
        this.mMenuColorRipple = getResources().getColor(i11);
        this.mMenuButton.setColorRippleResId(i11);
    }

    public void setMenuButtonHideAnimation(Animation animation) {
        this.mMenuButtonHideAnimation = animation;
        this.mMenuButton.setHideAnimation(animation);
    }

    public void setMenuButtonLabelText(String str) {
        this.mMenuButton.setLabelText(str);
    }

    public void setMenuButtonShowAnimation(Animation animation) {
        this.mMenuButtonShowAnimation = animation;
        this.mMenuButton.setShowAnimation(animation);
    }

    public void setOnMenuButtonClickListener(View.OnClickListener onClickListener) {
        this.mMenuButton.setOnClickListener(onClickListener);
    }

    public void setOnMenuButtonLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mMenuButton.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMenuToggleListener(OnMenuToggleListener onMenuToggleListener) {
        this.mToggleListener = onMenuToggleListener;
    }

    public void showMenu(boolean z11) {
        if (isMenuHidden()) {
            if (z11) {
                startAnimation(this.mMenuButtonShowAnimation);
            }
            setVisibility(0);
        }
    }

    public void showMenuButton(boolean z11) {
        if (isMenuButtonHidden()) {
            showMenuButtonWithImage(z11);
        }
    }

    public void toggle(boolean z11) {
        if (isOpened()) {
            close(z11);
        } else {
            open(z11);
        }
    }

    public void toggleMenu(boolean z11) {
        if (isMenuHidden()) {
            showMenu(z11);
        } else {
            hideMenu(z11);
        }
    }

    public void toggleMenuButton(boolean z11) {
        if (isMenuButtonHidden()) {
            showMenuButton(z11);
        } else {
            hideMenuButton(z11);
        }
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mOpenAnimatorSet = new AnimatorSet();
        this.mCloseAnimatorSet = new AnimatorSet();
        this.mButtonSpacing = PixelUtils.a(0.0f);
        this.mLabelsMargin = PixelUtils.a(0.0f);
        this.mLabelsVerticalOffset = PixelUtils.a(0.0f);
        this.mUiHandler = new Handler();
        this.mLabelsPaddingTop = PixelUtils.a(4.0f);
        this.mLabelsPaddingRight = PixelUtils.a(8.0f);
        this.mLabelsPaddingBottom = PixelUtils.a(4.0f);
        this.mLabelsPaddingLeft = PixelUtils.a(8.0f);
        this.mLabelsCornerRadius = PixelUtils.a(3.0f);
        this.mMenuShadowRadius = 4.0f;
        this.mMenuShadowXOffset = 1.0f;
        this.mMenuShadowYOffset = 3.0f;
        this.mIsAnimated = true;
        this.mIconAnimated = true;
        init(context, attributeSet);
    }

    public ViewGroup.MarginLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void addMenuButton(FloatingActionButton floatingActionButton, int i11) {
        int i12 = this.mButtonsCount - 2;
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 > i12) {
            i11 = i12;
        }
        addView(floatingActionButton, i11);
        this.mButtonsCount++;
        addLabel(floatingActionButton);
    }

    public ViewGroup.MarginLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
