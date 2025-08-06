package com.huobi.contract.helper;

import android.text.TextUtils;
import bj.e;
import bj.f;
import bj.g;
import bj.h;
import bj.i;
import bj.j;
import bj.k;
import bj.l;
import bj.m;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.ContractHiddenInstruments;
import com.hbg.lib.network.contract.core.controller.ContractHiddenInstrumentsController;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.contract.retrofit.service.ContractService;
import com.hbg.module.contract.helper.ContractRequestHelper;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.contract.entity.ContractLightLimitLevel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;

public class ContractCurrencyConfigImpl implements e {

    /* renamed from: a  reason: collision with root package name */
    public List<ContractCurrencyInfo> f43106a = null;

    /* renamed from: b  reason: collision with root package name */
    public List<ContractCoinInfo> f43107b = null;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, ContractLightLimitLevel> f43108c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, ContractCurrencyInfo> f43109d = new HashMap();

    /* access modifiers changed from: private */
    public /* synthetic */ List A(List list, ContractHiddenInstruments contractHiddenInstruments) {
        this.f43106a = list;
        synchronized (this.f43109d) {
            this.f43109d.clear();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) it2.next();
                contractCurrencyInfo.setNotSupportTrade(ContractHiddenInstrumentsController.d(contractCurrencyInfo.getSymbol()));
                this.f43109d.put(contractCurrencyInfo.getContractCode(), contractCurrencyInfo);
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List B(List list) {
        this.f43106a = list;
        synchronized (this.f43109d) {
            this.f43109d.clear();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) it2.next();
                contractCurrencyInfo.setNotSupportTrade(ContractHiddenInstrumentsController.d(contractCurrencyInfo.getSymbol()));
                this.f43109d.put(contractCurrencyInfo.getContractCode(), contractCurrencyInfo);
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map D() {
        return this.f43108c;
    }

    public static /* synthetic */ void E(Map map, ContractLightLimitLevel contractLightLimitLevel) {
        if (contractLightLimitLevel != null) {
            map.put(contractLightLimitLevel.getSymbol(), contractLightLimitLevel);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List y(List list) {
        this.f43107b = list;
        return list;
    }

    public static /* synthetic */ Boolean z(List list) {
        return Boolean.valueOf(list != null);
    }

    public int b(String str, int i11) {
        if (str == null) {
            return i11;
        }
        String str2 = null;
        List<ContractCurrencyInfo> list = this.f43106a;
        if (list != null && !list.isEmpty()) {
            Iterator<ContractCurrencyInfo> it2 = this.f43106a.iterator();
            while (true) {
                if (it2.hasNext()) {
                    ContractCurrencyInfo next = it2.next();
                    if (next != null && next.getSymbol() != null && next.getContractCode().equalsIgnoreCase(str)) {
                        str2 = next.getPriceTick();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return i11;
        }
        try {
            int indexOf = new BigDecimal(str2).toPlainString().indexOf("1");
            if (indexOf == -1) {
                return i11;
            }
            int i12 = indexOf - 1;
            if (i12 < 0) {
                i12 = 0;
            }
            return i12;
        } catch (Exception unused) {
            return i11;
        }
    }

    public int c(String str, int i11) {
        List<ContractCoinInfo> list;
        if (str == null || (list = this.f43107b) == null || list.isEmpty()) {
            return i11;
        }
        for (ContractCoinInfo next : this.f43107b) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getOtherAmountPrecision();
            }
        }
        return i11;
    }

    public int d(String str, int i11) {
        List<ContractCoinInfo> list;
        if (str == null || (list = this.f43107b) == null || list.isEmpty()) {
            return i11;
        }
        for (ContractCoinInfo next : this.f43107b) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getFinancialAmountPrecision();
            }
        }
        return i11;
    }

    public ContractCurrencyInfo e(String str) {
        ContractCurrencyInfo contractCurrencyInfo;
        synchronized (this.f43109d) {
            contractCurrencyInfo = this.f43109d.get(str);
        }
        return contractCurrencyInfo;
    }

    public ContractCurrencyInfo f() {
        for (ContractCurrencyInfo next : this.f43106a) {
            if (!next.isNotSupportTrade()) {
                return next;
            }
        }
        return null;
    }

    public List<ContractCurrencyInfo> g() {
        ArrayList arrayList = new ArrayList();
        List<ContractCurrencyInfo> list = this.f43106a;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(this.f43106a);
        }
        return arrayList;
    }

    public Observable<List<ContractCurrencyInfo>> h(boolean z11) {
        List<ContractCurrencyInfo> list;
        if (!z11 || (list = this.f43106a) == null || list.isEmpty()) {
            return Observable.zip(((ContractService) ContractRetrofit.request(ContractService.class)).getContractCurrencyAllInfo().compose(ContractRetrofit.h()).subscribeOn(Schedulers.io()), ContractHiddenInstrumentsController.b(z11).subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null)), new m(this));
        }
        return Observable.just(this.f43106a);
    }

    public Observable<List<ContractCoinInfo>> i(boolean z11, String str) {
        Observable<R> map = ((ContractService) ContractRetrofit.request(ContractService.class)).getCoinInfo(str).compose(ContractRetrofit.h()).map(new h(this));
        return z11 ? Observable.concat(Observable.just(this.f43107b), map).takeFirst(j.f12438b) : map;
    }

    public List<ContractCoinInfo> j() {
        return this.f43107b;
    }

    public LinkedHashSet<String> k() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        List<ContractCurrencyInfo> list = this.f43106a;
        if (list != null && list.size() > 0) {
            for (ContractCurrencyInfo symbol : this.f43106a) {
                linkedHashSet.add(symbol.getSymbol());
            }
        }
        return linkedHashSet;
    }

    public List<ContractCoinInfo> l() {
        ArrayList arrayList = new ArrayList();
        List<ContractCoinInfo> list = this.f43107b;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(this.f43107b);
        }
        return arrayList;
    }

    public Observable<Map<String, ContractLightLimitLevel>> m(boolean z11) {
        Observable<R> collect = ContractRequestHelper.a().flatMap(k.f12442b).collect(new g(this), f.f12420b);
        return z11 ? Observable.concat(Observable.just(this.f43108c), collect).takeFirst(l.f12446b) : collect;
    }

    public int n(String str, int i11) {
        List<ContractCoinInfo> list;
        if (str == null || (list = this.f43107b) == null || list.isEmpty()) {
            return i11;
        }
        for (ContractCoinInfo next : this.f43107b) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getPricePrecision();
            }
        }
        return i11;
    }

    public Observable<List<ContractCurrencyInfo>> o(boolean z11) {
        List<ContractCurrencyInfo> list;
        if (!z11 || (list = this.f43106a) == null || list.isEmpty()) {
            return ((ContractService) ContractRetrofit.request(ContractService.class)).getContractCurrencyAllInfo().compose(ContractRetrofit.h()).map(new i(this));
        }
        return Observable.just(this.f43106a);
    }

    public List<ContractCurrencyInfo> p() {
        return this.f43106a;
    }

    public int q(String str, int i11) {
        List<ContractCoinInfo> list;
        if (str == null || (list = this.f43107b) == null || list.isEmpty()) {
            return i11;
        }
        for (ContractCoinInfo next : this.f43107b) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getAmountPrecision();
            }
        }
        return i11;
    }
}
