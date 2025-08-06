package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.i;
import androidx.core.widget.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FlexboxHelper {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_CAPACITY = 10;
    private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
    private boolean[] mChildrenFrozen;
    private final FlexContainer mFlexContainer;
    public int[] mIndexToFlexLine;
    public long[] mMeasureSpecCache;
    private long[] mMeasuredSizeCache;

    public static class FlexLinesResult {
        public int mChildState;
        public List<FlexLine> mFlexLines;

        public void reset() {
            this.mFlexLines = null;
            this.mChildState = 0;
        }
    }

    public static class Order implements Comparable<Order> {
        public int index;
        public int order;

        private Order() {
        }

        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + '}';
        }

        public int compareTo(Order order2) {
            int i11 = this.order;
            int i12 = order2.order;
            if (i11 != i12) {
                return i11 - i12;
            }
            return this.index - order2.index;
        }
    }

    public FlexboxHelper(FlexContainer flexContainer) {
        this.mFlexContainer = flexContainer;
    }

    private void addFlexLine(List<FlexLine> list, FlexLine flexLine, int i11, int i12) {
        flexLine.mSumCrossSizeBefore = i12;
        this.mFlexContainer.onNewFlexLineAdded(flexLine);
        flexLine.mLastIndex = i11;
        list.add(flexLine);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkSizeConstraints(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.getMinWidth()
            r4 = 1
            if (r1 >= r3) goto L_0x001b
            int r1 = r0.getMinWidth()
        L_0x0019:
            r3 = r4
            goto L_0x0027
        L_0x001b:
            int r3 = r0.getMaxWidth()
            if (r1 <= r3) goto L_0x0026
            int r1 = r0.getMaxWidth()
            goto L_0x0019
        L_0x0026:
            r3 = 0
        L_0x0027:
            int r5 = r0.getMinHeight()
            if (r2 >= r5) goto L_0x0032
            int r2 = r0.getMinHeight()
            goto L_0x003e
        L_0x0032:
            int r5 = r0.getMaxHeight()
            if (r2 <= r5) goto L_0x003d
            int r2 = r0.getMaxHeight()
            goto L_0x003e
        L_0x003d:
            r4 = r3
        L_0x003e:
            if (r4 == 0) goto L_0x0055
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.updateMeasureCache(r8, r1, r0, r7)
            com.google.android.flexbox.FlexContainer r0 = r6.mFlexContainer
            r0.updateViewCache(r8, r7)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxHelper.checkSizeConstraints(android.view.View, int):void");
    }

    private List<FlexLine> constructFlexLinesForAlignContentCenter(List<FlexLine> list, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.mCrossSize = (i11 - i12) / 2;
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            if (i13 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(list.get(i13));
            if (i13 == list.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    private List<Order> createOrders(int i11) {
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            Order order = new Order();
            order.order = ((FlexItem) this.mFlexContainer.getFlexItemAt(i12).getLayoutParams()).getOrder();
            order.index = i12;
            arrayList.add(order);
        }
        return arrayList;
    }

    private void ensureChildrenFrozen(int i11) {
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null) {
            this.mChildrenFrozen = new boolean[Math.max(i11, 10)];
        } else if (zArr.length < i11) {
            this.mChildrenFrozen = new boolean[Math.max(zArr.length * 2, i11)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void evaluateMinimumSizeForCompoundButton(CompoundButton compoundButton) {
        int i11;
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable a11 = d.a(compoundButton);
        int i12 = 0;
        if (a11 == null) {
            i11 = 0;
        } else {
            i11 = a11.getMinimumWidth();
        }
        if (a11 != null) {
            i12 = a11.getMinimumHeight();
        }
        if (minWidth == -1) {
            minWidth = i11;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = i12;
        }
        flexItem.setMinHeight(minHeight);
    }

    private void expandFlexItems(int i11, int i12, FlexLine flexLine, int i13, int i14, boolean z11) {
        int i15;
        int i16;
        int i17;
        double d11;
        int i18;
        double d12;
        FlexLine flexLine2 = flexLine;
        int i19 = i13;
        float f11 = flexLine2.mTotalFlexGrow;
        float f12 = 0.0f;
        if (f11 > 0.0f && i19 >= (i15 = flexLine2.mMainSize)) {
            float f13 = ((float) (i19 - i15)) / f11;
            flexLine2.mMainSize = i14 + flexLine2.mDividerLengthInMainSize;
            if (!z11) {
                flexLine2.mCrossSize = Integer.MIN_VALUE;
            }
            int i21 = 0;
            boolean z12 = false;
            int i22 = 0;
            float f14 = 0.0f;
            while (i21 < flexLine2.mItemCount) {
                int i23 = flexLine2.mFirstIndex + i21;
                View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i23);
                if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                    int i24 = i12;
                    i16 = i15;
                } else {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int flexDirection = this.mFlexContainer.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int i25 = i15;
                        int i26 = i11;
                        int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr = this.mMeasuredSizeCache;
                        if (jArr != null) {
                            measuredWidth = extractLowerInt(jArr[i23]);
                        }
                        int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr2 = this.mMeasuredSizeCache;
                        i16 = i25;
                        if (jArr2 != null) {
                            measuredHeight = extractHigherInt(jArr2[i23]);
                        }
                        if (this.mChildrenFrozen[i23] || flexItem.getFlexGrow() <= 0.0f) {
                            int i27 = i12;
                        } else {
                            float flexGrow = ((float) measuredWidth) + (flexItem.getFlexGrow() * f13);
                            if (i21 == flexLine2.mItemCount - 1) {
                                flexGrow += f14;
                                f14 = 0.0f;
                            }
                            int round = Math.round(flexGrow);
                            if (round > flexItem.getMaxWidth()) {
                                round = flexItem.getMaxWidth();
                                this.mChildrenFrozen[i23] = true;
                                flexLine2.mTotalFlexGrow -= flexItem.getFlexGrow();
                                z12 = true;
                            } else {
                                f14 += flexGrow - ((float) round);
                                double d13 = (double) f14;
                                if (d13 > 1.0d) {
                                    round++;
                                    d11 = d13 - 1.0d;
                                } else if (d13 < -1.0d) {
                                    round--;
                                    d11 = d13 + 1.0d;
                                }
                                f14 = (float) d11;
                            }
                            int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(i12, flexItem, flexLine2.mSumCrossSizeBefore);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            reorderedFlexItemAt.measure(makeMeasureSpec, childHeightMeasureSpecInternal);
                            int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                            updateMeasureCache(i23, makeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                            this.mFlexContainer.updateViewCache(i23, reorderedFlexItemAt);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        }
                        int max = Math.max(i22, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        flexLine2.mMainSize += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                        i17 = max;
                    } else {
                        int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr3 = this.mMeasuredSizeCache;
                        if (jArr3 != null) {
                            measuredHeight3 = extractHigherInt(jArr3[i23]);
                        }
                        int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr4 = this.mMeasuredSizeCache;
                        if (jArr4 != null) {
                            measuredWidth3 = extractLowerInt(jArr4[i23]);
                        }
                        if (this.mChildrenFrozen[i23] || flexItem.getFlexGrow() <= f12) {
                            i18 = i15;
                            int i28 = i11;
                        } else {
                            float flexGrow2 = ((float) measuredHeight3) + (flexItem.getFlexGrow() * f13);
                            if (i21 == flexLine2.mItemCount - 1) {
                                flexGrow2 += f14;
                                f14 = f12;
                            }
                            int round2 = Math.round(flexGrow2);
                            if (round2 > flexItem.getMaxHeight()) {
                                round2 = flexItem.getMaxHeight();
                                this.mChildrenFrozen[i23] = true;
                                flexLine2.mTotalFlexGrow -= flexItem.getFlexGrow();
                                i18 = i15;
                                z12 = true;
                            } else {
                                f14 += flexGrow2 - ((float) round2);
                                i18 = i15;
                                double d14 = (double) f14;
                                if (d14 > 1.0d) {
                                    round2++;
                                    d12 = d14 - 1.0d;
                                } else if (d14 < -1.0d) {
                                    round2--;
                                    d12 = d14 + 1.0d;
                                }
                                f14 = (float) d12;
                            }
                            int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(i11, flexItem, flexLine2.mSumCrossSizeBefore);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, makeMeasureSpec2);
                            measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                            updateMeasureCache(i23, childWidthMeasureSpecInternal, makeMeasureSpec2, reorderedFlexItemAt);
                            this.mFlexContainer.updateViewCache(i23, reorderedFlexItemAt);
                            measuredHeight3 = measuredHeight4;
                        }
                        i17 = Math.max(i22, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        flexLine2.mMainSize += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                        int i29 = i12;
                        i16 = i18;
                    }
                    flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, i17);
                    i22 = i17;
                }
                i21++;
                i15 = i16;
                f12 = 0.0f;
            }
            int i30 = i12;
            int i31 = i15;
            if (z12 && i31 != flexLine2.mMainSize) {
                expandFlexItems(i11, i12, flexLine, i13, i14, true);
            }
        }
    }

    private int getChildHeightMeasureSpecInternal(int i11, FlexItem flexItem, int i12) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(i11, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i12, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    private int getChildWidthMeasureSpecInternal(int i11, FlexItem flexItem, int i12) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(i11, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    private int getFlexItemMarginEndCross(FlexItem flexItem, boolean z11) {
        if (z11) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private int getFlexItemMarginEndMain(FlexItem flexItem, boolean z11) {
        if (z11) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int getFlexItemMarginStartCross(FlexItem flexItem, boolean z11) {
        if (z11) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int getFlexItemMarginStartMain(FlexItem flexItem, boolean z11) {
        if (z11) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int getFlexItemSizeCross(FlexItem flexItem, boolean z11) {
        if (z11) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int getFlexItemSizeMain(FlexItem flexItem, boolean z11) {
        if (z11) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int getPaddingEndCross(boolean z11) {
        if (z11) {
            return this.mFlexContainer.getPaddingBottom();
        }
        return this.mFlexContainer.getPaddingEnd();
    }

    private int getPaddingEndMain(boolean z11) {
        if (z11) {
            return this.mFlexContainer.getPaddingEnd();
        }
        return this.mFlexContainer.getPaddingBottom();
    }

    private int getPaddingStartCross(boolean z11) {
        if (z11) {
            return this.mFlexContainer.getPaddingTop();
        }
        return this.mFlexContainer.getPaddingStart();
    }

    private int getPaddingStartMain(boolean z11) {
        if (z11) {
            return this.mFlexContainer.getPaddingStart();
        }
        return this.mFlexContainer.getPaddingTop();
    }

    private int getViewMeasuredSizeCross(View view, boolean z11) {
        if (z11) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int getViewMeasuredSizeMain(View view, boolean z11) {
        if (z11) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean isLastFlexItem(int i11, int i12, FlexLine flexLine) {
        return i11 == i12 - 1 && flexLine.getItemCountNotGone() != 0;
    }

    private boolean isWrapRequired(View view, int i11, int i12, int i13, int i14, FlexItem flexItem, int i15, int i16, int i17) {
        if (this.mFlexContainer.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i11 == 0) {
            return false;
        }
        int maxLine = this.mFlexContainer.getMaxLine();
        if (maxLine != -1 && maxLine <= i17 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.mFlexContainer.getDecorationLengthMainAxis(view, i15, i16);
        if (decorationLengthMainAxis > 0) {
            i14 += decorationLengthMainAxis;
        }
        if (i12 < i13 + i14) {
            return true;
        }
        return false;
    }

    private void shrinkFlexItems(int i11, int i12, FlexLine flexLine, int i13, int i14, boolean z11) {
        int i15;
        int i16;
        int i17;
        int i18;
        FlexLine flexLine2 = flexLine;
        int i19 = i13;
        int i21 = flexLine2.mMainSize;
        float f11 = flexLine2.mTotalFlexShrink;
        float f12 = 0.0f;
        if (f11 > 0.0f && i19 <= i21) {
            float f13 = ((float) (i21 - i19)) / f11;
            flexLine2.mMainSize = i14 + flexLine2.mDividerLengthInMainSize;
            if (!z11) {
                flexLine2.mCrossSize = Integer.MIN_VALUE;
            }
            int i22 = 0;
            boolean z12 = false;
            int i23 = 0;
            float f14 = 0.0f;
            while (i22 < flexLine2.mItemCount) {
                int i24 = flexLine2.mFirstIndex + i22;
                View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i24);
                if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                    int i25 = i12;
                    i16 = i21;
                    i15 = i22;
                } else {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int flexDirection = this.mFlexContainer.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        i16 = i21;
                        int i26 = i22;
                        int i27 = i11;
                        int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr = this.mMeasuredSizeCache;
                        if (jArr != null) {
                            measuredWidth = extractLowerInt(jArr[i24]);
                        }
                        int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr2 = this.mMeasuredSizeCache;
                        int i28 = i26;
                        if (jArr2 != null) {
                            measuredHeight = extractHigherInt(jArr2[i24]);
                        }
                        if (this.mChildrenFrozen[i24] || flexItem.getFlexShrink() <= 0.0f) {
                            int i29 = i12;
                            i18 = i28;
                        } else {
                            float flexShrink = ((float) measuredWidth) - (flexItem.getFlexShrink() * f13);
                            i18 = i28;
                            if (i18 == flexLine2.mItemCount - 1) {
                                flexShrink += f14;
                                f14 = 0.0f;
                            }
                            int round = Math.round(flexShrink);
                            if (round < flexItem.getMinWidth()) {
                                round = flexItem.getMinWidth();
                                this.mChildrenFrozen[i24] = true;
                                flexLine2.mTotalFlexShrink -= flexItem.getFlexShrink();
                                z12 = true;
                            } else {
                                f14 += flexShrink - ((float) round);
                                double d11 = (double) f14;
                                if (d11 > 1.0d) {
                                    round++;
                                    f14 -= 1.0f;
                                } else if (d11 < -1.0d) {
                                    round--;
                                    f14 += 1.0f;
                                }
                            }
                            int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(i12, flexItem, flexLine2.mSumCrossSizeBefore);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                            reorderedFlexItemAt.measure(makeMeasureSpec, childHeightMeasureSpecInternal);
                            int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                            updateMeasureCache(i24, makeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                            this.mFlexContainer.updateViewCache(i24, reorderedFlexItemAt);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        }
                        int max = Math.max(i23, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        flexLine2.mMainSize += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                        i17 = max;
                    } else {
                        int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                        long[] jArr3 = this.mMeasuredSizeCache;
                        if (jArr3 != null) {
                            measuredHeight3 = extractHigherInt(jArr3[i24]);
                        }
                        int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        long[] jArr4 = this.mMeasuredSizeCache;
                        if (jArr4 != null) {
                            measuredWidth3 = extractLowerInt(jArr4[i24]);
                        }
                        if (this.mChildrenFrozen[i24] || flexItem.getFlexShrink() <= f12) {
                            i16 = i21;
                            i15 = i22;
                            int i30 = i11;
                        } else {
                            float flexShrink2 = ((float) measuredHeight3) - (flexItem.getFlexShrink() * f13);
                            if (i22 == flexLine2.mItemCount - 1) {
                                flexShrink2 += f14;
                                f14 = f12;
                            }
                            int round2 = Math.round(flexShrink2);
                            if (round2 < flexItem.getMinHeight()) {
                                round2 = flexItem.getMinHeight();
                                this.mChildrenFrozen[i24] = true;
                                flexLine2.mTotalFlexShrink -= flexItem.getFlexShrink();
                                i16 = i21;
                                i15 = i22;
                                z12 = true;
                            } else {
                                f14 += flexShrink2 - ((float) round2);
                                i16 = i21;
                                i15 = i22;
                                double d12 = (double) f14;
                                if (d12 > 1.0d) {
                                    round2++;
                                    f14 -= 1.0f;
                                } else if (d12 < -1.0d) {
                                    round2--;
                                    f14 += 1.0f;
                                }
                            }
                            int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(i11, flexItem, flexLine2.mSumCrossSizeBefore);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                            reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, makeMeasureSpec2);
                            measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                            int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                            updateMeasureCache(i24, childWidthMeasureSpecInternal, makeMeasureSpec2, reorderedFlexItemAt);
                            this.mFlexContainer.updateViewCache(i24, reorderedFlexItemAt);
                            measuredHeight3 = measuredHeight4;
                        }
                        i17 = Math.max(i23, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                        flexLine2.mMainSize += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                        int i31 = i12;
                    }
                    flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, i17);
                    i23 = i17;
                }
                i22 = i15 + 1;
                i21 = i16;
                f12 = 0.0f;
            }
            int i32 = i12;
            int i33 = i21;
            if (z12 && i33 != flexLine2.mMainSize) {
                shrinkFlexItems(i11, i12, flexLine, i13, i14, true);
            }
        }
    }

    private int[] sortOrdersIntoReorderedIndices(int i11, List<Order> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i11];
        int i12 = 0;
        for (Order next : list) {
            int i13 = next.index;
            iArr[i12] = i13;
            sparseIntArray.append(i13, next.order);
            i12++;
        }
        return iArr;
    }

    private void stretchViewHorizontally(View view, int i11, int i12) {
        int i13;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i11 - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            i13 = extractHigherInt(jArr[i12]);
        } else {
            i13 = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        updateMeasureCache(i12, makeMeasureSpec2, makeMeasureSpec, view);
        this.mFlexContainer.updateViewCache(i12, view);
    }

    private void stretchViewVertically(View view, int i11, int i12) {
        int i13;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i11 - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            i13 = extractLowerInt(jArr[i12]);
        } else {
            i13 = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        updateMeasureCache(i12, makeMeasureSpec, makeMeasureSpec2, view);
        this.mFlexContainer.updateViewCache(i12, view);
    }

    private void updateMeasureCache(int i11, int i12, int i13, View view) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr != null) {
            jArr[i11] = makeCombinedLong(i12, i13);
        }
        long[] jArr2 = this.mMeasuredSizeCache;
        if (jArr2 != null) {
            jArr2[i11] = makeCombinedLong(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public void calculateFlexLines(FlexLinesResult flexLinesResult, int i11, int i12, int i13, int i14, int i15, List<FlexLine> list) {
        int i16;
        int i17;
        FlexLinesResult flexLinesResult2;
        int i18;
        int i19;
        List<FlexLine> list2;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        View view;
        int i27;
        int i28;
        FlexLinesResult flexLinesResult3 = flexLinesResult;
        int i29 = i11;
        int i30 = i12;
        int i31 = i15;
        boolean isMainAxisDirectionHorizontal = this.mFlexContainer.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        ArrayList arrayList = list == null ? new ArrayList() : list;
        flexLinesResult3.mFlexLines = arrayList;
        boolean z11 = i31 == -1;
        int paddingStartMain = getPaddingStartMain(isMainAxisDirectionHorizontal);
        int paddingEndMain = getPaddingEndMain(isMainAxisDirectionHorizontal);
        int paddingStartCross = getPaddingStartCross(isMainAxisDirectionHorizontal);
        int paddingEndCross = getPaddingEndCross(isMainAxisDirectionHorizontal);
        FlexLine flexLine = new FlexLine();
        int i32 = i14;
        flexLine.mFirstIndex = i32;
        int i33 = paddingEndMain + paddingStartMain;
        flexLine.mMainSize = i33;
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        boolean z12 = z11;
        int i34 = Integer.MIN_VALUE;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        while (true) {
            if (i16 >= flexItemCount) {
                i17 = i36;
                flexLinesResult2 = flexLinesResult;
                break;
            }
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i16);
            if (reorderedFlexItemAt == null) {
                if (isLastFlexItem(i16, flexItemCount, flexLine)) {
                    addFlexLine(arrayList, flexLine, i16, i35);
                }
            } else if (reorderedFlexItemAt.getVisibility() == 8) {
                flexLine.mGoneItemCount++;
                flexLine.mItemCount++;
                if (isLastFlexItem(i16, flexItemCount, flexLine)) {
                    addFlexLine(arrayList, flexLine, i16, i35);
                }
            } else {
                if (reorderedFlexItemAt instanceof CompoundButton) {
                    evaluateMinimumSizeForCompoundButton((CompoundButton) reorderedFlexItemAt);
                }
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int i38 = flexItemCount;
                if (flexItem.getAlignSelf() == 4) {
                    flexLine.mIndicesAlignSelfStretch.add(Integer.valueOf(i16));
                }
                int flexItemSizeMain = getFlexItemSizeMain(flexItem, isMainAxisDirectionHorizontal);
                if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                    flexItemSizeMain = Math.round(((float) size) * flexItem.getFlexBasisPercent());
                }
                if (isMainAxisDirectionHorizontal) {
                    int childWidthMeasureSpec = this.mFlexContainer.getChildWidthMeasureSpec(i29, i33 + getFlexItemMarginStartMain(flexItem, true) + getFlexItemMarginEndMain(flexItem, true), flexItemSizeMain);
                    i19 = size;
                    i18 = mode;
                    int childHeightMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(i30, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, true) + getFlexItemMarginEndCross(flexItem, true) + i35, getFlexItemSizeCross(flexItem, true));
                    reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    updateMeasureCache(i16, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                    i25 = childWidthMeasureSpec;
                } else {
                    i19 = size;
                    i18 = mode;
                    int childWidthMeasureSpec2 = this.mFlexContainer.getChildWidthMeasureSpec(i30, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, false) + getFlexItemMarginEndCross(flexItem, false) + i35, getFlexItemSizeCross(flexItem, false));
                    int childHeightMeasureSpec2 = this.mFlexContainer.getChildHeightMeasureSpec(i29, getFlexItemMarginStartMain(flexItem, false) + i33 + getFlexItemMarginEndMain(flexItem, false), flexItemSizeMain);
                    reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                    updateMeasureCache(i16, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                    i25 = childHeightMeasureSpec2;
                }
                this.mFlexContainer.updateViewCache(i16, reorderedFlexItemAt);
                checkSizeConstraints(reorderedFlexItemAt, i16);
                i36 = View.combineMeasuredStates(i36, reorderedFlexItemAt.getMeasuredState());
                int i39 = i35;
                int i40 = i38;
                FlexLine flexLine2 = flexLine;
                int i41 = i33;
                int i42 = i16;
                View view2 = reorderedFlexItemAt;
                list2 = arrayList;
                int i43 = i42;
                int i44 = i25;
                if (isWrapRequired(reorderedFlexItemAt, i18, i19, flexLine.mMainSize, getFlexItemMarginEndMain(flexItem, isMainAxisDirectionHorizontal) + getViewMeasuredSizeMain(reorderedFlexItemAt, isMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, isMainAxisDirectionHorizontal), flexItem, i42, i37, arrayList.size())) {
                    if (flexLine2.getItemCountNotGone() > 0) {
                        FlexLine flexLine3 = flexLine2;
                        addFlexLine(list2, flexLine3, i43 > 0 ? i43 - 1 : 0, i39);
                        i35 = flexLine3.mCrossSize + i39;
                    } else {
                        i35 = i39;
                    }
                    if (!isMainAxisDirectionHorizontal) {
                        i23 = i12;
                        view = view2;
                        i16 = i43;
                        int i45 = i44;
                        if (flexItem.getWidth() == -1) {
                            FlexContainer flexContainer = this.mFlexContainer;
                            view.measure(flexContainer.getChildWidthMeasureSpec(i23, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i35, flexItem.getWidth()), i45);
                            checkSizeConstraints(view, i16);
                        }
                    } else if (flexItem.getHeight() == -1) {
                        FlexContainer flexContainer2 = this.mFlexContainer;
                        i23 = i12;
                        i16 = i43;
                        view = view2;
                        view.measure(i44, flexContainer2.getChildHeightMeasureSpec(i23, flexContainer2.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i35, flexItem.getHeight()));
                        checkSizeConstraints(view, i16);
                    } else {
                        i23 = i12;
                        view = view2;
                        i16 = i43;
                    }
                    flexLine = new FlexLine();
                    flexLine.mItemCount = 1;
                    i22 = i41;
                    flexLine.mMainSize = i22;
                    flexLine.mFirstIndex = i16;
                    i26 = Integer.MIN_VALUE;
                    i27 = 0;
                } else {
                    i23 = i12;
                    view = view2;
                    i16 = i43;
                    flexLine = flexLine2;
                    i22 = i41;
                    flexLine.mItemCount++;
                    i27 = i37 + 1;
                    i35 = i39;
                    i26 = i34;
                }
                flexLine.mAnyItemsHaveFlexGrow |= flexItem.getFlexGrow() != 0.0f;
                flexLine.mAnyItemsHaveFlexShrink |= flexItem.getFlexShrink() != 0.0f;
                int[] iArr = this.mIndexToFlexLine;
                if (iArr != null) {
                    iArr[i16] = list2.size();
                }
                flexLine.mMainSize += getViewMeasuredSizeMain(view, isMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, isMainAxisDirectionHorizontal) + getFlexItemMarginEndMain(flexItem, isMainAxisDirectionHorizontal);
                flexLine.mTotalFlexGrow += flexItem.getFlexGrow();
                flexLine.mTotalFlexShrink += flexItem.getFlexShrink();
                this.mFlexContainer.onNewFlexItemAdded(view, i16, i27, flexLine);
                int max = Math.max(i26, getViewMeasuredSizeCross(view, isMainAxisDirectionHorizontal) + getFlexItemMarginStartCross(flexItem, isMainAxisDirectionHorizontal) + getFlexItemMarginEndCross(flexItem, isMainAxisDirectionHorizontal) + this.mFlexContainer.getDecorationLengthCrossAxis(view));
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, max);
                if (isMainAxisDirectionHorizontal) {
                    if (this.mFlexContainer.getFlexWrap() != 2) {
                        flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, view.getBaseline() + flexItem.getMarginTop());
                    } else {
                        flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                    }
                }
                i24 = i38;
                if (isLastFlexItem(i16, i24, flexLine)) {
                    addFlexLine(list2, flexLine, i16, i35);
                    i35 += flexLine.mCrossSize;
                }
                i21 = i15;
                if (i21 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).mLastIndex >= i21 && i16 >= i21 && !z12) {
                        i35 = -flexLine.getCrossSize();
                        i28 = i13;
                        z12 = true;
                        if (i35 <= i28 && z12) {
                            flexLinesResult2 = flexLinesResult;
                            i17 = i36;
                            break;
                        }
                        i37 = i27;
                        i34 = max;
                        i32 = i16 + 1;
                        FlexLinesResult flexLinesResult4 = flexLinesResult;
                        i29 = i11;
                        flexItemCount = i24;
                        i30 = i23;
                        i33 = i22;
                        arrayList = list2;
                        mode = i18;
                        i31 = i21;
                        size = i19;
                    }
                }
                i28 = i13;
                if (i35 <= i28) {
                }
                i37 = i27;
                i34 = max;
                i32 = i16 + 1;
                FlexLinesResult flexLinesResult42 = flexLinesResult;
                i29 = i11;
                flexItemCount = i24;
                i30 = i23;
                i33 = i22;
                arrayList = list2;
                mode = i18;
                i31 = i21;
                size = i19;
            }
            int i46 = i13;
            i19 = size;
            i18 = mode;
            i23 = i30;
            i21 = i31;
            list2 = arrayList;
            i22 = i33;
            i24 = flexItemCount;
            i32 = i16 + 1;
            FlexLinesResult flexLinesResult422 = flexLinesResult;
            i29 = i11;
            flexItemCount = i24;
            i30 = i23;
            i33 = i22;
            arrayList = list2;
            mode = i18;
            i31 = i21;
            size = i19;
        }
        flexLinesResult2.mChildState = i17;
    }

    public void calculateHorizontalFlexLines(FlexLinesResult flexLinesResult, int i11, int i12) {
        calculateFlexLines(flexLinesResult, i11, i12, Integer.MAX_VALUE, 0, -1, (List<FlexLine>) null);
    }

    public void calculateHorizontalFlexLinesToIndex(FlexLinesResult flexLinesResult, int i11, int i12, int i13, int i14, List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i11, i12, i13, 0, i14, list);
    }

    public void calculateVerticalFlexLines(FlexLinesResult flexLinesResult, int i11, int i12) {
        calculateFlexLines(flexLinesResult, i12, i11, Integer.MAX_VALUE, 0, -1, (List<FlexLine>) null);
    }

    public void calculateVerticalFlexLinesToIndex(FlexLinesResult flexLinesResult, int i11, int i12, int i13, int i14, List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i12, i11, i13, 0, i14, list);
    }

    public void clearFlexLines(List<FlexLine> list, int i11) {
        int i12 = this.mIndexToFlexLine[i11];
        if (i12 == -1) {
            i12 = 0;
        }
        if (list.size() > i12) {
            list.subList(i12, list.size()).clear();
        }
        int[] iArr = this.mIndexToFlexLine;
        int length = iArr.length - 1;
        if (i11 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i11, length, -1);
        }
        long[] jArr = this.mMeasureSpecCache;
        int length2 = jArr.length - 1;
        if (i11 > length2) {
            Arrays.fill(jArr, 0);
        } else {
            Arrays.fill(jArr, i11, length2, 0);
        }
    }

    public int[] createReorderedIndices(View view, int i11, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        List<Order> createOrders = createOrders(flexItemCount);
        Order order = new Order();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            order.order = 1;
        } else {
            order.order = ((FlexItem) layoutParams).getOrder();
        }
        if (i11 == -1 || i11 == flexItemCount) {
            order.index = flexItemCount;
        } else if (i11 < this.mFlexContainer.getFlexItemCount()) {
            order.index = i11;
            while (i11 < flexItemCount) {
                createOrders.get(i11).index++;
                i11++;
            }
        } else {
            order.index = flexItemCount;
        }
        createOrders.add(order);
        return sortOrdersIntoReorderedIndices(flexItemCount + 1, createOrders, sparseIntArray);
    }

    public void determineCrossSize(int i11, int i12, int i13) {
        int i14;
        int i15;
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i12);
            int size = View.MeasureSpec.getSize(i12);
            i14 = mode;
            i15 = size;
        } else if (flexDirection == 2 || flexDirection == 3) {
            i14 = View.MeasureSpec.getMode(i11);
            i15 = View.MeasureSpec.getSize(i11);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        if (i14 == 1073741824) {
            int sumOfCrossSize = this.mFlexContainer.getSumOfCrossSize() + i13;
            int i16 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mCrossSize = i15 - i13;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.mFlexContainer.getAlignContent();
                if (alignContent == 1) {
                    int i17 = i15 - sumOfCrossSize;
                    FlexLine flexLine = new FlexLine();
                    flexLine.mCrossSize = i17;
                    flexLinesInternal.add(0, flexLine);
                } else if (alignContent == 2) {
                    this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, i15, sumOfCrossSize));
                } else if (alignContent != 3) {
                    if (alignContent != 4) {
                        if (alignContent == 5 && sumOfCrossSize < i15) {
                            float size2 = ((float) (i15 - sumOfCrossSize)) / ((float) flexLinesInternal.size());
                            int size3 = flexLinesInternal.size();
                            float f11 = 0.0f;
                            while (i16 < size3) {
                                FlexLine flexLine2 = flexLinesInternal.get(i16);
                                float f12 = ((float) flexLine2.mCrossSize) + size2;
                                if (i16 == flexLinesInternal.size() - 1) {
                                    f12 += f11;
                                    f11 = 0.0f;
                                }
                                int round = Math.round(f12);
                                f11 += f12 - ((float) round);
                                if (f11 > 1.0f) {
                                    round++;
                                    f11 -= 1.0f;
                                } else if (f11 < -1.0f) {
                                    round--;
                                    f11 += 1.0f;
                                }
                                flexLine2.mCrossSize = round;
                                i16++;
                            }
                        }
                    } else if (sumOfCrossSize >= i15) {
                        this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, i15, sumOfCrossSize));
                    } else {
                        int size4 = (i15 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList = new ArrayList();
                        FlexLine flexLine3 = new FlexLine();
                        flexLine3.mCrossSize = size4;
                        for (FlexLine add : flexLinesInternal) {
                            arrayList.add(flexLine3);
                            arrayList.add(add);
                            arrayList.add(flexLine3);
                        }
                        this.mFlexContainer.setFlexLines(arrayList);
                    }
                } else if (sumOfCrossSize < i15) {
                    float size5 = ((float) (i15 - sumOfCrossSize)) / ((float) (flexLinesInternal.size() - 1));
                    ArrayList arrayList2 = new ArrayList();
                    int size6 = flexLinesInternal.size();
                    float f13 = 0.0f;
                    while (i16 < size6) {
                        arrayList2.add(flexLinesInternal.get(i16));
                        if (i16 != flexLinesInternal.size() - 1) {
                            FlexLine flexLine4 = new FlexLine();
                            if (i16 == flexLinesInternal.size() - 2) {
                                flexLine4.mCrossSize = Math.round(f13 + size5);
                                f13 = 0.0f;
                            } else {
                                flexLine4.mCrossSize = Math.round(size5);
                            }
                            int i18 = flexLine4.mCrossSize;
                            f13 += size5 - ((float) i18);
                            if (f13 > 1.0f) {
                                flexLine4.mCrossSize = i18 + 1;
                                f13 -= 1.0f;
                            } else if (f13 < -1.0f) {
                                flexLine4.mCrossSize = i18 - 1;
                                f13 += 1.0f;
                            }
                            arrayList2.add(flexLine4);
                        }
                        i16++;
                    }
                    this.mFlexContainer.setFlexLines(arrayList2);
                }
            }
        }
    }

    public void determineMainSize(int i11, int i12) {
        determineMainSize(i11, i12, 0);
    }

    public void ensureIndexToFlexLine(int i11) {
        int[] iArr = this.mIndexToFlexLine;
        if (iArr == null) {
            this.mIndexToFlexLine = new int[Math.max(i11, 10)];
        } else if (iArr.length < i11) {
            this.mIndexToFlexLine = Arrays.copyOf(this.mIndexToFlexLine, Math.max(iArr.length * 2, i11));
        }
    }

    public void ensureMeasureSpecCache(int i11) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr == null) {
            this.mMeasureSpecCache = new long[Math.max(i11, 10)];
        } else if (jArr.length < i11) {
            this.mMeasureSpecCache = Arrays.copyOf(this.mMeasureSpecCache, Math.max(jArr.length * 2, i11));
        }
    }

    public void ensureMeasuredSizeCache(int i11) {
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr == null) {
            this.mMeasuredSizeCache = new long[Math.max(i11, 10)];
        } else if (jArr.length < i11) {
            this.mMeasuredSizeCache = Arrays.copyOf(this.mMeasuredSizeCache, Math.max(jArr.length * 2, i11));
        }
    }

    public int extractHigherInt(long j11) {
        return (int) (j11 >> 32);
    }

    public int extractLowerInt(long j11) {
        return (int) j11;
    }

    public boolean isOrderChangedFromLastMeasurement(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i11 = 0; i11 < flexItemCount; i11++) {
            View flexItemAt = this.mFlexContainer.getFlexItemAt(i11);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i11)) {
                return true;
            }
        }
        return false;
    }

    public void layoutSingleChildHorizontal(View view, FlexLine flexLine, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i15 = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    int measuredHeight = (((i15 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                    if (this.mFlexContainer.getFlexWrap() != 2) {
                        int i16 = i12 + measuredHeight;
                        view.layout(i11, i16, i13, view.getMeasuredHeight() + i16);
                        return;
                    }
                    int i17 = i12 - measuredHeight;
                    view.layout(i11, i17, i13, view.getMeasuredHeight() + i17);
                    return;
                } else if (alignItems != 3) {
                    if (alignItems != 4) {
                        return;
                    }
                } else if (this.mFlexContainer.getFlexWrap() != 2) {
                    int max = Math.max(flexLine.mMaxBaseline - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i11, i12 + max, i13, i14 + max);
                    return;
                } else {
                    int max2 = Math.max((flexLine.mMaxBaseline - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(i11, i12 - max2, i13, i14 - max2);
                    return;
                }
            } else if (this.mFlexContainer.getFlexWrap() != 2) {
                int i18 = i12 + i15;
                view.layout(i11, (i18 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i13, i18 - flexItem.getMarginBottom());
                return;
            } else {
                view.layout(i11, (i12 - i15) + view.getMeasuredHeight() + flexItem.getMarginTop(), i13, (i14 - i15) + view.getMeasuredHeight() + flexItem.getMarginTop());
                return;
            }
        }
        if (this.mFlexContainer.getFlexWrap() != 2) {
            view.layout(i11, i12 + flexItem.getMarginTop(), i13, i14 + flexItem.getMarginTop());
        } else {
            view.layout(i11, i12 - flexItem.getMarginBottom(), i13, i14 - flexItem.getMarginBottom());
        }
    }

    public void layoutSingleChildVertical(View view, FlexLine flexLine, boolean z11, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i15 = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i15 - view.getMeasuredWidth()) + i.b(marginLayoutParams)) - i.a(marginLayoutParams)) / 2;
                    if (!z11) {
                        view.layout(i11 + measuredWidth, i12, i13 + measuredWidth, i14);
                        return;
                    } else {
                        view.layout(i11 - measuredWidth, i12, i13 - measuredWidth, i14);
                        return;
                    }
                } else if (!(alignItems == 3 || alignItems == 4)) {
                    return;
                }
            } else if (!z11) {
                view.layout(((i11 + i15) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i12, ((i13 + i15) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i14);
                return;
            } else {
                view.layout((i11 - i15) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i12, (i13 - i15) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i14);
                return;
            }
        }
        if (!z11) {
            view.layout(i11 + flexItem.getMarginLeft(), i12, i13 + flexItem.getMarginLeft(), i14);
        } else {
            view.layout(i11 - flexItem.getMarginRight(), i12, i13 - flexItem.getMarginRight(), i14);
        }
    }

    public long makeCombinedLong(int i11, int i12) {
        return (((long) i11) & 4294967295L) | (((long) i12) << 32);
    }

    public void stretchViews() {
        stretchViews(0);
    }

    public void calculateHorizontalFlexLines(FlexLinesResult flexLinesResult, int i11, int i12, int i13, int i14, List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i11, i12, i13, i14, -1, list);
    }

    public void calculateVerticalFlexLines(FlexLinesResult flexLinesResult, int i11, int i12, int i13, int i14, List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i12, i11, i13, i14, -1, list);
    }

    public void determineMainSize(int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
        if (i13 < this.mFlexContainer.getFlexItemCount()) {
            int flexDirection = this.mFlexContainer.getFlexDirection();
            int flexDirection2 = this.mFlexContainer.getFlexDirection();
            if (flexDirection2 == 0 || flexDirection2 == 1) {
                int mode = View.MeasureSpec.getMode(i11);
                int size = View.MeasureSpec.getSize(i11);
                int largestMainSize = this.mFlexContainer.getLargestMainSize();
                if (mode != 1073741824) {
                    size = Math.min(largestMainSize, size);
                }
                i16 = this.mFlexContainer.getPaddingLeft();
                i14 = this.mFlexContainer.getPaddingRight();
            } else if (flexDirection2 == 2 || flexDirection2 == 3) {
                int mode2 = View.MeasureSpec.getMode(i12);
                i15 = View.MeasureSpec.getSize(i12);
                if (mode2 != 1073741824) {
                    i15 = this.mFlexContainer.getLargestMainSize();
                }
                i16 = this.mFlexContainer.getPaddingTop();
                i14 = this.mFlexContainer.getPaddingBottom();
            } else {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int i17 = i16 + i14;
            int i18 = 0;
            int[] iArr = this.mIndexToFlexLine;
            if (iArr != null) {
                i18 = iArr[i13];
            }
            List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
            int size2 = flexLinesInternal.size();
            for (int i19 = i18; i19 < size2; i19++) {
                FlexLine flexLine = flexLinesInternal.get(i19);
                int i21 = flexLine.mMainSize;
                if (i21 < i15 && flexLine.mAnyItemsHaveFlexGrow) {
                    expandFlexItems(i11, i12, flexLine, i15, i17, false);
                } else if (i21 > i15 && flexLine.mAnyItemsHaveFlexShrink) {
                    shrinkFlexItems(i11, i12, flexLine, i15, i17, false);
                }
            }
        }
    }

    public void stretchViews(int i11) {
        View reorderedFlexItemAt;
        int i12 = i11;
        if (i12 < this.mFlexContainer.getFlexItemCount()) {
            int flexDirection = this.mFlexContainer.getFlexDirection();
            if (this.mFlexContainer.getAlignItems() == 4) {
                int[] iArr = this.mIndexToFlexLine;
                List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i13 = iArr != null ? iArr[i12] : 0; i13 < size; i13++) {
                    FlexLine flexLine = flexLinesInternal.get(i13);
                    int i14 = flexLine.mItemCount;
                    for (int i15 = 0; i15 < i14; i15++) {
                        int i16 = flexLine.mFirstIndex + i15;
                        if (!(i15 >= this.mFlexContainer.getFlexItemCount() || (reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i16)) == null || reorderedFlexItemAt.getVisibility() == 8)) {
                            FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                            if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                                if (flexDirection == 0 || flexDirection == 1) {
                                    stretchViewVertically(reorderedFlexItemAt, flexLine.mCrossSize, i16);
                                } else if (flexDirection == 2 || flexDirection == 3) {
                                    stretchViewHorizontally(reorderedFlexItemAt, flexLine.mCrossSize, i16);
                                } else {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                            }
                        }
                    }
                }
                return;
            }
            for (FlexLine next : this.mFlexContainer.getFlexLinesInternal()) {
                Iterator<Integer> it2 = next.mIndicesAlignSelfStretch.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Integer next2 = it2.next();
                        View reorderedFlexItemAt2 = this.mFlexContainer.getReorderedFlexItemAt(next2.intValue());
                        if (flexDirection == 0 || flexDirection == 1) {
                            stretchViewVertically(reorderedFlexItemAt2, next.mCrossSize, next2.intValue());
                        } else if (flexDirection == 2 || flexDirection == 3) {
                            stretchViewHorizontally(reorderedFlexItemAt2, next.mCrossSize, next2.intValue());
                        } else {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                    }
                }
            }
        }
    }

    public int[] createReorderedIndices(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        return sortOrdersIntoReorderedIndices(flexItemCount, createOrders(flexItemCount), sparseIntArray);
    }
}
