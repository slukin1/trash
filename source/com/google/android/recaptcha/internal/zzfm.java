package com.google.android.recaptcha.internal;

public abstract class zzfm implements Iterable {
    private final zzfe zza = zzfe.zza();

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z11 = true;
        for (Object append : this) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append(append);
            z11 = false;
        }
        sb2.append(']');
        return sb2.toString();
    }
}
