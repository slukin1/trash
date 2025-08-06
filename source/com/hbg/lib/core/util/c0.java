package com.hbg.lib.core.util;

import rx.functions.Func1;
import u6.g;

public final /* synthetic */ class c0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f68697b;

    public /* synthetic */ c0(g gVar) {
        this.f68697b = gVar;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(this.f68697b.isAlive());
    }
}
