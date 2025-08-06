package com.wtree.scrolltable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

public class SyncHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: b  reason: collision with root package name */
    public View f51248b;

    public SyncHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        View view = this.f51248b;
        if (view != null) {
            view.scrollTo(i11, i12);
        }
    }

    public void setScrollView(View view) {
        this.f51248b = view;
    }
}
