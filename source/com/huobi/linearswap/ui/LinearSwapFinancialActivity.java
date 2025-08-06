package com.huobi.linearswap.ui;

import al.j;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import cn.h;
import cn.i;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.c1;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;

public class LinearSwapFinancialActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public LinearSwapAccountInfo f75176k;

    /* renamed from: l  reason: collision with root package name */
    public String f75177l;

    /* renamed from: m  reason: collision with root package name */
    public BroadcastReceiver f75178m = new b();

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            LinearSwapFinancialActivity.this.Ji(methodCall, result);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if ("ACTION_TOKEN_ERROR_UNIFY_TRANSFER".equals(intent.getAction())) {
                LinearSwapFinancialActivity.this.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gi(HBDialogFragment hBDialogFragment) {
        Fi();
        hBDialogFragment.dismiss();
    }

    public final void Fi() {
        HBBaseWebActivity.showWebView(this, String.format(c1.e(), new Object[]{d1.h()}), "", "", false);
    }

    public final void Ii(MethodChannel.Result result) {
        boolean z11 = true;
        LinearSwapProductInfo s11 = LinearSwapProductInfoController.o().s(this.f75176k.getSymbol(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", this.f75176k.getSymbol());
        hashMap.put("isWhiteList", Boolean.valueOf(this.f75176k.isInWhiteList()));
        hashMap.put("availableAmount", this.f75176k.getAvailable());
        hashMap.put("equityAmount", this.f75176k.getEquity());
        hashMap.put("assetType", Integer.valueOf(this.f75176k.getAssetType()));
        hashMap.put(FirebaseAnalytics.Param.CHARACTER, LegalCurrencyConfigUtil.d().toUpperCase(Locale.US));
        if (this.f75176k.isCross()) {
            hashMap.put("is_trade", Boolean.TRUE);
            hashMap.put("margin_account", this.f75176k.getSymbol());
            Log.i("Liam", "linearSwapFinancialConfig, symbol:" + this.f75176k.getSymbol());
        } else {
            Log.i("Liam", "linearSwapFinancialConfig, symbol:" + this.f75176k.getSymbol());
            if (s11 != null) {
                if (s11.getIsTrade() != 1) {
                    z11 = false;
                }
                hashMap.put("is_trade", Boolean.valueOf(z11));
            } else {
                hashMap.put("is_trade", Boolean.FALSE);
            }
            hashMap.put("contract_code", this.f75176k.getContractCode());
        }
        result.success(hashMap);
    }

    public void Ji(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("linearSwapFinancialConfig".equals(str)) {
                Ii(result);
            } else if ("getLinearSwapFeeAmount".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), FuturePrecisionUtil.e(this.f75177l)));
                } catch (Exception e11) {
                    e11.printStackTrace();
                    result.error("getLinearSwapFeeAmount", e11.getMessage(), e11.getMessage());
                }
            } else if ("getLinearSwapOtherAmount".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), FuturePrecisionUtil.g(this.f75177l)));
                } catch (Exception e12) {
                    e12.printStackTrace();
                    result.error("getSwapOtherAmount", e12.getMessage(), e12.getMessage());
                }
            } else if ("getLinearSwapPriceAmount".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), FuturePrecisionUtil.h(this.f75177l)));
                } catch (Exception e13) {
                    e13.printStackTrace();
                    result.error("getSwapPriceAmount", e13.getMessage(), e13.getMessage());
                }
            } else if ("getLinearSwapFinancialAmount".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), FuturePrecisionUtil.f(this.f75177l)));
                } catch (Exception e14) {
                    e14.printStackTrace();
                    result.error("getSwapFinancialAmount", e14.getMessage(), e14.getMessage());
                }
            } else if ("getLinearSwapPrecisionString".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), ((Integer) methodCall.argument("precision")).intValue()));
                } catch (Exception e15) {
                    e15.printStackTrace();
                    result.error("getSwapFinancialAmount", e15.getMessage(), e15.getMessage());
                }
            } else if ("getLinearSwapMarginHint".equals(str)) {
                DialogUtils.b.d dVar = new DialogUtils.b.d(this);
                dVar.c1(getString(R.string.my_points_description));
                dVar.C0(getString(R.string.n_balance_contract_linear_swap_usdt_available_margin_hint));
                dVar.Y0(getString(R.string.prime_see_detail));
                dVar.a1(new h(this));
                dVar.P0(getString(R.string.allow_access_dialog_positive_btn));
                dVar.Q0(i.f13150a);
                dVar.k0().show(getSupportFragmentManager(), "");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Ki() {
        if (this.f75176k.isCross()) {
            j.b(this, this.f75176k.getSymbol());
        } else {
            LinearSwapTradeBaseFragment.Lj(this, FutureContractInfoController.n().o(StringUtils.i(this.f75176k.getContractCode())), 2);
        }
    }

    public String Nh() {
        return "linear_swap_financial";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "linear_swap_channel").setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearSwapAccountInfo linearSwapAccountInfo = (LinearSwapAccountInfo) getIntent().getSerializableExtra("linear_swap_detail_info");
        this.f75176k = linearSwapAccountInfo;
        if (linearSwapAccountInfo == null) {
            finish();
        }
        this.f75177l = this.f75176k.getSymbol();
        s1.a.b(this).c(this.f75178m, new IntentFilter("ACTION_TOKEN_ERROR_UNIFY_TRANSFER"));
    }

    public void onDestroy() {
        super.onDestroy();
        s1.a.b(this).e(this.f75178m);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("openLinearSwapExchange".equals(str)) {
                Ki();
                result.success((Object) null);
            } else if ("openLinearSwapTransfer".equals(str)) {
                if (this.f75176k.isCross()) {
                    UnifyTransferActivity.Wh(this, this.f75176k.getSymbol(), BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, false, (String) null, false, -1, this.f75176k.getSymbol());
                } else {
                    UnifyTransferActivity.Wh(this, this.f75176k.getSymbol(), BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, false, (String) null, false, -1, this.f75176k.getTradePartition());
                }
                result.success((Object) null);
            } else {
                super.onMethodCall(methodCall, result);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
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

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(this, new JumpTarget(k0.c(this), k0.h(this)));
    }
}
