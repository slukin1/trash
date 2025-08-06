package com.huobi.litere;

import al.w;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.hbg.lib.network.otc.core.bean.LiteReOtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcConfigBean;
import com.hbg.lib.network.otc.core.bean.OtcConfigItem;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.network.LiteRequestCallback1;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.account.ui.AccountOrderManageActivity;
import com.huobi.account.ui.LitePersonalCenterActivity;
import com.huobi.coupon.bean.Coupon;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.CurrencySearchEntity;
import com.huobi.finance.bean.CurrencySearchItem;
import com.huobi.finance.bean.FiatDWEntrance;
import com.huobi.finance.ui.DepositFiatFromCoinActivity;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.finance.ui.UnifyRiskActivity;
import com.huobi.finance.ui.UnifyWithdrawActivity;
import com.huobi.finance.ui.WithdrawFiatFromCoinActivity;
import com.huobi.finance.utils.DepositWithdrawHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.lite.LiteExchangeDialogFragment;
import com.huobi.litere.bean.LiteExchangeBean;
import com.huobi.litere.bean.LiteTradeBean;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.litere.main.ui.LiteReMainActivity;
import com.huobi.litere.market.ui.LiteReMarketFlutterActivity;
import com.huobi.litere.trade.ui.LiteReAssetDetailActivity;
import com.huobi.litere.trade.ui.LiteReExchangeFlutterActivity;
import com.huobi.litere.trade.ui.LiteReOrderStateActivity;
import com.huobi.litere.trade.ui.LiteReTradeFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.message.ui.MessageActivity;
import com.huobi.utils.GsonHelper;
import d7.a1;
import d7.k;
import d7.q0;
import gs.g;
import i6.m;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.v1;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import sn.f;
import tg.r;

