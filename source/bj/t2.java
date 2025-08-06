package bj;

import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.ContractUserInfoActive;
import com.huobi.contract.helper.ContractUserInfoProvider;
import rx.functions.Func1;

public final /* synthetic */ class t2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractUserInfo.UserBean f12500b;

    public /* synthetic */ t2(ContractUserInfo.UserBean userBean) {
        this.f12500b = userBean;
    }

    public final Object call(Object obj) {
        return ContractUserInfoProvider.t(this.f12500b, (ContractUserInfoActive) obj);
    }
}
