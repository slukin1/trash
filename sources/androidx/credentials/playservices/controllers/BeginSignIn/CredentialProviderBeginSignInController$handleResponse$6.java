package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialUnknownException;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderBeginSignInController$handleResponse$6 extends Lambda implements a<Unit> {
    public final /* synthetic */ GetCredentialUnknownException $e;
    public final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderBeginSignInController$handleResponse$6(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialUnknownException getCredentialUnknownException) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
        this.$e = getCredentialUnknownException;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, GetCredentialUnknownException getCredentialUnknownException) {
        credentialProviderBeginSignInController.getCallback().a(getCredentialUnknownException);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$6$$ExternalSyntheticLambda0(this.this$0, this.$e));
    }
}
