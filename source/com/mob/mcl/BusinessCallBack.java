package com.mob.mcl;

import com.mob.tools.proguard.EverythingKeeper;

public interface BusinessCallBack<T> extends EverythingKeeper {
    void callback(T t11);
}
