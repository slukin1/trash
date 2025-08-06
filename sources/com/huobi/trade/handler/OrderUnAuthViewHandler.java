package com.huobi.trade.handler;

import android.view.ViewGroup;
import android.widget.TextView;
import pro.huobi.R;
import s9.c;
import ws.d;

public class OrderUnAuthViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, d dVar, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R.id.order_unauth_hint);
        int a11 = dVar.a();
        if (a11 == 0) {
            textView.setText(R.string.order_empty_hint);
        } else if (a11 == 1) {
            textView.setText(R.string.order_empty_hint);
        } else if (a11 == 2) {
            textView.setText(R.string.order_empty_hint);
        }
    }

    public int getResId() {
        return R.layout.item_order_unauth;
    }
}
