package com.huobi.quicktrade.result.ui;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import c6.a;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.quicktrade.bean.QuickTradeDismissEvent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;

public class QuickTradeResultDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public a f80546b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f80547c = true;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static QuickTradeResultDialogFragment th(String str, String str2, int i11) {
        QuickTradeResultDialogFragment quickTradeResultDialogFragment = new QuickTradeResultDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("arg_symbol", str);
        bundle.putString("arg_order_id", str2);
        bundle.putInt("arg_trade_view_type", i11);
        quickTradeResultDialogFragment.setArguments(bundle);
        return quickTradeResultDialogFragment;
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.v_space).setOnClickListener(new qq.a(this));
    }

    public void afterInit() {
    }

    public void dismiss() {
        super.dismiss();
        a aVar = this.f80546b;
        if (aVar != null && this.f80547c) {
            aVar.a();
        }
    }

    public int getContentViewResId() {
        return R.layout.dialog_quick_trade_spot;
    }

    public int getGravity() {
        return 48;
    }

    public void initView(r rVar) {
        getChildFragmentManager().q().t(R.id.trade_spot_content_parent, QuickTradeResultFragment.Sh(getArguments().getString("arg_order_id"), getArguments().getInt("arg_trade_view_type"))).j();
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onEvent(QuickTradeDismissEvent quickTradeDismissEvent) {
        if (quickTradeDismissEvent.a()) {
            this.f80547c = false;
        }
        dismiss();
        if (quickTradeDismissEvent.a()) {
            this.f80547c = true;
        }
        if (quickTradeDismissEvent.a()) {
            nq.a.i(getActivity(), getParentFragmentManager(), getArguments().getString("arg_symbol"), true, this.f80546b);
        }
    }

    public void uh(a aVar) {
        this.f80546b = aVar;
    }
}
