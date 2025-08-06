package com.huobi.otc.flutter;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.finance.ui.DwRecordActivity;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import com.huobi.otc.ui.OtcTradeActivity;
import d7.k;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import jp.b;
import u6.g;

public class DepositCurrencySearchFragment extends AbsGlobalFlutterFragment {

    /* renamed from: i  reason: collision with root package name */
    public String f78424i = "1";

    /* renamed from: j  reason: collision with root package name */
    public int f78425j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f78426k = true;

    /* renamed from: l  reason: collision with root package name */
    public Map<String, CurrencyBean> f78427l = new HashMap();

    public static /* synthetic */ Boolean di(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ei(CurrencyBean currencyBean, Boolean bool) {
        ci(currencyBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(CurrencyBean currencyBean, APIStatusErrorException aPIStatusErrorException) {
        ci(currencyBean);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gi(CurrencyBean currencyBean, Throwable th2) {
        ci(currencyBean);
    }

    public String Bh() {
        return "coin_list_from_otc";
    }

    public final void ai(CurrencyBean currencyBean) {
        if (currencyBean != null) {
            if (currencyBean.isFiatTag()) {
                new OtcFaitDWJumpHelper(getActivity(), (OtcTradeActivity) getActivity(), currencyBean.getName()).t(OtcFaitDWJumpHelper.f78855g, currencyBean.getName());
            } else if (!this.f78426k) {
                ci(currencyBean);
            } else {
                DepositWithdrawController.l(getActivity(), currencyBean.getName()).filter(j.f78653b).compose(RxJavaHelper.t((g) null)).subscribe(EasySubscriber.create(new e(this, currencyBean), new d(this, currencyBean), new f(this, currencyBean)));
            }
        }
    }

    public String bi(String str) {
        return SP.i(str, "");
    }

    public final void ci(CurrencyBean currencyBean) {
        UnifyDepositActivity.wh(getActivity(), currencyBean.getName());
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "coin_list_channel").setMethodCallHandler(new c(this));
    }

    public void ki(MethodCall methodCall, MethodChannel.Result result) {
        d.j("flutter", "onMethodCallExtend method - " + methodCall.method);
        d.j("flutter", "onMethodCallExtend arguments - " + methodCall.arguments);
        try {
            String str = methodCall.method;
            if ("initCoinList".equals(str)) {
                b.b().f(result, true, this.f78424i, this.f78425j, this.f78426k, this.f78427l);
            } else if ("refreshCoinData".equals(str)) {
                k.C().E(false).compose(RxJavaHelper.t((g) null)).subscribe(q6.d.d(this, new i(result), new g(result), new h(result)));
            } else if ("selectedCurrency".equals(str)) {
                String str2 = (String) methodCall.argument("fiatValue");
                if (str2 == null || str2.isEmpty()) {
                    String str3 = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
                    d.b("CurrencySearchActivity-->onMethodCall-->selectedCurrency:" + str3);
                    if (!TextUtils.isEmpty(str3)) {
                        li(str3);
                        result.success((Object) null);
                        return;
                    }
                    return;
                }
                mi(str2);
                result.success((Object) null);
            } else if ("saveCoins".equals(str)) {
                String str4 = (String) methodCall.argument("coins");
                String str5 = (String) methodCall.argument("key");
                d.j("flutter", "saveCoins#coins - " + str4);
                d.j("flutter", "saveCoins#key - " + str5);
                ni(str4, str5);
                result.success((Object) null);
            } else if ("getCoins".equals(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("coins", bi((String) methodCall.argument("key")));
                String json = new Gson().toJson((Object) hashMap);
                d.j("flutter", "getCoins#jsonStr - " + json);
                result.success(json);
            } else if ("gotoDwRecordPage".equals(str)) {
                DwRecordActivity.Ji(getActivity(), ((Integer) methodCall.argument("pageType")).intValue());
                result.success((Object) null);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void li(String str) {
        ai(this.f78427l.get(StringUtils.g(str)));
    }

    public void mi(String str) {
        new OtcFaitDWJumpHelper(getActivity(), (OtcTradeActivity) getActivity(), str).t(OtcFaitDWJumpHelper.f78855g, str);
    }

    public void ni(String str, String str2) {
        SP.s(str2, str);
    }
}
