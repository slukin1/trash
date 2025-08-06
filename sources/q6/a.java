package q6;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import u6.g;

public abstract class a<T> extends RequestCallback1<T> {
    private boolean showErrorToast = true;

    /* renamed from: ui  reason: collision with root package name */
    public g f69029ui;

    public a(g gVar) {
        this.f69029ui = gVar;
    }

    public boolean isAlive() {
        g gVar = this.f69029ui;
        if (gVar != null) {
            return gVar.isAlive();
        }
        return super.isAlive();
    }

    public void onError2(Throwable th2) {
    }

    public void onFailed(APIStatusErrorException aPIStatusErrorException) {
    }

    public void onRequestFailure(Throwable th2) {
        if (th2 instanceof APIStatusErrorException) {
            onFailed((APIStatusErrorException) th2);
        } else {
            onError2(th2);
        }
    }

    public a(g gVar, boolean z11) {
        this.f69029ui = gVar;
        this.showErrorToast = z11;
    }
}
