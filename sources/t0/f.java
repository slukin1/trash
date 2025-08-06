package t0;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class f {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f16517a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f16518b;
    }

    public static void a(ArrayList<b> arrayList, char c11, float[] fArr) {
        arrayList.add(new b(c11, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            if (bVarArr[i11].f16519a != bVarArr2[i11].f16519a || bVarArr[i11].f16520b.length != bVarArr2[i11].f16520b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] c(float[] fArr, int i11, int i12) {
        if (i11 <= i12) {
            int length = fArr.length;
            if (i11 < 0 || i11 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i13 = i12 - i11;
            int min = Math.min(i13, length - i11);
            float[] fArr2 = new float[i13];
            System.arraycopy(fArr, i11, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 1;
        int i12 = 0;
        while (i11 < str.length()) {
            int i13 = i(str, i11);
            String trim = str.substring(i12, i13).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i12 = i13;
            i11 = i13 + 1;
        }
        if (i11 - i12 == 1 && i12 < str.length()) {
            a(arrayList, str.charAt(i12), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] d11 = d(str);
        if (d11 == null) {
            return null;
        }
        try {
            b.e(d11, path);
            return path;
        } catch (RuntimeException e11) {
            throw new RuntimeException("Error in parsing " + str, e11);
        }
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            bVarArr2[i11] = new b(bVarArr[i11]);
        }
        return bVarArr2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[LOOP:0: B:1:0x0007->B:20:0x003a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.lang.String r8, int r9, t0.f.a r10) {
        /*
            r0 = 0
            r10.f16518b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0035
            r6 = 69
            if (r5 == r6) goto L_0x0033
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0033
            switch(r5) {
                case 44: goto L_0x0035;
                case 45: goto L_0x002a;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0031
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = r0
            r3 = r7
            goto L_0x0037
        L_0x0027:
            r10.f16518b = r7
            goto L_0x0035
        L_0x002a:
            if (r1 == r9) goto L_0x0031
            if (r2 != 0) goto L_0x0031
            r10.f16518b = r7
            goto L_0x0035
        L_0x0031:
            r2 = r0
            goto L_0x0037
        L_0x0033:
            r2 = r7
            goto L_0x0037
        L_0x0035:
            r2 = r0
            r4 = r7
        L_0x0037:
            if (r4 == 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003d:
            r10.f16517a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.f.g(java.lang.String, int, t0.f$a):void");
    }

    public static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i11 = 1;
            int i12 = 0;
            while (i11 < length) {
                g(str, i11, aVar);
                int i13 = aVar.f16517a;
                if (i11 < i13) {
                    fArr[i12] = Float.parseFloat(str.substring(i11, i13));
                    i12++;
                }
                i11 = aVar.f16518b ? i13 : i13 + 1;
            }
            return c(fArr, 0, i12);
        } catch (NumberFormatException e11) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e11);
        }
    }

    public static int i(String str, int i11) {
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i11;
            }
            i11++;
        }
        return i11;
    }

    public static void j(b[] bVarArr, b[] bVarArr2) {
        for (int i11 = 0; i11 < bVarArr2.length; i11++) {
            bVarArr[i11].f16519a = bVarArr2[i11].f16519a;
            for (int i12 = 0; i12 < bVarArr2[i11].f16520b.length; i12++) {
                bVarArr[i11].f16520b[i12] = bVarArr2[i11].f16520b[i12];
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public char f16519a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f16520b;

        public b(char c11, float[] fArr) {
            this.f16519a = c11;
            this.f16520b = fArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x023b, code lost:
            if (r12[r7 + 4] == 0.0f) goto L_0x0240;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x023d, code lost:
            r23 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0240, code lost:
            r23 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0242, code lost:
            r24 = r7;
            c(r25, r9, r8, r3, r4, r5, r6, r15, r22, r23);
            r9 = r9 + r12[r13];
            r8 = r8 + r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x025c, code lost:
            r24 = r7;
            r7 = r24 + 0;
            r10.lineTo(r9, r12[r7]);
            r8 = r12[r7];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x026a, code lost:
            r24 = r7;
            r7 = r24 + 0;
            r1 = r24 + 1;
            r3 = r24 + 2;
            r5 = r24 + 3;
            r10.quadTo(r12[r7], r12[r1], r12[r3], r12[r5]);
            r0 = r12[r7];
            r1 = r12[r1];
            r9 = r12[r3];
            r8 = r12[r5];
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x028b, code lost:
            r24 = r7;
            r7 = r24 + 0;
            r10.lineTo(r12[r7], r8);
            r9 = r12[r7];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0299, code lost:
            r24 = r7;
            r7 = r24 + 2;
            r8 = r24 + 3;
            r9 = r24 + 4;
            r11 = r24 + 5;
            r25.cubicTo(r12[r24 + 0], r12[r24 + 1], r12[r7], r12[r8], r12[r9], r12[r11]);
            r9 = r12[r9];
            r0 = r12[r11];
            r1 = r12[r7];
            r2 = r12[r8];
            r8 = r0;
            r3 = r2;
            r2 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x02c4, code lost:
            r24 = r7;
            r15 = r8;
            r11 = r9;
            r13 = r24 + 5;
            r3 = r12[r13];
            r14 = r24 + 6;
            r4 = r12[r14];
            r5 = r12[r24 + 0];
            r6 = r12[r24 + 1];
            r7 = r12[r24 + 2];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x02e3, code lost:
            if (r12[r24 + 3] == 0.0f) goto L_0x02e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x02e5, code lost:
            r8 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x02e7, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x02ee, code lost:
            if (r12[r24 + 4] == 0.0f) goto L_0x02f2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x02f0, code lost:
            r9 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x02f2, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x02f3, code lost:
            c(r25, r11, r15, r3, r4, r5, r6, r7, r8, r9);
            r9 = r12[r13];
            r8 = r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x02fe, code lost:
            r3 = r8;
            r2 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0300, code lost:
            r7 = r24 + r19;
            r0 = r28;
            r11 = r0;
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x030a, code lost:
            r26[r13] = r9;
            r26[1] = r8;
            r26[2] = r2;
            r26[3] = r3;
            r26[4] = r20;
            r26[5] = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
            if (r7 >= r12.length) goto L_0x030a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x031b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            if (r11 == 'A') goto L_0x02c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
            if (r11 == 'C') goto L_0x0299;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
            if (r11 == 'H') goto L_0x028b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
            if (r11 == 'Q') goto L_0x026a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
            if (r11 == 'V') goto L_0x025c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
            if (r11 == 'a') goto L_0x020f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
            if (r11 == 'c') goto L_0x01e2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
            if (r11 == 'h') goto L_0x01d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
            if (r11 == 'q') goto L_0x01b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x001e, code lost:
            r19 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
            if (r11 == 'v') goto L_0x01aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
            if (r11 == 'L') goto L_0x0199;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0071, code lost:
            if (r11 == 'M') goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0079, code lost:
            if (r11 == 'S') goto L_0x0144;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
            if (r11 == 'T') goto L_0x011f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0083, code lost:
            if (r11 == 'l') goto L_0x010c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0087, code lost:
            if (r11 == 'm') goto L_0x00ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0089, code lost:
            if (r11 == 's') goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008b, code lost:
            if (r11 == 't') goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x008d, code lost:
            r24 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
            if (r0 == 'q') goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0093, code lost:
            if (r0 == 't') goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0095, code lost:
            if (r0 == 'Q') goto L_0x009d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0097, code lost:
            if (r0 != 'T') goto L_0x009a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x009a, code lost:
            r0 = 0.0f;
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x009d, code lost:
            r4 = r9 - r2;
            r0 = r8 - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a1, code lost:
            r1 = r7 + 0;
            r3 = r7 + 1;
            r10.rQuadTo(r4, r0, r12[r1], r12[r3]);
            r4 = r4 + r9;
            r0 = r0 + r8;
            r9 = r9 + r12[r1];
            r8 = r8 + r12[r3];
            r3 = r0;
            r2 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b7, code lost:
            if (r0 == 'c') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b9, code lost:
            if (r0 == 's') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bd, code lost:
            if (r0 == 'C') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c1, code lost:
            if (r0 != 'S') goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c4, code lost:
            r1 = 0.0f;
            r2 = 0.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c7, code lost:
            r0 = r9 - r2;
            r2 = r8 - r3;
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00cd, code lost:
            r13 = r7 + 0;
            r14 = r7 + 1;
            r15 = r7 + 2;
            r22 = r7 + 3;
            r25.rCubicTo(r1, r2, r12[r13], r12[r14], r12[r15], r12[r22]);
            r0 = r12[r13] + r9;
            r1 = r12[r14] + r8;
            r9 = r9 + r12[r15];
            r2 = r12[r22];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ef, code lost:
            r0 = r7 + 0;
            r9 = r9 + r12[r0];
            r1 = r7 + 1;
            r8 = r8 + r12[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f9, code lost:
            if (r7 <= 0) goto L_0x0103;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fb, code lost:
            r10.rLineTo(r12[r0], r12[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0103, code lost:
            r10.rMoveTo(r12[r0], r12[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x010c, code lost:
            r0 = r7 + 0;
            r4 = r7 + 1;
            r10.rLineTo(r12[r0], r12[r4]);
            r9 = r9 + r12[r0];
            r0 = r12[r4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x011c, code lost:
            r8 = r8 + r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x011f, code lost:
            if (r0 == 'q') goto L_0x0127;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0121, code lost:
            if (r0 == 't') goto L_0x0127;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0123, code lost:
            if (r0 == 'Q') goto L_0x0127;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0125, code lost:
            if (r0 != 'T') goto L_0x012d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0127, code lost:
            r9 = (r9 * 2.0f) - r2;
            r8 = (r8 * 2.0f) - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x012d, code lost:
            r0 = r7 + 0;
            r2 = r7 + 1;
            r10.quadTo(r9, r8, r12[r0], r12[r2]);
            r0 = r12[r0];
            r1 = r12[r2];
            r24 = r7;
            r3 = r8;
            r2 = r9;
            r9 = r0;
            r8 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0144, code lost:
            if (r0 == 'c') goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0146, code lost:
            if (r0 == 's') goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x014a, code lost:
            if (r0 == 'C') goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x014e, code lost:
            if (r0 != 'S') goto L_0x0156;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0150, code lost:
            r9 = (r9 * 2.0f) - r2;
            r8 = (r8 * 2.0f) - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x0156, code lost:
            r2 = r8;
            r8 = r7 + 0;
            r9 = r7 + 1;
            r13 = r7 + 2;
            r14 = r7 + 3;
            r25.cubicTo(r9, r2, r12[r8], r12[r9], r12[r13], r12[r14]);
            r0 = r12[r8];
            r1 = r12[r9];
            r9 = r12[r13];
            r8 = r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0177, code lost:
            r0 = r7 + 0;
            r9 = r12[r0];
            r1 = r7 + 1;
            r8 = r12[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x017f, code lost:
            if (r7 <= 0) goto L_0x018a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0181, code lost:
            r10.lineTo(r12[r0], r12[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x018a, code lost:
            r10.moveTo(r12[r0], r12[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0191, code lost:
            r24 = r7;
            r21 = r8;
            r20 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0199, code lost:
            r0 = r7 + 0;
            r4 = r7 + 1;
            r10.lineTo(r12[r0], r12[r4]);
            r9 = r12[r0];
            r8 = r12[r4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x01aa, code lost:
            r0 = r7 + 0;
            r10.rLineTo(0.0f, r12[r0]);
            r0 = r12[r0];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            r19 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b6, code lost:
            r0 = r7 + 0;
            r2 = r7 + 1;
            r4 = r7 + 2;
            r6 = r7 + 3;
            r10.rQuadTo(r12[r0], r12[r2], r12[r4], r12[r6]);
            r0 = r12[r0] + r9;
            r1 = r12[r2] + r8;
            r9 = r9 + r12[r4];
            r2 = r12[r6];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d5, code lost:
            r0 = r7 + 0;
            r10.rLineTo(r12[r0], 0.0f);
            r9 = r9 + r12[r0];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x01e2, code lost:
            r13 = r7 + 2;
            r14 = r7 + 3;
            r15 = r7 + 4;
            r22 = r7 + 5;
            r25.rCubicTo(r12[r7 + 0], r12[r7 + 1], r12[r13], r12[r14], r12[r15], r12[r22]);
            r0 = r12[r13] + r9;
            r1 = r12[r14] + r8;
            r9 = r9 + r12[r15];
            r2 = r12[r22];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x020a, code lost:
            r8 = r8 + r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x020b, code lost:
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x020f, code lost:
            r13 = r7 + 5;
            r3 = r12[r13] + r9;
            r14 = r7 + 6;
            r4 = r12[r14] + r8;
            r5 = r12[r7 + 0];
            r6 = r12[r7 + 1];
            r15 = r12[r7 + 2];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x022e, code lost:
            if (r12[r7 + 3] == 0.0f) goto L_0x0233;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0230, code lost:
            r22 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0233, code lost:
            r22 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
            r9 = r0;
            r8 = r1;
            r20 = r4;
            r21 = r5;
            r7 = 0;
            r0 = r27;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(android.graphics.Path r25, float[] r26, char r27, char r28, float[] r29) {
            /*
                r10 = r25
                r11 = r28
                r12 = r29
                r13 = 0
                r0 = r26[r13]
                r14 = 1
                r1 = r26[r14]
                r15 = 2
                r2 = r26[r15]
                r16 = 3
                r3 = r26[r16]
                r17 = 4
                r4 = r26[r17]
                r18 = 5
                r5 = r26[r18]
                switch(r11) {
                    case 65: goto L_0x0034;
                    case 67: goto L_0x0032;
                    case 72: goto L_0x002f;
                    case 76: goto L_0x001e;
                    case 77: goto L_0x001e;
                    case 81: goto L_0x002c;
                    case 83: goto L_0x002c;
                    case 84: goto L_0x001e;
                    case 86: goto L_0x002f;
                    case 90: goto L_0x0021;
                    case 97: goto L_0x0034;
                    case 99: goto L_0x0032;
                    case 104: goto L_0x002f;
                    case 108: goto L_0x001e;
                    case 109: goto L_0x001e;
                    case 113: goto L_0x002c;
                    case 115: goto L_0x002c;
                    case 116: goto L_0x001e;
                    case 118: goto L_0x002f;
                    case 122: goto L_0x0021;
                    default: goto L_0x001e;
                }
            L_0x001e:
                r19 = r15
                goto L_0x0037
            L_0x0021:
                r25.close()
                r10.moveTo(r4, r5)
                r0 = r4
                r2 = r0
                r1 = r5
                r3 = r1
                goto L_0x001e
            L_0x002c:
                r19 = r17
                goto L_0x0037
            L_0x002f:
                r19 = r14
                goto L_0x0037
            L_0x0032:
                r6 = 6
                goto L_0x0035
            L_0x0034:
                r6 = 7
            L_0x0035:
                r19 = r6
            L_0x0037:
                r9 = r0
                r8 = r1
                r20 = r4
                r21 = r5
                r7 = r13
                r0 = r27
            L_0x0040:
                int r1 = r12.length
                if (r7 >= r1) goto L_0x030a
                r1 = 65
                if (r11 == r1) goto L_0x02c4
                r1 = 67
                if (r11 == r1) goto L_0x0299
                r5 = 72
                if (r11 == r5) goto L_0x028b
                r5 = 81
                if (r11 == r5) goto L_0x026a
                r6 = 86
                if (r11 == r6) goto L_0x025c
                r6 = 97
                if (r11 == r6) goto L_0x020f
                r6 = 99
                if (r11 == r6) goto L_0x01e2
                r15 = 104(0x68, float:1.46E-43)
                if (r11 == r15) goto L_0x01d5
                r15 = 113(0x71, float:1.58E-43)
                if (r11 == r15) goto L_0x01b6
                r14 = 118(0x76, float:1.65E-43)
                if (r11 == r14) goto L_0x01aa
                r14 = 76
                if (r11 == r14) goto L_0x0199
                r14 = 77
                if (r11 == r14) goto L_0x0177
                r14 = 115(0x73, float:1.61E-43)
                r13 = 83
                r22 = 1073741824(0x40000000, float:2.0)
                if (r11 == r13) goto L_0x0144
                r4 = 116(0x74, float:1.63E-43)
                r13 = 84
                if (r11 == r13) goto L_0x011f
                r1 = 108(0x6c, float:1.51E-43)
                if (r11 == r1) goto L_0x010c
                r1 = 109(0x6d, float:1.53E-43)
                if (r11 == r1) goto L_0x00ef
                if (r11 == r14) goto L_0x00b7
                if (r11 == r4) goto L_0x0091
            L_0x008d:
                r24 = r7
                goto L_0x0300
            L_0x0091:
                if (r0 == r15) goto L_0x009d
                if (r0 == r4) goto L_0x009d
                if (r0 == r5) goto L_0x009d
                if (r0 != r13) goto L_0x009a
                goto L_0x009d
            L_0x009a:
                r0 = 0
                r4 = 0
                goto L_0x00a1
            L_0x009d:
                float r4 = r9 - r2
                float r0 = r8 - r3
            L_0x00a1:
                int r1 = r7 + 0
                r2 = r12[r1]
                int r3 = r7 + 1
                r5 = r12[r3]
                r10.rQuadTo(r4, r0, r2, r5)
                float r4 = r4 + r9
                float r0 = r0 + r8
                r1 = r12[r1]
                float r9 = r9 + r1
                r1 = r12[r3]
                float r8 = r8 + r1
                r3 = r0
                r2 = r4
                goto L_0x008d
            L_0x00b7:
                if (r0 == r6) goto L_0x00c7
                if (r0 == r14) goto L_0x00c7
                r1 = 67
                if (r0 == r1) goto L_0x00c7
                r1 = 83
                if (r0 != r1) goto L_0x00c4
                goto L_0x00c7
            L_0x00c4:
                r1 = 0
                r2 = 0
                goto L_0x00cd
            L_0x00c7:
                float r0 = r9 - r2
                float r1 = r8 - r3
                r2 = r1
                r1 = r0
            L_0x00cd:
                int r13 = r7 + 0
                r3 = r12[r13]
                int r14 = r7 + 1
                r4 = r12[r14]
                int r15 = r7 + 2
                r5 = r12[r15]
                int r22 = r7 + 3
                r6 = r12[r22]
                r0 = r25
                r0.rCubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r12[r13]
                float r0 = r0 + r9
                r1 = r12[r14]
                float r1 = r1 + r8
                r2 = r12[r15]
                float r9 = r9 + r2
                r2 = r12[r22]
                goto L_0x020a
            L_0x00ef:
                int r0 = r7 + 0
                r1 = r12[r0]
                float r9 = r9 + r1
                int r1 = r7 + 1
                r4 = r12[r1]
                float r8 = r8 + r4
                if (r7 <= 0) goto L_0x0103
                r0 = r12[r0]
                r1 = r12[r1]
                r10.rLineTo(r0, r1)
                goto L_0x008d
            L_0x0103:
                r0 = r12[r0]
                r1 = r12[r1]
                r10.rMoveTo(r0, r1)
                goto L_0x0191
            L_0x010c:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r4 = r7 + 1
                r5 = r12[r4]
                r10.rLineTo(r1, r5)
                r0 = r12[r0]
                float r9 = r9 + r0
                r0 = r12[r4]
            L_0x011c:
                float r8 = r8 + r0
                goto L_0x008d
            L_0x011f:
                if (r0 == r15) goto L_0x0127
                if (r0 == r4) goto L_0x0127
                if (r0 == r5) goto L_0x0127
                if (r0 != r13) goto L_0x012d
            L_0x0127:
                float r9 = r9 * r22
                float r9 = r9 - r2
                float r8 = r8 * r22
                float r8 = r8 - r3
            L_0x012d:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r2 = r7 + 1
                r3 = r12[r2]
                r10.quadTo(r9, r8, r1, r3)
                r0 = r12[r0]
                r1 = r12[r2]
                r24 = r7
                r3 = r8
                r2 = r9
                r9 = r0
                r8 = r1
                goto L_0x0300
            L_0x0144:
                if (r0 == r6) goto L_0x0150
                if (r0 == r14) goto L_0x0150
                r1 = 67
                if (r0 == r1) goto L_0x0150
                r1 = 83
                if (r0 != r1) goto L_0x0156
            L_0x0150:
                float r9 = r9 * r22
                float r9 = r9 - r2
                float r8 = r8 * r22
                float r8 = r8 - r3
            L_0x0156:
                r2 = r8
                r1 = r9
                int r8 = r7 + 0
                r3 = r12[r8]
                int r9 = r7 + 1
                r4 = r12[r9]
                int r13 = r7 + 2
                r5 = r12[r13]
                int r14 = r7 + 3
                r6 = r12[r14]
                r0 = r25
                r0.cubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r12[r8]
                r1 = r12[r9]
                r9 = r12[r13]
                r8 = r12[r14]
                goto L_0x020b
            L_0x0177:
                int r0 = r7 + 0
                r9 = r12[r0]
                int r1 = r7 + 1
                r8 = r12[r1]
                if (r7 <= 0) goto L_0x018a
                r0 = r12[r0]
                r1 = r12[r1]
                r10.lineTo(r0, r1)
                goto L_0x008d
            L_0x018a:
                r0 = r12[r0]
                r1 = r12[r1]
                r10.moveTo(r0, r1)
            L_0x0191:
                r24 = r7
                r21 = r8
                r20 = r9
                goto L_0x0300
            L_0x0199:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r4 = r7 + 1
                r5 = r12[r4]
                r10.lineTo(r1, r5)
                r9 = r12[r0]
                r8 = r12[r4]
                goto L_0x008d
            L_0x01aa:
                int r0 = r7 + 0
                r1 = r12[r0]
                r4 = 0
                r10.rLineTo(r4, r1)
                r0 = r12[r0]
                goto L_0x011c
            L_0x01b6:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r2 = r7 + 1
                r3 = r12[r2]
                int r4 = r7 + 2
                r5 = r12[r4]
                int r6 = r7 + 3
                r13 = r12[r6]
                r10.rQuadTo(r1, r3, r5, r13)
                r0 = r12[r0]
                float r0 = r0 + r9
                r1 = r12[r2]
                float r1 = r1 + r8
                r2 = r12[r4]
                float r9 = r9 + r2
                r2 = r12[r6]
                goto L_0x020a
            L_0x01d5:
                int r0 = r7 + 0
                r1 = r12[r0]
                r4 = 0
                r10.rLineTo(r1, r4)
                r0 = r12[r0]
                float r9 = r9 + r0
                goto L_0x008d
            L_0x01e2:
                int r0 = r7 + 0
                r1 = r12[r0]
                int r0 = r7 + 1
                r2 = r12[r0]
                int r13 = r7 + 2
                r3 = r12[r13]
                int r14 = r7 + 3
                r4 = r12[r14]
                int r15 = r7 + 4
                r5 = r12[r15]
                int r22 = r7 + 5
                r6 = r12[r22]
                r0 = r25
                r0.rCubicTo(r1, r2, r3, r4, r5, r6)
                r0 = r12[r13]
                float r0 = r0 + r9
                r1 = r12[r14]
                float r1 = r1 + r8
                r2 = r12[r15]
                float r9 = r9 + r2
                r2 = r12[r22]
            L_0x020a:
                float r8 = r8 + r2
            L_0x020b:
                r2 = r0
                r3 = r1
                goto L_0x008d
            L_0x020f:
                int r13 = r7 + 5
                r0 = r12[r13]
                float r3 = r0 + r9
                int r14 = r7 + 6
                r0 = r12[r14]
                float r4 = r0 + r8
                int r0 = r7 + 0
                r5 = r12[r0]
                int r0 = r7 + 1
                r6 = r12[r0]
                int r0 = r7 + 2
                r15 = r12[r0]
                int r0 = r7 + 3
                r0 = r12[r0]
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0233
                r22 = 1
                goto L_0x0235
            L_0x0233:
                r22 = 0
            L_0x0235:
                int r0 = r7 + 4
                r0 = r12[r0]
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x0240
                r23 = 1
                goto L_0x0242
            L_0x0240:
                r23 = 0
            L_0x0242:
                r0 = r25
                r1 = r9
                r2 = r8
                r24 = r7
                r7 = r15
                r15 = r8
                r8 = r22
                r11 = r9
                r9 = r23
                c(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r0 = r12[r13]
                float r9 = r11 + r0
                r0 = r12[r14]
                float r8 = r15 + r0
                goto L_0x02fe
            L_0x025c:
                r24 = r7
                r11 = r9
                int r7 = r24 + 0
                r0 = r12[r7]
                r10.lineTo(r11, r0)
                r8 = r12[r7]
                goto L_0x0300
            L_0x026a:
                r24 = r7
                int r7 = r24 + 0
                r0 = r12[r7]
                int r1 = r24 + 1
                r2 = r12[r1]
                int r3 = r24 + 2
                r4 = r12[r3]
                int r5 = r24 + 3
                r6 = r12[r5]
                r10.quadTo(r0, r2, r4, r6)
                r0 = r12[r7]
                r1 = r12[r1]
                r9 = r12[r3]
                r8 = r12[r5]
                r2 = r0
                r3 = r1
                goto L_0x0300
            L_0x028b:
                r24 = r7
                r15 = r8
                int r7 = r24 + 0
                r0 = r12[r7]
                r10.lineTo(r0, r15)
                r9 = r12[r7]
                goto L_0x0300
            L_0x0299:
                r24 = r7
                int r7 = r24 + 0
                r1 = r12[r7]
                int r7 = r24 + 1
                r2 = r12[r7]
                int r7 = r24 + 2
                r3 = r12[r7]
                int r8 = r24 + 3
                r4 = r12[r8]
                int r9 = r24 + 4
                r5 = r12[r9]
                int r11 = r24 + 5
                r6 = r12[r11]
                r0 = r25
                r0.cubicTo(r1, r2, r3, r4, r5, r6)
                r9 = r12[r9]
                r0 = r12[r11]
                r1 = r12[r7]
                r2 = r12[r8]
                r8 = r0
                r3 = r2
                r2 = r1
                goto L_0x0300
            L_0x02c4:
                r24 = r7
                r15 = r8
                r11 = r9
                int r13 = r24 + 5
                r3 = r12[r13]
                int r14 = r24 + 6
                r4 = r12[r14]
                int r7 = r24 + 0
                r5 = r12[r7]
                int r7 = r24 + 1
                r6 = r12[r7]
                int r7 = r24 + 2
                r7 = r12[r7]
                int r0 = r24 + 3
                r0 = r12[r0]
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x02e7
                r8 = 1
                goto L_0x02e8
            L_0x02e7:
                r8 = 0
            L_0x02e8:
                int r0 = r24 + 4
                r0 = r12[r0]
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x02f2
                r9 = 1
                goto L_0x02f3
            L_0x02f2:
                r9 = 0
            L_0x02f3:
                r0 = r25
                r1 = r11
                r2 = r15
                c(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r9 = r12[r13]
                r8 = r12[r14]
            L_0x02fe:
                r3 = r8
                r2 = r9
            L_0x0300:
                int r7 = r24 + r19
                r0 = r28
                r11 = r0
                r13 = 0
                r14 = 1
                r15 = 2
                goto L_0x0040
            L_0x030a:
                r15 = r8
                r11 = r9
                r0 = r13
                r26[r0] = r11
                r0 = 1
                r26[r0] = r15
                r0 = 2
                r26[r0] = r2
                r26[r16] = r3
                r26[r17] = r20
                r26[r18] = r21
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t0.f.b.a(android.graphics.Path, float[], char, char, float[]):void");
        }

        public static void b(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
            double d21 = d13;
            int ceil = (int) Math.ceil(Math.abs((d19 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d17);
            double sin = Math.sin(d17);
            double cos2 = Math.cos(d18);
            double sin2 = Math.sin(d18);
            double d22 = -d21;
            double d23 = d22 * cos;
            double d24 = d14 * sin;
            double d25 = (d23 * sin2) - (d24 * cos2);
            double d26 = d22 * sin;
            double d27 = d14 * cos;
            double d28 = (sin2 * d26) + (cos2 * d27);
            double d29 = d19 / ((double) ceil);
            double d31 = d28;
            double d32 = d25;
            int i11 = 0;
            double d33 = d15;
            double d34 = d16;
            double d35 = d18;
            while (i11 < ceil) {
                double d36 = d35 + d29;
                double sin3 = Math.sin(d36);
                double cos3 = Math.cos(d36);
                double d37 = (d11 + ((d21 * cos) * cos3)) - (d24 * sin3);
                double d38 = d12 + (d21 * sin * cos3) + (d27 * sin3);
                double d39 = (d23 * sin3) - (d24 * cos3);
                double d40 = (sin3 * d26) + (cos3 * d27);
                double d41 = d36 - d35;
                double tan = Math.tan(d41 / 2.0d);
                double sin4 = (Math.sin(d41) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d42 = d33 + (d32 * sin4);
                double d43 = sin;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d42, (float) (d34 + (d31 * sin4)), (float) (d37 - (sin4 * d39)), (float) (d38 - (sin4 * d40)), (float) d37, (float) d38);
                i11++;
                d29 = d29;
                sin = d43;
                d33 = d37;
                d26 = d26;
                cos = cos;
                d35 = d36;
                d31 = d40;
                d32 = d39;
                ceil = ceil;
                d34 = d38;
                d21 = d13;
            }
        }

        public static void c(Path path, float f11, float f12, float f13, float f14, float f15, float f16, float f17, boolean z11, boolean z12) {
            double d11;
            double d12;
            float f18 = f11;
            float f19 = f13;
            float f21 = f15;
            boolean z13 = z12;
            double radians = Math.toRadians((double) f17);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d13 = (double) f18;
            double d14 = d13 * cos;
            double d15 = d13;
            double d16 = (double) f12;
            double d17 = (double) f21;
            double d18 = (d14 + (d16 * sin)) / d17;
            double d19 = (((double) (-f18)) * sin) + (d16 * cos);
            double d21 = d16;
            double d22 = (double) f16;
            double d23 = d19 / d22;
            double d24 = (double) f14;
            double d25 = ((((double) f19) * cos) + (d24 * sin)) / d17;
            double d26 = d17;
            double d27 = ((((double) (-f19)) * sin) + (d24 * cos)) / d22;
            double d28 = d18 - d25;
            double d29 = d23 - d27;
            double d31 = (d18 + d25) / 2.0d;
            double d32 = (d23 + d27) / 2.0d;
            double d33 = sin;
            double d34 = (d28 * d28) + (d29 * d29);
            if (d34 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d35 = (1.0d / d34) - 0.25d;
            if (d35 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d34);
                float sqrt = (float) (Math.sqrt(d34) / 1.99999d);
                c(path, f11, f12, f13, f14, f21 * sqrt, f16 * sqrt, f17, z11, z12);
                return;
            }
            double sqrt2 = Math.sqrt(d35);
            double d36 = d28 * sqrt2;
            double d37 = sqrt2 * d29;
            boolean z14 = z12;
            if (z11 == z14) {
                d12 = d31 - d37;
                d11 = d32 + d36;
            } else {
                d12 = d31 + d37;
                d11 = d32 - d36;
            }
            double atan2 = Math.atan2(d23 - d11, d18 - d12);
            double atan22 = Math.atan2(d27 - d11, d25 - d12) - atan2;
            int i11 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z14 != (i11 >= 0)) {
                atan22 = i11 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d38 = d12 * d26;
            double d39 = d11 * d22;
            b(path, (d38 * cos) - (d39 * d33), (d38 * d33) + (d39 * cos), d26, d22, d15, d21, radians, atan2, atan22);
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c11 = 'm';
            for (int i11 = 0; i11 < bVarArr.length; i11++) {
                a(path, fArr, c11, bVarArr[i11].f16519a, bVarArr[i11].f16520b);
                c11 = bVarArr[i11].f16519a;
            }
        }

        public void d(b bVar, b bVar2, float f11) {
            this.f16519a = bVar.f16519a;
            int i11 = 0;
            while (true) {
                float[] fArr = bVar.f16520b;
                if (i11 < fArr.length) {
                    this.f16520b[i11] = (fArr[i11] * (1.0f - f11)) + (bVar2.f16520b[i11] * f11);
                    i11++;
                } else {
                    return;
                }
            }
        }

        public b(b bVar) {
            this.f16519a = bVar.f16519a;
            float[] fArr = bVar.f16520b;
            this.f16520b = f.c(fArr, 0, fArr.length);
        }
    }
}
