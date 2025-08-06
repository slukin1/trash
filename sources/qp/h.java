package qp;

import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.persenter.OtcFAQPresenter;
import rx.functions.Func3;

public final /* synthetic */ class h implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ h f60079b = new h();

    public final Object call(Object obj, Object obj2, Object obj3) {
        return OtcFAQPresenter.Y((UserVO) obj, (SecurityStrategySet) obj2, (UserSecurityInfoData) obj3);
    }
}
