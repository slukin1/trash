package com.huobi.quicktrade.trade.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import sq.i;

public class QuickTradeDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public String f80641b;

    /* renamed from: c  reason: collision with root package name */
    public a f80642c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f80643d = true;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static QuickTradeDialogFragment th(String str, boolean z11) {
        return uh(str, z11, -1);
    }

    public static QuickTradeDialogFragment uh(String str, boolean z11, int i11) {
        QuickTradeDialogFragment quickTradeDialogFragment = new QuickTradeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tradingview_symbol", str);
        bundle.putBoolean("arg_buy", z11);
        bundle.putInt("trade_dialog_type", i11);
        quickTradeDialogFragment.setArguments(bundle);
        return quickTradeDialogFragment;
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.v_space).setOnClickListener(new i(this));
    }

    public void afterInit() {
    }

    public void dismiss() {
        super.dismiss();
        a aVar = this.f80642c;
        if (aVar != null && this.f80643d) {
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
        getChildFragmentManager().q().t(R.id.trade_spot_content_parent, QuickTradeVerticalSpotFragment.Ki(this.f80641b, getArguments().getBoolean("arg_buy"), getArguments().getInt("trade_dialog_type"))).j();
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f80641b = arguments.getString("tradingview_symbol");
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
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
        dismiss();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        dismiss();
    }

    public void vh(a aVar) {
        this.f80642c = aVar;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onEvent(mq.a aVar) {
        this.f80643d = false;
        dismiss();
        this.f80643d = true;
        nq.a.k(getParentFragmentManager(), this.f80641b, aVar.a(), nq.a.c(), this.f80642c);
    }
}
