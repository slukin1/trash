package com.huobi.otc.flutter;

import android.content.Intent;
import android.os.Bundle;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import jp.l0;

public class AppealFlutterActivity extends AbsGlobalFlutterActivity {

    /* renamed from: l  reason: collision with root package name */
    public static int f78405l = 100;

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78406k;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            AppealFlutterActivity.this.Di(methodCall, result);
        }
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("getOrderId".equals(str)) {
                result.success(getIntent().getStringExtra("orderId"));
            } else if ("getOrderState".equals(str)) {
                result.success(Integer.valueOf(getIntent().getIntExtra("orderStatus", -1)));
            } else if ("getOrderTime".equals(str)) {
                OtcOrderDetailInfo otcOrderDetailInfo = (OtcOrderDetailInfo) getIntent().getSerializableExtra("otcOrderDetailInfo");
                HashMap hashMap = new HashMap();
                if (otcOrderDetailInfo != null) {
                    hashMap.put("now", Long.valueOf(otcOrderDetailInfo.getOtcOrder().getNow()));
                    hashMap.put("gmtModified", Long.valueOf(otcOrderDetailInfo.getOtcOrder().getGmtModified()));
                }
                result.success(hashMap);
            } else if ("dismissAppealController".equals(str)) {
                setResult(f78405l);
                finish();
            } else if ("getLastReason".equals(str)) {
                result.success((Map) getIntent().getSerializableExtra("reasonJson"));
            } else if ("gotoChatController".equals(str)) {
                l0.b(this, getIntent().getStringExtra("orderId"), false);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "otc_appeal_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_appeal_channel");
        this.f78406k = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onResume() {
        super.onResume();
    }
}
