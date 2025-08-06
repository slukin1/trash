package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f55703a = new Termination();

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static boolean a(AtomicReference<Throwable> atomicReference, Throwable th2) {
        Throwable th3;
        Throwable th4;
        do {
            th3 = atomicReference.get();
            if (th3 == f55703a) {
                return false;
            }
            if (th3 == null) {
                th4 = th2;
            } else {
                th4 = new CompositeException(th3, th2);
            }
        } while (!atomicReference.compareAndSet(th3, th4));
        return true;
    }

    public static NullPointerException b(String str) {
        return new NullPointerException(d(str));
    }

    public static <T> T c(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw b(str);
    }

    public static String d(String str) {
        return str + " Null values are generally not allowed in 3.x operators and sources.";
    }

    public static Throwable e(AtomicReference<Throwable> atomicReference) {
        Throwable th2 = atomicReference.get();
        Throwable th3 = f55703a;
        return th2 != th3 ? atomicReference.getAndSet(th3) : th2;
    }

    public static String f(long j11, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j11 + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException g(Throwable th2) {
        if (th2 instanceof Error) {
            throw ((Error) th2);
        } else if (th2 instanceof RuntimeException) {
            return (RuntimeException) th2;
        } else {
            return new RuntimeException(th2);
        }
    }
}
