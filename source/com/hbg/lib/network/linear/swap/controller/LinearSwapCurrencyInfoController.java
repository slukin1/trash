package com.hbg.lib.network.linear.swap.controller;

import android.text.TextUtils;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;

public class LinearSwapCurrencyInfoController {

    /* renamed from: c  reason: collision with root package name */
    public static volatile LinearSwapCurrencyInfoController f70318c;

    /* renamed from: a  reason: collision with root package name */
    public final List<LinearSwapContractInfo> f70319a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, LinearSwapContractInfo> f70320b = new HashMap();

    public class a implements Action1<List<LinearSwapContractInfo>> {
        public a() {
        }

        /* renamed from: a */
        public void call(List<LinearSwapContractInfo> list) {
            synchronized (LinearSwapCurrencyInfoController.this.f70319a) {
                LinearSwapCurrencyInfoController.this.f70319a.clear();
                LinearSwapCurrencyInfoController.this.f70319a.addAll(list);
            }
            synchronized (LinearSwapCurrencyInfoController.this.f70320b) {
                LinearSwapCurrencyInfoController.this.f70320b.clear();
                for (LinearSwapContractInfo next : list) {
                    LinearSwapCurrencyInfoController.this.f70320b.put(next.getContractCode(), next);
                }
            }
        }
    }

    public static LinearSwapCurrencyInfoController l() {
        if (f70318c == null) {
            synchronized (LinearSwapCurrencyInfoController.class) {
                if (f70318c == null) {
                    f70318c = new LinearSwapCurrencyInfoController();
                }
            }
        }
        return f70318c;
    }

