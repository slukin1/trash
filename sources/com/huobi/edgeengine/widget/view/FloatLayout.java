package com.huobi.edgeengine.widget.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.R$styleable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class FloatLayout extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public int f44437b;

    /* renamed from: c  reason: collision with root package name */
    public int f44438c;

    /* renamed from: d  reason: collision with root package name */
    public int f44439d;

    /* renamed from: e  reason: collision with root package name */
    public int f44440e;

    /* renamed from: f  reason: collision with root package name */
    public int f44441f;

    /* renamed from: g  reason: collision with root package name */
    public int f44442g;

    /* renamed from: h  reason: collision with root package name */
    public a f44443h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f44444i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f44445j;

    /* renamed from: k  reason: collision with root package name */
    public int f44446k;

    /* renamed from: l  reason: collision with root package name */
    public View.OnClickListener f44447l;

    public interface a {
        void a(int i11, int i12);
    }

    public FloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c(View view) {
        this.f44447l.onClick(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatLayout);
        this.f44437b = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f44438c = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f44439d = obtainStyledAttributes.getInteger(0, 3);
        int i11 = obtainStyledAttributes.getInt(1, -1);
        if (i11 >= 0) {
            setMaxLines(i11);
        }
        int i12 = obtainStyledAttributes.getInt(4, -1);
        if (i12 >= 0) {
            setMaxNumber(i12);
        }
        obtainStyledAttributes.recycle();
    }

    public final void d(int i11) {
        int paddingTop = getPaddingTop();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int[] iArr = this.f44444i;
            if (i12 >= iArr.length || iArr[i12] == 0) {
                break;
            }
            int paddingLeft = ((((i11 - getPaddingLeft()) - getPaddingRight()) - this.f44445j[i12]) / 2) + getPaddingLeft();
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.f44444i[i12]) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 8) {
                    i13++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    i16 = Math.max(i16, measuredHeight);
                    paddingLeft += measuredWidth + this.f44437b;
                    i14++;
                    i15++;
                    i13++;
                    if (i14 == this.f44446k) {
                        break;
                    }
                }
            }
            if (i14 == this.f44446k) {
                break;
            }
            paddingTop += i16 + this.f44438c;
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

    public final void e(int i11) {
        int paddingRight = i11 - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i12 = 1;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                childAt.setOnClickListener(new gk.a(this));
                if (i13 < this.f44446k) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (i12 == 1) {
                        paddingRight -= 34;
                    } else {
                        paddingRight = i11 - getPaddingRight();
                    }
                    if (paddingLeft + measuredWidth > paddingRight) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += i14 + this.f44438c;
                        i12++;
                        i14 = 0;
                    }
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    paddingLeft += measuredWidth + this.f44437b;
                    i14 = Math.max(i14, measuredHeight);
                    i13++;
                } else {
                    childAt.layout(0, 0, 0, 0);
                }
            }
        }
    }

    public final void f(int i11) {
        int paddingTop = getPaddingTop();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int[] iArr = this.f44444i;
            if (i12 >= iArr.length || iArr[i12] == 0) {
                break;
            }
            int paddingRight = (i11 - getPaddingRight()) - this.f44445j[i12];
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.f44444i[i12]) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 8) {
                    i13++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingRight, paddingTop, paddingRight + measuredWidth, paddingTop + measuredHeight);
                    i16 = Math.max(i16, measuredHeight);
                    paddingRight += measuredWidth + this.f44437b;
                    i14++;
                    i15++;
                    i13++;
                    if (i14 == this.f44446k) {
                        break;
                    }
                }
            }
            if (i14 == this.f44446k) {
                break;
            }
            paddingTop += i16 + this.f44438c;
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
        return this.f44439d;
    }

    public int getLineCount() {
        return this.f44442g;
    }

    public int getMaxLines() {
        if (this.f44440e == 0) {
            return this.f44441f;
        }
        return -1;
    }

    public int getMaxNumber() {
        if (this.f44440e == 1) {
            return this.f44441f;
        }
        return -1;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15 = i13 - i11;
        int i16 = this.f44439d & 7;
        if (i16 == 1) {
            d(i15);
        } else if (i16 == 3) {
            e(i15);
        } else if (i16 != 5) {
            e(i15);
        } else {
            f(i15);
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
        this.f44444i = new int[childCount];
        this.f44445j = new int[childCount];
        int i18 = 0;
        int i19 = 1;
        if (mode == 1073741824) {
            this.f44446k = 0;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = size - getPaddingRight();
            int i21 = 0;
            int i22 = paddingTop;
            int i23 = 0;
            while (true) {
                if (i18 < childCount) {
                    int i24 = this.f44440e;
                    if ((i24 == i19 && this.f44446k >= this.f44441f) || (i24 == 0 && i23 >= this.f44441f)) {
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
                            if (this.f44440e == 0 && i23 + 1 >= this.f44441f) {
                                break;
                            }
                            int[] iArr = this.f44445j;
                            iArr[i23] = iArr[i23] - this.f44437b;
                            i23++;
                            paddingLeft = getPaddingLeft();
                            i22 += this.f44438c + i21;
                        }
                        int[] iArr2 = this.f44444i;
                        iArr2[i23] = iArr2[i23] + 1;
                        int[] iArr3 = this.f44445j;
                        int i25 = iArr3[i23];
                        int i26 = this.f44437b;
                        iArr3[i23] = i25 + measuredWidth + i26;
                        paddingLeft += measuredWidth + i26;
                        this.f44446k++;
                    }
                    i18++;
                    size = i15;
                    i19 = 1;
                } else {
                    break;
                }
            }
            i15 = size;
            int[] iArr4 = this.f44445j;
            if (iArr4.length > 0 && iArr4[i23] > 0) {
                iArr4[i23] = iArr4[i23] - this.f44437b;
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
            this.f44446k = 0;
            int i27 = 0;
            int i28 = 0;
            while (true) {
                if (i27 >= childCount) {
                    i14 = 1;
                    break;
                }
                int i29 = this.f44440e;
                i14 = 1;
                if (i29 != 1) {
                    if (i29 == 0 && 1 > this.f44441f) {
                        break;
                    }
                } else if (this.f44446k > this.f44441f) {
                    break;
                }
                View childAt2 = getChildAt(i27);
                if (childAt2.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    childAt2.measure(ViewGroup.getChildMeasureSpec(i16, getPaddingLeft() + getPaddingRight(), layoutParams2.width), ViewGroup.getChildMeasureSpec(i17, getPaddingTop() + getPaddingBottom(), layoutParams2.height));
                    paddingLeft2 += childAt2.getMeasuredWidth();
                    i28 = Math.max(i28, childAt2.getMeasuredHeight());
                    this.f44446k++;
                }
                i27++;
            }
            int i30 = this.f44446k;
            if (i30 > 0) {
                paddingLeft2 += this.f44437b * (i30 - i14);
            }
            i13 = paddingLeft2;
            size2 = i28 + getPaddingTop() + getPaddingBottom();
            int[] iArr5 = this.f44444i;
            if (iArr5.length > 0) {
                iArr5[0] = childCount;
            }
            int[] iArr6 = this.f44445j;
            if (iArr6.length > 0) {
                iArr6[0] = i13;
            }
        }
        setMeasuredDimension(i13, size2);
        int i31 = i18 + 1;
        int i32 = this.f44442g;
        if (i32 != i31) {
            a aVar = this.f44443h;
            if (aVar != null) {
                aVar.a(i32, i31);
            }
            this.f44442g = i31;
        }
    }

    public void setChildHorizontalSpacing(int i11) {
        this.f44437b = i11;
        invalidate();
    }

    public void setChildVerticalSpacing(int i11) {
        this.f44438c = i11;
        invalidate();
    }

    public void setGravity(int i11) {
        if (this.f44439d != i11) {
            this.f44439d = i11;
            requestLayout();
        }
    }

    public void setMaxLines(int i11) {
        this.f44441f = i11;
        this.f44440e = 0;
        requestLayout();
    }

    public void setMaxNumber(int i11) {
        this.f44441f = i11;
        this.f44440e = 1;
        requestLayout();
    }

    public void setOnChildClickListener(View.OnClickListener onClickListener) {
        this.f44447l = onClickListener;
    }

    public void setOnLineCountChangeListener(a aVar) {
        this.f44443h = aVar;
    }

    public FloatLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44440e = 0;
        this.f44441f = Integer.MAX_VALUE;
        this.f44442g = 0;
        b(context, attributeSet);
    }
}
