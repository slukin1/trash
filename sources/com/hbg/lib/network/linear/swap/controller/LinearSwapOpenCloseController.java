package com.hbg.lib.network.linear.swap.controller;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOpenRight;
import h8.a;
import i8.i;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;

public final class LinearSwapOpenCloseController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, LinearSwapOpenRight> f70325a = new HashMap();

    public static boolean b(String str) {
        Map<String, LinearSwapOpenRight> map = f70325a;
        if (map.get(str) == null || map.get(str).getRight() == 1) {
            return true;
        }
        return false;
    }

    public static Observable<LinearSwapOpenRight> c(boolean z11, String str) {
        LinearSwapOpenRight linearSwapOpenRight;
        if (!z11 || (linearSwapOpenRight = f70325a.get(str)) == null) {
            return a.a().m(str).b().doOnNext(new i(str));
        }
        return Observable.just(linearSwapOpenRight);
    }
}
