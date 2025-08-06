package al;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.utils.Security2FADialogHelper;
import rx.functions.Action1;

public final /* synthetic */ class h0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Security2FADialogHelper f3574b;

    public /* synthetic */ h0(Security2FADialogHelper security2FADialogHelper) {
        this.f3574b = security2FADialogHelper;
    }

    public final void call(Object obj) {
        this.f3574b.D((APIStatusErrorException) obj);
    }
}
