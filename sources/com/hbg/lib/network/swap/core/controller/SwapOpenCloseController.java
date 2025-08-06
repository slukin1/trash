package com.hbg.lib.network.swap.core.controller;

import com.hbg.lib.network.swap.core.bean.SwapOpenRight;
import java.util.HashMap;
import java.util.Map;
import l9.a;
import m9.p;
import rx.Observable;

public final class SwapOpenCloseController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, SwapOpenRight> f70765a = new HashMap();

    public static boolean b(String str) {
        Map<String, SwapOpenRight> map = f70765a;
        if (map.get(str) == null || map.get(str).getRight() == 1) {
            return true;
        }
        return false;
    }

    public static Observable<SwapOpenRight> c(boolean z11, String str) {
        SwapOpenRight swapOpenRight;
        if (!z11 || (swapOpenRight = f70765a.get(str)) == null) {
            return a.a().m(str).b().doOnNext(new p(str));
        }
        return Observable.just(swapOpenRight);
    }
}
