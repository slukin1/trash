package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.CardOrderPayResultBean;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.trade.bean.LiteSuccessBean;
import com.hbg.module.huobi.im.group.bean.OberverData;
import com.hbg.module.huobi.im.observer.ActiveObserverHelper;
import com.hbg.module.otc.OtcModuleConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.coupon.bean.Coupon;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.event.FromWebPageBackEvent;
import com.huobi.otc.helper.OtcMerchantProfileSwither;
import com.huobi.otc.service.OTCService;
import com.huobi.otc.ui.HBSupportFormWebActivity;
import com.huobi.utils.GsonHelper;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import i6.i;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import jp.k0;
import jp.v1;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import u6.g;
import up.w;

public class OtcTradePayingAndSuccessActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78593k;

    /* renamed from: l  reason: collision with root package name */
    public String f78594l;

    /* renamed from: m  reason: collision with root package name */
    public LiteSuccessBean f78595m;

    /* renamed from: n  reason: collision with root package name */
    public String f78596n;

    /* renamed from: o  reason: collision with root package name */
    public HashMap f78597o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f78598p = false;

    public class a extends q6.d<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f78599e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, MethodChannel.Result result) {
            super(gVar);
            this.f78599e = result;
        }

        /* renamed from: j */
        public void onNext(String str) {
            OtcTradePayingAndSuccessActivity.this.Si();
        }

        public void onAfter() {
            super.onAfter();
            this.f78599e.success((Object) null);
        }

        public void onError2(Throwable th2) {
            if (th2 != null && !TextUtils.isEmpty(th2.getMessage())) {
                i.b().g(l0.f78658b, 2000);
            }
            OtcTradePayingAndSuccessActivity.this.Ri();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (aPIStatusErrorException != null && !TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                i.b().g(new k0(aPIStatusErrorException), 2000);
            }
            OtcTradePayingAndSuccessActivity.this.Ri();
        }
    }

    public class b extends TypeToken<List<CardOrderPayResultBean.Preconditions>> {
        public b() {
        }
    }

    public class c extends TypeToken<List<CardOrderPayResultBean.Parameters>> {
        public c() {
        }
    }

    public class d implements w.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ads f78603a;

        public class a extends BaseSubscriber<LegalQueryData> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ OtcAdTicket f78605b;

            public a(OtcAdTicket otcAdTicket) {
                this.f78605b = otcAdTicket;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void f(Ads ads, HBDialogFragment hBDialogFragment) {
                hBDialogFragment.dismiss();
                OtcModuleConfig.b().T(OtcTradePayingAndSuccessActivity.this, ads, true, (String) null, (String) null);
                OtcTradePayingAndSuccessActivity.this.finish();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void h(Ads ads, HBDialogFragment hBDialogFragment) {
                OtcModuleConfig.b().S(OtcTradePayingAndSuccessActivity.this, ads.getCoinId(), "2", -1);
                hBDialogFragment.dismiss();
            }

            /* renamed from: i */
            public void onNext(LegalQueryData legalQueryData) {
                super.onNext(legalQueryData);
                if (m.h0(legalQueryData.getAvaialAble()) > 0.0d) {
                    if (m.a(this.f78605b.getPrice()).compareTo(BigDecimal.ZERO) > 0 && m.a(this.f78605b.getPrice()).compareTo(m.a(d.this.f78603a.getPrice())) == 0) {
                        uf.b b11 = OtcModuleConfig.b();
                        d dVar = d.this;
                        b11.T(OtcTradePayingAndSuccessActivity.this, dVar.f78603a, true, (String) null, (String) null);
                        OtcTradePayingAndSuccessActivity.this.finish();
                        return;
                    }
                    OtcTradePayingAndSuccessActivity otcTradePayingAndSuccessActivity = OtcTradePayingAndSuccessActivity.this;
                    DialogUtils.c0(otcTradePayingAndSuccessActivity, otcTradePayingAndSuccessActivity.getString(R.string.otc_price_change_tip), "", OtcTradePayingAndSuccessActivity.this.getString(R.string.otc_ppace_order_dialog_btn_cancel), OtcTradePayingAndSuccessActivity.this.getString(R.string.otc_ppace_order_dialog_btn_continue), q0.f78673a, new o0(this, d.this.f78603a));
                    return;
                }
                String string = BaseApplication.b().getResources().getString(R.string.otc_sell_transfer_hint_dialog_content);
                String string2 = BaseApplication.b().getResources().getString(R.string.otc_sell_transfer_dialog_cancle);
                String string3 = BaseApplication.b().getResources().getString(R.string.otc_sell_transfer_dialog);
                d dVar2 = d.this;
                DialogUtils.c0(OtcTradePayingAndSuccessActivity.this, string, (String) null, string2, string3, r0.f78675a, new p0(this, dVar2.f78603a));
            }
        }

        public d(Ads ads) {
            this.f78603a = ads;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Ads ads, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            OtcModuleConfig.b().T(OtcTradePayingAndSuccessActivity.this, ads, true, (String) null, (String) null);
            OtcTradePayingAndSuccessActivity.this.finish();
        }

        public void a(TradeReMarkBean tradeReMarkBean, OtcAdTicket otcAdTicket, List<Coupon> list) {
            if (this.f78603a.getTradeType() == OtcTradeType.BUY) {
                ((OTCService) OtcRetrofit.request(OTCService.class)).getWalletByCoinId(this.f78603a.getCoinId()).compose(OtcRetrofit.o()).compose(RxJavaHelper.t(OtcTradePayingAndSuccessActivity.this)).subscribe(new a(otcAdTicket));
                return;
            }
            if (m.a(otcAdTicket.getPrice()).compareTo(BigDecimal.ZERO) > 0 && m.a(otcAdTicket.getPrice()).compareTo(m.a(this.f78603a.getPrice())) == 0) {
                OtcModuleConfig.b().T(OtcTradePayingAndSuccessActivity.this, this.f78603a, true, (String) null, (String) null);
                OtcTradePayingAndSuccessActivity.this.finish();
                return;
            }
            OtcTradePayingAndSuccessActivity otcTradePayingAndSuccessActivity = OtcTradePayingAndSuccessActivity.this;
            DialogUtils.c0(otcTradePayingAndSuccessActivity, otcTradePayingAndSuccessActivity.getString(R.string.otc_price_change_tip), "", OtcTradePayingAndSuccessActivity.this.getString(R.string.otc_ppace_order_dialog_btn_cancel), OtcTradePayingAndSuccessActivity.this.getString(R.string.otc_ppace_order_dialog_btn_continue), n0.f78663a, new m0(this, this.f78603a));
        }

        public void b() {
            boolean unused = OtcTradePayingAndSuccessActivity.this.f78598p = true;
        }
    }

    public static void Oi(Context context, LiteSuccessBean liteSuccessBean) {
        Intent intent = new Intent(context, OtcTradePayingAndSuccessActivity.class);
        intent.putExtra("key_lite_success_bean", liteSuccessBean);
        context.startActivity(intent);
    }

    public static void Pi(Context context, String str) {
        Intent intent = new Intent(context, OtcTradePayingAndSuccessActivity.class);
        intent.putExtra("key_order_id", str);
        context.startActivity(intent);
    }

    public static void Qi(Context context, String str, String str2) {
        Intent intent = new Intent(context, OtcTradePayingAndSuccessActivity.class);
        intent.putExtra("key_order_id", str);
        intent.putExtra("hbgContentUrl", str2);
        context.startActivity(intent);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void FromWebPageBack(FromWebPageBackEvent fromWebPageBackEvent) {
        MethodChannel methodChannel = this.f78593k;
        if (methodChannel != null) {
            methodChannel.invokeMethod("resetBackFromWeb", "");
        }
    }

    public final void Hi(Ads ads) {
        w.n(this, ads, this, Boolean.FALSE, new d(ads), (String) null);
    }

    public final void Ii(MethodCall methodCall, MethodChannel.Result result) {
        try {
            HashMap hashMap = new HashMap();
            LiteSuccessBean liteSuccessBean = this.f78595m;
            if (liteSuccessBean == null) {
                hashMap.put("orderId", this.f78594l);
            } else {
                hashMap.put("orderId", liteSuccessBean.getOrderId());
                hashMap.put("isBuy", Boolean.valueOf(this.f78595m.isBuy()));
                hashMap.put(FirebaseAnalytics.Param.QUANTITY, this.f78595m.getCoinQuantity());
                hashMap.put("cryptoAsset", this.f78595m.getCoinName());
                hashMap.put("amount", this.f78595m.getAmount());
                hashMap.put("quoteAsset", this.f78595m.getQuoteAssetName());
                hashMap.put("isP2pOrder", Boolean.valueOf(this.f78595m.isP2pOrder()));
                hashMap.put("orderStatus", Integer.valueOf(this.f78595m.getOrderStatus()));
                hashMap.put("isFromOrderDetail", Boolean.valueOf(this.f78595m.isFromOrderDetail()));
                hashMap.put("quoteAssetName", this.f78595m.getQuoteAssetName());
                hashMap.put("roleName", this.f78595m.getRoleName());
                hashMap.put("runMode", Integer.valueOf(this.f78595m.getRunMode()));
                hashMap.put(ShareConstants.WEB_DIALOG_PARAM_QUOTE, this.f78595m.getQuote());
            }
            result.success(new Gson().toJson((Object) hashMap));
        } catch (Exception e11) {
            result.error("OtcAdPublishEditActivity error", e11.getMessage(), e11.getMessage());
        }
    }

    public final void Ji(Intent intent) {
        if (intent.hasExtra("key_lite_success_bean")) {
            LiteSuccessBean liteSuccessBean = (LiteSuccessBean) intent.getSerializableExtra("key_lite_success_bean");
            this.f78595m = liteSuccessBean;
            if (liteSuccessBean != null) {
                this.f78596n = liteSuccessBean.getHbgContentUrl();
                return;
            }
            return;
        }
        this.f78596n = intent.getStringExtra("hbgContentUrl");
        this.f78594l = intent.getStringExtra("key_order_id");
        Uri data = getIntent().getData();
        if (data != null) {
            String decode = Uri.decode(data.toString());
            if (decode.contains("from_cpf")) {
                finish();
                return;
            } else if (!decode.contains("otc_bind_card") || !decode.contains(TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER)) {
                uf.c.b().o("callback_threeparty", "otc.pay.page.callback_threeparty", (HashMap) null);
                if (!OtcModuleConfig.a().a() || !decode.contains("orderId")) {
                    if (qu.d.i().m()) {
                        k0.k(this);
                    }
                    finish();
                } else {
                    this.f78594l = Li(decode, "orderId");
                }
            } else {
                if (OtcModuleConfig.a().a()) {
                    OtcModuleConfig.b().U(this, (Intent) null);
                } else {
                    OtcModuleConfig.b().k(this);
                }
                finish();
            }
        }
        if (TextUtils.isEmpty(this.f78594l)) {
            finish();
        }
    }

    public final String Ki(List<CardOrderPayResultBean.Parameters> list) {
        if (CollectionsUtils.b(list)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (CardOrderPayResultBean.Parameters next : list) {
            sb2.append(next.getName());
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(next.getValue());
            if (list.indexOf(next) != list.size() - 1) {
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        i6.d.e("getPostData--->", sb2.toString());
        return sb2.toString();
    }

    public final String Li(String str, String str2) {
        int length = str.length();
        int i11 = 0;
        while (true) {
            int indexOf = str.indexOf(38, i11);
            int i12 = indexOf != -1 ? indexOf : length;
            int indexOf2 = str.indexOf(61, i11);
            if (indexOf2 > i12 || indexOf2 == -1) {
                indexOf2 = i12;
            }
            if (indexOf2 - i11 != str2.length() || !str.regionMatches(i11, str2, 0, str2.length())) {
                if (indexOf == -1) {
                    return "";
                }
                i11 = indexOf + 1;
            } else if (indexOf2 == i12) {
                return "";
            } else {
                return str.substring(indexOf2 + 1, i12);
            }
        }
    }

    public String Nh() {
        return "otc_trade_paying_success";
    }

    /* renamed from: Ni */
    public final void Mi(MethodCall methodCall, MethodChannel.Result result) {
        Intent intent;
        try {
            String str = methodCall.method;
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1949106608:
                    if (str.equals("getInitData")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1410482359:
                    if (str.equals("toReCommitForm")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case -1093381338:
                    if (str.equals("transferToProAccount")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -866217125:
                    if (str.equals("openProMainHome")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -657047150:
                    if (str.equals("showActivePage")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case -505616354:
                    if (str.equals("contactCustomer")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -466089718:
                    if (str.equals("toGetAdTicket")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case -233308526:
                    if (str.equals("toMerchantPage")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case -200360833:
                    if (str.equals("openOtcTradeActivity")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -51810539:
                    if (str.equals("jumpToDeposit")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 328509380:
                    if (str.equals("toOrderDetail")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 559902537:
                    if (str.equals("openNewAssetPage")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    Ii(methodCall, result);
                    return;
                case 1:
                    LiteSuccessBean liteSuccessBean = this.f78595m;
                    if (liteSuccessBean == null || !liteSuccessBean.isFromOrderDetail()) {
                        v1.a().f(this, (String) methodCall.argument("orderId"));
                    }
                    finish();
                    return;
                case 2:
                    OtcModuleConfig.b().l(this, "Started chat with mandatory pre-chat form");
                    finish();
                    return;
                case 3:
                    boolean booleanValue = ((Boolean) methodCall.argument("isFinish")).booleanValue();
                    Uh();
                    result.success((Object) null);
                    if (booleanValue) {
                        finish();
                        return;
                    }
                    return;
                case 4:
                    ra.c.c().w(MapParamsBuilder.c().a(FirebaseAnalytics.Param.CURRENCY, ((String) methodCall.argument(FirebaseAnalytics.Param.CURRENCY)).toLowerCase(Locale.US)).a("amount", (String) methodCall.argument("amount")).a("type", FinanceRecordItem.TYPE_OTC_TO_PRO).b()).compose(RxJavaHelper.t((g) null)).subscribe(new a((g) null, result));
                    return;
                case 5:
                    Ri();
                    result.success((Object) null);
                    return;
                case 6:
                    if (ra.c.c().u()) {
                        intent = ra.c.b().m(this);
                    } else {
                        intent = ra.c.b().o(this);
                    }
                    startActivity(intent);
                    return;
                case 7:
                    int intValue = ((Integer) methodCall.argument("tradeSide")).intValue();
                    Intent intent2 = new Intent(this, ra.c.b().f());
                    intent2.setFlags(67108864);
                    intent2.putExtra("tradeSide", intValue);
                    startActivity(intent2);
                    return;
                case 8:
                    Map map = (Map) methodCall.argument("verifyExtend");
                    if (!CollectionsUtils.c(map)) {
                        String json = GsonHelper.a().toJson((Object) map);
                        i6.d.e("verifyExtend data::", json);
                        Ti((CardOrderPayResultBean.VerifyExtend) GsonHelper.a().fromJson(json, CardOrderPayResultBean.VerifyExtend.class));
                    }
                    result.success((Object) null);
                    return;
                case 9:
                    String str2 = (String) methodCall.argument("hbgContentUrl");
                    if (!TextUtils.isEmpty(str2)) {
                        if (this.f78597o == null) {
                            this.f78597o = new HashMap();
                        }
                        this.f78597o.clear();
                        this.f78597o.put("hbgContentUrl", str2);
                        ActiveObserverHelper.b().a(new OberverData(1, this.f78597o));
                        return;
                    }
                    return;
                case 10:
                    OtcMerchantProfileSwither.a(this, Long.valueOf(methodCall.argument("uid").toString()));
                    result.success((Object) null);
                    finish();
                    return;
                case 11:
                    if (!OtcModuleConfig.a().a()) {
                        OtcModuleConfig.a().l(this, (Intent) null, (Intent) null);
                        result.success(Boolean.FALSE);
                        return;
                    }
                    Ads ads = (Ads) new Gson().fromJson(methodCall.arguments.toString(), Ads.class);
                    if (ads != null) {
                        if (ads.hasEnablePay()) {
                            Hi(ads);
                        } else {
                            HuobiToastUtil.g(R.string.otc_order_detail_pay_method_not_support);
                        }
                        result.success(Boolean.TRUE);
                        return;
                    }
                    result.success(Boolean.FALSE);
                    return;
                default:
                    result.success((Object) null);
                    return;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success("");
        }
    }

    public final void Ri() {
        finish();
    }

    public final void Si() {
        finish();
    }

    public final void Ti(CardOrderPayResultBean.VerifyExtend verifyExtend) {
        if (verifyExtend != null) {
            ArrayList arrayList = new ArrayList();
            List<CardOrderPayResultBean.Preconditions> list = (List) GsonHelper.a().fromJson(verifyExtend.getPreconditions(), new b().getType());
            if (!CollectionsUtils.b(list)) {
                for (CardOrderPayResultBean.Preconditions preconditions : list) {
                    if (preconditions != null) {
                        String url = preconditions.getUrl();
                        arrayList.add(new MapParamsBuilder().a("postUrl", url).a("postForm", Ki(preconditions.getParameters())).b());
                    }
                }
            }
            List list2 = (List) GsonHelper.a().fromJson(verifyExtend.getParameters(), new c().getType());
            HashMap hashMap = new HashMap();
            arrayList.add(hashMap);
            hashMap.put("postUrl", verifyExtend.getVerifyUrl());
            if (!CollectionsUtils.b(list2)) {
                hashMap.put("postForm", Ki(list2));
            }
            HBSupportFormWebActivity.Ah(this, HBSupportFormWebActivity.yh(this, verifyExtend.getVerifyUrl(), "", "", false), arrayList);
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_paying_success_channel");
        this.f78593k = methodChannel;
        methodChannel.setMethodCallHandler(new j0(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ji(getIntent());
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri data = getIntent().getData();
        if (data != null) {
            String uri = data.toString();
            i6.d.e("uri--1->", uri);
            if (uri.contains("orderId")) {
                this.f78594l = Li(uri, "orderId");
            }
            this.f78593k.invokeMethod("order_paying_refresh", (Object) null);
        }
    }

    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(this.f78596n)) {
            String str = this.f78596n;
            this.f78596n = null;
            if (this.f78597o == null) {
                this.f78597o = new HashMap();
            }
            this.f78597o.clear();
            this.f78597o.put("hbgContentUrl", str);
            ActiveObserverHelper.b().a(new OberverData(1, this.f78597o));
        }
        if (this.f78598p) {
            this.f78598p = false;
            OtcModuleConfig.a().e("");
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        finish();
    }
}
