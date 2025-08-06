package bj;

import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import rx.functions.Action1;

public final /* synthetic */ class s2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractUserInfoProvider f12496b;

    public /* synthetic */ s2(ContractUserInfoProvider contractUserInfoProvider) {
        this.f12496b = contractUserInfoProvider;
    }

    public final void call(Object obj) {
        this.f12496b.v((ContractUserInfo.UserBean) obj);
    }
}
