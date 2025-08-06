package al;

import com.hbg.lib.common.utils.SystemUtils;
import com.huobi.finance.bean.InnerWithdrawAddress;
import java.util.List;

public final class y {
    public static boolean a(InnerWithdrawAddress innerWithdrawAddress) {
        if (innerWithdrawAddress == null) {
            return false;
        }
        return (SystemUtils.c() ? "1130" : "1139").equalsIgnoreCase(innerWithdrawAddress.getExchangeId());
    }

    public static boolean b(List<InnerWithdrawAddress> list) {
        if (list == null) {
            return false;
        }
        for (InnerWithdrawAddress a11 : list) {
            if (a(a11)) {
                return true;
            }
        }
        return false;
    }
}
