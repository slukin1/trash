package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import rx.functions.Action1;

public final /* synthetic */ class b2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58568b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f58569c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f58570d;

    public /* synthetic */ b2(UserRegisterV2Presenter userRegisterV2Presenter, Object obj, Object obj2) {
        this.f58568b = userRegisterV2Presenter;
        this.f58569c = obj;
        this.f58570d = obj2;
    }

    public final void call(Object obj) {
        this.f58568b.o1(this.f58569c, this.f58570d, obj);
    }
}
