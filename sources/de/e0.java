package de;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderResult;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class e0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e0 f53591b = new e0();

    public final Object call(Object obj) {
        return Observable.from(((LinearSwapOrderResult) obj).getOrders());
    }
}
