package com.hbg.module.content.ui.activity.live;

import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import we.c;

public final class LiveDetailActivity$initData$1$8$1$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ LiveSpeaker $speaker;
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$initData$1$8$1$1(LiveSpeaker liveSpeaker, LiveDetailActivity liveDetailActivity) {
        super(1);
        this.$speaker = liveSpeaker;
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        if (x.b(bool, Boolean.TRUE)) {
            this.$speaker.focusStatus = 1;
            LiveDetailActivity.Ki(this.this$0).T(this.$speaker);
            LiveSpeaker liveSpeaker = this.$speaker;
            String str = liveSpeaker.uidUnique;
            if (str == null) {
                str = "";
            }
            c.q(str, liveSpeaker.focusStatus);
        }
    }
}
