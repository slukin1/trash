package com.sumsub.sns.core.common;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public final class a {
    public static final <T extends View> boolean a(BottomSheetBehavior<T> bottomSheetBehavior) {
        return bottomSheetBehavior.getState() == 3;
    }
}
