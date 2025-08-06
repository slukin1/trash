package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public final /* synthetic */ class v implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f43943a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ V8 f43944b;

    public /* synthetic */ v(a0 a0Var, V8 v82) {
        this.f43943a = a0Var;
        this.f43944b = v82;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return this.f43943a.s(this.f43944b, v8Object, v8Array);
    }
}
