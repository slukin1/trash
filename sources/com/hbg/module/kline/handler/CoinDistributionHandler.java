package com.hbg.module.kline.handler;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.bean.CoinDistributionItem;
import i6.r;
import s9.c;

public class CoinDistributionHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, CoinDistributionItem coinDistributionItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.tv_coin_distribution_name);
        TextView textView2 = (TextView) e11.b(R$id.tv_coin_distribution_percent);
        TextView textView3 = (TextView) e11.b(R$id.tv_coin_distribution_time);
        if (!TextUtils.isEmpty(coinDistributionItem.getName())) {
            textView.setText(coinDistributionItem.getName());
        }
        if (!TextUtils.isEmpty(coinDistributionItem.getPercent())) {
            textView2.setText(coinDistributionItem.getPercent());
        }
        if (!TextUtils.isEmpty(coinDistributionItem.getTime())) {
            textView3.setText(coinDistributionItem.getTime());
        }
        cVar.itemView.setBackgroundColor(coinDistributionItem.getBackground());
    }

    public int getResId() {
        return R$layout.layout_coin_distribution_item;
    }
}
