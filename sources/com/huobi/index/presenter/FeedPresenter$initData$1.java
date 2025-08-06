package com.huobi.index.presenter;

import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;
import s9.a;

@d(c = "com.huobi.index.presenter.FeedPresenter$initData$1", f = "FeedPresenter.kt", l = {52}, m = "invokeSuspend")
public final class FeedPresenter$initData$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ int $actionType;
    public final /* synthetic */ int $bizType;
    public int label;
    public final /* synthetic */ FeedPresenter this$0;

    @d(c = "com.huobi.index.presenter.FeedPresenter$initData$1$1", f = "FeedPresenter.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.huobi.index.presenter.FeedPresenter$initData$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(feedPresenter, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.label == 0) {
                k.b(obj);
                feedPresenter.f0().h();
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedPresenter$initData$1(FeedPresenter feedPresenter, int i11, int i12, c<? super FeedPresenter$initData$1> cVar) {
        super(2, cVar);
        this.this$0 = feedPresenter;
        this.$actionType = i11;
        this.$bizType = i12;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FeedPresenter$initData$1(this.this$0, this.$actionType, this.$bizType, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((FeedPresenter$initData$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            CoroutineDispatcher b11 = v0.b();
            final FeedPresenter feedPresenter = this.this$0;
            AnonymousClass1 r12 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            if (g.g(b11, r12, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.f0().p() != null && (!this.this$0.f0().p().isEmpty())) {
            List<a> p11 = this.this$0.f0().p();
            this.this$0.f0().y(p11);
            this.this$0.f0().f73307i = p11 != null ? p11.size() : 0;
            this.this$0.f0().f73308j = this.$actionType;
            this.this$0.c0().h(this.this$0.f0());
        }
        this.this$0.i0(this.$actionType, this.$bizType);
        return Unit.f56620a;
    }
}
