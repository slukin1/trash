package com.huobi.finance.model;

import al.e0;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.c2c.C2CSymbolsProvider;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.c2c.util.c;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.C2CLendBalanceDataTotal;
import com.huobi.finance.bean.C2CLendBalanceDetailInfo;
import com.huobi.finance.bean.C2CMarginBalanceDataTotal;
import com.huobi.finance.bean.C2CMarginBalanceDetailInfo;
import com.huobi.finance.bean.ContractDataTotal;
import com.huobi.finance.bean.GridDataTotal;
import com.huobi.finance.bean.LegalDataTotal;
import com.huobi.finance.bean.LinearSwapDataTotal;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.bean.MineDataTotal;
import com.huobi.finance.bean.MiningDataTotal;
import com.huobi.finance.bean.OnChainDataTotal;
import com.huobi.finance.bean.OptionDataTotal;
import com.huobi.finance.bean.OtcOptionDataTotal;
import com.huobi.finance.bean.SavingsDataTotal;
import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.finance.bean.SwapDataTotal;
import com.huobi.finance.model.subaccount.GridDataProvider;
import com.huobi.finance.model.subaccount.LinearSwapDataProvider;
import com.huobi.finance.model.subaccount.MiningDataProvider;
import com.huobi.finance.model.subaccount.OnChainDataProvider;
import com.huobi.finance.model.subaccount.OptionDataProvider;
import com.huobi.finance.model.subaccount.OtcOptonDataProvider;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.supermargin.bean.MarginCurrency;
import d7.a1;
import d7.k;
import dt.h2;
import i6.d;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.schedulers.Schedulers;
import u6.g;
import wk.a;
import wk.b;
import wk.b0;
import wk.c0;
import wk.d0;
import wk.e;
import wk.f;
import wk.f0;
import wk.g0;
import wk.h;
import wk.h0;
import wk.i;
import wk.i0;
import wk.j;
import wk.j0;
import wk.k0;
import wk.l;
import wk.l0;
import wk.m0;
import wk.n;
import wk.o;
import wk.q;
import wk.r;
import wk.r0;
import wk.s;
import wk.t;
import wk.u;
import wk.v;
import wk.w;
import wk.x;
import wk.y;
import wk.z;

public class AssetDataCacheManager {

    /* renamed from: m  reason: collision with root package name */
    public static volatile AssetDataCacheManager f45429m;

    /* renamed from: a  reason: collision with root package name */
    public final OptionDataProvider f45430a = new OptionDataProvider();

    /* renamed from: b  reason: collision with root package name */
    public final LinearSwapDataProvider f45431b = new LinearSwapDataProvider();

    /* renamed from: c  reason: collision with root package name */
    public final MiningDataProvider f45432c;

    /* renamed from: d  reason: collision with root package name */
    public final OnChainDataProvider f45433d;

    /* renamed from: e  reason: collision with root package name */
    public final OtcOptonDataProvider f45434e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<BaseAssetTotal> f45435f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<Integer> f45436g = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    public String f45437h;

    /* renamed from: i  reason: collision with root package name */
    public final r0<MiningDataTotal> f45438i;

    /* renamed from: j  reason: collision with root package name */
    public final r0<GridDataTotal> f45439j;

    /* renamed from: k  reason: collision with root package name */
    public final r0<OnChainDataTotal> f45440k;

    /* renamed from: l  reason: collision with root package name */
    public final r0<OtcOptionDataTotal> f45441l;

    public AssetDataCacheManager() {
        MiningDataProvider miningDataProvider = new MiningDataProvider();
        this.f45432c = miningDataProvider;
        this.f45438i = new r0<>(miningDataProvider);
        this.f45439j = new r0<>(new GridDataProvider());
        OnChainDataProvider onChainDataProvider = new OnChainDataProvider();
        this.f45433d = onChainDataProvider;
        this.f45440k = new r0<>(onChainDataProvider);
        OtcOptonDataProvider otcOptonDataProvider = new OtcOptonDataProvider();
        this.f45434e = otcOptonDataProvider;
        this.f45441l = new r0<>(otcOptonDataProvider);
    }

