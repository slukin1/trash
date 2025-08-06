package us;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import cn.n;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.webview2.ui.ContractWebActivity;
import oa.a;
import pro.huobi.R;
import tg.r;

public final class h {
    public static /* synthetic */ void b(Context context, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.ai(context, "", "", false, false, 2);
        hBDialogFragment.sh();
    }

    public static void c(Context context) {
        d(context, false);
    }

    public static void d(Context context, boolean z11) {
        FragmentActivity fragmentActivity = (FragmentActivity) a.g().b();
        boolean X = r.x().X();
        Integer valueOf = Integer.valueOf(R.drawable.contract_more_open);
        if (X) {
            new DialogUtils.b.d(fragmentActivity).c1(context.getString(R.string.contract_activate_sub_account_dig_tip_title)).E0(false).i1(1).M0(valueOf).q0(false).P0(context.getString(R.string.allow_access_dialog_positive_btn)).Q0(n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        } else if (z11) {
            ContractWebActivity.ai(context, "", "", false, false, 2);
        } else {
            new DialogUtils.b.d(fragmentActivity).c1(context.getString(R.string.n_swap_open_hint)).E0(false).i1(1).M0(valueOf).s0(context.getString(R.string.n_contract_cancel)).P0(context.getString(R.string.n_contract_activate_dig_tip_btn_open)).Q0(new g(context)).N0(n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }
}
