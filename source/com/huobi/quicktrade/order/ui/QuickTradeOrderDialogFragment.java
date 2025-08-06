package com.huobi.quicktrade.order.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.quicktrade.bean.QuickTradeDismissEvent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pq.f;
import pro.huobi.R;

public class QuickTradeOrderDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public String f80545b;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static QuickTradeOrderDialogFragment th(String str) {
        QuickTradeOrderDialogFragment quickTradeOrderDialogFragment = new QuickTradeOrderDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tradingview_symbol", str);
        quickTradeOrderDialogFragment.setArguments(bundle);
        return quickTradeOrderDialogFragment;
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.v_space).setOnClickListener(new f(this));
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.dialog_quick_trade_spot;
    }

    public int getGravity() {
        return 48;
    }

    public void initView(r rVar) {
        getChildFragmentManager().q().t(R.id.trade_spot_content_parent, QuickTradeOrderFragment.Oh(this.f80545b)).j();
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
            this.f80545b = arguments.getString("tradingview_symbol");
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
    public void onTokenError(a aVar) {
        dismiss();
    }
}
