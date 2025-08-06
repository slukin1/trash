package com.hbg.lite.market.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ListenableScrollView extends ScrollView {

    /* renamed from: b  reason: collision with root package name */
    public a f77244b;

    public interface a {
        void a(int i11);
    }

    public ListenableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        a aVar = this.f77244b;
        if (aVar != null) {
            aVar.a(i12);
        }
    }

    public void setOnScrollListener(a aVar) {
        this.f77244b = aVar;
    }

    public ListenableScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
