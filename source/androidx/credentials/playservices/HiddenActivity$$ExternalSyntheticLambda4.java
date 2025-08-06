package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnSuccessListener;
import d10.l;

public final /* synthetic */ class HiddenActivity$$ExternalSyntheticLambda4 implements OnSuccessListener {
    public final /* synthetic */ l f$0;

    public /* synthetic */ HiddenActivity$$ExternalSyntheticLambda4(l lVar) {
        this.f$0 = lVar;
    }

    public final void onSuccess(Object obj) {
        HiddenActivity.handleCreatePublicKeyCredential$lambda$2$lambda$0(this.f$0, obj);
    }
}
