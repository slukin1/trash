package com.hbg.lite.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lite.R$styleable;

public class OtcFloatLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public int f77589b;

    /* renamed from: c  reason: collision with root package name */
    public int f77590c;

    /* renamed from: d  reason: collision with root package name */
    public int f77591d;

    /* renamed from: e  reason: collision with root package name */
    public int f77592e;

    /* renamed from: f  reason: collision with root package name */
    public int f77593f;

    /* renamed from: g  reason: collision with root package name */
    public int f77594g;

    /* renamed from: h  reason: collision with root package name */
    public a f77595h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f77596i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f77597j;

    /* renamed from: k  reason: collision with root package name */
    public int f77598k;

    /* renamed from: l  reason: collision with root package name */
    public SparseArray<Integer> f77599l;

    public interface a {
        void a(int i11, int i12);
    }

    public OtcFloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatLayout);
        this.f77589b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatLayout_childHorizontalSpacing, 0);
        this.f77590c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatLayout_childVerticalSpacing, 0);
        this.f77591d = obtainStyledAttributes.getInteger(R$styleable.FloatLayout_android_gravity, 3);
        int i11 = obtainStyledAttributes.getInt(R$styleable.FloatLayout_android_maxLines, -1);
        if (i11 >= 0) {
            setMaxLines(i11);
        }
        int i12 = obtainStyledAttributes.getInt(R$styleable.FloatLayout_maxNumber, -1);
        if (i12 >= 0) {
            setMaxNumber(i12);
        }
        obtainStyledAttributes.recycle();
    }

    public final void b(int i11) {
        int paddingTop = getPaddingTop();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int[] iArr = this.f77596i;
            if (i12 >= iArr.length || iArr[i12] == 0) {
                break;
            }
            int paddingLeft = ((((i11 - getPaddingLeft()) - getPaddingRight()) - this.f77597j[i12]) / 2) + getPaddingLeft();
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.f77596i[i12]) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 8) {
                    i13++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    i16 = Math.max(i16, measuredHeight);
                    paddingLeft += measuredWidth + this.f77589b;
                    i14++;
                    i15++;
                    i13++;
                    if (i14 == this.f77598k) {
                        break;
                    }
                }
            }
            if (i14 == this.f77598k) {
                break;
            }
            paddingTop += i16 + this.f77590c;
            i12++;
        }
        int childCount = getChildCount();
        while (i13 < childCount) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                childAt2.layout(0, 0, 0, 0);
            }
            i13++;
        }
    }

    public final void c(int i11) {
        int paddingRight = i11 - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i12 = 1;
        int i13 = 1;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8 && i14 < this.f77598k) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (paddingLeft + measuredWidth > paddingRight) {
                    i13++;
                    i15 = 0;
                }
                i15 = Math.max(i15, measuredHeight);
                i14++;
                this.f77599l.put(i13, Integer.valueOf(i15));
                paddingLeft += measuredWidth + this.f77589b;
            }
        }
        int paddingLeft2 = getPaddingLeft();
        int intValue = this.f77599l.get(1).intValue();
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                if (i17 < this.f77598k) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    if (paddingLeft2 + measuredWidth2 > paddingRight) {
                        i12++;
                        paddingLeft2 = getPaddingLeft();
                        paddingTop += intValue + this.f77590c;
                    }
                    intValue = this.f77599l.get(i12).intValue();
                    int max = Math.max(0, intValue - measuredHeight2) + paddingTop;
                    childAt2.layout(paddingLeft2, max, paddingLeft2 + measuredWidth2, measuredHeight2 + max);
                    paddingLeft2 += measuredWidth2 + this.f77589b;
                    i17++;
                } else {
                    childAt2.layout(0, 0, 0, 0);
                }
            }
        }
    }

    public final void d(int i11) {
        int paddingTop = getPaddingTop();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int[] iArr = this.f77596i;
            if (i12 >= iArr.length || iArr[i12] == 0) {
                break;
            }
            int paddingRight = (i11 - getPaddingRight()) - this.f77597j[i12];
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.f77596i[i12]) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 8) {
                    i13++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingRight, paddingTop, paddingRight + measuredWidth, paddingTop + measuredHeight);
                    i16 = Math.max(i16, measuredHeight);
                    paddingRight += measuredWidth + this.f77589b;
                    i14++;
                    i15++;
                    i13++;
                    if (i14 == this.f77598k) {
                        break;
                    }
                }
            }
            if (i14 == this.f77598k) {
                break;
            }
            paddingTop += i16 + this.f77590c;
            i12++;
        }
        int childCount = getChildCount();
        while (i13 < childCount) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                childAt2.layout(0, 0, 0, 0);
            }
            i13++;
        }
    }

    public int getGravity() {
        return this.f77591d;
    }

    public int getLineCount() {
        return this.f77594g;
    }

    public int getMaxLines() {
        if (this.f77592e == 0) {
            return this.f77593f;
        }
        return -1;
    }

    public int getMaxNumber() {
        if (this.f77592e == 1) {
            return this.f77593f;
        }
        return -1;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15 = i13 - i11;
        int i16 = this.f77591d & 7;
        if (i16 == 1) {
            b(i15);
        } else if (i16 == 3) {
            c(i15);
        } else if (i16 != 5) {
            c(i15);
        } else {
            d(i15);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00dd, code lost:
        r16 = r4;
     */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            int r3 = android.view.View.MeasureSpec.getMode(r19)
            int r4 = android.view.View.MeasureSpec.getSize(r19)
            int r5 = android.view.View.MeasureSpec.getMode(r20)
            int r6 = android.view.View.MeasureSpec.getSize(r20)
            int r7 = r18.getChildCount()
            int[] r8 = new int[r7]
            r0.f77596i = r8
            int[] r8 = new int[r7]
            r0.f77597j = r8
            r9 = 0
            r10 = 1
            r11 = 1073741824(0x40000000, float:2.0)
            if (r3 != r11) goto L_0x010b
            r0.f77598k = r9
            int r3 = r18.getPaddingLeft()
            int r11 = r18.getPaddingRight()
            int r11 = r4 - r11
            r12 = r9
            r13 = r12
            r14 = r13
        L_0x0037:
            if (r9 >= r7) goto L_0x00dd
            int r15 = r0.f77592e
            if (r15 != r10) goto L_0x0045
            int r10 = r0.f77598k
            int r8 = r0.f77593f
            if (r10 < r8) goto L_0x0045
            goto L_0x00dd
        L_0x0045:
            if (r15 != 0) goto L_0x004d
            int r8 = r0.f77593f
            if (r12 < r8) goto L_0x004d
            goto L_0x00dd
        L_0x004d:
            android.view.View r8 = r0.getChildAt(r9)
            int r10 = r8.getVisibility()
            r15 = 8
            if (r10 != r15) goto L_0x005d
            r16 = r4
            goto L_0x00d6
        L_0x005d:
            android.view.ViewGroup$LayoutParams r10 = r8.getLayoutParams()
            int r15 = r18.getPaddingLeft()
            int r16 = r18.getPaddingRight()
            int r15 = r15 + r16
            r16 = r4
            int r4 = r10.width
            int r4 = android.view.ViewGroup.getChildMeasureSpec(r1, r15, r4)
            int r15 = r18.getPaddingTop()
            int r17 = r18.getPaddingBottom()
            int r15 = r15 + r17
            int r10 = r10.height
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r2, r15, r10)
            r8.measure(r4, r10)
            int r4 = r8.getMeasuredWidth()
            int r10 = r3 + r4
            if (r10 <= r11) goto L_0x00b1
            int r3 = r0.f77590c
            int r3 = r3 + r13
            int r14 = r14 + r3
            int r3 = r0.f77592e
            if (r3 != 0) goto L_0x009d
            int r3 = r12 + 1
            int r10 = r0.f77593f
            if (r3 < r10) goto L_0x009d
            goto L_0x00df
        L_0x009d:
            int[] r3 = r0.f77597j
            r10 = r3[r12]
            int r13 = r0.f77589b
            int r10 = r10 - r13
            r3[r12] = r10
            int r12 = r12 + 1
            int r3 = r18.getPaddingLeft()
            int r8 = r8.getMeasuredHeight()
            goto L_0x00b9
        L_0x00b1:
            int r8 = r8.getMeasuredHeight()
            int r8 = java.lang.Math.max(r13, r8)
        L_0x00b9:
            int[] r10 = r0.f77596i
            r13 = r10[r12]
            r15 = 1
            int r13 = r13 + r15
            r10[r12] = r13
            int[] r10 = r0.f77597j
            r13 = r10[r12]
            int r15 = r0.f77589b
            int r17 = r4 + r15
            int r13 = r13 + r17
            r10[r12] = r13
            int r4 = r4 + r15
            int r3 = r3 + r4
            int r4 = r0.f77598k
            r10 = 1
            int r4 = r4 + r10
            r0.f77598k = r4
            r13 = r8
        L_0x00d6:
            int r9 = r9 + 1
            r4 = r16
            r10 = 1
            goto L_0x0037
        L_0x00dd:
            r16 = r4
        L_0x00df:
            int[] r1 = r0.f77597j
            int r2 = r1.length
            if (r2 <= 0) goto L_0x00ef
            r2 = r1[r12]
            if (r2 <= 0) goto L_0x00ef
            r2 = r1[r12]
            int r3 = r0.f77589b
            int r2 = r2 - r3
            r1[r12] = r2
        L_0x00ef:
            int r14 = r14 + r13
            if (r5 != 0) goto L_0x00f9
            int r1 = r18.getPaddingBottom()
            int r6 = r14 + r1
            goto L_0x0106
        L_0x00f9:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 != r1) goto L_0x0106
            int r1 = r18.getPaddingBottom()
            int r14 = r14 + r1
            int r6 = java.lang.Math.min(r14, r6)
        L_0x0106:
            r9 = r12
            r4 = r16
            goto L_0x019a
        L_0x010b:
            int r3 = r18.getPaddingLeft()
            int r4 = r18.getPaddingRight()
            int r3 = r3 + r4
            r0.f77598k = r9
            r4 = r9
            r5 = r4
        L_0x0118:
            if (r4 >= r7) goto L_0x0176
            int r6 = r0.f77592e
            r8 = 1
            if (r6 != r8) goto L_0x0126
            int r6 = r0.f77598k
            int r10 = r0.f77593f
            if (r6 <= r10) goto L_0x012d
            goto L_0x0177
        L_0x0126:
            if (r6 != 0) goto L_0x012d
            int r6 = r0.f77593f
            if (r8 <= r6) goto L_0x012d
            goto L_0x0177
        L_0x012d:
            android.view.View r6 = r0.getChildAt(r4)
            int r8 = r6.getVisibility()
            r10 = 8
            if (r8 != r10) goto L_0x013b
            r8 = 1
            goto L_0x0173
        L_0x013b:
            android.view.ViewGroup$LayoutParams r8 = r6.getLayoutParams()
            int r11 = r18.getPaddingLeft()
            int r12 = r18.getPaddingRight()
            int r11 = r11 + r12
            int r12 = r8.width
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r1, r11, r12)
            int r12 = r18.getPaddingTop()
            int r13 = r18.getPaddingBottom()
            int r12 = r12 + r13
            int r8 = r8.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r2, r12, r8)
            r6.measure(r11, r8)
            int r8 = r6.getMeasuredWidth()
            int r3 = r3 + r8
            int r6 = r6.getMeasuredHeight()
            int r5 = java.lang.Math.max(r5, r6)
            int r6 = r0.f77598k
            r8 = 1
            int r6 = r6 + r8
            r0.f77598k = r6
        L_0x0173:
            int r4 = r4 + 1
            goto L_0x0118
        L_0x0176:
            r8 = 1
        L_0x0177:
            int r1 = r0.f77598k
            if (r1 <= 0) goto L_0x0180
            int r2 = r0.f77589b
            int r1 = r1 - r8
            int r2 = r2 * r1
            int r3 = r3 + r2
        L_0x0180:
            r4 = r3
            int r1 = r18.getPaddingTop()
            int r5 = r5 + r1
            int r1 = r18.getPaddingBottom()
            int r6 = r5 + r1
            int[] r1 = r0.f77596i
            int r2 = r1.length
            if (r2 <= 0) goto L_0x0193
            r1[r9] = r7
        L_0x0193:
            int[] r1 = r0.f77597j
            int r2 = r1.length
            if (r2 <= 0) goto L_0x019a
            r1[r9] = r4
        L_0x019a:
            r0.setMeasuredDimension(r4, r6)
            r1 = 1
            int r9 = r9 + r1
            int r1 = r0.f77594g
            if (r1 == r9) goto L_0x01ac
            com.hbg.lite.view.OtcFloatLayout$a r2 = r0.f77595h
            if (r2 == 0) goto L_0x01aa
            r2.a(r1, r9)
        L_0x01aa:
            r0.f77594g = r9
        L_0x01ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lite.view.OtcFloatLayout.onMeasure(int, int):void");
    }

    public void setChildHorizontalSpacing(int i11) {
        this.f77589b = i11;
        invalidate();
    }

    public void setChildVerticalSpacing(int i11) {
        this.f77590c = i11;
        invalidate();
    }

    public void setGravity(int i11) {
        if (this.f77591d != i11) {
            this.f77591d = i11;
            requestLayout();
        }
    }

    public void setMaxLines(int i11) {
        this.f77593f = i11;
        this.f77592e = 0;
        requestLayout();
    }

    public void setMaxNumber(int i11) {
        this.f77593f = i11;
        this.f77592e = 1;
        requestLayout();
    }

    public void setOnLineCountChangeListener(a aVar) {
        this.f77595h = aVar;
    }

    public OtcFloatLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f77592e = 0;
        this.f77593f = Integer.MAX_VALUE;
        this.f77594g = 0;
        this.f77599l = new SparseArray<>();
        a(context, attributeSet);
    }
}
