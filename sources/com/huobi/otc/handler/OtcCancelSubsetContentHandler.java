package com.huobi.otc.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcCancelReasonDataType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import v9.c;

public class OtcCancelSubsetContentHandler extends OtcCancelNoSubsetHandler {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcCancelReasonDataType f78723b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OtcCancelReasonBean f78724c;

        public a(OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean) {
            this.f78723b = otcCancelReasonDataType;
            this.f78724c = otcCancelReasonBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f78723b.getOnReasonClickListener().onClick(this.f78724c.getAction());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(c cVar, int i11, OtcCancelReasonDataType otcCancelReasonDataType, ViewGroup viewGroup) {
        super.handleView(cVar, i11, otcCancelReasonDataType, viewGroup);
        OtcCancelReasonBean dataBean = otcCancelReasonDataType.getDataBean();
        View b11 = cVar.e().b(R$id.cl_content);
        TextView textView = (TextView) cVar.e().b(R$id.tv_action);
        ((TextView) cVar.e().b(R$id.tv_content)).setText(dataBean.getContent());
        b11.setVisibility(dataBean.isChecked() ? 0 : 8);
        if (!dataBean.isChecked() || dataBean.getAction() == null) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(dataBean.getAction().getName());
        textView.setOnClickListener(new a(otcCancelReasonDataType, dataBean));
    }

    public boolean d() {
        return true;
    }

    public int getResId() {
        return R$layout.item_cancel_subset_content;
    }
}
