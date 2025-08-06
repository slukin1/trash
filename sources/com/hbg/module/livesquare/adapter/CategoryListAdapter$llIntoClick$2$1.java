package com.hbg.module.livesquare.adapter;

import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentGroupData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.module.livesquare.dialog.LivePrepareDialog;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.c;

public final class CategoryListAdapter$llIntoClick$2$1 extends Lambda implements l<LiveAppointmentData, Unit> {
    public final /* synthetic */ LiveDetailBean $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ CategoryListAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoryListAdapter$llIntoClick$2$1(LiveDetailBean liveDetailBean, CategoryListAdapter categoryListAdapter, int i11) {
        super(1);
        this.$data = liveDetailBean;
        this.this$0 = categoryListAdapter;
        this.$position = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LiveAppointmentData) obj);
        return Unit.f56620a;
    }

    public final void invoke(LiveAppointmentData liveAppointmentData) {
        if (liveAppointmentData != null) {
            LiveDetailBean liveDetailBean = this.$data;
            CategoryListAdapter categoryListAdapter = this.this$0;
            int i11 = this.$position;
            liveDetailBean.appointed = 1;
            liveDetailBean.appointedNum = liveAppointmentData.getAppointedNum();
            categoryListAdapter.notifyItemChanged(i11);
            LiveAppointmentData liveAppointmentData2 = new LiveAppointmentData();
            LiveAppointmentGroupData liveAppointmentGroupData = new LiveAppointmentGroupData();
            LiveAppointmentGroupData liveGroup = liveAppointmentData.getLiveGroup();
            String str = null;
            liveAppointmentGroupData.setGroupId(liveGroup != null ? liveGroup.getGroupId() : null);
            LiveAppointmentGroupData liveGroup2 = liveAppointmentData.getLiveGroup();
            if (liveGroup2 != null) {
                str = liveGroup2.getTitle();
            }
            liveAppointmentGroupData.setTitle(str);
            liveAppointmentGroupData.setLiveId(Long.parseLong(liveDetailBean.f70249id));
            liveAppointmentData2.setLiveGroup(liveAppointmentGroupData);
            new LivePrepareDialog(liveAppointmentData2, liveDetailBean).show(categoryListAdapter.f().getSupportFragmentManager(), "");
            c.v(liveDetailBean);
        }
    }
}
