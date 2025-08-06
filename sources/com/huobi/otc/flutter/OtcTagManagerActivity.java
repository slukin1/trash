package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class OtcTagManagerActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78592k;

    public static void Ei(Context context) {
        context.startActivity(new Intent(context, OtcTagManagerActivity.class));
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if (str.hashCode() == -1949106608) {
                str.equals("getInitData");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "otc_tag_manager";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_tag_manager_channel");
        this.f78592k = methodChannel;
        methodChannel.setMethodCallHandler(new i0(this));
    }
}
