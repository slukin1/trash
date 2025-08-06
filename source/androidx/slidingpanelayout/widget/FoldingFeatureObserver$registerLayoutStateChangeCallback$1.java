package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.window.layout.j;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.h0;

@d(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ Activity $activity;
    public int label;
    public final /* synthetic */ FoldingFeatureObserver this$0;

    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/r", "Lkotlinx/coroutines/flow/e;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a implements e<j> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FoldingFeatureObserver f10955b;

        public a(FoldingFeatureObserver foldingFeatureObserver) {
            this.f10955b = foldingFeatureObserver;
        }

        public Object emit(j jVar, c<? super Unit> cVar) {
            Unit unit;
            j jVar2 = jVar;
            FoldingFeatureObserver.a b11 = this.f10955b.f10950d;
            if (b11 == null) {
                unit = null;
            } else {
                b11.a(jVar2);
                unit = Unit.f56620a;
            }
            if (unit == IntrinsicsKt__IntrinsicsKt.d()) {
                return unit;
            }
            return Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1(FoldingFeatureObserver foldingFeatureObserver, Activity activity, c<? super FoldingFeatureObserver$registerLayoutStateChangeCallback$1> cVar) {
        super(2, cVar);
        this.this$0 = foldingFeatureObserver;
        this.$activity = activity;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this.this$0, this.$activity, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((FoldingFeatureObserver$registerLayoutStateChangeCallback$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            kotlinx.coroutines.flow.d s11 = f.s(new FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1(this.this$0.f10947a.a(this.$activity), this.this$0));
            a aVar = new a(this.this$0);
            this.label = 1;
            if (s11.collect(aVar, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
