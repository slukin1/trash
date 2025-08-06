package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static final String H = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace(DecodedChar.FNC1, '.');

    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {

        public static class a implements IUnusedAppRestrictionsBackportCallback {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f8324a;

            public a(IBinder iBinder) {
                this.f8324a = iBinder;
            }

            public IBinder asBinder() {
                return this.f8324a;
            }
        }

        public Stub() {
            attachInterface(this, IUnusedAppRestrictionsBackportCallback.H);
        }

        public static IUnusedAppRestrictionsBackportCallback d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.H);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IUnusedAppRestrictionsBackportCallback)) {
                return new a(iBinder);
            }
            return (IUnusedAppRestrictionsBackportCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = IUnusedAppRestrictionsBackportCallback.H;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                boolean z11 = false;
                boolean z12 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    z11 = true;
                }
                a(z12, z11);
                return true;
            }
        }
    }

    void a(boolean z11, boolean z12) throws RemoteException;
}
