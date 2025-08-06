package com.huobi.finance.controller;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.VirtualAddressInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import tq.p;

public class VirtualAddressProvider {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ArrayList<VirtualAddressInfo>> f45411a = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static VirtualAddressProvider f45412a = new VirtualAddressProvider();
    }

    public static VirtualAddressProvider f() {
        return a.f45412a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(String str, ArrayList arrayList) {
        this.f45411a.put(str, arrayList);
    }

    public static /* synthetic */ Boolean h(ArrayList arrayList) {
        return Boolean.valueOf(arrayList != null);
    }

    public void c() {
        this.f45411a.clear();
    }

    public List<VirtualAddressInfo> d(String str) {
        return this.f45411a.get(str);
    }

    public Observable<ArrayList<VirtualAddressInfo>> e(String str, String str2, boolean z11) {
        MapParamsBuilder a11 = new MapParamsBuilder().a(FirebaseAnalytics.Param.CURRENCY, str);
        if (str2 != null) {
            a11.a("chain", str2);
        }
        Observable<R> doOnNext = ((FinanceService) p.W(FinanceService.class)).getWithdrawAddress(a11.b()).compose(p.a0()).doOnNext(new j(this, str));
        return z11 ? Observable.concat(Observable.just(this.f45411a.get(str)), doOnNext).takeFirst(k.f45428b) : doOnNext;
    }
}
