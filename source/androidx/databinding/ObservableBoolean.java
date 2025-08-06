package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableBoolean extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new a();
    public static final long serialVersionUID = 1;
    private boolean mValue;

    public class a implements Parcelable.Creator<ObservableBoolean> {
        /* renamed from: a */
        public ObservableBoolean createFromParcel(Parcel parcel) {
            boolean z11 = true;
            if (parcel.readInt() != 1) {
                z11 = false;
            }
            return new ObservableBoolean(z11);
        }

        /* renamed from: b */
        public ObservableBoolean[] newArray(int i11) {
            return new ObservableBoolean[i11];
        }
    }

    public ObservableBoolean(boolean z11) {
        this.mValue = z11;
    }

    public int describeContents() {
        return 0;
    }

    public boolean get() {
        return this.mValue;
    }

    public void set(boolean z11) {
        if (z11 != this.mValue) {
            this.mValue = z11;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mValue ? 1 : 0);
    }

    public ObservableBoolean() {
    }

    public ObservableBoolean(Observable... observableArr) {
        super(observableArr);
    }
}
