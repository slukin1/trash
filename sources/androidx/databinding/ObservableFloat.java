package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableFloat extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new a();
    public static final long serialVersionUID = 1;
    private float mValue;

    public class a implements Parcelable.Creator<ObservableFloat> {
        /* renamed from: a */
        public ObservableFloat createFromParcel(Parcel parcel) {
            return new ObservableFloat(parcel.readFloat());
        }

        /* renamed from: b */
        public ObservableFloat[] newArray(int i11) {
            return new ObservableFloat[i11];
        }
    }

    public ObservableFloat(float f11) {
        this.mValue = f11;
    }

    public int describeContents() {
        return 0;
    }

    public float get() {
        return this.mValue;
    }

    public void set(float f11) {
        if (f11 != this.mValue) {
            this.mValue = f11;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeFloat(this.mValue);
    }

    public ObservableFloat() {
    }

    public ObservableFloat(Observable... observableArr) {
        super(observableArr);
    }
}
