package io.reactivex.rxjava3.internal.util;

import o00.a;

public final class c {
    public static void a() {
        if (!a.j()) {
            return;
        }
        if ((Thread.currentThread() instanceof io.reactivex.rxjava3.internal.schedulers.c) || a.m()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }
}
