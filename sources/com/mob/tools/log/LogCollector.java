package com.mob.tools.log;

import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
public interface LogCollector extends PublicMemberKeeper {
    public static final int LEVEL_CRASH = 1;
    public static final int LEVEL_NATIVE = 2;
    public static final int LEVEL_NORMAL = 0;
    public static final int LEVEL_NORMAL_UPLOAD = 3;

    void log(String str, int i11, int i12, String str2, String str3);
}
