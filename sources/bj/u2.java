package bj;

import com.huobi.contract.entity.ContractUserInfo;
import q7.a;
import rx.functions.Func1;

public final /* synthetic */ class u2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ u2 f12505b = new u2();

    public final Object call(Object obj) {
        return a.a().fetchUserInfoActive().b().map(new t2((ContractUserInfo.UserBean) obj));
    }
}
