package com.mob.mgs;

import com.mob.tools.proguard.PublicMemberKeeper;

public interface OnIdChangeListener extends PublicMemberKeeper {
    void onChanged(String str, String str2);
}
