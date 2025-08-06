package jp;

import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.helper.OtcSecurityTokenFactory;
import rx.functions.Func2;

public final /* synthetic */ class i1 implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ i1 f56029b = new i1();

    public final Object call(Object obj, Object obj2) {
        return OtcSecurityTokenFactory.p((UserSecurityInfoData) obj, (SecurityStrategySet) obj2);
    }
}
