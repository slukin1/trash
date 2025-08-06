package com.huobi.otc.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import oa.a;

public class OtcVideoTutorialActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78609k;

    /* renamed from: l  reason: collision with root package name */
    public String f78610l;

    public static void Ei(Context context, String str) {
        Intent intent = new Intent(context, OtcVideoTutorialActivity.class);
        intent.putExtra("key_otc_video_url", str);
        context.startActivity(intent);
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1065688982) {
                if (hashCode == 1797117560) {
                    if (str.equals("dismissTutorialFragment")) {
                        c11 = 1;
                    }
                }
            } else if (str.equals("getVideoUrl")) {
                c11 = 0;
            }
            if (c11 == 0) {
                result.success(this.f78610l);
            } else if (c11 == 1) {
                Activity f11 = a.g().f(OtcTradeActivity.class);
                if (f11 != null && (f11 instanceof OtcTradeActivity)) {
                    ((OtcTradeActivity) f11).Fh();
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "otc_tutorial_video_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_tutorial_video_channel");
        this.f78609k = methodChannel;
        methodChannel.setMethodCallHandler(new t0(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f78610l = getIntent().getStringExtra("key_otc_video_url");
    }
}