public abstract class BaseLiteReFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public Map<String, CurrencyBean> f75408k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f75409l;

    /* renamed from: m  reason: collision with root package name */
    public HBDialogFragment f75410m;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            BaseLiteReFlutterActivity.this.Yi(methodCall, result);
        }
    }

    public class b implements MethodChannel.MethodCallHandler {
        public b() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            i6.d.j("flutter", "onPlatformMessageChannelMethodCall method - " + methodCall.method);
            i6.d.j("flutter", "onPlatformMessageChannelMethodCall arguments - " + methodCall.arguments);
            BaseLiteReFlutterActivity.this.Zi(methodCall, result);
        }
    }

    public class c implements MethodChannel.MethodCallHandler {
        public c() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            i6.d.j("flutter", "onPlatformMessageChannelMethodCall method - " + methodCall.method);
            i6.d.j("flutter", "onPlatformMessageChannelMethodCall arguments - " + methodCall.arguments);
            BaseLiteReFlutterActivity.this.aj(methodCall, result);
        }
    }

    public class d extends LiteRequestCallback1<List<CurrencyBean>> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f75414a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodCall f75415b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f75416c;

        public d(MethodCall methodCall, MethodChannel.Result result) {
            this.f75415b = methodCall;
            this.f75416c = result;
        }

        /* renamed from: b */
        public void onRequestSuccess(List<CurrencyBean> list) {
            try {
                Map<String, List<ChainInfo>> l11 = r.x().F0() ? k.C().l() : null;
                if (l11 != null && !l11.isEmpty() && !list.isEmpty()) {
                    for (CurrencyBean next : list) {
                        if (next != null) {
                            if (next.getName() != null) {
                                next.setChainInfos(l11.get(next.getName()));
                            }
                        }
                    }
                }
                CurrencySearchEntity currencySearchEntity = new CurrencySearchEntity();
                if (this.f75415b.hasArgument("type")) {
                    currencySearchEntity.setDeposit("1".equals(this.f75415b.argument("type")));
                }
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    CurrencyBean currencyBean = list.get(i11);
                    if (currencyBean != null && currencyBean.isVisible() && !currencyBean.isEtpTag()) {
                        CurrencySearchItem currencySearchItem = new CurrencySearchItem();
                        currencySearchItem.setCurrency(currencyBean.getDisplayName());
                        boolean z11 = true;
                        currencySearchItem.setDepositEnabled(!((DepositWithdrawHelper.b(currencyBean) & 2) != 0));
                        if ((DepositWithdrawHelper.b(currencyBean) & 4) != 0) {
                            z11 = false;
                        }
                        currencySearchItem.setWithdrawEnable(z11);
                        currencySearchItem.setFullName(currencyBean.getFullName());
                        arrayList.add(currencySearchItem);
                        BaseLiteReFlutterActivity.this.f75408k.put(StringUtils.g(currencyBean.getDisplayName()), currencyBean);
                    }
                }
                currencySearchEntity.setList(arrayList);
                String json = new Gson().toJson((Object) currencySearchEntity);
                i6.d.b("BaseLiteReFlutterActivity-->net onMethodCall-->getDepositWithdrawData:" + json);
                c(json);
            } catch (Exception e11) {
                e11.printStackTrace();
                i6.d.b("BaseLiteReFlutterActivity-->net Exception-->getDepositWithdrawData:" + e11.toString());
                c((Object) null);
            }
        }

        public final void c(Object obj) {
            if (!this.f75414a) {
                this.f75414a = true;
                this.f75416c.success(obj);
            }
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            i6.d.b("BaseLiteReFlutterActivity-->net onRequestFailure-->getDepositWithdrawData:" + th2.toString());
            c((Object) null);
        }
    }

    public static /* synthetic */ void Wi(HBDialogFragment hBDialogFragment) {
        g.i("lite_no_permission_exit_click", (HashMap) null);
        hBDialogFragment.dismiss();
        System.exit(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        LiteExchangeDialogFragment.Ah(this, false);
        g.i("lite_no_permission_pop_click", (HashMap) null);
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("content")) {
                ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence) null, (CharSequence) methodCall.argument("content")));
                HuobiToastUtil.t(this, R.string.currency_detail_notice_dialog_toast);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        result.success((Object) null);
    }

    public final void Ji(MethodCall methodCall, MethodChannel.Result result) {
        OtcConfigBean r11 = va.b.o().r();
        if (r11 != null) {
            try {
                LiteReOtcConfigBean liteReOtcConfigBean = new LiteReOtcConfigBean();
                List<OtcConfigItem.CurrencyBean> currencyBeans = r11.getCurrencyBeans();
                if (!CollectionsUtils.b(currencyBeans)) {
                    ArrayList arrayList = new ArrayList(currencyBeans.size());
                    liteReOtcConfigBean.setListCurrencyBeans(arrayList);
                    for (OtcConfigItem.CurrencyBean next : currencyBeans) {
                        LiteReOtcConfigBean.LiteCurrencyBean liteCurrencyBean = new LiteReOtcConfigBean.LiteCurrencyBean();
                        liteCurrencyBean.setCurrencyId(Integer.parseInt(next.getCurrencyId()));
                        liteCurrencyBean.setNameShort(next.getNameShort());
                        liteCurrencyBean.setSymbol(next.getSymbol());
                        arrayList.add(liteCurrencyBean);
                    }
                }
                List<OtcMarketCoinInfo.CoinInfo> coinInfoList = r11.getCoinInfoList();
                if (!CollectionsUtils.b(coinInfoList)) {
                    liteReOtcConfigBean.setLiteCoinInfoList(new ArrayList(coinInfoList.size()));
                }
                liteReOtcConfigBean.setBlueshield(false);
                result.success(GsonHelper.a().toJson((Object) liteReOtcConfigBean));
            } catch (Exception e11) {
                e11.printStackTrace();
                result.error("otcConfig", "Not data", "Not data");
            }
        } else {
            result.error("otcConfig", "Not data", "Not data");
        }
    }

    public final void Ki(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        if (F == null) {
            result.success("");
        } else {
            result.success(F.getDisplayName());
        }
    }

    public final void Li(MethodCall methodCall, MethodChannel.Result result) {
        List<CurrencyBean> g11 = q0.g();
        d dVar = new d(methodCall, result);
        if (g11 == null || g11.isEmpty()) {
            i6.d.b("BaseLiteReFlutterActivity-->net requestCurrencies-->getDepositWithdrawData:");
            k.C().U(true, dVar);
            return;
        }
        dVar.onRequestSuccess(g11);
    }

    public final void Mi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (va.b.o().x()) {
                Ji(methodCall, result);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("otcConfig", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ni(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("isBuy")) {
                Boolean bool = (Boolean) methodCall.argument("isBuy");
            } else {
                result.success(GsonHelper.a().toJson((Object) new ArrayList()));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success(GsonHelper.a().toJson((Object) new ArrayList()));
        }
    }

    public final void Oi(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        String valueOf = F != null ? String.valueOf(F.getSafeConfirms()) : "";
        i6.d.c("BaseLiteReFlutterActivity", "getSafeConfirmCount=" + valueOf);
        result.success(valueOf);
    }

    public final void Pi(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
        String x11 = k.C().x(str2, (String) methodCall.argument("chain"));
        if ("usdt".equals(str2)) {
            str = m.F(x11, 4);
        } else {
            str = m.F(x11, 8);
        }
        result.success(str);
    }

    public final void Qi(MethodCall methodCall, MethodChannel.Result result) {
        ra.c.b().k(this);
        result.success((Object) null);
    }

    public void Ri(MethodCall methodCall, MethodChannel.Result result) {
        try {
            OtcModuleConfig.b().l(this, "");
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success(GsonHelper.a().toJson((Object) new ArrayList()));
        }
        result.success((Object) null);
    }

    public void Si(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("orderId")) {
                v1.a().f(this, (String) methodCall.argument("orderId"));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("gotoOrderDetail", e11.getMessage(), e11.getMessage());
        }
        result.success((Object) null);
    }

    public final void Ti(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("orderId")) {
                LiteReOrderStateActivity.lj(this, (String) methodCall.argument("orderId"));
            }
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Ui(MethodCall methodCall, MethodChannel.Result result) {
        startActivity(UnifyRiskActivity.Ch(this, Long.parseLong((String) methodCall.argument("transactionId")), 1));
        result.success((Object) null);
    }

    public final void Vi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            startActivity(f.p(this, Coupon.OTC));
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public final void Yi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("otc_base_config_data".equals(str)) {
                Mi(methodCall, result);
            } else if ("getDepositWithdrawData".equals(str)) {
                Li(methodCall, result);
            } else if ("selectedCurrency".equals(str)) {
                String str2 = "";
                if (methodCall.hasArgument(FirebaseAnalytics.Param.CURRENCY)) {
                    str2 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
                }
                i6.d.b("CurrencySearchActivity-->onMethodCall-->selectedCurrency:" + str2);
                if (!TextUtils.isEmpty(str2)) {
                    if (methodCall.hasArgument("type")) {
                        bj(str2, (String) methodCall.argument("type"));
                    }
                    result.success((Object) null);
                }
            } else if ("openWithdraw".equals(str)) {
                UnifyWithdrawActivity.Di(this, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), TradeType.PRO);
                result.success((Object) null);
            } else if ("openDeposit".equals(str)) {
                UnifyDepositActivity.wh(this, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY));
                result.success((Object) null);
            } else if ("openOrderManager".equals(str)) {
                AccountOrderManageActivity.Hh(this);
                result.success((Object) null);
            } else if ("openLiteUserCenter".equals(str)) {
                gj(methodCall, result);
            } else if ("openMessage".equals(str)) {
                hj(methodCall, result);
            } else if ("openLiteMarket".equals(str)) {
                ej(methodCall, result);
            } else if ("openLiteAssetDetail".equals(str)) {
                cj(methodCall, result);
            } else if ("openLiteExchange".equals(str)) {
                dj(methodCall, result);
            } else if ("openLiteTrade".equals(str)) {
                fj(methodCall, result);
            } else if ("openOtcOrderListPage".equals(str)) {
                ij(methodCall, result);
            } else if ("copyClip".equals(str)) {
                Ii(methodCall, result);
            } else if ("getOtcTradeCurrencyList".equals(str)) {
                Ni(methodCall, result);
            } else if (!"getOtcTradeCryptoList".equals(str)) {
                if (!"getSupportExchangeCryptoList".equals(str)) {
                    if ("gotoAssetPage".equals(str)) {
                        Qi(methodCall, result);
                    } else if ("gotoOrderStatePage".equals(str)) {
                        Ti(methodCall, result);
                    } else if ("kycOtcPage".equals(str)) {
                        Vi(methodCall, result);
                    } else {
                        result.notImplemented();
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Zi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("getSmallAmount".equals(str)) {
                Pi(methodCall, result);
            } else if ("goToVerify".equals(str)) {
                Ui(methodCall, result);
            } else if ("depositPay".equals(str)) {
                CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo = new CurrencyFromCCFinanceRecordInfo();
                currencyFromCCFinanceRecordInfo.setOrderCode((String) methodCall.argument("orderCode"));
                currencyFromCCFinanceRecordInfo.setCurrency((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY));
                w.l(this, currencyFromCCFinanceRecordInfo);
                result.success((Object) null);
            } else if ("getChainDisplayName".equals(str)) {
                Ki(methodCall, result);
            } else if ("getSafeConfirmCount".equals(str)) {
                Oi(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void aj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if (TextUtils.equals(str, "toDeposit")) {
                DepositFiatFromCoinActivity.oj(this, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument(AppsFlyerProperties.CHANNEL), FiatDWEntrance.unknown);
                result.success((Object) null);
            } else if (TextUtils.equals(str, "toWithdraw")) {
                WithdrawFiatFromCoinActivity.nj(this, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), FiatDWEntrance.unknown);
                result.success((Object) null);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void bj(String str, String str2) {
        CurrencyBean currencyBean = this.f75408k.get(StringUtils.g(str));
        if (!"1".equals(str2)) {
            "2".equals(str2);
        }
    }

    public final void cj(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        boolean z11 = true;
        try {
            if (methodCall.hasArgument(FirebaseAnalytics.Param.CURRENCY)) {
                str = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
                z11 = ((Boolean) methodCall.argument("isFiat")).booleanValue();
            } else {
                str = null;
            }
            LiteReAssetDetailActivity.jj(this, str, z11);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        result.success((Object) null);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "lite_base_channel");
        this.f75409l = methodChannel;
        methodChannel.setMethodCallHandler(new a());
        new MethodChannel(flutterEngine.getDartExecutor(), "dw_record_channel").setMethodCallHandler(new b());
        new MethodChannel(flutterEngine.getDartExecutor(), "fiat_channel").setMethodCallHandler(new c());
    }

    public final void dj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            LiteExchangeBean liteExchangeBean = new LiteExchangeBean();
            if (methodCall.hasArgument("quoteCoinId")) {
                liteExchangeBean.setQuoteCoinId((Integer) methodCall.argument("quoteCoinId"));
            }
            if (methodCall.hasArgument("cryptoCoinId")) {
                liteExchangeBean.setCryptoCoinId((Integer) methodCall.argument("cryptoCoinId"));
            }
            LiteReExchangeFlutterActivity.kj(this, liteExchangeBean);
        } catch (Exception e11) {
            e11.printStackTrace();
            LiteReExchangeFlutterActivity.kj(this, (LiteExchangeBean) null);
        }
        result.success((Object) null);
    }

    public final void ej(MethodCall methodCall, MethodChannel.Result result) {
        try {
            LiteReMarketFlutterActivity.jj(this, methodCall.hasArgument("coinId") ? (Integer) methodCall.argument("coinId") : null);
        } catch (Exception e11) {
            e11.printStackTrace();
            LiteReExchangeFlutterActivity.kj(this, (LiteExchangeBean) null);
        }
        result.success((Object) null);
    }

    public final void fj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            LiteTradeBean liteTradeBean = new LiteTradeBean();
            if (methodCall.hasArgument("quoteCoinId")) {
                liteTradeBean.setCryptoCoinId(String.valueOf((Integer) methodCall.argument("quoteCoinId")));
            }
            if (methodCall.hasArgument("side")) {
                liteTradeBean.setSide((String) methodCall.argument("side"));
            }
            LiteReTradeFlutterActivity.vj(this, liteTradeBean);
        } catch (Exception e11) {
            e11.printStackTrace();
            LiteReTradeFlutterActivity.vj(this, (LiteTradeBean) null);
        }
        result.success((Object) null);
    }

    public final void gj(MethodCall methodCall, MethodChannel.Result result) {
        LitePersonalCenterActivity.sj(this);
        result.success((Object) null);
    }

    public final void hj(MethodCall methodCall, MethodChannel.Result result) {
        Intent intent = new Intent(this, MessageActivity.class);
        if (!r.x().F0()) {
            rn.c.i().d(this, new JumpTarget(intent, (Intent) null));
        } else if (!NetworkStatus.c(this)) {
            HuobiToastUtil.j(R.string.server_error);
            return;
        } else {
            startActivity(intent);
        }
        result.success((Object) null);
    }

    public final void ij(MethodCall methodCall, MethodChannel.Result result) {
        try {
            AssetModuleConfig.a().o0(this);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        result.success((Object) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1.v().z0(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new BaseSubscriber());
        LegalCurrencyConfigUtil.e().compose(RxJavaHelper.t(this)).subscribe(new BaseSubscriber());
        k.C().E(true).compose(RxJavaHelper.t(this)).subscribe(new BaseSubscriber());
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public void onPause() {
        super.onPause();
        try {
            HBDialogFragment hBDialogFragment = this.f75410m;
            if (hBDialogFragment != null) {
                hBDialogFragment.dismiss();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        if (r.x().F0()) {
            HBDialogFragment hBDialogFragment = this.f75410m;
            if (hBDialogFragment != null && hBDialogFragment.th()) {
                this.f75410m.dismiss();
            }
            Resources resources = getResources();
            try {
                Configuration configuration = getResources().getConfiguration();
                configuration.locale = AppLanguageHelper.getInstance().getCurAppLocale();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                resources = new Resources(getAssets(), displayMetrics, configuration);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            this.f75410m = DialogUtils.b0(this, resources.getString(R.string.n_lite_area_not_available_title), resources.getString(R.string.n_lite_area_not_available_msg), "", resources.getString(R.string.n_lite_area_not_available_exit), resources.getString(R.string.n_lite_area_not_available_switch_pro), jn.b.f55993a, new jn.a(this));
            g.i("lite_no_permission_pop_expose", (HashMap) null);
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (isAlive()) {
            Intent intent = new Intent(this, LiteReMainActivity.class);
            rn.c.i().d(this, new JumpTarget(intent, intent));
        }
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        LiteReHelper.a().c(true);
        return super.provideFlutterEngine(context);
    }

    public SplashScreen provideSplashScreen() {
        return new DrawableSplashScreen(new ColorDrawable(getResources().getColor(R.color.baseColorContentBackground)), ImageView.ScaleType.FIT_XY, 200);
    }
}
