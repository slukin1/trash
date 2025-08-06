package com.huobi.otc.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lite.trade.bean.LiteSuccessBean;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.observer.ActiveObserverHelper;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.persenter.OtcOrderUnReadNumP;
import com.huobi.otc.ui.OtcFAQDialogActivity;
import dp.t;
import i6.i;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Locale;
import jp.l0;
import jp.v1;
import u6.g;

public class OtcFlutterOrderDetailActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78489k;

    /* renamed from: l  reason: collision with root package name */
    public t f78490l;

    /* renamed from: m  reason: collision with root package name */
    public com.huobi.otc.helper.a f78491m;

    /* renamed from: n  reason: collision with root package name */
    public String f78492n;

    /* renamed from: o  reason: collision with root package name */
    public OtcOrderUnReadNumP f78493o;

    public class a extends OtcOrderUnReadNumP {
        public a() {
        }

        public String r() {
            return OtcFlutterOrderDetailActivity.this.f78492n;
        }

        public g s() {
            return OtcFlutterOrderDetailActivity.this;
        }

        public void v(int i11) {
            OtcFlutterOrderDetailActivity.this.f78489k.invokeMethod("updateUnreadMessageCount", Integer.valueOf(i11));
        }
    }

    public class b implements MethodChannel.MethodCallHandler {
        public b() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            OtcFlutterOrderDetailActivity.this.Ii(methodCall, result);
        }
    }

    public class c extends q6.d<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f78496e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g gVar, MethodChannel.Result result) {
            super(gVar);
            this.f78496e = result;
        }

        /* renamed from: j */
        public void onNext(String str) {
        }

        public void onAfter() {
            super.onAfter();
            this.f78496e.success((Object) null);
        }

        public void onError2(Throwable th2) {
            if (th2 != null && !TextUtils.isEmpty(th2.getMessage())) {
                i.b().g(v.f78682b, 2000);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (aPIStatusErrorException != null && !TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                i.b().g(new u(aPIStatusErrorException), 2000);
            }
        }
    }

    public class d implements cp.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f78498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel f78499b;

        public d(MethodCall methodCall, MethodChannel methodChannel) {
            this.f78498a = methodCall;
            this.f78499b = methodChannel;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", this.f78498a.argument("action"));
            hashMap.put("securityToken", str);
            this.f78499b.invokeMethod("orderRelease", hashMap);
        }

        public void d(BaseDialogFragment baseDialogFragment) {
        }

        public void e() {
        }

        public void f(t tVar) {
            t unused = OtcFlutterOrderDetailActivity.this.f78490l = tVar;
        }

        public boolean g() {
            return false;
        }

        public void h(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", this.f78498a.argument("action"));
            hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, str);
            this.f78499b.invokeMethod("orderRelease", hashMap);
            if (OtcFlutterOrderDetailActivity.this.f78490l != null && OtcFlutterOrderDetailActivity.this.f78490l.isShowing()) {
                OtcFlutterOrderDetailActivity.this.f78490l.dismiss();
            }
        }
    }

    public class e implements jp.c {

        public class a extends Security2FADialogHelper.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Security2FADialogHelper f78502a;

            public a(Security2FADialogHelper security2FADialogHelper) {
                this.f78502a = security2FADialogHelper;
            }

            public void onFailed(String str) {
            }

            public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                OtcFlutterOrderDetailActivity.this.f78491m.s().c(authResult.getToken());
                this.f78502a.v();
            }
        }

        public class b implements jp.c {
            public b() {
            }

            public void call() {
                OtcFlutterOrderDetailActivity.this.f78491m.I();
            }
        }

        public e() {
        }

        public void call() {
            OtcFlutterOrderDetailActivity otcFlutterOrderDetailActivity = OtcFlutterOrderDetailActivity.this;
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(otcFlutterOrderDetailActivity, otcFlutterOrderDetailActivity, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.S(new a(security2FADialogHelper), new b());
        }
    }

    public static void Ki(Context context, String str, boolean z11) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("com.huobi.otc.lite.order.id", str);
        }
        if (z11) {
            intent.putExtra("com.huobi.otc.lite.auto.start", true);
        }
        intent.setClass(context, OtcFlutterOrderDetailActivity.class);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 0);
        }
    }

    public void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            if ("requestOrderId".equals(str)) {
                result.success(this.f78492n);
            } else if ("showFundPasswordAlert".equals(str)) {
                Ji(methodCall, this.f78489k);
                result.success((Object) null);
            } else if ("startUnreadMessageUpdate".equals(str)) {
                OtcOrderUnReadNumP otcOrderUnReadNumP = this.f78493o;
                if (otcOrderUnReadNumP != null) {
                    otcOrderUnReadNumP.j();
                    this.f78489k.invokeMethod("updateUnreadMessageCount", Integer.valueOf(this.f78493o.t()));
                }
                result.success((Object) null);
            } else if ("stopUnreadMessageUpdate".equals(str)) {
                OtcOrderUnReadNumP otcOrderUnReadNumP2 = this.f78493o;
                if (otcOrderUnReadNumP2 != null) {
                    otcOrderUnReadNumP2.i();
                }
                result.success((Object) null);
            } else if ("goChat".equals(str)) {
                l0.b(this, this.f78492n, false);
                result.success((Object) null);
            } else if ("showFAQDialog".equals(str)) {
                OtcFAQDialogActivity.gg(this, "orderDetail", this.f78492n);
                result.success((Object) null);
            } else if ("showResultPage".equals(str)) {
                boolean booleanValue = ((Boolean) methodCall.argument("isP2pOrder")).booleanValue();
                String str2 = (String) methodCall.argument("orderId");
                String str3 = (String) methodCall.argument("hbgContentUrl");
                if (!booleanValue) {
                    OtcTradePayingAndSuccessActivity.Qi(this, str2, str3);
                } else {
                    LiteSuccessBean liteSuccessBean = new LiteSuccessBean();
                    liteSuccessBean.setFromOrderDetail(((Boolean) methodCall.argument("isFromOrderDetail")).booleanValue());
                    liteSuccessBean.setBuy(((Boolean) methodCall.argument("isBuy")).booleanValue());
                    liteSuccessBean.setCoinQuantity((String) methodCall.argument(FirebaseAnalytics.Param.QUANTITY));
                    liteSuccessBean.setCoinName((String) methodCall.argument("cryptoAsset"));
                    liteSuccessBean.setAmount((String) methodCall.argument("amount"));
                    liteSuccessBean.setCurrencyName((String) methodCall.argument("quoteAsset"));
                    liteSuccessBean.setQuoteAssetName((String) methodCall.argument("quoteAssetName"));
                    liteSuccessBean.setOrderStatus(((Integer) methodCall.argument("orderStatus")).intValue());
                    liteSuccessBean.setOrderId((String) methodCall.argument("orderId"));
                    liteSuccessBean.setRoleName((String) methodCall.argument("roleName"));
                    liteSuccessBean.setRunMode(((Integer) methodCall.argument("runMode")).intValue());
                    liteSuccessBean.setQuote((String) methodCall.argument(ShareConstants.WEB_DIALOG_PARAM_QUOTE));
                    liteSuccessBean.setHbgContentUrl(str3);
                    liteSuccessBean.setIsP2pOrder(true);
                    OtcTradePayingAndSuccessActivity.Oi(this, liteSuccessBean);
                }
                result.success((Object) null);
            } else if ("merchantHome".equals(str)) {
                OtcModuleConfig.b().K(this, Long.valueOf((String) methodCall.argument("userId")));
                result.success((Object) null);
            } else if ("showActivePage".endsWith(str)) {
                String str4 = (String) methodCall.argument("hbgContentUrl");
                if (!TextUtils.isEmpty(str4)) {
                    HashMap hashMap = new HashMap();
                    hashMap.clear();
                    hashMap.put("hbgContentUrl", str4);
                    ActiveObserverHelper.b().a(new OberverData(1, hashMap));
                }
                result.success((Object) null);
            } else if ("showTradeNoviceGuide".equals(str)) {
                OtcModuleConfig.b().C(this, "21");
            } else if ("transferToProAccount".equals(str)) {
                ra.c.c().w(MapParamsBuilder.c().a(FirebaseAnalytics.Param.CURRENCY, ((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY)).toLowerCase(Locale.US)).a("amount", (String) methodCall.argument("amount")).a("type", FinanceRecordItem.TYPE_OTC_TO_PRO).b()).compose(RxJavaHelper.t((g) null)).subscribe(new c((g) null, result));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void Ji(MethodCall methodCall, MethodChannel methodChannel) {
        if (this.f78491m == null) {
            this.f78491m = new com.huobi.otc.helper.a(this, this);
        }
        this.f78491m.J(new d(methodCall, methodChannel));
        this.f78491m.M(new e());
    }

    public String Nh() {
        return "otc_order_detail";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_order_detail_channel");
        this.f78489k = methodChannel;
        methodChannel.setMethodCallHandler(new b());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f78492n = getIntent().getStringExtra("com.huobi.otc.lite.order.id");
        a aVar = new a();
        this.f78493o = aVar;
        aVar.k();
    }

    public void onDestroy() {
        super.onDestroy();
        OtcOrderUnReadNumP otcOrderUnReadNumP = this.f78493o;
        if (otcOrderUnReadNumP != null) {
            otcOrderUnReadNumP.h();
        }
    }

    public void onNewIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("com.huobi.otc.lite.order.id");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f78492n = stringExtra;
        }
        super.onNewIntent(intent);
    }

    public void onPause() {
        super.onPause();
        OtcOrderUnReadNumP otcOrderUnReadNumP = this.f78493o;
        if (otcOrderUnReadNumP != null) {
            otcOrderUnReadNumP.o(true);
        }
    }

    public void onResume() {
        super.onResume();
        if (getIntent() != null && getIntent().getBooleanExtra("com.huobi.otc.lite.auto.start", false)) {
            v1.a().e(this, this.f78492n, -1);
            getIntent().putExtra("com.huobi.otc.lite.auto.start", false);
        }
        OtcOrderUnReadNumP otcOrderUnReadNumP = this.f78493o;
        if (otcOrderUnReadNumP != null) {
            otcOrderUnReadNumP.j();
            this.f78489k.invokeMethod("updateUnreadMessageCount", Integer.valueOf(this.f78493o.t()));
        }
    }
}
