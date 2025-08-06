package p039do;

import a7.e;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem;
import com.huobi.main.trade.bean.SafeguardDrawerItem;
import com.huobi.main.trade.enums.SafeguardType;
import com.huobi.main.trade.enums.TradeTabsType;
import com.huobi.utils.w;
import i6.b;
import i6.i;
import i6.m;
import i8.k;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import pro.huobi.R;
import sn.t;
import u6.g;

/* renamed from: do.y  reason: invalid package */
public class y extends a<co.a> implements ej.a, b.a {

    /* renamed from: j  reason: collision with root package name */
    public final List<ContractTagInfo.TagsGroupInfo.TagInfo> f83897j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f83898k;

    /* renamed from: l  reason: collision with root package name */
    public CopyOnWriteArrayList<s9.a> f83899l = new CopyOnWriteArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    public CopyOnWriteArrayList<s9.a> f83900m = new CopyOnWriteArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    public CopyOnWriteArrayList<s9.a> f83901n = new CopyOnWriteArrayList<>();

    /* renamed from: o  reason: collision with root package name */
    public List<String> f83902o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public int f83903p = 0;

    /* renamed from: q  reason: collision with root package name */
    public boolean f83904q = false;

    /* renamed from: r  reason: collision with root package name */
    public String f83905r = "";

    /* renamed from: s  reason: collision with root package name */
    public List<String> f83906s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    public i6.b f83907t;

    /* renamed from: u  reason: collision with root package name */
    public k.b f83908u = new d();

