package com.hbg.lib.widgets.dialog.viewhander;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import v9.c;

public class OrderConfirmListItemHandlerNew extends OrderConfirmListItemHandler {
    /* renamed from: e */
    public void handleView(c cVar, int i11, OrderConfirmBean.ListItem listItem, ViewGroup viewGroup) {
        super.handleView(cVar, i11, listItem, viewGroup);
        TextView textView = (TextView) cVar.e().b(R$id.tv_value);
        if (listItem.getValueColor() != 0) {
            textView.setTextColor(listItem.getValueColor());
        }
    }

    public int getResId() {
        return R$layout.item_order_confirm_dialog_list_new;
    }
}
