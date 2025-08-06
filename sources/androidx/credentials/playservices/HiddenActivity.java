package androidx.credentials.playservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import androidx.credentials.exceptions.CreateCredentialInterruptedException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.NoCredentialException;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import d10.l;
import kotlin.jvm.internal.r;

public class HiddenActivity extends Activity {
    public static final Companion Companion = new Companion((r) null);
    private static final int DEFAULT_VALUE = 1;
    private static final String KEY_AWAITING_RESULT = "androidx.credentials.playservices.AWAITING_RESULT";
    private static final String TAG = HiddenActivity.class.getName();
    /* access modifiers changed from: private */
    public boolean mWaitingForActivityResult;
    /* access modifiers changed from: private */
    public ResultReceiver resultReceiver;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    private final void handleBeginSignIn() {
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        if ((beginSignInRequest != null ? Identity.getSignInClient((Activity) this).beginSignIn(beginSignInRequest).addOnSuccessListener(new HiddenActivity$$ExternalSyntheticLambda3(new HiddenActivity$handleBeginSignIn$1$1(this, getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1)))).addOnFailureListener(new HiddenActivity$$ExternalSyntheticLambda2(this)) : null) == null) {
            Log.i(TAG, "During begin sign in, params is null, nothing to launch for begin sign in");
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void handleBeginSignIn$lambda$6$lambda$4(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void handleBeginSignIn$lambda$6$lambda$5(HiddenActivity hiddenActivity, Exception exc) {
        String name = NoCredentialException.class.getName();
        if ((exc instanceof ApiException) && CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) {
            name = GetCredentialInterruptedException.class.getName();
        }
        ResultReceiver resultReceiver2 = hiddenActivity.resultReceiver;
        hiddenActivity.setupFailure(resultReceiver2, name, "During begin sign in, failure response from one tap: " + exc.getMessage());
    }

    private final void handleCreatePassword() {
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        if ((savePasswordRequest != null ? Identity.getCredentialSavingClient((Activity) this).savePassword(savePasswordRequest).addOnSuccessListener(new HiddenActivity$$ExternalSyntheticLambda5(new HiddenActivity$handleCreatePassword$1$1(this, getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1)))).addOnFailureListener(new HiddenActivity$$ExternalSyntheticLambda0(this)) : null) == null) {
            Log.i(TAG, "During save password, params is null, nothing to launch for create password");
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void handleCreatePassword$lambda$10$lambda$8(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void handleCreatePassword$lambda$10$lambda$9(HiddenActivity hiddenActivity, Exception exc) {
        String name = CreateCredentialUnknownException.class.getName();
        if ((exc instanceof ApiException) && CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) {
            name = CreateCredentialInterruptedException.class.getName();
        }
        ResultReceiver resultReceiver2 = hiddenActivity.resultReceiver;
        hiddenActivity.setupFailure(resultReceiver2, name, "During save password, found password failure response from one tap " + exc.getMessage());
    }

    private final void handleCreatePublicKeyCredential() {
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) getIntent().getParcelableExtra(CredentialProviderBaseController.REQUEST_TAG);
        if ((publicKeyCredentialCreationOptions != null ? Fido.getFido2ApiClient((Activity) this).getRegisterPendingIntent(publicKeyCredentialCreationOptions).addOnSuccessListener(new HiddenActivity$$ExternalSyntheticLambda4(new HiddenActivity$handleCreatePublicKeyCredential$1$1(this, getIntent().getIntExtra(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, 1)))).addOnFailureListener(new HiddenActivity$$ExternalSyntheticLambda1(this)) : null) == null) {
            Log.w(TAG, "During create public key credential, request is null, so nothing to launch for public key credentials");
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void handleCreatePublicKeyCredential$lambda$2$lambda$0(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void handleCreatePublicKeyCredential$lambda$2$lambda$1(HiddenActivity hiddenActivity, Exception exc) {
        String name = CreateCredentialUnknownException.class.getName();
        if ((exc instanceof ApiException) && CredentialProviderBaseController.Companion.getRetryables().contains(Integer.valueOf(((ApiException) exc).getStatusCode()))) {
            name = CreateCredentialInterruptedException.class.getName();
        }
        ResultReceiver resultReceiver2 = hiddenActivity.resultReceiver;
        hiddenActivity.setupFailure(resultReceiver2, name, "During create public key credential, fido registration failure: " + exc.getMessage());
    }

    private final void restoreState(Bundle bundle) {
        if (bundle != null) {
            this.mWaitingForActivityResult = bundle.getBoolean(KEY_AWAITING_RESULT, false);
        }
    }

    /* access modifiers changed from: private */
    public final void setupFailure(ResultReceiver resultReceiver2, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG, true);
        bundle.putString(CredentialProviderBaseController.EXCEPTION_TYPE_TAG, str);
        bundle.putString(CredentialProviderBaseController.EXCEPTION_MESSAGE_TAG, str2);
        resultReceiver2.send(Integer.MAX_VALUE, bundle);
        finish();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        Bundle bundle = new Bundle();
        bundle.putBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG, false);
        bundle.putInt(CredentialProviderBaseController.ACTIVITY_REQUEST_CODE_TAG, i11);
        bundle.putParcelable(CredentialProviderBaseController.RESULT_DATA_TAG, intent);
        ResultReceiver resultReceiver2 = this.resultReceiver;
        if (resultReceiver2 != null) {
            resultReceiver2.send(i12, bundle);
        }
        this.mWaitingForActivityResult = false;
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        String stringExtra = getIntent().getStringExtra("TYPE");
        ResultReceiver resultReceiver2 = (ResultReceiver) getIntent().getParcelableExtra(CredentialProviderBaseController.RESULT_RECEIVER_TAG);
        this.resultReceiver = resultReceiver2;
        if (resultReceiver2 == null) {
            finish();
        }
        restoreState(bundle);
        if (!this.mWaitingForActivityResult) {
            if (stringExtra != null) {
                int hashCode = stringExtra.hashCode();
                if (hashCode != -441061071) {
                    if (hashCode != 15545322) {
                        if (hashCode == 1246634622 && stringExtra.equals(CredentialProviderBaseController.CREATE_PASSWORD_TAG)) {
                            handleCreatePassword();
                            return;
                        }
                    } else if (stringExtra.equals(CredentialProviderBaseController.CREATE_PUBLIC_KEY_CREDENTIAL_TAG)) {
                        handleCreatePublicKeyCredential();
                        return;
                    }
                } else if (stringExtra.equals(CredentialProviderBaseController.BEGIN_SIGN_IN_TAG)) {
                    handleBeginSignIn();
                    return;
                }
            }
            Log.w(TAG, "Activity handed an unsupported type");
            finish();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(KEY_AWAITING_RESULT, this.mWaitingForActivityResult);
        super.onSaveInstanceState(bundle);
    }
}
