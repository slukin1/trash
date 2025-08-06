package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.huobi.finance.bean.FiatChannelConfig;
import com.huobi.finance.bean.FiatDWEntrance;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.ThreadMode;

public class WithdrawFiatFromCoinActivity extends AbsFiatFromCoinActivity {

    /* renamed from: m  reason: collision with root package name */
    public String f47005m;

    /* renamed from: n  reason: collision with root package name */
    public int f47006n;

    public static void nj(Context context, String str, FiatDWEntrance fiatDWEntrance) {
        Intent intent = new Intent(context, WithdrawFiatFromCoinActivity.class);
        intent.putExtra("KEY_CURRENCY", str);
        intent.putExtra("KEY_EXTRA_ENTRANCE", fiatDWEntrance.getValue());
        context.startActivity(intent);
    }

    public String Nh() {
        return "fiat_withdraw";
    }

    public void Yi(MethodCall methodCall, MethodChannel.Result result) {
        super.Yi(methodCall, result);
        try {
            FiatChannelConfig fiatChannelConfig = new FiatChannelConfig();
            fiatChannelConfig.setCurrency(this.f47005m);
            fiatChannelConfig.setEntrance(this.f47006n);
            result.success(new Gson().toJson((Object) fiatChannelConfig));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
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
        this.f47005m = intent != null ? intent.getStringExtra("KEY_CURRENCY") : null;
        this.f47006n = intent != null ? intent.getIntExtra("KEY_EXTRA_ENTRANCE", FiatDWEntrance.unknown.getValue()) : FiatDWEntrance.unknown.getValue();
        if (TextUtils.isEmpty(this.f47005m)) {
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
