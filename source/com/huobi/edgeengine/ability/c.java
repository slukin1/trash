package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public final /* synthetic */ class c implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f43915a;

    public /* synthetic */ c(u uVar) {
        this.f43915a = uVar;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return d.f(this.f43915a, v8Object, v8Array);
    }
}
