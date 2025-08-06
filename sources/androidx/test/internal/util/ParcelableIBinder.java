package androidx.test.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableIBinder implements Parcelable {
    public static final Parcelable.Creator<ParcelableIBinder> CREATOR = new Parcelable.Creator<ParcelableIBinder>() {
        /* renamed from: a */
        public ParcelableIBinder createFromParcel(Parcel parcel) {
            return new ParcelableIBinder(parcel);
        }

        /* renamed from: b */
        public ParcelableIBinder[] newArray(int i11) {
            return new ParcelableIBinder[i11];
        }
    };
    private final IBinder iBinder;

    public ParcelableIBinder(IBinder iBinder2) {
        this.iBinder = (IBinder) Checks.b(iBinder2);
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getIBinder() {
        return this.iBinder;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStrongBinder(this.iBinder);
    }

    public ParcelableIBinder(Parcel parcel) {
        this.iBinder = parcel.readStrongBinder();
    }
}
