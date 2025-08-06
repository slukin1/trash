package jumio.core;

import com.jumio.core.extraction.ExtractionClient;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.sync.b;

@d(c = "com.jumio.core.extraction.ExtractionClient$extract$2", f = "ExtractionClient.kt", l = {163}, m = "invokeSuspend")
public final class h1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public int f56215a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtractionClient f56216b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h1(ExtractionClient extractionClient, c<? super h1> cVar) {
        super(2, cVar);
        this.f56216b = extractionClient;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new h1(this.f56216b, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((h1) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.f56215a;
        if (i11 == 0) {
            k.b(obj);
            b access$getExtractionSemaphore$p = this.f56216b.f39152i;
            this.f56215a = 1;
            if (access$getExtractionSemaphore$p.c(this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ExtractionClient extractionClient = this.f56216b;
        extractionClient.process(extractionClient.f39150g, this.f56216b.getPreviewProperties(), this.f56216b.f39151h, this.f56216b.getExtractionArea());
        if (this.f56216b.f39155l) {
            this.f56216b.f39149f.doFrame();
        }
        return Unit.f56620a;
    }
}
