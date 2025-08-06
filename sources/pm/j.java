package pm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.utils.TextUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.kline.presenter.AbstractKlinePresenter;
import com.hbg.module.kline.presenter.MarketInfoPresenter;
import com.hbg.module.kline.ui.MarketInfoRestartActivity;
import com.huobi.contract.entity.ContractCurrencyInfoDrawerItem;
import com.huobi.contract.entity.OptionCurrencyInfoDrawerItem;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.ui.ContractTradeBaseFragment;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.helper.l;
import com.huobi.main.trade.enums.SafeguardType;
import com.huobi.main.trade.enums.TradeTabsType;
import com.huobi.main.trade.ui.SymbolSelectionFragment;
import com.huobi.main.trade.ui.TradeCompareDialogFragment;
import com.huobi.main.trade.ui.TradeDialogFragment;
import com.huobi.staring.bean.RemindCustomSub;
import com.huobi.staring.helper.StaringRemindHelper;
import com.huobi.staring.ui.StaringRemindActivity;
import com.huobi.swap.bean.SwapCurrencyInfoDrawerItem;
import com.huobi.swap.ui.SwapTradeBaseFragment;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import cs.n;
import d7.a1;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p039do.k;
import pro.huobi.R;
import rx.Observable;
import sn.f;
import sn.t;
import td.g;
import td.h;
import tg.r;
import us.i;

public final class j {

    public class a implements h {
        public static /* synthetic */ Boolean Q(RemindCustomSub remindCustomSub) {
            return Boolean.valueOf(remindCustomSub != null && remindCustomSub.isCustomSub());
        }

        public static /* synthetic */ Boolean R(RemindCustomSub remindCustomSub) {
            return Boolean.valueOf(remindCustomSub != null && remindCustomSub.isCustomSub());
        }

        public static /* synthetic */ void S(MarketInfoPresenter.e eVar, TradeType tradeType, s9.a aVar) {
            int i11 = d.f76452a[tradeType.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
                j.i(eVar.getActivity(), f.n(eVar.getActivity(), ((ml.d) aVar).o(), false, tradeType));
                return;
            }
            if (i11 != 5) {
                if (i11 == 7) {
                    j.i(eVar.getActivity(), f.u(eVar.getActivity(), ((LinearSwapCurrencyInfoDrawerItem) aVar).e()));
                    return;
                } else if (i11 == 10) {
                    j.i(eVar.getActivity(), f.k(eVar.getActivity(), ((ml.d) aVar).o(), false, TradeType.PRO));
                } else if (i11 == 11) {
                    j.i(eVar.getActivity(), f.w(eVar.getActivity(), ((OptionCurrencyInfoDrawerItem) aVar).d()));
                    return;
                } else {
                    return;
                }
            }
            if (aVar instanceof ContractCurrencyInfoDrawerItem) {
                ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = (ContractCurrencyInfoDrawerItem) aVar;
                j.i(eVar.getActivity(), f.g(eVar.getActivity(), contractCurrencyInfoDrawerItem.d().getContractShortType(), contractCurrencyInfoDrawerItem.d().getContractCode(), contractCurrencyInfoDrawerItem.d(), tradeType));
            } else if (aVar instanceof SwapCurrencyInfoDrawerItem) {
                SwapCurrencyInfo d11 = ((SwapCurrencyInfoDrawerItem) aVar).d();
                j.i(eVar.getActivity(), f.x(eVar.getActivity(), d11.getContractShortType(), d11.getContractCode(), d11, TradeType.SWAP));
            }
        }

