package de;

import com.huobi.contract.helper.ContractOrderHelper;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class j implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f53603b;

    public /* synthetic */ j(Map map) {
        this.f53603b = map;
    }

    public final Object call(Object obj) {
        return ContractOrderHelper.g(this.f53603b).flatMap(o.f53612b).toList();
    }
}
