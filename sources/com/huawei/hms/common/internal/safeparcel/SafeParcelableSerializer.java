package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;

public final class SafeParcelableSerializer {
    public static <S extends SafeParcelable> S deserializeFromBytes(byte[] bArr, Parcelable.Creator<S> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        S s11 = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return s11;
    }

    public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        byte[] byteArrayExtra;
        if (intent == null || (byteArrayExtra = intent.getByteArrayExtra(str)) == null) {
            return null;
        }
        return deserializeFromBytes(byteArrayExtra, creator);
    }

    public static <S extends SafeParcelable> S deserializeFromString(String str, Parcelable.Creator<S> creator) {
        return deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList;
        if (bundle == null || (arrayList = (ArrayList) bundle.getSerializable(str)) == null) {
            return null;
        }
        ArrayList<S> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(deserializeFromBytes((byte[]) it2.next(), creator));
        }
        return arrayList2;
    }

    public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<S> creator) {
        ArrayList arrayList;
        if (intent == null || (arrayList = (ArrayList) intent.getSerializableExtra(str)) == null) {
            return null;
        }
        ArrayList<S> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(deserializeFromBytes((byte[]) it2.next(), creator));
        }
        return arrayList2;
    }

    public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> iterable, Bundle bundle, String str) {
        if (iterable != null && bundle != null) {
            ArrayList arrayList = new ArrayList();
            for (S serializeToBytes : iterable) {
                arrayList.add(serializeToBytes(serializeToBytes));
            }
            bundle.putSerializable(str, arrayList);
        }
    }

    public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> iterable, Intent intent, String str) {
        if (iterable != null && intent != null) {
            ArrayList arrayList = new ArrayList();
            for (S serializeToBytes : iterable) {
                arrayList.add(serializeToBytes(serializeToBytes));
            }
            intent.putExtra(str, arrayList);
        }
    }

    public static <S extends SafeParcelable> byte[] serializeToBytes(S s11) {
        Parcel obtain = Parcel.obtain();
        if (s11 != null) {
            s11.writeToParcel(obtain, 0);
        }
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <S extends SafeParcelable> void serializeToIntentExtra(S s11, Intent intent, String str) {
        if (s11 != null && intent != null) {
            intent.putExtra(str, serializeToBytes(s11));
        }
    }

    public static <S extends SafeParcelable> String serializeToString(S s11) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(s11));
    }
}
