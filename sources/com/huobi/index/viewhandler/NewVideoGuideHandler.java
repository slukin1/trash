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

public class NewVideoGuideHandler implements c {
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
        RoundedImageView roundedImageView = (RoundedImageView) e11.b(R.id.index_video_guide_iv);
        TextView textView = (TextView) e11.b(R.id.index_video_guide_dec);
        ImageView imageView = (ImageView) e11.b(R.id.index_image_dot);
        if (!TextUtils.isEmpty(indexFeatureItem.getImgUrl())) {
            b.c().i(roundedImageView, indexFeatureItem.getImgUrl(), R.drawable.homepage_guide_empty);
        } else {
            roundedImageView.setImageResource(R.drawable.homepage_guide_empty);
        }
        if (!TextUtils.isEmpty(indexFeatureItem.getSubUrl())) {
            imageView.setVisibility(0);
            b.c().h(imageView, indexFeatureItem.getSubUrl());
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(indexFeatureItem.getTitle());
        cVar.itemView.setOnClickListener(new t(cVar, indexFeatureItem));
    }

    public int getResId() {
        return R.layout.index_item_video_guide_layout;
    }
}
