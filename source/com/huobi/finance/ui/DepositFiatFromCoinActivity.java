package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huobi.finance.bean.FiatDWEntrance;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

public class DepositFiatFromCoinActivity extends AbsFiatFromCoinActivity {

    /* renamed from: m  reason: collision with root package name */
    public String f46536m;

    /* renamed from: n  reason: collision with root package name */
    public String f46537n;

    /* renamed from: o  reason: collision with root package name */
    public int f46538o;

    public static void nj(Context context, String str, FiatDWEntrance fiatDWEntrance) {
        Intent intent = new Intent(context, DepositFiatFromCoinActivity.class);
        intent.putExtra("KEY_CURRENCY", str);
        intent.putExtra("KEY_EXTRA_ENTRANCE", fiatDWEntrance.getValue());
        context.startActivity(intent);
    }

    public static void oj(Context context, String str, String str2, FiatDWEntrance fiatDWEntrance) {
        Intent intent = new Intent(context, DepositFiatFromCoinActivity.class);
        intent.putExtra("KEY_CURRENCY", str);
        intent.putExtra("KEY_EXTRA_ENTRANCE", fiatDWEntrance.getValue());
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("KEY_CHANNEL", str2);
        }
        context.startActivity(intent);
    }

    public String Nh() {
        return "fiat_deposit";
    }

    public void Xi(MethodCall methodCall, MethodChannel.Result result) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FirebaseAnalytics.Param.CURRENCY, this.f46536m);
        jSONObject.put("entrance", this.f46538o);
        if (!TextUtils.isEmpty(this.f46537n)) {
            jSONObject.put(AppsFlyerProperties.CHANNEL, this.f46537n);
        }
        result.success(jSONObject.toString());
    }

    public /* bridge */ /* synthetic */ void Yi(MethodCall methodCall, MethodChannel.Result result) {
        super.Yi(methodCall, result);
    }

    public /* bridge */ /* synthetic */ void Zi(MethodCall methodCall, MethodChannel.Result result) {
        super.Zi(methodCall, result);
    }

    public /* bridge */ /* synthetic */ void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
    }

    public /* bridge */ /* synthetic */ void jj(MethodCall methodCall, MethodChannel.Result result) {
        super.jj(methodCall, result);
    }

    public /* bridge */ /* synthetic */ void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f46536m = intent.getStringExtra("KEY_CURRENCY");
            this.f46537n = intent.getStringExtra("KEY_CHANNEL");
            this.f46538o = intent.getIntExtra("KEY_EXTRA_ENTRANCE", FiatDWEntrance.unknown.getValue());
        }
        if (TextUtils.isEmpty(this.f46536m)) {
            finish();
        }
    }

    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public /* bridge */ /* synthetic */ void onTokenError(a aVar) {
        super.onTokenError(aVar);
    }
}
