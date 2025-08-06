package p039do;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.main.helper.k;
import com.huobi.main.trade.enums.TradeTabsType;
import com.huobi.trade.helper.EtpRiskHintUtil;
import d7.a1;
import d7.q0;
import i6.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ml.d;
import pro.huobi.R;
import rx.Observable;
import sl.f0;
import sn.t;
import u6.g;

/* renamed from: do.k  reason: invalid package */
public class k extends a<co.a> implements d.a {

    /* renamed from: j  reason: collision with root package name */
    public Partitions f83861j;

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, List<String>> f83862k;

    /* renamed from: l  reason: collision with root package name */
    public final List<String> f83863l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f83864m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f83865n;

    /* renamed from: o  reason: collision with root package name */
    public int f83866o;

    /* renamed from: p  reason: collision with root package name */
    public int f83867p;

    /* renamed from: q  reason: collision with root package name */
    public Map<String, Integer> f83868q;

    /* renamed from: r  reason: collision with root package name */
    public List<String> f83869r;

    /* renamed from: s  reason: collision with root package name */
    public String f83870s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f83871t;

    /* renamed from: u  reason: collision with root package name */
    public com.huobi.main.helper.k f83872u;

    /* renamed from: v  reason: collision with root package name */
    public final f0.b f83873v;

    /* renamed from: do.k$a */
    public class a implements k.d {
        public a() {
        }

        public void a() {
            k.this.J((List<String>) null, false);
            k.this.X();
        }

        public void b(List<String> list) {
            k.this.J(list, false);
            k.this.X();
        }

        public void onSuccess() {
        }
    }

