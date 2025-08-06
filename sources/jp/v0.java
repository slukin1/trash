package jp;

import al.w;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.finance.ui.UnifyRiskActivity;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.otc.event.OtcRefreshMessageEvent;
import com.huobi.otc.flutter.OtcDepositDetailFlutterActivity;
import com.huobi.otc.flutter.OtcOrderDepositFragment;
import com.huobi.otc.helper.OtcMerchantProfileSwither;
import com.huobi.otc.persenter.OtcTradePresenter;
import cp.c;
import d7.k;
import d7.q0;
import dp.t;
import i6.d;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;
import u6.g;

public class v0 {

    /* renamed from: h  reason: collision with root package name */
    public static final String f84380h = OtcOrderDepositFragment.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public boolean f84381a;

    /* renamed from: b  reason: collision with root package name */
    public int f84382b;

    /* renamed from: c  reason: collision with root package name */
    public MethodChannel f84383c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84384d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f84385e;

    /* renamed from: f  reason: collision with root package name */
    public t f84386f;

    /* renamed from: g  reason: collision with root package name */
    public com.huobi.otc.helper.a f84387g;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f84388a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel f84389b;

        public a(MethodCall methodCall, MethodChannel methodChannel) {
            this.f84388a = methodCall;
            this.f84389b = methodChannel;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", this.f84388a.argument("action"));
            hashMap.put("securityToken", str);
            this.f84389b.invokeMethod("orderRelease", hashMap);
        }

        public void d(BaseDialogFragment baseDialogFragment) {
        }

        public void e() {
        }

        public void f(t tVar) {
            t unused = v0.this.f84386f = tVar;
        }

        public boolean g() {
            return false;
        }

