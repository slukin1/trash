package oupson.apng;

import android.widget.ImageView;
import d10.p;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "oupson.apng.ApngAnimator$load$2$1$2", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "oupson/apng/ApngAnimator$load$2$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ApngAnimator$load$2$invokeSuspend$$inlined$also$lambda$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ InputStream $inputStream$inlined;
    public final /* synthetic */ Apng $it;
    public int label;
    public final /* synthetic */ ApngAnimator$load$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngAnimator$load$2$invokeSuspend$$inlined$also$lambda$1(Apng apng, c cVar, ApngAnimator$load$2 apngAnimator$load$2, InputStream inputStream) {
        super(2, cVar);
        this.$it = apng;
        this.this$0 = apngAnimator$load$2;
        this.$inputStream$inlined = inputStream;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ApngAnimator$load$2$invokeSuspend$$inlined$also$lambda$1(this.$it, cVar, this.this$0, this.$inputStream$inlined);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ApngAnimator$load$2$invokeSuspend$$inlined$also$lambda$1) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            ImageView d11 = this.this$0.this$0.f52920c;
            if (d11 != null) {
                d11.setImageBitmap(this.$it.a());
            }
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
