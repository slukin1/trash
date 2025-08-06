package com.hbg.module.kline.handler;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.bean.IndexIngredient;
import i6.m;
import i6.r;
import java.util.Locale;
import s9.c;

public class MarketInfoIngredientHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, IndexIngredient indexIngredient, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Resources resources = cVar.itemView.getResources();
        TextView textView = (TextView) e11.b(R$id.coin_rise_or_all_pct_text);
        ((TextView) e11.b(R$id.coin_text)).setText(indexIngredient.getName().toUpperCase(Locale.US));
        ((TextView) e11.b(R$id.coin_weight_text)).setText(m.M(indexIngredient.getWeight(), 8));
        ((TextView) e11.b(R$id.coin_last_price_text)).setText(String.valueOf(indexIngredient.getClose()));
        textView.setText(m.S(indexIngredient.getRisePercent(), 2));
        double risePercent = indexIngredient.getRisePercent();
        if (Double.compare(risePercent, 0.0d) > 0) {
            textView.setTextColor(resources.getColor(R$color.color_rise));
        } else if (Double.compare(risePercent, 0.0d) < 0) {
            textView.setTextColor(resources.getColor(R$color.color_down));
        } else {
            textView.setTextColor(resources.getColor(R$color.color_flat));
        }
    }

    public int getResId() {
        return R$layout.item_market_info_ingredient;
    }
}
