package com.mob.commons.logcollector;

import com.mob.tools.log.LogCollector;
import com.mob.tools.proguard.ProtectedMemberKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
public abstract class LogsCollector implements LogCollector, ProtectedMemberKeeper, PublicMemberKeeper {
    public LogsCollector() {
        DefaultLogsCollector.get().addSDK(getSDKTag(), getSDKVersion());
    }

    public abstract String getSDKTag();

    public abstract int getSDKVersion();

    public final void log(String str, int i11, int i12, String str2, String str3) {
        DefaultLogsCollector.get().log(str, i11, i12, str2, str3);
    }
}
