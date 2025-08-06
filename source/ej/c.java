package ej;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import cn.n;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.webview2.ui.ContractWebActivity;
import oa.a;
import pro.huobi.R;
import tg.r;

public final class c {
    public static /* synthetic */ void b(Context context, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.Zh(context, "", "", false, false);
        hBDialogFragment.sh();
    }

    public static void c(Context context) {
        d(context, false);
    }

    public static void d(Context context, boolean z11) {
        boolean X = r.x().X();
        Integer valueOf = Integer.valueOf(R.drawable.contract_more_open);
        if (X) {
            new DialogUtils.b.d((FragmentActivity) a.g().b()).c1(context.getString(R.string.contract_activate_sub_account_dig_tip_title)).E0(false).i1(1).M0(valueOf).q0(false).P0(context.getString(R.string.allow_access_dialog_positive_btn)).Q0(n.f13170a).j0().show(((FragmentActivity) a.g().b()).getSupportFragmentManager(), "");
        } else if (z11) {
            ContractWebActivity.Zh(context, "", "", false, false);
        } else {
            new DialogUtils.b.d((FragmentActivity) a.g().b()).c1(context.getString(R.string.n_contract_activate_dig_tip_dm_title)).E0(false).i1(1).M0(valueOf).s0(context.getString(R.string.n_contract_cancel)).P0(context.getString(R.string.n_contract_activate_dig_tip_btn_open)).Q0(new b(context)).N0(n.f13170a).j0().show(((FragmentActivity) a.g().b()).getSupportFragmentManager(), "");
        }
    }
}
