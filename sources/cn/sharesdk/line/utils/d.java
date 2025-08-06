package cn.sharesdk.line.utils;

import android.os.Parcel;

public final class d {
    public static <T extends Enum> void a(Parcel parcel, T t11) {
        parcel.writeString(t11 != null ? t11.name() : null);
    }

    public static <T extends Enum<T>> T a(Parcel parcel, Class<T> cls) {
        String readString = parcel.readString();
        if (readString != null) {
            return Enum.valueOf(cls, readString);
        }
        return null;
    }
}
