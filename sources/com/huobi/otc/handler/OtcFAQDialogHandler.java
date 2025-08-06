package com.huobi.otc.handler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcFAQDialogDataType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import s9.d;
import v9.c;

public class OtcFAQDialogHandler implements d<OtcFAQDialogDataType> {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcFAQDialogDataType f78767b;

        public a(OtcFAQDialogDataType otcFAQDialogDataType) {
            this.f78767b = otcFAQDialogDataType;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f78767b.getOnItemClickListener().onChangeClick(this.f78767b);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcFAQDialogDataType f78769b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ OtcFAQBean f78770c;

        public b(OtcFAQDialogDataType otcFAQDialogDataType, OtcFAQBean otcFAQBean) {
            this.f78769b = otcFAQDialogDataType;
            this.f78770c = otcFAQBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f78769b.getOnItemClickListener().onClick(this.f78769b, this.f78770c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(c cVar, int i11, OtcFAQDialogDataType otcFAQDialogDataType, ViewGroup viewGroup) {
        OtcFAQBean dataBean = otcFAQDialogDataType.getDataBean();
        View b11 = cVar.e().b(R$id.cl_change);
        View b12 = cVar.e().b(R$id.tv_bottom_change);
        LinearLayout linearLayout = (LinearLayout) cVar.e().b(R$id.ll_problem);
        if (dataBean.getSubset().size() > 10) {
            b11.setVisibility(0);
            b12.setOnClickListener(new a(otcFAQDialogDataType));
        } else {
            b11.setVisibility(8);
        }
        d(otcFAQDialogDataType, linearLayout);
    }

    /* renamed from: c */
    public void a(c cVar, int i11, OtcFAQDialogDataType otcFAQDialogDataType, ViewGroup viewGroup, List<Object> list) {
        d(otcFAQDialogDataType, (LinearLayout) cVar.e().b(R$id.ll_problem));
    }

    public final void d(OtcFAQDialogDataType otcFAQDialogDataType, LinearLayout linearLayout) {
        OtcFAQBean dataBean = otcFAQDialogDataType.getDataBean();
        List<OtcFAQBean> subset = dataBean.getSubset();
        int i11 = 10;
        int pageSize = dataBean.getPageSize() * 10;
        int i12 = pageSize + 10;
        int size = subset.size();
        if (pageSize > size) {
            pageSize = 0;
        } else {
            i11 = i12;
        }
        if (i11 <= size) {
            size = i11;
        }
        int i13 = size - pageSize;
        while (linearLayout.getChildCount() < i13) {
            linearLayout.addView((TextView) View.inflate(linearLayout.getContext(), R$layout.dialog_faq_item_problem_layout, (ViewGroup) null), new ViewGroup.LayoutParams(-2, -2));
        }
        int childCount = linearLayout.getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            TextView textView = (TextView) linearLayout.getChildAt(i14);
            if (i14 < i13) {
                textView.setVisibility(0);
                OtcFAQBean otcFAQBean = subset.get(pageSize + i14);
                textView.setText(otcFAQBean.getTitle());
                textView.setOnClickListener(new b(otcFAQDialogDataType, otcFAQBean));
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public int getResId() {
        return R$layout.item_faq_dialog_all_layout;
    }
}
