package de;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderResult;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class f0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f0 f53594b = new f0();

    public final Object call(Object obj) {
        return Observable.from(((LinearSwapOrderResult) obj).getOrders());
    }
}
