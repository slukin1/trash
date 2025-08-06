package androidx.test.espresso.core.internal.deps.aidl;

import android.os.Parcel;

public class Codecs {

    /* renamed from: a  reason: collision with root package name */
    public static final ClassLoader f11145a = Codecs.class.getClassLoader();

    private Codecs() {
    }

    public static void a(Parcel parcel, boolean z11) {
        parcel.writeInt(z11 ? 1 : 0);
    }
}
