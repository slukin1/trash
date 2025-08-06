package dt;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
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
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.OrderConfirmBottomRemindSheetDialogFragment;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.AccountType;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.finance.bean.MarginSettings;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.supermargin.bean.MarginLoanAsset;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.bean.TradeRefreshEvent;
import com.huobi.trade.helper.f0;
import com.huobi.trade.prime.bean.PrimeBidOrderPlaceResult;
import com.huobi.trade.prime.service.PrimeService;
import com.huobi.trade.ui.TradeSpotOrderConfirmFragment;
import com.huobi.trade.ui.h1;
import com.huobi.utils.SymbolUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.stat.ServiceStat;
import d7.a1;
import ht.o;
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
import java.util.concurrent.TimeoutException;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import qk.u0;
import rx.Observable;
import tq.p;

public class d3 {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<h1> f84022a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Map<String, String>> f84023b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Map<String, String>> f84024c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Map<String, String>> f84025d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public Map<Integer, Map<String, String>> f84026e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, Map<String, String>> f84027f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Map<String, String>> f84028g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public Map<String, MarginLoanAsset> f84029h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public Map<String, MarginSettings> f84030i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public Dialog f84031j;

    /* renamed from: k  reason: collision with root package name */
    public BigDecimal f84032k;

    /* renamed from: l  reason: collision with root package name */
    public BigDecimal f84033l;

    /* renamed from: m  reason: collision with root package name */
    public BigDecimal f84034m;

    /* renamed from: n  reason: collision with root package name */
    public BigDecimal f84035n;

    /* renamed from: o  reason: collision with root package name */
    public BigDecimal f84036o;

    /* renamed from: p  reason: collision with root package name */
    public BigDecimal f84037p;

    /* renamed from: q  reason: collision with root package name */
    public BigDecimal f84038q;

    /* renamed from: r  reason: collision with root package name */
    public BigDecimal f84039r;

    /* renamed from: s  reason: collision with root package name */
    public DialogFragment f84040s;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            d3.this.f84040s.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements OrderConfirmBottomRemindSheetDialogFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SymbolBean f84042a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TradeType f84043b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OrderPlaceBean f84044c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Activity f84045d;

        public b(SymbolBean symbolBean, TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
            this.f84042a = symbolBean;
            this.f84043b = tradeType;
            this.f84044c = orderPlaceBean;
            this.f84045d = activity;
        }

