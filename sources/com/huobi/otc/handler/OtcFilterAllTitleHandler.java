package com.huobi.otc.handler;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.handler.entity.OtcFilterAllTitleItem;
import java.util.List;
import s9.d;
import v9.c;

public class OtcFilterAllTitleHandler implements d<OtcFilterAllTitleItem> {
    /* renamed from: b */
    public void handleView(c cVar, int i11, OtcFilterAllTitleItem otcFilterAllTitleItem, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.itemView.findViewById(R$id.textview);
        String c11 = otcFilterAllTitleItem.c();
        if (!TextUtils.isEmpty(c11)) {
            textView.setText(c11);
        } else {
            textView.setText(textView.getResources().getString(R$string.n_otc_advert_trade_p2p_filter_all_payMethod));
        }
    }

    /* renamed from: c */
    public void a(c cVar, int i11, OtcFilterAllTitleItem otcFilterAllTitleItem, ViewGroup viewGroup, List<Object> list) {
        TextView textView = (TextView) cVar.itemView.findViewById(R$id.textview);
        String c11 = otcFilterAllTitleItem.c();
        if (!TextUtils.isEmpty(c11)) {
            textView.setText(c11);
        } else {
            textView.setText(textView.getResources().getString(R$string.n_otc_advert_trade_p2p_filter_all_payMethod));
        }
    }

    public int getResId() {
        return R$layout.item_filter_all_title_layout;
    }
}
