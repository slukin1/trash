package com.huobi.trade.ui;

import android.view.View;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.otc.widget.FAQGestureFrameLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.HashMap;
import jp.k0;
import pro.huobi.R;

public class TradeFiatGuideDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public FAQGestureFrameLayout f82374b;

    /* renamed from: c  reason: collision with root package name */
    public a f82375c;

    public interface a {
        void a();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ah(View view) {
        k0.k(getActivity());
        g.i("APP_Trade_fiat_buy_click", (HashMap) null);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bh(View view) {
        a aVar = this.f82375c;
        if (aVar != null) {
            aVar.a();
        }
        g.i("APP_Trade_fiat_transfer_click", (HashMap) null);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ch(View view) {
        CurrencySearchActivity.jj(getActivity(), "1", 1, true);
        g.i("APP_Trade_fiat_deposit_click", (HashMap) null);
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        dismiss();
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
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Dh(a aVar) {
        this.f82375c = aVar;
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_fiat_guide_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        FAQGestureFrameLayout fAQGestureFrameLayout = (FAQGestureFrameLayout) rVar.b(R.id.dialog_fiat_root_gesture_layout);
        this.f82374b = fAQGestureFrameLayout;
        fAQGestureFrameLayout.setEndRunnable(new o1(this));
        rVar.b(R.id.dialog_fiat_root_layout).setOnClickListener(new n1(this));
        rVar.b(R.id.rl_top).setOnClickListener(new k1(this));
        rVar.b(R.id.dialog_fiat_guide_open_buy_assets).setOnClickListener(new m1(this));
        rVar.b(R.id.dialog_fiat_guide_go_transfer).setOnClickListener(new j1(this));
        rVar.b(R.id.dialog_fiat_guide_go_recharge).setOnClickListener(new l1(this));
    }

    public boolean isTransparent() {
        return false;
    }
}
