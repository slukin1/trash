package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class HuoBiCoordinatorLayout extends CoordinatorLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f79819b;

    public interface a {
        void a(boolean z11);
    }

    public HuoBiCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        a aVar;
        super.onSizeChanged(i11, i12, i13, i14);
        if (i14 != 0 && (aVar = this.f79819b) != null) {
            aVar.a(i14 > i12);
        }
    }

    public void setOnSizeChangeListener(a aVar) {
        this.f79819b = aVar;
    }
}
