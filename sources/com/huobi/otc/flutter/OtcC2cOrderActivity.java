package com.huobi.otc.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.AdsData;
import com.huobi.otc.event.OtcAdPriceChangeEvent;
import com.huobi.otc.utils.OtcPayMethodUtil;
import com.huobi.utils.GsonHelper;
import cp.c;
import dp.t;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import jp.l;
import jp.v1;
import org.greenrobot.eventbus.EventBus;
import q6.d;
import u6.g;

public class OtcC2cOrderActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78442k;

    /* renamed from: l  reason: collision with root package name */
    public AdsData f78443l;

    /* renamed from: m  reason: collision with root package name */
    public t f78444m;

    /* renamed from: n  reason: collision with root package name */
    public com.huobi.otc.helper.a f78445n;

    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f78446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel f78447b;

        public a(MethodCall methodCall, MethodChannel methodChannel) {
            this.f78446a = methodCall;
            this.f78447b = methodChannel;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", this.f78446a.argument("action"));
            hashMap.put("securityToken", str);
            this.f78447b.invokeMethod("contiuneCreateOrder", hashMap);
        }

        public void d(BaseDialogFragment baseDialogFragment) {
        }

        public void e() {
        }

        public void f(t tVar) {
            t unused = OtcC2cOrderActivity.this.f78444m = tVar;
        }

        public boolean g() {
            return false;
        }

        public void h(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("action", this.f78446a.argument("action"));
            hashMap.put("tradePass", str);
            this.f78447b.invokeMethod("contiuneCreateOrder", hashMap);
            if (OtcC2cOrderActivity.this.f78444m != null && OtcC2cOrderActivity.this.f78444m.isShowing()) {
                OtcC2cOrderActivity.this.f78444m.dismiss();
            }
        }
    }

    public class b implements jp.c {

        public class a extends Security2FADialogHelper.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Security2FADialogHelper f78450a;

            public a(Security2FADialogHelper security2FADialogHelper) {
                this.f78450a = security2FADialogHelper;
            }

            public void onFailed(String str) {
            }

            public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                OtcC2cOrderActivity.this.f78445n.s().c(authResult.getToken());
                this.f78450a.v();
            }
        }

        /* renamed from: com.huobi.otc.flutter.OtcC2cOrderActivity$b$b  reason: collision with other inner class name */
        public class C0835b implements jp.c {
            public C0835b() {
            }

            public void call() {
                OtcC2cOrderActivity.this.f78445n.I();
            }
        }

        public b() {
        }

        public void call() {
            OtcC2cOrderActivity otcC2cOrderActivity = OtcC2cOrderActivity.this;
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(otcC2cOrderActivity, otcC2cOrderActivity, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.S(new a(security2FADialogHelper), new C0835b());
        }
    }

    public static AdsData Hi(Ads ads, boolean z11, String str, String str2) {
        AdsData adsData = new AdsData();
        adsData.setId(ads.getId());
        adsData.setUid(ads.getUid());
        adsData.setUserName(ads.getUserName());
        adsData.setMerchantLevel(ads.getMerchantLevel());
        adsData.setMerchantTags(ads.getMerchantTags());
        adsData.setCoinId(ads.getCoinId());
        adsData.setCurrency(ads.getCurrency());
        adsData.setTradeType(ads.getTradeType() == OtcTradeType.BUY ? 0 : 1);
        adsData.setPayMethod(ads.getPayMethodStr());
        adsData.setPayMethods(ads.getPayMethods());
        adsData.setPayTerm(ads.getPayTerm());
        adsData.setPayName(ads.getPayName());
        adsData.setMinTradeLimit(ads.getMinTradeLimit());
        adsData.setMaxTradeLimit(ads.getMaxTradeLimit());
        adsData.setPrice(ads.getPrice());
        adsData.setTradeCount(ads.getTradeCount());
        adsData.setOnline(ads.isOnline());
        adsData.setFollowed(ads.isFollowed());
        adsData.setTradeMonthTimes(ads.getTradeMonthTimes());
        adsData.setOrderCompleteRate(ads.getOrderCompleteRate());
        adsData.setTakerAcceptOrder(ads.getTakerAcceptOrder());
        adsData.setTakerAcceptAmount(ads.getTakerAcceptAmount());
        adsData.setTakerLimit(ads.getTakerLimit());
        adsData.setGmtSort(ads.getGmtSort());
        adsData.setThumbUp(ads.getThumbUp());
        adsData.setSeaViewRoom(ads.getSeaViewRoom());
        adsData.setFromWatchword(z11);
        adsData.setShareCode(str);
        adsData.setWatchword(str2);
        adsData.setBlockType(ads.getBlockType());
        return adsData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ii(UserVO userVO) {
        if (userVO == null || userVO.isVerifyWayHaveSet()) {
            OtcModuleConfig.b().V(this);
        } else {
            OtcModuleConfig.b().H(this);
        }
    }

    public static void Ji(Activity activity, Ads ads, boolean z11, String str, String str2) {
        Li(activity, Hi(ads, z11, str, str2));
    }

    public static void Li(Context context, AdsData adsData) {
        Intent intent = new Intent(context, OtcC2cOrderActivity.class);
        intent.putExtra("key_ads", adsData);
        context.startActivity(intent);
    }

    public void Ki(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1683831941:
                    if (str.equals("pushToMerchantProfilePage")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1000656469:
                    if (str.equals("pushToRechargePage")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -994367249:
                    if (str.equals("pushToTransferPage")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -911137666:
                    if (str.equals("pushToPaymentListPage")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -57714072:
                    if (str.equals("callbackWhenQuotePriceChanged")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 413024254:
                    if (str.equals("retrieveAdvertInfo")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 1014855665:
                    if (str.equals("createOrderSuccess")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1603547744:
                    if (str.equals("pushToAllOrdersPage")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1992461996:
                    if (str.equals("gotoOtcTradeSettings")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case 2133727302:
                    if (str.equals("interruptTransactionWhenNeedPassword")) {
                        c11 = 7;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    AdsData adsData = this.f78443l;
                    if (adsData != null) {
                        adsData.setCoinName(va.b.g(adsData.getCoinId()));
                        result.success(GsonHelper.a().toJson((Object) this.f78443l));
                        return;
                    }
                    result.success((Object) null);
                    return;
                case 1:
                    OtcModuleConfig.b().K(this, Long.valueOf(methodCall.arguments().toString()));
                    result.success((Object) null);
                    return;
                case 2:
                    String str2 = (String) methodCall.argument("orderId");
                    String str3 = (String) methodCall.argument("selectedPayMethodId");
                    if (this.f78443l.getTradeType() == 1) {
                        OtcModuleConfig.a().d0(this, str2, "", str3);
                    } else {
                        v1.a().g(this, str2, false);
                    }
                    result.success((Object) null);
                    return;
                case 3:
                    OtcModuleConfig.b().U(this, (Intent) null);
                    result.success((Object) null);
                    return;
                case 4:
                    OtcPayMethodUtil.e(this);
                    result.success((Object) null);
                    return;
                case 5:
                    OtcModuleConfig.b().B(this, StringUtils.g(va.b.g(this.f78443l.getCoinId())), true, (String) null, false);
                    result.success((Object) null);
                    return;
                case 6:
                    UnifyDepositActivity.wh(this, StringUtils.g(va.b.g(this.f78443l.getCoinId())));
                    result.success((Object) null);
                    return;
                case 7:
                    Mi(methodCall, this.f78442k);
                    result.success((Object) null);
                    return;
                case 8:
                    l.q(false).compose(RxJavaHelper.t((g) null)).subscribe(d.c((g) null, new o(this)));
                    result.success((Object) null);
                    return;
                case 9:
                    OtcAdPriceChangeEvent otcAdPriceChangeEvent = new OtcAdPriceChangeEvent();
                    otcAdPriceChangeEvent.advertId = (String) methodCall.argument("advertId");
                    otcAdPriceChangeEvent.price = (String) methodCall.argument(FirebaseAnalytics.Param.PRICE);
                    EventBus.d().k(otcAdPriceChangeEvent);
                    result.success((Object) null);
                    return;
                default:
                    return;
            }
        } catch (Exception e11) {
            System.out.println("methodCall.arguments error ====== " + e11);
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public void Mi(MethodCall methodCall, MethodChannel methodChannel) {
        if (this.f78445n == null) {
            this.f78445n = new com.huobi.otc.helper.a(this, this);
        }
        this.f78445n.J(new a(methodCall, methodChannel));
        this.f78445n.M(new b());
    }

    public String Nh() {
        return "c2c_create_order";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "c2c_create_order_channel");
        this.f78442k = methodChannel;
        methodChannel.setMethodCallHandler(new n(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f78443l = (AdsData) intent.getSerializableExtra("key_ads");
        }
    }

    public void onResume() {
        super.onResume();
    }
}
