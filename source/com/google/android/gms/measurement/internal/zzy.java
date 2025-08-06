package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class zzy {
    public final String zzb;
    public final int zzc;
    public Boolean zzd;
    public Boolean zze;
    public Long zzf;
    public Long zzg;

    public zzy(String str, int i11) {
        this.zzb = str;
        this.zzc = i11;
    }

    private static Boolean zzd(String str, int i11, boolean z11, String str2, List list, String str3, zzet zzet) {
        if (i11 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z11 && i11 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i11 - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z11 ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzet != null) {
                        zzet.zzk().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    public static Boolean zze(BigDecimal bigDecimal, zzer zzer, double d11) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzer);
        if (zzer.zzg()) {
            boolean z11 = true;
            if (zzer.zzm() != 1) {
                if (zzer.zzm() == 5) {
                    if (!zzer.zzk() || !zzer.zzj()) {
                        return null;
                    }
                } else if (!zzer.zzh()) {
                    return null;
                }
                int zzm = zzer.zzm();
                if (zzer.zzm() == 5) {
                    if (zzlj.zzy(zzer.zze()) && zzlj.zzy(zzer.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzer.zze());
                            bigDecimal3 = new BigDecimal(zzer.zzd());
                            bigDecimal2 = bigDecimal5;
                            bigDecimal4 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!zzlj.zzy(zzer.zzc())) {
                    return null;
                } else {
                    try {
                        bigDecimal4 = new BigDecimal(zzer.zzc());
                        bigDecimal2 = null;
                        bigDecimal3 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm == 5) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                }
                int i11 = zzm - 1;
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 != 4 || bigDecimal2 == null) {
                                return null;
                            }
                            if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                                z11 = false;
                            }
                            return Boolean.valueOf(z11);
                        } else if (bigDecimal4 == null) {
                            return null;
                        } else {
                            if (d11 != 0.0d) {
                                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d11).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d11).multiply(new BigDecimal(2)))) >= 0) {
                                    z11 = false;
                                }
                                return Boolean.valueOf(z11);
                            }
                            if (bigDecimal.compareTo(bigDecimal4) != 0) {
                                z11 = false;
                            }
                            return Boolean.valueOf(z11);
                        }
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z11 = false;
                        }
                        return Boolean.valueOf(z11);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                        z11 = false;
                    }
                    return Boolean.valueOf(z11);
                }
            }
        }
        return null;
    }

    public static Boolean zzf(String str, zzey zzey, zzet zzet) {
        String str2;
        List list;
        Preconditions.checkNotNull(zzey);
        if (str == null || !zzey.zzi() || zzey.zzj() == 1) {
            return null;
        }
        if (zzey.zzj() == 7) {
            if (zzey.zza() == 0) {
                return null;
            }
        } else if (!zzey.zzh()) {
            return null;
        }
        int zzj = zzey.zzj();
        boolean zzf2 = zzey.zzf();
        if (zzf2 || zzj == 2 || zzj == 7) {
            str2 = zzey.zzd();
        } else {
            str2 = zzey.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzey.zza() == 0) {
            list = null;
        } else {
            List<String> zze2 = zzey.zze();
            if (!zzf2) {
                ArrayList arrayList = new ArrayList(zze2.size());
                for (String upperCase : zze2) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zze2 = Collections.unmodifiableList(arrayList);
            }
            list = zze2;
        }
        return zzd(str, zzj, zzf2, str3, list, zzj == 2 ? str3 : null, zzet);
    }

    public static Boolean zzg(double d11, zzer zzer) {
        try {
            return zze(new BigDecimal(d11), zzer, Math.ulp(d11));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zzh(long j11, zzer zzer) {
        try {
            return zze(new BigDecimal(j11), zzer, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zzi(String str, zzer zzer) {
        if (!zzlj.zzy(str)) {
            return null;
        }
        try {
            return zze(new BigDecimal(str), zzer, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zzj(Boolean bool, boolean z11) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z11);
    }

    public abstract int zza();

    public abstract boolean zzb();

    public abstract boolean zzc();
}
