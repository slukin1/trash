package com.huobi.main.trade.viewhandler;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huobi.main.trade.bean.SafeguardDrawerItem;
import i6.r;
import pro.huobi.R;
import s9.c;

public class SafeguardDrawerItemHandler implements c {
    public final int b(SafeguardDrawerItem safeguardDrawerItem) {
        return safeguardDrawerItem.f() ? R.color.trade_dialog_primary_color_night : R.color.trade_dialog_primary_color_light;
    }

    public final int c(SafeguardDrawerItem safeguardDrawerItem) {
        return safeguardDrawerItem.f() ? R.drawable.trade_liquidating_night : R.drawable.trade_liquidating_light;
    }

    public final int d(SafeguardDrawerItem safeguardDrawerItem) {
        return safeguardDrawerItem.f() ? R.color.trade_dialog_tab_text_color_night : R.color.trade_dialog_tab_text_color_light;
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, SafeguardDrawerItem safeguardDrawerItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        ((ImageView) e11.b(R.id.maintenance_iv)).setImageResource(c(safeguardDrawerItem));
        TextView textView = (TextView) e11.b(R.id.contract_safeguard_tv);
        TextView textView2 = (TextView) e11.b(R.id.swap_safeguard_tv);
        ((TextView) e11.b(R.id.safeguard_default_tv)).setTextColor(ContextCompat.getColor(context, b(safeguardDrawerItem)));
        textView.setText(safeguardDrawerItem.c());
        textView.setTextColor(ContextCompat.getColor(context, d(safeguardDrawerItem)));
        if (TextUtils.isEmpty(safeguardDrawerItem.c())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        textView2.setText(safeguardDrawerItem.e());
        textView2.setTextColor(ContextCompat.getColor(context, d(safeguardDrawerItem)));
        if (TextUtils.isEmpty(safeguardDrawerItem.e())) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
        }
    }

    public int getResId() {
        return R.layout.item_safegurd_drawer;
    }
}
