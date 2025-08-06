package qk;

import bh.j;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import i6.m;
import java.math.BigDecimal;
import pro.huobi.R;

public final class m0 {
    public static boolean a(boolean z11, boolean z12, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (z11 && z12 && m.e0(bigDecimal, bigDecimal2)) {
            HuobiToastUtil.m(j.d(R.string.n_contract_ol_tp_trigger_price_tips));
            return false;
        } else if (!z11 && z12 && m.g0(bigDecimal, bigDecimal2)) {
            HuobiToastUtil.m(j.d(R.string.n_contract_ol_sl_trigger_price_tips));
            return false;
        } else if (z11 && !z12 && m.g0(bigDecimal, bigDecimal2)) {
            HuobiToastUtil.m(j.d(R.string.n_contract_os_tp_trigger_price_tips));
            return false;
        } else if (z11 || z12 || !m.e0(bigDecimal, bigDecimal2)) {
            return true;
        } else {
            HuobiToastUtil.m(j.d(R.string.n_contract_os_sl_trigger_price_tips));
            return false;
        }
    }
}
