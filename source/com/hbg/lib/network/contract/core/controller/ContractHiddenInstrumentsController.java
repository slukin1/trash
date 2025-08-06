package com.hbg.lib.network.contract.core.controller;

import com.hbg.lib.network.contract.core.bean.ContractHiddenInstruments;
import java.util.HashSet;
import java.util.Set;
import q7.a;
import r7.c;
import rx.Observable;

public final class ContractHiddenInstrumentsController {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f69229a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static ContractHiddenInstruments f69230b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f69231c = new HashSet();

    public static Observable<ContractHiddenInstruments> b(boolean z11) {
        ContractHiddenInstruments contractHiddenInstruments;
        if (!z11 || (contractHiddenInstruments = f69230b) == null) {
            return a.a().getHiddenInstruments().b().map(c.f70517b);
        }
        return Observable.just(contractHiddenInstruments);
    }

    public static boolean c() {
        boolean z11;
        synchronized (f69229a) {
            ContractHiddenInstruments contractHiddenInstruments = f69230b;
            z11 = false;
            if (contractHiddenInstruments != null && contractHiddenInstruments.getHiddenAll() == 1) {
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean d(String str) {
        boolean contains;
        synchronized (f69229a) {
            contains = f69231c.contains(str);
        }
        return contains;
    }

    public static /* synthetic */ ContractHiddenInstruments e(ContractHiddenInstruments contractHiddenInstruments) {
        synchronized (f69229a) {
            f69230b = contractHiddenInstruments;
            Set<String> set = f69231c;
            set.clear();
            set.addAll(contractHiddenInstruments.getHiddenList());
        }
        return contractHiddenInstruments;
    }
}
