package vy;

import android.annotation.SuppressLint;
import com.google.android.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.jmrtd.lds.CVCAFile;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f40603a = true;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f40604a;

        /* renamed from: b  reason: collision with root package name */
        public int f40605b;
    }

    /* renamed from: vy.b$b  reason: collision with other inner class name */
    public static class C0549b extends a {

        /* renamed from: f  reason: collision with root package name */
        public static final int[] f40606f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g  reason: collision with root package name */
        public static final int[] f40607g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c  reason: collision with root package name */
        public int f40608c;

        /* renamed from: d  reason: collision with root package name */
        public int f40609d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f40610e;

        public C0549b(int i11, byte[] bArr) {
            this.f40604a = bArr;
            this.f40610e = (i11 & 8) == 0 ? f40606f : f40607g;
            this.f40608c = 0;
            this.f40609d = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:70:0x00f1 A[EDGE_INSN: B:70:0x00f1->B:53:0x00f1 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(byte[] r17, int r18, int r19, boolean r20) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.f40608c
                r2 = 0
                r3 = 6
                if (r1 != r3) goto L_0x0009
                return r2
            L_0x0009:
                int r4 = r19 + r18
                int r5 = r0.f40609d
                byte[] r6 = r0.f40604a
                int[] r7 = r0.f40610e
                r9 = r2
                r8 = r5
                r5 = r1
                r1 = r18
            L_0x0016:
                r10 = 3
                r11 = 4
                r12 = 2
                r13 = 1
                if (r1 >= r4) goto L_0x00f1
                if (r5 != 0) goto L_0x0063
            L_0x001e:
                int r14 = r1 + 4
                if (r14 > r4) goto L_0x005f
                byte r8 = r17[r1]
                r8 = r8 & 255(0xff, float:3.57E-43)
                r8 = r7[r8]
                int r8 = r8 << 18
                int r15 = r1 + 1
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                int r15 = r15 << 12
                r8 = r8 | r15
                int r15 = r1 + 2
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                int r15 = r15 << r3
                r8 = r8 | r15
                int r15 = r1 + 3
                byte r15 = r17[r15]
                r15 = r15 & 255(0xff, float:3.57E-43)
                r15 = r7[r15]
                r8 = r8 | r15
                if (r8 < 0) goto L_0x005f
                int r1 = r9 + 2
                byte r15 = (byte) r8
                r6[r1] = r15
                int r1 = r9 + 1
                int r15 = r8 >> 8
                byte r15 = (byte) r15
                r6[r1] = r15
                int r1 = r8 >> 16
                byte r1 = (byte) r1
                r6[r9] = r1
                int r9 = r9 + 3
                r1 = r14
                goto L_0x001e
            L_0x005f:
                if (r1 < r4) goto L_0x0063
                goto L_0x00f1
            L_0x0063:
                int r14 = r1 + 1
                byte r1 = r17[r1]
                r1 = r1 & 255(0xff, float:3.57E-43)
                r1 = r7[r1]
                r15 = 5
                r2 = -1
                if (r5 == 0) goto L_0x00e1
                if (r5 == r13) goto L_0x00d5
                r13 = -2
                if (r5 == r12) goto L_0x00c1
                if (r5 == r10) goto L_0x008e
                if (r5 == r11) goto L_0x0082
                if (r5 == r15) goto L_0x007c
                goto L_0x00ed
            L_0x007c:
                if (r1 == r2) goto L_0x00ed
                r0.f40608c = r3
            L_0x0080:
                r10 = 0
                return r10
            L_0x0082:
                r10 = 0
                if (r1 != r13) goto L_0x0089
                int r5 = r5 + 1
                goto L_0x00ed
            L_0x0089:
                if (r1 == r2) goto L_0x00ed
                r0.f40608c = r3
                return r10
            L_0x008e:
                if (r1 < 0) goto L_0x00a9
                int r2 = r8 << 6
                r1 = r1 | r2
                int r2 = r9 + 2
                byte r5 = (byte) r1
                r6[r2] = r5
                int r2 = r9 + 1
                int r5 = r1 >> 8
                byte r5 = (byte) r5
                r6[r2] = r5
                int r2 = r1 >> 16
                byte r2 = (byte) r2
                r6[r9] = r2
                int r9 = r9 + 3
                r8 = r1
                r5 = 0
                goto L_0x00ed
            L_0x00a9:
                if (r1 != r13) goto L_0x00bb
                int r1 = r9 + 1
                int r2 = r8 >> 2
                byte r2 = (byte) r2
                r6[r1] = r2
                int r1 = r8 >> 10
                byte r1 = (byte) r1
                r6[r9] = r1
                int r9 = r9 + 2
                r5 = r15
                goto L_0x00ed
            L_0x00bb:
                if (r1 == r2) goto L_0x00ed
                r0.f40608c = r3
            L_0x00bf:
                r1 = 0
                return r1
            L_0x00c1:
                if (r1 < 0) goto L_0x00c4
                goto L_0x00d8
            L_0x00c4:
                if (r1 != r13) goto L_0x00d0
                int r1 = r9 + 1
                int r2 = r8 >> 4
                byte r2 = (byte) r2
                r6[r9] = r2
                r9 = r1
                r5 = r11
                goto L_0x00ed
            L_0x00d0:
                if (r1 == r2) goto L_0x00ed
                r0.f40608c = r3
                goto L_0x0080
            L_0x00d5:
                r10 = 0
                if (r1 < 0) goto L_0x00dc
            L_0x00d8:
                int r2 = r8 << 6
                r1 = r1 | r2
                goto L_0x00e4
            L_0x00dc:
                if (r1 == r2) goto L_0x00ed
                r0.f40608c = r3
                return r10
            L_0x00e1:
                r10 = 0
                if (r1 < 0) goto L_0x00e8
            L_0x00e4:
                int r5 = r5 + 1
                r8 = r1
                goto L_0x00ed
            L_0x00e8:
                if (r1 == r2) goto L_0x00ed
                r0.f40608c = r3
                return r10
            L_0x00ed:
                r1 = r14
                r2 = 0
                goto L_0x0016
            L_0x00f1:
                if (r20 != 0) goto L_0x00fa
                r0.f40608c = r5
                r0.f40609d = r8
                r0.f40605b = r9
                return r13
            L_0x00fa:
                if (r5 == r13) goto L_0x0122
                if (r5 == r12) goto L_0x0115
                if (r5 == r10) goto L_0x0106
                if (r5 == r11) goto L_0x0103
                goto L_0x011d
            L_0x0103:
                r0.f40608c = r3
                goto L_0x00bf
            L_0x0106:
                int r1 = r9 + 1
                int r2 = r8 >> 10
                byte r2 = (byte) r2
                r6[r9] = r2
                int r9 = r1 + 1
                int r2 = r8 >> 2
                byte r2 = (byte) r2
                r6[r1] = r2
                goto L_0x011d
            L_0x0115:
                int r1 = r9 + 1
                int r2 = r8 >> 4
                byte r2 = (byte) r2
                r6[r9] = r2
                r9 = r1
            L_0x011d:
                r0.f40608c = r5
                r0.f40605b = r9
                return r13
            L_0x0122:
                r0.f40608c = r3
                goto L_0x00bf
            */
            throw new UnsupportedOperationException("Method not decompiled: vy.b.C0549b.a(byte[], int, int, boolean):boolean");
        }
    }

    public static class c extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final byte[] f40611j = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: k  reason: collision with root package name */
        public static final byte[] f40612k = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, 95};

        /* renamed from: l  reason: collision with root package name */
        public static final /* synthetic */ boolean f40613l = true;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f40614c;

        /* renamed from: d  reason: collision with root package name */
        public int f40615d;

        /* renamed from: e  reason: collision with root package name */
        public int f40616e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f40617f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f40618g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f40619h;

        /* renamed from: i  reason: collision with root package name */
        public final byte[] f40620i;

        public c(int i11, byte[] bArr) {
            this.f40604a = bArr;
            boolean z11 = true;
            this.f40617f = (i11 & 1) == 0;
            boolean z12 = (i11 & 2) == 0;
            this.f40618g = z12;
            this.f40619h = (i11 & 4) == 0 ? false : z11;
            this.f40620i = (i11 & 8) == 0 ? f40611j : f40612k;
            this.f40614c = new byte[2];
            this.f40615d = 0;
            this.f40616e = z12 ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01c5  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x01cb A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01d6  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x00e6 A[SYNTHETIC] */
        public boolean a(byte[] r19, int r20, int r21, boolean r22) {
            /*
                r18 = this;
                r0 = r18
                byte[] r1 = r0.f40620i
                byte[] r2 = r0.f40604a
                int r3 = r0.f40616e
                int r4 = r21 + r20
                int r5 = r0.f40615d
                r6 = -1
                r7 = 0
                r8 = 2
                r9 = 1
                if (r5 == r9) goto L_0x0031
                if (r5 == r8) goto L_0x0015
                goto L_0x0050
            L_0x0015:
                int r5 = r20 + 1
                if (r5 > r4) goto L_0x0050
                byte[] r10 = r0.f40614c
                byte r11 = r10[r7]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 16
                byte r10 = r10[r9]
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r10 = r10 << 8
                r10 = r10 | r11
                byte r11 = r19[r20]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r10 = r10 | r11
                r0.f40615d = r7
                r11 = r5
                goto L_0x0053
            L_0x0031:
                int r5 = r20 + 2
                if (r5 > r4) goto L_0x0050
                byte[] r5 = r0.f40614c
                byte r5 = r5[r7]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 16
                int r10 = r20 + 1
                byte r11 = r19[r20]
                r11 = r11 & 255(0xff, float:3.57E-43)
                int r11 = r11 << 8
                r5 = r5 | r11
                int r11 = r10 + 1
                byte r10 = r19[r10]
                r10 = r10 & 255(0xff, float:3.57E-43)
                r10 = r10 | r5
                r0.f40615d = r7
                goto L_0x0053
            L_0x0050:
                r11 = r20
                r10 = r6
            L_0x0053:
                r12 = 4
                r13 = 13
                r14 = 10
                if (r10 == r6) goto L_0x008f
                int r6 = r10 >> 18
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r7] = r6
                int r6 = r10 >> 12
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r9] = r6
                int r6 = r10 >> 6
                r6 = r6 & 63
                byte r6 = r1[r6]
                r2[r8] = r6
                r6 = r10 & 63
                byte r6 = r1[r6]
                r10 = 3
                r2[r10] = r6
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x008d
                boolean r3 = r0.f40619h
                if (r3 == 0) goto L_0x0085
                r3 = 5
                r2[r12] = r13
                goto L_0x0086
            L_0x0085:
                r3 = r12
            L_0x0086:
                int r6 = r3 + 1
                r2[r3] = r14
            L_0x008a:
                r3 = 19
                goto L_0x0090
            L_0x008d:
                r6 = r12
                goto L_0x0090
            L_0x008f:
                r6 = r7
            L_0x0090:
                int r10 = r11 + 3
                if (r10 > r4) goto L_0x00e6
                byte r15 = r19[r11]
                r15 = r15 & 255(0xff, float:3.57E-43)
                int r15 = r15 << 16
                int r16 = r11 + 1
                byte r5 = r19[r16]
                r5 = r5 & 255(0xff, float:3.57E-43)
                int r5 = r5 << 8
                r5 = r5 | r15
                int r11 = r11 + 2
                byte r11 = r19[r11]
                r11 = r11 & 255(0xff, float:3.57E-43)
                r5 = r5 | r11
                int r11 = r5 >> 18
                r11 = r11 & 63
                byte r11 = r1[r11]
                r2[r6] = r11
                int r11 = r6 + 1
                int r15 = r5 >> 12
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 2
                int r15 = r5 >> 6
                r15 = r15 & 63
                byte r15 = r1[r15]
                r2[r11] = r15
                int r11 = r6 + 3
                r5 = r5 & 63
                byte r5 = r1[r5]
                r2[r11] = r5
                int r6 = r6 + 4
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x00e4
                boolean r3 = r0.f40619h
                if (r3 == 0) goto L_0x00dd
                int r3 = r6 + 1
                r2[r6] = r13
                r6 = r3
            L_0x00dd:
                int r3 = r6 + 1
                r2[r6] = r14
                r6 = r3
                r11 = r10
                goto L_0x008a
            L_0x00e4:
                r11 = r10
                goto L_0x0090
            L_0x00e6:
                if (r22 == 0) goto L_0x01d6
                int r5 = r0.f40615d
                int r10 = r11 - r5
                int r15 = r4 + -1
                r16 = 61
                if (r10 != r15) goto L_0x0138
                if (r5 <= 0) goto L_0x00fa
                byte[] r8 = r0.f40614c
                byte r7 = r8[r7]
                r8 = r9
                goto L_0x0101
            L_0x00fa:
                int r8 = r11 + 1
                byte r10 = r19[r11]
                r11 = r8
                r8 = r7
                r7 = r10
            L_0x0101:
                r7 = r7 & 255(0xff, float:3.57E-43)
                int r7 = r7 << r12
                int r5 = r5 - r8
                r0.f40615d = r5
                int r5 = r6 + 1
                int r8 = r7 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r6] = r8
                int r6 = r5 + 1
                r7 = r7 & 63
                byte r1 = r1[r7]
                r2[r5] = r1
                boolean r1 = r0.f40617f
                if (r1 == 0) goto L_0x0125
                int r1 = r6 + 1
                r2[r6] = r16
                int r6 = r1 + 1
                r2[r1] = r16
            L_0x0125:
                boolean r1 = r0.f40618g
                if (r1 == 0) goto L_0x01bc
                boolean r1 = r0.f40619h
                if (r1 == 0) goto L_0x0132
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x0132:
                int r1 = r6 + 1
                r2[r6] = r14
                goto L_0x01bb
            L_0x0138:
                int r10 = r11 - r5
                int r12 = r4 + -2
                if (r10 != r12) goto L_0x01a4
                if (r5 <= r9) goto L_0x0146
                byte[] r10 = r0.f40614c
                byte r7 = r10[r7]
                r10 = r9
                goto L_0x0150
            L_0x0146:
                int r10 = r11 + 1
                byte r11 = r19[r11]
                r17 = r10
                r10 = r7
                r7 = r11
                r11 = r17
            L_0x0150:
                r7 = r7 & 255(0xff, float:3.57E-43)
                int r7 = r7 << r14
                if (r5 <= 0) goto L_0x015c
                byte[] r12 = r0.f40614c
                int r15 = r10 + 1
                byte r10 = r12[r10]
                goto L_0x0163
            L_0x015c:
                int r12 = r11 + 1
                byte r11 = r19[r11]
                r15 = r10
                r10 = r11
                r11 = r12
            L_0x0163:
                r10 = r10 & 255(0xff, float:3.57E-43)
                int r8 = r10 << 2
                r7 = r7 | r8
                int r5 = r5 - r15
                r0.f40615d = r5
                int r5 = r6 + 1
                int r8 = r7 >> 12
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r6] = r8
                int r6 = r5 + 1
                int r8 = r7 >> 6
                r8 = r8 & 63
                byte r8 = r1[r8]
                r2[r5] = r8
                int r5 = r6 + 1
                r7 = r7 & 63
                byte r1 = r1[r7]
                r2[r6] = r1
                boolean r1 = r0.f40617f
                if (r1 == 0) goto L_0x0190
                int r1 = r5 + 1
                r2[r5] = r16
                r5 = r1
            L_0x0190:
                boolean r1 = r0.f40618g
                if (r1 == 0) goto L_0x01a2
                boolean r1 = r0.f40619h
                if (r1 == 0) goto L_0x019d
                int r1 = r5 + 1
                r2[r5] = r13
                r5 = r1
            L_0x019d:
                int r1 = r5 + 1
                r2[r5] = r14
                r5 = r1
            L_0x01a2:
                r6 = r5
                goto L_0x01bc
            L_0x01a4:
                boolean r1 = r0.f40618g
                if (r1 == 0) goto L_0x01bc
                if (r6 <= 0) goto L_0x01bc
                r1 = 19
                if (r3 == r1) goto L_0x01bc
                boolean r1 = r0.f40619h
                if (r1 == 0) goto L_0x01b7
                int r1 = r6 + 1
                r2[r6] = r13
                r6 = r1
            L_0x01b7:
                int r1 = r6 + 1
                r2[r6] = r14
            L_0x01bb:
                r6 = r1
            L_0x01bc:
                boolean r1 = f40613l
                if (r1 != 0) goto L_0x01cb
                int r2 = r0.f40615d
                if (r2 != 0) goto L_0x01c5
                goto L_0x01cb
            L_0x01c5:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01cb:
                if (r1 != 0) goto L_0x01ff
                if (r11 != r4) goto L_0x01d0
                goto L_0x01ff
            L_0x01d0:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>()
                throw r1
            L_0x01d6:
                int r1 = r4 + -1
                if (r11 != r1) goto L_0x01e7
                byte[] r1 = r0.f40614c
                int r2 = r0.f40615d
                int r4 = r2 + 1
                r0.f40615d = r4
                byte r4 = r19[r11]
                r1[r2] = r4
                goto L_0x01ff
            L_0x01e7:
                int r4 = r4 - r8
                if (r11 != r4) goto L_0x01ff
                byte[] r1 = r0.f40614c
                int r2 = r0.f40615d
                int r4 = r2 + 1
                r0.f40615d = r4
                byte r5 = r19[r11]
                r1[r2] = r5
                int r2 = r4 + 1
                r0.f40615d = r2
                int r11 = r11 + r9
                byte r2 = r19[r11]
                r1[r4] = r2
            L_0x01ff:
                r0.f40605b = r6
                r0.f40616e = r3
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: vy.b.c.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] a(String str, int i11) {
        return b(str.getBytes(), i11);
    }

    public static byte[] b(byte[] bArr, int i11) {
        return c(bArr, 0, bArr.length, i11);
    }

    public static byte[] c(byte[] bArr, int i11, int i12, int i13) {
        C0549b bVar = new C0549b(i13, new byte[((i12 * 3) / 4)]);
        if (bVar.a(bArr, i11, i12, true)) {
            int i14 = bVar.f40605b;
            byte[] bArr2 = bVar.f40604a;
            if (i14 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i14];
            System.arraycopy(bArr2, 0, bArr3, 0, i14);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] d(byte[] bArr, int i11) {
        return e(bArr, 0, bArr.length, i11);
    }

    @SuppressLint({"Assert"})
    public static byte[] e(byte[] bArr, int i11, int i12, int i13) {
        c cVar = new c(i13, (byte[]) null);
        int i14 = (i12 / 3) * 4;
        int i15 = 2;
        if (!cVar.f40617f) {
            int i16 = i12 % 3;
            if (i16 == 1) {
                i14 += 2;
            } else if (i16 == 2) {
                i14 += 3;
            }
        } else if (i12 % 3 > 0) {
            i14 += 4;
        }
        if (cVar.f40618g && i12 > 0) {
            int i17 = ((i12 - 1) / 57) + 1;
            if (!cVar.f40619h) {
                i15 = 1;
            }
            i14 += i17 * i15;
        }
        cVar.f40604a = new byte[i14];
        cVar.a(bArr, i11, i12, true);
        if (f40603a || cVar.f40605b == i14) {
            return cVar.f40604a;
        }
        throw new AssertionError();
    }

    public static String f(byte[] bArr, int i11) {
        try {
            return new String(d(bArr, i11), C.ASCII_NAME);
        } catch (UnsupportedEncodingException e11) {
            throw new AssertionError(e11);
        }
    }
}
