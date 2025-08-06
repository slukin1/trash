package com.huobi.homemarket.handler;

import a7.e;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.NumberKlineUtil;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.CurrencyIntroInfo;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.index.core.util.ContractIndexPrecisionUtil;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$dimen;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.model.MgtExpandKlineBean;
import com.huobi.store.AppConfigManager;
import com.luck.picture.lib.config.PictureMimeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import de.h1;
import de.j0;
import de.q;
import de.r;
import de.t;
import de.v;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import ml.b;
import ql.f;
import ql.g;
import ql.h;
import rx.schedulers.Schedulers;
import td.i;

public abstract class AbsMarketViewHandler<T extends ml.b> implements s9.c {

    /* renamed from: e  reason: collision with root package name */
    public static AccelerateDecelerateInterpolator f72701e = new AccelerateDecelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    public static final float f72702f;

    /* renamed from: g  reason: collision with root package name */
    public static final float[] f72703g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f72704b;

    /* renamed from: c  reason: collision with root package name */
    public int f72705c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Double> f72706d;

    public class a implements q.e {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v9.c f72707b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ml.b f72708c;

        public a(v9.c cVar, ml.b bVar) {
            this.f72707b = cVar;
            this.f72708c = bVar;
        }

        public void G(String str, String str2, KlineInfo klineInfo) {
        }

        public void G3(KlineInfo klineInfo) {
        }

        public /* synthetic */ void K(List list, int i11) {
            r.a(this, list, i11);
        }

        public void M(KlineInfo klineInfo) {
        }

        public void P(String str) {
        }

        public final void a(KlineInfo klineInfo) {
            TextView textView = (TextView) this.f72707b.itemView.findViewById(R$id.volume_sum_amount_text2);
            if (textView != null) {
                textView.setText(m.T(BigDecimal.valueOf(klineInfo.getClose()).multiply(BigDecimal.valueOf(klineInfo.getAmount())).toPlainString(), PrecisionUtil.z(AbsMarketViewHandler.this.w(this.f72708c))));
            }
        }

        public void s3(String str, String str2, KlineInfo klineInfo) {
            AbsMarketViewHandler.this.K(this.f72707b, this.f72708c, str, str2, klineInfo);
        }

