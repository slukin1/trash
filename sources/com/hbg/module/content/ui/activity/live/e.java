package com.hbg.module.content.ui.activity.live;

import android.os.MessageQueue;

public final /* synthetic */ class e implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FullScreenLiveActivity f18628a;

    public /* synthetic */ e(FullScreenLiveActivity fullScreenLiveActivity) {
        this.f18628a = fullScreenLiveActivity;
    }

    public final boolean queueIdle() {
        return FullScreenLiveActivity$initGiftManager$2.invoke$lambda$0(this.f18628a);
    }
}
