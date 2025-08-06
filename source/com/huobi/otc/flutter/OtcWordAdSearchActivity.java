package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.coupon.bean.Coupon;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.service.OTCService;
import i6.m;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.math.BigDecimal;
import java.util.List;
import pro.huobi.R;
import uf.b;
import up.w;

public class OtcWordAdSearchActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f78611k;

    /* renamed from: l  reason: collision with root package name */
    public String f78612l;

    /* renamed from: m  reason: collision with root package name */
    public String f78613m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f78614n = false;

    public class a implements w.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Ads f78615a;

        /* renamed from: com.huobi.otc.flutter.OtcWordAdSearchActivity$a$a  reason: collision with other inner class name */
        public class C0838a extends BaseSubscriber<LegalQueryData> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ OtcAdTicket f78617b;

            public C0838a(OtcAdTicket otcAdTicket) {
                this.f78617b = otcAdTicket;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void f(Ads ads, HBDialogFragment hBDialogFragment) {
                hBDialogFragment.dismiss();
                b b11 = OtcModuleConfig.b();
                OtcWordAdSearchActivity otcWordAdSearchActivity = OtcWordAdSearchActivity.this;
                b11.T(otcWordAdSearchActivity, ads, true, otcWordAdSearchActivity.f78613m, OtcWordAdSearchActivity.this.f78612l);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void h(Ads ads, HBDialogFragment hBDialogFragment) {
                OtcModuleConfig.b().S(OtcWordAdSearchActivity.this, ads.getCoinId(), "2", -1);
                hBDialogFragment.dismiss();
            }

            /* renamed from: i */
            public void onNext(LegalQueryData legalQueryData) {
                super.onNext(legalQueryData);
                if (m.h0(legalQueryData.getAvaialAble()) > 0.0d) {
                    if (m.a(this.f78617b.getPrice()).compareTo(BigDecimal.ZERO) > 0 && m.a(this.f78617b.getPrice()).compareTo(m.a(a.this.f78615a.getPrice())) == 0) {
                        b b11 = OtcModuleConfig.b();
                        a aVar = a.this;
                        OtcWordAdSearchActivity otcWordAdSearchActivity = OtcWordAdSearchActivity.this;
                        b11.T(otcWordAdSearchActivity, aVar.f78615a, true, otcWordAdSearchActivity.f78613m, OtcWordAdSearchActivity.this.f78612l);
                        return;
                    }
                    OtcWordAdSearchActivity otcWordAdSearchActivity2 = OtcWordAdSearchActivity.this;
                    DialogUtils.c0(otcWordAdSearchActivity2, otcWordAdSearchActivity2.getString(R.string.otc_price_change_tip), "", OtcWordAdSearchActivity.this.getString(R.string.otc_ppace_order_dialog_btn_cancel), OtcWordAdSearchActivity.this.getString(R.string.otc_ppace_order_dialog_btn_continue), z0.f78694a, new x0(this, a.this.f78615a));
                    return;
                }
                String string = BaseApplication.b().getResources().getString(R.string.otc_sell_transfer_hint_dialog_content);
                String string2 = BaseApplication.b().getResources().getString(R.string.otc_sell_transfer_dialog_cancle);
                String string3 = BaseApplication.b().getResources().getString(R.string.otc_sell_transfer_dialog);
                a aVar2 = a.this;
                DialogUtils.c0(OtcWordAdSearchActivity.this, string, (String) null, string2, string3, a1.f78631a, new y0(this, aVar2.f78615a));
            }
        }

        public a(Ads ads) {
            this.f78615a = ads;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Ads ads, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            b b11 = OtcModuleConfig.b();
            OtcWordAdSearchActivity otcWordAdSearchActivity = OtcWordAdSearchActivity.this;
            b11.T(otcWordAdSearchActivity, ads, true, otcWordAdSearchActivity.f78613m, OtcWordAdSearchActivity.this.f78612l);
        }

        public void a(TradeReMarkBean tradeReMarkBean, OtcAdTicket otcAdTicket, List<Coupon> list) {
            if (this.f78615a.getTradeType() == OtcTradeType.BUY) {
                ((OTCService) OtcRetrofit.request(OTCService.class)).getWalletByCoinId(this.f78615a.getCoinId()).compose(OtcRetrofit.o()).compose(RxJavaHelper.t(OtcWordAdSearchActivity.this)).subscribe(new C0838a(otcAdTicket));
                return;
            }
            OtcAdTicket otcAdTicket2 = otcAdTicket;
            if (m.a(otcAdTicket.getPrice()).compareTo(BigDecimal.ZERO) > 0 && m.a(otcAdTicket.getPrice()).compareTo(m.a(this.f78615a.getPrice())) == 0) {
                b b11 = OtcModuleConfig.b();
                OtcWordAdSearchActivity otcWordAdSearchActivity = OtcWordAdSearchActivity.this;
                b11.T(otcWordAdSearchActivity, this.f78615a, true, otcWordAdSearchActivity.f78613m, OtcWordAdSearchActivity.this.f78612l);
                return;
            }
            OtcWordAdSearchActivity otcWordAdSearchActivity2 = OtcWordAdSearchActivity.this;
            DialogUtils.c0(otcWordAdSearchActivity2, otcWordAdSearchActivity2.getString(R.string.otc_price_change_tip), "", OtcWordAdSearchActivity.this.getString(R.string.otc_ppace_order_dialog_btn_cancel), OtcWordAdSearchActivity.this.getString(R.string.otc_ppace_order_dialog_btn_continue), w0.f78686a, new v0(this, this.f78615a));
        }

        public void b() {
            boolean unused = OtcWordAdSearchActivity.this.f78614n = true;
        }
    }

    public static void Ji(Context context, String str, String str2) {
        Intent intent = new Intent(context, OtcWordAdSearchActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("key_ad_word", str);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("key_share_code", str2);
        }
        context.startActivity(intent);
    }

    public final void Gi(Ads ads) {
        w.n(this, ads, this, Boolean.FALSE, new a(ads), (String) null);
    }

    public final void Hi(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra("key_ad_word")) {
                this.f78612l = intent.getStringExtra("key_ad_word");
            }
            if (intent.hasExtra("key_share_code")) {
                this.f78613m = intent.getStringExtra("key_share_code");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Ii(io.flutter.plugin.common.MethodCall r6, io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = "email"
            r1 = 0
            java.lang.String r2 = r6.method     // Catch:{ Exception -> 0x013d }
            r3 = -1
            int r4 = r2.hashCode()     // Catch:{ Exception -> 0x013d }
            switch(r4) {
                case -2143834347: goto L_0x0054;
                case -1949106608: goto L_0x004a;
                case -604500481: goto L_0x0040;
                case -581001744: goto L_0x0036;
                case -470125531: goto L_0x002c;
                case -466089718: goto L_0x0022;
                case -233308526: goto L_0x0018;
                case -143758473: goto L_0x000e;
                default: goto L_0x000d;
            }     // Catch:{ Exception -> 0x013d }
        L_0x000d:
            goto L_0x005d
        L_0x000e:
            java.lang.String r4 = "toNewGlobalC2"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x005d
            r3 = 5
            goto L_0x005d
        L_0x0018:
            java.lang.String r4 = "toMerchantPage"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x005d
            r3 = 4
            goto L_0x005d
        L_0x0022:
            java.lang.String r4 = "toGetAdTicket"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x005d
            r3 = 7
            goto L_0x005d
        L_0x002c:
            java.lang.String r4 = "toBindPhoneActivity"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x005d
            r3 = 6
            goto L_0x005d
        L_0x0036:
            java.lang.String r4 = "getPriceWithNumberHelper"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x005d
            r3 = 2
            goto L_0x005d
        L_0x0040:
            java.lang.String r4 = "getCurrencySymbol"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x005d
            r3 = 1
            goto L_0x005d
        L_0x004a:
            java.lang.String r4 = "getInitData"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x005d
            r3 = 0
            goto L_0x005d
        L_0x0054:
            java.lang.String r4 = "getCoinNameByCoinId"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x013d }
            if (r2 == 0) goto L_0x005d
            r3 = 3
        L_0x005d:
            java.lang.String r2 = ""
            switch(r3) {
                case 0: goto L_0x012e;
                case 1: goto L_0x011a;
                case 2: goto L_0x0102;
                case 3: goto L_0x00ee;
                case 4: goto L_0x00d9;
                case 5: goto L_0x00d1;
                case 6: goto L_0x00ad;
                case 7: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x0144
        L_0x0064:
            uf.a r0 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x013d }
            boolean r0 = r0.a()     // Catch:{ Exception -> 0x013d }
            if (r0 != 0) goto L_0x007b
            uf.a r6 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x013d }
            r6.l(r5, r1, r1)     // Catch:{ Exception -> 0x013d }
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x013d }
            r7.success(r6)     // Catch:{ Exception -> 0x013d }
            return
        L_0x007b:
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x013d }
            r0.<init>()     // Catch:{ Exception -> 0x013d }
            java.lang.Object r6 = r6.arguments     // Catch:{ Exception -> 0x013d }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x013d }
            java.lang.Class<com.huobi.otc.bean.Ads> r2 = com.huobi.otc.bean.Ads.class
            java.lang.Object r6 = r0.fromJson((java.lang.String) r6, r2)     // Catch:{ Exception -> 0x013d }
            com.huobi.otc.bean.Ads r6 = (com.huobi.otc.bean.Ads) r6     // Catch:{ Exception -> 0x013d }
            if (r6 == 0) goto L_0x00a6
            boolean r0 = r6.hasEnablePay()     // Catch:{ Exception -> 0x013d }
            if (r0 == 0) goto L_0x009a
            r5.Gi(r6)     // Catch:{ Exception -> 0x013d }
            goto L_0x00a0
        L_0x009a:
            r6 = 2132025766(0x7f1421a6, float:1.9690046E38)
            com.hbg.lib.widgets.utils.HuobiToastUtil.g(r6)     // Catch:{ Exception -> 0x013d }
        L_0x00a0:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x013d }
            r7.success(r6)     // Catch:{ Exception -> 0x013d }
            return
        L_0x00a6:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x013d }
            r7.success(r6)     // Catch:{ Exception -> 0x013d }
            goto L_0x0144
        L_0x00ad:
            uf.b r3 = com.hbg.module.otc.OtcModuleConfig.b()     // Catch:{ Exception -> 0x013d }
            boolean r4 = r6.hasArgument(r0)     // Catch:{ Exception -> 0x013d }
            if (r4 == 0) goto L_0x00be
            java.lang.Object r6 = r6.argument(r0)     // Catch:{ Exception -> 0x013d }
            r2 = r6
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x013d }
        L_0x00be:
            android.content.Intent r6 = r3.g(r5, r2)     // Catch:{ Exception -> 0x013d }
            java.lang.String r0 = "otc_bind_phone_action"
            java.lang.String r2 = "lite_order_otc_bind_phone"
            r6.putExtra(r0, r2)     // Catch:{ Exception -> 0x013d }
            r5.startActivity(r6)     // Catch:{ Exception -> 0x013d }
            r7.success(r1)     // Catch:{ Exception -> 0x013d }
            goto L_0x0144
        L_0x00d1:
            jp.f0 r6 = jp.f0.a()     // Catch:{ Exception -> 0x013d }
            r6.e(r5)     // Catch:{ Exception -> 0x013d }
            goto L_0x0144
        L_0x00d9:
            java.lang.String r0 = "uid"
            java.lang.Object r6 = r6.argument(r0)     // Catch:{ Exception -> 0x013d }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x013d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x013d }
            com.huobi.otc.helper.OtcMerchantProfileSwither.a(r5, r6)     // Catch:{ Exception -> 0x013d }
            r7.success(r1)     // Catch:{ Exception -> 0x013d }
            goto L_0x0144
        L_0x00ee:
            java.lang.String r0 = "id"
            java.lang.Object r6 = r6.argument(r0)     // Catch:{ Exception -> 0x013d }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x013d }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x013d }
            java.lang.String r6 = va.b.g(r6)     // Catch:{ Exception -> 0x013d }
            r7.success(r6)     // Catch:{ Exception -> 0x013d }
            goto L_0x0144
        L_0x0102:
            java.lang.String r0 = "price"
            java.lang.Object r6 = r6.argument(r0)     // Catch:{ Exception -> 0x013d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x013d }
            uf.a r0 = com.hbg.module.otc.OtcModuleConfig.a()     // Catch:{ Exception -> 0x013d }
            int r2 = i6.m.U(r6)     // Catch:{ Exception -> 0x013d }
            java.lang.String r6 = r0.v(r6, r2)     // Catch:{ Exception -> 0x013d }
            r7.success(r6)     // Catch:{ Exception -> 0x013d }
            goto L_0x0144
        L_0x011a:
            java.lang.String r0 = "currency"
            java.lang.Object r6 = r6.argument(r0)     // Catch:{ Exception -> 0x013d }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x013d }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x013d }
            java.lang.String r6 = va.b.k(r6)     // Catch:{ Exception -> 0x013d }
            r7.success(r6)     // Catch:{ Exception -> 0x013d }
            goto L_0x0144
        L_0x012e:
            java.lang.String r6 = r5.f78612l     // Catch:{ Exception -> 0x013d }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x013d }
            if (r6 == 0) goto L_0x0137
            goto L_0x0139
        L_0x0137:
            java.lang.String r2 = r5.f78612l     // Catch:{ Exception -> 0x013d }
        L_0x0139:
            r7.success(r2)     // Catch:{ Exception -> 0x013d }
            goto L_0x0144
        L_0x013d:
            r6 = move-exception
            r6.printStackTrace()
            r7.success(r1)
        L_0x0144:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.flutter.OtcWordAdSearchActivity.Ii(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public String Nh() {
        return "otc_word_ad_search_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "word_ad_search_channel");
        this.f78611k = methodChannel;
        methodChannel.setMethodCallHandler(new u0(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Hi(getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Hi(intent);
        this.f78611k.invokeMethod("reInitWordAd", (Object) null);
    }

    public void onResume() {
        super.onResume();
        if (this.f78614n) {
            this.f78614n = false;
            OtcModuleConfig.a().e("");
        }
    }
}
