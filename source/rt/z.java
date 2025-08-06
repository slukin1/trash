package rt;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bh.j;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.AutoOrderResult;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.pro.core.bean.AlgoOrderResult;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.OrderConfirmDialog;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.AccountType;
import com.huobi.finance.bean.MarginSettings;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.supermargin.bean.MarginLoanAsset;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.trade.bean.OrderMarginParams;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.bean.TradeRefreshEvent;
import com.huobi.trade.helper.f0;
import com.huobi.trade.prime.bean.PrimeBidOrderPlaceResult;
import com.huobi.trade.service.TradeService;
import com.huobi.tradenew.prime.helper.TradeMarginHelper;
import com.huobi.tradenew.prime.service.PrimeService;
import com.huobi.tradenew.ui.z0;
import com.huobi.utils.SymbolUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.stat.ServiceStat;
import d7.a1;
import dt.h2;
import i6.k;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import tq.p;
import ut.o;
import ws.h;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<z0> f84828a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Map<String, String>> f84829b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Map<String, String>> f84830c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Map<String, String>> f84831d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, Map<String, String>> f84832e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, Map<String, String>> f84833f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Map<String, String>> f84834g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, MarginLoanAsset> f84835h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public Map<String, MarginSettings> f84836i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public Dialog f84837j;

    /* renamed from: k  reason: collision with root package name */
    public Dialog f84838k;

    /* renamed from: l  reason: collision with root package name */
    public BigDecimal f84839l;

    /* renamed from: m  reason: collision with root package name */
    public BigDecimal f84840m;

    /* renamed from: n  reason: collision with root package name */
    public BigDecimal f84841n;

    /* renamed from: o  reason: collision with root package name */
    public BigDecimal f84842o;

    /* renamed from: p  reason: collision with root package name */
    public BigDecimal f84843p;

    /* renamed from: q  reason: collision with root package name */
    public BigDecimal f84844q;

    /* renamed from: r  reason: collision with root package name */
    public BigDecimal f84845r;

    /* renamed from: s  reason: collision with root package name */
    public BigDecimal f84846s;

    public class a extends b<AlgoOrderResult> {
        public a(TradeType tradeType, int i11, String str, boolean z11) {
            super(tradeType, i11, str, z11);
        }

        /* renamed from: b */
        public void onNext(AlgoOrderResult algoOrderResult) {
            super.onNext(algoOrderResult);
            k.o("PLAN_TRADE", "AlgoOrderResult - " + algoOrderResult);
            a(algoOrderResult.getClientOrderId(), (List<String>) null);
        }
    }

    public class b<T> extends EasySubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public String f84848b;

        /* renamed from: c  reason: collision with root package name */
        public TradeType f84849c;

        /* renamed from: d  reason: collision with root package name */
        public int f84850d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f84851e;

        /* renamed from: f  reason: collision with root package name */
        public long f84852f;

        public b(TradeType tradeType, int i11, String str, boolean z11) {
            this.f84849c = tradeType;
            this.f84850d = i11;
            this.f84848b = str;
            this.f84851e = z11;
        }

        public void a(String str, List<String> list) {
            System.currentTimeMillis();
            z.this.I().F(0, !o.C().T());
            boolean z11 = o.C().G() != null && this.f84848b.equals(o.C().G().getSymbolCode());
            if (o.C().W() && this.f84851e && this.f84850d == 0 && z11) {
                StringBuilder sb2 = new StringBuilder();
                if (list == null || list.isEmpty()) {
                    sb2 = new StringBuilder(String.format(j.d(R.string.prime_sign_number_dialog_content), new Object[]{str}));
                } else {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        sb2.append("# ");
                        sb2.append(list.get(i11));
                        if (i11 < list.size() - 1) {
                            sb2.append("\n");
                        }
                    }
                }
                z.this.I().J(sb2.toString());
            }
            HuobiToastUtil.t(j.c(), R.string.string_order_op_ok);
            s6.a.b(j.c()).c(R.raw.order_success);
            int i12 = this.f84850d;
            if (i12 == 0) {
                EventBus.d().k(new h(1, 0));
            } else if (i12 == 1) {
                EventBus.d().k(new h(2, (Integer) null));
            } else if (i12 == 2) {
                EventBus.d().k(new h(1, 1));
            } else if (i12 != 3) {
                EventBus.d().k(new h(-1, (Integer) null));
            } else {
                EventBus.d().k(new h(1, 2));
            }
            EventBus.d().k(new AssetAndOrderUpdateEvent());
            EventBus.d().k(new mq.a(str));
        }

        public void onAfter() {
            z.this.I().dismissProgressDialog();
            super.onAfter();
            boolean S = a1.v().S(this.f84848b);
            if (S && this.f84851e) {
                dh.c.g("prime");
            }
            if (S) {
                GrowingIOStatics.g(o.C().A(), this.f84851e);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if ("70002".equals(aPIStatusErrorException.getErrCode()) || "70003".equals(aPIStatusErrorException.getErrCode())) {
                EventBus.d().k(new TradeRefreshEvent());
                HuobiToastUtil.k(j.c(), R.string.n_data_error);
                return;
            }
            super.onFailed(aPIStatusErrorException);
        }

        public void onStart() {
            super.onStart();
            this.f84852f = System.currentTimeMillis();
            z.this.I().showProgressDialog();
        }
    }

    public class c extends b<PrimeBidOrderPlaceResult> {
        public c(TradeType tradeType, int i11, String str, boolean z11) {
            super(tradeType, i11, str, z11);
        }

        /* renamed from: b */
        public void onNext(PrimeBidOrderPlaceResult primeBidOrderPlaceResult) {
            super.onNext(primeBidOrderPlaceResult);
            a(primeBidOrderPlaceResult.getId(), primeBidOrderPlaceResult.getBidIds());
        }
    }

    public class d extends b<AutoOrderResult> {
        public d(TradeType tradeType, int i11, String str, boolean z11) {
            super(tradeType, i11, str, z11);
        }

        /* renamed from: b */
        public void onNext(AutoOrderResult autoOrderResult) {
            super.onNext(autoOrderResult);
            a((String) null, (List<String>) null);
        }
    }

    public class e extends b<String> {
        public e(TradeType tradeType, int i11, String str, boolean z11) {
            super(tradeType, i11, str, z11);
        }

        /* renamed from: b */
        public void onNext(String str) {
            super.onNext(str);
            a(str, (List<String>) null);
        }
    }

    public z(z0 z0Var) {
        this.f84828a = new WeakReference<>(z0Var);
    }

    public static Map<String, Object> B(Long l11, String str, OrderPlaceBean orderPlaceBean) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", orderPlaceBean.getSymbol());
        hashMap.put("accountId", l11.toString());
        if (orderPlaceBean.getTradeViewType() != 1) {
            hashMap.put("amount", orderPlaceBean.getAmount());
            hashMap.put("marketAmount", "0");
        } else if (orderPlaceBean.isBuy()) {
            if (orderPlaceBean.isSelectedMarketAmount()) {
                hashMap.put("marketAmount", orderPlaceBean.getMarketAmountText());
                hashMap.put("amount", "0");
            } else {
                hashMap.put("amount", orderPlaceBean.getAmount());
                hashMap.put("marketAmount", "0");
            }
        } else if (orderPlaceBean.isSelectedMarketAmount()) {
            hashMap.put("amount", orderPlaceBean.getAmount());
            hashMap.put("marketAmount", "0");
        } else {
            hashMap.put("marketAmount", orderPlaceBean.getMarketAmountText());
            hashMap.put("amount", "0");
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getLoanAmount())) {
            hashMap.put("borrowAmount", orderPlaceBean.getLoanAmount());
        }
        hashMap.put("type", orderPlaceBean.getOrderType());
        hashMap.put("tradePurpose", String.valueOf(orderPlaceBean.getAutoType()));
        if (!TextUtils.isEmpty(orderPlaceBean.getPrice())) {
            hashMap.put(FirebaseAnalytics.Param.PRICE, orderPlaceBean.getPrice());
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getStopPrice())) {
            hashMap.put("stopPrice", orderPlaceBean.getStopPrice());
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getOperator())) {
            hashMap.put("operator", orderPlaceBean.getOperator());
        }
        if (orderPlaceBean.getCouponId() != 0) {
            hashMap.put("couponId", Long.valueOf(orderPlaceBean.getCouponId()));
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getIceAmount())) {
            hashMap.put("iceAmount", orderPlaceBean.getIceAmount());
        }
        hashMap.put("source", str);
        return hashMap;
    }

    public static Map<String, Object> C(long j11, String str, OrderPlaceBean orderPlaceBean) {
        if (orderPlaceBean.getTradeViewType() == 3) {
            return s(j11, str, orderPlaceBean);
        }
        Map<String, Object> b11 = MapParamsBuilder.c().a("symbol", orderPlaceBean.getSymbol()).a("source", str).a("type", orderPlaceBean.getOrderType()).a("amount", orderPlaceBean.getAmount()).a(FirebaseAnalytics.Param.PRICE, orderPlaceBean.getPrice()).a("accountId", Long.valueOf(j11)).b();
        if (orderPlaceBean.getTradeViewType() == 2) {
            b11.put("stopPrice", orderPlaceBean.getStopPrice());
            b11.put("operator", orderPlaceBean.getOperator());
        }
        return b11;
    }

    public static Map<String, Object> G(long j11, String str, OrderPlaceBean orderPlaceBean) {
        if (orderPlaceBean.getTradeViewType() == 3) {
            return s(j11, str, orderPlaceBean);
        }
        Map<String, Object> b11 = MapParamsBuilder.c().a("symbol", orderPlaceBean.getSymbol()).a("source", str).a("type", orderPlaceBean.getOrderType()).a("amount", orderPlaceBean.getAmount()).a(FirebaseAnalytics.Param.PRICE, orderPlaceBean.getPrice()).a("account-id", Long.valueOf(j11)).b();
        if (orderPlaceBean.getTradeViewType() == 2) {
            b11.put("stop-price", orderPlaceBean.getStopPrice());
            b11.put("operator", orderPlaceBean.getOperator());
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getMarginAmount()) && m.a(orderPlaceBean.getMarginAmount()).compareTo(BigDecimal.ZERO) > 0) {
            b11.put("margin-amount", orderPlaceBean.getMarginAmount());
        }
        if (a1.v().S(orderPlaceBean.getSymbol()) && orderPlaceBean.isBuy()) {
            if (orderPlaceBean.isVerifyAliToken()) {
                b11.put("afs", orderPlaceBean.getVerify());
                b11.put("sliderId", orderPlaceBean.getAliToken().getSliderId());
                b11.put("sliderToken", orderPlaceBean.getAliToken().getSliderToken());
            }
            if (PhoneUtils.x()) {
                b11.put("r", Integer.valueOf((new Random().nextInt(5000) * 2) + 1));
            } else {
                b11.put("r", Integer.valueOf(new Random().nextInt(5000) * 2));
            }
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getIceAmount())) {
            b11.put("ice-amount", orderPlaceBean.getIceAmount());
        }
        k.d(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, "币币委托下单:" + new Gson().toJson((Object) b11));
        return b11;
    }

    public static /* synthetic */ Observable K(OrderPlaceBean orderPlaceBean, String str, Long l11) {
        Map<String, Object> G = G(l11.longValue(), "spot-android", orderPlaceBean);
        k.f("PLAN_TRADE", "accountType - " + str + " params - " + G);
        return x8.a.a().algoOrder(G).b();
    }

    public static /* synthetic */ Observable L(OrderPlaceBean orderPlaceBean, Long l11) {
        if (l11 == null) {
            return Observable.empty();
        }
        return v7.b.a().potentialOrderPlace(C(l11.longValue(), "spot-android", orderPlaceBean)).b();
    }

    public static /* synthetic */ Observable N(OrderPlaceBean orderPlaceBean, Long l11) {
        Class cls = PrimeService.class;
        Map<String, Object> G = G(l11.longValue(), "spot-android", orderPlaceBean);
        if (!o.C().U() || !orderPlaceBean.isBuy()) {
            return ((PrimeService) p.C(cls)).orderPlace(G);
        }
        return ((PrimeService) p.C(cls)).luckyOrderPlace(G);
    }

    public static /* synthetic */ Observable S(OrderPlaceBean orderPlaceBean, Long l11) {
        if (l11 == null) {
            return Observable.empty();
        }
        return v7.b.a().orderPlaceAuto(B(l11, "margin-android", orderPlaceBean)).b();
    }

    public static /* synthetic */ Observable T(OrderPlaceBean orderPlaceBean, Long l11) {
        if (l11 == null) {
            return Observable.empty();
        }
        return v7.b.a().orderPlaceAuto(B(l11, "super-margin-android", orderPlaceBean)).b();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void U(TradeType tradeType, OrderPlaceBean orderPlaceBean, View view) {
        f0(tradeType, orderPlaceBean);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity, HBDialogFragment hBDialogFragment) {
        t0(tradeType, orderPlaceBean, activity);
        hBDialogFragment.dismiss();
    }

    public static Map<String, Object> s(long j11, String str, OrderPlaceBean orderPlaceBean) {
        HashMap hashMap = new HashMap();
        hashMap.put("accountId", Long.valueOf(j11));
        hashMap.put("source", "android");
        hashMap.put("symbol", orderPlaceBean.getSymbol());
        hashMap.put("orderSide", orderPlaceBean.isBuy() ? "buy" : "sell");
        hashMap.put("stopPrice", orderPlaceBean.getStopPrice());
        hashMap.put("amount", orderPlaceBean.getAmount());
        if (2 == orderPlaceBean.getPlanTradeMarketMode()) {
            hashMap.put("orderType", PrimeRounds.ROUND_TRADE_MARKET_TYPE);
            if (orderPlaceBean.isBuy()) {
                hashMap.put("orderValue", orderPlaceBean.getAmount());
            } else {
                hashMap.put("orderSize", orderPlaceBean.getAmount());
            }
            if (!TextUtils.isEmpty(orderPlaceBean.getOrderMarginValue())) {
                hashMap.put("orderMarginValue", orderPlaceBean.getOrderMarginValue());
            }
        } else {
            hashMap.put("orderType", "limit");
            hashMap.put("orderPrice", orderPlaceBean.getPrice());
            hashMap.put("orderSize", orderPlaceBean.getAmount());
            if (!TextUtils.isEmpty(orderPlaceBean.getOrderMarginSize()) && orderPlaceBean.isBuy()) {
                hashMap.put("orderMarginSize", orderPlaceBean.getOrderMarginSize());
            }
            if (!TextUtils.isEmpty(orderPlaceBean.getMarginAmount()) && !orderPlaceBean.isBuy()) {
                hashMap.put("marginAmount", orderPlaceBean.getMarginAmount());
            }
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getIceAmount())) {
            hashMap.put("iceAmount", orderPlaceBean.getIceAmount());
        }
        return hashMap;
    }

    public MarginLoanAsset A(String str) {
        return this.f84835h.get(str);
    }

    public String D(TradeType tradeType, String str, boolean z11) {
        Map map = this.f84829b.get(Integer.valueOf(u(tradeType)));
        Map<Integer, Map<String, String>> map2 = this.f84829b;
        if (map2 == null || map2.isEmpty()) {
            return "0.00";
        }
        return (String) map.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str));
    }

    public Map<String, String> E(TradeType tradeType, int i11) {
        if (i11 == 1 || i11 == 3) {
            return this.f84832e.get(Integer.valueOf(u(tradeType)));
        }
        return this.f84833f.get(Integer.valueOf(u(tradeType)));
    }

    public BigDecimal F(TradeType tradeType, String str, boolean z11, int i11) {
        Map<String, String> E = E(tradeType, i11);
        if (E == null) {
            return BigDecimal.ZERO;
        }
        return m.a(E.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str)));
    }

    public BigDecimal H(String str, int i11, boolean z11, int i12, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (!z11 || ((i11 != 0 && i11 != 2) || a1.v().S(str))) {
            return (i11 == 3 && z11 && i12 == 1) ? bigDecimal.multiply(bigDecimal2) : bigDecimal2;
        }
        return bigDecimal.multiply(bigDecimal2);
    }

    public final z0 I() {
        return (z0) this.f84828a.get();
    }

    public boolean J(TradeType tradeType, String str, int i11, String str2, String str3, boolean z11, boolean z12, String str4, int i12, int i13, boolean z13) {
        BigDecimal bigDecimal;
        TradeType tradeType2 = tradeType;
        String str5 = str;
        boolean z14 = z11;
        int i14 = i12;
        BigDecimal a11 = m.a(str2);
        BigDecimal a12 = m.a(str3);
        if (a12.compareTo(BigDecimal.ZERO) <= 0) {
            return true;
        }
        BigDecimal H = H(str, i11, z11, i13, a11, a12);
        if (TradeType.PRO == tradeType2) {
            if (!a1.v().S(str) || !z14) {
                bigDecimal = z13 ? m.a(TradeMarginHelper.b().c()) : w(tradeType, str, z14);
            } else if (str4 != null) {
                bigDecimal = m.a(str4).compareTo(w(tradeType, str, z14)) < 0 ? m.a(str4) : w(tradeType, str, z14);
            } else {
                bigDecimal = BigDecimal.ZERO;
            }
        } else if (TradeType.MARGIN == tradeType2) {
            bigDecimal = z(str, z14, i14);
        } else if (TradeType.C2C == tradeType2) {
            bigDecimal = v(str, z14);
        } else {
            bigDecimal = F(tradeType, str, z14, i14);
        }
        if (!z12 || i11 == 3 || H.compareTo(bigDecimal) <= 0) {
            return true;
        }
        return false;
    }

    public boolean Z(TradeType tradeType, String str, int i11, String str2, String str3, boolean z11, BigDecimal bigDecimal, boolean z12, String str4, String str5, int i12, int i13, boolean z13) {
        BigDecimal bigDecimal2;
        String str6;
        String str7;
        TradeType tradeType2 = tradeType;
        String str8 = str;
        int i14 = i11;
        boolean z14 = z11;
        BigDecimal bigDecimal3 = bigDecimal;
        int i15 = i12;
        int i16 = i13;
        BigDecimal a11 = m.a(str4);
        BigDecimal a12 = m.a(str2);
        if (i14 == 0 || i14 == 2) {
            if (a12.compareTo(BigDecimal.ZERO) <= 0) {
                I().U(z14);
                return false;
            }
        } else if (i14 == 3 && i16 == 1 && a12.compareTo(BigDecimal.ZERO) <= 0) {
            I().U(z14);
            return false;
        }
        if ((i14 == 2 || i14 == 3) && a11.compareTo(BigDecimal.ZERO) <= 0) {
            I().i3(z14);
            return false;
        }
        BigDecimal a13 = m.a(str3);
        if (a13.compareTo(BigDecimal.ZERO) <= 0) {
            I().c0(z14);
            return false;
        }
        BigDecimal bigDecimal4 = a12;
        BigDecimal H = H(str, i11, z11, i13, a12, a13);
        ExchangeSettings b11 = ExchangeSettingsController.d().b(str8);
        String str9 = "0.9";
        String str10 = "1.1";
        if (!a1.v().S(str8) && i14 == 0 && bigDecimal3.compareTo(BigDecimal.ZERO) != 0) {
            if (b11 != null) {
                str7 = b11.getBuyLimitMustLessThan();
                str6 = b11.getSellLimitMustGreaterThan();
            } else {
                str6 = str9;
                str7 = str10;
            }
            if (z14 && bigDecimal4.compareTo(bigDecimal3.multiply(m.a(str7))) > 0) {
                HuobiToastUtil.m(String.format(j.c().getString(R.string.n_trade_buy_price_high), new Object[]{m.Q(str7, 0, 1)}));
                return false;
            } else if (!z14 && bigDecimal4.compareTo(bigDecimal3.multiply(m.a(str6))) < 0) {
                HuobiToastUtil.m(String.format(j.c().getString(R.string.n_trade_sell_price_low), new Object[]{m.Q(str6, 0, 1)}));
                return false;
            }
        }
        if (TradeType.PRO == tradeType2) {
            if (!a1.v().S(str8) || !z14) {
                bigDecimal2 = z13 ? m.a(TradeMarginHelper.b().c()) : w(tradeType2, str8, z14);
            } else if (str5 != null) {
                bigDecimal2 = m.a(str5).compareTo(w(tradeType2, str8, z14)) < 0 ? m.a(str5) : w(tradeType2, str8, z14);
            } else {
                bigDecimal2 = BigDecimal.ZERO;
            }
        } else if (TradeType.MARGIN == tradeType2) {
            bigDecimal2 = z(str8, z14, i15);
        } else if (TradeType.C2C == tradeType2) {
            bigDecimal2 = v(str8, z14);
        } else {
            bigDecimal2 = F(tradeType2, str8, z14, i15);
        }
        if (!z12) {
            return false;
        }
        if (i14 != 3 && H.compareTo(bigDecimal2) > 0) {
            return false;
        }
        if (i14 == 2) {
            if (a11.compareTo(m.a(str2)) == 0) {
                HuobiToastUtil.m(j.c().getString(R.string.trade_trend_trigger_price_tips));
                return false;
            }
            float floatValue = bigDecimal4.divide(a11, 2, 4).floatValue();
            if (b11 != null) {
                str10 = b11.getBuyLimitMustLessThan();
                str9 = b11.getSellLimitMustGreaterThan();
            }
            if (z14 && floatValue > m.a(str10).floatValue()) {
                HuobiToastUtil.m(String.format(j.c().getString(R.string.n_trade_buy_stop_price_high), new Object[]{m.Q(str10, 0, 1)}));
                return false;
            } else if (!z14 && floatValue < m.a(str9).floatValue()) {
                HuobiToastUtil.m(String.format(j.c().getString(R.string.n_trade_sell_stop_price_low), new Object[]{m.Q(str9, 0, 1)}));
                return false;
            }
        }
        if (i14 == 3 && i13 == 1) {
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                return false;
            }
            float floatValue2 = bigDecimal4.divide(a11, 2, 4).floatValue();
            if (z14 && floatValue2 > 1.1f) {
                HuobiToastUtil.m(j.c().getString(R.string.trade_trend_trigger_price_hight_tips));
                return false;
            } else if (!z14 && floatValue2 < 0.9f) {
                HuobiToastUtil.m(j.c().getString(R.string.trade_trend_trigger_price_low_tips));
                return false;
            }
        }
        if (NetworkStatus.c(j.c())) {
            return true;
        }
        HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
        return false;
    }

    public OrderPlaceBean a0(TradeType tradeType, String str, int i11, String str2, String str3, boolean z11, String str4, BigDecimal bigDecimal, int i12, String str5, OrderMarginParams orderMarginParams) {
        String str6;
        String str7;
        OrderPlaceBean orderPlaceBean = new OrderPlaceBean();
        orderPlaceBean.setSymbol(str);
        orderPlaceBean.setTradeViewType(i11);
        if (i11 == 0 || i11 == 2 || i11 == 3) {
            orderPlaceBean.setPrice(str2);
        }
        if (i11 == 3) {
            orderPlaceBean.setOrderMarginValue(orderMarginParams.f81960b);
            orderPlaceBean.setOrderMarginSize(orderMarginParams.f81959a);
        }
        orderPlaceBean.setAmount(str3);
        orderPlaceBean.setMarginAmount(str5);
        if (i11 == 3) {
            orderPlaceBean.setOrderMarginSize(orderMarginParams.f81959a);
            orderPlaceBean.setOrderMarginValue(orderMarginParams.f81960b);
        }
        BigDecimal a11 = m.a(str4);
        if (i11 == 2 || i11 == 3) {
            orderPlaceBean.setOperator(a11.compareTo(bigDecimal) <= 0 ? MTCommonConstants.Network.RADIO_4G : "gte");
            orderPlaceBean.setStopPrice(str4);
        }
        orderPlaceBean.setBuy(z11);
        if (i12 == 1) {
            orderPlaceBean.setAutoType(1);
        } else if (i12 == 2) {
            orderPlaceBean.setAutoType(2);
        } else if (i12 == 3) {
            orderPlaceBean.setAutoType(3);
        }
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            orderPlaceBean.setPredictAmount("--");
        } else if (z11) {
            BigDecimal bigDecimal2 = this.f84839l;
            if (bigDecimal2 == null) {
                orderPlaceBean.setPredictAmount("--");
            } else {
                orderPlaceBean.setPredictAmount(bigDecimal2.divide(bigDecimal, PrecisionUtil.z(str), 1).toPlainString());
            }
        } else {
            BigDecimal bigDecimal3 = this.f84840m;
            if (bigDecimal3 == null) {
                orderPlaceBean.setPredictAmount("--");
            } else {
                orderPlaceBean.setPredictAmount(bigDecimal3.divide(bigDecimal, PrecisionUtil.z(str), 1).toPlainString());
            }
        }
        if (tradeType == TradeType.SUPERMARGIN) {
            MarginLoanAsset marginLoanAsset = null;
            if (i12 == 1) {
                if (z11) {
                    str7 = a1.v().D(str);
                } else {
                    str7 = a1.v().n(str);
                }
                marginLoanAsset = A(str7);
            } else if (i12 == 2) {
                if (z11) {
                    str6 = a1.v().n(str);
                } else {
                    str6 = a1.v().D(str);
                }
                marginLoanAsset = A(str6);
            }
            if (marginLoanAsset != null) {
                orderPlaceBean.setInterestRate(m.Q(marginLoanAsset.getInterestRate(), PrecisionUtil.l(), 1));
            } else {
                orderPlaceBean.setInterestRate("--");
            }
        } else if (tradeType == TradeType.MARGIN) {
            MarginSettings marginSettings = this.f84836i.get(str);
            boolean z12 = false;
            if (i12 == 1) {
                z12 = !z11;
            } else if (i12 == 2) {
                z12 = z11;
            }
            if (marginSettings != null) {
                orderPlaceBean.setInterestRate(marginSettings.formatDeductedRate(z12));
            } else {
                orderPlaceBean.setInterestRate("--");
            }
        }
        if (z11) {
            BigDecimal bigDecimal4 = this.f84841n;
            if (bigDecimal4 == null) {
                orderPlaceBean.setLoanAmount("--");
            } else {
                orderPlaceBean.setLoanAmount(bigDecimal4.toPlainString());
            }
            BigDecimal bigDecimal5 = this.f84842o;
            if (bigDecimal5 == null) {
                orderPlaceBean.setRepayAmount("--");
            } else {
                orderPlaceBean.setRepayAmount(bigDecimal5.toPlainString());
            }
            BigDecimal bigDecimal6 = this.f84845r;
            if (bigDecimal6 == null) {
                orderPlaceBean.setLoanAmountAndInterest("--");
            } else {
                orderPlaceBean.setLoanAmountAndInterest(bigDecimal6.toPlainString());
            }
        } else {
            BigDecimal bigDecimal7 = this.f84843p;
            if (bigDecimal7 == null) {
                orderPlaceBean.setLoanAmount("--");
            } else {
                orderPlaceBean.setLoanAmount(bigDecimal7.toPlainString());
            }
            BigDecimal bigDecimal8 = this.f84844q;
            if (bigDecimal8 == null) {
                orderPlaceBean.setRepayAmount("--");
            } else {
                orderPlaceBean.setRepayAmount(bigDecimal8.toPlainString());
            }
            BigDecimal bigDecimal9 = this.f84846s;
            if (bigDecimal9 == null) {
                orderPlaceBean.setLoanAmountAndInterest("--");
            } else {
                orderPlaceBean.setLoanAmountAndInterest(bigDecimal9.toPlainString());
            }
        }
        if (z11 || i11 != 1) {
            if (z11) {
                BigDecimal bigDecimal10 = this.f84839l;
                if (bigDecimal10 == null) {
                    orderPlaceBean.setVolume("--");
                } else {
                    orderPlaceBean.setVolume(bigDecimal10.toPlainString());
                }
            } else {
                BigDecimal bigDecimal11 = this.f84840m;
                if (bigDecimal11 == null) {
                    orderPlaceBean.setVolume("--");
                } else {
                    orderPlaceBean.setVolume(bigDecimal11.toPlainString());
                }
            }
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            orderPlaceBean.setVolume("--");
        } else {
            orderPlaceBean.setVolume(f0.i(bigDecimal.multiply(m.a(str3)), z11, PrecisionUtil.y(str)).toPlainString());
        }
        orderPlaceBean.setNewPrice(bigDecimal.toPlainString());
        return orderPlaceBean;
    }

    public void b0(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        if (orderPlaceBean != null) {
            r0(tradeType, orderPlaceBean, activity);
        }
    }

    public void c0(TradeType tradeType, OrderPlaceBean orderPlaceBean) {
        if (orderPlaceBean != null) {
            if (!NetworkStatus.c(j.c())) {
                HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
                return;
            }
            h2.t1().b1(tradeType, AccountType.spot.toString()).flatMap(new n(orderPlaceBean)).compose(RxJavaHelper.t(I())).subscribe(new e(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
        }
    }

    public void d0(String str, MarginSettings marginSettings) {
        this.f84836i.put(str, marginSettings);
    }

    public void e0(TradeType tradeType, OrderPlaceBean orderPlaceBean) {
        if (orderPlaceBean != null) {
            if (!NetworkStatus.c(j.c())) {
                HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
            } else if (TradeType.PRO == tradeType) {
                if (a1.v().S(orderPlaceBean.getSymbol())) {
                    if (!o.C().Y() || !orderPlaceBean.isBuy()) {
                        h2.t1().b1(tradeType, AccountType.spot.toString()).flatMap(new w(orderPlaceBean)).compose(p.D()).compose(RxJavaHelper.t(I())).subscribe(new e(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
                        return;
                    }
                    h2.t1().b1(tradeType, AccountType.spot.toString()).flatMap(new m(orderPlaceBean)).compose(p.D()).compose(RxJavaHelper.t(I())).subscribe(new c(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
                } else if (orderPlaceBean.getTradeViewType() == 3) {
                    q(tradeType, orderPlaceBean, AccountType.spot.toString());
                } else {
                    h2.t1().b1(tradeType, AccountType.spot.toString()).flatMap(new x(orderPlaceBean)).compose(p.a0()).compose(RxJavaHelper.t(I())).subscribe(new e(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
                }
            } else if (TradeType.MARGIN == tradeType) {
                if (orderPlaceBean.getTradeViewType() == 3) {
                    q(tradeType, orderPlaceBean, AccountType.margin.toString());
                    return;
                }
                h2.t1().D1(AccountType.margin.toString(), orderPlaceBean.getSymbol()).flatMap(new y(orderPlaceBean)).compose(p.a0()).compose(RxJavaHelper.t(I())).subscribe(new e(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
            } else if (TradeType.SUPERMARGIN == tradeType) {
                if (orderPlaceBean.getTradeViewType() == 3) {
                    q(tradeType, orderPlaceBean, AccountType.supermargin.toString());
                    return;
                }
                h2.t1().b1(tradeType, AccountType.supermargin.toString()).flatMap(new o(orderPlaceBean)).compose(p.a0()).compose(RxJavaHelper.t(I())).subscribe(new e(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
            } else if (TradeType.C2C != tradeType) {
            } else {
                if (orderPlaceBean.getTradeViewType() == 3) {
                    q(tradeType, orderPlaceBean, AccountType.borrow.toString());
                    return;
                }
                h2.t1().D1(AccountType.borrow.toString(), orderPlaceBean.getSymbol()).flatMap(new l(orderPlaceBean)).compose(p.a0()).compose(RxJavaHelper.t(I())).subscribe(new e(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
            }
        }
    }

    public final void f0(TradeType tradeType, OrderPlaceBean orderPlaceBean) {
        if (orderPlaceBean.getAutoType() == 2) {
            orderPlaceBean.setLoanAmount("");
        }
        if (TradeType.MARGIN == tradeType) {
            h2.t1().D1(AccountType.margin.toString(), orderPlaceBean.getSymbol()).flatMap(new u(orderPlaceBean)).compose(RxJavaHelper.t(I())).subscribe(new d(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
        } else if (TradeType.SUPERMARGIN == tradeType) {
            h2.t1().b1(tradeType, AccountType.supermargin.toString()).flatMap(new v(orderPlaceBean)).compose(RxJavaHelper.t(I())).subscribe(new d(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
        }
    }

    public void g0(TradeType tradeType, Map<String, String> map) {
        this.f84829b.put(Integer.valueOf(u(tradeType)), map);
    }

    public void h0(BigDecimal bigDecimal) {
        this.f84841n = bigDecimal;
    }

    public void i0(BigDecimal bigDecimal) {
        this.f84845r = bigDecimal;
    }

    public void j0(BigDecimal bigDecimal) {
        this.f84842o = bigDecimal;
    }

    public void k0(BigDecimal bigDecimal) {
        this.f84839l = bigDecimal;
    }

    public void l0(String str, Map<String, String> map) {
        this.f84830c.put(str, map);
    }

    public void m0(String str, Map<String, String> map) {
        this.f84831d.put(str, map);
    }

    public void n0(BigDecimal bigDecimal) {
        this.f84843p = bigDecimal;
    }

    public void o0(BigDecimal bigDecimal) {
        this.f84846s = bigDecimal;
    }

    public void p0(BigDecimal bigDecimal) {
        this.f84844q = bigDecimal;
    }

    public final void q(TradeType tradeType, OrderPlaceBean orderPlaceBean, String str) {
        Observable<Long> observable;
        if (TradeType.C2C == tradeType || TradeType.MARGIN == tradeType) {
            observable = h2.t1().D1(str, orderPlaceBean.getSymbol());
        } else {
            observable = h2.t1().b1(tradeType, str);
        }
        observable.flatMap(new p(orderPlaceBean, str)).compose(RxJavaHelper.t(I())).subscribe(new a(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
    }

    public void q0(BigDecimal bigDecimal) {
        this.f84840m = bigDecimal;
    }

    public void r() {
        this.f84829b.clear();
        this.f84830c.clear();
        this.f84831d.clear();
        this.f84832e.clear();
        this.f84833f.clear();
        this.f84834g.clear();
    }

    public final void r0(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        Activity activity2 = activity;
        ArrayList arrayList = new ArrayList();
        OrderConfirmBean orderConfirmBean = new OrderConfirmBean();
        if (orderPlaceBean.getAutoType() == 1) {
            orderConfirmBean.setTopHint(activity2.getString(R.string.n_trade_dialog_loan_hint));
            if (orderPlaceBean.isBuy()) {
                Locale locale = Locale.US;
                orderConfirmBean.setTitle(String.format(locale, activity2.getString(R.string.n_trade_loan_long), new Object[]{a1.v().p(orderPlaceBean.getSymbol())}));
                if (orderPlaceBean.getTradeViewType() == 1) {
                    OrderConfirmBean.ListItem listItem = new OrderConfirmBean.ListItem();
                    listItem.setKey(activity2.getString(R.string.n_trade_buy_price));
                    listItem.setValue(activity2.getString(R.string.n_trade_market_buy_hint));
                    arrayList.add(listItem);
                    OrderConfirmBean.ListItem listItem2 = new OrderConfirmBean.ListItem();
                    listItem2.setKey(activity2.getString(R.string.n_trade_predict_buy_amount));
                    listItem2.setValue(String.format(locale, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayPredictAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem2);
                } else {
                    if (orderPlaceBean.getTradeViewType() == 2) {
                        OrderConfirmBean.ListItem listItem3 = new OrderConfirmBean.ListItem();
                        listItem3.setKey(activity2.getString(R.string.trade_trend_trigger_price));
                        if (m.a(orderPlaceBean.getStopPrice()).compareTo(m.a(orderPlaceBean.getNewPrice())) < 0) {
                            listItem3.setValue(String.format(locale, activity2.getString(R.string.n_trade_price_down), new Object[]{orderPlaceBean.getDisplayStopPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                        } else {
                            listItem3.setValue(String.format(locale, activity2.getString(R.string.n_trade_price_up), new Object[]{orderPlaceBean.getDisplayStopPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                        }
                        arrayList.add(listItem3);
                    }
                    OrderConfirmBean.ListItem listItem4 = new OrderConfirmBean.ListItem();
                    listItem4.setKey(activity2.getString(R.string.n_trade_buy_price));
                    listItem4.setValue(String.format(locale, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem4);
                    OrderConfirmBean.ListItem listItem5 = new OrderConfirmBean.ListItem();
                    listItem5.setKey(activity2.getString(R.string.n_trade_buy_amount));
                    listItem5.setValue(String.format(locale, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem5);
                }
                OrderConfirmBean.ListItem listItem6 = new OrderConfirmBean.ListItem();
                listItem6.setKey(activity2.getString(R.string.n_trade_loan_amount));
                listItem6.setValue(String.format(locale, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getLoanAmount(), a1.v().F(orderPlaceBean.getSymbol())}));
                arrayList.add(listItem6);
                OrderConfirmBean.ListItem listItem7 = new OrderConfirmBean.ListItem();
                listItem7.setKey(activity2.getString(R.string.n_trade_day_rate));
                listItem7.setValue(orderPlaceBean.getInterestRate());
                arrayList.add(listItem7);
                OrderConfirmBean.ListItem listItem8 = new OrderConfirmBean.ListItem();
                listItem8.setKey(activity2.getString(R.string.trade_total_volume));
                listItem8.setValue(String.format(locale, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayVolume(), a1.v().F(orderPlaceBean.getSymbol())}));
                arrayList.add(listItem8);
            } else {
                Locale locale2 = Locale.US;
                orderConfirmBean.setTitle(String.format(locale2, activity2.getString(R.string.n_trade_loan_short), new Object[]{a1.v().p(orderPlaceBean.getSymbol())}));
                if (orderPlaceBean.getTradeViewType() == 1) {
                    OrderConfirmBean.ListItem listItem9 = new OrderConfirmBean.ListItem();
                    listItem9.setKey(activity2.getString(R.string.n_trade_sell_price));
                    listItem9.setValue(activity2.getString(R.string.n_trade_market_sell_hint));
                    arrayList.add(listItem9);
                    OrderConfirmBean.ListItem listItem10 = new OrderConfirmBean.ListItem();
                    listItem10.setKey(activity2.getString(R.string.n_trade_sell_amount));
                    listItem10.setValue(String.format(locale2, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem10);
                    OrderConfirmBean.ListItem listItem11 = new OrderConfirmBean.ListItem();
                    listItem11.setKey(activity2.getString(R.string.n_trade_loan_amount));
                    listItem11.setValue(String.format(locale2, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getRepayAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem11);
                    OrderConfirmBean.ListItem listItem12 = new OrderConfirmBean.ListItem();
                    listItem12.setKey(activity2.getString(R.string.n_trade_day_rate));
                    listItem12.setValue(orderPlaceBean.getInterestRate());
                    arrayList.add(listItem12);
                    OrderConfirmBean.ListItem listItem13 = new OrderConfirmBean.ListItem();
                    listItem13.setKey(activity2.getString(R.string.n_trade_predict_volume));
                    listItem13.setValue(String.format(locale2, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayVolume(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem13);
                } else {
                    if (orderPlaceBean.getTradeViewType() == 2) {
                        OrderConfirmBean.ListItem listItem14 = new OrderConfirmBean.ListItem();
                        listItem14.setKey(activity2.getString(R.string.trade_trend_trigger_price));
                        if (m.a(orderPlaceBean.getStopPrice()).compareTo(m.a(orderPlaceBean.getNewPrice())) < 0) {
                            listItem14.setValue(String.format(locale2, activity2.getString(R.string.n_trade_price_down), new Object[]{orderPlaceBean.getDisplayStopPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                        } else {
                            listItem14.setValue(String.format(locale2, activity2.getString(R.string.n_trade_price_up), new Object[]{orderPlaceBean.getDisplayStopPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                        }
                        arrayList.add(listItem14);
                    }
                    OrderConfirmBean.ListItem listItem15 = new OrderConfirmBean.ListItem();
                    listItem15.setKey(activity2.getString(R.string.n_trade_sell_price));
                    listItem15.setValue(String.format(locale2, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem15);
                    OrderConfirmBean.ListItem listItem16 = new OrderConfirmBean.ListItem();
                    listItem16.setKey(activity2.getString(R.string.n_trade_sell_amount));
                    listItem16.setValue(String.format(locale2, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem16);
                    OrderConfirmBean.ListItem listItem17 = new OrderConfirmBean.ListItem();
                    listItem17.setKey(activity2.getString(R.string.n_trade_loan_amount));
                    listItem17.setValue(String.format(locale2, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getRepayAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem17);
                    OrderConfirmBean.ListItem listItem18 = new OrderConfirmBean.ListItem();
                    listItem18.setKey(activity2.getString(R.string.n_trade_day_rate));
                    listItem18.setValue(orderPlaceBean.getInterestRate());
                    arrayList.add(listItem18);
                    OrderConfirmBean.ListItem listItem19 = new OrderConfirmBean.ListItem();
                    listItem19.setKey(activity2.getString(R.string.trade_total_volume));
                    listItem19.setValue(String.format(locale2, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayVolume(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem19);
                }
            }
        } else if (orderPlaceBean.getAutoType() == 2) {
            orderConfirmBean.setTopHint(activity2.getString(R.string.n_trade_dialog_repay_hint));
            if (orderPlaceBean.isBuy()) {
                Locale locale3 = Locale.US;
                orderConfirmBean.setTitle(String.format(locale3, activity2.getString(R.string.n_trade_buy_repay), new Object[]{a1.v().p(orderPlaceBean.getSymbol())}));
                if (orderPlaceBean.getTradeViewType() == 1) {
                    OrderConfirmBean.ListItem listItem20 = new OrderConfirmBean.ListItem();
                    listItem20.setKey(activity2.getString(R.string.n_trade_buy_price));
                    listItem20.setValue(activity2.getString(R.string.n_trade_market_buy_hint));
                    arrayList.add(listItem20);
                    OrderConfirmBean.ListItem listItem21 = new OrderConfirmBean.ListItem();
                    listItem21.setKey(activity2.getString(R.string.n_trade_predict_buy_amount));
                    listItem21.setValue(String.format(locale3, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayPredictAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem21);
                } else {
                    if (orderPlaceBean.getTradeViewType() == 2) {
                        OrderConfirmBean.ListItem listItem22 = new OrderConfirmBean.ListItem();
                        listItem22.setKey(activity2.getString(R.string.trade_trend_trigger_price));
                        if (m.a(orderPlaceBean.getStopPrice()).compareTo(m.a(orderPlaceBean.getNewPrice())) < 0) {
                            listItem22.setValue(String.format(locale3, activity2.getString(R.string.n_trade_price_down), new Object[]{orderPlaceBean.getDisplayStopPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                        } else {
                            listItem22.setValue(String.format(locale3, activity2.getString(R.string.n_trade_price_up), new Object[]{orderPlaceBean.getDisplayStopPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                        }
                        arrayList.add(listItem22);
                    }
                    OrderConfirmBean.ListItem listItem23 = new OrderConfirmBean.ListItem();
                    listItem23.setKey(activity2.getString(R.string.n_trade_buy_price));
                    listItem23.setValue(String.format(locale3, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem23);
                    OrderConfirmBean.ListItem listItem24 = new OrderConfirmBean.ListItem();
                    listItem24.setKey(activity2.getString(R.string.n_trade_buy_amount));
                    listItem24.setValue(String.format(locale3, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem24);
                }
                OrderConfirmBean.ListItem listItem25 = new OrderConfirmBean.ListItem();
                listItem25.setKey(activity2.getString(R.string.n_trade_interest_and_loan_amount));
                listItem25.setValue(String.format(locale3, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getLoanAmountAndInterest(), a1.v().p(orderPlaceBean.getSymbol())}));
                arrayList.add(listItem25);
                OrderConfirmBean.ListItem listItem26 = new OrderConfirmBean.ListItem();
                listItem26.setKey(activity2.getString(R.string.trade_total_volume));
                listItem26.setValue(String.format(locale3, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayVolume(), a1.v().F(orderPlaceBean.getSymbol())}));
                arrayList.add(listItem26);
            } else {
                Locale locale4 = Locale.US;
                orderConfirmBean.setTitle(String.format(locale4, activity2.getString(R.string.n_trade_sell_repay), new Object[]{a1.v().F(orderPlaceBean.getSymbol())}));
                if (orderPlaceBean.getTradeViewType() == 1) {
                    OrderConfirmBean.ListItem listItem27 = new OrderConfirmBean.ListItem();
                    listItem27.setKey(activity2.getString(R.string.n_trade_sell_price));
                    listItem27.setValue(activity2.getString(R.string.n_trade_market_sell_hint));
                    arrayList.add(listItem27);
                    OrderConfirmBean.ListItem listItem28 = new OrderConfirmBean.ListItem();
                    listItem28.setKey(activity2.getString(R.string.n_trade_sell_amount));
                    listItem28.setValue(String.format(locale4, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem28);
                    OrderConfirmBean.ListItem listItem29 = new OrderConfirmBean.ListItem();
                    listItem29.setKey(activity2.getString(R.string.n_trade_interest_and_loan_amount));
                    listItem29.setValue(String.format(locale4, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getLoanAmountAndInterest(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem29);
                    OrderConfirmBean.ListItem listItem30 = new OrderConfirmBean.ListItem();
                    listItem30.setKey(activity2.getString(R.string.n_trade_predict_volume));
                    listItem30.setValue(String.format(locale4, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayVolume(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem30);
                } else {
                    if (orderPlaceBean.getTradeViewType() == 2) {
                        OrderConfirmBean.ListItem listItem31 = new OrderConfirmBean.ListItem();
                        listItem31.setKey(activity2.getString(R.string.trade_trend_trigger_price));
                        if (m.a(orderPlaceBean.getStopPrice()).compareTo(m.a(orderPlaceBean.getNewPrice())) < 0) {
                            listItem31.setValue(String.format(locale4, activity2.getString(R.string.n_trade_price_down), new Object[]{orderPlaceBean.getDisplayStopPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                        } else {
                            listItem31.setValue(String.format(locale4, activity2.getString(R.string.n_trade_price_up), new Object[]{orderPlaceBean.getDisplayStopPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                        }
                        arrayList.add(listItem31);
                    }
                    OrderConfirmBean.ListItem listItem32 = new OrderConfirmBean.ListItem();
                    listItem32.setKey(activity2.getString(R.string.n_trade_sell_price));
                    listItem32.setValue(String.format(locale4, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayPrice(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem32);
                    OrderConfirmBean.ListItem listItem33 = new OrderConfirmBean.ListItem();
                    listItem33.setKey(activity2.getString(R.string.n_trade_sell_amount));
                    listItem33.setValue(String.format(locale4, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayAmount(), a1.v().p(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem33);
                    OrderConfirmBean.ListItem listItem34 = new OrderConfirmBean.ListItem();
                    listItem34.setKey(activity2.getString(R.string.n_trade_interest_and_loan_amount));
                    listItem34.setValue(String.format(locale4, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getLoanAmountAndInterest(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem34);
                    OrderConfirmBean.ListItem listItem35 = new OrderConfirmBean.ListItem();
                    listItem35.setKey(activity2.getString(R.string.trade_total_volume));
                    listItem35.setValue(String.format(locale4, activity2.getString(R.string.two_label_with_space), new Object[]{orderPlaceBean.getDisplayVolume(), a1.v().F(orderPlaceBean.getSymbol())}));
                    arrayList.add(listItem35);
                }
            }
        }
        orderConfirmBean.setList(arrayList);
        orderConfirmBean.setConfirmBtnText(activity2.getString(R.string.string_confirm));
        Dialog d11 = OrderConfirmDialog.d(activity2, orderConfirmBean, new k(this, tradeType, orderPlaceBean), q.f25865b);
        this.f84837j = d11;
        d11.show();
    }

    public void s0(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        CallAuction b11 = ys.a.b(orderPlaceBean.getSymbol());
        if (b11 != null && b11.isCallAuction()) {
            if (!ConfigPreferences.b("user_config", "config_call_auction_third_confirm_" + orderPlaceBean.getSymbol())) {
                new DialogUtils.b.d((FragmentActivity) activity).c1(activity.getString(R.string.n_exchange_call_auction_order_line_up_title)).C0(activity.getString(R.string.n_exchange_call_auction_order_line_up_hint)).P0(activity.getString(R.string.n_exchange_call_auction_order_line_up_confirm)).x0(true).v0(new r(orderPlaceBean)).y0(activity.getString(R.string.n_exchange_call_auction_order_confirm_not_remind)).z0(Integer.valueOf(ContextCompat.getColor(activity, R.color.baseColorPrimaryText))).s0(activity.getString(R.string.n_cancel)).Q0(new s(this, tradeType, orderPlaceBean, activity)).N0(t.f25876a).k0().show(((FragmentActivity) activity).getSupportFragmentManager(), "");
                return;
            }
        }
        t0(tradeType, orderPlaceBean, activity);
    }

    public void t() {
        Dialog dialog = this.f84837j;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog dialog2 = this.f84838k;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
    }

    public void t0(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        if (a1.v().q0(orderPlaceBean.getSymbol(), tradeType)) {
            c0(tradeType, orderPlaceBean);
        } else {
            e0(tradeType, orderPlaceBean);
        }
    }

    public int u(TradeType tradeType) {
        return TradeType.SUPERMARGIN == tradeType ? 4 : 2;
    }

    public BigDecimal v(String str, boolean z11) {
        Map map = this.f84834g.get(str);
        if (map == null) {
            return BigDecimal.ZERO;
        }
        return m.a((String) map.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str)));
    }

    public BigDecimal w(TradeType tradeType, String str, boolean z11) {
        Map map = this.f84829b.get(Integer.valueOf(u(tradeType)));
        if (map == null) {
            return BigDecimal.ZERO;
        }
        return m.a((String) map.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str)));
    }

    public Observable<List<SymbolPrice>> x(Map<String, Object> map) {
        return ((TradeService) p.W(TradeService.class)).historyKline(map).compose(p.c0());
    }

    public Map<String, String> y(String str, int i11) {
        if (i11 == 1 || i11 == 3) {
            return this.f84830c.get(str);
        }
        return this.f84831d.get(str);
    }

    public BigDecimal z(String str, boolean z11, int i11) {
        Map<String, String> y11 = y(str, i11);
        if (y11 == null) {
            return BigDecimal.ZERO;
        }
        return m.a(y11.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str)));
    }
}
