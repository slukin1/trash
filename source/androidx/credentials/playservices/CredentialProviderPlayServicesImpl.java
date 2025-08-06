package androidx.credentials.playservices;

import android.app.Activity;
import android.content.Context;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.a;
import androidx.credentials.b;
import androidx.credentials.c;
import androidx.credentials.d;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.h;
import androidx.credentials.j;
import androidx.credentials.playservices.controllers.BeginSignIn.CredentialProviderBeginSignInController;
import androidx.credentials.playservices.controllers.CreatePassword.CredentialProviderCreatePasswordController;
import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.common.GoogleApiAvailability;
import d10.l;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;

public final class CredentialProviderPlayServicesImpl implements j {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final String TAG = CredentialProviderPlayServicesImpl.class.getName();
    private final Context context;
    private GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final boolean cancellationReviewer$credentials_play_services_auth_release(CancellationSignal cancellationSignal) {
            if (cancellationSignal == null) {
                Log.i(CredentialProviderPlayServicesImpl.TAG, "No cancellationSignal found");
                return false;
            } else if (!cancellationSignal.isCanceled()) {
                return false;
            } else {
                Log.i(CredentialProviderPlayServicesImpl.TAG, "the flow has been canceled");
                return true;
            }
        }
    }

    public CredentialProviderPlayServicesImpl(Context context2) {
        this.context = context2;
    }

    public static /* synthetic */ void getGoogleApiAvailability$annotations() {
    }

    private final int isGooglePlayServicesAvailable(Context context2) {
        return this.googleApiAvailability.isGooglePlayServicesAvailable(context2);
    }

    /* access modifiers changed from: private */
    public static final void onClearCredential$lambda$0(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void onClearCredential$lambda$4(CredentialProviderPlayServicesImpl credentialProviderPlayServicesImpl, CancellationSignal cancellationSignal, Executor executor, h hVar, Exception exc) {
        if (!(cancellationSignal != null ? cancellationSignal.isCanceled() : false)) {
            String str = TAG;
            Log.w(str, "During clear credential sign out failed with " + exc);
            executor.execute(new CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda2(hVar, exc));
        }
    }

    /* access modifiers changed from: private */
    public static final void onClearCredential$lambda$4$lambda$3$lambda$2(h hVar, Exception exc) {
        hVar.a(new ClearCredentialUnknownException(exc.getMessage()));
    }

    public final GoogleApiAvailability getGoogleApiAvailability() {
        return this.googleApiAvailability;
    }

    public boolean isAvailableOnDevice() {
        return isGooglePlayServicesAvailable(this.context) == 0;
    }

    public void onClearCredential(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, Executor executor, h<Void, ClearCredentialException> hVar) {
        if (!Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
            Identity.getSignInClient(this.context).signOut().addOnSuccessListener(new CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda1(new CredentialProviderPlayServicesImpl$onClearCredential$1(cancellationSignal, executor, hVar))).addOnFailureListener(new CredentialProviderPlayServicesImpl$$ExternalSyntheticLambda0(this, cancellationSignal, executor, hVar));
        }
    }

    public void onCreateCredential(a aVar, Activity activity, CancellationSignal cancellationSignal, Executor executor, h<b, CreateCredentialException> hVar) {
        if (!Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
            if (aVar instanceof c) {
                CredentialProviderCreatePasswordController.Companion.getInstance(activity).invokePlayServices((c) aVar, hVar, executor, cancellationSignal);
            } else if (aVar instanceof d) {
                CredentialProviderCreatePublicKeyCredentialController.Companion.getInstance(activity).invokePlayServices((d) aVar, hVar, executor, cancellationSignal);
            } else {
                throw new UnsupportedOperationException("Create Credential request is unsupported, not password or publickeycredential");
            }
        }
    }

    public void onGetCredential(GetCredentialRequest getCredentialRequest, Activity activity, CancellationSignal cancellationSignal, Executor executor, h<androidx.credentials.l, GetCredentialException> hVar) {
        if (!Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
            new CredentialProviderBeginSignInController(activity).invokePlayServices(getCredentialRequest, hVar, executor, cancellationSignal);
        }
    }

    public final void setGoogleApiAvailability(GoogleApiAvailability googleApiAvailability2) {
        this.googleApiAvailability = googleApiAvailability2;
    }
}
