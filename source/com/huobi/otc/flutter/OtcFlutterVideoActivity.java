package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class OtcFlutterVideoActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78505k;

    /* renamed from: l  reason: collision with root package name */
    public String f78506l;

    public static void Ei(Context context, String str) {
        Intent intent = new Intent(context, OtcFlutterVideoActivity.class);
        intent.putExtra("key_otc_video_url", str);
        context.startActivity(intent);
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            if (str.hashCode() == -1065688982) {
                if (str.equals("getVideoUrl")) {
                    c11 = 0;
                }
            }
            if (c11 == 0) {
                result.success(this.f78506l);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "otc_video_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_video_channel");
        this.f78505k = methodChannel;
        methodChannel.setMethodCallHandler(new w(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f78506l = getIntent().getStringExtra("key_otc_video_url");
    }
}
