package com.huobi.otc.ui;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.Locale;
import sp.f;
import sp.g;

public class BilateralCouponDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79231b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79232c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f79233d;

    /* renamed from: e  reason: collision with root package name */
    public String f79234e;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        if (!(getActivity() instanceof OtcTradeActivity)) {
            OtcModuleConfig.b().J(getActivity());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.id_dialog_bilateral_coupon_content_close_btn).setOnClickListener(new f(this));
        rVar.b(R$id.id_dialog_bilateral_coupon_btn).setOnClickListener(new g(this));
    }

    public void afterInit() {
        this.f79231b.setText(this.f79234e);
        this.f79233d.setText(String.format(Locale.US, getString(R$string.n_bilateral_coupon_desc), new Object[]{this.f79234e}));
    }

    public int getContentViewResId() {
        return R$layout.dialog_bilateral_coupon;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f79231b = (TextView) rVar.b(R$id.id_dialog_bilateral_coupon_money_tv);
        this.f79232c = (TextView) rVar.b(R$id.id_dialog_bilateral_coupon_unit_tv);
        this.f79233d = (TextView) rVar.b(R$id.id_dialog_bilateral_coupon_content_tv);
    }

    public boolean isTransparent() {
        return false;
    }
}
