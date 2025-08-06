package com.huobi.index.viewhandler;

import al.p;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import bh.j;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.index.bean.RiseRankType;
import com.huobi.index.presenter.g;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import wl.a;

public class FutureDropRankViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        String str;
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        cVar.itemView.setOnClickListener(this);
        g.b c11 = aVar.c();
        cVar.itemView.setTag(R.id.item_data, c11);
        cVar.itemView.setTag(R.id.item_data1, Integer.valueOf(i11));
        TextView e12 = e11.e(R.id.item_chart_basecurrency);
        TextView e13 = e11.e(R.id.item_chart_quotecurrency);
        TextView e14 = e11.e(R.id.item_chart_price);
        TextView e15 = e11.e(R.id.item_chart_percent);
        ImageView c12 = e11.c(R.id.item_chart_coin_icon);
        e14.setText(c11.d(context));
        e12.setText(c11.getTitle());
        ViewUtil.m(e13, !TextUtils.isEmpty(c11.a()));
        e13.setText(c11.a());
        try {
            if (c11.e() == null) {
                e15.setText("--");
                str = "--";
            } else {
                str = m.Q(String.valueOf(c11.e()), PrecisionUtil.v((String) null), 1);
                if (Double.compare(c11.e().doubleValue(), 0.0d) > 0) {
                    str = "+" + str;
                }
                e15.setText(str);
            }
            e15.setBackgroundColor(context.getResources().getColor(w.k(str)));
        } catch (Exception unused) {
            e15.setBackgroundColor(w.e());
            e15.setText("--");
        }
        e14.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
        e15.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
        f6.c.a().f(c12, p.l(c11.c()), p.m());
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
        g.b bVar = (g.b) view.getTag(R.id.item_data);
        try {
            is.a.w("4478", bVar.getTitle());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token", bVar.f());
        hashMap.put("list_type", 6);
        hashMap.put("token_site", Integer.valueOf(Integer.parseInt(view.getTag(R.id.item_data1).toString()) + 1));
        hashMap.put("select_type", RiseRankType.RANK_RISE_TYPE_FUTURE.getCurrency());
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        gs.g.i("toplist_token_click", hashMap);
        MarketModuleConfig.a().t("top_gainers_click", bVar.f());
        View.OnClickListener onItemClickListener = bVar.getOnItemClickListener();
        if (onItemClickListener != null) {
            onItemClickListener.onClick(view);
        }
        MarketModuleConfig.a().t("top_gainers_click", bVar.f());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
