package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;

public interface HttpResponseCallback extends PublicMemberKeeper {
    void onResponse(HttpConnection httpConnection) throws Throwable;
}
