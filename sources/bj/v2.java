package bj;

import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import rx.functions.Func1;

public final /* synthetic */ class v2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ v2 f12514b = new v2();

    public final Object call(Object obj) {
        return ContractUserInfoProvider.w((ContractUserInfo.UserBean) obj);
    }
}
