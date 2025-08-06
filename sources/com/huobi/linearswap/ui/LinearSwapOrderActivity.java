package com.huobi.linearswap.ui;

import a7.e;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import cn.d0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.swap.bean.FlutterLinearSwapConfig;
import com.huobi.utils.k0;
import com.tencent.android.tpush.common.Constants;
import i6.d;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Objects;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;

public class LinearSwapOrderActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public int f75248k;

    /* renamed from: l  reason: collision with root package name */
    public int f75249l;

    /* renamed from: m  reason: collision with root package name */
    public String f75250m;

    /* renamed from: n  reason: collision with root package name */
    public String f75251n;

    /* renamed from: o  reason: collision with root package name */
    public int f75252o;

    /* renamed from: p  reason: collision with root package name */
    public MethodChannel f75253p;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            LinearSwapOrderActivity.this.Qi(methodCall, result);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pi() {
        MethodChannel methodChannel = this.f75253p;
        if (methodChannel != null) {
            methodChannel.invokeMethod("refreshOpenLimitOrders", (Object) null);
        }
    }

    public static void Si(Activity activity, String str, int i11, int i12, String str2, String str3, int i13) {
        if (activity != null) {
            Intent intent = new Intent(activity, LinearSwapOrderActivity.class);
            intent.putExtra("extra_symbol", str);
            intent.putExtra("EXTRA_ORDER_TYPE", i11);
            intent.putExtra("EXTRA_SHOW_ORDER_MODEL", i12);
            intent.putExtra("CONTRACT_SHORT_TYPE", str3);
            intent.putExtra("EXTRA_CONTRACT_CODE", str2);
            intent.putExtra("EXTRA_PAGETYPE", i13);
            activity.startActivity(intent);
        }
    }

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
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
                str = LinearSwapCurrencyInfoController.l().f(str3);
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

    public final void Fi(MethodCall methodCall, MethodChannel.Result result) {
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
                str = LinearSwapCurrencyInfoController.l().f(str2);
            }
            result.success(m.m(FutureUnitUtil.c(String.valueOf(doubleValue2), String.valueOf(doubleValue), str, TradeType.LINEAR_SWAP, true), FuturePrecisionUtil.t(str2, str3, str3, "")));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapCoinForCurrency", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            double doubleValue = ((Double) methodCall.argument("num")).doubleValue();
            String str = (String) methodCall.argument("contract_code");
            result.success(m.i(doubleValue, FuturePrecisionUtil.u(str, str, "")));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapFeeAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Hi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            double doubleValue = ((Double) methodCall.argument("num")).doubleValue();
            int intValue = ((Integer) methodCall.argument("type")).intValue();
            LinearSwapContractInfo m11 = LinearSwapCurrencyInfoController.l().m((String) methodCall.argument("contract_code"));
            int i11 = 8;
            if (m11 != null) {
                if (intValue == 1) {
                    i11 = m11.getFeeAmountPrecision();
                } else if (intValue == 4) {
                    i11 = m11.getAmountPrecision();
                } else {
                    i11 = m11.getOtherAmountPrecision();
                }
            }
            result.success(m.w(doubleValue, i11));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapFundingPrecision", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
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

    public final void Ji(MethodCall methodCall, MethodChannel.Result result) {
        try {
            double doubleValue = ((Double) methodCall.argument("num")).doubleValue();
            String str = (String) methodCall.argument("contract_code");
            result.success(m.i(doubleValue, FuturePrecisionUtil.z((String) methodCall.argument("symbol"), str, str, "")));
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("getLinearSwapPriceAmount", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ki(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = (String) methodCall.argument("contract_code");
            boolean z11 = false;
            if (methodCall.hasArgument("isCross")) {
                z11 = ((Boolean) methodCall.argument("isCross")).booleanValue();
            }
            LinearSwapTradeBaseFragment.Lj(this, FutureContractInfoController.n().o(str), z11 ? 1 : 2);
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("goToFuturesTrade", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Li(MethodCall methodCall, MethodChannel.Result result) {
        try {
            CaptureShareHelper.h(this, (String) methodCall.argument("symbol"), (String) methodCall.argument(HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE), (String) methodCall.argument("avgCost"), (String) methodCall.argument("avgOffset"), (String) methodCall.argument("offsetProfit"), ((Boolean) methodCall.argument("isLong")).booleanValue(), 2);
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("goToShareHistoryPosition", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Mi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            CaptureShareHelper.h(this, (String) methodCall.argument("symbol"), (String) methodCall.argument(HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE), (String) methodCall.argument("openPrice"), (String) methodCall.argument("tradePrice"), (String) methodCall.argument("profitRatio"), true, 1);
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("goToShareOrder", e11.getMessage(), e11.getMessage());
        }
    }

    public String Nh() {
        return "linear_swap_orders";
    }

    public final void Ni(MethodCall methodCall, MethodChannel.Result result) {
        try {
            ((Boolean) methodCall.argument("isReal")).booleanValue();
            Intent intent = new Intent(this, LinearSwapTimeOrderDetailActivity.class);
            intent.putExtra("EXTRA_TIME_ORDER_SYMBOL", (String) methodCall.argument("symbol"));
            intent.putExtra("EXTRA_TIME_ORDER_ID", (String) methodCall.argument("orderId"));
            intent.putExtra("EXTRA_TIME_ORDER_CONTRACT_CODE", (String) methodCall.argument("contractCode"));
            intent.putExtra("EXTRA_TIME_ORDER_CONTRACT_TYPE", (String) methodCall.argument("contractType"));
            if (FutureContractInfo.MARGIN_CROSS.equals((String) methodCall.argument("marginMode"))) {
                intent.putExtra("EXTRA_TIME_ORDER_SHOW_MODEL", 1);
            } else {
                intent.putExtra("EXTRA_TIME_ORDER_SHOW_MODEL", 0);
            }
            startActivity(intent);
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("goToSharingTimeDetail", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Oi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            FlutterLinearSwapConfig flutterLinearSwapConfig = new FlutterLinearSwapConfig();
            flutterLinearSwapConfig.setContractCode(this.f75251n);
            flutterLinearSwapConfig.setShowOrderType(this.f75248k);
            flutterLinearSwapConfig.setShowOrderMode(this.f75249l);
            int i11 = 1;
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (e.E(tradeType)) {
                i11 = 2;
            } else if (e.G(tradeType)) {
                i11 = 3;
            }
            flutterLinearSwapConfig.setUnit(i11);
            flutterLinearSwapConfig.setPageType(this.f75252o);
            flutterLinearSwapConfig.setRedRiseGreenFall(w.l());
            flutterLinearSwapConfig.setLinearSwapCurrencyList(LinearSwapCurrencyInfoController.l().g());
            String json = new Gson().toJson((Object) flutterLinearSwapConfig);
            d.d("flutter -> " + json);
            result.success(json);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("linearSwapConfig", e11.getMessage(), e11.getMessage());
        }
    }

    public void Qi(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("initLinearSwapOrder".equals(str)) {
                Oi(methodCall, result);
            } else if ("getLinearSwapFeeAmount".equals(str)) {
                Gi(methodCall, result);
            } else if ("getLinearSwapOtherAmount".equals(str)) {
                Ii(methodCall, result);
            } else if ("getLinearSwapCoin".equals(str)) {
                Ei(methodCall, result);
            } else if ("getLinearSwapCoinForCurrency".equals(str)) {
                Fi(methodCall, result);
            } else if ("getLinearSwapPriceAmount".equals(str)) {
                Ji(methodCall, result);
            } else if ("goToFuturesTrade".equals(str)) {
                Ki(methodCall, result);
            } else if ("getLinearSwapFundingPrecisionString".equals(str)) {
                Hi(methodCall, result);
            } else if ("goToShareRecord".equals(str)) {
                Mi(methodCall, result);
            } else if ("goToSharingTimeDetail".equals(str)) {
                Ni(methodCall, result);
            } else if ("goToShareHistoryPosition".equals(str)) {
                Li(methodCall, result);
            } else if ("modifyLimitOrder".equals(str)) {
                Ri(methodCall, result);
            } else {
                result.notImplemented();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Ri(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = (String) methodCall.argument("orderId");
            String str2 = (String) methodCall.argument("entrustPrice");
            String str3 = (String) methodCall.argument("entrustVolume");
            String str4 = (String) methodCall.argument("contractCode");
            String str5 = (String) methodCall.argument("orderPriceType");
            String str6 = (String) methodCall.argument(Constants.FLAG_TAG_OFFSET);
            String str7 = (String) methodCall.argument(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
            String str8 = (String) methodCall.argument("leverRate");
            String str9 = (String) methodCall.argument("side");
            String str10 = (String) methodCall.argument("positionSide");
            FutureLimitOrderEditDialogHelper.r(this, new d0(this), str, str2, str3, str4, str5, str6, (str7 == null || str7.isEmpty()) ? str9 : str7, str8, Objects.equals(methodCall.argument("marginMode"), FutureContractInfo.MARGIN_CROSS) ? "1" : "2", str10);
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.error("showLimitOrderEditDialog", e11.getMessage(), e11.getMessage());
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "linear_swap_channel");
        this.f75253p = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f75250m = getIntent().getStringExtra("CONTRACT_SHORT_TYPE");
        this.f75251n = getIntent().getStringExtra("EXTRA_CONTRACT_CODE");
        this.f75248k = getIntent().getIntExtra("EXTRA_ORDER_TYPE", 0);
        this.f75249l = getIntent().getIntExtra("EXTRA_SHOW_ORDER_MODEL", 0);
        this.f75252o = getIntent().getIntExtra("EXTRA_PAGETYPE", 0);
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
