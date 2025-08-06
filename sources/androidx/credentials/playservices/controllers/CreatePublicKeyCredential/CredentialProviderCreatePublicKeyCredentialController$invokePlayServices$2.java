package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.h;
import d10.a;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$2 extends Lambda implements a<Unit> {
    public final /* synthetic */ Throwable $t;
    public final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$2(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, Throwable th2) {
        super(0);
        this.this$0 = credentialProviderCreatePublicKeyCredentialController;
        this.$t = th2;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, Throwable th2) {
        h access$getCallback$p = credentialProviderCreatePublicKeyCredentialController.callback;
        if (access$getCallback$p == null) {
            access$getCallback$p = null;
        }
        access$getCallback$p.a(new CreateCredentialUnknownException(th2.getMessage()));
    }

    public final void invoke() {
        Executor access$getExecutor$p = this.this$0.executor;
        if (access$getExecutor$p == null) {
            access$getExecutor$p = null;
        }
        access$getExecutor$p.execute(new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$2$$ExternalSyntheticLambda0(this.this$0, this.$t));
    }
}
