package com.huobi.trade.handler;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.hbg.lib.core.R$string;
import com.huobi.trade.bean.OrderEmptyItem;
import s9.c;

public class OrderEmptyViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OrderEmptyItem orderEmptyItem, ViewGroup viewGroup) {
        String str;
        TextView textView = (TextView) cVar.e().b(R$id.tv_order_empty);
        Resources resources = textView.getContext().getResources();
        if (orderEmptyItem.a()) {
            str = resources.getString(R$string.n_contract_trade_no_record);
        } else {
            str = resources.getString(R$string.trade_no_record);
        }
        textView.setText(str);
    }

    public int getResId() {
        return R$layout.item_trade_order_empty;
    }
}
