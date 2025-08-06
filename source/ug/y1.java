package ug;

import com.hbg.lib.network.hbg.core.bean.UserStepRateInfo;
import com.huobi.account.entity.BalanceQueryData;
import com.huobi.account.presenter.StepRateSettingPresenter;
import java.util.Map;
import rx.functions.Func6;

public final /* synthetic */ class y1 implements Func6 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StepRateSettingPresenter f60664b;

    public /* synthetic */ y1(StepRateSettingPresenter stepRateSettingPresenter) {
        this.f60664b = stepRateSettingPresenter;
    }

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return this.f60664b.g0((UserStepRateInfo) obj, (UserStepRateInfo) obj2, (UserStepRateInfo) obj3, (Map) obj4, ((Boolean) obj5).booleanValue(), (BalanceQueryData) obj6);
    }
}
