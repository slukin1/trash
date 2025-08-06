package com.mob.commons;

import android.os.Looper;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;

public class MobMeta implements PublicMemberKeeper {
    public static <T> T get(MobProduct mobProduct, String str, Class<T> cls, T t11) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            NLog instance = MobLog.getInstance();
            instance.w("WARNING: gt mta in main: key = " + str);
        }
        T a11 = C0891r.a(str, cls, mobProduct);
        if (a11 == null) {
            a11 = C0891r.a(str);
        }
        return a11 == null ? t11 : a11;
    }
}
