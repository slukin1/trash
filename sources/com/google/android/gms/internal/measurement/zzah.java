package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public final class zzah implements zzap {
    private final Double zza;

    public zzah(Double d11) {
        if (d11 == null) {
            this.zza = Double.valueOf(Double.NaN);
        } else {
            this.zza = d11;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        return this.zza.equals(((zzah) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return zzi();
    }

    public final zzap zzbU(String str, zzg zzg, List list) {
        if ("toString".equals(str)) {
            return new zzat(zzi());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{zzi(), str}));
    }

    public final zzap zzd() {
        return new zzah(this.zza);
    }

    public final Boolean zzg() {
        boolean z11 = false;
        if (!Double.isNaN(this.zza.doubleValue()) && this.zza.doubleValue() != 0.0d) {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    public final Double zzh() {
        return this.zza;
    }

    public final String zzi() {
        int i11;
        if (Double.isNaN(this.zza.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(this.zza.doubleValue())) {
            return this.zza.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal stripTrailingZeros = BigDecimal.valueOf(this.zza.doubleValue()).stripTrailingZeros();
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (stripTrailingZeros.scale() > 0) {
            i11 = stripTrailingZeros.precision();
        } else {
            i11 = stripTrailingZeros.scale();
        }
        decimalFormat.setMinimumFractionDigits(i11 - 1);
        String format = decimalFormat.format(stripTrailingZeros);
        int indexOf = format.indexOf("E");
        if (indexOf <= 0) {
            return format;
        }
        int parseInt = Integer.parseInt(format.substring(indexOf + 1));
        if ((parseInt >= 0 || parseInt <= -7) && (parseInt < 0 || parseInt >= 21)) {
            return format.replace("E-", "e-").replace("E", "e+");
        }
        return stripTrailingZeros.toPlainString();
    }

    public final Iterator zzl() {
        return null;
    }
}
