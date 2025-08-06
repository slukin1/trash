package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public final /* synthetic */ class b0 implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f43913a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ V8 f43914b;

    public /* synthetic */ b0(u uVar, V8 v82) {
        this.f43913a = uVar;
        this.f43914b = v82;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return c0.f(this.f43913a, this.f43914b, v8Object, v8Array);
    }
}
