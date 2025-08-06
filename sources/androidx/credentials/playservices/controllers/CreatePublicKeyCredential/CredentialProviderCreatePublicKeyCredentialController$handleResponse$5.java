package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.b;
import androidx.credentials.h;
import d10.a;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderCreatePublicKeyCredentialController$handleResponse$5 extends Lambda implements a<Unit> {
    public final /* synthetic */ b $response;
    public final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderCreatePublicKeyCredentialController$handleResponse$5(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, b bVar) {
        super(0);
        this.this$0 = credentialProviderCreatePublicKeyCredentialController;
        this.$response = bVar;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, b bVar) {
        h access$getCallback$p = credentialProviderCreatePublicKeyCredentialController.callback;
        if (access$getCallback$p == null) {
            access$getCallback$p = null;
        }
        access$getCallback$p.onResult(bVar);
    }

    public final void invoke() {
        Executor access$getExecutor$p = this.this$0.executor;
        if (access$getExecutor$p == null) {
            access$getExecutor$p = null;
        }
        access$getExecutor$p.execute(new CredentialProviderCreatePublicKeyCredentialController$handleResponse$5$$ExternalSyntheticLambda0(this.this$0, this.$response));
    }
}
