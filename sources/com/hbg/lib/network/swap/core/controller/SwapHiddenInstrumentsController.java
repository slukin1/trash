package com.hbg.lib.network.swap.core.controller;

import com.hbg.lib.network.swap.core.bean.SwapHiddenInstruments;
import java.util.HashSet;
import java.util.Set;
import l9.a;
import m9.l;
import rx.Observable;

public final class SwapHiddenInstrumentsController {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f70762a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static SwapHiddenInstruments f70763b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f70764c = new HashSet();

    public static Observable<SwapHiddenInstruments> b(boolean z11) {
        SwapHiddenInstruments swapHiddenInstruments;
        if (!z11 || (swapHiddenInstruments = f70763b) == null) {
            return a.a().getHiddenInstruments().b().map(l.f58131b);
        }
        return Observable.just(swapHiddenInstruments);
    }

    public static boolean c() {
        boolean z11;
        synchronized (f70762a) {
            SwapHiddenInstruments swapHiddenInstruments = f70763b;
            z11 = false;
            if (swapHiddenInstruments != null && swapHiddenInstruments.getHiddenAll() == 1) {
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean d(String str) {
        boolean contains;
        synchronized (f70762a) {
            contains = f70764c.contains(str);
        }
        return contains;
    }

    public static /* synthetic */ SwapHiddenInstruments e(SwapHiddenInstruments swapHiddenInstruments) {
        synchronized (f70762a) {
            f70763b = swapHiddenInstruments;
            Set<String> set = f70764c;
            set.clear();
            set.addAll(swapHiddenInstruments.getHiddenList());
        }
        return swapHiddenInstruments;
    }
}
