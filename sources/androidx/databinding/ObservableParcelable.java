package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;

public class ObservableParcelable<T extends Parcelable> extends ObservableField<T> implements Parcelable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = new a();
    public static final long serialVersionUID = 1;

    public class a implements Parcelable.Creator<ObservableParcelable> {
        /* renamed from: a */
        public ObservableParcelable createFromParcel(Parcel parcel) {
            return new ObservableParcelable(parcel.readParcelable(getClass().getClassLoader()));
        }

        /* renamed from: b */
        public ObservableParcelable[] newArray(int i11) {
            return new ObservableParcelable[i11];
        }
    }

    public ObservableParcelable(T t11) {
        super(t11);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable((Parcelable) get(), 0);
    }

    public ObservableParcelable() {
    }
}
