package com.huobi.trade.ui;

import android.os.Bundle;
import android.view.View;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.trade.engine.TradeNativeAbility;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import i6.r;
import java.lang.ref.WeakReference;
import nk.a;
import pro.huobi.R;
import rj.b;

public class TradeTimeOrderConfirmFragment extends BaseDialogFragment implements a.C0579a {

    /* renamed from: b  reason: collision with root package name */
    public a f82461b;

    /* renamed from: c  reason: collision with root package name */
    public View f82462c;

    /* renamed from: d  reason: collision with root package name */
    public TradeTimeConfirmView f82463d;

    /* renamed from: e  reason: collision with root package name */
    public b f82464e;

    public interface a {
        void callback();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        doDismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static TradeTimeOrderConfirmFragment th(String str) {
        TradeTimeOrderConfirmFragment tradeTimeOrderConfirmFragment = new TradeTimeOrderConfirmFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("FeatureTradeTimeInfo", str);
        tradeTimeOrderConfirmFragment.setArguments(bundle);
        return tradeTimeOrderConfirmFragment;
    }

    public void addEvent(r rVar) {
        this.f82462c.setOnClickListener(new j2(this));
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
        a aVar = this.f82461b;
        if (aVar != null) {
            aVar.callback();
        }
        this.f82464e.B();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.trade_time_order_confirm_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f82462c = rVar.b(R.id.v_space);
        TradeTimeConfirmView tradeTimeConfirmView = (TradeTimeConfirmView) rVar.b(R.id.trade_layout);
        this.f82463d = tradeTimeConfirmView;
        tradeTimeConfirmView.setActivity(getActivity());
        String string = getArguments().getString("FeatureTradeTimeInfo");
        b bVar = new b(getContext(), "tradeconfirm");
        this.f82464e = bVar;
        bVar.t("trade", TradeNativeAbility.class);
        this.f82464e.s(TUIConstants.TUIChat.FRAGMENT, new WeakReference(this));
        this.f82463d.setParam(string);
        this.f82463d.setEdgeEngine(this.f82464e);
    }

    public boolean isTransparent() {
        return false;
    }
}