    public static /* synthetic */ BalanceDataTotal N0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof BalanceDataTotal) {
            return (BalanceDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ ContractDataTotal O0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof ContractDataTotal) {
            return (ContractDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ LegalDataTotal P0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof LegalDataTotal) {
            return (LegalDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ LinearSwapDataTotal Q0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof LinearSwapDataTotal) {
            return (LinearSwapDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ MineDataTotal R0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof MineDataTotal) {
            return (MineDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ OptionDataTotal S0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof OptionDataTotal) {
            return (OptionDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ SavingsDataTotal T0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof SavingsDataTotal) {
            return (SavingsDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ SuperMarginDataTotal U0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof SuperMarginDataTotal) {
            return (SuperMarginDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ SwapDataTotal V0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof SwapDataTotal) {
            return (SwapDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ C2CMarginBalanceDataTotal W0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof C2CMarginBalanceDataTotal) {
            return (C2CMarginBalanceDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ C2CLendBalanceDataTotal X0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof C2CLendBalanceDataTotal) {
            return (C2CLendBalanceDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ MarginBalanceDataTotal Y0(BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal instanceof MarginBalanceDataTotal) {
            return (MarginBalanceDataTotal) baseAssetTotal;
        }
        return null;
    }

    public static /* synthetic */ BalanceDataTotal Z0(BalanceDataTotal balanceDataTotal, List list, List list2) {
        return balanceDataTotal;
    }

    public static /* synthetic */ Observable a1(boolean z11, List list) {
        Observable<BalanceDataTotal> K1 = h2.t1().K1(z11);
        Observable<List<LegalRateBean>> X = LegalCurrencyConfigUtil.X(true);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Observable.zip(K1, X.timeout(5000, timeUnit).onErrorResumeNext(Observable.just(new ArrayList())).compose(RxJavaHelper.t((g) null)), OtcMarketPriceConfigUtil.f(true).timeout(5000, timeUnit).onErrorResumeNext(Observable.just(new ArrayList())).compose(RxJavaHelper.t((g) null)), b0.f61378b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b1(BalanceDataTotal balanceDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(1, 0);
        z1(1, balanceDataTotal);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c1(ContractDataTotal contractDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(3, 0);
        z1(3, contractDataTotal);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d1(LegalDataTotal legalDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(2, 0);
        z1(2, legalDataTotal);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e1(LinearSwapDataTotal linearSwapDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(11, 0);
        z1(11, linearSwapDataTotal);
    }

    public static /* synthetic */ MineDataTotal f1(MineDataTotal mineDataTotal, List list, List list2, List list3) {
        List<? extends BaseAssetInfo> detailInfos = mineDataTotal.getDetailInfos();
        h2.t1().O3(detailInfos, list3);
        Collections.sort(detailInfos, h2.t1().B1());
        return mineDataTotal;
    }

    public static /* synthetic */ Observable g1(boolean z11, List list) {
        Observable<MineDataTotal> O1 = h2.t1().O1(z11);
        Observable<List<LegalRateBean>> X = LegalCurrencyConfigUtil.X(true);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Observable.zip(O1, X.timeout(5000, timeUnit).onErrorResumeNext(Observable.just(new ArrayList())).compose(RxJavaHelper.t((g) null)), OtcMarketPriceConfigUtil.f(true).timeout(5000, timeUnit).onErrorResumeNext(Observable.just(new ArrayList())).compose(RxJavaHelper.t((g) null)), al.b0.e(true), d0.f61382b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h1(MineDataTotal mineDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(5, 0);
        z1(5, mineDataTotal);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i1(OptionDataTotal optionDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(10, 0);
        z1(10, optionDataTotal);
    }

    public static /* synthetic */ SavingsDataTotal j1(SavingsDataTotal savingsDataTotal, List list, List list2, List list3) {
        List<? extends BaseAssetInfo> detailInfos = savingsDataTotal.getDetailInfos();
        h2.t1().P3(detailInfos, list3);
        Collections.sort(detailInfos, h2.t1().F1());
        return savingsDataTotal;
    }

    public static AssetDataCacheManager k0() {
        if (f45429m == null) {
            synchronized (AssetDataCacheManager.class) {
                if (f45429m == null) {
                    f45429m = new AssetDataCacheManager();
                }
            }
        }
        return f45429m;
    }

    public static /* synthetic */ Observable k1(boolean z11, List list) {
        Observable<SavingsDataTotal> P1 = h2.t1().P1(z11);
        Observable<List<LegalRateBean>> X = LegalCurrencyConfigUtil.X(true);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Observable.zip(P1, X.timeout(5000, timeUnit).onErrorResumeNext(Observable.just(new ArrayList())).compose(RxJavaHelper.t((g) null)), OtcMarketPriceConfigUtil.f(true).timeout(5000, timeUnit).onErrorResumeNext(Observable.just(new ArrayList())).compose(RxJavaHelper.t((g) null)), e0.d(true), wk.e0.f61385b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1(SavingsDataTotal savingsDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(9, 0);
        z1(9, savingsDataTotal);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable m1(boolean z11, List list) {
        return Observable.zip(h2.t1().Q1(z11), AssetModuleConfig.a().G0(z11).subscribeOn(Schedulers.io()), new x(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n1(SuperMarginDataTotal superMarginDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(4, 0);
        z1(4, superMarginDataTotal);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o1(SwapDataTotal swapDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(6, 0);
        z1(6, swapDataTotal);
    }

    public static /* synthetic */ C2CLendBalanceDataTotal q1(List list, C2CLendBalanceDataTotal c2CLendBalanceDataTotal, List list2) {
        if (c2CLendBalanceDataTotal != null) {
            List<C2CLendBalanceDetailInfo> detailInfoList = c2CLendBalanceDataTotal.getDetailInfoList();
            h2.t1().L3(detailInfoList, list);
            Collections.sort(detailInfoList, h2.t1().j1());
            c2CLendBalanceDataTotal.setDetailInfos(detailInfoList);
        }
        return c2CLendBalanceDataTotal;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r1(C2CLendBalanceDataTotal c2CLendBalanceDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(8, 0);
        z1(8, c2CLendBalanceDataTotal);
    }

    public static /* synthetic */ C2CMarginBalanceDataTotal s1(String str, List list, C2CMarginBalanceDataTotal c2CMarginBalanceDataTotal, List list2) {
        if (c2CMarginBalanceDataTotal != null) {
            List<C2CMarginBalanceDetailInfo> n12 = h2.t1().n1(str, c2CMarginBalanceDataTotal.getDetailAsset());
            h2.t1().M3(n12, list);
            Collections.sort(n12, h2.t1().m1());
            c2CMarginBalanceDataTotal.setDetailInfos(n12);
        }
        return c2CMarginBalanceDataTotal;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t1(C2CMarginBalanceDataTotal c2CMarginBalanceDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(7, 0);
        z1(7, c2CMarginBalanceDataTotal);
    }

    public static /* synthetic */ MarginBalanceDataTotal u1(String str, List list, MarginBalanceDataTotal marginBalanceDataTotal, List list2) {
        if (marginBalanceDataTotal != null) {
            List<MarginBalanceDetailInfo> A1 = h2.t1().g2(str, marginBalanceDataTotal.getDetailAsset());
            h2.t1().N3(A1);
            marginBalanceDataTotal.setDetailInfos(A1);
        }
        return marginBalanceDataTotal;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(MarginBalanceDataTotal marginBalanceDataTotal) {
        this.f45437h = BaseModuleConfig.a().getUid();
        A1(0, 0);
        z1(0, marginBalanceDataTotal);
    }

    public static /* synthetic */ MarginBalanceDataTotal x1(String str, MarginBalanceDataTotal marginBalanceDataTotal, List list) {
        if (marginBalanceDataTotal != null) {
            marginBalanceDataTotal.setDetailInfos(h2.t1().g2(str, marginBalanceDataTotal.getDetailAsset()));
        }
        return marginBalanceDataTotal;
    }

    public static /* synthetic */ int y1(SuperMarginDetailInfo superMarginDetailInfo, SuperMarginDetailInfo superMarginDetailInfo2) {
        try {
            BigDecimal a11 = m.a(superMarginDetailInfo.getEstimateAmount());
            BigDecimal a12 = m.a(superMarginDetailInfo2.getEstimateAmount());
            if (a11.compareTo(BigDecimal.ZERO) < 0 || a12.compareTo(BigDecimal.ZERO) < 0) {
                return a11.compareTo(a12);
            }
            return h2.t1().e1().compare(superMarginDetailInfo, superMarginDetailInfo2);
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public Observable<C2CLendBalanceDataTotal> A0() {
        boolean z11 = (R(8) & 1) == 0;
        return Observable.zip(c.d(z11, true), h2.t1().L1(z11), LegalCurrencyConfigUtil.X(true).timeout(5000, TimeUnit.MILLISECONDS).onErrorResumeNext(Observable.just(new ArrayList())), c0.f61380b).doOnNext(new w(this));
    }

    public void A1(int i11, int i12) {
        this.f45436g.put(i11, Integer.valueOf(i12));
    }

    public Observable<C2CMarginBalanceDataTotal> B0() {
        boolean z11 = (R(7) & 1) == 0;
        return Observable.zip(C2CSymbolsProvider.c(z11), h2.t1().M1(z11, (String) null), LegalCurrencyConfigUtil.X(true).timeout(5000, TimeUnit.MILLISECONDS).onErrorResumeNext(Observable.just(new ArrayList())), new z((String) null)).doOnNext(new g0(this));
    }

    public void B1() {
        try {
            if (this.f45436g.size() != 0) {
                int size = this.f45436g.size();
                for (int i11 = 0; i11 < size; i11++) {
                    int keyAt = this.f45436g.keyAt(i11);
                    Integer num = this.f45436g.get(keyAt);
                    if (num != null) {
                        this.f45436g.put(keyAt, Integer.valueOf(num.intValue() | 1));
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public Observable<MarginBalanceDataTotal> C0() {
        String g02 = a1.v().g0();
        boolean z11 = false;
        if ((R(0) & 1) == 0) {
            z11 = true;
        }
        return k.C().n(true, p.b(), "2").subscribeOn(Schedulers.io()).flatMap(new i(z11, g02)).doOnNext(new k0(this));
    }

    public final void C1(ArrayList<SuperMarginDetailInfo> arrayList) {
        Collections.sort(arrayList, a.f61375b);
    }

    public Observable<MarginBalanceDataTotal> D0(boolean z11, String str) {
        return Observable.zip(h2.t1().N1(TradeType.MARGIN, false, z11, str), LegalCurrencyConfigUtil.X(true).timeout(5000, TimeUnit.MILLISECONDS).onErrorResumeNext(Observable.just(new ArrayList())), new y(str));
    }

    public Observable<OnChainDataTotal> E0() {
        return this.f45440k.d();
    }

    public Observable<OptionDataTotal> F0() {
        return Observable.concat(b0(), v0());
    }

    public Observable<OtcOptionDataTotal> G0() {
        return this.f45441l.d();
    }

    public OtcOptonDataProvider H0() {
        return this.f45434e;
    }

    public Observable<SavingsDataTotal> I0() {
        return Observable.concat(c0(), w0());
    }

    public Observable<SuperMarginDataTotal> J0() {
        return Observable.concat(d0(), x0());
    }

    public Observable<SwapDataTotal> K0() {
        return Observable.concat(e0(), y0());
    }

    public boolean L0(int i11) {
        BaseAssetTotal Q = Q(i11);
        return Q != null && Q.isValid();
    }

    public final boolean M0() {
        String str = this.f45437h;
        return str != null && str.equals(BaseModuleConfig.a().getUid());
    }

    public final SuperMarginDataTotal N(SuperMarginDataTotal superMarginDataTotal, List<MarginCurrency> list) {
        SuperMarginDetailInfo superMarginDetailInfo;
        Map<String, SuperMarginDetailInfo> detailMap = superMarginDataTotal.getDetailMap();
        ArrayList arrayList = new ArrayList();
        for (MarginCurrency next : list) {
            String currency = next.getCurrency();
            if (detailMap.containsKey(StringUtils.g(currency))) {
                superMarginDetailInfo = detailMap.get(StringUtils.g(currency));
            } else {
                superMarginDetailInfo = new SuperMarginDetailInfo();
                superMarginDetailInfo.setDisplayName(k.C().z(currency));
            }
            superMarginDetailInfo.fillEmptyValues();
            superMarginDetailInfo.setCurrency(currency);
            if (next.getState() == 0 && m.a(superMarginDetailInfo.getEstimateAmount()).compareTo(BigDecimal.ZERO) == 0) {
                d.i("Hide Coin : " + superMarginDetailInfo.toString());
            } else {
                arrayList.add(superMarginDetailInfo);
            }
        }
        C1(arrayList);
        superMarginDataTotal.setDetailInfos(arrayList);
        return superMarginDataTotal;
    }

    public void O() {
        this.f45437h = null;
        B1();
        this.f45435f.clear();
        this.f45438i.c();
        this.f45440k.c();
    }

    public BaseAssetTotal P(SparseIntArray sparseIntArray) {
        return new BaseAssetTotal();
    }

    public BaseAssetTotal Q(int i11) {
        return this.f45435f.get(i11);
    }

    public int R(int i11) {
        Integer num = this.f45436g.get(i11);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public Observable<BalanceDataTotal> S() {
        return Observable.concat(W(), q0());
    }

    public Observable<C2CLendBalanceDataTotal> T() {
        return Observable.concat(g0(), A0());
    }

    public Observable<C2CMarginBalanceDataTotal> U() {
        return Observable.concat(f0(), B0());
    }

    public Observable<BaseAssetTotal> V(int i11) {
        return (!M0() || !L0(i11)) ? Observable.empty() : Observable.just(Q(i11)).onErrorResumeNext(Observable.empty());
    }

    public Observable<BalanceDataTotal> W() {
        return V(1).map(wk.k.f61397b);
    }

    public Observable<ContractDataTotal> X() {
        return V(3).map(o.f61405b);
    }

    public Observable<LegalDataTotal> Y() {
        return V(2).map(j.f61395b);
    }

    public Observable<LinearSwapDataTotal> Z() {
        return V(11).map(q.f61408b);
    }

    public Observable<MineDataTotal> a0() {
        return V(5).map(r.f61410b);
    }

    public Observable<OptionDataTotal> b0() {
        return V(10).map(s.f61411b);
    }

    public Observable<SavingsDataTotal> c0() {
        return V(9).map(t.f61413b);
    }

    public Observable<SuperMarginDataTotal> d0() {
        return V(4).map(wk.m.f61401b);
    }

    public Observable<SwapDataTotal> e0() {
        return V(6).map(n.f61403b);
    }

    public Observable<C2CMarginBalanceDataTotal> f0() {
        return V(7).map(v.f61417b);
    }

    public Observable<C2CLendBalanceDataTotal> g0() {
        return V(8).map(wk.p.f61407b);
    }

    public Observable<MarginBalanceDataTotal> h0() {
        return V(0).map(u.f61415b);
    }

    public Observable<ContractDataTotal> i0() {
        return Observable.concat(X(), r0());
    }

    public Observable<GridDataTotal> j0() {
        return this.f45439j.d();
    }

    public Observable<LegalDataTotal> l0() {
        return Observable.concat(Y(), s0());
    }

    public Observable<LinearSwapDataTotal> m0() {
        return Observable.concat(Z(), t0());
    }

    public Observable<MarginBalanceDataTotal> n0() {
        return Observable.concat(h0(), C0());
    }

    public Observable<MineDataTotal> o0() {
        return Observable.concat(a0(), u0());
    }

    public Observable<MiningDataTotal> p0() {
        return this.f45438i.d();
    }

    public Observable<BalanceDataTotal> q0() {
        return k.C().n(true, p.b(), "2").subscribeOn(Schedulers.io()).flatMap(new wk.g((R(1) & 1) == 0)).doOnNext(new l(this));
    }

    public Observable<ContractDataTotal> r0() {
        h2 t12 = h2.t1();
        boolean z11 = true;
        if ((R(3) & 1) != 0) {
            z11 = false;
        }
        return t12.r1(z11).doOnNext(new h0(this));
    }

    public Observable<LegalDataTotal> s0() {
        return h2.t1().v1().doOnNext(new i0(this));
    }

    public Observable<LinearSwapDataTotal> t0() {
        LinearSwapDataProvider linearSwapDataProvider = this.f45431b;
        boolean z11 = true;
        if ((R(11) & 1) != 0) {
            z11 = false;
        }
        return linearSwapDataProvider.a(z11).doOnNext(new j0(this));
    }

    public Observable<MineDataTotal> u0() {
        return k.C().n(true, p.b(), "2").subscribeOn(Schedulers.io()).flatMap(new f((R(5) & 1) == 0)).doOnNext(new l0(this));
    }

    public Observable<OptionDataTotal> v0() {
        OptionDataProvider optionDataProvider = this.f45430a;
        boolean z11 = true;
        if ((R(10) & 1) != 0) {
            z11 = false;
        }
        return optionDataProvider.a(z11).doOnNext(new m0(this));
    }

    public Observable<SavingsDataTotal> w0() {
        return k.C().n(true, p.b(), "2").subscribeOn(Schedulers.io()).flatMap(new h((R(9) & 1) == 0)).doOnNext(new b(this));
    }

    public Observable<SuperMarginDataTotal> x0() {
        return k.C().n(true, p.b(), "2").subscribeOn(Schedulers.io()).flatMap(new e(this, (R(4) & 1) == 0)).doOnNext(new wk.c(this));
    }

    public Observable<SwapDataTotal> y0() {
        h2 t12 = h2.t1();
        boolean z11 = true;
        if ((R(6) & 1) != 0) {
            z11 = false;
        }
        return t12.J1(z11).doOnNext(new wk.d(this));
    }

    public Observable<Boolean> z0() {
        Observable<LegalDataTotal> observable;
        Observable<ContractDataTotal> observable2;
        Observable<MarginBalanceDataTotal> subscribeOn = k0().C0().subscribeOn(Schedulers.io());
        Observable<SuperMarginDataTotal> subscribeOn2 = k0().x0().subscribeOn(Schedulers.io());
        Observable<BalanceDataTotal> subscribeOn3 = k0().q0().subscribeOn(Schedulers.io());
        if (BaseModuleConfig.a().c()) {
            observable = Observable.just(null);
        } else {
            observable = k0().s0().subscribeOn(Schedulers.io()).timeout((long) com.sumsub.sns.presentation.screen.d.N, TimeUnit.MILLISECONDS);
        }
        if (com.hbg.lib.core.util.o.h()) {
            observable2 = k0().r0().subscribeOn(Schedulers.io()).timeout((long) com.sumsub.sns.presentation.screen.d.N, TimeUnit.MILLISECONDS);
        } else {
            observable2 = Observable.just(null);
        }
        return Observable.zip(subscribeOn, subscribeOn2, subscribeOn3, observable, observable2, f0.f61387b);
    }

    public void z1(int i11, BaseAssetTotal baseAssetTotal) {
        if (baseAssetTotal != null) {
            i6.k.o("AssetCalculate", "[load]balanceType=" + i11 + " data=" + baseAssetTotal.toTotalString());
        } else {
            i6.k.o("AssetCalculate", "[load]balanceType=" + i11 + " data=null");
        }
        this.f45435f.put(i11, baseAssetTotal);
    }
}
