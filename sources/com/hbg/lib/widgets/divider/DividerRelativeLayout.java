package com.hbg.lib.widgets.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.percentlayout.widget.PercentRelativeLayout;
import ea.c;

public class DividerRelativeLayout extends PercentRelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    public c f71951c;

    public DividerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        this.f71951c = new c(this, attributeSet);
    }

    public c getDividerHelper() {
        return this.f71951c;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f71951c.a(canvas);
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11, i12, i13, i14);
        c cVar = this.f71951c;
        if (cVar != null) {
            cVar.b();
        }
    }

    public DividerRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context, attributeSet);
    }
}
