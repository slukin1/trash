package androidx.credentials.playservices;

import android.os.CancellationSignal;
import androidx.credentials.h;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.concurrent.Executor;

public final /* synthetic */ class CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda0 implements OnFailureListener {
    public final /* synthetic */ CredentialProviderPlayServicesImpl f$0;
    public final /* synthetic */ CancellationSignal f$1;
    public final /* synthetic */ Executor f$2;
    public final /* synthetic */ h f$3;

    public /* synthetic */ CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda0(CredentialProviderPlayServicesImpl credentialProviderPlayServicesImpl, CancellationSignal cancellationSignal, Executor executor, h hVar) {
        this.f$0 = credentialProviderPlayServicesImpl;
        this.f$1 = cancellationSignal;
        this.f$2 = executor;
        this.f$3 = hVar;
    }

    public final void onFailure(Exception exc) {
        CredentialProviderPlayServicesImpl.onClearCredential$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, exc);
    }
}
