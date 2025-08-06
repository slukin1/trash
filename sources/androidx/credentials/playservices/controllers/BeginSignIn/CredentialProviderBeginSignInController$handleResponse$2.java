package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialException;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderBeginSignInController$handleResponse$2 extends Lambda implements l<GetCredentialException, Unit> {
    public final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderBeginSignInController$handleResponse$2(CredentialProviderBeginSignInController credentialProviderBeginSignInController) {
        super(1);
        this.this$0 = credentialProviderBeginSignInController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialException getCredentialException) {
        credentialProviderBeginSignInController.getCallback().a(getCredentialException);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GetCredentialException) obj);
        return Unit.f56620a;
    }

    public final void invoke(GetCredentialException getCredentialException) {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$2$$ExternalSyntheticLambda0(this.this$0, getCredentialException));
    }
}
