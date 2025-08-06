package bj;

import com.hbg.module.contract.helper.ContractRequestHelper;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class p2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f12478b;

    public /* synthetic */ p2(Map map) {
        this.f12478b = map;
    }

    public final Object call(Object obj) {
        return ContractRequestHelper.b(this.f12478b);
    }
}
