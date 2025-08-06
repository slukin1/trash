package com.hbg.module.community.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.module.content.R$styleable;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {

    /* renamed from: r  reason: collision with root package name */
    public static final String f17591r = FlowLayout.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public boolean f17592b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f17593c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f17594d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f17595e = -65538;

    /* renamed from: f  reason: collision with root package name */
    public float f17596f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f17597g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17598h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f17599i = Integer.MAX_VALUE;

    /* renamed from: j  reason: collision with root package name */
    public int f17600j = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f17601k = -65536;

    /* renamed from: l  reason: collision with root package name */
    public int f17602l;

    /* renamed from: m  reason: collision with root package name */
    public List<Float> f17603m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public List<Integer> f17604n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public List<Integer> f17605o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public List<Integer> f17606p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public a f17607q = null;

    public interface a {
        void a();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.FlowLayout, 0, 0);
        try {
            this.f17592b = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_flFlow, true);
            this.f17593c = b(obtainStyledAttributes, R$styleable.FlowLayout_flChildSpacing, (int) a(0.0f));
            this.f17594d = b(obtainStyledAttributes, R$styleable.FlowLayout_flMinChildSpacing, (int) a(0.0f));
            this.f17595e = b(obtainStyledAttributes, R$styleable.FlowLayout_flChildSpacingForLastRow, -65538);
            this.f17596f = (float) b(obtainStyledAttributes, R$styleable.FlowLayout_flRowSpacing, (int) a(0.0f));
            this.f17599i = obtainStyledAttributes.getInt(R$styleable.FlowLayout_flMaxRows, Integer.MAX_VALUE);
            this.f17598h = obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_flRtl, false);
            this.f17600j = obtainStyledAttributes.getInt(R$styleable.FlowLayout_android_gravity, -1);
            this.f17601k = obtainStyledAttributes.getInt(R$styleable.FlowLayout_flRowVerticalGravity, -65536);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final float a(float f11) {
        return TypedValue.applyDimension(1, f11, getResources().getDisplayMetrics());
    }

    public final int b(TypedArray typedArray, int i11, int i12) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i11, typedValue);
        if (typedValue.type == 5) {
            return typedArray.getDimensionPixelSize(i11, i12);
        }
        return typedArray.getInt(i11, i12);
    }

    public final int c(int i11, int i12, int i13, int i14) {
        if (this.f17593c == -65536 || i14 >= this.f17605o.size() || i14 >= this.f17606p.size() || this.f17606p.get(i14).intValue() <= 0) {
            return 0;
        }
        if (i11 == 1) {
            return ((i12 - i13) - this.f17605o.get(i14).intValue()) / 2;
        }
        if (i11 != 5) {
            return 0;
        }
        return (i12 - i13) - this.f17605o.get(i14).intValue();
    }

    public final float d(int i11, int i12, int i13, int i14) {
        if (i11 != -65536) {
            return (float) i11;
        }
        if (i14 > 1) {
            return (float) ((i12 - i13) / (i14 - 1));
        }
        return 0.0f;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.f17593c;
    }

    public int getChildSpacingForLastRow() {
        return this.f17595e;
    }

    public int getMaxRows() {
        return this.f17599i;
    }

    public int getMinChildSpacing() {
        return this.f17594d;
    }

    public float getRowSpacing() {
        return this.f17596f;
    }

    public int getRowsCount() {
        return this.f17606p.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            r23 = this;
            r0 = r23
            int r1 = r23.getPaddingLeft()
            int r2 = r23.getPaddingRight()
            int r3 = r23.getPaddingTop()
            int r4 = r23.getPaddingBottom()
            boolean r5 = r0.f17598h
            if (r5 == 0) goto L_0x001c
            int r5 = r23.getWidth()
            int r5 = r5 - r2
            goto L_0x001d
        L_0x001c:
            r5 = r1
        L_0x001d:
            int r6 = r0.f17600j
            r7 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 & 7
            r8 = 80
            r9 = 16
            if (r7 == r9) goto L_0x0034
            if (r7 == r8) goto L_0x002c
            goto L_0x003e
        L_0x002c:
            int r7 = r28 - r26
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.f17602l
            int r7 = r7 - r4
            goto L_0x003d
        L_0x0034:
            int r7 = r28 - r26
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.f17602l
            int r7 = r7 - r4
            int r7 = r7 / 2
        L_0x003d:
            int r3 = r3 + r7
        L_0x003e:
            int r4 = r1 + r2
            int r7 = r27 - r25
            r10 = 0
            int r11 = r0.c(r6, r7, r4, r10)
            int r5 = r5 + r11
            int r11 = r0.f17601k
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.util.List<java.lang.Integer> r12 = r0.f17606p
            int r12 = r12.size()
            r13 = r10
            r14 = r13
        L_0x0054:
            int r15 = r0.f17599i
            int r15 = java.lang.Math.min(r12, r15)
            if (r13 >= r15) goto L_0x016c
            java.util.List<java.lang.Integer> r15 = r0.f17606p
            java.lang.Object r15 = r15.get(r13)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            java.util.List<java.lang.Integer> r9 = r0.f17604n
            java.lang.Object r9 = r9.get(r13)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.util.List<java.lang.Float> r8 = r0.f17603m
            java.lang.Object r8 = r8.get(r13)
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            r10 = 0
        L_0x0081:
            r16 = r1
            if (r10 >= r15) goto L_0x0136
            int r1 = r23.getChildCount()
            if (r14 >= r1) goto L_0x0136
            int r1 = r14 + 1
            android.view.View r14 = r0.getChildAt(r14)
            r26 = r1
            int r1 = r14.getVisibility()
            r27 = r12
            r12 = 8
            if (r1 != r12) goto L_0x00a4
            r14 = r26
            r12 = r27
            r1 = r16
            goto L_0x0081
        L_0x00a4:
            int r10 = r10 + 1
            android.view.ViewGroup$LayoutParams r1 = r14.getLayoutParams()
            boolean r12 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r12 == 0) goto L_0x00c6
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r12 = r1.leftMargin
            r28 = r10
            int r10 = r1.rightMargin
            r17 = r10
            int r10 = r1.topMargin
            int r1 = r1.bottomMargin
            r18 = r4
            r22 = r15
            r15 = r12
            r12 = r17
            r17 = r22
            goto L_0x00d0
        L_0x00c6:
            r28 = r10
            r18 = r4
            r17 = r15
            r1 = 0
            r10 = 0
            r12 = 0
            r15 = 0
        L_0x00d0:
            int r4 = r14.getMeasuredWidth()
            int r19 = r14.getMeasuredHeight()
            int r20 = r3 + r10
            r21 = r6
            r6 = 80
            if (r11 != r6) goto L_0x00ea
            int r10 = r3 + r9
            int r10 = r10 - r1
            int r20 = r10 - r19
            r1 = r20
            r6 = 16
            goto L_0x00f9
        L_0x00ea:
            r6 = 16
            if (r11 != r6) goto L_0x00f7
            int r10 = r9 - r10
            int r10 = r10 - r1
            int r10 = r10 - r19
            int r10 = r10 / 2
            int r20 = r20 + r10
        L_0x00f7:
            r1 = r20
        L_0x00f9:
            int r10 = r1 + r19
            boolean r6 = r0.f17598h
            if (r6 == 0) goto L_0x0111
            int r6 = r5 - r12
            r19 = r11
            int r11 = r6 - r4
            r14.layout(r11, r1, r6, r10)
            float r1 = (float) r5
            float r4 = (float) r4
            float r4 = r4 + r8
            float r5 = (float) r15
            float r4 = r4 + r5
            float r5 = (float) r12
            float r4 = r4 + r5
            float r1 = r1 - r4
            goto L_0x0122
        L_0x0111:
            r19 = r11
            int r6 = r5 + r15
            int r11 = r6 + r4
            r14.layout(r6, r1, r11, r10)
            float r1 = (float) r5
            float r4 = (float) r4
            float r4 = r4 + r8
            float r5 = (float) r15
            float r4 = r4 + r5
            float r5 = (float) r12
            float r4 = r4 + r5
            float r1 = r1 + r4
        L_0x0122:
            int r1 = (int) r1
            r5 = r1
            r14 = r26
            r12 = r27
            r10 = r28
            r1 = r16
            r15 = r17
            r4 = r18
            r11 = r19
            r6 = r21
            goto L_0x0081
        L_0x0136:
            r18 = r4
            r21 = r6
            r19 = r11
            r27 = r12
            boolean r1 = r0.f17598h
            if (r1 == 0) goto L_0x0148
            int r1 = r23.getWidth()
            int r1 = r1 - r2
            goto L_0x014a
        L_0x0148:
            r1 = r16
        L_0x014a:
            int r13 = r13 + 1
            r5 = r18
            r4 = r21
            int r6 = r0.c(r4, r7, r5, r13)
            int r1 = r1 + r6
            float r3 = (float) r3
            float r6 = (float) r9
            float r8 = r0.f17597g
            float r6 = r6 + r8
            float r3 = r3 + r6
            int r3 = (int) r3
            r12 = r27
            r6 = r4
            r4 = r5
            r11 = r19
            r8 = 80
            r9 = 16
            r10 = 0
            r5 = r1
            r1 = r16
            goto L_0x0054
        L_0x016c:
            int r1 = r23.getChildCount()
            if (r14 >= r1) goto L_0x0187
            android.view.View r1 = r0.getChildAt(r14)
            int r2 = r1.getVisibility()
            r3 = 8
            if (r2 != r3) goto L_0x0180
            r2 = 0
            goto L_0x0184
        L_0x0180:
            r2 = 0
            r1.layout(r2, r2, r2, r2)
        L_0x0184:
            int r14 = r14 + 1
            goto L_0x016c
        L_0x0187:
            com.hbg.module.community.view.FlowLayout$a r1 = r0.f17607q
            if (r1 == 0) goto L_0x018e
            r1.a()
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.view.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        float f11;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        View view;
        int i30;
        int i31;
        super.onMeasure(i11, i12);
        int size = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i12);
        this.f17603m.clear();
        this.f17604n.clear();
        this.f17605o.clear();
        this.f17606p.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z11 = mode != 0 && this.f17592b;
        int i32 = this.f17593c;
        int i33 = -65536;
        int i34 = (i32 == -65536 && mode == 0) ? 0 : i32;
        float f12 = i34 == -65536 ? (float) this.f17594d : (float) i34;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        while (i37 < childCount) {
            float f13 = f12;
            View childAt = getChildAt(i37);
            int i42 = i35;
            if (childAt.getVisibility() == 8) {
                int i43 = i11;
                i17 = i37;
                i25 = i34;
                i19 = mode;
                i16 = mode2;
                i18 = childCount;
                f11 = f13;
                i23 = -65536;
                i26 = i36;
                i22 = size;
                i24 = i42;
                int i44 = i12;
                i21 = size2;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i18 = childCount;
                    i28 = i42;
                    i21 = size2;
                    i29 = i36;
                    i17 = i37;
                    i16 = mode2;
                    f11 = f13;
                    i22 = size;
                    view = childAt;
                    i27 = i34;
                    i19 = mode;
                    i23 = -65536;
                    measureChildWithMargins(childAt, i11, 0, i12, i40);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i31 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i30 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    int i45 = i11;
                    int i46 = i12;
                } else {
                    i17 = i37;
                    i27 = i34;
                    i19 = mode;
                    i16 = mode2;
                    i18 = childCount;
                    f11 = f13;
                    i28 = i42;
                    i23 = -65536;
                    i22 = size;
                    i21 = size2;
                    i29 = i36;
                    view = childAt;
                    measureChild(view, i11, i12);
                    i31 = 0;
                    i30 = 0;
                }
                i26 = i31 + view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight() + i30;
                if (!z11 || i39 + i26 <= paddingLeft) {
                    i25 = i27;
                    i24 = i28 + 1;
                    i39 = (int) (((float) i39) + ((float) i26) + f11);
                    i26 += i29;
                    i41 = Math.max(i41, measuredHeight);
                } else {
                    i25 = i27;
                    this.f17603m.add(Float.valueOf(d(i25, paddingLeft, i29, i28)));
                    this.f17606p.add(Integer.valueOf(i28));
                    this.f17604n.add(Integer.valueOf(i41));
                    int i47 = (int) f11;
                    this.f17605o.add(Integer.valueOf(i39 - i47));
                    if (this.f17603m.size() <= this.f17599i) {
                        i40 += i41;
                    }
                    i38 = Math.max(i38, i39);
                    i39 = i26 + i47;
                    i41 = measuredHeight;
                    i24 = 1;
                }
            }
            i36 = i26;
            i37 = i17 + 1;
            i34 = i25;
            i35 = i24;
            i33 = i23;
            f12 = f11;
            size = i22;
            size2 = i21;
            mode = i19;
            childCount = i18;
            mode2 = i16;
        }
        int i48 = i35;
        int i49 = size;
        int i50 = mode;
        int i51 = size2;
        int i52 = mode2;
        int i53 = i36;
        float f14 = f12;
        int i54 = i33;
        int i55 = i41;
        int i56 = i34;
        int i57 = this.f17595e;
        if (i57 == -65537) {
            if (this.f17603m.size() >= 1) {
                List<Float> list = this.f17603m;
                list.add(list.get(list.size() - 1));
            } else {
                this.f17603m.add(Float.valueOf(d(i56, paddingLeft, i53, i48)));
            }
        } else if (i57 != -65538) {
            this.f17603m.add(Float.valueOf(d(i57, paddingLeft, i53, i48)));
        } else {
            this.f17603m.add(Float.valueOf(d(i56, paddingLeft, i53, i48)));
        }
        this.f17606p.add(Integer.valueOf(i48));
        this.f17604n.add(Integer.valueOf(i55));
        this.f17605o.add(Integer.valueOf(i39 - ((int) f14)));
        if (this.f17603m.size() <= this.f17599i) {
            i40 += i55;
        }
        int max = Math.max(i38, i39);
        if (i56 == i54) {
            i14 = i49;
            i13 = i14;
        } else if (i50 == 0) {
            i14 = max + getPaddingLeft() + getPaddingRight();
            i13 = i49;
        } else {
            i13 = i49;
            i14 = Math.min(max + getPaddingLeft() + getPaddingRight(), i13);
        }
        int paddingTop = i40 + getPaddingTop() + getPaddingBottom();
        int min = Math.min(this.f17603m.size(), this.f17599i);
        float f15 = this.f17596f;
        if (f15 == -65536.0f && i52 == 0) {
            f15 = 0.0f;
        }
        if (f15 == -65536.0f) {
            if (min > 1) {
                this.f17597g = (float) ((i51 - paddingTop) / (min - 1));
            } else {
                this.f17597g = 0.0f;
            }
            paddingTop = i51;
            i15 = paddingTop;
        } else {
            this.f17597g = f15;
            if (min > 1) {
                if (i52 == 0) {
                    paddingTop = (int) (((float) paddingTop) + (f15 * ((float) (min - 1))));
                } else {
                    i15 = i51;
                    paddingTop = Math.min((int) (((float) paddingTop) + (f15 * ((float) (min - 1)))), i15);
                }
            }
            i15 = i51;
        }
        this.f17602l = paddingTop;
        setMeasuredDimension(i50 == 1073741824 ? i13 : i14, i52 == 1073741824 ? i15 : paddingTop);
    }

    public void setChildSpacing(int i11) {
        this.f17593c = i11;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i11) {
        this.f17595e = i11;
        requestLayout();
    }

    public void setFlow(boolean z11) {
        this.f17592b = z11;
        requestLayout();
    }

    public void setGravity(int i11) {
        if (this.f17600j != i11) {
            this.f17600j = i11;
            requestLayout();
        }
    }

    public void setMaxRows(int i11) {
        this.f17599i = i11;
        requestLayout();
    }

    public void setMinChildSpacing(int i11) {
        this.f17594d = i11;
        requestLayout();
    }

    public void setOnLayoutFinishListener(a aVar) {
        this.f17607q = aVar;
    }

    public void setRowSpacing(float f11) {
        this.f17596f = f11;
        requestLayout();
    }

    public void setRowVerticalGravity(int i11) {
        if (this.f17601k != i11) {
            this.f17601k = i11;
            requestLayout();
        }
    }

    public void setRtl(boolean z11) {
        this.f17598h = z11;
        requestLayout();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }
}
