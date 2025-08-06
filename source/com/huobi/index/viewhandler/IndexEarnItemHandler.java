package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;
import com.huobi.index.bean.IndexEarnItem;
import com.huobi.index.bean.IndexFeatureItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import gs.g;
import i6.m;
import i6.r;
import java.util.HashMap;
import pro.huobi.R;
import s9.c;
import yl.o;

public class IndexEarnItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(IndexEarnItem indexEarnItem, Context context, int i11, View view) {
        IndexFeatureItem E = o.E(indexEarnItem.data.url);
        if (E != null && (context instanceof FragmentActivity)) {
            o.p((FragmentActivity) context, E);
        }
        HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo = indexEarnItem.data;
        if (indexAreaContentItemVo != null) {
            boolean z11 = indexAreaContentItemVo.coupon != null;
            HashMap hashMap = new HashMap();
            hashMap.put("earn_site", Integer.valueOf(i11 + 1));
            hashMap.put("earn_id", Integer.valueOf(E.f73183id));
            hashMap.put("token", indexEarnItem.data.currency);
            hashMap.put("is_rate", Boolean.valueOf(z11));
            hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
            g.i("homeEarn_item_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, IndexEarnItem indexEarnItem, ViewGroup viewGroup) {
        v9.c cVar2 = cVar;
        IndexEarnItem indexEarnItem2 = indexEarnItem;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        View b11 = e11.b(R.id.item_earn_item_layout);
        View b12 = e11.b(R.id.ll_coupon);
        View b13 = e11.b(R.id.home_earn_rate_rectangle);
        ImageView imageView = (ImageView) e11.b(R.id.item_earn_item_icon);
        TextView textView = (TextView) e11.b(R.id.item_earn_item_title);
        TextView textView2 = (TextView) e11.b(R.id.item_earn_item_refer);
        TextView textView3 = (TextView) e11.b(R.id.item_earn_item_time);
        TextView textView4 = (TextView) e11.b(R.id.item_earn_item_time_day);
        if (indexEarnItem.isShowItemTopIconView()) {
            b11.setPadding(0, PixelUtils.a(16.0f), 0, PixelUtils.a(12.0f));
            b12.setVisibility(0);
            b13.setVisibility(0);
            String string = context.getString(R.string.n_coupon_type_saving);
            String valueOf = String.valueOf(indexEarnItem2.data.coupon.addRate);
            ((TextView) e11.b(R.id.item_earn_item_top_icon_layout_text)).setText(string + " + " + m.Q(valueOf, 2, 1));
        } else {
            b11.setPadding(0, PixelUtils.a(12.0f), 0, PixelUtils.a(12.0f));
            b12.setVisibility(8);
            b13.setVisibility(8);
        }
        b.c().h(imageView, indexEarnItem.getIconUrl());
        textView.setText(indexEarnItem.getTitle());
        textView2.setText(m.Q(indexEarnItem.getRefer(), 2, 1));
        if (w.l()) {
            textView2.setTextColor(ContextCompat.getColor(context, R.color.baseColorShadeButtonRedStart));
        } else {
            textView2.setTextColor(ContextCompat.getColor(context, R.color.baseColorShadeButtonGreenStart));
        }
        if (indexEarnItem.getTerm() > 0) {
            textView3.setText(indexEarnItem.getTerm() + "");
            textView3.setVisibility(0);
            textView4.setText(context.getString(R.string.n_index_earn_unit_days));
        } else {
            textView3.setVisibility(8);
            textView4.setText(context.getString(R.string.n_index_earn_flexible));
        }
        cVar2.itemView.setOnClickListener(new e(indexEarnItem2, context, i11));
    }

    public int getResId() {
        return R.layout.layout_index_earn_item;
    }
}
