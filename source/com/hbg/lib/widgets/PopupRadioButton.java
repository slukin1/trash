package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.hbg.lib.common.utils.PixelUtils;

public class PopupRadioButton extends RadioButton {

    /* renamed from: b  reason: collision with root package name */
    public float f71568b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f71569c;

    /* renamed from: d  reason: collision with root package name */
    public int f71570d = 8;

    public PopupRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public final void a() {
        int i11;
        int i12;
        float f11;
        int i13;
        int i14;
        float measuredHeight = (float) getMeasuredHeight();
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[1];
        if (drawable != null) {
            if ((drawable instanceof BitmapDrawable) || (drawable instanceof StateListDrawable)) {
                f11 = (((float) drawable.getIntrinsicHeight()) * 1.0f) / ((float) drawable.getIntrinsicWidth());
            } else {
                f11 = 1.0f;
            }
            if (f11 > 1.0f) {
                i14 = (int) ((this.f71568b * measuredHeight) / f11);
                i13 = (int) (((float) i14) * f11);
            } else {
                i14 = (int) (this.f71568b * measuredHeight);
                i13 = i14;
            }
            int i15 = (int) (((float) i14) * f11);
            int i16 = (i13 - i15) / 2;
            drawable.setBounds(0, i16, i14 + 0, i15 + i16);
            setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
        if (this.f71569c != null) {
            float measuredWidth = (float) getMeasuredWidth();
            Drawable drawable2 = this.f71569c;
            if ((drawable2 instanceof BitmapDrawable) || (drawable2 instanceof StateListDrawable)) {
                i11 = drawable2.getIntrinsicWidth();
                i12 = this.f71569c.getIntrinsicHeight();
            } else {
                i12 = PixelUtils.a(30.0f);
                i11 = i12;
            }
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                int width = (int) ((measuredWidth / 2.0f) + ((float) (bounds.width() / 2)));
                int paddingTop = getPaddingTop() + bounds.top + (i12 / 2);
                this.f71569c.setBounds(width, paddingTop - i12, i11 + width, paddingTop);
            }
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        setButtonDrawable(new ColorDrawable(0));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PopupRadioButton);
            boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.PopupRadioButton_showPopup, false);
            this.f71569c = obtainStyledAttributes.getDrawable(R$styleable.PopupRadioButton_popupSrc);
            this.f71568b = obtainStyledAttributes.getFraction(R$styleable.PopupRadioButton_aspectRatio, 1, 100, 0.5f);
            if (z11) {
                this.f71570d = 0;
            } else {
                this.f71570d = 8;
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        if (this.f71570d == 0 && (drawable = this.f71569c) != null) {
            drawable.draw(canvas);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        a();
    }

    public PopupRadioButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context, attributeSet);
    }
}
