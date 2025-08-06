package com.huobi.points.activity;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

@Route(path = "/point/card/purchase")
public class PointsExchangeActivity extends AbsPointsNewActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f80389k;

    public void Fi(MethodCall methodCall, MethodChannel.Result result) {
        super.Fi(methodCall, result);
        try {
            result.success(this.f80389k);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("initStrategyOrder", e11.getMessage(), e11.getMessage());
        }
    }

    public String Nh() {
        return "point_exchange";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f80389k = getIntent().getStringExtra("param_normal_data");
    }
}
