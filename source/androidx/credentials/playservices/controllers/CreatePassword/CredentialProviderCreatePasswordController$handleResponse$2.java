package androidx.credentials.playservices.controllers.CreatePassword;

import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.h;
import d10.l;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderCreatePasswordController$handleResponse$2 extends Lambda implements l<CreateCredentialException, Unit> {
    public final /* synthetic */ CredentialProviderCreatePasswordController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderCreatePasswordController$handleResponse$2(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController) {
        super(1);
        this.this$0 = credentialProviderCreatePasswordController;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderCreatePasswordController credentialProviderCreatePasswordController, CreateCredentialException createCredentialException) {
        h access$getCallback$p = credentialProviderCreatePasswordController.callback;
        if (access$getCallback$p == null) {
            access$getCallback$p = null;
        }
        access$getCallback$p.a(createCredentialException);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CreateCredentialException) obj);
        return Unit.f56620a;
    }

    public final void invoke(CreateCredentialException createCredentialException) {
        Executor access$getExecutor$p = this.this$0.executor;
        if (access$getExecutor$p == null) {
            access$getExecutor$p = null;
        }
        access$getExecutor$p.execute(new CredentialProviderCreatePasswordController$handleResponse$2$$ExternalSyntheticLambda0(this.this$0, createCredentialException));
    }
}
