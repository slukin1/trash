package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.h0;

public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static int b(View view) {
        int G = h0.G(view);
        if (G > 0) {
            return G;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return b(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    public final boolean c(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        int i19 = i12;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() != 8) {
                int id2 = childAt.getId();
                if (id2 == R$id.topPanel) {
                    view = childAt;
                } else if (id2 == R$id.buttonPanel) {
                    view2 = childAt;
                } else if ((id2 != R$id.contentPanel && id2 != R$id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i11);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i18, 0);
            paddingTop += view.getMeasuredHeight();
            i13 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i13 = 0;
        }
        if (view2 != null) {
            view2.measure(i18, 0);
            i15 = b(view2);
            i14 = view2.getMeasuredHeight() - i15;
            paddingTop += i15;
            i13 = View.combineMeasuredStates(i13, view2.getMeasuredState());
        } else {
            i15 = 0;
            i14 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                i17 = 0;
            } else {
                i17 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i18, i17);
            i16 = view3.getMeasuredHeight();
            paddingTop += i16;
            i13 = View.combineMeasuredStates(i13, view3.getMeasuredState());
        } else {
            i16 = 0;
        }
        int i22 = size - paddingTop;
        if (view2 != null) {
            int i23 = paddingTop - i15;
            int min = Math.min(i22, i14);
            if (min > 0) {
                i22 -= min;
                i15 += min;
            }
            view2.measure(i18, View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
            paddingTop = i23 + view2.getMeasuredHeight();
            i13 = View.combineMeasuredStates(i13, view2.getMeasuredState());
        }
        if (view3 != null && i22 > 0) {
            view3.measure(i18, View.MeasureSpec.makeMeasureSpec(i16 + i22, mode));
            paddingTop = (paddingTop - i16) + view3.getMeasuredHeight();
            i13 = View.combineMeasuredStates(i13, view3.getMeasuredState());
        }
        int i24 = 0;
        for (int i25 = 0; i25 < childCount; i25++) {
            View childAt2 = getChildAt(i25);
            if (childAt2.getVisibility() != 8) {
                i24 = Math.max(i24, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i24 + getPaddingLeft() + getPaddingRight(), i18, i13), View.resolveSizeAndState(paddingTop, i19, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i19);
        return true;
    }

    public final void forceUniformWidth(int i11, int i12) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i13 = 0; i13 < i11; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i14 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i12, 0);
                    layoutParams.height = i14;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r21 - r19
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r0 = r17.getMeasuredHeight()
            int r10 = r17.getChildCount()
            int r1 = r17.getGravity()
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r1 & r3
            r1 = 16
            if (r2 == r1) goto L_0x0040
            r1 = 80
            if (r2 == r1) goto L_0x0035
            int r0 = r17.getPaddingTop()
            goto L_0x004b
        L_0x0035:
            int r1 = r17.getPaddingTop()
            int r1 = r1 + r22
            int r1 = r1 - r20
            int r0 = r1 - r0
            goto L_0x004b
        L_0x0040:
            int r1 = r17.getPaddingTop()
            int r2 = r22 - r20
            int r2 = r2 - r0
            int r2 = r2 / 2
            int r0 = r1 + r2
        L_0x004b:
            android.graphics.drawable.Drawable r1 = r17.getDividerDrawable()
            r2 = 0
            if (r1 != 0) goto L_0x0054
            r12 = r2
            goto L_0x0059
        L_0x0054:
            int r1 = r1.getIntrinsicHeight()
            r12 = r1
        L_0x0059:
            r13 = r2
        L_0x005a:
            if (r13 >= r10) goto L_0x00bf
            android.view.View r1 = r6.getChildAt(r13)
            if (r1 == 0) goto L_0x00bc
            int r2 = r1.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00bc
            int r4 = r1.getMeasuredWidth()
            int r14 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r15 = r2
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r15 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r15
            int r2 = r15.gravity
            if (r2 >= 0) goto L_0x007e
            r2 = r11
        L_0x007e:
            int r3 = androidx.core.view.h0.F(r17)
            int r2 = androidx.core.view.f.b(r2, r3)
            r2 = r2 & 7
            r3 = 1
            if (r2 == r3) goto L_0x0097
            r3 = 5
            if (r2 == r3) goto L_0x0092
            int r2 = r15.leftMargin
            int r2 = r2 + r7
            goto L_0x00a2
        L_0x0092:
            int r2 = r8 - r4
            int r3 = r15.rightMargin
            goto L_0x00a1
        L_0x0097:
            int r2 = r9 - r4
            int r2 = r2 / 2
            int r2 = r2 + r7
            int r3 = r15.leftMargin
            int r2 = r2 + r3
            int r3 = r15.rightMargin
        L_0x00a1:
            int r2 = r2 - r3
        L_0x00a2:
            boolean r3 = r6.hasDividerBeforeChildAt(r13)
            if (r3 == 0) goto L_0x00a9
            int r0 = r0 + r12
        L_0x00a9:
            int r3 = r15.topMargin
            int r16 = r0 + r3
            r0 = r17
            r3 = r16
            r5 = r14
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r0 = r15.bottomMargin
            int r14 = r14 + r0
            int r16 = r16 + r14
            r0 = r16
        L_0x00bc:
            int r13 = r13 + 1
            goto L_0x005a
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i11, int i12) {
        if (!c(i11, i12)) {
            super.onMeasure(i11, i12);
        }
    }

    public final void setChildFrame(View view, int i11, int i12, int i13, int i14) {
        view.layout(i11, i12, i13 + i11, i14 + i12);
    }
}
