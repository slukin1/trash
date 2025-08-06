package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.IOException;

public interface OnReadListener extends PublicMemberKeeper {
    void onRead(long j11) throws IOException;
}
