package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.huobi.finance.bean.FiatChannelConfig;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.ThreadMode;

public class FiatResultFromCoinActivity extends AbsFiatFromCoinActivity {

    /* renamed from: m  reason: collision with root package name */
    public int f46543m;

    /* renamed from: n  reason: collision with root package name */
    public String f46544n;

    /* renamed from: o  reason: collision with root package name */
    public String f46545o;

    public static void nj(Context context, String str, int i11, String str2) {
        Intent intent = new Intent(context, FiatResultFromCoinActivity.class);
        intent.putExtra("KEY_ORDER_CODE", str);
        intent.putExtra("KEY_TYPE", i11);
        intent.putExtra("KEY_CURRENCY", str2);
        context.startActivity(intent);
    }

    public String Nh() {
        return "fiat_order_result_detail";
    }

    public /* bridge */ /* synthetic */ void Yi(MethodCall methodCall, MethodChannel.Result result) {
        super.Yi(methodCall, result);
    }

    public void Zi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FiatChannelConfig fiatChannelConfig = new FiatChannelConfig();
            fiatChannelConfig.setType(this.f46543m);
            fiatChannelConfig.setOrderCode(this.f46544n);
            fiatChannelConfig.setCurrency(this.f46545o);
            result.success(new Gson().toJson((Object) fiatChannelConfig));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
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
        String str = null;
        this.f46544n = intent != null ? intent.getStringExtra("KEY_ORDER_CODE") : null;
        this.f46543m = intent != null ? intent.getIntExtra("KEY_TYPE", -1) : -1;
        if (intent != null) {
            str = intent.getStringExtra("KEY_CURRENCY");
        }
        this.f46545o = str;
        if (TextUtils.isEmpty(this.f46544n) || this.f46543m == -1 || TextUtils.isEmpty(this.f46545o)) {
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
