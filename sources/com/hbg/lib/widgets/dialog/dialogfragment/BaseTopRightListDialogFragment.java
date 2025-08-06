package com.hbg.lib.widgets.dialog.dialogfragment;

import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$style;
import i6.r;
import s9.a;

public abstract class BaseTopRightListDialogFragment<T extends a> extends BaseListDialogFragment<T> {
    public void afterInit() {
        super.afterInit();
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
        }
        customizeWindowDimAmount();
    }

    public int getAnimationStyle() {
        return R$style.tradeMenuAnimation;
    }

    public int getGravity() {
        return BadgeDrawable.TOP_END;
    }

    public void initView(r rVar) {
        super.initView(rVar);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.global_margin_right);
        getRootLayout().setPadding(0, dimensionPixelOffset, dimensionPixelOffset, 0);
    }
}
