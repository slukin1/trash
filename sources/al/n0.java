package al;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.utils.Security2FADialogHelper;
import rx.functions.Action1;

public final /* synthetic */ class n0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Security2FADialogHelper.g f3584b;

    public /* synthetic */ n0(Security2FADialogHelper.g gVar) {
        this.f3584b = gVar;
    }

    public final void call(Object obj) {
        this.f3584b.d0((APIStatusErrorException) obj);
    }
}