    /* renamed from: do.k$b */
    public class b extends BaseSubscriber<List<String>> {
        public b() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            if (k.this.f83864m) {
                List<String> r11 = t.r();
                if (r11 != null) {
                    k.this.J(r11, true);
                }
                k.this.X();
            }
        }
    }

    /* renamed from: do.k$c */
    public class c implements f0.b {
        public c() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            k.this.X();
        }
    }

    /* renamed from: do.k$d */
    public class d extends BaseSubscriber<List<SymbolBean>> {
        public d() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            k.this.M();
            k.this.A();
        }
    }

    /* renamed from: do.k$e */
    public class e implements k.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f83878a;

        public e(Runnable runnable) {
            this.f83878a = runnable;
        }

        public void a() {
        }

        public void b(List<String> list) {
        }

        public void onSuccess() {
            this.f83878a.run();
        }
    }

    public k(Context context, co.a aVar, g gVar) {
        this(context, TradeType.PRO, aVar, gVar);
    }

    public static /* synthetic */ Boolean O(String str, s9.a aVar) {
        if (aVar instanceof ml.d) {
            ml.d dVar = (ml.d) aVar;
            String j11 = dVar.j();
            String o11 = dVar.o();
            String str2 = a1.v().p(o11).toUpperCase() + "/" + a1.v().F(o11).toUpperCase();
            boolean z11 = true;
            boolean z12 = !TextUtils.isEmpty(j11) && j11.contains(str);
            if (!str.contains("/") || TextUtils.isEmpty(str2) || !str2.contains(str)) {
                z11 = false;
            }
            if (z12 || z11) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(List list) {
        ((co.a) h()).xa(i(), TradeTabsType.getTabsType(this.f83832e, this.f83870s), this.f83869r, list);
    }

    public static /* synthetic */ int Q(Map map, String str, String str2) {
        Integer num;
        int i11 = 0;
        try {
            num = map.get(str2) != null ? Integer.valueOf(m.k0(((CurrencyBean) map.get(str2)).getWeight())) : 0;
            try {
                if (map.get(str) != null) {
                    i11 = Integer.valueOf(m.k0(((CurrencyBean) map.get(str)).getWeight()));
                }
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
        return num.compareTo(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int R(ml.d dVar, ml.d dVar2) {
        Integer num;
        Integer num2 = 0;
        try {
            num = this.f83868q.get(dVar2.o());
            try {
                num2 = this.f83868q.get(dVar.o());
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

    public static /* synthetic */ int S(Map map, ml.d dVar, ml.d dVar2) {
        Integer num;
        int i11 = 0;
        try {
            boolean p02 = a1.v().p0(dVar.o());
            boolean p03 = a1.v().p0(dVar2.o());
            if (p02 && !p03) {
                return 1;
            }
            if (!p02 && p03) {
                return -1;
            }
            num = Integer.valueOf(a1.v().y(dVar2.o(), map));
            try {
                i11 = Integer.valueOf(a1.v().y(dVar.o(), map));
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
            return num.compareTo(i11);
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
    }

    public static /* synthetic */ int T(Map map, ml.d dVar, ml.d dVar2) {
        Integer num;
        int i11 = 0;
        try {
            num = Integer.valueOf(a1.v().y(dVar2.o(), map));
            try {
                i11 = Integer.valueOf(a1.v().y(dVar.o(), map));
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
        return num.compareTo(i11);
    }

    public void A() {
        L();
        ((co.a) h()).y7(this.f83866o);
    }

    public final void B() {
        a0(this.f83866o);
        int i11 = this.f83866o;
        if (i11 == 0) {
            this.f83832e = TradeTabsType.COLLECTION;
            this.f83864m = true;
            return;
        }
        boolean z11 = this.f83865n;
        if (!z11 || i11 != 1) {
            this.f83832e = TradeTabsType.OTHER;
            if (z11) {
                if (i11 > this.f83869r.size() - 1) {
                    h0(2);
                }
            } else if (i11 > this.f83869r.size() - 1) {
                h0(1);
            }
            this.f83864m = false;
            return;
        }
        this.f83832e = TradeTabsType.COMPARE;
        this.f83864m = false;
    }

    public void C(int i11) {
        this.f83866o = i11;
        B();
        A();
    }

    public void D() {
        this.f83870s = null;
    }

    public void E(Runnable runnable) {
        this.f83872u.a(I(), new e(runnable));
    }

    public final ml.d F(SymbolBean symbolBean, SymbolPrice symbolPrice) {
        ml.d dVar = new ml.d(1);
        b0(symbolBean, dVar);
        dVar.F(symbolBean.getDirection());
        if (f()) {
            dVar.E(false);
            dVar.M(true);
        } else {
            dVar.E(this.f83864m);
            dVar.M(false);
        }
        dVar.R(symbolBean.getTradeOpenAt());
        if (f()) {
            dVar.O(symbolBean.getState());
            dVar.T(TradeType.PRO);
        } else if (this.f83864m) {
            dVar.O(symbolBean.getState());
            dVar.T(TradeType.PRO);
        } else if (symbolBean.isHadSt()) {
            return null;
        } else {
            dVar.O(symbolBean.getState());
            dVar.T(this.f83831d);
        }
        String baseCurrencyDisplayName = symbolBean.getBaseCurrencyDisplayName();
        if (symbolBean.getSymbol().equals(((co.a) h()).nf())) {
            dVar.S(true);
        } else {
            dVar.S(false);
        }
        dVar.L(a1.v().S(symbolBean.getSymbol()));
        dVar.J(baseCurrencyDisplayName);
        dVar.G(symbolBean.isHadaxTag());
        dVar.N(symbolBean.isStTag());
        dVar.U(symbolBean.isZerofeeTag());
        dVar.Q(symbolPrice);
        dVar.D(this);
        dVar.K(((co.a) h()).G2());
        return dVar;
    }

    public final void G(List<s9.a> list, String str) {
        if (TextUtils.isEmpty(str)) {
            ((co.a) h()).xa(i(), TradeTabsType.getTabsType(this.f83832e, this.f83870s), this.f83869r, list);
        } else {
            Observable.from(list).filter(new j(str)).compose(RxJavaHelper.t(j())).toList().subscribe(EasySubscriber.create(new i(this)));
        }
    }

    public int H() {
        return this.f83867p;
    }

    public String I() {
        TradeType tradeType = this.f83831d;
        if (tradeType == TradeType.MARGIN) {
            return "s_gradually";
        }
        return tradeType == TradeType.SUPERMARGIN ? "s_full" : "t_symbol";
    }

    public final void J(List<String> list, boolean z11) {
        ArrayList arrayList = new ArrayList();
        String str = "TAB_SEARCH_HISTORY";
        if (z11 || list != null) {
            TradeType tradeType = TradeType.MARGIN;
            TradeType tradeType2 = this.f83831d;
            if (tradeType == tradeType2) {
                List<String> H = a1.v().H(tradeType);
                for (String next : list) {
                    if (H != null && H.contains(next)) {
                        arrayList.add(next);
                    }
                }
            } else {
                TradeType tradeType3 = TradeType.SUPERMARGIN;
                if (tradeType3 == tradeType2) {
                    List<String> H2 = a1.v().H(tradeType3);
                    for (String next2 : list) {
                        if (H2 != null && H2.contains(next2)) {
                            arrayList.add(next2);
                        }
                    }
                } else if (TradeType.isC2C(tradeType2)) {
                    List<String> H3 = a1.v().H(TradeType.C2C);
                    for (String next3 : list) {
                        if (H3 != null && H3.contains(next3)) {
                            arrayList.add(next3);
                        }
                    }
                } else {
                    List<String> H4 = a1.v().H(TradeType.PRO);
                    for (String next4 : list) {
                        if (H4 != null && H4.contains(next4)) {
                            arrayList.add(next4);
                        }
                    }
                }
            }
            Map<String, List<String>> map = this.f83862k;
            if (z11) {
                str = "TAB_COLLECTION";
            }
            map.put(str, arrayList);
            return;
        }
        this.f83862k.put(str, arrayList);
    }

    public final List<String> K() {
        List<SymbolBean> Z;
        String nf2 = ((co.a) h()).nf();
        String n11 = a1.v().n(nf2);
        String D = a1.v().D(nf2);
        boolean p02 = a1.v().p0(nf2);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(n11) && (Z = a1.v().Z(this.f83831d)) != null && !Z.isEmpty()) {
            for (SymbolBean next : Z) {
                if (next.isCanTrade()) {
                    if (!p02 && (n11.equalsIgnoreCase(next.getBaseCurrency()) || n11.equalsIgnoreCase(EtpRiskHintUtil.c(next.getBaseCurrency())))) {
                        arrayList.add(next.getSymbol());
                    } else if (p02 && next.isEtpTag() && EtpRiskHintUtil.c(n11).equalsIgnoreCase(EtpRiskHintUtil.c(next.getBaseCurrency()))) {
                        arrayList.add(next.getSymbol());
                    } else if (p02 && !next.isEtpTag() && EtpRiskHintUtil.c(n11).equalsIgnoreCase(next.getBaseCurrency()) && D.equalsIgnoreCase(next.getQuoteCurrency())) {
                        arrayList.add(next.getSymbol());
                    }
                }
            }
        }
        i6.d.b("ExchangeTradeDataProvider-->initSymbolChangeList-->" + arrayList);
        return arrayList;
    }

    public void L() {
        if (f()) {
            this.f83872u.d(I(), new a());
        } else if (this.f83864m) {
            t.s(false, this.f83829b).compose(RxJavaHelper.t(j())).subscribe(new b());
        } else {
            X();
        }
    }

    public final void M() {
        List<String> list;
        List list2;
        TradeType i11 = i();
        ArrayList arrayList = new ArrayList();
        if (TradeType.PRO == i11) {
            list = a1.v().m();
        } else if (TradeType.MARGIN == i11) {
            list = a1.v().f0();
        } else if (TradeType.isC2C(i11)) {
            list = a1.v().c0();
        } else {
            list = a1.v().i0();
        }
        if (list != null) {
            Map<String, CurrencyBean> u11 = d7.k.C().u();
            if (u11 != null) {
                Collections.sort(list, new h(u11));
            }
            List<String> r11 = t.r();
            if (r11 != null) {
                J(r11, true);
            }
            this.f83862k.put("TAB_COMPARE", K());
            for (int i12 = 0; i12 < list.size(); i12++) {
                if (this.f83861j == null) {
                    list2 = a1.v().d0(list.get(i12), i11);
                } else {
                    list2 = new ArrayList();
                    List<SymbolBean> B = a1.v().B(list.get(i12), this.f83861j.getId().longValue());
                    if (B != null) {
                        int size = B.size();
                        for (int i13 = 0; i13 < size; i13++) {
                            list2.add(B.get(i13).getSymbol());
                        }
                    }
                }
                this.f83862k.put(StringUtils.i(list.get(i12)), list2);
            }
            arrayList.add(this.f83829b.getString(R.string.market_markets_collection));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("TAB_COLLECTION");
            if (this.f83865n) {
                arrayList.add(String.format(Locale.US, g(R.string.n_close_path_eos_compare), new Object[]{a1.v().p(((co.a) h()).nf())}));
                arrayList2.add("TAB_COMPARE");
            }
            Map<String, CurrencyBean> h11 = q0.h();
            for (String next : list) {
                if (SymbolBean.FIAT.equalsIgnoreCase(next)) {
                    arrayList.add(StringUtils.i(next));
                    arrayList2.add(StringUtils.i(next));
                } else if (SymbolBean.ALTS.equalsIgnoreCase(next)) {
                    arrayList.add(StringUtils.i(next));
                    arrayList2.add(StringUtils.i(next));
                } else if (SymbolBean.CRYPTO.equalsIgnoreCase(next)) {
                    arrayList.add(StringUtils.i(next));
                    arrayList2.add(StringUtils.i(next));
                } else {
                    CurrencyBean t11 = d7.k.C().t(next, h11);
                    if (t11 == null) {
                        arrayList.add(StringUtils.i(next));
                        arrayList2.add(StringUtils.i(next));
                    } else {
                        arrayList.add(d7.k.C().y(t11));
                        arrayList2.add(d7.k.C().y(t11));
                    }
                }
            }
            this.f83869r.clear();
            this.f83869r.addAll(arrayList);
            this.f83863l.clear();
            this.f83863l.addAll(arrayList2);
            B();
            ((co.a) h()).p7(this.f83831d, this.f83869r);
        }
    }

    public void N(ml.d dVar) {
        this.f83872u.c(I(), dVar.o());
    }

    public final List<ml.d> U(List<SymbolPrice> list) {
        List list2;
        SymbolBean J;
        SymbolBean J2;
        List list3;
        ArrayList<SymbolPrice> arrayList = new ArrayList<>(list);
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        Map<String, SymbolPrice> T = LegalCurrencyConfigUtil.T();
        if (!f() && this.f83864m && (list3 = this.f83862k.get("TAB_COLLECTION")) != null && !list3.isEmpty()) {
            Y(list3);
        }
        if (f()) {
            list2 = this.f83862k.get("TAB_SEARCH_HISTORY");
        } else {
            list2 = this.f83862k.get(this.f83863l.get(this.f83866o));
        }
        if (list2 != null && list2.size() > 0 && arrayList.size() > 0) {
            for (SymbolPrice symbolPrice : arrayList) {
                T.put(symbolPrice.getSymbol(), symbolPrice);
                if (list2.contains(symbolPrice.getSymbol()) && (J2 = a1.v().J(symbolPrice.getSymbol(), TradeType.PRO)) != null) {
                    hashSet.add(symbolPrice.getSymbol());
                    ml.d F = F(J2, symbolPrice);
                    if (F != null) {
                        arrayList2.add(F);
                    }
                }
            }
            int size = list2.size();
            for (int i11 = 0; i11 < size; i11++) {
                String str = (String) list2.get(i11);
                if (!hashSet.contains(str) && !str.contains("bt1") && !str.contains("bt2") && (J = a1.v().J(str, TradeType.PRO)) != null) {
                    SymbolPrice symbolPrice2 = new SymbolPrice();
                    symbolPrice2.setSymbol(str);
                    ml.d F2 = F(J, symbolPrice2);
                    if (F2 != null) {
                        arrayList2.add(F2);
                    }
                }
            }
            if (f() || !this.f83864m) {
                Map<String, SymbolBean> V = a1.v().V(this.f83831d);
                if (this.f83832e == TradeTabsType.COMPARE) {
                    Collections.sort(arrayList2, new g(V));
                } else {
                    Collections.sort(arrayList2, new f(V));
                }
            } else {
                Collections.sort(arrayList2, new e(this));
            }
        }
        return arrayList2;
    }

    public final void V() {
        f0(true);
        List<SymbolBean> Z = a1.v().Z(i());
        if (Z == null || Z.isEmpty()) {
            a1.v().Y(true, false).compose(RxJavaHelper.t(j())).subscribe(new d());
            return;
        }
        M();
        A();
    }

    public void W() {
        p();
        V();
    }

    public final void X() {
        List<ml.d> U = U(f0.g().f());
        this.f83834g.clear();
        this.f83834g.addAll(U);
        p();
    }

    public final void Y(List<String> list) {
        this.f83868q.clear();
        int i11 = 0;
        for (String put : list) {
            this.f83868q.put(put, Integer.valueOf(i11));
            i11++;
        }
    }

    public void Z(Partitions partitions) {
        if (this.f83861j != partitions) {
            this.f83861j = partitions;
            M();
            X();
        }
    }

    public void a0(int i11) {
        this.f83867p = i11;
    }

    public final void b0(SymbolBean symbolBean, ml.d dVar) {
        TradeType tradeType = this.f83831d;
        if (tradeType == TradeType.PRO) {
            if (symbolBean.isEtpTag()) {
                dVar.I(com.huobi.trade.helper.f0.d(this.f83829b, symbolBean.getDirection(), symbolBean.getEtpLeverageRatio()));
            }
        } else if (tradeType == TradeType.MARGIN) {
            dVar.I(symbolBean.getLeverageRatio() + "X");
        } else if (tradeType == TradeType.SUPERMARGIN) {
            dVar.I(symbolBean.getSuperMarginLeverageRatio() + "X");
        } else if (tradeType == TradeType.C2C) {
            dVar.I(symbolBean.getFundingLeverageRatio() + "X");
        }
    }

    public void c(ml.d dVar) {
        if (h() != null) {
            ((co.a) h()).a(this.f83831d, dVar);
        }
    }

    public void c0(boolean z11) {
        this.f83871t = z11;
    }

    public void d0(String str) {
        this.f83870s = str;
        p();
    }

    public void e0(boolean z11) {
        this.f83865n = z11;
    }

    public final void f0(boolean z11) {
        if (z11) {
            f0.g().e("PRO_EXCHANGE_TRADE_DATA_TAG", this.f83873v);
            f0.g().i();
            return;
        }
        f0.g().j("PRO_EXCHANGE_TRADE_DATA_TAG");
        f0.g().n();
    }

    public final void g0() {
        f0(false);
        this.f83834g.clear();
    }

    public final void h0(int i11) {
        TradeType tradeType = TradeType.PRO;
        TradeType tradeType2 = this.f83831d;
        if (tradeType == tradeType2) {
            this.f83866o = i11;
            ConfigPreferences.k("user_config", "config_home_market_index", i11);
        } else if (TradeType.MARGIN == tradeType2) {
            this.f83866o = i11;
            ConfigPreferences.k("user_config", "config_home_market_margin_index", i11);
        } else if (TradeType.SUPERMARGIN == tradeType2) {
            this.f83866o = i11;
            ConfigPreferences.k("user_config", "config_home_market_super_margin_index", i11);
        } else if (TradeType.isC2C(tradeType2)) {
            this.f83866o = i11;
            ConfigPreferences.k("user_config", "config_home_market_c2c_index", i11);
        }
    }

    public void k() {
        D();
        p();
        V();
    }

    public void l() {
        L();
    }

    public void o() {
        D();
        g0();
    }

    public void p() {
        G(this.f83834g, this.f83870s);
        if (this.f83871t) {
            o();
        }
    }

    public k(Context context, int i11, co.a aVar, g gVar) {
        super(context, TradeType.PRO, aVar, gVar);
        this.f83862k = new ConcurrentHashMap(15);
        this.f83863l = new ArrayList();
        this.f83865n = false;
        this.f83866o = -1;
        this.f83868q = new HashMap();
        this.f83869r = new ArrayList();
        this.f83871t = false;
        this.f83873v = new c();
        this.f83866o = i11;
        List<String> r11 = t.r();
        if (r11 == null || r11.isEmpty()) {
            h0(1);
        }
    }

    public k(Context context, TradeType tradeType, co.a aVar, g gVar) {
        super(context, tradeType, aVar, gVar);
        this.f83862k = new ConcurrentHashMap(15);
        this.f83863l = new ArrayList();
        this.f83865n = false;
        this.f83866o = -1;
        this.f83868q = new HashMap();
        this.f83869r = new ArrayList();
        this.f83871t = false;
        this.f83873v = new c();
        this.f83872u = com.huobi.main.helper.k.b();
        if (TradeType.PRO == tradeType) {
            this.f83866o = ConfigPreferences.f("user_config", "config_home_market_index");
            List<String> r11 = t.r();
            if ((r11 == null || r11.isEmpty()) && this.f83866o == 0) {
                h0(1);
            }
        } else if (TradeType.MARGIN == tradeType) {
            this.f83866o = ConfigPreferences.f("user_config", "config_home_market_margin_index");
            List<String> r12 = t.r();
            if ((r12 == null || r12.isEmpty()) && this.f83866o == 0) {
                h0(1);
            }
        } else if (TradeType.SUPERMARGIN == tradeType) {
            this.f83866o = ConfigPreferences.f("user_config", "config_home_market_super_margin_index");
            List<String> r13 = t.r();
            if ((r13 == null || r13.isEmpty()) && this.f83866o == 0) {
                h0(1);
            }
        } else if (TradeType.isC2C(tradeType)) {
            this.f83866o = ConfigPreferences.f("user_config", "config_home_market_c2c_index");
            List<String> r14 = t.r();
            if ((r14 == null || r14.isEmpty()) && this.f83866o == 0) {
                h0(1);
            }
        }
    }
}
