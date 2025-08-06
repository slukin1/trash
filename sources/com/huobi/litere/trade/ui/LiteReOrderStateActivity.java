package com.huobi.litere.trade.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.litere.BaseLiteReFlutterActivity;
import com.huobi.otc.flutter.OtcFlutterOrderDetailActivity;
import com.huobi.utils.GsonHelper;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class LiteReOrderStateActivity extends BaseLiteReFlutterActivity {

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            LiteReOrderStateActivity.this.kj(methodCall, result);
        }
    }

    public static void lj(Context context, String str) {
        Intent intent = new Intent(context, LiteReOrderStateActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("orderId", str);
        }
        context.startActivity(intent);
    }

    public String Nh() {
        return "lite_order_state";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "lite_order_state_channel").setMethodCallHandler(new a());
    }

    public final void kj(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("getOrderId".equals(str)) {
                result.success(getIntent().getStringExtra("orderId"));
            } else if ("gotoOrderDetail".equals(str)) {
                Si(methodCall, result);
                Activity f11 = oa.a.g().f(OtcFlutterOrderDetailActivity.class);
                if (f11 != null) {
                    f11.finish();
                }
                finish();
            } else if ("gotoCustomerPage".equals(str)) {
                Ri(methodCall, result);
                finish();
            } else if ("getOrderStateWithParameters".equals(str)) {
                Intent intent = getIntent();
                if (intent != null) {
                    String stringExtra = intent.getStringExtra(FirebaseAnalytics.Param.QUANTITY);
                    result.success(GsonHelper.a().toJson((Object) new MapParamsBuilder().a(FirebaseAnalytics.Param.QUANTITY, stringExtra).a("cryptoAssetName", intent.getStringExtra("cryptoAssetName")).b()));
                    return;
                }
                result.success((Object) null);
            } else {
                result.notImplemented();
            }
        } catch (Exception unused) {
            result.notImplemented();
        }
    }
}
