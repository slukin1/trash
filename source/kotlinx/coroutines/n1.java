package kotlinx.coroutines;

import d10.l;
import d10.p;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.sequences.g;

public interface n1 extends CoroutineContext.a {

    /* renamed from: r0  reason: collision with root package name */
    public static final b f57382r0 = b.f57383b;

    public static final class a {
        public static /* synthetic */ void a(n1 n1Var, CancellationException cancellationException, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    cancellationException = null;
                }
                n1Var.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(n1 n1Var, R r11, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return CoroutineContext.a.C0663a.a(n1Var, r11, pVar);
        }

        public static <E extends CoroutineContext.a> E c(n1 n1Var, CoroutineContext.b<E> bVar) {
            return CoroutineContext.a.C0663a.b(n1Var, bVar);
        }

        public static /* synthetic */ x0 d(n1 n1Var, boolean z11, boolean z12, l lVar, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    z11 = false;
                }
                if ((i11 & 2) != 0) {
                    z12 = true;
                }
                return n1Var.E(z11, z12, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext e(n1 n1Var, CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0663a.c(n1Var, bVar);
        }

        public static CoroutineContext f(n1 n1Var, CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0663a.d(n1Var, coroutineContext);
        }
    }

    public static final class b implements CoroutineContext.b<n1> {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ b f57383b = new b();
    }

    CancellationException A();

    x0 E(boolean z11, boolean z12, l<? super Throwable, Unit> lVar);

    Object F(c<? super Unit> cVar);

    x0 L(l<? super Throwable, Unit> lVar);

    boolean a();

    void b(CancellationException cancellationException);

    g<n1> getChildren();

    n1 getParent();

    boolean isActive();

    boolean isCancelled();

    boolean start();

    q v(s sVar);
}
