package com.huobi.trade.ui;

import android.view.View;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.concurrent.TimeUnit;
import jp.k0;
import pro.huobi.R;

public class TradeFiatGuideTwoDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public a f82376b;

    public interface a {
        void a();

        TradeType b();

        void c();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ah(View view) {
        CurrencySearchActivity.lj(getActivity(), "1", false);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bh(View view) {
        k0.k(getActivity());
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ch(Void voidR) {
        a aVar = this.f82376b;
        if (aVar != null) {
            aVar.c();
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void zh(View view) {
        a aVar = this.f82376b;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Dh(a aVar) {
        this.f82376b = aVar;
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
        rVar.b(R.id.dialog_fiat_root_layout).setOnClickListener(new r1(this));
        rVar.b(R.id.dialog_fiat_guide_close).setOnClickListener(new t1(this));
        rVar.b(R.id.dialog_fiat_guide_transfer).setOnClickListener(new q1(this));
        rVar.b(R.id.dialog_fiat_guide_recharge).setOnClickListener(new s1(this));
        rVar.b(R.id.dialog_fiat_guide_go_buy).setOnClickListener(new p1(this));
        View b11 = rVar.b(R.id.ll_goto_margin);
        a aVar = this.f82376b;
        if (aVar == null || aVar.b() != TradeType.PRO) {
            b11.setVisibility(8);
            return;
        }
        b11.setVisibility(0);
        dw.a.a(rVar.b(R.id.tv_goto_margin)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new u1(this));
    }

    public boolean isTransparent() {
        return false;
    }

    public void setWindowDimAmount(float f11) {
        super.setWindowDimAmount(f11);
    }
}
