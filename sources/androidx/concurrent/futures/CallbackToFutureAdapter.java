package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CallbackToFutureAdapter {

    public static final class FutureGarbageCollectedException extends Throwable {
        public FutureGarbageCollectedException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public Object f6534a;

        /* renamed from: b  reason: collision with root package name */
        public c<T> f6535b;

        /* renamed from: c  reason: collision with root package name */
        public b<Void> f6536c = b.a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f6537d;

        public void a(Runnable runnable, Executor executor) {
            b<Void> bVar = this.f6536c;
            if (bVar != null) {
                bVar.addListener(runnable, executor);
            }
        }

        public void b() {
            this.f6534a = null;
            this.f6535b = null;
            this.f6536c.set(null);
        }

        public boolean c(T t11) {
            boolean z11 = true;
            this.f6537d = true;
            c<T> cVar = this.f6535b;
            if (cVar == null || !cVar.b(t11)) {
                z11 = false;
            }
            if (z11) {
                e();
            }
            return z11;
        }

        public boolean d() {
            boolean z11 = true;
            this.f6537d = true;
            c<T> cVar = this.f6535b;
            if (cVar == null || !cVar.a(true)) {
                z11 = false;
            }
            if (z11) {
                e();
            }
            return z11;
        }

        public final void e() {
            this.f6534a = null;
            this.f6535b = null;
            this.f6536c = null;
        }

        public boolean f(Throwable th2) {
            boolean z11 = true;
            this.f6537d = true;
            c<T> cVar = this.f6535b;
            if (cVar == null || !cVar.c(th2)) {
                z11 = false;
            }
            if (z11) {
                e();
            }
            return z11;
        }

        public void finalize() {
            b<Void> bVar;
            c<T> cVar = this.f6535b;
            if (cVar != null && !cVar.isDone()) {
                cVar.c(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f6534a));
            }
            if (!this.f6537d && (bVar = this.f6536c) != null) {
                bVar.set(null);
            }
        }
    }

    public interface b<T> {
        Object attachCompleter(a<T> aVar) throws Exception;
    }

    public static final class c<T> implements ListenableFuture<T> {

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<a<T>> f6538b;

        /* renamed from: c  reason: collision with root package name */
        public final AbstractResolvableFuture<T> f6539c = new a();

        public class a extends AbstractResolvableFuture<T> {
            public a() {
            }

            public String pendingToString() {
                a aVar = (a) c.this.f6538b.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f6534a + "]";
            }
        }

        public c(a<T> aVar) {
            this.f6538b = new WeakReference<>(aVar);
        }

        public boolean a(boolean z11) {
            return this.f6539c.cancel(z11);
        }

        public void addListener(Runnable runnable, Executor executor) {
            this.f6539c.addListener(runnable, executor);
        }

        public boolean b(T t11) {
            return this.f6539c.set(t11);
        }

        public boolean c(Throwable th2) {
            return this.f6539c.setException(th2);
        }

        public boolean cancel(boolean z11) {
            a aVar = (a) this.f6538b.get();
            boolean cancel = this.f6539c.cancel(z11);
            if (cancel && aVar != null) {
                aVar.b();
            }
            return cancel;
        }

        public T get() throws InterruptedException, ExecutionException {
            return this.f6539c.get();
        }

        public boolean isCancelled() {
            return this.f6539c.isCancelled();
        }

        public boolean isDone() {
            return this.f6539c.isDone();
        }

        public String toString() {
            return this.f6539c.toString();
        }

        public T get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.f6539c.get(j11, timeUnit);
        }
    }

    public static <T> ListenableFuture<T> a(b<T> bVar) {
        a aVar = new a();
        c<T> cVar = new c<>(aVar);
        aVar.f6535b = cVar;
        aVar.f6534a = bVar.getClass();
        try {
            Object attachCompleter = bVar.attachCompleter(aVar);
            if (attachCompleter != null) {
                aVar.f6534a = attachCompleter;
            }
        } catch (Exception e11) {
            cVar.c(e11);
        }
        return cVar;
    }
}
