package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public final /* synthetic */ class d0 implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ V8 f43916a;

    public /* synthetic */ d0(V8 v82) {
        this.f43916a = v82;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return e0.f(this.f43916a, v8Object, v8Array);
    }
}
