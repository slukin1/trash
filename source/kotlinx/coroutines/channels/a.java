package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.k0;

public class a<E> extends e<E> implements ReceiveChannel {
    public void J0(Throwable th2) {
        d g12 = g1();
        CancellationException cancellationException = null;
        if (th2 != null) {
            if (th2 instanceof CancellationException) {
                cancellationException = (CancellationException) th2;
            }
            if (cancellationException == null) {
                cancellationException = d1.a(k0.a(this) + " was cancelled", th2);
            }
        }
        g12.b(cancellationException);
    }

    public boolean t0(Throwable th2) {
        e0.a(getContext(), th2);
        return true;
    }
}
