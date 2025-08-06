package m9;

import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import q7.a;
import rx.functions.Func1;

public final /* synthetic */ class y implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ y f58142b = new y();

    public final Object call(Object obj) {
        return a.a().fetchUserInfoActive().b().map(new w((SwapUserInfo.UserBean) obj));
    }
}
