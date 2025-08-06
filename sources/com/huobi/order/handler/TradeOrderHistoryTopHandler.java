package com.huobi.order.handler;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.order.bean.TradeOrderDetailTopItem;
import i6.r;
import pro.huobi.R;
import s9.c;

public class TradeOrderHistoryTopHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, TradeOrderDetailTopItem tradeOrderDetailTopItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.tv_trade_history_detail_root);
        TextView textView = (TextView) e11.b(R.id.tv_trade_history_detail_top_title);
        TextView textView2 = (TextView) e11.b(R.id.tv_trade_history_detail_top_content);
        textView.setText(tradeOrderDetailTopItem.title);
        textView2.setText(tradeOrderDetailTopItem.content);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, tradeOrderDetailTopItem.titleRightRes, 0);
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, tradeOrderDetailTopItem.contentRightRes, 0);
        textView.setCompoundDrawablePadding(PixelUtils.a(2.0f));
        textView2.setCompoundDrawablePadding(PixelUtils.a(2.0f));
        textView.setOnClickListener(tradeOrderDetailTopItem.titleClickListener);
        textView2.setOnClickListener(tradeOrderDetailTopItem.contentClickListener);
        linearLayout.setGravity((i11 + 1) % 3 == 0 ? 8388613 : 8388611);
    }

    public int getResId() {
        return R.layout.item_trade_history_detail_top;
    }
}
