package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f8370a = versionedParcel.p(iconCompat.f8370a, 1);
        iconCompat.f8372c = versionedParcel.j(iconCompat.f8372c, 2);
        iconCompat.f8373d = versionedParcel.r(iconCompat.f8373d, 3);
        iconCompat.f8374e = versionedParcel.p(iconCompat.f8374e, 4);
        iconCompat.f8375f = versionedParcel.p(iconCompat.f8375f, 5);
        iconCompat.f8376g = (ColorStateList) versionedParcel.r(iconCompat.f8376g, 6);
        iconCompat.f8378i = versionedParcel.t(iconCompat.f8378i, 7);
        iconCompat.f8379j = versionedParcel.t(iconCompat.f8379j, 8);
        iconCompat.v();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.w(versionedParcel.f());
        int i11 = iconCompat.f8370a;
        if (-1 != i11) {
            versionedParcel.F(i11, 1);
        }
        byte[] bArr = iconCompat.f8372c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f8373d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i12 = iconCompat.f8374e;
        if (i12 != 0) {
            versionedParcel.F(i12, 4);
        }
        int i13 = iconCompat.f8375f;
        if (i13 != 0) {
            versionedParcel.F(i13, 5);
        }
        ColorStateList colorStateList = iconCompat.f8376g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f8378i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f8379j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
