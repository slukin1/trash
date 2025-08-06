package com.huobi.contract.helper;

import bj.c;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.module.contract.service.ContractService;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractPriceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ContractAccountConfigImpl implements bj.a {

    /* renamed from: a  reason: collision with root package name */
    public List<ContractAccountInfo> f43101a = null;

    /* renamed from: b  reason: collision with root package name */
    public List<ContractPriceInfo> f43102b = null;

    /* renamed from: c  reason: collision with root package name */
    public ContractHeartBeat f43103c;

    public class a implements Action1<List<ContractPriceInfo>> {
        public a() {
        }

        /* renamed from: a */
        public void call(List<ContractPriceInfo> list) {
            if (list != null) {
                List unused = ContractAccountConfigImpl.this.f43102b = new ArrayList();
                ContractAccountConfigImpl.this.f43102b.addAll(list);
            }
        }
    }

    public class b implements Func1<List<ContractPriceInfo>, Boolean> {
        public b() {
        }

        /* renamed from: a */
        public Boolean call(List<ContractPriceInfo> list) {
            return Boolean.valueOf(list != null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(List list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            this.f43101a = arrayList;
            arrayList.addAll(list);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(ContractHeartBeat contractHeartBeat) {
        this.f43103c = contractHeartBeat;
    }

    public Observable<ContractHeartBeat> a() {
        return ((ContractService) ContractRetrofit.request(ContractService.class)).systemStatus().compose(ContractRetrofit.h()).doOnNext(new bj.b(this));
    }

    public void b() {
        this.f43101a = null;
    }

    public ContractHeartBeat c() {
        return this.f43103c;
    }

    public Observable<List<ContractAccountInfo>> d(Map<String, Object> map) {
        return ((com.huobi.contract.service.ContractService) ContractRetrofit.request(com.huobi.contract.service.ContractService.class)).getAccountInfo(map).compose(ContractRetrofit.h());
    }

    public Observable<List<ContractAccountInfo>> k(boolean z11) {
        List<ContractAccountInfo> list;
        if (!z11 || (list = this.f43101a) == null || list.isEmpty()) {
            return ((com.huobi.contract.service.ContractService) ContractRetrofit.request(com.huobi.contract.service.ContractService.class)).getAccountInfo(new HashMap()).compose(ContractRetrofit.h()).doOnNext(new c(this));
        }
        return Observable.just(this.f43101a);
    }

    public Observable<List<ContractPriceInfo>> l(boolean z11) {
        Observable<R> doOnNext = ((ContractService) ContractRetrofit.request(ContractService.class)).getPriceInfo().compose(ContractRetrofit.h()).doOnNext(new a());
        return z11 ? Observable.concat(Observable.just(this.f43102b), doOnNext).takeFirst(new b()) : doOnNext;
    }
}