        public static /* synthetic */ void T(MarketInfoPresenter.e eVar, TradeType tradeType, String str, Object obj) {
            switch (d.f76452a[tradeType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    j.i(eVar.getActivity(), f.n(eVar.getActivity(), str, false, tradeType));
                    return;
                case 5:
                case 6:
                    if (obj instanceof ContractCurrencyInfo) {
                        ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) obj;
                        j.i(eVar.getActivity(), f.g(eVar.getActivity(), contractCurrencyInfo.getContractShortType(), contractCurrencyInfo.getContractCode(), contractCurrencyInfo, TradeType.CONTRACT));
                        return;
                    } else if (obj instanceof SwapCurrencyInfo) {
                        SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) obj;
                        j.i(eVar.getActivity(), f.x(eVar.getActivity(), swapCurrencyInfo.getContractShortType(), swapCurrencyInfo.getContractCode(), swapCurrencyInfo, TradeType.SWAP));
                        return;
                    } else {
                        return;
                    }
                case 7:
                    if (obj instanceof FutureContractInfo) {
                        j.i(eVar.getActivity(), f.u(eVar.getActivity(), (FutureContractInfo) obj));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public static /* synthetic */ void U(MarketInfoPresenter.e eVar, TradeType tradeType, s9.a aVar) {
            int i11 = d.f76452a[tradeType.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4) {
                j.i(eVar.getActivity(), f.n(eVar.getActivity(), ((ml.d) aVar).o(), false, tradeType));
                return;
            }
            if (i11 != 5) {
                if (i11 == 7) {
                    j.i(eVar.getActivity(), f.u(eVar.getActivity(), ((LinearSwapCurrencyInfoDrawerItem) aVar).e()));
                    return;
                } else if (i11 == 10) {
                    j.i(eVar.getActivity(), f.k(eVar.getActivity(), ((ml.d) aVar).o(), false, TradeType.PRO));
                } else if (i11 == 11) {
                    j.i(eVar.getActivity(), f.w(eVar.getActivity(), ((OptionCurrencyInfoDrawerItem) aVar).d()));
                    return;
                } else {
                    return;
                }
            }
            if (aVar instanceof ContractCurrencyInfoDrawerItem) {
                ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = (ContractCurrencyInfoDrawerItem) aVar;
                j.i(eVar.getActivity(), f.g(eVar.getActivity(), contractCurrencyInfoDrawerItem.d().getContractShortType(), contractCurrencyInfoDrawerItem.d().getContractCode(), contractCurrencyInfoDrawerItem.d(), tradeType));
            } else if (aVar instanceof SwapCurrencyInfoDrawerItem) {
                SwapCurrencyInfo d11 = ((SwapCurrencyInfoDrawerItem) aVar).d();
                j.i(eVar.getActivity(), f.x(eVar.getActivity(), d11.getContractShortType(), d11.getContractCode(), d11, TradeType.SWAP));
            }
        }

        public int A(String str) {
            return i.a(str);
        }

        public int B(String str) {
            return i.o(str);
        }

        public Observable<Object> C(MarketInfoPresenter.e eVar, String str, String str2) {
            String str3;
            if (TradeType.CONTRACT.toString().equals(str)) {
                str3 = "CONTRACT";
            } else if (TradeType.SWAP.toString().equals(str)) {
                str3 = "CONTRACT_SWAP";
            } else if (TradeType.LINEAR_SWAP.toString().equals(str)) {
                str3 = "LINEAR_SWAP";
            } else {
                str3 = (TradeType.LINEAR_SWAP_INDEX.toString().equals(str) || TradeType.CONTRACT_INDEX.toString().equals(str)) ? "FUTURES_INDEX" : "PRO";
            }
            return t.i(str2, eVar.getActivity(), str3).compose(RxJavaHelper.t(eVar));
        }

        public int D(String str) {
            return ej.f.t(str);
        }

        public void E(AbstractKlinePresenter.b bVar) {
            LegalCurrencyConfigUtil.e().flatMap(i.f53179b).compose(RxJavaHelper.t(bVar)).subscribe(new BaseSubscriber());
        }

        public BaseDialogFragment F(boolean z11, MarketInfoPresenter.e eVar, String str, BaseDialogFragment baseDialogFragment, String str2) {
            TradeCompareDialogFragment tradeCompareDialogFragment = new TradeCompareDialogFragment();
            tradeCompareDialogFragment.di(z11);
            tradeCompareDialogFragment.gi(eVar);
            tradeCompareDialogFragment.setCanceledOnTouchOutside(true);
            tradeCompareDialogFragment.setCancelable(true);
            tradeCompareDialogFragment.Yh(new d(eVar));
            tradeCompareDialogFragment.ii(((FragmentActivity) eVar.getActivity()).getSupportFragmentManager(), "trade", TradeType.parse(str2), str);
            return tradeCompareDialogFragment;
        }

        public int G(String str) {
            return i.e(str);
        }

        public boolean a(String str) {
            boolean z11;
            if (TradeType.isContract(str) || TradeType.isSwap(str) || TradeType.isLinearSwap(str)) {
                z11 = gj.d.n().q();
            } else {
                z11 = gj.d.n().B();
            }
            return z11 && !TradeType.isContractIndex(str);
        }

        public void b(String str, Map<String, Object> map) {
            is.a.i(str, map);
        }

        public void c(FragmentActivity fragmentActivity, String str, boolean z11) {
            nq.a.h(fragmentActivity, fragmentActivity.getSupportFragmentManager(), str, z11);
        }

        public void d(String str, Map<String, Object> map, String str2) {
            is.a.j(str, map, str2);
        }

        public boolean e() {
            return gj.d.n().G();
        }

        public void f(FragmentActivity fragmentActivity, String str) {
            nq.a.j(fragmentActivity, fragmentActivity.getSupportFragmentManager(), str);
        }

        public void g(String str, g gVar) {
            t.o(str, gVar);
        }

        public Observable<Boolean> h(MarketInfoPresenter.e eVar, String str) {
            return t.s(false, eVar.getActivity()).compose(RxJavaHelper.t(eVar)).map(new f(str));
        }

        public void i(AbstractKlinePresenter.b bVar, String str, boolean z11) {
            j.j(bVar, str, z11);
        }

        public int j(String str) {
            return i.z(str);
        }

        public void k(String str) {
            if (TradeType.isContract(str) || TradeType.isSwap(str) || TradeType.isLinearSwap(str)) {
                n.v();
            } else {
                StaringRemindHelper.n();
            }
        }

        public String l(String str, String str2, TradeType tradeType) {
            return LegalCurrencyConfigUtil.A(str, str2, tradeType);
        }

        public int m(String str) {
            return i.d(str);
        }

        public boolean n() {
            return r.x().F0();
        }

        public void o(u6.g gVar, String str, BaseDialogFragment baseDialogFragment, String str2) {
            j.d(gVar, str, TradeType.parse(str2)).W();
        }

        public void p(AbstractKlinePresenter.b bVar, ContractCurrencyInfo contractCurrencyInfo, SwapCurrencyInfo swapCurrencyInfo, FutureContractInfo futureContractInfo, String str, String str2, boolean z11) {
            j.f(bVar, contractCurrencyInfo, swapCurrencyInfo, futureContractInfo, str, str2, z11);
        }

        public Observable<Object> q(MarketInfoPresenter.e eVar, String str, String str2) {
            String str3;
            if (TradeType.CONTRACT.toString().equals(str)) {
                str3 = "CONTRACT";
            } else if (TradeType.SWAP.toString().equals(str)) {
                str3 = "CONTRACT_SWAP";
            } else if (TradeType.LINEAR_SWAP.toString().equals(str)) {
                str3 = "LINEAR_SWAP";
            } else {
                str3 = (TradeType.LINEAR_SWAP_INDEX.toString().equals(str) || TradeType.CONTRACT_INDEX.toString().equals(str)) ? "FUTURES_INDEX" : "PRO";
            }
            return t.l(str2, eVar.getActivity(), str3).compose(RxJavaHelper.t(eVar));
        }

        public String r() {
            return d1.f();
        }

        public Observable<Boolean> s(RemindContractType remindContractType, u6.g gVar, String str) {
            boolean z11;
            if (remindContractType != null) {
                z11 = gj.d.n().q();
            } else {
                z11 = gj.d.n().B();
            }
            if (!z11 || !rn.c.i().B()) {
                return Observable.just(Boolean.FALSE);
            }
            if (str.contains("/")) {
                str = str.replaceAll("/", "").toLowerCase(Locale.US);
            }
            if (remindContractType == null) {
                return StaringRemindHelper.l(str, gVar).map(g.f53177b);
            }
            if (remindContractType == RemindContractType.TYPE_SWAP) {
                SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(str);
                if (c11 != null) {
                    str = c11.getSymbol();
                }
            } else if (remindContractType == RemindContractType.TYPE_LINEAR_SWAP) {
                FutureContractInfo o11 = FutureContractInfoController.n().o(str);
                if (o11 != null) {
                    str = o11.getSymbol();
                }
            } else {
                ContractCurrencyInfo b11 = ContractCurrencyUtils.b(str);
                if (b11 != null) {
                    str = b11.getSymbol();
                }
            }
            return n.t(remindContractType, str, gVar).map(h.f53178b);
        }

        public int t(String str) {
            return ej.f.n(str);
        }

        public DialogFragment u(boolean z11, MarketInfoPresenter.e eVar, MarketInfoPresenter marketInfoPresenter, DialogFragment dialogFragment, String str) {
            TradeDialogFragment tradeDialogFragment;
            if (dialogFragment == null) {
                tradeDialogFragment = new TradeDialogFragment();
                tradeDialogFragment.xi(z11);
                tradeDialogFragment.zi(eVar);
                tradeDialogFragment.Ai(false);
                tradeDialogFragment.ri(new e(eVar));
            } else {
                tradeDialogFragment = (TradeDialogFragment) dialogFragment;
            }
            FragmentManager supportFragmentManager = ((FragmentActivity) eVar.getActivity()).getSupportFragmentManager();
            if (TradeType.isContract(str)) {
                ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = new ContractCurrencyInfoDrawerItem();
                contractCurrencyInfoDrawerItem.g(marketInfoPresenter.b0());
                tradeDialogFragment.Di(supportFragmentManager, "trade", TradeType.CONTRACT, contractCurrencyInfoDrawerItem);
            } else if (TradeType.isSwap(str)) {
                SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem = new SwapCurrencyInfoDrawerItem();
                swapCurrencyInfoDrawerItem.h(marketInfoPresenter.g0());
                tradeDialogFragment.Di(supportFragmentManager, "trade", TradeType.CONTRACT, swapCurrencyInfoDrawerItem);
            } else if (TradeType.isOption(str)) {
                OptionCurrencyInfoDrawerItem optionCurrencyInfoDrawerItem = new OptionCurrencyInfoDrawerItem();
                optionCurrencyInfoDrawerItem.f(marketInfoPresenter.d0());
                tradeDialogFragment.Di(supportFragmentManager, "trade", TradeType.OPTION, optionCurrencyInfoDrawerItem);
            } else if (TradeType.isLinearSwap(str)) {
                LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem = new LinearSwapCurrencyInfoDrawerItem();
                linearSwapCurrencyInfoDrawerItem.l(marketInfoPresenter.d0());
                tradeDialogFragment.Di(supportFragmentManager, "trade", TradeType.LINEAR_SWAP, linearSwapCurrencyInfoDrawerItem);
            } else {
                tradeDialogFragment.Ci(supportFragmentManager, "trade", TradeType.parse(str), marketInfoPresenter.h0());
            }
            return tradeDialogFragment;
        }

        public String v(String str) {
            return LegalCurrencyConfigUtil.B(str);
        }

        public DialogFragment w(boolean z11, MarketInfoPresenter.e eVar, MarketInfoPresenter marketInfoPresenter, DialogFragment dialogFragment, String str) {
            SymbolSelectionFragment symbolSelectionFragment;
            String str2;
            FutureContractInfo d02;
            if (dialogFragment == null) {
                symbolSelectionFragment = new SymbolSelectionFragment();
                symbolSelectionFragment.Kh(new c(eVar));
            } else {
                symbolSelectionFragment = (SymbolSelectionFragment) dialogFragment;
            }
            TradeType parse = TradeType.parse(str);
            String str3 = "";
            if (parse == TradeType.MARGIN || parse == TradeType.SUPERMARGIN || parse == TradeType.PRO) {
                if (marketInfoPresenter != null) {
                    str3 = marketInfoPresenter.h0();
                    str2 = a1.v().D(str3);
                } else {
                    str2 = str3;
                }
                l.f(str3, str2, parse, true);
            } else if (TradeType.isContract(str)) {
                ContractCurrencyInfo b02 = marketInfoPresenter.b0();
                if (b02 != null) {
                    l.f(b02.getContractShortType(), str3, parse, true);
                }
            } else if (TradeType.isSwap(str)) {
                SwapCurrencyInfo g02 = marketInfoPresenter.g0();
                if (g02 != null) {
                    l.f(g02.getContractShortType(), str3, parse, true);
                }
            } else if (TradeType.isLinearSwap(str) && (d02 = marketInfoPresenter.d0()) != null) {
                l.f(d02.getContractShortType(), str3, parse, true);
            }
            symbolSelectionFragment.Ph(((FragmentActivity) eVar.getActivity()).getSupportFragmentManager(), "trade", parse, true);
            return symbolSelectionFragment;
        }

        public void x(RemindContractType remindContractType, RemindBusinessType remindBusinessType, Context context, String str) {
            is.a.w("3111", str);
            if (remindContractType != null) {
                if (!n.l(str) && !StaringRemindHelper.i(str)) {
                    HuobiToastUtil.j(R.string.n_contract_reminder_not_supported);
                    return;
                }
            } else if (!StaringRemindHelper.h(str)) {
                HuobiToastUtil.j(R.string.staring_remind_no_tips);
                return;
            }
            if (rn.c.i().B()) {
                StaringRemindActivity.oj(context, str, remindContractType, remindBusinessType);
            } else {
                rn.c.i().d(context, new JumpTarget((Intent) null, (Intent) null));
            }
        }

        public int y(String str) {
            return i.f(str);
        }

        public int z(String str) {
            return ej.f.p(str);
        }
    }

    public class b extends EasySubscriber<List<ContractCurrencyInfo>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbstractKlinePresenter.b f76445b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ContractCurrencyInfo f76446c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f76447d;

        public b(AbstractKlinePresenter.b bVar, ContractCurrencyInfo contractCurrencyInfo, boolean z11) {
            this.f76445b = bVar;
            this.f76446c = contractCurrencyInfo;
            this.f76447d = z11;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(ContractCurrencyInfo contractCurrencyInfo, List list, boolean z11) {
            if (j.h(contractCurrencyInfo, list)) {
                g(contractCurrencyInfo, z11);
            } else {
                g(d(list), z11);
            }
        }

        public final ContractCurrencyInfo d(List<ContractCurrencyInfo> list) {
            int size = list.size();
            ContractCurrencyInfo contractCurrencyInfo = this.f76446c;
            for (int i11 = 0; i11 < size; i11++) {
                ContractCurrencyInfo contractCurrencyInfo2 = list.get(i11);
                if ("quarter".equals(contractCurrencyInfo2.getContractType()) && this.f76446c.getSymbol().equals(contractCurrencyInfo2.getSymbol())) {
                    contractCurrencyInfo = contractCurrencyInfo2;
                }
                if (this.f76446c.getSymbol().equals(contractCurrencyInfo2.getSymbol()) && this.f76446c.getContractType().equals(contractCurrencyInfo2.getContractType())) {
                    return contractCurrencyInfo2;
                }
            }
            return contractCurrencyInfo;
        }

        /* renamed from: e */
        public final void g(ContractCurrencyInfo contractCurrencyInfo, boolean z11) {
            if (z11) {
                ContractTradeBaseFragment.Si(this.f76445b.getActivity(), contractCurrencyInfo, 0, true);
            } else {
                ContractTradeBaseFragment.Si(this.f76445b.getActivity(), contractCurrencyInfo, 1, true);
            }
            this.f76445b.getActivity().finish();
        }

        public void onAfter() {
            super.onAfter();
            this.f76445b.dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            i6.i.b().g(new m(this, this.f76446c, this.f76447d), 10);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.i.b().g(new l(this, this.f76446c, this.f76447d), 10);
        }

        public void onStart() {
            super.onStart();
            this.f76445b.showProgressDialog();
        }

        public void onNext(List<ContractCurrencyInfo> list) {
            super.onNext(list);
            i6.i.b().g(new k(this, this.f76446c, list, this.f76447d), 10);
        }
    }

    public class c implements co.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean[] f76448b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f76449c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ u6.g f76450d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TradeType f76451e;

        public c(boolean[] zArr, String str, u6.g gVar, TradeType tradeType) {
            this.f76448b = zArr;
            this.f76449c = str;
            this.f76450d = gVar;
            this.f76451e = tradeType;
        }

        public boolean G2() {
            return false;
        }

        public s9.a R5() {
            i6.d.b("KlineConfig-->getCurrentItem -->");
            return null;
        }

        public void Yf(TradeType tradeType, List<? extends s9.a> list) {
            i6.d.b("KlineConfig-->onDataObserver 2-->");
        }

        public void a(TradeType tradeType, s9.a aVar) {
        }

        public void gg(TradeType tradeType, String str, SafeguardType safeguardType) {
        }

        public String nf() {
            i6.d.b("KlineConfig-->getCurrentSymbol -->");
            return null;
        }

        public void p7(TradeType tradeType, List<String> list) {
        }

        public void sb(int i11) {
        }

        public void xa(TradeType tradeType, TradeTabsType tradeTabsType, List<String> list, List<? extends s9.a> list2) {
            boolean z11;
            TradeType tradeType2 = TradeType.PRO;
            if (tradeType == tradeType2 && this.f76448b[0]) {
                Iterator<SymbolBean> it2 = a1.v().Z(tradeType2).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z11 = false;
                        break;
                    }
                    SymbolBean next = it2.next();
                    if (!TextUtils.c(next.getSymbol()) && next.isIsTradeEnabled() && !this.f76449c.equals(next.getSymbol()) && this.f76449c.startsWith(next.getBaseCurrencyDisplayName().toLowerCase())) {
                        z11 = true;
                        break;
                    }
                }
                u6.g gVar = this.f76450d;
                if (gVar instanceof MarketInfoPresenter.e) {
                    ((MarketInfoPresenter.e) gVar).Zg(this.f76451e, z11);
                }
                this.f76448b[0] = false;
            }
        }

