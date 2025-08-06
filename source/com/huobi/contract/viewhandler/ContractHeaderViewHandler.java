package com.huobi.contract.viewhandler;

import aj.a;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;

public class ContractHeaderViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        cVar.itemView.getContext();
        View b11 = e11.b(R$id.activity_container);
        b11.setTag(R$id.item_data1, aVar);
        ImageView imageView = (ImageView) e11.b(R$id.activity_iv);
        e11.e(R$id.market_header_partition).setText(aVar.g());
        TextView e12 = e11.e(R$id.tv_activity_name);
        if (!TextUtils.isEmpty(aVar.d())) {
            e12.setText(aVar.d());
            b11.setVisibility(0);
            if (TextUtils.isEmpty(aVar.e())) {
                imageView.setVisibility(8);
                b11.setOnClickListener((View.OnClickListener) null);
                return;
            }
            imageView.setVisibility(0);
            b11.setOnClickListener(this);
            return;
        }
        b11.setVisibility(8);
    }

    public int getResId() {
        return R$layout.item_market_contract_header;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = (a) view.getTag(R$id.item_data1);
        MarketModuleConfig.a().L((Activity) view.getContext(), aVar.e(), aVar.h());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
