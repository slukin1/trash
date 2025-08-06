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
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import oupson.apng.exceptions.NotApngException;
import oupson.apng.utils.ApngAnimatorOptions;
import oupson.apng.utils.Utils;

@d(c = "oupson.apng.ApngAnimator$load$3", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ApngAnimator$load$3 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ ApngAnimatorOptions $apngAnimatorOptions;
    public final /* synthetic */ byte[] $byteArray;
    public final /* synthetic */ Float $speed;
    public int label;
    public final /* synthetic */ ApngAnimator this$0;

    @d(c = "oupson.apng.ApngAnimator$load$3$2", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: oupson.apng.ApngAnimator$load$3$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;
        public final /* synthetic */ ApngAnimator$load$3 this$0;

        {
            this.this$0 = r1;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.this$0, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
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
                    byte[] bArr = this.this$0.$byteArray;
                    d12.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngAnimator$load$3(ApngAnimator apngAnimator, Float f11, byte[] bArr, ApngAnimatorOptions apngAnimatorOptions, c cVar) {
        super(2, cVar);
        this.this$0 = apngAnimator;
        this.$speed = f11;
        this.$byteArray = bArr;
        this.$apngAnimatorOptions = apngAnimatorOptions;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ApngAnimator$load$3(this.this$0, this.$speed, this.$byteArray, this.$apngAnimatorOptions, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ApngAnimator$load$3) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            this.this$0.u(this.$speed);
            ImageView.ScaleType scaleType = null;
            if (Utils.f52981j.l(this.$byteArray)) {
                this.this$0.t(true);
                this.this$0.u(this.$speed);
                ApngAnimator apngAnimator = this.this$0;
                ApngAnimatorOptions apngAnimatorOptions = this.$apngAnimatorOptions;
                if (apngAnimatorOptions != null) {
                    scaleType = apngAnimatorOptions.a();
                }
                apngAnimator.f52926i = scaleType;
                this.this$0.v(this.this$0.k(new APNGDisassembler().b(this.$byteArray).b()));
            } else if (this.this$0.m()) {
                n1 unused2 = i.d(g1.f57277b, v0.c(), (CoroutineStart) null, new AnonymousClass2(this, (c) null), 2, (Object) null);
            } else {
                throw new NotApngException();
            }
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
