package nn;

import com.huobi.login.bean.SecurityVerifyBean;
import com.huobi.login.presenter.ForgetPasswordPresenter;
import rx.functions.Action1;

public final /* synthetic */ class s implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ForgetPasswordPresenter f58653b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58654c;

    public /* synthetic */ s(ForgetPasswordPresenter forgetPasswordPresenter, String str) {
        this.f58653b = forgetPasswordPresenter;
        this.f58654c = str;
    }

    public final void call(Object obj) {
        this.f58653b.l0(this.f58654c, (SecurityVerifyBean) obj);
    }
}
