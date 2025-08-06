package oupson.apng;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "oupson.apng.ApngAnimator$loadUrl$1$1$1", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "oupson/apng/ApngAnimator$loadUrl$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ApngAnimator$loadUrl$1$invokeSuspend$$inlined$apply$lambda$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ byte[] $this_apply;
    public int label;
    public final /* synthetic */ ApngAnimator$loadUrl$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngAnimator$loadUrl$1$invokeSuspend$$inlined$apply$lambda$1(byte[] bArr, c cVar, ApngAnimator$loadUrl$1 apngAnimator$loadUrl$1) {
        super(2, cVar);
        this.$this_apply = bArr;
        this.this$0 = apngAnimator$loadUrl$1;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ApngAnimator$loadUrl$1$invokeSuspend$$inlined$apply$lambda$1(this.$this_apply, cVar, this.this$0);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ApngAnimator$loadUrl$1$invokeSuspend$$inlined$apply$lambda$1) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            ImageView d11 = this.this$0.this$0.f52920c;
            if (d11 != null) {
                ImageView.ScaleType e11 = this.this$0.this$0.f52926i;
                if (e11 == null) {
                    e11 = ImageView.ScaleType.FIT_CENTER;
                }
                d11.setScaleType(e11);
            }
            ImageView d12 = this.this$0.this$0.f52920c;
            if (d12 != null) {
                byte[] bArr = this.$this_apply;
                d12.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
