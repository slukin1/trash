package com.huobi.otc.handler;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.LiteSecurityMakerInfoBean;
import s9.c;

public class LiteSecurityMakerInfoHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, LiteSecurityMakerInfoBean liteSecurityMakerInfoBean, ViewGroup viewGroup) {
        ((ImageView) cVar.e().b(R$id.card_icon_iv)).setImageResource(liteSecurityMakerInfoBean.getIconId());
        ((TextView) cVar.e().b(R$id.card_desc_tv)).setText(liteSecurityMakerInfoBean.getSecurityDesc());
        ((LinearLayout) cVar.e().b(R$id.root_view)).setBackgroundResource(R$drawable.bg_lite_security_maker_info_card_shape);
    }

    public int getResId() {
        return R$layout.item_lite_security_card_layout;
    }
}
