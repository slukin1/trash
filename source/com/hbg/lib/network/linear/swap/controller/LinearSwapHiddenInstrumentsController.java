package com.hbg.lib.network.linear.swap.controller;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapHiddenInstruments;
import h8.a;
import i8.e;
import java.util.HashSet;
import java.util.Set;
import rx.Observable;

public final class LinearSwapHiddenInstrumentsController {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f70322a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static LinearSwapHiddenInstruments f70323b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f70324c = new HashSet();

    public static Observable<LinearSwapHiddenInstruments> b(boolean z11) {
        LinearSwapHiddenInstruments linearSwapHiddenInstruments;
        if (!z11 || (linearSwapHiddenInstruments = f70323b) == null) {
            return a.a().getHiddenInstruments().b().map(e.f55019b);
        }
        return Observable.just(linearSwapHiddenInstruments);
    }

    public static boolean c() {
        boolean z11;
        synchronized (f70322a) {
            LinearSwapHiddenInstruments linearSwapHiddenInstruments = f70323b;
            z11 = false;
            if (linearSwapHiddenInstruments != null && linearSwapHiddenInstruments.getHiddenAll() == 1) {
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean d(String str) {
        boolean contains;
        synchronized (f70322a) {
            contains = f70324c.contains(str);
        }
        return contains;
    }

    public static /* synthetic */ LinearSwapHiddenInstruments e(LinearSwapHiddenInstruments linearSwapHiddenInstruments) {
        synchronized (f70322a) {
            f70323b = linearSwapHiddenInstruments;
            Set<String> set = f70324c;
            set.clear();
            set.addAll(linearSwapHiddenInstruments.getHiddenList());
        }
        return linearSwapHiddenInstruments;
    }
}
