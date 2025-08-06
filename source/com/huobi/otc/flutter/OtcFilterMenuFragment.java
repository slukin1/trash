package com.huobi.otc.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.o;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import com.huobi.otc.ui.OtcFAQActivity;
import com.huobi.otc.ui.OtcSeaViewRoomActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import i6.d;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import jp.k0;
import jp.l;
import u6.g;

public class OtcFilterMenuFragment extends AbsGlobalFlutterFragment {

    /* renamed from: t  reason: collision with root package name */
    public static final String f78470t = OtcFilterMenuFragment.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    public MethodChannel f78471i;

    /* renamed from: j  reason: collision with root package name */
    public AdvertFilterType f78472j;

    /* renamed from: k  reason: collision with root package name */
    public int f78473k;

    /* renamed from: l  reason: collision with root package name */
    public int f78474l;

    /* renamed from: m  reason: collision with root package name */
    public int f78475m;

    /* renamed from: n  reason: collision with root package name */
    public String f78476n;

    /* renamed from: o  reason: collision with root package name */
    public String f78477o;

    /* renamed from: p  reason: collision with root package name */
    public int f78478p;

    /* renamed from: q  reason: collision with root package name */
    public Context f78479q;

    /* renamed from: r  reason: collision with root package name */
    public int f78480r;

