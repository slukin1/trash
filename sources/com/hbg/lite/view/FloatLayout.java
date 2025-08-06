package com.hbg.lite.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lite.R$styleable;

public class FloatLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public int f77553b;

    /* renamed from: c  reason: collision with root package name */
    public int f77554c;

    /* renamed from: d  reason: collision with root package name */
    public int f77555d;

    /* renamed from: e  reason: collision with root package name */
    public int f77556e;

    /* renamed from: f  reason: collision with root package name */
    public int f77557f;

    /* renamed from: g  reason: collision with root package name */
    public int f77558g;

    /* renamed from: h  reason: collision with root package name */
    public a f77559h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f77560i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f77561j;

    /* renamed from: k  reason: collision with root package name */
    public int f77562k;

    public interface a {
        void a(int i11, int i12);
    }

    public FloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatLayout);
        this.f77553b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatLayout_childHorizontalSpacing, 0);
        this.f77554c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatLayout_childVerticalSpacing, 0);
        this.f77555d = obtainStyledAttributes.getInteger(R$styleable.FloatLayout_android_gravity, 3);
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
            int[] iArr = this.f77560i;
            if (i12 >= iArr.length || iArr[i12] == 0) {
                break;
            }
            int paddingLeft = ((((i11 - getPaddingLeft()) - getPaddingRight()) - this.f77561j[i12]) / 2) + getPaddingLeft();
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.f77560i[i12]) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 8) {
                    i13++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    i16 = Math.max(i16, measuredHeight);
                    paddingLeft += measuredWidth + this.f77553b;
                    i14++;
                    i15++;
                    i13++;
                    if (i14 == this.f77562k) {
                        break;
                    }
                }
            }
            if (i14 == this.f77562k) {
                break;
            }
            paddingTop += i16 + this.f77554c;
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
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                if (i12 < this.f77562k) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (paddingLeft + measuredWidth > paddingRight) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += i13 + this.f77554c;
                        i13 = 0;
                    }
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    paddingLeft += measuredWidth + this.f77553b;
                    i13 = Math.max(i13, measuredHeight);
                    i12++;
                } else {
                    childAt.layout(0, 0, 0, 0);
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
            int[] iArr = this.f77560i;
            if (i12 >= iArr.length || iArr[i12] == 0) {
                break;
            }
            int paddingRight = (i11 - getPaddingRight()) - this.f77561j[i12];
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.f77560i[i12]) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 8) {
                    i13++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingRight, paddingTop, paddingRight + measuredWidth, paddingTop + measuredHeight);
                    i16 = Math.max(i16, measuredHeight);
                    paddingRight += measuredWidth + this.f77553b;
                    i14++;
                    i15++;
                    i13++;
                    if (i14 == this.f77562k) {
                        break;
                    }
                }
            }
            if (i14 == this.f77562k) {
                break;
            }
            paddingTop += i16 + this.f77554c;
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
        return this.f77555d;
    }

    public int getLineCount() {
        return this.f77558g;
    }

    public int getMaxLines() {
        if (this.f77556e == 0) {
            return this.f77557f;
        }
        return -1;
    }

    public int getMaxNumber() {
        if (this.f77556e == 1) {
            return this.f77557f;
        }
        return -1;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15 = i13 - i11;
        int i16 = this.f77555d & 7;
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

    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16 = i11;
        int i17 = i12;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int childCount = getChildCount();
        this.f77560i = new int[childCount];
        this.f77561j = new int[childCount];
        int i18 = 0;
        int i19 = 1;
        if (mode == 1073741824) {
            this.f77562k = 0;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = size - getPaddingRight();
            int i21 = 0;
            int i22 = paddingTop;
            int i23 = 0;
            while (true) {
                if (i18 < childCount) {
                    int i24 = this.f77556e;
                    if ((i24 == i19 && this.f77562k >= this.f77557f) || (i24 == 0 && i23 >= this.f77557f)) {
                        break;
                    }
                    View childAt = getChildAt(i18);
                    if (childAt.getVisibility() == 8) {
                        i15 = size;
                    } else {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        i15 = size;
                        childAt.measure(ViewGroup.getChildMeasureSpec(i16, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i17, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                        int measuredWidth = childAt.getMeasuredWidth();
                        i21 = Math.max(i21, childAt.getMeasuredHeight());
                        if (paddingLeft + measuredWidth > paddingRight) {
                            if (this.f77556e == 0 && i23 + 1 >= this.f77557f) {
                                break;
                            }
                            int[] iArr = this.f77561j;
                            iArr[i23] = iArr[i23] - this.f77553b;
                            i23++;
                            paddingLeft = getPaddingLeft();
                            i22 += this.f77554c + i21;
                        }
                        int[] iArr2 = this.f77560i;
                        iArr2[i23] = iArr2[i23] + 1;
                        int[] iArr3 = this.f77561j;
                        int i25 = iArr3[i23];
                        int i26 = this.f77553b;
                        iArr3[i23] = i25 + measuredWidth + i26;
                        paddingLeft += measuredWidth + i26;
                        this.f77562k++;
                    }
                    i18++;
                    size = i15;
                    i19 = 1;
                } else {
                    break;
                }
            }
            i15 = size;
            int[] iArr4 = this.f77561j;
            if (iArr4.length > 0 && iArr4[i23] > 0) {
                iArr4[i23] = iArr4[i23] - this.f77553b;
            }
            if (mode2 == 0) {
                size2 = i22 + i21 + getPaddingBottom();
            } else if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(i22 + i21 + getPaddingBottom(), size2);
            }
            i18 = i23;
            i13 = i15;
        } else {
            int paddingLeft2 = getPaddingLeft() + getPaddingRight();
            this.f77562k = 0;
            int i27 = 0;
            int i28 = 0;
            while (true) {
                if (i27 >= childCount) {
                    i14 = 1;
                    break;
                }
                int i29 = this.f77556e;
                i14 = 1;
                if (i29 != 1) {
                    if (i29 == 0 && 1 > this.f77557f) {
                        break;
                    }
                } else if (this.f77562k > this.f77557f) {
                    break;
                }
                View childAt2 = getChildAt(i27);
                if (childAt2.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    childAt2.measure(ViewGroup.getChildMeasureSpec(i16, getPaddingLeft() + getPaddingRight(), layoutParams2.width), ViewGroup.getChildMeasureSpec(i17, getPaddingTop() + getPaddingBottom(), layoutParams2.height));
                    paddingLeft2 += childAt2.getMeasuredWidth();
                    i28 = Math.max(i28, childAt2.getMeasuredHeight());
                    this.f77562k++;
                }
                i27++;
            }
            int i30 = this.f77562k;
            if (i30 > 0) {
                paddingLeft2 += this.f77553b * (i30 - i14);
            }
            i13 = paddingLeft2;
            size2 = i28 + getPaddingTop() + getPaddingBottom();
            int[] iArr5 = this.f77560i;
            if (iArr5.length > 0) {
                iArr5[0] = childCount;
            }
            int[] iArr6 = this.f77561j;
            if (iArr6.length > 0) {
                iArr6[0] = i13;
            }
        }
        setMeasuredDimension(i13, size2);
        int i31 = i18 + 1;
        int i32 = this.f77558g;
        if (i32 != i31) {
            a aVar = this.f77559h;
            if (aVar != null) {
                aVar.a(i32, i31);
            }
            this.f77558g = i31;
        }
    }

    public void setChildHorizontalSpacing(int i11) {
        this.f77553b = i11;
        invalidate();
    }

    public void setChildVerticalSpacing(int i11) {
        this.f77554c = i11;
        invalidate();
    }

    public void setGravity(int i11) {
        if (this.f77555d != i11) {
            this.f77555d = i11;
            requestLayout();
        }
    }

    public void setMaxLines(int i11) {
        this.f77557f = i11;
        this.f77556e = 0;
        requestLayout();
    }

    public void setMaxNumber(int i11) {
        this.f77557f = i11;
        this.f77556e = 1;
        requestLayout();
    }

    public void setOnLineCountChangeListener(a aVar) {
        this.f77559h = aVar;
    }

    public FloatLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f77556e = 0;
        this.f77557f = Integer.MAX_VALUE;
        this.f77558g = 0;
        a(context, attributeSet);
    }
}
