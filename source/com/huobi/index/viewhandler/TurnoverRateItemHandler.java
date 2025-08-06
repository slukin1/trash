package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import bh.j;
import com.alibaba.android.arouter.utils.TextUtils;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.index.bean.TurnoverRateItem;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.k;
import i6.m;
import i6.r;
import java.util.Locale;
import pro.huobi.R;
import s9.c;
import sn.f;

public class TurnoverRateItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, TurnoverRateItem turnoverRateItem, ViewGroup viewGroup) {
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        cVar.itemView.setOnClickListener(this);
        cVar.itemView.setTag(R.id.item_data, turnoverRateItem);
        TextView e12 = e11.e(R.id.item_chart_basecurrency);
        TextView e13 = e11.e(R.id.item_chart_price);
        TextView e14 = e11.e(R.id.item_chart_percent);
        if (TextUtils.c(turnoverRateItem.getCoin())) {
            e12.setText("");
        } else {
            e12.setText(k.C().z(turnoverRateItem.getCoin()));
        }
        if (TextUtils.c(turnoverRateItem.getPrice())) {
            e13.setText("--");
        } else {
            String price = turnoverRateItem.getPrice();
            e13.setText(m.c(price, price));
        }
        e14.setBackgroundColor(ContextCompat.getColor(context, R.color.baseColorMajorTheme006));
        e14.setTextColor(ContextCompat.getColor(context, R.color.global_small_area_bg_color));
        try {
            e14.setText(m.M(Double.valueOf(turnoverRateItem.getTurnoverRate()).doubleValue(), 2));
        } catch (NumberFormatException unused) {
            e14.setText("--");
        }
        e12.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
        e13.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
        e14.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
    }

    public int getResId() {
        return R.layout.view_index_framelayout;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!NetworkStatus.c(view.getContext())) {
            HuobiToastUtil.k(j.c(), R.string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        TurnoverRateItem turnoverRateItem = (TurnoverRateItem) view.getTag(R.id.item_data);
        String coin = turnoverRateItem.getCoin();
        StringBuilder sb2 = new StringBuilder();
        String coin2 = turnoverRateItem.getCoin();
        Locale locale = Locale.US;
        sb2.append(coin2.toLowerCase(locale));
        sb2.append("ht");
        String sb3 = sb2.toString();
        if (a1.v().S(sb3)) {
            k0.O(view.getContext(), sb3, true);
        } else if (coin.equals("BTC")) {
            Context context = view.getContext();
            f.C(context, coin.toLowerCase(locale) + "usdt", false, TradeType.PRO);
        } else if (coin.equals("USDT")) {
            f.C(view.getContext(), "btcusdt", false, TradeType.PRO);
        } else {
            Context context2 = view.getContext();
            f.C(context2, coin.toLowerCase(locale) + "btc", false, TradeType.PRO);
        }
        GrowingIOStatics.e("换手率榜");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
