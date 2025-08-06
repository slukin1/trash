package p039do;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huobi.contract.entity.ContractCurrencyInfoDrawerItem;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.main.trade.bean.SafeguardDrawerItem;
import com.huobi.main.trade.bean.SingleSafeguardDrawerItem;
import com.huobi.main.trade.enums.SafeguardType;
import com.huobi.main.trade.enums.TradeTabsType;
import com.huobi.swap.bean.SwapCurrencyInfoDrawerItem;
import com.huobi.utils.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import m9.r;
import o6.b;
import pro.huobi.R;
import rx.Subscription;
import sn.t;
import u6.g;
import us.j;

/* renamed from: do.d  reason: invalid package */
public class d extends a<co.a> implements ej.a {

    /* renamed from: j  reason: collision with root package name */
    public final List<ContractTagInfo.TagsGroupInfo.TagInfo> f83837j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f83838k;

    /* renamed from: l  reason: collision with root package name */
    public CopyOnWriteArrayList<s9.a> f83839l = new CopyOnWriteArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    public CopyOnWriteArrayList<s9.a> f83840m = new CopyOnWriteArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    public Subscription f83841n;

    /* renamed from: o  reason: collision with root package name */
    public List<String> f83842o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public int f83843p = 0;

    /* renamed from: q  reason: collision with root package name */
    public boolean f83844q = false;

    /* renamed from: r  reason: collision with root package name */
    public String f83845r = "";

    /* renamed from: s  reason: collision with root package name */
    public List<String> f83846s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    public b.C0747b f83847t = new e();

    /* renamed from: u  reason: collision with root package name */
    public r.b f83848u = new f();

