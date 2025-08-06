package androidx.test.espresso.remote;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.espresso.core.internal.deps.aidl.BaseStub;
import androidx.test.espresso.core.internal.deps.aidl.Codecs;

public interface IInteractionExecutionStatus extends IInterface {

    public static abstract class Stub extends BaseStub implements IInteractionExecutionStatus {
        public Stub() {
            super("androidx.test.espresso.remote.IInteractionExecutionStatus");
        }

        public boolean d(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1) {
                return false;
            }
            boolean x11 = x();
            parcel2.writeNoException();
            Codecs.a(parcel2, x11);
            return true;
        }
    }

    boolean x() throws RemoteException;
}
