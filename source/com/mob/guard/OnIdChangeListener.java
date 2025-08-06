package com.mob.guard;

import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
public interface OnIdChangeListener extends PublicMemberKeeper {
    void onChanged(String str, String str2);
}
