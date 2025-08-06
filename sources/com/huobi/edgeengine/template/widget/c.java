package com.huobi.edgeengine.template.widget;

import com.huobi.edgeengine.template.widget.Widget;
import java.lang.ref.WeakReference;

public abstract class c<T> implements Widget.u {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<T> f44202a;

    public c(T t11) {
        this.f44202a = new WeakReference<>(t11);
    }

    public void a(String str) {
        WeakReference<T> weakReference = this.f44202a;
        if (weakReference != null && weakReference.get() != null) {
            b(this.f44202a.get(), str);
        }
    }

    public abstract void b(T t11, String str);
}
