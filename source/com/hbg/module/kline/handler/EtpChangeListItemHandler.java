package com.hbg.module.kline.handler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.EtpRiskInfo;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import i6.r;
import s9.c;
import ud.a;

public class EtpChangeListItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.id_market_info_etp_change_item_title);
        TextView textView2 = (TextView) e11.b(R$id.id_market_info_etp_change_item_desc);
        EtpRiskInfo c11 = aVar.c();
        if (c11 != null) {
            textView.setText(c11.getTitle());
            textView2.setText(c11.getContent());
        }
    }

    public int getResId() {
        return R$layout.layout_market_info_etp_change_list_item;
    }
}
