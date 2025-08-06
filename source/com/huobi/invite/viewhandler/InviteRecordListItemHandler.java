package com.huobi.invite.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bh.j;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.huobi.invite.bean.InviteRecordListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;

public class InviteRecordListItemHandler implements c, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final int f74648b = 2;

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, InviteRecordListItem inviteRecordListItem, ViewGroup viewGroup) {
        if (cVar != null && inviteRecordListItem != null) {
            cVar.itemView.setTag(inviteRecordListItem);
            cVar.itemView.setOnClickListener(this);
            r e11 = cVar.e();
            TextView textView = (TextView) e11.b(R.id.id_invite_record_list_item_status);
            ((TextView) e11.b(R.id.id_invite_record_list_item_title)).setText(inviteRecordListItem.getAccountName());
            ((TextView) e11.b(R.id.id_invite_record_list_item_desc)).setText(DateTimeUtils.C(inviteRecordListItem.getRegisterTime()));
            String string = j.c().getString(R.string.invite_record_expand_state_can_not_use);
            int color = cVar.itemView.getResources().getColor(R.color.invite_record_list_item_status_text_color_disable);
            int state = inviteRecordListItem.getState();
            if (state == 0) {
                string = j.c().getString(R.string.invite_record_expand_state_invalid);
                color = cVar.itemView.getResources().getColor(R.color.invite_record_list_item_status_text_color_disable);
            } else if (state == 1) {
                string = j.c().getString(R.string.invite_record_expand_state_valid);
                color = cVar.itemView.getResources().getColor(R.color.invite_record_list_item_status_text_color_enable);
            } else if (state == 2) {
                string = j.c().getString(R.string.invite_record_expand_state_can_not_use);
                color = cVar.itemView.getResources().getColor(R.color.invite_record_list_item_status_text_color_disable);
            }
            textView.setText(string);
            textView.setTextColor(color);
        }
    }

    public int getResId() {
        return R.layout.layout_invite_record_list_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        InviteRecordListItem.a aVar;
        InviteRecordListItem inviteRecordListItem = (InviteRecordListItem) view.getTag();
        if (inviteRecordListItem == null || (aVar = inviteRecordListItem.callback) == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        aVar.a(inviteRecordListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