        public void a(boolean z11, View view) {
            if (z11) {
                if (this.f84042a.isCallAuctionOne()) {
                    ConfigPreferences.n("user_config", "config_call_auction_first_confirm", true);
                } else if (this.f84042a.isCallAuctionTwo()) {
                    ConfigPreferences.n("user_config", "config_call_auction_second_confirm", true);
                }
            }
            d3.this.u0(this.f84043b, this.f84044c, this.f84045d);
        }
    }

    public class c implements TradeSpotOrderConfirmFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TradeType f84047a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OrderPlaceBean f84048b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f84049c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f84050d;

        public c(TradeType tradeType, OrderPlaceBean orderPlaceBean, String str, String str2) {
            this.f84047a = tradeType;
            this.f84048b = orderPlaceBean;
            this.f84049c = str;
            this.f84050d = str2;
        }

        public void callback() {
            TradeType tradeType;
            if (!ks.g.j() || !((tradeType = this.f84047a) == TradeType.MARGIN || tradeType == TradeType.SUPERMARGIN)) {
                d3.this.c0(this.f84047a, this.f84048b, this.f84049c, this.f84050d);
            } else {
                d3.this.d0(tradeType, this.f84048b);
            }
        }
    }

    public class d extends e<AlgoOrderResult> {
        public d(TradeType tradeType, int i11, String str, boolean z11) {
            super(tradeType, i11, str, z11);
        }

        /* renamed from: b */
        public void onNext(AlgoOrderResult algoOrderResult) {
            super.onNext(algoOrderResult);
            k.o("PLAN_TRADE", "AlgoOrderResult - " + algoOrderResult);
            a(algoOrderResult.getClientOrderId(), (List<String>) null);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            if (th2 instanceof TimeoutException) {
                HuobiToastUtil.k(j.c(), R.string.string_order_op_timeout);
            } else {
                HuobiToastUtil.k(j.c(), R.string.string_order_op_fail);
            }
        }
    }

    public class e<T> extends EasySubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public String f84053b;

        /* renamed from: c  reason: collision with root package name */
        public TradeType f84054c;

        /* renamed from: d  reason: collision with root package name */
        public int f84055d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f84056e;

        /* renamed from: f  reason: collision with root package name */
        public long f84057f;

        public e(TradeType tradeType, int i11, String str, boolean z11) {
            this.f84054c = tradeType;
            this.f84055d = i11;
            this.f84053b = str;
            this.f84056e = z11;
        }

        public void a(String str, List<String> list) {
            System.currentTimeMillis();
            if (com.hbg.lib.core.util.b.c().f()) {
                d3.this.I().F(0, !o.B().P());
            } else {
                d3.this.I().Yb(0, !o.B().P(), this.f84056e);
            }
            boolean z11 = o.B().F() != null && this.f84053b.equals(o.B().F().getSymbolCode());
            if (o.B().S() && this.f84056e && this.f84055d == 0 && z11) {
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
                d3.this.I().J(sb2.toString());
            }
            HuobiToastUtil.t(j.c(), R.string.string_order_op_ok);
            s6.a.b(j.c()).c(R.raw.order_success);
            EventBus.d().k(new AssetAndOrderUpdateEvent());
            EventBus.d().k(new mq.a(str));
        }

        public void onAfter() {
            d3.this.I().dismissProgressDialog();
            super.onAfter();
            boolean S = a1.v().S(this.f84053b);
            if (S && this.f84056e) {
                dh.c.g("prime");
            }
            if (S) {
                GrowingIOStatics.g(o.B().z(), this.f84056e);
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
            this.f84057f = System.currentTimeMillis();
            d3.this.I().showProgressDialog();
        }
    }

    public class f extends e<PrimeBidOrderPlaceResult> {
        public f(TradeType tradeType, int i11, String str, boolean z11) {
            super(tradeType, i11, str, z11);
        }

        /* renamed from: b */
        public void onNext(PrimeBidOrderPlaceResult primeBidOrderPlaceResult) {
            super.onNext(primeBidOrderPlaceResult);
            a(primeBidOrderPlaceResult.getId(), primeBidOrderPlaceResult.getBidIds());
        }
    }

    public class g extends e<AutoOrderResult> {
        public g(TradeType tradeType, int i11, String str, boolean z11) {
            super(tradeType, i11, str, z11);
        }

        /* renamed from: b */
        public void onNext(AutoOrderResult autoOrderResult) {
            super.onNext(autoOrderResult);
            a((String) null, (List<String>) null);
        }
    }

    public class h extends e<String> {
        public h(TradeType tradeType, int i11, String str, boolean z11) {
            super(tradeType, i11, str, z11);
        }

        /* renamed from: b */
        public void onNext(String str) {
            super.onNext(str);
            a(str, (List<String>) null);
            if (this.f84054c == TradeType.PRO) {
                int i11 = this.f84055d;
                if (i11 == 0 || i11 == 1) {
                    tg.d.g().p();
                }
            }
        }
    }

    public d3(h1 h1Var) {
        this.f84022a = new WeakReference<>(h1Var);
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

    public static Map<String, Object> H(long j11, String str, OrderPlaceBean orderPlaceBean) {
        if (orderPlaceBean.getTradeViewType() == 3) {
            return s(j11, str, orderPlaceBean);
        }
        Map<String, Object> b11 = MapParamsBuilder.c().a("symbol", orderPlaceBean.getSymbol()).a("source", str).a("type", orderPlaceBean.getOrderType()).a(FirebaseAnalytics.Param.PRICE, orderPlaceBean.getPrice()).a("account-id", Long.valueOf(j11)).b();
        if (orderPlaceBean.getTradeViewType() != 1) {
            b11.put("amount", orderPlaceBean.getAmount());
            b11.put("market-amount", "0");
        } else if (orderPlaceBean.isBuy()) {
            if (orderPlaceBean.isSelectedMarketAmount()) {
                b11.put("market-amount", orderPlaceBean.getMarketAmountText());
                b11.put("amount", "0");
            } else {
                b11.put("amount", orderPlaceBean.getAmount());
                b11.put("market-amount", "0");
            }
        } else if (orderPlaceBean.isSelectedMarketAmount()) {
            b11.put("amount", orderPlaceBean.getAmount());
            b11.put("market-amount", "0");
        } else {
            b11.put("market-amount", orderPlaceBean.getMarketAmountText());
            b11.put("amount", "0");
        }
        if (orderPlaceBean.getTradeViewType() == 2) {
            b11.put("stop-price", orderPlaceBean.getStopPrice());
            b11.put("operator", orderPlaceBean.getOperator());
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
        if (orderPlaceBean.getCouponId() != 0) {
            b11.put("coupon-id", Long.valueOf(orderPlaceBean.getCouponId()));
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getIceAmount())) {
            b11.put("ice-amount", orderPlaceBean.getIceAmount());
        }
        k.d(ServiceStat.NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID, "币币委托下单:" + new Gson().toJson((Object) b11));
        return b11;
    }

    public static /* synthetic */ Observable L(OrderPlaceBean orderPlaceBean, String str, Long l11) {
        Map<String, Object> H = H(l11.longValue(), "spot-android", orderPlaceBean);
        k.f("PLAN_TRADE", "accountType - " + str + " params - " + H);
        return x8.a.a().algoOrder(H).b();
    }

    public static /* synthetic */ Observable M(OrderPlaceBean orderPlaceBean, Long l11) {
        if (l11 == null) {
            return Observable.empty();
        }
        return v7.b.a().potentialOrderPlace(C(l11.longValue(), "spot-android", orderPlaceBean)).b();
    }

    public static /* synthetic */ Observable P(OrderPlaceBean orderPlaceBean, Long l11) {
        if (l11 == null) {
            return Observable.empty();
        }
        return v7.b.a().orderPlaceAuto(B(l11, "margin-android", orderPlaceBean)).b();
    }

    public static /* synthetic */ Observable Q(OrderPlaceBean orderPlaceBean, Long l11) {
        if (l11 == null) {
            return Observable.empty();
        }
        return v7.b.a().orderPlaceAuto(B(l11, "super-margin-android", orderPlaceBean)).b();
    }

    public static /* synthetic */ Observable S(OrderPlaceBean orderPlaceBean, Long l11) {
        Class cls = PrimeService.class;
        Map<String, Object> H = H(l11.longValue(), "spot-android", orderPlaceBean);
        if (!o.B().Q() || !orderPlaceBean.isBuy()) {
            return ((PrimeService) p.C(cls)).orderPlace(H);
        }
        return ((PrimeService) p.C(cls)).luckyOrderPlace(H);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity, HBDialogFragment hBDialogFragment) {
        u0(tradeType, orderPlaceBean, activity);
        hBDialogFragment.dismiss();
    }

    public static Map<String, Object> s(long j11, String str, OrderPlaceBean orderPlaceBean) {
        HashMap hashMap = new HashMap();
        if (orderPlaceBean.getCouponId() != 0) {
            hashMap.put("couponId", Long.valueOf(orderPlaceBean.getCouponId()));
        }
        hashMap.put("accountId", Long.valueOf(j11));
        hashMap.put("source", "android");
        hashMap.put("symbol", orderPlaceBean.getSymbol());
        hashMap.put("orderSide", orderPlaceBean.isBuy() ? "buy" : "sell");
        hashMap.put("stopPrice", orderPlaceBean.getStopPrice());
        if (2 == orderPlaceBean.getPlanTradeMarketMode()) {
            hashMap.put("orderType", PrimeRounds.ROUND_TRADE_MARKET_TYPE);
            if (orderPlaceBean.isBuy()) {
                hashMap.put("orderValue", orderPlaceBean.getAmount());
            } else {
                hashMap.put("orderSize", orderPlaceBean.getAmount());
            }
        } else {
            hashMap.put("orderType", "limit");
            hashMap.put("orderPrice", orderPlaceBean.getPrice());
            hashMap.put("orderSize", orderPlaceBean.getAmount());
        }
        if (!TextUtils.isEmpty(orderPlaceBean.getIceAmount())) {
            hashMap.put("iceAmount", orderPlaceBean.getIceAmount());
        }
        return hashMap;
    }

    public MarginLoanAsset A(String str) {
        return this.f84029h.get(str);
    }

    public BigDecimal D() {
        return this.f84033l;
    }

    public String E(TradeType tradeType, String str, boolean z11) {
        Map map = this.f84023b.get(Integer.valueOf(u(tradeType)));
        if (map == null) {
            return "0.00";
        }
        String str2 = (String) map.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str));
        if (str2 == null) {
            return "0.00";
        }
        return str2;
    }

    public Map<String, String> F(TradeType tradeType, int i11) {
        if (i11 == 1 || i11 == 3) {
            return this.f84026e.get(Integer.valueOf(u(tradeType)));
        }
        return this.f84027f.get(Integer.valueOf(u(tradeType)));
    }

    public BigDecimal G(TradeType tradeType, String str, boolean z11, int i11) {
        Map<String, String> F = F(tradeType, i11);
        if (F == null) {
            return BigDecimal.ZERO;
        }
        return m.a(F.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str)));
    }

    public final h1 I() {
        return (h1) this.f84022a.get();
    }

    public boolean J(TradeType tradeType, String str, int i11, String str2, String str3, boolean z11, boolean z12, String str4, int i12, int i13) {
        BigDecimal bigDecimal;
        BigDecimal a11 = m.a(str2);
        BigDecimal a12 = m.a(str3);
        if (a12.compareTo(BigDecimal.ZERO) <= 0) {
            return true;
        }
        if (z11 && ((i11 == 0 || i11 == 2) && !a1.v().S(str))) {
            a12 = a11.multiply(a12);
        } else if (i11 == 3 && z11 && i13 == 1) {
            a12 = a11.multiply(a12);
        }
        if (TradeType.PRO == tradeType) {
            if (!a1.v().S(str) || !z11) {
                bigDecimal = x(tradeType, str, z11);
            } else if (str4 != null) {
                bigDecimal = m.a(str4).compareTo(x(tradeType, str, z11)) < 0 ? m.a(str4) : x(tradeType, str, z11);
            } else {
                bigDecimal = BigDecimal.ZERO;
            }
        } else if (TradeType.MARGIN == tradeType) {
            bigDecimal = z(str, z11, i12);
        } else if (TradeType.C2C == tradeType) {
            bigDecimal = w(str, z11);
        } else {
            bigDecimal = G(tradeType, str, z11, i12);
        }
        if (!z12 || i11 == 3 || a12.compareTo(bigDecimal) <= 0) {
            return true;
        }
        return false;
    }

    public final void K(TradeType tradeType, OrderPlaceBean orderPlaceBean, String str, String str2, Activity activity) {
        boolean z11;
        String str3;
        int tradeViewType = orderPlaceBean.getTradeViewType();
        if (tradeViewType == 0) {
            z11 = u0.a();
        } else if (tradeViewType == 1) {
            z11 = u0.b();
        } else if (tradeViewType == 2) {
            z11 = u0.d();
        } else if (tradeViewType != 3) {
            z11 = false;
        } else {
            z11 = u0.c();
        }
        if (z11) {
            if (tradeType == TradeType.MARGIN) {
                str3 = j.c().getString(R.string.n_contract_trade_margin);
            } else if (tradeType == TradeType.SUPERMARGIN) {
                str3 = j.c().getString(R.string.n_contract_super_margin);
            } else {
                str3 = "";
            }
            TradeSpotOrderConfirmFragment vh2 = TradeSpotOrderConfirmFragment.vh(str3, orderPlaceBean);
            vh2.show(((FragmentActivity) activity).getSupportFragmentManager(), "");
            vh2.wh(new c(tradeType, orderPlaceBean, str, str2));
        } else if (!ks.g.j() || !(tradeType == TradeType.MARGIN || tradeType == TradeType.SUPERMARGIN)) {
            c0(tradeType, orderPlaceBean, str, str2);
        } else {
            d0(tradeType, orderPlaceBean);
        }
    }

    public boolean W(TradeType tradeType, String str, int i11, String str2, String str3, boolean z11, BigDecimal bigDecimal, boolean z12, String str4, String str5, int i12, int i13) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        boolean z13;
        String str6;
        String str7;
        TradeType tradeType2 = tradeType;
        String str8 = str;
        int i14 = i11;
        boolean z14 = z11;
        BigDecimal bigDecimal4 = bigDecimal;
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
        if (!z14 || (!(i14 == 0 || i14 == 2) || a1.v().S(str8))) {
            bigDecimal2 = (i14 == 3 && z14 && i16 == 1) ? a12.multiply(a13) : a13;
        } else {
            bigDecimal2 = a12.multiply(a13);
        }
        ExchangeSettings b11 = ExchangeSettingsController.d().b(str8);
        String str9 = "0.9";
        String str10 = "1.1";
        if (!a1.v().S(str8) && i14 == 0 && bigDecimal4.compareTo(BigDecimal.ZERO) != 0) {
            if (b11 != null) {
                str7 = b11.getBuyLimitMustLessThan();
                str6 = b11.getSellLimitMustGreaterThan();
            } else {
                str6 = str9;
                str7 = str10;
            }
            if (z14 && a12.compareTo(bigDecimal4.multiply(m.a(str7))) > 0) {
                HuobiToastUtil.m(String.format(j.c().getString(R.string.n_trade_buy_price_high), new Object[]{m.Q(str7, 0, 1)}));
                return false;
            } else if (!z14 && a12.compareTo(bigDecimal4.multiply(m.a(str6))) < 0) {
                HuobiToastUtil.m(String.format(j.c().getString(R.string.n_trade_sell_price_low), new Object[]{m.Q(str6, 0, 1)}));
                return false;
            }
        }
        if (TradeType.PRO == tradeType2) {
            if (!a1.v().S(str8) || !z14) {
                bigDecimal3 = x(tradeType2, str8, z14);
            } else if (str5 != null) {
                bigDecimal3 = m.a(str5).compareTo(x(tradeType2, str8, z14)) < 0 ? m.a(str5) : x(tradeType2, str8, z14);
            } else {
                bigDecimal3 = BigDecimal.ZERO;
            }
        } else if (TradeType.MARGIN == tradeType2) {
            bigDecimal3 = z(str8, z14, i15);
        } else if (TradeType.C2C == tradeType2) {
            bigDecimal3 = w(str8, z14);
        } else {
            bigDecimal3 = G(tradeType2, str8, z14, i15);
        }
        if (!z12) {
            return false;
        }
        if (i14 != 3 && bigDecimal2.compareTo(bigDecimal3) > 0) {
            return false;
        }
        if (i14 == 2) {
            if (a11.compareTo(m.a(str2)) == 0) {
                HuobiToastUtil.m(j.c().getString(R.string.trade_trend_trigger_price_tips));
                return false;
            }
            float floatValue = a12.divide(a11, 2, 4).floatValue();
            if (b11 != null) {
                str10 = b11.getBuyLimitMustLessThan();
                str9 = b11.getSellLimitMustGreaterThan();
            }
            String str11 = str9;
            String str12 = str10;
            if (z14 && floatValue > m.a(str12).floatValue()) {
                HuobiToastUtil.m(String.format(j.c().getString(R.string.n_trade_buy_stop_price_high), new Object[]{m.Q(str12, 0, 1)}));
                return false;
            } else if (!z14 && floatValue < m.a(str11).floatValue()) {
                HuobiToastUtil.m(String.format(j.c().getString(R.string.n_trade_sell_stop_price_low), new Object[]{m.Q(str11, 0, 1)}));
                return false;
            }
        }
        if (i14 == 3 && i16 == 1) {
            if (a11.compareTo(BigDecimal.ZERO) == 0) {
                return false;
            }
            float floatValue2 = a12.divide(a11, 2, 4).floatValue();
            if (z14 && floatValue2 > 1.1f) {
                HuobiToastUtil.m(j.c().getString(R.string.trade_trend_trigger_price_hight_tips));
                return false;
            } else if (!z14 && floatValue2 < 0.9f) {
                HuobiToastUtil.m(j.c().getString(R.string.trade_trend_trigger_price_low_tips));
                return false;
            }
        }
        if (I().z6()) {
            String Wf = I().Wf();
            if (TextUtils.isEmpty(Wf)) {
                HuobiToastUtil.m(j.c().getString(R.string.n_trade_iceberg_input_tips));
                return false;
            }
            BigDecimal bigDecimal5 = BigDecimal.ZERO;
            if (!(i14 == 0 || i14 == 2) || a1.v().S(str8)) {
                if (i14 == 3) {
                    if (z14 && (!z14 || i16 != 1)) {
                        if (bigDecimal4.compareTo(BigDecimal.ZERO) != 0) {
                            a13 = a13.divide(bigDecimal4, 32, 1);
                        }
                    }
                } else if (bigDecimal4.compareTo(BigDecimal.ZERO) != 0) {
                    a13 = a13.divide(bigDecimal4, 32, 1);
                }
                a13 = bigDecimal5;
            }
            if (bigDecimal4.compareTo(BigDecimal.ZERO) == 0 && a13.compareTo(BigDecimal.ZERO) == 0) {
                HuobiToastUtil.m(j.c().getString(R.string.n_can_not_get_price));
                return false;
            }
            z13 = false;
            BigDecimal a14 = m.a(Wf);
            if (a14.compareTo(a13) > 0) {
                HuobiToastUtil.m(j.c().getString(R.string.n_trade_iceberg_amount_too_long_tips));
                return false;
            } else if (a14.multiply(BigDecimal.TEN).compareTo(a13) < 0) {
                HuobiToastUtil.m(j.c().getString(R.string.n_trade_iceberg_amount_too_short_tips));
                return false;
            }
        } else {
            z13 = false;
        }
        if (NetworkStatus.c(j.c())) {
            return true;
        }
        HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
        return z13;
    }

    public OrderPlaceBean X(TradeType tradeType, String str, int i11, String str2, String str3, boolean z11, String str4, BigDecimal bigDecimal, int i12, CouponReturn couponReturn) {
        String str5;
        String str6;
        OrderPlaceBean orderPlaceBean = new OrderPlaceBean();
        orderPlaceBean.setSymbol(str);
        orderPlaceBean.setTradeViewType(i11);
        if (i11 == 0 || i11 == 7 || i11 == 2 || i11 == 3) {
            orderPlaceBean.setPrice(str2);
        }
        orderPlaceBean.setAmount(str3);
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
            BigDecimal bigDecimal2 = this.f84032k;
            if (bigDecimal2 == null) {
                orderPlaceBean.setPredictAmount("--");
            } else {
                orderPlaceBean.setPredictAmount(bigDecimal2.divide(bigDecimal, PrecisionUtil.z(str), 1).toPlainString());
            }
        } else {
            BigDecimal bigDecimal3 = this.f84033l;
            if (bigDecimal3 == null) {
                orderPlaceBean.setPredictAmount("--");
            } else {
                orderPlaceBean.setPredictAmount(bigDecimal3.divide(bigDecimal, PrecisionUtil.z(str), 1).toPlainString());
            }
        }
        if (tradeType == TradeType.SUPERMARGIN) {
            MarginLoanAsset marginLoanAsset = null;
            if (i12 == 1 || i12 == 3) {
                if (z11) {
                    str5 = a1.v().D(str);
                } else {
                    str5 = a1.v().n(str);
                }
                marginLoanAsset = A(str5);
            } else if (i12 == 2) {
                if (z11) {
                    str6 = a1.v().n(str);
                } else {
                    str6 = a1.v().D(str);
                }
                marginLoanAsset = A(str6);
            }
            if (marginLoanAsset == null) {
                orderPlaceBean.setInterestRate("--");
            } else if (TextUtils.isEmpty(marginLoanAsset.getInterestRate())) {
                orderPlaceBean.setInterestRate(marginLoanAsset.getInterestRate());
            } else {
                orderPlaceBean.setInterestRate(m.Q(marginLoanAsset.getInterestRate(), PrecisionUtil.l(), 1));
            }
        } else if (tradeType == TradeType.MARGIN) {
            MarginSettings marginSettings = this.f84030i.get(str);
            boolean z12 = false;
            boolean z13 = (i12 == 1 || i12 == 3) ? !z11 : i12 == 2 ? z11 : false;
            if (marginSettings != null) {
                if (!z13 ? TextUtils.isEmpty(marginSettings.getDayQuoteCurrencyInterestRate()) : TextUtils.isEmpty(marginSettings.getDayBaseCurrencyInterestRate())) {
                    z12 = true;
                }
                if (z12) {
                    orderPlaceBean.setInterestRate("");
                } else {
                    orderPlaceBean.setInterestRate(marginSettings.formatDeductedRate(z13));
                }
            } else {
                orderPlaceBean.setInterestRate("--");
            }
        }
        if (z11) {
            BigDecimal bigDecimal4 = this.f84034m;
            if (bigDecimal4 == null) {
                orderPlaceBean.setLoanAmount("--");
            } else {
                orderPlaceBean.setLoanAmount(bigDecimal4.toPlainString());
            }
            BigDecimal bigDecimal5 = this.f84035n;
            if (bigDecimal5 == null) {
                orderPlaceBean.setRepayAmount("--");
            } else {
                orderPlaceBean.setRepayAmount(bigDecimal5.toPlainString());
            }
            BigDecimal bigDecimal6 = this.f84038q;
            if (bigDecimal6 == null) {
                orderPlaceBean.setLoanAmountAndInterest("--");
            } else {
                orderPlaceBean.setLoanAmountAndInterest(bigDecimal6.toPlainString());
            }
        } else {
            BigDecimal bigDecimal7 = this.f84036o;
            if (bigDecimal7 == null) {
                orderPlaceBean.setLoanAmount("--");
            } else {
                orderPlaceBean.setLoanAmount(bigDecimal7.toPlainString());
            }
            BigDecimal bigDecimal8 = this.f84037p;
            if (bigDecimal8 == null) {
                orderPlaceBean.setRepayAmount("--");
            } else {
                orderPlaceBean.setRepayAmount(bigDecimal8.toPlainString());
            }
            BigDecimal bigDecimal9 = this.f84039r;
            if (bigDecimal9 == null) {
                orderPlaceBean.setLoanAmountAndInterest("--");
            } else {
                orderPlaceBean.setLoanAmountAndInterest(bigDecimal9.toPlainString());
            }
        }
        if (z11 || i11 != 1) {
            if (z11) {
                BigDecimal bigDecimal10 = this.f84032k;
                if (bigDecimal10 == null) {
                    orderPlaceBean.setVolume("--");
                } else {
                    orderPlaceBean.setVolume(bigDecimal10.toPlainString());
                }
            } else {
                BigDecimal bigDecimal11 = this.f84033l;
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
        if (couponReturn != null) {
            orderPlaceBean.setCouponId(couponReturn.getId());
        }
        return orderPlaceBean;
    }

    public void Y(TradeType tradeType, OrderPlaceBean orderPlaceBean) {
        if (orderPlaceBean != null) {
            if (!NetworkStatus.c(j.c())) {
                HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
                return;
            }
            h2.t1().b1(tradeType, AccountType.spot.toString()).flatMap(new x2(orderPlaceBean)).compose(RxJavaHelper.t(I())).subscribe(new h(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
        }
    }

    public void Z(String str, MarginLoanAsset marginLoanAsset) {
        this.f84029h.put(str, marginLoanAsset);
    }

    public void a0(String str, MarginSettings marginSettings) {
        this.f84030i.put(str, marginSettings);
    }

    public void b0(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        if (orderPlaceBean != null) {
            if (!NetworkStatus.c(j.c())) {
                HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
            } else if (TradeType.PRO == tradeType) {
                if (a1.v().S(orderPlaceBean.getSymbol())) {
                    e0(tradeType, orderPlaceBean);
                    return;
                }
                K(tradeType, orderPlaceBean, AccountType.spot.toString(), "spot-android", activity);
            } else if (TradeType.MARGIN == tradeType) {
                K(tradeType, orderPlaceBean, AccountType.margin.toString(), "margin-android", activity);
            } else if (TradeType.SUPERMARGIN == tradeType) {
                K(tradeType, orderPlaceBean, AccountType.supermargin.toString(), "super-margin-android", activity);
            } else if (TradeType.C2C == tradeType) {
                K(tradeType, orderPlaceBean, AccountType.borrow.toString(), "c2c-margin-android", activity);
            }
        }
    }

    public final void c0(TradeType tradeType, OrderPlaceBean orderPlaceBean, String str, String str2) {
        if (orderPlaceBean.getTradeViewType() == 3) {
            p(tradeType, orderPlaceBean, str);
        } else if (tradeType == TradeType.PRO || tradeType == TradeType.SUPERMARGIN) {
            h2.t1().b1(tradeType, str).flatMap(new c3(str2, orderPlaceBean)).compose(p.a0()).compose(RxJavaHelper.t(I())).subscribe(new h(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
        } else if (tradeType == TradeType.C2C || tradeType == TradeType.MARGIN) {
            h2.t1().D1(str, orderPlaceBean.getSymbol()).flatMap(new t2(str2, orderPlaceBean)).compose(p.a0()).compose(RxJavaHelper.t(I())).subscribe(new h(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
        }
    }

    public final void d0(TradeType tradeType, OrderPlaceBean orderPlaceBean) {
        if (orderPlaceBean.getAutoType() == 2) {
            orderPlaceBean.setLoanAmount("");
        }
        if (TradeType.MARGIN == tradeType) {
            h2.t1().D1(AccountType.margin.toString(), orderPlaceBean.getSymbol()).flatMap(new y2(orderPlaceBean)).compose(RxJavaHelper.t(I())).subscribe(new g(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
        } else if (TradeType.SUPERMARGIN == tradeType) {
            h2.t1().b1(tradeType, AccountType.supermargin.toString()).flatMap(new z2(orderPlaceBean)).compose(RxJavaHelper.t(I())).subscribe(new g(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
        }
    }

    public final void e0(TradeType tradeType, OrderPlaceBean orderPlaceBean) {
        if (!o.B().U() || !orderPlaceBean.isBuy()) {
            h2.t1().b1(tradeType, AccountType.spot.toString()).flatMap(new a3(orderPlaceBean)).compose(p.D()).compose(RxJavaHelper.t(I())).subscribe(new h(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
            return;
        }
        h2.t1().b1(tradeType, AccountType.spot.toString()).flatMap(new w2(orderPlaceBean)).compose(p.D()).compose(RxJavaHelper.t(I())).subscribe(new f(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
    }

    public void f0(TradeType tradeType, Map<String, String> map) {
        this.f84023b.put(Integer.valueOf(u(tradeType)), map);
    }

    public void g0(BigDecimal bigDecimal) {
        this.f84034m = bigDecimal;
    }

    public void h0(BigDecimal bigDecimal) {
        this.f84038q = bigDecimal;
    }

    public void i0(BigDecimal bigDecimal) {
        this.f84035n = bigDecimal;
    }

    public void j0(BigDecimal bigDecimal) {
        this.f84032k = bigDecimal;
    }

    public void k0(String str, Map<String, String> map) {
        this.f84024c.put(str, map);
    }

    public void l0(String str, Map<String, String> map) {
        this.f84025d.put(str, map);
    }

    public void m0(BigDecimal bigDecimal) {
        this.f84036o = bigDecimal;
    }

    public void n0(BigDecimal bigDecimal) {
        this.f84039r = bigDecimal;
    }

    public void o0(BigDecimal bigDecimal) {
        this.f84037p = bigDecimal;
    }

    public final void p(TradeType tradeType, OrderPlaceBean orderPlaceBean, String str) {
        Observable<Long> observable;
        if (TradeType.C2C == tradeType || TradeType.MARGIN == tradeType) {
            observable = h2.t1().D1(str, orderPlaceBean.getSymbol());
        } else {
            observable = h2.t1().b1(tradeType, str);
        }
        observable.flatMap(new b3(orderPlaceBean, str)).compose(RxJavaHelper.t(I())).subscribe(new d(tradeType, orderPlaceBean.getTradeViewType(), orderPlaceBean.getSymbol(), orderPlaceBean.isBuy()));
    }

    public void p0(BigDecimal bigDecimal) {
        this.f84033l = bigDecimal;
    }

    public boolean q(TradeType tradeType, String str, boolean z11) {
        Map map = this.f84023b.get(Integer.valueOf(u(tradeType)));
        if (map == null) {
            return false;
        }
        if (((String) map.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str))) != null) {
            return true;
        }
        return false;
    }

    public void q0(TradeType tradeType, Map<String, String> map) {
        this.f84027f.put(Integer.valueOf(u(tradeType)), map);
    }

    public void r() {
        this.f84023b.clear();
        this.f84024c.clear();
        this.f84025d.clear();
        this.f84026e.clear();
        this.f84027f.clear();
        this.f84028g.clear();
    }

    public void r0(TradeType tradeType, Map<String, String> map) {
        this.f84026e.put(Integer.valueOf(u(tradeType)), map);
    }

    public void s0(TradeType tradeType, SymbolBean symbolBean, OrderPlaceBean orderPlaceBean, Activity activity, View.OnClickListener onClickListener, OrderConfirmBottomRemindSheetDialogFragment.a aVar) {
        ArrayList arrayList = new ArrayList();
        String displayPrice = orderPlaceBean.getDisplayPrice();
        String displayAmount = orderPlaceBean.getDisplayAmount();
        OrderConfirmBean orderConfirmBean = new OrderConfirmBean();
        String p11 = a1.v().p(orderPlaceBean.getSymbol());
        String F = a1.v().F(orderPlaceBean.getSymbol());
        orderConfirmBean.setTitle(activity.getString(R.string.n_exchange_call_auction_order_confirm_title));
        OrderConfirmBean.ListItem listItem = new OrderConfirmBean.ListItem();
        listItem.setKey(activity.getString(R.string.n_exchange_call_auction_order_symbol));
        listItem.setValue(a1.v().W(orderPlaceBean.getSymbol()));
        listItem.setValueColor(ContextCompat.getColor(activity, R.color.baseColorMajorTheme100));
        arrayList.add(listItem);
        OrderConfirmBean.ListItem listItem2 = new OrderConfirmBean.ListItem();
        listItem2.setKey(activity.getString(R.string.n_exchange_call_auction_order_price));
        listItem2.setValue(displayPrice + " " + F);
        arrayList.add(listItem2);
        OrderConfirmBean.ListItem listItem3 = new OrderConfirmBean.ListItem();
        listItem3.setKey(activity.getString(R.string.n_exchange_order_list_amount));
        listItem3.setValue(displayAmount + " " + p11);
        arrayList.add(listItem3);
        OrderConfirmBean.ListItem listItem4 = new OrderConfirmBean.ListItem();
        listItem4.setKey(activity.getString(R.string.n_mining_type));
        listItem4.setValue(activity.getString(R.string.n_exchange_order_normal_entrusts));
        arrayList.add(listItem4);
        orderConfirmBean.setList(arrayList);
        if (symbolBean.isCallAuctionOne()) {
            orderConfirmBean.setHint(String.format(Locale.ENGLISH, activity.getString(R.string.n_exchange_call_auction_order_confirm_first_hint, new Object[]{symbolBean.getSymbolName()}), new Object[0]));
        } else if (symbolBean.isCallAuctionTwo()) {
            orderConfirmBean.setHint(String.format(Locale.ENGLISH, activity.getString(R.string.n_exchange_call_auction_order_confirm_second_hint, new Object[]{symbolBean.getSymbolName()}), new Object[0]));
        }
        orderConfirmBean.setConfirmBtnText(activity.getString(R.string.n_exchange_call_auction_order_line_up_confirm));
        OrderConfirmBottomRemindSheetDialogFragment vh2 = OrderConfirmBottomRemindSheetDialogFragment.vh(orderConfirmBean, onClickListener, aVar);
        this.f84040s = vh2;
        vh2.show(((FragmentActivity) activity).getSupportFragmentManager(), "OrderConfirmBottomRemindSheetDialogFragment");
    }

    public void t() {
        Dialog dialog = this.f84031j;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void t0(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        SymbolBean J = a1.v().J(orderPlaceBean.getSymbol(), tradeType);
        if (J.isCallAuction()) {
            boolean b11 = ConfigPreferences.b("user_config", "config_call_auction_first_confirm");
            boolean b12 = ConfigPreferences.b("user_config", "config_call_auction_second_confirm");
            if ((!J.isCallAuctionOne() || b11) && (!J.isCallAuctionTwo() || b12)) {
                u0(tradeType, orderPlaceBean, activity);
                return;
            }
            SymbolBean symbolBean = J;
            s0(tradeType, symbolBean, orderPlaceBean, activity, new a(), new b(symbolBean, tradeType, orderPlaceBean, activity));
            return;
        }
        CallAuction b13 = ys.a.b(orderPlaceBean.getSymbol());
        if (b13 != null && b13.isCallAuction()) {
            if (!ConfigPreferences.b("user_config", "config_call_auction_third_confirm_" + orderPlaceBean.getSymbol())) {
                new DialogUtils.b.d((FragmentActivity) activity).c1(activity.getString(R.string.n_exchange_call_auction_order_line_up_title)).C0(activity.getString(R.string.n_exchange_call_auction_order_line_up_hint)).P0(activity.getString(R.string.n_exchange_call_auction_order_line_up_confirm)).x0(true).v0(new s2(orderPlaceBean)).y0(activity.getString(R.string.n_exchange_call_auction_order_confirm_not_remind)).z0(Integer.valueOf(ContextCompat.getColor(activity, R.color.baseColorPrimaryText))).s0(activity.getString(R.string.n_cancel)).Q0(new u2(this, tradeType, orderPlaceBean, activity)).N0(v2.f54176a).k0().show(((FragmentActivity) activity).getSupportFragmentManager(), "");
                return;
            }
        }
        u0(tradeType, orderPlaceBean, activity);
    }

    public int u(TradeType tradeType) {
        return TradeType.SUPERMARGIN == tradeType ? 4 : 2;
    }

    public void u0(TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        if (a1.v().q0(orderPlaceBean.getSymbol(), tradeType)) {
            Y(tradeType, orderPlaceBean);
        } else {
            b0(tradeType, orderPlaceBean, activity);
        }
    }

    public BigDecimal v() {
        return this.f84032k;
    }

    public BigDecimal w(String str, boolean z11) {
        Map map = this.f84028g.get(str);
        if (map == null) {
            return BigDecimal.ZERO;
        }
        return m.a((String) map.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str)));
    }

    public BigDecimal x(TradeType tradeType, String str, boolean z11) {
        Map map = this.f84023b.get(Integer.valueOf(u(tradeType)));
        if (map == null) {
            return BigDecimal.ZERO;
        }
        return m.a((String) map.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str)));
    }

    public Map<String, String> y(String str, int i11) {
        if (i11 == 1 || i11 == 3) {
            return this.f84024c.get(str);
        }
        return this.f84025d.get(str);
    }

    public BigDecimal z(String str, boolean z11, int i11) {
        Map<String, String> y11 = y(str, i11);
        if (y11 == null) {
            return BigDecimal.ZERO;
        }
        return m.a(y11.get(z11 ? SymbolUtil.a(str) : SymbolUtil.b(str)));
    }
}