    public LinearSwapContractInfo c() {
        LinearSwapContractInfo linearSwapContractInfo;
        synchronized (this.f70319a) {
            linearSwapContractInfo = null;
            if (!this.f70319a.isEmpty()) {
                Iterator<LinearSwapContractInfo> it2 = this.f70319a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    LinearSwapContractInfo next = it2.next();
                    if (next.isLinearSwapSwap() && "BTC".equalsIgnoreCase(next.getSymbol()) && "USDT".equalsIgnoreCase(next.getTradePartition())) {
                        linearSwapContractInfo = next;
                        break;
                    }
                }
                if (linearSwapContractInfo == null) {
                    linearSwapContractInfo = this.f70319a.get(0);
                }
            }
        }
        return linearSwapContractInfo;
    }

    public Map<String, LinearSwapContractInfo> d() {
        HashMap hashMap;
        synchronized (this.f70320b) {
            hashMap = new HashMap(this.f70320b);
        }
        return hashMap;
    }

    public int e(String str, int i11) {
        LinearSwapContractInfo linearSwapContractInfo;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        synchronized (this.f70320b) {
            if (!this.f70320b.isEmpty() && (linearSwapContractInfo = this.f70320b.get(str)) != null) {
                str2 = linearSwapContractInfo.getContractFace();
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

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        return "";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String f(java.lang.String r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0005
            java.lang.String r5 = ""
            return r5
        L_0x0005:
            java.util.List<com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo> r0 = r4.f70319a
            monitor-enter(r0)
            java.util.List<com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo> r1 = r4.f70319a     // Catch:{ all -> 0x003f }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x003b
            java.util.List<com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo> r1 = r4.f70319a     // Catch:{ all -> 0x003f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x003f }
        L_0x0016:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x003f }
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo r2 = (com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo) r2     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x0016
            java.lang.String r3 = r2.getSymbol()     // Catch:{ all -> 0x003f }
            if (r3 != 0) goto L_0x002b
            goto L_0x0016
        L_0x002b:
            java.lang.String r3 = r2.getSymbol()     // Catch:{ all -> 0x003f }
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x0016
            java.lang.String r5 = r2.getContractFace()     // Catch:{ all -> 0x003f }
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return r5
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            java.lang.String r5 = ""
            return r5
        L_0x003f:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController.f(java.lang.String):java.lang.String");
    }

    public List<LinearSwapContractInfo> g() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f70319a) {
            if (!this.f70319a.isEmpty()) {
                arrayList.addAll(this.f70319a);
            }
        }
        return arrayList;
    }

    public Observable<List<LinearSwapContractInfo>> h(boolean z11) {
        return (!z11 || this.f70319a.isEmpty()) ? h8.a.a().g0("", TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL).b().doOnNext(new a()) : Observable.just(this.f70319a);
    }

    public int i(String str, int i11) {
        LinearSwapContractInfo linearSwapContractInfo;
        if (str == null) {
            return i11;
        }
        synchronized (this.f70320b) {
            if (!this.f70320b.isEmpty() && (linearSwapContractInfo = this.f70320b.get(str)) != null) {
                i11 = linearSwapContractInfo.getFeeAmountPrecision();
            }
        }
        return i11;
    }

    public LinearSwapContractInfo j() {
        LinearSwapContractInfo linearSwapContractInfo;
        synchronized (this.f70319a) {
            if (this.f70319a.size() > 0) {
                Iterator<LinearSwapContractInfo> it2 = this.f70319a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    linearSwapContractInfo = it2.next();
                    if (!linearSwapContractInfo.isNotSupportTrade()) {
                        break;
                    }
                }
            }
            linearSwapContractInfo = null;
        }
        return linearSwapContractInfo;
    }

    public LinearSwapContractInfo k(String str) {
        synchronized (this.f70320b) {
            for (Map.Entry<String, LinearSwapContractInfo> value : this.f70320b.entrySet()) {
                LinearSwapContractInfo linearSwapContractInfo = (LinearSwapContractInfo) value.getValue();
                if (linearSwapContractInfo != null && linearSwapContractInfo.getContractShortType().equals(str)) {
                    return linearSwapContractInfo;
                }
            }
            LinearSwapContractInfo linearSwapContractInfo2 = this.f70320b.get(str);
            return linearSwapContractInfo2;
        }
    }

    public LinearSwapContractInfo m(String str) {
        LinearSwapContractInfo linearSwapContractInfo;
        synchronized (this.f70320b) {
            linearSwapContractInfo = this.f70320b.get(str);
        }
        return linearSwapContractInfo;
    }

    public LinearSwapContractInfo n(String str) {
        synchronized (this.f70320b) {
            if (this.f70320b.size() > 0) {
                for (String str2 : this.f70320b.keySet()) {
                    LinearSwapContractInfo linearSwapContractInfo = this.f70320b.get(str2);
                    if (linearSwapContractInfo.getContractShortType().equals(str)) {
                        return linearSwapContractInfo;
                    }
                }
            }
            return null;
        }
    }

    public int o(String str, int i11) {
        LinearSwapContractInfo linearSwapContractInfo;
        if (str == null) {
            return i11;
        }
        synchronized (this.f70320b) {
            if (!this.f70320b.isEmpty() && (linearSwapContractInfo = this.f70320b.get(str)) != null) {
                i11 = linearSwapContractInfo.getOtherAmountPrecision();
            }
        }
        return i11;
    }

    public int p(String str, int i11) {
        LinearSwapContractInfo linearSwapContractInfo;
        if (str == null) {
            return i11;
        }
        String str2 = null;
        synchronized (this.f70320b) {
            if (!this.f70320b.isEmpty() && (linearSwapContractInfo = this.f70320b.get(str)) != null) {
                str2 = linearSwapContractInfo.getPriceTick();
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

    public int q(String str, int i11) {
        if (str == null) {
            return i11;
        }
        String str2 = null;
        synchronized (this.f70319a) {
            if (!this.f70319a.isEmpty()) {
                Iterator<LinearSwapContractInfo> it2 = this.f70319a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    LinearSwapContractInfo next = it2.next();
                    if (next != null) {
                        if (next.getContractShortType() != null) {
                            if (next.getContractShortType().equalsIgnoreCase(str)) {
                                str2 = next.getPriceTick();
                                break;
                            }
                        }
                    }
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

    public List<String> r() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.f70319a) {
            if (this.f70319a.size() > 0) {
                for (LinearSwapContractInfo symbol : this.f70319a) {
                    linkedHashSet.add(symbol.getSymbol());
                }
            }
        }
        return new ArrayList(linkedHashSet);
    }
}
