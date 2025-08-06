package com.hbg.module.content.ui.activity.live;

import android.os.MessageQueue;

public final /* synthetic */ class a0 implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiveDetailActivity f18614a;

    public /* synthetic */ a0(LiveDetailActivity liveDetailActivity) {
        this.f18614a = liveDetailActivity;
    }

    public final boolean queueIdle() {
        return LiveDetailActivity.tl(this.f18614a);
    }
}
