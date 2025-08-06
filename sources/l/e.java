package l;

import android.os.IBinder;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final ITrustedWebActivityCallback f16047a;

    public e(ITrustedWebActivityCallback iTrustedWebActivityCallback) {
        this.f16047a = iTrustedWebActivityCallback;
    }

    public static e a(IBinder iBinder) {
        ITrustedWebActivityCallback asInterface = iBinder == null ? null : ITrustedWebActivityCallback.Stub.asInterface(iBinder);
        if (asInterface == null) {
            return null;
        }
        return new e(asInterface);
    }
}
