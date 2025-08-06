package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

@d(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {85}, m = "invokeSuspend")
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements p<k<? super Rect>, c<? super Unit>, Object> {
    public final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    public int label;

    public static final class a implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<Rect> f3660b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f3661c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnScrollChangedListener f3662d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnLayoutChangeListener f3663e;

        public a(k<? super Rect> kVar, View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener) {
            this.f3660b = kVar;
            this.f3661c = view;
            this.f3662d = onScrollChangedListener;
            this.f3663e = onLayoutChangeListener;
        }

        public void onViewAttachedToWindow(View view) {
            this.f3660b.q(t.b(this.f3661c));
            this.f3661c.getViewTreeObserver().addOnScrollChangedListener(this.f3662d);
            this.f3661c.addOnLayoutChangeListener(this.f3663e);
        }

        public void onViewDetachedFromWindow(View view) {
            view.getViewTreeObserver().removeOnScrollChangedListener(this.f3662d);
            view.removeOnLayoutChangeListener(this.f3663e);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, c<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> cVar) {
        super(2, cVar);
        this.$view = view;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(k kVar, View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i11 != i15 || i13 != i17 || i12 != i16 || i14 != i18) {
            kVar.q(t.b(view));
        }
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(k kVar, View view) {
        kVar.q(t.b(view));
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, cVar);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    public final Object invoke(k<? super Rect> kVar, c<? super Unit> cVar) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.k.b(obj);
            k kVar = (k) this.L$0;
            final r rVar = new r(kVar);
            final s sVar = new s(kVar, this.$view);
            final a aVar = new a(kVar, this.$view, sVar, rVar);
            if (a.f3664a.a(this.$view)) {
                kVar.q(t.b(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(sVar);
                this.$view.addOnLayoutChangeListener(rVar);
            }
            this.$view.addOnAttachStateChangeListener(aVar);
            final View view = this.$view;
            AnonymousClass1 r52 = new d10.a<Unit>() {
                public final void invoke() {
                    view.getViewTreeObserver().removeOnScrollChangedListener(sVar);
                    view.removeOnLayoutChangeListener(rVar);
                    view.removeOnAttachStateChangeListener(aVar);
                }
            };
            this.label = 1;
            if (ProduceKt.a(kVar, r52, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            kotlin.k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
