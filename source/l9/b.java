package l9;

import android.content.Context;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.KLineListener;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.listener.MarketDepthPercentListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.listener.MarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.listener.RequestMarketTradeDetailListener;
import com.hbg.lib.network.swap.core.bean.LeverRate;
import com.hbg.lib.network.swap.core.bean.OrderInsertRspInfo;
import com.hbg.lib.network.swap.core.bean.PriceLimitInfo;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapActivityInfo;
import com.hbg.lib.network.swap.core.bean.SwapAllowLevel;
import com.hbg.lib.network.swap.core.bean.SwapAvailableLevelInfo;
import com.hbg.lib.network.swap.core.bean.SwapCancelResult;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrentTrackOrderResult;
import com.hbg.lib.network.swap.core.bean.SwapFundingRate;
import com.hbg.lib.network.swap.core.bean.SwapHiddenInstruments;
import com.hbg.lib.network.swap.core.bean.SwapLightLimitLevel;
import com.hbg.lib.network.swap.core.bean.SwapOpenInterestInfo;
import com.hbg.lib.network.swap.core.bean.SwapOpenRight;
import com.hbg.lib.network.swap.core.bean.SwapOrderResult;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.bean.SwapPriceInfo;
import com.hbg.lib.network.swap.core.bean.SwapSettlementPriceInfo;
import com.hbg.lib.network.swap.core.bean.SwapTpSlOrderRspInfo;
import com.hbg.lib.network.swap.core.bean.SwapTpSlRelationOrder;
import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserOrderLimit;
import com.hbg.lib.network.swap.core.util.SwapDepthType;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.contract.entity.OffSiteLimit;
import d9.a;
import g9.a;
import java.util.HashMap;
import java.util.List;

public interface b {
    a<SwapOrderResult<SwapTriggerOrderInfo>> A(int i11, int i12, String str);

    a<OrderInsertRspInfo> B(String str, String str2, String str3, String str4, int i11);

    a<SwapCurrentTrackOrderResult> C(String str, int i11, int i12, String str2);

    a<OrderInsertRspInfo> D(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double d11);

    a<OrderInsertRspInfo> E(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void F(boolean z11, String str, SwapDepthType swapDepthType, MarketDepthListener marketDepthListener);

    a<SwapOrderResult<SwapCurrentOrderInfo>> G(int i11, int i12, String str, String str2);

    a<SwapCancelResult> H(String str, String str2);

    void I(boolean z11, String str, SwapDepthType swapDepthType, MarketDepthPercentListener marketDepthPercentListener);

    a<OffSiteLimit> J(String str, String str2, String str3, String str4, String str5, String str6);

    a<LeverRate> K(String str, String str2);

    a<List<SwapAccountInfo>> L(String str);

    a<SwapOrderResult<SwapTriggerOrderInfo>> M(int i11, int i12, String str);

    a<List<SwapSettlementPriceInfo>> N(String str);

    a<List<SwapPosition>> O(String str);

    a<OrderInsertRspInfo> P(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    a<List<SwapCurrencyInfo>> Q(String str);

    void a(String str, Context context, c9.b bVar);

    a<SwapActivityInfo> activityInfo(String str);

    a<Object> agreeHighLever();

    void b();

    void c(a.d dVar);

    void d(a.d dVar);

    void e(boolean z11, MarketOverviewListener marketOverviewListener);

    void f(String str, Period period, long j11, long j12, KLineListener kLineListener);

    void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener);

    d9.a<List<SwapAvailableLevelInfo>> getAllowLevel(String str);

    d9.a<List<SwapAllowLevel>> getAllowMaxLevel(String str);

    d9.a<SwapFundingRate> getFunddingRate(String str);

    d9.a<SwapHiddenInstruments> getHiddenInstruments();

    d9.a<List<SwapLightLimitLevel>> getLightLimitLevel(String str);

    d9.a<String> getMarketPriceInfo(String str);

    d9.a<List<SwapPriceInfo>> getPriceInfo(String str);

    d9.a<List<PriceLimitInfo>> getPriceLimitLevel(String str);

    d9.a<ContractOpenCountInfo> getSwapOpenCountInfo();

    d9.a<List<SwapOpenInterestInfo>> getSwapOpenInterest(String str);

    d9.a<SwapUserInfo.UserBean> getUserInfo();

    void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener);

    void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11);

    void j(boolean z11, String str, MarketDetailListener marketDetailListener);

    void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener);

    void l(boolean z11, String str, String str2, MarketDepthListener marketDepthListener);

    d9.a<SwapOpenRight> m(String str);

    d9.a<Object> n(String str);

    d9.a<Boolean> o(String str, String str2, String str3, String str4, String str5);

    d9.a<ContractCancelOrderResult> p(HashMap<String, Object> hashMap);

    d9.a<SwapCancelResult> q(String str, long j11);

    d9.a<Integer> queryTradeUnit();

    d9.a<SwapTpSlOrderRspInfo> r(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

    d9.a<List<LevelAvailableMarginInfo>> s(String str);

    d9.a<Object> swapCloseAllPosition();

    d9.a<SwapCancelResult> t(String str, String str2);

    d9.a<ContractTriggerProtectInfo> triggerProtect(String str);

    d9.a<ReversalEstimatedLiquidationPrice> u(String str, String str2);

    d9.a<List<ProductInfo>> v();

    d9.a<SwapTpSlRelationOrder> w(String str, String str2);

    d9.a<OrderInsertRspInfo> x(String str, String str2);

    d9.a<SwapCancelResult> y(String str, String str2);

    d9.a<List<SwapUserOrderLimit>> z(String str);
}
