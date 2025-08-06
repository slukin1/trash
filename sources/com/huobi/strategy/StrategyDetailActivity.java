package com.huobi.strategy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import com.huobi.strategy.bean.StrategyDetailConfig;
import i6.d;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class StrategyDetailActivity extends AbsStrategyBaseActivity {

    /* renamed from: l  reason: collision with root package name */
    public String f81301l;

    public static void start(Context context, String str) {
        if (context != null) {
            Intent intent = new Intent(context, StrategyDetailActivity.class);
            intent.putExtra("STRATEGY_ID", str);
            context.startActivity(intent);
        }
    }

    public void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            StrategyDetailConfig strategyDetailConfig = new StrategyDetailConfig();
            strategyDetailConfig.setOrderId(this.f81301l);
            String json = new Gson().toJson((Object) strategyDetailConfig);
            d.d("flutter -> " + json);
            result.success(json);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("initStrategyOrder", e11.getMessage(), e11.getMessage());
        }
    }

    public String Nh() {
        return "strategy_detail";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f81301l = getIntent().getStringExtra("STRATEGY_ID");
    }
}
