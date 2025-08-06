package com.huobi.order.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.pro.core.bean.AlgoSpecificOrderInfo;
import com.hbg.lib.network.pro.core.bean.PeriodTrade;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.order.bean.TimeOrderBeanDetails;
import com.huobi.points.entity.PointsPack;
import com.huobi.trade.bean.AlgoOrderMatchBean;
import com.huobi.trade.bean.OrderEmptyItem;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.huobi.view.title.HbTitleBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import gs.g;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import pro.huobi.R;
import q10.c;
import yo.s0;

public class TimeTradeDetailOrderActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public CommonTextListIndicator f78163b;

    /* renamed from: c  reason: collision with root package name */
    public ConstraintLayout f78164c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f78165d;

    /* renamed from: e  reason: collision with root package name */
    public HbTitleBar f78166e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f78167f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f78168g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f78169h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f78170i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f78171j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f78172k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f78173l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f78174m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f78175n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f78176o;

    /* renamed from: p  reason: collision with root package name */
    public List<String> f78177p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public String f78178q;

    /* renamed from: r  reason: collision with root package name */
    public v9.a<s9.a> f78179r;

    /* renamed from: s  reason: collision with root package name */
    public List<s9.a> f78180s;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            TimeTradeDetailOrderActivity.this.f78163b.c(i11);
            TimeTradeDetailOrderActivity.this.f78163b.b(i11, 0.0f, 0);
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
            if (i11 == 0) {
                TimeTradeDetailOrderActivity.this.f78164c.setVisibility(0);
                TimeTradeDetailOrderActivity.this.f78165d.setVisibility(8);
                g.i("app_trade_twap_order_details_info_click", hashMap);
            } else {
                TimeTradeDetailOrderActivity.this.f78164c.setVisibility(8);
                TimeTradeDetailOrderActivity.this.f78165d.setVisibility(0);
                TimeTradeDetailOrderActivity.this.f78179r.i(TimeTradeDetailOrderActivity.this.f78180s);
                TimeTradeDetailOrderActivity.this.f78179r.notifyDataSetChanged();
                g.i("app_trade_twap_order_details_history_click", hashMap);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            if (TimeTradeDetailOrderActivity.this.f78177p == null) {
                return 0;
            }
            return TimeTradeDetailOrderActivity.this.f78177p.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(Integer.valueOf(ContextCompat.getColor(context, R.color.baseColorMajorTheme100)));
            linePagerIndicator.setMode(2);
            linePagerIndicator.setLineWidth((float) PixelUtils.a(20.0f));
            linePagerIndicator.setLineHeight(context.getResources().getDimension(R.dimen.global_indicator_height));
            return linePagerIndicator;
        }

        public c getTitleView(Context context, int i11) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setText((CharSequence) TimeTradeDetailOrderActivity.this.f78177p.get(i11));
            colorTransitionPagerTitleView.setTextSize(1, 14.0f);
            colorTransitionPagerTitleView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            colorTransitionPagerTitleView.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
            colorTransitionPagerTitleView.setOnClickListener(new l(this, i11));
            return colorTransitionPagerTitleView;
        }
    }

    public class b extends BaseSubscriber<AlgoSpecificOrderInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(AlgoSpecificOrderInfo algoSpecificOrderInfo) {
            super.onNext(algoSpecificOrderInfo);
            TimeTradeDetailOrderActivity.this.oh(algoSpecificOrderInfo);
        }
    }

    public final void Qg() {
        HashMap hashMap = new HashMap();
        hashMap.put("clientOrderId", this.f78178q);
        s0.d0().k0(hashMap).compose(RxJavaHelper.t((u6.g) null)).subscribe(new b());
    }

    public void addEvent() {
        super.addEvent();
    }

    public void afterInit() {
        super.afterInit();
        this.f78178q = getIntent().getStringExtra("clientOrderId");
        Qg();
    }

    public int getContentView() {
        return R.layout.activity_trade_timeweight_detail;
    }

    public void initView() {
        super.initView();
        this.f78163b = (CommonTextListIndicator) this.viewFinder.b(R.id.tw_detail_indictor);
        this.f78164c = (ConstraintLayout) this.viewFinder.b(R.id.tw_trade_order_detail);
        this.f78165d = (RecyclerView) this.viewFinder.b(R.id.tw_deal_record_rv);
        this.f78166e = (HbTitleBar) this.viewFinder.b(R.id.tw_title_bar);
        this.f78167f = (TextView) this.viewFinder.b(R.id.tw_detail_symbol);
        this.f78168g = (TextView) this.viewFinder.b(R.id.tw_detail_time);
        this.f78166e.setTitle(getResources().getString(R.string.n_exchange_timing_entrust_detail));
        this.f78177p.add(getString(R.string.n_exchange_timing_entrust_info));
        this.f78177p.add(getString(R.string.n_exchange_timing_deal_record));
        this.f78169h = (TextView) this.viewFinder.b(R.id.tw_trade_type);
        this.f78170i = (TextView) this.viewFinder.b(R.id.tw_trade_taker_limit);
        this.f78171j = (TextView) this.viewFinder.b(R.id.tw_trade_taker_price);
        this.f78172k = (TextView) this.viewFinder.b(R.id.tw_trade_interval);
        this.f78173l = (TextView) this.viewFinder.b(R.id.tw_trade_unit);
        this.f78174m = (TextView) this.viewFinder.b(R.id.tw_trade_volume);
        this.f78175n = (TextView) this.viewFinder.b(R.id.tw_trade_deal);
        this.f78176o = (TextView) this.viewFinder.b(R.id.tw_trade_status);
        initViewPager();
        ArrayList arrayList = new ArrayList();
        this.f78180s = arrayList;
        v9.a<s9.a> aVar = new v9.a<>(arrayList);
        this.f78179r = aVar;
        aVar.i(this.f78180s);
        this.f78165d.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.vertical_divider_bg), PixelUtils.a(0.5f), false, false));
        this.f78165d.setLayoutManager(new StableLinearLayoutManager(this));
        this.f78165d.setAdapter(this.f78179r);
    }

    public final void initViewPager() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new a());
        this.f78163b.setNavigator(commonNavigator);
        this.f78163b.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
    }

    public final void oh(AlgoSpecificOrderInfo algoSpecificOrderInfo) {
        String str;
        int i11;
        String str2;
        String str3;
        Long l11;
        String str4;
        String str5;
        SymbolBean J = a1.v().J(algoSpecificOrderInfo.getSymbol(), TradeType.PRO);
        String str6 = "";
        if (J != null) {
            String baseCurrencyDisplayName = J.getBaseCurrencyDisplayName();
            str6 = J.getQuoteCurrencyDisplayName();
            str = baseCurrencyDisplayName;
        } else {
            str = str6;
        }
        if ("buy".equals(algoSpecificOrderInfo.getOrderSide())) {
            this.f78169h.setText(getResources().getString(R.string.order_buy_label));
            i11 = ContextCompat.getColor(this, w.h());
        } else {
            this.f78169h.setText(getResources().getString(R.string.order_sell_label));
            i11 = ContextCompat.getColor(this, w.d());
        }
        this.f78169h.setTextColor(i11);
        int A = PrecisionUtil.A(algoSpecificOrderInfo.getSymbol());
        String m11 = m.m(algoSpecificOrderInfo.getOrderPrice(), A);
        String str7 = " " + str6;
        String str8 = " " + str;
        this.f78170i.setText(m11 + str7);
        if (algoSpecificOrderInfo.getOrderPriceType() == 1) {
            String m12 = m.m(algoSpecificOrderInfo.getOrderPriceGap(), A);
            this.f78171j.setText(m12 + str7);
        } else {
            this.f78171j.setText(m.Q(algoSpecificOrderInfo.getOrderPriceRatio(), 2, 1));
        }
        if (TextUtils.isEmpty(algoSpecificOrderInfo.getInterval())) {
            this.f78172k.setText("0 S");
        } else {
            this.f78172k.setText(algoSpecificOrderInfo.getInterval() + " S");
        }
        int z11 = PrecisionUtil.z(algoSpecificOrderInfo.getSymbol());
        if (algoSpecificOrderInfo.getSingleOrderType() == 1) {
            if (TextUtils.isEmpty(algoSpecificOrderInfo.getSingleOrderSize())) {
                str5 = m.m("0", z11);
            } else {
                str5 = m.m(algoSpecificOrderInfo.getSingleOrderSize(), z11);
            }
            this.f78173l.setText(str5 + str8);
        } else {
            if (TextUtils.isEmpty(algoSpecificOrderInfo.getSingleOrderRatio())) {
                str4 = m.m("0", 2);
            } else {
                str4 = m.Q(algoSpecificOrderInfo.getSingleOrderRatio(), 2, 1);
            }
            this.f78173l.setText(str4);
        }
        if (TextUtils.isEmpty(algoSpecificOrderInfo.getOrderFinishSize())) {
            str2 = m.m("0", z11);
        } else {
            str2 = m.m(algoSpecificOrderInfo.getOrderFinishSize(), z11);
        }
        this.f78175n.setText(str2 + str8);
        if (TextUtils.isEmpty(algoSpecificOrderInfo.getOrderSize())) {
            str3 = m.m("0", z11);
        } else {
            str3 = m.m(algoSpecificOrderInfo.getOrderSize(), z11);
        }
        this.f78174m.setText(str3 + str8);
        if (algoSpecificOrderInfo.getOrderStatus().equals("triggered")) {
            this.f78176o.setText(getResources().getString(R.string.n_exchange_order_finished));
        } else if (algoSpecificOrderInfo.getOrderStatus().equals("stopped")) {
            this.f78176o.setText(getResources().getString(R.string.n_exchange_order_stopped));
        } else if (algoSpecificOrderInfo.getOrderStatus().equals("canceled")) {
            this.f78176o.setText(getResources().getString(R.string.n_exchange_order_canceled));
        } else if (algoSpecificOrderInfo.getOrderStatus().equals("rejected")) {
            this.f78176o.setText(getResources().getString(R.string.n_exchange_order_rejected));
        } else if (algoSpecificOrderInfo.getOrderStatus().equals(PointsPack.STATE_PENDING) || algoSpecificOrderInfo.getOrderStatus().equals(LoanOrderItem.CREATED)) {
            this.f78176o.setText(getResources().getString(R.string.n_exchange_order_running));
        }
        this.f78167f.setText(str + "/" + str6);
        Long orderExecuteTime = algoSpecificOrderInfo.getOrderExecuteTime();
        if (orderExecuteTime == null) {
            l11 = Long.valueOf((System.currentTimeMillis() - algoSpecificOrderInfo.getOrderOrigTime()) / 1000);
        } else {
            l11 = Long.valueOf(orderExecuteTime.longValue() / 1000);
        }
        this.f78168g.setText(String.format(getResources().getString(R.string.n_exchange_timing_order_running_time), new Object[]{String.valueOf(l11.longValue() / 86400), String.valueOf((l11.longValue() % 86400) / 3600), String.valueOf((l11.longValue() % 3600) / 60), DateTimeUtils.D(algoSpecificOrderInfo.getOrderOrigTime())}));
        this.f78180s.clear();
        List<PeriodTrade> periodTrades = algoSpecificOrderInfo.getPeriodTrades();
        int size = periodTrades.size();
        if (size > 0) {
            for (int i12 = 0; i12 < size; i12++) {
                AlgoOrderMatchBean algoOrderMatchBean = new AlgoOrderMatchBean();
                algoOrderMatchBean.setId(algoSpecificOrderInfo.getOrderId());
                algoOrderMatchBean.setSymbol(algoSpecificOrderInfo.getSymbol());
                algoOrderMatchBean.setOrderSide(algoSpecificOrderInfo.getOrderSide());
                algoOrderMatchBean.setPeriodTrade(periodTrades.get(i12));
                this.f78180s.add(new TimeOrderBeanDetails(algoOrderMatchBean));
            }
            return;
        }
        this.f78180s.add(new OrderEmptyItem(algoSpecificOrderInfo.getSymbol()));
    }
}
