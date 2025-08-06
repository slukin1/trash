package oupson.apng;

import android.widget.ImageView;
import d10.p;
import java.util.ArrayList;
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

@d(c = "oupson.apng.ApngAnimator$setupAnimationDrawableAndStart$1", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ApngAnimator$setupAnimationDrawableAndStart$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ ArrayList $generatedFrame;
    public int label;
    public final /* synthetic */ ApngAnimator this$0;

    @d(c = "oupson.apng.ApngAnimator$setupAnimationDrawableAndStart$1$1", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: oupson.apng.ApngAnimator$setupAnimationDrawableAndStart$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;
        public final /* synthetic */ ApngAnimator$setupAnimationDrawableAndStart$1 this$0;

        {
            this.this$0 = r1;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
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
                    d11.clearAnimation();
                    d11.setImageDrawable(this.this$0.this$0.f52922e);
                }
                CustomAnimationDrawable a11 = this.this$0.this$0.f52922e;
                if (a11 != null) {
                    a11.start();
                }
                this.this$0.this$0.f52918a = true;
                this.this$0.this$0.f52923f.invoke(this.this$0.this$0);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngAnimator$setupAnimationDrawableAndStart$1(ApngAnimator apngAnimator, ArrayList arrayList, c cVar) {
        super(2, cVar);
        this.this$0 = apngAnimator;
        this.$generatedFrame = arrayList;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ApngAnimator$setupAnimationDrawableAndStart$1(this.this$0, this.$generatedFrame, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ApngAnimator$setupAnimationDrawableAndStart$1) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            ApngAnimator apngAnimator = this.this$0;
            apngAnimator.s(apngAnimator.w(this.$generatedFrame));
            ApngAnimator apngAnimator2 = this.this$0;
            apngAnimator2.f52922e = apngAnimator2.l();
            n1 unused2 = i.d(g1.f57277b, v0.c(), (CoroutineStart) null, new AnonymousClass1(this, (c) null), 2, (Object) null);
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
