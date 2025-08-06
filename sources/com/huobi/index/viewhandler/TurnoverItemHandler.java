package com.huobi.index.viewhandler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import bh.j;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.index.bean.TurnoverItem;
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

public class TurnoverItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, TurnoverItem turnoverItem, ViewGroup viewGroup) {
        String str;
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        cVar.itemView.setOnClickListener(this);
        cVar.itemView.setTag(R.id.item_data, turnoverItem);
        TextView e12 = e11.e(R.id.item_chart_basecurrency);
        TextView e13 = e11.e(R.id.item_chart_price);
        TextView e14 = e11.e(R.id.item_chart_percent);
        if (TextUtils.isEmpty(turnoverItem.getCoin())) {
            e12.setText("");
        } else {
            e12.setText(k.C().z(turnoverItem.getCoin()));
        }
        if (TextUtils.isEmpty(turnoverItem.getPrice())) {
            e13.setText("--");
        } else {
            String price = turnoverItem.getPrice();
            e13.setText(m.c(price, price));
        }
        e14.setBackgroundColor(ContextCompat.getColor(context, R.color.baseColorMajorTheme006));
        e14.setTextColor(ContextCompat.getColor(context, R.color.global_small_area_bg_color));
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            str = m.g(turnoverItem.getLegalCurrencyVolume());
        } else {
            str = m.X(turnoverItem.getLegalCurrencyVolume());
        }
        e14.setText(str);
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
        TurnoverItem turnoverItem = (TurnoverItem) view.getTag(R.id.item_data);
        String coin = turnoverItem.getCoin();
        String str = coin.toLowerCase(Locale.US) + "ht";
        if (a1.v().S(str)) {
            k0.O(view.getContext(), str, true);
        } else if (!TextUtils.isEmpty(turnoverItem.getSymbolName())) {
            f.C(view.getContext(), turnoverItem.getSymbolName(), false, TradeType.PRO);
            try {
                a.w("4479", turnoverItem.getSymbolName());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        GrowingIOStatics.e("成交额榜");
        HashMap hashMap = new HashMap();
        hashMap.put("tradepair_name", turnoverItem.getSymbolName());
        g.i("vol_leaders_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
