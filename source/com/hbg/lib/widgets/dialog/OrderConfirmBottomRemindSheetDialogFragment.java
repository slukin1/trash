package com.hbg.lib.widgets.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$style;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import z9.i1;
import z9.j1;
import z9.k1;

public class OrderConfirmBottomRemindSheetDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f71865b;

    /* renamed from: c  reason: collision with root package name */
    public a f71866c;

    /* renamed from: d  reason: collision with root package name */
    public OrderConfirmBean f71867d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f71868e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71869f;

    public interface a {
        void a(boolean z11, View view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismissAllowingStateLoss();
        a aVar = this.f71866c;
        if (aVar != null) {
            aVar.a(this.f71869f, view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismissAllowingStateLoss();
        View.OnClickListener onClickListener = this.f71865b;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (this.f71866c != null) {
            boolean z11 = !this.f71869f;
            this.f71869f = z11;
            this.f71868e.setChecked(z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static OrderConfirmBottomRemindSheetDialogFragment vh(OrderConfirmBean orderConfirmBean, View.OnClickListener onClickListener, a aVar) {
        OrderConfirmBottomRemindSheetDialogFragment orderConfirmBottomRemindSheetDialogFragment = new OrderConfirmBottomRemindSheetDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(RemoteMessageConst.MessageBody.PARAM, orderConfirmBean);
        orderConfirmBottomRemindSheetDialogFragment.setArguments(bundle);
        orderConfirmBottomRemindSheetDialogFragment.wh(onClickListener);
        orderConfirmBottomRemindSheetDialogFragment.xh(aVar);
        return orderConfirmBottomRemindSheetDialogFragment;
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.dialog_confirm_button).setOnClickListener(new j1(this));
        rVar.b(R$id.dialog_close_button).setOnClickListener(new k1(this));
        rVar.b(R$id.dialog_confirm_not_remind_container).setOnClickListener(new i1(this));
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_order_confirm_bottom_remind_sheet;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        TextView e11 = rVar.e(R$id.dialog_title);
        TextView e12 = rVar.e(R$id.dialog_confirm_button);
        TextView e13 = rVar.e(R$id.dialog_confirm_hint_tv);
        this.f71868e = (CheckBox) rVar.b(R$id.dialog_confirm_cb);
        String title = this.f71867d.getTitle();
        if (!TextUtils.isEmpty(title)) {
            e11.setText(title);
        }
        if (!TextUtils.isEmpty(this.f71867d.getConfirmBtnText())) {
            e12.setText(this.f71867d.getConfirmBtnText());
        }
        if (StringUtils.q(this.f71867d.getHint())) {
            e13.setText(this.f71867d.getHint());
            e13.setVisibility(0);
        }
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) rVar.b(R$id.dialog_content_recyclerview);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (this.f71867d.getList() == null || this.f71867d.getList().size() == 0) {
            easyRecyclerView.setVisibility(8);
            return;
        }
        easyRecyclerView.setVisibility(0);
        easyRecyclerView.setData(this.f71867d.getList());
    }

    public boolean isTransparent() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            OrderConfirmBean orderConfirmBean = (OrderConfirmBean) arguments.getSerializable(RemoteMessageConst.MessageBody.PARAM);
            this.f71867d = orderConfirmBean;
            if (orderConfirmBean != null && orderConfirmBean.getList() != null) {
                for (OrderConfirmBean.ListItem next : this.f71867d.getList()) {
                    next.setUseNewStyle(true);
                    next.setValueExtraColorRes(R$color.base_up_color);
                }
            }
        }
    }

    public final void wh(View.OnClickListener onClickListener) {
        this.f71865b = onClickListener;
    }

    public final void xh(a aVar) {
        this.f71866c = aVar;
    }
}
