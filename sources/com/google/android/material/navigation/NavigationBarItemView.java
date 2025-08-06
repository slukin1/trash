package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.i0;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import androidx.core.view.z;
import androidx.core.widget.l;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import u0.a;

public abstract class NavigationBarItemView extends FrameLayout implements j.a {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int INVALID_ITEM_POSITION = -1;
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    /* access modifiers changed from: private */
    public ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private g itemData;
    private int itemPosition = -1;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    public NavigationBarItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(getItemLayoutResId(), this, true);
        this.icon = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.labelGroup = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.smallLabel = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.largeLabel = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.defaultMargin = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        viewGroup.setTag(R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        h0.I0(textView, 2);
        h0.I0(textView2, 2);
        setFocusable(true);
        calculateTextScaleFactors(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                    if (NavigationBarItemView.this.icon.getVisibility() == 0) {
                        NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                        navigationBarItemView.tryUpdateBadgeBounds(navigationBarItemView.icon);
                    }
                }
            });
        }
    }

    private void calculateTextScaleFactors(float f11, float f12) {
        this.shiftAmount = f11 - f12;
        this.scaleUpFactor = (f12 * 1.0f) / f11;
        this.scaleDownFactor = (f11 * 1.0f) / f12;
    }

    private FrameLayout getCustomParentForBadge(View view) {
        ImageView imageView = this.icon;
        if (view != imageView || !BadgeUtils.USE_COMPAT_PARENT) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i11 = 0;
        for (int i12 = 0; i12 < indexOfChild; i12++) {
            View childAt = viewGroup.getChildAt(i12);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i11++;
            }
        }
        return i11;
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        int minimumHeight = badgeDrawable2 != null ? badgeDrawable2.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) this.icon.getLayoutParams()).topMargin) + this.icon.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        int i11;
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 == null) {
            i11 = 0;
        } else {
            i11 = badgeDrawable2.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        return Math.max(i11, layoutParams.leftMargin) + this.icon.getMeasuredWidth() + Math.max(i11, layoutParams.rightMargin);
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    private static void setViewLayoutParams(View view, int i11, int i12) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i11;
        layoutParams.gravity = i12;
        view.setLayoutParams(layoutParams);
    }

    private static void setViewScaleValues(View view, float f11, float f12, int i11) {
        view.setScaleX(f11);
        view.setScaleY(f12);
        view.setVisibility(i11);
    }

    private void tryAttachBadgeToAnchor(View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
            }
            this.badgeDrawable = null;
        }
    }

    /* access modifiers changed from: private */
    public void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private static void updateViewPaddingBottom(View view, int i11) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i11);
    }

    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    public int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    public g getItemData() {
        return this.itemData;
    }

    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.labelGroup.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.labelGroup.getMeasuredWidth() + layoutParams.rightMargin);
    }

    public void initialize(g gVar, int i11) {
        CharSequence charSequence;
        this.itemData = gVar;
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setIcon(gVar.getIcon());
        setTitle(gVar.getTitle());
        setId(gVar.getItemId());
        if (!TextUtils.isEmpty(gVar.getContentDescription())) {
            setContentDescription(gVar.getContentDescription());
        }
        if (!TextUtils.isEmpty(gVar.getTooltipText())) {
            charSequence = gVar.getTooltipText();
        } else {
            charSequence = gVar.getTitle();
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 21 || i12 > 23) {
            i0.a(this, charSequence);
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
    }

    public int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        g gVar = this.itemData;
        if (gVar != null && gVar.isCheckable() && this.itemData.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable2 = this.badgeDrawable;
        if (badgeDrawable2 != null && badgeDrawable2.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(title + ", " + this.badgeDrawable.getContentDescription());
        }
        AccessibilityNodeInfoCompat U0 = AccessibilityNodeInfoCompat.U0(accessibilityNodeInfo);
        U0.r0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            U0.p0(false);
            U0.f0(AccessibilityNodeInfoCompat.a.f8539i);
        }
        U0.I0(getResources().getString(R.string.item_view_role_description));
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setBadge(BadgeDrawable badgeDrawable2) {
        this.badgeDrawable = badgeDrawable2;
        ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    public void setCheckable(boolean z11) {
        refreshDrawableState();
    }

    public void setChecked(boolean z11) {
        TextView textView = this.largeLabel;
        textView.setPivotX((float) (textView.getWidth() / 2));
        TextView textView2 = this.largeLabel;
        textView2.setPivotY((float) textView2.getBaseline());
        TextView textView3 = this.smallLabel;
        textView3.setPivotX((float) (textView3.getWidth() / 2));
        TextView textView4 = this.smallLabel;
        textView4.setPivotY((float) textView4.getBaseline());
        int i11 = this.labelVisibilityMode;
        if (i11 != -1) {
            if (i11 == 0) {
                if (z11) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    ViewGroup viewGroup = this.labelGroup;
                    updateViewPaddingBottom(viewGroup, ((Integer) viewGroup.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                    this.largeLabel.setVisibility(0);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    updateViewPaddingBottom(this.labelGroup, 0);
                    this.largeLabel.setVisibility(4);
                }
                this.smallLabel.setVisibility(4);
            } else if (i11 == 1) {
                ViewGroup viewGroup2 = this.labelGroup;
                updateViewPaddingBottom(viewGroup2, ((Integer) viewGroup2.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                if (z11) {
                    setViewLayoutParams(this.icon, (int) (((float) this.defaultMargin) + this.shiftAmount), 49);
                    setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                    TextView textView5 = this.smallLabel;
                    float f11 = this.scaleUpFactor;
                    setViewScaleValues(textView5, f11, f11, 4);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    TextView textView6 = this.largeLabel;
                    float f12 = this.scaleDownFactor;
                    setViewScaleValues(textView6, f12, f12, 4);
                    setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
                }
            } else if (i11 == 2) {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                this.largeLabel.setVisibility(8);
                this.smallLabel.setVisibility(8);
            }
        } else if (this.isShifting) {
            if (z11) {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                ViewGroup viewGroup3 = this.labelGroup;
                updateViewPaddingBottom(viewGroup3, ((Integer) viewGroup3.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                this.largeLabel.setVisibility(0);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                updateViewPaddingBottom(this.labelGroup, 0);
                this.largeLabel.setVisibility(4);
            }
            this.smallLabel.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.labelGroup;
            updateViewPaddingBottom(viewGroup4, ((Integer) viewGroup4.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
            if (z11) {
                setViewLayoutParams(this.icon, (int) (((float) this.defaultMargin) + this.shiftAmount), 49);
                setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                TextView textView7 = this.smallLabel;
                float f13 = this.scaleUpFactor;
                setViewScaleValues(textView7, f13, f13, 4);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                TextView textView8 = this.largeLabel;
                float f14 = this.scaleDownFactor;
                setViewScaleValues(textView8, f14, f14, 4);
                setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z11);
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        this.smallLabel.setEnabled(z11);
        this.largeLabel.setEnabled(z11);
        this.icon.setEnabled(z11);
        if (z11) {
            h0.Q0(this, z.b(getContext(), 1002));
        } else {
            h0.Q0(this, (z) null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable != this.originalIconDrawable) {
            this.originalIconDrawable = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = a.r(drawable).mutate();
                this.wrappedIconDrawable = drawable;
                ColorStateList colorStateList = this.iconTint;
                if (colorStateList != null) {
                    a.o(drawable, colorStateList);
                }
            }
            this.icon.setImageDrawable(drawable);
        }
    }

    public void setIconSize(int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = i11;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData != null && (drawable = this.wrappedIconDrawable) != null) {
            a.o(drawable, colorStateList);
            this.wrappedIconDrawable.invalidateSelf();
        }
    }

    public void setItemBackground(int i11) {
        setItemBackground(i11 == 0 ? null : ContextCompat.getDrawable(getContext(), i11));
    }

    public void setItemPosition(int i11) {
        this.itemPosition = i11;
    }

    public void setLabelVisibilityMode(int i11) {
        if (this.labelVisibilityMode != i11) {
            this.labelVisibilityMode = i11;
            g gVar = this.itemData;
            if (gVar != null) {
                setChecked(gVar.isChecked());
            }
        }
    }

    public void setShifting(boolean z11) {
        if (this.isShifting != z11) {
            this.isShifting = z11;
            g gVar = this.itemData;
            if (gVar != null) {
                setChecked(gVar.isChecked());
            }
        }
    }

    public void setShortcut(boolean z11, char c11) {
    }

    public void setTextAppearanceActive(int i11) {
        l.s(this.largeLabel, i11);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(int i11) {
        l.s(this.smallLabel, i11);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        g gVar = this.itemData;
        if (gVar == null || TextUtils.isEmpty(gVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        g gVar2 = this.itemData;
        if (gVar2 != null && !TextUtils.isEmpty(gVar2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 21 || i11 > 23) {
            i0.a(this, charSequence);
        }
    }

    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        h0.B0(this, drawable);
    }
}
