package com.huobi.asset2.index.personer;

import al.l;
import al.p;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.AssetOptionsInfo;
import com.hbg.lib.network.hbg.core.bean.AssetPositionSpotData;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.account.entity.LegalQueryData;
import com.huobi.asset.AssetAccountType;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.AssetCacheInfoData;
import com.huobi.finance.bean.AssetPositionCoinData;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.bean.AssetPositionEarnTimingHeaderData;
import com.huobi.finance.bean.AssetPositionLevelData;
import com.huobi.finance.bean.AssetPositionOtcData;
import com.huobi.finance.bean.AssetPositionQuantData;
import com.huobi.finance.bean.AssetPositionWarrantData;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.BaseAssetPositionAccountData;
import com.huobi.finance.bean.BasePositionSortAccountItem;
import com.huobi.finance.bean.CacheAssetPositionData;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.store.AppConfigManager;
import com.huobi.supermargin.bean.MarginOverview;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import qh.i0;
import qh.p0;
import rh.q;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import sl.f0;
import uh.i;
import vk.k;
import zh.a1;
import zh.b1;
import zh.c1;
import zh.d1;
import zh.e1;
import zh.f1;
import zh.g1;
import zh.h1;
import zh.i1;
import zh.j1;
import zh.k1;
import zh.l0;
import zh.l1;
import zh.m0;
import zh.m1;
import zh.n0;
import zh.n1;
import zh.o0;
import zh.o1;
import zh.p1;
import zh.q0;
import zh.q1;
import zh.r0;
import zh.r1;
import zh.s0;
import zh.s1;
import zh.t0;
import zh.t1;
import zh.u0;
import zh.u1;
import zh.v0;
import zh.v1;
import zh.w0;
import zh.w1;
import zh.x0;
import zh.x1;
import zh.y0;
import zh.z0;

