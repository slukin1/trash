package com.mob.mcl;

import com.mob.tools.proguard.EverythingKeeper;

public interface TcpStatusListener extends EverythingKeeper {
    void onStatus(TcpStatus tcpStatus);
}
