package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {

    /* renamed from: b  reason: collision with root package name */
    public a f71336b;

    public interface a {
        void onScrollChanged(int i11, int i12, int i13, int i14);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        a aVar = this.f71336b;
        if (aVar != null) {
            aVar.onScrollChanged(i11, i12, i13, i14);
        }
    }

    public void setCallback(a aVar) {
        this.f71336b = aVar;
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