        public void y7(int i11) {
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f76452a;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f76452a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.C2C     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.OTC     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.INDEX     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.GRID     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f76452a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.OPTION     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: pm.j.d.<clinit>():void");
        }
    }

    public static k d(u6.g gVar, String str, TradeType tradeType) {
        k kVar = new k((Context) bh.j.c(), 1, (co.a) new c(new boolean[]{true}, str, gVar, tradeType), gVar);
        kVar.e0(true);
        kVar.c0(true);
        return kVar;
    }

    public static void e(AbstractKlinePresenter.b bVar, ContractCurrencyInfo contractCurrencyInfo, boolean z11) {
        ContractCurrencyUtils.g(false).compose(RxJavaHelper.t(bVar)).subscribe(new b(bVar, contractCurrencyInfo, z11));
    }

    public static void f(AbstractKlinePresenter.b bVar, ContractCurrencyInfo contractCurrencyInfo, SwapCurrencyInfo swapCurrencyInfo, FutureContractInfo futureContractInfo, String str, String str2, boolean z11) {
        if (TradeType.isContract(str)) {
            e(bVar, contractCurrencyInfo, z11);
        } else if (TradeType.isLinearSwap(str)) {
            LinearSwapTradeBaseFragment.Oj(bVar.getActivity(), futureContractInfo, z11 ^ true ? 1 : 0, true);
        } else if (TradeType.isSwap(str)) {
            SwapTradeBaseFragment.Ri(bVar.getActivity(), swapCurrencyInfo, z11 ^ true ? 1 : 0, true);
        } else if (TradeType.PRO.equals(TradeType.valueOf(str))) {
            k0.O(bVar.getActivity(), str2, z11);
        } else if (TradeType.MARGIN.toString().equals(str)) {
            k0.M(str2, "0", z11, bVar.getActivity());
        } else if (TradeType.C2C.toString().equals(str)) {
            k0.J(bVar.getActivity(), str2, z11);
        } else if (TradeType.SUPERMARGIN.toString().equals(str)) {
            k0.R(str2, "0", z11, bVar.getActivity());
        }
    }

    public static void g() {
        td.i.a().c(new a());
    }

    public static boolean h(ContractCurrencyInfo contractCurrencyInfo, List<ContractCurrencyInfo> list) {
        String contractCode = contractCurrencyInfo.getContractCode();
        for (int i11 = 0; i11 < list.size(); i11++) {
            ContractCurrencyInfo contractCurrencyInfo2 = list.get(i11);
            if (contractCurrencyInfo2 != null && contractCurrencyInfo2.getContractCode().equals(contractCode)) {
                return true;
            }
        }
        return false;
    }

    public static void i(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity, MarketInfoRestartActivity.class);
        intent2.putExtra("extra_intent", intent);
        activity.startActivity(intent2);
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        activity.finish();
    }

    public static void j(AbstractKlinePresenter.b bVar, String str, boolean z11) {
        k0.M(str, "0", z11, bVar.getActivity());
    }
}
