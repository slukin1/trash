package com.huobi.litere.trade.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.otc.core.bean.ExpressQuotePramBean;
import com.huobi.finance.bean.FiatDWEntrance;
import com.huobi.finance.ui.DepositFiatFromCoinActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.litere.BaseLiteReFlutterActivity;
import com.huobi.litere.bean.LiteTradeBean;
import com.huobi.otc.event.CloseFastTradeDialogEvent;
import com.huobi.otc.flutter.OtcOrderDepositActivity;
import com.huobi.utils.GsonHelper;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.math.BigDecimal;
import k20.h;
import org.greenrobot.eventbus.ThreadMode;
import up.g;

public class LiteReTradeFlutterActivity extends BaseLiteReFlutterActivity {

    /* renamed from: n  reason: collision with root package name */
    public MethodChannel f75424n;

    /* renamed from: o  reason: collision with root package name */
    public Integer f75425o;

    /* renamed from: p  reason: collision with root package name */
    public Integer f75426p;

    /* renamed from: q  reason: collision with root package name */
    public String f75427q;

    /* renamed from: r  reason: collision with root package name */
    public String f75428r = "";

    /* renamed from: s  reason: collision with root package name */
    public String f75429s = "";

    /* renamed from: t  reason: collision with root package name */
    public String f75430t;

    /* renamed from: u  reason: collision with root package name */
    public String f75431u;

    /* renamed from: v  reason: collision with root package name */
    public String f75432v;

