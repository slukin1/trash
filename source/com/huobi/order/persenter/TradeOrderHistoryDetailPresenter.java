package com.huobi.order.persenter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.order.bean.TradeOrderDetailTopItem;
import com.huobi.order.service.OrderService;
import com.huobi.order.ui.FeeFragmentListDialog;
import com.huobi.trade.bean.TradeOrderHistory;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import tq.p;
import u6.g;
import xo.c;

public class TradeOrderHistoryDetailPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f78115a = "";

    /* renamed from: b  reason: collision with root package name */
    public TradeOrderHistory f78116b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<OrderBeanDetails> f78117c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public v9.a<OrderBeanDetails> f78118d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<TradeOrderDetailTopItem> f78119e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public v9.a<TradeOrderDetailTopItem> f78120f;

    public class a extends EasySubscriber<List<OrderBeanDetails>> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
            ((b) TradeOrderHistoryDetailPresenter.this.getUI()).f1().k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((b) TradeOrderHistoryDetailPresenter.this.getUI()).f1().k();
        }

        public void onStart() {
            super.onStart();
            ((b) TradeOrderHistoryDetailPresenter.this.getUI()).f1().p();
        }

        public void onNext(List<OrderBeanDetails> list) {
            super.onNext(list);
            TradeOrderHistoryDetailPresenter.this.f78117c.addAll(list);
            TradeOrderHistoryDetailPresenter.this.f78118d.notifyDataSetChanged();
            if (TradeOrderHistoryDetailPresenter.this.f78117c.size() > 0) {
                ((b) TradeOrderHistoryDetailPresenter.this.getUI()).f1().g();
            } else {
                ((b) TradeOrderHistoryDetailPresenter.this.getUI()).f1().i();
            }
            TradeOrderHistoryDetailPresenter.this.f0();
            ((b) TradeOrderHistoryDetailPresenter.this.getUI()).Pa(TradeOrderHistoryDetailPresenter.this.f78115a, TradeOrderHistoryDetailPresenter.this.f78116b, TradeOrderHistoryDetailPresenter.this.f78117c);
        }
    }

    public interface b extends g {
        void Pa(String str, TradeOrderHistory tradeOrderHistory, ArrayList<OrderBeanDetails> arrayList);

        void S9(v9.a aVar);

        void d4(v9.a aVar);

        LoadingLayout f1();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void a0(View view) {
        HuobiToastUtil.p(R.string.n_replicated);
        ((ClipboardManager) view.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence) null, AppUtil.b(this.f78116b.getId())));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void b0(ArrayList arrayList, View view) {
        FeeFragmentListDialog.rh(getActivity().getSupportFragmentManager(), arrayList);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List c0(List list) {
        boolean z11;
        if (list != null) {
            BigDecimal bigDecimal = BigDecimal.ZERO;
            HashSet hashSet = new HashSet();
            Iterator it2 = list.iterator();
            BigDecimal bigDecimal2 = bigDecimal;
            BigDecimal bigDecimal3 = bigDecimal2;
            while (true) {
                z11 = false;
                if (!it2.hasNext()) {
                    break;
                }
                OrderBeanDetails orderBeanDetails = (OrderBeanDetails) it2.next();
                orderBeanDetails.calculateTotalCash();
                orderBeanDetails.buildFeeCurrency();
                BigDecimal a11 = m.a(orderBeanDetails.getFilledFees());
                if (a11.compareTo(BigDecimal.ZERO) < 0) {
                    hashSet.add(-1);
                } else if (a11.compareTo(BigDecimal.ZERO) > 0) {
                    hashSet.add(1);
                }
                bigDecimal2 = bigDecimal2.add(a11);
                if (!TextUtils.isEmpty(orderBeanDetails.getFeeDeductCurrency())) {
                    if ("hbpoint".equals(orderBeanDetails.getFeeDeductCurrency()) || "pts".equals(orderBeanDetails.getFeeDeductCurrency())) {
                        bigDecimal = bigDecimal.add(m.a(orderBeanDetails.getFilledPoints()));
                    } else {
                        bigDecimal3 = bigDecimal3.add(m.a(orderBeanDetails.getFilledPoints()));
                    }
                }
                if ("hbpoint".equals(orderBeanDetails.getFeeDeductCurrency()) || "pts".equals(orderBeanDetails.getFeeDeductCurrency())) {
                    z11 = true;
                }
                if (TextUtils.isEmpty(this.f78116b.getFeeDeductCurrency()) && !z11) {
                    this.f78116b.setFeeDeductCurrency(orderBeanDetails.getFeeDeductCurrency());
                }
            }
            this.f78116b.setTotalPoints(bigDecimal.toPlainString());
            this.f78116b.setFees(bigDecimal2.toPlainString());
            TradeOrderHistory tradeOrderHistory = this.f78116b;
            if (hashSet.size() < 2) {
                z11 = true;
            }
            tradeOrderHistory.setFeeAvailable(z11);
            this.f78116b.buildFeeCurrency();
            this.f78116b.setTotalDeductFees(bigDecimal3.toPlainString());
        }
        return list;
    }

    public int Y(TradeOrderHistory tradeOrderHistory) {
        int i11 = 0;
        if (tradeOrderHistory == null) {
            return 0;
        }
        String status = tradeOrderHistory.getStatus();
        if (status.equals("3")) {
            if (m.i0(tradeOrderHistory.getTamount()) > 0.0f) {
                i11 = 1;
            }
            if (i11 > 0) {
                return i11 + 1;
            }
            return i11;
        } else if (status.equals("2")) {
            return 1;
        } else {
            return 0;
        }
    }

    public final void Z() {
        this.f78118d = new v9.a<>(this.f78117c);
        ((b) getUI()).S9(this.f78118d);
        this.f78120f = new v9.a<>(this.f78119e);
        ((b) getUI()).d4(this.f78120f);
    }

    /* renamed from: d0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        Z();
        if (getActivity().getIntent() != null) {
            Intent intent = getActivity().getIntent();
            TradeOrderHistory tradeOrderHistory = (TradeOrderHistory) intent.getSerializableExtra("extra_order_history");
            this.f78116b = tradeOrderHistory;
            if (tradeOrderHistory != null) {
                tradeOrderHistory.setTotalPoints("0");
                this.f78116b.setFees("0");
                this.f78116b.buildFeeCurrency();
            }
            this.f78115a = intent.getStringExtra("symbolId");
            f0();
            ((b) getUI()).Pa(this.f78115a, this.f78116b, this.f78117c);
        }
        g0();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:65|66|67|68|69|117) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:56|57|58|(1:60)|61|62|(2:64|116)(1:115)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0449 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0474 */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03f2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0453 A[Catch:{ Exception -> 0x03f2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f0() {
        /*
            r13 = this;
            com.huobi.trade.bean.TradeOrderHistory r0 = r13.f78116b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r0 = r13.f78119e
            r0.clear()
            d7.a1 r0 = d7.a1.v()
            com.huobi.trade.bean.TradeOrderHistory r1 = r13.f78116b
            java.lang.String r1 = r1.getSymbolId()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.network.pro.core.bean.SymbolBean r0 = r0.J(r1, r2)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0027
            java.lang.String r2 = r0.getBaseCurrencyDisplayName()
            java.lang.String r0 = r0.getQuoteCurrencyDisplayName()
            goto L_0x0029
        L_0x0027:
            r0 = r1
            r2 = r0
        L_0x0029:
            com.huobi.trade.bean.TradeOrderHistory r3 = r13.f78116b
            java.lang.String r3 = r3.getType()
            com.huobi.order.bean.TradeOrderDetailTopItem r4 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r5 = 2132023869(0x7f141a3d, float:1.9686198E38)
            java.lang.String r5 = r13.getString(r5)
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            com.huobi.trade.bean.TradeOrderHistory r8 = r13.f78116b
            java.lang.Long r8 = r8.getId()
            r9 = 0
            r7[r9] = r8
            java.lang.String r7 = com.hbg.lib.common.utils.AppUtil.b(r7)
            r4.<init>(r5, r7)
            r5 = 2131236047(0x7f0814cf, float:1.8088305E38)
            com.huobi.order.bean.TradeOrderDetailTopItem r5 = r4.setContentRightRes(r5)
            xo.a r7 = new xo.a
            r7.<init>(r13)
            r5.setContentClickListener(r7)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r5 = r13.f78119e
            r5.add(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 2132021957(0x7f1412c5, float:1.968232E38)
            java.lang.String r5 = r13.getString(r5)
            r4.append(r5)
            java.lang.String r5 = "(%s)"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r0
            java.lang.String r4 = java.lang.String.format(r4, r7)
            java.lang.String r7 = "sell-market"
            boolean r8 = r7.equals(r3)
            java.lang.String r10 = "buy-market"
            if (r8 != 0) goto L_0x00a5
            boolean r8 = r10.equals(r3)
            if (r8 == 0) goto L_0x0090
            goto L_0x00a5
        L_0x0090:
            com.huobi.trade.bean.TradeOrderHistory r8 = r13.f78116b
            java.lang.String r8 = r8.getOrder_price()
            com.huobi.trade.bean.TradeOrderHistory r11 = r13.f78116b
            java.lang.String r11 = r11.getSymbolId()
            int r11 = com.hbg.lib.data.symbol.PrecisionUtil.A(r11)
            java.lang.String r8 = i6.m.m(r8, r11)
            goto L_0x00ac
        L_0x00a5:
            r8 = 2132021960(0x7f1412c8, float:1.9682326E38)
            java.lang.String r8 = r13.getString(r8)
        L_0x00ac:
            com.huobi.order.bean.TradeOrderDetailTopItem r11 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r11.<init>(r4, r8)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r4 = r13.f78119e
            r4.add(r11)
            com.huobi.trade.bean.TradeOrderHistory r4 = r13.f78116b
            java.lang.String r4 = r4.getMarketAmount()
            java.math.BigDecimal r4 = i6.m.a(r4)
            java.math.BigDecimal r8 = java.math.BigDecimal.ZERO
            int r4 = r4.compareTo(r8)
            r8 = 2132021970(0x7f1412d2, float:1.9682346E38)
            r11 = 2132021956(0x7f1412c4, float:1.9682318E38)
            if (r4 <= 0) goto L_0x0135
            boolean r4 = r10.equals(r3)
            if (r4 == 0) goto L_0x0105
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = r13.getString(r11)
            r4.append(r8)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r8[r9] = r2
            java.lang.String r4 = java.lang.String.format(r4, r8)
            com.huobi.trade.bean.TradeOrderHistory r8 = r13.f78116b
            java.lang.String r8 = r8.getMarketAmount()
            com.huobi.trade.bean.TradeOrderHistory r11 = r13.f78116b
            java.lang.String r11 = r11.getSymbolId()
            int r11 = com.hbg.lib.data.symbol.PrecisionUtil.C(r11)
            java.lang.String r8 = i6.m.m(r8, r11)
            goto L_0x019a
        L_0x0105:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = r13.getString(r8)
            r4.append(r8)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r8[r9] = r0
            java.lang.String r4 = java.lang.String.format(r4, r8)
            com.huobi.trade.bean.TradeOrderHistory r8 = r13.f78116b
            java.lang.String r8 = r8.getMarketAmount()
            com.huobi.trade.bean.TradeOrderHistory r11 = r13.f78116b
            java.lang.String r11 = r11.getSymbolId()
            int r11 = com.hbg.lib.data.symbol.PrecisionUtil.y(r11)
            java.lang.String r8 = i6.m.m(r8, r11)
            goto L_0x019a
        L_0x0135:
            boolean r4 = r10.equals(r3)
            if (r4 == 0) goto L_0x016b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = r13.getString(r8)
            r4.append(r8)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r8[r9] = r0
            java.lang.String r4 = java.lang.String.format(r4, r8)
            com.huobi.trade.bean.TradeOrderHistory r8 = r13.f78116b
            java.lang.String r8 = r8.getOrder_tprice()
            com.huobi.trade.bean.TradeOrderHistory r11 = r13.f78116b
            java.lang.String r11 = r11.getSymbolId()
            int r11 = com.hbg.lib.data.symbol.PrecisionUtil.y(r11)
            java.lang.String r8 = i6.m.m(r8, r11)
            goto L_0x019a
        L_0x016b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = r13.getString(r11)
            r4.append(r8)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r8[r9] = r2
            java.lang.String r4 = java.lang.String.format(r4, r8)
            com.huobi.trade.bean.TradeOrderHistory r8 = r13.f78116b
            java.lang.String r8 = r8.getOrder_amount()
            com.huobi.trade.bean.TradeOrderHistory r11 = r13.f78116b
            java.lang.String r11 = r11.getSymbolId()
            int r11 = com.hbg.lib.data.symbol.PrecisionUtil.z(r11)
            java.lang.String r8 = i6.m.m(r8, r11)
        L_0x019a:
            com.huobi.order.bean.TradeOrderDetailTopItem r11 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r11.<init>(r4, r8)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r4 = r13.f78119e
            r4.add(r11)
            boolean r4 = com.huobi.trade.bean.TradeOrderType.c(r3)
            r8 = 2132021938(0x7f1412b2, float:1.9682281E38)
            r11 = 2132021963(0x7f1412cb, float:1.9682332E38)
            r12 = 2132021964(0x7f1412cc, float:1.9682334E38)
            if (r4 == 0) goto L_0x0206
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r13.getString(r12)
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r9] = r0
            java.lang.String r3 = java.lang.String.format(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r13.getString(r11)
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r0
            java.lang.String r0 = java.lang.String.format(r4, r7)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r13.getString(r8)
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r2
            java.lang.String r4 = java.lang.String.format(r4, r7)
            goto L_0x031b
        L_0x0206:
            boolean r4 = com.huobi.trade.bean.TradeOrderType.d(r3)
            if (r4 == 0) goto L_0x025f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r13.getString(r12)
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r9] = r0
            java.lang.String r3 = java.lang.String.format(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r13.getString(r11)
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r0
            java.lang.String r0 = java.lang.String.format(r4, r7)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r13.getString(r8)
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r2
            java.lang.String r4 = java.lang.String.format(r4, r7)
            goto L_0x031b
        L_0x025f:
            boolean r4 = r10.equals(r3)
            if (r4 == 0) goto L_0x02b7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r13.getString(r12)
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r9] = r0
            java.lang.String r3 = java.lang.String.format(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r13.getString(r11)
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r0
            java.lang.String r0 = java.lang.String.format(r4, r7)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r13.getString(r8)
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r2
            java.lang.String r4 = java.lang.String.format(r4, r7)
            goto L_0x031b
        L_0x02b7:
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x030f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r13.getString(r12)
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r9] = r0
            java.lang.String r3 = java.lang.String.format(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r13.getString(r11)
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r0
            java.lang.String r0 = java.lang.String.format(r4, r7)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r13.getString(r8)
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r7 = new java.lang.Object[r6]
            r7[r9] = r2
            java.lang.String r4 = java.lang.String.format(r4, r7)
            goto L_0x031b
        L_0x030f:
            java.lang.String r3 = r13.getString(r12)
            java.lang.String r0 = r13.getString(r11)
            java.lang.String r4 = r13.getString(r8)
        L_0x031b:
            com.huobi.trade.bean.TradeOrderHistory r7 = r13.f78116b
            java.lang.String r7 = r7.getTprice()
            com.huobi.trade.bean.TradeOrderHistory r8 = r13.f78116b
            java.lang.String r8 = r8.getSymbolId()
            int r8 = com.hbg.lib.data.symbol.PrecisionUtil.y(r8)
            java.lang.String r7 = i6.m.m(r7, r8)
            com.huobi.order.bean.TradeOrderDetailTopItem r8 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r8.<init>(r3, r7)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r3 = r13.f78119e
            r3.add(r8)
            com.huobi.trade.bean.TradeOrderHistory r3 = r13.f78116b
            java.lang.String r3 = r3.getAprice()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x034c
            com.huobi.trade.bean.TradeOrderHistory r3 = r13.f78116b
            java.lang.String r7 = "0"
            r3.setAprice(r7)
        L_0x034c:
            com.huobi.trade.bean.TradeOrderHistory r3 = r13.f78116b
            int r3 = r13.Y(r3)
            r7 = 2132027010(0x7f142682, float:1.9692569E38)
            if (r3 >= r6) goto L_0x035c
            java.lang.String r8 = r13.getString(r7)
            goto L_0x0370
        L_0x035c:
            com.huobi.trade.bean.TradeOrderHistory r8 = r13.f78116b
            java.lang.String r8 = r8.getAprice()
            com.huobi.trade.bean.TradeOrderHistory r10 = r13.f78116b
            java.lang.String r10 = r10.getSymbolId()
            int r10 = com.hbg.lib.data.symbol.PrecisionUtil.A(r10)
            java.lang.String r8 = i6.m.m(r8, r10)
        L_0x0370:
            com.huobi.order.bean.TradeOrderDetailTopItem r10 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r10.<init>(r0, r8)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r0 = r13.f78119e
            r0.add(r10)
            if (r3 >= r6) goto L_0x0381
            java.lang.String r0 = r13.getString(r7)
            goto L_0x0395
        L_0x0381:
            com.huobi.trade.bean.TradeOrderHistory r0 = r13.f78116b
            java.lang.String r0 = r0.getTamount()
            com.huobi.trade.bean.TradeOrderHistory r3 = r13.f78116b
            java.lang.String r3 = r3.getSymbolId()
            int r3 = com.hbg.lib.data.symbol.PrecisionUtil.z(r3)
            java.lang.String r0 = i6.m.m(r0, r3)
        L_0x0395:
            com.huobi.order.bean.TradeOrderDetailTopItem r3 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r3.<init>(r4, r0)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r0 = r13.f78119e
            r0.add(r3)
            com.huobi.trade.bean.TradeOrderHistory r0 = r13.f78116b
            java.lang.String r0 = r0.getIceAmount()
            java.math.BigDecimal r0 = i6.m.a(r0)
            java.math.BigDecimal r3 = java.math.BigDecimal.ZERO
            int r3 = r0.compareTo(r3)
            if (r3 <= 0) goto L_0x03e7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 2132025080(0x7f141ef8, float:1.9688654E38)
            java.lang.String r4 = r13.getString(r4)
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r9] = r2
            java.lang.String r2 = java.lang.String.format(r3, r4)
            com.huobi.trade.bean.TradeOrderHistory r3 = r13.f78116b
            java.lang.String r3 = r3.getSymbolId()
            int r3 = com.hbg.lib.data.symbol.PrecisionUtil.z(r3)
            java.lang.String r0 = i6.m.q(r0, r3)
            com.huobi.order.bean.TradeOrderDetailTopItem r3 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r3.<init>(r2, r0)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r0 = r13.f78119e
            r0.add(r3)
        L_0x03e7:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList<com.huobi.order.bean.OrderBeanDetails> r2 = r13.f78117c
            java.util.Iterator r2 = r2.iterator()
        L_0x03f2:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x047f
            java.lang.Object r3 = r2.next()
            com.huobi.order.bean.OrderBeanDetails r3 = (com.huobi.order.bean.OrderBeanDetails) r3
            com.huobi.order.ui.TradeOrderHistoryDetailActivity$FeedData r4 = new com.huobi.order.ui.TradeOrderHistoryDetailActivity$FeedData
            r4.<init>()
            java.lang.String r8 = r3.getSymbol()
            r4.f78214a = r8
            java.lang.String r8 = r3.getFeeCurrency()
            r4.f78215b = r8
            java.lang.String r8 = r3.getFeeDeductCurrency()
            r4.f78216c = r8
            boolean r8 = r0.contains(r4)
            if (r8 == 0) goto L_0x046e
            int r4 = r0.indexOf(r4)
            java.lang.Object r4 = r0.get(r4)
            com.huobi.order.ui.TradeOrderHistoryDetailActivity$FeedData r4 = (com.huobi.order.ui.TradeOrderHistoryDetailActivity.FeedData) r4
            java.lang.String r8 = r3.getFilledPoints()     // Catch:{ Exception -> 0x0449 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0449 }
            if (r8 != 0) goto L_0x0449
            java.math.BigDecimal r8 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0449 }
            java.lang.String r10 = r4.f78217d     // Catch:{ Exception -> 0x0449 }
            r8.<init>(r10)     // Catch:{ Exception -> 0x0449 }
            java.math.BigDecimal r10 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0449 }
            java.lang.String r11 = r3.getFilledPoints()     // Catch:{ Exception -> 0x0449 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0449 }
            java.math.BigDecimal r8 = r8.add(r10)     // Catch:{ Exception -> 0x0449 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0449 }
            r4.f78217d = r8     // Catch:{ Exception -> 0x0449 }
        L_0x0449:
            java.lang.String r8 = r3.getFilledFees()     // Catch:{ Exception -> 0x03f2 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x03f2 }
            if (r8 != 0) goto L_0x03f2
            java.math.BigDecimal r8 = new java.math.BigDecimal     // Catch:{ Exception -> 0x03f2 }
            java.lang.String r10 = r4.f78218e     // Catch:{ Exception -> 0x03f2 }
            r8.<init>(r10)     // Catch:{ Exception -> 0x03f2 }
            java.math.BigDecimal r10 = new java.math.BigDecimal     // Catch:{ Exception -> 0x03f2 }
            java.lang.String r3 = r3.getFilledFees()     // Catch:{ Exception -> 0x03f2 }
            r10.<init>(r3)     // Catch:{ Exception -> 0x03f2 }
            java.math.BigDecimal r3 = r8.add(r10)     // Catch:{ Exception -> 0x03f2 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x03f2 }
            r4.f78218e = r3     // Catch:{ Exception -> 0x03f2 }
            goto L_0x03f2
        L_0x046e:
            java.lang.String r8 = r3.getFilledPoints()     // Catch:{ Exception -> 0x0474 }
            r4.f78217d = r8     // Catch:{ Exception -> 0x0474 }
        L_0x0474:
            java.lang.String r3 = r3.getFilledFees()     // Catch:{ Exception -> 0x047a }
            r4.f78218e = r3     // Catch:{ Exception -> 0x047a }
        L_0x047a:
            r0.add(r4)
            goto L_0x03f2
        L_0x047f:
            int r2 = r0.size()
            r3 = 2132021933(0x7f1412ad, float:1.9682271E38)
            if (r2 <= 0) goto L_0x05b5
            com.huobi.trade.bean.TradeOrderHistory r2 = r13.f78116b
            boolean r2 = r2.isFeeAvailable()
            if (r2 == 0) goto L_0x05b5
            int r2 = r0.size()
            int r2 = r2 - r6
            java.lang.Object r2 = r0.get(r2)
            com.huobi.order.ui.TradeOrderHistoryDetailActivity$FeedData r2 = (com.huobi.order.ui.TradeOrderHistoryDetailActivity.FeedData) r2
            java.lang.String r4 = r2.f78216c
            java.lang.String r7 = "ht"
            boolean r4 = r4.equalsIgnoreCase(r7)
            java.lang.String r7 = "hbpoint"
            java.lang.String r8 = "pts"
            if (r4 == 0) goto L_0x04ac
            java.lang.String r4 = "HT"
            goto L_0x04df
        L_0x04ac:
            java.lang.String r4 = r2.f78216c
            java.lang.String r10 = "trx"
            boolean r4 = r4.equalsIgnoreCase(r10)
            if (r4 == 0) goto L_0x04b9
            java.lang.String r4 = "TRX"
            goto L_0x04df
        L_0x04b9:
            java.lang.String r4 = r2.f78216c
            java.lang.String r10 = "htx"
            boolean r4 = r4.equalsIgnoreCase(r10)
            if (r4 == 0) goto L_0x04c6
            java.lang.String r4 = "HTX"
            goto L_0x04df
        L_0x04c6:
            java.lang.String r4 = r2.f78216c
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x04de
            java.lang.String r4 = r2.f78216c
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x04d7
            goto L_0x04de
        L_0x04d7:
            java.lang.String r4 = r2.f78215b
            java.lang.String r4 = r4.toUpperCase()
            goto L_0x04df
        L_0x04de:
            r4 = r8
        L_0x04df:
            java.util.Locale r10 = java.util.Locale.US
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = r13.getString(r3)
            r11.append(r3)
            r11.append(r5)
            java.lang.String r3 = r11.toString()
            java.lang.Object[] r5 = new java.lang.Object[r6]
            r5[r9] = r4
            java.lang.String r3 = java.lang.String.format(r10, r3, r5)
            java.lang.String r4 = r2.f78216c
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x05a8
            java.lang.String r4 = r2.f78216c
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x050e
            goto L_0x05a8
        L_0x050e:
            java.lang.String r4 = r2.f78216c
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0532
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r2.f78218e
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.String r4 = r2.f78214a
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.c(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
            goto L_0x054d
        L_0x0532:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r2.f78217d
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.String r4 = r2.f78214a
            int r4 = com.hbg.lib.data.symbol.PrecisionUtil.c(r4)
            java.lang.String r1 = i6.m.m(r1, r4)
        L_0x054d:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r5 = "+"
            if (r4 != 0) goto L_0x0582
            java.math.BigDecimal r1 = i6.m.a(r1)
            java.lang.String r4 = "-1"
            java.math.BigDecimal r4 = i6.m.a(r4)
            java.math.BigDecimal r1 = r1.multiply(r4)
            java.lang.String r1 = r1.toPlainString()
            java.math.BigDecimal r4 = i6.m.a(r1)
            java.math.BigDecimal r7 = java.math.BigDecimal.ZERO
            int r4 = r4.compareTo(r7)
            if (r4 != r6) goto L_0x0582
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
        L_0x0582:
            java.lang.String r2 = r2.f78214a
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.c(r2)
            java.lang.String r1 = i6.m.m(r1, r2)
            java.math.BigDecimal r2 = i6.m.a(r1)
            java.math.BigDecimal r4 = java.math.BigDecimal.ZERO
            int r2 = r2.compareTo(r4)
            if (r2 != r6) goto L_0x05bd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x05bd
        L_0x05a8:
            java.lang.String r1 = r2.f78217d
            java.lang.String r2 = r2.f78214a
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.c(r2)
            java.lang.String r1 = i6.m.m(r1, r2)
            goto L_0x05bd
        L_0x05b5:
            java.lang.String r3 = r13.getString(r3)
            java.lang.String r1 = r13.getString(r7)
        L_0x05bd:
            com.huobi.order.bean.TradeOrderDetailTopItem r2 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r2.<init>(r3, r1)
            int r1 = r0.size()
            r3 = 2
            if (r1 < r3) goto L_0x05d8
            r1 = 2131233450(0x7f080aaa, float:1.8083038E38)
            com.huobi.order.bean.TradeOrderDetailTopItem r1 = r2.setTitleRightRes(r1)
            xo.b r3 = new xo.b
            r3.<init>(r13, r0)
            r1.setTitleClickListener(r3)
        L_0x05d8:
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r0 = r13.f78119e
            r0.add(r2)
            com.huobi.order.bean.TradeOrderDetailTopItem r0 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r1 = 2132021932(0x7f1412ac, float:1.968227E38)
            java.lang.String r1 = r13.getString(r1)
            com.huobi.trade.bean.TradeOrderHistory r2 = r13.f78116b
            long r2 = r2.getOrder_time()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            java.lang.String r2 = com.hbg.lib.common.utils.DateTimeUtils.D(r2)
            r0.<init>(r1, r2)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r1 = r13.f78119e
            r1.add(r0)
            com.huobi.order.bean.TradeOrderDetailTopItem r0 = new com.huobi.order.bean.TradeOrderDetailTopItem
            r1 = 2132021942(0x7f1412b6, float:1.968229E38)
            java.lang.String r1 = r13.getString(r1)
            com.huobi.trade.bean.TradeOrderHistory r2 = r13.f78116b
            long r2 = r2.getUpdateAt()
            long r2 = r2 * r4
            java.lang.String r2 = com.hbg.lib.common.utils.DateTimeUtils.D(r2)
            r0.<init>(r1, r2)
            java.util.ArrayList<com.huobi.order.bean.TradeOrderDetailTopItem> r1 = r13.f78119e
            r1.add(r0)
            v9.a<com.huobi.order.bean.TradeOrderDetailTopItem> r0 = r13.f78120f
            r0.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.order.persenter.TradeOrderHistoryDetailPresenter.f0():void");
    }

    public void g0() {
        ((OrderService) p.X(TradeType.PRO, OrderService.class)).matchResults(String.valueOf(this.f78116b.getId())).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).map(new c(this)).subscribe(new a());
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        this.f78117c.clear();
        this.f78119e.clear();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (TextUtils.isEmpty(proTokenUpdate.getProToken()) && getUI() != null && ((b) getUI()).isAlive()) {
            getActivity().finish();
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((b) getUI()).isAlive()) {
            getActivity().finish();
        }
    }
}
