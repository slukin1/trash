package com.huobi.asset2.index.personer;

import al.p;
import android.text.TextUtils;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
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
import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
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
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.bean.MarginBalanceDetailInfo;
import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.bean.SuperMarginDetailInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
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
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;
import uh.i;
import vk.k;
import zh.a0;
import zh.b0;
import zh.c0;
import zh.d0;
import zh.e0;
import zh.f0;
import zh.g0;
import zh.h0;
import zh.j;
import zh.j0;
import zh.k0;
import zh.l;
import zh.n;
import zh.o;
import zh.q;
import zh.r;
import zh.s;
import zh.t;
import zh.u;
import zh.v;
import zh.x;
import zh.y;
import zh.z;

public class AssetIndexFragmentPresenter extends BaseFragmentPresenter<h> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f42681c = new Object[0];

    /* renamed from: d  reason: collision with root package name */
    public Subscription f42682d;

    /* renamed from: e  reason: collision with root package name */
    public i0 f42683e;

    /* renamed from: f  reason: collision with root package name */
    public int f42684f = 1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42685g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42686h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42687i;

    /* renamed from: j  reason: collision with root package name */
    public String f42688j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f42689k = false;

    /* renamed from: l  reason: collision with root package name */
    public List<k> f42690l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public k.a f42691m = new d0(this);

    /* renamed from: n  reason: collision with root package name */
    public AssetAccountType[] f42692n;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList<AssetAccountType> f42693o = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    public List<BaseAssetPositionAccountData> f42694p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public HashMap<AssetAccountType, List<BasePositionSortAccountItem>> f42695q = new HashMap<>();

    /* renamed from: r  reason: collision with root package name */
    public HashMap<AssetAccountType, Boolean> f42696r = new HashMap<>();

    /* renamed from: s  reason: collision with root package name */
    public HashMap<AssetAccountType, Integer> f42697s = new HashMap<>();

    public class a extends BaseSubscriber<Long> {
        public a() {
        }

        public void onNext(Long l11) {
            if (AssetIndexFragmentPresenter.this.Y0()) {
                AssetIndexFragmentPresenter.this.Y1();
            }
        }
    }

    public class b extends BaseSubscriber<List<BasePositionSortAccountItem>> {
        public b() {
        }

        public void onAfter() {
            super.onAfter();
            AssetIndexFragmentPresenter.this.f42696r.put(AssetAccountType.MARGIN, Boolean.FALSE);
        }

        public void onNext(List<BasePositionSortAccountItem> list) {
            onAfter();
            AssetIndexFragmentPresenter.this.a2(AssetAccountType.MARGIN, list);
        }
    }

    public class c extends SilentSubscriber<List<BasePositionSortAccountItem>> {
        public c() {
        }

        public void onAfter() {
            AssetIndexFragmentPresenter.this.f42696r.put(AssetAccountType.OTC, Boolean.FALSE);
        }

        public void onCompleted() {
            AssetIndexFragmentPresenter.this.f42696r.put(AssetAccountType.OTC, Boolean.FALSE);
        }

        public void onError2(Throwable th2) {
            AssetIndexFragmentPresenter.this.a2(AssetAccountType.OTC, (List<BasePositionSortAccountItem>) null);
            onAfter();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            AssetIndexFragmentPresenter.this.a2(AssetAccountType.OTC, (List<BasePositionSortAccountItem>) null);
            onAfter();
        }

        public void onNext(List<BasePositionSortAccountItem> list) {
            AssetIndexFragmentPresenter.this.a2(AssetAccountType.OTC, list);
            onAfter();
        }
    }

    public class d extends BaseSubscriber<List<BasePositionSortAccountItem>> {
        public d() {
        }

        public void onAfter() {
            super.onAfter();
            AssetIndexFragmentPresenter.this.f42696r.put(AssetAccountType.HUOBI_EARN, Boolean.FALSE);
        }

        public void onNext(List<BasePositionSortAccountItem> list) {
            AssetIndexFragmentPresenter assetIndexFragmentPresenter = AssetIndexFragmentPresenter.this;
            AssetAccountType assetAccountType = AssetAccountType.HUOBI_EARN;
            assetIndexFragmentPresenter.a2(assetAccountType, list);
            AssetIndexFragmentPresenter.this.e2(assetAccountType);
            onAfter();
        }
    }

    public class e extends BaseSubscriber<List<BasePositionSortAccountItem>> {
        public e() {
        }

        public void onAfter() {
            super.onAfter();
            AssetIndexFragmentPresenter.this.f42696r.put(AssetAccountType.SPOT, Boolean.FALSE);
        }

        public void onNext(List<BasePositionSortAccountItem> list) {
            AssetIndexFragmentPresenter.this.a2(AssetAccountType.SPOT, list);
            onAfter();
        }
    }

    public class f extends SilentSubscriber<List<AssetOptionsInfo>> {
        public f() {
        }

        public void onCompleted() {
            super.onCompleted();
            AssetIndexFragmentPresenter.this.f42696r.put(AssetAccountType.WARRANT, Boolean.FALSE);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            AssetIndexFragmentPresenter.this.a2(AssetAccountType.WARRANT, (List<BasePositionSortAccountItem>) null);
        }

        public void onNext(List<AssetOptionsInfo> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (AssetOptionsInfo next : list) {
                    if (BigDecimal.ZERO.compareTo(m.a(next.getPosition())) != 0) {
                        AssetPositionWarrantData assetPositionWarrantData = new AssetPositionWarrantData();
                        assetPositionWarrantData.j(next);
                        arrayList.add(assetPositionWarrantData);
                    }
                }
            }
            AssetIndexFragmentPresenter.this.a2(AssetAccountType.WARRANT, arrayList);
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42704a;

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
                f42704a = r0
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.SPOT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42704a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.OTC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42704a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.MARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42704a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.FUTURE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f42704a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.HUOBI_EARN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f42704a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.QUANT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f42704a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.WARRANT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.personer.AssetIndexFragmentPresenter.g.<clinit>():void");
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
    public /* synthetic */ void A1(APIStatusErrorException aPIStatusErrorException) {
        ((h) getUI()).finishRefresh();
        if (this.f42685g) {
            ((h) getUI()).Z2(2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B1(Throwable th2) {
        ((h) getUI()).finishRefresh();
        if (this.f42685g) {
            ((h) getUI()).Z2(2);
        }
    }

    public static /* synthetic */ Object G1(Integer num, Integer num2, Integer num3, Map map) {
        return null;
    }

    public static /* synthetic */ Integer H1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer I1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Integer J1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Map K1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Boolean a1(Boolean bool) {
        i.d().n(!bool.booleanValue() && i.d().h());
        return bool;
    }

    public static /* synthetic */ List c1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List d1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ HashMap e1(List list, List list2) {
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

    public static /* synthetic */ List f1(HashMap hashMap) {
        List<MiningItem> list = (List) hashMap.get(0);
        List<MiningItem> list2 = (List) hashMap.get(1);
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtils.b(list)) {
            for (MiningItem miningItem : list) {
                if (!m.b0(miningItem.getMiningAmount())) {
                    arrayList.add(new vk.e(miningItem));
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
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List g1(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AssetPositionContractData h1(SwapPosition swapPosition) {
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

    public static /* synthetic */ List i1(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AssetPositionContractData j1(LinearSwapPosition linearSwapPosition) {
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

    public static /* synthetic */ List k1(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List l1(ContractHeartBeat contractHeartBeat, List list, List list2, List list3) {
        ArrayList arrayList = new ArrayList();
        if (!contractHeartBeat.isSysSafeguard() && list != null) {
            arrayList.addAll(list);
        }
        if (!contractHeartBeat.isSwapSafeguard() && list2 != null) {
            arrayList.addAll(list2);
        }
        if (!contractHeartBeat.isLinearSwapSafeguard() && list3 != null) {
            arrayList.addAll(list3);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m1(List list) {
        AssetAccountType assetAccountType = AssetAccountType.FUTURE;
        a2(assetAccountType, list);
        this.f42696r.put(assetAccountType, Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n1(APIStatusErrorException aPIStatusErrorException) {
        this.f42696r.put(AssetAccountType.FUTURE, Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o1(Throwable th2) {
        this.f42696r.put(AssetAccountType.FUTURE, Boolean.FALSE);
    }

    public static /* synthetic */ List p1(MarginBalanceDataTotal marginBalanceDataTotal, SuperMarginDataTotal superMarginDataTotal) {
        ArrayList arrayList = new ArrayList();
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
                    }
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List q1(List list) {
        String str;
        ArrayList arrayList = new ArrayList();
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
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r1(Boolean bool) {
        ((h) getUI()).M2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ BasePositionSortAccountItem s1(GridStrategy gridStrategy) {
        return AssetPositionQuantData.g(gridStrategy, getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t1(List list) {
        AssetAccountType assetAccountType = AssetAccountType.QUANT;
        a2(assetAccountType, list);
        this.f42696r.put(assetAccountType, Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u1(APIStatusErrorException aPIStatusErrorException) {
        this.f42696r.put(AssetAccountType.QUANT, Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1(Throwable th2) {
        this.f42696r.put(AssetAccountType.QUANT, Boolean.FALSE);
    }

    public static /* synthetic */ List w1(AssetPositionSpotData assetPositionSpotData) {
        ArrayList arrayList = new ArrayList();
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
                        arrayList.add(assetPositionCoinData);
                    }
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ BalanceProfitLossData x1(Map map, Boolean bool, Boolean bool2, Boolean bool3, BalanceProfitLossData balanceProfitLossData) {
        return balanceProfitLossData;
    }

    public static /* synthetic */ BalanceProfitLossData y1(hh.f fVar, BalanceProfitLossData balanceProfitLossData) {
        Iterator<BalanceProfitLossData.AccountBalance> it2 = balanceProfitLossData.getProfitAccountBalanceList().iterator();
        while (it2.hasNext()) {
            if (fVar.g(al.a.d(it2.next().getDistributionType())) == null) {
                it2.remove();
            }
        }
        return balanceProfitLossData;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z1(BalanceProfitLossData balanceProfitLossData) {
        ((h) getUI()).A3(balanceProfitLossData);
        p0.n().C(balanceProfitLossData.getTotalBalance());
        if (p0.n().p()) {
            ((h) getUI()).Z2(4);
        } else if (this.f42685g) {
            this.f42685g = false;
            V0();
            i2();
        } else {
            ((h) getUI()).x1();
        }
    }

    public void L1() {
        if (!this.f42685g) {
            this.f42695q.remove(AssetAccountType.OTC);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f42693o);
            for (AssetAccountType assetAccountType : this.f42692n) {
                if (!arrayList.contains(assetAccountType)) {
                    i6.d.j("looper", "come from loadData() Real requested data:" + assetAccountType.toString());
                    X1(assetAccountType);
                }
            }
        }
    }

    public void M1() {
        Observable.zip(v7.b.a().getMiningItemList(0).b().onErrorReturn(q.f63044b), v7.b.a().getMiningItemList(1).b().onErrorReturn(t.f63053b), z.f63071b).map(v.f63059b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public final void N1() {
        Observable.zip(AssetModuleConfig.a().Q0(), AssetModuleConfig.a().k0(getActivity()).onErrorReturn(r.f63047b), l9.a.a().O((String) null).b().flatMap(ad.i.f3526b).map(new zh.g(this)).toList().onErrorReturn(zh.m.f63032b), h8.a.a().n0((String) null, TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL).b().flatMap(ad.i.f3526b).map(new zh.f(this)).toList().onErrorReturn(zh.p.f63041b), a0.f62990b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new k0(this), new zh.w(this), new h0(this)));
    }

    public void O1() {
        Observable.zip(AssetDataCacheManager.k0().C0().subscribeOn(Schedulers.io()), AssetDataCacheManager.k0().x0().subscribeOn(Schedulers.io()), y.f63068b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new b());
    }

    public void P1() {
        v7.b.a().getOptionsAsset().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f());
    }

    public void Q1() {
        s8.a.a().getWallet2().b().map(x.f63065b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
    }

    public void R1() {
        S1();
        V1();
    }

    public final int S0(AssetAccountType assetAccountType) {
        int intValue = this.f42697s.get(assetAccountType).intValue();
        for (int i11 = 0; i11 < this.f42694p.size(); i11++) {
            if (intValue < this.f42697s.get(this.f42694p.get(i11).a()).intValue()) {
                return i11;
            }
        }
        return -1;
    }

    public final void S1() {
        this.f42683e.f().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new f0(this)));
    }

    public final Observable<Boolean> T0() {
        return v7.b.a().getYbbSwitch().b().compose(RxJavaHelper.t((u6.g) null)).map(j.f63023b).onErrorReturn(n.f63035b);
    }

    public final void T1() {
        v7.b.a().U((String) null, 1, -1, (String) null, -1, "1", 100, (Long) null, (Long) null).b().flatMap(ad.i.f3526b).map(new zh.e(this)).toList().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new j0(this), new e0(this), new g0(this)));
    }

    public final void U0() {
        int i11 = 0;
        if (BaseModuleConfig.a().c()) {
            this.f42692n = new AssetAccountType[]{AssetAccountType.SPOT, AssetAccountType.FUTURE, AssetAccountType.MARGIN, AssetAccountType.QUANT};
        } else {
            this.f42692n = new AssetAccountType[]{AssetAccountType.SPOT, AssetAccountType.FUTURE, AssetAccountType.MARGIN, AssetAccountType.OTC, AssetAccountType.HUOBI_EARN, AssetAccountType.QUANT, AssetAccountType.WARRANT};
        }
        while (true) {
            AssetAccountType[] assetAccountTypeArr = this.f42692n;
            if (i11 < assetAccountTypeArr.length) {
                this.f42697s.put(assetAccountTypeArr[i11], Integer.valueOf(i11));
                i11++;
            } else {
                return;
            }
        }
    }

    public final void U1() {
        v7.b.a().getSpotApiMerge().b().map(zh.i.f63020b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
    }

    public final void V0() {
        this.f42694p.clear();
        this.f42693o.clear();
        int i11 = 0;
        while (true) {
            AssetAccountType[] assetAccountTypeArr = this.f42692n;
            if (i11 < assetAccountTypeArr.length) {
                this.f42693o.add(assetAccountTypeArr[i11]);
                i11++;
            } else {
                this.f42694p.add(new vk.f(AssetAccountType.DEFAULT));
                ((h) getUI()).S2(this.f42694p);
                return;
            }
        }
    }

    public void V1() {
        hh.f h11 = hh.f.h();
        Observable.zip(wk.p0.g("usdt", true), T0(), h11.k(), rh.q.r(), this.f42683e.e(), c0.f62998b).map(new zh.h(h11)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new zh.a(this), new l(this), new zh.i0(this)));
    }

    public final void W0() {
        List<k> list = this.f42690l;
        int i11 = R$string.n_asset_count_equivalent_sort;
        list.add(new k(true, getString(i11), 1, this.f42691m));
        this.f42690l.add(new k(false, getString(R$string.n_asset_profit_sort), 2, this.f42691m));
        this.f42690l.add(new k(false, getString(R$string.n_asset_Yield_sort), 3, this.f42691m));
        ((h) getUI()).H1(this.f42690l, getString(i11), true);
    }

    public void W1() {
        this.f42687i = BaseModuleConfig.a().c();
        this.f42688j = BaseModuleConfig.a().getUid();
        this.f42685g = true;
        this.f42695q.clear();
        this.f42696r.clear();
        U0();
        ((h) getUI()).Z2(1);
    }

    public final void X0(AssetAccountType assetAccountType, List<BasePositionSortAccountItem> list) {
        int S0 = S0(assetAccountType);
        if (S0 == -1) {
            this.f42694p.add(new vk.d(assetAccountType));
            this.f42694p.add(new vk.i(assetAccountType, list));
        } else {
            this.f42694p.add(S0, new vk.i(assetAccountType, list));
            this.f42694p.add(S0, new vk.d(assetAccountType));
        }
        n2();
        ((h) getUI()).M1(S0, 2);
        if (S0 == 0) {
            ((h) getUI()).r3();
        }
    }

    public void X1(AssetAccountType assetAccountType) {
        Boolean bool = this.f42696r.get(assetAccountType);
        if (bool == null || !bool.booleanValue()) {
            i6.d.j("looper", "Real requested data :" + assetAccountType.toString());
            this.f42696r.put(assetAccountType, Boolean.TRUE);
            switch (g.f42704a[assetAccountType.ordinal()]) {
                case 1:
                    U1();
                    return;
                case 2:
                    Q1();
                    return;
                case 3:
                    O1();
                    return;
                case 4:
                    N1();
                    return;
                case 5:
                    M1();
                    return;
                case 6:
                    T1();
                    return;
                case 7:
                    P1();
                    return;
                default:
                    return;
            }
        }
    }

    public boolean Y0() {
        return this.f42686h && al.l.f().i();
    }

    public final void Y1() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f42693o);
        i6.d.j("looper", "Prepare data for polling :" + arrayList.toString());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            X1((AssetAccountType) it2.next());
        }
    }

    public final boolean Z0() {
        if (!CollectionsUtils.b(this.f42694p)) {
            return this.f42694p.get(0) instanceof vk.f;
        }
        return false;
    }

    public void Z1(boolean z11) {
        this.f42686h = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a2(com.huobi.asset.AssetAccountType r5, java.util.List<com.huobi.finance.bean.BasePositionSortAccountItem> r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f42681c
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
            boolean r2 = r4.Z0()     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x002c
            r1 = 0
            r4.g2(r1, r5, r6)     // Catch:{ all -> 0x007d }
            goto L_0x0055
        L_0x002c:
            r2 = -1
            if (r1 != r2) goto L_0x0034
            r4.X0(r5, r6)     // Catch:{ all -> 0x007d }
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x0034:
            java.util.List<com.huobi.finance.bean.BaseAssetPositionAccountData> r2 = r4.f42694p     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x007d }
            s9.a r1 = (s9.a) r1     // Catch:{ all -> 0x007d }
            boolean r2 = r1 instanceof vk.i     // Catch:{ all -> 0x007d }
            if (r2 == 0) goto L_0x0055
            vk.i r1 = (vk.i) r1     // Catch:{ all -> 0x007d }
            r1.o(r6)     // Catch:{ all -> 0x007d }
            int r2 = r4.f42684f     // Catch:{ all -> 0x007d }
            boolean r3 = r4.f42689k     // Catch:{ all -> 0x007d }
            r1.c(r2, r3)     // Catch:{ all -> 0x007d }
            h6.a r1 = r4.getUI()     // Catch:{ all -> 0x007d }
            com.huobi.asset2.index.personer.AssetIndexFragmentPresenter$h r1 = (com.huobi.asset2.index.personer.AssetIndexFragmentPresenter.h) r1     // Catch:{ all -> 0x007d }
            r1.K1(r5)     // Catch:{ all -> 0x007d }
        L_0x0055:
            java.util.HashMap<com.huobi.asset.AssetAccountType, java.util.List<com.huobi.finance.bean.BasePositionSortAccountItem>> r1 = r4.f42695q     // Catch:{ all -> 0x007d }
            r1.put(r5, r6)     // Catch:{ all -> 0x007d }
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x005c:
            r4.f2(r5)     // Catch:{ all -> 0x007d }
            com.hbg.lib.core.BaseModuleConfig$a r5 = com.hbg.lib.core.BaseModuleConfig.a()     // Catch:{ all -> 0x007d }
            boolean r5 = r5.c()     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x007b
            java.util.List<com.huobi.finance.bean.BaseAssetPositionAccountData> r5 = r4.f42694p     // Catch:{ all -> 0x007d }
            boolean r5 = com.hbg.lib.core.util.CollectionsUtils.b(r5)     // Catch:{ all -> 0x007d }
            if (r5 == 0) goto L_0x007b
            h6.a r5 = r4.getUI()     // Catch:{ all -> 0x007d }
            com.huobi.asset2.index.personer.AssetIndexFragmentPresenter$h r5 = (com.huobi.asset2.index.personer.AssetIndexFragmentPresenter.h) r5     // Catch:{ all -> 0x007d }
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
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset2.index.personer.AssetIndexFragmentPresenter.a2(com.huobi.asset.AssetAccountType, java.util.List):void");
    }

    public final void b2(int i11) {
        if (i11 >= 0 && i11 < this.f42694p.size()) {
            this.f42694p.remove(i11);
            ((h) getUI()).a3(i11, 1);
            n2();
        }
    }

    /* renamed from: c2 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, h hVar) {
        super.onUIReady(baseCoreActivity, hVar);
        this.f42683e = i0.d();
        this.f42687i = BaseModuleConfig.a().c();
        this.f42688j = BaseModuleConfig.a().getUid();
        U0();
        W0();
        d2().subscribe(EasySubscriber.create(zh.d.f63001b, zh.b.f62993b, zh.c.f62997b));
    }

    public final Observable<Object> d2() {
        i6.d.c("AssetIndexFragmentPresenter", "preLoad");
        return Observable.zip(a7.e.K(TradeType.CONTRACT).onErrorReturn(s.f63050b), a7.e.K(TradeType.SWAP).onErrorReturn(zh.k.f63026b), a7.e.K(TradeType.LINEAR_SWAP).onErrorReturn(o.f63038b), LegalCurrencyConfigUtil.e().onErrorReturn(u.f63056b), b0.f62994b).compose(RxJavaHelper.t((u6.g) getUI())).timeout(5, TimeUnit.SECONDS);
    }

    public final void e2(AssetAccountType assetAccountType) {
        if (this.f42693o.contains(assetAccountType)) {
            this.f42693o.remove(assetAccountType);
        }
    }

    public final void f2(AssetAccountType assetAccountType) {
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < this.f42694p.size(); i14++) {
            BaseAssetPositionAccountData baseAssetPositionAccountData = this.f42694p.get(i14);
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
            b2(i11);
        } else {
            if (i12 != -1) {
                b2(i12);
            }
            if (i13 != -1) {
                b2(i13);
            }
        }
        m2();
    }

    public final void g2(int i11, AssetAccountType assetAccountType, List<BasePositionSortAccountItem> list) {
        if (i11 >= 0) {
            b2(i11);
            this.f42694p.add(i11, new vk.i(assetAccountType, list));
            this.f42694p.add(i11, new vk.d(assetAccountType));
            n2();
            ((h) getUI()).M1(i11, 2);
            if (i11 == 0) {
                ((h) getUI()).r3();
            }
        }
    }

    public final void h2() {
        for (int i11 = 0; i11 < this.f42694p.size(); i11++) {
            BaseAssetPositionAccountData baseAssetPositionAccountData = this.f42694p.get(i11);
            if (baseAssetPositionAccountData instanceof vk.i) {
                baseAssetPositionAccountData.c(this.f42684f, this.f42689k);
            }
        }
        ((h) getUI()).x1();
    }

    public final void i2() {
        k2();
        this.f42682d = Observable.interval(0, 3, TimeUnit.SECONDS).compose(RxJavaHelper.s()).subscribe(new a());
    }

    public void j2() {
        if (!this.f42685g) {
            i2();
        }
    }

    public void k2() {
        Subscription subscription = this.f42682d;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f42682d.unsubscribe();
            this.f42696r.clear();
        }
    }

    public void l2(AssetAccountType assetAccountType) {
        int e11 = al.l.f().e(assetAccountType);
        if (e11 >= 0) {
            s9.a aVar = this.f42694p.get(e11);
            if (aVar instanceof vk.i) {
                vk.i iVar = (vk.i) aVar;
                iVar.j();
                a2(assetAccountType, iVar.i());
            }
        }
    }

    public final void m2() {
        if (!CollectionsUtils.b(this.f42694p)) {
            for (int i11 = 0; i11 < this.f42694p.size(); i11++) {
                s9.a aVar = this.f42694p.get(i11);
                if (aVar instanceof vk.i) {
                    al.l.f().l(((vk.i) aVar).a(), i11);
                }
            }
        }
    }

    public final void n2() {
        al.l.f().a();
        for (int i11 = 0; i11 < this.f42694p.size(); i11++) {
            al.l.f().l(this.f42694p.get(i11).a(), i11);
        }
    }

    /* renamed from: o2 */
    public final void C1(int i11) {
        boolean z11 = true;
        String str = "";
        if (this.f42684f != i11) {
            this.f42684f = i11;
            for (k next : this.f42690l) {
                if (next.c() == i11) {
                    str = next.a();
                }
                next.f(next.c() == i11);
            }
            h2();
            gi.a.v(this.f42684f);
        }
        h hVar = (h) getUI();
        List<k> list = this.f42690l;
        if (i11 != 0) {
            z11 = false;
        }
        hVar.H1(list, str, z11);
    }

    public void onPause() {
        super.onPause();
        sl.f0.g().m();
    }

    public void onResume() {
        super.onResume();
        sl.f0.g().i();
    }

    public void p2(boolean z11) {
        this.f42689k = z11;
        gi.a.w(z11);
        h2();
    }

    public void q2() {
        if (!BaseModuleConfig.a().getUid().equalsIgnoreCase(this.f42688j)) {
            W1();
        }
    }
}
