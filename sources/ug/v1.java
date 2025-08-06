package ug;

import com.huobi.account.presenter.StepRateSettingPresenter;
import rx.functions.Action1;

public final /* synthetic */ class v1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StepRateSettingPresenter f60653b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f60654c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f60655d;

    public /* synthetic */ v1(StepRateSettingPresenter stepRateSettingPresenter, boolean z11, boolean z12) {
        this.f60653b = stepRateSettingPresenter;
        this.f60654c = z11;
        this.f60655d = z12;
    }

    public final void call(Object obj) {
        this.f60653b.d0(this.f60654c, this.f60655d, (Boolean) obj);
    }
}
