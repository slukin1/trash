package com.huobi.main.trade.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huobi.main.trade.bean.SingleSafeguardDrawerItem;
import i6.r;
import pro.huobi.R;
import s9.c;

public class SingleSafeguardDrawerItemHandler implements c {
    public final int b(SingleSafeguardDrawerItem singleSafeguardDrawerItem) {
        return singleSafeguardDrawerItem.e() ? R.color.trade_dialog_divider_color_night : R.color.trade_dialog_divider_color_light;
    }

    public final int c(SingleSafeguardDrawerItem singleSafeguardDrawerItem) {
        return singleSafeguardDrawerItem.e() ? R.color.trade_dialog_item_click_color_night : R.color.trade_dialog_item_click_color_light;
    }

    public final int d(SingleSafeguardDrawerItem singleSafeguardDrawerItem) {
        return singleSafeguardDrawerItem.e() ? R.color.trade_dialog_tab_text_color_night : R.color.trade_dialog_tab_text_color_light;
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, SingleSafeguardDrawerItem singleSafeguardDrawerItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R.id.safeguard_tv);
        View b11 = e11.b(R.id.single_safeguard_top_divider);
        View b12 = e11.b(R.id.single_safeguard_bottom_divider);
        textView.setText(singleSafeguardDrawerItem.c());
        textView.setTextColor(ContextCompat.getColor(context, d(singleSafeguardDrawerItem)));
        textView.setBackground(ContextCompat.getDrawable(context, c(singleSafeguardDrawerItem)));
        b11.setBackground(ContextCompat.getDrawable(context, b(singleSafeguardDrawerItem)));
        b12.setBackground(ContextCompat.getDrawable(context, b(singleSafeguardDrawerItem)));
    }

    public int getResId() {
        return R.layout.item_single_safegurd_drawer;
    }
}
