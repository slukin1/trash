package jumio.liveness;

import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;

@d(c = "com.jumio.liveness.LivenessExtractionClient$pauseExtractionUpdates$1", f = "LivenessExtractionClient.kt", l = {592}, m = "invokeSuspend")
public final class i extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public int f56477a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f56478b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f56479c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a<Unit> f56480d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(long j11, e eVar, a<Unit> aVar, c<? super i> cVar) {
        super(2, cVar);
        this.f56478b = j11;
        this.f56479c = eVar;
        this.f56480d = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new i(this.f56478b, this.f56479c, this.f56480d, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((i) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.f56477a;
        if (i11 == 0) {
            k.b(obj);
            long j11 = this.f56478b;
            this.f56477a = 1;
            if (DelayKt.b(j11, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f56479c.f56463j = false;
        this.f56480d.invoke();
        return Unit.f56620a;
    }
}
