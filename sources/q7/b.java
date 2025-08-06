package q7;

import android.content.Context;
import com.hbg.lib.network.contract.core.bean.CenterMarketConfigContracts;
import com.hbg.lib.network.contract.core.bean.CenterMarketConfigInfo;
import com.hbg.lib.network.contract.core.bean.ContractAllowLevel;
import com.hbg.lib.network.contract.core.bean.ContractAvailableLevelInfo;
import com.hbg.lib.network.contract.core.bean.ContractClearDialogConfig;
import com.hbg.lib.network.contract.core.bean.ContractHiddenInstruments;
import com.hbg.lib.network.contract.core.bean.ContractHoldAmount;
import com.hbg.lib.network.contract.core.bean.ContractOpenRight;
import com.hbg.lib.network.contract.core.bean.ContractOrderInsertRspInfo;
import com.hbg.lib.network.contract.core.bean.ContractSettlementPrice;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.hbg.lib.network.contract.core.bean.ContractTpSlOrderRspInfo;
import com.hbg.lib.network.contract.core.bean.ContractUserOrderLimit;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.PopupSetInfo;
import com.hbg.lib.network.contract.core.bean.PriceLimitInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.contract.core.bean.StopOrderRspResult;
import com.hbg.lib.network.contract.core.util.ContractDepthType;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.contract.core.util.RemindTriggerType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthPercentListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.listener.MarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.listener.RequestMarketTradeDetailListener;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractCancelResult;
import com.huobi.contract.entity.ContractCurrentTrackOrderResult;
import com.huobi.contract.entity.ContractPriceProtectionInfo;
import com.huobi.contract.entity.ContractTpSlRelationOrder;
import com.huobi.contract.entity.ContractUserInfoActive;
import com.huobi.contract.entity.OffSiteLimit;
import d9.a;
import g9.a;
import java.util.HashMap;
import java.util.List;

public interface b {
    a<ContractCancelResult> A(String str, String str2);

    void B(boolean z11, String str, ContractDepthType contractDepthType, MarketDepthListener marketDepthListener);

    void C(boolean z11, String str, ContractDepthType contractDepthType, MarketDepthPercentListener marketDepthPercentListener);

    a<Void> D(int i11);

    a<OffSiteLimit> E(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    a<ContractOrderInsertRspInfo> F(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10);

    a<ContractCurrentTrackOrderResult> G(String str, String str2, int i11, int i12, String str3);

    a<Integer> H(String str, RemindContractType remindContractType);

    a<ContractOrderInsertRspInfo> I(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i11, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, double d11);

    a<List<ContractHoldAmount>> J(String str);

    a<Integer> K(RemindBusinessType remindBusinessType, String str, RemindContractType remindContractType, RemindTriggerType remindTriggerType, String str2);

    a<List<Integer>> L(List<Long> list);

    a<Void> M(long j11, long j12);

    a<ContractTpSlOrderRspInfo> N(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13);

    a<List<CenterMarketConfigInfo>> O(String str, RemindContractType remindContractType);

    a<StopOrderRspResult> P(String str, String str2, int i11, int i12, String str3);

    a<List<ContractSettlementPrice>> Q(String str);

    void a(String str, Context context, c9.b bVar);

    a<Object> agreeHighLever();

    void b();

    void c(a.d dVar);

    d9.a<Object> contractCloseAllPosition();

    void d(a.d dVar);

    void e(boolean z11, MarketOverviewListener marketOverviewListener);

    void f(String str, Period period, long j11, long j12, KLineListener kLineListener);

    d9.a<ContractUserInfoActive> fetchUserInfoActive();

    void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener);

    d9.a<List<ContractAvailableLevelInfo>> getAllowLevel(String str);

    d9.a<List<ContractAllowLevel>> getAllowMaxLevel(String str);

    d9.a<ContractClearDialogConfig> getClearDialogConfig();

    d9.a<ContractPriceProtectionInfo> getContractPriceProtection();

    d9.a<ContractTagInfo> getContractTagInfo();

    d9.a<ContractCalmPeriodInfo> getCoolingOffPeriodInfo();

    d9.a<ContractHiddenInstruments> getHiddenInstruments();

    d9.a<List<PriceLimitInfo>> getPriceLimitLevel(String str);

    void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener);

    void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11);

    void j(boolean z11, String str, MarketDetailListener marketDetailListener);

    void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener);

    void l(boolean z11, String str, String str2, MarketDepthListener marketDepthListener);

    d9.a<ContractOpenRight> m(String str);

    d9.a<Object> n(String str);

    d9.a<Boolean> o(String str, String str2, String str3, String str4, String str5);

    d9.a<ContractCancelOrderResult> p(HashMap<String, Object> hashMap);

    d9.a<ContractCancelResult> q(String str, long j11);

    d9.a<Integer> queryTradeUnit();

    d9.a<CenterMarketConfigContracts> r();

    d9.a<List<LevelAvailableMarginInfo>> s(String str);

    d9.a<Object> t(String str, String str2, String str3, String str4, String str5, String str6, int i11);

    d9.a<ReversalEstimatedLiquidationPrice> u(String str, String str2);

    d9.a<PopupSetInfo> v(String str);

    d9.a<ContractTpSlRelationOrder> w(String str, String str2);

    d9.a<ContractOrderInsertRspInfo> x(String str, String str2);

    d9.a<ContractOrderInsertRspInfo> y(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

    d9.a<List<ContractUserOrderLimit>> z(String str);
}
