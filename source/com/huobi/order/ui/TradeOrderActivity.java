package com.huobi.order.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import bt.f0;
import bt.h1;
import bt.n1;
import bt.r0;
import bt.v;
import bt.z0;
import bt.z1;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.AlgoOrderCancelResult;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.bean.CancelOpenOrdersResult;
import com.hbg.lib.network.pro.core.bean.PlanCancelOpenOrdersResult;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.BaseOrderFilterDialogFragment;
import com.hbg.lib.widgets.CommonTabSelectorView;
import com.hbg.lib.widgets.TradeOrderMoreFilterView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.assetrecord.AppleOrderHistoryRecordActivity;
import com.huobi.order.bean.CurrentTimeTradeInfo;
import com.huobi.order.bean.OrderBean;
import com.huobi.order.bean.TimeTradeInfo;
import com.huobi.order.persenter.OrderListFragmentPresenter;
import com.huobi.order.ui.CurrentOrderFilterDialogFragment;
import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.utils.k0;
import com.huobi.view.BasePopupWindow;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qk.v0;
import rx.Subscription;
import y9.a;
import yo.s0;

public class TradeOrderActivity extends BaseOrderActivity implements ho.a, ct.d, CurrentOrderFilterDialogFragment.b, BasePopupWindow.PopupWindowListener {
    public View A;
    public TextView B;
    public int C;
    public int D;
    public View E;
    public TextView F;
    public View G;
    public TextView H;
    public View I;
    public TextView J;
    public TradeOrderMoreFilterView K;
    public CommonTabSelectorView L;
    public a.C0825a M = new h();
    public String N;
    public String O;
    public Runnable P = new p(this);
    public Runnable Q = new p(this);

    /* renamed from: n  reason: collision with root package name */
    public Subscription f78183n;

    /* renamed from: o  reason: collision with root package name */
    public String f78184o;

    /* renamed from: p  reason: collision with root package name */
    public String f78185p;

    /* renamed from: q  reason: collision with root package name */
    public int f78186q;

    /* renamed from: r  reason: collision with root package name */
    public String f78187r;

    /* renamed from: s  reason: collision with root package name */
    public String f78188s;

    /* renamed from: t  reason: collision with root package name */
    public long f78189t;

    /* renamed from: u  reason: collision with root package name */
    public long f78190u;

    /* renamed from: v  reason: collision with root package name */
    public TradeType f78191v;

    /* renamed from: w  reason: collision with root package name */
    public List<String> f78192w;

    /* renamed from: x  reason: collision with root package name */
    public io.c f78193x;

    /* renamed from: y  reason: collision with root package name */
    public io.b f78194y;

    /* renamed from: z  reason: collision with root package name */
    public Map<String, BaseOrderFilterDialogFragment> f78195z = new HashMap();

    public class a extends q6.b<PlanCancelOpenOrdersResult> {
        public a(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: a */
        public void onRequestSuccess(PlanCancelOpenOrdersResult planCancelOpenOrdersResult) {
            super.onRequestSuccess(planCancelOpenOrdersResult);
            i6.i.b().g(TradeOrderActivity.this.P, 500);
        }
    }

    public class b extends EasySubscriber<PlanCancelOpenOrdersResult> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(PlanCancelOpenOrdersResult planCancelOpenOrdersResult) {
            super.onNext(planCancelOpenOrdersResult);
            if (planCancelOpenOrdersResult.getNextId() < 0) {
                HuobiToastUtil.s(R.string.n_order_cancel_success_toast);
            } else if (planCancelOpenOrdersResult.getFailed() == 0 && planCancelOpenOrdersResult.getNextId() > 0) {
                HuobiToastUtil.j(R.string.n_order_cancel_more_toast);
            } else if (planCancelOpenOrdersResult.getFailed() > 0) {
                String valueOf = String.valueOf(planCancelOpenOrdersResult.getFailed());
                HuobiToastUtil.m(String.format(Locale.US, TradeOrderActivity.this.getString(R.string.n_order_cancel_part_failed_toast), new Object[]{valueOf}));
            }
        }

