package com.huobi.edgeengine.template.widget;

import android.view.View;
import com.huobi.edgeengine.template.widget.Widget;
import java.lang.ref.WeakReference;

public abstract class b implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f44201a;

    public b(View view) {
        this.f44201a = new WeakReference<>(view);
    }

    public void a(String str) {
        WeakReference<View> weakReference = this.f44201a;
        if (weakReference != null && weakReference.get() != null) {
            b((View) this.f44201a.get(), str);
        }
    }

    public abstract void b(View view, String str);
}
