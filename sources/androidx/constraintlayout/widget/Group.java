package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void f(ConstraintLayout constraintLayout) {
        e(constraintLayout);
    }

    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7923f = false;
    }

    public void n(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f7969u0.f1(0);
        layoutParams.f7969u0.G0(0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    public void setElevation(float f11) {
        super.setElevation(f11);
        d();
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        d();
    }

    public Group(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
