package com.huobi.feature.ui;

import android.os.Bundle;
import android.view.View;
import com.hbg.lib.data.future.bean.FeatureTradeTimeInfo;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import nk.a;
import pk.h3;
import pro.huobi.R;

public class TimeOrderFragment extends BaseDialogFragment implements a.C0579a {

    /* renamed from: b  reason: collision with root package name */
    public a f45011b;

    /* renamed from: c  reason: collision with root package name */
    public View f45012c;

    /* renamed from: d  reason: collision with root package name */
    public FutureTradeTimeTogetherView f45013d;

    /* renamed from: e  reason: collision with root package name */
    public FeatureTradeTimeInfo f45014e;

    public interface a {
        void callback();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        doDismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static TimeOrderFragment th(FeatureTradeTimeInfo featureTradeTimeInfo, AccountBalanceInfoV5 accountBalanceInfoV5) {
        TimeOrderFragment timeOrderFragment = new TimeOrderFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("FeatureTradeTimeInfo", featureTradeTimeInfo);
        bundle.putSerializable("FeatureTradeTimeInfo_Balance", accountBalanceInfoV5);
        timeOrderFragment.setArguments(bundle);
        return timeOrderFragment;
    }

    public void addEvent(r rVar) {
        this.f45012c.setOnClickListener(new h3(this));
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void close() {
        doDismiss();
    }

    public void doDismiss() {
        super.doDismiss();
        this.f45013d.Z();
        a aVar = this.f45011b;
        if (aVar != null) {
            aVar.callback();
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.feature_timing_order_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f45012c = rVar.b(R.id.iv_close);
        FutureTradeTimeTogetherView futureTradeTimeTogetherView = (FutureTradeTimeTogetherView) rVar.b(R.id.trade_layout);
        this.f45013d = futureTradeTimeTogetherView;
        futureTradeTimeTogetherView.setActivity(getActivity());
        this.f45013d.setTradeTimeUI(this);
        this.f45014e = (FeatureTradeTimeInfo) getArguments().getSerializable("FeatureTradeTimeInfo");
        this.f45013d.setBalance((AccountBalanceInfoV5) getArguments().getSerializable("FeatureTradeTimeInfo_Balance"));
        this.f45013d.setFeatureTradeTimeInfo(this.f45014e);
    }

    public boolean isTransparent() {
        return false;
    }
}
