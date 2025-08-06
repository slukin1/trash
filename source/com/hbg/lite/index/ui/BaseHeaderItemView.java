package com.hbg.lite.index.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import i6.r;
import za.a;

public abstract class BaseHeaderItemView<T> extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public Context f77108b;

    /* renamed from: c  reason: collision with root package name */
    public T f77109c;

    /* renamed from: d  reason: collision with root package name */
    public a f77110d;

    /* renamed from: e  reason: collision with root package name */
    public r f77111e;

    public BaseHeaderItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public abstract void a();

    public final void b(Context context) {
        this.f77108b = context;
        this.f77111e = new r(View.inflate(context, getResId(), this));
        a();
    }

    public abstract void c(T t11);

    public abstract int getResId();

    public void setData(T t11) {
        this.f77109c = t11;
        c(t11);
    }

    public void setMCallback(a aVar) {
        this.f77110d = aVar;
    }

    public BaseHeaderItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
