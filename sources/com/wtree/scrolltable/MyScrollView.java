package com.wtree.scrolltable;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {

    /* renamed from: b  reason: collision with root package name */
    public boolean f51245b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51246c = false;

    /* renamed from: d  reason: collision with root package name */
    public a f51247d;

    public interface a {
        void a();

        void b();
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        a aVar;
        if (this.f51245b) {
            a aVar2 = this.f51247d;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else if (this.f51246c && (aVar = this.f51247d) != null) {
            aVar.a();
        }
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        if (getScrollY() == 0) {
            this.f51245b = true;
            this.f51246c = false;
        } else if (((getScrollY() + getHeight()) - getPaddingTop()) - getPaddingBottom() == getChildAt(0).getHeight()) {
            this.f51246c = true;
            this.f51245b = false;
        } else {
            this.f51245b = false;
            this.f51246c = false;
        }
        a();
    }

    public void setScanScrollChangedListener(a aVar) {
        this.f51247d = aVar;
    }
}
