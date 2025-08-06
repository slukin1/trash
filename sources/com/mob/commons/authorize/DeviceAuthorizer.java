package com.mob.commons.authorize;

import android.content.Context;
import com.mob.commons.MobProduct;
import com.mob.commons.e;
import com.mob.commons.j;
import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
public final class DeviceAuthorizer implements PublicMemberKeeper {
    public static synchronized String authorize(MobProduct mobProduct) {
        String a11;
        synchronized (DeviceAuthorizer.class) {
            a11 = e.a(mobProduct);
        }
        return a11;
    }

    public static String authorizeForOnce() {
        return e.b();
    }

    public static String getMString(Context context) {
        return e.a(context);
    }

    public static boolean isClear() {
        return j.a().b();
    }

    public static boolean isFor() {
        return e.a();
    }
}
