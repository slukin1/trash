package com.huobi.finance.ui;

import al.w;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.activity.CountryAreaSelectActivity;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.FiatDWEntrance;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.litere.event.CloseLiteReAssetPage;
import com.huobi.login.bean.JumpTarget;
import com.huobi.otc.ui.OtcBindBankCardActivity;
import com.huobi.utils.k0;
import d7.k;
import dt.h2;
import hh.f;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import jp.l;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import rn.c;
import rx.Observable;
import rx.Subscriber;

abstract class AbsFiatFromCoinActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public Security2FADialogHelper f46233k;

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f46234l;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            d.j("flutter", "onPlatformMessageChannelMethodCall method - " + methodCall.method);
            d.j("flutter", "onPlatformMessageChannelMethodCall arguments - " + methodCall.arguments);
            AbsFiatFromCoinActivity.this.jj(methodCall, result);
        }
    }

    public class b extends Security2FADialogHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f46236a = true;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f46237b;

        public b(MethodChannel.Result result) {
            this.f46237b = result;
        }

        public void onFailed(String str) {
            d.c("2FA", "onFailed errMsg=" + str);
            if (this.f46236a) {
                this.f46237b.success((Object) null);
                this.f46236a = false;
            }
        }

        public void onSuccess(String str) {
            d.c("2FA", "onSuccess token=" + str);
            if (this.f46236a) {
                this.f46237b.success(str);
                AbsFiatFromCoinActivity.this.f46233k.v();
                this.f46236a = false;
            }
        }
    }

    public static /* synthetic */ Observable fj(BalanceDataTotal balanceDataTotal) {
        List<? extends BaseAssetInfo> detailInfos = balanceDataTotal != null ? balanceDataTotal.getDetailInfos() : null;
        if (detailInfos != null && !detailInfos.isEmpty()) {
            return Observable.from(detailInfos);
        }
        throw new NullPointerException("Get balance data is null.");
    }

    public static /* synthetic */ BalanceDetailInfo hj(BaseAssetInfo baseAssetInfo) {
        return (BalanceDetailInfo) baseAssetInfo;
    }

    public final void Mi(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
        if (TextUtils.isEmpty(str)) {
            result.success((Object) null);
            return;
        }
        Observable<R> compose = h2.t1().v3(TradeType.PRO, false).map(new u(str)).map(z.f47419b).compose(RxJavaHelper.t(this));
        Objects.requireNonNull(result);
        compose.subscribe((Subscriber<? super R>) SilentSubscriber.b(new p(result), new s(result), new t(result)));
    }

    public void Ni(MethodChannel.Result result) {
        d.c("2FA", "### START ###");
        if (this.f46233k == null) {
            this.f46233k = new Security2FADialogHelper(this, this, "VERIFY_SETTING_POLICY_WITHDRAW");
        }
        this.f46233k.L(true);
        this.f46233k.M(true);
        this.f46233k.R(new b(result));
    }

    public final void Oi() {
        finish();
        com.blankj.utilcode.util.a.a(HBBaseWebActivity.class);
    }

    public final String Pi() {
        if (SystemUtils.c()) {
            return l.p() + "fiat-crypto/card-result" + "?" + Uri.encode("from=from_cpf");
        }
        return "https://www.global-base.tc-jp1.huobiapps.com/-/x/otc" + OtcModuleConfig.a().g() + "fiat-crypto/card-result" + "?" + Uri.encode("from=from_cpf");
    }

    public final void Qi(MethodCall methodCall) {
        if (f.h().l()) {
            zn.a.d().k(this, "total_balance_type_balance");
            return;
        }
        Intent c11 = k0.c(this);
        Bundle bundle = new Bundle();
        bundle.putString("total_balance_type", "total_balance_type_balance");
        c11.putExtras(bundle);
        startActivity(c11);
    }

    public final void Ri(MethodCall methodCall) {
        String str = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
        if (!TextUtils.isEmpty(str) && k.C().L(str)) {
            AssetDataCacheManager.k0().S().flatMap(w.f47369b).filter(x.f47385b).map(y.f47404b).filter(new v(str)).compose(RxJavaHelper.t(this)).first().subscribe(q6.d.c(this, new r(this)));
        }
    }

    public final void Si(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (!methodCall.hasArgument("orderCode") || !methodCall.hasArgument("type")) {
                result.error("-1", methodCall.method + "argument error", (Object) null);
                return;
            }
            FiatResultFromCoinActivity.nj(this, (String) methodCall.argument("orderCode"), ((Integer) methodCall.argument("type")).intValue(), (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY));
            result.success((Object) null);
        } catch (Exception e11) {
            i6.k.k(e11);
            result.error("-1", methodCall.method + "has error", (Object) null);
        }
    }

    public final void Ti(MethodCall methodCall) {
        String str = (String) methodCall.argument("coinId");
        jp.k0.k(this);
    }

    public void Ui(MethodCall methodCall, MethodChannel.Result result) throws Exception {
        String str = (String) methodCall.argument("url");
        String str2 = (String) methodCall.argument("accountNo");
        String str3 = (String) methodCall.argument(AppsFlyerProperties.CHANNEL);
        String str4 = (String) methodCall.argument("paymentMethodCode");
        String h11 = iu.a.f().k() ? ku.b.e().h(this) : null;
        Intent webViewIntent = HBBaseWebActivity.getWebViewIntent(this, str, "", "", false);
        if (webViewIntent == null) {
            result.success((Object) null);
            return;
        }
        webViewIntent.putExtra("accountNo", str2);
        webViewIntent.putExtra(AppsFlyerProperties.CHANNEL, str3);
        webViewIntent.putExtra("paymentMethodCode", str4);
        webViewIntent.putExtra("deviceFingerprint", h11);
        HBBaseWebActivity.showWebView(this, webViewIntent);
        result.success((Object) null);
    }

    public void Vi(MethodCall methodCall, MethodChannel.Result result) throws Exception {
        String str = (String) methodCall.argument("url");
        String str2 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
        String str3 = (String) methodCall.argument(AppsFlyerProperties.CHANNEL);
        String str4 = (String) methodCall.argument("paymentMethodCode");
        String str5 = (String) methodCall.argument("limitMin");
        String str6 = (String) methodCall.argument("limitMax");
        double doubleValue = ((Double) methodCall.argument("amount")).doubleValue();
        String h11 = iu.a.f().k() ? ku.b.e().h(this) : null;
        d.e("gotoFiatChannelDepositH5GuaranteePay-limitMin->", str5 + "");
        d.e("gotoFiatChannelDepositH5GuaranteePay-limitMax->", str6 + "");
        w.i(this, str, str2, str3, str4, BigDecimal.valueOf(doubleValue), h11, str5, str6);
        result.success((Object) null);
    }

    public void Wi(MethodCall methodCall, MethodChannel.Result result) throws Exception {
        String str = (String) methodCall.argument("url");
        String str2 = (String) methodCall.argument("orderCode");
        String str3 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
        String str4 = (String) methodCall.argument("paymentMethodCode");
        String str5 = (String) methodCall.argument("accountNumber");
        if ("settlepay".equals(str4)) {
            w.k(this, str, str2, str3, str4, str5);
        } else {
            w.j(this, str, str2, str3, str4);
        }
        result.success((Object) null);
    }

    public void Xi(MethodCall methodCall, MethodChannel.Result result) throws Exception {
    }

    public void Yi(MethodCall methodCall, MethodChannel.Result result) {
    }

    public void Zi(MethodCall methodCall, MethodChannel.Result result) {
    }

    public final void aj(BalanceDetailInfo balanceDetailInfo) {
        Intent intent = new Intent(this, CurrencyFromCCDetailActivity.class);
        intent.putExtra("currency_detail_info", balanceDetailInfo);
        startActivity(intent);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "fiat_channel");
        this.f46234l = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void jj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if (TextUtils.equals(str, "fiatChannelWithdrawSecondaryValidation")) {
                Ni(result);
            } else if (TextUtils.equals(str, "initFiatChannelWithdraw")) {
                Yi(methodCall, result);
            } else if (TextUtils.equals(str, "fiatChannelCurrencyBalance")) {
                Mi(methodCall, result);
            } else if (TextUtils.equals(str, "initFiatOrderResultDetail")) {
                Zi(methodCall, result);
            } else if (TextUtils.equals(str, "goFiatOrderResultDetail")) {
                Si(methodCall, result);
            } else if (TextUtils.equals(str, "goOTC")) {
                Ti(methodCall);
                Oi();
                result.success((Object) null);
            } else if (TextUtils.equals(str, "openBindCardPage")) {
                kj(methodCall);
                result.success((Object) null);
            } else if (TextUtils.equals(str, "goAssetPage")) {
                Qi(methodCall);
                Oi();
                result.success((Object) null);
            } else if (TextUtils.equals(str, "goAssetRecordPage")) {
                Ri(methodCall);
                result.success((Object) null);
            } else if (TextUtils.equals(str, "initFiatChannelDeposit")) {
                Xi(methodCall, result);
            } else if (TextUtils.equals(str, "gotoFiatChannelDepositH5Pay")) {
                Wi(methodCall, result);
            } else if (TextUtils.equals(str, "gotoFiatChannelDepositH5GuaranteePay")) {
                Vi(methodCall, result);
            } else if (TextUtils.equals(str, "gotoFiatChannelAddAccountH5Pay")) {
                Ui(methodCall, result);
            } else if (TextUtils.equals(str, "toDeposit")) {
                DepositFiatFromCoinActivity.oj(this, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument(AppsFlyerProperties.CHANNEL), FiatDWEntrance.unknown);
                result.success((Object) null);
                finish();
            } else if (TextUtils.equals(str, "showLevelAlert")) {
                com.hbg.lib.widgets.dialog.b.a(this);
                result.success((Object) null);
            } else if (TextUtils.equals(str, "selectCountry")) {
                mj();
                result.success((Object) null);
            } else if (TextUtils.equals(str, "popToBalanceDetail")) {
                lj();
                result.success((Object) null);
            } else if (TextUtils.equals(str, "openBrowser")) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.setData(Uri.parse(((String) methodCall.argument("url")) + "?return_url=" + Pi()));
                startActivity(intent);
                result.success((Object) null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void kj(MethodCall methodCall) {
        OtcBindBankCardActivity.Sh(this);
    }

    public final void lj() {
        EventBus.d().k(new CloseLiteReAssetPage());
        finish();
    }

    public final void mj() {
        Intent intent = new Intent(this, CountryAreaSelectActivity.class);
        intent.putExtra("choose_type", "choose_type_code");
        startActivityForResult(intent, 1001);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (i11 == 1001 && intent != null) {
            try {
                String stringExtra = intent.getStringExtra("phone_area_code");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("areaCode", stringExtra);
                this.f46234l.invokeMethod("fiatCountryInfo", jSONObject.toString());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        super.onActivityResult(i11, i12, intent);
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(this, new JumpTarget(k0.c(this), k0.h(this)));
    }
}
