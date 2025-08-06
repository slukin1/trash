package com.huobi.homemarket.model;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketOptionDataController {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, SymbolPrice> f72728a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<FutureContractInfo>> f72729b = new HashMap();

    public HashMap<String, SymbolPrice> a() {
        return this.f72728a;
    }

    public List<FutureContractInfo> b(String str) {
        return this.f72729b.get(str);
    }

    public SymbolPrice c(String str) {
        return this.f72728a.get(str);
    }

    public void d(List<FutureContractInfo> list) {
        this.f72729b.clear();
        for (FutureContractInfo next : list) {
            List list2 = this.f72729b.get(next.getSymbol());
            if (list2 == null) {
                list2 = new ArrayList();
                this.f72729b.put(next.getSymbol(), list2);
            }
            list2.add(next);
        }
    }

    public synchronized void e(List<SymbolPrice> list) {
        if (list != null) {
            for (SymbolPrice symbolPrice : new ArrayList(list)) {
                this.f72728a.put(symbolPrice.getSymbol(), symbolPrice);
            }
        }
    }

    public boolean f() {
        return this.f72729b.size() != 0;
    }
}
