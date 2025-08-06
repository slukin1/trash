package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.helper.OtcMerchantProfileSwither;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class OtcMyFollowedFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78517k;

    public static void Ei(Context context) {
        context.startActivity(new Intent(context, OtcMyFollowedFlutterActivity.class));
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.method.equals("presentMerchantDetailPage")) {
                OtcMerchantProfileSwither.a(this, Long.valueOf((String) methodCall.arguments));
            }
        } catch (Exception unused) {
            result.notImplemented();
        }
    }

    public String Nh() {
        return "merchant_attention_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "merchant_attention_channel");
        this.f78517k = methodChannel;
        methodChannel.setMethodCallHandler(new a0(this));
    }
}