    /* renamed from: s  reason: collision with root package name */
    public o f78481s = new b(true);

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            OtcFilterMenuFragment.this.Zh(methodCall, result);
        }
    }

    public class b extends o {
        public b(boolean z11) {
            super(z11);
        }

        public void handleOnBackPressed() {
            d.c(OtcFilterMenuFragment.f78470t, " OnBackPressedDispatcher handleOnBackPressed");
            OtcFilterMenuFragment.this.Xh();
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f78484a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.otc.flutter.AdvertFilterType[] r0 = com.huobi.otc.flutter.AdvertFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f78484a = r0
                com.huobi.otc.flutter.AdvertFilterType r1 = com.huobi.otc.flutter.AdvertFilterType.MERCHANT_AND_PAYMETHOD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f78484a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.otc.flutter.AdvertFilterType r1 = com.huobi.otc.flutter.AdvertFilterType.TRADING_PAIR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f78484a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.otc.flutter.AdvertFilterType r1 = com.huobi.otc.flutter.AdvertFilterType.CRYPTO_COINS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f78484a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.otc.flutter.AdvertFilterType r1 = com.huobi.otc.flutter.AdvertFilterType.EXTENSION_FUNCS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f78484a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.otc.flutter.AdvertFilterType r1 = com.huobi.otc.flutter.AdvertFilterType.PAY_METHODS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f78484a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.otc.flutter.AdvertFilterType r1 = com.huobi.otc.flutter.AdvertFilterType.AMOUNT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f78484a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.otc.flutter.AdvertFilterType r1 = com.huobi.otc.flutter.AdvertFilterType.SITE_BRAND_FILTER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f78484a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huobi.otc.flutter.AdvertFilterType r1 = com.huobi.otc.flutter.AdvertFilterType.LEGAL_TENDER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.flutter.OtcFilterMenuFragment.c.<clinit>():void");
        }
    }

    public static OtcFilterMenuFragment Vh(int i11, int i12, int i13, String str, int i14, int i15) {
        OtcFilterMenuFragment otcFilterMenuFragment = new OtcFilterMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, RenderMode.texture.name());
        bundle.putInt("param_type_menu", i11);
        bundle.putInt("param_site_type", i15);
        bundle.putInt("param_trade_type", i12);
        bundle.putInt("param_trade_model", i13);
        bundle.putString("param_coin_id", str);
        bundle.putInt("param_from_list_type", i14);
        otcFilterMenuFragment.setArguments(bundle);
        return otcFilterMenuFragment;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yh(UserVO userVO) {
        if (userVO == null || userVO.isVerifyWayHaveSet()) {
            OtcModuleConfig.b().V((Activity) this.f78479q);
        } else {
            OtcModuleConfig.b().H(this.f78479q);
        }
    }

    public String Bh() {
        return "c2c_filter_view";
    }

    public final void Wh(String str) {
        String str2;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1990282098:
                if (str.equals("trade_model")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1617379345:
                if (str.equals("otc_helper")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1612654376:
                if (str.equals("my_orders")) {
                    c11 = 2;
                    break;
                }
                break;
            case -796371916:
                if (str.equals("share_advert")) {
                    c11 = 3;
                    break;
                }
                break;
            case -477220857:
                if (str.equals("my_attensions")) {
                    c11 = 4;
                    break;
                }
                break;
            case -438015953:
                if (str.equals("otc_price_tips")) {
                    c11 = 5;
                    break;
                }
                break;
            case -95251181:
                if (str.equals("novice_guide")) {
                    c11 = 6;
                    break;
                }
                break;
            case 258514686:
                if (str.equals("advert_model")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1445122646:
                if (str.equals("receive_methods")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1583303838:
                if (str.equals("trade_settings")) {
                    c11 = 9;
                    break;
                }
                break;
            case 1647691986:
                if (str.equals("card_management")) {
                    c11 = 10;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 7:
                ((OtcTradeActivity) this.f78479q).zh();
                return;
            case 1:
                if (!OtcModuleConfig.a().a()) {
                    OtcModuleConfig.a().l((Activity) this.f78479q, (Intent) null, (Intent) null);
                    return;
                } else {
                    OtcFAQActivity.zh((Activity) this.f78479q);
                    return;
                }
            case 2:
                Intent intent = new Intent(this.f78479q, OtcModuleConfig.b().I());
                if (OtcModuleConfig.a().a()) {
                    if (((OtcTradeActivity) this.f78479q).Ed() == OtcTradeAreaEnum.DEPOSIT_AREA) {
                        intent.putExtra("extra_select_deposit", true);
                    }
                    OtcModuleConfig.b().U(this.f78479q, intent);
                    return;
                }
                OtcModuleConfig.a().l((Activity) this.f78479q, (Intent) null, (Intent) null);
                return;
            case 3:
                OtcModuleConfig.b().M(this.f78479q, (String) null, (String) null);
                return;
            case 4:
                if (!OtcModuleConfig.a().a()) {
                    OtcModuleConfig.a().l((Activity) this.f78479q, (Intent) null, (Intent) null);
                    return;
                } else {
                    OtcModuleConfig.b().m((Activity) this.f78479q);
                    return;
                }
            case 5:
                OtcModuleConfig.b().n(this.f78479q);
                return;
            case 6:
                OtcTradeAreaEnum Ed = ((OtcTradeActivity) this.f78479q).Ed();
                if (Ed == OtcTradeAreaEnum.FAST_AREA) {
                    str2 = "1";
                } else if (Ed == OtcTradeAreaEnum.FREE_AREA) {
                    str2 = "2";
                } else {
                    str2 = Ed == OtcTradeAreaEnum.DEPOSIT_AREA ? "3" : "";
                }
                OtcModuleConfig.b().C(this.f78479q, str2);
                uf.c.b().l("click_guide_menu", (HashMap) null);
                return;
            case 8:
                k0 d11 = k0.d();
                Context context = this.f78479q;
                d11.g((Activity) context, (OtcTradeActivity) context);
                return;
            case 9:
                if (!OtcModuleConfig.a().a()) {
                    OtcModuleConfig.a().l((Activity) this.f78479q, (Intent) null, (Intent) null);
                    return;
                } else {
                    l.q(false).compose(RxJavaHelper.t((g) null)).subscribe(q6.d.c((OtcTradeActivity) this.f78479q, new t(this)));
                    return;
                }
            case 10:
                if (!OtcModuleConfig.a().a()) {
                    OtcModuleConfig.a().l((Activity) this.f78479q, (Intent) null, (Intent) null);
                    return;
                } else {
                    ((OtcTradeActivity) this.f78479q).Qh();
                    return;
                }
            default:
                return;
        }
    }

    public final void Xh() {
        Context context = this.f78479q;
        if (context instanceof OtcTradeActivity) {
            ((OtcTradeActivity) context).Xh();
        } else if (context instanceof OtcSeaViewRoomActivity) {
            ((OtcSeaViewRoomActivity) context).Og();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:38|39|40|(2:42|(2:44|(2:47|45))(1:48))|49|50|(2:52|115)(2:53|116)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00e2 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0297 A[Catch:{ Exception -> 0x029b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[Catch:{ Exception -> 0x029b }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00eb A[Catch:{ Exception -> 0x029b }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f2 A[Catch:{ Exception -> 0x029b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Zh(io.flutter.plugin.common.MethodCall r17, io.flutter.plugin.common.MethodChannel.Result r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.lang.String r3 = ","
            r4 = 0
            java.lang.String r5 = r0.method     // Catch:{ Exception -> 0x029b }
            int r6 = r5.hashCode()     // Catch:{ Exception -> 0x029b }
            r7 = 290034107(0x114991bb, float:1.5901011E-28)
            r9 = 2
            r10 = 0
            r11 = 1
            if (r6 == r7) goto L_0x0036
            r7 = 930629526(0x37784796, float:1.4798619E-5)
            if (r6 == r7) goto L_0x002c
            r7 = 1671672458(0x63a3b28a, float:6.039369E21)
            if (r6 == r7) goto L_0x0022
            goto L_0x0040
        L_0x0022:
            java.lang.String r6 = "dismiss"
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x029b }
            if (r5 == 0) goto L_0x0040
            r5 = r9
            goto L_0x0041
        L_0x002c:
            java.lang.String r6 = "retrieveAdvertFilterInfo"
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x029b }
            if (r5 == 0) goto L_0x0040
            r5 = r10
            goto L_0x0041
        L_0x0036:
            java.lang.String r6 = "updateAdvertFilterParams"
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x029b }
            if (r5 == 0) goto L_0x0040
            r5 = r11
            goto L_0x0041
        L_0x0040:
            r5 = -1
        L_0x0041:
            if (r5 == 0) goto L_0x0297
            if (r5 == r11) goto L_0x0054
            if (r5 == r9) goto L_0x004c
            r18.notImplemented()     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x004c:
            r16.Xh()     // Catch:{ Exception -> 0x029b }
            r2.success(r4)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x0054:
            java.lang.Object r0 = r0.arguments     // Catch:{ Exception -> 0x029b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x029b }
            com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ Exception -> 0x029b }
            r5.<init>()     // Catch:{ Exception -> 0x029b }
            java.lang.Class<java.util.HashMap> r6 = java.util.HashMap.class
            java.lang.Object r0 = r5.fromJson((java.lang.String) r0, r6)     // Catch:{ Exception -> 0x029b }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.flutter.AdvertFilterType r5 = r1.f78472j     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.flutter.AdvertFilterType r6 = com.huobi.otc.flutter.AdvertFilterType.EXTENSION_FUNCS     // Catch:{ Exception -> 0x029b }
            if (r5 != r6) goto L_0x007a
            java.lang.String r3 = "action"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x029b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x029b }
            r1.Wh(r0)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x007a:
            com.huobi.otc.flutter.AdvertFilterType r6 = com.huobi.otc.flutter.AdvertFilterType.TRADING_PAIR     // Catch:{ Exception -> 0x029b }
            if (r5 != r6) goto L_0x0087
            android.content.Context r3 = r1.f78479q     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.ui.OtcTradeActivity r3 = (com.huobi.otc.ui.OtcTradeActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.ki(r11, r0)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x0087:
            com.huobi.otc.flutter.AdvertFilterType r6 = com.huobi.otc.flutter.AdvertFilterType.LEGAL_TENDER     // Catch:{ Exception -> 0x029b }
            if (r5 != r6) goto L_0x0096
            android.content.Context r3 = r1.f78479q     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.ui.OtcTradeActivity r3 = (com.huobi.otc.ui.OtcTradeActivity) r3     // Catch:{ Exception -> 0x029b }
            int r5 = r1.f78474l     // Catch:{ Exception -> 0x029b }
            r3.li(r5, r11, r0)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x0096:
            com.huobi.otc.flutter.AdvertFilterType r6 = com.huobi.otc.flutter.AdvertFilterType.CRYPTO_COINS     // Catch:{ Exception -> 0x029b }
            if (r5 != r6) goto L_0x00a3
            android.content.Context r3 = r1.f78479q     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.ui.OtcTradeActivity r3 = (com.huobi.otc.ui.OtcTradeActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.ki(r10, r0)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x00a3:
            com.huobi.otc.flutter.AdvertFilterType r6 = com.huobi.otc.flutter.AdvertFilterType.PAY_METHODS     // Catch:{ Exception -> 0x029b }
            if (r5 != r6) goto L_0x00f9
            int r5 = r1.f78480r     // Catch:{ Exception -> 0x029b }
            op.a r5 = op.a.r(r5)     // Catch:{ Exception -> 0x029b }
            java.lang.String r6 = "payMethod"
            java.lang.Object r6 = r0.get(r6)     // Catch:{ Exception -> 0x029b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x029b }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x029b }
            r7.<init>()     // Catch:{ Exception -> 0x029b }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00e2 }
            if (r8 != 0) goto L_0x00e2
            boolean r8 = r6.contains(r3)     // Catch:{ Exception -> 0x00e2 }
            if (r8 == 0) goto L_0x00db
            java.lang.String[] r3 = r6.split(r3)     // Catch:{ Exception -> 0x00e2 }
        L_0x00cc:
            int r8 = r3.length     // Catch:{ Exception -> 0x00e2 }
            if (r10 >= r8) goto L_0x00e2
            r8 = r3[r10]     // Catch:{ Exception -> 0x00e2 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00e2 }
            r7.add(r8)     // Catch:{ Exception -> 0x00e2 }
            int r10 = r10 + 1
            goto L_0x00cc
        L_0x00db:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00e2 }
            r7.add(r3)     // Catch:{ Exception -> 0x00e2 }
        L_0x00e2:
            r5.M(r6)     // Catch:{ Exception -> 0x029b }
            android.content.Context r3 = r1.f78479q     // Catch:{ Exception -> 0x029b }
            boolean r5 = r3 instanceof com.huobi.otc.ui.OtcTradeActivity     // Catch:{ Exception -> 0x029b }
            if (r5 == 0) goto L_0x00f2
            com.huobi.otc.ui.OtcTradeActivity r3 = (com.huobi.otc.ui.OtcTradeActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.Ch(r0)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x00f2:
            com.huobi.otc.ui.OtcSeaViewRoomActivity r3 = (com.huobi.otc.ui.OtcSeaViewRoomActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.Zf(r7)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x00f9:
            com.huobi.otc.flutter.AdvertFilterType r3 = com.huobi.otc.flutter.AdvertFilterType.AMOUNT     // Catch:{ Exception -> 0x029b }
            if (r5 != r3) goto L_0x0124
            int r3 = r1.f78480r     // Catch:{ Exception -> 0x029b }
            op.a r3 = op.a.r(r3)     // Catch:{ Exception -> 0x029b }
            java.lang.String r5 = "amount"
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x029b }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x029b }
            r3.C(r5)     // Catch:{ Exception -> 0x029b }
            android.content.Context r3 = r1.f78479q     // Catch:{ Exception -> 0x029b }
            boolean r6 = r3 instanceof com.huobi.otc.ui.OtcTradeActivity     // Catch:{ Exception -> 0x029b }
            if (r6 == 0) goto L_0x011d
            com.huobi.otc.ui.OtcTradeActivity r3 = (com.huobi.otc.ui.OtcTradeActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.Ch(r0)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x011d:
            com.huobi.otc.ui.OtcSeaViewRoomActivity r3 = (com.huobi.otc.ui.OtcSeaViewRoomActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.Xf(r5)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x0124:
            com.huobi.otc.flutter.AdvertFilterType r3 = com.huobi.otc.flutter.AdvertFilterType.SITE_BRAND_FILTER     // Catch:{ Exception -> 0x029b }
            java.lang.String r6 = "labelId"
            if (r5 != r3) goto L_0x0155
            java.lang.String r3 = "brandLabelIds"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ Exception -> 0x029b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x029b }
            int r5 = r1.f78480r     // Catch:{ Exception -> 0x029b }
            op.a r5 = op.a.r(r5)     // Catch:{ Exception -> 0x029b }
            r5.E(r3)     // Catch:{ Exception -> 0x029b }
            java.lang.Object r3 = r0.get(r6)     // Catch:{ Exception -> 0x029b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x029b }
            r5.H(r3)     // Catch:{ Exception -> 0x029b }
            android.content.Context r3 = r1.f78479q     // Catch:{ Exception -> 0x029b }
            boolean r5 = r3 instanceof com.huobi.otc.ui.OtcTradeActivity     // Catch:{ Exception -> 0x029b }
            if (r5 == 0) goto L_0x02a3
            com.huobi.otc.ui.OtcTradeActivity r3 = (com.huobi.otc.ui.OtcTradeActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.Ch(r0)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x0155:
            int r3 = r1.f78480r     // Catch:{ Exception -> 0x029b }
            op.a r3 = op.a.r(r3)     // Catch:{ Exception -> 0x029b }
            java.lang.String r5 = "makerCompleteRate"
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x029b }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x029b }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x029b }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ Exception -> 0x029b }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x029b }
            java.lang.String r7 = "isThumbsUp"
            java.lang.Object r7 = r0.get(r7)     // Catch:{ Exception -> 0x029b }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Exception -> 0x029b }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x029b }
            java.lang.String r12 = "isMerchant"
            java.lang.Object r12 = r0.get(r12)     // Catch:{ Exception -> 0x029b }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ Exception -> 0x029b }
            boolean r12 = r12.booleanValue()     // Catch:{ Exception -> 0x029b }
            java.lang.String r13 = "isTraded"
            java.lang.Object r13 = r0.get(r13)     // Catch:{ Exception -> 0x029b }
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ Exception -> 0x029b }
            boolean r13 = r13.booleanValue()     // Catch:{ Exception -> 0x029b }
            java.lang.String r14 = "isFollowed"
            java.lang.Object r14 = r0.get(r14)     // Catch:{ Exception -> 0x029b }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ Exception -> 0x029b }
            boolean r14 = r14.booleanValue()     // Catch:{ Exception -> 0x029b }
            java.lang.String r15 = "merchantTags"
            java.lang.Object r15 = r0.get(r15)     // Catch:{ Exception -> 0x029b }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x029b }
            java.lang.String r10 = "blockType"
            java.lang.Object r10 = r0.get(r10)     // Catch:{ Exception -> 0x029b }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x029b }
            r4 = 4
            r8 = 3
            if (r7 == 0) goto L_0x01ca
            ip.a r7 = new ip.a     // Catch:{ Exception -> 0x029b }
            r12 = 2132023534(0x7f1418ee, float:1.9685519E38)
            java.lang.String r12 = r1.getString(r12)     // Catch:{ Exception -> 0x029b }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.enums.OtcAdsFilterType r14 = com.huobi.otc.enums.OtcAdsFilterType.MERCHANT_LEVEL_FILTER     // Catch:{ Exception -> 0x029b }
            r7.<init>(r12, r13, r14, r11)     // Catch:{ Exception -> 0x029b }
            goto L_0x021c
        L_0x01ca:
            if (r12 == 0) goto L_0x01df
            ip.a r7 = new ip.a     // Catch:{ Exception -> 0x029b }
            r12 = 2132023500(0x7f1418cc, float:1.968545E38)
            java.lang.String r12 = r1.getString(r12)     // Catch:{ Exception -> 0x029b }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.enums.OtcAdsFilterType r14 = com.huobi.otc.enums.OtcAdsFilterType.MERCHANT_LEVEL_FILTER     // Catch:{ Exception -> 0x029b }
            r7.<init>(r12, r13, r14, r11)     // Catch:{ Exception -> 0x029b }
            goto L_0x021c
        L_0x01df:
            if (r13 == 0) goto L_0x01f4
            ip.a r7 = new ip.a     // Catch:{ Exception -> 0x029b }
            r12 = 2132023536(0x7f1418f0, float:1.9685523E38)
            java.lang.String r12 = r1.getString(r12)     // Catch:{ Exception -> 0x029b }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.enums.OtcAdsFilterType r14 = com.huobi.otc.enums.OtcAdsFilterType.MERCHANT_LEVEL_FILTER     // Catch:{ Exception -> 0x029b }
            r7.<init>(r12, r13, r14, r11)     // Catch:{ Exception -> 0x029b }
            goto L_0x021c
        L_0x01f4:
            if (r14 == 0) goto L_0x0209
            ip.a r7 = new ip.a     // Catch:{ Exception -> 0x029b }
            r12 = 2132024808(0x7f141de8, float:1.9688103E38)
            java.lang.String r12 = r1.getString(r12)     // Catch:{ Exception -> 0x029b }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.enums.OtcAdsFilterType r14 = com.huobi.otc.enums.OtcAdsFilterType.MERCHANT_LEVEL_FILTER     // Catch:{ Exception -> 0x029b }
            r7.<init>(r12, r13, r14, r11)     // Catch:{ Exception -> 0x029b }
            goto L_0x021c
        L_0x0209:
            ip.a r7 = new ip.a     // Catch:{ Exception -> 0x029b }
            r12 = 2132024805(0x7f141de5, float:1.9688096E38)
            java.lang.String r12 = r1.getString(r12)     // Catch:{ Exception -> 0x029b }
            r13 = -1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x029b }
            com.huobi.otc.enums.OtcAdsFilterType r14 = com.huobi.otc.enums.OtcAdsFilterType.MERCHANT_LEVEL_FILTER     // Catch:{ Exception -> 0x029b }
            r7.<init>(r12, r13, r14, r11)     // Catch:{ Exception -> 0x029b }
        L_0x021c:
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x029b }
            r12 = r12 ^ r11
            boolean r13 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x029b }
            if (r13 == 0) goto L_0x022b
            com.hbg.lib.network.otc.core.bean.Merchant r10 = com.hbg.lib.network.otc.core.bean.Merchant.NORMAL     // Catch:{ Exception -> 0x029b }
            java.lang.String r10 = r10.value     // Catch:{ Exception -> 0x029b }
        L_0x022b:
            r3.I(r5)     // Catch:{ Exception -> 0x029b }
            r3.H(r6)     // Catch:{ Exception -> 0x029b }
            java.lang.Object r5 = r7.c()     // Catch:{ Exception -> 0x029b }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x029b }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x029b }
            if (r5 != r11) goto L_0x023f
            r5 = r11
            goto L_0x0240
        L_0x023f:
            r5 = 0
        L_0x0240:
            r3.N(r5)     // Catch:{ Exception -> 0x029b }
            java.lang.Object r5 = r7.c()     // Catch:{ Exception -> 0x029b }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x029b }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x029b }
            if (r5 != r9) goto L_0x0251
            r5 = r11
            goto L_0x0252
        L_0x0251:
            r5 = 0
        L_0x0252:
            r3.K(r5)     // Catch:{ Exception -> 0x029b }
            java.lang.Object r5 = r7.c()     // Catch:{ Exception -> 0x029b }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x029b }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x029b }
            if (r5 != r8) goto L_0x0263
            r5 = r11
            goto L_0x0264
        L_0x0263:
            r5 = 0
        L_0x0264:
            r3.O(r5)     // Catch:{ Exception -> 0x029b }
            java.lang.Object r5 = r7.c()     // Catch:{ Exception -> 0x029b }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x029b }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x029b }
            if (r5 != r4) goto L_0x0274
            goto L_0x0275
        L_0x0274:
            r11 = 0
        L_0x0275:
            r3.G(r11)     // Catch:{ Exception -> 0x029b }
            if (r12 == 0) goto L_0x027d
            java.lang.String r4 = "1"
            goto L_0x027f
        L_0x027d:
            java.lang.String r4 = ""
        L_0x027f:
            r3.D(r4)     // Catch:{ Exception -> 0x029b }
            r3.J(r10)     // Catch:{ Exception -> 0x029b }
            android.content.Context r3 = r1.f78479q     // Catch:{ Exception -> 0x029b }
            boolean r4 = r3 instanceof com.huobi.otc.ui.OtcTradeActivity     // Catch:{ Exception -> 0x029b }
            if (r4 == 0) goto L_0x0291
            com.huobi.otc.ui.OtcTradeActivity r3 = (com.huobi.otc.ui.OtcTradeActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.Ch(r0)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x0291:
            com.huobi.otc.ui.OtcSeaViewRoomActivity r3 = (com.huobi.otc.ui.OtcSeaViewRoomActivity) r3     // Catch:{ Exception -> 0x029b }
            r3.Yf()     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x0297:
            r1.ai(r2)     // Catch:{ Exception -> 0x029b }
            goto L_0x02a3
        L_0x029b:
            r0 = move-exception
            r0.printStackTrace()
            r3 = 0
            r2.success(r3)
        L_0x02a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.flutter.OtcFilterMenuFragment.Zh(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: int} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ai(io.flutter.plugin.common.MethodChannel.Result r11) {
        /*
            r10 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = r10.f78476n
            java.lang.String r2 = "currencyName"
            r0.put(r2, r1)
            int r1 = r10.f78480r
            op.a r1 = op.a.r(r1)
            int[] r2 = com.huobi.otc.flutter.OtcFilterMenuFragment.c.f78484a
            com.huobi.otc.flutter.AdvertFilterType r3 = r10.f78472j
            int r3 = r3.ordinal()
            r2 = r2[r3]
            java.lang.String r3 = "advertLabels"
            r4 = 0
            java.lang.String r5 = "labelId"
            java.lang.String r6 = "payMethod"
            r7 = 1
            java.lang.String r8 = "siteType"
            java.lang.String r9 = "tradeType"
            switch(r2) {
                case 1: goto L_0x011f;
                case 2: goto L_0x0104;
                case 3: goto L_0x00e1;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00ae;
                case 6: goto L_0x0083;
                case 7: goto L_0x0041;
                case 8: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x01d0
        L_0x002d:
            int r1 = r10.f78474l
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.put(r8, r1)
            int r1 = r10.f78473k
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.put(r9, r1)
            goto L_0x01d0
        L_0x0041:
            java.lang.String r2 = r1.d()
            int r4 = r10.f78473k
            if (r4 != 0) goto L_0x005a
            java.util.HashMap r4 = r1.e()
            java.lang.String r6 = r10.f78477o
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Object r4 = r4.get(r6)
            java.util.List r4 = (java.util.List) r4
            goto L_0x006a
        L_0x005a:
            java.util.HashMap r4 = r1.p()
            java.lang.String r6 = r10.f78477o
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Object r4 = r4.get(r6)
            java.util.List r4 = (java.util.List) r4
        L_0x006a:
            if (r4 == 0) goto L_0x006d
            goto L_0x0072
        L_0x006d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x0072:
            r0.put(r3, r4)
            java.lang.String r3 = "brandLabelIds"
            r0.put(r3, r2)
            java.lang.String r1 = r1.g()
            r0.put(r5, r1)
            goto L_0x01d0
        L_0x0083:
            int r2 = r10.f78473k
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.put(r9, r2)
            java.lang.String r1 = r1.a()
            java.lang.String r2 = "amount"
            r0.put(r2, r1)
            java.lang.String r1 = r10.f78477o
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r1.intValue()
            java.lang.String r1 = va.b.g(r1)
            java.lang.String r1 = r1.toUpperCase()
            java.lang.String r2 = "coinName"
            r0.put(r2, r1)
            goto L_0x01d0
        L_0x00ae:
            java.lang.String r1 = r1.n()
            r0.put(r6, r1)
            goto L_0x01d0
        L_0x00b7:
            int r1 = r10.f78475m
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "advert_model"
            r0.put(r2, r1)
            android.content.Context r1 = r10.f78479q
            com.huobi.otc.ui.OtcTradeActivity r1 = (com.huobi.otc.ui.OtcTradeActivity) r1
            com.huobi.otc.enums.OtcTradeAreaEnum r1 = r1.Ed()
            com.huobi.otc.enums.OtcTradeAreaEnum r2 = com.huobi.otc.enums.OtcTradeAreaEnum.FAST_AREA
            if (r1 != r2) goto L_0x00cf
            goto L_0x00d6
        L_0x00cf:
            com.huobi.otc.enums.OtcTradeAreaEnum r2 = com.huobi.otc.enums.OtcTradeAreaEnum.DEPOSIT_AREA
            if (r1 != r2) goto L_0x00d5
            r4 = r7
            goto L_0x00d6
        L_0x00d5:
            r4 = 2
        L_0x00d6:
            java.lang.String r1 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "otc_navigator_type"
            r0.put(r2, r1)
            goto L_0x01d0
        L_0x00e1:
            jp.c1 r1 = jp.c1.h()
            com.huobi.otc.enums.TradeBusinessEnum r2 = com.huobi.otc.enums.TradeBusinessEnum.ALL
            java.lang.String r3 = r10.f78477o
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r3 = r3.intValue()
            java.lang.String r3 = va.b.g(r3)
            java.lang.String r3 = r3.toUpperCase()
            java.lang.String r1 = r1.g(r2, r3)
            java.lang.String r2 = "fullName"
            r0.put(r2, r1)
            goto L_0x01d0
        L_0x0104:
            java.lang.String r1 = r10.f78477o
            java.lang.String r2 = "coinId"
            r0.put(r2, r1)
            int r1 = r10.f78473k
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.put(r9, r1)
            int r1 = r10.f78474l
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.put(r8, r1)
            goto L_0x01d0
        L_0x011f:
            int r2 = r10.f78473k
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.put(r9, r2)
            java.lang.String r2 = r1.n()
            r0.put(r6, r2)
            boolean r2 = r1.w()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r6 = "isThumbsUp"
            r0.put(r6, r2)
            boolean r2 = r1.u()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r6 = "isMerchant"
            r0.put(r6, r2)
            boolean r2 = r1.x()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r6 = "isTraded"
            r0.put(r6, r2)
            boolean r2 = r1.t()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r6 = "isFollowed"
            r0.put(r6, r2)
            java.lang.String r2 = r1.c()
            java.lang.String r6 = "merchantTags"
            r0.put(r6, r2)
            int r2 = r1.i()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r6 = "makerCompleteRate"
            r0.put(r6, r2)
            java.lang.String r2 = r1.g()
            r0.put(r5, r2)
            java.lang.String r2 = r1.j()
            java.lang.String r5 = "blockType"
            r0.put(r5, r2)
            int r2 = r10.f78473k
            if (r2 != 0) goto L_0x019e
            java.util.HashMap r1 = r1.e()
            java.lang.String r2 = r10.f78477o
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Object r1 = r1.get(r2)
            java.util.List r1 = (java.util.List) r1
            goto L_0x01ae
        L_0x019e:
            java.util.HashMap r1 = r1.p()
            java.lang.String r2 = r10.f78477o
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.Object r1 = r1.get(r2)
            java.util.List r1 = (java.util.List) r1
        L_0x01ae:
            if (r1 == 0) goto L_0x01b1
            goto L_0x01b6
        L_0x01b1:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x01b6:
            r0.put(r3, r1)
            int r1 = r10.f78480r
            if (r1 != r7) goto L_0x01be
            r4 = r7
        L_0x01be:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
            java.lang.String r2 = "isSeaRoom"
            r0.put(r2, r1)
            int r1 = r10.f78474l
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.put(r8, r1)
        L_0x01d0:
            com.google.gson.Gson r1 = com.huobi.utils.GsonHelper.a()
            java.lang.String r0 = r1.toJson((java.lang.Object) r0)
            r11.success(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.flutter.OtcFilterMenuFragment.ai(io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public final void bi(AdvertFilterType advertFilterType) {
        this.f78472j = advertFilterType;
        HashMap hashMap = new HashMap();
        hashMap.put("actionType", Integer.valueOf(advertFilterType.ordinal()));
        this.f78471i.invokeMethod("showFilterContent", hashMap);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "c2c_filter_channel");
        this.f78471i = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f78479q = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f78478p = arguments.getInt("param_type_menu", 0);
            this.f78473k = arguments.getInt("param_trade_type", 0);
            this.f78474l = arguments.getInt("param_site_type", 1);
            this.f78475m = arguments.getInt("param_trade_model", 0);
            this.f78477o = arguments.getString("param_coin_id", "");
            this.f78476n = up.g.c(this.f78474l == 0 ? "otc_brand_select_trade_currency_quote_asset" : "otc_select_trade_currency_quote_asset");
            this.f78480r = arguments.getInt("param_from_list_type", 0);
        }
        getActivity().getOnBackPressedDispatcher().h(this.f78481s);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f78481s.remove();
        this.f78481s.setEnabled(false);
        this.f78481s = null;
    }

    public void onResume() {
        super.onResume();
        int i11 = this.f78478p;
        AdvertFilterType advertFilterType = AdvertFilterType.MERCHANT_AND_PAYMETHOD;
        if (i11 == advertFilterType.ordinal()) {
            this.f78472j = advertFilterType;
        } else {
            int i12 = this.f78478p;
            AdvertFilterType advertFilterType2 = AdvertFilterType.TRADING_PAIR;
            if (i12 == advertFilterType2.ordinal()) {
                this.f78472j = advertFilterType2;
            } else {
                int i13 = this.f78478p;
                AdvertFilterType advertFilterType3 = AdvertFilterType.LEGAL_TENDER;
                if (i13 == advertFilterType3.ordinal()) {
                    this.f78472j = advertFilterType3;
                } else {
                    int i14 = this.f78478p;
                    AdvertFilterType advertFilterType4 = AdvertFilterType.CRYPTO_COINS;
                    if (i14 == advertFilterType4.ordinal()) {
                        this.f78472j = advertFilterType4;
                    } else {
                        int i15 = this.f78478p;
                        AdvertFilterType advertFilterType5 = AdvertFilterType.PAY_METHODS;
                        if (i15 == advertFilterType5.ordinal()) {
                            this.f78472j = advertFilterType5;
                        } else {
                            int i16 = this.f78478p;
                            AdvertFilterType advertFilterType6 = AdvertFilterType.AMOUNT;
                            if (i16 == advertFilterType6.ordinal()) {
                                this.f78472j = advertFilterType6;
                            } else {
                                int i17 = this.f78478p;
                                AdvertFilterType advertFilterType7 = AdvertFilterType.SITE_BRAND_FILTER;
                                if (i17 == advertFilterType7.ordinal()) {
                                    this.f78472j = advertFilterType7;
                                } else {
                                    this.f78472j = AdvertFilterType.EXTENSION_FUNCS;
                                }
                            }
                        }
                    }
                }
            }
        }
        bi(this.f78472j);
    }
}
