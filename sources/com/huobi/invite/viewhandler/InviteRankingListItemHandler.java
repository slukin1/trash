package com.huobi.invite.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.invite.bean.InviteRankingListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dm.a;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;

public class InviteRankingListItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, InviteRankingListItem inviteRankingListItem, ViewGroup viewGroup) {
        if (cVar != null && inviteRankingListItem != null) {
            cVar.itemView.setOnClickListener(this);
            cVar.itemView.setTag(inviteRankingListItem);
            r e11 = cVar.e();
            TextView textView = (TextView) e11.b(R.id.id_invite_ranking_list_account);
            TextView textView2 = (TextView) e11.b(R.id.id_invite_ranking_list_usdt_amount);
            TextView textView3 = (TextView) e11.b(R.id.id_invite_ranking_list_point_amount);
            View b11 = e11.b(R.id.id_invite_ranking_list_item_divider);
            ((TextView) e11.b(R.id.id_invite_ranking_list_item_title)).setText(String.valueOf(i11 + 3 + 1));
            b11.setVisibility(i11 == 0 ? 8 : 0);
            textView.setText(inviteRankingListItem.inviteReturnDetail.getAccount());
            textView2.setText(m.i(inviteRankingListItem.inviteReturnDetail.getAmountSum().doubleValue(), PrecisionUtil.i()));
            textView3.setText(m.i(inviteRankingListItem.inviteReturnDetail.getPointSum().doubleValue(), PrecisionUtil.h()));
        }
    }

    public int getResId() {
        return R.layout.layout_invite_ranking_list_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar;
        InviteRankingListItem inviteRankingListItem = (InviteRankingListItem) view.getTag();
        if (!(inviteRankingListItem == null || (aVar = inviteRankingListItem.callback) == null)) {
            aVar.O(inviteRankingListItem.inviteReturnDetail);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
