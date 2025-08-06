package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.h0;
import com.google.android.flexbox.FlexboxHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayout extends ViewGroup implements FlexContainer {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;
    private Drawable mDividerDrawableHorizontal;
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private FlexboxHelper mFlexboxHelper;
    private int mJustifyContent;
    private int mMaxLine;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public FlexboxLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean allFlexLinesAreDummyBefore(int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.mFlexLines.get(i12).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean allViewsAreGoneBefore(int i11, int i12) {
        for (int i13 = 1; i13 <= i12; i13++) {
            View reorderedChildAt = getReorderedChildAt(i11 - i13);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void drawDividersHorizontal(Canvas canvas, boolean z11, boolean z12) {
        int i11;
        int i12;
        int i13;
        int i14;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mFlexLines.size();
        for (int i15 = 0; i15 < size; i15++) {
            FlexLine flexLine = this.mFlexLines.get(i15);
            for (int i16 = 0; i16 < flexLine.mItemCount; i16++) {
                int i17 = flexLine.mFirstIndex + i16;
                View reorderedChildAt = getReorderedChildAt(i17);
                if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i17, i16)) {
                        if (z11) {
                            i14 = reorderedChildAt.getRight() + layoutParams.rightMargin;
                        } else {
                            i14 = (reorderedChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerVerticalWidth;
                        }
                        drawVerticalDivider(canvas, i14, flexLine.mTop, flexLine.mCrossSize);
                    }
                    if (i16 == flexLine.mItemCount - 1 && (this.mShowDividerVertical & 4) > 0) {
                        if (z11) {
                            i13 = (reorderedChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerVerticalWidth;
                        } else {
                            i13 = reorderedChildAt.getRight() + layoutParams.rightMargin;
                        }
                        drawVerticalDivider(canvas, i13, flexLine.mTop, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i15)) {
                if (z12) {
                    i12 = flexLine.mBottom;
                } else {
                    i12 = flexLine.mTop - this.mDividerHorizontalHeight;
                }
                drawHorizontalDivider(canvas, paddingLeft, i12, max);
            }
            if (hasEndDividerAfterFlexLine(i15) && (this.mShowDividerHorizontal & 4) > 0) {
                if (z12) {
                    i11 = flexLine.mTop - this.mDividerHorizontalHeight;
                } else {
                    i11 = flexLine.mBottom;
                }
                drawHorizontalDivider(canvas, paddingLeft, i11, max);
            }
        }
    }

    private void drawDividersVertical(Canvas canvas, boolean z11, boolean z12) {
        int i11;
        int i12;
        int i13;
        int i14;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mFlexLines.size();
        for (int i15 = 0; i15 < size; i15++) {
            FlexLine flexLine = this.mFlexLines.get(i15);
            for (int i16 = 0; i16 < flexLine.mItemCount; i16++) {
                int i17 = flexLine.mFirstIndex + i16;
                View reorderedChildAt = getReorderedChildAt(i17);
                if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i17, i16)) {
                        if (z12) {
                            i14 = reorderedChildAt.getBottom() + layoutParams.bottomMargin;
                        } else {
                            i14 = (reorderedChildAt.getTop() - layoutParams.topMargin) - this.mDividerHorizontalHeight;
                        }
                        drawHorizontalDivider(canvas, flexLine.mLeft, i14, flexLine.mCrossSize);
                    }
                    if (i16 == flexLine.mItemCount - 1 && (this.mShowDividerHorizontal & 4) > 0) {
                        if (z12) {
                            i13 = (reorderedChildAt.getTop() - layoutParams.topMargin) - this.mDividerHorizontalHeight;
                        } else {
                            i13 = reorderedChildAt.getBottom() + layoutParams.bottomMargin;
                        }
                        drawHorizontalDivider(canvas, flexLine.mLeft, i13, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i15)) {
                if (z11) {
                    i12 = flexLine.mRight;
                } else {
                    i12 = flexLine.mLeft - this.mDividerVerticalWidth;
                }
                drawVerticalDivider(canvas, i12, paddingTop, max);
            }
            if (hasEndDividerAfterFlexLine(i15) && (this.mShowDividerVertical & 4) > 0) {
                if (z11) {
                    i11 = flexLine.mLeft - this.mDividerVerticalWidth;
                } else {
                    i11 = flexLine.mRight;
                }
                drawVerticalDivider(canvas, i11, paddingTop, max);
            }
        }
    }

    private void drawHorizontalDivider(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.mDividerDrawableHorizontal;
        if (drawable != null) {
            drawable.setBounds(i11, i12, i13 + i11, this.mDividerHorizontalHeight + i12);
            this.mDividerDrawableHorizontal.draw(canvas);
        }
    }

    private void drawVerticalDivider(Canvas canvas, int i11, int i12, int i13) {
        Drawable drawable = this.mDividerDrawableVertical;
        if (drawable != null) {
            drawable.setBounds(i11, i12, this.mDividerVerticalWidth + i11, i13 + i12);
            this.mDividerDrawableVertical.draw(canvas);
        }
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int i11, int i12) {
        if (allViewsAreGoneBefore(i11, i12)) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerVertical & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.mShowDividerHorizontal & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerHorizontal & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hasDividerBeforeFlexLine(int i11) {
        if (i11 < 0 || i11 >= this.mFlexLines.size()) {
            return false;
        }
        if (allFlexLinesAreDummyBefore(i11)) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerHorizontal & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.mShowDividerVertical & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerHorizontal & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerVertical & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hasEndDividerAfterFlexLine(int i11) {
        if (i11 < 0 || i11 >= this.mFlexLines.size()) {
            return false;
        }
        for (int i12 = i11 + 1; i12 < this.mFlexLines.size(); i12++) {
            if (this.mFlexLines.get(i12).getItemCountNotGone() > 0) {
                return false;
            }
        }
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerHorizontal & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerVertical & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void layoutHorizontal(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            r28 = this;
            r0 = r28
            int r1 = r28.getPaddingLeft()
            int r2 = r28.getPaddingRight()
            int r3 = r33 - r31
            int r4 = r32 - r30
            int r5 = r28.getPaddingBottom()
            int r3 = r3 - r5
            int r5 = r28.getPaddingTop()
            java.util.List<com.google.android.flexbox.FlexLine> r6 = r0.mFlexLines
            int r6 = r6.size()
            r8 = 0
        L_0x001e:
            if (r8 >= r6) goto L_0x022c
            java.util.List<com.google.android.flexbox.FlexLine> r9 = r0.mFlexLines
            java.lang.Object r9 = r9.get(r8)
            com.google.android.flexbox.FlexLine r9 = (com.google.android.flexbox.FlexLine) r9
            boolean r10 = r0.hasDividerBeforeFlexLine(r8)
            if (r10 == 0) goto L_0x0032
            int r10 = r0.mDividerHorizontalHeight
            int r3 = r3 - r10
            int r5 = r5 + r10
        L_0x0032:
            int r10 = r0.mJustifyContent
            r15 = 4
            r14 = 2
            r11 = 0
            r13 = 1
            if (r10 == 0) goto L_0x00c7
            if (r10 == r13) goto L_0x00bd
            r12 = 1073741824(0x40000000, float:2.0)
            if (r10 == r14) goto L_0x00ab
            r7 = 3
            if (r10 == r7) goto L_0x0093
            if (r10 == r15) goto L_0x007a
            r7 = 5
            if (r10 != r7) goto L_0x0061
            int r7 = r9.getItemCountNotGone()
            if (r7 == 0) goto L_0x0058
            int r10 = r9.mMainSize
            int r10 = r4 - r10
            float r10 = (float) r10
            int r7 = r7 + 1
            float r7 = (float) r7
            float r10 = r10 / r7
            goto L_0x0059
        L_0x0058:
            r10 = r11
        L_0x0059:
            float r7 = (float) r1
            float r7 = r7 + r10
            int r12 = r4 - r2
            float r12 = (float) r12
            float r12 = r12 - r10
            goto L_0x00cc
        L_0x0061:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.append(r3)
            int r3 = r0.mJustifyContent
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x007a:
            int r7 = r9.getItemCountNotGone()
            if (r7 == 0) goto L_0x0088
            int r10 = r9.mMainSize
            int r10 = r4 - r10
            float r10 = (float) r10
            float r7 = (float) r7
            float r10 = r10 / r7
            goto L_0x0089
        L_0x0088:
            r10 = r11
        L_0x0089:
            float r7 = (float) r1
            float r12 = r10 / r12
            float r7 = r7 + r12
            int r14 = r4 - r2
            float r14 = (float) r14
            float r12 = r14 - r12
            goto L_0x00cc
        L_0x0093:
            float r7 = (float) r1
            int r10 = r9.getItemCountNotGone()
            if (r10 == r13) goto L_0x009e
            int r10 = r10 + -1
            float r10 = (float) r10
            goto L_0x00a0
        L_0x009e:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x00a0:
            int r12 = r9.mMainSize
            int r12 = r4 - r12
            float r12 = (float) r12
            float r10 = r12 / r10
            int r12 = r4 - r2
            float r12 = (float) r12
            goto L_0x00cc
        L_0x00ab:
            float r7 = (float) r1
            int r10 = r9.mMainSize
            int r14 = r4 - r10
            float r14 = (float) r14
            float r14 = r14 / r12
            float r7 = r7 + r14
            int r14 = r4 - r2
            float r14 = (float) r14
            int r10 = r4 - r10
            float r10 = (float) r10
            float r10 = r10 / r12
            float r12 = r14 - r10
            goto L_0x00cb
        L_0x00bd:
            int r7 = r9.mMainSize
            int r10 = r4 - r7
            int r10 = r10 + r2
            float r10 = (float) r10
            int r7 = r7 - r1
            float r12 = (float) r7
            r7 = r10
            goto L_0x00cb
        L_0x00c7:
            float r7 = (float) r1
            int r10 = r4 - r2
            float r12 = (float) r10
        L_0x00cb:
            r10 = r11
        L_0x00cc:
            float r17 = java.lang.Math.max(r10, r11)
            r14 = 0
        L_0x00d1:
            int r10 = r9.mItemCount
            if (r14 >= r10) goto L_0x0220
            int r10 = r9.mFirstIndex
            int r10 = r10 + r14
            android.view.View r18 = r0.getReorderedChildAt(r10)
            if (r18 == 0) goto L_0x020c
            int r11 = r18.getVisibility()
            r15 = 8
            if (r11 != r15) goto L_0x00f2
            r23 = r1
            r26 = r13
            r22 = r14
            r25 = 2
            r27 = 4
            goto L_0x0216
        L_0x00f2:
            android.view.ViewGroup$LayoutParams r11 = r18.getLayoutParams()
            r15 = r11
            com.google.android.flexbox.FlexboxLayout$LayoutParams r15 = (com.google.android.flexbox.FlexboxLayout.LayoutParams) r15
            int r11 = r15.leftMargin
            float r11 = (float) r11
            float r7 = r7 + r11
            int r11 = r15.rightMargin
            float r11 = (float) r11
            float r12 = r12 - r11
            boolean r10 = r0.hasDividerBeforeChildAtAlongMainAxis(r10, r14)
            if (r10 == 0) goto L_0x0111
            int r10 = r0.mDividerVerticalWidth
            float r11 = (float) r10
            float r7 = r7 + r11
            float r12 = r12 - r11
            r20 = r10
            r19 = r12
            goto L_0x0115
        L_0x0111:
            r19 = r12
            r20 = 0
        L_0x0115:
            int r10 = r9.mItemCount
            int r10 = r10 - r13
            if (r14 != r10) goto L_0x0127
            int r10 = r0.mShowDividerVertical
            r16 = 4
            r10 = r10 & 4
            if (r10 <= 0) goto L_0x0129
            int r10 = r0.mDividerVerticalWidth
            r21 = r10
            goto L_0x012b
        L_0x0127:
            r16 = 4
        L_0x0129:
            r21 = 0
        L_0x012b:
            int r10 = r0.mFlexWrap
            r12 = 2
            if (r10 != r12) goto L_0x018d
            if (r29 == 0) goto L_0x0163
            com.google.android.flexbox.FlexboxHelper r10 = r0.mFlexboxHelper
            int r11 = java.lang.Math.round(r19)
            int r22 = r18.getMeasuredWidth()
            int r22 = r11 - r22
            int r11 = r18.getMeasuredHeight()
            int r23 = r3 - r11
            int r24 = java.lang.Math.round(r19)
            r11 = r18
            r25 = r12
            r12 = r9
            r26 = r13
            r13 = r22
            r22 = r14
            r14 = r23
            r23 = r1
            r1 = r15
            r27 = r16
            r15 = r24
            r16 = r3
            r10.layoutSingleChildHorizontal(r11, r12, r13, r14, r15, r16)
            goto L_0x01d5
        L_0x0163:
            r23 = r1
            r25 = r12
            r26 = r13
            r22 = r14
            r1 = r15
            r27 = r16
            com.google.android.flexbox.FlexboxHelper r10 = r0.mFlexboxHelper
            int r13 = java.lang.Math.round(r7)
            int r11 = r18.getMeasuredHeight()
            int r14 = r3 - r11
            int r11 = java.lang.Math.round(r7)
            int r12 = r18.getMeasuredWidth()
            int r15 = r11 + r12
            r11 = r18
            r12 = r9
            r16 = r3
            r10.layoutSingleChildHorizontal(r11, r12, r13, r14, r15, r16)
            goto L_0x01d5
        L_0x018d:
            r23 = r1
            r25 = r12
            r26 = r13
            r22 = r14
            r1 = r15
            r27 = r16
            if (r29 == 0) goto L_0x01b8
            com.google.android.flexbox.FlexboxHelper r10 = r0.mFlexboxHelper
            int r11 = java.lang.Math.round(r19)
            int r12 = r18.getMeasuredWidth()
            int r13 = r11 - r12
            int r15 = java.lang.Math.round(r19)
            int r11 = r18.getMeasuredHeight()
            int r16 = r5 + r11
            r11 = r18
            r12 = r9
            r14 = r5
            r10.layoutSingleChildHorizontal(r11, r12, r13, r14, r15, r16)
            goto L_0x01d5
        L_0x01b8:
            com.google.android.flexbox.FlexboxHelper r10 = r0.mFlexboxHelper
            int r13 = java.lang.Math.round(r7)
            int r11 = java.lang.Math.round(r7)
            int r12 = r18.getMeasuredWidth()
            int r15 = r11 + r12
            int r11 = r18.getMeasuredHeight()
            int r16 = r5 + r11
            r11 = r18
            r12 = r9
            r14 = r5
            r10.layoutSingleChildHorizontal(r11, r12, r13, r14, r15, r16)
        L_0x01d5:
            int r10 = r18.getMeasuredWidth()
            float r10 = (float) r10
            float r10 = r10 + r17
            int r11 = r1.rightMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r7 = r7 + r10
            int r10 = r18.getMeasuredWidth()
            float r10 = (float) r10
            float r10 = r10 + r17
            int r1 = r1.leftMargin
            float r1 = (float) r1
            float r10 = r10 + r1
            float r19 = r19 - r10
            if (r29 == 0) goto L_0x01fd
            r13 = 0
            r15 = 0
            r10 = r9
            r11 = r18
            r12 = r21
            r14 = r20
            r10.updatePositionFromView(r11, r12, r13, r14, r15)
            goto L_0x0209
        L_0x01fd:
            r13 = 0
            r15 = 0
            r10 = r9
            r11 = r18
            r12 = r20
            r14 = r21
            r10.updatePositionFromView(r11, r12, r13, r14, r15)
        L_0x0209:
            r12 = r19
            goto L_0x0216
        L_0x020c:
            r23 = r1
            r26 = r13
            r22 = r14
            r27 = r15
            r25 = 2
        L_0x0216:
            int r14 = r22 + 1
            r1 = r23
            r13 = r26
            r15 = r27
            goto L_0x00d1
        L_0x0220:
            r23 = r1
            int r1 = r9.mCrossSize
            int r5 = r5 + r1
            int r3 = r3 - r1
            int r8 = r8 + 1
            r1 = r23
            goto L_0x001e
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.layoutHorizontal(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void layoutVertical(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            r29 = this;
            r0 = r29
            int r1 = r29.getPaddingTop()
            int r2 = r29.getPaddingBottom()
            int r3 = r29.getPaddingRight()
            int r4 = r29.getPaddingLeft()
            int r5 = r34 - r32
            int r6 = r35 - r33
            int r5 = r5 - r3
            java.util.List<com.google.android.flexbox.FlexLine> r3 = r0.mFlexLines
            int r3 = r3.size()
            r8 = 0
        L_0x001e:
            if (r8 >= r3) goto L_0x021c
            java.util.List<com.google.android.flexbox.FlexLine> r9 = r0.mFlexLines
            java.lang.Object r9 = r9.get(r8)
            com.google.android.flexbox.FlexLine r9 = (com.google.android.flexbox.FlexLine) r9
            boolean r10 = r0.hasDividerBeforeFlexLine(r8)
            if (r10 == 0) goto L_0x0032
            int r10 = r0.mDividerVerticalWidth
            int r4 = r4 + r10
            int r5 = r5 - r10
        L_0x0032:
            int r10 = r0.mJustifyContent
            r15 = 4
            r11 = 0
            r14 = 1
            if (r10 == 0) goto L_0x00c5
            if (r10 == r14) goto L_0x00bd
            r12 = 2
            r13 = 1073741824(0x40000000, float:2.0)
            if (r10 == r12) goto L_0x00aa
            r12 = 3
            if (r10 == r12) goto L_0x0093
            if (r10 == r15) goto L_0x007a
            r12 = 5
            if (r10 != r12) goto L_0x0061
            int r10 = r9.getItemCountNotGone()
            if (r10 == 0) goto L_0x0058
            int r12 = r9.mMainSize
            int r12 = r6 - r12
            float r12 = (float) r12
            int r10 = r10 + 1
            float r10 = (float) r10
            float r12 = r12 / r10
            goto L_0x0059
        L_0x0058:
            r12 = r11
        L_0x0059:
            float r10 = (float) r1
            float r10 = r10 + r12
            int r13 = r6 - r2
            float r13 = (float) r13
            float r13 = r13 - r12
            goto L_0x00ca
        L_0x0061:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.append(r3)
            int r3 = r0.mJustifyContent
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x007a:
            int r10 = r9.getItemCountNotGone()
            if (r10 == 0) goto L_0x0088
            int r12 = r9.mMainSize
            int r12 = r6 - r12
            float r12 = (float) r12
            float r10 = (float) r10
            float r12 = r12 / r10
            goto L_0x0089
        L_0x0088:
            r12 = r11
        L_0x0089:
            float r10 = (float) r1
            float r13 = r12 / r13
            float r10 = r10 + r13
            int r7 = r6 - r2
            float r7 = (float) r7
            float r13 = r7 - r13
            goto L_0x00ca
        L_0x0093:
            float r10 = (float) r1
            int r7 = r9.getItemCountNotGone()
            if (r7 == r14) goto L_0x009e
            int r7 = r7 + -1
            float r7 = (float) r7
            goto L_0x00a0
        L_0x009e:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x00a0:
            int r12 = r9.mMainSize
            int r12 = r6 - r12
            float r12 = (float) r12
            float r12 = r12 / r7
            int r7 = r6 - r2
            float r13 = (float) r7
            goto L_0x00ca
        L_0x00aa:
            float r7 = (float) r1
            int r10 = r9.mMainSize
            int r12 = r6 - r10
            float r12 = (float) r12
            float r12 = r12 / r13
            float r7 = r7 + r12
            int r12 = r6 - r2
            float r12 = (float) r12
            int r10 = r6 - r10
            float r10 = (float) r10
            float r10 = r10 / r13
            float r13 = r12 - r10
            r10 = r7
            goto L_0x00c9
        L_0x00bd:
            int r7 = r9.mMainSize
            int r10 = r6 - r7
            int r10 = r10 + r2
            float r10 = (float) r10
            int r7 = r7 - r1
            goto L_0x00c8
        L_0x00c5:
            float r10 = (float) r1
            int r7 = r6 - r2
        L_0x00c8:
            float r13 = (float) r7
        L_0x00c9:
            r12 = r11
        L_0x00ca:
            float r7 = java.lang.Math.max(r12, r11)
            r12 = 0
        L_0x00cf:
            int r11 = r9.mItemCount
            if (r12 >= r11) goto L_0x0214
            int r11 = r9.mFirstIndex
            int r11 = r11 + r12
            android.view.View r18 = r0.getReorderedChildAt(r11)
            if (r18 == 0) goto L_0x0206
            int r15 = r18.getVisibility()
            r14 = 8
            if (r15 != r14) goto L_0x00ec
            r25 = r12
            r26 = 1
            r28 = 4
            goto L_0x020c
        L_0x00ec:
            android.view.ViewGroup$LayoutParams r14 = r18.getLayoutParams()
            r15 = r14
            com.google.android.flexbox.FlexboxLayout$LayoutParams r15 = (com.google.android.flexbox.FlexboxLayout.LayoutParams) r15
            int r14 = r15.topMargin
            float r14 = (float) r14
            float r10 = r10 + r14
            int r14 = r15.bottomMargin
            float r14 = (float) r14
            float r13 = r13 - r14
            boolean r11 = r0.hasDividerBeforeChildAtAlongMainAxis(r11, r12)
            if (r11 == 0) goto L_0x010d
            int r11 = r0.mDividerHorizontalHeight
            float r14 = (float) r11
            float r10 = r10 + r14
            float r13 = r13 - r14
            r19 = r10
            r21 = r11
            r20 = r13
            goto L_0x0113
        L_0x010d:
            r19 = r10
            r20 = r13
            r21 = 0
        L_0x0113:
            int r10 = r9.mItemCount
            r14 = 1
            int r10 = r10 - r14
            if (r12 != r10) goto L_0x0126
            int r10 = r0.mShowDividerHorizontal
            r16 = 4
            r10 = r10 & 4
            if (r10 <= 0) goto L_0x0128
            int r10 = r0.mDividerHorizontalHeight
            r22 = r10
            goto L_0x012a
        L_0x0126:
            r16 = 4
        L_0x0128:
            r22 = 0
        L_0x012a:
            if (r30 == 0) goto L_0x0185
            if (r31 == 0) goto L_0x015d
            com.google.android.flexbox.FlexboxHelper r10 = r0.mFlexboxHelper
            r13 = 1
            int r11 = r18.getMeasuredWidth()
            int r17 = r5 - r11
            int r11 = java.lang.Math.round(r20)
            int r23 = r18.getMeasuredHeight()
            int r23 = r11 - r23
            int r24 = java.lang.Math.round(r20)
            r11 = r18
            r25 = r12
            r12 = r9
            r26 = r14
            r14 = r17
            r27 = r15
            r28 = r16
            r15 = r23
            r16 = r5
            r17 = r24
            r10.layoutSingleChildVertical(r11, r12, r13, r14, r15, r16, r17)
            goto L_0x01cc
        L_0x015d:
            r25 = r12
            r26 = r14
            r27 = r15
            r28 = r16
            com.google.android.flexbox.FlexboxHelper r10 = r0.mFlexboxHelper
            r13 = 1
            int r11 = r18.getMeasuredWidth()
            int r14 = r5 - r11
            int r15 = java.lang.Math.round(r19)
            int r11 = java.lang.Math.round(r19)
            int r12 = r18.getMeasuredHeight()
            int r17 = r11 + r12
            r11 = r18
            r12 = r9
            r16 = r5
            r10.layoutSingleChildVertical(r11, r12, r13, r14, r15, r16, r17)
            goto L_0x01cc
        L_0x0185:
            r25 = r12
            r26 = r14
            r27 = r15
            r28 = r16
            if (r31 == 0) goto L_0x01ae
            com.google.android.flexbox.FlexboxHelper r10 = r0.mFlexboxHelper
            r13 = 0
            int r11 = java.lang.Math.round(r20)
            int r12 = r18.getMeasuredHeight()
            int r15 = r11 - r12
            int r11 = r18.getMeasuredWidth()
            int r16 = r4 + r11
            int r17 = java.lang.Math.round(r20)
            r11 = r18
            r12 = r9
            r14 = r4
            r10.layoutSingleChildVertical(r11, r12, r13, r14, r15, r16, r17)
            goto L_0x01cc
        L_0x01ae:
            com.google.android.flexbox.FlexboxHelper r10 = r0.mFlexboxHelper
            r13 = 0
            int r15 = java.lang.Math.round(r19)
            int r11 = r18.getMeasuredWidth()
            int r16 = r4 + r11
            int r11 = java.lang.Math.round(r19)
            int r12 = r18.getMeasuredHeight()
            int r17 = r11 + r12
            r11 = r18
            r12 = r9
            r14 = r4
            r10.layoutSingleChildVertical(r11, r12, r13, r14, r15, r16, r17)
        L_0x01cc:
            int r10 = r18.getMeasuredHeight()
            float r10 = (float) r10
            float r10 = r10 + r7
            r14 = r27
            int r11 = r14.bottomMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r19 = r19 + r10
            int r10 = r18.getMeasuredHeight()
            float r10 = (float) r10
            float r10 = r10 + r7
            int r11 = r14.topMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r20 = r20 - r10
            if (r31 == 0) goto L_0x01f5
            r12 = 0
            r14 = 0
            r10 = r9
            r11 = r18
            r13 = r22
            r15 = r21
            r10.updatePositionFromView(r11, r12, r13, r14, r15)
            goto L_0x0201
        L_0x01f5:
            r12 = 0
            r14 = 0
            r10 = r9
            r11 = r18
            r13 = r21
            r15 = r22
            r10.updatePositionFromView(r11, r12, r13, r14, r15)
        L_0x0201:
            r10 = r19
            r13 = r20
            goto L_0x020c
        L_0x0206:
            r25 = r12
            r26 = r14
            r28 = r15
        L_0x020c:
            int r12 = r25 + 1
            r14 = r26
            r15 = r28
            goto L_0x00cf
        L_0x0214:
            int r7 = r9.mCrossSize
            int r4 = r4 + r7
            int r5 = r5 - r7
            int r8 = r8 + 1
            goto L_0x001e
        L_0x021c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.layoutVertical(boolean, boolean, int, int, int, int):void");
    }

    private void measureHorizontal(int i11, int i12) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, i11, i12);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(i11, i12);
        if (this.mAlignItems == 3) {
            for (FlexLine next : this.mFlexLines) {
                int i13 = Integer.MIN_VALUE;
                for (int i14 = 0; i14 < next.mItemCount; i14++) {
                    View reorderedChildAt = getReorderedChildAt(next.mFirstIndex + i14);
                    if (!(reorderedChildAt == null || reorderedChildAt.getVisibility() == 8)) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        if (this.mFlexWrap != 2) {
                            i13 = Math.max(i13, reorderedChildAt.getMeasuredHeight() + Math.max(next.mMaxBaseline - reorderedChildAt.getBaseline(), layoutParams.topMargin) + layoutParams.bottomMargin);
                        } else {
                            i13 = Math.max(i13, reorderedChildAt.getMeasuredHeight() + layoutParams.topMargin + Math.max((next.mMaxBaseline - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), layoutParams.bottomMargin));
                        }
                    }
                }
                next.mCrossSize = i13;
            }
        }
        this.mFlexboxHelper.determineCrossSize(i11, i12, getPaddingTop() + getPaddingBottom());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, i11, i12, this.mFlexLinesResult.mChildState);
    }

    private void measureVertical(int i11, int i12) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, i11, i12);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(i11, i12);
        this.mFlexboxHelper.determineCrossSize(i11, i12, getPaddingLeft() + getPaddingRight());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, i11, i12, this.mFlexLinesResult.mChildState);
    }

    private void setMeasuredDimensionForFlex(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i13);
        int size2 = View.MeasureSpec.getSize(i13);
        if (i11 == 0 || i11 == 1) {
            i15 = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            i16 = getLargestMainSize();
        } else if (i11 == 2 || i11 == 3) {
            i15 = getLargestMainSize();
            i16 = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + i11);
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < i16) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            } else {
                size = i16;
            }
            i17 = View.resolveSizeAndState(size, i12, i14);
        } else if (mode == 0) {
            i17 = View.resolveSizeAndState(i16, i12, i14);
        } else if (mode == 1073741824) {
            if (size < i16) {
                i14 = View.combineMeasuredStates(i14, 16777216);
            }
            i17 = View.resolveSizeAndState(size, i12, i14);
        } else {
            throw new IllegalStateException("Unknown width mode is set: " + mode);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i15) {
                i14 = View.combineMeasuredStates(i14, 256);
            } else {
                size2 = i15;
            }
            i18 = View.resolveSizeAndState(size2, i13, i14);
        } else if (mode2 == 0) {
            i18 = View.resolveSizeAndState(i15, i13, i14);
        } else if (mode2 == 1073741824) {
            if (size2 < i15) {
                i14 = View.combineMeasuredStates(i14, 256);
            }
            i18 = View.resolveSizeAndState(size2, i13, i14);
        } else {
            throw new IllegalStateException("Unknown height mode is set: " + mode2);
        }
        setMeasuredDimension(i17, i18);
    }

    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(view, i11, layoutParams, this.mOrderCache);
        super.addView(view, i11, layoutParams);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getAlignContent() {
        return this.mAlignContent;
    }

    public int getAlignItems() {
        return this.mAlignItems;
    }

    public int getChildHeightMeasureSpec(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    public int getChildWidthMeasureSpec(int i11, int i12, int i13) {
        return ViewGroup.getChildMeasureSpec(i11, i12, i13);
    }

    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    public int getDecorationLengthMainAxis(View view, int i11, int i12) {
        int i13;
        int i14 = 0;
        if (isMainAxisDirectionHorizontal()) {
            if (hasDividerBeforeChildAtAlongMainAxis(i11, i12)) {
                i14 = 0 + this.mDividerVerticalWidth;
            }
            if ((this.mShowDividerVertical & 4) <= 0) {
                return i14;
            }
            i13 = this.mDividerVerticalWidth;
        } else {
            if (hasDividerBeforeChildAtAlongMainAxis(i11, i12)) {
                i14 = 0 + this.mDividerHorizontalHeight;
            }
            if ((this.mShowDividerHorizontal & 4) <= 0) {
                return i14;
            }
            i13 = this.mDividerHorizontalHeight;
        }
        return i14 + i13;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }

    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }

    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    public View getFlexItemAt(int i11) {
        return getChildAt(i11);
    }

    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        for (FlexLine next : this.mFlexLines) {
            if (next.getItemCountNotGone() != 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    public int getLargestMainSize() {
        int i11 = Integer.MIN_VALUE;
        for (FlexLine flexLine : this.mFlexLines) {
            i11 = Math.max(i11, flexLine.mMainSize);
        }
        return i11;
    }

    public int getMaxLine() {
        return this.mMaxLine;
    }

    public View getReorderedChildAt(int i11) {
        if (i11 < 0) {
            return null;
        }
        int[] iArr = this.mReorderedIndices;
        if (i11 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i11]);
    }

    public View getReorderedFlexItemAt(int i11) {
        return getReorderedChildAt(i11);
    }

    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }

    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }

    public int getSumOfCrossSize() {
        int i11;
        int i12;
        int size = this.mFlexLines.size();
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            FlexLine flexLine = this.mFlexLines.get(i14);
            if (hasDividerBeforeFlexLine(i14)) {
                if (isMainAxisDirectionHorizontal()) {
                    i12 = this.mDividerHorizontalHeight;
                } else {
                    i12 = this.mDividerVerticalWidth;
                }
                i13 += i12;
            }
            if (hasEndDividerAfterFlexLine(i14)) {
                if (isMainAxisDirectionHorizontal()) {
                    i11 = this.mDividerHorizontalHeight;
                } else {
                    i11 = this.mDividerVerticalWidth;
                }
                i13 += i11;
            }
            i13 += flexLine.mCrossSize;
        }
        return i13;
    }

    public boolean isMainAxisDirectionHorizontal() {
        int i11 = this.mFlexDirection;
        return i11 == 0 || i11 == 1;
    }

    public void onDraw(Canvas canvas) {
        if (this.mDividerDrawableVertical != null || this.mDividerDrawableHorizontal != null) {
            if (this.mShowDividerHorizontal != 0 || this.mShowDividerVertical != 0) {
                int F = h0.F(this);
                int i11 = this.mFlexDirection;
                boolean z11 = false;
                boolean z12 = true;
                if (i11 == 0) {
                    boolean z13 = F == 1;
                    if (this.mFlexWrap == 2) {
                        z11 = true;
                    }
                    drawDividersHorizontal(canvas, z13, z11);
                } else if (i11 == 1) {
                    boolean z14 = F != 1;
                    if (this.mFlexWrap == 2) {
                        z11 = true;
                    }
                    drawDividersHorizontal(canvas, z14, z11);
                } else if (i11 == 2) {
                    if (F != 1) {
                        z12 = false;
                    }
                    if (this.mFlexWrap == 2) {
                        z12 = !z12;
                    }
                    drawDividersVertical(canvas, z12, false);
                } else if (i11 == 3) {
                    if (F == 1) {
                        z11 = true;
                    }
                    if (this.mFlexWrap == 2) {
                        z11 = !z11;
                    }
                    drawDividersVertical(canvas, z11, true);
                }
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int F = h0.F(this);
        int i15 = this.mFlexDirection;
        boolean z12 = false;
        if (i15 == 0) {
            layoutHorizontal(F == 1, i11, i12, i13, i14);
        } else if (i15 == 1) {
            layoutHorizontal(F != 1, i11, i12, i13, i14);
        } else if (i15 == 2) {
            if (F == 1) {
                z12 = true;
            }
            layoutVertical(this.mFlexWrap == 2 ? !z12 : z12, false, i11, i12, i13, i14);
        } else if (i15 == 3) {
            if (F == 1) {
                z12 = true;
            }
            layoutVertical(this.mFlexWrap == 2 ? !z12 : z12, true, i11, i12, i13, i14);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
        }
    }

    public void onMeasure(int i11, int i12) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        if (this.mFlexboxHelper.isOrderChangedFromLastMeasurement(this.mOrderCache)) {
            this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(this.mOrderCache);
        }
        int i13 = this.mFlexDirection;
        if (i13 == 0 || i13 == 1) {
            measureHorizontal(i11, i12);
        } else if (i13 == 2 || i13 == 3) {
            measureVertical(i11, i12);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
        }
    }

    public void onNewFlexItemAdded(View view, int i11, int i12, FlexLine flexLine) {
        if (!hasDividerBeforeChildAtAlongMainAxis(i11, i12)) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            int i13 = flexLine.mMainSize;
            int i14 = this.mDividerVerticalWidth;
            flexLine.mMainSize = i13 + i14;
            flexLine.mDividerLengthInMainSize += i14;
            return;
        }
        int i15 = flexLine.mMainSize;
        int i16 = this.mDividerHorizontalHeight;
        flexLine.mMainSize = i15 + i16;
        flexLine.mDividerLengthInMainSize += i16;
    }

    public void onNewFlexLineAdded(FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 4) > 0) {
                int i11 = flexLine.mMainSize;
                int i12 = this.mDividerVerticalWidth;
                flexLine.mMainSize = i11 + i12;
                flexLine.mDividerLengthInMainSize += i12;
            }
        } else if ((this.mShowDividerHorizontal & 4) > 0) {
            int i13 = flexLine.mMainSize;
            int i14 = this.mDividerHorizontalHeight;
            flexLine.mMainSize = i13 + i14;
            flexLine.mDividerLengthInMainSize += i14;
        }
    }

    public void setAlignContent(int i11) {
        if (this.mAlignContent != i11) {
            this.mAlignContent = i11;
            requestLayout();
        }
    }

    public void setAlignItems(int i11) {
        if (this.mAlignItems != i11) {
            this.mAlignItems = i11;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable != this.mDividerDrawableHorizontal) {
            this.mDividerDrawableHorizontal = drawable;
            if (drawable != null) {
                this.mDividerHorizontalHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerHorizontalHeight = 0;
            }
            setWillNotDrawFlag();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable != this.mDividerDrawableVertical) {
            this.mDividerDrawableVertical = drawable;
            if (drawable != null) {
                this.mDividerVerticalWidth = drawable.getIntrinsicWidth();
            } else {
                this.mDividerVerticalWidth = 0;
            }
            setWillNotDrawFlag();
            requestLayout();
        }
    }

    public void setFlexDirection(int i11) {
        if (this.mFlexDirection != i11) {
            this.mFlexDirection = i11;
            requestLayout();
        }
    }

    public void setFlexLines(List<FlexLine> list) {
        this.mFlexLines = list;
    }

    public void setFlexWrap(int i11) {
        if (this.mFlexWrap != i11) {
            this.mFlexWrap = i11;
            requestLayout();
        }
    }

    public void setJustifyContent(int i11) {
        if (this.mJustifyContent != i11) {
            this.mJustifyContent = i11;
            requestLayout();
        }
    }

    public void setMaxLine(int i11) {
        if (this.mMaxLine != i11) {
            this.mMaxLine = i11;
            requestLayout();
        }
    }

    public void setShowDivider(int i11) {
        setShowDividerVertical(i11);
        setShowDividerHorizontal(i11);
    }

    public void setShowDividerHorizontal(int i11) {
        if (i11 != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = i11;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i11) {
        if (i11 != this.mShowDividerVertical) {
            this.mShowDividerVertical = i11;
            requestLayout();
        }
    }

    public void updateViewCache(int i11, View view) {
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mMaxLine = -1;
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mFlexLines = new ArrayList();
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i11, 0);
        this.mFlexDirection = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.mAlignContent = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.mMaxLine = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i12 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i12 != 0) {
            this.mShowDividerVertical = i12;
            this.mShowDividerHorizontal = i12;
        }
        int i13 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i13 != 0) {
            this.mShowDividerVertical = i13;
        }
        int i14 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i14 != 0) {
            this.mShowDividerHorizontal = i14;
        }
        obtainStyledAttributes.recycle();
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() {
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            public LayoutParams[] newArray(int i11) {
                return new LayoutParams[i11];
            }
        };
        private int mAlignSelf = -1;
        private float mFlexBasisPercent = -1.0f;
        private float mFlexGrow = 0.0f;
        private float mFlexShrink = 1.0f;
        private int mMaxHeight = FlexItem.MAX_SIZE;
        private int mMaxWidth = FlexItem.MAX_SIZE;
        private int mMinHeight = -1;
        private int mMinWidth = -1;
        private int mOrder = 1;
        private boolean mWrapBefore;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, FlexItem.MAX_SIZE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, FlexItem.MAX_SIZE);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        public int describeContents() {
            return 0;
        }

        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        public int getHeight() {
            return this.height;
        }

        public int getMarginBottom() {
            return this.bottomMargin;
        }

        public int getMarginLeft() {
            return this.leftMargin;
        }

        public int getMarginRight() {
            return this.rightMargin;
        }

        public int getMarginTop() {
            return this.topMargin;
        }

        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        public int getMinHeight() {
            return this.mMinHeight;
        }

        public int getMinWidth() {
            return this.mMinWidth;
        }

        public int getOrder() {
            return this.mOrder;
        }

        public int getWidth() {
            return this.width;
        }

        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        public void setAlignSelf(int i11) {
            this.mAlignSelf = i11;
        }

        public void setFlexBasisPercent(float f11) {
            this.mFlexBasisPercent = f11;
        }

        public void setFlexGrow(float f11) {
            this.mFlexGrow = f11;
        }

        public void setFlexShrink(float f11) {
            this.mFlexShrink = f11;
        }

        public void setHeight(int i11) {
            this.height = i11;
        }

        public void setMaxHeight(int i11) {
            this.mMaxHeight = i11;
        }

        public void setMaxWidth(int i11) {
            this.mMaxWidth = i11;
        }

        public void setMinHeight(int i11) {
            this.mMinHeight = i11;
        }

        public void setMinWidth(int i11) {
            this.mMinWidth = i11;
        }

        public void setOrder(int i11) {
            this.mOrder = i11;
        }

        public void setWidth(int i11) {
            this.width = i11;
        }

        public void setWrapBefore(boolean z11) {
            this.mWrapBefore = z11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i11, int i12) {
            super(new ViewGroup.LayoutParams(i11, i12));
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(Parcel parcel) {
            super(0, 0);
            boolean z11 = false;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0 ? true : z11;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }
}
