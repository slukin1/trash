package lm;

import com.huobi.kalle.c;
import com.huobi.kalle.simple.Callback;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import lm.g;

public final class i<T extends g, S, F> extends FutureTask<h<S, F>> implements c {

    /* renamed from: b  reason: collision with root package name */
    public a<T, S, F> f76280b;

    /* renamed from: c  reason: collision with root package name */
    public final Callback<S, F> f76281c;

    public i(a<T, S, F> aVar, Callback<S, F> callback) {
        super(aVar);
        this.f76280b = aVar;
        this.f76281c = callback;
    }

    public void done() {
        try {
            this.f76281c.f((h) get());
        } catch (CancellationException unused) {
            this.f76281c.c();
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (isCancelled()) {
                this.f76281c.c();
            } else if (cause == null || !(cause instanceof Exception)) {
                this.f76281c.e(new Exception(cause));
            } else {
                this.f76281c.e((Exception) cause);
            }
        } catch (Exception e12) {
            if (isCancelled()) {
                this.f76281c.c();
            } else {
                this.f76281c.e(e12);
            }
        }
        this.f76281c.d();
    }

    public void run() {
        this.f76281c.g();
        super.run();
    }
}
