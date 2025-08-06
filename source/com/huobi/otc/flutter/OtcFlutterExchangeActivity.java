package com.huobi.otc.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.utils.GsonHelper;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;

public class OtcFlutterExchangeActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f78485k;

    /* renamed from: l  reason: collision with root package name */
    public String f78486l;

    /* renamed from: m  reason: collision with root package name */
    public MethodChannel f78487m;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            OtcFlutterExchangeActivity.this.Di(methodCall, result);
        }
    }

    public static void Ei(Context context, String str, String str2) {
        Intent intent = new Intent(context, OtcFlutterExchangeActivity.class);
        if (!(str == null || str2 == null)) {
            intent.putExtra("key_from_coin", str);
            intent.putExtra("key_to_coin", str2);
        }
        if (OtcModuleConfig.a().a()) {
            context.startActivity(intent);
        } else {
            OtcModuleConfig.a().l((Activity) context, intent, (Intent) null);
        }
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if ("getInitData".equals(methodCall.method)) {
                HashMap hashMap = new HashMap();
                String str = this.f78485k;
                String str2 = "";
                if (str == null) {
                    str = str2;
                }
                hashMap.put("from", str);
                String str3 = this.f78486l;
                if (str3 != null) {
                    str2 = str3;
                }
                hashMap.put("to", str2);
                result.success(GsonHelper.a().toJson((Object) hashMap));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "otc_exchange";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_exchange_channel");
        this.f78487m = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("key_from_coin")) {
            this.f78485k = getIntent().getStringExtra("key_from_coin");
        }
        if (getIntent().hasExtra("key_to_coin")) {
            this.f78486l = getIntent().getStringExtra("key_to_coin");
        }
    }
}
