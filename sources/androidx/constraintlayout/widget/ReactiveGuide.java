package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

public class ReactiveGuide extends View implements SharedValues.a {

    /* renamed from: b  reason: collision with root package name */
    public int f8104b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8105c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f8106d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8107e = true;

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f8104b = obtainStyledAttributes.getResourceId(index, this.f8104b);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f8105c = obtainStyledAttributes.getBoolean(index, this.f8105c);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f8106d = obtainStyledAttributes.getResourceId(index, this.f8106d);
                } else if (index == R$styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f8107e = obtainStyledAttributes.getBoolean(index, this.f8107e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f8104b != -1) {
            ConstraintLayout.getSharedValues().a(this.f8104b, this);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f8106d;
    }

    public int getAttributeId() {
        return this.f8104b;
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z11) {
        this.f8105c = z11;
    }

    public void setApplyToConstraintSetId(int i11) {
        this.f8106d = i11;
    }

    public void setAttributeId(int i11) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i12 = this.f8104b;
        if (i12 != -1) {
            sharedValues.b(i12, this);
        }
        this.f8104b = i11;
        if (i11 != -1) {
            sharedValues.a(i11, this);
        }
    }

    public void setGuidelineBegin(int i11) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f7928a = i11;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i11) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f7930b = i11;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f11) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f7932c = f11;
        setLayoutParams(layoutParams);
    }

    public void setVisibility(int i11) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        super.setVisibility(8);
        a(attributeSet);
    }
}
