package jp;

import com.hbg.lib.network.otc.core.bean.FunctionAvailableBean;
import rx.functions.Func1;

public final /* synthetic */ class a1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a1 f55995b = new a1();

    public final Object call(Object obj) {
        return Boolean.valueOf(!((FunctionAvailableBean) obj).getAvailable().booleanValue());
    }
}
