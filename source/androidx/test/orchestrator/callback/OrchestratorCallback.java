package androidx.test.orchestrator.callback;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.runner.internal.deps.aidl.BaseProxy;
import androidx.test.runner.internal.deps.aidl.BaseStub;
import androidx.test.runner.internal.deps.aidl.Codecs;

public interface OrchestratorCallback extends IInterface {

    public static abstract class Stub extends BaseStub implements OrchestratorCallback {

        public static class Proxy extends BaseProxy implements OrchestratorCallback {
            public Proxy(IBinder iBinder) {
                super(iBinder, "androidx.test.orchestrator.callback.OrchestratorCallback");
            }

            public void b(String str) throws RemoteException {
                Parcel d11 = d();
                d11.writeString(str);
                e(1, d11);
            }

            public void f(Bundle bundle) throws RemoteException {
                Parcel d11 = d();
                Codecs.b(d11, bundle);
                e(2, d11);
            }
        }

        public Stub() {
            super("androidx.test.orchestrator.callback.OrchestratorCallback");
        }

        public static OrchestratorCallback g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.test.orchestrator.callback.OrchestratorCallback");
            if (queryLocalInterface instanceof OrchestratorCallback) {
                return (OrchestratorCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public boolean d(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1) {
                b(parcel.readString());
            } else if (i11 != 2) {
                return false;
            } else {
                f((Bundle) Codecs.a(parcel, Bundle.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void b(String str) throws RemoteException;

    void f(Bundle bundle) throws RemoteException;
}
