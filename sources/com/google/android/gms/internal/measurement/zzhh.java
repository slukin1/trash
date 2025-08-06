package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;

public final class zzhh {
    private final SimpleArrayMap zza;

    public zzhh(SimpleArrayMap simpleArrayMap) {
        this.zza = simpleArrayMap;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        SimpleArrayMap simpleArrayMap;
        if (uri != null) {
            simpleArrayMap = (SimpleArrayMap) this.zza.get(uri.toString());
        } else {
            simpleArrayMap = null;
        }
        if (simpleArrayMap == null) {
            return null;
        }
        return (String) simpleArrayMap.get("".concat(str3));
    }
}
