package al;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.utils.Security2FADialogHelper;
import rx.functions.Action1;

public final /* synthetic */ class i0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Security2FADialogHelper f3575b;

    public /* synthetic */ i0(Security2FADialogHelper security2FADialogHelper) {
        this.f3575b = security2FADialogHelper;
    }

    public final void call(Object obj) {
        this.f3575b.z((APIStatusErrorException) obj);
    }
}
