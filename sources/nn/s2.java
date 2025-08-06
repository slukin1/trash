package nn;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.huobi.login.presenter.UserRegisterV2Presenter;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class s2 implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UcIntCodeResponse f58657b;

    public /* synthetic */ s2(UcIntCodeResponse ucIntCodeResponse) {
        this.f58657b = ucIntCodeResponse;
    }

    public final void call(Object obj) {
        UserRegisterV2Presenter.L0(this.f58657b, (Subscriber) obj);
    }
}
