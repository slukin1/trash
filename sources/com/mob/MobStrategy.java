package com.mob;

import com.mob.commons.ab;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.i;

public class MobStrategy implements PublicMemberKeeper {
    public static void setStrategy(final int i11) {
        new Thread(new i() {
            public void a() {
                ab.a().a(i11);
            }
        }).start();
    }
}
