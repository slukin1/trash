package com.huobi.tradenew.handler;

import android.view.ViewGroup;
import android.widget.TextView;
import i6.r;
import pro.huobi.R;
import s9.c;
import ws.b;

public class MarginBalanceDialogItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((TextView) e11.b(R.id.margin_loan_title_tv)).setText(bVar.d());
        ((TextView) e11.b(R.id.margin_base_currency_tv)).setText(bVar.c());
        ((TextView) e11.b(R.id.margin_quote_currency_tv)).setText(bVar.e());
    }

    public int getResId() {
        return R.layout.item_trade_margin_balance;
    }
}
