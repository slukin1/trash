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
import com.huobi.index.bean.NewSymbol;
import com.huobi.statistics.GrowingIOStatics;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.k;
import gs.g;
import i6.m;
import i6.r;
import is.a;
import java.util.HashMap;
import java.util.Locale;
import pro.huobi.R;
import s9.c;
import sn.f;

public class NewSymbolItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, NewSymbol newSymbol, ViewGroup viewGroup) {
        String str;
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        cVar.itemView.setOnClickListener(this);
        cVar.itemView.setTag(R.id.item_data, newSymbol);
        cVar.itemView.setTag(R.id.item_data1, Integer.valueOf(i11));
        TextView e12 = e11.e(R.id.item_chart_basecurrency);
        TextView e13 = e11.e(R.id.item_chart_price);
        TextView e14 = e11.e(R.id.item_chart_percent);
        if (TextUtils.c(newSymbol.getCoin())) {
            e12.setText("");
        } else {
            e12.setText(k.C().z(newSymbol.getCoin()));
        }
        if (TextUtils.c(newSymbol.getPrice())) {
            e13.setText("--");
        } else {
            String price = newSymbol.getPrice();
            e13.setText(m.c(price, price));
        }
        try {
            double doubleValue = Double.valueOf(newSymbol.getPercent()).doubleValue();
            if (newSymbol.getPercent() == null) {
                e14.setText("--");
                str = "--";
            } else {
                str = m.Q(String.valueOf(newSymbol.getPercent()), PrecisionUtil.v((String) null), 1);
                if (Double.compare(doubleValue, 0.0d) > 0) {
                    str = "+" + str;
                }
                e14.setText(str);
            }
            e14.setBackgroundColor(context.getResources().getColor(w.k(str)));
            e14.setText(m.S(doubleValue, 2));
        } catch (Exception unused) {
            e14.setBackgroundColor(w.e());
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
        NewSymbol newSymbol = (NewSymbol) view.getTag(R.id.item_data);
        String str = newSymbol.getCoin().toLowerCase(Locale.US) + "ht";
        if (a1.v().S(str)) {
            k0.O(view.getContext(), str, true);
        } else {
            String K = a1.v().K(newSymbol.getCoin());
            if (!TextUtils.c(K)) {
                f.C(view.getContext(), K, false, TradeType.PRO);
            }
            try {
                a.w("4480", K);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        GrowingIOStatics.e("新币榜");
        HashMap hashMap = new HashMap();
        hashMap.put("token", newSymbol.getCoin());
        hashMap.put("list_type", 4);
        hashMap.put("token_site", Integer.valueOf(Integer.parseInt(view.getTag(R.id.item_data1).toString()) + 1));
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        g.i("toplist_token_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
