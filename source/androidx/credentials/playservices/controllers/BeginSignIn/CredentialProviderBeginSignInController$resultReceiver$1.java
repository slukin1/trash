package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;

public final class CredentialProviderBeginSignInController$resultReceiver$1 extends ResultReceiver {
    public final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CredentialProviderBeginSignInController$resultReceiver$1(CredentialProviderBeginSignInController credentialProviderBeginSignInController, Handler handler) {
        super(handler);
        this.this$0 = credentialProviderBeginSignInController;
    }

    public void onReceiveResult(int i11, Bundle bundle) {
        if (!this.this$0.maybeReportErrorFromResultReceiver(bundle, new CredentialProviderBeginSignInController$resultReceiver$1$onReceiveResult$1(CredentialProviderBaseController.Companion), this.this$0.getExecutor(), this.this$0.getCallback(), this.this$0.cancellationSignal)) {
            this.this$0.handleResponse$credentials_play_services_auth_release(bundle.getInt(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG), i11, (Intent) bundle.getParcelable(CredentialProviderBaseController.RESULT_DATA_TAG));
        }
    }
}
