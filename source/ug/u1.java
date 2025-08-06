package ug;

import com.huobi.account.entity.UserRateInfoAvailableCollection;
import com.huobi.account.presenter.StepRateSettingPresenter;
import rx.functions.Action1;

public final /* synthetic */ class u1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StepRateSettingPresenter f60650b;

    public /* synthetic */ u1(StepRateSettingPresenter stepRateSettingPresenter) {
        this.f60650b = stepRateSettingPresenter;
    }

    public final void call(Object obj) {
        this.f60650b.c0((UserRateInfoAvailableCollection) obj);
    }
}
