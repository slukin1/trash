package com.huobi.trade.prime.viewhandler;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bh.j;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.trade.prime.bean.PrimeOrderBean;
import com.huobi.utils.SymbolUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import ht.o;
import i6.m;
import i6.r;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import q6.d;
import s9.c;
import u6.g;

public class PrimeOrderBeanViewHandler implements c {

    public class a extends d {
        public a(g gVar) {
            super(gVar);
        }

        public void onAfter() {
            super.onAfter();
            EventBus.d().k(new AssetAndOrderUpdateEvent());
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HuobiToastUtil.k(j.c(), R.string.string_order_cancel_fail);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.k(j.c(), R.string.string_order_cancel_fail);
            } else {
                super.onFailed(aPIStatusErrorException);
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.t(j.c(), R.string.string_order_cancel_ok);
            s6.a.b(j.c()).c(R.raw.order_canceled);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f(PrimeOrderBean primeOrderBean, TextView textView, View view) {
        c(d(view), primeOrderBean);
        VibrateManager.a(textView);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void c(Context context, PrimeOrderBean primeOrderBean) {
        g gVar = context instanceof g ? (g) context : null;
        if (!NetworkStatus.c(j.c())) {
            HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
        } else {
            o.B().s(primeOrderBean.getId()).delay(1, TimeUnit.SECONDS).compose(RxJavaHelper.t(gVar)).subscribe(new a(gVar));
        }
    }

    public Activity d(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, PrimeOrderBean primeOrderBean, ViewGroup viewGroup) {
        Context context = cVar.itemView.getContext();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_order_type);
        TextView textView2 = (TextView) e11.b(R.id.tv_order_time);
        TextView textView3 = (TextView) e11.b(R.id.tv_order_operate);
        TextView textView4 = (TextView) e11.b(R.id.tv_order_price);
        TextView textView5 = (TextView) e11.b(R.id.tv_order_amount_process);
        TextView textView6 = (TextView) e11.b(R.id.tv_order_amount);
        TextView textView7 = (TextView) e11.b(R.id.price_title_tv);
        TextView textView8 = (TextView) e11.b(R.id.order_amount_title_tv);
        TextView textView9 = (TextView) e11.b(R.id.order_fee_title_tv);
        TextView textView10 = (TextView) e11.b(R.id.tv_symbol);
        View b11 = e11.b(R.id.id_tv_trade_order_trigger_layout);
        ViewUtil.m(textView10, false);
        String n11 = a1.v().n(primeOrderBean.getSymbol());
        String D = a1.v().D(primeOrderBean.getSymbol());
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.US;
        sb2.append(n11.toUpperCase(locale));
        sb2.append("/");
        sb2.append(D.toUpperCase(locale));
        textView10.setText(sb2.toString());
        boolean isBuy = primeOrderBean.isBuy();
        int i12 = R.color.invest_countdown_background_color;
        if (isBuy) {
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
        textView4.setText(m.m(primeOrderBean.getPrice(), PrecisionUtil.A(primeOrderBean.getSymbol())));
        textView7.setText(String.format(context.getString(R.string.order_price_icon_label), new Object[]{SymbolUtil.c(primeOrderBean.getSymbol(), false)}));
        if (a1.v().Q(primeOrderBean.getSymbol())) {
            textView8.setText(String.format(context.getString(R.string.n_exchange_order_list_volume) + "(%s)", new Object[]{D.toUpperCase(locale)}));
        } else {
            textView8.setText(String.format(context.getString(R.string.order_amount_icon_label), new Object[]{SymbolUtil.c(primeOrderBean.getSymbol(), true)}));
        }
        textView9.setText(context.getString(R.string.n_exchange_timing_deal_amount) + SymbolUtil.c(primeOrderBean.getSymbol(), true));
        textView2.setText(DateTimeUtils.C(primeOrderBean.getCreatedAt()));
        textView5.setText(m.q(m.a(primeOrderBean.getAmount()), PrecisionUtil.y(primeOrderBean.getSymbol())));
        textView6.setText("0");
        textView3.setOnClickListener(new jt.a(this, primeOrderBean, textView3));
        ViewUtil.m(b11, false);
        PrimeInfo F = o.B().F();
        ViewUtil.m(textView3, F == null || primeOrderBean.getSymbol() == null || !primeOrderBean.getSymbol().equalsIgnoreCase(F.getSymbolCode()) || !o.B().T() || o.B().Z());
    }

    public int getResId() {
        return R.layout.item_order_layout;
    }
}
