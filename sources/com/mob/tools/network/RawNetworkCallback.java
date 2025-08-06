package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.InputStream;

public interface RawNetworkCallback extends PublicMemberKeeper {
    void onResponse(InputStream inputStream) throws Throwable;
}