        public void h(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", this.f84388a.argument("action"));
            hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, str);
            this.f84389b.invokeMethod("orderRelease", hashMap);
            if (v0.this.f84386f != null && v0.this.f84386f.isShowing()) {
                v0.this.f84386f.dismiss();
            }
        }
    }

    public class b implements c {

        public class a extends Security2FADialogHelper.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Security2FADialogHelper f84392a;

            public a(Security2FADialogHelper security2FADialogHelper) {
                this.f84392a = security2FADialogHelper;
            }

            public void onFailed(String str) {
            }

            public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                v0.this.f84387g.s().c(authResult.getToken());
                this.f84392a.v();
            }
        }

        /* renamed from: jp.v0$b$b  reason: collision with other inner class name */
        public class C0872b implements c {
            public C0872b() {
            }

            public void call() {
                v0.this.f84387g.I();
            }
        }

        public b() {
        }

        public void call() {
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper((FragmentActivity) v0.this.f84385e, (g) v0.this.f84385e, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.S(new a(security2FADialogHelper), new C0872b());
        }
    }

    public v0(Activity activity) {
        this.f84385e = activity;
    }

    public void g(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_all_order_channel");
        this.f84383c = methodChannel;
        methodChannel.setMethodCallHandler(new u0(this));
        new MethodChannel(flutterEngine.getDartExecutor(), "dw_record_channel").setMethodCallHandler(new t0(this));
    }

    public final void h(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            String str2 = f84380h;
            d.c(str2, "onMethodCall method=" + str);
            if ("initDWRecord".equals(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PlaceFields.PAGE, 1);
                jSONObject.put("isFromOtc", true);
                jSONObject.put("currencyDisplayNameList", new JSONArray(j()));
                result.success(jSONObject.toString());
            } else if ("initFaitDWRecord".equals(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("currencyDisplayNameList", new JSONArray(k()));
                result.success(jSONObject2.toString());
            } else if ("showDatePickerView".equals(str)) {
                cl.d.d(this.f84385e, methodCall, result);
            } else if ("getSafeConfirmCount".equals(str)) {
                m(methodCall, result);
            } else if ("getChainDisplayName".equals(str)) {
                i(methodCall, result);
            } else if ("getSmallAmount".equals(str)) {
                n(methodCall, result);
            } else if ("goToVerify".equals(str)) {
                o(methodCall, result);
            } else if ("depositPay".equals(str)) {
                CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo = new CurrencyFromCCFinanceRecordInfo();
                currencyFromCCFinanceRecordInfo.setOrderCode((String) methodCall.argument("orderCode"));
                currencyFromCCFinanceRecordInfo.setCurrency((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY));
                w.l(this.f84385e, currencyFromCCFinanceRecordInfo);
                result.success((Object) null);
            } else if ("gotoRecordDetailPage".equals(str)) {
                Map map = (Map) methodCall.arguments;
                OtcDepositDetailFlutterActivity.Ti(this.f84385e, Long.valueOf((String) map.get("key_record_id")).longValue(), ((Boolean) map.get("key_is_withdraw")).booleanValue(), true);
                result.success((Object) null);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void i(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        if (F == null) {
            result.success("");
        } else {
            result.success(F.getDisplayName());
        }
    }

    public List<String> j() {
        List<CurrencyBean> g11 = q0.g();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < g11.size(); i11++) {
            CurrencyBean currencyBean = g11.get(i11);
            if (currencyBean != null && currencyBean.isVisible() && !currencyBean.isEtpTag()) {
                arrayList.add(currencyBean.getDisplayName());
            }
        }
        return arrayList;
    }

    public List<String> k() {
        List<CurrencyBean> g11 = q0.g();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < g11.size(); i11++) {
            CurrencyBean currencyBean = g11.get(i11);
            if (currencyBean != null && currencyBean.isVisible() && !currencyBean.isEtpTag() && currencyBean.isFiatTag()) {
                arrayList.add(currencyBean.getDisplayName());
            }
        }
        return arrayList;
    }

    public String l() {
        return "otc_all_order";
    }

    public final void m(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        String valueOf = F != null ? String.valueOf(F.getSafeConfirms()) : "";
        String str = f84380h;
        d.c(str, "getSafeConfirmCount=" + valueOf);
        result.success(valueOf);
    }

    public final void n(MethodCall methodCall, MethodChannel.Result result) {
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

    public final void o(MethodCall methodCall, MethodChannel.Result result) {
        this.f84385e.startActivity(UnifyRiskActivity.Ch(this.f84385e, Long.parseLong((String) methodCall.argument("transactionId")), 1));
        result.success((Object) null);
    }

    public void p(int i11) {
        this.f84383c.invokeMethod("onBottomTabChange", Integer.valueOf(i11));
    }

    public void q(Intent intent) {
        this.f84381a = intent.getBooleanExtra("extra_select_deposit", false);
        if (intent.hasExtra("orderStatus")) {
            String stringExtra = intent.getStringExtra("orderStatus");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    this.f84382b = Integer.valueOf(stringExtra).intValue();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else {
                this.f84382b = intent.getIntExtra("orderStatus", 0);
            }
        }
    }

    public void r(Bundle bundle) {
        this.f84384d = bundle.getBoolean("extra_hide_titleBar", false);
        this.f84381a = bundle.getBoolean("extra_select_deposit", false);
    }

    public final void s(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            String str2 = f84380h;
            d.c(str2, "native->onMethodCall method=" + str + ",arguments=" + methodCall.arguments);
            char c11 = 65535;
            int i11 = 1;
            switch (str.hashCode()) {
                case -1949106608:
                    if (str.equals("getInitData")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1836262593:
                    if (str.equals("showFundPasswordAlert")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -591998849:
                    if (str.equals("onUnreadClear")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -14387093:
                    if (str.equals("goToMerchant")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 361623584:
                    if (str.equals("hideTabBar")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 793671067:
                    if (str.equals("showTabBar")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1105016966:
                    if (str.equals("onTabChange")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1358957435:
                    if (str.equals("goToChat")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1504052156:
                    if (str.equals("goToOrderDetail")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1725199645:
                    if (str.equals("goToOrderPay")) {
                        c11 = 7;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    HashMap hashMap = new HashMap();
                    hashMap.put("tabPage", Integer.valueOf(this.f84381a ? 1 : 0));
                    hashMap.put("advertMode", Integer.valueOf(b1.h().j() ? 1 : 0));
                    hashMap.put("hideTitleBar", Integer.valueOf(this.f84384d ? 1 : 0));
                    if (!this.f84384d) {
                        i11 = 0;
                    }
                    hashMap.put("embedded", Integer.valueOf(i11));
                    hashMap.put("orderStatus", Integer.valueOf(this.f84382b));
                    result.success(hashMap);
                    d.c(str2, "native->getInitData dataMap=" + hashMap);
                    return;
                case 1:
                    int intValue = ((Integer) methodCall.argument("tabIndex")).intValue();
                    Activity activity = this.f84385e;
                    if (activity instanceof OtcTradePresenter.i) {
                        ((OtcTradePresenter.i) activity).oe(intValue);
                    }
                    result.success((Object) null);
                    return;
                case 2:
                    l0.b(this.f84385e, (String) methodCall.argument("orderId"), false);
                    result.success((Object) null);
                    return;
                case 3:
                    ((Integer) methodCall.argument("orderStatus")).intValue();
                    v1.a().g(this.f84385e, (String) methodCall.argument("orderId"), false);
                    result.success((Object) null);
                    return;
                case 4:
                    OtcMerchantProfileSwither.a(this.f84385e, Long.valueOf(methodCall.argument("counterpartUid").toString()));
                    result.success((Object) null);
                    return;
                case 5:
                    Activity activity2 = this.f84385e;
                    if (activity2 instanceof OtcTradePresenter.i) {
                        ((OtcTradePresenter.i) activity2).y5(true);
                    }
                    result.success((Object) null);
                    return;
                case 6:
                    Activity activity3 = this.f84385e;
                    if (activity3 instanceof OtcTradePresenter.i) {
                        ((OtcTradePresenter.i) activity3).y5(false);
                    }
                    result.success((Object) null);
                    return;
                case 7:
                    OtcModuleConfig.a().d0(this.f84385e, (String) methodCall.argument("orderId"), "", "");
                    result.success((Object) null);
                    return;
                case 8:
                    EventBus.d().k(new OtcRefreshMessageEvent());
                    return;
                case 9:
                    t(methodCall, this.f84383c);
                    result.success((Object) null);
                    break;
            }
            result.notImplemented();
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void t(MethodCall methodCall, MethodChannel methodChannel) {
        if (this.f84387g == null) {
            Activity activity = this.f84385e;
            this.f84387g = new com.huobi.otc.helper.a((FragmentActivity) activity, (g) activity);
        }
        this.f84387g.J(new a(methodCall, methodChannel));
        this.f84387g.M(new b());
    }
}
