package h8;

import android.content.Context;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearOrderInsertRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAvailableLevelInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCancelAllResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCrossAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapExperienceFundQueryResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapFinancialRecord;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapFundingRate;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapHiddenInstruments;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLeverRate;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLightLimitLevel;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOpenInterestInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOpenRight;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderInsertRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderTimeSharingRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPositionModeSwitchRespInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPriceLimitInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapSettlementPriceInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeOrderResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeSharingGlobalConfig;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTpSlOrderRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTpSlRelationOrder;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTrackOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserOrderLimit;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapWhiteList;
import com.hbg.lib.network.linear.swap.core.bean.UnionModeData;
import com.hbg.lib.network.linear.swap.core.bean.UnionModeWhiteListInfo;
import com.hbg.lib.network.linear.swap.core.bean.UnionSupportCurrency;
import com.hbg.lib.network.linear.swap.core.util.LinearSwapDepthType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthPercentListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.listener.MarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.listener.RequestMarketTradeDetailListener;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractPositionLimit;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.contract.entity.OffSiteLimit;
import com.huobi.contract.entity.PositionSlippageInfo;
import d9.a;
import g9.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface b {
    a<LinearSwapOrderResult<LinearSwapTrackOrderInfo>> A(String str, int i11, int i12, int i13, String str2);

    void A0(boolean z11, String str, LinearSwapDepthType linearSwapDepthType, MarketDepthPercentListener marketDepthPercentListener);

    a<LinearSwapOrderInsertRspInfo> B(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z11, boolean z12);

    a<ReversalEstimatedLiquidationPrice> C(String str, String str2, String str3);

    a<LinearSwapLeverRate> D(String str, String str2);

    a<List<LevelAvailableMarginInfo>> E(String str, String str2);

    a<LinearSwapPositionModeSwitchRespInfo> F(String str, boolean z11);

    a<LinearSwapOrderInsertRspInfo> G(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double d11, boolean z11, boolean z12, int i12, String str16);

    a<UnionModeData> H();

    a<LinearSwapLeverRate> I(String str, String str2, String str3, boolean z11);

    a<List<LinearSwapCrossAccountInfo>> J(String str, String str2);

    a<LinearSwapOrderResult<LinearSwapCurrentOrderInfo>> K(int i11, int i12, String str, String str2, String str3, String str4);

    a<LinearSwapTimeOrderResult<LinearSwapTimeOrderInfo>> L(String str, int i11, int i12);

    a<Object> M(String str, String str2, String str3, String str4);

    a<ReversalEstimatedLiquidationPrice> N(String str, String str2, String str3);

    a<LinearSwapCancelAllResult> O(String str, String str2, String str3, long j11);

    a<String> P(String str, String str2, int i11, String str3, String str4, String str5);

    a<Object> Q(boolean z11);

    a<LinearOrderInsertRspInfo> R(String str, String str2, String str3, String str4, int i11, int i12, boolean z11, String str5);

    a<LinearSwapCancelAllResult> S(String str, String str2);

    a<LinearSwapTpSlRelationOrder> T(boolean z11, String str, String str2);

    a<LinearSwapBondAdjustResult> U(String str, int i11, String str2, String str3, boolean z11, String str4);

    a<LinearSwapOrderInsertRspInfo> V(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double d11, boolean z11, boolean z12, int i12, String str16);

    a<Boolean> W(String str, String str2, String str3, String str4, String str5);

    a<LinearSwapCancelAllResult> X(String str, String str2);

    a<LinearSwapCancelAllResult> Y(String str, long j11);

    a<LinearOrderInsertRspInfo> Z(String str, String str2, String str3, String str4, int i11, int i12, boolean z11, String str5);

    void a(String str, Context context, c9.b bVar);

    a<LinearOrderInsertRspInfo> a0(String str, String str2, String str3);

    a<Void> adjustPositionLimit();

    a<Object> agreeHighLever();

    void b();

    a<List<LinearSwapUserOrderLimit>> b0(String str, String str2);

    void c(a.d dVar);

    d9.a<LinearOrderInsertRspInfo> c0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z11, boolean z12);

    void d(a.d dVar);

    d9.a<LinearOrderInsertRspInfo> d0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z11, boolean z12);

    void e(boolean z11, MarketOverviewListener marketOverviewListener);

    void e0(boolean z11, String str, LinearSwapDepthType linearSwapDepthType, MarketDepthListener marketDepthListener);

    void f(String str, Period period, long j11, long j12, KLineListener kLineListener);

    d9.a<UnionSupportCurrency> f0();

    void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener);

    d9.a<List<LinearSwapContractInfo>> g0(String str, String str2, String str3);

    d9.a<List<LinearSwapAvailableLevelInfo>> getAllowLevel(String str, String str2);

    d9.a<List<LinearSwapContactConfigInfo>> getContractConfigInfo();

    d9.a<List<LinearSwapAvailableLevelInfo>> getCrossAllowLevel(String str, String str2);

    d9.a<LinearSwapExperienceFundQueryResult> getExperienceFundQuery();

    d9.a<LinearSwapFundingRate> getFundingRate(String str, String str2);

    d9.a<LinearSwapHiddenInstruments> getHiddenInstruments();

    d9.a<List<LinearSwapLightLimitLevel>> getLightLimitLevel(String str);

    d9.a<ContractOpenCountInfo> getLinearSwapOpenCountInfo();

    d9.a<String> getPriceInfo(String str);

    d9.a<List<LinearSwapPriceLimitInfo>> getPriceLimitLevel(String str, String str2, String str3);

    d9.a<List<LinearSwapOpenInterestInfo>> getSwapOpenInterest(String str, String str2, String str3);

    d9.a<LinearSwapTimeSharingGlobalConfig> getTimeSharingGlobalConfigInfo();

    d9.a<LinearSwapUserInfo> getUserInfo();

    d9.a<ContractPositionLimit> getUserPositionLimitList();

    void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener);

    d9.a<LinearSwapOrderTimeSharingRspInfo> h0(String str, String str2, String str3, String str4, String str5, int i11, double d11, int i12, double d12, int i13, int i14, int i15);

    void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11);

    d9.a<LinearSwapFinancialRecord> i0(String str, int i11, int i12, int i13);

    void j(boolean z11, String str, MarketDetailListener marketDetailListener);

    d9.a<PositionSlippageInfo> j0(String str, String str2, String str3);

    void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener);

    d9.a<LinearSwapPositionModeSwitchRespInfo> k0(String str, String str2);

    void l(boolean z11, String str, String str2, MarketDepthListener marketDepthListener);

    d9.a<OffSiteLimit> l0(String str, String str2, String str3, String str4, String str5, int i11, String str6, String str7);

    d9.a<Object> linearCloseAllPosition();

    d9.a<LinearSwapOpenRight> m(String str);

    d9.a<LinearSwapOrderResult<LinearSwapTriggerOrderInfo>> m0(int i11, int i12, String str, String str2, int i13);

    d9.a<Object> n(String str);

    d9.a<List<LinearSwapPosition>> n0(String str, String str2, String str3);

    d9.a<Boolean> o(String str, String str2, String str3, String str4, String str5);

    d9.a<LinearSwapOrderInsertRspInfo> o0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z11, boolean z12);

    d9.a<ContractCancelOrderResult> p(HashMap<String, Object> hashMap);

    d9.a<LinearSwapPositionModeSwitchRespInfo> p0(String str, boolean z11);

    d9.a<LinearSwapCancelAllResult> q(String str, long j11);

    d9.a<LinearSwapCancelAllResult> q0(String str, long j11);

    d9.a<AccountBalanceInfoV5> queryAccountBalance();

    d9.a<LinearSwapPositionModeSwitchRespInfo> queryPositionModeWhenUnitDeposit();

    d9.a<Integer> queryTradeUnit();

    d9.a<UnionModeWhiteListInfo> queryUnionWhiteList();

    d9.a<List<LinearSwapWhiteList>> queryUserIshit(Map<String, String> map);

    d9.a<LinearSwapTpSlOrderRspInfo> r(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

    d9.a<LinearSwapBondAdjustDetail> r0(String str, String str2, String str3, boolean z11, String str4, String str5);

    d9.a<LinearSwapTpSlOrderRspInfo> s0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

    d9.a<LinearSwapCancelAllResult> t(String str, String str2);

    d9.a<List<LevelAvailableMarginInfo>> t0(String str, String str2);

    d9.a<ContractTriggerProtectInfo> triggerProtect(String str);

    d9.a<LinearOrderInsertRspInfo> u0(String str, String str2, String str3);

    d9.a<List<LinearSwapProductInfo>> v();

    d9.a<List<LinearSwapSettlementPriceInfo>> v0(String str, String str2, String str3);

    d9.a<LinearSwapLeverRate> w0(String str, String str2, String str3, boolean z11);

    d9.a<List<LinearSwapProductInfo>> x0();

    d9.a<LinearSwapCancelAllResult> y(String str, String str2);

    d9.a<LinearSwapOrderResult<LinearSwapTriggerOrderInfo>> y0(int i11, int i12, String str, String str2, int i13);

    d9.a<List<LinearSwapAccountInfo>> z(String str, String str2);

    d9.a<LinearSwapCancelAllResult> z0(String str, String str2);
}
