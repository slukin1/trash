package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzem;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzmh;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public final class zzlj extends zzku {
    public zzlj(zzlh zzlh) {
        super(zzlh);
    }

    public static final void zzA(zzfs zzfs, String str, Object obj) {
        List zzp = zzfs.zzp();
        int i11 = 0;
        while (true) {
            if (i11 >= zzp.size()) {
                i11 = -1;
                break;
            } else if (str.equals(((zzfx) zzp.get(i11)).zzg())) {
                break;
            } else {
                i11++;
            }
        }
        zzfw zze = zzfx.zze();
        zze.zzj(str);
        if (obj instanceof Long) {
            zze.zzi(((Long) obj).longValue());
        }
        if (i11 >= 0) {
            zzfs.zzj(i11, zze);
        } else {
            zzfs.zze(zze);
        }
    }

    public static final boolean zzB(zzau zzau, zzq zzq) {
        Preconditions.checkNotNull(zzau);
        Preconditions.checkNotNull(zzq);
        return !TextUtils.isEmpty(zzq.zzb) || !TextUtils.isEmpty(zzq.zzq);
    }

    public static final zzfx zzC(zzft zzft, String str) {
        for (zzfx zzfx : zzft.zzi()) {
            if (zzfx.zzg().equals(str)) {
                return zzfx;
            }
        }
        return null;
    }

    public static final Object zzD(zzft zzft, String str) {
        zzfx zzC = zzC(zzft, str);
        if (zzC == null) {
            return null;
        }
        if (zzC.zzy()) {
            return zzC.zzh();
        }
        if (zzC.zzw()) {
            return Long.valueOf(zzC.zzd());
        }
        if (zzC.zzu()) {
            return Double.valueOf(zzC.zza());
        }
        if (zzC.zzc() <= 0) {
            return null;
        }
        List<zzfx> zzi = zzC.zzi();
        ArrayList arrayList = new ArrayList();
        for (zzfx zzfx : zzi) {
            if (zzfx != null) {
                Bundle bundle = new Bundle();
                for (zzfx zzfx2 : zzfx.zzi()) {
                    if (zzfx2.zzy()) {
                        bundle.putString(zzfx2.zzg(), zzfx2.zzh());
                    } else if (zzfx2.zzw()) {
                        bundle.putLong(zzfx2.zzg(), zzfx2.zzd());
                    } else if (zzfx2.zzu()) {
                        bundle.putDouble(zzfx2.zzg(), zzfx2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void zzE(StringBuilder sb2, int i11, List list) {
        if (list != null) {
            int i12 = i11 + 1;
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                zzfx zzfx = (zzfx) it2.next();
                if (zzfx != null) {
                    zzG(sb2, i12);
                    sb2.append("param {\n");
                    Double d11 = null;
                    zzJ(sb2, i12, "name", zzfx.zzx() ? this.zzt.zzj().zze(zzfx.zzg()) : null);
                    zzJ(sb2, i12, "string_value", zzfx.zzy() ? zzfx.zzh() : null);
                    zzJ(sb2, i12, "int_value", zzfx.zzw() ? Long.valueOf(zzfx.zzd()) : null);
                    if (zzfx.zzu()) {
                        d11 = Double.valueOf(zzfx.zza());
                    }
                    zzJ(sb2, i12, "double_value", d11);
                    if (zzfx.zzc() > 0) {
                        zzE(sb2, i12, zzfx.zzi());
                    }
                    zzG(sb2, i12);
                    sb2.append("}\n");
                }
            }
        }
    }

    private final void zzF(StringBuilder sb2, int i11, zzem zzem) {
        String str;
        if (zzem != null) {
            zzG(sb2, i11);
            sb2.append("filter {\n");
            if (zzem.zzh()) {
                zzJ(sb2, i11, "complement", Boolean.valueOf(zzem.zzg()));
            }
            if (zzem.zzj()) {
                zzJ(sb2, i11, "param_name", this.zzt.zzj().zze(zzem.zze()));
            }
            if (zzem.zzk()) {
                int i12 = i11 + 1;
                zzey zzd = zzem.zzd();
                if (zzd != null) {
                    zzG(sb2, i12);
                    sb2.append("string_filter {\n");
                    if (zzd.zzi()) {
                        switch (zzd.zzj()) {
                            case 1:
                                str = "UNKNOWN_MATCH_TYPE";
                                break;
                            case 2:
                                str = "REGEXP";
                                break;
                            case 3:
                                str = "BEGINS_WITH";
                                break;
                            case 4:
                                str = "ENDS_WITH";
                                break;
                            case 5:
                                str = "PARTIAL";
                                break;
                            case 6:
                                str = "EXACT";
                                break;
                            default:
                                str = "IN_LIST";
                                break;
                        }
                        zzJ(sb2, i12, "match_type", str);
                    }
                    if (zzd.zzh()) {
                        zzJ(sb2, i12, "expression", zzd.zzd());
                    }
                    if (zzd.zzg()) {
                        zzJ(sb2, i12, "case_sensitive", Boolean.valueOf(zzd.zzf()));
                    }
                    if (zzd.zza() > 0) {
                        zzG(sb2, i12 + 1);
                        sb2.append("expression_list {\n");
                        for (String append : zzd.zze()) {
                            zzG(sb2, i12 + 2);
                            sb2.append(append);
                            sb2.append("\n");
                        }
                        sb2.append("}\n");
                    }
                    zzG(sb2, i12);
                    sb2.append("}\n");
                }
            }
            if (zzem.zzi()) {
                zzK(sb2, i11 + 1, "number_filter", zzem.zzc());
            }
            zzG(sb2, i11);
            sb2.append("}\n");
        }
    }

    private static final void zzG(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("  ");
        }
    }

    private static final String zzH(boolean z11, boolean z12, boolean z13) {
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            sb2.append("Dynamic ");
        }
        if (z12) {
            sb2.append("Sequence ");
        }
        if (z13) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    private static final void zzI(StringBuilder sb2, int i11, String str, zzgi zzgi) {
        if (zzgi != null) {
            zzG(sb2, 3);
            sb2.append(str);
            sb2.append(" {\n");
            if (zzgi.zzb() != 0) {
                zzG(sb2, 4);
                sb2.append("results: ");
                int i12 = 0;
                for (Long l11 : zzgi.zzi()) {
                    int i13 = i12 + 1;
                    if (i12 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(l11);
                    i12 = i13;
                }
                sb2.append(10);
            }
            if (zzgi.zzd() != 0) {
                zzG(sb2, 4);
                sb2.append("status: ");
                int i14 = 0;
                for (Long l12 : zzgi.zzk()) {
                    int i15 = i14 + 1;
                    if (i14 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(l12);
                    i14 = i15;
                }
                sb2.append(10);
            }
            if (zzgi.zza() != 0) {
                zzG(sb2, 4);
                sb2.append("dynamic_filter_timestamps: {");
                int i16 = 0;
                for (zzfr zzfr : zzgi.zzh()) {
                    int i17 = i16 + 1;
                    if (i16 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(zzfr.zzh() ? Integer.valueOf(zzfr.zza()) : null);
                    sb2.append(":");
                    sb2.append(zzfr.zzg() ? Long.valueOf(zzfr.zzb()) : null);
                    i16 = i17;
                }
                sb2.append("}\n");
            }
            if (zzgi.zzc() != 0) {
                zzG(sb2, 4);
                sb2.append("sequence_filter_timestamps: {");
                int i18 = 0;
                for (zzgk zzgk : zzgi.zzj()) {
                    int i19 = i18 + 1;
                    if (i18 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(zzgk.zzi() ? Integer.valueOf(zzgk.zzb()) : null);
                    sb2.append(": [");
                    int i21 = 0;
                    for (Long longValue : zzgk.zzf()) {
                        long longValue2 = longValue.longValue();
                        int i22 = i21 + 1;
                        if (i21 != 0) {
                            sb2.append(", ");
                        }
                        sb2.append(longValue2);
                        i21 = i22;
                    }
                    sb2.append("]");
                    i18 = i19;
                }
                sb2.append("}\n");
            }
            zzG(sb2, 3);
            sb2.append("}\n");
        }
    }

    private static final void zzJ(StringBuilder sb2, int i11, String str, Object obj) {
        if (obj != null) {
            zzG(sb2, i11 + 1);
            sb2.append(str);
            sb2.append(l.f34627b);
            sb2.append(obj);
            sb2.append(10);
        }
    }

    private static final void zzK(StringBuilder sb2, int i11, String str, zzer zzer) {
        if (zzer != null) {
            zzG(sb2, i11);
            sb2.append(str);
            sb2.append(" {\n");
            if (zzer.zzg()) {
                int zzm = zzer.zzm();
                zzJ(sb2, i11, "comparison_type", zzm != 1 ? zzm != 2 ? zzm != 3 ? zzm != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
            }
            if (zzer.zzi()) {
                zzJ(sb2, i11, "match_as_float", Boolean.valueOf(zzer.zzf()));
            }
            if (zzer.zzh()) {
                zzJ(sb2, i11, "comparison_value", zzer.zzc());
            }
            if (zzer.zzk()) {
                zzJ(sb2, i11, "min_comparison_value", zzer.zze());
            }
            if (zzer.zzj()) {
                zzJ(sb2, i11, "max_comparison_value", zzer.zzd());
            }
            zzG(sb2, i11);
            sb2.append("}\n");
        }
    }

    public static int zza(zzgc zzgc, String str) {
        for (int i11 = 0; i11 < zzgc.zzb(); i11++) {
            if (str.equals(zzgc.zzap(i11).zzf())) {
                return i11;
            }
        }
        return -1;
    }

    public static zzmh zzm(zzmh zzmh, byte[] bArr) throws zzll {
        zzkn zza = zzkn.zza();
        if (zza != null) {
            return zzmh.zzaz(bArr, zza);
        }
        return zzmh.zzay(bArr);
    }

    public static List zzs(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i11 = 0; i11 < length; i11++) {
            long j11 = 0;
            for (int i12 = 0; i12 < 64; i12++) {
                int i13 = (i11 * 64) + i12;
                if (i13 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i13)) {
                    j11 |= 1 << i12;
                }
            }
            arrayList.add(Long.valueOf(j11));
        }
        return arrayList;
    }

    public static boolean zzw(List list, int i11) {
        if (i11 >= list.size() * 64) {
            return false;
        }
        return ((1 << (i11 % 64)) & ((Long) list.get(i11 / 64)).longValue()) != 0;
    }

    public static boolean zzy(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public final boolean zzb() {
        return false;
    }

    public final long zzd(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return zzf(str.getBytes(Charset.forName("UTF-8")));
    }

    public final long zzf(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        this.zzt.zzv().zzg();
        MessageDigest zzF = zzlp.zzF();
        if (zzF != null) {
            return zzlp.zzp(zzF.digest(bArr));
        }
        this.zzt.zzaA().zzd().zza("Failed to get MD5");
        return 0;
    }

    public final Bundle zzh(Map map, boolean z11) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, (String) null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z11) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    arrayList2.add(zzh((Map) arrayList.get(i11), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.zzt.zzaA().zzd().zza("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Parcelable zzi(byte[] r5, android.os.Parcelable.Creator r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002f
        L_0x001c:
            com.google.android.gms.measurement.internal.zzgd r5 = r4.zzt     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzaA()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzd()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zza(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002f:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.zzi(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = r0.get(com.google.firebase.crashlytics.CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzau zzj(com.google.android.gms.internal.measurement.zzaa r9) {
        /*
            r8 = this;
            java.util.Map r0 = r9.zze()
            r1 = 1
            android.os.Bundle r0 = r8.zzh(r0, r1)
            java.lang.String r1 = "_o"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L_0x001c
            java.lang.Object r1 = r0.get(r1)
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r1.toString()
            goto L_0x001e
        L_0x001c:
            java.lang.String r1 = "app"
        L_0x001e:
            r5 = r1
            java.lang.String r1 = r9.zzd()
            java.lang.String r1 = com.google.android.gms.measurement.internal.zzhc.zzb(r1)
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = r9.zzd()
        L_0x002d:
            r3 = r1
            com.google.android.gms.measurement.internal.zzau r1 = new com.google.android.gms.measurement.internal.zzau
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas
            r4.<init>(r0)
            long r6 = r9.zza()
            r2 = r1
            r2.<init>(r3, r4, r5, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.zzj(com.google.android.gms.internal.measurement.zzaa):com.google.android.gms.measurement.internal.zzau");
    }

    public final zzft zzl(zzap zzap) {
        zzfs zze = zzft.zze();
        zze.zzl(zzap.zze);
        zzar zzar = new zzar(zzap.zzf);
        while (zzar.hasNext()) {
            String zza = zzar.next();
            zzfw zze2 = zzfx.zze();
            zze2.zzj(zza);
            Object zzf = zzap.zzf.zzf(zza);
            Preconditions.checkNotNull(zzf);
            zzu(zze2, zzf);
            zze.zze(zze2);
        }
        return (zzft) zze.zzaD();
    }

    public final String zzo(zzgb zzgb) {
        if (zzgb == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        for (zzgd zzgd : zzgb.zzd()) {
            if (zzgd != null) {
                zzG(sb2, 1);
                sb2.append("bundle {\n");
                if (zzgd.zzbl()) {
                    zzJ(sb2, 1, "protocol_version", Integer.valueOf(zzgd.zzd()));
                }
                zzqu.zzc();
                if (this.zzt.zzf().zzs(zzgd.zzy(), zzeg.zzao) && zzgd.zzbo()) {
                    zzJ(sb2, 1, "session_stitching_token", zzgd.zzL());
                }
                zzJ(sb2, 1, "platform", zzgd.zzJ());
                if (zzgd.zzbh()) {
                    zzJ(sb2, 1, "gmp_version", Long.valueOf(zzgd.zzm()));
                }
                if (zzgd.zzbt()) {
                    zzJ(sb2, 1, "uploading_gmp_version", Long.valueOf(zzgd.zzs()));
                }
                if (zzgd.zzbf()) {
                    zzJ(sb2, 1, "dynamite_version", Long.valueOf(zzgd.zzj()));
                }
                if (zzgd.zzbc()) {
                    zzJ(sb2, 1, "config_version", Long.valueOf(zzgd.zzh()));
                }
                zzJ(sb2, 1, "gmp_app_id", zzgd.zzG());
                zzJ(sb2, 1, "admob_app_id", zzgd.zzx());
                zzJ(sb2, 1, "app_id", zzgd.zzy());
                zzJ(sb2, 1, Constants.EXTRA_KEY_APP_VERSION, zzgd.zzB());
                if (zzgd.zzba()) {
                    zzJ(sb2, 1, "app_version_major", Integer.valueOf(zzgd.zza()));
                }
                zzJ(sb2, 1, "firebase_instance_id", zzgd.zzF());
                if (zzgd.zzbe()) {
                    zzJ(sb2, 1, "dev_cert_hash", Long.valueOf(zzgd.zzi()));
                }
                zzJ(sb2, 1, "app_store", zzgd.zzA());
                if (zzgd.zzbs()) {
                    zzJ(sb2, 1, "upload_timestamp_millis", Long.valueOf(zzgd.zzr()));
                }
                if (zzgd.zzbp()) {
                    zzJ(sb2, 1, "start_timestamp_millis", Long.valueOf(zzgd.zzp()));
                }
                if (zzgd.zzbg()) {
                    zzJ(sb2, 1, "end_timestamp_millis", Long.valueOf(zzgd.zzk()));
                }
                if (zzgd.zzbk()) {
                    zzJ(sb2, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgd.zzo()));
                }
                if (zzgd.zzbj()) {
                    zzJ(sb2, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgd.zzn()));
                }
                zzJ(sb2, 1, "app_instance_id", zzgd.zzz());
                zzJ(sb2, 1, "resettable_device_id", zzgd.zzK());
                zzJ(sb2, 1, "ds_id", zzgd.zzE());
                if (zzgd.zzbi()) {
                    zzJ(sb2, 1, "limited_ad_tracking", Boolean.valueOf(zzgd.zzaY()));
                }
                zzJ(sb2, 1, TPDownloadProxyEnum.USER_OS_VERSION, zzgd.zzI());
                zzJ(sb2, 1, TPDownloadProxyEnum.USER_DEVICE_MODEL, zzgd.zzD());
                zzJ(sb2, 1, "user_default_language", zzgd.zzM());
                if (zzgd.zzbr()) {
                    zzJ(sb2, 1, "time_zone_offset_minutes", Integer.valueOf(zzgd.zzf()));
                }
                if (zzgd.zzbb()) {
                    zzJ(sb2, 1, "bundle_sequential_index", Integer.valueOf(zzgd.zzb()));
                }
                if (zzgd.zzbn()) {
                    zzJ(sb2, 1, "service_upload", Boolean.valueOf(zzgd.zzaZ()));
                }
                zzJ(sb2, 1, "health_monitor", zzgd.zzH());
                if (zzgd.zzbm()) {
                    zzJ(sb2, 1, "retry_counter", Integer.valueOf(zzgd.zze()));
                }
                if (zzgd.zzbd()) {
                    zzJ(sb2, 1, "consent_signals", zzgd.zzC());
                }
                zzpz.zzc();
                if (this.zzt.zzf().zzs((String) null, zzeg.zzaE) && zzgd.zzbq()) {
                    zzJ(sb2, 1, "target_os_version", Long.valueOf(zzgd.zzq()));
                }
                List<zzgm> zzP = zzgd.zzP();
                if (zzP != null) {
                    for (zzgm zzgm : zzP) {
                        if (zzgm != null) {
                            zzG(sb2, 2);
                            sb2.append("user_property {\n");
                            zzJ(sb2, 2, "set_timestamp_millis", zzgm.zzs() ? Long.valueOf(zzgm.zzc()) : null);
                            zzJ(sb2, 2, "name", this.zzt.zzj().zzf(zzgm.zzf()));
                            zzJ(sb2, 2, "string_value", zzgm.zzg());
                            zzJ(sb2, 2, "int_value", zzgm.zzr() ? Long.valueOf(zzgm.zzb()) : null);
                            zzJ(sb2, 2, "double_value", zzgm.zzq() ? Double.valueOf(zzgm.zza()) : null);
                            zzG(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<zzfp> zzN = zzgd.zzN();
                if (zzN != null) {
                    for (zzfp zzfp : zzN) {
                        if (zzfp != null) {
                            zzG(sb2, 2);
                            sb2.append("audience_membership {\n");
                            if (zzfp.zzk()) {
                                zzJ(sb2, 2, "audience_id", Integer.valueOf(zzfp.zza()));
                            }
                            if (zzfp.zzm()) {
                                zzJ(sb2, 2, "new_audience", Boolean.valueOf(zzfp.zzj()));
                            }
                            zzI(sb2, 2, "current_data", zzfp.zzd());
                            if (zzfp.zzn()) {
                                zzI(sb2, 2, "previous_data", zzfp.zze());
                            }
                            zzG(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<zzft> zzO = zzgd.zzO();
                if (zzO != null) {
                    for (zzft zzft : zzO) {
                        if (zzft != null) {
                            zzG(sb2, 2);
                            sb2.append("event {\n");
                            zzJ(sb2, 2, "name", this.zzt.zzj().zzd(zzft.zzh()));
                            if (zzft.zzu()) {
                                zzJ(sb2, 2, "timestamp_millis", Long.valueOf(zzft.zzd()));
                            }
                            if (zzft.zzt()) {
                                zzJ(sb2, 2, "previous_timestamp_millis", Long.valueOf(zzft.zzc()));
                            }
                            if (zzft.zzs()) {
                                zzJ(sb2, 2, "count", Integer.valueOf(zzft.zza()));
                            }
                            if (zzft.zzb() != 0) {
                                zzE(sb2, 2, zzft.zzi());
                            }
                            zzG(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                zzG(sb2, 1);
                sb2.append("}\n");
            }
        }
        sb2.append("}\n");
        return sb2.toString();
    }

    public final String zzp(zzek zzek) {
        if (zzek == null) {
            return OptionsBridge.NULL_VALUE;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nevent_filter {\n");
        if (zzek.zzp()) {
            zzJ(sb2, 0, "filter_id", Integer.valueOf(zzek.zzb()));
        }
        zzJ(sb2, 0, "event_name", this.zzt.zzj().zzd(zzek.zzg()));
        String zzH = zzH(zzek.zzk(), zzek.zzm(), zzek.zzn());
        if (!zzH.isEmpty()) {
            zzJ(sb2, 0, "filter_type", zzH);
        }
        if (zzek.zzo()) {
            zzK(sb2, 1, "event_count_filter", zzek.zzf());
        }
        if (zzek.zza() > 0) {
            sb2.append("  filters {\n");
            for (zzem zzF : zzek.zzh()) {
                zzF(sb2, 2, zzF);
            }
        }
        zzG(sb2, 1);
        sb2.append("}\n}\n");
        return sb2.toString();
    }

    public final String zzq(zzet zzet) {
        if (zzet == null) {
            return OptionsBridge.NULL_VALUE;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nproperty_filter {\n");
        if (zzet.zzj()) {
            zzJ(sb2, 0, "filter_id", Integer.valueOf(zzet.zza()));
        }
        zzJ(sb2, 0, "property_name", this.zzt.zzj().zzf(zzet.zze()));
        String zzH = zzH(zzet.zzg(), zzet.zzh(), zzet.zzi());
        if (!zzH.isEmpty()) {
            zzJ(sb2, 0, "filter_type", zzH);
        }
        zzF(sb2, 1, zzet.zzb());
        sb2.append("}\n");
        return sb2.toString();
    }

    public final List zzr(List list, List list2) {
        int i11;
        ArrayList arrayList = new ArrayList(list);
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) it2.next();
            if (num.intValue() < 0) {
                this.zzt.zzaA().zzk().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzt.zzaA().zzk().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i12 = size2;
            i11 = size;
            size = i12;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i11);
    }

    public final Map zzt(Bundle bundle, boolean z11) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z12 = obj instanceof Parcelable[];
            if (z12 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z11) {
                    ArrayList arrayList = new ArrayList();
                    if (z12) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zzt((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            Object obj2 = arrayList2.get(i11);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zzt((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zzt((Bundle) obj, false));
                    }
                    hashMap.put(str, arrayList);
                }
            } else if (obj != null) {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    public final void zzu(zzfw zzfw, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfw.zzg();
        zzfw.zze();
        zzfw.zzd();
        zzfw.zzf();
        if (obj instanceof String) {
            zzfw.zzk((String) obj);
        } else if (obj instanceof Long) {
            zzfw.zzi(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzfw.zzh(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    zzfw zze = zzfx.zze();
                    for (String str : bundle.keySet()) {
                        zzfw zze2 = zzfx.zze();
                        zze2.zzj(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zze2.zzi(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zze2.zzk((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zze2.zzh(((Double) obj2).doubleValue());
                        }
                        zze.zzc(zze2);
                    }
                    if (zze.zza() > 0) {
                        arrayList.add((zzfx) zze.zzaD());
                    }
                }
            }
            zzfw.zzb(arrayList);
        } else {
            this.zzt.zzaA().zzd().zzb("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zzv(zzgl zzgl, Object obj) {
        Preconditions.checkNotNull(obj);
        zzgl.zzc();
        zzgl.zzb();
        zzgl.zza();
        if (obj instanceof String) {
            zzgl.zzh((String) obj);
        } else if (obj instanceof Long) {
            zzgl.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzgl.zzd(((Double) obj).doubleValue());
        } else {
            this.zzt.zzaA().zzd().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final boolean zzx(long j11, long j12) {
        return j11 == 0 || j12 <= 0 || Math.abs(this.zzt.zzax().currentTimeMillis() - j11) > j12;
    }

    public final byte[] zzz(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            this.zzt.zzaA().zzd().zzb("Failed to gzip content", e11);
            throw e11;
        }
    }
}
