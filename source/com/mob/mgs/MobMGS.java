package com.mob.mgs;

import com.mob.mgs.impl.b;
import com.mob.mgs.impl.g;
import com.mob.tools.proguard.EverythingKeeper;

public class MobMGS implements EverythingKeeper {
    public static final String MGS_TAG = "MOBGUARD";

    public static boolean getDS() {
        return b.b();
    }

    public static void setDS(boolean z11) {
        b.a(z11);
    }

    public static void setOnAppActiveListener(OnAppActiveListener onAppActiveListener) {
        if (onAppActiveListener != null) {
            g.a(onAppActiveListener);
        }
    }
}
