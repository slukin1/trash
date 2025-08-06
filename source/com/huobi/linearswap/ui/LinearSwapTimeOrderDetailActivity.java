package com.huobi.linearswap.ui;

import a7.e;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.swap.bean.FlutterLinearSwapTimeOrderConfig;
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

public class LinearSwapTimeOrderDetailActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public int f75298k;

    /* renamed from: l  reason: collision with root package name */
    public String f75299l;

    /* renamed from: m  reason: collision with root package name */
    public String f75300m;

    /* renamed from: n  reason: collision with root package name */
    public String f75301n;

    /* renamed from: o  reason: collision with root package name */
    public String f75302o;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            LinearSwapTimeOrderDetailActivity.this.Ji(methodCall, result);
        }
    }

    public final void Di(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        try {
            String str3 = (String) methodCall.argument("symbol");
            String str4 = (String) methodCall.argument("contract_code");
            double doubleValue = ((Double) methodCall.argument(FirebaseAnalytics.Param.PRICE)).doubleValue();
            double doubleValue2 = ((Double) methodCall.argument("volume")).doubleValue();
            LinearSwapContractInfo linearSwapContractInfo = LinearSwapCurrencyInfoController.l().d().get(str4);
            if (linearSwapContractInfo != null) {
                str = linearSwapContractInfo.getContractFace();
            } else {
                str = "";
            }
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (e.E(tradeType)) {
                str2 = FutureUnitUtil.b(String.valueOf(doubleValue2), String.valueOf(doubleValue), str, tradeType, FuturePrecisionUtil.t(str3, str4, str4, ""));
            } else if (e.G(tradeType)) {
                str2 = FutureUnitUtil.b(String.valueOf(doubleValue2), String.valueOf(doubleValue), str, tradeType, FuturePrecisionUtil.g(str3));
            } else {
                str2 = FutureUnitUtil.b(String.valueOf(doubleValue2), String.valueOf(doubleValue), str, tradeType, FuturePrecisionUtil.B());
            }
            result.success(str2);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapCoin", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        try {
            String str2 = (String) methodCall.argument("symbol");
            String str3 = (String) methodCall.argument("contract_code");
            double doubleValue = ((Double) methodCall.argument(FirebaseAnalytics.Param.PRICE)).doubleValue();
            double doubleValue2 = ((Double) methodCall.argument("volume")).doubleValue();
            LinearSwapContractInfo linearSwapContractInfo = LinearSwapCurrencyInfoController.l().d().get(str3);
            if (linearSwapContractInfo != null) {
                str = linearSwapContractInfo.getContractFace();
            } else {
                str = "";
            }
            result.success(m.m(FutureUnitUtil.c(String.valueOf(doubleValue2), String.valueOf(doubleValue), str, TradeType.LINEAR_SWAP, true), FuturePrecisionUtil.t(str2, str3, str3, "")));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapCoinForCurrency", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            double doubleValue = ((Double) methodCall.argument("num")).doubleValue();
            String str = (String) methodCall.argument("contract_code");
            result.success(m.i(doubleValue, FuturePrecisionUtil.u(str, str, "")));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapFeeAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = (String) methodCall.argument("contract_code");
            String i11 = m.i(((Double) methodCall.argument("num")).doubleValue(), FuturePrecisionUtil.w(str, str, ""));
            d.j("LinearSwapOrder", "amount = " + i11);
            result.success(i11);
        } catch (Exception e11) {
            d.j("LinearSwapOrder", "getLinearSwapOtherAmount error");
            e11.printStackTrace();
            result.error("getLinearSwapOtherAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Hi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            double doubleValue = ((Double) methodCall.argument("num")).doubleValue();
            String str = (String) methodCall.argument("contract_code");
            result.success(m.i(doubleValue, FuturePrecisionUtil.z((String) methodCall.argument("symbol"), str, str, "")));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapPriceAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FlutterLinearSwapTimeOrderConfig flutterLinearSwapTimeOrderConfig = new FlutterLinearSwapTimeOrderConfig();
            flutterLinearSwapTimeOrderConfig.setContractCode(this.f75299l);
            flutterLinearSwapTimeOrderConfig.setCurShowMode(this.f75298k);
            flutterLinearSwapTimeOrderConfig.setSymbol(this.f75301n);
            flutterLinearSwapTimeOrderConfig.setOrderId(this.f75300m);
            flutterLinearSwapTimeOrderConfig.setContractType(this.f75302o);
            int i11 = 1;
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (e.E(tradeType)) {
                i11 = 2;
            } else if (e.G(tradeType)) {
                i11 = 3;
            }
            flutterLinearSwapTimeOrderConfig.setUnit(i11);
            flutterLinearSwapTimeOrderConfig.setRedRiseGreenFall(w.l());
            String json = new Gson().toJson((Object) flutterLinearSwapTimeOrderConfig);
            d.d("flutter -> " + json);
            result.success(json);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("linearSwapConfig", e11.getMessage(), e11.getMessage());
        }
    }

    public void Ji(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("initLinearSwapTimeWeightedOrderDetail".equals(str)) {
                Ii(methodCall, result);
            } else if ("getLinearSwapFeeAmount".equals(str)) {
                Fi(methodCall, result);
            } else if ("getLinearSwapOtherAmount".equals(str)) {
                Gi(methodCall, result);
            } else if ("getLinearSwapCoin".equals(str)) {
                Di(methodCall, result);
            } else if ("getLinearSwapCoinForCurrency".equals(str)) {
                Ei(methodCall, result);
            } else if ("getLinearSwapPriceAmount".equals(str)) {
                Hi(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "time_weighted_order_detail";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "linear_swap_channel").setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f75299l = getIntent().getStringExtra("EXTRA_TIME_ORDER_CONTRACT_CODE");
        this.f75302o = getIntent().getStringExtra("EXTRA_TIME_ORDER_CONTRACT_TYPE");
        this.f75301n = getIntent().getStringExtra("EXTRA_TIME_ORDER_SYMBOL");
        this.f75300m = getIntent().getStringExtra("EXTRA_TIME_ORDER_ID");
        this.f75298k = getIntent().getIntExtra("EXTRA_TIME_ORDER_SHOW_MODEL", 0);
        this.f75302o = getIntent().getStringExtra("EXTRA_TIME_ORDER_CONTRACT_TYPE");
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
        Activity h11 = oa.a.g().h();
        Intent i11 = k0.i(this, h11 != null && (h11 instanceof HuobiMainActivity));
        c.i().m(this, new JumpTarget(i11, i11));
    }
}
