package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import java.lang.ref.WeakReference;

public final /* synthetic */ class e implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f43917a;

    public /* synthetic */ e(WeakReference weakReference) {
        this.f43917a = weakReference;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return f.g(this.f43917a, v8Object, v8Array);
    }
}
