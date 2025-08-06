package androidx.core.os;

import android.os.Parcel;

@Deprecated
public interface m<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i11);
}
