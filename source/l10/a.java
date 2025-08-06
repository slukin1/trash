package l10;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.lang.reflect.Array;
import net.lingala.zip4j.exception.ZipException;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.jmrtd.lds.CVCAFile;

public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f57995g = {99, 124, 119, 123, -14, 107, ISOFileInfo.FCI_BYTE, -59, ISO7816.INS_DECREASE, 1, 103, 43, -2, -41, ISOFileInfo.AB, 118, ISO7816.INS_GET_DATA, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, ISO7816.INS_GET_RESPONSE, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.A5, -27, -15, 113, ISO7816.INS_LOAD_KEY_FILE, Framer.STDOUT_FRAME_PREFIX, 21, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, 18, Byte.MIN_VALUE, ISO7816.INS_APPEND_RECORD, -21, 39, -78, 117, 9, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_UNBLOCK_CHV, Ascii.SUB, Ascii.ESC, 110, 90, ISOFileInfo.A0, 82, 59, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_READ_RECORD2, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, ISO7816.INS_READ_BINARY2, 91, 106, -53, -66, 57, 74, 76, 88, -49, ISO7816.INS_WRITE_BINARY, -17, -86, -5, 67, 77, 51, ISOFileInfo.PROP_INFO, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_PUT_DATA, Framer.ENTER_FRAME_PREFIX, 16, -1, -13, ISO7816.INS_WRITE_RECORD, -51, 12, 19, -20, 95, -105, ISO7816.INS_REHABILITATE_CHV, 23, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, ISOFileInfo.DATA_BYTES2, 79, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_MSE, ISO7816.INS_PSO, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, ISO7816.INS_CREATE_FILE, 50, 58, 10, 73, 6, ISO7816.INS_CHANGE_CHV, 92, ISO7816.INS_ENVELOPE, -45, -84, ISOFileInfo.FCP_BYTE, -111, -107, ISO7816.INS_DELETE_FILE, 121, -25, -56, 55, 109, ISOFileInfo.ENV_TEMP_EF, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, Framer.EXIT_FRAME_PREFIX, 37, 46, 28, -90, ISO7816.INS_READ_BINARY_STAMPED, -58, -24, -35, 116, Ascii.US, 75, -67, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.LCS_BYTE, ISO7816.INS_MANAGE_CHANNEL, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, ISOFileInfo.CHANNEL_SECURITY, -108, -101, 30, ISOFileInfo.FCI_EXT, -23, -50, 85, 40, -33, ISOFileInfo.SECURITY_ATTR_COMPACT, ISOFileInfo.A1, -119, 13, -65, -26, CVCAFile.CAR_TAG, 104, 65, -103, Framer.STDIN_FRAME_PREFIX, 15, ISO7816.INS_READ_BINARY, 84, -69, 22};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f57996h = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 197, 145};

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f57997i = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};

    /* renamed from: a  reason: collision with root package name */
    public int f57998a;

    /* renamed from: b  reason: collision with root package name */
    public int[][] f57999b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f58000c;

    /* renamed from: d  reason: collision with root package name */
    public int f58001d;

    /* renamed from: e  reason: collision with root package name */
    public int f58002e;

    /* renamed from: f  reason: collision with root package name */
    public int f58003f;

    public a(byte[] bArr) throws ZipException {
        c(bArr);
    }

    public final void a(int[][] iArr) {
        this.f58000c ^= iArr[0][0];
        this.f58001d ^= iArr[0][1];
        this.f58002e ^= iArr[0][2];
        this.f58003f ^= iArr[0][3];
        int i11 = 1;
        while (i11 < this.f57998a - 1) {
            int[] iArr2 = f57997i;
            int f11 = (((iArr2[this.f58000c & 255] ^ f(iArr2[(this.f58001d >> 8) & 255], 24)) ^ f(iArr2[(this.f58002e >> 16) & 255], 16)) ^ f(iArr2[(this.f58003f >> 24) & 255], 8)) ^ iArr[i11][0];
            int f12 = (((iArr2[this.f58001d & 255] ^ f(iArr2[(this.f58002e >> 8) & 255], 24)) ^ f(iArr2[(this.f58003f >> 16) & 255], 16)) ^ f(iArr2[(this.f58000c >> 24) & 255], 8)) ^ iArr[i11][1];
            int f13 = (((iArr2[this.f58002e & 255] ^ f(iArr2[(this.f58003f >> 8) & 255], 24)) ^ f(iArr2[(this.f58000c >> 16) & 255], 16)) ^ f(iArr2[(this.f58001d >> 24) & 255], 8)) ^ iArr[i11][2];
            int i12 = i11 + 1;
            int f14 = iArr[i11][3] ^ (((iArr2[this.f58003f & 255] ^ f(iArr2[(this.f58000c >> 8) & 255], 24)) ^ f(iArr2[(this.f58001d >> 16) & 255], 16)) ^ f(iArr2[(this.f58002e >> 24) & 255], 8));
            this.f58000c = (((iArr2[f11 & 255] ^ f(iArr2[(f12 >> 8) & 255], 24)) ^ f(iArr2[(f13 >> 16) & 255], 16)) ^ f(iArr2[(f14 >> 24) & 255], 8)) ^ iArr[i12][0];
            this.f58001d = (((iArr2[f12 & 255] ^ f(iArr2[(f13 >> 8) & 255], 24)) ^ f(iArr2[(f14 >> 16) & 255], 16)) ^ f(iArr2[(f11 >> 24) & 255], 8)) ^ iArr[i12][1];
            this.f58002e = (((iArr2[f13 & 255] ^ f(iArr2[(f14 >> 8) & 255], 24)) ^ f(iArr2[(f11 >> 16) & 255], 16)) ^ f(iArr2[(f12 >> 24) & 255], 8)) ^ iArr[i12][2];
            this.f58003f = (((iArr2[f14 & 255] ^ f(iArr2[(f11 >> 8) & 255], 24)) ^ f(iArr2[(f12 >> 16) & 255], 16)) ^ f(iArr2[(f13 >> 24) & 255], 8)) ^ iArr[i12][3];
            i11 = i12 + 1;
        }
        int[] iArr3 = f57997i;
        int f15 = (((iArr3[this.f58000c & 255] ^ f(iArr3[(this.f58001d >> 8) & 255], 24)) ^ f(iArr3[(this.f58002e >> 16) & 255], 16)) ^ f(iArr3[(this.f58003f >> 24) & 255], 8)) ^ iArr[i11][0];
        char f16 = (((iArr3[this.f58001d & 255] ^ f(iArr3[(this.f58002e >> 8) & 255], 24)) ^ f(iArr3[(this.f58003f >> 16) & 255], 16)) ^ f(iArr3[(this.f58000c >> 24) & 255], 8)) ^ iArr[i11][1];
        int f17 = (((iArr3[this.f58002e & 255] ^ f(iArr3[(this.f58003f >> 8) & 255], 24)) ^ f(iArr3[(this.f58000c >> 16) & 255], 16)) ^ f(iArr3[(this.f58001d >> 24) & 255], 8)) ^ iArr[i11][2];
        int i13 = i11 + 1;
        int f18 = iArr[i11][3] ^ (f(iArr3[(this.f58002e >> 24) & 255], 8) ^ ((iArr3[this.f58003f & 255] ^ f(iArr3[(this.f58000c >> 8) & 255], 24)) ^ f(iArr3[(this.f58001d >> 16) & 255], 16)));
        byte[] bArr = f57995g;
        this.f58000c = iArr[i13][0] ^ ((((bArr[f15 & 255] & 255) ^ ((bArr[(f16 >> 8) & 255] & 255) << 8)) ^ ((bArr[(f17 >> 16) & 255] & 255) << 16)) ^ (bArr[(f18 >> 24) & 255] << Ascii.CAN));
        this.f58001d = ((((bArr[f16 & 255] & 255) ^ ((bArr[(f17 >> 8) & 255] & 255) << 8)) ^ ((bArr[(f18 >> 16) & 255] & 255) << 16)) ^ (bArr[(f15 >> 24) & 255] << Ascii.CAN)) ^ iArr[i13][1];
        this.f58002e = ((((bArr[f17 & 255] & 255) ^ ((bArr[(f18 >> 8) & 255] & 255) << 8)) ^ ((bArr[(f15 >> 16) & 255] & 255) << 16)) ^ (bArr[(f16 >> 24) & 255] << Ascii.CAN)) ^ iArr[i13][2];
        this.f58003f = ((((bArr[f18 & 255] & 255) ^ ((bArr[(f15 >> 8) & 255] & 255) << 8)) ^ ((bArr[(f16 >> 16) & 255] & 255) << 16)) ^ (bArr[(f17 >> 24) & 255] << Ascii.CAN)) ^ iArr[i13][3];
    }

    public final int[][] b(byte[] bArr) throws ZipException {
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && length * 4 == bArr.length) {
            int i11 = length + 6;
            this.f57998a = i11;
            int[] iArr = new int[2];
            iArr[1] = 4;
            int i12 = 0;
            iArr[0] = i11 + 1;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            int i13 = 0;
            while (i12 < bArr.length) {
                iArr2[i13 >> 2][i13 & 3] = (bArr[i12] & 255) | ((bArr[i12 + 1] & 255) << 8) | ((bArr[i12 + 2] & 255) << 16) | (bArr[i12 + 3] << Ascii.CAN);
                i12 += 4;
                i13++;
            }
            int i14 = (this.f57998a + 1) << 2;
            for (int i15 = length; i15 < i14; i15++) {
                int i16 = i15 - 1;
                int i17 = iArr2[i16 >> 2][i16 & 3];
                int i18 = i15 % length;
                if (i18 == 0) {
                    i17 = i(f(i17, 8)) ^ f57996h[(i15 / length) - 1];
                } else if (length > 6 && i18 == 4) {
                    i17 = i(i17);
                }
                int i19 = i15 - length;
                iArr2[i15 >> 2][i15 & 3] = i17 ^ iArr2[i19 >> 2][i19 & 3];
            }
            return iArr2;
        }
        throw new ZipException("invalid key length (not 128/192/256)");
    }

    public void c(byte[] bArr) throws ZipException {
        this.f57999b = b(bArr);
    }

    public int d(byte[] bArr, int i11, byte[] bArr2, int i12) throws ZipException {
        if (this.f57999b == null) {
            throw new ZipException("AES engine not initialised");
        } else if (i11 + 16 > bArr.length) {
            throw new ZipException("input buffer too short");
        } else if (i12 + 16 <= bArr2.length) {
            g(bArr, i11);
            a(this.f57999b);
            h(bArr2, i12);
            return 16;
        } else {
            throw new ZipException("output buffer too short");
        }
    }

    public int e(byte[] bArr, byte[] bArr2) throws ZipException {
        return d(bArr, 0, bArr2, 0);
    }

    public final int f(int i11, int i12) {
        return (i11 << (-i12)) | (i11 >>> i12);
    }

    public final void g(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11] & 255;
        this.f58000c = b11;
        int i13 = i12 + 1;
        byte b12 = b11 | ((bArr[i12] & 255) << 8);
        this.f58000c = b12;
        int i14 = i13 + 1;
        byte b13 = b12 | ((bArr[i13] & 255) << 16);
        this.f58000c = b13;
        int i15 = i14 + 1;
        this.f58000c = b13 | (bArr[i14] << Ascii.CAN);
        int i16 = i15 + 1;
        byte b14 = bArr[i15] & 255;
        this.f58001d = b14;
        int i17 = i16 + 1;
        byte b15 = ((bArr[i16] & 255) << 8) | b14;
        this.f58001d = b15;
        int i18 = i17 + 1;
        byte b16 = b15 | ((bArr[i17] & 255) << 16);
        this.f58001d = b16;
        int i19 = i18 + 1;
        this.f58001d = b16 | (bArr[i18] << Ascii.CAN);
        int i21 = i19 + 1;
        byte b17 = bArr[i19] & 255;
        this.f58002e = b17;
        int i22 = i21 + 1;
        byte b18 = ((bArr[i21] & 255) << 8) | b17;
        this.f58002e = b18;
        int i23 = i22 + 1;
        byte b19 = b18 | ((bArr[i22] & 255) << 16);
        this.f58002e = b19;
        int i24 = i23 + 1;
        this.f58002e = b19 | (bArr[i23] << Ascii.CAN);
        int i25 = i24 + 1;
        byte b21 = bArr[i24] & 255;
        this.f58003f = b21;
        int i26 = i25 + 1;
        byte b22 = ((bArr[i25] & 255) << 8) | b21;
        this.f58003f = b22;
        byte b23 = b22 | ((bArr[i26] & 255) << 16);
        this.f58003f = b23;
        this.f58003f = (bArr[i26 + 1] << Ascii.CAN) | b23;
    }

    public final void h(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = this.f58000c;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.f58001d;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        int i21 = i19 + 1;
        bArr[i19] = (byte) (i18 >> 16);
        int i22 = i21 + 1;
        bArr[i21] = (byte) (i18 >> 24);
        int i23 = i22 + 1;
        int i24 = this.f58002e;
        bArr[i22] = (byte) i24;
        int i25 = i23 + 1;
        bArr[i23] = (byte) (i24 >> 8);
        int i26 = i25 + 1;
        bArr[i25] = (byte) (i24 >> 16);
        int i27 = i26 + 1;
        bArr[i26] = (byte) (i24 >> 24);
        int i28 = i27 + 1;
        int i29 = this.f58003f;
        bArr[i27] = (byte) i29;
        int i30 = i28 + 1;
        bArr[i28] = (byte) (i29 >> 8);
        bArr[i30] = (byte) (i29 >> 16);
        bArr[i30 + 1] = (byte) (i29 >> 24);
    }

    public final int i(int i11) {
        byte[] bArr = f57995g;
        return (bArr[(i11 >> 24) & 255] << Ascii.CAN) | (bArr[i11 & 255] & 255) | ((bArr[(i11 >> 8) & 255] & 255) << 8) | ((bArr[(i11 >> 16) & 255] & 255) << 16);
    }
}
