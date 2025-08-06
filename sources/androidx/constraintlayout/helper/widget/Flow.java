package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;

public class Flow extends VirtualLayout {

    /* renamed from: m  reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.Flow f7344m;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7344m = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f7344m.x2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_padding) {
                    this.f7344m.D1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingStart) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.f7344m.I1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        this.f7344m.F1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f7344m.G1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f7344m.J1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f7344m.H1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f7344m.E1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f7344m.C2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f7344m.r2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f7344m.B2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f7344m.l2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f7344m.t2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f7344m.n2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f7344m.v2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f7344m.p2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f7344m.k2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f7344m.s2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f7344m.m2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f7344m.u2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f7344m.z2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f7344m.o2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f7344m.y2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f7344m.q2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f7344m.A2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R$styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f7344m.w2(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f7922e = this.f7344m;
        s();
    }

    public void l(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.l(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            int i11 = layoutParams.Y;
            if (i11 != -1) {
                flow.x2(i11);
            }
        }
    }

    public void m(ConstraintWidget constraintWidget, boolean z11) {
        this.f7344m.o1(z11);
    }

    @SuppressLint({"WrongCall"})
    public void onMeasure(int i11, int i12) {
        t(this.f7344m, i11, i12);
    }

    public void setFirstHorizontalBias(float f11) {
        this.f7344m.k2(f11);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i11) {
        this.f7344m.l2(i11);
        requestLayout();
    }

    public void setFirstVerticalBias(float f11) {
        this.f7344m.m2(f11);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i11) {
        this.f7344m.n2(i11);
        requestLayout();
    }

    public void setHorizontalAlign(int i11) {
        this.f7344m.o2(i11);
        requestLayout();
    }

    public void setHorizontalBias(float f11) {
        this.f7344m.p2(f11);
        requestLayout();
    }

    public void setHorizontalGap(int i11) {
        this.f7344m.q2(i11);
        requestLayout();
    }

    public void setHorizontalStyle(int i11) {
        this.f7344m.r2(i11);
        requestLayout();
    }

    public void setMaxElementsWrap(int i11) {
        this.f7344m.w2(i11);
        requestLayout();
    }

    public void setOrientation(int i11) {
        this.f7344m.x2(i11);
        requestLayout();
    }

    public void setPadding(int i11) {
        this.f7344m.D1(i11);
        requestLayout();
    }

    public void setPaddingBottom(int i11) {
        this.f7344m.E1(i11);
        requestLayout();
    }

    public void setPaddingLeft(int i11) {
        this.f7344m.G1(i11);
        requestLayout();
    }

    public void setPaddingRight(int i11) {
        this.f7344m.H1(i11);
        requestLayout();
    }

    public void setPaddingTop(int i11) {
        this.f7344m.J1(i11);
        requestLayout();
    }

    public void setVerticalAlign(int i11) {
        this.f7344m.y2(i11);
        requestLayout();
    }

    public void setVerticalBias(float f11) {
        this.f7344m.z2(f11);
        requestLayout();
    }

    public void setVerticalGap(int i11) {
        this.f7344m.A2(i11);
        requestLayout();
    }

    public void setVerticalStyle(int i11) {
        this.f7344m.B2(i11);
        requestLayout();
    }

    public void setWrapMode(int i11) {
        this.f7344m.C2(i11);
        requestLayout();
    }

    public void t(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (virtualLayout != null) {
            virtualLayout.x1(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.s1(), virtualLayout.r1());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public Flow(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
