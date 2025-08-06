package com.huobi.contract.ui;

import a7.e;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractOrderHelper;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.linearswap.bean.FlutterContractConfig;
import com.huobi.login.bean.JumpTarget;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.utils.k0;
import com.tencent.android.tpush.common.Constants;
import dj.a0;
import ej.f;
import i6.d;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;

public class ContractOrderActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public int f43304k;

    /* renamed from: l  reason: collision with root package name */
    public int f43305l;

    /* renamed from: m  reason: collision with root package name */
    public String f43306m;

    /* renamed from: n  reason: collision with root package name */
    public String f43307n;

    /* renamed from: o  reason: collision with root package name */
    public MethodChannel f43308o;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            ContractOrderActivity.this.Ni(methodCall, result);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mi() {
        MethodChannel methodChannel = this.f43308o;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshOpenLimitOrders", (Object) null);
        }
    }

    public static void Pi(Context context, String str, int i11, String str2, int i12) {
        if (context != null) {
            Intent intent = new Intent(context, ContractOrderActivity.class);
            intent.putExtra("extra_symbol", str);
            intent.putExtra("EXTRA_ORDER_TYPE", i11);
            intent.putExtra("CONTRACT_SHORT_TYPE", str2);
            intent.putExtra("EXTRA_PAGETYPE", i12);
            context.startActivity(intent);
        }
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        try {
            result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), f.m((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapFeeAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Fi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String i11 = m.i(((Double) methodCall.argument("num")).doubleValue(), f.o((String) methodCall.argument("symbol")));
            d.j("LinearSwapOrder", "amount = " + i11);
            result.success(i11);
        } catch (Exception e11) {
            d.j("LinearSwapOrder", "getLinearSwapOtherAmount error");
            e11.printStackTrace();
            result.error("getLinearSwapOtherAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            double doubleValue = ((Double) methodCall.argument("num")).doubleValue();
            String str = (String) methodCall.argument("contract_code");
            result.success(m.i(doubleValue, f.r((String) methodCall.argument("symbol"))));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapPriceAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Hi(MethodCall methodCall, MethodChannel.Result result) {
        int i11;
        TradeType tradeType = TradeType.CONTRACT;
        boolean E = e.E(tradeType);
        try {
            String str = (String) methodCall.argument("symbol");
            String f11 = ContractOrderHelper.f(String.valueOf(((Double) methodCall.argument("volume")).doubleValue()), String.valueOf(((Double) methodCall.argument(FirebaseAnalytics.Param.PRICE)).doubleValue()), ContractCurrencyUtils.i(str), tradeType);
            if (E) {
                i11 = f.o(str);
            } else {
                i11 = f.t(str);
            }
            result.success(m.m(f11, i11));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getSwapCoin", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            ContractTradeBaseFragment.Ri(this, ContractCurrencyUtils.b((String) methodCall.argument("contract_short_type")));
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
            FlutterContractConfig flutterContractConfig = new FlutterContractConfig();
            flutterContractConfig.setContractCode(this.f43306m);
            flutterContractConfig.setShowOrderType(this.f43304k);
            flutterContractConfig.setSymbol(this.f43307n);
            flutterContractConfig.setSwapCoin(e.E(TradeType.CONTRACT));
            flutterContractConfig.setRedRiseGreenFall(w.l());
            flutterContractConfig.setContractCurrencyList(ContractCurrencyUtils.l());
            flutterContractConfig.setPageType(this.f43305l);
            result.success(new Gson().toJson((Object) flutterContractConfig));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("flutterContractConfig", e11.getMessage(), e11.getMessage());
        }
    }

    public String Nh() {
        return "contract_orders";
    }

    public void Ni(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            d.d("onMethodCallExtend : " + str);
            if ("initContractOrder".equals(str)) {
                Li(methodCall, result);
            } else if ("getContractFeeAmount".equals(str)) {
                Ei(methodCall, result);
            } else if ("getContractOtherAmount".equals(str)) {
                Fi(methodCall, result);
            } else if ("getContractCoin".equals(str)) {
                Hi(methodCall, result);
            } else if ("getContractPriceAmount".equals(str)) {
                Gi(methodCall, result);
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
            FutureLimitOrderEditDialogHelper.q(this, new a0(this), (String) methodCall.argument("orderId"), (String) methodCall.argument("entrustPrice"), (String) methodCall.argument("entrustVolume"), (String) methodCall.argument("contractCode"), (String) methodCall.argument("orderPriceType"), (String) methodCall.argument(Constants.FLAG_TAG_OFFSET), (String) methodCall.argument(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION), (String) methodCall.argument("leverRate"));
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("showLimitOrderEditDialog", e11.getMessage(), e11.getMessage());
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "contract_channel");
        this.f43308o = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f43306m = getIntent().getStringExtra("CONTRACT_SHORT_TYPE");
        this.f43304k = getIntent().getIntExtra("EXTRA_ORDER_TYPE", 0);
        this.f43305l = getIntent().getIntExtra("EXTRA_PAGETYPE", 0);
        this.f43307n = getIntent().getStringExtra("extra_symbol");
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
        Intent d11 = k0.d(this, false);
        c.i().m(this, new JumpTarget(d11, d11));
    }
}
