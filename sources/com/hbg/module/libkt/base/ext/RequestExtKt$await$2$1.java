package com.hbg.module.libkt.base.ext;

import d10.l;
import d9.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class RequestExtKt$await$2$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ a<T> $this_await;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestExtKt$await$2$1(a<T> aVar) {
        super(1);
        this.$this_await = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.$this_await.a();
    }
}
