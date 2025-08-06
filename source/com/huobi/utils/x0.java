package com.huobi.utils;

import android.view.View;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.view.TipsPopup;

public final class x0 {
    public static /* synthetic */ void b(TipsPopup tipsPopup) {
        if (tipsPopup.isShowing()) {
            tipsPopup.dismiss();
        }
    }

    public static TipsPopup c(View view, String str, boolean z11) {
        TipsPopup tipsPopup = new TipsPopup(view.getContext(), z11, str);
        tipsPopup.setText(str);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        tipsPopup.showAt(view, (iArr[0] - PixelUtils.a(15.0f)) + (view.getWidth() / 2));
        return tipsPopup;
    }

    public static void d(View view, String str) {
        view.postDelayed(new w0(c(view, str, true)), 3000);
    }
}
