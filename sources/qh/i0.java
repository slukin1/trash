package qh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.ProfitUserInfo;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.asset2.index.util.b;
import i6.k;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;

public final class i0 {

    /* renamed from: c  reason: collision with root package name */
    public static final i0 f47741c = new i0();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, BalanceProfitLossData> f47742a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Boolean> f47743b = new HashMap();

    public static i0 d() {
        return f47741c;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BalanceProfitLossData i(BalanceProfitLossData balanceProfitLossData) {
        this.f47742a.put(g(), balanceProfitLossData);
        if (balanceProfitLossData != null) {
            b.a().f(balanceProfitLossData.getSpotRiskLevel(), balanceProfitLossData.getAccountState());
            k.n("BalanceProfitAndLossHelper setSpotAccountState RiskLevel = " + balanceProfitLossData.getSpotRiskLevel() + ", AccountState = " + balanceProfitLossData.getAccountState());
        }
        return balanceProfitLossData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean j(ProfitUserInfo profitUserInfo) {
        boolean isActive = profitUserInfo.isActive();
        this.f47743b.put(g(), Boolean.valueOf(isActive));
        AssetModuleConfig.a().E0(Boolean.valueOf(isActive));
        return Boolean.valueOf(isActive);
    }

    public BalanceProfitLossData c() {
        return this.f47742a.get(g());
    }

    public Observable<BalanceProfitLossData> e() {
        return v7.b.a().getBalanceProfitLoss().b().map(new g0(this));
    }

    public Observable<Boolean> f() {
        Boolean F = AssetModuleConfig.a().F();
        if (F == null || !F.booleanValue()) {
            return v7.b.a().getProfitUserInfo().b().map(new h0(this));
        }
        return Observable.just(Boolean.TRUE);
    }

    public final String g() {
        return AssetModuleConfig.a().getUid();
    }

    public boolean h() {
        Boolean bool = this.f47743b.get(AssetModuleConfig.a().getUid());
        return bool != null && bool.booleanValue();
    }
}
