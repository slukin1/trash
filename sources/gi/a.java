package gi;

import android.text.TextUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.asset.AssetAccountType;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import java.util.HashMap;
import java.util.List;

public final class a {

    /* renamed from: gi.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0576a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47531a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.asset.AssetAccountType[] r0 = com.huobi.asset.AssetAccountType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f47531a = r0
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.SPOT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f47531a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.FUTURE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f47531a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.MARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f47531a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.OTC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f47531a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.HUOBI_EARN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f47531a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.QUANT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f47531a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.POOL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f47531a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.WARRANT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f47531a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.MORTGAGE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: gi.a.C0576a.<clinit>():void");
        }
    }

    public static void a() {
        BaseModuleConfig.a().w("app_assets_income_analysis_open_button_click", (HashMap) null);
    }

    public static String b(AssetAccountType assetAccountType) {
        switch (C0576a.f47531a[assetAccountType.ordinal()]) {
            case 1:
                return RankScreenBean.SCREEN_VALUE_SPOT;
            case 2:
                return "derivatives";
            case 3:
                return "margin";
            case 4:
                return SymbolBean.FIAT;
            case 5:
                return "huobiEarn";
            case 6:
                return "quant";
            case 7:
                return "pool";
            case 8:
                return "options";
            case 9:
                return "collateral";
            default:
                return "";
        }
    }

    public static String c(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? "default" : "yield" : "earning" : "inventory";
    }

    public static void d() {
        BaseModuleConfig.a().w("app_assets_all_exposure", (HashMap) null);
    }

    public static void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("app_assets_taketurns_click_activity", str);
            BaseModuleConfig.a().w("app_assets_taketurns_click", hashMap);
        }
    }

    public static void f(List<String> list) {
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("app_assets_taketurns_exposure_activity", list.toString());
            BaseModuleConfig.a().w("app_assets_taketurns_exposure", hashMap);
        }
    }

    public static void g() {
        BaseModuleConfig.a().w("app_alterCost_update_click", (HashMap) null);
    }

    public static void h(int i11) {
        String str = i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "recharge" : "cloudWallet" : TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER : "transfer" : "withdraw";
        HashMap hashMap = new HashMap(1);
        hashMap.put("app_assets_recharge_click_button", str);
        BaseModuleConfig.a().w("app_assets_recharge_click", hashMap);
    }

    public static void i(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("switchCurrency", str);
            BaseModuleConfig.a().w("app_switch_currency_all_click", hashMap);
        }
    }

    public static void j() {
        BaseModuleConfig.a().w("app_assets_hide_click", (HashMap) null);
    }

    public static void k() {
        BaseModuleConfig.a().w("app_assets_income_analysis_entrance_click", (HashMap) null);
    }

    public static void l(String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("subAccount", b(AssetAccountType.valueOf(str)));
            BaseModuleConfig.a().w("app_assets_subaccount_entrance_click", hashMap);
        }
    }

    public static void m() {
        BaseModuleConfig.a().w("app_assets_currency_click", (HashMap) null);
    }

    public static void n() {
        BaseModuleConfig.a().w("app_assets_switch_currency_entrance_click", (HashMap) null);
    }

    public static void o() {
        BaseModuleConfig.a().w("app_switch_currency_close_click", (HashMap) null);
    }

    public static void p() {
        BaseModuleConfig.a().w("app_switch_currency_all_exposure", (HashMap) null);
    }

    public static void q(AssetAccountType assetAccountType, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_assets_funds_click_accoutType", b(assetAccountType));
        hashMap.put("app_assets_funds_click_hotSpot", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("app_assets_funds_click_currency", str2);
        }
        BaseModuleConfig.a().w("app_assets_funds_click", hashMap);
    }

    public static void r(AssetAccountType assetAccountType, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_assets_shortcuts_click_accoutType", b(assetAccountType));
        hashMap.put("app_assets_shortcuts_click_button", str);
        hashMap.put("app_assets_shortcuts_click_currency", str2);
        BaseModuleConfig.a().w("app_assets_shortcuts_click", hashMap);
    }

    public static void s(AssetAccountType assetAccountType, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_assets_funds_unfold_button_click_accoutType", b(assetAccountType));
        BaseModuleConfig.a().w("app_assets_funds_unfold_button_click", hashMap);
    }

    public static void t() {
        BaseModuleConfig.a().w("app_income_analysis_windows_exposure", (HashMap) null);
    }

    public static void u() {
        BaseModuleConfig.a().w("app_assets_TodayPL_RedDot_click", (HashMap) null);
    }

    public static void v(int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_assets_rank_button_click_option", c(i11));
        BaseModuleConfig.a().w("app_assets_rank_button_click", hashMap);
    }

    public static void w(boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_assets_rank_upDown_click_option", z11 ? "down" : "up");
        BaseModuleConfig.a().w("app_assets_rank_upDown_click", hashMap);
    }

    public static void x(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("app_spot_shortcuts_click", str);
        BaseModuleConfig.a().w("app_spot_shortcuts_click_button", hashMap);
    }

    public static void y() {
        BaseModuleConfig.a().w("app_assets_subaccount_entrance_exposure", (HashMap) null);
    }
}
