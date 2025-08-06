package kotlinx.coroutines.rx3;

import j00.f;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.n1;

public final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public final n1 f57448a;

    public a(n1 n1Var) {
        this.f57448a = n1Var;
    }

    public void cancel() {
        n1.a.a(this.f57448a, (CancellationException) null, 1, (Object) null);
    }
}
