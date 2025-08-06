package com.huobi.view.collapsingtoolbarlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.h0;
import androidx.core.view.v;
import androidx.core.widget.l;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$style;
import com.hbg.lib.widgets.R$styleable;
import com.huobi.view.collapsingtoolbarlayout.ValueAnimatorCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import u0.a;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int AUTO_SIZE_MIN_TEXT_SIZE = 5;
    private static final int AUTO_SIZE_STEP_GRANULARITY = 1;
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int MAX_LINES = 1;
    private static final int TITLE_MAX_SIZE = 28;
    private AppBarLayout mAppBarLayout;
    public final CollapsingTextHelper mCollapsingTextHelper;
    private boolean mCollapsingTitleEnabled;
    private Drawable mContentScrim;
    public int mCurrentOffset;
    private FrameLayout.LayoutParams mDividerLayoutParams;
    private View mDividerView;
    private boolean mDrawCollapsingMiddleTitle;
    private boolean mDrawCollapsingTitle;
    private View mDummyView;
    private int mExpandedMarginBottom;
    private int mExpandedMarginEnd;
    private int mExpandedMarginStart;
    private int mExpandedMarginTop;
    public WindowInsetsCompat mLastInsets;
    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private boolean mRefreshToolbar;
    private int mScrimAlpha;
    private long mScrimAnimationDuration;
    private ValueAnimatorCompat mScrimAnimator;
    private int mScrimVisibleHeightTrigger;
    private boolean mScrimsAreShown;
    private boolean mShowDivider;
    public Drawable mStatusBarScrim;
    private TextView mTitleView;
    private final Rect mTmpRect;
    private Toolbar mToolbar;
    private View mToolbarDirectChild;
    private int mToolbarDrawIndex;
    private int mToolbarId;

    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.mCurrentOffset = i11;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.mLastInsets;
            int m11 = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i12);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                int i13 = layoutParams.mCollapseMode;
                if (i13 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(MathUtils.constrain(-i11, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(childAt)));
                } else if (i13 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(Math.round(((float) (-i11)) * layoutParams.mParallaxMult));
                }
            }
            CollapsingToolbarLayout.this.updateScrimVisibility();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.mStatusBarScrim != null && m11 > 0) {
                h0.n0(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.mCollapsingTextHelper.setExpansionFraction(((float) Math.abs(i11)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - h0.G(CollapsingToolbarLayout.this)) - m11)));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void animateScrim(int i11) {
        Interpolator interpolator;
        ensureToolbar();
        ValueAnimatorCompat valueAnimatorCompat = this.mScrimAnimator;
        if (valueAnimatorCompat == null) {
            ValueAnimatorCompat createAnimator = ViewUtils.createAnimator();
            this.mScrimAnimator = createAnimator;
            createAnimator.setDuration(this.mScrimAnimationDuration);
            ValueAnimatorCompat valueAnimatorCompat2 = this.mScrimAnimator;
            if (i11 > this.mScrimAlpha) {
                interpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            } else {
                interpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            valueAnimatorCompat2.setInterpolator(interpolator);
            this.mScrimAnimator.addUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat) {
                    CollapsingToolbarLayout.this.setScrimAlpha(valueAnimatorCompat.getAnimatedIntValue());
                }
            });
        } else if (valueAnimatorCompat.isRunning()) {
            this.mScrimAnimator.cancel();
        }
        this.mScrimAnimator.setIntValues(this.mScrimAlpha, i11);
        this.mScrimAnimator.start();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ensureToolbar() {
        /*
            r6 = this;
            boolean r0 = r6.mRefreshToolbar
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.mToolbar = r0
            r6.mToolbarDirectChild = r0
            int r1 = r6.mToolbarId
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            androidx.appcompat.widget.Toolbar r1 = (androidx.appcompat.widget.Toolbar) r1
            r6.mToolbar = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.findDirectChild(r1)
            r6.mToolbarDirectChild = r1
        L_0x001f:
            androidx.appcompat.widget.Toolbar r1 = r6.mToolbar
            r2 = 0
            if (r1 != 0) goto L_0x003c
            int r1 = r6.getChildCount()
            r3 = r2
        L_0x0029:
            if (r3 >= r1) goto L_0x003a
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = r4 instanceof androidx.appcompat.widget.Toolbar
            if (r5 == 0) goto L_0x0037
            r0 = r4
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            goto L_0x003a
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003a:
            r6.mToolbar = r0
        L_0x003c:
            r6.updateDummyView()
            r6.mRefreshToolbar = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout.ensureToolbar():void");
    }

    private View findDirectChild(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private static int getHeightWithMargins(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static ViewOffsetHelper getViewOffsetHelper(View view) {
        int i11 = R$id.view_offset_helper;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(i11);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(i11, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean isToolbarChildDrawnNext(View view) {
        int i11 = this.mToolbarDrawIndex;
        return i11 >= 0 && i11 == indexOfChild(view) + 1;
    }

    private void updateDummyView() {
        View view;
        if (!this.mCollapsingTitleEnabled && (view = this.mDummyView) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mDummyView);
            }
        }
        if (this.mCollapsingTitleEnabled && this.mToolbar != null) {
            if (this.mDummyView == null) {
                this.mDummyView = new View(getContext());
            }
            if (this.mDummyView.getParent() == null) {
                this.mToolbar.addView(this.mDummyView, -1, -1);
            }
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.mToolbar == null && (drawable = this.mContentScrim) != null && this.mScrimAlpha > 0) {
            drawable.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
        }
        if (this.mCollapsingTitleEnabled && this.mDrawCollapsingTitle) {
            if (this.mDrawCollapsingMiddleTitle) {
                this.mCollapsingTextHelper.draw(canvas);
            }
            String str = null;
            String charSequence = this.mTitleView.getText() == null ? null : this.mTitleView.getText().toString();
            if (this.mCollapsingTextHelper.getText() != null) {
                str = this.mCollapsingTextHelper.getText().toString();
            }
            if ((charSequence == null && str != null) || (charSequence != null && !charSequence.equals(str))) {
                this.mTitleView.setText(str);
            }
        }
        if (this.mStatusBarScrim != null && this.mScrimAlpha > 0) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            int m11 = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
            if (m11 > 0) {
                this.mStatusBarScrim.setBounds(0, -this.mCurrentOffset, getWidth(), m11 - this.mCurrentOffset);
                this.mStatusBarScrim.mutate().setAlpha(this.mScrimAlpha);
                this.mStatusBarScrim.draw(canvas);
            }
        }
        if (Math.abs(this.mCurrentOffset) < this.mAppBarLayout.getTotalScrollRange() || this.mToolbar == null || !this.mShowDivider) {
            if (indexOfChild(this.mDividerView) != -1) {
                removeView(this.mDividerView);
            }
        } else if (indexOfChild(this.mDividerView) == -1) {
            addView(this.mDividerView, this.mDividerLayoutParams);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        boolean drawChild = super.drawChild(canvas, view, j11);
        if (this.mContentScrim == null || this.mScrimAlpha <= 0 || !isToolbarChildDrawnNext(view)) {
            return drawChild;
        }
        this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
        this.mContentScrim.draw(canvas);
        return true;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarScrim;
        boolean z11 = false;
        if (drawable != null && drawable.isStateful()) {
            z11 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            z11 |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.mCollapsingTextHelper;
        if (collapsingTextHelper != null) {
            z11 |= collapsingTextHelper.setState(drawableState);
        }
        if (z11) {
            invalidate();
        }
    }

    public int getCollapsedTitleGravity() {
        return this.mCollapsingTextHelper.getCollapsedTextGravity();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.mCollapsingTextHelper.getCollapsedTypeface();
    }

    public Drawable getContentScrim() {
        return this.mContentScrim;
    }

    public View getDividerView() {
        return this.mDividerView;
    }

    public int getExpandedTitleGravity() {
        return this.mCollapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.mExpandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.mExpandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.mExpandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.mExpandedMarginTop;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.mCollapsingTextHelper.getExpandedTypeface();
    }

    public final int getMaxOffsetForPinChild(View view) {
        return ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public long getScrimAnimationDuration() {
        return this.mScrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int i11 = this.mScrimVisibleHeightTrigger;
        if (i11 >= 0) {
            return i11;
        }
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        int m11 = windowInsetsCompat != null ? windowInsetsCompat.m() : 0;
        int G = h0.G(this);
        if (G > 0) {
            return Math.min((G * 2) + m11, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.mStatusBarScrim;
    }

    public CharSequence getTitle() {
        if (this.mCollapsingTitleEnabled) {
            return this.mCollapsingTextHelper.getText();
        }
        return null;
    }

    public boolean isTitleEnabled() {
        return this.mCollapsingTitleEnabled;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            h0.G0(this, h0.C((View) parent));
            if (this.mOnOffsetChangedListener == null) {
                this.mOnOffsetChangedListener = new OffsetUpdateListener();
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            this.mAppBarLayout = appBarLayout;
            appBarLayout.addOnOffsetChangedListener(this.mOnOffsetChangedListener);
            h0.u0(this);
        }
    }

    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.mOnOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        View view;
        int i15;
        int i16;
        super.onLayout(z11, i11, i12, i13, i14);
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        if (windowInsetsCompat != null) {
            int m11 = windowInsetsCompat.m();
            int childCount = getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                if (!h0.C(childAt) && childAt.getTop() < m11) {
                    h0.h0(childAt, m11);
                }
            }
        }
        if (this.mCollapsingTitleEnabled && (view = this.mDummyView) != null) {
            boolean z12 = true;
            boolean z13 = h0.Z(view) && this.mDummyView.getVisibility() == 0;
            this.mDrawCollapsingTitle = z13;
            if (z13) {
                if (h0.F(this) != 1) {
                    z12 = false;
                }
                View view2 = this.mToolbarDirectChild;
                if (view2 == null) {
                    view2 = this.mToolbar;
                }
                int maxOffsetForPinChild = getMaxOffsetForPinChild(view2);
                ViewGroupUtils.getDescendantRect(this, this.mDummyView, this.mTmpRect);
                CollapsingTextHelper collapsingTextHelper = this.mCollapsingTextHelper;
                int i18 = this.mTmpRect.left;
                if (z12) {
                    i15 = this.mToolbar.getTitleMarginEnd();
                } else {
                    i15 = this.mToolbar.getTitleMarginStart();
                }
                int i19 = i18 + i15;
                int titleMarginTop = this.mTmpRect.top + maxOffsetForPinChild + this.mToolbar.getTitleMarginTop();
                int i21 = this.mTmpRect.right;
                if (z12) {
                    i16 = this.mToolbar.getTitleMarginStart();
                } else {
                    i16 = this.mToolbar.getTitleMarginEnd();
                }
                collapsingTextHelper.setCollapsedBounds(i19, titleMarginTop, i21 + i16, (this.mTmpRect.bottom + maxOffsetForPinChild) - this.mToolbar.getTitleMarginBottom());
                this.mCollapsingTextHelper.setExpandedBounds(z12 ? this.mExpandedMarginEnd : this.mExpandedMarginStart, this.mTmpRect.top + this.mExpandedMarginTop, (i13 - i11) - (z12 ? this.mExpandedMarginStart : this.mExpandedMarginEnd), (i14 - i12) - this.mExpandedMarginBottom);
                this.mCollapsingTextHelper.recalculate();
            }
        }
        int childCount2 = getChildCount();
        for (int i22 = 0; i22 < childCount2; i22++) {
            getViewOffsetHelper(getChildAt(i22)).onViewLayout();
        }
        if (this.mToolbar != null) {
            if (this.mCollapsingTitleEnabled && TextUtils.isEmpty(this.mCollapsingTextHelper.getText())) {
                this.mCollapsingTextHelper.setText(this.mToolbar.getTitle());
            }
            View view3 = this.mToolbarDirectChild;
            if (view3 == null || view3 == this) {
                setMinimumHeight(getHeightWithMargins(this.mToolbar));
                this.mToolbarDrawIndex = indexOfChild(this.mToolbar);
            } else {
                setMinimumHeight(getHeightWithMargins(view3));
                this.mToolbarDrawIndex = indexOfChild(this.mToolbarDirectChild);
            }
        } else {
            this.mToolbarDrawIndex = -1;
        }
        updateScrimVisibility();
    }

    public void onMeasure(int i11, int i12) {
        ensureToolbar();
        super.onMeasure(i11, i12);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        Drawable drawable = this.mContentScrim;
        if (drawable != null) {
            drawable.setBounds(0, 0, i11, i12);
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = h0.C(this) ? windowInsetsCompat : null;
        if (!ViewUtils.objectEquals(this.mLastInsets, windowInsetsCompat2)) {
            this.mLastInsets = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.c();
    }

    public void setCollapsedTitleGravity(int i11) {
        this.mCollapsingTextHelper.setCollapsedTextGravity(i11);
    }

    public void setCollapsedTitleTextAppearance(int i11) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(i11);
    }

    public void setCollapsedTitleTextColor(int i11) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.mCollapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mContentScrim = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.mContentScrim.setCallback(this);
                this.mContentScrim.setAlpha(this.mScrimAlpha);
            }
            h0.n0(this);
        }
    }

    public void setContentScrimColor(int i11) {
        setContentScrim(new ColorDrawable(i11));
    }

    public void setContentScrimResource(int i11) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i11));
    }

    public void setDrawCollapsingMiddleTitle(boolean z11) {
        this.mDrawCollapsingMiddleTitle = z11;
    }

    public void setExpandedTitleColor(int i11) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(i11);
        }
        setExpandedTitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setExpandedTitleGravity(int i11) {
        this.mCollapsingTextHelper.setExpandedTextGravity(i11);
    }

    public void setExpandedTitleMargin(int i11, int i12, int i13, int i14) {
        this.mExpandedMarginStart = i11;
        this.mExpandedMarginTop = i12;
        this.mExpandedMarginEnd = i13;
        this.mExpandedMarginBottom = i14;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i11) {
        this.mExpandedMarginBottom = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i11) {
        this.mExpandedMarginEnd = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i11) {
        this.mExpandedMarginStart = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i11) {
        this.mExpandedMarginTop = i11;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i11) {
        this.mCollapsingTextHelper.setExpandedTextAppearance(i11);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        this.mCollapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.mCollapsingTextHelper.setExpandedTypeface(typeface);
    }

    public void setScrimAlpha(int i11) {
        Toolbar toolbar;
        if (i11 != this.mScrimAlpha) {
            if (!(this.mContentScrim == null || (toolbar = this.mToolbar) == null)) {
                h0.n0(toolbar);
            }
            this.mScrimAlpha = i11;
            h0.n0(this);
        }
    }

    public void setScrimAnimationDuration(long j11) {
        this.mScrimAnimationDuration = j11;
    }

    public void setScrimVisibleHeightTrigger(int i11) {
        if (this.mScrimVisibleHeightTrigger != i11) {
            this.mScrimVisibleHeightTrigger = i11;
            updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean z11) {
        setScrimsShown(z11, h0.a0(this) && !isInEditMode());
    }

    public void setShowDivider(boolean z11) {
        this.mShowDivider = z11;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarScrim = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarScrim.setState(getDrawableState());
                }
                a.m(this.mStatusBarScrim, h0.F(this));
                this.mStatusBarScrim.setVisible(getVisibility() == 0, false);
                this.mStatusBarScrim.setCallback(this);
                this.mStatusBarScrim.setAlpha(this.mScrimAlpha);
            }
            h0.n0(this);
        }
    }

    public void setStatusBarScrimColor(int i11) {
        setStatusBarScrim(new ColorDrawable(i11));
    }

    public void setStatusBarScrimResource(int i11) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i11));
    }

    public void setTitle(CharSequence charSequence) {
        this.mCollapsingTextHelper.setText(charSequence);
    }

    public void setTitleEnabled(boolean z11) {
        if (z11 != this.mCollapsingTitleEnabled) {
            this.mCollapsingTitleEnabled = z11;
            updateDummyView();
            requestLayout();
        }
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        boolean z11 = i11 == 0;
        Drawable drawable = this.mStatusBarScrim;
        if (!(drawable == null || drawable.isVisible() == z11)) {
            this.mStatusBarScrim.setVisible(z11, false);
        }
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 != null && drawable2.isVisible() != z11) {
            this.mContentScrim.setVisible(z11, false);
        }
    }

    public final void updateScrimVisibility() {
        if (this.mContentScrim != null || this.mStatusBarScrim != null) {
            setScrimsShown(getHeight() + this.mCurrentOffset < getScrimVisibleHeightTrigger());
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mContentScrim || drawable == this.mStatusBarScrim;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.mCollapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setScrimsShown(boolean z11, boolean z12) {
        if (this.mScrimsAreShown != z11) {
            int i11 = 255;
            if (z12) {
                if (!z11) {
                    i11 = 0;
                }
                animateScrim(i11);
            } else {
                if (!z11) {
                    i11 = 0;
                }
                setScrimAlpha(i11);
            }
            this.mScrimsAreShown = z11;
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mRefreshToolbar = true;
        this.mTmpRect = new Rect();
        this.mDrawCollapsingMiddleTitle = true;
        this.mScrimVisibleHeightTrigger = -1;
        this.mShowDivider = true;
        ThemeUtils.checkAppCompatTheme(context);
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.mCollapsingTextHelper = collapsingTextHelper;
        collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        View view = new View(context);
        this.mDividerView = view;
        view.setBackgroundResource(R$color.baseColorPrimarySeparator);
        LayoutParams layoutParams = new LayoutParams(-1, PixelUtils.h(context.getResources().getDimension(R$dimen.global_divider_height)));
        this.mDividerLayoutParams = layoutParams;
        layoutParams.gravity = 80;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout, i11, R$style.Widget_Design_CollapsingToolbar);
        collapsingTextHelper.setExpandedTextGravity(obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, BadgeDrawable.BOTTOM_START));
        collapsingTextHelper.setCollapsedTextGravity(obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.mExpandedMarginBottom = dimensionPixelSize;
        this.mExpandedMarginEnd = dimensionPixelSize;
        this.mExpandedMarginTop = dimensionPixelSize;
        this.mExpandedMarginStart = dimensionPixelSize;
        int i12 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.mExpandedMarginStart = obtainStyledAttributes.getDimensionPixelSize(i12, 0);
        }
        int i13 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.mExpandedMarginEnd = obtainStyledAttributes.getDimensionPixelSize(i13, 0);
        }
        int i14 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.mExpandedMarginTop = obtainStyledAttributes.getDimensionPixelSize(i14, 0);
        }
        int i15 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.mExpandedMarginBottom = obtainStyledAttributes.getDimensionPixelSize(i15, 0);
        }
        this.mCollapsingTitleEnabled = obtainStyledAttributes.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(R$styleable.CollapsingToolbarLayout_title));
        collapsingTextHelper.setExpandedTextAppearance(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        collapsingTextHelper.setCollapsedTextAppearance(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int i16 = R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (obtainStyledAttributes.hasValue(i16)) {
            collapsingTextHelper.setExpandedTextAppearance(obtainStyledAttributes.getResourceId(i16, 0));
        }
        int i17 = R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (obtainStyledAttributes.hasValue(i17)) {
            collapsingTextHelper.setCollapsedTextAppearance(obtainStyledAttributes.getResourceId(i17, 0));
        }
        this.mScrimVisibleHeightTrigger = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.mScrimAnimationDuration = (long) obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        this.mToolbarId = obtainStyledAttributes.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.mTitleView = appCompatTextView;
        appCompatTextView.setMaxLines(1);
        this.mTitleView.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        collapsingTextHelper.initTitleTextView(this.mTitleView);
        l.k(this.mTitleView, 1);
        l.j(this.mTitleView, 5, 28, 1, 1);
        this.mTitleView.setTextSize(1, 28.0f);
        LayoutParams layoutParams2 = new LayoutParams(-1, -2);
        layoutParams2.gravity = getExpandedTitleGravity();
        layoutParams2.topMargin = this.mExpandedMarginTop;
        layoutParams2.leftMargin = this.mExpandedMarginStart;
        layoutParams2.rightMargin = this.mExpandedMarginEnd;
        layoutParams2.bottomMargin = this.mExpandedMarginBottom;
        addView(this.mTitleView, layoutParams2);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        h0.O0(this, new v() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.onWindowInsetChanged(windowInsetsCompat);
            }
        });
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        public int mCollapseMode = 0;
        public float mParallaxMult = 0.5f;

        @Retention(RetentionPolicy.SOURCE)
        public @interface CollapseMode {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.mCollapseMode = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int getCollapseMode() {
            return this.mCollapseMode;
        }

        public float getParallaxMultiplier() {
            return this.mParallaxMult;
        }

        public void setCollapseMode(int i11) {
            this.mCollapseMode = i11;
        }

        public void setParallaxMultiplier(float f11) {
            this.mParallaxMult = f11;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(int i11, int i12, int i13) {
            super(i11, i12, i13);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
