package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Constraints extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public ConstraintSet f8094b;

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
        super.setVisibility(8);
    }

    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void c(AttributeSet attributeSet) {
        Log.v("Constraints", " ################# init");
    }

    public ConstraintSet getConstraintSet() {
        if (this.f8094b == null) {
            this.f8094b = new ConstraintSet();
        }
        this.f8094b.r(this);
        return this.f8094b;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(attributeSet);
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;
        public float F0;
        public float G0;
        public float H0;
        public float I0;

        /* renamed from: w0  reason: collision with root package name */
        public float f8095w0;

        /* renamed from: x0  reason: collision with root package name */
        public boolean f8096x0;

        /* renamed from: y0  reason: collision with root package name */
        public float f8097y0;

        /* renamed from: z0  reason: collision with root package name */
        public float f8098z0;

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
            this.f8095w0 = 1.0f;
            this.f8096x0 = false;
            this.f8097y0 = 0.0f;
            this.f8098z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 1.0f;
            this.D0 = 1.0f;
            this.E0 = 0.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8095w0 = 1.0f;
            this.f8096x0 = false;
            this.f8097y0 = 0.0f;
            this.f8098z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 1.0f;
            this.D0 = 1.0f;
            this.E0 = 0.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintSet_android_alpha) {
                    this.f8095w0 = obtainStyledAttributes.getFloat(index, this.f8095w0);
                } else if (index == R$styleable.ConstraintSet_android_elevation) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.f8097y0 = obtainStyledAttributes.getFloat(index, this.f8097y0);
                        this.f8096x0 = true;
                    }
                } else if (index == R$styleable.ConstraintSet_android_rotationX) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == R$styleable.ConstraintSet_android_rotationY) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == R$styleable.ConstraintSet_android_rotation) {
                    this.f8098z0 = obtainStyledAttributes.getFloat(index, this.f8098z0);
                } else if (index == R$styleable.ConstraintSet_android_scaleX) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == R$styleable.ConstraintSet_android_scaleY) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == R$styleable.ConstraintSet_android_transformPivotX) {
                    this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
                } else if (index == R$styleable.ConstraintSet_android_transformPivotY) {
                    this.F0 = obtainStyledAttributes.getFloat(index, this.F0);
                } else if (index == R$styleable.ConstraintSet_android_translationX) {
                    this.G0 = obtainStyledAttributes.getFloat(index, this.G0);
                } else if (index == R$styleable.ConstraintSet_android_translationY) {
                    this.H0 = obtainStyledAttributes.getFloat(index, this.H0);
                } else if (index == R$styleable.ConstraintSet_android_translationZ && Build.VERSION.SDK_INT >= 21) {
                    this.I0 = obtainStyledAttributes.getFloat(index, this.I0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
