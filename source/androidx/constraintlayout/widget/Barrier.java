package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class Barrier extends ConstraintHelper {

    /* renamed from: k  reason: collision with root package name */
    public int f7907k;

    /* renamed from: l  reason: collision with root package name */
    public int f7908l;

    /* renamed from: m  reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.Barrier f7909m;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f7909m.p1();
    }

    public int getMargin() {
        return this.f7909m.r1();
    }

    public int getType() {
        return this.f7907k;
    }

    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7909m = new androidx.constraintlayout.core.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f7909m.u1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R$styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f7909m.w1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f7922e = this.f7909m;
        s();
    }

    public void l(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.l(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            androidx.constraintlayout.core.widgets.Barrier barrier = (androidx.constraintlayout.core.widgets.Barrier) helperWidget;
            t(barrier, constraint.f8000e.f8030g0, ((ConstraintWidgetContainer) helperWidget.L()).L1());
            barrier.u1(constraint.f8000e.f8046o0);
            barrier.w1(constraint.f8000e.f8032h0);
        }
    }

    public void m(ConstraintWidget constraintWidget, boolean z11) {
        t(constraintWidget, this.f7907k, z11);
    }

    public void setAllowsGoneWidget(boolean z11) {
        this.f7909m.u1(z11);
    }

    public void setDpMargin(int i11) {
        androidx.constraintlayout.core.widgets.Barrier barrier = this.f7909m;
        barrier.w1((int) ((((float) i11) * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i11) {
        this.f7909m.w1(i11);
    }

    public void setType(int i11) {
        this.f7907k = i11;
    }

    public final void t(ConstraintWidget constraintWidget, int i11, boolean z11) {
        this.f7908l = i11;
        if (Build.VERSION.SDK_INT < 17) {
            int i12 = this.f7907k;
            if (i12 == 5) {
                this.f7908l = 0;
            } else if (i12 == 6) {
                this.f7908l = 1;
            }
        } else if (z11) {
            int i13 = this.f7907k;
            if (i13 == 5) {
                this.f7908l = 1;
            } else if (i13 == 6) {
                this.f7908l = 0;
            }
        } else {
            int i14 = this.f7907k;
            if (i14 == 5) {
                this.f7908l = 0;
            } else if (i14 == 6) {
                this.f7908l = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            ((androidx.constraintlayout.core.widgets.Barrier) constraintWidget).v1(this.f7908l);
        }
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        super.setVisibility(8);
    }
}
