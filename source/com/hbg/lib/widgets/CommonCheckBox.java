package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;

public class CommonCheckBox extends AppCompatImageView implements Checkable {

    /* renamed from: b  reason: collision with root package name */
    public Type f71062b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71063c;

    /* renamed from: d  reason: collision with root package name */
    public int f71064d;

    /* renamed from: e  reason: collision with root package name */
    public int f71065e;

    /* renamed from: f  reason: collision with root package name */
    public int f71066f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f71067g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f71068h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f71069i;

    public enum Type {
        CHECK,
        PARTLY_CHECK
    }

    public CommonCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c() {
        if (!this.f71063c) {
            Drawable drawable = this.f71068h;
            if (drawable != null) {
                setImageDrawable(drawable);
            } else {
                setImageResource(this.f71065e);
            }
        } else if (this.f71062b == Type.PARTLY_CHECK) {
            Drawable drawable2 = this.f71069i;
            if (drawable2 != null) {
                setImageDrawable(drawable2);
            } else {
                setImageResource(this.f71066f);
            }
        } else {
            Drawable drawable3 = this.f71067g;
            if (drawable3 != null) {
                setImageDrawable(drawable3);
            } else {
                setImageResource(this.f71064d);
            }
        }
    }

    public Type getType() {
        return this.f71062b;
    }

    public boolean isChecked() {
        return this.f71063c;
    }

    public void setChecked(boolean z11) {
        this.f71063c = z11;
        c();
    }

    public void setPartlySelectedDrawable(Drawable drawable) {
        this.f71069i = drawable;
    }

    public void setPartlySelectedResId(int i11) {
        this.f71066f = i11;
        this.f71069i = null;
    }

    public void setSelectedDrawable(Drawable drawable) {
        this.f71067g = drawable;
    }

    public void setSelectedResId(int i11) {
        this.f71064d = i11;
        this.f71067g = null;
    }

    public void setType(Type type) {
        if (type != null) {
            this.f71062b = type;
        } else {
            this.f71062b = Type.CHECK;
        }
        c();
    }

    public void setUnSelectedDrawable(Drawable drawable) {
        this.f71068h = drawable;
    }

    public void setUnSelectedResId(int i11) {
        this.f71065e = i11;
        this.f71068h = null;
    }

    public void toggle() {
        setChecked(!this.f71063c);
    }

    public CommonCheckBox(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71062b = Type.CHECK;
        this.f71066f = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonCheckBox, i11, 0);
        this.f71063c = obtainStyledAttributes.getBoolean(R$styleable.CommonCheckBox_isChecked, false);
        this.f71067g = obtainStyledAttributes.getDrawable(R$styleable.CommonCheckBox_drawable_checked);
        this.f71068h = obtainStyledAttributes.getDrawable(R$styleable.CommonCheckBox_drawable_unchecked);
        this.f71069i = obtainStyledAttributes.getDrawable(R$styleable.CommonCheckBox_drawable_partly_checked);
        obtainStyledAttributes.recycle();
        c();
    }
}
