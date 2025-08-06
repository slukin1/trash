package com.huobi.index.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.view.roundimg.RoundedImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import i6.r;
import pro.huobi.R;
import s9.c;
import yl.o;

public class IndexBearItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(v9.c cVar, IndexFeatureItem indexFeatureItem, View view) {
        if (cVar.itemView.getContext() instanceof HuobiMainActivity) {
            o.p((HuobiMainActivity) cVar.itemView.getContext(), indexFeatureItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, IndexFeatureItem indexFeatureItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        RoundedImageView roundedImageView = (RoundedImageView) e11.b(R.id.bear_image);
        TextView textView = (TextView) e11.b(R.id.bear_title_text);
        TextView textView2 = (TextView) e11.b(R.id.bear_title_desc_text);
        ImageView imageView = (ImageView) e11.b(R.id.bear_dot_image);
        ImageView imageView2 = (ImageView) e11.b(R.id.default_image);
        if (!TextUtils.isEmpty(indexFeatureItem.getImgUrl())) {
            b.c().h(roundedImageView, indexFeatureItem.getImgUrl());
            imageView2.setVisibility(8);
        } else {
            roundedImageView.setImageResource(R.drawable.bear_default_background);
            imageView2.setVisibility(0);
        }
        if (!TextUtils.isEmpty(indexFeatureItem.getSubUrl())) {
            imageView.setVisibility(0);
            b.c().h(imageView, indexFeatureItem.getSubUrl());
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(indexFeatureItem.getTitle());
        if (TextUtils.isEmpty(indexFeatureItem.getIntroduction())) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(indexFeatureItem.getIntroduction());
        }
        e11.b(R.id.bear_layout).setOnClickListener(new a(cVar, indexFeatureItem));
    }

    public int getResId() {
        return R.layout.layout_index_bear_item;
    }
}
