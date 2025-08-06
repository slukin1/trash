package com.huobi.swap.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
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
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import ts.g;
import ts.h;
import ts.j;
import us.i;

public class SwapFinancialActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public SwapAccountInfo f81616k;

    /* renamed from: l  reason: collision with root package name */
    public BroadcastReceiver f81617l = new b();

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            SwapFinancialActivity.this.Ni(methodCall, result);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if ("ACTION_TOKEN_ERROR_UNIFY_TRANSFER".equals(intent.getAction())) {
                SwapFinancialActivity.this.finish();
            }
        }
    }

    public class c extends EasySubscriber<ProductInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f81620b;

        public c(MethodChannel.Result result) {
            this.f81620b = result;
        }

        /* renamed from: a */
        public void onNext(ProductInfo productInfo) {
            super.onNext(productInfo);
            HashMap hashMap = new HashMap();
            hashMap.put("symbol", SwapFinancialActivity.this.f81616k.getSymbol());
            hashMap.put("contract_code", SwapFinancialActivity.this.f81616k.getContractCode());
            boolean z11 = true;
            if (productInfo.getIsTrade() != 1) {
                z11 = false;
            }
            hashMap.put("is_trade", Boolean.valueOf(z11));
            this.f81620b.success(hashMap);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f81620b.error("swapFinancialConfig", th2.getMessage(), (Object) null);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            this.f81620b.error("swapFinancialConfig", aPIStatusErrorException.getMessage(), (Object) null);
        }
    }

    public class d extends EasySubscriber<SwapCurrencyInfo> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(SwapCurrencyInfo swapCurrencyInfo) {
            super.onNext(swapCurrencyInfo);
            SwapTradeBaseFragment.Qi(SwapFinancialActivity.this, swapCurrencyInfo);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ji(HBDialogFragment hBDialogFragment) {
        Ii();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Li(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) it2.next();
            if (this.f81616k.getSymbol().equalsIgnoreCase(swapCurrencyInfo.getSymbol())) {
                return Observable.just(swapCurrencyInfo);
            }
        }
        return Observable.just(null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Mi(List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ProductInfo productInfo = (ProductInfo) it2.next();
            if (productInfo.getSymbol().equalsIgnoreCase(this.f81616k.getSymbol())) {
                return Observable.just(productInfo);
            }
        }
        return Observable.just(new ProductInfo());
    }

    public final void Ii() {
        HBBaseWebActivity.showWebView(this, String.format(c1.j(), new Object[]{d1.h()}), "", "", false);
    }

    public String Nh() {
        return "swap_financial";
    }

    public void Ni(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("getPrecisionString".equals(str)) {
                result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), ((Integer) methodCall.argument("precision")).intValue()));
            } else if ("swapFinancialConfig".equals(str)) {
                Pi(result);
            } else if ("getSwapFeeAmount".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), i.g((String) methodCall.argument("symbol"))));
                } catch (Exception e11) {
                    e11.printStackTrace();
                    result.error("getSwapFeeAmount", e11.getMessage(), e11.getMessage());
                }
            } else if ("getSwapOtherAmount".equals(str)) {
                try {
                    double doubleValue = ((Double) methodCall.argument("num")).doubleValue();
                    String str2 = (String) methodCall.argument("symbol");
                    i6.d.j("SwapOrder", "num = " + doubleValue);
                    i6.d.j("SwapOrder", "symbol = " + str2);
                    String i11 = m.i(doubleValue, SwapCurrencyInfoController.k().l(str2, 4));
                    i6.d.j("SwapOrder", "amount = " + i11);
                    result.success(i11);
                } catch (Exception e12) {
                    i6.d.j("SwapOrder", "getSwapOtherAmount error");
                    e12.printStackTrace();
                    result.error("getSwapOtherAmount", e12.getMessage(), e12.getMessage());
                }
            } else if ("getPrecisionAmount".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), SwapCurrencyInfoController.k().d((String) methodCall.argument("symbol"), 8)));
                } catch (Exception e13) {
                    e13.printStackTrace();
                    result.error("getPrecisionAmount", e13.getMessage(), e13.getMessage());
                }
            } else if ("getSwapPriceAmount".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), SwapCurrencyInfoController.k().n((String) methodCall.argument("symbol"), 2)));
                } catch (Exception e14) {
                    e14.printStackTrace();
                    result.error("getSwapPriceAmount", e14.getMessage(), e14.getMessage());
                }
            } else if ("getSwapFinancialAmount".equals(str)) {
                try {
                    result.success(m.i(((Double) methodCall.argument("num")).doubleValue(), qs.a.f84586a.d((String) methodCall.argument("symbol"), 8)));
                } catch (Exception e15) {
                    e15.printStackTrace();
                    result.error("getSwapFinancialAmount", e15.getMessage(), e15.getMessage());
                }
            } else if ("getSwapMarginHint".equals(str)) {
                DialogUtils.b.d dVar = new DialogUtils.b.d(this);
                dVar.c1(getString(R.string.my_points_description));
                dVar.C0(getString(R.string.n_balance_contract_swap_available_margin_hint));
                dVar.Y0(getString(R.string.prime_see_detail));
                dVar.a1(new g(this));
                dVar.P0(getString(R.string.allow_access_dialog_positive_btn));
                dVar.Q0(h.f60360a);
                dVar.k0().show(getSupportFragmentManager(), "");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            result.notImplemented();
        }
    }

    public final void Oi() {
        SwapCurrencyInfoController.k().f(true).flatMap(new j(this)).compose(RxJavaHelper.t(this)).subscribe(new d());
    }

    public final void Pi(MethodChannel.Result result) {
        Observable<List<ProductInfo>> observable;
        qs.a aVar = qs.a.f84586a;
        if (CollectionsUtils.b(aVar.a())) {
            observable = aVar.f(false);
        } else {
            observable = Observable.just(aVar.a());
        }
        observable.flatMap(new ts.i(this)).compose(RxJavaHelper.t(this)).subscribe(new c(result));
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "swap_channel").setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SwapAccountInfo swapAccountInfo = (SwapAccountInfo) getIntent().getSerializableExtra("swap_detail_info");
        this.f81616k = swapAccountInfo;
        if (swapAccountInfo == null) {
            finish();
        }
        s1.a.b(this).c(this.f81617l, new IntentFilter("ACTION_TOKEN_ERROR_UNIFY_TRANSFER"));
    }

    public void onDestroy() {
        super.onDestroy();
        s1.a.b(this).e(this.f81617l);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("openSwapExchange".equals(str)) {
                Oi();
                result.success((Object) null);
            } else if ("openSwapTransfer".equals(str)) {
                UnifyTransferActivity.Th(this, this.f81616k.getSymbol(), BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP);
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
        rn.c.i().m(this, new JumpTarget(k0.c(this), k0.h(this)));
    }
}
