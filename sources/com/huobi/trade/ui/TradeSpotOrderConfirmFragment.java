package com.huobi.trade.ui;

import android.os.Bundle;
import android.view.View;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.engine.TradeSpotNativeAbility;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import i6.r;
import java.lang.ref.WeakReference;
import nk.a;
import pro.huobi.R;
import rj.b;

public class TradeSpotOrderConfirmFragment extends BaseDialogFragment implements a.C0579a {

    /* renamed from: b  reason: collision with root package name */
    public a f82446b;

    /* renamed from: c  reason: collision with root package name */
    public View f82447c;

    /* renamed from: d  reason: collision with root package name */
    public TradeSpotConfirmView f82448d;

    /* renamed from: e  reason: collision with root package name */
    public b f82449e;

    /* renamed from: f  reason: collision with root package name */
    public OrderPlaceBean f82450f;

    public interface a {
        void callback();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        doDismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static TradeSpotOrderConfirmFragment vh(String str, OrderPlaceBean orderPlaceBean) {
        TradeSpotOrderConfirmFragment tradeSpotOrderConfirmFragment = new TradeSpotOrderConfirmFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SpotTradeOrderInfo", orderPlaceBean);
        bundle.putString("SpotTradeType", str);
        tradeSpotOrderConfirmFragment.setArguments(bundle);
        return tradeSpotOrderConfirmFragment;
    }

    public void addEvent(r rVar) {
        this.f82447c.setOnClickListener(new i2(this));
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
        this.f82449e.B();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.trade_spot_order_confirm_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f82447c = rVar.b(R.id.v_space);
        TradeSpotConfirmView tradeSpotConfirmView = (TradeSpotConfirmView) rVar.b(R.id.trade_layout);
        this.f82448d = tradeSpotConfirmView;
        tradeSpotConfirmView.setActivity(getActivity());
        Bundle arguments = getArguments();
        OrderPlaceBean orderPlaceBean = (OrderPlaceBean) arguments.getSerializable("SpotTradeOrderInfo");
        this.f82450f = orderPlaceBean;
        String string = arguments.getString("SpotTradeType");
        b bVar = new b(getContext(), "spottradeconfirm");
        this.f82449e = bVar;
        bVar.t("trade", TradeSpotNativeAbility.class);
        this.f82449e.s(TUIConstants.TUIChat.FRAGMENT, new WeakReference(this));
        this.f82448d.d(orderPlaceBean, string);
        this.f82448d.setEdgeEngine(this.f82449e);
    }

    public boolean isTransparent() {
        return false;
    }

    public void th() {
        a aVar = this.f82446b;
        if (aVar != null) {
            aVar.callback();
        }
    }

    public OrderPlaceBean uh() {
        return this.f82450f;
    }

    public void wh(a aVar) {
        this.f82446b = aVar;
    }
}
