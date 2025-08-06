package d3;

import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.jmrtd.lds.CVCAFile;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f15620a = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f15621b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, 28, 29, 30, Ascii.US, 32, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_MSE, 35, ISO7816.INS_CHANGE_CHV, 37, 38, 39, 40, 41, ISO7816.INS_PSO, 43, ISO7816.INS_UNBLOCK_CHV, Framer.STDIN_FRAME_PREFIX, 46, 47, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f15622c = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, Framer.STDIN_FRAME_PREFIX, 95};

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f15623d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Ascii.SUB, Ascii.ESC, 28, 29, 30, Ascii.US, 32, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_MSE, 35, ISO7816.INS_CHANGE_CHV, 37, 38, 39, 40, 41, ISO7816.INS_PSO, 43, ISO7816.INS_UNBLOCK_CHV, Framer.STDIN_FRAME_PREFIX, 46, 47, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f15624e = {Framer.STDIN_FRAME_PREFIX, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122};

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f15625f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, 28, 29, 30, Ascii.US, 32, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_MSE, 35, ISO7816.INS_CHANGE_CHV, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, ISO7816.INS_PSO, 43, ISO7816.INS_UNBLOCK_CHV, Framer.STDIN_FRAME_PREFIX, 46, 47, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static int d(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        int i14;
        int i15;
        Objects.requireNonNull(bArr, "Source array was null.");
        Objects.requireNonNull(bArr2, "Destination array was null.");
        if (i11 < 0 || (i14 = i11 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11)}));
        } else if (i12 < 0 || (i15 = i12 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i12)}));
        } else {
            byte[] l11 = l(i13);
            int i16 = i11 + 2;
            if (bArr[i16] == 61) {
                bArr2[i12] = (byte) ((((l11[bArr[i11 + 1]] & 255) << 12) | ((l11[bArr[i11]] & 255) << 18)) >>> 16);
                return 1;
            } else if (bArr[i14] == 61) {
                int i17 = (l11[bArr[i11 + 1]] & 255) << 12;
                int i18 = ((l11[bArr[i16]] & 255) << 6) | i17 | ((l11[bArr[i11]] & 255) << 18);
                bArr2[i12] = (byte) (i18 >>> 16);
                bArr2[i12 + 1] = (byte) (i18 >>> 8);
                return 2;
            } else {
                int i19 = (l11[bArr[i11 + 1]] & 255) << 12;
                byte b11 = (l11[bArr[i14]] & 255) | i19 | ((l11[bArr[i11]] & 255) << 18) | ((l11[bArr[i16]] & 255) << 6);
                bArr2[i12] = (byte) (b11 >> 16);
                bArr2[i12 + 1] = (byte) (b11 >> 8);
                bArr2[i15] = (byte) b11;
                return 3;
            }
        }
    }

    public static byte[] e(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14) {
        byte[] k11 = k(i14);
        int i15 = 0;
        int i16 = (i12 > 0 ? (bArr[i11] << Ascii.CAN) >>> 8 : 0) | (i12 > 1 ? (bArr[i11 + 1] << Ascii.CAN) >>> 16 : 0);
        if (i12 > 2) {
            i15 = (bArr[i11 + 2] << Ascii.CAN) >>> 24;
        }
        int i17 = i16 | i15;
        if (i12 == 1) {
            bArr2[i13] = k11[i17 >>> 18];
            bArr2[i13 + 1] = k11[(i17 >>> 12) & 63];
            bArr2[i13 + 2] = 61;
            bArr2[i13 + 3] = 61;
            return bArr2;
        } else if (i12 == 2) {
            bArr2[i13] = k11[i17 >>> 18];
            bArr2[i13 + 1] = k11[(i17 >>> 12) & 63];
            bArr2[i13 + 2] = k11[(i17 >>> 6) & 63];
            bArr2[i13 + 3] = 61;
            return bArr2;
        } else if (i12 != 3) {
            return bArr2;
        } else {
            bArr2[i13] = k11[i17 >>> 18];
            bArr2[i13 + 1] = k11[(i17 >>> 12) & 63];
            bArr2[i13 + 2] = k11[(i17 >>> 6) & 63];
            bArr2[i13 + 3] = k11[i17 & 63];
            return bArr2;
        }
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, int i11, int i12) {
        e(bArr2, 0, i11, bArr, 0, i12);
        return bArr;
    }

    public static String g(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : h(bArr);
    }

    public static String h(byte[] bArr) {
        try {
            return i(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String i(byte[] bArr, int i11, int i12, int i13) throws IOException {
        byte[] j11 = j(bArr, i11, i12, i13);
        try {
            return new String(j11, C.ASCII_NAME);
        } catch (UnsupportedEncodingException unused) {
            return new String(j11);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:12|13|14|15|16|17|18|19|20|21|22|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:30|31|44|45|46|47|(2:48|49)|50) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0037 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0061 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] j(byte[] r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            r0 = r18
            r7 = r19
            r8 = r20
            java.lang.String r1 = "Cannot serialize a null array."
            java.util.Objects.requireNonNull(r0, r1)
            if (r7 < 0) goto L_0x010c
            if (r8 < 0) goto L_0x00f5
            int r1 = r7 + r8
            int r2 = r0.length
            r9 = 1
            if (r1 > r2) goto L_0x00d1
            r1 = r21 & 2
            if (r1 == 0) goto L_0x0065
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0054, all -> 0x0050 }
            r2.<init>()     // Catch:{ IOException -> 0x0054, all -> 0x0050 }
            d3.a$a r3 = new d3.a$a     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            r4 = r21 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x0041, all -> 0x003f }
            r4.close()     // Catch:{ IOException -> 0x0041, all -> 0x003f }
            r4.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r3.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            r2.close()     // Catch:{ Exception -> 0x003a }
        L_0x003a:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x003f:
            r0 = move-exception
            goto L_0x005a
        L_0x0041:
            r0 = move-exception
            goto L_0x004e
        L_0x0043:
            r0 = move-exception
            goto L_0x005b
        L_0x0045:
            r0 = move-exception
            r4 = r1
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            r3 = r1
            goto L_0x005b
        L_0x004b:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x004e:
            r1 = r2
            goto L_0x0057
        L_0x0050:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x005b
        L_0x0054:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x0057:
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r0 = move-exception
            r2 = r1
        L_0x005a:
            r1 = r4
        L_0x005b:
            r1.close()     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            r3.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            r2.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            throw r0
        L_0x0065:
            r1 = r21 & 8
            if (r1 == 0) goto L_0x006b
            r11 = r9
            goto L_0x006c
        L_0x006b:
            r11 = 0
        L_0x006c:
            int r1 = r8 / 3
            r12 = 4
            int r1 = r1 * r12
            int r2 = r8 % 3
            if (r2 <= 0) goto L_0x0076
            r2 = r12
            goto L_0x0077
        L_0x0076:
            r2 = 0
        L_0x0077:
            int r1 = r1 + r2
            if (r11 == 0) goto L_0x007d
            int r2 = r1 / 76
            int r1 = r1 + r2
        L_0x007d:
            r13 = r1
            byte[] r14 = new byte[r13]
            int r15 = r8 + -2
            r6 = 0
            r16 = 0
            r17 = 0
        L_0x0087:
            if (r6 >= r15) goto L_0x00b1
            int r2 = r6 + r7
            r3 = 3
            r1 = r18
            r4 = r14
            r5 = r16
            r10 = r6
            r6 = r21
            e(r1, r2, r3, r4, r5, r6)
            int r1 = r17 + 4
            if (r11 == 0) goto L_0x00aa
            r2 = 76
            if (r1 < r2) goto L_0x00aa
            int r1 = r16 + 4
            r2 = 10
            r14[r1] = r2
            int r16 = r16 + 1
            r17 = 0
            goto L_0x00ac
        L_0x00aa:
            r17 = r1
        L_0x00ac:
            int r6 = r10 + 3
            int r16 = r16 + 4
            goto L_0x0087
        L_0x00b1:
            r10 = r6
            if (r10 >= r8) goto L_0x00c4
            int r2 = r10 + r7
            int r3 = r8 - r10
            r1 = r18
            r4 = r14
            r5 = r16
            r6 = r21
            e(r1, r2, r3, r4, r5, r6)
            int r16 = r16 + 4
        L_0x00c4:
            r0 = r16
            int r13 = r13 - r9
            if (r0 > r13) goto L_0x00d0
            byte[] r1 = new byte[r0]
            r2 = 0
            java.lang.System.arraycopy(r14, r2, r1, r2, r0)
            return r1
        L_0x00d0:
            return r14
        L_0x00d1:
            r2 = 0
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            r3[r2] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r3[r9] = r2
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 2
            r3[r2] = r0
            java.lang.String r0 = "Cannot have offset of %d and length of %d with array of length %d"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r1.<init>(r0)
            throw r1
        L_0x00f5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have length offset: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x010c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have negative offset: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.a.j(byte[], int, int, int):byte[]");
    }

    public static final byte[] k(int i11) {
        if ((i11 & 16) == 16) {
            return f15622c;
        }
        if ((i11 & 32) == 32) {
            return f15624e;
        }
        return f15620a;
    }

    public static final byte[] l(int i11) {
        if ((i11 & 16) == 16) {
            return f15623d;
        }
        if ((i11 & 32) == 32) {
            return f15625f;
        }
        return f15621b;
    }

    /* renamed from: d3.a$a  reason: collision with other inner class name */
    public static class C0076a extends FilterOutputStream {

        /* renamed from: b  reason: collision with root package name */
        public boolean f15626b;

        /* renamed from: c  reason: collision with root package name */
        public int f15627c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f15628d;

        /* renamed from: e  reason: collision with root package name */
        public int f15629e;

        /* renamed from: f  reason: collision with root package name */
        public int f15630f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15631g;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f15632h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15633i;

        /* renamed from: j  reason: collision with root package name */
        public int f15634j;

        /* renamed from: k  reason: collision with root package name */
        public byte[] f15635k;

        public C0076a(OutputStream outputStream, int i11) {
            super(outputStream);
            boolean z11 = true;
            this.f15631g = (i11 & 8) != 0;
            z11 = (i11 & 1) == 0 ? false : z11;
            this.f15626b = z11;
            int i12 = z11 ? 3 : 4;
            this.f15629e = i12;
            this.f15628d = new byte[i12];
            this.f15627c = 0;
            this.f15630f = 0;
            this.f15633i = false;
            this.f15632h = new byte[4];
            this.f15634j = i11;
            this.f15635k = a.l(i11);
        }

        public void a() throws IOException {
            int i11 = this.f15627c;
            if (i11 <= 0) {
                return;
            }
            if (this.f15626b) {
                this.out.write(a.f(this.f15632h, this.f15628d, i11, this.f15634j));
                this.f15627c = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void close() throws IOException {
            a();
            super.close();
            this.f15628d = null;
            this.out = null;
        }

        public void write(int i11) throws IOException {
            if (this.f15633i) {
                this.out.write(i11);
            } else if (this.f15626b) {
                byte[] bArr = this.f15628d;
                int i12 = this.f15627c;
                int i13 = i12 + 1;
                this.f15627c = i13;
                bArr[i12] = (byte) i11;
                int i14 = this.f15629e;
                if (i13 >= i14) {
                    this.out.write(a.f(this.f15632h, bArr, i14, this.f15634j));
                    int i15 = this.f15630f + 4;
                    this.f15630f = i15;
                    if (this.f15631g && i15 >= 76) {
                        this.out.write(10);
                        this.f15630f = 0;
                    }
                    this.f15627c = 0;
                }
            } else {
                byte[] bArr2 = this.f15635k;
                int i16 = i11 & 127;
                if (bArr2[i16] > -5) {
                    byte[] bArr3 = this.f15628d;
                    int i17 = this.f15627c;
                    int i18 = i17 + 1;
                    this.f15627c = i18;
                    bArr3[i17] = (byte) i11;
                    if (i18 >= this.f15629e) {
                        this.out.write(this.f15632h, 0, a.d(bArr3, 0, this.f15632h, 0, this.f15634j));
                        this.f15627c = 0;
                    }
                } else if (bArr2[i16] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            if (this.f15633i) {
                this.out.write(bArr, i11, i12);
                return;
            }
            for (int i13 = 0; i13 < i12; i13++) {
                write(bArr[i11 + i13]);
            }
        }
    }
}
