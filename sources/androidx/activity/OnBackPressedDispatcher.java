package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;
import d10.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.x;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f3640a;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<Boolean> f3641b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayDeque<o> f3642c;

    /* renamed from: d  reason: collision with root package name */
    public o f3643d;

    /* renamed from: e  reason: collision with root package name */
    public OnBackInvokedCallback f3644e;

    /* renamed from: f  reason: collision with root package name */
    public OnBackInvokedDispatcher f3645f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3646g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3647h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f3648a = new a();

        public static final void c(d10.a aVar) {
            aVar.invoke();
        }

        public final OnBackInvokedCallback b(d10.a<Unit> aVar) {
            return new p(aVar);
        }

        public final void d(Object obj, int i11, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i11, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f3649a = new b();

        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l<c, Unit> f3650a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l<c, Unit> f3651b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d10.a<Unit> f3652c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ d10.a<Unit> f3653d;

            public a(l<? super c, Unit> lVar, l<? super c, Unit> lVar2, d10.a<Unit> aVar, d10.a<Unit> aVar2) {
                this.f3650a = lVar;
                this.f3651b = lVar2;
                this.f3652c = aVar;
                this.f3653d = aVar2;
            }

            public void onBackCancelled() {
                this.f3653d.invoke();
            }

            public void onBackInvoked() {
                this.f3652c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                this.f3651b.invoke(new c(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                this.f3650a.invoke(new c(backEvent));
            }
        }

        public final OnBackInvokedCallback a(l<? super c, Unit> lVar, l<? super c, Unit> lVar2, d10.a<Unit> aVar, d10.a<Unit> aVar2) {
            return new a(lVar, lVar2, aVar, aVar2);
        }
    }

    public final class c implements r, d {

        /* renamed from: b  reason: collision with root package name */
        public final Lifecycle f3654b;

        /* renamed from: c  reason: collision with root package name */
        public final o f3655c;

        /* renamed from: d  reason: collision with root package name */
        public d f3656d;

        public c(Lifecycle lifecycle, o oVar) {
            this.f3654b = lifecycle;
            this.f3655c = oVar;
            lifecycle.a(this);
        }

        public void cancel() {
            this.f3654b.d(this);
            this.f3655c.removeCancellable(this);
            d dVar = this.f3656d;
            if (dVar != null) {
                dVar.cancel();
            }
            this.f3656d = null;
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f3656d = OnBackPressedDispatcher.this.j(this.f3655c);
            } else if (event == Lifecycle.Event.ON_STOP) {
                d dVar = this.f3656d;
                if (dVar != null) {
                    dVar.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    public final class d implements d {

        /* renamed from: b  reason: collision with root package name */
        public final o f3658b;

        public d(o oVar) {
            this.f3658b = oVar;
        }

        public void cancel() {
            OnBackPressedDispatcher.this.f3642c.remove(this.f3658b);
            if (x.b(OnBackPressedDispatcher.this.f3643d, this.f3658b)) {
                this.f3658b.handleOnBackCancelled();
                OnBackPressedDispatcher.this.f3643d = null;
            }
            this.f3658b.removeCancellable(this);
            d10.a<Unit> enabledChangedCallback$activity_release = this.f3658b.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.f3658b.setEnabledChangedCallback$activity_release((d10.a<Unit>) null);
        }
    }

    public OnBackPressedDispatcher() {
        this((Runnable) null, 1, (kotlin.jvm.internal.r) null);
    }

    public OnBackPressedDispatcher(Runnable runnable, Consumer<Boolean> consumer) {
        OnBackInvokedCallback onBackInvokedCallback;
        this.f3640a = runnable;
        this.f3641b = consumer;
        this.f3642c = new ArrayDeque<>();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            if (i11 >= 34) {
                onBackInvokedCallback = b.f3649a.a(new l<c, Unit>(this) {
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((c) obj);
                        return Unit.f56620a;
                    }

                    public final void invoke(c cVar) {
                        this.this$0.n(cVar);
                    }
                }, new l<c, Unit>(this) {
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((c) obj);
                        return Unit.f56620a;
                    }

                    public final void invoke(c cVar) {
                        this.this$0.m(cVar);
                    }
                }, new d10.a<Unit>(this) {
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.l();
                    }
                }, new d10.a<Unit>(this) {
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.k();
                    }
                });
            } else {
                onBackInvokedCallback = a.f3648a.b(new d10.a<Unit>(this) {
                    public final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.l();
                    }
                });
            }
            this.f3644e = onBackInvokedCallback;
        }
    }

    public final void h(o oVar) {
        j(oVar);
    }

    public final void i(LifecycleOwner lifecycleOwner, o oVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            oVar.addCancellable(new c(lifecycle, oVar));
            q();
            oVar.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
        }
    }

    public final d j(o oVar) {
        this.f3642c.add(oVar);
        d dVar = new d(oVar);
        oVar.addCancellable(dVar);
        q();
        oVar.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return dVar;
    }

    public final void k() {
        o oVar;
        ArrayDeque<o> arrayDeque = this.f3642c;
        ListIterator<o> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                oVar = null;
                break;
            }
            oVar = listIterator.previous();
            if (oVar.isEnabled()) {
                break;
            }
        }
        o oVar2 = oVar;
        this.f3643d = null;
        if (oVar2 != null) {
            oVar2.handleOnBackCancelled();
        }
    }

    public final void l() {
        o oVar;
        ArrayDeque<o> arrayDeque = this.f3642c;
        ListIterator<o> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                oVar = null;
                break;
            }
            oVar = listIterator.previous();
            if (oVar.isEnabled()) {
                break;
            }
        }
        o oVar2 = oVar;
        this.f3643d = null;
        if (oVar2 != null) {
            oVar2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f3640a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void m(c cVar) {
        o oVar;
        ArrayDeque<o> arrayDeque = this.f3642c;
        ListIterator<o> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                oVar = null;
                break;
            }
            oVar = listIterator.previous();
            if (oVar.isEnabled()) {
                break;
            }
        }
        o oVar2 = oVar;
        if (oVar2 != null) {
            oVar2.handleOnBackProgressed(cVar);
        }
    }

    public final void n(c cVar) {
        o oVar;
        ArrayDeque<o> arrayDeque = this.f3642c;
        ListIterator<o> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                oVar = null;
                break;
            }
            oVar = listIterator.previous();
            if (oVar.isEnabled()) {
                break;
            }
        }
        o oVar2 = oVar;
        this.f3643d = oVar2;
        if (oVar2 != null) {
            oVar2.handleOnBackStarted(cVar);
        }
    }

    public final void o(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        this.f3645f = onBackInvokedDispatcher;
        p(this.f3647h);
    }

    public final void p(boolean z11) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f3645f;
        OnBackInvokedCallback onBackInvokedCallback = this.f3644e;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (z11 && !this.f3646g) {
                a.f3648a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f3646g = true;
            } else if (!z11 && this.f3646g) {
                a.f3648a.e(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f3646g = false;
            }
        }
    }

    public final void q() {
        boolean z11 = this.f3647h;
        ArrayDeque<o> arrayDeque = this.f3642c;
        boolean z12 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<T> it2 = arrayDeque.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((o) it2.next()).isEnabled()) {
                        z12 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.f3647h = z12;
        if (z12 != z11) {
            Consumer<Boolean> consumer = this.f3641b;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z12));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                p(z12);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i11, kotlin.jvm.internal.r rVar) {
        this((i11 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, (Consumer<Boolean>) null);
    }
}
