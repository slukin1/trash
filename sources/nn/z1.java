package nn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.login.presenter.UserRegisterV2Presenter;
import rx.functions.Action1;

public final /* synthetic */ class z1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58688b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f58689c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f58690d;

    public /* synthetic */ z1(UserRegisterV2Presenter userRegisterV2Presenter, Object obj, Object obj2) {
        this.f58688b = userRegisterV2Presenter;
        this.f58689c = obj;
        this.f58690d = obj2;
    }

    public final void call(Object obj) {
        this.f58688b.p1(this.f58689c, this.f58690d, (APIStatusErrorException) obj);
    }
}
