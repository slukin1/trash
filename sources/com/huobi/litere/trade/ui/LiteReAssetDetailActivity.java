package com.huobi.litere.trade.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huobi.litere.BaseLiteReFlutterActivity;
import com.huobi.litere.event.CloseLiteReAssetPage;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

public class LiteReAssetDetailActivity extends BaseLiteReFlutterActivity {

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            try {
                if ("getCurrency".equals(methodCall.method)) {
                    JSONObject jSONObject = new JSONObject();
                    String stringExtra = LiteReAssetDetailActivity.this.getIntent().getStringExtra(FirebaseAnalytics.Param.CURRENCY);
                    boolean booleanExtra = LiteReAssetDetailActivity.this.getIntent().getBooleanExtra("isFiat", false);
                    jSONObject.put(FirebaseAnalytics.Param.CURRENCY, stringExtra);
                    jSONObject.put("isFiat", booleanExtra);
                    result.success(jSONObject.toString());
                    return;
                }
                result.notImplemented();
            } catch (Exception e11) {
                e11.printStackTrace();
                result.notImplemented();
            }
        }
    }

    public static void jj(Context context, String str, boolean z11) {
        Intent intent = new Intent(context, LiteReAssetDetailActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.CURRENCY, str);
        intent.putExtra("isFiat", z11);
        if (!"BRL".equals(str) || !(context instanceof Activity)) {
            context.startActivity(intent);
        } else {
            ((Activity) context).startActivityForResult(intent, 0);
        }
    }

    public String Nh() {
        return "lite_asset_detail";
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void closeAssetPage(CloseLiteReAssetPage closeLiteReAssetPage) {
        finish();
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "lite_asset_detail_channel").setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if ("BRL".equals(getIntent().getStringExtra(FirebaseAnalytics.Param.CURRENCY))) {
            setResult(1630461439);
        }
    }

    public void onDestroy() {
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        super.onDestroy();
    }

    public void onStop() {
        super.onStop();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }
}
