package com.huobi.index.viewhandler;

import al.p;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import bh.j;
import com.alibaba.android.arouter.utils.TextUtils;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankListItemBean;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.index.bean.RankDynamicItem;
import com.huobi.index.countdown.RecommendedCountDownLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import gs.g;
import i6.r;
import java.util.HashMap;
import java.util.Locale;
import pro.huobi.R;
import s9.c;
import sn.f;
import yl.t;

public class RankNewSymbolItemHandler implements c, View.OnClickListener {
    @SuppressLint({"SetTextI18n"})
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, RankDynamicItem rankDynamicItem, ViewGroup viewGroup) {
        if (rankDynamicItem == null) {
            Log.d("RankNewSymbolItemHandler", "data is null");
            return;
        }
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        cVar.itemView.setOnClickListener(this);
        cVar.itemView.setTag(R.id.item_data, rankDynamicItem);
        cVar.itemView.setTag(R.id.item_data1, Integer.valueOf(i11));
        ImageView c11 = e11.c(R.id.item_chart_coin_icon);
        TextView e12 = e11.e(R.id.item_chart_basecurrency);
        TextView e13 = e11.e(R.id.item_chart_price);
        RecommendedCountDownLayout recommendedCountDownLayout = (RecommendedCountDownLayout) e11.b(R.id.item_new_symbol_count_view);
        e12.setText(rankDynamicItem.getBaseCurrencyDisplayName());
        if (rankDynamicItem.g() != null) {
            f6.c.a().f(c11, p.l(""), p.m());
            long beginTradeDate = rankDynamicItem.g().getBeginTradeDate();
            e13.setText(DateTimeUtils.h(beginTradeDate, "MM-dd HH:mm"));
            recommendedCountDownLayout.getCountDownManager().t();
            long currentTimeMillis = beginTradeDate - System.currentTimeMillis();
            recommendedCountDownLayout.getCountDownManager().u(i11, currentTimeMillis, true);
            if (currentTimeMillis < Period.DAY_MILLS) {
                recommendedCountDownLayout.setDayInVisible(false);
            } else {
                recommendedCountDownLayout.setDayInVisible(true);
            }
            recommendedCountDownLayout.setValid(true);
            recommendedCountDownLayout.setVisibility(0);
            e12.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            e13.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            e12.setTextSize(1, 14.0f);
        }
    }

    public int getResId() {
        return R.layout.index_rank_new_symbol_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        String str;
        String str2;
        if (!NetworkStatus.c(view.getContext())) {
            HuobiToastUtil.k(j.c(), R.string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        RankDynamicItem rankDynamicItem = (RankDynamicItem) view.getTag(R.id.item_data);
        RankListItemBean g11 = rankDynamicItem.g();
        if (rankDynamicItem.l()) {
            g11.getSymbol();
            str = g11.getBaseCurrency();
            str2 = g11.getSymbol();
        } else {
            g11.getCurrency().toLowerCase(Locale.US);
            str = g11.getCurrency();
            str2 = a1.v().K(str);
        }
        RankScreenBean h11 = t.h();
        String str3 = "";
        String screenValue = h11 != null ? h11.getScreenValue() : str3;
        f.C(view.getContext(), str2, false, TradeType.PRO);
        HashMap hashMap = new HashMap();
        if (rankDynamicItem.l()) {
            if (str2 == null) {
                str2 = str3;
            }
            hashMap.put("token", str2);
        } else {
            if (str == null) {
                str = str3;
            }
            hashMap.put("token", str);
        }
        hashMap.put("list_type", Integer.valueOf(rankDynamicItem.i()));
        hashMap.put("token_site", Integer.valueOf(Integer.parseInt(view.getTag(R.id.item_data1).toString()) + 1));
        if (t.i()) {
            if (!TextUtils.c(screenValue)) {
                str3 = screenValue;
            }
            hashMap.put("select_type", str3);
        } else {
            hashMap.put("select_type", str3);
        }
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        g.i("toplist_token_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
