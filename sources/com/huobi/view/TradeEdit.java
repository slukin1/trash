package com.huobi.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import i6.m;

public class TradeEdit extends EditText {
    private float count = 0.1f;
    private Drawable dLeft;
    private Drawable dRight;
    private Rect lBounds;
    public boolean longclick = false;
    private Rect rBounds;

    public TradeEdit(Context context) {
        super(context);
        initEditText();
    }

    private void initEditText() {
        setCompoundDrawables(this.dLeft, (Drawable) null, this.dRight, (Drawable) null);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dRight = null;
        this.dLeft = null;
        this.rBounds = null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f11;
        float f12 = 0.0f;
        if (this.dRight != null && motionEvent.getAction() == 1) {
            this.rBounds = this.dRight.getBounds();
            if (((int) motionEvent.getRawX()) > getRight() - this.rBounds.width()) {
                if (TextUtils.isEmpty(getText().toString().trim())) {
                    f11 = 0.0f;
                } else {
                    f11 = m.i0(getText().toString().trim());
                }
                setText((f11 + this.count) + "");
            }
        }
        if (this.dLeft != null && motionEvent.getAction() == 1) {
            this.lBounds = this.dLeft.getBounds();
            if (((int) motionEvent.getRawX()) < getLeft() + this.lBounds.width()) {
                if (!TextUtils.isEmpty(getText().toString().trim())) {
                    f12 = m.i0(getText().toString().trim());
                }
                setText((f12 - this.count) + "");
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.dLeft = drawable;
        this.dRight = drawable3;
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.dLeft = drawable;
        this.dRight = drawable3;
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setCount(float f11) {
        this.count = f11;
    }

    public TradeEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initEditText();
    }

    public TradeEdit(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initEditText();
    }
}
