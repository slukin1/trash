package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnSuccessListener;
import d10.l;

public final /* synthetic */ class CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda1 implements OnSuccessListener {
    public final /* synthetic */ l f$0;

    public /* synthetic */ CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda1(l lVar) {
        this.f$0 = lVar;
    }

    public final void onSuccess(Object obj) {
        CredentialProviderPlayServicesImpl.onClearCredential$lambda$0(this.f$0, obj);
    }
}
