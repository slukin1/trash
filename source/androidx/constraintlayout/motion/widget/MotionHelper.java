package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

public class MotionHelper extends ConstraintHelper implements MotionLayout.k {

    /* renamed from: k  reason: collision with root package name */
    public boolean f7515k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f7516l = false;

    /* renamed from: m  reason: collision with root package name */
    public float f7517m;

    /* renamed from: n  reason: collision with root package name */
    public View[] f7518n;

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(attributeSet);
    }

    public void A(View view, float f11) {
    }

    public float getProgress() {
        return this.f7517m;
    }

    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.f7515k = obtainStyledAttributes.getBoolean(index, this.f7515k);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.f7516l = obtainStyledAttributes.getBoolean(index, this.f7516l);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11) {
    }

    public void setProgress(float f11) {
        this.f7517m = f11;
        int i11 = 0;
        if (this.f7920c > 0) {
            this.f7518n = j((ConstraintLayout) getParent());
            while (i11 < this.f7920c) {
                A(this.f7518n[i11], f11);
                i11++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i11 < childCount) {
            View childAt = viewGroup.getChildAt(i11);
            if (!(childAt instanceof MotionHelper)) {
                A(childAt, f11);
            }
            i11++;
        }
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return this.f7516l;
    }

    public boolean v() {
        return this.f7515k;
    }

    public void w(MotionLayout motionLayout) {
    }

    public void x(Canvas canvas) {
    }

    public void y(Canvas canvas) {
    }

    public void z(MotionLayout motionLayout, HashMap<View, d> hashMap) {
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k(attributeSet);
    }
}
