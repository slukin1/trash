package oa;

import com.hbg.lib.widgets.utils.HuobiToastUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final /* synthetic */ class c implements InvocationHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f58805b;

    public /* synthetic */ c(Object obj) {
        this.f58805b = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return HuobiToastUtil.e(this.f58805b, obj, method, objArr);
    }
}
