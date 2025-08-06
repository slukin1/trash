package com.hbg.lib.data.future.controller;

import ad.i;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.controller.LinearSwapHiddenInstrumentsController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapHiddenInstruments;
import com.hbg.lib.network.option.controller.OptionCurrencyInfoController;
import com.hbg.lib.network.option.core.bean.OptionCurrencyInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import z6.d;
import z6.e;

public class FutureContractInfoController {

    /* renamed from: a  reason: collision with root package name */
    public static volatile FutureContractInfoController f68834a;

    public class a implements Func1<List<OptionCurrencyInfo>, Observable<OptionCurrencyInfo>> {
        public a() {
        }

        /* renamed from: a */
        public Observable<OptionCurrencyInfo> call(List<OptionCurrencyInfo> list) {
            return Observable.from(list);
        }
    }

    public class b implements Func1<List<OptionCurrencyInfo>, Observable<OptionCurrencyInfo>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<OptionCurrencyInfo> call(List<OptionCurrencyInfo> list) {
            return Observable.from(list);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68837a;

        static {
            int[] iArr = new int[TradeType.values().length];
            f68837a = iArr;
            try {
                iArr[TradeType.LINEAR_SWAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static FutureContractInfoController n() {
        if (f68834a == null) {
            synchronized (FutureContractInfoController.class) {
                if (f68834a == null) {
                    f68834a = new FutureContractInfoController();
                }
            }
        }
        return f68834a;
    }

    public static /* synthetic */ FutureContractInfo u(OptionCurrencyInfo optionCurrencyInfo) {
        FutureContractInfo futureContractInfo = new FutureContractInfo();
        return futureContractInfo.optionConvert(futureContractInfo, optionCurrencyInfo);
    }

    public static /* synthetic */ FutureContractInfo v(LinearSwapContractInfo linearSwapContractInfo) {
        FutureContractInfo futureContractInfo = new FutureContractInfo();
        linearSwapContractInfo.setNotSupportTrade(LinearSwapHiddenInstrumentsController.d(linearSwapContractInfo.getContractCode()));
        return futureContractInfo.convert(futureContractInfo, linearSwapContractInfo);
    }

    public static /* synthetic */ List w(List list, LinearSwapHiddenInstruments linearSwapHiddenInstruments) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            LinearSwapContractInfo linearSwapContractInfo = (LinearSwapContractInfo) it2.next();
            FutureContractInfo futureContractInfo = new FutureContractInfo();
            linearSwapContractInfo.setNotSupportTrade(LinearSwapHiddenInstrumentsController.d(linearSwapContractInfo.getContractCode()));
            arrayList.add(futureContractInfo.convert(futureContractInfo, linearSwapContractInfo));
        }
        return arrayList;
    }

    public static /* synthetic */ FutureContractInfo x(OptionCurrencyInfo optionCurrencyInfo) {
        FutureContractInfo futureContractInfo = new FutureContractInfo();
        return futureContractInfo.optionConvert(futureContractInfo, optionCurrencyInfo);
    }

    public List<FutureContractInfo> e(TradeType tradeType) {
        if (c.f68837a[tradeType.ordinal()] != 1) {
            return new ArrayList();
        }
        return f();
    }

    public List<FutureContractInfo> f() {
        ArrayList arrayList = new ArrayList();
        for (LinearSwapContractInfo convert : LinearSwapCurrencyInfoController.l().g()) {
            FutureContractInfo futureContractInfo = new FutureContractInfo();
            arrayList.add(futureContractInfo.convert(futureContractInfo, convert));
        }
        return arrayList;
    }

    public FutureContractInfo g() {
        LinearSwapContractInfo c11 = LinearSwapCurrencyInfoController.l().c();
        FutureContractInfo futureContractInfo = new FutureContractInfo();
        return c11 != null ? futureContractInfo.convert(futureContractInfo, c11) : futureContractInfo;
    }

    public Observable<List<FutureContractInfo>> h(TradeType tradeType, boolean z11) {
        return q(z11);
    }

    public Observable<List<FutureContractInfo>> i(TradeType tradeType, boolean z11) {
        return p(z11);
    }

    public Observable<List<FutureContractInfo>> j(String str, String str2, String str3, String str4) {
        return OptionCurrencyInfoController.i().h(str, str2, str3, str4).concatMap(new b()).map(z6.c.f62006b).toList();
    }

    public FutureContractInfo k() {
        for (FutureContractInfo next : f()) {
            if (next.isSupportCross()) {
                return next;
            }
        }
        return null;
    }

    public FutureContractInfo l(TradeType tradeType) {
        LinearSwapContractInfo j11;
        if (c.f68837a[tradeType.ordinal()] != 1 || (j11 = LinearSwapCurrencyInfoController.l().j()) == null) {
            return null;
        }
        FutureContractInfo futureContractInfo = new FutureContractInfo();
        return futureContractInfo.convert(futureContractInfo, j11);
    }

    public FutureContractInfo m(String str) {
        LinearSwapContractInfo k11 = LinearSwapCurrencyInfoController.l().k(str);
        if (k11 == null) {
            return null;
        }
        FutureContractInfo futureContractInfo = new FutureContractInfo();
        return futureContractInfo.convert(futureContractInfo, k11);
    }

    public FutureContractInfo o(String str) {
        LinearSwapContractInfo m11 = LinearSwapCurrencyInfoController.l().m(str);
        if (m11 == null) {
            return null;
        }
        FutureContractInfo futureContractInfo = new FutureContractInfo();
        return futureContractInfo.convert(futureContractInfo, m11);
    }

    public Observable<List<FutureContractInfo>> p(boolean z11) {
        return LinearSwapCurrencyInfoController.l().h(z11).concatMap(i.f3526b).map(z6.b.f62005b).toList();
    }

    public Observable<List<FutureContractInfo>> q(boolean z11) {
        return Observable.zip(LinearSwapCurrencyInfoController.l().h(z11).subscribeOn(Schedulers.io()), LinearSwapHiddenInstrumentsController.b(z11).subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null)), e.f62008b);
    }

    public FutureContractInfo r(String str) {
        OptionCurrencyInfo j11 = OptionCurrencyInfoController.i().j(str);
        if (j11 == null) {
            return null;
        }
        FutureContractInfo futureContractInfo = new FutureContractInfo();
        return futureContractInfo.optionConvert(futureContractInfo, j11);
    }

    public Observable<List<FutureContractInfo>> s(boolean z11) {
        return OptionCurrencyInfoController.i().e(z11).concatMap(new a()).map(d.f62007b).toList();
    }

    public List<String> t(TradeType tradeType) {
        return LinearSwapCurrencyInfoController.l().r();
    }
}
