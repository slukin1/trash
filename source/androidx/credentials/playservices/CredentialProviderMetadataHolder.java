package androidx.credentials.playservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.NotImplementedError;

public final class CredentialProviderMetadataHolder extends Service {
    public IBinder onBind(Intent intent) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
