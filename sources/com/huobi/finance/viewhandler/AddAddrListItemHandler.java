package com.huobi.finance.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.finance.bean.AddAddrListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import i6.r;
import s9.c;

public class AddAddrListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(AddAddrListItem addAddrListItem, int i11, View view) {
        addAddrListItem.c().b(i11, addAddrListItem);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, AddAddrListItem addAddrListItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        View b11 = e11.b(R$id.id_on_chain_add_addr_item_bg);
        TextView textView = (TextView) e11.b(R$id.id_on_chain_add_addr_item_tv);
        DefiChainInfo d11 = addAddrListItem.d();
        b.c().i((ImageView) e11.b(R$id.id_on_chain_add_addr_item_iv), d11.getSelectIcon(), R$drawable.icon_ask);
        textView.setText(StringUtils.j(d11.getChain(), "--"));
        boolean a11 = addAddrListItem.c().a(i11, addAddrListItem);
        ViewUtil.m((ImageView) e11.b(R$id.id_on_chain_add_addr_item_ok), a11);
        Resources resources = textView.getResources();
        if (a11) {
            b11.setBackgroundResource(R$drawable.on_chain_addr_item_bg_focus);
            textView.setTextColor(resources.getColor(R$color.baseColorMajorTheme100));
        } else {
            b11.setBackgroundResource(R$drawable.on_chain_addr_item_bg);
            textView.setTextColor(resources.getColor(R$color.baseColorPrimaryText));
        }
        b11.setOnClickListener(new bl.c(addAddrListItem, i11));
    }

    public int getResId() {
        return R$layout.layout_on_chain_addr_list_item;
    }
}
