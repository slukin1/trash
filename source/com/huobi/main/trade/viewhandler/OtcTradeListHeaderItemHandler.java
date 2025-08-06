package com.huobi.main.trade.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bo.b;
import pro.huobi.R;
import s9.c;

public class OtcTradeListHeaderItemHandler implements c {
    public final int b(b bVar) {
        return bVar.f() ? R.color.trade_dialog_divider_color_night : R.color.trade_dialog_divider_color_light;
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) cVar.e().b(R.id.id_list_item_trade_otc_header_tv);
        textView.setText(bVar.e());
        textView.setTextColor(ContextCompat.getColor(context, bVar.f() ? R.color.global_major_theme100_night : R.color.global_major_theme100_light));
        cVar.e().b(R.id.id_list_item_trade_otc_header_line).setBackgroundColor(ContextCompat.getColor(context, b(bVar)));
        View b11 = cVar.e().b(R.id.v_contest_divider);
        TextView e11 = cVar.e().e(R.id.tv_activity_name);
        b11.setVisibility(8);
        e11.setVisibility(8);
    }

    public int getResId() {
        return R.layout.list_item_trade_otc_header;
    }
}
