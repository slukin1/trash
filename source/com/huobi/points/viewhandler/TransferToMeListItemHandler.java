package com.huobi.points.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsAction;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import gq.d;
import i6.m;
import pro.huobi.R;
import s9.c;

public class TransferToMeListItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        String str;
        int i12;
        String str2;
        i6.d.b("TransferToMeListItemHandler-->handleView-->" + dVar.f84175c);
        Resources resources = cVar.itemView.getResources();
        cVar.itemView.setTag(dVar);
        cVar.itemView.setOnClickListener(this);
        TextView textView = (TextView) cVar.e().b(R.id.tv_points_transfer_order_account);
        TextView textView2 = (TextView) cVar.e().b(R.id.tv_points_transfer_order_size);
        TextView textView3 = (TextView) cVar.e().b(R.id.tv_points_transfer_order_status);
        TextView textView4 = (TextView) cVar.e().b(R.id.tv_points_transfer_order_date);
        if (PointsAction.TYPE_TRANSFER_IN.equals(dVar.a().getType())) {
            i12 = resources.getColor(R.color.baseColorMajorTheme100);
            str = "+";
        } else {
            i12 = resources.getColor(R.color.baseColorPrimaryText);
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        textView.setText(resources.getString(R.string.points_history_details_other_account) + " " + dVar.f84175c.getAccount());
        textView2.setText(str + " " + m.p0(m.m(dVar.f84175c.getTotalPoints(), PrecisionUtil.c((String) null))));
        textView2.setTextColor(i12);
        String state = dVar.f84175c.getState();
        state.hashCode();
        char c11 = 65535;
        switch (state.hashCode()) {
            case -1335395429:
                if (state.equals(Points.STATE_DENIED)) {
                    c11 = 0;
                    break;
                }
                break;
            case -673660814:
                if (state.equals("finished")) {
                    c11 = 1;
                    break;
                }
                break;
            case -123173735:
                if (state.equals("canceled")) {
                    c11 = 2;
                    break;
                }
                break;
            case 348678395:
                if (state.equals("submitted")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (!PointsAction.TYPE_TRANSFER_IN.equals(dVar.f84175c.getType())) {
                    str2 = resources.getString(R.string.points_transfer_order_status_reject);
                    break;
                } else {
                    str2 = resources.getString(R.string.points_transfer_order_status_i_rejecct);
                    break;
                }
            case 1:
                str2 = resources.getString(R.string.points_transfer_order_status_finished);
                break;
            case 2:
                if (!PointsAction.TYPE_TRANSFER_IN.equals(dVar.f84175c.getType())) {
                    str2 = resources.getString(R.string.points_transfer_order_status_canceled);
                    break;
                } else {
                    str2 = resources.getString(R.string.points_transfer_order_status_he_cancel);
                    break;
                }
            case 3:
                if (!PointsAction.TYPE_TRANSFER_IN.equals(dVar.f84175c.getType())) {
                    str2 = resources.getString(R.string.points_transfer_order_status_waiting);
                    break;
                } else {
                    str2 = resources.getString(R.string.my_transfer_item_waiting_receive);
                    break;
                }
            default:
                str2 = "";
                break;
        }
        textView3.setText(str2);
        textView4.setText(DateTimeUtils.j(dVar.f84175c.getCreatedAt()));
    }

    public int getResId() {
        return R.layout.layout_transfer_to_me_list_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        d dVar = (d) view.getTag();
        if (!(dVar == null || dVar.a() == null)) {
            dVar.a().a(dVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
