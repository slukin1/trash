package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.controller.DepositWithdrawController;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import com.huobi.view.BottomAlterCostDialogFragment;
import d7.k;
import gs.g;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import qiu.niorgai.StatusBarCompat;
import yl.x;

public class AssetSpotCurrencyDetailActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f46272k;

    /* renamed from: l  reason: collision with root package name */
    public String f46273l;

    /* renamed from: m  reason: collision with root package name */
    public TradeType f46274m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f46275n;

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            AssetSpotCurrencyDetailActivity.this.Zi(methodCall, result);
        }
    }

    public class b implements BottomAlterCostDialogFragment.DialogCloseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f46277a;

        public b(MethodChannel.Result result) {
            this.f46277a = result;
        }

        public void onDialogClose(String str) {
            this.f46277a.success(str);
        }
    }

    public static /* synthetic */ Boolean Ri(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Si(Boolean bool) {
        Ni();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ti(APIStatusErrorException aPIStatusErrorException) {
        Ni();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ui(Throwable th2) {
        Ni();
    }

    public static /* synthetic */ Boolean Vi(Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wi(Boolean bool) {
        Pi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xi(APIStatusErrorException aPIStatusErrorException) {
        Pi();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yi(Throwable th2) {
        Pi();
    }

    public static void bj(Context context, String str, TradeType tradeType) {
        Intent intent = new Intent(context, AssetSpotCurrencyDetailActivity.class);
        intent.putExtra(FirebaseAnalytics.Param.CURRENCY, str);
        intent.putExtra("tradeType", tradeType);
        context.startActivity(intent);
    }

    public final void Li() {
        if (Qi()) {
            new OtcFaitDWJumpHelper(this, this, this.f46273l).t(OtcFaitDWJumpHelper.f78855g, this.f46273l);
        } else {
            DepositWithdrawController.l(this, this.f46273l).compose(RxJavaHelper.t(this)).filter(g1.f47129b).subscribe(EasySubscriber.create(new d1(this), new a1(this), new e1(this)));
        }
    }

    public final void Mi() {
        if (Qi()) {
            new OtcFaitDWJumpHelper(this, this, this.f46273l).t(OtcFaitDWJumpHelper.f78856h, this.f46273l);
        } else {
            DepositWithdrawController.m(this, this.f46273l).compose(RxJavaHelper.t(this)).filter(h1.f47147b).subscribe(EasySubscriber.create(new c1(this), new b1(this), new f1(this)));
        }
    }

    public String Nh() {
        return "spot_detail";
    }

    public final void Ni() {
        UnifyDepositActivity.wh(this, this.f46273l);
    }

    public final void Oi(boolean z11) {
        QuickEmptyActivity.fg(this, this.f46273l, z11);
    }

    public final void Pi() {
        UnifyWithdrawActivity.Di(this, this.f46273l, this.f46274m);
    }

    public final boolean Qi() {
        CurrencyBean s11 = k.C().s(this.f46273l);
        return s11 != null && s11.isFiatTag();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r8.notImplemented();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Zi(io.flutter.plugin.common.MethodCall r7, io.flutter.plugin.common.MethodChannel.Result r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.method     // Catch:{ Exception -> 0x01a0 }
            r1 = -1
            int r2 = r0.hashCode()     // Catch:{ Exception -> 0x01a0 }
            r3 = 0
            r4 = 1
            switch(r2) {
                case -1584811405: goto L_0x005e;
                case -449332819: goto L_0x0054;
                case 158017419: goto L_0x004a;
                case 182384131: goto L_0x0040;
                case 1154647963: goto L_0x0036;
                case 1313268003: goto L_0x002c;
                case 1359431541: goto L_0x0022;
                case 1771792014: goto L_0x0017;
                case 2112213047: goto L_0x000d;
                default: goto L_0x000c;
            }     // Catch:{ Exception -> 0x01a0 }
        L_0x000c:
            goto L_0x0067
        L_0x000d:
            java.lang.String r2 = "goToEarnAandTradingBot"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = 6
            goto L_0x0067
        L_0x0017:
            java.lang.String r2 = "goToTransfer"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = 8
            goto L_0x0067
        L_0x0022:
            java.lang.String r2 = "goToSell"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = 2
            goto L_0x0067
        L_0x002c:
            java.lang.String r2 = "initSpotDetail"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = r3
            goto L_0x0067
        L_0x0036:
            java.lang.String r2 = "goToDeposit"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = 3
            goto L_0x0067
        L_0x0040:
            java.lang.String r2 = "goToBuy"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = r4
            goto L_0x0067
        L_0x004a:
            java.lang.String r2 = "fixPositionPrice"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = 7
            goto L_0x0067
        L_0x0054:
            java.lang.String r2 = "goToWithdraw"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = 4
            goto L_0x0067
        L_0x005e:
            java.lang.String r2 = "goToLbIntroduceWebView"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0067
            r1 = 5
        L_0x0067:
            java.lang.String r0 = "currency"
            java.lang.String r2 = ""
            r5 = 0
            switch(r1) {
                case 0: goto L_0x0144;
                case 1: goto L_0x0138;
                case 2: goto L_0x012c;
                case 3: goto L_0x010d;
                case 4: goto L_0x00e7;
                case 5: goto L_0x00dd;
                case 6: goto L_0x00a9;
                case 7: goto L_0x0080;
                case 8: goto L_0x0074;
                default: goto L_0x006f;
            }
        L_0x006f:
            r8.notImplemented()     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x0074:
            java.lang.String r7 = r6.f46273l     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = "2"
            com.huobi.finance.ui.UnifyTransferActivity.Th(r6, r7, r0)     // Catch:{ Exception -> 0x01a0 }
            r8.success(r5)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x0080:
            com.huobi.view.BottomAlterCostDialogFragment r7 = new com.huobi.view.BottomAlterCostDialogFragment     // Catch:{ Exception -> 0x01a0 }
            r7.<init>()     // Catch:{ Exception -> 0x01a0 }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ Exception -> 0x01a0 }
            r1.<init>()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r2 = r6.f46273l     // Catch:{ Exception -> 0x01a0 }
            r1.putString(r0, r2)     // Catch:{ Exception -> 0x01a0 }
            r7.setArguments(r1)     // Catch:{ Exception -> 0x01a0 }
            com.huobi.finance.ui.AssetSpotCurrencyDetailActivity$b r0 = new com.huobi.finance.ui.AssetSpotCurrencyDetailActivity$b     // Catch:{ Exception -> 0x01a0 }
            r0.<init>(r8)     // Catch:{ Exception -> 0x01a0 }
            r7.setOnDialogCloseCallback(r0)     // Catch:{ Exception -> 0x01a0 }
            androidx.fragment.app.FragmentManager r0 = r6.getSupportFragmentManager()     // Catch:{ Exception -> 0x01a0 }
            java.lang.Class<com.huobi.view.BottomAlterCostDialogFragment> r1 = com.huobi.view.BottomAlterCostDialogFragment.class
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x01a0 }
            r7.show(r0, r1)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x00a9:
            java.lang.String r0 = "url"
            java.lang.Object r7 = r7.argument(r0)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00d8 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00d8 }
            if (r0 == 0) goto L_0x00d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
            r0.<init>()     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r1 = "EARN_AND_TRADING_METHOD URL is Null   url= :"
            r0.append(r1)     // Catch:{ Exception -> 0x00d8 }
            r0.append(r7)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x00d8 }
            i6.k.n(r7)     // Catch:{ Exception -> 0x00d8 }
            r8.notImplemented()     // Catch:{ Exception -> 0x00d8 }
            goto L_0x01a7
        L_0x00d0:
            com.hbg.lib.core.webview.HBBaseWebActivity.showWebView(r6, r7, r2, r2, r4)     // Catch:{ Exception -> 0x00d8 }
            r8.success(r5)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x01a7
        L_0x00d8:
            r8.notImplemented()     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x00dd:
            java.lang.String r7 = r6.f46273l     // Catch:{ Exception -> 0x01a0 }
            com.huobi.view.CurrencyIntroWebActivity.start(r6, r7)     // Catch:{ Exception -> 0x01a0 }
            r8.success(r5)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x00e7:
            r6.Mi()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r7 = "withdraw"
            r6.aj(r7)     // Catch:{ Exception -> 0x01a0 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x01a0 }
            r7.<init>()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = "currency_name"
            d7.k r1 = d7.k.C()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r2 = r6.f46273l     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r1 = r1.z(r2)     // Catch:{ Exception -> 0x01a0 }
            r7.put(r0, r1)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = "app_assets_Exchange_details_withdraw_click"
            gs.g.i(r0, r7)     // Catch:{ Exception -> 0x01a0 }
            r8.success(r5)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x010d:
            boolean r7 = r6.f46275n     // Catch:{ Exception -> 0x01a0 }
            if (r7 == 0) goto L_0x011f
            d7.a1 r7 = d7.a1.v()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = r6.f46273l     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r7 = r7.t(r0)     // Catch:{ Exception -> 0x01a0 }
            com.huobi.utils.k0.O(r6, r7, r3)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x0127
        L_0x011f:
            r6.Li()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r7 = "recharge"
            r6.aj(r7)     // Catch:{ Exception -> 0x01a0 }
        L_0x0127:
            r8.success(r5)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x012c:
            r6.Oi(r3)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r7 = "sale"
            r6.aj(r7)     // Catch:{ Exception -> 0x01a0 }
            r8.success(r5)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x0138:
            r6.Oi(r4)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r7 = "buy"
            r6.aj(r7)     // Catch:{ Exception -> 0x01a0 }
            r8.success(r5)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x0144:
            dt.h2 r7 = dt.h2.t1()     // Catch:{ Exception -> 0x01a0 }
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ Exception -> 0x01a0 }
            com.huobi.account.entity.AccountType r3 = com.huobi.account.entity.AccountType.spot     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01a0 }
            rx.Observable r7 = r7.b1(r1, r3)     // Catch:{ Exception -> 0x01a0 }
            rx.observables.BlockingObservable r7 = r7.toBlocking()     // Catch:{ Exception -> 0x01a0 }
            java.lang.Object r7 = r7.firstOrDefault(r5)     // Catch:{ Exception -> 0x01a0 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r1 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.y()     // Catch:{ Exception -> 0x01a0 }
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r1 = r1.toUpperCase(r3)     // Catch:{ Exception -> 0x01a0 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x01a0 }
            r3.<init>()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r4 = r6.f46273l     // Catch:{ Exception -> 0x01a0 }
            r3.put(r0, r4)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = "isClearUser"
            yl.x r4 = yl.x.n()     // Catch:{ Exception -> 0x01a0 }
            boolean r4 = r4.r()     // Catch:{ Exception -> 0x01a0 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x01a0 }
            r3.put(r0, r4)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = "proAccountId"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a0 }
            r4.<init>()     // Catch:{ Exception -> 0x01a0 }
            r4.append(r7)     // Catch:{ Exception -> 0x01a0 }
            r4.append(r2)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x01a0 }
            r3.put(r0, r7)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r7 = "character"
            r3.put(r7, r1)     // Catch:{ Exception -> 0x01a0 }
            r8.success(r3)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x01a7
        L_0x01a0:
            r7 = move-exception
            r7.printStackTrace()
            r8.notImplemented()
        L_0x01a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.AssetSpotCurrencyDetailActivity.Zi(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void aj(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_spot_currency_detail_button", str);
        g.i("app_spot_currency_bottom_button_exposure", hashMap);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "spot_detail_channel");
        this.f46272k = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z11 = true;
        StatusBarCompat.d(this, true);
        if (NightHelper.e().g()) {
            StatusBarCompat.a(this);
        } else {
            StatusBarCompat.b(this);
        }
        Intent intent = getIntent();
        this.f46273l = intent.getStringExtra(FirebaseAnalytics.Param.CURRENCY);
        this.f46274m = (TradeType) intent.getSerializableExtra("tradeType");
        this.f46275n = x.n().q();
        if (!x.n().m(this.f46273l) || !this.f46275n) {
            z11 = false;
        }
        this.f46275n = z11;
    }
}
