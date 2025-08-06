package un;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.login.v3.presenter.UserLoginPresenter;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class w implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UcIntCodeResponse f60900b;

    public /* synthetic */ w(UcIntCodeResponse ucIntCodeResponse) {
        this.f60900b = ucIntCodeResponse;
    }

    public final void call(Object obj) {
        UserLoginPresenter.Z0(this.f60900b, (Subscriber) obj);
    }
}
