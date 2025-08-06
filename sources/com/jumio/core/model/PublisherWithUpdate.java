package com.jumio.core.model;

import com.jumio.core.util.ReflectionUtil;
import d10.p;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public abstract class PublisherWithUpdate<Update, Result> {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f39233a = i0.a(v0.c().G());

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList f39234b = new CopyOnWriteArrayList();

    @d(c = "com.jumio.core.model.PublisherWithUpdate$publishError$1", f = "PublisherWithUpdate.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubscriberWithUpdate<Update, Result> f39235a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Throwable f39236b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SubscriberWithUpdate<Update, Result> subscriberWithUpdate, Throwable th2, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f39235a = subscriberWithUpdate;
            this.f39236b = th2;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a(this.f39235a, this.f39236b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            k.b(obj);
            this.f39235a.onError(this.f39236b);
            return Unit.f56620a;
        }
    }

    @d(c = "com.jumio.core.model.PublisherWithUpdate$publishResult$1", f = "PublisherWithUpdate.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubscriberWithUpdate<Update, Result> f39237a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Result f39238b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SubscriberWithUpdate<Update, Result> subscriberWithUpdate, Result result, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f39237a = subscriberWithUpdate;
            this.f39238b = result;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f39237a, this.f39238b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            k.b(obj);
            this.f39237a.onResult(this.f39238b);
            return Unit.f56620a;
        }
    }

    @d(c = "com.jumio.core.model.PublisherWithUpdate$publishUpdate$1", f = "PublisherWithUpdate.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubscriberWithUpdate<Update, Result> f39239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Update f39240b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SubscriberWithUpdate<Update, Result> subscriberWithUpdate, Update update, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f39239a = subscriberWithUpdate;
            this.f39240b = update;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f39239a, this.f39240b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            k.b(obj);
            this.f39239a.onUpdate(this.f39240b);
            return Unit.f56620a;
        }
    }

    public final h0 getMainScope() {
        return this.f39233a;
    }

    public final void publishError(Throwable th2) {
        Iterator it2 = this.f39234b.iterator();
        while (it2.hasNext()) {
            SubscriberWithUpdate subscriberWithUpdate = (SubscriberWithUpdate) it2.next();
            try {
                Method method = ReflectionUtil.getMethod(subscriberWithUpdate, "onError", th2.getClass());
                InvokeOnUiThread invokeOnUiThread = method != null ? (InvokeOnUiThread) method.getAnnotation(InvokeOnUiThread.class) : null;
                if (invokeOnUiThread != null) {
                    if (invokeOnUiThread.value()) {
                        n1 unused = i.d(this.f39233a, (CoroutineContext) null, (CoroutineStart) null, new a(subscriberWithUpdate, th2, (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
                    }
                }
                subscriberWithUpdate.onError(th2);
            } catch (NoSuchMethodException unused2) {
                subscriberWithUpdate.onError(th2);
            }
        }
    }

    public void publishResult(Result result) {
        Class<?> cls;
        Iterator it2 = this.f39234b.iterator();
        while (it2.hasNext()) {
            SubscriberWithUpdate subscriberWithUpdate = (SubscriberWithUpdate) it2.next();
            if (result != null) {
                try {
                    cls = result.getClass();
                } catch (NoSuchMethodException unused) {
                    subscriberWithUpdate.onResult(result);
                }
            } else {
                cls = null;
            }
            Method method = ReflectionUtil.getMethod(subscriberWithUpdate, "onResult", cls);
            InvokeOnUiThread invokeOnUiThread = method != null ? (InvokeOnUiThread) method.getAnnotation(InvokeOnUiThread.class) : null;
            if (invokeOnUiThread != null) {
                if (invokeOnUiThread.value()) {
                    n1 unused2 = i.d(this.f39233a, (CoroutineContext) null, (CoroutineStart) null, new b(subscriberWithUpdate, result, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
                }
            }
            subscriberWithUpdate.onResult(result);
        }
    }

    public void publishUpdate(Update update) {
        Iterator it2 = this.f39234b.iterator();
        while (it2.hasNext()) {
            SubscriberWithUpdate subscriberWithUpdate = (SubscriberWithUpdate) it2.next();
            try {
                Method method = ReflectionUtil.getMethod(subscriberWithUpdate, "onUpdate", update.getClass());
                InvokeOnUiThread invokeOnUiThread = method != null ? (InvokeOnUiThread) method.getAnnotation(InvokeOnUiThread.class) : null;
                if (invokeOnUiThread != null) {
                    if (invokeOnUiThread.value()) {
                        n1 unused = i.d(this.f39233a, (CoroutineContext) null, (CoroutineStart) null, new c(subscriberWithUpdate, update, (kotlin.coroutines.c<? super c>) null), 3, (Object) null);
                    }
                }
                subscriberWithUpdate.onUpdate(update);
            } catch (NoSuchMethodException unused2) {
                subscriberWithUpdate.onUpdate(update);
            }
        }
    }

    public final boolean subscribe(SubscriberWithUpdate<Update, Result> subscriberWithUpdate) {
        return !this.f39234b.contains(subscriberWithUpdate) && this.f39234b.add(subscriberWithUpdate);
    }

    public final boolean unsubscribe(SubscriberWithUpdate<Update, Result> subscriberWithUpdate) {
        return this.f39234b.remove(subscriberWithUpdate);
    }
}
