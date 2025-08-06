package com.jumio.core.network;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.jumio.core.network.DownloadTask$MainTaskProgressListener$runOnMain$1", f = "DownloadTask.kt", l = {}, m = "invokeSuspend")
public final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d10.a<Unit> f39435a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(d10.a<Unit> aVar, c<? super a> cVar) {
        super(2, cVar);
        this.f39435a = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new a(this.f39435a, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((a) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        this.f39435a.invoke();
        return Unit.f56620a;
    }
}
