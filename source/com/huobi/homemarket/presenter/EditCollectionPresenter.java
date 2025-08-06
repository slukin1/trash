package com.huobi.homemarket.presenter;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$string;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.homemarket.bean.CollectionMultiple;
import com.huobi.homemarket.model.CollEditModel;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rl.b;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import u6.g;
import us.j;

public class EditCollectionPresenter extends ActivityPresenter<f> {

    /* renamed from: a  reason: collision with root package name */
    public List<CollEditModel> f72742a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b  reason: collision with root package name */
    public List<CollEditModel> f72743b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c  reason: collision with root package name */
    public LinearLayoutManager f72744c;

    /* renamed from: d  reason: collision with root package name */
    public v9.a<s9.a> f72745d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f72746e = new LinkedHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public rl.c f72747f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Boolean> f72748g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public boolean f72749h = true;

    /* renamed from: i  reason: collision with root package name */
    public CollEditModel.a f72750i = new b();

    /* renamed from: j  reason: collision with root package name */
    public b.a f72751j = new c();

    public class a extends BaseSubscriber<List<String>> {
        public a() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            EditCollectionPresenter.this.f72745d.notifyDataSetChanged();
        }
    }

    public class b implements CollEditModel.a {
        public b() {
        }

        public void a(CollEditModel collEditModel) {
            try {
                int indexOf = EditCollectionPresenter.this.f72743b.indexOf(collEditModel);
                EditCollectionPresenter.this.f72743b.remove(collEditModel);
                EditCollectionPresenter.this.f72743b.add(0, collEditModel);
                EditCollectionPresenter.this.f72745d.notifyItemMoved(indexOf, 0);
                EditCollectionPresenter.this.f72744c.scrollToPosition(0);
                EditCollectionPresenter.this.f72742a.remove(collEditModel);
                EditCollectionPresenter.this.f72742a.add(0, collEditModel);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class c implements b.a {
        public c() {
        }

        public void a(int i11) {
        }

        public boolean onMove(int i11, int i12) {
            List<CollEditModel> list = EditCollectionPresenter.this.f72743b;
            if (list == null) {
                return false;
            }
            Collections.swap(EditCollectionPresenter.this.f72743b, i11, i12);
            EditCollectionPresenter.this.f72745d.notifyItemMoved(i11, i12);
            int indexOf = EditCollectionPresenter.this.f72742a.indexOf(list.get(i11));
            int indexOf2 = EditCollectionPresenter.this.f72742a.indexOf(EditCollectionPresenter.this.f72743b.get(i12));
            if (indexOf < 0 || indexOf2 < 0) {
                return true;
            }
            Collections.swap(EditCollectionPresenter.this.f72742a, indexOf, indexOf2);
            return true;
        }
    }

    public class d extends q6.d<Object> {
        public d(g gVar) {
            super(gVar);
        }

        public void onAfter() {
            super.onAfter();
            EditCollectionPresenter.this.getActivity().finish();
        }
    }

    public class e extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f72756b;

        public e(List list) {
            this.f72756b = list;
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            MarketModuleConfig.a().f0(this.f72756b);
            EditCollectionPresenter.this.s0();
        }

        public void onStart() {
            super.onStart();
        }
    }

    public interface f extends g {
        void H4(boolean z11);

        RecyclerView Y0();

        void Y5(boolean z11);

        boolean va();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(List list, List list2, List list3, Object obj) {
        MarketModuleConfig.a().R(list);
        MarketModuleConfig.a().f0(list2);
        this.f72743b.removeAll(list3);
        this.f72742a.removeAll(list3);
        ((f) getUI()).Y5(false);
        ((f) getUI()).H4(false);
        this.f72745d.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(List list, List list2, List list3, List list4, boolean z11, Throwable th2) {
        if (z11) {
            b0(list, list2, list3, list4);
        }
    }

    public static /* synthetic */ int k0(CollEditModel collEditModel, CollEditModel collEditModel2) {
        Integer num;
        Integer num2 = 0;
        try {
            num = Integer.valueOf(collEditModel2.getWeight());
            try {
                num2 = Integer.valueOf(collEditModel.getWeight());
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num2.compareTo(num);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = num2;
            e.printStackTrace();
            return num2.compareTo(num);
        }
        return num2.compareTo(num);
    }

    public static /* synthetic */ int l0(CollEditModel collEditModel, CollEditModel collEditModel2) {
        Integer num;
        Integer num2 = 0;
        try {
            num = Integer.valueOf(collEditModel2.getWeight());
            try {
                num2 = Integer.valueOf(collEditModel.getWeight());
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num2.compareTo(num);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = num2;
            e.printStackTrace();
            return num2.compareTo(num);
        }
        return num2.compareTo(num);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(List list) {
        r0(list);
        d0(list);
    }

    public void Z(boolean z11) {
        if (!this.f72743b.isEmpty()) {
            for (CollEditModel collection : this.f72743b) {
                collection.setCollection(z11);
            }
            this.f72745d.notifyDataSetChanged();
            if (z11) {
                ((f) getUI()).Y5(true);
            } else {
                ((f) getUI()).Y5(false);
            }
        } else {
            ((f) getUI()).Y5(false);
        }
    }

    public final CollEditModel a0(String str, String str2, String str3) {
        CollEditModel collEditModel = new CollEditModel();
        if (this.f72746e.get(str) != null) {
            collEditModel.setWeight(this.f72746e.get(str).intValue());
        } else {
            collEditModel.setWeight(0);
        }
        collEditModel.setShowSymbol(str2);
        collEditModel.setQuoteCurrency(str3);
        if (this.f72748g.get(str) != null) {
            collEditModel.setCollection(this.f72748g.get(str).booleanValue());
        } else if (((f) getUI()).va()) {
            collEditModel.setCollection(true);
        } else {
            collEditModel.setCollection(false);
        }
        collEditModel.setSymbol(str);
        collEditModel.setItemTouchHelp(this.f72747f);
        collEditModel.setCallback(this.f72750i);
        return collEditModel;
    }

    public final void b0(List<CollEditModel> list, List<CollectionMultiple> list2, List<String> list3, List<String> list4) {
        MarketModuleConfig.a().c0(list2, getActivity()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new tl.d(this, list4, list3, list)));
    }

    public void c0() {
        if (!this.f72743b.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            StringBuilder sb2 = new StringBuilder();
            for (CollEditModel next : this.f72742a) {
                if (next.isCollection()) {
                    arrayList.add(next);
                    arrayList3.add(next.getSymbol());
                    sb2.append(next.getSymbol());
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                } else {
                    CollectionMultiple collectionMultiple = new CollectionMultiple();
                    collectionMultiple.setWebsite(MarketModuleConfig.a().e0(next.getSymbol()));
                    collectionMultiple.setTradingPair(next.getSymbol());
                    arrayList2.add(collectionMultiple);
                    arrayList4.add(next.getSymbol());
                }
            }
            if (sb2.length() > 0) {
                MarketModuleConfig.a().g(sb2.substring(0, sb2.length() - 1), new tl.e(this, arrayList, arrayList2, arrayList4, arrayList3));
            } else {
                b0(arrayList, arrayList2, arrayList4, arrayList3);
            }
        }
    }

    public final void d0(List<String> list) {
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
            List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
            List<FutureContractInfo> f11 = FutureContractInfoController.n().f();
            List<IndexCurrencyInfo> d11 = IndexCurrencyInfoController.k().d();
            for (String next : list) {
                if (MarketModuleConfig.a().l().equals(MarketModuleConfig.a().e0(next))) {
                    SymbolBean J = a1.v().J(next, TradeType.PRO);
                    if (J != null && J.isCanTrade()) {
                        String baseCurrencyDisplayName = J.getBaseCurrencyDisplayName();
                        CollEditModel a02 = a0(next, baseCurrencyDisplayName, "/" + J.getQuoteCurrencyDisplayName());
                        if (this.f72749h) {
                            arrayList.add(a02);
                        }
                        arrayList2.add(a02);
                    }
                } else {
                    String str = "";
                    if (MarketModuleConfig.a().x().equals(MarketModuleConfig.a().e0(next))) {
                        if (gj.d.n().E()) {
                            if (m11 == null || m11.isEmpty()) {
                                CollEditModel a03 = a0(next, ej.g.d(next, str, 1), (String) null);
                                if (!this.f72749h) {
                                    arrayList.add(a03);
                                }
                                arrayList2.add(a03);
                            } else {
                                for (ContractCurrencyInfo next2 : m11) {
                                    if (next.equals(next2.getContractShortType())) {
                                        CollEditModel a04 = a0(next, ej.g.d(next2.getContractShortType(), next2.getContractCode(), 1), (String) null);
                                        if (!this.f72749h) {
                                            arrayList.add(a04);
                                        }
                                        arrayList2.add(a04);
                                    }
                                }
                            }
                        }
                    } else if (MarketModuleConfig.a().v().equals(MarketModuleConfig.a().e0(next))) {
                        if (gj.d.n().E()) {
                            if (e11 == null || e11.isEmpty()) {
                                String[] split = next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                if (split.length > 0) {
                                    str = split[0];
                                }
                                CollEditModel a05 = a0(next, j.f(str, getActivity()), (String) null);
                                if (!this.f72749h) {
                                    arrayList.add(a05);
                                }
                                arrayList2.add(a05);
                            } else {
                                for (SwapCurrencyInfo contractShortType : e11) {
                                    if (next.equals(contractShortType.getContractShortType())) {
                                        String[] split2 = next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                        CollEditModel a06 = a0(next, j.f(split2.length > 0 ? split2[0] : str, getActivity()), (String) null);
                                        if (!this.f72749h) {
                                            arrayList.add(a06);
                                        }
                                        arrayList2.add(a06);
                                    }
                                }
                            }
                        }
                    } else if (MarketModuleConfig.a().z().equals(MarketModuleConfig.a().e0(next))) {
                        if (gj.d.n().E()) {
                            if (f11 == null || f11.isEmpty()) {
                                String[] split3 = next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                String str2 = split3.length > 0 ? split3[0] : str;
                                if (split3.length > 0) {
                                    str = split3[1];
                                }
                                CollEditModel a07 = a0(next, a7.e.l(getActivity(), str2, str), (String) null);
                                if (!this.f72749h) {
                                    arrayList.add(a07);
                                }
                                arrayList2.add(a07);
                            } else {
                                for (FutureContractInfo next3 : f11) {
                                    if (next.equals(next3.getContractShortType())) {
                                        CollEditModel a08 = a0(next, a7.e.p(BaseApplication.b(), next3.getSymbol(), next3.getQuoteCurrency()), a7.e.q(BaseApplication.b(), next3.getContractCode(), next3.getContractType()));
                                        if (!this.f72749h) {
                                            arrayList.add(a08);
                                        }
                                        arrayList2.add(a08);
                                    }
                                }
                            }
                        }
                    } else if (MarketModuleConfig.a().N().equals(MarketModuleConfig.a().e0(next))) {
                        if (d11 == null || d11.isEmpty()) {
                            String[] split4 = next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            String str3 = split4.length > 0 ? split4[0] : str;
                            if (split4.length > 0) {
                                str = split4[1];
                            }
                            CollEditModel a09 = a0(next, j.a(str3, BaseApplication.b()), str);
                            if (!this.f72749h) {
                                arrayList.add(a09);
                            }
                            arrayList2.add(a09);
                        } else {
                            for (IndexCurrencyInfo next4 : d11) {
                                if (next.equals(next4.getContractShortType())) {
                                    CollEditModel a010 = a0(next, j.c(BaseApplication.b(), next4.getSymbol(), next4.getQuoteCurrency()), BaseApplication.b().getString(R$string.n_market_contract_index_trade_name));
                                    if (!this.f72749h) {
                                        arrayList.add(a010);
                                    }
                                    arrayList2.add(a010);
                                }
                            }
                        }
                    }
                }
            }
            Collections.sort(arrayList, tl.b.f29332b);
            Collections.sort(arrayList2, tl.a.f29330b);
            this.f72743b.addAll(arrayList);
            this.f72742a.addAll(arrayList2);
        }
    }

    public final void f0() {
        this.f72742a.clear();
        this.f72743b.clear();
        this.f72745d.notifyDataSetChanged();
        Observable.just(MarketModuleConfig.a().m0()).subscribeOn(Schedulers.io()).doOnNext(new tl.c(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public final void g0() {
        this.f72744c = new LinearLayoutManager(getActivity(), 1, false);
        ((f) getUI()).Y0().setLayoutManager(this.f72744c);
        this.f72745d = new v9.a<>(this.f72743b);
        ((f) getUI()).Y0().setAdapter(this.f72745d);
        rl.c cVar = new rl.c(this.f72751j);
        this.f72747f = cVar;
        cVar.b(((f) getUI()).Y0());
        this.f72747f.C(true);
    }

    public void h0() {
        if (!this.f72743b.isEmpty()) {
            int i11 = 0;
            boolean z11 = false;
            for (CollEditModel isCollection : this.f72743b) {
                if (isCollection.isCollection()) {
                    i11++;
                    z11 = true;
                }
            }
            if (i11 != this.f72743b.size()) {
                ((f) getUI()).H4(false);
            } else {
                ((f) getUI()).H4(true);
            }
            ((f) getUI()).Y5(z11);
            return;
        }
        ((f) getUI()).Y5(false);
    }

    /* renamed from: n0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, f fVar) {
        super.onUIReady(baseCoreActivity, fVar);
        if (baseCoreActivity.getIntent() != null) {
            this.f72749h = baseCoreActivity.getIntent().getBooleanExtra("isSpot", true);
        }
        g0();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            if (!this.f72743b.isEmpty()) {
                for (CollEditModel symbol : this.f72743b) {
                    this.f72748g.put(symbol.getSymbol(), Boolean.FALSE);
                }
            }
            ((f) getUI()).H4(false);
            ((f) getUI()).Y5(false);
            f0();
        }
    }

    public void onResume() {
        super.onResume();
        ((f) getUI()).Y5(false);
        ((f) getUI()).H4(false);
        f0();
    }

    public void p0() {
        if (!this.f72743b.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (CollEditModel symbol : this.f72742a) {
                arrayList.add(symbol.getSymbol());
            }
            MarketModuleConfig.a().Z(getActivity(), arrayList).subscribe(new e(arrayList));
            return;
        }
        s0();
    }

    public void q0() {
        if (!this.f72743b.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (CollEditModel next : this.f72742a) {
                CollectionMultiple collectionMultiple = new CollectionMultiple();
                collectionMultiple.setWebsite(MarketModuleConfig.a().e0(next.getSymbol()));
                collectionMultiple.setTradingPair(next.getSymbol());
                arrayList.add(collectionMultiple);
            }
            MarketModuleConfig.a().c0(arrayList, getActivity()).compose(RxJavaHelper.t((g) getUI())).subscribe(new d((g) getUI()));
            return;
        }
        getActivity().finish();
    }

    public final void r0(List<String> list) {
        if (!list.isEmpty()) {
            this.f72746e.clear();
            for (int i11 = 0; i11 < list.size(); i11++) {
                this.f72746e.put(list.get(i11), Integer.valueOf(i11));
            }
        }
    }

    public final void s0() {
        MarketModuleConfig.a().h(getActivity());
    }
}