        public void onAfter() {
            super.onAfter();
            TradeOrderActivity.this.getUI().dismissProgressDialog();
            i6.i.b().g(TradeOrderActivity.this.P, 500);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
            } else {
                HuobiToastUtil.j(R.string.n_order_cancel_failed_toast);
            }
        }

        public void onStart() {
            super.onStart();
            TradeOrderActivity.this.getUI().showProgressDialog();
        }
    }

    public class c extends EasySubscriber<CancelOpenOrdersResult> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(CancelOpenOrdersResult cancelOpenOrdersResult) {
            super.onNext(cancelOpenOrdersResult);
            if (cancelOpenOrdersResult.getNextId() == -1) {
                HuobiToastUtil.s(R.string.n_order_cancel_success_toast);
            } else if (cancelOpenOrdersResult.getFailedCount() == 0 && cancelOpenOrdersResult.getNextId() > 0) {
                HuobiToastUtil.j(R.string.n_order_cancel_more_toast);
            } else if (cancelOpenOrdersResult.getFailedCount() > 0) {
                String valueOf = String.valueOf(cancelOpenOrdersResult.getFailedCount());
                HuobiToastUtil.m(String.format(Locale.US, TradeOrderActivity.this.getString(R.string.n_order_cancel_part_failed_toast), new Object[]{valueOf}));
            }
        }

        public void onAfter() {
            super.onAfter();
            TradeOrderActivity.this.getUI().dismissProgressDialog();
            i6.i.b().g(TradeOrderActivity.this.P, 500);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            HuobiToastUtil.j(R.string.n_order_cancel_failed_toast);
        }

        public void onStart() {
            super.onStart();
            TradeOrderActivity.this.getUI().showProgressDialog();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeOrderActivity.this.Ei();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements CommonTabSelectorView.b {
        public e() {
        }

        public void onHide() {
            TradeOrderActivity tradeOrderActivity = TradeOrderActivity.this;
            tradeOrderActivity.Ai(tradeOrderActivity.F, true);
        }

        public void onShow() {
            TradeOrderActivity tradeOrderActivity = TradeOrderActivity.this;
            tradeOrderActivity.Ai(tradeOrderActivity.F, false);
        }
    }

    public class f implements TradeOrderMoreFilterView.e {
        public f() {
        }

        public void a(int i11, long j11, long j12, int i12, int i13) {
            int unused = TradeOrderActivity.this.f78186q = i11;
            String unused2 = TradeOrderActivity.this.f78187r = TradeOrderMoreFilterView.A(j11);
            long unused3 = TradeOrderActivity.this.f78190u = j11;
            String unused4 = TradeOrderActivity.this.f78188s = TradeOrderMoreFilterView.A(j12);
            long unused5 = TradeOrderActivity.this.f78189t = j12;
            int i14 = 2;
            if (i13 == 2) {
                i14 = 1;
            } else if (i13 != 3) {
                i14 = 0;
            }
            i6.k.o("TradeOrder", "user select order more : " + i14);
            zo.a.g().n(i14);
            if (zo.a.g().j()) {
                zo.a.g().q(i12);
            } else if (zo.a.g().k()) {
                zo.a.g().r(i12);
            } else {
                zo.a.g().m(i12);
            }
            TradeOrderActivity.this.Ch();
            TradeOrderActivity.this.K.B();
        }

        public void onHide() {
        }

        public void onShow() {
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeOrderActivity.this.Ci();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class h implements a.C0825a {
        public h() {
        }

        public void a(y9.a aVar) {
            int c11 = zo.a.g().c();
            int e11 = aVar.e();
            i6.k.o("TradeOrder", "user select order type : " + e11);
            if (c11 != e11) {
                zo.a.g().o(e11);
                zo.a.g().m(0);
                zo.a.g().q(10);
                zo.a.g().r(20);
            }
            TradeOrderActivity.this.Ji();
            TradeOrderActivity.this.Ch();
            TradeOrderActivity.this.L.d();
        }

        public boolean b(y9.a aVar) {
            return zo.a.g().c() == aVar.e();
        }
    }

    public class i implements CurrentTimeTradeInfo.a {
        public i() {
        }

        public void a(CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
            Intent intent = new Intent();
            intent.setClass(context, TimeTradeDetailOrderActivity.class);
            intent.putExtra("clientOrderId", currentTimeTradeInfo.getOrderInfo().getClientOrderId());
            context.startActivity(intent);
        }

        public void b(CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
            k0.O(TradeOrderActivity.this, currentTimeTradeInfo.getSymbol(), "buy".equals(currentTimeTradeInfo.getOrderInfo().getOrderSide()));
        }

        public void c(CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
            TradeOrderActivity.this.fi(context, currentTimeTradeInfo.getOrderInfo());
        }
    }

    public class j extends q6.d<AlgoOrderCancelResult> {
        public j(u6.g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(AlgoOrderCancelResult algoOrderCancelResult) {
            super.onNext(algoOrderCancelResult);
            HuobiToastUtil.t(bh.j.c(), R.string.n_exchange_timing_stop_order_success);
        }

        public void onAfter() {
            super.onAfter();
            EventBus.d().k(new AssetAndOrderUpdateEvent());
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
            HuobiToastUtil.k(bh.j.c(), R.string.n_order_cancel_failed_toast);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            String errCode = aPIStatusErrorException.getErrCode();
            if (!errCode.equals("5007") && !errCode.equals("5008") && !errCode.equals("5009")) {
                super.onFailed(aPIStatusErrorException);
            } else if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
            }
        }
    }

    public class k implements TimeTradeInfo.a {
        public k() {
        }
    }

    public static void Fi(Context context, TradeType tradeType, String str) {
        BaseOrderActivity.Eh(context, di(context, tradeType, str, 0));
    }

    public static void Gi(Context context, TradeType tradeType, String str, int i11) {
        BaseOrderActivity.Eh(context, di(context, tradeType, str, i11));
    }

    public static void Hi(Context context, TradeType tradeType, String str, int i11, int i12) {
        BaseOrderActivity.Eh(context, ei(context, tradeType, str, i11, i12));
    }

    public static Intent di(Context context, TradeType tradeType, String str, int i11) {
        return ei(context, tradeType, str, i11, 0);
    }

    public static Intent ei(Context context, TradeType tradeType, String str, int i11, int i12) {
        Intent intent = new Intent(context, TradeOrderActivity.class);
        intent.putExtra("extra_trade_type", tradeType.toString());
        intent.putExtra("extra_symbol", str);
        intent.putExtra("EXTRA_ORDER_TYPE", i11);
        intent.putExtra("EXTRA_ORDER_PAGE", i12);
        return intent;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Di();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ti(vo.a aVar, Context context) {
        k0.O(this, aVar.f(), "buy".equals(aVar.e().getOrderSide()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ui(OrderBean orderBean, Context context) {
        k0.O(this, orderBean.getSymbol(), orderBean.isBuy());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ji();
    }

    public void Ah() {
        yi((String) null);
        xi((String) null);
        Bh();
    }

    public final void Ai(TextView textView, boolean z11) {
        if (z11) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_down, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_up, 0);
        }
    }

    public void Bi() {
        DialogUtils.b0(this, getString(R.string.n_login_tip), ki(), "", getString(R.string.n_cancel), getString(R.string.n_confirm), ad.b.f3517a, new n(this));
    }

    public void Ch() {
        if (isAlive()) {
            if (Pg().yh() != null) {
                if (zo.a.g().d() == 0) {
                    ((OrderListFragmentPresenter) Pg().yh()).f0(Og());
                } else if (zo.a.g().d() == 1) {
                    ((OrderListFragmentPresenter) Pg().yh()).f0(oh());
                } else if (zo.a.g().d() == 2) {
                    ((OrderListFragmentPresenter) Pg().yh()).f0(Qg());
                }
            }
            super.Ch();
        }
    }

    public final void Ci() {
        Ai(this.H, false);
        li().show(getSupportFragmentManager(), mi());
    }

    public TradeType D0() {
        return this.f78191v;
    }

    public final void Di() {
        int i11;
        int b11 = zo.a.g().b();
        this.K.setDirection(b11 != 1 ? b11 != 2 ? 1 : 3 : 2);
        int i12 = this.f78186q;
        if (i12 == 0) {
            this.K.setStartTime(this.f78190u);
            this.K.setEndTime(this.f78189t);
        } else {
            this.K.setDateType(i12);
        }
        this.K.setStatusVisible(zo.a.g().d() == 1);
        this.K.setTimeVisible(zo.a.g().d() != 0);
        ArrayList arrayList = new ArrayList();
        if (zo.a.g().j()) {
            i11 = zo.a.g().e();
            arrayList.add(new y9.a(10, getString(R.string.n_trade_all_status)));
            arrayList.add(new y9.a(13, getString(R.string.n_exchange_order_triggered)));
            arrayList.add(new y9.a(12, getString(R.string.n_exchange_order_rejected)));
            arrayList.add(new y9.a(11, getString(R.string.n_exchange_order_canceled)));
        } else if (zo.a.g().k()) {
            i11 = zo.a.g().f();
            arrayList.add(new y9.a(20, getString(R.string.n_trade_all_status)));
            arrayList.add(new y9.a(22, getString(R.string.n_exchange_order_rejected)));
            arrayList.add(new y9.a(23, getString(R.string.n_exchange_order_finished)));
            arrayList.add(new y9.a(24, getString(R.string.n_exchange_order_canceled)));
            arrayList.add(new y9.a(25, getString(R.string.n_exchange_order_stopped)));
        } else {
            int a11 = zo.a.g().a();
            arrayList.add(new y9.a(0, getString(R.string.n_trade_all_status)));
            arrayList.add(new y9.a(1, getString(R.string.n_exchange_order_list_completed)));
            arrayList.add(new y9.a(2, getString(R.string.n_exchange_order_list_canceled)));
            i11 = a11;
        }
        this.K.V(i11, arrayList);
        this.K.X();
    }

    public String Ec() {
        return this.f78187r;
    }

    public final void Ei() {
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        arrayList.add(new y9.a(0, getString(R.string.n_exchange_limit_or_market), this.M));
        arrayList.add(new y9.a(1, getString(R.string.trade_trend_stop), this.M));
        if (!zo.a.g().i()) {
            arrayList.add(new y9.a(2, getString(R.string.contract_order_type_trigger), this.M));
        }
        if (D0() == TradeType.PRO) {
            z11 = true;
        }
        if (v0.b().c(z11)) {
            arrayList.add(new y9.a(3, getString(R.string.n_exchange_timing_deal), this.M));
        }
        this.L.setDataList(arrayList);
        this.L.h();
    }

    public void Fh(int i11) {
        zo.a.g().p(i11);
        if (zo.a.g().i() && zo.a.g().j()) {
            zo.a.g().o(0);
            Ji();
        }
        super.Fh(i11);
        Ii();
    }

    public final void Ii() {
        if (vh() || wh()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.n_exchange_filled_orders_tip2) + getString(R.string.n_exchange_filled_orders_tip_view_detail));
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(getString(R.string.n_exchange_filled_orders_tip_view_detail));
            int indexOf = spannableStringBuilder.toString().indexOf(spannableStringBuilder2.toString());
            if (indexOf > 0 && spannableStringBuilder2.length() + indexOf <= spannableStringBuilder.length()) {
                spannableStringBuilder.setSpan(new URLSpan(spannableStringBuilder.toString()) {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        AppleOrderHistoryRecordActivity.Hh(TradeOrderActivity.this);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }

                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(ContextCompat.getColor(TradeOrderActivity.this, R.color.color_privacy_agreement_majortheme100));
                        textPaint.setUnderlineText(false);
                    }
                }, indexOf, spannableStringBuilder2.length() + indexOf, 17);
            }
            this.B.setMovementMethod(LinkMovementMethod.getInstance());
            this.B.setHighlightColor(getResources().getColor(17170445));
            this.B.setText(spannableStringBuilder);
            ViewUtil.m(this.A, true);
            ii(0);
            return;
        }
        ViewUtil.m(this.A, false);
    }

    public final void Ji() {
        int c11 = zo.a.g().c();
        if (c11 == 0) {
            this.F.setText(R.string.n_exchange_limit_or_market);
        } else if (c11 == 1) {
            this.F.setText(R.string.trade_trend_stop);
        } else if (c11 == 2) {
            this.F.setText(R.string.contract_order_type_trigger);
        } else if (c11 == 3) {
            this.F.setText(R.string.n_exchange_timing_deal);
        }
    }

    public String M7() {
        return this.f78188s;
    }

    public int N2() {
        return 10;
    }

    public SmartRefreshPageSplitter.c Og() {
        if (ri()) {
            int b11 = zo.a.g().b();
            if (1 == b11) {
                yi("buy");
            } else if (2 == b11) {
                yi("sell");
            } else {
                yi((String) null);
            }
            return new bt.k(this, new q(this));
        }
        int b12 = zo.a.g().b();
        int c11 = zo.a.g().c();
        if (c11 == 1) {
            if (1 == b12) {
                yi("buy-stop-limit,buy-stop-limit-fok");
            } else if (2 == b12) {
                yi("sell-stop-limit,sell-stop-limit-fok");
            } else {
                yi("buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok");
            }
        } else if (c11 == 3) {
            if (1 == b12) {
                yi("buy");
            } else if (2 == b12) {
                yi("sell");
            } else {
                yi((String) null);
            }
            return new v(this, new i());
        } else if (1 == b12) {
            yi("buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok");
        } else if (2 == b12) {
            yi("sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok");
        } else {
            yi("buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok");
        }
        xi((String) null);
        return new f0(this, new o(this));
    }

    public void Q() {
    }

    public SmartRefreshPageSplitter.c Qg() {
        if (zo.a.g().d() == 2) {
            if (zo.a.g().c() == 1) {
                if (1 == zo.a.g().b()) {
                    yi("buy-stop-limit,buy-stop-limit-fok");
                } else if (2 == zo.a.g().b()) {
                    yi("sell-stop-limit,sell-stop-limit-fok");
                } else {
                    yi("buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok");
                }
            } else if (zo.a.g().c() == 0) {
                if (1 == zo.a.g().b()) {
                    yi("buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok");
                } else if (2 == zo.a.g().b()) {
                    yi("sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok");
                } else {
                    yi("buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok");
                }
            } else if (zo.a.g().c() == 3) {
                if (1 == zo.a.g().b()) {
                    yi("buy");
                } else if (2 == zo.a.g().b()) {
                    yi("sell");
                } else {
                    yi((String) null);
                }
                return new z1(this);
            }
        }
        return new r0(this);
    }

    public void R(List list) {
        Pg().Kh();
        Dh();
    }

    public void W8(String str, boolean z11, String str2, String str3, String str4) {
        this.N = str3;
        this.O = str4;
        if (gi(z11, str)) {
            hi();
            bc(str);
            String str5 = null;
            String[] split = !TextUtils.isEmpty(str) ? str.split(Constants.ACCEPT_TIME_SEPARATOR_SP) : null;
            if (split != null && split.length > 1) {
                str5 = a1.v().p(split[0]);
            }
            if (TextUtils.isEmpty(str)) {
                this.H.setText(R.string.n_exchange_order_list_all_symbol);
            } else if (!TextUtils.isEmpty(str5)) {
                this.H.setText(String.format("%s/%s", new Object[]{str5, getResources().getString(R.string.n_exchange_order_list_all)}));
            } else {
                this.H.setText(String.format("%s/%s", new Object[]{a1.v().p(str), a1.v().F(str)}));
            }
            Ch();
            i6.k.o("TradeOrder", "sureClick isAllOrder - " + uh() + " isHisOrder -  " + wh() + " isDetailOrder - " + vh());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("symbol - ");
            sb2.append(str);
            i6.k.o("TradeOrder", sb2.toString());
        }
    }

    public void addEvent() {
        super.addEvent();
        this.E.setOnClickListener(new d());
        this.L.setCallback(new e());
        this.K.setCallback(new f());
        this.I.setOnClickListener(new m(this));
        this.G.setOnClickListener(new g());
    }

    public void afterInit() {
        pi();
        this.D = getResources().getDisplayMetrics().widthPixels;
        String stringExtra = getIntent().getStringExtra("extra_trade_type");
        zi(TextUtils.isEmpty(stringExtra) ? TradeType.PRO : TradeType.valueOf(stringExtra));
        qi();
        this.f78193x = new io.c(1, R.drawable.global_filter_unselected, this);
        this.f78194y = new io.b(2, R.drawable.selector_cancel_all, getString(R.string.n_margin_cancel_order), this);
        this.f78192w = a1.v().i();
        Ii();
        View view = this.A;
        if (view != null) {
            view.setX((float) this.D);
        }
        int c11 = zo.a.g().c();
        if (c11 == 2 || c11 == 3) {
            zo.a.g().m(0);
            zo.a.g().q(10);
            zo.a.g().r(20);
            zo.a.g().n(0);
        }
        Ji();
        Fh(getIntent().getIntExtra("EXTRA_ORDER_PAGE", 0));
    }

    public void e9(int i11, RecyclerView recyclerView, int i12, int i13) {
        super.e9(i11, recyclerView, i12, i13);
        if (i11 == 1 || i11 == 2) {
            int i14 = 0;
            if (i13 > 0) {
                i14 = this.A.getHeight();
            }
            ii(i14);
        }
    }

    public final void fi(Context context, AlgoOrderInfo algoOrderInfo) {
        u6.g gVar = context instanceof u6.g ? (u6.g) context : null;
        if (!NetworkStatus.c(bh.j.c())) {
            HuobiToastUtil.k(bh.j.c(), R.string.string_network_disconnect);
        } else {
            s0.d0().R(2, algoOrderInfo.getClientOrderId()).delay(1, TimeUnit.SECONDS).compose(RxJavaHelper.t(gVar)).subscribe(new j(gVar));
        }
    }

    public void finish() {
        super.finish();
    }

    public String getOrderType() {
        return this.f78184o;
    }

    public String getState() {
        return this.f78185p;
    }

    public final boolean gi(boolean z11, String str) {
        boolean z12 = true;
        if (z11) {
            return true;
        }
        if (!str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP) && !this.f78192w.contains(str)) {
            z12 = false;
        }
        if (!z12) {
            HuobiToastUtil.j(R.string.order_filter_no_symbol);
        }
        return z12;
    }

    public final void hi() {
        Ai(this.H, true);
        li().dismiss();
    }

    public final void ii(int i11) {
        if (this.C != i11) {
            this.C = i11;
            this.A.animate().translationY((float) this.C);
        }
    }

    public void initIntent(Intent intent) {
        super.initIntent(intent);
        zo.a.g().o(intent.getIntExtra("EXTRA_ORDER_TYPE", 0));
    }

    public void initView() {
        super.initView();
        this.K = (TradeOrderMoreFilterView) this.viewFinder.b(R.id.id_trade_order_more_filter);
        this.L = (CommonTabSelectorView) this.viewFinder.b(R.id.id_trade_order_tab_selector_view);
        this.B = (TextView) findViewById(R.id.id_trade_order_contract_bottom_tips_tv);
        this.A = findViewById(R.id.id_trade_order_contract_bottom_tips_bg);
        this.G = findViewById(R.id.fl_type1);
        this.H = (TextView) findViewById(R.id.tv_type1);
        this.E = findViewById(R.id.fl_type2);
        this.F = (TextView) findViewById(R.id.tv_type2);
        this.I = findViewById(R.id.fl_more);
        this.J = (TextView) findViewById(R.id.tv_more);
    }

    public final void ji() {
        if (ri()) {
            x8.a.a().p(o0(), ni(), 1).d(new a(getUI()));
        } else if (si()) {
            Subscription subscription = this.f78183n;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.f78183n = x8.a.a().p(o0(), ni(), 2).b().compose(RxJavaHelper.t(getUI())).subscribe(new b());
        } else {
            wi((Long) null);
        }
    }

    public final String ki() {
        String str;
        int c11 = zo.a.g().c();
        if (c11 == 1) {
            str = getString(R.string.n_order_cancel_stop_space);
        } else if (c11 != 3) {
            str = getString(R.string.n_order_cancel_normal_space);
        } else {
            str = getString(R.string.n_exchange_timing_deal);
        }
        String str2 = null;
        if (!TextUtils.isEmpty(this.N)) {
            if (TextUtils.isEmpty(this.O)) {
                str2 = StringUtils.i(this.N) + "/" + getResources().getString(R.string.n_exchange_order_list_all);
            } else {
                str2 = StringUtils.i(this.N) + "/" + StringUtils.i(this.O);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            int b11 = zo.a.g().b();
            if (b11 != 1) {
                if (b11 != 2) {
                    return String.format(Locale.US, getString(R.string.n_order_cancel_all_tips), new Object[]{str});
                } else if (zo.a.g().c() != 1) {
                    return String.format(Locale.US, getString(R.string.n_order_cancel_direction_tips), new Object[]{getString(R.string.n_order_cancel_normal_sell_space)});
                } else {
                    return String.format(Locale.US, getString(R.string.n_order_cancel_direction_tips), new Object[]{getString(R.string.n_order_cancel_stop_sell_space)});
                }
            } else if (zo.a.g().c() != 1) {
                return String.format(Locale.US, getString(R.string.n_order_cancel_direction_tips), new Object[]{getString(R.string.n_order_cancel_normal_buy_space)});
            } else {
                return String.format(Locale.US, getString(R.string.n_order_cancel_direction_tips), new Object[]{getString(R.string.n_order_cancel_stop_buy_space)});
            }
        } else {
            int b12 = zo.a.g().b();
            if (b12 != 1) {
                if (b12 != 2) {
                    return String.format(Locale.US, getString(R.string.n_order_cancel_symbol_tips), new Object[]{str2, str});
                } else if (zo.a.g().c() != 1) {
                    return String.format(Locale.US, getString(R.string.n_order_cancel_symbol_direction_tips), new Object[]{str2, getString(R.string.n_order_cancel_normal_sell_space)});
                } else {
                    return String.format(Locale.US, getString(R.string.n_order_cancel_symbol_direction_tips), new Object[]{str2, getString(R.string.n_order_cancel_stop_sell_space)});
                }
            } else if (zo.a.g().c() != 1) {
                return String.format(Locale.US, getString(R.string.n_order_cancel_symbol_direction_tips), new Object[]{str2, getString(R.string.n_order_cancel_normal_buy_space)});
            } else {
                return String.format(Locale.US, getString(R.string.n_order_cancel_symbol_direction_tips), new Object[]{str2, getString(R.string.n_order_cancel_stop_buy_space)});
            }
        }
    }

    public void l0(int i11, float f11, int i12, int i13, int i14) {
        if (i11 == 1 || i11 == 2) {
            ii(0);
        }
    }

    public final BaseOrderFilterDialogFragment li() {
        return this.f78195z.get("currentOrder");
    }

    public final String mi() {
        if (uh()) {
            return "currentOrder";
        }
        return wh() ? "detailOrder" : "historyOrder";
    }

    public final String ni() {
        int b11 = zo.a.g().b();
        if (b11 == 1) {
            return "buy";
        }
        if (b11 != 2) {
            return null;
        }
        return "sell";
    }

    public void o7(io.a aVar) {
        if (aVar.c() == 1) {
            Ci();
        } else if (aVar.c() == 2) {
            Bi();
        }
    }

    public SmartRefreshPageSplitter.c oh() {
        if (ri()) {
            int b11 = zo.a.g().b();
            if (1 == b11) {
                yi("buy");
            } else if (2 == b11) {
                yi("sell");
            } else {
                yi((String) null);
            }
            xi(zo.a.g().h(zo.a.g().e()));
            return new z0(this);
        }
        int b12 = zo.a.g().b();
        int c11 = zo.a.g().c();
        if (c11 == 1) {
            if (1 == b12) {
                yi("buy-stop-limit,buy-stop-limit-fok");
            } else if (2 == b12) {
                yi("sell-stop-limit,sell-stop-limit-fok");
            } else {
                yi("buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok");
            }
        } else if (c11 == 3) {
            if (1 == b12) {
                yi("buy");
            } else if (2 == b12) {
                yi("sell");
            } else {
                yi((String) null);
            }
            xi(zo.a.g().h(zo.a.g().f()));
            return new h1(this, new k());
        } else if (1 == b12) {
            yi("buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok");
        } else if (2 == b12) {
            yi("sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok");
        } else {
            yi("buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok");
        }
        if (zo.a.g().d() == 1) {
            xi(zo.a.g().h(zo.a.g().a()));
        }
        return new n1(this);
    }

    public final String oi() {
        if (zo.a.g().c() == 1) {
            int b11 = zo.a.g().b();
            if (b11 != 1) {
                return b11 != 2 ? "buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok" : "sell-stop-limit,sell-stop-limit-fok";
            }
            return "buy-stop-limit,buy-stop-limit-fok";
        }
        int b12 = zo.a.g().b();
        if (b12 != 1) {
            return b12 != 2 ? "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok" : "sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok";
        }
        return "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok";
    }

    public void onBackPressed() {
        if (this.K.F()) {
            this.K.B();
        } else if (this.L.e()) {
            this.L.d();
        } else {
            super.onBackPressed();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        i6.i.b().h(this.P);
        i6.i.b().h(this.Q);
    }

    public void onDialogFragmentPause() {
    }

    public void onDialogFragmentResume() {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        super.onPageScrolled(i11, f11, i12);
        i6.d.b("OrderActivity-->onPageScrolled--> position = " + i11 + " positionOffset = " + f11 + " positionOffsetPixels = " + i12 + " mTipsLayoutTranslationX = " + this.D);
        View view = this.A;
        if (view == null) {
            return;
        }
        if (i11 == 0) {
            float x11 = view.getX();
            int i13 = this.D;
            if (x11 < ((float) i13)) {
                this.A.setX((float) i13);
            }
        } else if (view.getX() > 0.0f) {
            this.A.setX(0.0f);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (TextUtils.isEmpty(proTokenUpdate.getProToken()) && getUI() != null && getUI().isAlive()) {
            finish();
        }
    }

    public void pc(int i11, float f11, int i12, int i13, int i14) {
        if (i11 == 1 || i11 == 2) {
            ii(this.A.getHeight());
        }
    }

    public final void pi() {
        this.f78186q = 3;
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        this.f78189t = timeInMillis;
        this.f78188s = TradeOrderMoreFilterView.A(timeInMillis);
        instance.add(5, -29);
        long timeInMillis2 = instance.getTimeInMillis();
        this.f78190u = timeInMillis2;
        this.f78187r = TradeOrderMoreFilterView.A(timeInMillis2);
    }

    public void popupWindowDismiss() {
        onDialogFragmentPause();
    }

    public void popupWindowShow() {
        onDialogFragmentResume();
    }

    public void q6() {
        Ai(this.H, true);
    }

    public final void qi() {
        CurrentOrderFilterDialogFragment currentOrderFilterDialogFragment = new CurrentOrderFilterDialogFragment();
        currentOrderFilterDialogFragment.Eh(this);
        currentOrderFilterDialogFragment.setDialogFragmentListener(this);
        this.f78195z.put("currentOrder", currentOrderFilterDialogFragment);
    }

    public boolean rh() {
        return true;
    }

    public boolean ri() {
        return zo.a.g().c() == 2;
    }

    public void sh(List<io.a> list) {
        OrderListFragment Pg;
        RecyclerView Y0;
        RecyclerView.Adapter adapter;
        if (uh() && !ri() && (Pg = Pg()) != null && (Y0 = Pg.Y0()) != null && (adapter = Y0.getAdapter()) != null && adapter.getItemCount() > 0) {
            list.add(this.f78194y);
        }
    }

    public boolean si() {
        return zo.a.g().c() == 3;
    }

    @k20.h
    @Keep
    public void updateOrderList(AssetAndOrderUpdateEvent assetAndOrderUpdateEvent) {
        i6.i.b().g(this.P, 500);
        i6.i.b().g(this.Q, 2000);
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public final void wi(Long l11) {
        x8.a.a().B(l11, o0(), oi(), (String) null, -1).b().compose(RxJavaHelper.t(getUI())).subscribe(new c());
    }

    public void xi(String str) {
        this.f78184o = str;
    }

    public void yi(String str) {
        this.f78185p = str;
    }

    public void zi(TradeType tradeType) {
        this.f78191v = tradeType;
    }
}
