package com.huochat.community.util;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huochat.community.R;

public final class CommunityDialogUtil {
    public static final CommunityDialogUtil INSTANCE = new CommunityDialogUtil();

    private CommunityDialogUtil() {
    }

    public final void showDialog(FragmentActivity fragmentActivity, int i11, String str, String str2, String str3, String str4, String str5, DialogUtils.b.f fVar, DialogUtils.b.f fVar2) {
        HBDialogFragment j02 = new DialogUtils.b.d(fragmentActivity).L0(Integer.valueOf(i11 == 0 ? R.drawable.community_dialog_bg_light : R.drawable.community_dialog_bg_night)).c1(str).e1(Integer.valueOf(BaseApplication.a(i11 == 0 ? R.color.color_14181F : R.color.color_CFD3E9))).h1(Float.valueOf((float) DisplayTool.dp2px(16.0f))).C0(str2).D0(Integer.valueOf(BaseApplication.a(i11 == 0 ? R.color.color_14181F : R.color.color_CFD3E9))).R0(str3).T0(true).P0(str5).s0(str4).r0(Integer.valueOf(BaseApplication.a(i11 == 0 ? R.color.color_14181F : R.color.color_CFD3E9))).p0(Integer.valueOf(i11 == 0 ? R.drawable.community_cancel_btn_selector : R.drawable.community_cancel_btn_selector_night)).Q0(fVar2).N0(fVar).j0();
        if (fragmentActivity != null) {
            j02.show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }
}
