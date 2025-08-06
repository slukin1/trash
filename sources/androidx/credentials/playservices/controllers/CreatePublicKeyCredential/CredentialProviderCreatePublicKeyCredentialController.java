package androidx.credentials.playservices.controllers.CreatePublicKeyCredential;

import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.credentials.b;
import androidx.credentials.d;
import androidx.credentials.e;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.publickeycredential.CreatePublicKeyCredentialDomException;
import androidx.credentials.h;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;
import org.json.JSONException;

public final class CredentialProviderCreatePublicKeyCredentialController extends CredentialProviderController<d, PublicKeyCredentialCreationOptions, PublicKeyCredential, b, CreateCredentialException> {
    public static final Companion Companion = new Companion((r) null);
    private static final String TAG = CredentialProviderCreatePublicKeyCredentialController.class.getName();
    /* access modifiers changed from: private */
    public static CredentialProviderCreatePublicKeyCredentialController controller;
    /* access modifiers changed from: private */
    public h<b, CreateCredentialException> callback;
    /* access modifiers changed from: private */
    public CancellationSignal cancellationSignal;
    private final Context context;
    /* access modifiers changed from: private */
    public Executor executor;
    private final CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1 resultReceiver = new CredentialProviderCreatePublicKeyCredentialController$resultReceiver$1(this, new Handler(Looper.getMainLooper()));

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CredentialProviderCreatePublicKeyCredentialController getInstance(Context context) {
            if (CredentialProviderCreatePublicKeyCredentialController.controller == null) {
                CredentialProviderCreatePublicKeyCredentialController.controller = new CredentialProviderCreatePublicKeyCredentialController(context);
            }
            return CredentialProviderCreatePublicKeyCredentialController.controller;
        }
    }

    public CredentialProviderCreatePublicKeyCredentialController(Context context2) {
        super(context2);
        this.context = context2;
    }

    private static /* synthetic */ void getCallback$annotations() {
    }

    private static /* synthetic */ void getCancellationSignal$annotations() {
    }

    private static /* synthetic */ void getExecutor$annotations() {
    }

    public static final CredentialProviderCreatePublicKeyCredentialController getInstance(Context context2) {
        return Companion.getInstance(context2);
    }

    /* access modifiers changed from: private */
    public static final void handleResponse$lambda$0(CredentialProviderCreatePublicKeyCredentialController credentialProviderCreatePublicKeyCredentialController) {
        h<b, CreateCredentialException> hVar = credentialProviderCreatePublicKeyCredentialController.callback;
        if (hVar == null) {
            hVar = null;
        }
        hVar.a(new CreatePublicKeyCredentialDomException(new UnknownError(), "Upon handling create public key credential response, fido module giving null bytes indicating internal error"));
    }

    public final void handleResponse$credentials_play_services_auth_release(int i11, int i12, Intent intent) {
        if (i11 != CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE()) {
            String str = TAG;
            Log.w(str, "Returned request code " + CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE() + " does not match what was given " + i11);
        } else if (!CredentialProviderController.maybeReportErrorResultCodeCreate(i12, CredentialProviderCreatePublicKeyCredentialController$handleResponse$1.INSTANCE, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$2(this), this.cancellationSignal)) {
            Executor executor2 = null;
            byte[] byteArrayExtra = intent != null ? intent.getByteArrayExtra(Fido.FIDO2_KEY_CREDENTIAL_EXTRA) : null;
            if (byteArrayExtra != null) {
                PublicKeyCredential deserializeFromBytes = PublicKeyCredential.deserializeFromBytes(byteArrayExtra);
                CreateCredentialException publicKeyCredentialResponseContainsError = PublicKeyCredentialControllerUtility.Companion.publicKeyCredentialResponseContainsError(deserializeFromBytes);
                if (publicKeyCredentialResponseContainsError != null) {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$4(this, publicKeyCredentialResponseContainsError));
                    return;
                }
                try {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$5(this, convertResponseToCredentialManager(deserializeFromBytes)));
                } catch (JSONException e11) {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$6(this, e11));
                } catch (Throwable th2) {
                    CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePublicKeyCredentialController$handleResponse$7(this, th2));
                }
            } else if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(this.cancellationSignal)) {
                Executor executor3 = this.executor;
                if (executor3 != null) {
                    executor2 = executor3;
                }
                executor2.execute(new CredentialProviderCreatePublicKeyCredentialController$$ExternalSyntheticLambda0(this));
            }
        }
    }

    public PublicKeyCredentialCreationOptions convertRequestToPlayServices(d dVar) {
        return PublicKeyCredentialControllerUtility.Companion.convert(dVar);
    }

    public b convertResponseToCredentialManager(PublicKeyCredential publicKeyCredential) {
        return new e(PublicKeyCredentialControllerUtility.Companion.toCreatePasskeyResponseJson(publicKeyCredential));
    }

    public void invokePlayServices(d dVar, h<b, CreateCredentialException> hVar, Executor executor2, CancellationSignal cancellationSignal2) {
        this.cancellationSignal = cancellationSignal2;
        this.callback = hVar;
        this.executor = executor2;
        try {
            PublicKeyCredentialCreationOptions convertRequestToPlayServices = convertRequestToPlayServices(dVar);
            if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal2)) {
                Intent intent = new Intent(this.context, HiddenActivity.class);
                intent.putExtra(CredentialProviderBaseController.REQUEST_TAG, convertRequestToPlayServices);
                generateHiddenActivityIntent(this.resultReceiver, intent, CredentialProviderBaseController.CREATE_PUBLIC_KEY_CREDENTIAL_TAG);
                this.context.startActivity(intent);
            }
        } catch (JSONException e11) {
            CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$1(this, e11));
        } catch (Throwable th2) {
            CredentialProviderController.cancelOrCallbackExceptionOrResult(cancellationSignal2, new CredentialProviderCreatePublicKeyCredentialController$invokePlayServices$2(this, th2));
        }
    }
}
