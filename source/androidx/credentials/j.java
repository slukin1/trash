package androidx.credentials;

import android.app.Activity;
import android.os.CancellationSignal;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import java.util.concurrent.Executor;

public interface j {
    boolean isAvailableOnDevice();

    void onCreateCredential(a aVar, Activity activity, CancellationSignal cancellationSignal, Executor executor, h<b, CreateCredentialException> hVar);

    void onGetCredential(GetCredentialRequest getCredentialRequest, Activity activity, CancellationSignal cancellationSignal, Executor executor, h<l, GetCredentialException> hVar);
}
