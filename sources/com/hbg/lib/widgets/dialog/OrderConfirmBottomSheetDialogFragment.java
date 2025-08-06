package com.hbg.lib.widgets.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import z9.l1;
import z9.m1;
import z9.n1;

public class OrderConfirmBottomSheetDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public a f71870b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f71871c;

    /* renamed from: d  reason: collision with root package name */
    public OrderConfirmBean f71872d;

    /* renamed from: e  reason: collision with root package name */
    public CommonCheckBox f71873e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71874f;

    public interface a {
        void a(boolean z11, View view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismissAllowingStateLoss();
        a aVar = this.f71870b;
        if (aVar != null) {
            aVar.a(this.f71874f, view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        dismissAllowingStateLoss();
        View.OnClickListener onClickListener = this.f71871c;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        boolean z11 = !this.f71874f;
        this.f71874f = z11;
        this.f71873e.setChecked(z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static OrderConfirmBottomSheetDialogFragment vh(OrderConfirmBean orderConfirmBean, a aVar, View.OnClickListener onClickListener) {
        OrderConfirmBottomSheetDialogFragment orderConfirmBottomSheetDialogFragment = new OrderConfirmBottomSheetDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(RemoteMessageConst.MessageBody.PARAM, orderConfirmBean);
        orderConfirmBottomSheetDialogFragment.setArguments(bundle);
        orderConfirmBottomSheetDialogFragment.xh(aVar);
        orderConfirmBottomSheetDialogFragment.wh(onClickListener);
        return orderConfirmBottomSheetDialogFragment;
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.dialog_confirm_button).setOnClickListener(new l1(this));
        rVar.b(R$id.iv_close).setOnClickListener(new n1(this));
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.dialog_order_confirm_bottom_sheet;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        TextView e11 = rVar.e(R$id.dialog_title);
        TextView e12 = rVar.e(R$id.dialog_confirm_button);
        TextView e13 = rVar.e(R$id.dialog_hint_text);
        this.f71873e = (CommonCheckBox) rVar.b(R$id.id_checkbox);
        String title = this.f71872d.getTitle();
        if (!TextUtils.isEmpty(title)) {
            e11.setText(title);
        }
        if (!TextUtils.isEmpty(this.f71872d.getConfirmBtnText())) {
            e12.setText(this.f71872d.getConfirmBtnText());
        }
        if (StringUtils.q(this.f71872d.getHint())) {
            e13.setText(this.f71872d.getHint());
            e13.setVisibility(0);
        }
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) rVar.b(R$id.dialog_content_recyclerview);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (this.f71872d.getList() == null || this.f71872d.getList().size() == 0) {
            easyRecyclerView.setVisibility(8);
        } else {
            easyRecyclerView.setVisibility(0);
            easyRecyclerView.setData(this.f71872d.getList());
        }
        rVar.b(R$id.dialog_confirm_not_remind_container).setOnClickListener(new m1(this));
    }

    public boolean isTransparent() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            OrderConfirmBean orderConfirmBean = (OrderConfirmBean) arguments.getSerializable(RemoteMessageConst.MessageBody.PARAM);
            this.f71872d = orderConfirmBean;
            if (orderConfirmBean != null && orderConfirmBean.getList() != null) {
                for (OrderConfirmBean.ListItem next : this.f71872d.getList()) {
                    next.setUseNewStyle(true);
                    next.setValueExtraColorRes(R$color.base_up_color);
                }
            }
        }
    }

    public final void wh(View.OnClickListener onClickListener) {
        this.f71871c = onClickListener;
    }

    public final void xh(a aVar) {
        this.f71870b = aVar;
    }
}
