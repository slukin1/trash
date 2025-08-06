package com.hbg.lib.network.index.core.controller;

import ad.i;
import c8.b;
import c8.c;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.xiaomi.mipush.sdk.Constants;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;

public class IndexCurrencyInfoController {

    /* renamed from: c  reason: collision with root package name */
    public static volatile IndexCurrencyInfoController f70300c;

    /* renamed from: a  reason: collision with root package name */
    public List<IndexCurrencyInfo> f70301a = null;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, IndexCurrencyInfo> f70302b;

    public class a implements Func1<List<SymbolPrice>, List<IndexCurrencyInfo>> {
        public a() {
        }

        /* renamed from: a */
        public List<IndexCurrencyInfo> call(List<SymbolPrice> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (SymbolPrice next : list) {
                IndexCurrencyInfo indexCurrencyInfo = new IndexCurrencyInfo();
                indexCurrencyInfo.setClose(next.getClose());
                String[] split = next.getSymbol().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split.length > 1) {
                    indexCurrencyInfo.setSymbol(split[0]);
                    indexCurrencyInfo.setQuoteCurrency(split[1]);
                }
                indexCurrencyInfo.setContractCode(next.getSymbol());
                indexCurrencyInfo.setContractShortType(next.getSymbol() + "-Index");
                arrayList.add(indexCurrencyInfo);
            }
            return arrayList;
        }
    }

    public static IndexCurrencyInfoController k() {
        if (f70300c == null) {
            synchronized (IndexCurrencyInfoController.class) {
                if (f70300c == null) {
                    f70300c = new IndexCurrencyInfoController();
                }
            }
        }
        return f70300c;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List m(List list) {
        this.f70301a = list;
        this.f70302b = new HashMap();
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ IndexCurrencyInfo n(IndexCurrencyInfo indexCurrencyInfo) {
        this.f70302b.put(indexCurrencyInfo.getContractShortType(), indexCurrencyInfo);
        return indexCurrencyInfo;
    }

    public static /* synthetic */ Boolean o(List list) {
        return Boolean.valueOf(list != null);
    }

    public List<IndexCurrencyInfo> d() {
        return f((String) null);
    }

    public List<IndexCurrencyInfo> e() {
        return f("usd");
    }

    public List<IndexCurrencyInfo> f(String str) {
        List<IndexCurrencyInfo> list;
        ArrayList arrayList = new ArrayList();
        if (str != null || (list = this.f70301a) == null) {
            List<IndexCurrencyInfo> list2 = this.f70301a;
            if (list2 != null && !list2.isEmpty()) {
                String[] split = str.split("_");
                for (IndexCurrencyInfo next : this.f70301a) {
                    for (String equalsIgnoreCase : split) {
                        if (equalsIgnoreCase.equalsIgnoreCase(next.getQuoteCurrency())) {
                            arrayList.add(next);
                        }
                    }
                }
            }
            return arrayList;
        }
        arrayList.addAll(list);
        return arrayList;
    }

    public Observable<List<IndexCurrencyInfo>> g(boolean z11) {
        Observable<List<R>> list = b8.a.a().h().b().map(new a()).map(new b(this)).flatMap(i.f3526b).map(new c8.a(this)).toList();
        return z11 ? Observable.concat(Observable.just(this.f70301a), list).takeFirst(c.f13013b) : list;
    }

    public Map<String, IndexCurrencyInfo> h() {
        return this.f70302b;
    }

    public List<String> i() {
        return j("usd");
    }

    public List<String> j(String str) {
        ArrayList arrayList = new ArrayList();
        List<IndexCurrencyInfo> list = this.f70301a;
        if (list != null && list.size() > 0) {
            for (IndexCurrencyInfo next : this.f70301a) {
                if (str.equalsIgnoreCase(next.getQuoteCurrency())) {
                    arrayList.add(next.getSymbol());
                }
            }
        }
        return arrayList;
    }

    public int l(String str, int i11) {
        if (str == null) {
            return i11;
        }
        BigDecimal bigDecimal = null;
        List<IndexCurrencyInfo> list = this.f70301a;
        if (list != null && !list.isEmpty()) {
            Iterator<IndexCurrencyInfo> it2 = this.f70301a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                IndexCurrencyInfo next = it2.next();
                if (next != null && next.getContractCode() != null && next.getContractCode().equalsIgnoreCase(str)) {
                    try {
                        bigDecimal = new BigDecimal(String.valueOf(next.getClose()));
                        break;
                    } catch (Throwable unused) {
                        bigDecimal = BigDecimal.ZERO;
                    }
                }
            }
        }
        if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            return i11;
        }
        String plainString = bigDecimal.toPlainString();
        int indexOf = plainString.indexOf(InstructionFileId.DOT) + 1;
        if (indexOf == 0) {
            return i11;
        }
        return plainString.length() - indexOf;
    }
}
