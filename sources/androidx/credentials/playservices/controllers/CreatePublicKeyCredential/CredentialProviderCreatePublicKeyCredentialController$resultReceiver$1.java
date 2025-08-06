package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.credentials.h;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import java.util.concurrent.Executor;

public final class CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1 extends ResultReceiver {
    public final /* synthetic */ CredentialProviderCreatePublicKeyCredentialController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController, Handler handler) {
        super(handler);
        this.this$0 = credentialProviderCreatePublicKeyCredentialController;
    }

    public void onReceiveResult(int i11, Bundle bundle) {
        CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController = this.this$0;
        CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1 credentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1 = new CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.Companion);
        Executor access$getExecutor$p = this.this$0.executor;
        Executor executor = access$getExecutor$p == null ? null : access$getExecutor$p;
        h access$getCallback$p = this.this$0.callback;
        if (!credentialProviderCreatePublicKeyCredentialController.maybeReportErrorFromResultReceiver(bundle, credentialProviderCreatePublicKeyCredentialController$resultReceiver$1$onReceiveResult$1, executor, access$getCallback$p == null ? null : access$getCallback$p, this.this$0.cancellationSignal)) {
            this.this$0.handleResponse$credentials_play_services_auth_release(bundle.getInt(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG), i11, (Intent) bundle.getParcelable(CredentialProviderBaseController.RESULT_DATA_TAG));
        }
    }
}
