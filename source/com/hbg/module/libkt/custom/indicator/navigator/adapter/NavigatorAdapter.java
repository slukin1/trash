package com.hbg.module.libkt.custom.indicator.navigator.adapter;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import pe.b;
import pe.c;

public abstract class NavigatorAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final DataSetObservable f24807a = new DataSetObservable();

    public abstract int a();

    public abstract b b(Context context);

    public abstract c c(Context context, int i11);

    public final float d(Context context, int i11) {
        return 1.0f;
    }

    public final void e() {
        this.f24807a.notifyChanged();
    }

    public final void f(DataSetObserver dataSetObserver) {
        this.f24807a.registerObserver(dataSetObserver);
    }

    public final void g(DataSetObserver dataSetObserver) {
        this.f24807a.unregisterObserver(dataSetObserver);
    }
}
