package qs;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bj.l0;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureTpSlOrder;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCancelResult;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrentTrackOrderResult;
import com.hbg.lib.network.swap.core.bean.SwapOrderResult;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.bean.SwapTpSlOrder;
import com.hbg.lib.network.swap.core.bean.SwapTpSlRelationOrder;
import com.hbg.lib.network.swap.core.bean.SwapTrackOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.future.bean.FutureTpSlOrderDialogItem;
import com.huobi.future.ui.FutureTpSlDetailDialogFragment;
import com.huobi.swap.bean.SwapCurrentOrderItem;
import com.huobi.swap.bean.SwapCurrentTrackOrderItem;
import com.huobi.swap.bean.SwapCurrentTriggerOrderItem;
import com.huobi.swap.handler.SwapCurrentOrderHandler;
import com.huobi.trade.bean.EdgeOrderEmptyItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import ps.a;
import qk.o0;
import rx.Observable;
import rx.Subscriber;
import tg.r;
import ts.i1;

public class h1 {
    public SwapCurrentTriggerOrderItem.a A = new p0(this);
    public a.C0884a B = new h();
    public SwapCurrentTrackOrderItem.a C = new e0(this);
    public bm.a D;

    /* renamed from: a  reason: collision with root package name */
    public i1 f84598a;

    /* renamed from: b  reason: collision with root package name */
    public i f84599b;

    /* renamed from: c  reason: collision with root package name */
    public List<s9.a> f84600c;

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f84601d;

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f84602e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f84603f;

    /* renamed from: g  reason: collision with root package name */
    public List<s9.a> f84604g;

    /* renamed from: h  reason: collision with root package name */
    public v9.a<s9.a> f84605h;

    /* renamed from: i  reason: collision with root package name */
    public List<j> f84606i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public EdgeOrderEmptyItem f84607j = new EdgeOrderEmptyItem();

    /* renamed from: k  reason: collision with root package name */
    public k f84608k;

    /* renamed from: l  reason: collision with root package name */
    public Subscriber<List<SwapPositionItem>> f84609l;

    /* renamed from: m  reason: collision with root package name */
    public Subscriber<List<SwapCurrentOrderItem>> f84610m;

    /* renamed from: n  reason: collision with root package name */
    public Subscriber<List<SwapCurrentTriggerOrderItem>> f84611n;

    /* renamed from: o  reason: collision with root package name */
    public Subscriber<List<ps.a>> f84612o;

    /* renamed from: p  reason: collision with root package name */
    public Subscriber<List<SwapCurrentTrackOrderItem>> f84613p;

    /* renamed from: q  reason: collision with root package name */
    public Subscriber<ContractOpenCountInfo> f84614q;

    /* renamed from: r  reason: collision with root package name */
    public ContractOpenCountInfo f84615r = new ContractOpenCountInfo();

    /* renamed from: s  reason: collision with root package name */
    public SwapCurrencyInfo f84616s;

    /* renamed from: t  reason: collision with root package name */
    public TradeType f84617t;

    /* renamed from: u  reason: collision with root package name */
    public SwapPositionItem.a f84618u;

    /* renamed from: v  reason: collision with root package name */
    public SwapOrderResult<SwapCurrentOrderInfo> f84619v;

    /* renamed from: w  reason: collision with root package name */
    public SwapOrderResult<SwapTriggerOrderInfo> f84620w;

    /* renamed from: x  reason: collision with root package name */
    public SwapOrderResult<SwapTriggerOrderInfo> f84621x;

    /* renamed from: y  reason: collision with root package name */
    public SwapCurrentTrackOrderResult f84622y;

    /* renamed from: z  reason: collision with root package name */
    public SwapCurrentOrderHandler.a f84623z = new g();

