package rx.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

public enum ExceptionsUtils {
    ;
    
    private static final Throwable TERMINATED = null;

    /* access modifiers changed from: public */
    static {
        TERMINATED = new Throwable("Terminated");
    }

    public static boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable th2) {
        Throwable th3;
        Throwable th4;
        do {
            th3 = atomicReference.get();
            if (th3 == TERMINATED) {
                return false;
            }
            if (th3 == null) {
                th4 = th2;
            } else if (th3 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th3).getExceptions());
                arrayList.add(th2);
                th4 = new CompositeException((Collection<? extends Throwable>) arrayList);
            } else {
                th4 = new CompositeException(th3, th2);
            }
        } while (!atomicReference.compareAndSet(th3, th4));
        return true;
    }

    public static boolean isTerminated(AtomicReference<Throwable> atomicReference) {
        return isTerminated(atomicReference.get());
    }

    public static Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable th2 = atomicReference.get();
        Throwable th3 = TERMINATED;
        return th2 != th3 ? atomicReference.getAndSet(th3) : th2;
    }

    public static boolean isTerminated(Throwable th2) {
        return th2 == TERMINATED;
    }
}
