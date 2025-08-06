package com.hbg.module.libkt.utils;

import android.content.res.Resources;

public final class m {
    public static final int a(Number number) {
        return (int) (((float) number.intValue()) * Resources.getSystem().getDisplayMetrics().density);
    }
}
