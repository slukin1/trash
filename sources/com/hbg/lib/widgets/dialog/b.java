package com.hbg.lib.widgets.dialog;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$string;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final class b {
    public static void a(FragmentActivity fragmentActivity) {
        new DialogUtils.b.d(fragmentActivity).G0(Integer.valueOf(PixelUtils.a(16.0f))).C0(fragmentActivity.getResources().getString(R$string.use_pc_web_instead)).i1(1).M0(Integer.valueOf(R$drawable.otc_tips_toweb)).P0(fragmentActivity.getResources().getString(R$string.allow_access_dialog_positive_btn)).q0(false).Q0(ad.b.f3517a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }
}
