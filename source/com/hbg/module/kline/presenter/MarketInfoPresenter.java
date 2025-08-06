package com.hbg.module.kline.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import ce.j;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.ContentNewsUnreadBean;
import com.hbg.lib.network.hbg.core.bean.ContentUnreadBean;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.index.core.util.ContractIndexPrecisionUtil;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.community.ui.CommunityKLineFragment;
import com.hbg.module.content.ui.fragment.KlineDeepFragment;
import com.hbg.module.content.ui.fragment.NewsChildFragment;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.ui.MarketInfoCurrencyDetailFragment;
import com.hbg.module.kline.ui.MarketInfoEtpDetailFragment;
import com.hbg.module.kline.ui.MarketInfoFragment;
import com.hbg.module.kline.util.MarketSymbolTitleUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import td.i;
import u6.g;

public class MarketInfoPresenter extends ActivityPresenter<e> {

    /* renamed from: a  reason: collision with root package name */
    public String f23670a;

    /* renamed from: b  reason: collision with root package name */
    public String f23671b;

    /* renamed from: c  reason: collision with root package name */
    public String f23672c;

    /* renamed from: d  reason: collision with root package name */
    public String f23673d;

    /* renamed from: e  reason: collision with root package name */
    public String f23674e;

    /* renamed from: f  reason: collision with root package name */
    public String f23675f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23676g;

    /* renamed from: h  reason: collision with root package name */
    public int f23677h;

    /* renamed from: i  reason: collision with root package name */
    public int f23678i;

    /* renamed from: j  reason: collision with root package name */
    public String f23679j;

    /* renamed from: k  reason: collision with root package name */
    public ContractCurrencyInfo f23680k;

    /* renamed from: l  reason: collision with root package name */
    public SwapCurrencyInfo f23681l;

    /* renamed from: m  reason: collision with root package name */
    public IndexCurrencyInfo f23682m;

    /* renamed from: n  reason: collision with root package name */
    public FutureContractInfo f23683n;

    /* renamed from: o  reason: collision with root package name */
    public List<Fragment> f23684o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public List<String> f23685p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public int f23686q = -1;

    public class a extends b0 {
        public a(FragmentManager fragmentManager, int i11) {
            super(fragmentManager, i11);
        }

        public int getCount() {
            return MarketInfoPresenter.this.f23684o.size();
        }

        public Fragment getItem(int i11) {
            return (Fragment) MarketInfoPresenter.this.f23684o.get(i11);
        }
    }

