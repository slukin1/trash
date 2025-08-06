package rh;

import com.huobi.contract.entity.ContractUserInfo;
import rx.functions.Func1;
import uh.c;

public final /* synthetic */ class l implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f25652b;

    public /* synthetic */ l(c cVar) {
        this.f25652b = cVar;
    }

    public final Object call(Object obj) {
        return this.f25652b.m((ContractUserInfo.UserBean) obj);
    }
}
