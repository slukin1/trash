package androidx.credentials.playservices.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.ResultReceiver;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialInterruptedException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.NoCredentialException;
import java.util.Set;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public class CredentialProviderBaseController {
    public static final String ACTIVITY_REQUEST_CODE_TAG = "ACTIVITY_REQUEST_CODE";
    public static final String BEGIN_SIGN_IN_TAG = "BEGIN_SIGN_IN";
    /* access modifiers changed from: private */
    public static final int CONTROLLER_REQUEST_CODE = 1;
    public static final String CREATE_PASSWORD_TAG = "CREATE_PASSWORD";
    public static final String CREATE_PUBLIC_KEY_CREDENTIAL_TAG = "CREATE_PUBLIC_KEY_CREDENTIAL";
    public static final Companion Companion = new Companion((r) null);
    public static final String EXCEPTION_MESSAGE_TAG = "EXCEPTION_MESSAGE";
    public static final String EXCEPTION_TYPE_TAG = "EXCEPTION_TYPE";
    public static final String FAILURE_RESPONSE_TAG = "FAILURE_RESPONSE";
    public static final String REQUEST_TAG = "REQUEST_TYPE";
    public static final String RESULT_DATA_TAG = "RESULT_DATA";
    public static final String RESULT_RECEIVER_TAG = "RESULT_RECEIVER";
    public static final String TYPE_TAG = "TYPE";
    /* access modifiers changed from: private */
    public static final Set<Integer> retryables = SetsKt__SetsKt.f(8, 7, 20);
    private final Context context;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ void getCONTROLLER_REQUEST_CODE$annotations() {
        }

        public final CreateCredentialException createCredentialExceptionTypeToException$credentials_play_services_auth_release(String str, String str2) {
            if (x.b(str, CreateCredentialCancellationException.class.getName())) {
                return new CreateCredentialCancellationException(str2);
            }
            if (x.b(str, CreateCredentialInterruptedException.class.getName())) {
                return new CreateCredentialInterruptedException(str2);
            }
            return new CreateCredentialUnknownException(str2);
        }

        public final int getCONTROLLER_REQUEST_CODE() {
            return CredentialProviderBaseController.CONTROLLER_REQUEST_CODE;
        }

        public final GetCredentialException getCredentialExceptionTypeToException$credentials_play_services_auth_release(String str, String str2) {
            if (x.b(str, GetCredentialCancellationException.class.getName())) {
                return new GetCredentialCancellationException(str2);
            }
            if (x.b(str, GetCredentialInterruptedException.class.getName())) {
                return new GetCredentialInterruptedException(str2);
            }
            if (x.b(str, NoCredentialException.class.getName())) {
                return new NoCredentialException(str2);
            }
            return new GetCredentialUnknownException(str2);
        }

        public final Set<Integer> getRetryables() {
            return CredentialProviderBaseController.retryables;
        }
    }

    public CredentialProviderBaseController(Context context2) {
        this.context = context2;
    }

    public static final int getCONTROLLER_REQUEST_CODE() {
        return Companion.getCONTROLLER_REQUEST_CODE();
    }

    public final void generateHiddenActivityIntent(ResultReceiver resultReceiver, Intent intent, String str) {
        intent.putExtra("TYPE", str);
        intent.putExtra(ACTIVITY_REQUEST_CODE_TAG, CONTROLLER_REQUEST_CODE);
        intent.putExtra(RESULT_RECEIVER_TAG, toIpcFriendlyResultReceiver(resultReceiver));
        intent.setFlags(65536);
    }

    public final <T extends ResultReceiver> ResultReceiver toIpcFriendlyResultReceiver(T t11) {
        Parcel obtain = Parcel.obtain();
        t11.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return resultReceiver;
    }
}