        public void u(KlineInfo klineInfo) {
            TextView textView = (TextView) this.f72707b.itemView.findViewById(com.hbg.module.kline.R$id.volume_sum_text2);
            if (textView != null) {
                String tradeType = AbsMarketViewHandler.this.x(this.f72708c).toString();
                String w11 = AbsMarketViewHandler.this.w(this.f72708c);
                if (TradeType.isOption(tradeType)) {
                    if (e.E(TradeType.valueOf(tradeType))) {
                        textView.setText(m.c(m.L(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(w11)), "--"));
                        textView.append(w11);
                        return;
                    }
                    textView.setText(textView.getResources().getString(R$string.contract_24h_num_value, new Object[]{m.k(klineInfo.getVol(), PrecisionUtil.t(w11), true)}));
                } else if (TradeType.isLinearSwap(tradeType)) {
                    if (e.F(TradeType.valueOf(tradeType))) {
                        textView.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(w11)));
                    } else {
                        textView.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(w11)));
                    }
                    a(klineInfo);
                } else if (TradeType.isContract(tradeType)) {
                    if (e.E(TradeType.CONTRACT)) {
                        textView.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(w11)));
                    } else {
                        textView.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(w11)));
                    }
                    a(klineInfo);
                } else if (TradeType.isSwap(tradeType)) {
                    if (e.E(TradeType.SWAP)) {
                        textView.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(w11)));
                    } else {
                        textView.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(w11)));
                    }
                    a(klineInfo);
                }
            }
        }
    }

    public class b implements t.e {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v9.c f72710b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ml.b f72711c;

        public b(v9.c cVar, ml.b bVar) {
            this.f72710b = cVar;
            this.f72711c = bVar;
        }

        public void G(String str, String str2, KlineInfo klineInfo) {
        }

        public void G3(KlineInfo klineInfo) {
        }

        public void M(KlineInfo klineInfo) {
            TextView textView = (TextView) this.f72710b.itemView.findViewById(R$id.volume_sum_text2);
            TextView textView2 = (TextView) this.f72710b.itemView.findViewById(R$id.volume_sum_amount_text2);
            if (textView != null) {
                AbsMarketViewHandler absMarketViewHandler = AbsMarketViewHandler.this;
                if (absMarketViewHandler.R(absMarketViewHandler.x(this.f72711c))) {
                    textView.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.t(AbsMarketViewHandler.this.w(this.f72711c))));
                } else {
                    textView.setText(m.k(klineInfo.getAmount(), PrecisionUtil.t(AbsMarketViewHandler.this.w(this.f72711c)), true));
                }
            }
            if (textView2 != null) {
                textView2.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.z(AbsMarketViewHandler.this.w(this.f72711c))));
            }
        }

        public void s3(String str, String str2, KlineInfo klineInfo) {
            AbsMarketViewHandler.this.K(this.f72710b, this.f72711c, str, str2, klineInfo);
        }
    }

    public class c extends EasySubscriber<CurrencyIntroInfo> {

        /* renamed from: b  reason: collision with root package name */
        public String f72713b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f72714c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f72715d;

        public c(TextView textView, TextView textView2) {
            this.f72714c = textView;
            this.f72715d = textView2;
            this.f72713b = textView.getResources().getString(com.hbg.module.kline.R$string.global_crossbar);
        }

        /* renamed from: a */
        public void onNext(CurrencyIntroInfo currencyIntroInfo) {
            super.onNext(currencyIntroInfo);
            if (currencyIntroInfo != null) {
                this.f72714c.setText(TextUtils.isEmpty(currencyIntroInfo.getRank()) ? this.f72713b : currencyIntroInfo.getRank());
                if (TextUtils.isEmpty(currencyIntroInfo.getCurrency()) || TextUtils.isEmpty(currencyIntroInfo.getPublishVolume()) || !NumberKlineUtil.c(currencyIntroInfo.getPublishVolume())) {
                    this.f72715d.setText(this.f72713b);
                    return;
                }
                String T = m.T(LegalCurrencyConfigUtil.o(currencyIntroInfo.getCurrency(), currencyIntroInfo.getPublishVolume(), "usdt", TradeType.PRO), 2);
                if (TextUtils.isEmpty(T)) {
                    this.f72715d.setText(this.f72713b);
                } else {
                    this.f72715d.setText(T);
                }
            } else {
                if (TextUtils.isEmpty(this.f72714c.getText())) {
                    this.f72714c.setText(this.f72713b);
                }
                if (TextUtils.isEmpty(this.f72715d.getText())) {
                    this.f72715d.setText(this.f72713b);
                }
            }
        }

        public void onError2(Throwable th2) {
            if (TextUtils.isEmpty(this.f72714c.getText())) {
                this.f72714c.setText(this.f72713b);
            }
            if (TextUtils.isEmpty(this.f72715d.getText())) {
                this.f72715d.setText(this.f72713b);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (TextUtils.isEmpty(this.f72714c.getText())) {
                this.f72714c.setText(this.f72713b);
            }
            if (TextUtils.isEmpty(this.f72715d.getText())) {
                this.f72715d.setText(this.f72713b);
            }
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f72717a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f72717a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f72717a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f72717a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.homemarket.handler.AbsMarketViewHandler.d.<clinit>():void");
        }
    }

    static {
        float a11 = (float) DimenUtils.a(4.0f);
        f72702f = a11;
        f72703g = new float[]{a11, a11, a11, a11, a11, a11, a11, a11};
    }

    public AbsMarketViewHandler() {
        this.f72704b = false;
        this.f72706d = new HashMap();
        this.f72704b = T();
    }

    public static /* synthetic */ void C(ViewGroup.LayoutParams layoutParams, int i11, View view, ValueAnimator valueAnimator) {
        layoutParams.height = (int) (((float) i11) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
        view.requestLayout();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(View view, int i11) {
        int i12;
        Resources resources;
        if (this.f72704b) {
            resources = view.getContext().getResources();
            i12 = R$dimen.dimen_230;
        } else {
            resources = view.getContext().getResources();
            i12 = R$dimen.dimen_40;
        }
        l(view, resources.getDimensionPixelSize(i12) - i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void E(v9.c cVar, ml.b bVar, View view) {
        MarketModuleConfig.a().c((FragmentActivity) cVar.itemView.getContext(), w(bVar), true);
        HashMap hashMap = new HashMap();
        hashMap.put("TradePair_current_id", w(bVar));
        hashMap.put("Tradepair_class", x(bVar) == TradeType.PRO ? RankScreenBean.SCREEN_VALUE_SPOT : RankScreenBean.SCREEN_VALUE_FUTURE);
        hashMap.put("absinfo_action", "buy");
        nc.c.a("App_markets_list_absinfo_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void F(v9.c cVar, ml.b bVar, View view) {
        MarketModuleConfig.a().c((FragmentActivity) cVar.itemView.getContext(), w(bVar), false);
        HashMap hashMap = new HashMap();
        hashMap.put("TradePair_current_id", w(bVar));
        hashMap.put("Tradepair_class", x(bVar) == TradeType.PRO ? RankScreenBean.SCREEN_VALUE_SPOT : RankScreenBean.SCREEN_VALUE_FUTURE);
        hashMap.put("absinfo_action", "sell");
        nc.c.a("App_markets_list_absinfo_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void G(v9.c cVar, ml.b bVar, View view) {
        MarketModuleConfig.a().f((FragmentActivity) cVar.itemView.getContext(), w(bVar));
        HashMap hashMap = new HashMap();
        hashMap.put("TradePair_current_id", w(bVar));
        hashMap.put("Tradepair_class", x(bVar) == TradeType.PRO ? RankScreenBean.SCREEN_VALUE_SPOT : RankScreenBean.SCREEN_VALUE_FUTURE);
        hashMap.put("absinfo_action", "orders");
        nc.c.a("App_markets_list_absinfo_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void H(v9.c cVar, ml.b bVar, int i11, View view) {
        m(cVar, bVar, i11, false);
        HashMap hashMap = new HashMap();
        hashMap.put("TradePair_current_id", w(bVar));
        hashMap.put("Tradepair_class", x(bVar) == TradeType.PRO ? RankScreenBean.SCREEN_VALUE_SPOT : RankScreenBean.SCREEN_VALUE_FUTURE);
        hashMap.put("absinfo_action", "Kline");
        nc.c.a("App_markets_list_absinfo_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void I(ml.b bVar, View view) {
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        a11.k0("holigeit://open/v1?url=ihuobiglobal://m.hbg.com/contract/index?code=" + p(bVar));
        HashMap hashMap = new HashMap();
        hashMap.put("TradePair_current_id", w(bVar));
        hashMap.put("Tradepair_class", x(bVar) == TradeType.PRO ? RankScreenBean.SCREEN_VALUE_SPOT : RankScreenBean.SCREEN_VALUE_FUTURE);
        hashMap.put("absinfo_action", "futures");
        nc.c.a("App_markets_list_absinfo_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static String q(String str) {
        String j11 = BaseModuleConfig.a().j();
        if (j11 == null) {
            j11 = "";
        }
        return j11 + "/-/x/hb/p/api/contents/currency/icon_png/" + str.toLowerCase() + PictureMimeType.PNG;
    }

    public static int r() {
        if (NightHelper.e().g()) {
            return R$drawable.balances_currencyicon_night;
        }
        return R$drawable.balances_currencyicon;
    }

    public abstract boolean A(T t11);

    public void B(v9.c cVar, T t11, int i11) {
        if (this.f72704b) {
            M(cVar, t11, i11);
        } else {
            m(cVar, t11, i11, true);
        }
    }

    public void K(v9.c cVar, T t11, String str, String str2, KlineInfo klineInfo) {
        if (z(t11)) {
            View view = cVar.itemView;
            int i11 = R$id.high_price_text2;
            if (view.findViewById(i11) != null) {
                TextView textView = (TextView) cVar.itemView.findViewById(i11);
                TextView textView2 = (TextView) cVar.itemView.findViewById(R$id.low_price_text2);
                textView.setText(m.k(klineInfo.getHigh(), this.f72705c, true));
                textView2.setText(m.k(klineInfo.getLow(), this.f72705c, true));
                textView.setTextColor(textView.getResources().getColor(w.h()));
                textView2.setTextColor(textView2.getResources().getColor(w.d()));
            }
        }
    }

    public final int L(T t11) {
        TradeType x11 = x(t11);
        if (TradeType.isContract(x11)) {
            return i.a().b().z(p(t11));
        }
        if (TradeType.isSwap(x11)) {
            return i.a().b().B(v(t11));
        }
        if (TradeType.isContractIndex(x11)) {
            return ContractIndexPrecisionUtil.a(p(t11));
        }
        if (TradeType.isLinearSwap(x11)) {
            return FuturePrecisionUtil.y(p(t11), w(t11), "");
        }
        if (TradeType.isLinearSwapIndex(x11)) {
            return FuturePrecisionUtil.b(p(t11));
        }
        return PrecisionUtil.w(w(t11), x11);
    }

    public void M(v9.c cVar, T t11, int i11) {
        int i12;
        View view;
        if (this.f72704b) {
            view = cVar.itemView;
            i12 = R$id.ll_quick_trade_container;
        } else {
            view = cVar.itemView;
            i12 = R$id.ll_quick_trade_bottom;
        }
        View findViewById = view.findViewById(i12);
        if (findViewById == null) {
            findViewById = j(cVar, t11, i11, 0);
        }
        if (findViewById.getVisibility() != 0) {
            N(cVar, t11, i11);
            int n11 = n(cVar, findViewById, t11, i11);
            findViewById.getLayoutParams().height = 0;
            findViewById.requestLayout();
            findViewById.setVisibility(4);
            findViewById.postDelayed(new g(this, findViewById, n11), 0);
            HashMap hashMap = new HashMap();
            hashMap.put("TradePair_current_id", w(t11));
            hashMap.put("Tradepair_class", x(t11) == TradeType.PRO ? RankScreenBean.SCREEN_VALUE_SPOT : RankScreenBean.SCREEN_VALUE_FUTURE);
            nc.c.a("App_markets_list_absinfo_show", hashMap);
            return;
        }
        findViewById.setVisibility(8);
        k(cVar, t11, i11);
    }

    public void N(v9.c cVar, T t11, int i11) {
        rl.q.b().f(o(t11), i11);
        rl.q.b().d(cVar.itemView);
    }

    public int O(v9.c cVar, T t11, int i11) {
        View findViewById = cVar.itemView.findViewById(R$id.ll_quick_trade_bottom);
        TextView textView = (TextView) cVar.itemView.findViewById(R$id.tv_buy);
        TextView textView2 = (TextView) cVar.itemView.findViewById(R$id.tv_sell);
        View findViewById2 = cVar.itemView.findViewById(R$id.klineViewWrapper_bottom_divider);
        if (!A(t11)) {
            findViewById.setVisibility(8);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            return findViewById.getLayoutParams().height;
        }
        findViewById.setVisibility(0);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
        if (w.l()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.quick_trade_buy_red, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R$drawable.quick_trade_sell_green, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(R$drawable.quick_trade_buy_green, 0, 0, 0);
            textView2.setCompoundDrawablesWithIntrinsicBounds(R$drawable.quick_trade_sell_red, 0, 0, 0);
        }
        cVar.itemView.findViewById(R$id.fl_buy).setOnClickListener(new ql.d(this, cVar, t11));
        cVar.itemView.findViewById(R$id.fl_sell).setOnClickListener(new ql.e(this, cVar, t11));
        cVar.itemView.findViewById(R$id.fl_place_order).setOnClickListener(new ql.c(this, cVar, t11));
        return 0;
    }

    public final void P(v9.c cVar, View view, T t11, int i11) {
        String str;
        String str2;
        if (this.f72704b) {
            this.f72705c = L(t11);
            TradeType x11 = x(t11);
            String w11 = w(t11);
            a aVar = new a(cVar, t11);
            b bVar = new b(cVar, t11);
            if (rl.q.b().f76470e == null) {
                a1 v11 = a1.v();
                String w12 = w(t11);
                TradeType tradeType = TradeType.PRO;
                String str3 = v11.E(w12, tradeType) + "usdt";
                if (!a1.v().H(tradeType).contains(str3)) {
                    str3 = "";
                }
                String str4 = str3;
                if (TradeType.isContract(x11)) {
                    rl.q.b().f76470e = new q(w11, str4, p(t11), aVar, (u6.g) null);
                } else if (TradeType.isSwap(x11)) {
                    rl.q.b().f76470e = new h1(w11, str4, p(t11), aVar, (u6.g) null);
                } else if (TradeType.isContractIndex(x11)) {
                    rl.q.b().f76470e = new de.a(p(t11), str4, bVar);
                } else if (TradeType.isLinearSwap(x11)) {
                    rl.q.b().f76470e = new j0(w11, str4, p(t11), aVar, (u6.g) null);
                } else if (TradeType.isLinearSwapIndex(x11)) {
                    rl.q.b().f76470e = new v(p(t11), str4, bVar);
                } else {
                    rl.q.b().f76470e = new t(w11, str4, a1.v().p0(w(t11)), bVar);
                }
                t tVar = rl.q.b().f76470e;
                Period period = Period.expandtl;
                tVar.a(period);
                rl.q.b().f76470e.onResume();
                KlineViewWrapper klineViewWrapper = (KlineViewWrapper) cVar.itemView.findViewById(R$id.klineViewWrapper);
                klineViewWrapper.setTradeType(x11.toString());
                klineViewWrapper.setSymbolId(w(t11));
                klineViewWrapper.setPricePrecision(this.f72705c);
                klineViewWrapper.setPeriod(period);
                klineViewWrapper.D();
            } else if (TradeType.isContract(x11) || TradeType.isSwap(x11) || TradeType.isLinearSwap(x11)) {
                rl.q.b().f76470e.l(aVar);
            } else {
                rl.q.b().f76470e.l(bVar);
            }
            Q(t11, cVar);
            ((TextView) cVar.itemView.findViewById(R$id.high_price_label2)).setText(cVar.itemView.getResources().getString(R$string.n_kline_24H_highest));
            ((TextView) cVar.itemView.findViewById(R$id.low_price_label2)).setText(cVar.itemView.getResources().getString(R$string.n_kline_24H_lowest));
            TextView textView = (TextView) cVar.itemView.findViewById(R$id.volume_sum_amount_label2);
            TextView textView2 = (TextView) cVar.itemView.findViewById(R$id.volume_sum_label2);
            int i12 = d.f72717a[x11.ordinal()];
            if (i12 == 1 || i12 == 2) {
                str2 = v(t11).toUpperCase();
                str = "USD";
            } else if (i12 != 3) {
                str2 = StringUtils.i(a1.v().p(w11));
                str = StringUtils.i(a1.v().F(w11));
            } else {
                str = u(t11).toUpperCase();
                str2 = v(t11).toUpperCase();
            }
            int i13 = 0;
            if (textView2 != null) {
                if (!TradeType.isContract(x11) && !TradeType.isLinearSwap(x11) && !TradeType.isSwap(x11)) {
                    textView2.setText(String.format(cVar.itemView.getResources().getString(com.hbg.module.kline.R$string.n_kline_24H_amount), new Object[]{str2}));
                } else if (e.F(x11) || e.G(x11)) {
                    textView2.setText(String.format(cVar.itemView.getResources().getString(com.hbg.module.kline.R$string.n_kline_24H_amount), new Object[]{str2}));
                } else {
                    textView2.setText(String.format(cVar.itemView.getResources().getString(com.hbg.module.kline.R$string.n_kline_24H_amount), new Object[]{cVar.itemView.getResources().getString(com.hbg.module.kline.R$string.contract_trade_unit_sheet)}));
                }
            }
            if (textView != null) {
                textView.setText(String.format(cVar.itemView.getResources().getString(com.hbg.module.kline.R$string.n_kline_24H_volume), new Object[]{str}));
            }
            ((TextView) cVar.itemView.findViewById(R$id.current_value)).setText(cVar.itemView.getResources().getString(R$string.n_currency_intro_total_market_value) + "(" + str + ")");
            view.setOnClickListener(new f(this, cVar, t11, i11));
            TextView textView3 = (TextView) view.findViewById(R$id.tv_future);
            if (!t(t11)) {
                i13 = 8;
            }
            textView3.setVisibility(i13);
            textView3.setText(textView3.getResources().getString(R$string.n_hangqing_go_future) + " >");
            textView3.setOnClickListener(new ql.b(this, t11));
        }
    }

    public void Q(T t11, v9.c cVar) {
        v7.b.a().getDigitalAssetInfo(MapParamsBuilder.c().a(FirebaseAnalytics.Param.CURRENCY, t11.getBaseCurrency()).a("lang", AppLanguageHelper.getInstance().getCurAppLocale().toString().replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER)).b()).b().retry(3).onErrorReturn(h.f60033b).throttleLast(100, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).compose(RxJavaHelper.t((u6.g) null)).subscribe(new c((TextView) cVar.itemView.findViewById(R$id.rank_by_cap_text), (TextView) cVar.itemView.findViewById(R$id.current_value_text)));
    }

    public boolean R(TradeType tradeType) {
        return !TradeType.isOption(tradeType) && !TradeType.isIndex(tradeType) && !TradeType.isContractIndex(tradeType) && !TradeType.isLinearSwapIndex(tradeType);
    }

    public void S(v9.c cVar, T t11, int i11) {
        int i12;
        View view;
        if (this.f72704b) {
            view = cVar.itemView;
            i12 = R$id.ll_quick_trade_container;
        } else {
            view = cVar.itemView;
            i12 = R$id.ll_quick_trade_bottom;
        }
        View findViewById = view.findViewById(i12);
        if (z(t11)) {
            if (findViewById == null) {
                findViewById = j(cVar, t11, i11, -2);
            }
            findViewById.setVisibility(0);
            n(cVar, findViewById, t11, i11);
        } else if (findViewById != null) {
            if (findViewById.getParent() != null) {
                ((ViewGroup) findViewById).removeView(findViewById);
            }
            findViewById.setVisibility(8);
        }
    }

    public boolean T() {
        try {
            this.f72704b = ((MgtExpandKlineBean) AppConfigManager.c(MgtConfigNumber.MARKET_ITEM_EXPAND_KLINE_NEW.number, MgtExpandKlineBean.class)).isHuidu();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return this.f72704b;
    }

    public View j(v9.c cVar, T t11, int i11, int i12) {
        if (rl.q.b().f76469d == null) {
            if (this.f72704b) {
                rl.q.b().f76469d = LayoutInflater.from(cVar.itemView.getContext()).inflate(R$layout.layout_item_market_view_k, (ViewGroup) null);
            } else {
                rl.q.b().f76469d = LayoutInflater.from(cVar.itemView.getContext()).inflate(R$layout.layout_item_market_view_quick_trade, (ViewGroup) null);
            }
            if (rl.q.b().f76470e != null) {
                rl.q.b().f76470e.l((t.e) null);
                rl.q.b().f76470e.onPause();
                rl.q.b().f76470e = null;
            }
        } else if (!(rl.q.b().f76469d.getParent() == null || rl.q.b().f76469d.getParent() == cVar.itemView)) {
            ((ViewGroup) rl.q.b().f76469d.getParent()).removeView(rl.q.b().f76469d);
            rl.q.b().f76469d.setVisibility(8);
            if (!o(t11).equals(rl.q.b().f76469d.getTag(R$id.ll_quick_trade_container))) {
                if (rl.q.b().f76470e != null) {
                    rl.q.b().f76470e.l((t.e) null);
                    rl.q.b().f76470e.onPause();
                    rl.q.b().f76470e = null;
                }
                KlineViewWrapper klineViewWrapper = (KlineViewWrapper) rl.q.b().f76469d.findViewById(R$id.klineViewWrapper);
                if (klineViewWrapper != null) {
                    klineViewWrapper.C();
                    klineViewWrapper.G();
                }
                TextView textView = (TextView) rl.q.b().f76469d.findViewById(R$id.rank_by_cap_text);
                if (textView != null) {
                    textView.setText("--");
                }
                TextView textView2 = (TextView) rl.q.b().f76469d.findViewById(R$id.current_value_text);
                if (textView2 != null) {
                    textView2.setText("--");
                }
                TextView textView3 = (TextView) rl.q.b().f76469d.findViewById(R$id.high_price_text2);
                if (textView3 != null) {
                    textView3.setText("--");
                }
                TextView textView4 = (TextView) rl.q.b().f76469d.findViewById(R$id.low_price_text2);
                if (textView4 != null) {
                    textView4.setText("--");
                }
                TextView textView5 = (TextView) rl.q.b().f76469d.findViewById(R$id.volume_sum_text2);
                if (textView5 != null) {
                    textView5.setText("--");
                }
                TextView textView6 = (TextView) rl.q.b().f76469d.findViewById(R$id.volume_sum_amount_text2);
                if (textView6 != null) {
                    textView6.setText("--");
                }
            }
        }
        ((ViewGroup) cVar.itemView).addView(rl.q.b().f76469d, s(i12));
        rl.q.b().f76469d.setTag(R$id.ll_quick_trade_container, o(t11));
        return rl.q.b().f76469d;
    }

    public void k(v9.c cVar, T t11, int i11) {
        rl.q.b().f((String) null, -1);
    }

    public void l(View view, int i11) {
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(200).addUpdateListener(new ql.a(layoutParams, i11, view));
        ofFloat.start();
    }

    public abstract void m(v9.c cVar, T t11, int i11, boolean z11);

    public int n(v9.c cVar, View view, T t11, int i11) {
        P(cVar, view, t11, i11);
        return O(cVar, t11, i11);
    }

    public String o(T t11) {
        return v(t11) + "#" + w(t11) + "#" + p(t11);
    }

    public String p(T t11) {
        return "";
    }

    public abstract ViewGroup.LayoutParams s(int i11);

    public boolean t(T t11) {
        return true;
    }

    public String u(T t11) {
        return "";
    }

    public String v(T t11) {
        return "";
    }

    public abstract String w(T t11);

    public abstract TradeType x(T t11);

    /* renamed from: y */
    public void handleView(v9.c cVar, int i11, T t11, ViewGroup viewGroup) {
        S(cVar, t11, i11);
    }

    public boolean z(T t11) {
        return rl.q.b().c(o(t11));
    }
}
