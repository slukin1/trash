package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;

public final class zzbb {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01fd, code lost:
        r1 = r22.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0201, code lost:
        r2 = r22.zzc();
        r4 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x020f, code lost:
        if (r24.size() <= 1) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0211, code lost:
        r5 = java.lang.Math.max(0, (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x022d, code lost:
        if (r5 <= 0) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x022f, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0236, code lost:
        if (r6 >= java.lang.Math.min(r2, r1 + r5)) goto L_0x0249;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0238, code lost:
        r4.zzq(r4.zzc(), r9.zze(r1));
        r9.zzp(r1);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x024e, code lost:
        if (r24.size() <= 2) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0250, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0255, code lost:
        if (r2 >= r24.size()) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0257, code lost:
        r5 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0263, code lost:
        if ((r5 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x026f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0265, code lost:
        r9.zzo((r1 + r2) - 2, r5);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0276, code lost:
        throw new java.lang.IllegalArgumentException("Failed to parse elements to add");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0277, code lost:
        if (r1 >= r2) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0279, code lost:
        r4.zzq(r4.zzc(), r9.zze(r1));
        r9.zzq(r1, (com.google.android.gms.internal.measurement.zzap) null);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x028d, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("sort", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x029c, code lost:
        if (r22.zzc() >= 2) goto L_0x029f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x029f, code lost:
        r1 = r22.zzm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a7, code lost:
        if (r24.isEmpty() != false) goto L_0x02c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02a9, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02b6, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x02bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02b8, code lost:
        r0 = (com.google.android.gms.internal.measurement.zzai) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c2, code lost:
        throw new java.lang.IllegalArgumentException("Comparator should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02c3, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02c4, code lost:
        java.util.Collections.sort(r1, new com.google.android.gms.internal.measurement.zzba(r0, r3));
        r22.zzn();
        r0 = r1.iterator();
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02d8, code lost:
        if (r0.hasNext() == false) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02da, code lost:
        r9.zzq(r2, (com.google.android.gms.internal.measurement.zzap) r0.next());
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02e7, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02e8, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("some", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02ff, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0305, code lost:
        if (r22.zzc() != 0) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x030a, code lost:
        r0 = (com.google.android.gms.internal.measurement.zzai) r0;
        r1 = r22.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0314, code lost:
        if (r1.hasNext() == false) goto L_0x0355;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0316, code lost:
        r2 = ((java.lang.Integer) r1.next()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0324, code lost:
        if (r9.zzs(r2) == false) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0350, code lost:
        if (r0.zza(r3, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r9.zze(r2), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2)), r9})).zzg().booleanValue() == false) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x035f, code lost:
        throw new java.lang.IllegalArgumentException(r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0360, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x036e, code lost:
        if (r24.isEmpty() == false) goto L_0x0375;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0375, code lost:
        r4 = (double) r22.zzc();
        r6 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0393, code lost:
        if (r6 >= 0.0d) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0395, code lost:
        r6 = java.lang.Math.max(r6 + r4, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x039b, code lost:
        r6 = java.lang.Math.min(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03a4, code lost:
        if (r24.size() != 2) goto L_0x03cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03a6, code lost:
        r10 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03bf, code lost:
        if (r10 >= 0.0d) goto L_0x03c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03c1, code lost:
        r4 = java.lang.Math.max(r4 + r10, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03c7, code lost:
        r4 = java.lang.Math.min(r4, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03cb, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r1 = (int) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03d4, code lost:
        if (((double) r1) >= r4) goto L_0x03e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03d6, code lost:
        r0.zzq(r0.zzc(), r9.zze(r1));
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03e5, code lost:
        r9 = r22;
        com.google.android.gms.internal.measurement.zzh.zzh(com.jumio.liveness.DaClient.ATTR_SHIFT, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03f1, code lost:
        if (r22.zzc() != 0) goto L_0x03f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03f6, code lost:
        r0 = r9.zze(0);
        r9.zzp(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03fe, code lost:
        r9 = r22;
        com.google.android.gms.internal.measurement.zzh.zzh("reverse", 0, r24);
        r0 = r22.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x040a, code lost:
        if (r0 == 0) goto L_0x0435;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x040c, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x040f, code lost:
        if (r2 >= (r0 / 2)) goto L_0x0435;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0415, code lost:
        if (r9.zzs(r2) == false) goto L_0x0432;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0417, code lost:
        r1 = r9.zze(r2);
        r9.zzq(r2, (com.google.android.gms.internal.measurement.zzap) null);
        r3 = (r0 - 1) - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0426, code lost:
        if (r9.zzs(r3) == false) goto L_0x042f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0428, code lost:
        r9.zzq(r2, r9.zze(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x042f, code lost:
        r9.zzq(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0432, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0435, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0441, code lost:
        return zzc(r22, r23, r24, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x044d, code lost:
        return zzc(r22, r23, r24, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x044e, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0458, code lost:
        if (r24.isEmpty() != false) goto L_0x0476;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x045a, code lost:
        r0 = r24.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0462, code lost:
        if (r0.hasNext() == false) goto L_0x0476;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0464, code lost:
        r9.zzq(r22.zzc(), r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0484, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r22.zzc()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0485, code lost:
        r9 = r22;
        com.google.android.gms.internal.measurement.zzh.zzh("pop", 0, r24);
        r0 = r22.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0491, code lost:
        if (r0 != 0) goto L_0x0496;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0496, code lost:
        r0 = r0 - 1;
        r1 = r9.zze(r0);
        r9.zzp(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04a1, code lost:
        r1 = r21;
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("map", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04ba, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x04d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04c0, code lost:
        if (r22.zzc() != 0) goto L_0x04c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x04d5, code lost:
        throw new java.lang.IllegalArgumentException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04d6, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("lastIndexOf", 2, r0);
        r4 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04e6, code lost:
        if (r24.isEmpty() != false) goto L_0x04f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04e8, code lost:
        r4 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04f3, code lost:
        r5 = r22.zzc() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x04fe, code lost:
        if (r24.size() <= 1) goto L_0x0537;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0500, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0516, code lost:
        if (java.lang.Double.isNaN(r0.zzh().doubleValue()) == false) goto L_0x0520;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0518, code lost:
        r5 = (double) (r22.zzc() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0520, code lost:
        r5 = com.google.android.gms.internal.measurement.zzh.zza(r0.zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x052e, code lost:
        if (r5 >= 0.0d) goto L_0x0538;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0530, code lost:
        r5 = r5 + ((double) r22.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0537, code lost:
        r5 = (double) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x053a, code lost:
        if (r5 >= 0.0d) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0546, code lost:
        r0 = (int) java.lang.Math.min((double) r22.zzc(), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0550, code lost:
        if (r0 < 0) goto L_0x0571;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0556, code lost:
        if (r9.zzs(r0) == false) goto L_0x056e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0560, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzl(r9.zze(r0), r4) == false) goto L_0x056e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x056e, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x057b, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("join", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0589, code lost:
        if (r22.zzc() != 0) goto L_0x058e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0592, code lost:
        if (r24.isEmpty() != false) goto L_0x05b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0594, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x05a1, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) != false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x05a5, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzau) == false) goto L_0x05a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05a8, code lost:
        r0 = r0.zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x05ad, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x05b0, code lost:
        r0 = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05bd, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("indexOf", 2, r0);
        r4 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x05cd, code lost:
        if (r24.isEmpty() != false) goto L_0x05da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x05cf, code lost:
        r4 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x05df, code lost:
        if (r24.size() <= 1) goto L_0x0617;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05e1, code lost:
        r5 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x05fe, code lost:
        if (r5 < ((double) r22.zzc())) goto L_0x060a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x060c, code lost:
        if (r5 >= 0.0d) goto L_0x0616;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x060e, code lost:
        r1 = ((double) r22.zzc()) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0616, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0617, code lost:
        r0 = r22.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x061f, code lost:
        if (r0.hasNext() == false) goto L_0x0644;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0621, code lost:
        r3 = ((java.lang.Integer) r0.next()).intValue();
        r5 = (double) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x062e, code lost:
        if (r5 < r1) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0638, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzl(r9.zze(r3), r4) == false) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x064e, code lost:
        r1 = r21;
        r9 = r22;
        r0 = r24;
        r3 = r23;
        com.google.android.gms.internal.measurement.zzh.zzh("forEach", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0668, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x067c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x066e, code lost:
        if (r22.zzb() != 0) goto L_0x0673;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0673, code lost:
        zzb(r9, r3, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0681, code lost:
        throw new java.lang.IllegalArgumentException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0682, code lost:
        r1 = r21;
        r9 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh(r20, 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x069d, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x06e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x06a3, code lost:
        if (r22.zzb() != 0) goto L_0x06ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x06ab, code lost:
        r1 = r22.zzd();
        r0 = zzb(r9, r3, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, java.lang.Boolean.TRUE);
        r2 = new com.google.android.gms.internal.measurement.zzae();
        r0 = r0.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x06c5, code lost:
        if (r0.hasNext() == false) goto L_0x06e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x06c7, code lost:
        r2.zzq(r2.zzc(), ((com.google.android.gms.internal.measurement.zzae) r1).zze(((java.lang.Integer) r0.next()).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x06e7, code lost:
        throw new java.lang.IllegalArgumentException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x06e8, code lost:
        r1 = r21;
        r2 = r22;
        r3 = r23;
        r0 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("every", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0701, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x0726;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0707, code lost:
        if (r22.zzc() != 0) goto L_0x070c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x071e, code lost:
        if (zzb(r2, r3, (com.google.android.gms.internal.measurement.zzao) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).zzc() == r22.zzc()) goto L_0x0723;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0034, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x072b, code lost:
        throw new java.lang.IllegalArgumentException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x072c, code lost:
        r2 = r22;
        r3 = r23;
        r0 = r24;
        r1 = r22.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x073a, code lost:
        if (r24.isEmpty() != false) goto L_0x078e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x073c, code lost:
        r0 = r24.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0744, code lost:
        if (r0.hasNext() == false) goto L_0x078e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0746, code lost:
        r2 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0752, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0786;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0754, code lost:
        r4 = (com.google.android.gms.internal.measurement.zzae) r1;
        r5 = r4.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x075d, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzae) == false) goto L_0x0782;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x075f, code lost:
        r2 = (com.google.android.gms.internal.measurement.zzae) r2;
        r6 = r2.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0769, code lost:
        if (r6.hasNext() == false) goto L_0x0740;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x076b, code lost:
        r7 = (java.lang.Integer) r6.next();
        r4.zzq(r7.intValue() + r5, r2.zze(r7.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0782, code lost:
        r4.zzq(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x078d, code lost:
        throw new java.lang.IllegalStateException("Failed evaluation of arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x078e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:?, code lost:
        return r22.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:?, code lost:
        return zzb(r9, r3, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r9.zzj(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00de, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0102, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0104, code lost:
        r20 = "filter";
        r21 = "Callback should be a method";
        r1 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010e, code lost:
        switch(r0) {
            case 0: goto L_0x072c;
            case 1: goto L_0x06e8;
            case 2: goto L_0x0682;
            case 3: goto L_0x064e;
            case 4: goto L_0x05bd;
            case 5: goto L_0x057b;
            case 6: goto L_0x04d6;
            case 7: goto L_0x04a1;
            case 8: goto L_0x0485;
            case 9: goto L_0x044e;
            case 10: goto L_0x0442;
            case 11: goto L_0x0436;
            case 12: goto L_0x03fe;
            case 13: goto L_0x03e5;
            case 14: goto L_0x0360;
            case 15: goto L_0x02e8;
            case 16: goto L_0x028d;
            case 17: goto L_0x01c0;
            case 18: goto L_0x01ab;
            case 19: goto L_0x0119;
            default: goto L_0x0111;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0118, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x011d, code lost:
        if (r24.isEmpty() != false) goto L_0x019a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011f, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r1 = r24.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012c, code lost:
        if (r1.hasNext() == false) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012e, code lost:
        r2 = r23.zzb((com.google.android.gms.internal.measurement.zzap) r1.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013c, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x013e, code lost:
        r0.zzq(r0.zzc(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x014d, code lost:
        throw new java.lang.IllegalStateException("Argument evaluation failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014e, code lost:
        r1 = r0.zzc();
        r2 = r22.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x015a, code lost:
        if (r2.hasNext() == false) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x015c, code lost:
        r3 = (java.lang.Integer) r2.next();
        r0.zzq(r3.intValue() + r1, r22.zze(r3.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0175, code lost:
        r9 = r22;
        r22.zzn();
        r1 = r0.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0182, code lost:
        if (r1.hasNext() == false) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0184, code lost:
        r2 = (java.lang.Integer) r1.next();
        r9.zzq(r2.intValue(), r0.zze(r2.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019a, code lost:
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01aa, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r22.zzc()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ab, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r4, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01bf, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r22.zzj(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c0, code lost:
        r9 = r22;
        r3 = r23;
        r0 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cb, code lost:
        if (r24.isEmpty() == false) goto L_0x01d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01d4, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01eb, code lost:
        if (r1 >= 0) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ed, code lost:
        r1 = java.lang.Math.max(0, r1 + r22.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01fb, code lost:
        if (r1 <= r22.zzc()) goto L_0x0201;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzap zza(java.lang.String r21, com.google.android.gms.internal.measurement.zzae r22, com.google.android.gms.internal.measurement.zzg r23, java.util.List r24) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            int r4 = r21.hashCode()
            java.lang.String r5 = "indexOf"
            java.lang.String r6 = "reverse"
            java.lang.String r7 = "slice"
            java.lang.String r8 = "shift"
            java.lang.String r9 = "every"
            java.lang.String r10 = "sort"
            java.lang.String r11 = "some"
            java.lang.String r12 = "join"
            java.lang.String r13 = "pop"
            java.lang.String r14 = "map"
            java.lang.String r15 = "lastIndexOf"
            java.lang.String r3 = "forEach"
            java.lang.String r1 = "filter"
            java.lang.String r2 = "toString"
            r16 = -1
            r17 = r2
            switch(r4) {
                case -1776922004: goto L_0x00f7;
                case -1354795244: goto L_0x00eb;
                case -1274492040: goto L_0x00e1;
                case -934873754: goto L_0x00d4;
                case -895859076: goto L_0x00c8;
                case -678635926: goto L_0x00c0;
                case -467511597: goto L_0x00b8;
                case -277637751: goto L_0x00ac;
                case 107868: goto L_0x00a4;
                case 111185: goto L_0x009b;
                case 3267882: goto L_0x0093;
                case 3452698: goto L_0x0088;
                case 3536116: goto L_0x007f;
                case 3536286: goto L_0x0076;
                case 96891675: goto L_0x006b;
                case 109407362: goto L_0x0061;
                case 109526418: goto L_0x0057;
                case 965561430: goto L_0x004b;
                case 1099846370: goto L_0x0041;
                case 1943291465: goto L_0x0038;
                default: goto L_0x0034;
            }
        L_0x0034:
            r4 = r17
            goto L_0x0102
        L_0x0038:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0034
            r0 = 4
            goto L_0x00de
        L_0x0041:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0034
            r0 = 12
            goto L_0x00de
        L_0x004b:
            java.lang.String r4 = "reduceRight"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0034
            r0 = 11
            goto L_0x00de
        L_0x0057:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x0034
            r0 = 14
            goto L_0x00de
        L_0x0061:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0034
            r0 = 13
            goto L_0x00de
        L_0x006b:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0034
            r4 = r17
            r0 = 1
            goto L_0x0104
        L_0x0076:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0034
            r0 = 16
            goto L_0x00de
        L_0x007f:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0034
            r0 = 15
            goto L_0x00de
        L_0x0088:
            java.lang.String r4 = "push"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0034
            r0 = 9
            goto L_0x00de
        L_0x0093:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0034
            r0 = 5
            goto L_0x00de
        L_0x009b:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0034
            r0 = 8
            goto L_0x00de
        L_0x00a4:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0034
            r0 = 7
            goto L_0x00de
        L_0x00ac:
            java.lang.String r4 = "unshift"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0034
            r0 = 19
            goto L_0x00de
        L_0x00b8:
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0034
            r0 = 6
            goto L_0x00de
        L_0x00c0:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0034
            r0 = 3
            goto L_0x00de
        L_0x00c8:
            java.lang.String r4 = "splice"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0034
            r0 = 17
            goto L_0x00de
        L_0x00d4:
            java.lang.String r4 = "reduce"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0034
            r0 = 10
        L_0x00de:
            r4 = r17
            goto L_0x0104
        L_0x00e1:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0034
            r4 = r17
            r0 = 2
            goto L_0x0104
        L_0x00eb:
            java.lang.String r4 = "concat"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0034
            r4 = r17
            r0 = 0
            goto L_0x0104
        L_0x00f7:
            r4 = r17
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0102
            r0 = 18
            goto L_0x0104
        L_0x0102:
            r0 = r16
        L_0x0104:
            r18 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r2 = "Callback should be a method"
            r20 = r1
            r21 = r2
            r1 = 0
            switch(r0) {
                case 0: goto L_0x072c;
                case 1: goto L_0x06e8;
                case 2: goto L_0x0682;
                case 3: goto L_0x064e;
                case 4: goto L_0x05bd;
                case 5: goto L_0x057b;
                case 6: goto L_0x04d6;
                case 7: goto L_0x04a1;
                case 8: goto L_0x0485;
                case 9: goto L_0x044e;
                case 10: goto L_0x0442;
                case 11: goto L_0x0436;
                case 12: goto L_0x03fe;
                case 13: goto L_0x03e5;
                case 14: goto L_0x0360;
                case 15: goto L_0x02e8;
                case 16: goto L_0x028d;
                case 17: goto L_0x01c0;
                case 18: goto L_0x01ab;
                case 19: goto L_0x0119;
                default: goto L_0x0111;
            }
        L_0x0111:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0119:
            boolean r0 = r24.isEmpty()
            if (r0 != 0) goto L_0x019a
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            java.util.Iterator r1 = r24.iterator()
        L_0x0128:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x014e
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            r3 = r23
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x0146
            int r4 = r0.zzc()
            r0.zzq(r4, r2)
            goto L_0x0128
        L_0x0146:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x014e:
            int r1 = r0.zzc()
            java.util.Iterator r2 = r22.zzk()
        L_0x0156:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0175
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            r9 = r22
            com.google.android.gms.internal.measurement.zzap r3 = r9.zze(r3)
            r0.zzq(r4, r3)
            goto L_0x0156
        L_0x0175:
            r9 = r22
            r22.zzn()
            java.util.Iterator r1 = r0.zzk()
        L_0x017e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x019c
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzap r2 = r0.zze(r2)
            r9.zzq(r3, r2)
            goto L_0x017e
        L_0x019a:
            r9 = r22
        L_0x019c:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r22.zzc()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x01ab:
            r9 = r22
            r0 = r24
            r1 = r4
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r1, r2, r0)
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = ","
            java.lang.String r1 = r9.zzj(r1)
            r0.<init>(r1)
            return r0
        L_0x01c0:
            r9 = r22
            r3 = r23
            r0 = r24
            r2 = 0
            boolean r1 = r24.isEmpty()
            if (r1 == 0) goto L_0x01d4
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x028c
        L_0x01d4:
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r4 = r1.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            int r1 = (int) r4
            if (r1 >= 0) goto L_0x01f7
            int r4 = r22.zzc()
            int r1 = r1 + r4
            int r1 = java.lang.Math.max(r2, r1)
            goto L_0x0201
        L_0x01f7:
            int r2 = r22.zzc()
            if (r1 <= r2) goto L_0x0201
            int r1 = r22.zzc()
        L_0x0201:
            int r2 = r22.zzc()
            com.google.android.gms.internal.measurement.zzae r4 = new com.google.android.gms.internal.measurement.zzae
            r4.<init>()
            int r5 = r24.size()
            r6 = 1
            if (r5 <= r6) goto L_0x0277
            java.lang.Object r5 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r5 = r3.zzb(r5)
            java.lang.Double r5 = r5.zzh()
            double r5 = r5.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
            int r5 = (int) r5
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            if (r5 <= 0) goto L_0x0249
            r6 = r1
        L_0x0230:
            int r7 = r1 + r5
            int r7 = java.lang.Math.min(r2, r7)
            if (r6 >= r7) goto L_0x0249
            com.google.android.gms.internal.measurement.zzap r7 = r9.zze(r1)
            int r8 = r4.zzc()
            r4.zzq(r8, r7)
            r9.zzp(r1)
            int r6 = r6 + 1
            goto L_0x0230
        L_0x0249:
            int r2 = r24.size()
            r5 = 2
            if (r2 <= r5) goto L_0x028b
            r2 = 2
        L_0x0251:
            int r5 = r24.size()
            if (r2 >= r5) goto L_0x028b
            java.lang.Object r5 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r5 = r3.zzb(r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzag
            if (r6 != 0) goto L_0x026f
            int r6 = r1 + r2
            int r6 = r6 + -2
            r9.zzo(r6, r5)
            int r2 = r2 + 1
            goto L_0x0251
        L_0x026f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x0277:
            if (r1 >= r2) goto L_0x028b
            com.google.android.gms.internal.measurement.zzap r0 = r9.zze(r1)
            int r3 = r4.zzc()
            r4.zzq(r3, r0)
            r0 = 0
            r9.zzq(r1, r0)
            int r1 = r1 + 1
            goto L_0x0277
        L_0x028b:
            r0 = r4
        L_0x028c:
            return r0
        L_0x028d:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r1, r0)
            int r1 = r22.zzc()
            r2 = 2
            if (r1 >= r2) goto L_0x029f
            goto L_0x02e7
        L_0x029f:
            java.util.List r1 = r22.zzm()
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x02c3
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r2 == 0) goto L_0x02bb
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            goto L_0x02c4
        L_0x02bb:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x02c3:
            r0 = 0
        L_0x02c4:
            com.google.android.gms.internal.measurement.zzba r2 = new com.google.android.gms.internal.measurement.zzba
            r2.<init>(r0, r3)
            java.util.Collections.sort(r1, r2)
            r22.zzn()
            java.util.Iterator r0 = r1.iterator()
            r2 = 0
        L_0x02d4:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02e7
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            int r3 = r2 + 1
            r9.zzq(r2, r1)
            r2 = r3
            goto L_0x02d4
        L_0x02e7:
            return r9
        L_0x02e8:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r11, r1, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x0358
            int r1 = r22.zzc()
            if (r1 != 0) goto L_0x030a
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x0357
        L_0x030a:
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            java.util.Iterator r1 = r22.zzk()
        L_0x0310:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0355
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            boolean r4 = r9.zzs(r2)
            if (r4 == 0) goto L_0x0310
            r4 = 3
            com.google.android.gms.internal.measurement.zzap[] r4 = new com.google.android.gms.internal.measurement.zzap[r4]
            com.google.android.gms.internal.measurement.zzap r5 = r9.zze(r2)
            r6 = 0
            r4[r6] = r5
            double r5 = (double) r2
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r2.<init>(r5)
            r5 = 1
            r4[r5] = r2
            r2 = 2
            r4[r2] = r9
            java.util.List r2 = java.util.Arrays.asList(r4)
            com.google.android.gms.internal.measurement.zzap r2 = r0.zza(r3, r2)
            java.lang.Boolean r2 = r2.zzg()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0310
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x0357
        L_0x0355:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
        L_0x0357:
            return r0
        L_0x0358:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r21
            r0.<init>(r1)
            throw r0
        L_0x0360:
            r9 = r22
            r3 = r23
            r0 = r24
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r7, r4, r0)
            boolean r4 = r24.isEmpty()
            if (r4 == 0) goto L_0x0375
            com.google.android.gms.internal.measurement.zzap r0 = r22.zzd()
            goto L_0x03e4
        L_0x0375:
            int r4 = r22.zzc()
            double r4 = (double) r4
            r6 = 0
            java.lang.Object r6 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzap r6 = (com.google.android.gms.internal.measurement.zzap) r6
            com.google.android.gms.internal.measurement.zzap r6 = r3.zzb(r6)
            java.lang.Double r6 = r6.zzh()
            double r6 = r6.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzh.zza(r6)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 >= 0) goto L_0x039b
            double r6 = r6 + r4
            double r6 = java.lang.Math.max(r6, r1)
            goto L_0x039f
        L_0x039b:
            double r6 = java.lang.Math.min(r6, r4)
        L_0x039f:
            int r8 = r24.size()
            r10 = 2
            if (r8 != r10) goto L_0x03cb
            r8 = 1
            java.lang.Object r0 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r10 = r0.doubleValue()
            double r10 = com.google.android.gms.internal.measurement.zzh.zza(r10)
            int r0 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x03c7
            double r4 = r4 + r10
            double r4 = java.lang.Math.max(r4, r1)
            goto L_0x03cb
        L_0x03c7:
            double r4 = java.lang.Math.min(r4, r10)
        L_0x03cb:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            int r1 = (int) r6
        L_0x03d1:
            double r2 = (double) r1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x03e4
            com.google.android.gms.internal.measurement.zzap r2 = r9.zze(r1)
            int r3 = r0.zzc()
            r0.zzq(r3, r2)
            int r1 = r1 + 1
            goto L_0x03d1
        L_0x03e4:
            return r0
        L_0x03e5:
            r9 = r22
            r0 = r24
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r1, r0)
            int r0 = r22.zzc()
            if (r0 != 0) goto L_0x03f6
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x03fd
        L_0x03f6:
            com.google.android.gms.internal.measurement.zzap r0 = r9.zze(r1)
            r9.zzp(r1)
        L_0x03fd:
            return r0
        L_0x03fe:
            r9 = r22
            r0 = r24
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r6, r1, r0)
            int r0 = r22.zzc()
            if (r0 == 0) goto L_0x0435
            r2 = 0
        L_0x040d:
            int r1 = r0 / 2
            if (r2 >= r1) goto L_0x0435
            boolean r1 = r9.zzs(r2)
            if (r1 == 0) goto L_0x0432
            com.google.android.gms.internal.measurement.zzap r1 = r9.zze(r2)
            r3 = 0
            r9.zzq(r2, r3)
            int r3 = r0 + -1
            int r3 = r3 - r2
            boolean r4 = r9.zzs(r3)
            if (r4 == 0) goto L_0x042f
            com.google.android.gms.internal.measurement.zzap r4 = r9.zze(r3)
            r9.zzq(r2, r4)
        L_0x042f:
            r9.zzq(r3, r1)
        L_0x0432:
            int r2 = r2 + 1
            goto L_0x040d
        L_0x0435:
            return r9
        L_0x0436:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 0
            com.google.android.gms.internal.measurement.zzap r0 = zzc(r9, r3, r0, r1)
            return r0
        L_0x0442:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 1
            com.google.android.gms.internal.measurement.zzap r0 = zzc(r9, r3, r0, r1)
            return r0
        L_0x044e:
            r9 = r22
            r3 = r23
            r0 = r24
            boolean r1 = r24.isEmpty()
            if (r1 != 0) goto L_0x0476
            java.util.Iterator r0 = r24.iterator()
        L_0x045e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0476
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            int r2 = r22.zzc()
            r9.zzq(r2, r1)
            goto L_0x045e
        L_0x0476:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r22.zzc()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x0485:
            r9 = r22
            r0 = r24
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r13, r2, r0)
            int r0 = r22.zzc()
            if (r0 != 0) goto L_0x0496
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x04a0
        L_0x0496:
            int r0 = r0 + -1
            com.google.android.gms.internal.measurement.zzap r1 = r9.zze(r0)
            r9.zzp(r0)
            r0 = r1
        L_0x04a0:
            return r0
        L_0x04a1:
            r1 = r21
            r9 = r22
            r3 = r23
            r0 = r24
            r2 = 0
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r4, r0)
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x04d0
            int r1 = r22.zzc()
            if (r1 != 0) goto L_0x04c8
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x04cf
        L_0x04c8:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            r1 = 0
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r9, r3, r0, r1, r1)
        L_0x04cf:
            return r0
        L_0x04d0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x04d6:
            r9 = r22
            r3 = r23
            r0 = r24
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r15, r4, r0)
            com.google.android.gms.internal.measurement.zzap r4 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r5 = r24.isEmpty()
            if (r5 != 0) goto L_0x04f3
            r5 = 0
            java.lang.Object r4 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
        L_0x04f3:
            int r5 = r22.zzc()
            int r5 = r5 + -1
            int r6 = r24.size()
            r7 = 1
            if (r6 <= r7) goto L_0x0537
            java.lang.Object r0 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r3 = r0.zzh()
            double r5 = r3.doubleValue()
            boolean r3 = java.lang.Double.isNaN(r5)
            if (r3 == 0) goto L_0x0520
            int r0 = r22.zzc()
            int r0 = r0 + -1
            double r5 = (double) r0
            goto L_0x052c
        L_0x0520:
            java.lang.Double r0 = r0.zzh()
            double r5 = r0.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
        L_0x052c:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0538
            int r0 = r22.zzc()
            double r7 = (double) r0
            double r5 = r5 + r7
            goto L_0x0538
        L_0x0537:
            double r5 = (double) r5
        L_0x0538:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0546
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r18)
            r0.<init>(r1)
            goto L_0x057a
        L_0x0546:
            int r0 = r22.zzc()
            double r0 = (double) r0
            double r0 = java.lang.Math.min(r0, r5)
            int r0 = (int) r0
        L_0x0550:
            if (r0 < 0) goto L_0x0571
            boolean r1 = r9.zzs(r0)
            if (r1 == 0) goto L_0x056e
            com.google.android.gms.internal.measurement.zzap r1 = r9.zze(r0)
            boolean r1 = com.google.android.gms.internal.measurement.zzh.zzl(r1, r4)
            if (r1 == 0) goto L_0x056e
            double r0 = (double) r0
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r2.<init>(r0)
            r0 = r2
            goto L_0x057a
        L_0x056e:
            int r0 = r0 + -1
            goto L_0x0550
        L_0x0571:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r18)
            r0.<init>(r1)
        L_0x057a:
            return r0
        L_0x057b:
            r9 = r22
            r3 = r23
            r0 = r24
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r12, r1, r0)
            int r1 = r22.zzc()
            if (r1 != 0) goto L_0x058e
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzm
            goto L_0x05bc
        L_0x058e:
            boolean r1 = r24.isEmpty()
            if (r1 != 0) goto L_0x05b0
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r1 != 0) goto L_0x05ad
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzau
            if (r1 == 0) goto L_0x05a8
            goto L_0x05ad
        L_0x05a8:
            java.lang.String r0 = r0.zzi()
            goto L_0x05b2
        L_0x05ad:
            java.lang.String r0 = ""
            goto L_0x05b2
        L_0x05b0:
            java.lang.String r0 = ","
        L_0x05b2:
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r9.zzj(r0)
            r1.<init>(r0)
            r0 = r1
        L_0x05bc:
            return r0
        L_0x05bd:
            r9 = r22
            r3 = r23
            r0 = r24
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r5, r4, r0)
            com.google.android.gms.internal.measurement.zzap r4 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r5 = r24.isEmpty()
            if (r5 != 0) goto L_0x05da
            r5 = 0
            java.lang.Object r4 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
        L_0x05da:
            int r5 = r24.size()
            r6 = 1
            if (r5 <= r6) goto L_0x0617
            java.lang.Object r0 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r5 = r0.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
            int r0 = r22.zzc()
            double r7 = (double) r0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x060a
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r18)
            r0.<init>(r1)
            goto L_0x064d
        L_0x060a:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0616
            int r0 = r22.zzc()
            double r0 = (double) r0
            double r1 = r0 + r5
            goto L_0x0617
        L_0x0616:
            r1 = r5
        L_0x0617:
            java.util.Iterator r0 = r22.zzk()
        L_0x061b:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0644
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            double r5 = (double) r3
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x061b
            com.google.android.gms.internal.measurement.zzap r3 = r9.zze(r3)
            boolean r3 = com.google.android.gms.internal.measurement.zzh.zzl(r3, r4)
            if (r3 == 0) goto L_0x061b
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            r0.<init>(r1)
            goto L_0x064d
        L_0x0644:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r18)
            r0.<init>(r1)
        L_0x064d:
            return r0
        L_0x064e:
            r1 = r21
            r9 = r22
            r0 = r24
            r2 = r3
            r4 = 1
            r3 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r4, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x067c
            int r1 = r22.zzb()
            if (r1 != 0) goto L_0x0673
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x067b
        L_0x0673:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            r1 = 0
            zzb(r9, r3, r0, r1, r1)
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x067b:
            return r0
        L_0x067c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x0682:
            r1 = r21
            r9 = r22
            r3 = r23
            r0 = r24
            r2 = r20
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r4, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x06e2
            int r1 = r22.zzb()
            if (r1 != 0) goto L_0x06ab
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x06e1
        L_0x06ab:
            com.google.android.gms.internal.measurement.zzap r1 = r22.zzd()
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r4 = 0
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r9, r3, r0, r4, r2)
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r2.<init>()
            java.util.Iterator r0 = r0.zzk()
        L_0x06c1:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x06e0
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = r1
            com.google.android.gms.internal.measurement.zzae r4 = (com.google.android.gms.internal.measurement.zzae) r4
            com.google.android.gms.internal.measurement.zzap r3 = r4.zze(r3)
            int r4 = r2.zzc()
            r2.zzq(r4, r3)
            goto L_0x06c1
        L_0x06e0:
            r0 = r2
        L_0x06e1:
            return r0
        L_0x06e2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x06e8:
            r1 = r21
            r2 = r22
            r3 = r23
            r0 = r24
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r9, r4, r0)
            r4 = 0
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r4 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r4 == 0) goto L_0x0726
            int r1 = r22.zzc()
            if (r1 != 0) goto L_0x070c
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x0725
        L_0x070c:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r2, r3, r0, r1, r4)
            int r0 = r0.zzc()
            int r1 = r22.zzc()
            if (r0 == r1) goto L_0x0723
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x0725
        L_0x0723:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
        L_0x0725:
            return r0
        L_0x0726:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L_0x072c:
            r2 = r22
            r3 = r23
            r0 = r24
            com.google.android.gms.internal.measurement.zzap r1 = r22.zzd()
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x078e
            java.util.Iterator r0 = r24.iterator()
        L_0x0740:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x078e
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x0786
            r4 = r1
            com.google.android.gms.internal.measurement.zzae r4 = (com.google.android.gms.internal.measurement.zzae) r4
            int r5 = r4.zzc()
            boolean r6 = r2 instanceof com.google.android.gms.internal.measurement.zzae
            if (r6 == 0) goto L_0x0782
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            java.util.Iterator r6 = r2.zzk()
        L_0x0765:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0740
            java.lang.Object r7 = r6.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r8 = r7.intValue()
            int r8 = r8 + r5
            int r7 = r7.intValue()
            com.google.android.gms.internal.measurement.zzap r7 = r2.zze(r7)
            r4.zzq(r8, r7)
            goto L_0x0765
        L_0x0782:
            r4.zzq(r5, r2)
            goto L_0x0740
        L_0x0786:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x078e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zza(java.lang.String, com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    private static zzae zzb(zzae zzae, zzg zzg, zzai zzai, Boolean bool, Boolean bool2) {
        zzae zzae2 = new zzae();
        Iterator zzk = zzae.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzae.zzs(intValue)) {
                zzap zza = zzai.zza(zzg, Arrays.asList(new zzap[]{zzae.zze(intValue), new zzah(Double.valueOf((double) intValue)), zzae}));
                if (zza.zzg().equals(bool)) {
                    return zzae2;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzae2.zzq(intValue, zza);
                }
            }
        }
        return zzae2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzap zzc(com.google.android.gms.internal.measurement.zzae r9, com.google.android.gms.internal.measurement.zzg r10, java.util.List r11, boolean r12) {
        /*
            java.lang.String r0 = "reduce"
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzi(r0, r1, r11)
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r0, r2, r11)
            r0 = 0
            java.lang.Object r3 = r11.get(r0)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r10.zzb(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzai
            if (r4 == 0) goto L_0x009d
            int r4 = r11.size()
            if (r4 != r2) goto L_0x0036
            java.lang.Object r11 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzap r11 = (com.google.android.gms.internal.measurement.zzap) r11
            com.google.android.gms.internal.measurement.zzap r11 = r10.zzb(r11)
            boolean r4 = r11 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Failed to parse initial value"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            int r11 = r9.zzc()
            if (r11 == 0) goto L_0x0095
            r11 = 0
        L_0x003d:
            com.google.android.gms.internal.measurement.zzai r3 = (com.google.android.gms.internal.measurement.zzai) r3
            int r4 = r9.zzc()
            if (r12 == 0) goto L_0x0047
            r5 = r0
            goto L_0x0049
        L_0x0047:
            int r5 = r4 + -1
        L_0x0049:
            r6 = -1
            if (r12 == 0) goto L_0x004e
            int r4 = r4 + r6
            goto L_0x004f
        L_0x004e:
            r4 = r0
        L_0x004f:
            if (r1 == r12) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r6 = r1
        L_0x0053:
            if (r11 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzap r11 = r9.zze(r5)
        L_0x0059:
            int r5 = r5 + r6
        L_0x005a:
            int r12 = r4 - r5
            int r12 = r12 * r6
            if (r12 < 0) goto L_0x0094
            boolean r12 = r9.zzs(r5)
            if (r12 == 0) goto L_0x0059
            r12 = 4
            com.google.android.gms.internal.measurement.zzap[] r12 = new com.google.android.gms.internal.measurement.zzap[r12]
            r12[r0] = r11
            com.google.android.gms.internal.measurement.zzap r11 = r9.zze(r5)
            r12[r1] = r11
            double r7 = (double) r5
            com.google.android.gms.internal.measurement.zzah r11 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r11.<init>(r7)
            r12[r2] = r11
            r11 = 3
            r12[r11] = r9
            java.util.List r11 = java.util.Arrays.asList(r12)
            com.google.android.gms.internal.measurement.zzap r11 = r3.zza(r10, r11)
            boolean r12 = r11 instanceof com.google.android.gms.internal.measurement.zzag
            if (r12 != 0) goto L_0x008c
            goto L_0x0059
        L_0x008c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Reduce operation failed"
            r9.<init>(r10)
            throw r9
        L_0x0094:
            return r11
        L_0x0095:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Empty array with no initial value error"
            r9.<init>(r10)
            throw r9
        L_0x009d:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Callback should be a method"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zzc(com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List, boolean):com.google.android.gms.internal.measurement.zzap");
    }
}
