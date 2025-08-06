package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialException;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CredentialProviderBeginSignInController$handleResponse$4 extends Lambda implements a<Unit> {
    public final /* synthetic */ Ref$ObjectRef<GetCredentialException> $exception;
    public final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderBeginSignInController$handleResponse$4(CredentialProviderBeginSignInController credentialProviderBeginSignInController, Ref$ObjectRef<GetCredentialException> ref$ObjectRef) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
        this.$exception = ref$ObjectRef;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController credentialProviderBeginSignInController, Ref$ObjectRef ref$ObjectRef) {
        credentialProviderBeginSignInController.getCallback().a(ref$ObjectRef.element);
    }

    public final void invoke() {
        this.this$0.getExecutor().execute(new CredentialProviderBeginSignInController$handleResponse$4$$ExternalSyntheticLambda0(this.this$0, this.$exception));
    }
}
