package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import bh.j;
import com.alibaba.android.arouter.utils.TextUtils;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.index.bean.HotSymbol;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import gs.g;
import i6.m;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import sn.f;

public class HotSymbolItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, HotSymbol hotSymbol, ViewGroup viewGroup) {
        String str;
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        cVar.itemView.setOnClickListener(this);
        cVar.itemView.setTag(R.id.item_data, hotSymbol);
        cVar.itemView.setTag(R.id.item_data1, Integer.valueOf(i11));
        TextView e12 = e11.e(R.id.item_chart_basecurrency);
        TextView e13 = e11.e(R.id.item_chart_quotecurrency);
        TextView e14 = e11.e(R.id.item_chart_price);
        TextView e15 = e11.e(R.id.item_chart_percent);
        e12.setText(hotSymbol.getBaseCurrencyDisplayName());
        e13.setText("/" + hotSymbol.getQuoteCurrencyDisplayName());
        if (TextUtils.c(hotSymbol.getPrice())) {
            e14.setText("--");
        } else {
            String price = hotSymbol.getPrice();
            e14.setText(m.c(price, price));
        }
        try {
            double doubleValue = Double.valueOf(hotSymbol.getPercent()).doubleValue();
            if (hotSymbol.getPercent() == null) {
                e15.setText("--");
                str = "--";
            } else {
                str = m.Q(String.valueOf(hotSymbol.getPercent()), PrecisionUtil.v((String) null), 1);
                if (Double.compare(doubleValue, 0.0d) > 0) {
                    str = "+" + str;
                }
                e15.setText(str);
            }
            e15.setBackgroundColor(context.getResources().getColor(w.k(str)));
            e15.setText(m.S(doubleValue, 2));
        } catch (Exception unused) {
            e15.setBackgroundColor(w.e());
            e15.setText("--");
        }
        e12.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
        e13.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
        e14.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
        e15.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
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
        HotSymbol hotSymbol = (HotSymbol) view.getTag(R.id.item_data);
        String symbol = hotSymbol.getSymbol();
        if (a1.v().S(a1.v().n(symbol) + "HT")) {
            k0.O(view.getContext(), symbol, true);
        } else if (!TextUtils.c(symbol)) {
            f.C(view.getContext(), symbol, false, TradeType.PRO);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token", hotSymbol.getSymbol());
        hashMap.put("list_type", 5);
        hashMap.put("token_site", Integer.valueOf(Integer.parseInt(view.getTag(R.id.item_data1).toString()) + 1));
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        g.i("toplist_token_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
