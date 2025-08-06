package com.hbg.lib.widgets.dialog.viewhander;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import i6.r;
import s9.c;

public class OrderConfirmTpSlItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OrderConfirmBean.ListItem listItem, ViewGroup viewGroup) {
        if (cVar != null && listItem != null && (listItem instanceof OrderConfirmBean.TpSlItem)) {
            OrderConfirmBean.TpSlItem tpSlItem = (OrderConfirmBean.TpSlItem) listItem;
            r e11 = cVar.e();
            TextView e12 = e11.e(R$id.trigger_price_title);
            TextView e13 = e11.e(R$id.trigger_price_value);
            TextView e14 = e11.e(R$id.entrust_price_title);
            TextView e15 = e11.e(R$id.entrust_price_value);
            cVar.itemView.setBackgroundResource(tpSlItem.getItemBgDrawableRes());
            int textColorRes = tpSlItem.getTextColorRes();
            if (textColorRes > 0) {
                int color = cVar.itemView.getContext().getResources().getColor(textColorRes);
                e12.setTextColor(color);
                e13.setTextColor(color);
                e14.setTextColor(color);
                e15.setTextColor(color);
            }
            e12.setText(tpSlItem.getTriggerPriceTitle());
            e13.setText(tpSlItem.getTriggerPrice());
            e14.setText(tpSlItem.getEntrustPriceTitle());
            e15.setText(tpSlItem.getEntrustPrice());
        }
    }

    public int getResId() {
        return R$layout.item_order_confirm_dialog_tp_sl;
    }
}
