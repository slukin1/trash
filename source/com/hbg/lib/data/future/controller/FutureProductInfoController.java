package com.hbg.lib.data.future.controller;

import com.hbg.lib.data.future.bean.FutureProductInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import com.hbg.lib.network.option.controller.OptionProductInfoController;
import com.hbg.lib.network.option.core.bean.OptionProductInfo;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import z6.h;
import z6.i;

public class FutureProductInfoController {

    /* renamed from: a  reason: collision with root package name */
    public static volatile FutureProductInfoController f68839a;

    public class a implements Func1<List<OptionProductInfo>, Observable<OptionProductInfo>> {
        public a() {
        }

        /* renamed from: a */
        public Observable<OptionProductInfo> call(List<OptionProductInfo> list) {
            return Observable.from(list);
        }
    }

    public class b implements Func1<List<LinearSwapProductInfo>, Observable<LinearSwapProductInfo>> {
        public b() {
        }

        /* renamed from: a */
        public Observable<LinearSwapProductInfo> call(List<LinearSwapProductInfo> list) {
            return Observable.from(list);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68842a;

        static {
            int[] iArr = new int[TradeType.values().length];
            f68842a = iArr;
            try {
                iArr[TradeType.LINEAR_SWAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static FutureProductInfoController d() {
        if (f68839a == null) {
            synchronized (FutureProductInfoController.class) {
                if (f68839a == null) {
                    f68839a = new FutureProductInfoController();
                }
            }
        }
        return f68839a;
    }

    public static /* synthetic */ FutureProductInfo k(LinearSwapProductInfo linearSwapProductInfo) {
        FutureProductInfo futureProductInfo = new FutureProductInfo();
        return futureProductInfo.convert(futureProductInfo, linearSwapProductInfo);
    }

    public static /* synthetic */ FutureProductInfo l(OptionProductInfo optionProductInfo) {
        FutureProductInfo futureProductInfo = new FutureProductInfo();
        return futureProductInfo.optionConvert(futureProductInfo, optionProductInfo);
    }

    public List<FutureProductInfo> c() {
        ArrayList arrayList = new ArrayList();
        for (OptionProductInfo optionConvert : OptionProductInfoController.h().c()) {
            FutureProductInfo futureProductInfo = new FutureProductInfo();
            arrayList.add(futureProductInfo.optionConvert(futureProductInfo, optionConvert));
        }
        return arrayList;
    }

    public Observable<List<FutureProductInfo>> e(boolean z11) {
        return f(false, z11);
    }

    public Observable<List<FutureProductInfo>> f(boolean z11, boolean z12) {
        Observable<List<LinearSwapProductInfo>> observable;
        if (z11) {
            observable = LinearSwapProductInfoController.o().j(z12);
        } else {
            observable = LinearSwapProductInfoController.o().h(z12);
        }
        return observable.concatMap(new b()).map(h.f62011b).toList();
    }

    public FutureProductInfo g(String str) {
        OptionProductInfo m11 = OptionProductInfoController.h().m(str);
        if (m11 == null) {
            return null;
        }
        FutureProductInfo futureProductInfo = new FutureProductInfo();
        return futureProductInfo.optionConvert(futureProductInfo, m11);
    }

    public Observable<List<FutureProductInfo>> h(boolean z11) {
        return OptionProductInfoController.h().d(z11).concatMap(new a()).map(i.f62012b).toList();
    }

    public Observable<List<FutureProductInfo>> i(TradeType tradeType, boolean z11) {
        if (c.f68842a[tradeType.ordinal()] != 1) {
            return h(z11);
        }
        return e(z11);
    }

    public List<String> j() {
        return OptionProductInfoController.h().n();
    }
}
