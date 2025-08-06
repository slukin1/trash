package com.huobi.litere.market.ui;

import android.content.Context;
import android.content.Intent;
import com.huobi.litere.BaseLiteReFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class LiteReMarketFlutterActivity extends BaseLiteReFlutterActivity {

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            try {
                if ("getCoinId".equals(methodCall.method)) {
                    result.success(Integer.valueOf(LiteReMarketFlutterActivity.this.getIntent().getIntExtra("lite_market_coin_id", -1)));
                } else {
                    result.notImplemented();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                result.notImplemented();
            }
        }
    }

    public static void jj(Context context, Integer num) {
        Intent intent = new Intent(context, LiteReMarketFlutterActivity.class);
        if (num != null) {
            intent.putExtra("lite_market_coin_id", num);
        }
        context.startActivity(intent);
    }

    public String Nh() {
        return "lite_market";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "lite_market_channel").setMethodCallHandler(new a());
    }
}
