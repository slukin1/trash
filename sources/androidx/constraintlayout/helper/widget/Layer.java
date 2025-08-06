package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

public class Layer extends ConstraintHelper {
    public boolean A;
    public boolean B;

    /* renamed from: k  reason: collision with root package name */
    public float f7345k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f7346l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f7347m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public ConstraintLayout f7348n;

    /* renamed from: o  reason: collision with root package name */
    public float f7349o = 1.0f;

    /* renamed from: p  reason: collision with root package name */
    public float f7350p = 1.0f;

    /* renamed from: q  reason: collision with root package name */
    public float f7351q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    public float f7352r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    public float f7353s = Float.NaN;

    /* renamed from: t  reason: collision with root package name */
    public float f7354t = Float.NaN;

    /* renamed from: u  reason: collision with root package name */
    public float f7355u = Float.NaN;

    /* renamed from: v  reason: collision with root package name */
    public float f7356v = Float.NaN;

    /* renamed from: w  reason: collision with root package name */
    public boolean f7357w = true;

    /* renamed from: x  reason: collision with root package name */
    public View[] f7358x = null;

    /* renamed from: y  reason: collision with root package name */
    public float f7359y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    public float f7360z = 0.0f;

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void f(ConstraintLayout constraintLayout) {
        e(constraintLayout);
    }

    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        this.f7923f = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.A = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.B = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void n(ConstraintLayout constraintLayout) {
        u();
        this.f7351q = Float.NaN;
        this.f7352r = Float.NaN;
        ConstraintWidget b11 = ((ConstraintLayout.LayoutParams) getLayoutParams()).b();
        b11.f1(0);
        b11.G0(0);
        t();
        layout(((int) this.f7355u) - getPaddingLeft(), ((int) this.f7356v) - getPaddingTop(), ((int) this.f7353s) + getPaddingRight(), ((int) this.f7354t) + getPaddingBottom());
        v();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7348n = (ConstraintLayout) getParent();
        if (this.A || this.B) {
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i11 = 0; i11 < this.f7920c; i11++) {
                View viewById = this.f7348n.getViewById(this.f7919b[i11]);
                if (viewById != null) {
                    if (this.A) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.B && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public void p(ConstraintLayout constraintLayout) {
        this.f7348n = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f7347m = rotation;
        } else if (!Float.isNaN(this.f7347m)) {
            this.f7347m = rotation;
        }
    }

    public void setElevation(float f11) {
        super.setElevation(f11);
        d();
    }

    public void setPivotX(float f11) {
        this.f7345k = f11;
        v();
    }

    public void setPivotY(float f11) {
        this.f7346l = f11;
        v();
    }

    public void setRotation(float f11) {
        this.f7347m = f11;
        v();
    }

    public void setScaleX(float f11) {
        this.f7349o = f11;
        v();
    }

    public void setScaleY(float f11) {
        this.f7350p = f11;
        v();
    }

    public void setTranslationX(float f11) {
        this.f7359y = f11;
        v();
    }

    public void setTranslationY(float f11) {
        this.f7360z = f11;
        v();
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        d();
    }

    public void t() {
        if (this.f7348n != null) {
            if (!this.f7357w && !Float.isNaN(this.f7351q) && !Float.isNaN(this.f7352r)) {
                return;
            }
            if (Float.isNaN(this.f7345k) || Float.isNaN(this.f7346l)) {
                View[] j11 = j(this.f7348n);
                int left = j11[0].getLeft();
                int top = j11[0].getTop();
                int right = j11[0].getRight();
                int bottom = j11[0].getBottom();
                for (int i11 = 0; i11 < this.f7920c; i11++) {
                    View view = j11[i11];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.f7353s = (float) right;
                this.f7354t = (float) bottom;
                this.f7355u = (float) left;
                this.f7356v = (float) top;
                if (Float.isNaN(this.f7345k)) {
                    this.f7351q = (float) ((left + right) / 2);
                } else {
                    this.f7351q = this.f7345k;
                }
                if (Float.isNaN(this.f7346l)) {
                    this.f7352r = (float) ((top + bottom) / 2);
                } else {
                    this.f7352r = this.f7346l;
                }
            } else {
                this.f7352r = this.f7346l;
                this.f7351q = this.f7345k;
            }
        }
    }

    public final void u() {
        int i11;
        if (this.f7348n != null && (i11 = this.f7920c) != 0) {
            View[] viewArr = this.f7358x;
            if (viewArr == null || viewArr.length != i11) {
                this.f7358x = new View[i11];
            }
            for (int i12 = 0; i12 < this.f7920c; i12++) {
                this.f7358x[i12] = this.f7348n.getViewById(this.f7919b[i12]);
            }
        }
    }

    public final void v() {
        if (this.f7348n != null) {
            if (this.f7358x == null) {
                u();
            }
            t();
            double radians = Float.isNaN(this.f7347m) ? 0.0d : Math.toRadians((double) this.f7347m);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f11 = this.f7349o;
            float f12 = f11 * cos;
            float f13 = this.f7350p;
            float f14 = (-f13) * sin;
            float f15 = f11 * sin;
            float f16 = f13 * cos;
            for (int i11 = 0; i11 < this.f7920c; i11++) {
                View view = this.f7358x[i11];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.f7351q;
                float top = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.f7352r;
                view.setTranslationX((((f12 * left) + (f14 * top)) - left) + this.f7359y);
                view.setTranslationY((((left * f15) + (f16 * top)) - top) + this.f7360z);
                view.setScaleY(this.f7350p);
                view.setScaleX(this.f7349o);
                if (!Float.isNaN(this.f7347m)) {
                    view.setRotation(this.f7347m);
                }
            }
        }
    }

    public Layer(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
