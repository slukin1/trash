package un;

import com.huobi.login.v3.presenter.UserLoginPresenter;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginPresenter f60859b;

    public /* synthetic */ b(UserLoginPresenter userLoginPresenter) {
        this.f60859b = userLoginPresenter;
    }

    public final void call(Object obj) {
        this.f60859b.E1((List) obj);
    }
}
