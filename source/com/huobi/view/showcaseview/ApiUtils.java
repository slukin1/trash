package com.huobi.view.showcaseview;

import android.os.Build;

class ApiUtils {
    public boolean isCompatWith(int i11) {
        return Build.VERSION.SDK_INT >= i11;
    }

    public boolean isCompatWithHoneycomb() {
        return isCompatWith(11);
    }
}
