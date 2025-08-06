package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class EditChangeEmptyView extends View {

    /* renamed from: b  reason: collision with root package name */
    public a f79769b;

    public interface a {
        void a();
    }

    public EditChangeEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        a aVar;
        super.onSizeChanged(i11, i12, i13, i14);
        if (i12 != i14 && i14 != 0 && (aVar = this.f79769b) != null) {
            aVar.a();
        }
    }

    public void setOnSizeChangeListener(a aVar) {
        this.f79769b = aVar;
    }
}
