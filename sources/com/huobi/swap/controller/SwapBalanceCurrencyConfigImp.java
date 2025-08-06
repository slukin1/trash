package com.huobi.swap.controller;

import android.text.TextUtils;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qs.a;
import qs.b;
import qs.c;
import rx.Observable;
import rx.schedulers.Schedulers;

public class SwapBalanceCurrencyConfigImp implements a {

    /* renamed from: b  reason: collision with root package name */
    public List<ProductInfo> f81512b = null;

    /* access modifiers changed from: private */
    public /* synthetic */ List i(List list) {
        this.f81512b = list;
        return list;
    }

    public static /* synthetic */ Boolean j(List list) {
        return Boolean.valueOf(list != null);
    }

    public List<ProductInfo> a() {
        ArrayList arrayList = new ArrayList();
        List<ProductInfo> list = this.f81512b;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public int b(String str, int i11) {
        int indexOf;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        List<ProductInfo> list = this.f81512b;
        if (list != null && !list.isEmpty()) {
            Iterator<ProductInfo> it2 = this.f81512b.iterator();
            while (true) {
                if (it2.hasNext()) {
                    ProductInfo next = it2.next();
                    if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                        str2 = next.getPriceTick();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str2) || (indexOf = str2.indexOf("1")) == -1) {
            return i11;
        }
        int i12 = indexOf - 1;
        if (i12 < 0) {
            return 0;
        }
        return i12;
    }

    public int c(String str, int i11) {
        List<ProductInfo> list;
        if (str == null || (list = this.f81512b) == null || list.isEmpty()) {
            return i11;
        }
        for (ProductInfo next : this.f81512b) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getOtherAmountPrecision();
            }
        }
        return i11;
    }

    public int d(String str, int i11) {
        List<ProductInfo> list;
        if (str == null || (list = this.f81512b) == null || list.isEmpty()) {
            return i11;
        }
        for (ProductInfo next : this.f81512b) {
            if (next != null && next.getSymbol() != null && next.getSymbol().equalsIgnoreCase(str)) {
                return next.getFinancialAmountPrecision();
            }
        }
        return i11;
    }

    public int e() {
        return 2;
    }

    public Observable<List<ProductInfo>> f(boolean z11) {
        Observable<R> subscribeOn = l9.a.a().v().b().map(new b(this)).subscribeOn(Schedulers.io());
        return z11 ? Observable.concat(Observable.just(this.f81512b), subscribeOn).takeFirst(c.f70383b) : subscribeOn;
    }
}
