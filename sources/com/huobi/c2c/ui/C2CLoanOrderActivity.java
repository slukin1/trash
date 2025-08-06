package com.huobi.c2c.ui;

import al.p;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import com.huobi.c2c.bean.FlutterC2CLoanOrderConfig;
import com.huobi.c2c.util.c;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class C2CLoanOrderActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public String f43003k;

    /* renamed from: l  reason: collision with root package name */
    public int f43004l;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            C2CLoanOrderActivity.this.Fi(methodCall, result);
        }
    }

    public static void Gi(Activity activity, String str, int i11) {
        List<C2CCurrencyBean> c11;
        if (activity != null && (c11 = c.c()) != null && !c11.isEmpty()) {
            Intent intent = new Intent(activity, C2CLoanOrderActivity.class);
            intent.putExtra("extra_currency", str);
            intent.putExtra("extra_order_type", i11);
            activity.startActivity(intent);
        }
    }

    public final void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            result.success(m.m((String) methodCall.argument("profit"), PrecisionUtil.a(TradeType.PRO, (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY))));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getExpectIncome", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FlutterC2CLoanOrderConfig flutterC2CLoanOrderConfig = new FlutterC2CLoanOrderConfig();
            flutterC2CLoanOrderConfig.setCurrency(this.f43003k);
            flutterC2CLoanOrderConfig.setOrderType(this.f43004l);
            flutterC2CLoanOrderConfig.setC2cCurrencyList(c.c());
            result.success(new Gson().toJson((Object) flutterC2CLoanOrderConfig));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("initC2CLoanOrder", e11.getMessage(), e11.getMessage());
        }
    }

    public void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("initC2CLoanOrder".equals(str)) {
                Ei(methodCall, result);
            } else if ("getProfit".equals(str)) {
                Di(methodCall, result);
            } else if ("getCurrencyIconUrl".equals(str)) {
                result.success(p.l((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY)));
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "c2c_loan_order";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "c2c_loan_order_channel").setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f43003k = getIntent().getStringExtra("extra_currency");
        this.f43004l = getIntent().getIntExtra("extra_order_type", 0);
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
    public void onTokenError(mo.a aVar) {
        Intent A = k0.A(this, "");
        rn.c.i().m(this, new JumpTarget(A, A));
    }
}