    /* renamed from: do.d$a */
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
            List unused = d.this.f83846s = list;
            List s11 = d.this.B();
            if (d.this.f83843p == 0 && s11.isEmpty()) {
                d.this.y(1);
            }
        }
    }

    /* renamed from: do.d$b */
    public class b extends BaseSubscriber<ContractHeartBeat> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            d.this.x();
            d.this.H(r.g().f());
            d.this.H(o6.b.g().f());
            d.this.N();
        }
    }

    /* renamed from: do.d$c */
    public class c extends BaseSubscriber<List<ContractCurrencyInfo>> {
        public c() {
        }

        public void onNext(List<ContractCurrencyInfo> list) {
            super.onNext(list);
            d.this.x();
            d.this.H(r.g().f());
            d.this.H(o6.b.g().f());
            d.this.N();
        }
    }

    /* renamed from: do.d$d  reason: collision with other inner class name */
    public class C0861d extends BaseSubscriber<List<SwapCurrencyInfo>> {
        public C0861d() {
        }

        public void onNext(List<SwapCurrencyInfo> list) {
            super.onNext(list);
            d.this.x();
            d.this.H(r.g().f());
            d.this.H(o6.b.g().f());
            d.this.N();
        }
    }

    /* renamed from: do.d$e */
    public class e implements b.C0747b {
        public e() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            d.this.H(list);
            d.this.f83834g.clear();
            d.this.N();
            d.this.p();
        }
    }

    /* renamed from: do.d$f */
    public class f implements r.b {
        public f() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            d.this.H(list);
            d.this.f83834g.clear();
            d.this.N();
            d.this.p();
        }
    }

    public d(Context context, co.a aVar, g gVar) {
        super(context, TradeType.CONTRACT, aVar, gVar);
        this.f83842o.add(context.getResources().getString(R.string.n_contract_market_collection));
        this.f83842o.add(context.getResources().getString(R.string.n_market_order_list_all));
        List<ContractTagInfo.TagsGroupInfo.TagInfo> e11 = w.d().e(false);
        this.f83837j = e11;
        for (ContractTagInfo.TagsGroupInfo.TagInfo next : e11) {
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                this.f83842o.add(next.h());
            } else {
                this.f83842o.add(next.i());
            }
        }
        int f11 = ConfigPreferences.f("user_config", "config_home_market_contract_index");
        this.f83843p = f11;
        if (f11 >= this.f83842o.size()) {
            this.f83843p = 1;
        }
        this.f83844q = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ int I(int r11, s9.a r12, s9.a r13) {
        /*
            r0 = 1
            r1 = 1
            if (r11 == r0) goto L_0x0125
            r3 = 2
            if (r11 != r3) goto L_0x000a
            goto L_0x0125
        L_0x000a:
            r3 = 4636737291354636288(0x4059000000000000, double:100.0)
            boolean r0 = r12 instanceof com.huobi.swap.bean.SwapCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x008e }
            if (r0 == 0) goto L_0x0048
            r0 = r12
            com.huobi.swap.bean.SwapCurrencyInfoDrawerItem r0 = (com.huobi.swap.bean.SwapCurrencyInfoDrawerItem) r0     // Catch:{ Exception -> 0x008e }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r0 = r0.getSymbolPrice()     // Catch:{ Exception -> 0x008e }
            java.lang.Double r0 = r0.getOpen()     // Catch:{ Exception -> 0x008e }
            double r5 = r0.doubleValue()     // Catch:{ Exception -> 0x008e }
            r0 = r12
            com.huobi.swap.bean.SwapCurrencyInfoDrawerItem r0 = (com.huobi.swap.bean.SwapCurrencyInfoDrawerItem) r0     // Catch:{ Exception -> 0x008e }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r0 = r0.getSymbolPrice()     // Catch:{ Exception -> 0x008e }
            java.lang.Double r0 = r0.getClose()     // Catch:{ Exception -> 0x008e }
            double r7 = r0.doubleValue()     // Catch:{ Exception -> 0x008e }
            double r7 = r7 - r5
            double r7 = r7 / r5
            double r7 = r7 * r3
            com.huobi.swap.bean.SwapCurrencyInfoDrawerItem r12 = (com.huobi.swap.bean.SwapCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x008e }
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r12 = r12.d()     // Catch:{ Exception -> 0x008e }
            java.lang.String r12 = r12.getSymbol()     // Catch:{ Exception -> 0x008e }
            int r12 = com.hbg.lib.data.symbol.PrecisionUtil.v(r12)     // Catch:{ Exception -> 0x008e }
            java.lang.String r12 = i6.m.i(r7, r12)     // Catch:{ Exception -> 0x008e }
            double r5 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x008e }
            goto L_0x0093
        L_0x0048:
            boolean r0 = r12 instanceof com.huobi.contract.entity.ContractCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x008e }
            if (r0 == 0) goto L_0x008c
            r0 = r12
            com.huobi.contract.entity.ContractCurrencyInfoDrawerItem r0 = (com.huobi.contract.entity.ContractCurrencyInfoDrawerItem) r0     // Catch:{ Exception -> 0x008e }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r0 = r0.d()     // Catch:{ Exception -> 0x008e }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r0 = r0.getSymbolPrice()     // Catch:{ Exception -> 0x008e }
            java.lang.Double r0 = r0.getOpen()     // Catch:{ Exception -> 0x008e }
            double r5 = r0.doubleValue()     // Catch:{ Exception -> 0x008e }
            r0 = r12
            com.huobi.contract.entity.ContractCurrencyInfoDrawerItem r0 = (com.huobi.contract.entity.ContractCurrencyInfoDrawerItem) r0     // Catch:{ Exception -> 0x008e }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r0 = r0.d()     // Catch:{ Exception -> 0x008e }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r0 = r0.getSymbolPrice()     // Catch:{ Exception -> 0x008e }
            java.lang.Double r0 = r0.getClose()     // Catch:{ Exception -> 0x008e }
            double r7 = r0.doubleValue()     // Catch:{ Exception -> 0x008e }
            double r7 = r7 - r5
            double r7 = r7 / r5
            double r7 = r7 * r3
            com.huobi.contract.entity.ContractCurrencyInfoDrawerItem r12 = (com.huobi.contract.entity.ContractCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x008e }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r12 = r12.d()     // Catch:{ Exception -> 0x008e }
            java.lang.String r12 = r12.getSymbol()     // Catch:{ Exception -> 0x008e }
            int r12 = com.hbg.lib.data.symbol.PrecisionUtil.v(r12)     // Catch:{ Exception -> 0x008e }
            java.lang.String r12 = i6.m.i(r7, r12)     // Catch:{ Exception -> 0x008e }
            double r5 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x008e }
            goto L_0x0093
        L_0x008c:
            r5 = r1
            goto L_0x0093
        L_0x008e:
            r12 = move-exception
            r12.printStackTrace()
            goto L_0x008c
        L_0x0093:
            boolean r12 = r13 instanceof com.huobi.swap.bean.SwapCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x0114 }
            if (r12 == 0) goto L_0x00d0
            r12 = r13
            com.huobi.swap.bean.SwapCurrencyInfoDrawerItem r12 = (com.huobi.swap.bean.SwapCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x0114 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x0114 }
            java.lang.Double r12 = r12.getOpen()     // Catch:{ Exception -> 0x0114 }
            double r7 = r12.doubleValue()     // Catch:{ Exception -> 0x0114 }
            r12 = r13
            com.huobi.swap.bean.SwapCurrencyInfoDrawerItem r12 = (com.huobi.swap.bean.SwapCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x0114 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x0114 }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x0114 }
            double r9 = r12.doubleValue()     // Catch:{ Exception -> 0x0114 }
            double r9 = r9 - r7
            double r9 = r9 / r7
            double r9 = r9 * r3
            com.huobi.swap.bean.SwapCurrencyInfoDrawerItem r13 = (com.huobi.swap.bean.SwapCurrencyInfoDrawerItem) r13     // Catch:{ Exception -> 0x0114 }
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r12 = r13.d()     // Catch:{ Exception -> 0x0114 }
            java.lang.String r12 = r12.getSymbol()     // Catch:{ Exception -> 0x0114 }
            int r12 = com.hbg.lib.data.symbol.PrecisionUtil.v(r12)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r12 = i6.m.i(r9, r12)     // Catch:{ Exception -> 0x0114 }
            double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x0114 }
        L_0x00ce:
            r1 = r12
            goto L_0x0118
        L_0x00d0:
            boolean r12 = r13 instanceof com.huobi.contract.entity.ContractCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x0114 }
            if (r12 == 0) goto L_0x0118
            r12 = r13
            com.huobi.contract.entity.ContractCurrencyInfoDrawerItem r12 = (com.huobi.contract.entity.ContractCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x0114 }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r12 = r12.d()     // Catch:{ Exception -> 0x0114 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x0114 }
            java.lang.Double r12 = r12.getOpen()     // Catch:{ Exception -> 0x0114 }
            double r7 = r12.doubleValue()     // Catch:{ Exception -> 0x0114 }
            r12 = r13
            com.huobi.contract.entity.ContractCurrencyInfoDrawerItem r12 = (com.huobi.contract.entity.ContractCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x0114 }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r12 = r12.d()     // Catch:{ Exception -> 0x0114 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x0114 }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x0114 }
            double r9 = r12.doubleValue()     // Catch:{ Exception -> 0x0114 }
            double r9 = r9 - r7
            double r9 = r9 / r7
            double r9 = r9 * r3
            com.huobi.contract.entity.ContractCurrencyInfoDrawerItem r13 = (com.huobi.contract.entity.ContractCurrencyInfoDrawerItem) r13     // Catch:{ Exception -> 0x0114 }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r12 = r13.d()     // Catch:{ Exception -> 0x0114 }
            java.lang.String r12 = r12.getSymbol()     // Catch:{ Exception -> 0x0114 }
            int r12 = com.hbg.lib.data.symbol.PrecisionUtil.v(r12)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r12 = i6.m.i(r9, r12)     // Catch:{ Exception -> 0x0114 }
            double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x0114 }
            goto L_0x00ce
        L_0x0114:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0118:
            r12 = 3
            if (r11 != r12) goto L_0x0120
            int r11 = java.lang.Double.compare(r1, r5)
            goto L_0x0124
        L_0x0120:
            int r11 = java.lang.Double.compare(r5, r1)
        L_0x0124:
            return r11
        L_0x0125:
            boolean r3 = r12 instanceof com.huobi.swap.bean.SwapCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x014f }
            if (r3 == 0) goto L_0x0138
            com.huobi.swap.bean.SwapCurrencyInfoDrawerItem r12 = (com.huobi.swap.bean.SwapCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x014f }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x014f }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x014f }
            double r1 = r12.doubleValue()     // Catch:{ Exception -> 0x014f }
            goto L_0x0153
        L_0x0138:
            boolean r3 = r12 instanceof com.huobi.contract.entity.ContractCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x014f }
            if (r3 == 0) goto L_0x0153
            com.huobi.contract.entity.ContractCurrencyInfoDrawerItem r12 = (com.huobi.contract.entity.ContractCurrencyInfoDrawerItem) r12     // Catch:{ Exception -> 0x014f }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r12 = r12.d()     // Catch:{ Exception -> 0x014f }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x014f }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x014f }
            double r1 = r12.doubleValue()     // Catch:{ Exception -> 0x014f }
            goto L_0x0153
        L_0x014f:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0153:
            r3 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            boolean r12 = r13 instanceof com.huobi.swap.bean.SwapCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x0180 }
            if (r12 == 0) goto L_0x0169
            com.huobi.swap.bean.SwapCurrencyInfoDrawerItem r13 = (com.huobi.swap.bean.SwapCurrencyInfoDrawerItem) r13     // Catch:{ Exception -> 0x0180 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r13.getSymbolPrice()     // Catch:{ Exception -> 0x0180 }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x0180 }
            double r12 = r12.doubleValue()     // Catch:{ Exception -> 0x0180 }
        L_0x0167:
            r3 = r12
            goto L_0x0184
        L_0x0169:
            boolean r12 = r13 instanceof com.huobi.contract.entity.ContractCurrencyInfoDrawerItem     // Catch:{ Exception -> 0x0180 }
            if (r12 == 0) goto L_0x0184
            com.huobi.contract.entity.ContractCurrencyInfoDrawerItem r13 = (com.huobi.contract.entity.ContractCurrencyInfoDrawerItem) r13     // Catch:{ Exception -> 0x0180 }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r12 = r13.d()     // Catch:{ Exception -> 0x0180 }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r12 = r12.getSymbolPrice()     // Catch:{ Exception -> 0x0180 }
            java.lang.Double r12 = r12.getClose()     // Catch:{ Exception -> 0x0180 }
            double r12 = r12.doubleValue()     // Catch:{ Exception -> 0x0180 }
            goto L_0x0167
        L_0x0180:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0184:
            if (r11 != r0) goto L_0x018b
            int r11 = java.lang.Double.compare(r3, r1)
            goto L_0x018f
        L_0x018b:
            int r11 = java.lang.Double.compare(r1, r3)
        L_0x018f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p039do.d.I(int, s9.a, s9.a):int");
    }

    public final List<s9.a> A(List<String> list) {
        ArrayList arrayList = new ArrayList();
        int size = this.f83839l.size();
        for (int i11 = 0; i11 < size; i11++) {
            s9.a aVar = this.f83839l.get(i11);
            if (aVar instanceof bo.b) {
                if (list == null) {
                    arrayList.add(aVar);
                } else if (list.contains(((bo.b) aVar).e())) {
                    arrayList.add(aVar);
                }
            } else if (aVar instanceof ContractCurrencyInfoDrawerItem) {
                if (list == null) {
                    arrayList.add(aVar);
                } else if (list.contains(((ContractCurrencyInfoDrawerItem) aVar).d().getSymbol())) {
                    arrayList.add(aVar);
                }
            } else if (aVar instanceof SwapCurrencyInfoDrawerItem) {
                if (list == null) {
                    arrayList.add(aVar);
                } else if (list.contains(((SwapCurrencyInfoDrawerItem) aVar).d().getSymbol())) {
                    arrayList.add(aVar);
                }
            }
        }
        ContractHeartBeat d11 = bj.d.d();
        if (d11 != null) {
            if (bj.d.s() && !bj.d.x()) {
                SingleSafeguardDrawerItem singleSafeguardDrawerItem = new SingleSafeguardDrawerItem();
                singleSafeguardDrawerItem.f(((co.a) h()).G2());
                singleSafeguardDrawerItem.h(SafeguardType.SAFEGUARD_TIPS);
                singleSafeguardDrawerItem.g(String.format(g(R.string.n_contract_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getTime(), "yyyy/MM/dd HH:mm")}));
                arrayList.add(0, singleSafeguardDrawerItem);
            } else if (!bj.d.s() && bj.d.x()) {
                SingleSafeguardDrawerItem singleSafeguardDrawerItem2 = new SingleSafeguardDrawerItem();
                singleSafeguardDrawerItem2.f(((co.a) h()).G2());
                singleSafeguardDrawerItem2.h(SafeguardType.SAFEGUARD_TIPS);
                singleSafeguardDrawerItem2.g(String.format(g(R.string.n_swap_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
                arrayList.add(0, singleSafeguardDrawerItem2);
            } else if (bj.d.s() && bj.d.x()) {
                SafeguardDrawerItem safeguardDrawerItem = new SafeguardDrawerItem();
                safeguardDrawerItem.h(((co.a) h()).G2());
                safeguardDrawerItem.i(SafeguardType.SAFEGUARD_ALL);
                safeguardDrawerItem.g(String.format(g(R.string.n_contract_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getTime(), "yyyy/MM/dd HH:mm")}));
                safeguardDrawerItem.j(String.format(g(R.string.n_swap_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
                arrayList.add(0, safeguardDrawerItem);
            }
        }
        return arrayList;
    }

    public final List<s9.a> B() {
        List<String> list = this.f83846s;
        if (list == null || list.isEmpty()) {
            J((List<s9.a>) null);
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<s9.a> it2 = this.f83839l.iterator();
        while (it2.hasNext()) {
            s9.a next = it2.next();
            if (next instanceof SwapCurrencyInfoDrawerItem) {
                SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem = (SwapCurrencyInfoDrawerItem) next;
                if (this.f83846s.contains(swapCurrencyInfoDrawerItem.d().getContractShortType())) {
                    arrayList.add(swapCurrencyInfoDrawerItem);
                }
            } else if (next instanceof ContractCurrencyInfoDrawerItem) {
                ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = (ContractCurrencyInfoDrawerItem) next;
                if (this.f83846s.contains(contractCurrencyInfoDrawerItem.d().getContractShortType())) {
                    arrayList.add(contractCurrencyInfoDrawerItem);
                }
            }
        }
        J(arrayList);
        ContractHeartBeat d11 = bj.d.d();
        if (d11 != null) {
            if (bj.d.s() && !bj.d.x()) {
                SingleSafeguardDrawerItem singleSafeguardDrawerItem = new SingleSafeguardDrawerItem();
                singleSafeguardDrawerItem.f(((co.a) h()).G2());
                singleSafeguardDrawerItem.h(SafeguardType.SAFEGUARD_TIPS);
                singleSafeguardDrawerItem.g(String.format(g(R.string.n_contract_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getTime(), "yyyy/MM/dd HH:mm")}));
                arrayList.add(0, singleSafeguardDrawerItem);
            } else if (!bj.d.s() && bj.d.x()) {
                SingleSafeguardDrawerItem singleSafeguardDrawerItem2 = new SingleSafeguardDrawerItem();
                singleSafeguardDrawerItem2.f(((co.a) h()).G2());
                singleSafeguardDrawerItem2.h(SafeguardType.SAFEGUARD_TIPS);
                singleSafeguardDrawerItem2.g(String.format(g(R.string.n_swap_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
                arrayList.add(0, singleSafeguardDrawerItem2);
            } else if (bj.d.s() && bj.d.x()) {
                SafeguardDrawerItem safeguardDrawerItem = new SafeguardDrawerItem();
                safeguardDrawerItem.h(((co.a) h()).G2());
                safeguardDrawerItem.i(SafeguardType.SAFEGUARD_ALL);
                safeguardDrawerItem.g(String.format(g(R.string.n_contract_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getTime(), "yyyy/MM/dd HH:mm")}));
                safeguardDrawerItem.j(String.format(g(R.string.n_swap_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
                arrayList.add(0, safeguardDrawerItem);
            }
        }
        return arrayList;
    }

    public final List<s9.a> C(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i11 = 0; i11 < this.f83839l.size(); i11++) {
                s9.a aVar = this.f83839l.get(i11);
                if (aVar instanceof ContractCurrencyInfoDrawerItem) {
                    if (list.contains(((ContractCurrencyInfoDrawerItem) aVar).d().getSymbol())) {
                        arrayList.add(aVar);
                    }
                } else if ((aVar instanceof SwapCurrencyInfoDrawerItem) && list.contains(((SwapCurrencyInfoDrawerItem) aVar).d().getSymbol())) {
                    arrayList.add(aVar);
                }
            }
        }
        ContractHeartBeat d11 = bj.d.d();
        if (d11 != null && (bj.d.s() || bj.d.x())) {
            SafeguardDrawerItem safeguardDrawerItem = new SafeguardDrawerItem();
            safeguardDrawerItem.h(((co.a) h()).G2());
            safeguardDrawerItem.i(SafeguardType.SAFEGUARD_SINGLE);
            if (bj.d.s()) {
                safeguardDrawerItem.g(String.format(g(R.string.n_function_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getTime(), "yyyy/MM/dd HH:mm")}));
            } else {
                safeguardDrawerItem.j(String.format(g(R.string.n_function_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
            }
            arrayList.add(0, safeguardDrawerItem);
        }
        return arrayList;
    }

    public final synchronized List<s9.a> D() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        int i11 = this.f83843p;
        if (i11 == 0) {
            this.f83832e = TradeTabsType.COLLECTION;
            arrayList.addAll(B());
        } else if (i11 == 1) {
            this.f83832e = TradeTabsType.OTHER;
            arrayList.addAll(A((List<String>) null));
        } else {
            this.f83832e = TradeTabsType.OTHER;
            if (i11 - 2 < this.f83837j.size()) {
                arrayList.addAll(C(this.f83837j.get(this.f83843p - 2).e()));
            }
        }
        return arrayList;
    }

    public final void E() {
        t.s(false, this.f83829b).compose(RxJavaHelper.t(j())).subscribe(new a());
    }

    public final void F() {
        bj.d.p().compose(RxJavaHelper.t(j())).subscribe(new b());
        ContractCurrencyUtils.g(false).compose(RxJavaHelper.t(j())).subscribe(new c());
        SwapCurrencyInfoController.k().f(false).compose(RxJavaHelper.t(j())).subscribe(new C0861d());
    }

    public int G() {
        return this.f83843p;
    }

    public final synchronized void H(List<SymbolPrice> list) {
        ArrayList<SymbolPrice> arrayList = new ArrayList<>(list);
        ArrayList<s9.a> arrayList2 = new ArrayList<>(this.f83839l);
        for (s9.a aVar : arrayList2) {
            for (SymbolPrice symbolPrice : arrayList) {
                if (aVar instanceof ContractCurrencyInfoDrawerItem) {
                    ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = (ContractCurrencyInfoDrawerItem) aVar;
                    if (contractCurrencyInfoDrawerItem.d().getContractShortType().equals(symbolPrice.getSymbol())) {
                        contractCurrencyInfoDrawerItem.d().setSymbolPrice(symbolPrice);
                    }
                } else if (aVar instanceof SwapCurrencyInfoDrawerItem) {
                    SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem = (SwapCurrencyInfoDrawerItem) aVar;
                    if (swapCurrencyInfoDrawerItem.d().getContractCode().equals(symbolPrice.getSymbol())) {
                        swapCurrencyInfoDrawerItem.k(symbolPrice);
                    }
                }
            }
        }
        this.f83839l.clear();
        this.f83839l.addAll(arrayList2);
        if (this.f83840m.size() == 0) {
            this.f83840m.addAll(this.f83839l);
        }
        n(this.f83836i, false);
    }

    public final void J(List<s9.a> list) {
        boolean z11 = list == null || list.isEmpty();
        if (!this.f83844q && this.f83843p == 0 && z11) {
            y(1);
        }
    }

    public final void K(int i11) {
        String str;
        switch (i11) {
            case 0:
                str = "optional";
                break;
            case 1:
                str = TtmlNode.COMBINE_ALL;
                break;
            case 2:
                str = "coin_sustainable";
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
        gs.g.j("switchover_coin_pair", "coin_contract", str, (HashMap) null);
    }

    public void L(String str) {
        this.f83845r = str;
        N();
    }

    public void M(TradeType tradeType, String str, SafeguardType safeguardType) {
        ((co.a) h()).gg(tradeType, str, safeguardType);
    }

    public final void N() {
        List<s9.a> D = D();
        this.f83834g.clear();
        if (!TextUtils.isEmpty(this.f83845r)) {
            String str = "";
            for (int i11 = 0; i11 < D.size(); i11++) {
                s9.a aVar = D.get(i11);
                if (aVar instanceof SwapCurrencyInfoDrawerItem) {
                    str = j.f(((SwapCurrencyInfoDrawerItem) aVar).d().getSymbol(), this.f83829b);
                } else if (aVar instanceof ContractCurrencyInfoDrawerItem) {
                    ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = (ContractCurrencyInfoDrawerItem) aVar;
                    str = ej.g.d(contractCurrencyInfoDrawerItem.d().getContractShortType(), contractCurrencyInfoDrawerItem.d().getContractCode(), 2);
                } else if (aVar instanceof SafeguardDrawerItem) {
                    this.f83834g.add(aVar);
                }
                if (!TextUtils.isEmpty(str) && str.contains(this.f83845r) && !(aVar instanceof bo.b)) {
                    this.f83834g.add(aVar);
                }
            }
        } else {
            this.f83834g.addAll(D);
        }
        s9.a aVar2 = !this.f83834g.isEmpty() ? this.f83834g.get(0) : null;
        if (aVar2 != null && (aVar2 instanceof SingleSafeguardDrawerItem)) {
            SingleSafeguardDrawerItem singleSafeguardDrawerItem = (SingleSafeguardDrawerItem) aVar2;
            M(this.f83831d, singleSafeguardDrawerItem.c(), singleSafeguardDrawerItem.d());
            this.f83834g.remove(aVar2);
        } else if (aVar2 == null || !(aVar2 instanceof SafeguardDrawerItem)) {
            M(this.f83831d, "", SafeguardType.SAFEGUARD_NONE);
        } else {
            M(this.f83831d, "", ((SafeguardDrawerItem) aVar2).d());
        }
        p();
        this.f83844q = true;
    }

    public boolean a(s9.a aVar) {
        if ((aVar instanceof ContractCurrencyInfoDrawerItem) && (((co.a) h()).R5() instanceof ContractCurrencyInfoDrawerItem)) {
            ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = (ContractCurrencyInfoDrawerItem) aVar;
            ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem2 = (ContractCurrencyInfoDrawerItem) ((co.a) h()).R5();
            if (contractCurrencyInfoDrawerItem2 == null || contractCurrencyInfoDrawerItem2.d().getContractCode() == null || contractCurrencyInfoDrawerItem2.d().getSymbol() == null || !contractCurrencyInfoDrawerItem2.d().getContractCode().equals(contractCurrencyInfoDrawerItem.d().getContractCode()) || !contractCurrencyInfoDrawerItem2.d().getSymbol().equals(contractCurrencyInfoDrawerItem.d().getSymbol())) {
                return false;
            }
            return true;
        } else if ((aVar instanceof SwapCurrencyInfoDrawerItem) && (((co.a) h()).R5() instanceof SwapCurrencyInfoDrawerItem)) {
            SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem = (SwapCurrencyInfoDrawerItem) ((co.a) h()).R5();
            SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem2 = (SwapCurrencyInfoDrawerItem) aVar;
            if (!(swapCurrencyInfoDrawerItem.d() == null || swapCurrencyInfoDrawerItem.d().getContractCode() == null || swapCurrencyInfoDrawerItem2.d() == null)) {
                return swapCurrencyInfoDrawerItem.d().getContractCode().equals(swapCurrencyInfoDrawerItem2.d().getContractCode());
            }
        }
        return false;
    }

    public void e(s9.a aVar) {
        if (h() != null) {
            ((co.a) h()).a(this.f83831d, aVar);
        }
    }

    public void k() {
        i6.d.b("ContractTradeDataProvider-->register-->");
        if (!this.f83838k) {
            E();
            z();
            p();
            o6.b.g().e("contract_overview_provider_tag", this.f83847t);
            o6.b.g().i();
            r.g().e("swap_overview_provider_tag", this.f83848u);
            r.g().i();
            this.f83838k = true;
            F();
            y(this.f83843p);
        }
    }

    public void l() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        r4 = java.lang.System.out;
        r4.println("ContractSortListError==>> " + r3.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:2:0x0005, B:6:0x0017] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(int r3, boolean r4) {
        /*
            r2 = this;
            super.n(r3, r4)
            if (r3 != 0) goto L_0x0017
            java.util.concurrent.CopyOnWriteArrayList<s9.a> r3 = r2.f83839l     // Catch:{ all -> 0x0022 }
            r3.clear()     // Catch:{ all -> 0x0022 }
            java.util.concurrent.CopyOnWriteArrayList<s9.a> r3 = r2.f83839l     // Catch:{ all -> 0x0022 }
            java.util.concurrent.CopyOnWriteArrayList<s9.a> r0 = r2.f83840m     // Catch:{ all -> 0x0022 }
            r3.addAll(r0)     // Catch:{ all -> 0x0022 }
            if (r4 == 0) goto L_0x0016
            r2.N()     // Catch:{ all -> 0x0022 }
        L_0x0016:
            return
        L_0x0017:
            java.util.concurrent.CopyOnWriteArrayList<s9.a> r0 = r2.f83839l     // Catch:{ ConcurrentModificationException -> 0x0024 }
            do.c r1 = new do.c     // Catch:{ ConcurrentModificationException -> 0x0024 }
            r1.<init>(r3)     // Catch:{ ConcurrentModificationException -> 0x0024 }
            java.util.Collections.sort(r0, r1)     // Catch:{ ConcurrentModificationException -> 0x0024 }
            goto L_0x0028
        L_0x0022:
            r3 = move-exception
            goto L_0x002e
        L_0x0024:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0022 }
        L_0x0028:
            if (r4 == 0) goto L_0x0048
            r2.N()     // Catch:{ all -> 0x0022 }
            goto L_0x0048
        L_0x002e:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ContractSortListError==>> "
            r0.append(r1)
            java.lang.String r3 = r3.getMessage()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.println(r3)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p039do.d.n(int, boolean):void");
    }

    public void o() {
        i6.d.b("ContractTradeDataProvider-->unregister-->");
        if (this.f83838k) {
            this.f83838k = false;
            o6.b.g().j("contract_overview_provider_tag");
            o6.b.g().n();
            r.g().j("swap_overview_provider_tag");
            r.g().n();
            Subscription subscription = this.f83841n;
            if (subscription != null) {
                subscription.unsubscribe();
            }
        }
    }

    public void p() {
        if (h() != null) {
            ((co.a) h()).xa(this.f83831d, TradeTabsType.getTabsType(this.f83832e, this.f83845r), this.f83842o, this.f83834g);
        }
    }

    public final void x() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
        List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
        this.f83839l.clear();
        ContractHeartBeat d11 = bj.d.d();
        if (d11 != null) {
            if (bj.d.s() && !bj.d.x()) {
                SingleSafeguardDrawerItem singleSafeguardDrawerItem = new SingleSafeguardDrawerItem();
                singleSafeguardDrawerItem.f(((co.a) h()).G2());
                singleSafeguardDrawerItem.h(SafeguardType.SAFEGUARD_TIPS);
                singleSafeguardDrawerItem.g(String.format(g(R.string.n_contract_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getTime(), "yyyy/MM/dd HH:mm")}));
                this.f83839l.add(singleSafeguardDrawerItem);
            } else if (!bj.d.s() && bj.d.x()) {
                SingleSafeguardDrawerItem singleSafeguardDrawerItem2 = new SingleSafeguardDrawerItem();
                singleSafeguardDrawerItem2.f(((co.a) h()).G2());
                singleSafeguardDrawerItem2.h(SafeguardType.SAFEGUARD_TIPS);
                singleSafeguardDrawerItem2.g(String.format(g(R.string.n_swap_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
                this.f83839l.add(singleSafeguardDrawerItem2);
            } else if (bj.d.s() && bj.d.x()) {
                SafeguardDrawerItem safeguardDrawerItem = new SafeguardDrawerItem();
                safeguardDrawerItem.h(((co.a) h()).G2());
                safeguardDrawerItem.i(SafeguardType.SAFEGUARD_ALL);
                safeguardDrawerItem.g(String.format(g(R.string.n_contract_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getTime(), "yyyy/MM/dd HH:mm")}));
                safeguardDrawerItem.j(String.format(g(R.string.n_swap_maintenance_recovery_time_tips), new Object[]{DateTimeUtils.h(d11.getSwapEstimatedRecoveryTime(), "yyyy/MM/dd HH:mm")}));
                this.f83839l.add(safeguardDrawerItem);
            }
        }
        if (!bj.d.s()) {
            linkedHashSet.addAll(ContractCurrencyUtils.l());
        }
        if (!bj.d.x()) {
            linkedHashSet.addAll(SwapCurrencyInfoController.k().r());
        }
        Iterator it2 = linkedHashSet.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (e11 != null && !bj.d.x()) {
                for (SwapCurrencyInfo next : e11) {
                    if (next.getSymbol().equals(str)) {
                        SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem = new SwapCurrencyInfoDrawerItem();
                        swapCurrencyInfoDrawerItem.h(next);
                        swapCurrencyInfoDrawerItem.j(true);
                        swapCurrencyInfoDrawerItem.g(this);
                        swapCurrencyInfoDrawerItem.i(((co.a) h()).G2());
                        try {
                            int i12 = i11 + 1;
                            try {
                                this.f83839l.add(i11, swapCurrencyInfoDrawerItem);
                                i11 = i12;
                            } catch (Throwable unused) {
                                i11 = i12;
                                this.f83839l.add(swapCurrencyInfoDrawerItem);
                            }
                        } catch (Throwable unused2) {
                            this.f83839l.add(swapCurrencyInfoDrawerItem);
                        }
                    }
                }
            }
            if (m11 != null && !bj.d.s()) {
                for (ContractCurrencyInfo next2 : m11) {
                    if (next2.getSymbol().equals(str)) {
                        next2.setItemType(1);
                        next2.setPercentVisible(true);
                        next2.setNightMode(((co.a) h()).G2());
                        ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = new ContractCurrencyInfoDrawerItem();
                        contractCurrencyInfoDrawerItem.g(next2);
                        contractCurrencyInfoDrawerItem.f(this);
                        contractCurrencyInfoDrawerItem.h(((co.a) h()).G2());
                        this.f83839l.add(contractCurrencyInfoDrawerItem);
                    }
                }
            }
        }
        this.f83840m.clear();
        this.f83840m.addAll(this.f83839l);
        n(this.f83836i, false);
    }

    public void y(int i11) {
        this.f83843p = i11;
        N();
        ((co.a) h()).y7(this.f83843p);
        K(i11);
    }

    public void z() {
        this.f83845r = null;
    }
}
