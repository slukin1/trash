package com.huobi.finance.viewhandler;

import al.s;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bl.s2;
import bl.t2;
import bl.u2;
import bl.v2;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.finance.bean.ManageAddressListItem;
import com.huobi.view.drawable.BgColorDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import i6.r;
import s9.c;

public class ManageAddressListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void g(ManageAddressListItem manageAddressListItem, View view) {
        manageAddressListItem.d().a(manageAddressListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void h(ManageAddressListItem manageAddressListItem, View view) {
        manageAddressListItem.d().b(manageAddressListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(ManageAddressListItem manageAddressListItem, View view) {
        manageAddressListItem.d().b(manageAddressListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(ManageAddressListItem manageAddressListItem, View view) {
        manageAddressListItem.d().c(manageAddressListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, ManageAddressListItem manageAddressListItem, ViewGroup viewGroup) {
        int i12;
        int i13;
        Resources resources = cVar.itemView.getResources();
        DefiChainInfo e11 = manageAddressListItem.e();
        UserAddrInfo c11 = manageAddressListItem.c();
        r e12 = cVar.e();
        TextView textView = (TextView) e12.b(R$id.id_addr_list_item_text_tv);
        View b11 = e12.b(R$id.id_addr_list_item_copy);
        View b12 = e12.b(R$id.id_addr_list_item_delete);
        View b13 = e12.b(R$id.id_addr_list_item_select);
        ImageView imageView = (ImageView) e12.b(R$id.id_addr_list_item_img);
        View b14 = e12.b(R$id.id_addr_list_item_cover_bg);
        try {
            i12 = Color.parseColor(e11.getLeftColor());
        } catch (Exception unused) {
            i12 = Color.parseColor("#3C3E42");
        }
        try {
            i13 = Color.parseColor(e11.getRightColor());
        } catch (Exception unused2) {
            i13 = Color.parseColor("#5D6066");
        }
        cVar.itemView.setBackground(new BgColorDrawable(i12, i13, (float) resources.getDimensionPixelOffset(R$dimen.dimen_10), BgColorDrawable.GradientOrientation.HORIZONTAL));
        textView.setText(s.i(c11.getAddress()));
        b.c().h(imageView, e11.getAddressIcon());
        ViewUtil.m(b13, manageAddressListItem.d().d(manageAddressListItem));
        ViewUtil.m(b14, manageAddressListItem.d().d(manageAddressListItem));
        b12.setOnClickListener(new v2(manageAddressListItem));
        b11.setOnClickListener(new t2(manageAddressListItem));
        textView.setOnClickListener(new s2(manageAddressListItem));
        cVar.itemView.setOnClickListener(new u2(manageAddressListItem));
    }

    public int getResId() {
        return R$layout.layout_manage_addr_list_item;
    }
}
