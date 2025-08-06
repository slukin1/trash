package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.h0;
import com.huobi.view.roundimg.RoundedDrawable;

public class ButtonBarLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f4391b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4392c;

    /* renamed from: d  reason: collision with root package name */
    public int f4393d = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr = R$styleable.ButtonBarLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        h0.v0(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.f4391b = obtainStyledAttributes.getBoolean(R$styleable.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f4391b);
        }
    }

    private void setStacked(boolean z11) {
        if (this.f4392c == z11) {
            return;
        }
        if (!z11 || this.f4391b) {
            this.f4392c = z11;
            setOrientation(z11 ? 1 : 0);
            setGravity(z11 ? 8388613 : 80);
            View findViewById = findViewById(R$id.spacer);
            if (findViewById != null) {
                findViewById.setVisibility(z11 ? 8 : 4);
            }
            for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                bringChildToFront(getChildAt(childCount));
            }
        }
    }

    public final int a(int i11) {
        int childCount = getChildCount();
        while (i11 < childCount) {
            if (getChildAt(i11).getVisibility() == 0) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public final boolean b() {
        return this.f4392c;
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        int i13;
        int size = View.MeasureSpec.getSize(i11);
        int i14 = 0;
        if (this.f4391b) {
            if (size > this.f4393d && b()) {
                setStacked(false);
            }
            this.f4393d = size;
        }
        if (b() || View.MeasureSpec.getMode(i11) != 1073741824) {
            i13 = i11;
            z11 = false;
        } else {
            i13 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z11 = true;
        }
        super.onMeasure(i13, i12);
        if (this.f4391b && !b()) {
            if ((getMeasuredWidthAndState() & RoundedDrawable.DEFAULT_BORDER_COLOR) == 16777216) {
                setStacked(true);
                z11 = true;
            }
        }
        if (z11) {
            super.onMeasure(i11, i12);
        }
        int a11 = a(0);
        if (a11 >= 0) {
            View childAt = getChildAt(a11);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int a12 = a(a11 + 1);
                if (a12 >= 0) {
                    paddingTop += getChildAt(a12).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i14 = paddingTop;
            } else {
                i14 = paddingTop + getPaddingBottom();
            }
        }
        if (h0.G(this) != i14) {
            setMinimumHeight(i14);
            if (i12 == 0) {
                super.onMeasure(i11, i12);
            }
        }
    }

    public void setAllowStacking(boolean z11) {
        if (this.f4391b != z11) {
            this.f4391b = z11;
            if (!z11 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
