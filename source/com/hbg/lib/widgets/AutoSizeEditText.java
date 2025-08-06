package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;

public class AutoSizeEditText extends AppCompatEditText {

    /* renamed from: b  reason: collision with root package name */
    public int f70987b = 0;

    /* renamed from: c  reason: collision with root package name */
    public float f70988c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public boolean f70989d = false;

    /* renamed from: e  reason: collision with root package name */
    public float f70990e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int f70991f = 300;

    /* renamed from: g  reason: collision with root package name */
    public float f70992g = 0.7f;

    /* renamed from: h  reason: collision with root package name */
    public Paint f70993h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70994i;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            boolean unused = AutoSizeEditText.this.f70989d = false;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = AutoSizeEditText.this.f70989d = true;
        }
    }

    public AutoSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public final float b() {
        return e() / ((float) this.f70987b);
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.AutoSizeEditText, 0, 0);
        this.f70990e = obtainStyledAttributes.getFloat(R$styleable.AutoSizeEditText_linesLimit, 1.0f);
        this.f70992g = obtainStyledAttributes.getFloat(R$styleable.AutoSizeEditText_textScale, 0.7f);
        this.f70991f = obtainStyledAttributes.getInteger(R$styleable.AutoSizeEditText_animationDuration, 300);
        obtainStyledAttributes.recycle();
    }

    public final void d() {
        Paint paint = new Paint();
        this.f70993h = paint;
        paint.setTypeface(getTypeface());
        this.f70993h.setTextSize(this.f70988c);
    }

    public final float e() {
        Paint paint = this.f70993h;
        if (paint != null) {
            return paint.measureText(getText().toString());
        }
        return 0.0f;
    }

    public final void f(float f11, float f12) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "textSize", new float[]{f11, f12});
        ofFloat.setTarget(this);
        ofFloat.setDuration((long) this.f70991f);
        ofFloat.addListener(new a());
        ofFloat.start();
    }

    public final void g() {
        float textSize = getTextSize();
        float f11 = this.f70988c;
        if (textSize >= f11) {
            return;
        }
        if (this.f70994i) {
            f(textSize, f11);
        } else {
            setTextSize(f11);
        }
    }

    public final void h() {
        float f11 = this.f70988c * this.f70992g;
        float textSize = getTextSize();
        if (textSize <= f11) {
            return;
        }
        if (this.f70994i) {
            f(textSize, f11);
        } else {
            setTextSize(f11);
        }
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 == 66) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (this.f70987b == 0) {
            int measuredWidth = getMeasuredWidth();
            this.f70987b = measuredWidth;
            this.f70987b = measuredWidth - (getPaddingRight() + getPaddingLeft());
        }
        if (this.f70988c == 0.0f) {
            this.f70988c = getTextSize();
            d();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        super.onTextChanged(charSequence, i11, i12, i13);
        if (this.f70989d) {
            return;
        }
        if (b() > this.f70990e) {
            h();
        } else {
            g();
        }
    }

    public void setAnimationDuration(int i11) {
        this.f70991f = i11;
    }

    public void setLinesLimit(float f11) {
        this.f70990e = f11;
    }

    public void setTextScale(float f11) {
        this.f70992g = f11;
    }

    public void setTextSize(float f11) {
        super.setTextSize(0, f11);
    }

    public AutoSizeEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(attributeSet);
    }
}
