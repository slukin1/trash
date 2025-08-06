package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.UserRegisterV2Presenter;
import rx.functions.Action1;

public final /* synthetic */ class i2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ i2 f58610b = new i2();

    public final void call(Object obj) {
        UserRegisterV2Presenter.e1((APIStatusErrorException) obj);
    }
}
