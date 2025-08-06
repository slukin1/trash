package com.huobi.swap.ui;

import a7.e;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.contract.helper.ContractOrderHelper;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.swap.bean.FlutterSwapConfig;
import com.huobi.utils.k0;
import com.tencent.android.tpush.common.Constants;
import i6.d;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import ts.u;
import us.i;

public class SwapOrderActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public int f81670k;

    /* renamed from: l  reason: collision with root package name */
    public int f81671l;

    /* renamed from: m  reason: collision with root package name */
    public String f81672m;

    /* renamed from: n  reason: collision with root package name */
    public MethodChannel f81673n;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            SwapOrderActivity.this.Ni(methodCall, result);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mi() {
        MethodChannel methodChannel = this.f81673n;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshOpenLimitOrders", (Object) null);
        }
    }

    public static void Pi(Activity activity, String str, int i11, int i12) {
        if (activity != null) {
            Intent intent = new Intent(activity, SwapOrderActivity.class);
            intent.putExtra("extra_symbol", str);
            intent.putExtra("EXTRA_ORDER_TYPE", i11);
            intent.putExtra("EXTRA_PAGETYPE", i12);
            activity.startActivity(intent);
        }
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        int i11;
        TradeType tradeType = TradeType.SWAP;
        boolean E = e.E(tradeType);
        try {
            String str = (String) methodCall.argument("symbol");
            double doubleValue = ((Double) methodCall.argument(FirebaseAnalytics.Param.PRICE)).doubleValue();
            double doubleValue2 = ((Double) methodCall.argument("volume")).doubleValue();
            SwapCurrencyInfo swapCurrencyInfo = SwapCurrencyInfoController.k().p().get((String) methodCall.argument("contract_code"));
            String str2 = "";
            if (swapCurrencyInfo != null) {
                str2 = swapCurrencyInfo.getContractFace();
            }
            String f11 = ContractOrderHelper.f(String.valueOf(doubleValue2), String.valueOf(doubleValue), str2, tradeType);
            if (E) {
                i11 = i.p(str);
            } else {
                i11 = i.z(str);
            }
            result.success(m.m(f11, i11));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getSwapCoin", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), i.g((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getSwapFeeAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            double doubleValue = ((Double) methodCall.argument("num")).doubleValue();
            String str = (String) methodCall.argument("symbol");
            d.j("SwapOrder", "num = " + doubleValue);
            d.j("SwapOrder", "symbol = " + str);
            String i11 = m.i(doubleValue, SwapCurrencyInfoController.k().l(str, 4));
            d.j("SwapOrder", "amount = " + i11);
            result.success(i11);
        } catch (Exception e11) {
            d.j("SwapOrder", "getSwapOtherAmount error");
            e11.printStackTrace();
            result.error("getSwapOtherAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Hi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), SwapCurrencyInfoController.k().n((String) methodCall.argument("symbol"), 2)));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getSwapPriceAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            SwapTradeBaseFragment.Qi(this, SwapCurrencyInfoController.k().p().get((String) methodCall.argument("contract_code")));
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("goToFuturesTrade", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ji(MethodCall methodCall, MethodChannel.Result result) {
        try {
            CaptureShareHelper.h(this, (String) methodCall.argument("symbol"), (String) methodCall.argument(HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE), (String) methodCall.argument("avgCost"), (String) methodCall.argument("avgOffset"), (String) methodCall.argument("offsetProfit"), ((Boolean) methodCall.argument("isLong")).booleanValue(), 2);
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("goToShareHistoryPosition", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ki(MethodCall methodCall, MethodChannel.Result result) {
        try {
            CaptureShareHelper.h(this, (String) methodCall.argument("symbol"), (String) methodCall.argument(HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE), (String) methodCall.argument("openPrice"), (String) methodCall.argument("tradePrice"), (String) methodCall.argument("profitRatio"), true, 1);
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("goToShareOrder", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Li(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FlutterSwapConfig flutterSwapConfig = new FlutterSwapConfig();
            flutterSwapConfig.setContractCode(this.f81672m);
            flutterSwapConfig.setShowOrderType(this.f81670k);
            flutterSwapConfig.setSwapCoin(e.E(TradeType.SWAP));
            flutterSwapConfig.setRedRiseGreenFall(w.l());
            flutterSwapConfig.setPageType(this.f81671l);
            flutterSwapConfig.setSwapCurrencyList(SwapCurrencyInfoController.k().e());
            result.success(new Gson().toJson((Object) flutterSwapConfig));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("swapConfig", e11.getMessage(), e11.getMessage());
        }
    }

    public String Nh() {
        return "swap_orders";
    }

    public void Ni(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("initSwapOrder".equals(str)) {
                Li(methodCall, result);
            } else if ("getSwapFeeAmount".equals(str)) {
                Fi(methodCall, result);
            } else if ("getSwapOtherAmount".equals(str)) {
                Gi(methodCall, result);
            } else if ("getSwapPriceAmount".equals(str)) {
                Hi(methodCall, result);
            } else if ("getSwapCoin".equals(str)) {
                Ei(methodCall, result);
            } else if ("goToFuturesTrade".equals(str)) {
                Ii(methodCall, result);
            } else if ("goToShareRecord".equals(str)) {
                Ki(methodCall, result);
            } else if ("goToShareHistoryPosition".equals(str)) {
                Ji(methodCall, result);
            } else if ("modifyLimitOrder".equals(str)) {
                Oi(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Oi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FutureLimitOrderEditDialogHelper.s(this, new u(this), (String) methodCall.argument("orderId"), (String) methodCall.argument("entrustPrice"), (String) methodCall.argument("entrustVolume"), (String) methodCall.argument("contractCode"), (String) methodCall.argument("orderPriceType"), (String) methodCall.argument(Constants.FLAG_TAG_OFFSET), (String) methodCall.argument(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION), (String) methodCall.argument("leverRate"));
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("showLimitOrderEditDialog", e11.getMessage(), e11.getMessage());
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "swap_channel");
        this.f81673n = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f81672m = getIntent().getStringExtra("extra_symbol");
        this.f81670k = getIntent().getIntExtra("EXTRA_ORDER_TYPE", 0);
        this.f81671l = getIntent().getIntExtra("EXTRA_PAGETYPE", 0);
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
        boolean z11 = h11 != null && (h11 instanceof HuobiMainActivity);
        Intent v11 = k0.v(this, z11);
        if (!z11) {
            v11.addFlags(67108864);
        }
        c.i().m(this, new JumpTarget(v11, v11));
    }
}
