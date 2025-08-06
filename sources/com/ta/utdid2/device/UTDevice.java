package com.ta.utdid2.device;

import android.content.Context;
import py.a;

public class UTDevice {
    @Deprecated
    public static String getUtdid(Context context) {
        if (context == null) {
            return "ffffffffffffffffffffffff";
        }
        a.c().e(context);
        return a.a().getUtdid(context);
    }
}
