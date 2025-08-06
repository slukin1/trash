package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

public abstract class VirtualLayout extends ConstraintHelper {

    /* renamed from: k  reason: collision with root package name */
    public boolean f8110k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f8111l;

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void f(ConstraintLayout constraintLayout) {
        e(constraintLayout);
    }

    public void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f8110k = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f8111l = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8110k || this.f8111l) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
                for (int i11 = 0; i11 < this.f7920c; i11++) {
                    View viewById = constraintLayout.getViewById(this.f7919b[i11]);
                    if (viewById != null) {
                        if (this.f8110k) {
                            viewById.setVisibility(visibility);
                        }
                        if (this.f8111l && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                            viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    public void setElevation(float f11) {
        super.setElevation(f11);
        d();
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        d();
    }

    public void t(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i11, int i12) {
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
