package de;

import com.hbg.lib.network.swap.core.bean.SwapOrderResult;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class d1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d1 f53589b = new d1();

    public final Object call(Object obj) {
        return Observable.from(((SwapOrderResult) obj).getOrders());
    }
}
