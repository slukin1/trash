package com.hbg.module.content.ui.activity.live;

import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentGroupData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveGroup;
import com.hbg.module.content.helper.live.HbgLiveHelper;
import com.hbg.module.livesquare.dialog.LivePrepareDialog;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import nc.c;
import we.b;

public final class LiveDetailActivity$liveAppointment$1 extends Lambda implements l<LiveAppointmentData, Unit> {
    public final /* synthetic */ LiveDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDetailActivity$liveAppointment$1(LiveDetailActivity liveDetailActivity) {
        super(1);
        this.this$0 = liveDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LiveAppointmentData) obj);
        return Unit.f56620a;
    }

    public final void invoke(LiveAppointmentData liveAppointmentData) {
        LiveGroup liveGroup;
        LiveGroup liveGroup2;
        String str;
        LiveGroup liveGroup3;
        LiveGroup liveGroup4;
        this.this$0.Df();
        LiveDetailBean Hi = this.this$0.f18466m;
        int i11 = 1;
        if (Hi != null) {
            Hi.appointed = 1;
        }
        LiveDetailBean Hi2 = this.this$0.f18466m;
        if (Hi2 != null) {
            Hi2.appointedNum = liveAppointmentData != null ? liveAppointmentData.getAppointedNum() : 0;
        }
        HbgLiveHelper.f18227a.L(this.this$0.f18466m);
        LiveDetailActivity.Ki(this.this$0).M(this.this$0.f18466m);
        LiveAppointmentData liveAppointmentData2 = new LiveAppointmentData();
        LiveAppointmentGroupData liveAppointmentGroupData = new LiveAppointmentGroupData();
        LiveDetailBean Hi3 = this.this$0.f18466m;
        liveAppointmentGroupData.setGroupId((Hi3 == null || (liveGroup4 = Hi3.liveGroup) == null) ? null : liveGroup4.groupId);
        LiveDetailBean Hi4 = this.this$0.f18466m;
        liveAppointmentGroupData.setTitle((Hi4 == null || (liveGroup3 = Hi4.liveGroup) == null) ? null : liveGroup3.title);
        LiveDetailBean Hi5 = this.this$0.f18466m;
        liveAppointmentGroupData.setLiveId((Hi5 == null || (str = Hi5.f70249id) == null) ? 0 : Long.parseLong(str));
        LiveDetailBean Hi6 = this.this$0.f18466m;
        if (!(Hi6 == null || (liveGroup2 = Hi6.liveGroup) == null)) {
            i11 = liveGroup2.type;
        }
        liveAppointmentGroupData.setType(i11);
        LiveDetailBean Hi7 = this.this$0.f18466m;
        liveAppointmentGroupData.setHasJion((Hi7 == null || (liveGroup = Hi7.liveGroup) == null) ? 0 : liveGroup.hasJion);
        liveAppointmentData2.setLiveGroup(liveAppointmentGroupData);
        new LivePrepareDialog(liveAppointmentData2, this.this$0.f18466m).show(this.this$0.getSupportFragmentManager(), "");
        c.a("APP_LIVE_notice_show", this.this$0.K);
        LiveDetailBean Hi8 = this.this$0.f18466m;
        if (Hi8 != null) {
            we.c.v(Hi8);
        }
        b.m("liveAppointment", (Class) null, 2, (Object) null).g(0);
    }
}
