package com.huobi.finance.model.subaccount;

import al.s;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.pro.core.bean.DefiBoxAsset;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import com.huobi.defibox.DefiChainListProvider;
import com.huobi.finance.bean.OnChainDataTotal;
import i6.m;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import rx.Observable;
import wk.p0;
import x8.a;
import xk.n;
import xk.o;
import xk.p;
import xk.v;

public class OnChainDataProvider implements v<OnChainDataTotal> {
    /* access modifiers changed from: private */
    public /* synthetic */ OnChainDataTotal g(List list, List list2) {
        OnChainDataTotal onChainDataTotal = new OnChainDataTotal();
        onChainDataTotal.setUserAddrInfoList(list2);
        UserAddrInfo f11 = f(list2);
        s.h(f11);
        onChainDataTotal.setSelectedAddr(f11);
        return onChainDataTotal;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable i(String str, boolean z11, OnChainDataTotal onChainDataTotal) {
        UserAddrInfo selectedAddr = onChainDataTotal.getSelectedAddr();
        if (selectedAddr == null) {
            return Observable.just(onChainDataTotal);
        }
        return Observable.zip(p0.g("btc", z11), a.a().D(BaseModuleConfig.a().f(), str, selectedAddr.getChain(), selectedAddr.getAddress()).b(), new p(this, onChainDataTotal));
    }

    public Observable<OnChainDataTotal> a(boolean z11) {
        Observable<List<DefiChainInfo>> d11 = DefiChainListProvider.d(true);
        String uid = BaseModuleConfig.a().getUid();
        return Observable.zip(d11, a.a().getDefiBoUserAddrList(BaseModuleConfig.a().f(), uid).b(), new o(this)).flatMap(new n(this, uid, z11));
    }

    /* renamed from: e */
    public final OnChainDataTotal h(OnChainDataTotal onChainDataTotal, Map<String, BigDecimal> map, DefiBoxAsset defiBoxAsset) {
        BigDecimal bigDecimal = map.get("usdt");
        if (bigDecimal != null) {
            BigDecimal multiply = m.a(defiBoxAsset.getTotal()).multiply(bigDecimal);
            BigDecimal multiply2 = m.a(defiBoxAsset.getWallet()).multiply(bigDecimal);
            defiBoxAsset.setTotalInBTC(multiply.toPlainString());
            defiBoxAsset.setWalletInBTC(multiply2.toPlainString());
        }
        onChainDataTotal.setDefiBoxAsset(defiBoxAsset);
        return onChainDataTotal;
    }

    public final UserAddrInfo f(List<UserAddrInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        UserAddrInfo d11 = s.d();
        if (d11 == null) {
            return list.get(0);
        }
        for (UserAddrInfo equals : list) {
            if (d11.equals(equals)) {
                return d11;
            }
        }
        return list.get(0);
    }
}