    /* renamed from: w  reason: collision with root package name */
    public ExpressQuotePramBean f75433w;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            LiteReTradeFlutterActivity.this.uj(methodCall, result);
        }
    }

    public static void vj(Context context, LiteTradeBean liteTradeBean) {
        Intent intent = new Intent(context, LiteReTradeFlutterActivity.class);
        if (liteTradeBean != null) {
            intent.putExtra("lite_re_extra_trade_channel", liteTradeBean);
        }
        context.startActivity(intent);
    }

    public String Nh() {
        return "lite_trade";
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void closeFastTradeDialogEvent(CloseFastTradeDialogEvent closeFastTradeDialogEvent) {
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        this.f75424n = new MethodChannel(flutterEngine.getDartExecutor(), "lite_trade_channel");
        qj();
        this.f75424n.setMethodCallHandler(new a());
    }

    public final void jj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            sj(methodCall, result);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        result.success((Object) null);
    }

    public final void kj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument(FirebaseAnalytics.Param.CURRENCY)) {
                DepositFiatFromCoinActivity.nj(this, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), FiatDWEntrance.unknown);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        result.success((Object) null);
    }

    public final void lj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            startActivity(new Intent(this, OtcOrderDepositActivity.class));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        result.success((Object) null);
    }

    public final void mj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument("currencyId")) {
                String str = (String) methodCall.argument("currencyId");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        result.success((Object) null);
    }

    public final void nj(MethodCall methodCall, MethodChannel.Result result) {
        result.success((Object) null);
    }

    public final void oj(MethodCall methodCall, MethodChannel.Result result) {
        result.success((Object) null);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void pj(MethodCall methodCall, MethodChannel.Result result) {
        result.success((Object) null);
    }

    public final void qj() {
    }

    public final void rj(MethodCall methodCall, MethodChannel.Result result) {
        result.success((Object) null);
    }

    public final ExpressQuotePramBean sj(MethodCall methodCall, MethodChannel.Result result) {
        ExpressQuotePramBean expressQuotePramBean = new ExpressQuotePramBean();
        if (methodCall.hasArgument("cryptoAsset")) {
            String str = (String) methodCall.argument("cryptoAsset");
            if (!TextUtils.isEmpty(str)) {
                expressQuotePramBean.setCryptoAsset(str.toLowerCase());
            }
        }
        if (methodCall.hasArgument("quoteAsset")) {
            String str2 = (String) methodCall.argument("quoteAsset");
            if (!TextUtils.isEmpty(str2)) {
                expressQuotePramBean.setQuoteAsset(str2);
            }
        }
        if (methodCall.hasArgument("side")) {
            expressQuotePramBean.setSide((String) methodCall.argument("side"));
        }
        if (methodCall.hasArgument("amount")) {
            expressQuotePramBean.setAmount((BigDecimal) methodCall.argument("amount"));
            this.f75430t = expressQuotePramBean.getAmount().toPlainString();
        }
        if (methodCall.hasArgument("type")) {
            expressQuotePramBean.setType((String) methodCall.argument("type"));
        }
        if (methodCall.hasArgument("coinId")) {
            this.f75425o = (Integer) methodCall.argument("coinId");
        }
        if (methodCall.hasArgument("currencyId")) {
            this.f75426p = (Integer) methodCall.argument("currencyId");
        }
        if (methodCall.hasArgument("balanceMinAmount")) {
            this.f75431u = (String) methodCall.argument("balanceMinAmount");
        }
        if (methodCall.hasArgument("balanceMinQuantity")) {
            this.f75432v = (String) methodCall.argument("balanceMinQuantity");
        }
        if (methodCall.hasArgument("fiatCurrencyBalance")) {
            String str3 = (String) methodCall.argument("fiatCurrencyBalance");
            this.f75427q = str3;
            TextUtils.isEmpty(str3);
        }
        if (methodCall.hasArgument("totalBalance")) {
            String str4 = (String) methodCall.argument("totalBalance");
            this.f75428r = str4;
            TextUtils.isEmpty(str4);
        }
        if (methodCall.hasArgument("fiatTypeTotalBalance")) {
            this.f75429s = (String) methodCall.argument("fiatTypeTotalBalance");
        }
        this.f75433w = expressQuotePramBean;
        return expressQuotePramBean;
    }

    public final void tj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.hasArgument(FirebaseAnalytics.Param.CURRENCY)) {
                UnifyTransferActivity.Uh(this, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), "1", false, (String) null, false);
            }
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void uj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if (str.equals("initLiteTrade")) {
                Serializable serializableExtra = getIntent().getSerializableExtra("lite_re_extra_trade_channel");
                if (serializableExtra instanceof LiteTradeBean) {
                    LiteTradeBean liteTradeBean = (LiteTradeBean) serializableExtra;
                    liteTradeBean.setCurrencyId(g.c("otc_select_trade_currency_quote_asset"));
                    if (!m.a0(liteTradeBean.getCryptoCoinId())) {
                        liteTradeBean.setCryptoCoinId("0");
                    }
                    if (!m.a0(liteTradeBean.getCurrencyId())) {
                        liteTradeBean.setCurrencyId("14");
                    }
                    liteTradeBean.setScreenWidth(String.valueOf(PixelUtils.h((float) PixelUtils.g())));
                    liteTradeBean.setScreenHeight(String.valueOf(PixelUtils.h((float) PixelUtils.f())));
                    result.success(GsonHelper.a().toJson((Object) liteTradeBean));
                    return;
                }
                result.success((Object) null);
            } else if ("beginLiteFastTradeQuote".equals(str)) {
                jj(methodCall, result);
            } else if ("beginLiteSwitchBuySellType".equals(str)) {
                pj(methodCall, result);
            } else if ("beginLiteSwitchTradeType".equals(str)) {
                pj(methodCall, result);
            } else if ("beginLiteSwitchCoin".equals(str)) {
                pj(methodCall, result);
            } else if ("beginLiteSwitchCurrency".equals(str)) {
                mj(methodCall, result);
                pj(methodCall, result);
            } else if ("beginLiteTradeKeyboardChange".equals(str)) {
                pj(methodCall, result);
            } else if ("beginLiteGotoOrderList".equals(str)) {
                lj(methodCall, result);
            } else if ("beginLiteGotoDeposit".equals(str)) {
                kj(methodCall, result);
            } else if ("beginLiteTradeAutoRequestQuote".equals(str)) {
                nj(methodCall, result);
            } else if ("endLiteTradeAutoRequestQuote".equals(str)) {
                rj(methodCall, result);
            } else if ("shouldResetLiteTradeRequestQuote".equals(str)) {
                pj(methodCall, result);
            } else if ("beginLiteTradeShowCertification".equals(str)) {
                oj(methodCall, result);
            } else if ("gotoTransferPage".equals(str)) {
                tj(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }
}
