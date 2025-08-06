package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import w1.b;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();
    private final b mParcel;

    public static class a implements Parcelable.Creator<ParcelImpl> {
        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: b */
        public ParcelImpl[] newArray(int i11) {
            return new ParcelImpl[i11];
        }
    }

    public ParcelImpl(b bVar) {
        this.mParcel = bVar;
    }

    public int describeContents() {
        return 0;
    }

    public <T extends b> T getVersionedParcel() {
        return this.mParcel;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        new w1.a(parcel).L(this.mParcel);
    }

    public ParcelImpl(Parcel parcel) {
        this.mParcel = new w1.a(parcel).u();
    }
}
