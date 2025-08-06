package com.huobi.index.viewhandler;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.index.bean.RankingListData;
import com.huobi.index.countdown.RecommendedCountDownLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import sn.f;
import yl.t;

public class RankingNewSymbolItemHandler implements c, View.OnClickListener {
    @SuppressLint({"SetTextI18n"})
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, RankingListData.NewSymbolItemData newSymbolItemData, ViewGroup viewGroup) {
        if (newSymbolItemData == null) {
            Log.d("RankingNewSymbolItemHandler", "data is null");
            return;
        }
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        cVar.itemView.setOnClickListener(this);
        cVar.itemView.setTag(R.id.item_data, newSymbolItemData);
        cVar.itemView.setTag(R.id.item_data1, Integer.valueOf(i11));
        ImageView c11 = e11.c(R.id.wait_item_chart_coin_icon);
        TextView e12 = e11.e(R.id.wait_item_chart_basecurrency);
        TextView e13 = e11.e(R.id.wait_item_chart_price);
        RecommendedCountDownLayout recommendedCountDownLayout = (RecommendedCountDownLayout) e11.b(R.id.wait_item_new_symbol_count_view);
        e12.setText(newSymbolItemData.getBaseName());
        if (c(context)) {
            f6.c.a().g(c11, newSymbolItemData.getIconURL(), c11.getResources().getDrawable(R.drawable.home_coin_placeholder_24));
        }
        long longValue = newSymbolItemData.getBeginDate().longValue();
        e13.setText(DateTimeUtils.h(longValue, "MM-dd HH:mm"));
        recommendedCountDownLayout.getCountDownManager().t();
        long currentTimeMillis = longValue - System.currentTimeMillis();
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

    public final boolean c(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public int getResId() {
        return R.layout.rank_wait_new_symbol_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!NetworkStatus.c(view.getContext())) {
            HuobiToastUtil.k(j.c(), R.string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        RankingListData.NewSymbolItemData newSymbolItemData = (RankingListData.NewSymbolItemData) view.getTag(R.id.item_data);
        RankScreenBean h11 = t.h();
        String str = "";
        String screenValue = h11 != null ? h11.getScreenValue() : str;
        f.C(view.getContext(), newSymbolItemData.getSymbol(), false, TradeType.PRO);
        HashMap hashMap = new HashMap();
        hashMap.put("token", newSymbolItemData.getBaseName() != null ? newSymbolItemData.getBaseName() : str);
        hashMap.put("list_type", Integer.valueOf(newSymbolItemData.getType()));
        hashMap.put("token_site", Integer.valueOf(Integer.parseInt(view.getTag(R.id.item_data1).toString()) + 1));
        if (t.i()) {
            if (!TextUtils.c(screenValue)) {
                str = screenValue;
            }
            hashMap.put("select_type", str);
        } else {
            hashMap.put("select_type", str);
        }
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        g.i("toplist_token_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
