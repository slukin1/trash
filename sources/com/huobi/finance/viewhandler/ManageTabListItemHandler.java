package com.huobi.finance.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import bl.w2;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.finance.bean.ManageTabListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import s9.c;

public class ManageTabListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(ManageTabListItem manageTabListItem, View view) {
        manageTabListItem.c().b(manageTabListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, ManageTabListItem manageTabListItem, ViewGroup viewGroup) {
        String str;
        Resources resources = cVar.itemView.getResources();
        ImageView imageView = (ImageView) cVar.e().b(R$id.imageView);
        boolean a11 = manageTabListItem.c().a(manageTabListItem);
        if (a11) {
            str = manageTabListItem.d().getSelectIcon();
        } else if (NightHelper.e().g()) {
            str = manageTabListItem.d().getUnSelectIconNight();
        } else {
            str = manageTabListItem.d().getUnSelectIcon();
        }
        b.c().h(imageView, str);
        if (a11) {
            cVar.itemView.setBackgroundColor(resources.getColor(R$color.login_v2_bottom_background));
        } else {
            cVar.itemView.setBackgroundColor(0);
        }
        cVar.itemView.setOnClickListener(new w2(manageTabListItem));
    }

    public int getResId() {
        return R$layout.layout_manage_list_item;
    }
}
