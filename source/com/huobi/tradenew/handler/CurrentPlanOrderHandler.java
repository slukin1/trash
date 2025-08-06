package com.huobi.tradenew.handler;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bh.j;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.AlgoOrderCancelResult;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import i6.r;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import q6.d;
import s9.c;
import u6.g;
import yo.s0;

public class CurrentPlanOrderHandler implements c, View.OnClickListener {

    public class a extends d<AlgoOrderCancelResult> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(AlgoOrderCancelResult algoOrderCancelResult) {
            super.onNext(algoOrderCancelResult);
            HuobiToastUtil.t(j.c(), R.string.string_order_cancel_ok);
        }

        public void onAfter() {
            super.onAfter();
            EventBus.d().k(new AssetAndOrderUpdateEvent());
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
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(AlgoOrderInfo algoOrderInfo, View view) {
        d(e(view), algoOrderInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String c(String str) {
        return "(" + str + ")";
    }

    public void d(Context context, AlgoOrderInfo algoOrderInfo) {
        g gVar = context instanceof g ? (g) context : null;
        if (!NetworkStatus.c(j.c())) {
            HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
        } else {
            s0.d0().R(1, algoOrderInfo.getClientOrderId()).delay(1, TimeUnit.SECONDS).compose(RxJavaHelper.t(gVar)).subscribe(new a(gVar));
        }
    }

    public Activity e(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* renamed from: f */
    public void handleView(v9.c cVar, int i11, vo.a aVar, ViewGroup viewGroup) {
        Resources resources;
        String str;
        String str2;
        Resources resources2;
        vo.a aVar2 = aVar;
        Context context = cVar.itemView.getContext();
        Resources resources3 = context.getResources();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_order_type);
        TextView textView2 = (TextView) e11.b(R.id.tv_order_time);
        TextView textView3 = (TextView) e11.b(R.id.tv_order_price);
        TextView textView4 = (TextView) e11.b(R.id.tv_order_amount_process);
        TextView textView5 = (TextView) e11.b(R.id.price_title_tv);
        TextView textView6 = (TextView) e11.b(R.id.order_amount_title_tv);
        TextView textView7 = (TextView) e11.b(R.id.tv_symbol);
        TextView textView8 = (TextView) e11.b(R.id.id_tv_trade_order_trigger_condition);
        TextView textView9 = (TextView) e11.b(R.id.tv_margin_type);
        TradeType g11 = aVar.g();
        TextView textView10 = (TextView) e11.b(R.id.tv_order_operate);
        TradeType tradeType = TradeType.SUPERMARGIN;
        TextView textView11 = (TextView) e11.b(R.id.id_tv_trade_order_trigger);
        if (g11 == tradeType) {
            textView9.setVisibility(0);
            textView9.setText(R.string.n_contract_super_margin);
        } else if (aVar.g() == TradeType.MARGIN) {
            textView9.setVisibility(0);
            textView9.setText(R.string.n_contract_trade_margin);
        } else {
            textView9.setVisibility(4);
        }
        AlgoOrderInfo e12 = aVar.e();
        textView7.setTag(R.id.item_data, aVar2);
        textView7.setOnClickListener(this);
        textView.setTag(R.id.item_data, aVar2);
        textView.setOnClickListener(this);
        SymbolBean J = a1.v().J(aVar.f(), TradeType.PRO);
        StringBuilder sb2 = new StringBuilder();
        if (J != null) {
            str = J.getBaseCurrencyDisplayName();
            str2 = J.getQuoteCurrencyDisplayName();
            resources = resources3;
        } else {
            Iterator<String> it2 = a1.v().j().iterator();
            String str3 = "";
            String str4 = str3;
            while (it2.hasNext()) {
                Iterator<String> it3 = it2;
                String next = it2.next();
                String str5 = str3;
                if (aVar.f().lastIndexOf(next) > 0) {
                    resources2 = resources3;
                    str4 = aVar.f().substring(0, aVar.f().lastIndexOf(next));
                    str3 = next;
                } else {
                    resources2 = resources3;
                    str3 = str5;
                }
                it2 = it3;
                resources3 = resources2;
            }
            resources = resources3;
            String str6 = str3;
            str = str4;
            str2 = str6;
        }
        sb2.append(str);
        sb2.append("/");
        sb2.append(str2);
        textView7.setText(sb2);
        textView.setTag(R.id.item_data, aVar2);
        textView.setOnClickListener(this);
        boolean equals = "buy".equals(e12.getOrderSide());
        int i12 = R.color.invest_countdown_background_color;
        if (equals) {
            textView.setText(R.string.order_buy_label);
            textView.setTextColor(ContextCompat.getColor(context, w.h()));
            if (w.l()) {
                i12 = R.color.trade_item_red_bg_color;
            }
            textView.setBackgroundColor(ContextCompat.getColor(context, i12));
        } else {
            textView.setText(R.string.order_sell_label);
            textView.setTextColor(ContextCompat.getColor(context, w.d()));
            if (!w.l()) {
                i12 = R.color.trade_item_red_bg_color;
            }
            textView.setBackgroundColor(ContextCompat.getColor(context, i12));
        }
        if (e12.isLimitOrderType()) {
            textView3.setText(m.m(e12.getOrderPrice(), PrecisionUtil.A(aVar.f())));
        } else {
            textView3.setText(R.string.n_exchange_order_list_market);
        }
        textView5.setText(String.format(context.getString(R.string.n_exchange_order_list_entrust_price) + "(%s)", new Object[]{str2}));
        if (e12.isLimitOrderType()) {
            textView6.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_list_entrust_amount), c(str)}));
            textView4.setText(m.m(e12.getOrderSize(), PrecisionUtil.z(aVar.f())));
        } else if ("buy".equals(e12.getOrderSide())) {
            textView6.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_entrusts_total_volume), c(str2)}));
            textView4.setText(m.m(e12.getOrderValue(), PrecisionUtil.y(aVar.f())));
        } else {
            textView6.setText(String.format("%s%s", new Object[]{context.getString(R.string.n_exchange_order_list_entrust_amount), c(str)}));
            textView4.setText(m.m(e12.getOrderSize(), PrecisionUtil.z(aVar.f())));
        }
        textView2.setText(DateTimeUtils.C(e12.getOrderOrigTime()));
        textView8.setText(m.m(e12.getStopPrice(), PrecisionUtil.A(aVar.f())) + str2);
        if (LoanOrderItem.CREATED.equalsIgnoreCase(e12.getOrderStatus())) {
            textView11.setText(resources.getString(R.string.n_exchange_order_list_untriggered));
        } else {
            textView11.setText(resources.getString(R.string.n_exchange_order_list_triggered));
        }
        textView10.setOnClickListener(new pt.a(this, e12));
    }

    public int getResId() {
        return R.layout.item_plan_current_order_layout;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        vo.a aVar = (vo.a) view.getTag(R.id.item_data);
        if (view.getId() == R.id.tv_symbol) {
            if (aVar.c() != null) {
                aVar.c().a(aVar, view.getContext());
            }
        } else if (view.getId() == R.id.tv_order_type) {
            boolean equals = "buy".equals(aVar.e().getOrderSide());
            if (aVar.h()) {
                k0.S(view.getContext(), aVar.f(), equals, aVar.g());
            } else {
                k0.O(view.getContext(), aVar.f(), equals);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
