package com.huobi.view.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.huobi.view.bean.SelectorBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gu.a;
import s9.b;
import s9.c;

public class SelectorItemHandler implements c {
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$handleView$0(SelectorBean selectorBean, View view) {
        selectorBean.setSelected(true);
        view.setTag(selectorBean);
        if (selectorBean.getOnClickListener() != null) {
            selectorBean.getOnClickListener().onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R$layout.item_selector_checkbox_layout;
    }

    public /* bridge */ /* synthetic */ View getView() {
        return b.a(this);
    }

    public void handleView(v9.c cVar, int i11, SelectorBean selectorBean, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.checkBox);
        textView.setSelected(selectorBean.isSelected());
        textView.setText(selectorBean.getName());
        textView.setOnClickListener(new a(selectorBean));
    }
}
