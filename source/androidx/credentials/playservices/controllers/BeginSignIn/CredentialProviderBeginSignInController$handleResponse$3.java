package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.l;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderBeginSignInController$handleResponse$3 extends Lambda implements a<Unit> {
    public final /* synthetic */ l $response;
    public final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderBeginSignInController$handleResponse$3(CredentialProviderBeginSignInController credentialProviderBeginSignInController, l lVar) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
        this.$response = lVar;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, l lVar) {
        credentialProviderBeginSignInController.getCallback().onResult(lVar);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$3$$ExternalSyntheticLambda0(this.this$0, this.$response));
    }
}
