package com.huobi.invite.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.huobi.invite.bean.InvitePosterListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import i6.r;
import pro.huobi.R;
import s9.c;

public class InvitePosterItemHandler implements c {

    public interface a {
        void a(InvitePosterListItem invitePosterListItem);

        boolean b(InvitePosterListItem invitePosterListItem);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void d(InvitePosterListItem invitePosterListItem, View view) {
        if (invitePosterListItem.c() != null) {
            invitePosterListItem.c().a(invitePosterListItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, InvitePosterListItem invitePosterListItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        View view = cVar.itemView;
        e11.b(R.id.share_layout);
        CheckBox checkBox = (CheckBox) e11.b(R.id.poster_frame);
        CheckBox checkBox2 = (CheckBox) e11.b(R.id.checked_poster);
        b.c().h((ImageView) e11.b(R.id.poster_image), invitePosterListItem.d().getImg());
        boolean b11 = invitePosterListItem.c() != null ? invitePosterListItem.c().b(invitePosterListItem) : false;
        checkBox.setChecked(b11);
        checkBox2.setChecked(b11);
        view.setOnClickListener(new fm.a(invitePosterListItem));
    }

    public int getResId() {
        return R.layout.item_share_poster;
    }
}
