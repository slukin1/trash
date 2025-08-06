package nn;

import com.huobi.login.presenter.UserRegisterV2Presenter;
import rx.functions.Action1;

public final /* synthetic */ class a2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterV2Presenter f58561b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f58562c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f58563d;

    public /* synthetic */ a2(UserRegisterV2Presenter userRegisterV2Presenter, Object obj, Object obj2) {
        this.f58561b = userRegisterV2Presenter;
        this.f58562c = obj;
        this.f58563d = obj2;
    }

    public final void call(Object obj) {
        this.f58561b.q1(this.f58562c, this.f58563d, (Throwable) obj);
    }
}
