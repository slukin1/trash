package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

public final class d {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        a.n(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<b> atomicReference, b bVar, Class<?> cls) {
        Objects.requireNonNull(bVar, "next is null");
        if (atomicReference.compareAndSet((Object) null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean d(AtomicReference<z20.d> atomicReference, z20.d dVar, Class<?> cls) {
        Objects.requireNonNull(dVar, "next is null");
        if (atomicReference.compareAndSet((Object) null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean e(b bVar, b bVar2, Class<?> cls) {
        Objects.requireNonNull(bVar2, "next is null");
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        if (bVar == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean f(z20.d dVar, z20.d dVar2, Class<?> cls) {
        Objects.requireNonNull(dVar2, "next is null");
        if (dVar == null) {
            return true;
        }
        dVar2.cancel();
        if (dVar == SubscriptionHelper.CANCELLED) {
            return false;
        }
        b(cls);
        return false;
    }
}
