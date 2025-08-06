package com.hbg.module.content.ui.activity.live;

import android.os.MessageQueue;

public final /* synthetic */ class l0 implements MessageQueue.IdleHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LiveDetailActivity f18654a;

    public /* synthetic */ l0(LiveDetailActivity liveDetailActivity) {
        this.f18654a = liveDetailActivity;
    }

    public final boolean queueIdle() {
        return LiveDetailActivity.Ok(this.f18654a);
    }
}