public class AssetIndexFragmentPresenterNew extends BaseFragmentPresenter<h> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f42705c = new Object[0];

    /* renamed from: d  reason: collision with root package name */
    public boolean f42706d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42707e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42708f = false;

    /* renamed from: g  reason: collision with root package name */
    public CacheAssetPositionData f42709g = new CacheAssetPositionData();

    /* renamed from: h  reason: collision with root package name */
    public long f42710h = Period.DAY_MILLS;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<AssetAccountType, Boolean> f42711i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    public boolean f42712j = true;

    /* renamed from: k  reason: collision with root package name */
    public Subscription f42713k;

    /* renamed from: l  reason: collision with root package name */
    public i0 f42714l;

    /* renamed from: m  reason: collision with root package name */
    public int f42715m = 1;

    /* renamed from: n  reason: collision with root package name */
    public boolean f42716n = true;

    /* renamed from: o  reason: collision with root package name */
    public boolean f42717o = true;

    /* renamed from: p  reason: collision with root package name */
    public boolean f42718p;

    /* renamed from: q  reason: collision with root package name */
    public String f42719q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f42720r = false;

    /* renamed from: s  reason: collision with root package name */
    public List<k> f42721s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    public k.a f42722t = new q1(this);

    /* renamed from: u  reason: collision with root package name */
    public AssetAccountType[] f42723u;

    /* renamed from: v  reason: collision with root package name */
    public ArrayList<AssetAccountType> f42724v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    public List<BaseAssetPositionAccountData> f42725w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    public HashMap<AssetAccountType, List<BasePositionSortAccountItem>> f42726x = new HashMap<>();

    /* renamed from: y  reason: collision with root package name */
    public HashMap<AssetAccountType, Boolean> f42727y = new HashMap<>();

    /* renamed from: z  reason: collision with root package name */
    public HashMap<AssetAccountType, Integer> f42728z = new HashMap<>();

    public class a extends BaseSubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            if (AssetIndexFragmentPresenterNew.this.g1()) {
                AssetIndexFragmentPresenterNew.this.j2();
            }
        }
    }

    public class b extends BaseSubscriber<List<BasePositionSortAccountItem>> {
        public b() {
        }

        public void onAfter() {
            super.onAfter();
            HashMap S0 = AssetIndexFragmentPresenterNew.this.f42727y;
            AssetAccountType assetAccountType = AssetAccountType.MARGIN;
            S0.put(assetAccountType, Boolean.FALSE);
            AssetIndexFragmentPresenterNew.this.u2(assetAccountType);
        }

        public void onNext(List<BasePositionSortAccountItem> list) {
            onAfter();
            AssetIndexFragmentPresenterNew.this.l2(AssetAccountType.MARGIN, list);
        }
    }

    public class c extends SilentSubscriber<List<BasePositionSortAccountItem>> {
        public c() {
        }

        public void onAfter() {
            HashMap S0 = AssetIndexFragmentPresenterNew.this.f42727y;
            AssetAccountType assetAccountType = AssetAccountType.OTC;
            S0.put(assetAccountType, Boolean.FALSE);
            AssetIndexFragmentPresenterNew.this.u2(assetAccountType);
        }

        public void onCompleted() {
            AssetIndexFragmentPresenterNew.this.f42727y.put(AssetAccountType.OTC, Boolean.FALSE);
        }

        public void onError2(Throwable th2) {
            AssetIndexFragmentPresenterNew.this.l2(AssetAccountType.OTC, (List<BasePositionSortAccountItem>) null);
            onAfter();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            AssetIndexFragmentPresenterNew.this.l2(AssetAccountType.OTC, (List<BasePositionSortAccountItem>) null);
            onAfter();
        }

        public void onNext(List<BasePositionSortAccountItem> list) {
            AssetIndexFragmentPresenterNew.this.l2(AssetAccountType.OTC, list);
            onAfter();
        }
    }

    public class d extends BaseSubscriber<List<BasePositionSortAccountItem>> {
        public d() {
        }

        public void onAfter() {
            super.onAfter();
            HashMap S0 = AssetIndexFragmentPresenterNew.this.f42727y;
            AssetAccountType assetAccountType = AssetAccountType.HUOBI_EARN;
            S0.put(assetAccountType, Boolean.FALSE);
            AssetIndexFragmentPresenterNew.this.u2(assetAccountType);
        }

        public void onNext(List<BasePositionSortAccountItem> list) {
            AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew = AssetIndexFragmentPresenterNew.this;
            AssetAccountType assetAccountType = AssetAccountType.HUOBI_EARN;
            assetIndexFragmentPresenterNew.l2(assetAccountType, list);
            AssetIndexFragmentPresenterNew.this.p2(assetAccountType);
            onAfter();
        }
    }

    public class e extends BaseSubscriber<List<BasePositionSortAccountItem>> {
        public e() {
        }

        public void onAfter() {
            super.onAfter();
            HashMap S0 = AssetIndexFragmentPresenterNew.this.f42727y;
            AssetAccountType assetAccountType = AssetAccountType.SPOT;
            S0.put(assetAccountType, Boolean.FALSE);
            AssetIndexFragmentPresenterNew.this.u2(assetAccountType);
        }

        public void onNext(List<BasePositionSortAccountItem> list) {
            AssetIndexFragmentPresenterNew.this.l2(AssetAccountType.SPOT, list);
            onAfter();
        }
    }

    public class f extends SilentSubscriber<List<AssetOptionsInfo>> {
        public f() {
        }

        public void onCompleted() {
            super.onCompleted();
            AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew = AssetIndexFragmentPresenterNew.this;
            AssetAccountType assetAccountType = AssetAccountType.WARRANT;
            assetIndexFragmentPresenterNew.u2(assetAccountType);
            AssetIndexFragmentPresenterNew.this.f42727y.put(assetAccountType, Boolean.FALSE);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew = AssetIndexFragmentPresenterNew.this;
            AssetAccountType assetAccountType = AssetAccountType.WARRANT;
            assetIndexFragmentPresenterNew.u2(assetAccountType);
            AssetIndexFragmentPresenterNew.this.l2(assetAccountType, (List<BasePositionSortAccountItem>) null);
        }

        public void onNext(List<AssetOptionsInfo> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (AssetOptionsInfo next : list) {
                    if (BigDecimal.ZERO.compareTo(m.a(next.getPosition())) != 0) {
                        AssetPositionWarrantData assetPositionWarrantData = new AssetPositionWarrantData();
                        assetPositionWarrantData.j(next);
                        arrayList.add(assetPositionWarrantData);
                        arrayList2.add(assetPositionWarrantData);
                    }
                }
            }
            AssetIndexFragmentPresenterNew.this.f42709g.setWarrantDataList(arrayList2);
            AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew = AssetIndexFragmentPresenterNew.this;
            AssetAccountType assetAccountType = AssetAccountType.WARRANT;
            assetIndexFragmentPresenterNew.l2(assetAccountType, arrayList);
            AssetIndexFragmentPresenterNew.this.u2(assetAccountType);
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42735a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.asset.AssetAccountType[] r0 = com.huobi.asset.AssetAccountType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42735a = r0
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.SPOT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42735a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.OTC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42735a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.MARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42735a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.FUTURE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f42735a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.HUOBI_EARN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f42735a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.QUANT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f42735a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.WARRANT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew.g.<clinit>():void");
        }
    }

    public interface h extends h6.a, u6.g {
        void A3(BalanceProfitLossData balanceProfitLossData);

        void H1(List<k> list, String str, boolean z11);

        void K1(AssetAccountType assetAccountType);

        void M1(int i11, int i12);

        void M2();

        void S2(List<BaseAssetPositionAccountData> list);

        void Z2(int i11);

        void a3(int i11, int i12);

        void finishRefresh();

        void r3();

        void x1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AssetPositionQuantData A1(GridStrategy gridStrategy) {
        return AssetPositionQuantData.g(gridStrategy, getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable B1(List list) {
        this.f42709g.setQuantDataList(list);
        return Observable.from(list);
    }

    public static /* synthetic */ BasePositionSortAccountItem C1(AssetPositionQuantData assetPositionQuantData) {
        return assetPositionQuantData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D1(List list) {
        AssetAccountType assetAccountType = AssetAccountType.QUANT;
        l2(assetAccountType, list);
        this.f42727y.put(assetAccountType, Boolean.FALSE);
        u2(assetAccountType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E1(APIStatusErrorException aPIStatusErrorException) {
        HashMap<AssetAccountType, Boolean> hashMap = this.f42727y;
        AssetAccountType assetAccountType = AssetAccountType.QUANT;
        hashMap.put(assetAccountType, Boolean.FALSE);
        u2(assetAccountType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F1(Throwable th2) {
        HashMap<AssetAccountType, Boolean> hashMap = this.f42727y;
        AssetAccountType assetAccountType = AssetAccountType.QUANT;
        hashMap.put(assetAccountType, Boolean.FALSE);
        u2(assetAccountType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List G1(AssetPositionSpotData assetPositionSpotData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (assetPositionSpotData != null) {
            com.huobi.asset2.index.util.b.a().f(assetPositionSpotData.getRiskLevel(), assetPositionSpotData.getAccountState());
            List<AssetPositionSpotData.SpotInfoListDTO> spotInfoList = assetPositionSpotData.getSpotInfoList();
            if (!CollectionsUtils.b(spotInfoList)) {
                for (AssetPositionSpotData.SpotInfoListDTO next : spotInfoList) {
                    AssetPositionCoinData assetPositionCoinData = new AssetPositionCoinData();
                    assetPositionCoinData.L(next.getCurrencyCode());
                    assetPositionCoinData.F(next.getCurrencyCode());
                    assetPositionCoinData.C(p.j(next.getSingleCurrencySpotAvailableNum(), next.getCurrencyCode()));
                    String j11 = p.j(next.getBalance(), next.getCurrencyCode());
                    assetPositionCoinData.E(j11);
                    assetPositionCoinData.I(p.j(next.getSuspense(), next.getCurrencyCode()));
                    String j12 = p.j(next.getLockNum(), next.getCurrencyCode());
                    String j13 = p.j(next.getSingleCurrencySpotNum(), next.getCurrencyCode());
                    assetPositionCoinData.G(j13);
                    assetPositionCoinData.H(j12);
                    assetPositionCoinData.J(next.getProfit());
                    assetPositionCoinData.K(next.getProfitRate());
                    assetPositionCoinData.D(next.getAvgCost());
                    assetPositionCoinData.M(next.getTodayProfit());
                    assetPositionCoinData.N(next.getTodayProfitRate());
                    if (m.a(j13).compareTo(BigDecimal.ZERO) != 0 || m.a(j11).compareTo(BigDecimal.ZERO) < 0) {
                        arrayList2.add(assetPositionCoinData);
                        arrayList.add(assetPositionCoinData);
                    }
                }
            }
        }
        this.f42709g.setCoinDataList(arrayList2);
        return arrayList;
    }

    public static /* synthetic */ BalanceProfitLossData H1(Map map, Boolean bool, Boolean bool2, Boolean bool3, BalanceProfitLossData balanceProfitLossData) {
        return balanceProfitLossData;
    }

    public static /* synthetic */ BalanceProfitLossData I1(hh.f fVar, BalanceProfitLossData balanceProfitLossData) {
        Iterator<BalanceProfitLossData.AccountBalance> it2 = balanceProfitLossData.getProfitAccountBalanceList().iterator();
        while (it2.hasNext()) {
            if (fVar.g(al.a.d(it2.next().getDistributionType())) == null) {
                it2.remove();
            }
        }
        return balanceProfitLossData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(BalanceProfitLossData balanceProfitLossData) {
        ((h) getUI()).A3(balanceProfitLossData);
        p0.n().C(balanceProfitLossData.getTotalBalance());
        if (p0.n().p()) {
            ((h) getUI()).Z2(4);
        } else if (this.f42716n) {
            this.f42716n = false;
            c1();
            y2();
        } else {
            ((h) getUI()).x1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K1(APIStatusErrorException aPIStatusErrorException) {
        ((h) getUI()).finishRefresh();
        if (this.f42716n) {
            ((h) getUI()).Z2(2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(Throwable th2) {
        ((h) getUI()).finishRefresh();
        if (this.f42716n) {
            ((h) getUI()).Z2(2);
        }
    }

    public static /* synthetic */ Object Q1(Integer num, Integer num2, Integer num3, Map map) {
        return null;
    }

    public static /* synthetic */ Integer R1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer S1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer T1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Map U1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Boolean i1(Boolean bool) {
        i.d().n(!bool.booleanValue() && i.d().h());
        return bool;
    }

    public static /* synthetic */ List k1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List l1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ HashMap m1(List list, List list2) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                MiningItem miningItem = (MiningItem) it2.next();
                if (!m.b0(miningItem.getMiningAmount())) {
                    arrayList.add(miningItem);
                }
            }
            hashMap.put(0, arrayList);
        }
        if (list2 != null) {
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                MiningItem miningItem2 = (MiningItem) it3.next();
                if (!m.b0(miningItem2.getMiningAmount())) {
                    arrayList2.add(miningItem2);
                }
            }
            hashMap.put(1, arrayList2);
        }
        com.huobi.asset2.index.util.a.a().c(arrayList, arrayList2);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List n1(HashMap hashMap) {
        List<MiningItem> list = (List) hashMap.get(0);
        List<MiningItem> list2 = (List) hashMap.get(1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!CollectionsUtils.b(list)) {
            for (MiningItem miningItem : list) {
                if (!m.b0(miningItem.getMiningAmount())) {
                    arrayList.add(new vk.e(miningItem));
                    arrayList2.add(new vk.e(miningItem));
                }
            }
        }
        if (!CollectionsUtils.b(list2)) {
            if (!CollectionsUtils.b(list)) {
                arrayList.add(new AssetPositionEarnTimingHeaderData());
            }
            for (MiningItem miningItem2 : list2) {
                if (!m.b0(miningItem2.getMiningAmount())) {
                    arrayList.add(new vk.e(miningItem2));
                    arrayList2.add(new vk.e(miningItem2));
                }
            }
        }
        this.f42709g.setEarnDataList(arrayList2);
        return arrayList;
    }

    public static /* synthetic */ List o1(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AssetPositionContractData p1(SwapPosition swapPosition) {
        String str;
        SwapCurrencyInfo q11 = SwapCurrencyInfoController.k().q(swapPosition.getContractCode());
        AssetPositionContractData assetPositionContractData = new AssetPositionContractData();
        TradeType tradeType = TradeType.SWAP;
        assetPositionContractData.d0(tradeType);
        assetPositionContractData.a0(swapPosition.getSymbol());
        assetPositionContractData.b0(swapPosition.getSymbol() + "/USD");
        assetPositionContractData.L(swapPosition.getContractCode());
        assetPositionContractData.P(swapPosition.getDirection());
        assetPositionContractData.N(false);
        assetPositionContractData.T(swapPosition.getLeverRate() + "X·" + getResources().getString(R$string.n_market_contract_swap_trade_name));
        assetPositionContractData.R(swapPosition.getLeverRate());
        assetPositionContractData.Y("--");
        if (!TextUtils.isEmpty(swapPosition.getRiskRate())) {
            assetPositionContractData.Y(m.Q(swapPosition.getRiskRate(), us.i.v(swapPosition.getSymbol()), 1));
        }
        if (!TextUtils.isEmpty(swapPosition.getPositionMargin())) {
            assetPositionContractData.U(m.q(m.a(LegalCurrencyConfigUtil.E(swapPosition.getSymbol(), swapPosition.getPositionMargin())), us.i.c(swapPosition.getSymbol())));
        } else {
            assetPositionContractData.U("--");
        }
        if (!a7.e.E(tradeType)) {
            assetPositionContractData.H(m.m(swapPosition.getVolume(), us.i.l(swapPosition.getSymbol())));
            assetPositionContractData.J(m.m(swapPosition.getAvailable(), us.i.l(swapPosition.getSymbol())));
        } else if (m.a(swapPosition.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
            assetPositionContractData.H(m.m("0", us.i.k(swapPosition.getSymbol())));
        } else {
            String contractFace = q11 != null ? q11.getContractFace() : "";
            assetPositionContractData.H(m.q(m.a(swapPosition.getVolume()).multiply(m.a(contractFace)).divide(m.a(swapPosition.getLastPrice()), 32, 1), us.i.k(swapPosition.getSymbol())));
            assetPositionContractData.J(m.q(m.a(swapPosition.getAvailable()).multiply(m.a(contractFace)).divide(m.a(swapPosition.getLastPrice()), 32, 1), us.i.k(swapPosition.getSymbol())));
        }
        boolean E = a7.e.E(tradeType);
        if (E) {
            str = swapPosition.getSymbol();
        } else {
            str = getActivity().getString(R$string.contract_market_vol_sheet);
        }
        assetPositionContractData.I(str);
        assetPositionContractData.K(E);
        if (q11 != null) {
            assetPositionContractData.M(m.a(q11.getContractFace()).divide(m.a(swapPosition.getLastPrice()), 12, 1).toPlainString());
        }
        assetPositionContractData.Z(m.m(swapPosition.getCostOpen(), us.i.m(swapPosition.getSymbol())));
        assetPositionContractData.Q(m.m(swapPosition.getLastPrice(), us.i.m(swapPosition.getSymbol())));
        assetPositionContractData.V(LegalCurrencyConfigUtil.E(swapPosition.getSymbol(), swapPosition.getProfit()));
        String Q = m.Q(swapPosition.getProfitRate(), us.i.s(swapPosition.getSymbol()), 1);
        if (!Q.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            Q = "+" + Q;
        }
        assetPositionContractData.X(Q);
        assetPositionContractData.O(swapPosition.getProfitRate());
        assetPositionContractData.W(w.a(swapPosition.getProfit()));
        return assetPositionContractData;
    }

    public static /* synthetic */ List q1(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AssetPositionContractData r1(LinearSwapPosition linearSwapPosition) {
        String str;
        FutureContractInfo o11 = FutureContractInfoController.n().o(linearSwapPosition.getContractCode());
        AssetPositionContractData assetPositionContractData = new AssetPositionContractData();
        TradeType tradeType = TradeType.LINEAR_SWAP;
        assetPositionContractData.d0(tradeType);
        assetPositionContractData.a0(linearSwapPosition.getSymbol());
        String tradePartition = o11.getTradePartition();
        assetPositionContractData.c0(o11.getTradePartition());
        if (!TextUtils.isEmpty(tradePartition)) {
            assetPositionContractData.b0(linearSwapPosition.getSymbol() + "/" + tradePartition);
        } else {
            assetPositionContractData.b0(linearSwapPosition.getSymbol() + "/USDT");
        }
        if (o11.isLinearSwapFuture()) {
            assetPositionContractData.S(o11.getPair());
        }
        assetPositionContractData.L(linearSwapPosition.getContractCode());
        assetPositionContractData.P(linearSwapPosition.getDirection());
        assetPositionContractData.N((FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(linearSwapPosition.getMarginMode()) ? (char) 1 : 2) == 1);
        String e11 = a7.e.e(getActivity(), o11.getContractType());
        if (!"swap".equals(o11.getContractType())) {
            e11 = e11 + a7.e.s(getActivity(), o11.getContractCode(), o11.getContractType());
        }
        assetPositionContractData.T(linearSwapPosition.getLeverRate() + "X·" + e11);
        assetPositionContractData.R(linearSwapPosition.getLeverRate());
        assetPositionContractData.Y("--");
        if (!TextUtils.isEmpty(linearSwapPosition.getRiskRate())) {
            assetPositionContractData.Y(m.Q(linearSwapPosition.getRiskRate(), FuturePrecisionUtil.r(linearSwapPosition.getSymbol()), 1));
        }
        if (!TextUtils.isEmpty(linearSwapPosition.getPositionMargin())) {
            assetPositionContractData.U(m.q(m.a(LegalCurrencyConfigUtil.E(linearSwapPosition.getMarginAsset(), linearSwapPosition.getPositionMargin())), us.i.c(linearSwapPosition.getSymbol())));
        } else {
            assetPositionContractData.U("--");
        }
        String contractFace = o11.getContractFace();
        int s11 = FuturePrecisionUtil.s(linearSwapPosition.getContractCode(), o11.getContractShortType(), (String) null);
        if (!a7.e.E(tradeType)) {
            assetPositionContractData.H(m.m(linearSwapPosition.getVolume(), FuturePrecisionUtil.B()));
            assetPositionContractData.J(m.m(linearSwapPosition.getAvailable(), FuturePrecisionUtil.B()));
        } else if (m.a(linearSwapPosition.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
            assetPositionContractData.H(m.m("0", s11));
        } else {
            assetPositionContractData.H(m.m(FutureUnitUtil.a(linearSwapPosition.getVolume(), linearSwapPosition.getLastPrice(), contractFace, tradeType), s11));
            assetPositionContractData.J(m.m(FutureUnitUtil.a(linearSwapPosition.getAvailable(), linearSwapPosition.getLastPrice(), contractFace, tradeType), s11));
        }
        boolean E = a7.e.E(tradeType);
        if (E) {
            str = linearSwapPosition.getSymbol();
        } else {
            str = getActivity().getString(R$string.contract_market_vol_sheet);
        }
        assetPositionContractData.I(str);
        assetPositionContractData.K(E);
        assetPositionContractData.M(contractFace);
        int y11 = FuturePrecisionUtil.y(linearSwapPosition.getContractCode(), o11.getContractShortType(), (String) null);
        assetPositionContractData.Z(m.m(linearSwapPosition.getCostOpen(), y11));
        assetPositionContractData.Q(m.m(linearSwapPosition.getLastPrice(), y11));
        assetPositionContractData.V(LegalCurrencyConfigUtil.E(o11.getQuoteCurrency(), linearSwapPosition.getProfit()));
        String Q = m.Q(linearSwapPosition.getProfitRate(), FuturePrecisionUtil.q(linearSwapPosition.getSymbol()), 1);
        if (!Q.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            Q = "+" + Q;
        }
        assetPositionContractData.X(Q);
        assetPositionContractData.O(linearSwapPosition.getProfitRate());
        assetPositionContractData.W(w.a(linearSwapPosition.getProfit()));
        return assetPositionContractData;
    }

    public static /* synthetic */ List s1(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List t1(ContractHeartBeat contractHeartBeat, List list, List list2, List list3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!contractHeartBeat.isSysSafeguard() && list != null) {
            arrayList.addAll(list);
            arrayList2.addAll(list);
        }
        if (!contractHeartBeat.isSwapSafeguard() && list2 != null) {
            arrayList.addAll(list2);
            arrayList2.addAll(list2);
        }
        if (!contractHeartBeat.isLinearSwapSafeguard() && list3 != null) {
            arrayList.addAll(list3);
            arrayList2.addAll(list3);
        }
        this.f42709g.setContractDataList(arrayList2);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u1(List list) {
        AssetAccountType assetAccountType = AssetAccountType.FUTURE;
        l2(assetAccountType, list);
        this.f42727y.put(assetAccountType, Boolean.FALSE);
        u2(assetAccountType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1(APIStatusErrorException aPIStatusErrorException) {
        HashMap<AssetAccountType, Boolean> hashMap = this.f42727y;
        AssetAccountType assetAccountType = AssetAccountType.FUTURE;
        hashMap.put(assetAccountType, Boolean.FALSE);
        u2(assetAccountType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(Throwable th2) {
        HashMap<AssetAccountType, Boolean> hashMap = this.f42727y;
        AssetAccountType assetAccountType = AssetAccountType.FUTURE;
        hashMap.put(assetAccountType, Boolean.FALSE);
        u2(assetAccountType);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List x1(MarginBalanceDataTotal marginBalanceDataTotal, SuperMarginDataTotal superMarginDataTotal) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (superMarginDataTotal != null && !CollectionsUtils.b(superMarginDataTotal.getDetailInfos())) {
            for (BaseAssetInfo baseAssetInfo : superMarginDataTotal.getDetailInfos()) {
                if (baseAssetInfo instanceof SuperMarginDetailInfo) {
                    String j11 = p.j(m.a(baseAssetInfo.getOnOrders()).add(m.a(baseAssetInfo.getAvaialAble())).toPlainString(), baseAssetInfo.getCurrency());
                    if (!m.b0(j11)) {
                        AssetPositionLevelData assetPositionLevelData = new AssetPositionLevelData();
                        assetPositionLevelData.N(baseAssetInfo.getDisplayName());
                        assetPositionLevelData.C(baseAssetInfo.getCurrency());
                        assetPositionLevelData.u(baseAssetInfo.getAvaialAble());
                        assetPositionLevelData.B(((SuperMarginDetailInfo) baseAssetInfo).getLoan());
                        assetPositionLevelData.F(j11);
                        assetPositionLevelData.E(superMarginDataTotal.getMarginOverview());
                        assetPositionLevelData.O(true);
                        arrayList.add(assetPositionLevelData);
                        arrayList2.add(assetPositionLevelData);
                    }
                }
            }
        }
        if (marginBalanceDataTotal != null && !CollectionsUtils.b(marginBalanceDataTotal.getDetailInfos())) {
            for (BaseAssetInfo baseAssetInfo2 : marginBalanceDataTotal.getDetailInfos()) {
                if (baseAssetInfo2 instanceof MarginBalanceDetailInfo) {
                    MarginBalanceDetailInfo marginBalanceDetailInfo = (MarginBalanceDetailInfo) baseAssetInfo2;
                    String j12 = p.j(m.a(marginBalanceDetailInfo.getBaseCurrencyOnorders()).add(m.a(marginBalanceDetailInfo.getBaseCurrencyAvaiable())).toPlainString(), marginBalanceDetailInfo.getBaseCurrency());
                    String j13 = p.j(m.a(marginBalanceDetailInfo.getQuoteCurrencyOnorders()).add(m.a(marginBalanceDetailInfo.getQuoteCurrencyAvaiable())).toPlainString(), marginBalanceDetailInfo.getQuoteCurrency());
                    if (!m.b0(j12) || !m.b0(j13)) {
                        AssetPositionLevelData assetPositionLevelData2 = new AssetPositionLevelData();
                        String state = marginBalanceDetailInfo.getState();
                        String riskRate = marginBalanceDetailInfo.getRiskRate();
                        MarginOverview marginOverview = new MarginOverview();
                        marginOverview.setRiskState(com.huobi.trade.helper.a.a(riskRate, state));
                        assetPositionLevelData2.E(marginOverview);
                        assetPositionLevelData2.D(marginBalanceDetailInfo.getDisplayName());
                        assetPositionLevelData2.w(marginBalanceDetailInfo.getBaseCurrencyAvaiable());
                        assetPositionLevelData2.x(marginBalanceDetailInfo.getBaseCurrencyDisplayName());
                        assetPositionLevelData2.y(marginBalanceDetailInfo.getBaseCurrencyLoaned());
                        assetPositionLevelData2.z(marginBalanceDetailInfo.getBaseCurrencyOnorders());
                        assetPositionLevelData2.v(marginBalanceDetailInfo.getBaseCurrency());
                        assetPositionLevelData2.A(j12);
                        assetPositionLevelData2.H(marginBalanceDetailInfo.getQuoteCurrencyAvaiable());
                        assetPositionLevelData2.I(marginBalanceDetailInfo.getQuoteCurrencyDisplayName());
                        assetPositionLevelData2.J(marginBalanceDetailInfo.getQuoteCurrencyLoaned());
                        assetPositionLevelData2.K(marginBalanceDetailInfo.getQuoteCurrencyOnorders());
                        assetPositionLevelData2.G(marginBalanceDetailInfo.getQuoteCurrency());
                        assetPositionLevelData2.L(j13);
                        assetPositionLevelData2.C(marginBalanceDetailInfo.getSymbol());
                        assetPositionLevelData2.O(false);
                        assetPositionLevelData2.M(marginBalanceDetailInfo.getRiskRate());
                        arrayList.add(assetPositionLevelData2);
                        arrayList2.add(assetPositionLevelData2);
                    }
                }
            }
        }
        this.f42709g.setLevelDataList(arrayList2);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List y1(List list) {
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!CollectionsUtils.b(list)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                LegalQueryData legalQueryData = (LegalQueryData) it2.next();
                if (legalQueryData != null && !m.b0(legalQueryData.getAvaialAble())) {
                    MarketCoin.Coin h11 = OtcMarketPriceConfigUtil.h(legalQueryData.getCoinId());
                    AssetPositionOtcData assetPositionOtcData = new AssetPositionOtcData();
                    String str2 = "--";
                    if (h11 != null) {
                        if (h11.getCoinCode() != null) {
                            str2 = h11.getCoinCode().toLowerCase(Locale.US);
                        }
                        str = d7.k.C().z(h11.getCoinCode());
                    } else {
                        str = str2;
                    }
                    assetPositionOtcData.n(legalQueryData.getCoinId());
                    assetPositionOtcData.o(str2);
                    assetPositionOtcData.p(str);
                    assetPositionOtcData.m(legalQueryData.getAvaialAble());
                    assetPositionOtcData.q(legalQueryData.getFrozen());
                    arrayList.add(assetPositionOtcData);
                    arrayList2.add(assetPositionOtcData);
                }
            }
        }
        this.f42709g.setOtcDataList(arrayList2);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z1(Boolean bool) {
        ((h) getUI()).M2();
    }

    public void A2() {
        Subscription subscription = this.f42713k;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f42713k.unsubscribe();
            this.f42727y.clear();
        }
    }

    public void B2(AssetAccountType assetAccountType) {
        int e11 = l.f().e(assetAccountType);
        if (e11 >= 0 && this.f42725w.size() > e11) {
            s9.a aVar = this.f42725w.get(e11);
            if (aVar instanceof vk.i) {
                vk.i iVar = (vk.i) aVar;
                iVar.j();
                l2(assetAccountType, iVar.i());
            }
        }
    }

    public final void C2() {
        if (!CollectionsUtils.b(this.f42725w)) {
            for (int i11 = 0; i11 < this.f42725w.size(); i11++) {
                s9.a aVar = this.f42725w.get(i11);
                if (aVar instanceof vk.i) {
                    l.f().l(((vk.i) aVar).a(), i11);
                }
            }
        }
    }

    public final void D2() {
        l.f().a();
        for (int i11 = 0; i11 < this.f42725w.size(); i11++) {
            l.f().l(this.f42725w.get(i11).a(), i11);
        }
    }

    /* renamed from: E2 */
    public final void M1(int i11) {
        boolean z11 = true;
        String str = "";
        if (this.f42715m != i11) {
            this.f42715m = i11;
            for (k next : this.f42721s) {
                if (next.c() == i11) {
                    str = next.a();
                }
                next.f(next.c() == i11);
            }
            w2();
            gi.a.v(this.f42715m);
        }
        h hVar = (h) getUI();
        List<k> list = this.f42721s;
        if (i11 != 0) {
            z11 = false;
        }
        hVar.H1(list, str, z11);
    }

    public void F2(boolean z11) {
        this.f42720r = z11;
        gi.a.w(z11);
        w2();
    }

    public void G2() {
        v2();
        if (!BaseModuleConfig.a().getUid().equalsIgnoreCase(this.f42719q)) {
            h2();
        }
    }

    public final void V1() {
        if (this.f42706d && this.f42707e) {
            int i11 = 0;
            this.f42706d = false;
            String W0 = W0();
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(W0)) {
                CacheAssetPositionData cacheAssetPositionData = (CacheAssetPositionData) new Gson().fromJson(W0, CacheAssetPositionData.class);
                while (true) {
                    AssetAccountType[] assetAccountTypeArr = this.f42723u;
                    if (i11 < assetAccountTypeArr.length) {
                        AssetAccountType assetAccountType = assetAccountTypeArr[i11];
                        if (System.currentTimeMillis() - cacheAssetPositionData.getCacheTime() < this.f42710h) {
                            ArrayList arrayList = new ArrayList();
                            switch (g.f42735a[assetAccountType.ordinal()]) {
                                case 1:
                                    if (!CollectionsUtils.b(cacheAssetPositionData.getCoinDataList())) {
                                        arrayList.addAll(cacheAssetPositionData.getCoinDataList());
                                        break;
                                    }
                                    break;
                                case 2:
                                    if (!CollectionsUtils.b(cacheAssetPositionData.getOtcDataList())) {
                                        arrayList.addAll(cacheAssetPositionData.getOtcDataList());
                                        break;
                                    }
                                    break;
                                case 3:
                                    if (!CollectionsUtils.b(cacheAssetPositionData.getLevelDataList())) {
                                        arrayList.addAll(cacheAssetPositionData.getLevelDataList());
                                        break;
                                    }
                                    break;
                                case 4:
                                    if (!CollectionsUtils.b(cacheAssetPositionData.getContractDataList())) {
                                        arrayList.addAll(cacheAssetPositionData.getContractDataList());
                                        break;
                                    }
                                    break;
                                case 5:
                                    if (!CollectionsUtils.b(cacheAssetPositionData.getEarnDataList())) {
                                        arrayList.addAll(cacheAssetPositionData.getEarnDataList());
                                        break;
                                    }
                                    break;
                                case 6:
                                    if (!CollectionsUtils.b(cacheAssetPositionData.getQuantDataList())) {
                                        arrayList.addAll(cacheAssetPositionData.getQuantDataList());
                                        break;
                                    }
                                    break;
                                case 7:
                                    if (!CollectionsUtils.b(cacheAssetPositionData.getWarrantDataList())) {
                                        arrayList.addAll(cacheAssetPositionData.getWarrantDataList());
                                        break;
                                    }
                                    break;
                            }
                            if (!CollectionsUtils.b(arrayList)) {
                                hashMap.put(assetAccountType, arrayList);
                            }
                        }
                        i11++;
                    }
                }
            }
            if (!CollectionsUtils.c(hashMap)) {
                this.f42708f = true;
                Z0(hashMap);
            }
        }
    }

    public final String W0() {
        return SP.i("cache_account_position" + AssetModuleConfig.a().getUid(), "");
    }

    public void W1() {
        V1();
        if (!this.f42716n) {
            this.f42726x.remove(AssetAccountType.OTC);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f42724v);
            for (AssetAccountType assetAccountType : this.f42723u) {
                if (!arrayList.contains(assetAccountType)) {
                    i6.d.j("looper", "come from loadData() Real requested data:" + assetAccountType.toString());
                    i2(assetAccountType);
                }
            }
        }
    }

    public final int X0(AssetAccountType assetAccountType) {
        int intValue = this.f42728z.get(assetAccountType).intValue();
        for (int i11 = 0; i11 < this.f42725w.size(); i11++) {
            if (intValue < this.f42728z.get(this.f42725w.get(i11).a()).intValue()) {
                return i11;
            }
        }
        return -1;
    }

    public void X1() {
        Observable.zip(v7.b.a().getMiningItemList(0).b().onErrorReturn(k1.f63028b), v7.b.a().getMiningItemList(1).b().onErrorReturn(e1.f63007b), m1.f63034b).map(new t0(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public final Observable<Boolean> Y0() {
        return v7.b.a().getYbbSwitch().b().compose(RxJavaHelper.t((u6.g) null)).map(z0.f63072b).onErrorReturn(i1.f63022b);
    }

    public final void Y1() {
        Observable.zip(AssetModuleConfig.a().Q0(), AssetModuleConfig.a().k0(getActivity()).onErrorReturn(d1.f63003b), l9.a.a().O((String) null).b().flatMap(ad.i.f3526b).map(new s0(this)).toList().onErrorReturn(a1.f62991b), h8.a.a().n0((String) null, TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL).b().flatMap(ad.i.f3526b).map(new r0(this)).toList().onErrorReturn(g1.f63015b), new n1(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new w1(this), new r1(this), new t1(this)));
    }

    public final void Z0(HashMap<AssetAccountType, List<BasePositionSortAccountItem>> hashMap) {
        this.f42725w.clear();
        int i11 = 0;
        while (true) {
            AssetAccountType[] assetAccountTypeArr = this.f42723u;
            if (i11 < assetAccountTypeArr.length) {
                AssetAccountType assetAccountType = assetAccountTypeArr[i11];
                List list = hashMap.get(assetAccountType);
                if (!CollectionsUtils.b(list)) {
                    this.f42725w.add(new vk.d(assetAccountType));
                    this.f42725w.add(new vk.i(assetAccountType, list));
                }
                i11++;
            } else {
                D2();
                x2(false);
                ((h) getUI()).S2(this.f42725w);
                return;
            }
        }
    }

    public void Z1() {
        Observable.zip(AssetDataCacheManager.k0().C0().subscribeOn(Schedulers.io()), AssetDataCacheManager.k0().x0().subscribeOn(Schedulers.io()), new l1(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new b());
    }

    public final void a1() {
        AssetCacheInfoData assetCacheInfoData = (AssetCacheInfoData) AppConfigManager.c(MgtConfigNumber.ASSET_CACHE_OPEN.number, AssetCacheInfoData.class);
        if (assetCacheInfoData == null) {
            assetCacheInfoData = new AssetCacheInfoData();
            assetCacheInfoData.setCacheTimeHour(24);
            assetCacheInfoData.setAndroidOpenCache(true);
        }
        this.f42710h = assetCacheInfoData.getTimeMillis();
        this.f42707e = assetCacheInfoData.isAndroidOpenCache();
    }

    public void a2() {
        v7.b.a().getOptionsAsset().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f());
    }

    public final void b1() {
        int i11 = 0;
        if (BaseModuleConfig.a().c()) {
            this.f42723u = new AssetAccountType[]{AssetAccountType.SPOT, AssetAccountType.FUTURE, AssetAccountType.MARGIN, AssetAccountType.QUANT};
        } else {
            this.f42723u = new AssetAccountType[]{AssetAccountType.SPOT, AssetAccountType.FUTURE, AssetAccountType.MARGIN, AssetAccountType.OTC, AssetAccountType.HUOBI_EARN, AssetAccountType.QUANT, AssetAccountType.WARRANT};
        }
        while (true) {
            AssetAccountType[] assetAccountTypeArr = this.f42723u;
            if (i11 < assetAccountTypeArr.length) {
                this.f42728z.put(assetAccountTypeArr[i11], Integer.valueOf(i11));
                this.f42711i.put(this.f42723u[i11], Boolean.FALSE);
                i11++;
            } else {
                return;
            }
        }
    }

    public void b2() {
        s8.a.a().getWallet2().b().map(new u0(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
    }

    public final void c1() {
        d1(false);
    }

    public void c2() {
        d2();
        g2();
    }

    public final void d1(boolean z11) {
        this.f42724v.clear();
        int i11 = 0;
        while (true) {
            AssetAccountType[] assetAccountTypeArr = this.f42723u;
            if (i11 >= assetAccountTypeArr.length) {
                break;
            }
            this.f42724v.add(assetAccountTypeArr[i11]);
            i11++;
        }
        if (!this.f42708f || z11) {
            this.f42725w.clear();
            this.f42725w.add(new vk.f(AssetAccountType.DEFAULT));
            ((h) getUI()).S2(this.f42725w);
        }
    }

    public final void d2() {
        this.f42714l.f().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new s1(this)));
    }

    public final void e1() {
        List<k> list = this.f42721s;
        int i11 = R$string.n_asset_count_equivalent_sort;
        list.add(new k(true, getString(i11), 1, this.f42722t));
        this.f42721s.add(new k(false, getString(R$string.n_asset_profit_sort), 2, this.f42722t));
        this.f42721s.add(new k(false, getString(R$string.n_asset_Yield_sort), 3, this.f42722t));
        ((h) getUI()).H1(this.f42721s, getString(i11), true);
    }

    public final void e2() {
        v7.b.a().U((String) null, 1, -1, (String) null, -1, "1", 100, (Long) null, (Long) null).b().flatMap(ad.i.f3526b).map(new q0(this)).toList().flatMap(new v0(this)).map(y0.f63069b).toList().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new x1(this), new h1(this), new u1(this)));
    }

    public final void f1(AssetAccountType assetAccountType, List<BasePositionSortAccountItem> list) {
        int X0 = X0(assetAccountType);
        if (X0 == -1) {
            this.f42725w.add(new vk.d(assetAccountType));
            this.f42725w.add(new vk.i(assetAccountType, list));
        } else {
            this.f42725w.add(X0, new vk.i(assetAccountType, list));
            this.f42725w.add(X0, new vk.d(assetAccountType));
        }
        D2();
        ((h) getUI()).M1(X0, 2);
        if (X0 == 0) {
            ((h) getUI()).r3();
        }
    }

    public final void f2() {
        v7.b.a().getSpotApiMerge().b().map(new zh.p0(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
    }

    public boolean g1() {
        return this.f42717o && l.f().i();
    }

    public void g2() {
        hh.f h11 = hh.f.h();
        Observable.zip(wk.p0.g("usdt", true), Y0(), h11.k(), q.r(), this.f42714l.e(), p1.f63043b).map(new x0(h11)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new l0(this), new w0(this), new v1(this)));
    }

    public final boolean h1() {
        if (!CollectionsUtils.b(this.f42725w)) {
            return this.f42725w.get(0) instanceof vk.f;
        }
        return false;
    }

    public void h2() {
        this.f42718p = BaseModuleConfig.a().c();
        this.f42719q = BaseModuleConfig.a().getUid();
        this.f42716n = true;
        this.f42726x.clear();
        this.f42727y.clear();
        b1();
        d1(true);
    }

    public void i2(AssetAccountType assetAccountType) {
        Boolean bool = this.f42727y.get(assetAccountType);
        if (bool == null || !bool.booleanValue()) {
            i6.d.j("looper", "Real requested data :" + assetAccountType.toString());
            this.f42727y.put(assetAccountType, Boolean.TRUE);
            switch (g.f42735a[assetAccountType.ordinal()]) {
                case 1:
                    f2();
                    return;
                case 2:
                    b2();
                    return;
                case 3:
                    Z1();
                    return;
                case 4:
                    Y1();
                    return;
                case 5:
                    X1();
                    return;
                case 6:
                    e2();
                    return;
                case 7:
                    a2();
                    return;
                default:
                    return;
            }
        }
    }

    public final void j2() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f42724v);
        i6.d.j("looper", "Prepare data for polling :" + arrayList.toString());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2((AssetAccountType) it2.next());
        }
    }

    public void k2(boolean z11) {
        this.f42717o = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l2(com.huobi.asset.AssetAccountType r5, java.util.List<com.huobi.finance.bean.BasePositionSortAccountItem> r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f42705c
            monitor-enter(r0)
            al.l r1 = al.l.f()     // Catch:{ all -> 0x007d }
            int r1 = r1.e(r5)     // Catch:{ all -> 0x007d }
            vk.i r2 = new vk.i     // Catch:{ all -> 0x007d }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x007d }
            boolean r3 = com.hbg.lib.core.util.CollectionsUtils.b(r6)     // Catch:{ all -> 0x007d }
            if (r3 != 0) goto L_0x005c
            java.util.List r2 = r2.h()     // Catch:{ all -> 0x007d }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x0021
            goto L_0x005c
        L_0x0021:
            boolean r2 = r4.h1()     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x002c
            r1 = 0
            r4.r2(r1, r5, r6)     // Catch:{ all -> 0x007d }
            goto L_0x0055
        L_0x002c:
            r2 = -1
            if (r1 != r2) goto L_0x0034
            r4.f1(r5, r6)     // Catch:{ all -> 0x007d }
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x0034:
            java.util.List<com.huobi.finance.bean.BaseAssetPositionAccountData> r2 = r4.f42725w     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x007d }
            s9.a r1 = (s9.a) r1     // Catch:{ all -> 0x007d }
            boolean r2 = r1 instanceof vk.i     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x0055
            vk.i r1 = (vk.i) r1     // Catch:{ all -> 0x007d }
            r1.o(r6)     // Catch:{ all -> 0x007d }
            int r2 = r4.f42715m     // Catch:{ all -> 0x007d }
            boolean r3 = r4.f42720r     // Catch:{ all -> 0x007d }
            r1.c(r2, r3)     // Catch:{ all -> 0x007d }
            h6.a r1 = r4.getUI()     // Catch:{ all -> 0x007d }
            com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew$h r1 = (com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew.h) r1     // Catch:{ all -> 0x007d }
            r1.K1(r5)     // Catch:{ all -> 0x007d }
        L_0x0055:
            java.util.HashMap<com.huobi.asset.AssetAccountType, java.util.List<com.huobi.finance.bean.BasePositionSortAccountItem>> r1 = r4.f42726x     // Catch:{ all -> 0x007d }
            r1.put(r5, r6)     // Catch:{ all -> 0x007d }
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x005c:
            r4.q2(r5)     // Catch:{ all -> 0x007d }
            com.hbg.lib.core.BaseModuleConfig$a r5 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ all -> 0x007d }
            boolean r5 = r5.c()     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x007b
            java.util.List<com.huobi.finance.bean.BaseAssetPositionAccountData> r5 = r4.f42725w     // Catch:{ all -> 0x007d }
            boolean r5 = com.hbg.lib.core.util.CollectionsUtils.b(r5)     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x007b
            h6.a r5 = r4.getUI()     // Catch:{ all -> 0x007d }
            com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew$h r5 = (com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew.h) r5     // Catch:{ all -> 0x007d }
            r6 = 3
            r5.Z2(r6)     // Catch:{ all -> 0x007d }
        L_0x007b:
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x007d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew.l2(com.huobi.asset.AssetAccountType, java.util.List):void");
    }

    public final void m2(int i11) {
        if (i11 >= 0 && i11 < this.f42725w.size()) {
            this.f42725w.remove(i11);
            ((h) getUI()).a3(i11, 1);
            D2();
        }
    }

    /* renamed from: n2 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, h hVar) {
        super.onUIReady(baseCoreActivity, hVar);
        this.f42714l = i0.d();
        this.f42718p = BaseModuleConfig.a().c();
        this.f42719q = BaseModuleConfig.a().getUid();
        b1();
        e1();
        o2().subscribe(EasySubscriber.create(o0.f63039b, m0.f63033b, n0.f63036b));
        a1();
    }

    public final Observable<Object> o2() {
        i6.d.c("AssetIndexFragmentPresenter", "preLoad");
        return Observable.zip(a7.e.K(TradeType.CONTRACT).onErrorReturn(b1.f62995b), a7.e.K(TradeType.SWAP).onErrorReturn(c1.f62999b), a7.e.K(TradeType.LINEAR_SWAP).onErrorReturn(j1.f63025b), LegalCurrencyConfigUtil.e().onErrorReturn(f1.f63011b), o1.f63040b).compose(RxJavaHelper.t((u6.g) getUI())).timeout(5, TimeUnit.SECONDS);
    }

    public void onPause() {
        super.onPause();
        f0.g().m();
    }

    public void onResume() {
        super.onResume();
        f0.g().i();
    }

    public final void p2(AssetAccountType assetAccountType) {
        if (this.f42724v.contains(assetAccountType)) {
            this.f42724v.remove(assetAccountType);
        }
    }

    public final void q2(AssetAccountType assetAccountType) {
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < this.f42725w.size(); i14++) {
            BaseAssetPositionAccountData baseAssetPositionAccountData = this.f42725w.get(i14);
            if (baseAssetPositionAccountData.a() == assetAccountType) {
                if (baseAssetPositionAccountData instanceof vk.f) {
                    i11 = i14;
                } else {
                    if (baseAssetPositionAccountData instanceof vk.d) {
                        i13 = i14;
                    }
                    if (baseAssetPositionAccountData instanceof vk.i) {
                        i12 = i14;
                    }
                }
            }
        }
        if (i11 != -1) {
            m2(i11);
        } else {
            if (i12 != -1) {
                m2(i12);
            }
            if (i13 != -1) {
                m2(i13);
            }
        }
        C2();
    }

    public final void r2(int i11, AssetAccountType assetAccountType, List<BasePositionSortAccountItem> list) {
        if (i11 >= 0) {
            m2(i11);
            this.f42725w.add(i11, new vk.i(assetAccountType, list));
            this.f42725w.add(i11, new vk.d(assetAccountType));
            D2();
            ((h) getUI()).M1(i11, 2);
            if (i11 == 0) {
                ((h) getUI()).r3();
            }
        }
    }

    public void s2() {
        this.f42709g.setCacheTime(System.currentTimeMillis());
        t2(new Gson().toJson((Object) this.f42709g));
    }

    public final void t2(String str) {
        SP.s("cache_account_position" + AssetModuleConfig.a().getUid(), str);
    }

    public final void u2(AssetAccountType assetAccountType) {
        if (this.f42712j) {
            this.f42711i.put(assetAccountType, Boolean.TRUE);
            for (Map.Entry<AssetAccountType, Boolean> value : this.f42711i.entrySet()) {
                if (!((Boolean) value.getValue()).booleanValue()) {
                    return;
                }
            }
            AssetModuleConfig.a().n("huobiapp_assets_start", "huobiapp_assets_end", "", true);
            this.f42712j = false;
        }
    }

    public final void v2() {
        if (this.f42712j) {
            AssetModuleConfig.a().d0("huobiapp_assets_start");
        }
    }

    public final void w2() {
        x2(true);
    }

    public final void x2(boolean z11) {
        for (int i11 = 0; i11 < this.f42725w.size(); i11++) {
            BaseAssetPositionAccountData baseAssetPositionAccountData = this.f42725w.get(i11);
            if (baseAssetPositionAccountData instanceof vk.i) {
                baseAssetPositionAccountData.c(this.f42715m, this.f42720r);
            }
        }
        if (z11) {
            ((h) getUI()).x1();
        }
    }

    public final void y2() {
        A2();
        this.f42713k = Observable.interval(0, 3, TimeUnit.SECONDS).compose(RxJavaHelper.s()).subscribe(new a());
    }

    public void z2() {
        if (!this.f42716n) {
            y2();
        }
    }
}
