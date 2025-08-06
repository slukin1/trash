package com.huobi.c2c.ui;

import al.p;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.c2c.bean.FlutterC2CLoanOrderDetailConfig;
import com.huobi.c2c.lend.bean.C2CLendOrderHistoryItem;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import i6.d;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;

public class C2CLoanOrderDetailActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public C2CLendOrderHistoryItem f43006k;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            C2CLoanOrderDetailActivity.this.Fi(methodCall, result);
        }
    }

    public final void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = (String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("flutter: getExpectIncome");
            TradeType tradeType = TradeType.PRO;
            sb2.append(PrecisionUtil.a(tradeType, str));
            d.b(sb2.toString());
            result.success(m.m((String) methodCall.argument("profit"), PrecisionUtil.a(tradeType, str)));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getExpectIncome", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FlutterC2CLoanOrderDetailConfig flutterC2CLoanOrderDetailConfig = new FlutterC2CLoanOrderDetailConfig();
            flutterC2CLoanOrderDetailConfig.setLoanHistory(this.f43006k);
            result.success(new Gson().toJson((Object) flutterC2CLoanOrderDetailConfig));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("initC2CLoanOrderDetail", e11.getMessage(), e11.getMessage());
        }
    }

    public void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("initC2CLoanOrderDetail".equals(str)) {
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
        return "c2c_loan_order_detail";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "c2c_loan_order_detail_channel").setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f43006k = (C2CLendOrderHistoryItem) getIntent().getSerializableExtra("extra_item");
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
        c.i().m(this, new JumpTarget(A, A));
    }
}
