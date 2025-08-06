package com.huobi.home.engine;

import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f72478b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f72479c;

    public /* synthetic */ b(String str, Ref$ObjectRef ref$ObjectRef) {
        this.f72478b = str;
        this.f72479c = ref$ObjectRef;
    }

    public final void run() {
        HomeBridgeAbility.o(this.f72478b, this.f72479c);
    }
}
