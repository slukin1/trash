package rh;

import com.huobi.contract.entity.ContractHeartBeat;
import rx.functions.Func1;
import uh.c;

public final /* synthetic */ class j implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f25650b;

    public /* synthetic */ j(c cVar) {
        this.f25650b = cVar;
    }

    public final Object call(Object obj) {
        return this.f25650b.l((ContractHeartBeat) obj);
    }
}
