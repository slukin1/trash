package bj;

import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.helper.ContractAccountConfigImpl;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractAccountConfigImpl f12405b;

    public /* synthetic */ b(ContractAccountConfigImpl contractAccountConfigImpl) {
        this.f12405b = contractAccountConfigImpl;
    }

    public final void call(Object obj) {
        this.f12405b.j((ContractHeartBeat) obj);
    }
}
