package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableInt extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new a();
    public static final long serialVersionUID = 1;
    private int mValue;

    public class a implements Parcelable.Creator<ObservableInt> {
        /* renamed from: a */
        public ObservableInt createFromParcel(Parcel parcel) {
            return new ObservableInt(parcel.readInt());
        }

        /* renamed from: b */
        public ObservableInt[] newArray(int i11) {
            return new ObservableInt[i11];
        }
    }

    public ObservableInt(int i11) {
        this.mValue = i11;
    }

    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mValue;
    }

    public void set(int i11) {
        if (i11 != this.mValue) {
            this.mValue = i11;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mValue);
    }

    public ObservableInt() {
    }

    public ObservableInt(Observable... observableArr) {
        super(observableArr);
    }
}
