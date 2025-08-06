package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableDouble extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableDouble> CREATOR = new a();
    public static final long serialVersionUID = 1;
    private double mValue;

    public class a implements Parcelable.Creator<ObservableDouble> {
        /* renamed from: a */
        public ObservableDouble createFromParcel(Parcel parcel) {
            return new ObservableDouble(parcel.readDouble());
        }

        /* renamed from: b */
        public ObservableDouble[] newArray(int i11) {
            return new ObservableDouble[i11];
        }
    }

    public ObservableDouble(double d11) {
        this.mValue = d11;
    }

    public int describeContents() {
        return 0;
    }

    public double get() {
        return this.mValue;
    }

    public void set(double d11) {
        if (d11 != this.mValue) {
            this.mValue = d11;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeDouble(this.mValue);
    }

    public ObservableDouble() {
    }

    public ObservableDouble(Observable... observableArr) {
        super(observableArr);
    }
}