    /* renamed from: do.y$a */
    public class a extends EasySubscriber<List<String>> {
        public a() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            List unused = y.this.f83906s = list;
            y.this.f83907t.sendEmptyMessage(1);
            List x11 = y.this.D();
            if (y.this.f83903p == 0 && x11.isEmpty()) {
                y.this.A(1);
            }
        }
    }

    /* renamed from: do.y$b */
    public class b extends BaseSubscriber<ContractHeartBeat> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            y.this.f83907t.sendEmptyMessage(3);
        }
    }

    /* renamed from: do.y$c */
    public class c extends BaseSubscriber<List<FutureContractInfo>> {
        public c() {
        }

        public void onNext(List<FutureContractInfo> list) {
            super.onNext(list);
            y.this.f83907t.sendEmptyMessage(2);
        }
    }

    /* renamed from: do.y$d */
    public class d implements k.b {
        public d() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = list;
            y.this.f83907t.sendMessage(obtain);
        }
    }

    public y(Context context, co.a aVar, g gVar) {
        super(context, TradeType.LINEAR_SWAP, aVar, gVar);
        this.f83902o.add(context.getResources().getString(R.string.n_contract_market_collection));
        this.f83902o.add(context.getResources().getString(R.string.n_market_order_list_all));
        List<ContractTagInfo.TagsGroupInfo.TagInfo> e11 = w.d().e(true);
        this.f83897j = e11;
        for (ContractTagInfo.TagsGroupInfo.TagInfo next : e11) {
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                this.f83902o.add(next.h());
            } else {
                this.f83902o.add(next.i());
            }
        }
        int f11 = ConfigPreferences.f("user_config", "config_home_market_linear_swap_index");
        this.f83903p = f11;
        if (f11 >= this.f83902o.size()) {
            this.f83903p = 1;
        }
        this.f83904q = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.f83834g.clear();
        this.f83834g.addAll(this.f83901n);
        U();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f83834g.clear();
        this.f83834g.addAll(this.f83901n);
        U();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        this.f83834g.clear();
        this.f83834g.addAll(this.f83901n);
        U();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[Catch:{ Exception -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int O(int r11, s9.a r12, s9.a r13) {
        /*
            r0 = 1
            r1 = 1
            if (r11 == r0) goto L_0x0092
            r3 = 2
            if (r11 != r3) goto L_0x000a
            goto L_0x0092
        L_0x000a:
            r3 = 4636737291354636288(0x4059000000000000, double:100.0)
            boolean r0 = r12 instanceof com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x0048 }
            if (r0 == 0) goto L_0x0048
            r0 = r12
            com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem r0 = (com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem) r0     // Catch:{ Exception -> 0x0048 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r0 = r0.getSymbolPrice()     // Catch:{ Exception -> 0x0048 }
            java.lang.Double r0 = r0.getOpen()     // Catch:{ Exception -> 0x0048 }
            double r5 = r0.doubleValue()     // Catch:{ Exception -> 0x0048 }
            r0 = r12
            com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem r0 = (com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem) r0     // Catch:{ Exception -> 0x0048 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r0 = r0.getSymbolPrice()     // Catch:{ Exception -> 0x0048 }
            java.lang.Double r0 = r0.getClose()     // Catch:{ Exception -> 0x0048 }
            double r7 = r0.doubleValue()     // Catch:{ Exception -> 0x0048 }
            double r7 = r7 - r5
            double r7 = r7 / r5
            double r7 = r7 * r3
            com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem r12 = (com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x0048 }
            com.hbg.lib.data.future.bean.FutureContractInfo r12 = r12.e()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r12 = r12.getSymbol()     // Catch:{ Exception -> 0x0048 }
            int r12 = com.hbg.lib.data.symbol.PrecisionUtil.v(r12)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r12 = i6.m.i(r7, r12)     // Catch:{ Exception -> 0x0048 }
            double r5 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0049
        L_0x0048:
            r5 = r1
        L_0x0049:
            boolean r12 = r13 instanceof com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x0085 }
            if (r12 == 0) goto L_0x0085
            r12 = r13
            com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem r12 = (com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x0085 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x0085 }
            java.lang.Double r12 = r12.getOpen()     // Catch:{ Exception -> 0x0085 }
            double r7 = r12.doubleValue()     // Catch:{ Exception -> 0x0085 }
            r12 = r13
            com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem r12 = (com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x0085 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x0085 }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x0085 }
            double r9 = r12.doubleValue()     // Catch:{ Exception -> 0x0085 }
            double r9 = r9 - r7
            double r9 = r9 / r7
            double r9 = r9 * r3
            com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem r13 = (com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem) r13     // Catch:{ Exception -> 0x0085 }
            com.hbg.lib.data.future.bean.FutureContractInfo r12 = r13.e()     // Catch:{ Exception -> 0x0085 }
            java.lang.String r12 = r12.getSymbol()     // Catch:{ Exception -> 0x0085 }
            int r12 = com.hbg.lib.data.symbol.PrecisionUtil.v(r12)     // Catch:{ Exception -> 0x0085 }
            java.lang.String r12 = i6.m.i(r9, r12)     // Catch:{ Exception -> 0x0085 }
            double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x0085 }
            r1 = r12
        L_0x0085:
            r12 = 3
            if (r11 != r12) goto L_0x008d
            int r11 = java.lang.Double.compare(r1, r5)
            goto L_0x0091
        L_0x008d:
            int r11 = java.lang.Double.compare(r5, r1)
        L_0x0091:
            return r11
        L_0x0092:
            boolean r3 = r12 instanceof com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x00a4 }
            if (r3 == 0) goto L_0x00a4
            com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem r12 = (com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x00a4 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x00a4 }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x00a4 }
            double r1 = r12.doubleValue()     // Catch:{ Exception -> 0x00a4 }
        L_0x00a4:
            r3 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            boolean r12 = r13 instanceof com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x00b9 }
            if (r12 == 0) goto L_0x00b9
            com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem r13 = (com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem) r13     // Catch:{ Exception -> 0x00b9 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r13.getSymbolPrice()     // Catch:{ Exception -> 0x00b9 }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x00b9 }
            double r12 = r12.doubleValue()     // Catch:{ Exception -> 0x00b9 }
            r3 = r12
        L_0x00b9:
            if (r11 != r0) goto L_0x00c0
            int r11 = java.lang.Double.compare(r3, r1)
            goto L_0x00c4
        L_0x00c0:
            int r11 = java.lang.Double.compare(r1, r3)
        L_0x00c4:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p039do.y.O(int, s9.a, s9.a):int");
    }

    public void A(int i11) {
        this.f83903p = i11;
        this.f83907t.sendEmptyMessage(6);
        ((co.a) h()).y7(this.f83903p);
        Q(i11);
    }

    public void B() {
        this.f83905r = "";
    }

    public final List<s9.a> C() {
        ArrayList arrayList = new ArrayList();
        Iterator<s9.a> it2 = this.f83899l.iterator();
        while (it2.hasNext()) {
            s9.a next = it2.next();
            if (next instanceof bo.b) {
                arrayList.add(next);
            } else if (next instanceof LinearSwapCurrencyInfoDrawerItem) {
                arrayList.add(next);
            }
        }
        ContractHeartBeat d11 = bj.d.d();
        if (d11 != null && bj.d.t()) {
            SafeguardDrawerItem safeguardDrawerItem = new SafeguardDrawerItem();
            safeguardDrawerItem.h(((co.a) h()).G2());
            safeguardDrawerItem.i(SafeguardType.SAFEGUARD_ALL);
            safeguardDrawerItem.j(String.format(g(R.string.n_function_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getLinearSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
            arrayList.add(0, safeguardDrawerItem);
        }
        return arrayList;
    }

    public final List<s9.a> D() {
        List<String> list = this.f83906s;
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<s9.a> it2 = this.f83899l.iterator();
        while (it2.hasNext()) {
            s9.a next = it2.next();
            if (next instanceof LinearSwapCurrencyInfoDrawerItem) {
                if (this.f83906s.contains(((LinearSwapCurrencyInfoDrawerItem) next).e().getContractShortType())) {
                    arrayList.add(next);
                }
            }
        }
        ContractHeartBeat d11 = bj.d.d();
        if (d11 != null && bj.d.t()) {
            SafeguardDrawerItem safeguardDrawerItem = new SafeguardDrawerItem();
            safeguardDrawerItem.h(((co.a) h()).G2());
            safeguardDrawerItem.i(SafeguardType.SAFEGUARD_ALL);
            safeguardDrawerItem.j(String.format(g(R.string.n_function_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getLinearSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
            arrayList.add(0, safeguardDrawerItem);
        }
        return arrayList;
    }

    public final List<s9.a> E() {
        ArrayList arrayList = new ArrayList();
        int i11 = this.f83903p;
        if (i11 == 0) {
            this.f83832e = TradeTabsType.COLLECTION;
            arrayList.addAll(D());
        } else if (i11 == 1) {
            this.f83832e = TradeTabsType.OTHER;
            arrayList.addAll(C());
        } else {
            this.f83832e = TradeTabsType.OTHER;
            if (i11 - 2 < this.f83897j.size()) {
                arrayList.addAll(F(this.f83897j.get(this.f83903p - 2).e()));
            }
        }
        return arrayList;
    }

    public final List<s9.a> F(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<s9.a> it2 = this.f83899l.iterator();
            while (it2.hasNext()) {
                s9.a next = it2.next();
                if ((next instanceof LinearSwapCurrencyInfoDrawerItem) && list.contains(((LinearSwapCurrencyInfoDrawerItem) next).e().getSymbol())) {
                    arrayList.add(next);
                }
            }
        }
        ContractHeartBeat d11 = bj.d.d();
        if (d11 != null && bj.d.t()) {
            SafeguardDrawerItem safeguardDrawerItem = new SafeguardDrawerItem();
            safeguardDrawerItem.h(((co.a) h()).G2());
            safeguardDrawerItem.i(SafeguardType.SAFEGUARD_ALL);
            safeguardDrawerItem.j(String.format(g(R.string.n_function_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getLinearSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
            arrayList.add(0, safeguardDrawerItem);
        }
        return arrayList;
    }

    public final void G() {
        t.s(false, this.f83829b).compose(RxJavaHelper.t(j())).subscribe(new a());
    }

    public final void H() {
        bj.d.p().compose(RxJavaHelper.t(j())).subscribe(new b());
        FutureContractInfoController.n().q(false).compose(RxJavaHelper.t(j())).subscribe(new c());
    }

    public int I() {
        return this.f83903p;
    }

    public final void J(List<SymbolPrice> list) {
        Iterator it2;
        double d11;
        ArrayList arrayList = new ArrayList(list);
        ArrayList<s9.a> arrayList2 = new ArrayList<>(this.f83899l);
        String str = "--";
        String str2 = str;
        for (s9.a aVar : arrayList2) {
            for (Iterator it3 = arrayList.iterator(); it3.hasNext(); it3 = it2) {
                SymbolPrice symbolPrice = (SymbolPrice) it3.next();
                if (aVar instanceof LinearSwapCurrencyInfoDrawerItem) {
                    LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem = (LinearSwapCurrencyInfoDrawerItem) aVar;
                    if (linearSwapCurrencyInfoDrawerItem.e().getContractShortType().equals(symbolPrice.getSymbol())) {
                        linearSwapCurrencyInfoDrawerItem.p(symbolPrice);
                        Double close = symbolPrice.getClose();
                        if (close != null) {
                            str = m.m(String.valueOf(close), FuturePrecisionUtil.y(linearSwapCurrencyInfoDrawerItem.e().getContractCode(), linearSwapCurrencyInfoDrawerItem.e().getContractShortType(), linearSwapCurrencyInfoDrawerItem.e().getOptionCode()));
                            Double open = symbolPrice.getOpen();
                            if (open != null) {
                                d11 = close.doubleValue() - open.doubleValue();
                                it2 = it3;
                            } else {
                                it2 = it3;
                                d11 = 0.0d;
                            }
                            if (Double.compare(close.doubleValue(), 0.0d) != 0) {
                                boolean z11 = Double.compare(d11, 0.0d) > 0;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(z11 ? "+" : "");
                                sb2.append(m.i((d11 / open.doubleValue()) * 100.0d, PrecisionUtil.v(linearSwapCurrencyInfoDrawerItem.e().getSymbol())));
                                sb2.append("%");
                                str2 = sb2.toString();
                            }
                        } else {
                            it2 = it3;
                        }
                        linearSwapCurrencyInfoDrawerItem.k(str2);
                        linearSwapCurrencyInfoDrawerItem.o(str);
                    }
                }
                it2 = it3;
            }
        }
        this.f83899l.clear();
        this.f83899l.addAll(arrayList2);
        if (this.f83900m.size() == 0) {
            this.f83900m.addAll(this.f83899l);
        }
        n(this.f83836i, false);
    }

    /* renamed from: P */
    public final void K(List<s9.a> list) {
        boolean z11 = list == null || list.isEmpty();
        if (!this.f83904q && this.f83903p == 0 && z11) {
            A(1);
        }
    }

    public final void Q(int i11) {
        String str;
        switch (i11) {
            case 0:
                str = "optional";
                break;
            case 1:
                str = TtmlNode.COMBINE_ALL;
                break;
            case 2:
                str = "usdt_sustainable";
                break;
            case 3:
                str = "this_week";
                break;
            case 4:
                str = "next_week";
                break;
            case 5:
                str = "this_quarter";
                break;
            case 6:
                str = "next_quarter";
                break;
            default:
                str = "";
                break;
        }
        gs.g.j("switchover_coin_pair", "usdt_contract", str, (HashMap) null);
    }

    public void R(String str) {
        this.f83905r = str;
        this.f83907t.sendEmptyMessage(5);
    }

    public void S(TradeType tradeType, String str, SafeguardType safeguardType) {
        ((co.a) h()).gg(tradeType, str, safeguardType);
    }

    public final void T() {
        List<s9.a> E = E();
        this.f83901n.clear();
        if (!TextUtils.isEmpty(this.f83905r)) {
            int size = E.size();
            String str = "";
            for (int i11 = 0; i11 < size; i11++) {
                s9.a aVar = E.get(i11);
                if (aVar instanceof LinearSwapCurrencyInfoDrawerItem) {
                    LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem = (LinearSwapCurrencyInfoDrawerItem) aVar;
                    str = e.v(this.f83829b, linearSwapCurrencyInfoDrawerItem.e().getSymbol(), linearSwapCurrencyInfoDrawerItem.e().getQuoteCurrency(), linearSwapCurrencyInfoDrawerItem.e().getContractCode(), linearSwapCurrencyInfoDrawerItem.e().getContractType());
                } else if (aVar instanceof SafeguardDrawerItem) {
                    this.f83901n.add(aVar);
                }
                i6.d.b(str);
                if (!TextUtils.isEmpty(str) && str.contains(this.f83905r) && !(aVar instanceof bo.b)) {
                    this.f83901n.add(aVar);
                }
            }
            return;
        }
        this.f83901n.addAll(E);
    }

    public final void U() {
        s9.a aVar = !this.f83834g.isEmpty() ? this.f83834g.get(0) : null;
        if (aVar == null || !(aVar instanceof SafeguardDrawerItem)) {
            S(this.f83831d, "", SafeguardType.SAFEGUARD_NONE);
        } else {
            S(this.f83831d, "", SafeguardType.SAFEGUARD_ALL);
        }
        p();
        this.f83904q = true;
    }

    public boolean a(s9.a aVar) {
        if (!(aVar instanceof LinearSwapCurrencyInfoDrawerItem) || !(((co.a) h()).R5() instanceof LinearSwapCurrencyInfoDrawerItem)) {
            return false;
        }
        LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem = (LinearSwapCurrencyInfoDrawerItem) ((co.a) h()).R5();
        LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem2 = (LinearSwapCurrencyInfoDrawerItem) aVar;
        if (linearSwapCurrencyInfoDrawerItem.e() == null || linearSwapCurrencyInfoDrawerItem.e().getContractCode() == null || linearSwapCurrencyInfoDrawerItem2.e() == null) {
            return false;
        }
        return linearSwapCurrencyInfoDrawerItem.e().getContractCode().equals(linearSwapCurrencyInfoDrawerItem2.e().getContractCode());
    }

    public void e(s9.a aVar) {
        if (h() != null) {
            ((co.a) h()).a(this.f83831d, aVar);
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                i.b().f(new w(this, D()));
                return;
            case 2:
            case 3:
                z();
                J(k.g().f());
                T();
                i.b().f(new t(this));
                return;
            case 4:
                J((List) message.obj);
                T();
                i.b().f(new u(this));
                return;
            case 5:
            case 6:
                T();
                i.b().f(new v(this));
                return;
            default:
                return;
        }
    }

    public void k() {
        i6.d.b("LinearSwapTradeDataProvider-->register-->");
        if (!this.f83898k) {
            this.f83907t = new i6.b("LinearSwapTradeDataProvider", this);
            G();
            B();
            p();
            k.g().e("linear_swap_overview_provider_tag", this.f83908u);
            k.g().i();
            this.f83898k = true;
            H();
            A(this.f83903p);
        }
    }

    public void l() {
    }

    public void n(int i11, boolean z11) {
        super.n(i11, z11);
        if (i11 == 0) {
            try {
                this.f83899l.clear();
                this.f83899l.addAll(this.f83900m);
                if (z11) {
                    T();
                    this.f83834g.clear();
                    this.f83834g.addAll(this.f83901n);
                    U();
                }
            } catch (Throwable th2) {
                PrintStream printStream = System.out;
                printStream.println("LinearSwapSortListError==>> " + th2.getMessage());
            }
        } else {
            Collections.sort(this.f83899l, new x(i11));
            if (z11) {
                T();
                this.f83834g.clear();
                this.f83834g.addAll(this.f83901n);
                U();
            }
        }
    }

    public void o() {
        i6.d.b("LinearSwapTradeDataProvider-->unregister-->");
        if (this.f83898k) {
            this.f83898k = false;
            k.g().j("linear_swap_overview_provider_tag");
            k.g().n();
        }
    }

    public void p() {
        if (h() != null) {
            ((co.a) h()).xa(this.f83831d, TradeTabsType.getTabsType(this.f83832e, this.f83905r), this.f83902o, this.f83834g);
        }
    }

    public final void z() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean t11 = bj.d.t();
        List<FutureContractInfo> f11 = FutureContractInfoController.n().f();
        this.f83899l.clear();
        ContractHeartBeat d11 = bj.d.d();
        if (d11 != null && t11) {
            SafeguardDrawerItem safeguardDrawerItem = new SafeguardDrawerItem();
            safeguardDrawerItem.h(((co.a) h()).G2());
            safeguardDrawerItem.i(SafeguardType.SAFEGUARD_ALL);
            safeguardDrawerItem.j(String.format(g(R.string.n_function_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getLinearSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
            this.f83899l.add(safeguardDrawerItem);
        }
        if (!t11) {
            linkedHashSet.addAll(FutureContractInfoController.n().t(TradeType.LINEAR_SWAP));
        }
        Iterator it2 = linkedHashSet.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (f11 != null && !t11) {
                for (FutureContractInfo next : f11) {
                    if (next.getSymbol().equals(str)) {
                        LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem = new LinearSwapCurrencyInfoDrawerItem();
                        if (next.isLinearSwapSwap()) {
                            linearSwapCurrencyInfoDrawerItem.q(100);
                            try {
                                int i12 = i11 + 1;
                                try {
                                    this.f83899l.add(i11, linearSwapCurrencyInfoDrawerItem);
                                    i11 = i12;
                                } catch (Throwable unused) {
                                    i11 = i12;
                                    this.f83899l.add(linearSwapCurrencyInfoDrawerItem);
                                    linearSwapCurrencyInfoDrawerItem.l(next);
                                    linearSwapCurrencyInfoDrawerItem.n(true);
                                    linearSwapCurrencyInfoDrawerItem.j(this);
                                    linearSwapCurrencyInfoDrawerItem.m(((co.a) h()).G2());
                                    linearSwapCurrencyInfoDrawerItem.o("--");
                                    linearSwapCurrencyInfoDrawerItem.k("--");
                                }
                            } catch (Throwable unused2) {
                                this.f83899l.add(linearSwapCurrencyInfoDrawerItem);
                                linearSwapCurrencyInfoDrawerItem.l(next);
                                linearSwapCurrencyInfoDrawerItem.n(true);
                                linearSwapCurrencyInfoDrawerItem.j(this);
                                linearSwapCurrencyInfoDrawerItem.m(((co.a) h()).G2());
                                linearSwapCurrencyInfoDrawerItem.o("--");
                                linearSwapCurrencyInfoDrawerItem.k("--");
                            }
                        } else {
                            linearSwapCurrencyInfoDrawerItem.q(90);
                            this.f83899l.add(linearSwapCurrencyInfoDrawerItem);
                        }
                        linearSwapCurrencyInfoDrawerItem.l(next);
                        linearSwapCurrencyInfoDrawerItem.n(true);
                        linearSwapCurrencyInfoDrawerItem.j(this);
                        linearSwapCurrencyInfoDrawerItem.m(((co.a) h()).G2());
                        linearSwapCurrencyInfoDrawerItem.o("--");
                        linearSwapCurrencyInfoDrawerItem.k("--");
                    }
                }
            }
        }
        this.f83900m.clear();
        this.f83900m.addAll(this.f83899l);
        n(this.f83836i, false);
    }
}
