package nn;

import android.content.Intent;
import c6.b;
import com.huobi.login.presenter.SetForgetPswPresenter;

public final /* synthetic */ class m1 implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SetForgetPswPresenter f58628b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f58629c;

    public /* synthetic */ m1(SetForgetPswPresenter setForgetPswPresenter, Intent intent) {
        this.f58628b = setForgetPswPresenter;
        this.f58629c = intent;
    }

    public final void onCallback(Object obj) {
        this.f58628b.i0(this.f58629c, obj);
    }
}
