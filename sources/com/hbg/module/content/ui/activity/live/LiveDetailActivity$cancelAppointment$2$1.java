package com.hbg.module.content.ui.activity.live;

import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.module.content.helper.live.HbgLiveHelper;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.b;
import we.c;

public final class LiveDetailActivity$cancelAppointment$2$1 extends Lambda implements l<LiveAppointmentData, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$cancelAppointment$2$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LiveAppointmentData) obj);
        return Unit.f56620a;
    }

    public final void invoke(LiveAppointmentData liveAppointmentData) {
        this.this$0.Df();
        LiveDetailBean Hi = this.this$0.f18466m;
        if (Hi != null) {
            Hi.appointed = 0;
        }
        LiveDetailBean Hi2 = this.this$0.f18466m;
        if (Hi2 != null) {
            Hi2.appointedNum = liveAppointmentData != null ? liveAppointmentData.getAppointedNum() : 0;
        }
        HbgLiveHelper.f18227a.L(this.this$0.f18466m);
        LiveDetailActivity.Ki(this.this$0).M(this.this$0.f18466m);
        LiveDetailBean Hi3 = this.this$0.f18466m;
        if (Hi3 != null) {
            c.v(Hi3);
        }
        b.m("liveAppointment", (Class) null, 2, (Object) null).g(0);
    }
}
