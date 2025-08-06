package com.hbg.lib.network.swap.core.controller;

import android.text.TextUtils;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapHiddenInstruments;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l9.a;
import m9.j;
import m9.k;
import rx.Observable;
import rx.schedulers.Schedulers;

public class SwapCurrencyInfoController {

    /* renamed from: d  reason: collision with root package name */
    public static volatile SwapCurrencyInfoController f70758d;

    /* renamed from: a  reason: collision with root package name */
    public List<SwapCurrencyInfo> f70759a = null;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SwapCurrencyInfo> f70760b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, SwapCurrencyInfo> f70761c = new HashMap();

    public static SwapCurrencyInfoController k() {
        if (f70758d == null) {
            synchronized (SwapCurrencyInfoController.class) {
                if (f70758d == null) {
                    f70758d = new SwapCurrencyInfoController();
                }
            }
        }
        return f70758d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List s(List list, SwapHiddenInstruments swapHiddenInstruments) {
        this.f70759a = list;
        this.f70760b = new HashMap();
        synchronized (this.f70761c) {
            this.f70761c.clear();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) it2.next();
                swapCurrencyInfo.setNotSupportTrade(SwapHiddenInstrumentsController.d(swapCurrencyInfo.getContractCode()));
                this.f70760b.put(swapCurrencyInfo.getContractShortType(), swapCurrencyInfo);
                this.f70761c.put(swapCurrencyInfo.getContractCode(), swapCurrencyInfo);
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List t(List list) {
        this.f70759a = list;
        this.f70760b = new HashMap();
        synchronized (this.f70761c) {
            this.f70761c.clear();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) it2.next();
                swapCurrencyInfo.setNotSupportTrade(SwapHiddenInstrumentsController.d(swapCurrencyInfo.getContractCode()));
                this.f70760b.put(swapCurrencyInfo.getContractShortType(), swapCurrencyInfo);
                this.f70761c.put(swapCurrencyInfo.getContractCode(), swapCurrencyInfo);
            }
        }
        return list;
    }

    public SwapCurrencyInfo c(String str) {
        Map<String, SwapCurrencyInfo> map;
        if (!TextUtils.isEmpty(str) && (map = this.f70760b) != null) {
            return map.get(str);
        }
        return null;
    }

    public int d(String str, int i11) {
        List<SwapCurrencyInfo> list;
        if (str == null || (list = this.f70759a) == null || list.isEmpty()) {
            return i11;
        }
        for (SwapCurrencyInfo next : this.f70759a) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getAmountPrecision();
            }
        }
        return i11;
    }

    public List<SwapCurrencyInfo> e() {
        ArrayList arrayList = new ArrayList();
        List<SwapCurrencyInfo> list = this.f70759a;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(this.f70759a);
        }
        return arrayList;
    }

    public Observable<List<SwapCurrencyInfo>> f(boolean z11) {
        List<SwapCurrencyInfo> list;
        if (!z11 || (list = this.f70759a) == null || list.isEmpty()) {
            return Observable.zip(a.a().Q((String) null).b().subscribeOn(Schedulers.io()), SwapHiddenInstrumentsController.b(z11).subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null)), new k(this));
        }
        return Observable.just(this.f70759a);
    }

    public Observable<List<SwapCurrencyInfo>> g(boolean z11) {
        List<SwapCurrencyInfo> list;
        if (!z11 || (list = this.f70759a) == null || list.isEmpty()) {
            return a.a().Q((String) null).b().map(new j(this));
        }
        return Observable.just(this.f70759a);
    }

    public SwapCurrencyInfo h(String str) {
        List<SwapCurrencyInfo> e11 = e();
        if (e11 == null) {
            return null;
        }
        for (SwapCurrencyInfo next : e11) {
            if (next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public int i(String str, int i11) {
        List<SwapCurrencyInfo> list;
        if (str == null || (list = this.f70759a) == null || list.isEmpty()) {
            return i11;
        }
        for (SwapCurrencyInfo next : this.f70759a) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getFeeAmountPrecision();
            }
        }
        return i11;
    }

    public SwapCurrencyInfo j() {
        List<SwapCurrencyInfo> list = this.f70759a;
        if (list != null) {
            for (SwapCurrencyInfo next : list) {
                if (!next.isNotSupportTrade()) {
                    return next;
                }
            }
        }
        return null;
    }

    public int l(String str, int i11) {
        List<SwapCurrencyInfo> list;
        if (str == null || (list = this.f70759a) == null || list.isEmpty()) {
            return i11;
        }
        for (SwapCurrencyInfo next : this.f70759a) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getOtherAmountPrecision();
            }
        }
        return i11;
    }

    public int m(String str, int i11) {
        List<SwapCurrencyInfo> list;
        if (str == null || (list = this.f70759a) == null || list.isEmpty()) {
            return i11;
        }
        for (SwapCurrencyInfo next : this.f70759a) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getPricePrecision();
            }
        }
        return i11;
    }

    public int n(String str, int i11) {
        if (str == null) {
            return i11;
        }
        String str2 = null;
        List<SwapCurrencyInfo> list = this.f70759a;
        if (list != null && !list.isEmpty()) {
            Iterator<SwapCurrencyInfo> it2 = this.f70759a.iterator();
            while (true) {
                if (it2.hasNext()) {
                    SwapCurrencyInfo next = it2.next();
                    if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
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

    public int o(String str, int i11) {
        if (str == null) {
            return i11;
        }
        String str2 = null;
        List<SwapCurrencyInfo> list = this.f70759a;
        if (list != null && !list.isEmpty()) {
            Iterator<SwapCurrencyInfo> it2 = this.f70759a.iterator();
            while (true) {
                if (it2.hasNext()) {
                    SwapCurrencyInfo next = it2.next();
                    if (next != null && next.getSymbol() != null && next.getContractShortType().equalsIgnoreCase(str)) {
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

    public Map<String, SwapCurrencyInfo> p() {
        return this.f70760b;
    }

    public SwapCurrencyInfo q(String str) {
        SwapCurrencyInfo swapCurrencyInfo;
        synchronized (this.f70761c) {
            swapCurrencyInfo = this.f70761c.get(str);
        }
        return swapCurrencyInfo;
    }

    public List<String> r() {
        ArrayList arrayList = new ArrayList();
        List<SwapCurrencyInfo> list = this.f70759a;
        if (list != null && list.size() > 0) {
            for (SwapCurrencyInfo symbol : this.f70759a) {
                arrayList.add(symbol.getSymbol());
            }
        }
        return arrayList;
    }
}