    public class b extends BaseSubscriber<Boolean> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            ((e) MarketInfoPresenter.this.getUI()).a7(bool);
        }
    }

    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            ((e) MarketInfoPresenter.this.getUI()).I6(i11);
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23690a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23690a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23690a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23690a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.presenter.MarketInfoPresenter.d.<clinit>():void");
        }
    }

    public interface e extends g {
        void I6(int i11);

        void P7(List<String> list);

        void Pc();

        void W6(boolean z11, boolean z12, boolean z13);

        void X9(SymbolBean symbolBean);

        void Zg(TradeType tradeType, boolean z11);

        void a7(Boolean bool);

        ViewPager g3();

        Activity getActivity();

        void pe(String str, int i11);

        void qg(SymbolBean symbolBean);

        void te(boolean z11);

        void ub(String str);

        void zc();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit p0(ContentUnreadBean contentUnreadBean) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = false;
        if (contentUnreadBean != null) {
            boolean z14 = contentUnreadBean.getCommunityNum() > 0;
            ContentNewsUnreadBean news = contentUnreadBean.getNews();
            if (news != null) {
                z11 = news.getNewsflashNum() > 0;
                if (news.getNewsNum() <= 0) {
                    z12 = false;
                }
            } else {
                z12 = false;
                z11 = false;
            }
            z13 = z14;
        } else {
            z12 = false;
            z11 = false;
        }
        ((e) getUI()).W6(z13, z11, z12);
        return null;
    }

    public static /* synthetic */ Unit q0(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        return null;
    }

    public final void A0() {
        int i11;
        if (!TextUtils.isEmpty(this.f23670a)) {
            String str = "";
            int i12 = d.f23690a[TradeType.parse(this.f23670a).ordinal()];
            int i13 = 0;
            if (i12 == 1) {
                ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info");
                if (!(contractCurrencyInfo == null || contractCurrencyInfo.getSymbol() == null)) {
                    str = contractCurrencyInfo.getSymbol().toUpperCase();
                }
            } else if (i12 == 2) {
                SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info");
                if (!(swapCurrencyInfo == null || swapCurrencyInfo.getSymbol() == null)) {
                    str = swapCurrencyInfo.getSymbol().toUpperCase();
                }
            } else if (i12 != 3) {
                str = StringUtils.i(a1.v().p(this.f23671b));
                ((e) getUI()).pe(str, i13);
            } else {
                FutureContractInfo futureContractInfo = (FutureContractInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info");
                if (futureContractInfo != null) {
                    str = futureContractInfo.getSymbol().toUpperCase();
                } else if (!TextUtils.isEmpty(this.f23671b) && this.f23671b.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    String[] split = this.f23671b.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    if (split == null) {
                        i11 = 0;
                    } else {
                        i11 = split.length;
                    }
                    if (i11 >= 1) {
                        str = split[0];
                    }
                }
            }
            i13 = 1;
            ((e) getUI()).pe(str, i13);
        }
    }

    public final void T(Intent intent) {
        try {
            CommunityKLineFragment a11 = CommunityKLineFragment.F.a(this.f23671b, this.f23670a, this.f23676g, a1.v().p(f0()), "");
            if (intent.getBooleanExtra("airdrop", false)) {
                this.f23686q = this.f23685p.size();
            }
            this.f23685p.add(getString(R$string.n_content_comment));
            this.f23684o.add(a11);
            V();
            U();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void U() {
        this.f23685p.add(getString(R$string.n_content_deep_news));
        this.f23684o.add(KlineDeepFragment.C.a(this.f23671b));
    }

    public final void V() {
        this.f23685p.add(getString(R$string.n_content_newsflash));
        NewsChildFragment a11 = NewsChildFragment.H.a(-1, "", this.f23671b, -1);
        if (a11.getArguments() != null) {
            a11.getArguments().putInt("viewType", 2);
        }
        this.f23684o.add(a11);
    }

    public final void W() {
        if (BaseModuleConfig.a().U(this.f23671b)) {
            ((e) getUI()).zc();
        }
    }

    public final void X(Intent intent) {
        this.f23682m = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        Z(intent);
        this.f23677h = ContractIndexPrecisionUtil.a(this.f23674e);
        this.f23678i = 0;
        if (this.f23682m != null) {
            String string = getString(R$string.market_info_tab_contract_index_intro);
            this.f23672c = String.format(Locale.US, string, new Object[]{this.f23682m.getSymbol() + this.f23682m.getQuoteCurrency()});
            this.f23675f = this.f23682m.getContractShortType();
        }
        String c02 = c0();
        this.f23679j = c02;
        if (TextUtils.isEmpty(c02)) {
            this.f23679j = this.f23671b;
        }
    }

    public final void Y(Intent intent) {
        String stringExtra = intent.getStringExtra("contractName");
        this.f23672c = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.f23671b)) {
            this.f23672c = MarketSymbolTitleUtil.a(this.f23671b);
        }
        if (TradeType.isContract(this.f23670a)) {
            ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            this.f23680k = contractCurrencyInfo;
            if (contractCurrencyInfo == null) {
                ContractCurrencyInfo b11 = ContractCurrencyUtils.b(this.f23671b);
                this.f23680k = b11;
                if (b11 != null) {
                    this.f23675f = b11.getContractShortType();
                    intent.putExtra("contract_currency_info", this.f23680k);
                    if (TextUtils.isEmpty(this.f23674e)) {
                        String contractCode = this.f23680k.getContractCode();
                        this.f23674e = contractCode;
                        intent.putExtra("contractCode", contractCode);
                    }
                    if (TextUtils.isEmpty(this.f23673d)) {
                        String symbol = this.f23680k.getSymbol();
                        this.f23673d = symbol;
                        intent.putExtra("contract_currency_symble", symbol);
                    }
                }
            } else {
                this.f23675f = contractCurrencyInfo.getContractShortType();
            }
            this.f23677h = i.a().b().z(this.f23674e);
            if (a7.e.E(TradeType.CONTRACT)) {
                this.f23678i = i.a().b().t(this.f23674e);
            } else {
                this.f23678i = i.a().b().D(this.f23674e);
            }
        } else if (TradeType.isSwap(this.f23670a)) {
            SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            this.f23681l = swapCurrencyInfo;
            if (swapCurrencyInfo == null) {
                SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(this.f23671b);
                this.f23681l = c11;
                if (c11 != null) {
                    this.f23675f = c11.getContractShortType();
                    intent.putExtra("contract_currency_info", this.f23681l);
                    if (TextUtils.isEmpty(this.f23674e)) {
                        String contractCode2 = this.f23681l.getContractCode();
                        this.f23674e = contractCode2;
                        intent.putExtra("contractCode", contractCode2);
                    }
                    if (TextUtils.isEmpty(this.f23673d)) {
                        String symbol2 = this.f23681l.getSymbol();
                        this.f23673d = symbol2;
                        intent.putExtra("contract_currency_symble", symbol2);
                    }
                }
            } else {
                this.f23675f = swapCurrencyInfo.getContractShortType();
            }
            this.f23677h = i.a().b().B(this.f23673d);
            if (a7.e.E(TradeType.SWAP)) {
                this.f23678i = i.a().b().m(this.f23673d);
            } else {
                this.f23678i = i.a().b().j(this.f23673d);
            }
        }
        String c02 = c0();
        this.f23679j = c02;
        if (TextUtils.isEmpty(c02)) {
            this.f23679j = this.f23671b;
        }
    }

    public final void Z(Intent intent) {
        if (this.f23682m == null) {
            Map<String, IndexCurrencyInfo> h11 = IndexCurrencyInfoController.k().h();
            if (h11 != null) {
                this.f23682m = h11.get(this.f23671b);
            }
            if (this.f23682m == null) {
                this.f23682m = new IndexCurrencyInfo();
                String[] split = this.f23671b.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split.length > 1) {
                    this.f23682m.setSymbol(split[0]);
                    this.f23682m.setQuoteCurrency(split[1]);
                }
                this.f23682m.setContractShortType(this.f23671b);
                this.f23682m.setContractCode(this.f23671b.replace("-Index", ""));
            }
            intent.putExtra("contract_currency_info", this.f23682m);
            intent.putExtra("symbolId", this.f23682m.getContractCode());
            intent.putExtra("contractCode", this.f23682m.getContractCode());
            intent.putExtra("contract_currency_symble", this.f23682m.getSymbol());
            this.f23671b = this.f23682m.getContractCode();
            this.f23674e = this.f23682m.getContractCode();
        }
    }

    public final void a0(String str) {
        i.a().b().h((e) getUI(), str).subscribe(new b());
    }

    public ContractCurrencyInfo b0() {
        return this.f23680k;
    }

    public String c0() {
        return this.f23675f;
    }

    public FutureContractInfo d0() {
        return this.f23683n;
    }

    public final String f0() {
        String str = this.f23671b;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (this.f23671b.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return this.f23671b.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0].toLowerCase(Locale.ROOT) + "usdt";
        } else if (!this.f23671b.contains("_")) {
            return this.f23671b;
        } else {
            return this.f23671b.split("_")[0].toLowerCase(Locale.ROOT) + "usdt";
        }
    }

    public SwapCurrencyInfo g0() {
        return this.f23681l;
    }

    public String h0() {
        return this.f23671b;
    }

    public String i0() {
        return this.f23670a;
    }

    public String j0() {
        return this.f23679j;
    }

    public final void k0() {
        RequestExtKt.c(v7.b.a().getContentUnread(f0(), 11), new ce.i(this), j.f13079b, (MutableLiveData) null);
    }

    public boolean l0() {
        return a1.v().p0(this.f23671b);
    }

    public boolean m0() {
        return this.f23676g;
    }

    public boolean n0() {
        return TradeType.MARGIN == TradeType.valueOf(this.f23670a) || TradeType.SUPERMARGIN == TradeType.valueOf(this.f23670a);
    }

    public void onResume() {
        super.onResume();
        a0(j0());
    }

    public final void r0(Intent intent) {
        this.f23682m = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
        Z(intent);
        this.f23678i = 0;
        if (this.f23682m != null) {
            String p11 = a7.e.p(getActivity(), this.f23682m.getSymbol(), this.f23682m.getQuoteCurrency());
            String string = getString(R$string.market_info_tab_contract_index_intro);
            this.f23672c = String.format(Locale.US, string, new Object[]{p11});
            this.f23677h = FuturePrecisionUtil.b(this.f23682m.getContractCode());
            this.f23675f = this.f23682m.getContractShortType();
        }
        String c02 = c0();
        this.f23679j = c02;
        if (TextUtils.isEmpty(c02)) {
            this.f23679j = this.f23671b;
        }
    }

    public final void s0(Intent intent) {
        String stringExtra = intent.getStringExtra("contractName");
        this.f23672c = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.f23671b)) {
            this.f23672c = MarketSymbolTitleUtil.b(this.f23671b);
        }
        FutureContractInfo futureContractInfo = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
        this.f23683n = futureContractInfo;
        if (futureContractInfo == null) {
            LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(this.f23671b);
            if (n11 != null) {
                FutureContractInfo futureContractInfo2 = new FutureContractInfo();
                this.f23683n = futureContractInfo2;
                futureContractInfo2.convert(futureContractInfo2, n11);
                intent.putExtra("contract_currency_info", this.f23683n);
                this.f23675f = this.f23683n.contractShortType;
                if (TextUtils.isEmpty(this.f23674e)) {
                    String contractCode = this.f23683n.getContractCode();
                    this.f23674e = contractCode;
                    intent.putExtra("contractCode", contractCode);
                }
                if (TextUtils.isEmpty(this.f23673d)) {
                    String symbol = this.f23683n.getSymbol();
                    this.f23673d = symbol;
                    intent.putExtra("contract_currency_symble", symbol);
                }
            }
        } else {
            this.f23675f = futureContractInfo.contractShortType;
            this.f23674e = futureContractInfo.getContractCode();
            this.f23673d = this.f23683n.getSymbol();
        }
        this.f23677h = FuturePrecisionUtil.y(this.f23674e, this.f23675f, "");
        if (a7.e.F(TradeType.valueOf(this.f23670a))) {
            this.f23678i = FuturePrecisionUtil.s(this.f23674e, this.f23675f, "");
        } else {
            this.f23678i = FuturePrecisionUtil.B();
        }
        String c02 = c0();
        this.f23679j = c02;
        if (TextUtils.isEmpty(c02)) {
            this.f23679j = this.f23671b;
        }
    }

    /* renamed from: t0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, e eVar) {
        super.onUIReady(baseCoreActivity, eVar);
        Intent intent = ((e) getUI()).getActivity().getIntent();
        this.f23670a = z0(intent);
        this.f23671b = y0(intent);
        this.f23673d = v0(intent);
        this.f23674e = u0(intent);
        this.f23676g = x0(intent);
        w0(intent);
        ((e) getUI()).ub(this.f23672c);
        A0();
        ((e) getUI()).P7(this.f23685p);
        ((e) getUI()).Pc();
        ((e) getUI()).g3().setAdapter(new a(getActivity().getSupportFragmentManager(), 1));
        ((e) getUI()).g3().setOffscreenPageLimit(this.f23684o.size());
        if (this.f23686q != -1) {
            ((e) getUI()).g3().setCurrentItem(this.f23686q);
        }
        k0();
        W();
    }

    public String u0(Intent intent) {
        return intent.getStringExtra("contractCode");
    }

    public String v0(Intent intent) {
        return intent.getStringExtra("contract_currency_symble");
    }

    public void w0(Intent intent) {
        if (TradeType.isContract(this.f23670a) || TradeType.isSwap(this.f23670a)) {
            Y(intent);
            this.f23685p.add(getString(R$string.n_market_info_quotes_main_title));
            this.f23684o.add(MarketInfoFragment.hm(this.f23671b, this.f23670a, false));
            ((e) getUI()).te(false);
            T(intent);
        } else if (TradeType.isContractIndex(this.f23670a)) {
            X(intent);
            this.f23685p.add(getString(R$string.n_market_info_quotes_main_title));
            this.f23684o.add(MarketInfoFragment.hm(this.f23671b, this.f23670a, false));
            ((e) getUI()).te(false);
            T(intent);
        } else if (TradeType.isLinearSwap(this.f23670a)) {
            s0(intent);
            this.f23685p.add(getString(R$string.n_market_info_quotes_main_title));
            this.f23684o.add(MarketInfoFragment.hm(this.f23671b, this.f23670a, false));
            ((e) getUI()).te(false);
            T(intent);
        } else if (TradeType.isLinearSwapIndex(this.f23670a)) {
            r0(intent);
            this.f23685p.add(getString(R$string.n_market_info_quotes_main_title));
            this.f23684o.add(MarketInfoFragment.hm(this.f23671b, this.f23670a, false));
            ((e) getUI()).te(false);
            T(intent);
        } else {
            ((e) getUI()).te(!n0());
            this.f23672c = a1.v().X(this.f23671b, TradeType.valueOf(this.f23670a));
            this.f23677h = PrecisionUtil.w(this.f23671b, TradeType.valueOf(this.f23670a));
            this.f23678i = PrecisionUtil.z(this.f23671b);
            this.f23679j = h0();
            this.f23685p.add(getString(R$string.n_market_info_quotes_main_title));
            this.f23684o.add(MarketInfoFragment.hm(this.f23671b, this.f23670a, !n0()));
            T(intent);
            if (l0()) {
                this.f23685p.add(getString(R$string.n_kline_etp_info_tab));
                this.f23684o.add(new MarketInfoEtpDetailFragment());
            } else {
                this.f23685p.add(getString(R$string.market_info_tab_intro));
                this.f23684o.add(new MarketInfoCurrencyDetailFragment());
            }
            ((e) getUI()).X9(a1.v().J(this.f23671b, TradeType.valueOf(this.f23670a)));
        }
        ((e) getUI()).g3().addOnPageChangeListener(new c());
        ((e) getUI()).qg(a1.v().J(this.f23671b, TradeType.valueOf(this.f23670a)));
    }

    public boolean x0(Intent intent) {
        return intent.getBooleanExtra("market_grid", false);
    }

    public String y0(Intent intent) {
        return intent.getStringExtra("symbolId");
    }

    public String z0(Intent intent) {
        String stringExtra = intent.getStringExtra("market_trade_type");
        return TextUtils.isEmpty(stringExtra) ? TradeType.PRO.toString() : stringExtra;
    }
}
