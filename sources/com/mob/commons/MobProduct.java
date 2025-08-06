package com.mob.commons;

import com.mob.tools.proguard.EverythingKeeper;

public interface MobProduct extends EverythingKeeper {
    String getProductTag();

    int getSdkver();
}
