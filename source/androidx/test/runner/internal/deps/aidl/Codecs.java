package androidx.test.runner.internal.deps.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Codecs {

    /* renamed from: a  reason: collision with root package name */
    public static final ClassLoader f11691a = Codecs.class.getClassLoader();

    private Codecs() {
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
