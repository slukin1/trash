package com.huobi.order.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.order.persenter.TradeOrderHistoryDetailPresenter;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.trade.bean.TradeOrderType;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import java.util.ArrayList;
import java.util.Locale;
import pro.huobi.R;

public class TradeOrderHistoryDetailActivity extends BaseActivity<TradeOrderHistoryDetailPresenter, TradeOrderHistoryDetailPresenter.b> implements TradeOrderHistoryDetailPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f78207b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f78208c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f78209d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f78210e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayoutManager f78211f;

    /* renamed from: g  reason: collision with root package name */
    public LoadingLayout f78212g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f78213h;

    public static class FeedData {

        /* renamed from: a  reason: collision with root package name */
        public String f78214a;

        /* renamed from: b  reason: collision with root package name */
        public String f78215b;

        /* renamed from: c  reason: collision with root package name */
        public String f78216c;

        /* renamed from: d  reason: collision with root package name */
        public String f78217d;

        /* renamed from: e  reason: collision with root package name */
        public String f78218e;

        public boolean equals(Object obj) {
            if (obj instanceof FeedData) {
                FeedData feedData = (FeedData) obj;
                return (feedData.f78216c + feedData.f78214a + feedData.f78215b).equals(this.f78216c + this.f78214a + this.f78215b);
            } else if (!(obj instanceof String)) {
                return super.equals(obj);
            } else {
                return ((String) obj).equals(this.f78216c + this.f78214a + this.f78215b);
            }
        }
    }

    public class a extends GridLayoutManager.SpanSizeLookup {
        public a() {
        }

        public int getSpanSize(int i11) {
            return i11 % 3 == 0 ? 4 : 3;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(String str, boolean z11, View view) {
        k0.O(this, str, z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pg(String str, boolean z11, View view) {
        k0.O(this, str, z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        ((TradeOrderHistoryDetailPresenter) getPresenter()).g0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Pa(String str, TradeOrderHistory tradeOrderHistory, ArrayList<OrderBeanDetails> arrayList) {
        String str2;
        if (tradeOrderHistory != null) {
            SymbolBean J = a1.v().J(tradeOrderHistory.getSymbolId(), TradeType.PRO);
            boolean z11 = false;
            this.f78213h.setVisibility(tradeOrderHistory.getSource().contains("fl") ? 0 : 8);
            StringBuilder sb2 = new StringBuilder();
            String str3 = "";
            if (J != null) {
                str3 = J.getBaseCurrencyDisplayName();
                str2 = J.getQuoteCurrencyDisplayName();
            } else {
                str2 = str3;
            }
            String type = tradeOrderHistory.getType();
            if (TradeOrderType.c(type)) {
                if (TradeOrderType.e(tradeOrderHistory.getSource())) {
                    this.f78209d.setText(R.string.order_system_buy_label);
                } else {
                    this.f78209d.setText(R.string.order_buy_label);
                }
                this.f78209d.setTextColor(getResources().getColor(w.h()));
            } else {
                if (TradeOrderType.d(type)) {
                    if (TradeOrderType.e(tradeOrderHistory.getSource())) {
                        this.f78209d.setText(R.string.order_system_sell_label);
                    } else {
                        this.f78209d.setText(R.string.order_sell_label);
                    }
                    this.f78209d.setTextColor(getResources().getColor(w.d()));
                } else if ("buy-market".equals(type)) {
                    if (TradeOrderType.e(tradeOrderHistory.getSource())) {
                        this.f78209d.setText(R.string.order_system_buy_label);
                    } else {
                        this.f78209d.setText(R.string.order_buy_label);
                    }
                    this.f78209d.setTextColor(getResources().getColor(w.h()));
                } else if ("sell-market".equals(type)) {
                    if (TradeOrderType.e(tradeOrderHistory.getSource())) {
                        this.f78209d.setText(R.string.order_system_sell_label);
                    } else {
                        this.f78209d.setText(R.string.order_sell_label);
                    }
                    this.f78209d.setTextColor(getResources().getColor(w.d()));
                }
                sb2.append(str3);
                sb2.append("/");
                sb2.append(str2.toUpperCase(Locale.US));
                this.f78210e.setText(sb2.toString());
                this.f78210e.setOnClickListener(new t(this, str, z11));
                this.f78209d.setOnClickListener(new s(this, str, z11));
            }
            z11 = true;
            sb2.append(str3);
            sb2.append("/");
            sb2.append(str2.toUpperCase(Locale.US));
            this.f78210e.setText(sb2.toString());
            this.f78210e.setOnClickListener(new t(this, str, z11));
            this.f78209d.setOnClickListener(new s(this, str, z11));
        }
    }

    public void S9(v9.a aVar) {
        this.f78208c.setAdapter(aVar);
    }

    public void addEvent() {
        this.f78212g.setOnRetryClickListener(new r(this));
    }

    public void d4(v9.a aVar) {
        this.f78207b.setAdapter(aVar);
    }

    public LoadingLayout f1() {
        return this.f78212g;
    }

    /* renamed from: fg */
    public TradeOrderHistoryDetailPresenter createPresenter() {
        return new TradeOrderHistoryDetailPresenter();
    }

    public int getContentView() {
        return R.layout.activity_trade_order_history_detail;
    }

    /* renamed from: gg */
    public TradeOrderHistoryDetailPresenter.b getUI() {
        return this;
    }

    public void initView() {
        this.f78207b = (RecyclerView) this.viewFinder.b(R.id.trade_history_top_rv);
        this.f78208c = (RecyclerView) this.viewFinder.b(R.id.trade_history_details_rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10);
        gridLayoutManager.t(new a());
        this.f78207b.setLayoutManager(gridLayoutManager);
        this.f78207b.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f78211f = linearLayoutManager;
        this.f78208c.setLayoutManager(linearLayoutManager);
        this.f78208c.setNestedScrollingEnabled(false);
        this.f78212g = (LoadingLayout) this.viewFinder.b(R.id.detail_loading_layout);
        this.f78210e = (TextView) this.viewFinder.b(R.id.detail_symbol_tv);
        this.f78213h = (TextView) this.viewFinder.b(R.id.tv_order_fl);
        this.f78209d = (TextView) this.viewFinder.b(R.id.detail_order_type_tv);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
