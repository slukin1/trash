package cj;

import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.presenter.ContractTradeBasePresenter;
import rx.functions.Func3;

public final /* synthetic */ class f implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f f13092b = new f();

    public final Object call(Object obj, Object obj2, Object obj3) {
        return ContractTradeBasePresenter.Q1((ContractUserInfo.UserBean) obj, (UserKycInfoNew) obj2, (UnifyKycInfo) obj3);
    }
}
