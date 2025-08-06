package com.huobi.order.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.huobi.R$styleable;

public class OrderTitleTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public int f78247b;

    /* renamed from: c  reason: collision with root package name */
    public int f78248c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f78249d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f78250e;

    public OrderTitleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void init() {
        if (this.f78250e) {
            setPivotX(0.0f);
            setPivotY((float) this.f78248c);
            setScaleX(1.75f);
            setScaleY(1.75f);
            return;
        }
        setPivotX((float) this.f78247b);
        setPivotY((float) this.f78248c);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f78247b = getWidth();
        int height = getHeight();
        this.f78248c = height;
        if (this.f78247b == 0 || height == 0) {
            invalidate();
        } else if (!this.f78249d) {
            this.f78249d = true;
            init();
        }
    }

    public void setIsBig(boolean z11) {
        this.f78250e = z11;
        init();
    }

    public OrderTitleTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OrderTitleTextView, i11, 0);
            this.f78250e = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
    }
}
