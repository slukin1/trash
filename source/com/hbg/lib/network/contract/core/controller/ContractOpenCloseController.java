package com.hbg.lib.network.contract.core.controller;

import com.hbg.lib.network.contract.core.bean.ContractOpenRight;
import java.util.HashMap;
import java.util.Map;
import q7.a;
import r7.d;
import rx.Observable;

public final class ContractOpenCloseController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, ContractOpenRight> f69232a = new HashMap();

    public static boolean b(String str) {
        Map<String, ContractOpenRight> map = f69232a;
        if (map.get(str) == null || map.get(str).getRight() == 1) {
            return true;
        }
        return false;
    }

    public static Observable<ContractOpenRight> c(boolean z11, String str) {
        ContractOpenRight contractOpenRight;
        if (!z11 || (contractOpenRight = f69232a.get(str)) == null) {
            return a.a().m(str).b().doOnNext(new d(str));
        }
        return Observable.just(contractOpenRight);
    }
}
