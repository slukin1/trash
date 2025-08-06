package iq;

import com.hbg.lib.network.hbg.core.bean.AccountBalanceInfo;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.points.presenter.PointsTransferPresenter;
import rx.functions.Func2;

public final /* synthetic */ class s implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ s f55831b = new s();

    public final Object call(Object obj, Object obj2) {
        return PointsTransferPresenter.d0((BalanceQueryData) obj, (AccountBalanceInfo) obj2);
    }
}
