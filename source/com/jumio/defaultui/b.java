package com.jumio.defaultui;

import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;

@d(c = "com.jumio.defaultui.JumioActivity$initObservers$3$2", f = "JumioActivity.kt", l = {447}, m = "invokeSuspend")
public final class b extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public int f70821a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JumioActivity f70822b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(JumioActivity jumioActivity, c<? super b> cVar) {
        super(2, cVar);
        this.f70822b = jumioActivity;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new b(this.f70822b, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.f70821a;
        if (i11 == 0) {
            k.b(obj);
            this.f70821a = 1;
            if (DelayKt.b(200, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JumioActivity.navigateTo$default(this.f70822b, R.id.confirmationFragment, (Integer) null, (l) null, 4, (Object) null);
        this.f70822b.setActionBarQuitIcon(R.drawable.jumio_ic_close);
        return Unit.f56620a;
    }
}
