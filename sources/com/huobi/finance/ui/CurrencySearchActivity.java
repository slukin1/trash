package com.huobi.finance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import d7.k;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import is.a;
import java.util.HashMap;
import java.util.Map;
import jp.b;
import u6.g;

@Route(path = "/balance/depositSearch")
public class CurrencySearchActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f46531k;

    /* renamed from: l  reason: collision with root package name */
    public int f46532l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f46533m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f46534n;

    /* renamed from: o  reason: collision with root package name */
    public Map<String, CurrencyBean> f46535o = new HashMap();

    /* access modifiers changed from: private */
    public /* synthetic */ void Ti(CurrencyBean currencyBean, Throwable th2) {
        Ri(currencyBean);
    }

    public static /* synthetic */ Boolean Ui(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vi(CurrencyBean currencyBean, Boolean bool) {
        Ri(currencyBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wi(CurrencyBean currencyBean, APIStatusErrorException aPIStatusErrorException) {
        Ri(currencyBean);
    }

    public static /* synthetic */ Boolean Xi(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yi(CurrencyBean currencyBean, Boolean bool) {
        Si(currencyBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zi(CurrencyBean currencyBean, APIStatusErrorException aPIStatusErrorException) {
        Si(currencyBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aj(CurrencyBean currencyBean, Throwable th2) {
        Si(currencyBean);
    }

    public static void jj(Activity activity, String str, int i11, boolean z11) {
        Intent intent = new Intent(activity, CurrencySearchActivity.class);
        intent.putExtra("extra_type", str);
        intent.putExtra("extra_from", i11);
        intent.putExtra("JUMP_RECHOOSE", z11);
        if (z11) {
            activity.startActivityForResult(intent, 1001);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void kj(Activity activity, String str, int i11, boolean z11, boolean z12) {
        Intent intent = new Intent(activity, CurrencySearchActivity.class);
        intent.putExtra("extra_type", str);
        intent.putExtra("extra_from", i11);
        intent.putExtra("JUMP_RECHOOSE", z11);
        intent.putExtra("SHOW_DISABLE_DEPOSIT", z12);
        if (z11) {
            activity.startActivityForResult(intent, 1001);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void lj(Activity activity, String str, boolean z11) {
        jj(activity, str, 0, z11);
    }

    public String Nh() {
        return this.f46532l == 1 ? "coin_tab_list" : "coin_list";
    }

    public final void Oi(CurrencyBean currencyBean) {
        if (currencyBean != null) {
            if (currencyBean.isFiatTag()) {
                new OtcFaitDWJumpHelper(this, this, currencyBean.getName()).t(OtcFaitDWJumpHelper.f78855g, currencyBean.getName());
            } else if (!this.f46534n) {
                Ri(currencyBean);
            } else {
                DepositWithdrawController.l(this, currencyBean.getName()).filter(a5.f47041b).compose(RxJavaHelper.t(this)).subscribe(EasySubscriber.create(new f5(this, currencyBean), new d5(this, currencyBean), new i5(this, currencyBean)));
            }
        }
    }

    public final void Pi(CurrencyBean currencyBean) {
        if (currencyBean != null) {
            if (currencyBean.isFiatTag()) {
                CurrencyFromCCDetailActivity.Uh(this, this, currencyBean.getName(), new y4(this));
            } else {
                DepositWithdrawController.m(this, currencyBean.getName()).filter(b5.f47056b).compose(RxJavaHelper.t(this)).subscribe(EasySubscriber.create(new g5(this, currencyBean), new e5(this, currencyBean), new h5(this, currencyBean)));
            }
        }
    }

    public String Qi(String str) {
        return SP.i(str, "");
    }

    public final void Ri(CurrencyBean currencyBean) {
        if (this.f46533m) {
            setResult(-1, new Intent().putExtra("coin", currencyBean.getName()));
        } else {
            UnifyDepositActivity.wh(this, currencyBean.getName());
        }
        finish();
    }

    public final void Si(CurrencyBean currencyBean) {
        if (this.f46533m) {
            setResult(-1, new Intent().putExtra("coin", currencyBean.getName()));
        } else {
            UnifyWithdrawActivity.Di(this, currencyBean.getName(), TradeType.PRO);
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "coin_list_channel").setMethodCallHandler(new c5(this));
    }

    public void ej(MethodCall methodCall, MethodChannel.Result result) {
        d.j("flutter", "onMethodCallExtend method - " + methodCall.method);
        d.j("flutter", "onMethodCallExtend arguments - " + methodCall.arguments);
        try {
            String str = methodCall.method;
            if ("initCoinList".equals(str)) {
                if (this instanceof TransferChooseCurrencyActivity) {
                    hj(result);
                    return;
                }
                b.b().f(result, true, this.f46531k, this.f46532l, this.f46534n, this.f46535o);
            } else if ("refreshCoinData".equals(str)) {
                k.C().E(false).compose(RxJavaHelper.t((g) null)).subscribe(q6.d.d(this, new z4(result), new j5(result), new k5(result)));
            } else if ("selectedCurrency".equals(str)) {
                String str2 = (String) methodCall.argument("fiatValue");
                if (str2 == null || str2.isEmpty()) {
                    String str3 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
                    d.b("CurrencySearchActivity-->onMethodCall-->selectedCurrency:" + str3);
                    if (!TextUtils.isEmpty(str3)) {
                        fj(str3);
                        result.success((Object) null);
                        return;
                    }
                    return;
                }
                gj(str2);
                result.success((Object) null);
            } else if ("saveCoins".equals(str)) {
                String str4 = (String) methodCall.argument("coins");
                String str5 = (String) methodCall.argument("key");
                d.j("flutter", "saveCoins#coins - " + str4);
                d.j("flutter", "saveCoins#key - " + str5);
                ij(str4, str5);
                result.success((Object) null);
            } else if ("getCoins".equals(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("coins", Qi((String) methodCall.argument("key")));
                String json = new Gson().toJson((Object) hashMap);
                d.j("flutter", "getCoins#jsonStr - " + json);
                result.success(json);
            } else if ("gotoDwRecordPage".equals(str)) {
                DwRecordActivity.Ji(this, ((Integer) methodCall.argument("pageType")).intValue());
                result.success((Object) null);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void fj(String str) {
        CurrencyBean currencyBean = this.f46535o.get(StringUtils.g(str));
        if ("1".equals(this.f46531k)) {
            Oi(currencyBean);
        } else if ("2".equals(this.f46531k)) {
            Pi(currencyBean);
        }
    }

    public void gj(String str) {
        if ("1".equals(this.f46531k)) {
            new OtcFaitDWJumpHelper(this, this, str).t(OtcFaitDWJumpHelper.f78855g, str);
        } else if ("2".equals(this.f46531k)) {
            CurrencyFromCCDetailActivity.Uh(this, this, str, new y4(this));
        }
    }

    public void hj(MethodChannel.Result result) {
    }

    public void ij(String str, String str2) {
        SP.s(str2, str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f46531k = getIntent().getStringExtra("extra_type");
        this.f46532l = getIntent().getIntExtra("extra_from", 0);
        this.f46533m = getIntent().getBooleanExtra("JUMP_RECHOOSE", false);
        this.f46534n = getIntent().getBooleanExtra("SHOW_DISABLE_DEPOSIT", true);
    }

    public void onStop() {
        super.onStop();
        if ("1".equals(this.f46531k)) {
            a.n("126", "1005138", (String) null, (Map<String, Object>) null);
        } else if ("2".equals(this.f46531k)) {
            a.n("126", "1005140", (String) null, (Map<String, Object>) null);
        }
    }
}
