package com.huobi.guide.helper;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.guide.ui.ContractGuideNewFragment;
import com.huobi.guide.ui.TradeLoanRepayGuideFragment;
import i6.d;

public class ContractGuideHelper {
    public static int a(int i11) {
        switch (i11) {
            case 1:
                return 3;
            case 5:
                return 4;
            case 6:
                return 1;
            default:
                return 0;
        }
    }

    public static void b(FragmentActivity fragmentActivity, int i11) {
        c(fragmentActivity.getSupportFragmentManager(), i11);
    }

    public static void c(FragmentManager fragmentManager, int i11) {
        int i12 = 0;
        if (ConfigPreferences.g("contract_guide_config", "ContractGuideKey_LIMIT_ORDER", 0) == i11) {
            d.b("引导弹框已点击,typeId ：" + i11);
        } else if (ConfigPreferences.g("contract_guide_config", "ContractGuideKey_STORE_ORDER", 0) == i11) {
            d.b("引导弹框已点击,typeId ：" + i11);
        } else if (ConfigPreferences.g("contract_guide_config", "ContractGuideKey_TRIGGER_ORDER", 0) == i11) {
            d.b("引导弹框已点击,typeId ：" + i11);
        } else {
            if (i11 == 1) {
                ConfigPreferences.k("contract_guide_config", "ContractGuideKey_LIMIT_ORDER", 1);
            } else {
                if (i11 == 2) {
                    ConfigPreferences.k("contract_guide_config", "ContractGuideKey_OPEN_ORDER", 2);
                } else if (i11 == 3) {
                    ConfigPreferences.k("contract_guide_config", "ContractGuideKey_STORE_ORDER", 3);
                } else if (i11 == 4) {
                    ConfigPreferences.k("contract_guide_config", "ContractGuideKey_TRIGGER_ORDER", 4);
                    i12 = 3;
                } else if (i11 == 6) {
                    ConfigPreferences.k("contract_guide_config", "TradeGuideKey_MARKET", 6);
                    i12 = 1;
                }
                i12 = 2;
            }
            ContractGuideNewFragment.yh(i12, "").show(fragmentManager, "guide");
        }
    }

    public static void d(FragmentManager fragmentManager, String str, int i11) {
        ContractGuideNewFragment.yh(i11, str).show(fragmentManager, str);
    }

    public static void e(FragmentManager fragmentManager, int i11) {
        int i12 = 0;
        switch (i11) {
            case 2:
            case 3:
            case 7:
                i12 = 2;
                break;
            case 4:
            case 8:
                i12 = 3;
                break;
            case 6:
                i12 = 1;
                break;
        }
        ContractGuideNewFragment yh2 = ContractGuideNewFragment.yh(i12, "");
        yh2.zh(true);
        yh2.show(fragmentManager, "guide");
    }

    public static void f(FragmentManager fragmentManager, int i11, boolean z11, String str) {
        int i12 = 0;
        switch (i11) {
            case 2:
            case 3:
            case 7:
                i12 = 2;
                break;
            case 4:
            case 8:
                i12 = 3;
                break;
            case 6:
                i12 = 1;
                break;
        }
        ContractGuideNewFragment yh2 = ContractGuideNewFragment.yh(i12, str);
        yh2.zh(true);
        yh2.Ah(z11);
        yh2.show(fragmentManager, "guide");
    }

    public static void g(FragmentManager fragmentManager, int i11) {
        TradeLoanRepayGuideFragment.yh(i11).show(fragmentManager, "guide");
    }
}
