package ug;

import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.account.presenter.SecuritySetPresenter;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import java.util.List;
import rx.functions.Func4;

public final /* synthetic */ class t1 implements Func4 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t1 f60647b = new t1();

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return SecuritySetPresenter.X((UserVO) obj, (SecurityStrategySet) obj2, (UserSecurityInfoData) obj3, (List) obj4);
    }
}
