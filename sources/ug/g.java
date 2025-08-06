package ug;

import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import com.hbg.lib.network.hbg.core.bean.CustomerData;
import com.hbg.lib.network.hbg.core.bean.RewardInfo;
import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.huobi.account.presenter.AccountPresenter;
import java.util.List;
import rx.functions.Func5;

public final /* synthetic */ class g implements Func5 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AccountPresenter f60597b;

    public /* synthetic */ g(AccountPresenter accountPresenter) {
        this.f60597b = accountPresenter;
    }

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return this.f60597b.O0((AccountTaskResp) obj, (List) obj2, (RewardInfo) obj3, (CustomerData) obj4, (SubscribeBox) obj5);
    }
}
