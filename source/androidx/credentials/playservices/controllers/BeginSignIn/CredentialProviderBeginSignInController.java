package androidx.credentials.playservices.controllers.BeginSignIn;

import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.f;
import androidx.credentials.h;
import androidx.credentials.l;
import androidx.credentials.o;
import androidx.credentials.p;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.PublicKeyCredentialControllerUtility;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;

public final class CredentialProviderBeginSignInController extends CredentialProviderController<GetCredentialRequest, BeginSignInRequest, SignInCredential, l, GetCredentialException> {
    public static final Companion Companion = new Companion((r) null);
    private static final String TAG = CredentialProviderBeginSignInController.class.getName();
    /* access modifiers changed from: private */
    public static CredentialProviderBeginSignInController controller;
    public h<l, GetCredentialException> callback;
    /* access modifiers changed from: private */
    public CancellationSignal cancellationSignal;
    private final Context context;
    public Executor executor;
    private final CredentialProviderBeginSignInController$resultReceiver$1 resultReceiver = new CredentialProviderBeginSignInController$resultReceiver$1(this, new Handler(Looper.getMainLooper()));

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CredentialProviderBeginSignInController getInstance(Context context) {
            if (CredentialProviderBeginSignInController.controller == null) {
                CredentialProviderBeginSignInController.controller = new CredentialProviderBeginSignInController(context);
            }
            return CredentialProviderBeginSignInController.controller;
        }
    }

    public CredentialProviderBeginSignInController(Context context2) {
        super(context2);
        this.context = context2;
    }

    private final GoogleIdTokenCredential createGoogleIdCredential(SignInCredential signInCredential) {
        GoogleIdTokenCredential.Builder idToken = new GoogleIdTokenCredential.Builder().setId(signInCredential.getId()).setIdToken(signInCredential.getGoogleIdToken());
        if (signInCredential.getDisplayName() != null) {
            idToken.setDisplayName(signInCredential.getDisplayName());
        }
        if (signInCredential.getGivenName() != null) {
            idToken.setGivenName(signInCredential.getGivenName());
        }
        if (signInCredential.getFamilyName() != null) {
            idToken.setFamilyName(signInCredential.getFamilyName());
        }
        if (signInCredential.getPhoneNumber() != null) {
            idToken.setPhoneNumber(signInCredential.getPhoneNumber());
        }
        if (signInCredential.getProfilePictureUri() != null) {
            idToken.setProfilePictureUri(signInCredential.getProfilePictureUri());
        }
        return idToken.build();
    }

    public static /* synthetic */ void getCallback$annotations() {
    }

    private static /* synthetic */ void getCancellationSignal$annotations() {
    }

    public static /* synthetic */ void getExecutor$annotations() {
    }

    public static final CredentialProviderBeginSignInController getInstance(Context context2) {
        return Companion.getInstance(context2);
    }

    public final h<l, GetCredentialException> getCallback() {
        h<l, GetCredentialException> hVar = this.callback;
        if (hVar != null) {
            return hVar;
        }
        return null;
    }

    public final Executor getExecutor() {
        Executor executor2 = this.executor;
        if (executor2 != null) {
            return executor2;
        }
        return null;
    }

    public final void handleResponse$credentials_play_services_auth_release(int i11, int i12, Intent intent) {
        if (i11 != CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE()) {
            String str = TAG;
            Log.w(str, "Returned request code " + CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE() + " which  does not match what was given " + i11);
        } else if (!CredentialProviderController.maybeReportErrorResultCodeGet(i12, CredentialProviderBeginSignInController$handleResponse$1.INSTANCE, new CredentialProviderBeginSignInController$handleResponse$2(this), this.cancellationSignal)) {
            try {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderBeginSignInController$handleResponse$3(this, convertResponseToCredentialManager(Identity.getSignInClient(this.context).getSignInCredentialFromIntent(intent))));
            } catch (ApiException e11) {
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = new GetCredentialUnknownException(e11.getMessage());
                if (e11.getStatusCode() == 16) {
                    ref$ObjectRef.element = new GetCredentialCancellationException(e11.getMessage());
                } else if (CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(e11.getStatusCode()))) {
                    ref$ObjectRef.element = new GetCredentialInterruptedException(e11.getMessage());
                }
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderBeginSignInController$handleResponse$4(this, ref$ObjectRef));
            } catch (GetCredentialException e12) {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderBeginSignInController$handleResponse$5(this, e12));
            } catch (Throwable th2) {
                CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderBeginSignInController$handleResponse$6(this, new GetCredentialUnknownException(th2.getMessage())));
            }
        }
    }

    public final void setCallback(h<l, GetCredentialException> hVar) {
        this.callback = hVar;
    }

    public final void setExecutor(Executor executor2) {
        this.executor = executor2;
    }

    public BeginSignInRequest convertRequestToPlayServices(GetCredentialRequest getCredentialRequest) {
        return BeginSignInControllerUtility.Companion.constructBeginSignInRequest$credentials_play_services_auth_release(getCredentialRequest, this.context);
    }

    public l convertResponseToCredentialManager(SignInCredential signInCredential) {
        f fVar;
        if (signInCredential.getPassword() != null) {
            fVar = new o(signInCredential.getId(), signInCredential.getPassword());
        } else if (signInCredential.getGoogleIdToken() != null) {
            fVar = createGoogleIdCredential(signInCredential);
        } else if (signInCredential.getPublicKeyCredential() != null) {
            fVar = new p(PublicKeyCredentialControllerUtility.Companion.toAssertPasskeyResponse(signInCredential));
        } else {
            Log.w(TAG, "Credential returned but no google Id or password or passkey found");
            fVar = null;
        }
        if (fVar != null) {
            return new l(fVar);
        }
        throw new GetCredentialUnknownException("When attempting to convert get response, null credential found");
    }

    public void invokePlayServices(GetCredentialRequest getCredentialRequest, h<l, GetCredentialException> hVar, Executor executor2, CancellationSignal cancellationSignal2) {
        this.cancellationSignal = cancellationSignal2;
        setCallback(hVar);
        setExecutor(executor2);
        if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal2)) {
            BeginSignInRequest convertRequestToPlayServices = convertRequestToPlayServices(getCredentialRequest);
            Intent intent = new Intent(this.context, HiddenActivity.class);
            intent.putExtra(CredentialProviderBaseController.REQUEST_TAG, convertRequestToPlayServices);
            generateHiddenActivityIntent(this.resultReceiver, intent, CredentialProviderBaseController.BEGIN_SIGN_IN_TAG);
            this.context.startActivity(intent);
        }
    }
}
