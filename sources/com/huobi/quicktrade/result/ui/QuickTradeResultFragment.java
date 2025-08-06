package com.huobi.quicktrade.result.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bh.j;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.network.pro.core.bean.AlgoSpecificOrderInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.order.bean.OrderBean;
import com.huobi.order.service.OrderService;
import com.huobi.points.entity.PointsPack;
import com.huobi.quicktrade.bean.QuickTradeDismissEvent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import tq.p;
import u6.g;
import yo.s0;

public class QuickTradeResultFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public String f80548l;

    /* renamed from: m  reason: collision with root package name */
    public int f80549m;

    /* renamed from: n  reason: collision with root package name */
    public QuickTradeResultView f80550n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f80551o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f80552p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f80553q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f80554r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f80555s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f80556t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f80557u;

    /* renamed from: v  reason: collision with root package name */
    public Subscription f80558v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f80559w;

    public class a extends BaseSubscriber {
        public a() {
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            QuickTradeResultFragment.this.Th();
        }
    }

    public class b extends BaseSubscriber<AlgoSpecificOrderInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(AlgoSpecificOrderInfo algoSpecificOrderInfo) {
            super.onNext(algoSpecificOrderInfo);
            boolean unused = QuickTradeResultFragment.this.f80559w = "buy".equals(algoSpecificOrderInfo.getOrderSide());
            QuickTradeResultFragment.this.Uh(algoSpecificOrderInfo);
            QuickTradeResultFragment.this.f80550n.setData(algoSpecificOrderInfo);
        }
    }

    public class c extends BaseSubscriber<OrderBean> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(OrderBean orderBean) {
            super.onNext(orderBean);
            boolean unused = QuickTradeResultFragment.this.f80559w = orderBean.isBuy();
            QuickTradeResultFragment.this.Vh(orderBean);
            QuickTradeResultFragment.this.f80550n.b(orderBean, QuickTradeResultFragment.this.f80549m);
        }
    }

    public class d extends q6.d {
        public d(g gVar) {
            super(gVar);
        }

        public void onAfter() {
            super.onAfter();
            EventBus.d().k(new QuickTradeDismissEvent());
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            HuobiToastUtil.k(j.c(), R.string.string_order_cancel_fail);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.k(j.c(), R.string.string_order_cancel_fail);
            } else {
                super.onFailed(aPIStatusErrorException);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.t(j.c(), R.string.string_order_cancel_ok);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Ph(View view) {
        EventBus.d().k(new QuickTradeDismissEvent());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qh(View view) {
        Nh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Rh(View view) {
        QuickTradeDismissEvent quickTradeDismissEvent = new QuickTradeDismissEvent();
        quickTradeDismissEvent.b(true);
        EventBus.d().k(quickTradeDismissEvent);
        HashMap hashMap = new HashMap();
        hashMap.put("trade_class_name", this.f80559w ? "buy" : "sale");
        hashMap.put("order_class_name", nq.a.b(this.f80549m));
        gs.g.i("App_quickcomponent_trade_transsuc_placeod_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static QuickTradeResultFragment Sh(String str, int i11) {
        QuickTradeResultFragment quickTradeResultFragment = new QuickTradeResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString("arg_order_id", str);
        bundle.putInt("arg_trade_view_type", i11);
        quickTradeResultFragment.setArguments(bundle);
        return quickTradeResultFragment;
    }

    public final void Nh() {
        HashMap hashMap = new HashMap();
        hashMap.put("trade_class_name", this.f80559w ? "buy" : "sale");
        hashMap.put("order_class_name", nq.a.b(this.f80549m));
        gs.g.i("App_quickcomponent_trade_transsuc_revoke_click", hashMap);
        if (!NetworkStatus.c(j.c())) {
            HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
            return;
        }
        d dVar = new d(this);
        if (Oh()) {
            s0.d0().R(1, this.f80548l).delay(1, TimeUnit.SECONDS).compose(RxJavaHelper.t(this)).subscribe(dVar);
        } else {
            ((OrderService) p.X(TradeType.PRO, OrderService.class)).submitCancel(Long.valueOf(this.f80548l).longValue(), "user-actively-cancels-order-android").delay(1, TimeUnit.SECONDS).compose(p.a0()).compose(RxJavaHelper.t(this)).subscribe(dVar);
        }
    }

    public final boolean Oh() {
        return this.f80549m == 3;
    }

    public final void Th() {
        if (Oh()) {
            HashMap hashMap = new HashMap();
            hashMap.put("clientOrderId", this.f80548l);
            s0.d0().T(hashMap).compose(RxJavaHelper.t((g) null)).subscribe(new b());
            return;
        }
        ((OrderService) p.X(TradeType.PRO, OrderService.class)).getOrder(Long.valueOf(this.f80548l).longValue()).compose(p.a0()).compose(RxJavaHelper.t((g) null)).subscribe(new c());
    }

    public final void Uh(AlgoSpecificOrderInfo algoSpecificOrderInfo) {
        String str;
        SymbolBean J = a1.v().J(algoSpecificOrderInfo.getSymbol(), TradeType.PRO);
        String str2 = "";
        if (J != null) {
            str2 = J.getBaseCurrencyDisplayName();
            str = J.getQuoteCurrencyDisplayName();
        } else {
            str = str2;
        }
        String orderStatus = algoSpecificOrderInfo.getOrderStatus();
        if (LoanOrderItem.CREATED.equals(orderStatus)) {
            this.f80552p.setText(R.string.n_quick_trade_plan_order_state_created);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_created, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(0);
            this.f80557u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80557u.setBackground(getResources().getDrawable(R.drawable.shape_item_operation_default_bg));
        } else if ("canceled".equals(orderStatus)) {
            this.f80552p.setText(R.string.n_exchange_order_have_canceled);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_canceled, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(8);
        } else if (PointsPack.STATE_PENDING.equals(orderStatus)) {
            this.f80552p.setText(R.string.n_exchange_trade_triggering);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_created, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(0);
            this.f80557u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80557u.setBackground(getResources().getDrawable(R.drawable.shape_item_operation_default_bg));
        } else if ("triggered".equals(orderStatus)) {
            this.f80552p.setText(R.string.n_quick_trade_plan_order_state_triggered);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_success, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(8);
        } else {
            this.f80552p.setText(R.string.n_quick_trade_plan_order_state_rejected);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_failed, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.base_down_color));
            this.f80553q.setVisibility(0);
            this.f80557u.setVisibility(8);
        }
        if (this.f80559w) {
            this.f80554r.setText(R.string.order_buy_label);
            this.f80554r.setTextColor(ContextCompat.getColor(getContext(), w.h()));
        } else {
            this.f80554r.setText(R.string.order_sell_label);
            this.f80554r.setTextColor(ContextCompat.getColor(getContext(), w.d()));
        }
        this.f80555s.setText(str2 + "/" + str);
        this.f80556t.setText(DateTimeUtils.C(algoSpecificOrderInfo.getOrderOrigTime()));
    }

    public final void Vh(OrderBean orderBean) {
        String str;
        SymbolBean J = a1.v().J(orderBean.getSymbol(), TradeType.PRO);
        String str2 = "";
        if (J != null) {
            str2 = J.getBaseCurrencyDisplayName();
            str = J.getQuoteCurrencyDisplayName();
        } else {
            str = str2;
        }
        String state = orderBean.getState();
        if (LoanOrderItem.CREATED.equals(state)) {
            this.f80552p.setText(R.string.n_quick_trade_plan_order_state_created);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_created, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(0);
            this.f80557u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80557u.setBackground(getResources().getDrawable(R.drawable.shape_item_operation_default_bg));
        } else if ("submitted".equals(state)) {
            this.f80552p.setText(R.string.n_exchange_trade_wait_completed);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_created, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(0);
            this.f80557u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80557u.setBackground(getResources().getDrawable(R.drawable.shape_item_operation_default_bg));
        } else if (C2CLoanOrderBean.LOAN_ORDER_STATE_PARTIAL_FILLED.equals(state)) {
            this.f80552p.setText(R.string.n_exchange_trade_partial_completed);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_created, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(0);
            this.f80557u.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80557u.setBackground(getResources().getDrawable(R.drawable.shape_item_operation_default_bg));
        } else if ("partial-canceled".equals(state)) {
            this.f80552p.setText(R.string.n_exchange_trade_partial_canceled);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_canceled, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(8);
        } else if (TtmlNode.TEXT_EMPHASIS_MARK_FILLED.equals(state)) {
            this.f80552p.setText(getString(R.string.n_exchange_order_list_completed));
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_success, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(8);
        } else {
            this.f80552p.setText(R.string.n_exchange_trade_have_canceled);
            this.f80552p.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_quick_trade_result_canceled, 0, 0, 0);
            this.f80552p.setTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
            this.f80553q.setVisibility(8);
            this.f80557u.setVisibility(8);
        }
        if (this.f80559w) {
            this.f80554r.setText(R.string.order_buy_label);
            this.f80554r.setTextColor(ContextCompat.getColor(getContext(), w.h()));
        } else {
            this.f80554r.setText(R.string.order_sell_label);
            this.f80554r.setTextColor(ContextCompat.getColor(getContext(), w.d()));
        }
        this.f80555s.setText(str2 + "/" + str);
        this.f80556t.setText(DateTimeUtils.C(orderBean.getCreatedAt()));
    }

    public void afterInit() {
        super.afterInit();
        Bundle arguments = getArguments();
        this.f80548l = arguments.getString("arg_order_id");
        int i11 = arguments.getInt("arg_trade_view_type");
        this.f80549m = i11;
        if (i11 == 0) {
            this.f80551o.setText(getString(R.string.n_contract_order_type_limit));
        } else if (i11 == 1) {
            this.f80551o.setText(getString(R.string.trade_price_market_deal));
        } else if (i11 == 2) {
            this.f80551o.setText(getString(R.string.n_contract_trade_trend_stop));
        } else if (i11 == 3) {
            this.f80551o.setText(getString(R.string.n_contract_order_type_trigger));
        }
        Th();
    }

    public void initViews() {
        super.initViews();
        this.f80551o = (TextView) this.f67460i.b(R.id.tv_trade_view_type);
        this.f80552p = (TextView) this.f67460i.b(R.id.tv_order_state);
        this.f80553q = (TextView) this.f67460i.b(R.id.tv_order_state_result);
        this.f80554r = (TextView) this.f67460i.b(R.id.tv_order_type);
        this.f80555s = (TextView) this.f67460i.b(R.id.tv_symbol);
        this.f80556t = (TextView) this.f67460i.b(R.id.tv_order_time);
        this.f80557u = (TextView) this.f67460i.b(R.id.tv_order_operate);
        this.f80550n = (QuickTradeResultView) this.f67460i.b(R.id.quick_trade_result_view);
        this.f67460i.b(R.id.iv_close).setOnClickListener(qq.d.f60116b);
        this.f80557u.setOnClickListener(new qq.c(this));
        this.f67460i.b(R.id.quick_trade_btn).setOnClickListener(new qq.b(this));
        gs.g.i("App_quickcomponent_trade_transsuc_view", (HashMap) null);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_quick_trade_result, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            Subscription subscription = this.f80558v;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.f80558v = Observable.interval(3, TimeUnit.SECONDS).subscribe(new a());
            return;
        }
        Subscription subscription2 = this.f80558v;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }
}
