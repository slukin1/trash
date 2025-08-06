package yk;

import al.j;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import cn.n;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import pro.huobi.R;

public final class h {
    public static /* synthetic */ void b(boolean z11, String str, FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        if (!z11) {
            if ("usdt".equalsIgnoreCase(str)) {
                j.b(fragmentActivity, "usdt");
            } else if ("husd".equalsIgnoreCase(str)) {
                j.b(fragmentActivity, "husd");
            } else {
                LinearSwapTradeBaseFragment.Lj(fragmentActivity, FutureContractInfoController.n().o(StringUtils.i(str)), 2);
            }
        }
        hBDialogFragment.dismiss();
        fragmentActivity.finish();
    }

    public static void c(FragmentActivity fragmentActivity, String str, boolean z11) {
        if (fragmentActivity != null) {
            Resources resources = fragmentActivity.getResources();
            DialogUtils.c0(fragmentActivity, resources.getString(R.string.transfer_contract_trade_dialog_content), (String) null, (String) null, resources.getString(R.string.currency_detail_contract_exchange), n.f13170a, new g(z11, str, fragmentActivity));
        }
    }
}
