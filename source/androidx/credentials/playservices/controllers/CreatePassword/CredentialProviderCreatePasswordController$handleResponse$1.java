package androidx.credentials.playservices.controllers.CreatePassword;

import android.os.CancellationSignal;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderCreatePasswordController$handleResponse$1 extends Lambda implements p<CancellationSignal, a<? extends Unit>, Unit> {
    public static final CredentialProviderCreatePasswordController$handleResponse$1 INSTANCE = new CredentialProviderCreatePasswordController$handleResponse$1();

    public CredentialProviderCreatePasswordController$handleResponse$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CancellationSignal) obj, (a<Unit>) (a) obj2);
        return Unit.f56620a;
    }

    public final void invoke(CancellationSignal cancellationSignal, a<Unit> aVar) {
        CredentialProviderController.Companion companion = CredentialProviderController.Companion;
        CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal, aVar);
    }
}
