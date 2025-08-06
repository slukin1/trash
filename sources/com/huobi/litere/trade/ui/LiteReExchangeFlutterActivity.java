package com.huobi.litere.trade.ui;

import android.content.Context;
import android.content.Intent;
import com.huobi.litere.BaseLiteReFlutterActivity;
import com.huobi.litere.bean.LiteExchangeBean;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import org.json.JSONObject;

public class LiteReExchangeFlutterActivity extends BaseLiteReFlutterActivity {

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            LiteReExchangeFlutterActivity.this.jj(methodCall, result);
        }
    }

    public static void kj(Context context, LiteExchangeBean liteExchangeBean) {
        Intent intent = new Intent(context, LiteReExchangeFlutterActivity.class);
        if (liteExchangeBean != null) {
            intent.putExtra("lite_re_exchange", liteExchangeBean);
        }
        context.startActivity(intent);
    }

    public String Nh() {
        return "lite_coin_convert";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "lite_re_exchange_channel").setMethodCallHandler(new a());
    }

    public void jj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.method.equals("getExchangeCoinInfo")) {
                Serializable serializableExtra = getIntent().getSerializableExtra("lite_re_exchange");
                if (serializableExtra instanceof LiteExchangeBean) {
                    LiteExchangeBean liteExchangeBean = (LiteExchangeBean) serializableExtra;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("cryptoCoinId", liteExchangeBean.getCryptoCoinId());
                    jSONObject.put("quoteCoinId", liteExchangeBean.getQuoteCoinId());
                    result.success(jSONObject.toString());
                    return;
                }
                result.success((Object) null);
                return;
            }
            result.notImplemented();
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }
}
