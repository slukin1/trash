package bj;

import aj.c;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.contract.R$raw;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureTpSlOrder;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.StopOrderRspResult;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.contract.entity.ContractCurrentOrderInfo;
import com.huobi.contract.entity.ContractCurrentOrderItem;
import com.huobi.contract.entity.ContractCurrentOrderResult;
import com.huobi.contract.entity.ContractCurrentTrackOrderItem;
import com.huobi.contract.entity.ContractCurrentTrackOrderResult;
import com.huobi.contract.entity.ContractCurrentTriggerOrderInfo;
import com.huobi.contract.entity.ContractCurrentTriggerOrderResult;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.entity.ContractTpSlOrder;
import com.huobi.contract.entity.ContractTpSlRelationOrder;
import com.huobi.contract.entity.ContractTrackOrderInfo;
import com.huobi.contract.entity.ContractTriggerOrderRspInfo;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractOrderHelper;
import com.huobi.contract.viewhandler.ContractCurrentOrderHandler;
import com.huobi.future.bean.FutureTpSlOrderDialogItem;
import com.huobi.future.ui.FutureTpSlDetailDialogFragment;
import com.huobi.trade.bean.EdgeOrderEmptyItem;
import dj.p1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

public class h2 {
    public ContractCurrentTriggerOrderInfo.a A = new p1(this);
    public ContractCurrentTrackOrderItem.a B = new e1(this);
    public c.a C = new h();
    public bm.a D;

    /* renamed from: a  reason: collision with root package name */
    public p1 f40795a;

    /* renamed from: b  reason: collision with root package name */
    public i f40796b;

    /* renamed from: c  reason: collision with root package name */
    public List<s9.a> f40797c;

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f40798d;

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f40799e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f40800f;

    /* renamed from: g  reason: collision with root package name */
    public List<s9.a> f40801g;

    /* renamed from: h  reason: collision with root package name */
    public v9.a<s9.a> f40802h;

    /* renamed from: i  reason: collision with root package name */
    public List<j> f40803i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public k f40804j;

    /* renamed from: k  reason: collision with root package name */
    public EdgeOrderEmptyItem f40805k = new EdgeOrderEmptyItem();

    /* renamed from: l  reason: collision with root package name */
    public Subscriber<List<ContractPosition>> f40806l;

    /* renamed from: m  reason: collision with root package name */
    public Subscriber<List<ContractCurrentOrderItem>> f40807m;

    /* renamed from: n  reason: collision with root package name */
    public Subscriber<List<ContractCurrentTriggerOrderInfo>> f40808n;

    /* renamed from: o  reason: collision with root package name */
    public Subscriber<List<aj.c>> f40809o;

    /* renamed from: p  reason: collision with root package name */
    public Subscriber<List<ContractCurrentTrackOrderItem>> f40810p;

    /* renamed from: q  reason: collision with root package name */
    public Subscriber<ContractOpenCountInfo> f40811q;

    /* renamed from: r  reason: collision with root package name */
    public ContractOpenCountInfo f40812r = new ContractOpenCountInfo();

    /* renamed from: s  reason: collision with root package name */
    public ContractCurrencyInfo f40813s;

    /* renamed from: t  reason: collision with root package name */
    public TradeType f40814t;

    /* renamed from: u  reason: collision with root package name */
    public ContractPosition.a f40815u;

    /* renamed from: v  reason: collision with root package name */
    public ContractCurrentOrderResult f40816v;

    /* renamed from: w  reason: collision with root package name */
    public ContractCurrentTriggerOrderResult f40817w;

    /* renamed from: x  reason: collision with root package name */
    public StopOrderRspResult f40818x;

    /* renamed from: y  reason: collision with root package name */
    public ContractCurrentTrackOrderResult f40819y;

    /* renamed from: z  reason: collision with root package name */
    public ContractCurrentOrderHandler.a f40820z = new g();

