package com.huobi.asset2.index.util;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$string;
import com.huobi.margin.entity.MarginBalanceQueryData;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f42769a;

    /* renamed from: b  reason: collision with root package name */
    public String f42770b;

    /* renamed from: com.huobi.asset2.index.util.b$b  reason: collision with other inner class name */
    public static class C0561b {

        /* renamed from: a  reason: collision with root package name */
        public static b f42771a = new b();
    }

    public static b a() {
        return C0561b.f42771a;
    }

    public int b() {
        if (MarginBalanceQueryData.STATE_FL_NEGATIVE_ACCOUNT.equalsIgnoreCase(this.f42770b) || MarginBalanceQueryData.STATE_FL_SYS.equalsIgnoreCase(this.f42770b) || MarginBalanceQueryData.STATE_FL_MGT.equalsIgnoreCase(this.f42770b) || MarginBalanceQueryData.STATE_FL_END.equalsIgnoreCase(this.f42770b)) {
            return R$color.baseCoinDangerousTip;
        }
        if ("lock".equalsIgnoreCase(this.f42770b)) {
            return R$color.baseCoinLockTip;
        }
        String str = this.f42769a;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return R$color.scan_toolbar_bg_color;
            case 1:
                return R$color.color_FE8731;
            case 2:
            case 3:
                return R$color.baseCoinDangerousTip;
            default:
                return R$color.baseColorShadeFunctionButtonEnd;
        }
    }

    public String c(Context context) {
        if (MarginBalanceQueryData.STATE_FL_NEGATIVE_ACCOUNT.equalsIgnoreCase(this.f42770b)) {
            return context.getString(R$string.n_spot_wear_a_storehouse);
        }
        if ("lock".equalsIgnoreCase(this.f42770b)) {
            return context.getString(R$string.n_spot_lock_a_storehouse);
        }
        if (MarginBalanceQueryData.STATE_FL_SYS.equalsIgnoreCase(this.f42770b) || MarginBalanceQueryData.STATE_FL_MGT.equalsIgnoreCase(this.f42770b) || MarginBalanceQueryData.STATE_FL_END.equalsIgnoreCase(this.f42770b)) {
            return context.getString(R$string.n_spot_blast_a_storehouse);
        }
        String str = this.f42769a;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return context.getString(R$string.n_spot_order_little_risk);
            case 1:
                return context.getString(R$string.n_spot_order_middle_risk);
            case 2:
                return context.getString(R$string.n_spot_order_high_risk);
            case 3:
                return context.getString(R$string.n_spot_order_very_high_risk);
            default:
                return context.getString(R$string.n_spot_order_not_risk);
        }
    }

    public boolean d() {
        return MarginBalanceQueryData.STATE_FL_NEGATIVE_ACCOUNT.equalsIgnoreCase(this.f42770b);
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f42769a) && !TextUtils.isEmpty(this.f42770b);
    }

    public void f(String str, String str2) {
        this.f42769a = str;
        this.f42770b = str2;
    }

    public b() {
    }
}
