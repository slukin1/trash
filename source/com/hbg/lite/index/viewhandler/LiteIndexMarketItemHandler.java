package com.hbg.lite.index.viewhandler;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import cb.d;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.otc.core.bean.MarketMergedInfo;
import com.hbg.lite.R$color;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.index.bean.LiteIndexMarketItem;
import com.hbg.lite.view.OverFlowedTextView;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import g6.b;
import i6.m;
import i6.r;
import s9.c;
import sa.a;

public class LiteIndexMarketItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(LiteIndexMarketItem liteIndexMarketItem, View view) {
        if (liteIndexMarketItem.getCallback() != null) {
            liteIndexMarketItem.getCallback().a(liteIndexMarketItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(LiteIndexMarketItem liteIndexMarketItem, View view) {
        if (liteIndexMarketItem.getCallback() != null) {
            liteIndexMarketItem.getCallback().a(liteIndexMarketItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, LiteIndexMarketItem liteIndexMarketItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        View b11 = e11.b(R$id.id_market_merged_item_content_layout);
        Resources resources = b11.getResources();
        View b12 = e11.b(R$id.divider_view);
        Guideline guideline = (Guideline) e11.b(R$id.guideline);
        ViewUtil.m(b12, liteIndexMarketItem.isShowDivider());
        b11.setBackground(ContextCompat.getDrawable(cVar.itemView.getContext(), R$drawable.lite_index_market_item_shape_bg));
        if (a.h()) {
            guideline.setGuidelinePercent(0.34f);
        } else {
            guideline.setGuidelinePercent(0.38f);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) cVar.itemView.getLayoutParams();
        if (i11 == 0) {
            marginLayoutParams.topMargin = PixelUtils.a(-12.0f);
        } else {
            marginLayoutParams.topMargin = 0;
        }
        cVar.itemView.setLayoutParams(marginLayoutParams);
        MarketMergedInfo marketMergedInfo = liteIndexMarketItem.getMarketMergedInfo();
        ImageView imageView = (ImageView) e11.b(R$id.id_market_merged_item_logo);
        TextView textView = (TextView) e11.b(R$id.id_market_merged_item_title);
        TextView textView2 = (TextView) e11.b(R$id.id_market_merged_item_subtitle);
        OverFlowedTextView overFlowedTextView = (OverFlowedTextView) e11.b(R$id.id_market_merged_item_price);
        TextView textView3 = (TextView) e11.b(R$id.id_market_merged_item_percent);
        TextView textView4 = (TextView) e11.b(R$id.id_trade_btn);
        if (marketMergedInfo != null) {
            b.c().i(imageView, liteIndexMarketItem.getLogoUrl(), R$drawable.shape_logo_default_bg);
            textView.setText(StringUtils.i(liteIndexMarketItem.getShortName()));
            textView2.setText(liteIndexMarketItem.getName());
            String str = "--";
            overFlowedTextView.setText(String.format("%s %s", new Object[]{va.b.n(a.c()), (TextUtils.isEmpty(marketMergedInfo.getPrice()) || OptionsBridge.NULL_VALUE.equalsIgnoreCase(marketMergedInfo.getPrice())) ? str : marketMergedInfo.getPrice()}));
            double h02 = m.h0(marketMergedInfo.getChange());
            if (!TextUtils.isEmpty(marketMergedInfo.getChange()) && !OptionsBridge.NULL_VALUE.equalsIgnoreCase(marketMergedInfo.getChange())) {
                str = marketMergedInfo.getChange();
            }
            if (h02 > 0.0d) {
                textView3.setTextColor(resources.getColor(R$color.base_up_color));
                if (!str.startsWith("+")) {
                    str = "+" + str;
                }
            } else if (h02 < 0.0d) {
                textView3.setTextColor(resources.getColor(R$color.base_down_color));
                if (!str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
                }
            } else {
                textView3.setTextColor(resources.getColor(R$color.baseColorDefaultPlaceholder));
            }
            textView3.setText(str + "%");
        }
        textView4.setOnClickListener(new d(liteIndexMarketItem));
        cVar.itemView.setOnClickListener(new cb.c(liteIndexMarketItem));
    }

    public int getResId() {
        return R$layout.lite_market_merged_item;
    }
}
