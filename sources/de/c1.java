package de;

import com.hbg.lib.network.swap.core.bean.SwapOrderResult;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class c1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c1 f53586b = new c1();

    public final Object call(Object obj) {
        return Observable.from(((SwapOrderResult) obj).getOrders());
    }
}
