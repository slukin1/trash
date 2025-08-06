package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

public interface IUnusedAppRestrictionsBackportService extends IInterface {
    public static final String I = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace(DecodedChar.FNC1, '.');

    public static class Default implements IUnusedAppRestrictionsBackportService {
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {
        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportService.I);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = IUnusedAppRestrictionsBackportService.I;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                c(IUnusedAppRestrictionsBackportCallback.Stub.d(parcel.readStrongBinder()));
                return true;
            }
        }
    }

    void c(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException;
}
