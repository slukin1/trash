package androidx.credentials.playservices.controllers;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.h;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import d10.a;
import d10.l;
import d10.p;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;

public abstract class CredentialProviderController<T1, T2, R2, R1, E1> extends CredentialProviderBaseController {
    public static final Companion Companion = new Companion((r) null);
    private final Context context;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final void cancelOrCallbackExceptionOrResult(CancellationSignal cancellationSignal, a<Unit> aVar) {
            if (!CredentialProviderPlayServicesImpl.Companion.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
                aVar.invoke();
            }
        }

        public final String generateErrorStringCanceled$credentials_play_services_auth_release() {
            return "activity is cancelled by the user.";
        }

        public final String generateErrorStringUnknown$credentials_play_services_auth_release(int i11) {
            return "activity with result code: " + i11 + " indicating not RESULT_OK";
        }

        public final boolean maybeReportErrorResultCodeCreate(int i11, p<? super CancellationSignal, ? super a<Unit>, Unit> pVar, l<? super CreateCredentialException, Unit> lVar, CancellationSignal cancellationSignal) {
            if (i11 == -1) {
                return false;
            }
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = new CreateCredentialUnknownException(generateErrorStringUnknown$credentials_play_services_auth_release(i11));
            if (i11 == 0) {
                ref$ObjectRef.element = new CreateCredentialCancellationException(generateErrorStringCanceled$credentials_play_services_auth_release());
            }
            pVar.invoke(cancellationSignal, new CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1(lVar, ref$ObjectRef));
            return true;
        }

        public final boolean maybeReportErrorResultCodeGet(int i11, p<? super CancellationSignal, ? super a<Unit>, Unit> pVar, l<? super GetCredentialException, Unit> lVar, CancellationSignal cancellationSignal) {
            if (i11 == -1) {
                return false;
            }
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = new GetCredentialUnknownException(generateErrorStringUnknown$credentials_play_services_auth_release(i11));
            if (i11 == 0) {
                ref$ObjectRef.element = new GetCredentialCancellationException(generateErrorStringCanceled$credentials_play_services_auth_release());
            }
            pVar.invoke(cancellationSignal, new CredentialProviderController$Companion$maybeReportErrorResultCodeGet$1(lVar, ref$ObjectRef));
            return true;
        }
    }

    public CredentialProviderController(Context context2) {
        super(context2);
        this.context = context2;
    }

    public static final void cancelOrCallbackExceptionOrResult(CancellationSignal cancellationSignal, a<Unit> aVar) {
        Companion.cancelOrCallbackExceptionOrResult(cancellationSignal, aVar);
    }

    public static final boolean maybeReportErrorResultCodeCreate(int i11, p<? super CancellationSignal, ? super a<Unit>, Unit> pVar, l<? super CreateCredentialException, Unit> lVar, CancellationSignal cancellationSignal) {
        return Companion.maybeReportErrorResultCodeCreate(i11, pVar, lVar, cancellationSignal);
    }

    public static final boolean maybeReportErrorResultCodeGet(int i11, p<? super CancellationSignal, ? super a<Unit>, Unit> pVar, l<? super GetCredentialException, Unit> lVar, CancellationSignal cancellationSignal) {
        return Companion.maybeReportErrorResultCodeGet(i11, pVar, lVar, cancellationSignal);
    }

    public abstract T2 convertRequestToPlayServices(T1 t12);

    public abstract R1 convertResponseToCredentialManager(R2 r22);

    public abstract void invokePlayServices(T1 t12, h<R1, E1> hVar, Executor executor, CancellationSignal cancellationSignal);

    public final boolean maybeReportErrorFromResultReceiver(Bundle bundle, p<? super String, ? super String, ? extends E1> pVar, Executor executor, h<R1, E1> hVar, CancellationSignal cancellationSignal) {
        if (!bundle.getBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG)) {
            return false;
        }
        cancelOrCallbackExceptionOrResult(cancellationSignal, new CredentialProviderController$maybeReportErrorFromResultReceiver$1(executor, hVar, pVar.invoke(bundle.getString(CredentialProviderBaseController.EXCEPTION_TYPE_TAG), bundle.getString(CredentialProviderBaseController.EXCEPTION_MESSAGE_TAG))));
        return true;
    }
}
