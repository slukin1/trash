package com.hbg.lib.network.linear.swap.retrofit;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
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
import com.hbg.lib.network.pro.socket.request.KlineRequest;
import com.hbg.lib.network.pro.socket.request.TradeDetailRequest;
import com.hbg.lib.network.pro.socket.subscribe.LastKlineSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketDepthSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketDetailSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketInfoDepthPercentSub;
import com.hbg.lib.network.pro.socket.subscribe.MarketOverviewSub;
import com.hbg.lib.network.pro.socket.subscribe.TradeDetailSub;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractPositionLimit;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.contract.entity.OffSiteLimit;
import com.huobi.contract.entity.PositionSlippageInfo;
import com.tencent.android.tpush.common.Constants;
import d9.a;
import g9.a;
import g9.i;
import h8.b;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LinearSwapRetrofitImpl implements b {

    /* renamed from: a  reason: collision with root package name */
    public i f70345a;

    /* renamed from: b  reason: collision with root package name */
    public c9.b f70346b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f70347c = new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss", Locale.US);

    /* renamed from: d  reason: collision with root package name */
    public String f70348d;

    public a<LinearSwapOrderResult<LinearSwapTrackOrderInfo>> A(String str, int i11, int i12, int i13, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("page_index", Integer.valueOf(i11));
        hashMap.put("page_size", Integer.valueOf(i12));
        hashMap.put("trade_type", Integer.valueOf(i13));
        hashMap.put("trade_partition", str2);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getAllOpenTrackOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void A0(boolean z11, String str, LinearSwapDepthType linearSwapDepthType, MarketDepthPercentListener marketDepthPercentListener) {
        RetrofitLogger.a(this.f70348d + "-->subscribeMarketDepthPercent--> isSubscribe=" + z11 + " symbol=" + str + " type=" + linearSwapDepthType + " listener=" + marketDepthPercentListener);
        if (z11 && !w()) {
            s();
        }
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.u(new MarketInfoDepthPercentSub(z11, str, linearSwapDepthType.step), marketDepthPercentListener);
        }
    }

    public a<LinearSwapOrderInsertRspInfo> B(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z11, boolean z12) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("trigger_type", str2);
        hashMap.put("trigger_price", str3);
        hashMap.put("order_price", str4);
        hashMap.put("order_price_type", str5);
        hashMap.put("volume", str6);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str7);
        if (z11) {
            hashMap.put(Constants.FLAG_TAG_OFFSET, LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE);
        } else {
            hashMap.put(Constants.FLAG_TAG_OFFSET, str8);
        }
        hashMap.put("lever_rate", str9);
        if (z12) {
            hashMap.put("reduce_only", 1);
        }
        try {
            RetrofitLogger.g("正向永续计划委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).triggerOrderInsert(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public final a<LinearSwapOrderInsertRspInfo> B0(String str, String str2, String str3, String str4, String str5, String str6, boolean z11, int i11, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, double d11, boolean z12, boolean z13, String str15) {
        String str16 = str3;
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        String str20 = str15;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("margin_mode", z11 ? FutureContractInfo.MARGIN_CROSS : FutureContractInfo.MARGIN_ISOLATED);
        hashMap.put(FirebaseAnalytics.Param.PRICE, str2);
        hashMap.put("volume", str17);
        hashMap.put("side", str18);
        if (str20 != null && !str15.isEmpty()) {
            hashMap.put("position_side", str20);
        } else if (z12) {
            hashMap.put("position_side", LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE);
        } else {
            String str21 = "long";
            if ("sell".equals(str18)) {
                if (str19.equals("open")) {
                    str21 = "short";
                }
                hashMap.put("position_side", str21);
            } else {
                if (!str19.equals("open")) {
                    str21 = "short";
                }
                hashMap.put("position_side", str21);
            }
        }
        str3.hashCode();
        char c11 = 65535;
        switch (str3.hashCode()) {
            case -1081306052:
                if (str16.equals(PrimeRounds.ROUND_TRADE_MARKET_TYPE)) {
                    c11 = 0;
                    break;
                }
                break;
            case -757447681:
                if (str16.equals("optimal_10_fok")) {
                    c11 = 1;
                    break;
                }
                break;
            case -757444806:
                if (str16.equals("optimal_10_ioc")) {
                    c11 = 2;
                    break;
                }
                break;
            case -728818530:
                if (str16.equals("optimal_20_fok")) {
                    c11 = 3;
                    break;
                }
                break;
            case -728815655:
                if (str16.equals("optimal_20_ioc")) {
                    c11 = 4;
                    break;
                }
                break;
            case -434974533:
                if (str16.equals("optimal_5_fok")) {
                    c11 = 5;
                    break;
                }
                break;
            case -434971658:
                if (str16.equals("optimal_5_ioc")) {
                    c11 = 6;
                    break;
                }
                break;
            case -407001376:
                if (str16.equals("opponent_fok")) {
                    c11 = 7;
                    break;
                }
                break;
            case -406998501:
                if (str16.equals("opponent_ioc")) {
                    c11 = 8;
                    break;
                }
                break;
            case -188030627:
                if (str16.equals("opponent")) {
                    c11 = 9;
                    break;
                }
                break;
            case 101570:
                if (str16.equals("fok")) {
                    c11 = 10;
                    break;
                }
                break;
            case 104445:
                if (str16.equals("ioc")) {
                    c11 = 11;
                    break;
                }
                break;
            case 102976443:
                if (str16.equals("limit")) {
                    c11 = 12;
                    break;
                }
                break;
            case 1305011708:
                if (str16.equals("optimal_10")) {
                    c11 = 13;
                    break;
                }
                break;
            case 1305011739:
                if (str16.equals("optimal_20")) {
                    c11 = 14;
                    break;
                }
                break;
            case 1843212472:
                if (str16.equals("optimal_5")) {
                    c11 = 15;
                    break;
                }
                break;
            case 2002822123:
                if (str16.equals("post_only")) {
                    c11 = 16;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                hashMap.put("type", PrimeRounds.ROUND_TRADE_MARKET_TYPE);
                break;
            case 1:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_10");
                hashMap.put("time_in_force", "fok");
                break;
            case 2:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_10");
                hashMap.put("time_in_force", "ioc");
                break;
            case 3:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_20");
                hashMap.put("time_in_force", "fok");
                break;
            case 4:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_20");
                hashMap.put("time_in_force", "ioc");
                break;
            case 5:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_5");
                hashMap.put("time_in_force", "fok");
                break;
            case 6:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_5");
                hashMap.put("time_in_force", "ioc");
                break;
            case 7:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "opponent");
                hashMap.put("time_in_force", "fok");
                break;
            case 8:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "opponent");
                hashMap.put("time_in_force", "ioc");
                break;
            case 9:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "opponent");
                break;
            case 10:
                hashMap.put("type", "limit");
                hashMap.put("time_in_force", "fok");
                break;
            case 11:
                hashMap.put("type", "limit");
                hashMap.put("time_in_force", "ioc");
                break;
            case 12:
                hashMap.put("type", "limit");
                break;
            case 13:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_10");
                break;
            case 14:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_20");
                break;
            case 15:
                hashMap.put("type", "limit");
                hashMap.put("price_match", "optimal_5");
                break;
            case 16:
                hashMap.put("type", "post_only");
                break;
        }
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        if (z13) {
            hashMap.put("reduce_only", 1);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("tp_trigger_price", str7);
            hashMap.put("tp_order_price", str8);
            hashMap.put("tp_order_price_type", str9);
            if (!TextUtils.isEmpty(str10)) {
                hashMap.put("tp_trigger_type", str10);
            }
        }
        if (!TextUtils.isEmpty(str11)) {
            hashMap.put("sl_trigger_price", str11);
            hashMap.put("sl_order_price", str12);
            hashMap.put("sl_order_price_type", str13);
            if (!TextUtils.isEmpty(str14)) {
                hashMap.put("sl_trigger_type", str14);
            }
        }
        if (d11 > 0.0d) {
            BigDecimal scale = BigDecimal.valueOf(d11).multiply(new BigDecimal(str17)).setScale(0, 1);
            if (scale.compareTo(BigDecimal.ZERO) == 0) {
                scale = BigDecimal.ONE;
            }
            hashMap.put("tpsl_volume", scale.toPlainString());
        }
        try {
            RetrofitLogger.g("正向永续全仓限价委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestSwapOrderV5(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<ReversalEstimatedLiquidationPrice> C(String str, String str2, String str3) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        try {
            RetrofitLogger.g("正向永续全仓一键反手预估强评价:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (SPUtil.j()) {
            hashMap.put("margin_mode", FutureContractInfo.MARGIN_CROSS);
            hashMap.put("position_side", str3);
            return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).requestReversalEstimatedLiquidationPriceV5(hashMap).compose(LinearSwapRetrofit.o()));
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).requestReversalEstimatedLiquidationPriceCross(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapLeverRate> D(String str, String str2) {
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryLeverRateV5(str, str2).compose(LinearSwapRetrofit.o()));
    }

    public a<List<LevelAvailableMarginInfo>> E(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getCrossLevelAvailableMargin(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapPositionModeSwitchRespInfo> F(String str, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("margin_account", str);
        hashMap.put("position_mode", z11 ? "single_side" : "dual_side");
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).switchPositionModeWhenQuanCang(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapOrderInsertRspInfo> G(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double d11, boolean z11, boolean z12, int i12, String str16) {
        String str17 = str4;
        if (SPUtil.j()) {
            return B0(str, str2, str3, str4, str5, str6, false, i11, str8, str9, str10, str11, str12, str13, str14, str15, d11, z11, z12, str16);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(FirebaseAnalytics.Param.PRICE, str2);
        hashMap.put("order_price_type", str3);
        hashMap.put("volume", str17);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str5);
        if (z11) {
            hashMap.put(Constants.FLAG_TAG_OFFSET, LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE);
        } else {
            hashMap.put(Constants.FLAG_TAG_OFFSET, str6);
        }
        hashMap.put("lever_rate", str7);
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("tp_trigger_price", str8);
            hashMap.put("tp_order_price", str9);
            hashMap.put("tp_order_price_type", str10);
            if (!TextUtils.isEmpty(str11)) {
                hashMap.put("tp_trigger_type", str11);
            }
        }
        if (!TextUtils.isEmpty(str12)) {
            hashMap.put("sl_trigger_price", str12);
            hashMap.put("sl_order_price", str13);
            hashMap.put("sl_order_price_type", str14);
            if (!TextUtils.isEmpty(str15)) {
                hashMap.put("sl_trigger_type", str15);
            }
        }
        if (d11 > 0.0d) {
            BigDecimal scale = BigDecimal.valueOf(d11).multiply(new BigDecimal(str17)).setScale(0, 1);
            if (scale.compareTo(BigDecimal.ZERO) == 0) {
                scale = BigDecimal.ONE;
            }
            hashMap.put("tpsl_volume", scale.toPlainString());
        }
        if (z12) {
            hashMap.put("reduce_only", 1);
        }
        hashMap.put("use_time_weighted", Integer.valueOf(i12));
        try {
            RetrofitLogger.g("正向永续限价委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestSwapOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<UnionModeData> H() {
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryAssetMode().compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapLeverRate> I(String str, String str2, String str3, boolean z11) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("lever_rate", str2);
        if (!SPUtil.j()) {
            return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).checkCrossLeverRate(hashMap).compose(LinearSwapRetrofit.o()));
        }
        hashMap.put("margin_mode", str3);
        hashMap.put("position_side", z11 ? "BOTH" : "LONG");
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).updateLeverRateV5(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<List<LinearSwapCrossAccountInfo>> J(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_type", TtmlNode.COMBINE_ALL);
        hashMap.put("margin_account", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getCrossAccountInfo(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapOrderResult<LinearSwapCurrentOrderInfo>> K(int i11, int i12, String str, String str2, String str3, String str4) {
        if (SPUtil.j()) {
            return u(i11, i12, str);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("page_size", Integer.valueOf(i12));
        hashMap.put("order_type", str4);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        hashMap.put("business_type", str3);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getAllCurrentOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapTimeOrderResult<LinearSwapTimeOrderInfo>> L(String str, int i11, int i12) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("page_index", Integer.valueOf(i11));
        hashMap.put("page_size", Integer.valueOf(i12));
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getCurrentTimeOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<Object> M(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("asset", str);
        hashMap.put("from_margin_account", str2);
        hashMap.put("to_margin_account", str3);
        hashMap.put("amount", str4);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).transferInner(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<ReversalEstimatedLiquidationPrice> N(String str, String str2, String str3) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        try {
            RetrofitLogger.g("正向永续逐仓一键反手预估强评价:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (SPUtil.j()) {
            hashMap.put("margin_mode", FutureContractInfo.MARGIN_ISOLATED);
            hashMap.put("position_side", str3);
            return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).requestReversalEstimatedLiquidationPriceV5(hashMap).compose(LinearSwapRetrofit.o()));
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).requestReversalEstimatedLiquidationPrice(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapCancelAllResult> O(String str, String str2, String str3, long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("contract_type", str2);
        hashMap.put("pair", str3);
        hashMap.put("order_id", Long.valueOf(j11));
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).cancelCrossTrackOpenOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<String> P(String str, String str2, int i11, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("product_id", str);
        hashMap.put("contract_code", str2);
        hashMap.put("margin_mode", Integer.valueOf(i11));
        hashMap.put("contract_type", str3);
        hashMap.put("business_type", str4);
        hashMap.put("pair", str5);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getGridOrderExists(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<Object> Q(boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("assets_mode", z11 ? "1" : "0");
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).switchAssetMode(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearOrderInsertRspInfo> R(String str, String str2, String str3, String str4, int i11, int i12, boolean z11, String str5) {
        if (i12 != 1 && SPUtil.j()) {
            return x(str, str5, z11);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str2);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str3);
        hashMap.put("order_price_type", str4);
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        hashMap.put("after_cancel_order", 1);
        hashMap.put("use_time_weighted", Integer.valueOf(i12));
        try {
            RetrofitLogger.g("正向永续全仓闪电委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestSwapCrossLightClose(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapCancelAllResult> S(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).contractCrossStopCancel(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapTpSlRelationOrder> T(boolean z11, String str, String str2) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        if (z11) {
            return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).getCrossTpSlRelationOrder(hashMap).compose(LinearSwapRetrofit.o()));
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).getTpSlRelationOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapBondAdjustResult> U(String str, int i11, String str2, String str3, boolean z11, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("asset", str);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, Integer.valueOf(i11));
        hashMap.put("fromMarginAccount", str2);
        hashMap.put("toMarginAccount", str3);
        if (z11) {
            hashMap.put("outInType", 1);
        } else {
            hashMap.put("outInType", 0);
        }
        hashMap.put("amount", str4);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).adjustBond(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapOrderInsertRspInfo> V(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, double d11, boolean z11, boolean z12, int i12, String str16) {
        String str17 = str4;
        if (SPUtil.j()) {
            return B0(str, str2, str3, str4, str5, str6, true, i11, str8, str9, str10, str11, str12, str13, str14, str15, d11, z11, z12, str16);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(FirebaseAnalytics.Param.PRICE, str2);
        hashMap.put("order_price_type", str3);
        hashMap.put("volume", str17);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str5);
        if (z11) {
            hashMap.put(Constants.FLAG_TAG_OFFSET, LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE);
        } else {
            hashMap.put(Constants.FLAG_TAG_OFFSET, str6);
        }
        hashMap.put("lever_rate", str7);
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        if (z12) {
            hashMap.put("reduce_only", 1);
        }
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("tp_trigger_price", str8);
            hashMap.put("tp_order_price", str9);
            hashMap.put("tp_order_price_type", str10);
            if (!TextUtils.isEmpty(str11)) {
                hashMap.put("tp_trigger_type", str11);
            }
        }
        if (!TextUtils.isEmpty(str12)) {
            hashMap.put("sl_trigger_price", str12);
            hashMap.put("sl_order_price", str13);
            hashMap.put("sl_order_price_type", str14);
            if (!TextUtils.isEmpty(str15)) {
                hashMap.put("sl_trigger_type", str15);
            }
        }
        if (d11 > 0.0d) {
            BigDecimal scale = BigDecimal.valueOf(d11).multiply(new BigDecimal(str17)).setScale(0, 1);
            if (scale.compareTo(BigDecimal.ZERO) == 0) {
                scale = BigDecimal.ONE;
            }
            hashMap.put("tpsl_volume", scale.toPlainString());
        }
        hashMap.put("use_time_weighted", Integer.valueOf(i12));
        try {
            RetrofitLogger.g("正向永续全仓限价委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestSwapCrossOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<Boolean> W(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("tp_trigger_price", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("sl_trigger_price", str5);
        }
        try {
            RetrofitLogger.h("查询止盈止损下单冻结状态——全仓", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestCurrentCrossTpslFrozenState(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapCancelAllResult> X(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).contractCrossTriggerCancel(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearSwapCancelAllResult> Y(String str, long j11) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", Long.valueOf(j11));
        if (SPUtil.j()) {
            return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).orderCancelV5(hashMap).compose(LinearSwapRetrofit.o()));
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).crossOrderCancel(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<LinearOrderInsertRspInfo> Z(String str, String str2, String str3, String str4, int i11, int i12, boolean z11, String str5) {
        if (i12 != 1 && SPUtil.j()) {
            return x(str, str5, z11);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str2);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str3);
        hashMap.put("order_price_type", str4);
        hashMap.put("check_min_volume", Integer.valueOf(i11));
        hashMap.put("after_cancel_order", 1);
        hashMap.put("use_time_weighted", Integer.valueOf(i12));
        try {
            RetrofitLogger.g("正向永续闪电委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestSwapLightClose(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void a(String str, Context context, c9.b bVar) {
        this.f70348d = str;
        RetrofitLogger.a(this.f70348d + "-->init");
        this.f70346b = bVar;
        LinearSwapRetrofit.g().init(str, context, bVar);
    }

    public a<LinearOrderInsertRspInfo> a0(String str, String str2, String str3) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        try {
            RetrofitLogger.g("正向永续一键反手:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (SPUtil.j()) {
            hashMap.put("margin_mode", FutureContractInfo.MARGIN_ISOLATED);
            hashMap.put("position_side", str3);
            return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).requestReversalV5(hashMap).compose(LinearSwapRetrofit.o()));
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).requestReversal(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public a<Void> adjustPositionLimit() {
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).adjustPositionLimit().compose(LinearSwapRetrofit.o()));
    }

    public a<Object> agreeHighLever() {
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).agreeHighLever().compose(LinearSwapRetrofit.o()));
    }

    public void b() {
        RetrofitLogger.a(this.f70348d + "-->disconnectWebSocket");
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.n();
        }
    }

    public a<List<LinearSwapUserOrderLimit>> b0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("trade_partition", str2);
        return new a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getUserOrderLimit(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void c(a.d dVar) {
        RetrofitLogger.a(this.f70348d + "-->removeReconnectListener-->" + dVar);
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.r(dVar);
        }
    }

    public d9.a<LinearOrderInsertRspInfo> c0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z11, boolean z12) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        if (z11) {
            hashMap.put(Constants.FLAG_TAG_OFFSET, LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE);
        } else {
            hashMap.put(Constants.FLAG_TAG_OFFSET, str3);
        }
        hashMap.put("lever_rate", str4);
        hashMap.put("volume", str5);
        hashMap.put("callback_rate", str6);
        hashMap.put("active_price", str7);
        hashMap.put("order_price_type", str8);
        if (z12) {
            hashMap.put("reduce_only", 1);
        }
        try {
            RetrofitLogger.h("正向永续跟踪委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).trackOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void d(a.d dVar) {
        RetrofitLogger.a(this.f70348d + "-->addReconnectListener-->" + dVar);
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.h(dVar);
        }
    }

    public d9.a<LinearOrderInsertRspInfo> d0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z11, boolean z12) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_type", str);
        hashMap.put("contract_code", str2);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str4);
        hashMap.put("pair", str3);
        if (z11) {
            hashMap.put(Constants.FLAG_TAG_OFFSET, LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE);
        } else {
            hashMap.put(Constants.FLAG_TAG_OFFSET, str5);
        }
        hashMap.put("lever_rate", str6);
        hashMap.put("volume", str7);
        hashMap.put("callback_rate", str8);
        hashMap.put("active_price", str9);
        hashMap.put("order_price_type", str10);
        if (z12) {
            hashMap.put("reduce_only", 1);
        }
        try {
            RetrofitLogger.h("正向永续全仓跟踪委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).crossTrackOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void e(boolean z11, MarketOverviewListener marketOverviewListener) {
        RetrofitLogger.a(this.f70348d + "-->subscribeMarketOverview--> isSubscribe=" + z11 + " listener=" + marketOverviewListener);
        if (z11 && !w()) {
            s();
        }
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.u(new MarketOverviewSub(z11), marketOverviewListener);
        }
    }

    public void e0(boolean z11, String str, LinearSwapDepthType linearSwapDepthType, MarketDepthListener marketDepthListener) {
        l(z11, str, linearSwapDepthType.step, marketDepthListener);
    }

    public void f(String str, Period period, long j11, long j12, KLineListener kLineListener) {
        Period period2 = period;
        long j13 = j11;
        long j14 = j12;
        RetrofitLogger.a(this.f70348d + "-->requestKLineList--> symbol=" + str + " period=" + period2 + " from=" + j13 + "(*1000=" + this.f70347c.format(new Date(j13 * 1000)) + ") to=" + j14 + "(*1000=" + this.f70347c.format(new Date(j14 * 1000)) + ")");
        if (!w()) {
            s();
        }
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.u(new KlineRequest(str, period2.value, j11, j12), kLineListener);
        }
    }

    public d9.a<UnionSupportCurrency> f0() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryUnionModeSupportCurrency().compose(LinearSwapRetrofit.o()));
    }

    public void g(boolean z11, String str, Period period, LastKlineListener lastKlineListener) {
        RetrofitLogger.a(this.f70348d + "-->subscribeLastKline--> isSubscribe=" + z11 + " symbol=" + str + " period=" + period + " listener=" + lastKlineListener);
        if (z11 && !w()) {
            s();
        }
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.u(new LastKlineSub(z11, str, period.value), lastKlineListener);
        }
    }

    public d9.a<List<LinearSwapContractInfo>> g0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("business_type", str3);
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getSwapCurrencyInfo(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapAvailableLevelInfo>> getAllowLevel(String str, String str2) {
        Class cls = LinearSwapService.class;
        if (SPUtil.j()) {
            return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).getAllowLevelV5(str, str2, FutureContractInfo.MARGIN_ISOLATED).compose(LinearSwapRetrofit.o()));
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).getAllowLevel(str, str2).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapContactConfigInfo>> getContractConfigInfo() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getContractConfigInfo().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapAvailableLevelInfo>> getCrossAllowLevel(String str, String str2) {
        Class cls = LinearSwapService.class;
        if (SPUtil.j()) {
            return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).getAllowLevelV5(str, str2, FutureContractInfo.MARGIN_CROSS).compose(LinearSwapRetrofit.o()));
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).getCrossAllowLevel(str, str2).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapExperienceFundQueryResult> getExperienceFundQuery() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getExperienceFundQuery().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapFundingRate> getFundingRate(String str, String str2) {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getFundingRate(str, str2).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapHiddenInstruments> getHiddenInstruments() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getHiddenInstruments().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapLightLimitLevel>> getLightLimitLevel(String str) {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getLightLimitLevel(str).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<ContractOpenCountInfo> getLinearSwapOpenCountInfo() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getLinearSwapOpenCountInfo().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<String> getPriceInfo(String str) {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getPriceInfo(str).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapPriceLimitInfo>> getPriceLimitLevel(String str, String str2, String str3) {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getPriceLimitLevel(str, str2, str3).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapOpenInterestInfo>> getSwapOpenInterest(String str, String str2, String str3) {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getSwapOpenInterest(str, str2, str3).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapTimeSharingGlobalConfig> getTimeSharingGlobalConfigInfo() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getTimeSharingGlobalConfigInfo().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapUserInfo> getUserInfo() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getUserInfo().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<ContractPositionLimit> getUserPositionLimitList() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getUserPositionLimitList().compose(LinearSwapRetrofit.o()));
    }

    public void h(boolean z11, String str, String str2, int i11, MarketDepthListener marketDepthListener) {
        RetrofitLogger.a(this.f70348d + "-->subscribeMarketDepth--> isSubscribe=" + z11 + " symbol=" + str + " step=" + str2 + " size=" + i11 + " listener=" + marketDepthListener);
        if (z11 && !w()) {
            s();
        }
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.u(new MarketDepthSub(z11, str, str2, i11), marketDepthListener);
        }
    }

    public d9.a<LinearSwapOrderTimeSharingRspInfo> h0(String str, String str2, String str3, String str4, String str5, int i11, double d11, int i12, double d12, int i13, int i14, int i15) {
        HashMap hashMap = new HashMap();
        String str6 = str;
        hashMap.put("contract_code", str);
        String str7 = str2;
        hashMap.put("contract_type", str2);
        String str8 = str3;
        hashMap.put("margin_mode", str3);
        String str9 = str4;
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str4);
        String str10 = str5;
        hashMap.put(Constants.FLAG_TAG_OFFSET, str5);
        hashMap.put("lever_rate", Integer.valueOf(i11));
        hashMap.put("price_interval", Double.valueOf(d11));
        hashMap.put("price_interval_mode", Integer.valueOf(i12));
        hashMap.put("price_limit", Double.valueOf(d12));
        hashMap.put("time_interval", Integer.valueOf(i13));
        hashMap.put("unit_volume", Integer.valueOf(i14));
        hashMap.put("volume", Integer.valueOf(i15));
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestTimeSharingOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void i(String str, RequestMarketTradeDetailListener requestMarketTradeDetailListener, int i11) {
        RetrofitLogger.a(this.f70348d + "-->requestMarketTradeDetailList--> symbol=" + str + " listener=" + requestMarketTradeDetailListener);
        if (!w()) {
            s();
        }
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.u(new TradeDetailRequest(str, i11), requestMarketTradeDetailListener);
        }
    }

    public d9.a<LinearSwapFinancialRecord> i0(String str, int i11, int i12, int i13) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("asset", str);
        hashMap.put("create_date", 90);
        hashMap.put("money_type", Integer.valueOf(i11));
        hashMap.put("page_index", Integer.valueOf(i12));
        hashMap.put("page_size", Integer.valueOf(i13));
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).transferInnerHistory(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void j(boolean z11, String str, MarketDetailListener marketDetailListener) {
        RetrofitLogger.a(this.f70348d + "-->subscribeMarketDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketDetailListener);
        if (z11 && !w()) {
            s();
        }
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.u(new MarketDetailSub(z11, str), marketDetailListener);
        }
    }

    public d9.a<PositionSlippageInfo> j0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str);
        hashMap.put("volume", str2);
        hashMap.put("contract_code", str3);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryPositionSlippage(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void k(boolean z11, String str, MarketTradeDetailListener marketTradeDetailListener) {
        RetrofitLogger.a(this.f70348d + "-->subscribeMarketTradeDetail--> isSubscribe=" + z11 + " symbol=" + str + " listener=" + marketTradeDetailListener);
        if (z11 && !w()) {
            s();
        }
        i iVar = this.f70345a;
        if (iVar != null) {
            iVar.u(new TradeDetailSub(z11, str), marketTradeDetailListener);
        }
    }

    public d9.a<LinearSwapPositionModeSwitchRespInfo> k0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("margin_mode", str);
        hashMap.put("position_mode", str2);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).switchPositionModeWhenUnitDeposit(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void l(boolean z11, String str, String str2, MarketDepthListener marketDepthListener) {
        h(z11, str, str2, 20, marketDepthListener);
    }

    public d9.a<OffSiteLimit> l0(String str, String str2, String str3, String str4, String str5, int i11, String str6, String str7) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("contract_type", str2);
        hashMap.put(FirebaseAnalytics.Param.PRICE, str3);
        hashMap.put("volume", str4);
        hashMap.put("order_price_type", str5);
        hashMap.put("margin_mode", i11 == 2 ? FutureContractInfo.MARGIN_ISOLATED : FutureContractInfo.MARGIN_CROSS);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str6);
        hashMap.put(Constants.FLAG_TAG_OFFSET, str7);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getOrderLimit(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<Object> linearCloseAllPosition() {
        Class cls = LinearSwapService.class;
        if (SPUtil.j()) {
            return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).linearCloseAllPositionV5().compose(LinearSwapRetrofit.o()));
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).linearCloseAllPosition().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapOpenRight> m(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getOpenRight(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapOrderResult<LinearSwapTriggerOrderInfo>> m0(int i11, int i12, String str, String str2, int i13) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_size", Integer.valueOf(i12));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        hashMap.put("business_type", Integer.valueOf(i13));
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getAllCurrentTriggerOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<Object> n(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("trade_unit", str);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).updateTradeUnit(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapPosition>> n0(String str, String str2, String str3) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("trade_partition", str2);
        hashMap.put("business_type", str3);
        if (SPUtil.j()) {
            return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).getAllContractPositionWhenUnitDeposit(hashMap).compose(LinearSwapRetrofit.o()));
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).getAllContractPosition(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<Boolean> o(String str, String str2, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("tp_trigger_price", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("sl_trigger_price", str5);
        }
        try {
            RetrofitLogger.h("查询止盈止损下单冻结状态", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestCurrentTpslFrozenState(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapOrderInsertRspInfo> o0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z11, boolean z12) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("trigger_type", str2);
        hashMap.put("trigger_price", str3);
        hashMap.put("order_price", str4);
        hashMap.put("order_price_type", str5);
        hashMap.put("volume", str6);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str7);
        if (z11) {
            hashMap.put(Constants.FLAG_TAG_OFFSET, LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE);
        } else {
            hashMap.put(Constants.FLAG_TAG_OFFSET, str8);
        }
        hashMap.put("lever_rate", str9);
        if (z12) {
            hashMap.put("reduce_only", 1);
        }
        try {
            RetrofitLogger.g("正向永续全仓计划委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).crossTriggerOrderInsert(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<ContractCancelOrderResult> p(HashMap<String, Object> hashMap) {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestCancelOrderAll(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapPositionModeSwitchRespInfo> p0(String str, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("margin_account", str);
        hashMap.put("position_mode", z11 ? "single_side" : "dual_side");
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).switchPositionModeWhenZhuCang(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapCancelAllResult> q(String str, long j11) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", Long.valueOf(j11));
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).cancelTrackOpenOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapCancelAllResult> q0(String str, long j11) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", Long.valueOf(j11));
        if (SPUtil.j()) {
            return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).orderCancelV5(hashMap).compose(LinearSwapRetrofit.o()));
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).orderCancel(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<AccountBalanceInfoV5> queryAccountBalance() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryAccountBalance().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapPositionModeSwitchRespInfo> queryPositionModeWhenUnitDeposit() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryPositionModeWhenUnitDeposit().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<Integer> queryTradeUnit() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryTradeUnit().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<UnionModeWhiteListInfo> queryUnionWhiteList() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryUnionWhiteList().compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapWhiteList>> queryUserIshit(Map<String, String> map) {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).queryUserIshit(map).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapTpSlOrderRspInfo> r(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("tp_trigger_price", str4);
            hashMap.put("tp_order_price", str5);
            hashMap.put("tp_order_price_type", str6);
            if (!TextUtils.isEmpty(str7)) {
                hashMap.put("tp_trigger_type", str7);
            }
        }
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("sl_trigger_price", str8);
            hashMap.put("sl_order_price", str9);
            hashMap.put("sl_order_price_type", str10);
            if (!TextUtils.isEmpty(str11)) {
                hashMap.put("sl_trigger_type", str11);
            }
        }
        try {
            RetrofitLogger.h("正向永续止盈止损委托下单", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestContractTpSlOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapBondAdjustDetail> r0(String str, String str2, String str3, boolean z11, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("margin_account", str2);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str5);
        if (z11) {
            hashMap.put("trade_side", "increase");
        } else {
            hashMap.put("trade_side", "decrease");
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("trade_partition", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("amount", str4);
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getBondAdjustDetail(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public void s() {
        RetrofitLogger.a(this.f70348d + "-->connectWebSocket");
        c9.b bVar = this.f70346b;
        if (bVar != null) {
            String webSocketHost = bVar.getWebSocketHost();
            if (!TextUtils.isEmpty(webSocketHost)) {
                if (this.f70345a == null) {
                    this.f70345a = new i(LinearSwapRetrofit.g().getTag(), LinearSwapRetrofit.g().createSocketOkHttpClientBuilder().build(), this.f70346b);
                }
                this.f70345a.m(webSocketHost);
            }
        }
    }

    public d9.a<LinearSwapTpSlOrderRspInfo> s0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("volume", str3);
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("tp_trigger_price", str4);
            hashMap.put("tp_order_price", str5);
            hashMap.put("tp_order_price_type", str6);
            if (!TextUtils.isEmpty(str7)) {
                hashMap.put("tp_trigger_type", str7);
            }
        }
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("sl_trigger_price", str8);
            hashMap.put("sl_order_price", str9);
            hashMap.put("sl_order_price_type", str10);
            if (!TextUtils.isEmpty(str11)) {
                hashMap.put("sl_trigger_type", str11);
            }
        }
        try {
            RetrofitLogger.h("正向永续止盈止损委托下单——全仓", new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestContractCrossTpSlOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapCancelAllResult> t(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).contractTriggerCancel(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LevelAvailableMarginInfo>> t0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getLevelAvailableMargin(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<ContractTriggerProtectInfo> triggerProtect(String str) {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).triggerProtect(str).compose(LinearSwapRetrofit.o()));
    }

    public final d9.a<LinearSwapOrderResult<LinearSwapCurrentOrderInfo>> u(int i11, int i12, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        hashMap.put("page_size", Integer.valueOf(i12));
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getAllCurrentOrderV5(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearOrderInsertRspInfo> u0(String str, String str2, String str3) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        try {
            RetrofitLogger.g("正向永续一键反手:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (SPUtil.j()) {
            hashMap.put("margin_mode", FutureContractInfo.MARGIN_CROSS);
            hashMap.put("position_side", str3);
            return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).requestReversalV5(hashMap).compose(LinearSwapRetrofit.o()));
        }
        hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str2);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).requestReversalCross(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapProductInfo>> v() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getProductInfo("0", (String) null, TtmlNode.COMBINE_ALL).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapSettlementPriceInfo>> v0(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("trade_partition", str2);
        hashMap.put("business_type", str3);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getSettlementPrice(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public final boolean w() {
        i iVar = this.f70345a;
        return iVar != null && iVar.q();
    }

    public d9.a<LinearSwapLeverRate> w0(String str, String str2, String str3, boolean z11) {
        Class cls = LinearSwapService.class;
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("lever_rate", str2);
        if (!SPUtil.j()) {
            return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).checkLeverRate(hashMap).compose(LinearSwapRetrofit.o()));
        }
        hashMap.put("margin_mode", str3);
        hashMap.put("position_side", z11 ? "BOTH" : "LONG");
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(cls)).updateLeverRateV5(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public final d9.a<LinearOrderInsertRspInfo> x(String str, String str2, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("margin_mode", z11 ? FutureContractInfo.MARGIN_CROSS : FutureContractInfo.MARGIN_ISOLATED);
        hashMap.put("position_side", str2);
        if (!z11) {
            hashMap.put("after_cancel_order", 1);
        }
        try {
            RetrofitLogger.g("正向永续闪电委托下单:" + new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).requestSwapLightCloseV5(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapProductInfo>> x0() {
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getProductInfo("0", "1", TtmlNode.COMBINE_ALL).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapCancelAllResult> y(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).contractStopCancel(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapOrderResult<LinearSwapTriggerOrderInfo>> y0(int i11, int i12, String str, String str2, int i13) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_size", Integer.valueOf(i12));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (i11 != 0) {
            hashMap.put("page_index", Integer.valueOf(i11));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        hashMap.put("business_type", Integer.valueOf(i13));
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getAllCurrentStopOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<List<LinearSwapAccountInfo>> z(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("contract_code", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("trade_partition", str2);
        }
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).getAccountInfo(hashMap).compose(LinearSwapRetrofit.o()));
    }

    public d9.a<LinearSwapCancelAllResult> z0(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("contract_code", str);
        hashMap.put("order_id", str2);
        return new d9.a<>(((LinearSwapService) LinearSwapRetrofit.request(LinearSwapService.class)).cancelTimeOpenOrder(hashMap).compose(LinearSwapRetrofit.o()));
    }
}
