package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableShort extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new a();
    public static final long serialVersionUID = 1;
    private short mValue;

    public class a implements Parcelable.Creator<ObservableShort> {
        /* renamed from: a */
        public ObservableShort createFromParcel(Parcel parcel) {
            return new ObservableShort((short) parcel.readInt());
        }

        /* renamed from: b */
        public ObservableShort[] newArray(int i11) {
            return new ObservableShort[i11];
        }
    }

    public ObservableShort(short s11) {
        this.mValue = s11;
    }

    public int describeContents() {
        return 0;
    }

    public short get() {
        return this.mValue;
    }

    public void set(short s11) {
        if (s11 != this.mValue) {
            this.mValue = s11;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mValue);
    }

    public ObservableShort() {
    }

    public ObservableShort(Observable... observableArr) {
        super(observableArr);
    }
}
