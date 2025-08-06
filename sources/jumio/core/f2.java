package jumio.core;

import com.jumio.core.model.InvokeOnUiThread;
import com.jumio.core.model.Subscriber;
import com.jumio.core.util.ReflectionUtil;
import d10.p;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public class f2<Result> {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f56197a = i0.a(v0.c().G());

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList f56198b = new CopyOnWriteArrayList();

    @d(c = "com.jumio.core.model.Publisher$publishError$1", f = "Publisher.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Subscriber<Result> f56199a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Throwable f56200b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Subscriber<Result> subscriber, Throwable th2, c<? super a> cVar) {
            super(2, cVar);
            this.f56199a = subscriber;
            this.f56200b = th2;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new a(this.f56199a, this.f56200b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            k.b(obj);
            this.f56199a.onError(this.f56200b);
            return Unit.f56620a;
        }
    }

    @d(c = "com.jumio.core.model.Publisher$publishResult$1", f = "Publisher.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Subscriber<Result> f56201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Result f56202b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Subscriber<Result> subscriber, Result result, c<? super b> cVar) {
            super(2, cVar);
            this.f56201a = subscriber;
            this.f56202b = result;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new b(this.f56201a, this.f56202b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            k.b(obj);
            this.f56201a.onResult(this.f56202b);
            return Unit.f56620a;
        }
    }

    public final boolean add(Subscriber<Result> subscriber) {
        return !this.f56198b.contains(subscriber) && this.f56198b.add(subscriber);
    }

    public final void publishError(Throwable th2) {
        Iterator it2 = this.f56198b.iterator();
        while (it2.hasNext()) {
            Subscriber subscriber = (Subscriber) it2.next();
            try {
                Method method = ReflectionUtil.getMethod(subscriber, "onError", th2.getClass());
                InvokeOnUiThread invokeOnUiThread = method != null ? (InvokeOnUiThread) method.getAnnotation(InvokeOnUiThread.class) : null;
                if (invokeOnUiThread != null) {
                    if (invokeOnUiThread.value()) {
                        n1 unused = i.d(this.f56197a, (CoroutineContext) null, (CoroutineStart) null, new a(subscriber, th2, (c<? super a>) null), 3, (Object) null);
                    }
                }
                subscriber.onError(th2);
            } catch (NoSuchMethodException unused2) {
                subscriber.onError(th2);
            }
        }
    }

    public final void publishResult(Result result) {
        Class<?> cls;
        Iterator it2 = this.f56198b.iterator();
        while (it2.hasNext()) {
            Subscriber subscriber = (Subscriber) it2.next();
            if (result != null) {
                try {
                    cls = result.getClass();
                } catch (NoSuchMethodException unused) {
                    subscriber.onResult(result);
                }
            } else {
                cls = null;
            }
            Method method = ReflectionUtil.getMethod(subscriber, "onResult", cls);
            InvokeOnUiThread invokeOnUiThread = method != null ? (InvokeOnUiThread) method.getAnnotation(InvokeOnUiThread.class) : null;
            if (invokeOnUiThread != null) {
                if (invokeOnUiThread.value()) {
                    n1 unused2 = i.d(this.f56197a, (CoroutineContext) null, (CoroutineStart) null, new b(subscriber, result, (c<? super b>) null), 3, (Object) null);
                }
            }
            subscriber.onResult(result);
        }
    }

    public final boolean remove(Subscriber<Result> subscriber) {
        return this.f56198b.remove(subscriber);
    }

    public final void removeAllSubscriber() {
        this.f56198b.clear();
    }
}
