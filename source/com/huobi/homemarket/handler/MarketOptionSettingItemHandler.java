package com.huobi.homemarket.handler;

import a7.e;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.homemarket.bean.MarketOptionSettingBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ql.m;
import s9.c;

public class MarketOptionSettingItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(MarketOptionSettingBean marketOptionSettingBean, TextView textView, View view) {
        if (marketOptionSettingBean.getType() == 4) {
            marketOptionSettingBean.setTemporarySelectedState(!marketOptionSettingBean.isTemporarySelectedState());
            textView.setSelected(marketOptionSettingBean.isTemporarySelectedState());
        } else if (!textView.isSelected() && marketOptionSettingBean.getOnClickListener() != null) {
            marketOptionSettingBean.setTemporarySelectedState(true);
            view.setTag(marketOptionSettingBean);
            marketOptionSettingBean.getOnClickListener().onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, MarketOptionSettingBean marketOptionSettingBean, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.checkBox);
        textView.setSelected(marketOptionSettingBean.isTemporarySelectedState());
        if (marketOptionSettingBean.getType() == 2) {
            textView.setText(e.h(marketOptionSettingBean.getContractType(), marketOptionSettingBean.getDeliveryDate()));
        } else if (marketOptionSettingBean.getType() == 4) {
            textView.setText(cVar.itemView.getContext().getString(marketOptionSettingBean.getFieldTitleEnum().getTitleRes()));
        } else {
            textView.setText(marketOptionSettingBean.getName());
        }
        textView.setOnClickListener(new m(marketOptionSettingBean, textView));
    }

    public int getResId() {
        return R$layout.market_option_setting_checkbox_layout;
    }
}
