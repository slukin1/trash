package com.huobi.homemarket.handler;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.homemarket.bean.OneKeyCollectItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;

public class OneKeyCollectViewHandler implements c {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonCheckBox f72719b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v9.c f72720c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OneKeyCollectItem f72721d;

        public a(CommonCheckBox commonCheckBox, v9.c cVar, OneKeyCollectItem oneKeyCollectItem) {
            this.f72719b = commonCheckBox;
            this.f72720c = cVar;
            this.f72721d = oneKeyCollectItem;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f72719b.toggle();
            this.f72720c.itemView.setSelected(this.f72719b.isChecked());
            this.f72721d.s(this.f72719b.isChecked());
            String c11 = this.f72721d.c();
            if (this.f72719b.isChecked()) {
                OneKeyCollectItem.f72670l.add(c11);
            } else {
                OneKeyCollectItem.f72670l.remove(c11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OneKeyCollectItem oneKeyCollectItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.item_chart_basecurrency_optional);
        TextView textView2 = (TextView) e11.b(R$id.item_chart_quotecurrency_optional);
        TextView textView3 = (TextView) e11.b(R$id.item_chart_percent_optional);
        TextView textView4 = (TextView) e11.b(R$id.item_chart_price_optional);
        CommonCheckBox commonCheckBox = (CommonCheckBox) e11.b(R$id.symbol_check_box);
        Resources resources = cVar.itemView.getContext().getResources();
        String c11 = oneKeyCollectItem.c();
        if (!TextUtils.isEmpty(c11)) {
            textView.setText(c11.toUpperCase());
        }
        textView3.setText(oneKeyCollectItem.i());
        textView3.setTextColor(resources.getColor(oneKeyCollectItem.h()));
        textView4.setText(oneKeyCollectItem.g());
        String quoteCurrency = oneKeyCollectItem.getQuoteCurrency();
        if (!TextUtils.isEmpty(quoteCurrency)) {
            textView2.setText("/" + quoteCurrency.toUpperCase());
        }
        commonCheckBox.setChecked(oneKeyCollectItem.k());
        commonCheckBox.setTag(oneKeyCollectItem);
        cVar.itemView.setSelected(oneKeyCollectItem.k());
        cVar.itemView.setOnClickListener(new a(commonCheckBox, cVar, oneKeyCollectItem));
    }

    public int getResId() {
        return R$layout.item_market_one_key_collect;
    }
}