    public class a extends BaseSubscriber<ContractOpenCountInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ContractOpenCountInfo contractOpenCountInfo) {
            h2.this.U().d1(contractOpenCountInfo);
        }
    }

    public class b extends EasySubscriber<List<aj.c>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f40822b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f40823c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40824d;

        public b(int i11, int i12, String str) {
            this.f40822b = i11;
            this.f40823c = i12;
            this.f40824d = str;
        }

        public void onError2(Throwable th2) {
            h2.this.G0(this.f40822b, this.f40823c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            h2.this.G0(this.f40822b, this.f40823c);
        }

        public void onNext(List<aj.c> list) {
            h2.this.L0(this.f40824d, this.f40823c, 1, list);
            for (aj.c C0 : list) {
                h2.this.f40796b.C0(C0);
            }
        }
    }

    public class c extends EasySubscriber<List<ContractCurrentOrderItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f40826b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f40827c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40828d;

        public c(int i11, int i12, String str) {
            this.f40826b = i11;
            this.f40827c = i12;
            this.f40828d = str;
        }

        public void onError2(Throwable th2) {
            h2.this.G0(this.f40826b, this.f40827c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            h2.this.G0(this.f40826b, this.f40827c);
        }

        public void onNext(List<ContractCurrentOrderItem> list) {
            h2.this.H0(this.f40828d, this.f40827c, 0, list);
        }
    }

    public class d extends EasySubscriber<List<ContractCurrentTriggerOrderInfo>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f40830b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f40831c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40832d;

        public d(int i11, int i12, String str) {
            this.f40830b = i11;
            this.f40831c = i12;
            this.f40832d = str;
        }

        public void onError2(Throwable th2) {
            h2.this.G0(this.f40830b, this.f40831c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            h2.this.G0(this.f40830b, this.f40831c);
        }

        public void onNext(List<ContractCurrentTriggerOrderInfo> list) {
            h2.this.N0(this.f40832d, this.f40831c, 1, list);
        }
    }

    public class e extends BaseSubscriber<List<ContractCurrentTrackOrderItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f40834b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f40835c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40836d;

        public e(int i11, int i12, String str) {
            this.f40834b = i11;
            this.f40835c = i12;
            this.f40836d = str;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            h2.this.G0(this.f40834b, this.f40835c);
        }

        public void onNext(List<ContractCurrentTrackOrderItem> list) {
            h2.this.M0(this.f40836d, this.f40835c, 5, list);
        }
    }

    public class f extends EasySubscriber<List<ContractPosition>> {
        public f() {
        }

        public void onNext(List<ContractPosition> list) {
            super.onNext(list);
            h2.this.J0(list);
            l0.t().P(h2.this.f40813s.getContractShortType(), list);
        }
    }

    public class g implements ContractCurrentOrderHandler.a {
        public g() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(List list) {
            HuobiToastUtil.s(R$string.string_order_cancel_ok);
            s6.a.b(BaseApplication.b()).c(R$raw.order_canceled);
            h2 h2Var = h2.this;
            h2Var.Q0(h2Var.f40813s.getSymbol(), 0, 0, 10, h2.this.U().getPositionType(), h2.this.U().e1(), h2.this.U().T0());
            h2.this.P0();
        }

        public static /* synthetic */ void f(Context context, ContractTpSlRelationOrder contractTpSlRelationOrder) {
            FutureTpSlDetailDialogFragment futureTpSlDetailDialogFragment = new FutureTpSlDetailDialogFragment();
            List<ContractTpSlOrder> tpSlOrderInfo = contractTpSlRelationOrder.getTpSlOrderInfo();
            ArrayList arrayList = new ArrayList();
            ContractCurrencyInfo h11 = ContractCurrencyUtils.h(contractTpSlRelationOrder.getContractCode());
            for (ContractTpSlOrder contractToFuture : tpSlOrderInfo) {
                FutureTpSlOrderDialogItem futureTpSlOrderDialogItem = new FutureTpSlOrderDialogItem();
                FutureTpSlOrder futureTpSlOrder = new FutureTpSlOrder();
                futureTpSlOrderDialogItem.i(futureTpSlOrder.contractToFuture(futureTpSlOrder, contractToFuture));
                futureTpSlOrderDialogItem.g(h11.getContractFace());
                futureTpSlOrderDialogItem.h(h11.getContractShortType());
                futureTpSlOrderDialogItem.j("USD");
                arrayList.add(futureTpSlOrderDialogItem);
            }
            futureTpSlDetailDialogFragment.tc(arrayList);
            futureTpSlDetailDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "ContractFutureTpSlDetailDialogFragment");
            HashMap hashMap = new HashMap();
            hashMap.put("Page_name", "contract_view");
            ContractModuleConfig.a().c("check_take_profit_and_stop_loss_click", hashMap);
        }

        public void a(ContractCurrentOrderInfo contractCurrentOrderInfo, Context context) {
            q7.a.a().w(contractCurrentOrderInfo.getSymbol(), contractCurrentOrderInfo.getOrderId()).b().compose(RxJavaHelper.t(h2.this.U())).subscribe(q6.d.c(h2.this.U(), new i2(context)));
        }

        public void b(ContractCurrentOrderInfo contractCurrentOrderInfo) {
            ContractOrderHelper.b(contractCurrentOrderInfo.getSymbol(), contractCurrentOrderInfo.getOrderId(), 0).compose(ContractRetrofit.g()).delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(h2.this.U())).subscribe(q6.d.c(h2.this.U(), new j2(this)));
            BaseModuleConfig.a().d("4714", (Map<String, Object>) null, ContractModuleConfig.a().g(TradeType.CONTRACT));
            HashMap hashMap = new HashMap();
            hashMap.put("business_category", "contract_trade");
            hashMap.put("type", "coin_contract");
            hashMap.put("module_name", "entrust_list");
            hashMap.put("button_name", "repeal");
            BaseModuleConfig.a().w("appclick_contracts", hashMap);
        }
    }

    public class h implements c.a {
        public h() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(List list) {
            HuobiToastUtil.s(R$string.string_order_cancel_ok);
            s6.a.b(BaseApplication.b()).c(R$raw.order_canceled);
            h2 h2Var = h2.this;
            h2Var.S0(h2Var.f40813s.getSymbol(), 0, 10, h2.this.U().e1(), h2.this.U().T0());
            h2.this.P0();
        }

        public void b(aj.c cVar, Context context) {
            h2.this.f40815u.b(cVar, context);
        }

        public void c(aj.c cVar) {
            ContractTriggerOrderRspInfo e11 = cVar.e();
            q7.a.a().A(e11.getSymbol(), e11.getOrderId()).b().compose(ContractRetrofit.g()).delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(h2.this.U())).subscribe(q6.d.c(h2.this.U(), new k2(this)));
        }
    }

    public interface i {
        int B0();

        void C0(aj.c cVar);

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

    public h2(p1 p1Var, TradeType tradeType) {
        this.f40795a = p1Var;
        this.f40797c = new ArrayList();
        this.f40798d = new ArrayList();
        this.f40799e = new ArrayList();
        this.f40800f = new ArrayList();
        this.f40801g = new ArrayList();
        this.f40802h = new v9.a<>(this.f40797c);
        this.f40814t = tradeType;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(List list) {
        HuobiToastUtil.s(R$string.string_order_cancel_ok);
        s6.a.b(BaseApplication.b()).c(R$raw.order_canceled);
        U0(this.f40813s.getSymbol(), 1, 0, 10, U().getPositionType(), U().e1(), U().T0());
        P0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo) {
        ContractOrderHelper.b(contractCurrentTriggerOrderInfo.getSymbol(), contractCurrentTriggerOrderInfo.getOrderId(), 1).compose(ContractRetrofit.g()).delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(U())).subscribe(q6.d.c(U(), new z1(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(List list) {
        HuobiToastUtil.s(R$string.string_order_cancel_ok);
        T0(this.f40813s.getSymbol(), 5, 0, 10, U().getPositionType(), U().e1(), U().T0());
        P0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(ContractCurrentTrackOrderItem contractCurrentTrackOrderItem) {
        q7.a.a().q(contractCurrentTrackOrderItem.e().getSymbol(), contractCurrentTrackOrderItem.e().getOrderId()).b().compose(ContractRetrofit.g()).delay(300, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t(U())).subscribe(q6.d.c(U(), new a2(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable b0(ContractCurrentOrderResult contractCurrentOrderResult) {
        this.f40816v = contractCurrentOrderResult;
        return Observable.from(contractCurrentOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ContractCurrentOrderItem c0(ContractCurrentOrderInfo contractCurrentOrderInfo) {
        ContractCurrencyInfo h11 = ContractCurrencyUtils.h(contractCurrentOrderInfo.getContractCode());
        if (h11 != null) {
            contractCurrentOrderInfo.setContractFace(h11.getContractFace());
        }
        return new ContractCurrentOrderItem(contractCurrentOrderInfo, this.f40820z);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable d0(String str, int i11, int i12, Long l11) {
        if (!ContractModuleConfig.a().d()) {
            str = null;
        }
        return ContractOrderHelper.h(str, i11, i12).flatMap(new f1(this)).map(new g2(this)).toList();
    }

    public static /* synthetic */ Boolean f0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ContractPosition h0(ContractPosition contractPosition) {
        contractPosition.setClickListener(this.f40815u);
        contractPosition.setContractCurrencyInfo(ContractCurrencyUtils.h(contractPosition.getContractCode()));
        return contractPosition;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable i0(Map map, Long l11) {
        return ContractOrderHelper.g(map).flatMap(s1.f12495b).map(new j1(this)).toList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List k0(StopOrderRspResult stopOrderRspResult) {
        this.f40818x = stopOrderRspResult;
        ArrayList arrayList = new ArrayList();
        for (ContractTriggerOrderRspInfo next : stopOrderRspResult.getOrders()) {
            aj.c cVar = new aj.c(next);
            ContractCurrencyInfo h11 = ContractCurrencyUtils.h(next.getContractCode());
            if (h11 != null) {
                cVar.k(h11.getContractFace());
            }
            cVar.j(this.C);
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable l0(String str, int i11, int i12, Long l11) {
        if (!ContractModuleConfig.a().d()) {
            str = null;
        }
        return q7.a.a().P(str, (String) null, i11, i12, "0").b().map(new f2(this));
    }

    public static /* synthetic */ Boolean n0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable o0(ContractCurrentTrackOrderResult contractCurrentTrackOrderResult) {
        this.f40819y = contractCurrentTrackOrderResult;
        return Observable.from(contractCurrentTrackOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ContractCurrentTrackOrderItem p0(ContractTrackOrderInfo contractTrackOrderInfo) {
        ContractCurrencyInfo h11 = ContractCurrencyUtils.h(contractTrackOrderInfo.getContractCode());
        ContractCurrentTrackOrderItem contractCurrentTrackOrderItem = new ContractCurrentTrackOrderItem();
        if (h11 != null) {
            contractCurrentTrackOrderItem.k(h11.getContractFace());
        }
        contractCurrentTrackOrderItem.l(contractTrackOrderInfo);
        contractCurrentTrackOrderItem.j(this.B);
        return contractCurrentTrackOrderItem;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable q0(String str, int i11, int i12, Long l11) {
        if (!ContractModuleConfig.a().d()) {
            str = null;
        }
        return q7.a.a().G(str, (String) null, i11, i12, "0").b().flatMap(new g1(this)).map(new k1(this)).toList().flatMap(ad.i.f3526b).toList();
    }

    public static /* synthetic */ Boolean s0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public static /* synthetic */ Boolean u0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable v0(ContractCurrentTriggerOrderResult contractCurrentTriggerOrderResult) {
        this.f40817w = contractCurrentTriggerOrderResult;
        return Observable.from(contractCurrentTriggerOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ContractCurrentTriggerOrderInfo w0(ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo) {
        ContractCurrencyInfo h11 = ContractCurrencyUtils.h(contractCurrentTriggerOrderInfo.getContractCode());
        if (h11 != null) {
            contractCurrentTriggerOrderInfo.setContractFace(h11.getContractFace());
        }
        contractCurrentTriggerOrderInfo.setCallback(this.A);
        return contractCurrentTriggerOrderInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable x0(String str, int i11, int i12, Long l11) {
        if (!ContractModuleConfig.a().d()) {
            str = null;
        }
        return ContractOrderHelper.i(str, (String) null, i11, i12).flatMap(new i1(this)).map(new h1(this)).toList().flatMap(ad.i.f3526b).toList();
    }

    public void A0(View view) {
        v9.a<s9.a> aVar = this.f40802h;
        if (aVar != null) {
            aVar.j(view);
        }
    }

    public void B0(ContractPosition.a aVar) {
        this.f40815u = aVar;
    }

    public void C0(bm.a aVar) {
        this.D = aVar;
    }

    public void D0(j jVar) {
        if (jVar != null) {
            this.f40803i.add(jVar);
        }
    }

    public void E0(k kVar) {
        this.f40804j = kVar;
    }

    public final void F0(int i11, int i12) {
        if (i11 == 0) {
            this.f40798d.clear();
            this.f40798d.add(this.f40805k);
            this.f40802h.i(this.f40798d);
        } else if (i12 == 1) {
            if (this.f40796b.B0() == 1) {
                this.f40799e.clear();
                this.f40799e.add(this.f40805k);
                this.f40802h.i(this.f40799e);
            } else {
                return;
            }
        } else if (i12 == 2) {
            if (this.f40796b.B0() == 2) {
                this.f40800f.clear();
                this.f40800f.add(this.f40805k);
                this.f40802h.i(this.f40800f);
            } else {
                return;
            }
        } else if (i12 == 3) {
            if (this.f40796b.B0() == 3) {
                this.f40801g.clear();
                this.f40801g.add(this.f40805k);
                this.f40802h.i(this.f40801g);
            } else {
                return;
            }
        } else if (this.f40796b.B0() == 0) {
            this.f40797c.clear();
            this.f40797c.add(this.f40805k);
            this.f40802h.i(this.f40797c);
        } else {
            return;
        }
        this.f40802h.notifyDataSetChanged();
    }

    public final void G0(int i11, int i12) {
        F0(i11, i12);
    }

    public final void H0(String str, int i11, int i12, List<? extends s9.a> list) {
        int i13;
        this.f40797c.clear();
        if (list.isEmpty()) {
            this.f40797c.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f40797c.addAll(list);
            if (list.size() >= 10) {
                this.f40797c.add(new aj.e(str, i12, this.f40814t, this.f40813s.getContractShortType()));
            }
        }
        if (this.f40796b.B0() == 0) {
            this.f40802h.i(this.f40797c);
            this.f40802h.notifyDataSetChanged();
        }
        if (!this.f40803i.isEmpty()) {
            for (j next : this.f40803i) {
                if (next != null) {
                    next.a();
                }
            }
        }
        i iVar = this.f40796b;
        if (iVar != null) {
            ContractCurrentOrderResult contractCurrentOrderResult = this.f40816v;
            if (contractCurrentOrderResult == null) {
                i13 = 0;
            } else {
                i13 = contractCurrentOrderResult.getTotalSize();
            }
            iVar.h(i13);
        }
    }

    public void I0() {
        F0(U().e1(), U().T0());
    }

    public void J0(List<? extends s9.a> list) {
        this.f40798d.clear();
        if (list.isEmpty()) {
            bm.a aVar = this.D;
            if (aVar != null) {
                aVar.a(false);
            }
            this.f40798d.add(this.f40805k);
        } else {
            bm.a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.a(true);
            }
            this.f40798d.addAll(list);
        }
        if (U().v1() == 0) {
            this.f40802h.i(this.f40798d);
            this.f40802h.notifyDataSetChanged();
        }
        k kVar = this.f40804j;
        if (kVar != null) {
            kVar.c();
        }
    }

    public void K0() {
        F0(U().e1(), U().T0());
    }

    public final void L0(String str, int i11, int i12, List<? extends s9.a> list) {
        int i13;
        this.f40800f.clear();
        if (list.isEmpty()) {
            this.f40800f.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f40800f.addAll(list);
            if (list.size() >= 10) {
                this.f40800f.add(new aj.e(str, i12, this.f40814t, this.f40813s.getContractShortType()));
            }
        }
        if (this.f40796b.B0() == 2) {
            this.f40802h.i(this.f40800f);
            this.f40802h.notifyDataSetChanged();
        }
        i iVar = this.f40796b;
        if (iVar != null) {
            StopOrderRspResult stopOrderRspResult = this.f40818x;
            if (stopOrderRspResult == null) {
                i13 = 0;
            } else {
                i13 = stopOrderRspResult.getTotalSize();
            }
            iVar.f(i13);
        }
    }

    public void M() {
        this.f40797c.clear();
        this.f40798d.clear();
        this.f40799e.clear();
        this.f40800f.clear();
        this.f40801g.clear();
    }

    public final void M0(String str, int i11, int i12, List<? extends s9.a> list) {
        int i13;
        this.f40801g.clear();
        if (list.isEmpty()) {
            this.f40801g.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f40801g.addAll(list);
            if (list.size() >= 10) {
                this.f40801g.add(new aj.e(str, i12, this.f40814t, this.f40813s.getContractShortType()));
            }
        }
        if (this.f40796b.B0() == 3) {
            this.f40802h.i(this.f40801g);
            this.f40802h.notifyDataSetChanged();
        }
        i iVar = this.f40796b;
        if (iVar != null) {
            ContractCurrentTrackOrderResult contractCurrentTrackOrderResult = this.f40819y;
            if (contractCurrentTrackOrderResult == null) {
                i13 = 0;
            } else {
                i13 = contractCurrentTrackOrderResult.getTotalSize();
            }
            iVar.i(i13);
        }
    }

    public final Subscriber<List<ContractCurrentOrderItem>> N(String str, int i11, int i12) {
        return new c(i11, i12, str);
    }

    public final void N0(String str, int i11, int i12, List<? extends s9.a> list) {
        int i13;
        this.f40799e.clear();
        if (list.isEmpty()) {
            this.f40799e.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f40799e.addAll(list);
            if (list.size() >= 10) {
                this.f40799e.add(new aj.e(str, i12, this.f40814t, this.f40813s.getContractShortType()));
            }
        }
        if (this.f40796b.B0() == 1) {
            this.f40802h.i(this.f40799e);
            this.f40802h.notifyDataSetChanged();
        }
        i iVar = this.f40796b;
        if (iVar != null) {
            ContractCurrentTriggerOrderResult contractCurrentTriggerOrderResult = this.f40817w;
            if (contractCurrentTriggerOrderResult == null) {
                i13 = 0;
            } else {
                i13 = contractCurrentTriggerOrderResult.getTotalSize();
            }
            iVar.g(i13);
        }
    }

    public final Subscriber<List<ContractPosition>> O() {
        return new f();
    }

    public void O0(int i11, int i12) {
        F0(i11, i12);
    }

    public final Subscriber<List<ContractCurrentTrackOrderItem>> P(String str, int i11, int i12) {
        return new e(i11, i12, str);
    }

    public void P0() {
        Subscriber<ContractOpenCountInfo> subscriber = this.f40811q;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (BaseModuleConfig.a().a()) {
            this.f40811q = new a();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(r1.f12488b).retryWhen(t1.f12499b).compose(ContractRetrofit.h()).compose(RxJavaHelper.t(U())).subscribe(this.f40811q);
            return;
        }
        U().d1(this.f40812r);
    }

    public final Subscriber<List<ContractCurrentTriggerOrderInfo>> Q(String str, int i11, int i12) {
        return new d(i11, i12, str);
    }

    public void Q0(String str, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!BaseModuleConfig.a().a()) {
            O0(i15, i16);
        } else if (i14 != 2) {
            Subscriber<List<ContractCurrentOrderItem>> subscriber = this.f40807m;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f40807m = N(str, i15, i16);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new o1(this, str, i12, i13)).retryWhen(x1.f12525b).filter(new e2(i15)).compose(RxJavaHelper.t(U())).subscribe(this.f40807m);
        }
    }

    public List<s9.a> R() {
        return this.f40797c;
    }

    public void R0(String str, String str2, int i11, int i12) {
        Subscriber<List<ContractPosition>> subscriber = this.f40806l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (i11 == 2) {
            if (!BaseModuleConfig.a().a()) {
                K0();
                return;
            }
        } else if (!BaseModuleConfig.a().a()) {
            return;
        }
        l0.t().F();
        this.f40806l = O();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new q1(this, MapParamsBuilder.c().a("symbol", str).a("contract_code", str2).b())).retryWhen(v1.f12513b).compose(RxJavaHelper.t(U())).subscribe(this.f40806l);
    }

    public List<s9.a> S() {
        return this.f40798d;
    }

    public void S0(String str, int i11, int i12, int i13, int i14) {
        if (!BaseModuleConfig.a().a()) {
            O0(i13, i14);
            return;
        }
        Y0();
        this.f40809o = new b(i13, i14, str);
        Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new n1(this, str, i11, i12)).retryWhen(w1.f12519b).filter(new c2(i13)).compose(RxJavaHelper.t(U())).subscribe(this.f40809o);
    }

    public v9.a<s9.a> T() {
        return this.f40802h;
    }

    public void T0(String str, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!BaseModuleConfig.a().a()) {
            O0(i15, i16);
        } else if (i14 != 2) {
            Subscriber<List<ContractCurrentTrackOrderItem>> subscriber = this.f40810p;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f40810p = P(str, i15, i16);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new l1(this, str, i12, i13)).retryWhen(u1.f12504b).filter(new d2(i15)).compose(RxJavaHelper.t(U())).subscribe(this.f40810p);
        }
    }

    public final p1 U() {
        return this.f40795a;
    }

    public void U0(String str, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!BaseModuleConfig.a().a()) {
            O0(i15, i16);
        } else if (i14 != 2) {
            Subscriber<List<ContractCurrentTriggerOrderInfo>> subscriber = this.f40808n;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f40808n = Q(str, i15, i16);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new m1(this, str, i12, i13)).retryWhen(y1.f12530b).filter(new b2(i15)).compose(RxJavaHelper.t(U())).subscribe(this.f40808n);
        }
    }

    public void V0() {
        Subscriber<ContractOpenCountInfo> subscriber = this.f40811q;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void W0() {
        Subscriber<List<ContractCurrentOrderItem>> subscriber = this.f40807m;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void X0() {
        Subscriber<List<ContractPosition>> subscriber = this.f40806l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        l0.t().Y();
    }

    public void Y0() {
        Subscriber<List<aj.c>> subscriber = this.f40809o;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void Z0() {
        Subscriber<List<ContractCurrentTrackOrderItem>> subscriber = this.f40810p;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void a1() {
        Subscriber<List<ContractCurrentTriggerOrderInfo>> subscriber = this.f40808n;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void y0(i iVar) {
        this.f40796b = iVar;
    }

    public void z0(ContractCurrencyInfo contractCurrencyInfo) {
        this.f40813s = contractCurrencyInfo;
    }
}
