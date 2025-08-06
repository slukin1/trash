package al;

import com.huobi.finance.utils.Security2FADialogHelper;
import rx.functions.Action1;

public final /* synthetic */ class l0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Security2FADialogHelper f3578b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Security2FADialogHelper.PasskeyAuth f3579c;

    public /* synthetic */ l0(Security2FADialogHelper security2FADialogHelper, Security2FADialogHelper.PasskeyAuth passkeyAuth) {
        this.f3578b = security2FADialogHelper;
        this.f3579c = passkeyAuth;
    }

    public final void call(Object obj) {
        this.f3578b.C(this.f3579c, (String) obj);
    }
}
