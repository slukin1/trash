package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import java.util.ArrayList;
import java.util.List;

public class ChipGroup extends FlowLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ChipGroup;
    /* access modifiers changed from: private */
    public int checkedId;
    /* access modifiers changed from: private */
    public final CheckedStateTracker checkedStateTracker;
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private OnCheckedChangeListener onCheckedChangeListener;
    private PassThroughHierarchyChangeListener passThroughListener;
    /* access modifiers changed from: private */
    public boolean protectFromCheckedChange;
    /* access modifiers changed from: private */
    public boolean selectionRequired;
    /* access modifiers changed from: private */
    public boolean singleSelection;

    public class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            if (!ChipGroup.this.protectFromCheckedChange) {
                if (!ChipGroup.this.getCheckedChipIds().isEmpty() || !ChipGroup.this.selectionRequired) {
                    int id2 = compoundButton.getId();
                    if (z11) {
                        if (!(ChipGroup.this.checkedId == -1 || ChipGroup.this.checkedId == id2 || !ChipGroup.this.singleSelection)) {
                            ChipGroup chipGroup = ChipGroup.this;
                            chipGroup.setCheckedStateForView(chipGroup.checkedId, false);
                        }
                        ChipGroup.this.setCheckedId(id2);
                    } else if (ChipGroup.this.checkedId == id2) {
                        ChipGroup.this.setCheckedId(-1);
                    }
                } else {
                    ChipGroup.this.setCheckedStateForView(compoundButton.getId(), true);
                    ChipGroup.this.setCheckedId(compoundButton.getId(), false);
                }
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(ChipGroup chipGroup, int i11);
    }

    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */
        public ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(h0.n());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).check(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.checkedStateTracker);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener2 = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener2 != null) {
                onHierarchyChangeListener2.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal((CompoundButton.OnCheckedChangeListener) null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener2 = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener2 != null) {
                onHierarchyChangeListener2.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getChipCount() {
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) instanceof Chip) {
                i11++;
            }
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i11) {
        setCheckedId(i11, true);
    }

    /* access modifiers changed from: private */
    public void setCheckedStateForView(int i11, boolean z11) {
        View findViewById = findViewById(i11);
        if (findViewById instanceof Chip) {
            this.protectFromCheckedChange = true;
            ((Chip) findViewById).setChecked(z11);
            this.protectFromCheckedChange = false;
        }
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i12 = this.checkedId;
                if (i12 != -1 && this.singleSelection) {
                    setCheckedStateForView(i12, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i11, layoutParams);
    }

    public void check(int i11) {
        int i12 = this.checkedId;
        if (i11 != i12) {
            if (i12 != -1 && this.singleSelection) {
                setCheckedStateForView(i12, false);
            }
            if (i11 != -1) {
                setCheckedStateForView(i11, true);
            }
            setCheckedId(i11);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void clearCheck() {
        this.protectFromCheckedChange = true;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.protectFromCheckedChange = false;
        setCheckedId(-1);
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.singleSelection) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public int getIndexOfChip(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) instanceof Chip) {
                if (((Chip) getChildAt(i12)) == view) {
                    return i11;
                }
                i11++;
            }
        }
        return -1;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i11 = this.checkedId;
        if (i11 != -1) {
            setCheckedStateForView(i11, true);
            setCheckedId(this.checkedId);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.U0(accessibilityNodeInfo).q0(AccessibilityNodeInfoCompat.f.b(getRowCount(), isSingleLine() ? getChipCount() : -1, false, isSingleSelection() ? 1 : 2));
    }

    public void setChipSpacing(int i11) {
        setChipSpacingHorizontal(i11);
        setChipSpacingVertical(i11);
    }

    public void setChipSpacingHorizontal(int i11) {
        if (this.chipSpacingHorizontal != i11) {
            this.chipSpacingHorizontal = i11;
            setItemSpacing(i11);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i11) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i11));
    }

    public void setChipSpacingResource(int i11) {
        setChipSpacing(getResources().getDimensionPixelOffset(i11));
    }

    public void setChipSpacingVertical(int i11) {
        if (this.chipSpacingVertical != i11) {
            this.chipSpacingVertical = i11;
            setLineSpacing(i11);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i11) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i11));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i11) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener2) {
        this.onCheckedChangeListener = onCheckedChangeListener2;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.passThroughListener.onHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z11) {
        this.selectionRequired = z11;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i11) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i11) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(boolean z11) {
        super.setSingleLine(z11);
    }

    public void setSingleSelection(boolean z11) {
        if (this.singleSelection != z11) {
            this.singleSelection = z11;
            clearCheck();
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i11, boolean z11) {
        this.checkedId = i11;
        OnCheckedChangeListener onCheckedChangeListener2 = this.onCheckedChangeListener;
        if (onCheckedChangeListener2 != null && this.singleSelection && z11) {
            onCheckedChangeListener2.onCheckedChanged(this, i11);
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(int i11) {
        setSingleLine(getResources().getBoolean(i11));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChipGroup(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            com.google.android.material.chip.ChipGroup$CheckedStateTracker r8 = new com.google.android.material.chip.ChipGroup$CheckedStateTracker
            r0 = 0
            r8.<init>()
            r7.checkedStateTracker = r8
            com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener r8 = new com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener
            r8.<init>()
            r7.passThroughListener = r8
            r8 = -1
            r7.checkedId = r8
            r6 = 0
            r7.protectFromCheckedChange = r6
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.ChipGroup
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.ChipGroup_chipSpacing
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingHorizontal
            int r0 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingHorizontal(r0)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingVertical
            int r10 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingVertical(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_singleLine
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleLine((boolean) r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_singleSelection
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleSelection((boolean) r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_selectionRequired
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSelectionRequired(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_checkedChip
            int r10 = r9.getResourceId(r10, r8)
            if (r10 == r8) goto L_0x0069
            r7.checkedId = r10
        L_0x0069:
            r9.recycle()
            com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener r8 = r7.passThroughListener
            super.setOnHierarchyChangeListener(r8)
            r8 = 1
            androidx.core.view.h0.I0(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(int i11) {
        setSingleSelection(getResources().getBoolean(i11));
    }
}
