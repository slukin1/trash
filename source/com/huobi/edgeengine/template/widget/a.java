package com.huobi.edgeengine.template.widget;

import android.view.View;
import com.huobi.edgeengine.template.widget.Widget;
import java.lang.ref.WeakReference;

public abstract class a implements Widget.t {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f44200a;

    public a(View view) {
        this.f44200a = new WeakReference<>(view);
    }

    public void a(int i11) {
        WeakReference<View> weakReference = this.f44200a;
        if (weakReference != null && weakReference.get() != null) {
            b((View) this.f44200a.get(), i11);
        }
    }

    public abstract void b(View view, int i11);
}
