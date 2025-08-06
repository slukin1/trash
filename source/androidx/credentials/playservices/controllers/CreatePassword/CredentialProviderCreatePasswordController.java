package androidx.credentials.playservices.controllers.CreatePassword;

import android.content.Context;
import android.content.Intent;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.credentials.CreatePasswordResponse;
import androidx.credentials.b;
import androidx.credentials.c;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.h;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.HiddenActivity;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SignInPassword;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class CredentialProviderCreatePasswordController extends CredentialProviderController<c, SavePasswordRequest, Unit, b, CreateCredentialException> {
    public static final Companion Companion = new Companion((r) null);
    private static final String TAG = CredentialProviderCreatePasswordController.class.getName();
    /* access modifiers changed from: private */
    public static CredentialProviderCreatePasswordController controller;
    /* access modifiers changed from: private */
    public h<b, CreateCredentialException> callback;
    /* access modifiers changed from: private */
    public CancellationSignal cancellationSignal;
    private final Context context;
    /* access modifiers changed from: private */
    public Executor executor;
    private final CredentialProviderCreatePasswordController$resultReceiver$1 resultReceiver = new CredentialProviderCreatePasswordController$resultReceiver$1(this, new Handler(Looper.getMainLooper()));

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CredentialProviderCreatePasswordController getInstance(Context context) {
            if (CredentialProviderCreatePasswordController.controller == null) {
                CredentialProviderCreatePasswordController.controller = new CredentialProviderCreatePasswordController(context);
            }
            return CredentialProviderCreatePasswordController.controller;
        }
    }

    public CredentialProviderCreatePasswordController(Context context2) {
        super(context2);
        this.context = context2;
    }

    private static /* synthetic */ void getCallback$annotations() {
    }

    private static /* synthetic */ void getCancellationSignal$annotations() {
    }

    public static final CredentialProviderCreatePasswordController getInstance(Context context2) {
        return Companion.getInstance(context2);
    }

    public final void handleResponse$credentials_play_services_auth_release(int i11, int i12) {
        if (i11 != CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE()) {
            String str = TAG;
            Log.w(str, "Returned request code " + CredentialProviderBaseController.getCONTROLLER_REQUEST_CODE() + " which does not match what was given " + i11);
        } else if (!CredentialProviderController.maybeReportErrorResultCodeCreate(i12, CredentialProviderCreatePasswordController$handleResponse$1.INSTANCE, new CredentialProviderCreatePasswordController$handleResponse$2(this), this.cancellationSignal)) {
            CredentialProviderController.cancelOrCallbackExceptionOrResult(this.cancellationSignal, new CredentialProviderCreatePasswordController$handleResponse$3(this, convertResponseToCredentialManager(Unit.f56620a)));
        }
    }

    public SavePasswordRequest convertRequestToPlayServices(c cVar) {
        return SavePasswordRequest.builder().setSignInPassword(new SignInPassword(cVar.c(), cVar.d())).build();
    }

    public b convertResponseToCredentialManager(Unit unit) {
        return new CreatePasswordResponse();
    }

    public void invokePlayServices(c cVar, h<b, CreateCredentialException> hVar, Executor executor2, CancellationSignal cancellationSignal2) {
        this.cancellationSignal = cancellationSignal2;
        this.callback = hVar;
        this.executor = executor2;
        if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal2)) {
            SavePasswordRequest convertRequestToPlayServices = convertRequestToPlayServices(cVar);
            Intent intent = new Intent(this.context, HiddenActivity.class);
            intent.putExtra(CredentialProviderBaseController.REQUEST_TAG, convertRequestToPlayServices);
            generateHiddenActivityIntent(this.resultReceiver, intent, CredentialProviderBaseController.CREATE_PASSWORD_TAG);
            this.context.startActivity(intent);
        }
    }
}
