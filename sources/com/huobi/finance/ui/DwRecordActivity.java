package com.huobi.finance.ui;

import al.w;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.otc.flutter.OtcDepositDetailFlutterActivity;
import com.huobi.utils.k0;
import d7.k;
import d7.q0;
import i6.d;
import i6.m;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.huobi.R;
import rn.c;
import tg.r;

public class DwRecordActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f46539k;

    /* renamed from: l  reason: collision with root package name */
    public int f46540l;

    public static void Ji(Activity activity, int i11) {
        Intent intent = new Intent(activity, DwRecordActivity.class);
        intent.putExtra("dw_record_type", i11);
        if (r.x().F0()) {
            activity.startActivity(intent);
        } else {
            c.i().d(activity, new JumpTarget(intent, (Intent) null));
        }
    }

    public final void Di(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        if (F == null) {
            result.success("");
        } else {
            result.success(F.getDisplayName());
        }
    }

    public List<String> Ei() {
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

    public List<String> Fi() {
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

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        ChainInfo F = k.C().F((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY), (String) methodCall.argument("chain"));
        String valueOf = F != null ? String.valueOf(F.getSafeConfirms()) : "";
        d.c("DwRecordActivity", "getSafeConfirmCount=" + valueOf);
        result.success(valueOf);
    }

    public final void Hi(MethodCall methodCall, MethodChannel.Result result) {
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

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        startActivity(UnifyRiskActivity.Ch(this, Long.parseLong((String) methodCall.argument("transactionId")), 1));
        result.success((Object) null);
    }

    public String Nh() {
        return "dw_record";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "dw_record_channel");
        this.f46539k = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f46540l = getIntent().getIntExtra("dw_record_type", 1);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            d.c("DwRecordActivity", "onMethodCall method=" + str);
            if ("initDWRecord".equals(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PlaceFields.PAGE, this.f46540l);
                jSONObject.put("isFromOtc", false);
                jSONObject.put("currencyDisplayNameList", new JSONArray(Ei()));
                result.success(jSONObject.toString());
            } else if ("initFaitDWRecord".equals(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("currencyDisplayNameList", new JSONArray(Fi()));
                result.success(jSONObject2.toString());
            } else if ("showDatePickerView".equals(str)) {
                cl.d.d(this, methodCall, result);
            } else if ("getSafeConfirmCount".equals(str)) {
                Gi(methodCall, result);
            } else if ("getChainDisplayName".equals(str)) {
                Di(methodCall, result);
            } else if ("getSmallAmount".equals(str)) {
                Hi(methodCall, result);
            } else if ("goToVerify".equals(str)) {
                Ii(methodCall, result);
            } else if ("depositPay".equals(str)) {
                CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo = new CurrencyFromCCFinanceRecordInfo();
                currencyFromCCFinanceRecordInfo.setOrderCode((String) methodCall.argument("orderCode"));
                currencyFromCCFinanceRecordInfo.setCurrency((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY));
                w.l(this, currencyFromCCFinanceRecordInfo);
                result.success((Object) null);
            } else if ("gotoRecordDetailPage".equals(str)) {
                Map map = (Map) methodCall.arguments;
                OtcDepositDetailFlutterActivity.Ti(this, Long.valueOf((String) map.get("key_record_id")).longValue(), ((Boolean) map.get("key_is_withdraw")).booleanValue(), true);
                result.success((Object) null);
            } else {
                super.onMethodCall(methodCall, result);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
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
    public void onTokenError(a aVar) {
        c.i().m(this, new JumpTarget(k0.c(this), k0.h(this)));
    }

    public SplashScreen provideSplashScreen() {
        return new DrawableSplashScreen(new ColorDrawable(getResources().getColor(R.color.baseColorContentBackground)), ImageView.ScaleType.FIT_XY, 200);
    }
}
