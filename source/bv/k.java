package bv;

import bv.g;
import com.huobi.woodpecker.kalle.d;
import com.huobi.woodpecker.kalle.simple.Callback;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public final class k<T extends g, S, F> extends FutureTask<h<S, F>> implements d {

    /* renamed from: b  reason: collision with root package name */
    public a<T, S, F> f19424b;

    /* renamed from: c  reason: collision with root package name */
    public final Callback<S, F> f19425c;

    public k(a<T, S, F> aVar, Callback<S, F> callback) {
        super(aVar);
        this.f19424b = aVar;
        this.f19425c = callback;
    }

    public void done() {
        try {
            this.f19425c.f((h) get());
        } catch (CancellationException unused) {
            this.f19425c.c();
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (isCancelled()) {
                this.f19425c.c();
            } else if (cause == null || !(cause instanceof Exception)) {
                this.f19425c.e(new Exception(cause));
            } else {
                this.f19425c.e((Exception) cause);
            }
        } catch (Exception e12) {
            if (isCancelled()) {
                this.f19425c.c();
            } else {
                this.f19425c.e(e12);
            }
        }
        this.f19425c.d();
    }

    public void run() {
        this.f19425c.g();
        super.run();
    }
}
