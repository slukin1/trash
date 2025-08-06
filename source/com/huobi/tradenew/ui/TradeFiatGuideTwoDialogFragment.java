package com.huobi.tradenew.ui;

import android.view.View;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.tradenew.ui.TradeFiatGuideDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import jp.k0;
import pro.huobi.R;

public class TradeFiatGuideTwoDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TradeFiatGuideDialogFragment.a f83155b;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ah(View view) {
        k0.k(getActivity());
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(View view) {
        TradeFiatGuideDialogFragment.a aVar = this.f83155b;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void zh(View view) {
        CurrencySearchActivity.lj(getActivity(), "1", false);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Bh(TradeFiatGuideDialogFragment.a aVar) {
        this.f83155b = aVar;
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_fiat_guide_two_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.b(R.id.dialog_fiat_root_layout).setOnClickListener(new j1(this));
        rVar.b(R.id.dialog_fiat_guide_close).setOnClickListener(new l1(this));
        rVar.b(R.id.dialog_fiat_guide_transfer).setOnClickListener(new i1(this));
        rVar.b(R.id.dialog_fiat_guide_recharge).setOnClickListener(new m1(this));
        rVar.b(R.id.dialog_fiat_guide_go_buy).setOnClickListener(new k1(this));
    }

    public boolean isTransparent() {
        return false;
    }

    public void setWindowDimAmount(float f11) {
        super.setWindowDimAmount(f11);
    }
}
