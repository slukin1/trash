package com.huobi.view.pickerview.util;

import pro.huobi.R;

public class PickerViewAnimateUtil {
    private static final int INVALID = -1;

    public static int getAnimationResource(int i11, boolean z11) {
        if (i11 != 80) {
            return -1;
        }
        return z11 ? R.anim.pickerview_slide_in_bottom : R.anim.pickerview_slide_out_bottom;
    }
}
