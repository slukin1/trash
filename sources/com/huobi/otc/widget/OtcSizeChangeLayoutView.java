package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class OtcSizeChangeLayoutView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f80053b;

    public interface a {
        void a(int i11, int i12);
    }

    public OtcSizeChangeLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        a aVar;
        super.onSizeChanged(i11, i12, i13, i14);
        if (i12 != i14 && (aVar = this.f80053b) != null) {
            aVar.a(i14, i12);
        }
    }

    public void setOnSizeChangeListener(a aVar) {
        this.f80053b = aVar;
    }

    public OtcSizeChangeLayoutView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
