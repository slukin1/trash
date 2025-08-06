package com.hbg.lib.widgets.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import ea.c;

public class DividerLinearLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public c f71950b;

    public DividerLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f71950b = new c(this, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f71950b.a(canvas);
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        super.setPadding(i11, i12, i13, i14);
        c cVar = this.f71950b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public DividerLinearLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
