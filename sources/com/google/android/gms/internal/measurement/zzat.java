package com.google.android.gms.internal.measurement;

import java.util.Iterator;

public final class zzat implements Iterable, zzap {
    /* access modifiers changed from: private */
    public final String zza;

    public zzat(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        return this.zza.equals(((zzat) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        String str = this.zza;
        return "\"" + str + "\"";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x019b, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x019c, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r5, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01b1, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r5, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01c8, code lost:
        r0 = r21;
        com.google.android.gms.internal.measurement.zzh.zzh(r6, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01d2, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toLowerCase", 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e9, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toLocaleLowerCase", 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01ff, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r14, 0, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0214, code lost:
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("substring", 2, r1);
        r2 = r21.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0223, code lost:
        if (r24.isEmpty() != false) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0225, code lost:
        r3 = r23;
        r4 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x023f, code lost:
        r3 = r23;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0247, code lost:
        if (r24.size() <= 1) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0249, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0261, code lost:
        r1 = r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0265, code lost:
        r4 = java.lang.Math.min(java.lang.Math.max(r4, 0), r2.length());
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r2.length());
        r3 = new com.google.android.gms.internal.measurement.zzat(r2.substring(java.lang.Math.min(r4, r1), java.lang.Math.max(r4, r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0291, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("split", 2, r1);
        r2 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02a1, code lost:
        if (r2.length() != 0) goto L_0x02b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02b4, code lost:
        r5 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02be, code lost:
        if (r24.isEmpty() == false) goto L_0x02c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02c0, code lost:
        r5.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02c5, code lost:
        r4 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02d8, code lost:
        if (r24.size() <= 1) goto L_0x02f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02da, code lost:
        r6 = com.google.android.gms.internal.measurement.zzh.zzd(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02f1, code lost:
        r6 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02f8, code lost:
        if (r6 != 0) goto L_0x0301;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0301, code lost:
        r1 = r2.split(java.util.regex.Pattern.quote(r4), ((int) r6) + 1);
        r2 = r1.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0311, code lost:
        if (r4.isEmpty() == false) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0313, code lost:
        if (r2 <= 0) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0315, code lost:
        r14 = r1[0].isEmpty();
        r3 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0324, code lost:
        if (r1[r3].isEmpty() != false) goto L_0x032a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0326, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0328, code lost:
        r3 = r2;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x032d, code lost:
        if (((long) r2) <= r6) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x032f, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0331, code lost:
        if (r14 >= r3) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0333, code lost:
        r5.add(new com.google.android.gms.internal.measurement.zzat(r1[r14]));
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0347, code lost:
        r3 = r23;
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r1);
        r2 = r21.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0357, code lost:
        if (r24.isEmpty() != false) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0359, code lost:
        r4 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x036d, code lost:
        r4 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x036f, code lost:
        r4 = com.google.android.gms.internal.measurement.zzh.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0377, code lost:
        if (r4 >= 0.0d) goto L_0x0384;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0379, code lost:
        r4 = java.lang.Math.max(((double) r2.length()) + r4, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0384, code lost:
        r4 = java.lang.Math.min(r4, (double) r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0392, code lost:
        if (r24.size() <= 1) goto L_0x03a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0394, code lost:
        r6 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03a7, code lost:
        r6 = (double) r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03ac, code lost:
        r6 = com.google.android.gms.internal.measurement.zzh.zza(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03b4, code lost:
        if (r6 >= 0.0d) goto L_0x03c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03b6, code lost:
        r6 = java.lang.Math.max(((double) r2.length()) + r6, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03c1, code lost:
        r6 = java.lang.Math.min(r6, (double) r2.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03ca, code lost:
        r1 = (int) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03df, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj(com.google.firebase.analytics.FirebaseAnalytics.Event.SEARCH, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03ee, code lost:
        if (r24.isEmpty() != false) goto L_0x03fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03f0, code lost:
        r17 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03fe, code lost:
        r1 = java.util.regex.Pattern.compile(r17).matcher(r0.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x040c, code lost:
        if (r1.find() == false) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x042b, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("replace", 2, r1);
        r2 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x043b, code lost:
        if (r24.isEmpty() != false) goto L_0x045d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x043d, code lost:
        r17 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0451, code lost:
        if (r24.size() <= 1) goto L_0x045d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0453, code lost:
        r2 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x045d, code lost:
        r1 = r17;
        r4 = r0.zza;
        r5 = r4.indexOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0465, code lost:
        if (r5 < 0) goto L_0x0643;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0469, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0490;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x046b, code lost:
        r2 = ((com.google.android.gms.internal.measurement.zzai) r2).zza(r3, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r1), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r5)), r0}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0490, code lost:
        r3 = new com.google.android.gms.internal.measurement.zzat(r4.substring(0, r5) + r2.zzi() + r4.substring(r5 + r1.length()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04bc, code lost:
        r3 = r23;
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("match", 1, r1);
        r2 = r21.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04cc, code lost:
        if (r24.size() > 0) goto L_0x04d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x04ce, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x04d1, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x04e0, code lost:
        r1 = java.util.regex.Pattern.compile(r1).matcher(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04ec, code lost:
        if (r1.find() == false) goto L_0x0508;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x050c, code lost:
        r3 = r23;
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("lastIndexOf", 2, r1);
        r4 = r21.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x051d, code lost:
        if (r24.size() > 0) goto L_0x0520;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0520, code lost:
        r17 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x052e, code lost:
        r5 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0534, code lost:
        if (r24.size() >= 2) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0536, code lost:
        r1 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0539, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0550, code lost:
        if (java.lang.Double.isNaN(r1) == false) goto L_0x0555;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0552, code lost:
        r1 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0555, code lost:
        r1 = com.google.android.gms.internal.measurement.zzh.zza(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x056a, code lost:
        r3 = r23;
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj("indexOf", 2, r1);
        r4 = r21.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x057c, code lost:
        if (r24.size() > 0) goto L_0x057f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x057f, code lost:
        r17 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x058e, code lost:
        r5 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0594, code lost:
        if (r24.size() >= 2) goto L_0x0598;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0596, code lost:
        r1 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0598, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x05c0, code lost:
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh(r20, 1, r1);
        r2 = r21.zza;
        r1 = r23.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x05e3, code lost:
        if ("length".equals(r1.zzi()) == false) goto L_0x05e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x05e9, code lost:
        r3 = r1.zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x05f7, code lost:
        if (r3 != java.lang.Math.floor(r3)) goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x05f9, code lost:
        r1 = (int) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x05fa, code lost:
        if (r1 < 0) goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0600, code lost:
        if (r1 >= r2.length()) goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x060a, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0614, code lost:
        if (r24.isEmpty() != false) goto L_0x0643;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0616, code lost:
        r2 = new java.lang.StringBuilder(r0.zza);
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0622, code lost:
        if (r14 >= r24.size()) goto L_0x0638;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0624, code lost:
        r2.append(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(r14)).zzi());
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0645, code lost:
        r0 = r21;
        r3 = r23;
        r1 = r24;
        com.google.android.gms.internal.measurement.zzh.zzj(r19, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0655, code lost:
        if (r24.isEmpty() != false) goto L_0x0670;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0657, code lost:
        r14 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r1.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0670, code lost:
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0672, code lost:
        r1 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0674, code lost:
        if (r14 < 0) goto L_0x068b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x067a, code lost:
        if (r14 < r1.length()) goto L_0x067d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r21.zza.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r21.zza.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r21.zza.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r21.zza.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r21.zza.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r0}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r2.substring(r1, java.lang.Math.max(0, ((int) r6) - r1) + r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r1.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r1.group())}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r4.lastIndexOf(r5, (int) r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r4.indexOf(r5, (int) com.google.android.gms.internal.measurement.zzh.zza(r1))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(java.lang.String.valueOf(r1.charAt(r14)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c7, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c9, code lost:
        r3 = r17;
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0139, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0162, code lost:
        r3 = r17;
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0187, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0188, code lost:
        r17 = "undefined";
        r20 = r3;
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x018f, code lost:
        switch(r1) {
            case 0: goto L_0x0645;
            case 1: goto L_0x060a;
            case 2: goto L_0x05c0;
            case 3: goto L_0x056a;
            case 4: goto L_0x050c;
            case 5: goto L_0x04bc;
            case 6: goto L_0x042b;
            case 7: goto L_0x03df;
            case 8: goto L_0x0347;
            case 9: goto L_0x0291;
            case 10: goto L_0x0214;
            case 11: goto L_0x01ff;
            case 12: goto L_0x01e9;
            case 13: goto L_0x01d2;
            case 14: goto L_0x01c8;
            case 15: goto L_0x01b1;
            case 16: goto L_0x019c;
            default: goto L_0x0192;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0192, code lost:
        r0 = r21;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0179  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zzbU(java.lang.String r22, com.google.android.gms.internal.measurement.zzg r23, java.util.List r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            java.lang.String r4 = "charAt"
            boolean r5 = r4.equals(r1)
            java.lang.String r6 = "concat"
            java.lang.String r7 = "indexOf"
            java.lang.String r8 = "replace"
            java.lang.String r9 = "substring"
            java.lang.String r10 = "split"
            java.lang.String r11 = "slice"
            java.lang.String r12 = "match"
            java.lang.String r13 = "lastIndexOf"
            java.lang.String r14 = "toLocaleUpperCase"
            java.lang.String r15 = "search"
            java.lang.String r2 = "toLowerCase"
            java.lang.String r0 = "toLocaleLowerCase"
            java.lang.String r3 = "toString"
            r16 = r4
            java.lang.String r4 = "hasOwnProperty"
            r17 = r14
            java.lang.String r14 = "toUpperCase"
            r18 = r14
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r6.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r4.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r7.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r13.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r12.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r8.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r15.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r11.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r10.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r9.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r2.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r0.equals(r1)
            if (r5 != 0) goto L_0x00b8
            boolean r5 = r3.equals(r1)
            if (r5 != 0) goto L_0x00b8
            r5 = r18
            boolean r18 = r5.equals(r1)
            r14 = r17
            if (r18 != 0) goto L_0x00bc
            boolean r17 = r14.equals(r1)
            if (r17 != 0) goto L_0x00bc
            r17 = r4
            java.lang.String r4 = "trim"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x00a6
            goto L_0x00be
        L_0x00a6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            java.lang.String r1 = "%s is not a String function"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x00b8:
            r14 = r17
            r5 = r18
        L_0x00bc:
            r17 = r4
        L_0x00be:
            int r4 = r22.hashCode()
            r19 = r3
            switch(r4) {
                case -1789698943: goto L_0x0179;
                case -1776922004: goto L_0x0167;
                case -1464939364: goto L_0x0158;
                case -1361633751: goto L_0x014a;
                case -1354795244: goto L_0x013c;
                case -1137582698: goto L_0x0131;
                case -906336856: goto L_0x0129;
                case -726908483: goto L_0x0120;
                case -467511597: goto L_0x0118;
                case -399551817: goto L_0x010f;
                case 3568674: goto L_0x0103;
                case 103668165: goto L_0x00fb;
                case 109526418: goto L_0x00f2;
                case 109648666: goto L_0x00e9;
                case 530542161: goto L_0x00e0;
                case 1094496948: goto L_0x00d8;
                case 1943291465: goto L_0x00cf;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            r4 = r16
        L_0x00c9:
            r3 = r17
            r6 = r19
            goto L_0x0187
        L_0x00cf:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00c7
            r1 = 3
            goto L_0x0139
        L_0x00d8:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00c7
            r1 = 6
            goto L_0x0139
        L_0x00e0:
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00c7
            r1 = 10
            goto L_0x0139
        L_0x00e9:
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00c7
            r1 = 9
            goto L_0x0139
        L_0x00f2:
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x00c7
            r1 = 8
            goto L_0x0139
        L_0x00fb:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x00c7
            r1 = 5
            goto L_0x0139
        L_0x0103:
            java.lang.String r4 = "trim"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00c7
            r1 = 16
            goto L_0x0139
        L_0x010f:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00c7
            r1 = 15
            goto L_0x0139
        L_0x0118:
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00c7
            r1 = 4
            goto L_0x0139
        L_0x0120:
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x00c7
            r1 = 11
            goto L_0x0139
        L_0x0129:
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00c7
            r1 = 7
            goto L_0x0139
        L_0x0131:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00c7
            r1 = 13
        L_0x0139:
            r4 = r16
            goto L_0x0162
        L_0x013c:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00c7
            r4 = r16
            r3 = r17
            r6 = r19
            r1 = 1
            goto L_0x0188
        L_0x014a:
            r4 = r16
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00c9
            r3 = r17
            r6 = r19
            r1 = 0
            goto L_0x0188
        L_0x0158:
            r4 = r16
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00c9
            r1 = 12
        L_0x0162:
            r3 = r17
            r6 = r19
            goto L_0x0188
        L_0x0167:
            r4 = r16
            r6 = r19
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0176
            r1 = 14
            r3 = r17
            goto L_0x0188
        L_0x0176:
            r3 = r17
            goto L_0x0187
        L_0x0179:
            r4 = r16
            r3 = r17
            r6 = r19
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0187
            r1 = 2
            goto L_0x0188
        L_0x0187:
            r1 = -1
        L_0x0188:
            java.lang.String r17 = "undefined"
            r20 = r3
            r19 = r4
            switch(r1) {
                case 0: goto L_0x0645;
                case 1: goto L_0x060a;
                case 2: goto L_0x05c0;
                case 3: goto L_0x056a;
                case 4: goto L_0x050c;
                case 5: goto L_0x04bc;
                case 6: goto L_0x042b;
                case 7: goto L_0x03df;
                case 8: goto L_0x0347;
                case 9: goto L_0x0291;
                case 10: goto L_0x0214;
                case 11: goto L_0x01ff;
                case 12: goto L_0x01e9;
                case 13: goto L_0x01d2;
                case 14: goto L_0x01c8;
                case 15: goto L_0x01b1;
                case 16: goto L_0x019c;
                default: goto L_0x0192;
            }
        L_0x0192:
            r0 = r21
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Command not supported"
            r1.<init>(r2)
            throw r1
        L_0x019c:
            r1 = r24
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r5, r3, r1)
            r0 = r21
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r1.trim()
            r2.<init>(r1)
            goto L_0x068d
        L_0x01b1:
            r3 = 0
            r0 = r21
            r1 = r24
            com.google.android.gms.internal.measurement.zzh.zzh(r5, r3, r1)
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r3)
            r2.<init>(r1)
            goto L_0x068d
        L_0x01c8:
            r3 = 0
            r0 = r21
            r1 = r24
            com.google.android.gms.internal.measurement.zzh.zzh(r6, r3, r1)
            goto L_0x0643
        L_0x01d2:
            r3 = 0
            r0 = r21
            r1 = r24
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r3, r1)
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toLowerCase(r3)
            r2.<init>(r1)
            goto L_0x068d
        L_0x01e9:
            r3 = 0
            r1 = r24
            r2 = r0
            r0 = r21
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r3, r1)
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r1.toLowerCase()
            r2.<init>(r1)
            goto L_0x068d
        L_0x01ff:
            r3 = 0
            r0 = r21
            r1 = r24
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r3, r1)
            java.lang.String r1 = r0.zza
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r1.toUpperCase()
            r2.<init>(r1)
            goto L_0x068d
        L_0x0214:
            r0 = r21
            r1 = r24
            r2 = 2
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r9, r2, r1)
            java.lang.String r2 = r0.zza
            boolean r4 = r24.isEmpty()
            if (r4 != 0) goto L_0x023f
            java.lang.Object r4 = r1.get(r3)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            r3 = r23
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
            java.lang.Double r4 = r4.zzh()
            double r4 = r4.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            int r4 = (int) r4
            goto L_0x0242
        L_0x023f:
            r3 = r23
            r4 = 0
        L_0x0242:
            int r5 = r24.size()
            r6 = 1
            if (r5 <= r6) goto L_0x0261
            java.lang.Object r1 = r1.get(r6)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r5 = r1.doubleValue()
            double r5 = com.google.android.gms.internal.measurement.zzh.zza(r5)
            int r1 = (int) r5
            goto L_0x0265
        L_0x0261:
            int r1 = r2.length()
        L_0x0265:
            r3 = 0
            int r4 = java.lang.Math.max(r4, r3)
            int r5 = r2.length()
            int r4 = java.lang.Math.min(r4, r5)
            int r1 = java.lang.Math.max(r1, r3)
            int r3 = r2.length()
            int r1 = java.lang.Math.min(r1, r3)
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            int r5 = java.lang.Math.min(r4, r1)
            int r1 = java.lang.Math.max(r4, r1)
            java.lang.String r1 = r2.substring(r5, r1)
            r3.<init>(r1)
            goto L_0x04b9
        L_0x0291:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r2, r1)
            java.lang.String r2 = r0.zza
            int r4 = r2.length()
            if (r4 != 0) goto L_0x02b4
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r1 = 1
            com.google.android.gms.internal.measurement.zzap[] r1 = new com.google.android.gms.internal.measurement.zzap[r1]
            r4 = 0
            r1[r4] = r0
            java.util.List r1 = java.util.Arrays.asList(r1)
            r2.<init>(r1)
            goto L_0x068d
        L_0x02b4:
            r4 = 0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r6 = r24.isEmpty()
            if (r6 == 0) goto L_0x02c5
            r5.add(r0)
            goto L_0x0340
        L_0x02c5:
            java.lang.Object r6 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r6 = (com.google.android.gms.internal.measurement.zzap) r6
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r6)
            java.lang.String r4 = r4.zzi()
            int r6 = r24.size()
            r7 = 1
            if (r6 <= r7) goto L_0x02f1
            java.lang.Object r1 = r1.get(r7)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r6 = r1.doubleValue()
            long r6 = com.google.android.gms.internal.measurement.zzh.zzd(r6)
            goto L_0x02f4
        L_0x02f1:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x02f4:
            r8 = 0
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x0301
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r2.<init>()
            goto L_0x068d
        L_0x0301:
            java.lang.String r1 = java.util.regex.Pattern.quote(r4)
            int r3 = (int) r6
            r8 = 1
            int r3 = r3 + r8
            java.lang.String[] r1 = r2.split(r1, r3)
            int r2 = r1.length
            boolean r3 = r4.isEmpty()
            if (r3 == 0) goto L_0x0328
            if (r2 <= 0) goto L_0x0328
            r3 = 0
            r3 = r1[r3]
            boolean r14 = r3.isEmpty()
            int r3 = r2 + -1
            r4 = r1[r3]
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x032a
            r3 = r2
            goto L_0x032a
        L_0x0328:
            r3 = r2
            r14 = 0
        L_0x032a:
            long r8 = (long) r2
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x0331
            int r3 = r3 + -1
        L_0x0331:
            if (r14 >= r3) goto L_0x0340
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            r4 = r1[r14]
            r2.<init>(r4)
            r5.add(r2)
            int r14 = r14 + 1
            goto L_0x0331
        L_0x0340:
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r2.<init>(r5)
            goto L_0x068d
        L_0x0347:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r11, r2, r1)
            java.lang.String r2 = r0.zza
            boolean r4 = r24.isEmpty()
            if (r4 != 0) goto L_0x036d
            r4 = 0
            java.lang.Object r5 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r5)
            java.lang.Double r4 = r4.zzh()
            double r4 = r4.doubleValue()
            goto L_0x036f
        L_0x036d:
            r4 = 0
        L_0x036f:
            double r4 = com.google.android.gms.internal.measurement.zzh.zza(r4)
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0384
            int r8 = r2.length()
            double r8 = (double) r8
            double r8 = r8 + r4
            double r4 = java.lang.Math.max(r8, r6)
            goto L_0x038d
        L_0x0384:
            int r6 = r2.length()
            double r6 = (double) r6
            double r4 = java.lang.Math.min(r4, r6)
        L_0x038d:
            int r6 = r24.size()
            r7 = 1
            if (r6 <= r7) goto L_0x03a7
            java.lang.Object r1 = r1.get(r7)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r6 = r1.doubleValue()
            goto L_0x03ac
        L_0x03a7:
            int r1 = r2.length()
            double r6 = (double) r1
        L_0x03ac:
            double r6 = com.google.android.gms.internal.measurement.zzh.zza(r6)
            r8 = 0
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x03c1
            int r1 = r2.length()
            double r10 = (double) r1
            double r10 = r10 + r6
            double r6 = java.lang.Math.max(r10, r8)
            goto L_0x03ca
        L_0x03c1:
            int r1 = r2.length()
            double r8 = (double) r1
            double r6 = java.lang.Math.min(r6, r8)
        L_0x03ca:
            int r1 = (int) r4
            int r3 = (int) r6
            int r3 = r3 - r1
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
            int r3 = r3 + r1
            com.google.android.gms.internal.measurement.zzat r4 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r2.substring(r1, r3)
            r4.<init>(r1)
            r2 = r4
            goto L_0x068d
        L_0x03df:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 1
            r4 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r15, r2, r1)
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x03fe
            java.lang.Object r1 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.String r17 = r1.zzi()
        L_0x03fe:
            java.lang.String r1 = r0.zza
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r17)
            java.util.regex.Matcher r1 = r2.matcher(r1)
            boolean r2 = r1.find()
            if (r2 == 0) goto L_0x041e
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r1.start()
            double r3 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            goto L_0x068d
        L_0x041e:
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            r3 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            goto L_0x068d
        L_0x042b:
            r2 = 2
            r0 = r21
            r3 = r23
            r1 = r24
            com.google.android.gms.internal.measurement.zzh.zzj(r8, r2, r1)
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r4 = r24.isEmpty()
            if (r4 != 0) goto L_0x045d
            r4 = 0
            java.lang.Object r5 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r5)
            java.lang.String r17 = r4.zzi()
            int r4 = r24.size()
            r5 = 1
            if (r4 <= r5) goto L_0x045d
            java.lang.Object r1 = r1.get(r5)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r1)
        L_0x045d:
            r1 = r17
            java.lang.String r4 = r0.zza
            int r5 = r4.indexOf(r1)
            if (r5 < 0) goto L_0x0643
            boolean r6 = r2 instanceof com.google.android.gms.internal.measurement.zzai
            if (r6 == 0) goto L_0x0490
            com.google.android.gms.internal.measurement.zzai r2 = (com.google.android.gms.internal.measurement.zzai) r2
            r6 = 3
            com.google.android.gms.internal.measurement.zzap[] r6 = new com.google.android.gms.internal.measurement.zzap[r6]
            com.google.android.gms.internal.measurement.zzat r7 = new com.google.android.gms.internal.measurement.zzat
            r7.<init>(r1)
            r8 = 0
            r6[r8] = r7
            double r7 = (double) r5
            com.google.android.gms.internal.measurement.zzah r9 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r9.<init>(r7)
            r7 = 1
            r6[r7] = r9
            r7 = 2
            r6[r7] = r0
            java.util.List r6 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.zzap r2 = r2.zza(r3, r6)
        L_0x0490:
            com.google.android.gms.internal.measurement.zzat r3 = new com.google.android.gms.internal.measurement.zzat
            r6 = 0
            java.lang.String r6 = r4.substring(r6, r5)
            java.lang.String r2 = r2.zzi()
            int r1 = r1.length()
            int r5 = r5 + r1
            java.lang.String r1 = r4.substring(r5)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
        L_0x04b9:
            r2 = r3
            goto L_0x068d
        L_0x04bc:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r12, r2, r1)
            java.lang.String r2 = r0.zza
            int r4 = r24.size()
            if (r4 > 0) goto L_0x04d1
            java.lang.String r1 = ""
            goto L_0x04e0
        L_0x04d1:
            r4 = 0
            java.lang.Object r1 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.String r1 = r1.zzi()
        L_0x04e0:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r1 = r1.matcher(r2)
            boolean r2 = r1.find()
            if (r2 == 0) goto L_0x0508
            com.google.android.gms.internal.measurement.zzae r2 = new com.google.android.gms.internal.measurement.zzae
            r3 = 1
            com.google.android.gms.internal.measurement.zzap[] r3 = new com.google.android.gms.internal.measurement.zzap[r3]
            com.google.android.gms.internal.measurement.zzat r4 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r1.group()
            r4.<init>(r1)
            r5 = 0
            r3[r5] = r4
            java.util.List r1 = java.util.Arrays.asList(r3)
            r2.<init>(r1)
            goto L_0x068d
        L_0x0508:
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzg
            goto L_0x068d
        L_0x050c:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 2
            r5 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r13, r2, r1)
            java.lang.String r4 = r0.zza
            int r6 = r24.size()
            if (r6 > 0) goto L_0x0520
            goto L_0x052e
        L_0x0520:
            java.lang.Object r5 = r1.get(r5)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r5 = r3.zzb(r5)
            java.lang.String r17 = r5.zzi()
        L_0x052e:
            r5 = r17
            int r6 = r24.size()
            if (r6 >= r2) goto L_0x0539
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x054c
        L_0x0539:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
        L_0x054c:
            boolean r3 = java.lang.Double.isNaN(r1)
            if (r3 == 0) goto L_0x0555
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x0559
        L_0x0555:
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r1)
        L_0x0559:
            int r1 = (int) r1
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r4.lastIndexOf(r5, r1)
            double r3 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            goto L_0x068d
        L_0x056a:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = 2
            r8 = 0
            com.google.android.gms.internal.measurement.zzh.zzj(r7, r2, r1)
            java.lang.String r4 = r0.zza
            int r5 = r24.size()
            if (r5 > 0) goto L_0x057f
            goto L_0x058e
        L_0x057f:
            r5 = 0
            java.lang.Object r5 = r1.get(r5)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r5 = r3.zzb(r5)
            java.lang.String r17 = r5.zzi()
        L_0x058e:
            r5 = r17
            int r6 = r24.size()
            if (r6 >= r2) goto L_0x0598
            r1 = r8
            goto L_0x05ab
        L_0x0598:
            r2 = 1
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
        L_0x05ab:
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r1)
            int r1 = (int) r1
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r4.indexOf(r5, r1)
            double r3 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            goto L_0x068d
        L_0x05c0:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = r20
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r2, r4, r1)
            java.lang.String r2 = r0.zza
            r4 = 0
            java.lang.Object r1 = r1.get(r4)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.String r3 = r1.zzi()
            java.lang.String r4 = "length"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x05e9
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x068d
        L_0x05e9:
            java.lang.Double r1 = r1.zzh()
            double r3 = r1.doubleValue()
            double r5 = java.lang.Math.floor(r3)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0606
            int r1 = (int) r3
            if (r1 < 0) goto L_0x0606
            int r2 = r2.length()
            if (r1 >= r2) goto L_0x0606
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x068d
        L_0x0606:
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x068d
        L_0x060a:
            r0 = r21
            r3 = r23
            r1 = r24
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x0643
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = r0.zza
            r2.<init>(r4)
            r14 = 0
        L_0x061e:
            int r4 = r24.size()
            if (r14 >= r4) goto L_0x0638
            java.lang.Object r4 = r1.get(r14)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
            java.lang.String r4 = r4.zzi()
            r2.append(r4)
            int r14 = r14 + 1
            goto L_0x061e
        L_0x0638:
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = r1
            goto L_0x068d
        L_0x0643:
            r2 = r0
            goto L_0x068d
        L_0x0645:
            r0 = r21
            r3 = r23
            r1 = r24
            r2 = r19
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r2, r4, r1)
            boolean r2 = r24.isEmpty()
            if (r2 != 0) goto L_0x0670
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.zzh.zza(r1)
            int r14 = (int) r1
            goto L_0x0672
        L_0x0670:
            r2 = 0
            r14 = r2
        L_0x0672:
            java.lang.String r1 = r0.zza
            if (r14 < 0) goto L_0x068b
            int r2 = r1.length()
            if (r14 < r2) goto L_0x067d
            goto L_0x068b
        L_0x067d:
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            char r1 = r1.charAt(r14)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2.<init>(r1)
            goto L_0x068d
        L_0x068b:
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzm
        L_0x068d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzat.zzbU(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    public final zzap zzd() {
        return new zzat(this.zza);
    }

    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String zzi() {
        return this.zza;
    }

    public final Iterator zzl() {
        return new zzar(this);
    }
}
