package com.huobi.otc.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcFAQDataType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import s9.d;
import v9.c;

public class OtcFAQHandler implements d<OtcFAQDataType> {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcFAQDataType f78780b;

        public a(OtcFAQDataType otcFAQDataType) {
            this.f78780b = otcFAQDataType;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            OtcFAQDataType.OnItemClickListener onItemClickListener = this.f78780b.getOnItemClickListener();
            if (onItemClickListener != null) {
                onItemClickListener.onClick(this.f78780b);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(c cVar, int i11, OtcFAQDataType otcFAQDataType, ViewGroup viewGroup) {
        OtcFAQBean dataBean = otcFAQDataType.getDataBean();
        ((TextView) cVar.e().b(R$id.tv_title)).setText(dataBean.getTitle());
        cVar.e().b(R$id.cl_root).setOnClickListener(new a(otcFAQDataType));
        if (dataBean.isLast()) {
            cVar.e().b(R$id.view_faq_divide).setVisibility(8);
        } else {
            cVar.e().b(R$id.view_faq_divide).setVisibility(0);
        }
    }

    /* renamed from: c */
    public void a(c cVar, int i11, OtcFAQDataType otcFAQDataType, ViewGroup viewGroup, List<Object> list) {
    }

    public int getResId() {
        return R$layout.item_faq_layout;
    }
}
