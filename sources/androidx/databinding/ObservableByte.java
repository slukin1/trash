package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableByte extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new a();
    public static final long serialVersionUID = 1;
    private byte mValue;

    public class a implements Parcelable.Creator<ObservableByte> {
        /* renamed from: a */
        public ObservableByte createFromParcel(Parcel parcel) {
            return new ObservableByte(parcel.readByte());
        }

        /* renamed from: b */
        public ObservableByte[] newArray(int i11) {
            return new ObservableByte[i11];
        }
    }

    public ObservableByte(byte b11) {
        this.mValue = b11;
    }

    public int describeContents() {
        return 0;
    }

    public byte get() {
        return this.mValue;
    }

    public void set(byte b11) {
        if (b11 != this.mValue) {
            this.mValue = b11;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByte(this.mValue);
    }

    public ObservableByte() {
    }

    public ObservableByte(Observable... observableArr) {
        super(observableArr);
    }
}
