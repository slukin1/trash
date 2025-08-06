package al;

import android.app.Activity;
import android.view.View;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.coupon.bean.CouponReturn;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import java.util.Map;
import vk.c;

public final class i {
    public static c g(Activity activity) {
        return new c(activity.getResources().getString(R$string.n_otc_oneKey_title), new c(activity));
    }

    public static c h(Activity activity, String str) {
        return new c(activity.getResources().getString(R$string.n_balance_grid_strategy), new d(activity, str));
    }

    public static c i(Activity activity, boolean z11) {
        return new c(activity.getResources().getString(R$string.n_otc_card_trade), new g(z11, activity));
    }

    public static c j(Activity activity, String str, String str2) {
        return k(activity, str, str2, activity.getResources().getString(R$string.balance_margin_transfer));
    }

    public static c k(Activity activity, String str, String str2, String str3) {
        return new c(str3, new f(activity, str, str2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (1 == r4.getActiveState()) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (1 == r4.getActiveState()) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a3, code lost:
        if (1 == r4.getActiveState()) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static vk.c l(android.app.Activity r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, com.huobi.asset.AssetAccountType r15) {
        /*
            bc.a r0 = com.hbg.module.asset.AssetModuleConfig.a()
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0015
            vk.c r15 = new vk.c
            al.e r0 = new al.e
            r0.<init>(r11, r12, r13)
            r15.<init>(r14, r0)
            return r15
        L_0x0015:
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.CONTRACT
            r1 = 0
            r2 = 1
            if (r15 == 0) goto L_0x00c5
            r13.hashCode()
            r3 = -1
            int r4 = r13.hashCode()
            switch(r4) {
                case 52: goto L_0x0048;
                case 55: goto L_0x003d;
                case 1567: goto L_0x0032;
                case 1568: goto L_0x0027;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0052
        L_0x0027:
            java.lang.String r4 = "11"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x0030
            goto L_0x0052
        L_0x0030:
            r3 = 3
            goto L_0x0052
        L_0x0032:
            java.lang.String r4 = "10"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x003b
            goto L_0x0052
        L_0x003b:
            r3 = 2
            goto L_0x0052
        L_0x003d:
            java.lang.String r4 = "7"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x0046
            goto L_0x0052
        L_0x0046:
            r3 = r2
            goto L_0x0052
        L_0x0048:
            java.lang.String r4 = "4"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r3 = r1
        L_0x0052:
            switch(r3) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x008d;
                case 2: goto L_0x0074;
                case 3: goto L_0x0057;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x00c5
        L_0x0057:
            int r0 = com.hbg.module.asset.R$string.n_linear_swap_open_usdt_title
            java.lang.String r0 = r11.getString(r0)
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            i8.s r4 = i8.s.d()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo r4 = r4.f()
            if (r4 == 0) goto L_0x0071
            int r4 = r4.getActiveState()
            if (r2 != r4) goto L_0x0071
        L_0x006f:
            r4 = r2
            goto L_0x0072
        L_0x0071:
            r4 = r1
        L_0x0072:
            r8 = r3
            goto L_0x00c8
        L_0x0074:
            int r0 = com.hbg.module.asset.R$string.n_option_open
            java.lang.String r0 = r11.getString(r0)
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.OPTION
            z6.l r4 = z6.l.c()
            com.hbg.lib.data.future.bean.FutureUserInfo r4 = r4.f()
            if (r4 == 0) goto L_0x0071
            int r4 = r4.getActiveState()
            if (r2 != r4) goto L_0x0071
            goto L_0x006f
        L_0x008d:
            int r0 = com.hbg.module.asset.R$string.n_contract_swap_open_title
            java.lang.String r0 = r11.getString(r0)
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.SWAP
            m9.z r4 = m9.z.f()
            com.hbg.lib.network.swap.core.bean.SwapUserInfo$UserBean r4 = r4.h()
            if (r4 == 0) goto L_0x0071
            int r4 = r4.getActiveState()
            if (r2 != r4) goto L_0x0071
            goto L_0x006f
        L_0x00a6:
            int r3 = com.hbg.module.asset.R$string.n_contract_delivery_open_dm_title
            java.lang.String r3 = r11.getString(r3)
            bc.a r4 = com.hbg.module.asset.AssetModuleConfig.a()
            com.huobi.contract.entity.ContractUserInfo$UserBean r4 = r4.R()
            if (r4 == 0) goto L_0x00c1
            int r4 = r4.getActiveState()
            if (r2 != r4) goto L_0x00be
            r4 = r2
            goto L_0x00bf
        L_0x00be:
            r4 = r1
        L_0x00bf:
            r8 = r0
            goto L_0x00c3
        L_0x00c1:
            r8 = r0
            r4 = r1
        L_0x00c3:
            r0 = r3
            goto L_0x00c8
        L_0x00c5:
            r8 = r0
            r4 = r1
            r0 = r14
        L_0x00c8:
            if (r4 != 0) goto L_0x00d0
            com.huobi.asset.AssetAccountType r3 = com.huobi.asset.AssetAccountType.FUTURE
            if (r15 != r3) goto L_0x00d0
            r6 = r2
            goto L_0x00d1
        L_0x00d0:
            r6 = r1
        L_0x00d1:
            if (r6 != 0) goto L_0x00d4
            goto L_0x00d5
        L_0x00d4:
            r14 = r0
        L_0x00d5:
            vk.c r15 = new vk.c
            al.h r0 = new al.h
            r5 = r0
            r7 = r11
            r9 = r12
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            r15.<init>(r14, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: al.i.l(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, com.huobi.asset.AssetAccountType):vk.c");
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(Activity activity, View view) {
        BaseModuleConfig.a().w("app_assets_fiat_fast_click", (HashMap) null);
        AssetModuleConfig.a().C(activity);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void n(Activity activity, String str, View view) {
        BaseModuleConfig.a().w("app_assets_quant_account_grid_trading_click", (HashMap) null);
        AssetModuleConfig.a().j1(activity, str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(boolean z11, Activity activity, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("Page_name", z11 ? "app_assets_margin_cross_view" : "app_assets_margin_isolate_view");
        BaseModuleConfig.a().w("app_assets_trade_click", hashMap);
        AssetModuleConfig.a().H0(activity, z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void p(Activity activity, String str, String str2, View view) {
        BaseModuleConfig.a().b("3525", (Map<String, Object>) null);
        AssetModuleConfig.a().k1(activity, str, str2);
        s(str2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void q(Activity activity, String str, String str2, View view) {
        BaseModuleConfig.a().b("3525", (Map<String, Object>) null);
        AssetModuleConfig.a().k1(activity, str, str2);
        s(str2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void r(boolean z11, Activity activity, TradeType tradeType, String str, String str2, View view) {
        if (z11) {
            AssetModuleConfig.a().g0(activity, true, tradeType);
        } else {
            BaseModuleConfig.a().b("3525", (Map<String, Object>) null);
            AssetModuleConfig.a().k1(activity, str, str2);
            s(str2);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void s(String str) {
        String str2;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 1;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c11 = 2;
                    break;
                }
                break;
            case 54:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                    c11 = 3;
                    break;
                }
                break;
            case 55:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                    c11 = 4;
                    break;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1567:
                if (str.equals(CouponReturn.TYPE_EXPERIENCE)) {
                    c11 = 6;
                    break;
                }
                break;
            case 1568:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                    c11 = 7;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c11 = 8;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                str2 = "app_assets_fiat_view";
                break;
            case 1:
                str2 = "app_assets_margin_isolate_view";
                break;
            case 2:
                str2 = "app_assets_derivatives_coin_M_futures_view";
                break;
            case 3:
                str2 = "app_assets_margin_cross_view";
                break;
            case 4:
                str2 = "app_assets_derivatives_coin_M_swaps_view";
                break;
            case 5:
                str2 = "app_assets_pool_view";
                break;
            case 6:
                str2 = "app_assets_derivatives_options_view";
                break;
            case 7:
                str2 = "app_assets_derivatives_usdt_M_swaps_view";
                break;
            case 8:
                str2 = "app_assets_warrant_view";
                break;
            default:
                str2 = null;
                break;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("Page_name", str2);
        BaseModuleConfig.a().w("app_assets_transfer_click", hashMap);
    }
}
