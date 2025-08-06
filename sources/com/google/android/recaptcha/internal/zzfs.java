package com.google.android.recaptcha.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public final class zzfs {
    public static boolean zza(Collection collection, Iterator it2) {
        Objects.requireNonNull(it2);
        boolean z11 = false;
        while (it2.hasNext()) {
            z11 |= collection.add(it2.next());
        }
        return z11;
    }
}
