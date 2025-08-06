package com.huobi.finance.utils;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import java.util.Iterator;
import java.util.List;
import x7.f;

public class DepositWithdrawHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f47439a = "!>_<!";

    public static String a(ChainInfo chainInfo) {
        return chainInfo == null ? "" : chainInfo.getChain();
    }

    public static int b(CurrencyBean currencyBean) {
        int i11 = currencyBean.isWhiteEnabled() ? 16 : 0;
        if (currencyBean.isCountryDisabled() || f.c(currencyBean.getName())) {
            i11 |= 8;
        }
        if (!currencyBean.isVisible()) {
            i11 |= 1;
        }
        if (!currencyBean.isVisible() || !currencyBean.isDepositEnabled()) {
            i11 |= 2;
        }
        return !currencyBean.isWithdrawEnabled() ? i11 | 4 : i11;
    }

    public static ChainInfo c(List<ChainInfo> list) {
        ChainInfo chainInfo = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ChainInfo chainInfo2 = list.get(0);
        Iterator<ChainInfo> it2 = list.iterator();
        while (true) {
            if (it2.hasNext()) {
                ChainInfo next = it2.next();
                if (next != null && next.isDefaultChain()) {
                    chainInfo = next;
                    break;
                }
            } else {
                break;
            }
        }
        return chainInfo == null ? chainInfo2 : chainInfo;
    }

    public static String d(ChainInfo chainInfo) {
        String depositDesc = chainInfo == null ? "" : chainInfo.getDepositDesc();
        return !TextUtils.isEmpty(depositDesc) ? depositDesc.replace(f47439a, "\n") : depositDesc;
    }

    public static String e(ChainInfo chainInfo) {
        return chainInfo == null ? "" : chainInfo.getDisplayName();
    }

    public static ChainInfo f(List<ChainInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (ChainInfo next : list) {
            if (next != null) {
                return next;
            }
        }
        return null;
    }

    public static ChainInfo g(List<ChainInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (ChainInfo next : list) {
            if (next != null && ChainInfo.CHAIN_TYPE_NEW.equals(next.getChainType())) {
                return next;
            }
        }
        return null;
    }

    public static ChainInfo h(List<ChainInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (ChainInfo next : list) {
            if (next != null && ChainInfo.CHAIN_TYPE_OLD.equals(next.getChainType())) {
                return next;
            }
        }
        return null;
    }

    public static String i(ChainInfo chainInfo) {
        return chainInfo == null ? "" : chainInfo.getReplaceChainInfoDesc();
    }

    public static String j(ChainInfo chainInfo) {
        return chainInfo == null ? "" : chainInfo.getReplaceChainNotificationDesc();
    }

    public static String k(ChainInfo chainInfo) {
        return chainInfo == null ? "" : chainInfo.getReplaceChainPopupDesc();
    }

    public static ChainInfo l(List<ChainInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (ChainInfo next : list) {
            if (next != null && next.getDepositEnable()) {
                return next;
            }
        }
        return null;
    }

    public static ChainInfo m(List<ChainInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (ChainInfo next : list) {
            if (next != null && next.getWithdrawEnable()) {
                return next;
            }
        }
        return null;
    }

    public static String n(List<ChainInfo> list) {
        ChainInfo f11 = f(list);
        if (f11 == null) {
            return "";
        }
        return f11.getSuspendDepositDesc();
    }

    public static String o(List<ChainInfo> list) {
        ChainInfo f11 = f(list);
        if (f11 == null) {
            return "";
        }
        return f11.getSuspendWithdrawDesc();
    }

    public static String p(ChainInfo chainInfo) {
        String withdrawDesc = chainInfo == null ? "" : chainInfo.getWithdrawDesc();
        return !TextUtils.isEmpty(withdrawDesc) ? withdrawDesc.replace(f47439a, "\n") : withdrawDesc;
    }

    public static String q(ChainInfo chainInfo) {
        return chainInfo == null ? "" : chainInfo.getWithdrawMinAmount();
    }

    public static int r(ChainInfo chainInfo) {
        if (chainInfo == null) {
            return 0;
        }
        return chainInfo.getWithdrawPrecision();
    }

    public static boolean s(ChainInfo chainInfo) {
        if (chainInfo == null) {
            return false;
        }
        return chainInfo.getAddrOneoff();
    }

    public static boolean t(ChainInfo chainInfo) {
        if (chainInfo == null) {
            return false;
        }
        return chainInfo.getAddrWithTag();
    }

    public static boolean u(ChainInfo chainInfo) {
        if (chainInfo == null) {
            return false;
        }
        return chainInfo.getAddrdepositTag();
    }

    public static boolean v(ChainInfo chainInfo) {
        if (chainInfo == null) {
            return false;
        }
        return chainInfo.getDepositEnable();
    }

    public static boolean w(ChainInfo chainInfo) {
        if (chainInfo == null) {
            return false;
        }
        return chainInfo.getWithdrawEnable();
    }

    public static boolean x(List<ChainInfo> list) {
        return list != null && list.size() >= 2 && !y(list);
    }

    public static boolean y(List<ChainInfo> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        boolean z11 = false;
        boolean z12 = false;
        for (ChainInfo next : list) {
            if (next != null) {
                if (ChainInfo.CHAIN_TYPE_OLD.equals(next.getChainType())) {
                    z12 = true;
                } else if (ChainInfo.CHAIN_TYPE_NEW.equals(next.getChainType())) {
                    z11 = true;
                }
            }
        }
        if (list.size() != 2 || !z11 || !z12) {
            return false;
        }
        return true;
    }

    public static boolean z(List<ChainInfo> list) {
        return list == null || list.size() <= 1;
    }
}
