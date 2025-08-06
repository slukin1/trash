package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import org.json.JSONObject;
import up.g;

public class OtcPriceCreateActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78542k;

    public static void Ei(Context context) {
        context.startActivity(new Intent(context, OtcPriceCreateActivity.class));
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            if (str.hashCode() == -1949106608) {
                if (str.equals("getInitData")) {
                    c11 = 0;
                }
            }
            if (c11 == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("quoteName", g.c("otc_select_trade_currency_quote_asset"));
                hashMap.put("coinName", g.b());
                result.success(new JSONObject(hashMap).toString());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "otc_price_create_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "price_create_channel");
        this.f78542k = methodChannel;
        methodChannel.setMethodCallHandler(new e0(this));
    }
}
