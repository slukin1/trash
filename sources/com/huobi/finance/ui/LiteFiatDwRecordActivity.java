package com.huobi.finance.ui;

import al.w;
import android.app.Activity;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.huobi.login.bean.JumpTarget;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import rn.c;
import tg.r;

public class LiteFiatDwRecordActivity extends DwRecordActivity {

    /* renamed from: m  reason: collision with root package name */
    public MethodChannel f46593m;

    public static void Ki(Activity activity) {
        Intent intent = new Intent(activity, LiteFiatDwRecordActivity.class);
        if (r.x().F0()) {
            activity.startActivity(intent);
        } else {
            c.i().d(activity, new JumpTarget(intent, (Intent) null));
        }
    }

    public String Nh() {
        return "lite_fiat_dw_record";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "fiat_channel");
        this.f46593m = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            d.c("LiteFiatDwRecordActivit", "onMethodCall method=" + str);
            if ("depositPay".equals(str)) {
                CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo = new CurrencyFromCCFinanceRecordInfo();
                currencyFromCCFinanceRecordInfo.setOrderCode((String) methodCall.argument("orderCode"));
                currencyFromCCFinanceRecordInfo.setCurrency((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY));
                w.l(this, currencyFromCCFinanceRecordInfo);
                result.success((Object) null);
                return;
            }
            super.onMethodCall(methodCall, result);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }
}
