package com.hbg.lib.core.util;

import rx.functions.Func1;
import u6.g;

public final /* synthetic */ class d0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f68699b;

    public /* synthetic */ d0(g gVar) {
        this.f68699b = gVar;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(this.f68699b.isAlive());
    }
}
