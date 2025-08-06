package rx.exceptions;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import rx.Observer;
import rx.SingleSubscriber;

public final class Exceptions {
    private static final int MAX_DEPTH = 25;

    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static void addCause(Throwable th2, Throwable th3) {
        HashSet hashSet = new HashSet();
        int i11 = 0;
        while (th2.getCause() != null) {
            int i12 = i11 + 1;
            if (i11 < 25) {
                th2 = th2.getCause();
                if (!hashSet.contains(th2.getCause())) {
                    hashSet.add(th2.getCause());
                    i11 = i12;
                }
            } else {
                return;
            }
        }
        try {
            th2.initCause(th3);
        } catch (Throwable unused) {
        }
    }

    public static Throwable getFinalCause(Throwable th2) {
        int i11 = 0;
        while (th2.getCause() != null) {
            int i12 = i11 + 1;
            if (i11 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th2 = th2.getCause();
            i11 = i12;
        }
        return th2;
    }

    public static RuntimeException propagate(Throwable th2) {
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        } else {
            throw new RuntimeException(th2);
        }
    }

    public static void throwIfAny(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th2 = (Throwable) list.get(0);
                if (th2 instanceof RuntimeException) {
                    throw ((RuntimeException) th2);
                } else if (th2 instanceof Error) {
                    throw ((Error) th2);
                } else {
                    throw new RuntimeException(th2);
                }
            } else {
                throw new CompositeException((Collection<? extends Throwable>) list);
            }
        }
    }

    public static void throwIfFatal(Throwable th2) {
        if (th2 instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th2);
        } else if (th2 instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) th2);
        } else if (th2 instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) th2);
        } else if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        } else if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        } else if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }

    public static void throwOrReport(Throwable th2, Observer<?> observer, Object obj) {
        throwIfFatal(th2);
        observer.onError(OnErrorThrowable.addValueAsLastCause(th2, obj));
    }

    public static void throwOrReport(Throwable th2, SingleSubscriber<?> singleSubscriber, Object obj) {
        throwIfFatal(th2);
        singleSubscriber.onError(OnErrorThrowable.addValueAsLastCause(th2, obj));
    }

    public static void throwOrReport(Throwable th2, Observer<?> observer) {
        throwIfFatal(th2);
        observer.onError(th2);
    }

    public static void throwOrReport(Throwable th2, SingleSubscriber<?> singleSubscriber) {
        throwIfFatal(th2);
        singleSubscriber.onError(th2);
    }
}
