package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class OtcPricePromptActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78543k;

    public static void Ei(Context context) {
        context.startActivity(new Intent(context, OtcPricePromptActivity.class));
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            if (str.hashCode() == -2092872502) {
                if (str.equals("toCreatePromptPage")) {
                    c11 = 0;
                }
            }
            if (c11 == 0) {
                OtcModuleConfig.b().d(this);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "otc_price_prompt_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "price_prompt_channel");
        this.f78543k = methodChannel;
        methodChannel.setMethodCallHandler(new f0(this));
    }
}
