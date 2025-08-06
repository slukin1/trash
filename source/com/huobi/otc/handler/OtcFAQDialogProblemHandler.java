package com.huobi.otc.handler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcFAQDialogDataType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import s9.d;

public class OtcFAQDialogProblemHandler implements d<OtcFAQDialogDataType> {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcFAQDialogDataType f78772b;

        public a(OtcFAQDialogDataType otcFAQDialogDataType) {
            this.f78772b = otcFAQDialogDataType;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f78772b.getOnItemClickListener().onClickGreat(this.f78772b, 1);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcFAQDialogDataType f78774b;

        public b(OtcFAQDialogDataType otcFAQDialogDataType) {
            this.f78774b = otcFAQDialogDataType;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f78774b.getOnItemClickListener().onClickGreat(this.f78774b, 2);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcFAQDialogDataType f78776b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f78777c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OtcFAQBean f78778d;

        public c(OtcFAQDialogDataType otcFAQDialogDataType, TextView textView, OtcFAQBean otcFAQBean) {
            this.f78776b = otcFAQDialogDataType;
            this.f78777c = textView;
            this.f78778d = otcFAQBean;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f78776b.getOnItemClickListener().onClickAction(this.f78777c.getContext(), this.f78778d);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OtcFAQDialogDataType otcFAQDialogDataType, ViewGroup viewGroup) {
        OtcFAQBean dataBean = otcFAQDialogDataType.getDataBean();
        ImageView imageView = (ImageView) cVar.e().b(R$id.iv_great);
        ImageView imageView2 = (ImageView) cVar.e().b(R$id.iv_step);
        TextView textView = (TextView) cVar.e().b(R$id.tv_action);
        ((TextView) cVar.e().b(R$id.tv_problem)).setText(dataBean.getTitle());
        ((TextView) cVar.e().b(R$id.tv_answer)).setText(dataBean.getContent());
        imageView.setOnClickListener(new a(otcFAQDialogDataType));
        imageView2.setOnClickListener(new b(otcFAQDialogDataType));
        d(dataBean, imageView, imageView2);
        if (dataBean.getAction() == null || TextUtils.isEmpty(dataBean.getAction().getName()) || TextUtils.isEmpty(dataBean.getAction().getLink())) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(dataBean.getAction().getName());
        textView.setVisibility(0);
        textView.setOnClickListener(new c(otcFAQDialogDataType, textView, dataBean));
    }

    /* renamed from: c */
    public void a(v9.c cVar, int i11, OtcFAQDialogDataType otcFAQDialogDataType, ViewGroup viewGroup, List<Object> list) {
        d(otcFAQDialogDataType.getDataBean(), (ImageView) cVar.e().b(R$id.iv_great), (ImageView) cVar.e().b(R$id.iv_step));
    }

    public final void d(OtcFAQBean otcFAQBean, ImageView imageView, ImageView imageView2) {
        if (otcFAQBean.getLike() == 1) {
            imageView.setSelected(true);
            imageView2.setSelected(false);
        } else if (otcFAQBean.getLike() == 2) {
            imageView.setSelected(false);
            imageView2.setSelected(true);
        } else {
            imageView.setSelected(false);
            imageView2.setSelected(false);
        }
    }

    public int getResId() {
        return R$layout.item_faq_problem_answer_layout;
    }
}
