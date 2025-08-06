package iq;

import com.huobi.points.presenter.MyTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyTransferPresenter f55799b;

    public /* synthetic */ d(MyTransferPresenter myTransferPresenter) {
        this.f55799b = myTransferPresenter;
    }

    public final void call(Object obj) {
        this.f55799b.W((Long) obj);
    }
}
