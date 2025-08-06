package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableChar extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = new a();
    public static final long serialVersionUID = 1;
    private char mValue;

    public class a implements Parcelable.Creator<ObservableChar> {
        /* renamed from: a */
        public ObservableChar createFromParcel(Parcel parcel) {
            return new ObservableChar((char) parcel.readInt());
        }

        /* renamed from: b */
        public ObservableChar[] newArray(int i11) {
            return new ObservableChar[i11];
        }
    }

    public ObservableChar(char c11) {
        this.mValue = c11;
    }

    public int describeContents() {
        return 0;
    }

    public char get() {
        return this.mValue;
    }

    public void set(char c11) {
        if (c11 != this.mValue) {
            this.mValue = c11;
            notifyChange();
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mValue);
    }

    public ObservableChar() {
    }

    public ObservableChar(Observable... observableArr) {
        super(observableArr);
    }
}
