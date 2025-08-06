package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import java.lang.ref.WeakReference;

public final /* synthetic */ class q implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f43934a;

    public /* synthetic */ q(WeakReference weakReference) {
        this.f43934a = weakReference;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return r.l(this.f43934a, v8Object, v8Array);
    }
}
