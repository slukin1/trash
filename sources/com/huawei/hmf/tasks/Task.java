package com.huawei.hmf.tasks;

import eg.b;
import eg.c;
import eg.d;

public abstract class Task<TResult> {
    public Task<TResult> a(b<TResult> bVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract Task<TResult> b(c cVar);

    public abstract Task<TResult> c(d<TResult> dVar);

    public abstract Exception d();

    public abstract TResult e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();
}
