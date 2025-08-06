package com.huobi.finance.viewhandler;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.finance.bean.CurrencyIntroBean;
import i6.r;
import pro.huobi.R;
import s9.c;
import wk.p0;

public class CurrencyDetailTradeItemViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, CurrencyIntroBean.TradeItem tradeItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_base_currency);
        TextView textView2 = (TextView) e11.b(R.id.tv_quote_currency);
        TextView textView3 = (TextView) e11.b(R.id.tv_loan_multi);
        TextView textView4 = (TextView) e11.b(R.id.tv_price);
        TextView textView5 = (TextView) e11.b(R.id.tv_rise_rate);
        textView.setText("--");
        textView2.setText("/--");
        textView4.setText("--");
        textView5.setText("--");
        ((TextView) e11.b(R.id.tv_label)).setText(tradeItem.c());
        textView.setText(tradeItem.i());
        textView2.setText(tradeItem.g());
        if (!TextUtils.isEmpty(tradeItem.d())) {
            ViewUtil.m(textView3, true);
            textView3.setText(String.format("%sX", new Object[]{tradeItem.d()}));
        } else {
            ViewUtil.m(textView3, false);
        }
        SymbolPrice symbolPrice = tradeItem.getSymbolPrice();
        if (symbolPrice != null) {
            if (tradeItem.f() >= 0) {
                textView4.setText(p0.f(symbolPrice, tradeItem.f()));
            } else {
                textView4.setText(p0.e(symbolPrice));
            }
            p0.j(textView5, symbolPrice);
        }
        cVar.itemView.setOnClickListener(tradeItem.e());
    }

    public int getResId() {
        return R.layout.item_currency_detail_market_item;
    }
}
