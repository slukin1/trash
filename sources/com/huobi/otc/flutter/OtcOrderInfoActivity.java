package com.huobi.otc.flutter;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import i6.d;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

public class OtcOrderInfoActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f78522k;

    /* renamed from: l  reason: collision with root package name */
    public String f78523l;

    /* renamed from: m  reason: collision with root package name */
    public String f78524m;

    /* renamed from: n  reason: collision with root package name */
    public MethodChannel f78525n;

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("orderId", this.f78522k);
            String str = this.f78523l;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            hashMap.put("payId", str);
            String str3 = this.f78524m;
            if (str3 != null) {
                str2 = str3;
            }
            hashMap.put("bankType", str2);
            JSONObject jSONObject = new JSONObject(hashMap);
            d.j("OtcOrderInfoActivity", jSONObject.toString());
            result.success(jSONObject.toString());
        } catch (Exception e11) {
            result.error("OtcOrderInfoActivity error", e11.getMessage(), e11.getMessage());
        }
    }

    /* renamed from: Gi */
    public final void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -2014228961) {
                if (hashCode != -1949106608) {
                    if (hashCode == -1770614792) {
                        if (str.equals("finishOrderInfoActivity")) {
                            c11 = 1;
                        }
                    }
                } else if (str.equals("getInitData")) {
                    c11 = 0;
                }
            } else if (str.equals("showTradeNoviceGuide")) {
                c11 = 2;
            }
            if (c11 == 0) {
                Ei(methodCall, result);
            } else if (c11 == 1) {
                finish();
            } else if (c11 == 2) {
                OtcModuleConfig.b().C(this, "21");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "otc_order_info";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_order_info_channel");
        this.f78525n = methodChannel;
        methodChannel.setMethodCallHandler(new c0(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("com.huobi.otc.lite.order.id")) {
            this.f78522k = getIntent().getStringExtra("com.huobi.otc.lite.order.id");
            this.f78523l = getIntent().getStringExtra("com.huobi.otc.lite.order.pay.id");
            this.f78524m = getIntent().getStringExtra("com.huobi.otc.lite.order.bank.type");
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(a aVar) {
        finish();
    }
}
