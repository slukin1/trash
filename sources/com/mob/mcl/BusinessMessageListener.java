package com.mob.mcl;

import com.mob.tools.proguard.EverythingKeeper;

public interface BusinessMessageListener extends EverythingKeeper {
    void messageReceived(int i11, String str, String str2);
}
