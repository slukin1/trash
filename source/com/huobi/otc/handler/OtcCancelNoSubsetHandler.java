package com.huobi.otc.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcCancelReasonDataType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import s9.d;
import v9.c;

public class OtcCancelNoSubsetHandler implements d<OtcCancelReasonDataType> {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcCancelReasonDataType f78721b;

        public a(OtcCancelReasonDataType otcCancelReasonDataType) {
            this.f78721b = otcCancelReasonDataType;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f78721b.getOnReasonClickListener().onClick(this.f78721b, (OtcCancelReasonBean) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(c cVar, int i11, OtcCancelReasonDataType otcCancelReasonDataType, ViewGroup viewGroup) {
        OtcCancelReasonBean dataBean = otcCancelReasonDataType.getDataBean();
        TextView textView = (TextView) cVar.e().b(R$id.tv_title);
        ImageView imageView = (ImageView) cVar.e().b(R$id.iv_check);
        textView.setText(dataBean.getTitle() == null ? "" : dataBean.getTitle());
        textView.setOnClickListener(new a(otcCancelReasonDataType));
        imageView.setImageResource(dataBean.isChecked() ? R$drawable.marquee_selected : R$drawable.marquee_unselected);
        if (d()) {
            cVar.e().b(R$id.view_no_subset_divide).setVisibility(8);
        } else {
            cVar.e().b(R$id.view_no_subset_divide).setVisibility(0);
        }
    }

    /* renamed from: c */
    public void a(c cVar, int i11, OtcCancelReasonDataType otcCancelReasonDataType, ViewGroup viewGroup, List<Object> list) {
    }

    public boolean d() {
        return false;
    }

    public int getResId() {
        return R$layout.item_cancel_no_subset;
    }
}
