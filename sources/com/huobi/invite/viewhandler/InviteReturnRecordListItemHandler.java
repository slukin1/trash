package com.huobi.invite.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bh.j;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.invite.bean.InviteReturnRecordListItem;
import com.huobi.points.entity.PointsAction;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.util.Locale;
import pro.huobi.R;
import s9.c;

public class InviteReturnRecordListItemHandler implements c, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final String f74649b = "finished";

    /* renamed from: c  reason: collision with root package name */
    public final String f74650c = PointsAction.STATE_PREPARED;

    /* renamed from: d  reason: collision with root package name */
    public final String f74651d = SymbolBean.SUSPEND;

    /* renamed from: e  reason: collision with root package name */
    public final String f74652e = "reissued";

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, InviteReturnRecordListItem inviteReturnRecordListItem, ViewGroup viewGroup) {
        int i12;
        int i13;
        v9.c cVar2 = cVar;
        InviteReturnRecordListItem inviteReturnRecordListItem2 = inviteReturnRecordListItem;
        if (cVar2 == null || inviteReturnRecordListItem2 == null) {
            return;
        }
        cVar2.itemView.setTag(inviteReturnRecordListItem2);
        cVar2.itemView.setOnClickListener(this);
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_invite_return_record_status);
        TextView textView2 = (TextView) e11.b(R.id.tv_invite_return_record_date);
        TextView textView3 = (TextView) e11.b(R.id.tv_invite_return_record_point_card);
        TextView textView4 = (TextView) e11.b(R.id.tv_invite_return_record_money);
        TextView textView5 = (TextView) e11.b(R.id.tv_invite_return_record_cash_unit);
        ((TextView) e11.b(R.id.tv_invite_return_record_account)).setText(inviteReturnRecordListItem.getAccount());
        String str = "finished";
        boolean equals = str.equals(inviteReturnRecordListItem.getState());
        boolean equals2 = "reissued".equals(inviteReturnRecordListItem.getState());
        if (!TextUtils.isEmpty(inviteReturnRecordListItem.getState())) {
            str = inviteReturnRecordListItem.getState();
        }
        String string = j.c().getString(R.string.invite_return_record_list_item_status);
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1852006340:
                if (str.equals(SymbolBean.SUSPEND)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1279552451:
                if (str.equals(PointsAction.STATE_PREPARED)) {
                    c11 = 1;
                    break;
                }
                break;
            case -623718754:
                if (str.equals("reissued")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                string = j.c().getString(R.string.invite_return_record_list_item_status_invalid);
                break;
            case 1:
                string = j.c().getString(R.string.invite_return_record_list_item_status_unarrived);
                break;
            case 2:
                string = j.c().getString(R.string.invite_return_record_list_item_status_reissue);
                break;
        }
        textView.setText(string);
        textView2.setText(DateTimeUtils.C(inviteReturnRecordListItem.getDate()));
        textView3.setText("+" + m.i(inviteReturnRecordListItem.getBrokeragePoint().doubleValue(), PrecisionUtil.g()));
        textView4.setText("+" + m.i(inviteReturnRecordListItem.getBrokerageAmount().doubleValue(), PrecisionUtil.f()));
        if ((equals2 || equals) && inviteReturnRecordListItem.getBrokeragePoint().doubleValue() != 0.0d) {
            i12 = cVar2.itemView.getResources().getColor(R.color.invite_return_record_list_item_color_light);
        } else {
            i12 = cVar2.itemView.getResources().getColor(R.color.global_secondary_text_color);
        }
        textView3.setTextColor(i12);
        if ((equals2 || equals) && inviteReturnRecordListItem.getBrokerageAmount().doubleValue() != 0.0d) {
            i13 = cVar2.itemView.getResources().getColor(R.color.invite_return_record_list_item_color_light);
        } else {
            i13 = cVar2.itemView.getResources().getColor(R.color.global_secondary_text_color);
        }
        textView4.setTextColor(i13);
        textView5.setText(String.format(Locale.US, cVar2.itemView.getResources().getString(R.string.invite_return_record_list_item_brokerage), new Object[]{cVar2.itemView.getResources().getString(R.string.invite_return_unit_usdt)}));
    }

    public int getResId() {
        return R.layout.layout_invite_return_record_list_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        InviteReturnRecordListItem.a aVar;
        InviteReturnRecordListItem inviteReturnRecordListItem = (InviteReturnRecordListItem) view.getTag();
        if (inviteReturnRecordListItem == null || (aVar = inviteReturnRecordListItem.callback) == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        aVar.M5(inviteReturnRecordListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
