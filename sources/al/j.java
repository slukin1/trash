package al;

import android.content.Context;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import dn.d;
import qk.k;

public final class j {
    public static FutureContractInfo a(String str) {
        FutureContractInfo f11 = k.f(FutureContractInfoController.n().e(TradeType.LINEAR_SWAP));
        if (f11 == null) {
            return null;
        }
        return (d.f().j(f11.getSymbol()) || f11.isSupportCross()) ? f11 : FutureContractInfoController.n().k();
    }

    public static void b(Context context, String str) {
        LinearSwapTradeBaseFragment.Lj(context, a(StringUtils.g(str)), 1);
    }
}