    public class a extends BaseSubscriber<ContractOpenCountInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ContractOpenCountInfo contractOpenCountInfo) {
            h1.this.T().d1(contractOpenCountInfo);
        }
    }

    public class b extends EasySubscriber<List<ps.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f84625b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f84626c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f84627d;

        public b(int i11, int i12, String str) {
            this.f84625b = i11;
            this.f84626c = i12;
            this.f84627d = str;
        }

        public void onError2(Throwable th2) {
            h1.this.F0(this.f84625b, this.f84626c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            h1.this.F0(this.f84625b, this.f84626c);
        }

        public void onNext(List<ps.a> list) {
            h1.this.K0(this.f84627d, this.f84626c, 1, list);
            for (ps.a b11 : list) {
                h1.this.f84599b.b(b11);
            }
        }
    }

    public class c extends EasySubscriber<List<SwapCurrentOrderItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f84629b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f84630c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f84631d;

        public c(int i11, int i12, String str) {
            this.f84629b = i11;
            this.f84630c = i12;
            this.f84631d = str;
        }

        public void onError2(Throwable th2) {
            h1.this.F0(this.f84629b, this.f84630c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            h1.this.F0(this.f84629b, this.f84630c);
        }

        public void onNext(List<SwapCurrentOrderItem> list) {
            h1.this.G0(this.f84631d, this.f84630c, 0, list);
        }
    }

    public class d extends EasySubscriber<List<SwapCurrentTriggerOrderItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f84633b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f84634c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f84635d;

        public d(int i11, int i12, String str) {
            this.f84633b = i11;
            this.f84634c = i12;
            this.f84635d = str;
        }

        public void onError2(Throwable th2) {
            h1.this.F0(this.f84633b, this.f84634c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            h1.this.F0(this.f84633b, this.f84634c);
        }

        public void onNext(List<SwapCurrentTriggerOrderItem> list) {
            h1.this.M0(this.f84635d, this.f84634c, 1, list);
        }
    }

    public class e extends BaseSubscriber<List<SwapCurrentTrackOrderItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f84637b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f84638c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f84639d;

        public e(int i11, int i12, String str) {
            this.f84637b = i11;
            this.f84638c = i12;
            this.f84639d = str;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            h1.this.F0(this.f84637b, this.f84638c);
        }

        public void onNext(List<SwapCurrentTrackOrderItem> list) {
            h1.this.L0(this.f84639d, this.f84638c, 5, list);
        }
    }

    public class f extends EasySubscriber<List<SwapPositionItem>> {
        public f() {
        }

        public void onNext(List<SwapPositionItem> list) {
            super.onNext(list);
            h1.this.I0(list);
            l0.y().P(h1.this.f84616s.getContractCode(), list);
        }
    }

    public class g implements SwapCurrentOrderHandler.a {
        public g() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(SwapCancelResult swapCancelResult) {
            HuobiToastUtil.s(R.string.string_order_cancel_ok);
            s6.a.b(bh.j.c()).c(R.raw.order_canceled);
            h1 h1Var = h1.this;
            h1Var.P0(h1Var.f84616s.getContractCode(), 0, 0, 10, h1.this.T().getPositionType(), h1.this.T().e1(), h1.this.T().T0());
            h1.this.O0();
        }

        public static /* synthetic */ void f(Context context, SwapTpSlRelationOrder swapTpSlRelationOrder) {
            FutureTpSlDetailDialogFragment futureTpSlDetailDialogFragment = new FutureTpSlDetailDialogFragment();
            List<SwapTpSlOrder> tpSlOrderInfo = swapTpSlRelationOrder.getTpSlOrderInfo();
            ArrayList arrayList = new ArrayList();
            SwapCurrencyInfo h11 = SwapCurrencyInfoController.k().h(swapTpSlRelationOrder.getSymbol());
            for (SwapTpSlOrder swapToFuture : tpSlOrderInfo) {
                FutureTpSlOrderDialogItem futureTpSlOrderDialogItem = new FutureTpSlOrderDialogItem();
                FutureTpSlOrder futureTpSlOrder = new FutureTpSlOrder();
                futureTpSlOrderDialogItem.i(futureTpSlOrder.swapToFuture(futureTpSlOrder, swapToFuture));
                futureTpSlOrderDialogItem.g(h11.getContractFace());
                futureTpSlOrderDialogItem.h(h11.getContractShortType());
                futureTpSlOrderDialogItem.j("USD");
                arrayList.add(futureTpSlOrderDialogItem);
            }
            futureTpSlDetailDialogFragment.tc(arrayList);
            futureTpSlDetailDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "SwapFutureTpSlDetailDialogFragment");
            HashMap hashMap = new HashMap();
            hashMap.put("Page_name", "contract_view");
            gs.g.i("check_take_profit_and_stop_loss_click", hashMap);
        }

        public void a(SwapCurrentOrderInfo swapCurrentOrderInfo) {
            o.a(swapCurrentOrderInfo.getContractCode(), swapCurrentOrderInfo.getOrderId(), 0).delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(h1.this.T())).subscribe(q6.d.c(h1.this.T(), new j1(this)));
            is.a.j("4714", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "entrust_list");
            gs.g.j("contract_trade", "coin_contract", "repeal", hashMap);
        }

        public void b(SwapCurrentOrderInfo swapCurrentOrderInfo, Context context) {
            l9.a.a().w(swapCurrentOrderInfo.getContractCode(), String.valueOf(swapCurrentOrderInfo.getOrderId())).b().compose(RxJavaHelper.t(h1.this.T())).subscribe(q6.d.c(h1.this.T(), new i1(context)));
        }
    }

    public class h implements a.C0884a {
        public h() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(SwapCancelResult swapCancelResult) {
            HuobiToastUtil.s(R.string.string_order_cancel_ok);
            s6.a.b(BaseApplication.b()).c(R.raw.order_canceled);
            h1 h1Var = h1.this;
            h1Var.R0(h1Var.f84616s.getContractCode(), 0, 10, h1.this.T().e1(), h1.this.T().T0());
            h1.this.O0();
        }

        public void a(ps.a aVar, Context context) {
            h1.this.f84599b.a(aVar, context);
        }

        public void b(ps.a aVar) {
            SwapTriggerOrderInfo e11 = aVar.e();
            l9.a.a().y(e11.getContractCode(), e11.getOrderId()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(h1.this.T())).subscribe(q6.d.c(h1.this.T(), new k1(this)));
        }
    }

    public interface i {
        int B0();

        void a(ps.a aVar, Context context);

        void b(ps.a aVar);

        void f(int i11);

        void g(int i11);

        void h(int i11);

        void i(int i11);
    }

    public interface j {
        void a();
    }

    public interface k {
        void c();
    }

    public h1(i1 i1Var, TradeType tradeType) {
        this.f84598a = i1Var;
        this.f84600c = new ArrayList();
        this.f84601d = new ArrayList();
        this.f84602e = new ArrayList();
        this.f84603f = new ArrayList();
        this.f84604g = new ArrayList();
        this.f84605h = new v9.a<>(this.f84600c);
        this.f84617t = tradeType;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(SwapCancelResult swapCancelResult) {
        HuobiToastUtil.s(R.string.string_order_cancel_ok);
        s6.a.b(bh.j.c()).c(R.raw.order_canceled);
        T0(this.f84616s.getContractCode(), 1, 0, 10, T().getPositionType(), T().e1(), T().T0());
        O0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(SwapTriggerOrderInfo swapTriggerOrderInfo) {
        o.a(swapTriggerOrderInfo.getContractCode(), swapTriggerOrderInfo.getOrderId(), 1).delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(T())).subscribe(q6.d.c(T(), new a1(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(SwapCancelResult swapCancelResult) {
        HuobiToastUtil.s(R.string.string_order_cancel_ok);
        S0(this.f84616s.getContractCode(), 5, 0, 10, T().getPositionType(), T().e1(), T().T0());
        O0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(SwapCurrentTrackOrderItem swapCurrentTrackOrderItem) {
        l9.a.a().q(swapCurrentTrackOrderItem.e().getContractCode(), swapCurrentTrackOrderItem.e().getOrderId()).b().delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(T())).subscribe(q6.d.c(T(), new z0(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable a0(SwapOrderResult swapOrderResult) {
        this.f84619v = swapOrderResult;
        return Observable.from(swapOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SwapCurrentOrderItem b0(SwapCurrentOrderInfo swapCurrentOrderInfo) {
        SwapCurrentOrderItem swapCurrentOrderItem = new SwapCurrentOrderItem();
        SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(swapCurrentOrderInfo.getContractCode());
        if (q11 != null) {
            swapCurrentOrderInfo.setContractFace(q11.getContractFace());
        }
        swapCurrentOrderItem.e(this.f84623z);
        swapCurrentOrderItem.f(swapCurrentOrderInfo);
        return swapCurrentOrderItem;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable c0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return o.b(str, "", i11, i12).flatMap(new f0(this)).map(new f1(this)).toList();
    }

    public static /* synthetic */ Boolean e0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SwapPositionItem g0(SwapPosition swapPosition) {
        SwapPositionItem swapPositionItem = new SwapPositionItem();
        swapPositionItem.g(swapPosition);
        swapPositionItem.f(this.f84618u);
        swapPositionItem.h(SwapCurrencyInfoController.k().q(swapPosition.getContractCode()));
        return swapPositionItem;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable h0(String str, Long l11) {
        return l9.a.a().O(str).b().flatMap(s0.f70446b).map(new i0(this)).toList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List j0(SwapOrderResult swapOrderResult) {
        this.f84621x = swapOrderResult;
        ArrayList arrayList = new ArrayList();
        for (SwapTriggerOrderInfo swapTriggerOrderInfo : swapOrderResult.getOrders()) {
            ps.a aVar = new ps.a(swapTriggerOrderInfo);
            SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(swapTriggerOrderInfo.getContractCode());
            if (q11 != null) {
                aVar.g(q11.getContractFace());
            }
            aVar.f(this.B);
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable k0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return l9.a.a().A(i11, i12, str).b().map(new h0(this));
    }

    public static /* synthetic */ Boolean m0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable n0(SwapCurrentTrackOrderResult swapCurrentTrackOrderResult) {
        this.f84622y = swapCurrentTrackOrderResult;
        return Observable.from(swapCurrentTrackOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SwapCurrentTrackOrderItem o0(SwapTrackOrderInfo swapTrackOrderInfo) {
        SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(swapTrackOrderInfo.getContractCode());
        SwapCurrentTrackOrderItem swapCurrentTrackOrderItem = new SwapCurrentTrackOrderItem();
        if (q11 != null) {
            swapCurrentTrackOrderItem.k(q11.getContractFace());
        }
        swapCurrentTrackOrderItem.l(swapTrackOrderInfo);
        swapCurrentTrackOrderItem.j(this.C);
        return swapCurrentTrackOrderItem;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable p0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return l9.a.a().C(str, i11, i12, "0").b().flatMap(new g1(this)).map(new j0(this)).toList().flatMap(ad.i.f3526b).toList();
    }

    public static /* synthetic */ Boolean r0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public static /* synthetic */ Boolean t0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable u0(SwapOrderResult swapOrderResult) {
        this.f84620w = swapOrderResult;
        return Observable.from(swapOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SwapCurrentTriggerOrderItem v0(SwapTriggerOrderInfo swapTriggerOrderInfo) {
        SwapCurrentTriggerOrderItem swapCurrentTriggerOrderItem = new SwapCurrentTriggerOrderItem();
        SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(swapTriggerOrderInfo.getContractCode());
        if (q11 != null) {
            swapCurrentTriggerOrderItem.g(q11.getContractFace());
        }
        swapCurrentTriggerOrderItem.h(swapTriggerOrderInfo);
        swapCurrentTriggerOrderItem.f(this.A);
        return swapCurrentTriggerOrderItem;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable w0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return o.c(str, i11, i12).flatMap(new g0(this)).map(new k0(this)).toList();
    }

    public void A0(SwapPositionItem.a aVar) {
        this.f84618u = aVar;
    }

    public void B0(bm.a aVar) {
        this.D = aVar;
    }

    public void C0(j jVar) {
        if (jVar != null) {
            this.f84606i.add(jVar);
        }
    }

    public void D0(k kVar) {
        this.f84608k = kVar;
    }

    public final void E0(int i11, int i12) {
        if (i11 == 0) {
            this.f84601d.clear();
            this.f84601d.add(this.f84607j);
            this.f84605h.i(this.f84601d);
        } else if (i12 == 1) {
            if (this.f84599b.B0() == 1) {
                this.f84602e.clear();
                this.f84602e.add(this.f84607j);
                this.f84605h.i(this.f84602e);
            } else {
                return;
            }
        } else if (i12 == 2) {
            if (this.f84599b.B0() == 2) {
                this.f84603f.clear();
                this.f84603f.add(this.f84607j);
                this.f84605h.i(this.f84603f);
            } else {
                return;
            }
        } else if (i12 == 3) {
            if (this.f84599b.B0() == 3) {
                this.f84604g.clear();
                this.f84604g.add(this.f84607j);
                this.f84605h.i(this.f84604g);
            } else {
                return;
            }
        } else if (this.f84599b.B0() == 0) {
            this.f84600c.clear();
            this.f84600c.add(this.f84607j);
            this.f84605h.i(this.f84600c);
        } else {
            return;
        }
        this.f84605h.notifyDataSetChanged();
    }

    public final void F0(int i11, int i12) {
        E0(i11, i12);
    }

    public final void G0(String str, int i11, int i12, List<? extends s9.a> list) {
        int i13;
        this.f84600c.clear();
        if (list.isEmpty()) {
            this.f84600c.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f84600c.addAll(list);
            if (list.size() >= 10) {
                this.f84600c.add(new aj.e(str, i12, this.f84617t));
            }
        }
        if (this.f84599b.B0() == 0) {
            this.f84605h.i(this.f84600c);
            this.f84605h.notifyDataSetChanged();
        }
        if (!this.f84606i.isEmpty()) {
            for (j next : this.f84606i) {
                if (next != null) {
                    next.a();
                }
            }
        }
        i iVar = this.f84599b;
        if (iVar != null) {
            SwapOrderResult<SwapCurrentOrderInfo> swapOrderResult = this.f84619v;
            if (swapOrderResult == null) {
                i13 = 0;
            } else {
                i13 = swapOrderResult.getTotalSize();
            }
            iVar.h(i13);
        }
    }

    public void H0() {
        E0(T().e1(), T().T0());
    }

    public void I0(List<? extends s9.a> list) {
        this.f84601d.clear();
        if (list.isEmpty()) {
            bm.a aVar = this.D;
            if (aVar != null) {
                aVar.a(false);
            }
            this.f84601d.add(this.f84607j);
        } else {
            bm.a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.a(true);
            }
            this.f84601d.addAll(list);
        }
        if (T().v1() == 0) {
            this.f84605h.i(this.f84601d);
            this.f84605h.notifyDataSetChanged();
        }
        k kVar = this.f84608k;
        if (kVar != null) {
            kVar.c();
        }
    }

    public void J0() {
        E0(T().e1(), T().T0());
    }

    public final void K0(String str, int i11, int i12, List<? extends s9.a> list) {
        int i13;
        this.f84603f.clear();
        if (list.isEmpty()) {
            this.f84603f.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f84603f.addAll(list);
            if (list.size() >= 10) {
                this.f84603f.add(new aj.e(str, i12, this.f84617t, this.f84616s.getContractShortType()));
            }
        }
        if (this.f84599b.B0() == 2) {
            this.f84605h.i(this.f84603f);
            this.f84605h.notifyDataSetChanged();
        }
        i iVar = this.f84599b;
        if (iVar != null) {
            SwapOrderResult<SwapTriggerOrderInfo> swapOrderResult = this.f84621x;
            if (swapOrderResult == null) {
                i13 = 0;
            } else {
                i13 = swapOrderResult.getTotalSize();
            }
            iVar.f(i13);
        }
    }

    public void L() {
        this.f84600c.clear();
        this.f84601d.clear();
        this.f84602e.clear();
        this.f84603f.clear();
        this.f84604g.clear();
    }

    public final void L0(String str, int i11, int i12, List<? extends s9.a> list) {
        int i13;
        this.f84604g.clear();
        if (list.isEmpty()) {
            this.f84604g.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f84604g.addAll(list);
            if (list.size() >= 10) {
                this.f84604g.add(new aj.e(str, i12, this.f84617t, this.f84616s.getContractShortType()));
            }
        }
        if (this.f84599b.B0() == 3) {
            this.f84605h.i(this.f84604g);
            this.f84605h.notifyDataSetChanged();
        }
        i iVar = this.f84599b;
        if (iVar != null) {
            SwapCurrentTrackOrderResult swapCurrentTrackOrderResult = this.f84622y;
            if (swapCurrentTrackOrderResult == null) {
                i13 = 0;
            } else {
                i13 = swapCurrentTrackOrderResult.getTotalSize();
            }
            iVar.i(i13);
        }
    }

    public final Subscriber<List<SwapCurrentOrderItem>> M(String str, int i11, int i12) {
        return new c(i11, i12, str);
    }

    public final void M0(String str, int i11, int i12, List<? extends s9.a> list) {
        int i13;
        this.f84602e.clear();
        if (list.isEmpty()) {
            this.f84602e.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f84602e.addAll(list);
            if (list.size() >= 10) {
                this.f84602e.add(new aj.e(str, i12, this.f84617t));
            }
        }
        if (this.f84599b.B0() == 1) {
            this.f84605h.i(this.f84602e);
            this.f84605h.notifyDataSetChanged();
        }
        i iVar = this.f84599b;
        if (iVar != null) {
            SwapOrderResult<SwapTriggerOrderInfo> swapOrderResult = this.f84620w;
            if (swapOrderResult == null) {
                i13 = 0;
            } else {
                i13 = swapOrderResult.getTotalSize();
            }
            iVar.g(i13);
        }
    }

    public final Subscriber<List<SwapPositionItem>> N() {
        return new f();
    }

    public void N0(int i11, int i12) {
        E0(i11, i12);
    }

    public final Subscriber<List<SwapCurrentTrackOrderItem>> O(String str, int i11, int i12) {
        return new e(i11, i12, str);
    }

    public void O0() {
        Subscriber<ContractOpenCountInfo> subscriber = this.f84614q;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (r.x().F0()) {
            this.f84614q = new a();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(r0.f70444b).retryWhen(t0.f70448b).compose(RxJavaHelper.t(T())).subscribe(this.f84614q);
            return;
        }
        T().d1(this.f84615r);
    }

    public final Subscriber<List<SwapCurrentTriggerOrderItem>> P(String str, int i11, int i12) {
        return new d(i11, i12, str);
    }

    public void P0(String str, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!r.x().F0()) {
            N0(i15, i16);
        } else if (i14 != 2 && !TextUtils.isEmpty(str)) {
            Subscriber<List<SwapCurrentOrderItem>> subscriber = this.f84610m;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f84610m = M(str, i15, i16);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new n0(this, str, i12, i13)).retryWhen(u0.f70450b).filter(new c1(i15)).compose(RxJavaHelper.t(T())).subscribe(this.f84610m);
        }
    }

    public List<s9.a> Q() {
        return this.f84600c;
    }

    public void Q0(String str, int i11, int i12) {
        Subscriber<List<SwapPositionItem>> subscriber = this.f84609l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (i11 == 2) {
            if (!r.x().F0()) {
                J0();
                return;
            }
        } else if (!r.x().F0()) {
            return;
        }
        l0.y().F();
        this.f84609l = N();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new l0(this, str)).retryWhen(w0.f70458b).compose(RxJavaHelper.t(T())).subscribe(this.f84609l);
    }

    public List<s9.a> R() {
        return this.f84601d;
    }

    public void R0(String str, int i11, int i12, int i13, int i14) {
        if (!BaseModuleConfig.a().a()) {
            N0(i13, i14);
            return;
        }
        X0();
        this.f84612o = new b(i13, i14, str);
        Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new q0(this, str, i11, i12)).retryWhen(y0.f70466b).filter(new b1(i13)).compose(RxJavaHelper.t(T())).subscribe(this.f84612o);
    }

    public v9.a<s9.a> S() {
        return this.f84605h;
    }

    public void S0(String str, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!BaseModuleConfig.a().a()) {
            N0(i15, i16);
        } else if (i14 != 2) {
            Subscriber<List<SwapCurrentTrackOrderItem>> subscriber = this.f84613p;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f84613p = O(str, i15, i16);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new o0(this, str, i12, i13)).retryWhen(x0.f70462b).filter(new d1(i15)).compose(RxJavaHelper.t(T())).subscribe(this.f84613p);
        }
    }

    public final i1 T() {
        return this.f84598a;
    }

    public void T0(String str, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!r.x().F0()) {
            N0(i15, i16);
        } else if (i14 != 2 && !TextUtils.isEmpty(str)) {
            Subscriber<List<SwapCurrentTriggerOrderItem>> subscriber = this.f84611n;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f84611n = P(str, i15, i16);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new m0(this, str, i12, i13)).retryWhen(v0.f70454b).filter(new e1(i15)).compose(RxJavaHelper.t(T())).subscribe(this.f84611n);
        }
    }

    public void U0() {
        Subscriber<ContractOpenCountInfo> subscriber = this.f84614q;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void V0() {
        Subscriber<List<SwapCurrentOrderItem>> subscriber = this.f84610m;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void W0() {
        Subscriber<List<SwapPositionItem>> subscriber = this.f84609l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        l0.y().Y();
    }

    public void X0() {
        Subscriber<List<ps.a>> subscriber = this.f84612o;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void Y0() {
        Subscriber<List<SwapCurrentTrackOrderItem>> subscriber = this.f84613p;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void Z0() {
        Subscriber<List<SwapCurrentTriggerOrderItem>> subscriber = this.f84611n;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void x0(i iVar) {
        this.f84599b = iVar;
    }

    public void y0(SwapCurrencyInfo swapCurrencyInfo) {
        this.f84616s = swapCurrencyInfo;
    }

    public void z0(View view) {
        v9.a<s9.a> aVar = this.f84605h;
        if (aVar != null) {
            aVar.j(view);
        }
    }
}
