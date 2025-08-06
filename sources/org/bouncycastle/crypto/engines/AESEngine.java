package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.sumsub.sns.prooface.network.b;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.lang.reflect.Array;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StatelessProcessing;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.jmrtd.lds.CVCAFile;

public class AESEngine implements BlockCipher, StatelessProcessing {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, ISOFileInfo.FCI_BYTE, -59, ISO7816.INS_DECREASE, 1, 103, 43, -2, -41, ISOFileInfo.AB, 118, ISO7816.INS_GET_DATA, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, ISO7816.INS_GET_RESPONSE, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.A5, -27, -15, 113, ISO7816.INS_LOAD_KEY_FILE, Framer.STDOUT_FRAME_PREFIX, 21, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, 18, Byte.MIN_VALUE, ISO7816.INS_APPEND_RECORD, -21, 39, -78, 117, 9, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_UNBLOCK_CHV, Ascii.SUB, Ascii.ESC, 110, 90, ISOFileInfo.A0, 82, 59, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_READ_RECORD2, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, ISO7816.INS_READ_BINARY2, 91, 106, -53, -66, 57, 74, 76, 88, -49, ISO7816.INS_WRITE_BINARY, -17, -86, -5, 67, 77, 51, ISOFileInfo.PROP_INFO, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_PUT_DATA, Framer.ENTER_FRAME_PREFIX, 16, -1, -13, ISO7816.INS_WRITE_RECORD, -51, 12, 19, -20, 95, -105, ISO7816.INS_REHABILITATE_CHV, 23, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, ISOFileInfo.DATA_BYTES2, 79, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_MSE, ISO7816.INS_PSO, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, ISO7816.INS_CREATE_FILE, 50, 58, 10, 73, 6, ISO7816.INS_CHANGE_CHV, 92, ISO7816.INS_ENVELOPE, -45, -84, ISOFileInfo.FCP_BYTE, -111, -107, ISO7816.INS_DELETE_FILE, 121, -25, -56, 55, 109, ISOFileInfo.ENV_TEMP_EF, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, Framer.EXIT_FRAME_PREFIX, 37, 46, 28, -90, ISO7816.INS_READ_BINARY_STAMPED, -58, -24, -35, 116, Ascii.US, 75, -67, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.LCS_BYTE, ISO7816.INS_MANAGE_CHANNEL, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, ISOFileInfo.CHANNEL_SECURITY, -108, -101, 30, ISOFileInfo.FCI_EXT, -23, -50, 85, 40, -33, ISOFileInfo.SECURITY_ATTR_COMPACT, ISOFileInfo.A1, -119, 13, -65, -26, CVCAFile.CAR_TAG, 104, 65, -103, Framer.STDIN_FRAME_PREFIX, 15, ISO7816.INS_READ_BINARY, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, ISO7816.INS_DECREASE, 54, ISOFileInfo.A5, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, ISOFileInfo.DATA_BYTES2, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, ISOFileInfo.FCI_EXT, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.CHANNEL_SECURITY, 67, ISO7816.INS_REHABILITATE_CHV, -60, -34, -23, -53, 84, 123, -108, 50, -90, ISO7816.INS_ENVELOPE, 35, 61, -18, 76, -107, 11, CVCAFile.CAR_TAG, -6, -61, 78, 8, 46, ISOFileInfo.A1, 102, 40, -39, ISO7816.INS_CHANGE_CHV, -78, 118, 91, -94, 73, 109, ISOFileInfo.SECURITY_ATTR_EXP, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, ISO7816.INS_READ_RECORD_STAMPED, -110, 108, ISO7816.INS_MANAGE_CHANNEL, 72, 80, -3, -19, -71, ISO7816.INS_PUT_DATA, 94, 21, 70, 87, -89, ISOFileInfo.ENV_TEMP_EF, -99, -124, -112, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.AB, 0, ISOFileInfo.SECURITY_ATTR_COMPACT, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, ISO7816.INS_DELETE_FILE, 88, 5, -72, ISO7816.INS_READ_RECORD2, 69, 6, ISO7816.INS_WRITE_BINARY, ISO7816.INS_UNBLOCK_CHV, 30, -113, ISO7816.INS_GET_DATA, Utf8.REPLACEMENT_BYTE, 15, 2, -63, -81, -67, 3, 1, 19, ISOFileInfo.LCS_BYTE, 107, 58, -111, 17, 65, 79, 103, ISO7816.INS_UPDATE_RECORD, -22, -105, -14, -49, -50, -16, ISO7816.INS_READ_BINARY_STAMPED, -26, 115, -106, -84, 116, ISO7816.INS_MSE, -25, -83, 53, ISOFileInfo.PROP_INFO, ISO7816.INS_APPEND_RECORD, -7, 55, -24, 28, 117, -33, 110, 71, -15, Ascii.SUB, 113, 29, 41, -59, -119, ISOFileInfo.FCI_BYTE, -73, ISOFileInfo.FCP_BYTE, 14, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, ISO7816.INS_WRITE_RECORD, 121, 32, -102, -37, ISO7816.INS_GET_RESPONSE, -2, Framer.EXIT_FRAME_PREFIX, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_READ_BINARY2, 18, 16, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Ascii.DEL, -87, Ascii.EM, -75, 74, 13, Framer.STDIN_FRAME_PREFIX, -27, 122, -97, -109, -55, -100, -17, ISOFileInfo.A0, ISO7816.INS_CREATE_FILE, 59, 77, -82, ISO7816.INS_PSO, -11, ISO7816.INS_READ_BINARY, -56, -21, -69, 60, ISOFileInfo.FILE_IDENTIFIER, 83, -103, 97, 23, 43, 4, 126, -70, 119, ISO7816.INS_UPDATE_BINARY, 38, -31, 105, 20, 99, 85, Framer.ENTER_FRAME_PREFIX, 12, 125};
    private static final int[] T0 = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};
    private static final int[] Tinv0 = {1353184337, 1399144830, -1012656358, -1772214470, -882136261, -247096033, -1420232020, -1828461749, 1442459680, -160598355, -1854485368, 625738485, -52959921, -674551099, -2143013594, -1885117771, 1230680542, 1729870373, -1743852987, -507445667, 41234371, 317738113, -1550367091, -956705941, -413167869, -1784901099, -344298049, -631680363, 763608788, -752782248, 694804553, 1154009486, 1787413109, 2021232372, 1799248025, -579749593, -1236278850, 397248752, 1722556617, -1271214467, 407560035, -2110711067, 1613975959, 1165972322, -529046351, -2068943941, 480281086, -1809118983, 1483229296, 436028815, -2022908268, -1208452270, 601060267, -503166094, 1468997603, 715871590, 120122290, 63092015, -1703164538, -1526188077, -226023376, -1297760477, -1167457534, 1552029421, 723308426, -1833666137, -252573709, -1578997426, -839591323, -708967162, 526529745, -1963022652, -1655493068, -1604979806, 853641733, 1978398372, 971801355, -1427152832, 111112542, 1360031421, -108388034, 1023860118, -1375387939, 1186850381, -1249028975, 90031217, 1876166148, -15380384, 620468249, -1746289194, -868007799, 2006899047, -1119688528, -2004121337, 945494503, -605108103, 1191869601, -384875908, -920746760, 0, -2088337399, 1223502642, -1401941730, 1316117100, -67170563, 1446544655, 517320253, 658058550, 1691946762, 564550760, -783000677, 976107044, -1318647284, 266819475, -761860428, -1634624741, 1338359936, -1574904735, 1766553434, 370807324, 179999714, -450191168, 1138762300, 488053522, 185403662, -1379431438, -1180125651, -928440812, -2061897385, 1275557295, -1143105042, -44007517, -1624899081, -1124765092, -985962940, 880737115, 1982415755, -590994485, 1761406390, 1676797112, -891538985, 277177154, 1076008723, 538035844, 2099530373, -130171950, 288553390, 1839278535, 1261411869, -214912292, -330136051, -790380169, 1813426987, -1715900247, -95906799, 577038663, -997393240, 440397984, -668172970, -275762398, -951170681, -1043253031, -22885748, 906744984, -813566554, 685669029, 646887386, -1530942145, -459458004, 227702864, -1681105046, 1648787028, -1038905866, -390539120, 1593260334, -173030526, -1098883681, 2090061929, -1456614033, -1290656305, 999926984, -1484974064, 1852021992, 2075868123, 158869197, -199730834, 28809964, -1466282109, 1701746150, 2129067946, 147831841, -420997649, -644094022, -835293366, -737566742, -696471511, -1347247055, 824393514, 815048134, -1067015627, 935087732, -1496677636, -1328508704, 366520115, 1251476721, -136647615, 240176511, 804688151, -1915335306, 1303441219, 1414376140, -553347356, -474623586, 461924940, -1205916479, 2136040774, 82468509, 1563790337, 1937016826, 776014843, 1511876531, 1389550482, 861278441, 323475053, -1939744870, 2047648055, -1911228327, -1992551445, -299390514, 902390199, -303751967, 1018251130, 1507840668, 1064563285, 2043548696, -1086863501, -355600557, 1537932639, 342834655, -2032450440, -2114736182, 1053059257, 741614648, 1598071746, 1925389590, 203809468, -1958134744, 1100287487, 1895934009, -558691320, -1662733096, -1866377628, 1636092795, 1890988757, 1952214088, 1113045200};

    /* renamed from: m1  reason: collision with root package name */
    private static final int f59145m1 = -2139062144;

    /* renamed from: m2  reason: collision with root package name */
    private static final int f59146m2 = 2139062143;

    /* renamed from: m3  reason: collision with root package name */
    private static final int f59147m3 = 27;

    /* renamed from: m4  reason: collision with root package name */
    private static final int f59148m4 = -1061109568;

    /* renamed from: m5  reason: collision with root package name */
    private static final int f59149m5 = 1061109567;
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 197, 145};
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    /* renamed from: s  reason: collision with root package name */
    private byte[] f59150s;

    private static int FFmulX(int i11) {
        return (((i11 & f59145m1) >>> 7) * 27) ^ ((f59146m2 & i11) << 1);
    }

    private static int FFmulX2(int i11) {
        int i12 = i11 & f59148m4;
        int i13 = i12 ^ (i12 >>> 1);
        return (i13 >>> 5) ^ (((f59149m5 & i11) << 2) ^ (i13 >>> 2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v21, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decryptBlock(byte[] r18, int r19, byte[] r20, int r21, int[][] r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            int r3 = r19 + 0
            int r3 = org.bouncycastle.util.Pack.littleEndianToInt(r1, r3)
            int r4 = r19 + 4
            int r4 = org.bouncycastle.util.Pack.littleEndianToInt(r1, r4)
            int r5 = r19 + 8
            int r5 = org.bouncycastle.util.Pack.littleEndianToInt(r1, r5)
            int r6 = r19 + 12
            int r1 = org.bouncycastle.util.Pack.littleEndianToInt(r1, r6)
            int r6 = r0.ROUNDS
            r7 = r22[r6]
            r8 = 0
            r7 = r7[r8]
            r3 = r3 ^ r7
            r7 = r22[r6]
            r9 = 1
            r7 = r7[r9]
            r4 = r4 ^ r7
            r7 = r22[r6]
            r10 = 2
            r7 = r7[r10]
            r5 = r5 ^ r7
            int r7 = r6 + -1
            r6 = r22[r6]
            r11 = 3
            r6 = r6[r11]
            r1 = r1 ^ r6
        L_0x003a:
            r6 = 16
            r12 = 24
            r13 = 8
            if (r7 <= r9) goto L_0x01a3
            int[] r14 = Tinv0
            r15 = r3 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r11 = r1 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r14[r11]
            int r11 = shift(r11, r12)
            r11 = r11 ^ r15
            int r15 = r5 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r6)
            r11 = r11 ^ r15
            int r15 = r4 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r13)
            r11 = r11 ^ r15
            r15 = r22[r7]
            r15 = r15[r8]
            r11 = r11 ^ r15
            r15 = r4 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r8 = r3 >> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r14[r8]
            int r8 = shift(r8, r12)
            r8 = r8 ^ r15
            int r15 = r1 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r6)
            r8 = r8 ^ r15
            int r15 = r5 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r13)
            r8 = r8 ^ r15
            r15 = r22[r7]
            r15 = r15[r9]
            r8 = r8 ^ r15
            r15 = r5 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r9 = r4 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r14[r9]
            int r9 = shift(r9, r12)
            r9 = r9 ^ r15
            int r15 = r3 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r6)
            r9 = r9 ^ r15
            int r15 = r1 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r13)
            r9 = r9 ^ r15
            r15 = r22[r7]
            r15 = r15[r10]
            r9 = r9 ^ r15
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r14[r1]
            int r5 = r5 >> 8
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r14[r5]
            int r5 = shift(r5, r12)
            r1 = r1 ^ r5
            int r4 = r4 >> 16
            r4 = r4 & 255(0xff, float:3.57E-43)
            r4 = r14[r4]
            int r4 = shift(r4, r6)
            r1 = r1 ^ r4
            int r3 = r3 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r14[r3]
            int r3 = shift(r3, r13)
            r1 = r1 ^ r3
            int r3 = r7 + -1
            r4 = r22[r7]
            r5 = 3
            r4 = r4[r5]
            r1 = r1 ^ r4
            r4 = r11 & 255(0xff, float:3.57E-43)
            r4 = r14[r4]
            int r5 = r1 >> 8
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r14[r5]
            int r5 = shift(r5, r12)
            r4 = r4 ^ r5
            int r5 = r9 >> 16
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r14[r5]
            int r5 = shift(r5, r6)
            r4 = r4 ^ r5
            int r5 = r8 >> 24
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r14[r5]
            int r5 = shift(r5, r13)
            r4 = r4 ^ r5
            r5 = r22[r3]
            r7 = 0
            r5 = r5[r7]
            r4 = r4 ^ r5
            r5 = r8 & 255(0xff, float:3.57E-43)
            r5 = r14[r5]
            int r7 = r11 >> 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r14[r7]
            int r7 = shift(r7, r12)
            r5 = r5 ^ r7
            int r7 = r1 >> 16
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r14[r7]
            int r7 = shift(r7, r6)
            r5 = r5 ^ r7
            int r7 = r9 >> 24
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r14[r7]
            int r7 = shift(r7, r13)
            r5 = r5 ^ r7
            r7 = r22[r3]
            r15 = 1
            r7 = r7[r15]
            r5 = r5 ^ r7
            r7 = r9 & 255(0xff, float:3.57E-43)
            r7 = r14[r7]
            int r15 = r8 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r12)
            r7 = r7 ^ r15
            int r15 = r11 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r6)
            r7 = r7 ^ r15
            int r15 = r1 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r14[r15]
            int r15 = shift(r15, r13)
            r7 = r7 ^ r15
            r15 = r22[r3]
            r15 = r15[r10]
            r7 = r7 ^ r15
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r14[r1]
            int r9 = r9 >> r13
            r9 = r9 & 255(0xff, float:3.57E-43)
            r9 = r14[r9]
            int r9 = shift(r9, r12)
            r1 = r1 ^ r9
            int r8 = r8 >> r6
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r14[r8]
            int r6 = shift(r8, r6)
            r1 = r1 ^ r6
            int r6 = r11 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r14[r6]
            int r6 = shift(r6, r13)
            r1 = r1 ^ r6
            int r6 = r3 + -1
            r3 = r22[r3]
            r8 = 3
            r3 = r3[r8]
            r1 = r1 ^ r3
            r3 = r4
            r4 = r5
            r5 = r7
            r8 = 0
            r9 = 1
            r11 = 3
            r7 = r6
            goto L_0x003a
        L_0x01a3:
            int[] r8 = Tinv0
            r9 = r3 & 255(0xff, float:3.57E-43)
            r9 = r8[r9]
            int r11 = r1 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r8[r11]
            int r11 = shift(r11, r12)
            r9 = r9 ^ r11
            int r11 = r5 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r8[r11]
            int r11 = shift(r11, r6)
            r9 = r9 ^ r11
            int r11 = r4 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r8[r11]
            int r11 = shift(r11, r13)
            r9 = r9 ^ r11
            r11 = r22[r7]
            r14 = 0
            r11 = r11[r14]
            r9 = r9 ^ r11
            r11 = r4 & 255(0xff, float:3.57E-43)
            r11 = r8[r11]
            int r14 = r3 >> 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r8[r14]
            int r14 = shift(r14, r12)
            r11 = r11 ^ r14
            int r14 = r1 >> 16
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r8[r14]
            int r14 = shift(r14, r6)
            r11 = r11 ^ r14
            int r14 = r5 >> 24
            r14 = r14 & 255(0xff, float:3.57E-43)
            r14 = r8[r14]
            int r14 = shift(r14, r13)
            r11 = r11 ^ r14
            r14 = r22[r7]
            r15 = 1
            r14 = r14[r15]
            r11 = r11 ^ r14
            r14 = r5 & 255(0xff, float:3.57E-43)
            r14 = r8[r14]
            int r15 = r4 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r8[r15]
            int r15 = shift(r15, r12)
            r14 = r14 ^ r15
            int r15 = r3 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r8[r15]
            int r15 = shift(r15, r6)
            r14 = r14 ^ r15
            int r15 = r1 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r8[r15]
            int r15 = shift(r15, r13)
            r14 = r14 ^ r15
            r15 = r22[r7]
            r15 = r15[r10]
            r14 = r14 ^ r15
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r8[r1]
            int r5 = r5 >> r13
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r8[r5]
            int r5 = shift(r5, r12)
            r1 = r1 ^ r5
            int r4 = r4 >> r6
            r4 = r4 & 255(0xff, float:3.57E-43)
            r4 = r8[r4]
            int r4 = shift(r4, r6)
            r1 = r1 ^ r4
            int r3 = r3 >> r12
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r8[r3]
            int r3 = shift(r3, r13)
            r1 = r1 ^ r3
            r3 = r22[r7]
            r4 = 3
            r3 = r3[r4]
            r1 = r1 ^ r3
            byte[] r3 = Si
            r4 = r9 & 255(0xff, float:3.57E-43)
            byte r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte[] r5 = r0.f59150s
            int r7 = r1 >> 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r13
            r4 = r4 ^ r7
            int r7 = r14 >> 16
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r6
            r4 = r4 ^ r7
            int r7 = r11 >> 24
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r3[r7]
            int r7 = r7 << r12
            r4 = r4 ^ r7
            r7 = 0
            r8 = r22[r7]
            r8 = r8[r7]
            r4 = r4 ^ r8
            r7 = r11 & 255(0xff, float:3.57E-43)
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r9 >> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = r5[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r13
            r7 = r7 ^ r8
            int r8 = r1 >> 16
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = r3[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r6
            r7 = r7 ^ r8
            int r8 = r14 >> 24
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = r5[r8]
            int r8 = r8 << r12
            r7 = r7 ^ r8
            r8 = 0
            r15 = r22[r8]
            r8 = 1
            r8 = r15[r8]
            r7 = r7 ^ r8
            r8 = r14 & 255(0xff, float:3.57E-43)
            byte r8 = r5[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r15 = r11 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r3[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r13
            r8 = r8 ^ r15
            int r15 = r9 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r3[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r8 = r8 ^ r15
            int r15 = r1 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r5[r15]
            int r15 = r15 << r12
            r8 = r8 ^ r15
            r15 = 0
            r16 = r22[r15]
            r10 = r16[r10]
            r8 = r8 ^ r10
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = r3[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r14 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r13
            r1 = r1 ^ r3
            int r3 = r11 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r6
            r1 = r1 ^ r3
            int r3 = r9 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            int r3 = r3 << r12
            r1 = r1 ^ r3
            r3 = 0
            r3 = r22[r3]
            r5 = 3
            r3 = r3[r5]
            r1 = r1 ^ r3
            int r3 = r21 + 0
            org.bouncycastle.util.Pack.intToLittleEndian((int) r4, (byte[]) r2, (int) r3)
            int r3 = r21 + 4
            org.bouncycastle.util.Pack.intToLittleEndian((int) r7, (byte[]) r2, (int) r3)
            int r3 = r21 + 8
            org.bouncycastle.util.Pack.intToLittleEndian((int) r8, (byte[]) r2, (int) r3)
            int r3 = r21 + 12
            org.bouncycastle.util.Pack.intToLittleEndian((int) r1, (byte[]) r2, (int) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.AESEngine.decryptBlock(byte[], int, byte[], int, int[][]):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void encryptBlock(byte[] r18, int r19, byte[] r20, int r21, int[][] r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            int r3 = r19 + 0
            int r3 = org.bouncycastle.util.Pack.littleEndianToInt(r1, r3)
            int r4 = r19 + 4
            int r4 = org.bouncycastle.util.Pack.littleEndianToInt(r1, r4)
            int r5 = r19 + 8
            int r5 = org.bouncycastle.util.Pack.littleEndianToInt(r1, r5)
            int r6 = r19 + 12
            int r1 = org.bouncycastle.util.Pack.littleEndianToInt(r1, r6)
            r6 = 0
            r7 = r22[r6]
            r7 = r7[r6]
            r3 = r3 ^ r7
            r7 = r22[r6]
            r8 = 1
            r7 = r7[r8]
            r4 = r4 ^ r7
            r7 = r22[r6]
            r9 = 2
            r7 = r7[r9]
            r5 = r5 ^ r7
            r7 = r22[r6]
            r10 = 3
            r7 = r7[r10]
            r1 = r1 ^ r7
            r7 = r8
        L_0x0037:
            int r11 = r0.ROUNDS
            int r11 = r11 - r8
            r12 = 16
            r13 = 24
            r14 = 8
            if (r7 >= r11) goto L_0x01a3
            int[] r11 = T0
            r15 = r3 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r10 = r4 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r11[r10]
            int r10 = shift(r10, r13)
            r10 = r10 ^ r15
            int r15 = r5 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r12)
            r10 = r10 ^ r15
            int r15 = r1 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r14)
            r10 = r10 ^ r15
            r15 = r22[r7]
            r15 = r15[r6]
            r10 = r10 ^ r15
            r15 = r4 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r6 = r5 >> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r11[r6]
            int r6 = shift(r6, r13)
            r6 = r6 ^ r15
            int r15 = r1 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r12)
            r6 = r6 ^ r15
            int r15 = r3 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r14)
            r6 = r6 ^ r15
            r15 = r22[r7]
            r15 = r15[r8]
            r6 = r6 ^ r15
            r15 = r5 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r8 = r1 >> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r11[r8]
            int r8 = shift(r8, r13)
            r8 = r8 ^ r15
            int r15 = r3 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r12)
            r8 = r8 ^ r15
            int r15 = r4 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r14)
            r8 = r8 ^ r15
            r15 = r22[r7]
            r15 = r15[r9]
            r8 = r8 ^ r15
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r11[r1]
            int r3 = r3 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r11[r3]
            int r3 = shift(r3, r13)
            r1 = r1 ^ r3
            int r3 = r4 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r11[r3]
            int r3 = shift(r3, r12)
            r1 = r1 ^ r3
            int r3 = r5 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r11[r3]
            int r3 = shift(r3, r14)
            r1 = r1 ^ r3
            int r3 = r7 + 1
            r4 = r22[r7]
            r5 = 3
            r4 = r4[r5]
            r1 = r1 ^ r4
            r4 = r10 & 255(0xff, float:3.57E-43)
            r4 = r11[r4]
            int r5 = r6 >> 8
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r11[r5]
            int r5 = shift(r5, r13)
            r4 = r4 ^ r5
            int r5 = r8 >> 16
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r11[r5]
            int r5 = shift(r5, r12)
            r4 = r4 ^ r5
            int r5 = r1 >> 24
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r11[r5]
            int r5 = shift(r5, r14)
            r4 = r4 ^ r5
            r5 = r22[r3]
            r7 = 0
            r5 = r5[r7]
            r4 = r4 ^ r5
            r5 = r6 & 255(0xff, float:3.57E-43)
            r5 = r11[r5]
            int r7 = r8 >> 8
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r11[r7]
            int r7 = shift(r7, r13)
            r5 = r5 ^ r7
            int r7 = r1 >> 16
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r11[r7]
            int r7 = shift(r7, r12)
            r5 = r5 ^ r7
            int r7 = r10 >> 24
            r7 = r7 & 255(0xff, float:3.57E-43)
            r7 = r11[r7]
            int r7 = shift(r7, r14)
            r5 = r5 ^ r7
            r7 = r22[r3]
            r15 = 1
            r7 = r7[r15]
            r5 = r5 ^ r7
            r7 = r8 & 255(0xff, float:3.57E-43)
            r7 = r11[r7]
            int r15 = r1 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r13)
            r7 = r7 ^ r15
            int r15 = r10 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r12)
            r7 = r7 ^ r15
            int r15 = r6 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r11[r15]
            int r15 = shift(r15, r14)
            r7 = r7 ^ r15
            r15 = r22[r3]
            r15 = r15[r9]
            r7 = r7 ^ r15
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r11[r1]
            int r10 = r10 >> r14
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r11[r10]
            int r10 = shift(r10, r13)
            r1 = r1 ^ r10
            int r6 = r6 >> r12
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r11[r6]
            int r6 = shift(r6, r12)
            r1 = r1 ^ r6
            int r6 = r8 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r11[r6]
            int r6 = shift(r6, r14)
            r1 = r1 ^ r6
            int r6 = r3 + 1
            r3 = r22[r3]
            r8 = 3
            r3 = r3[r8]
            r1 = r1 ^ r3
            r3 = r4
            r4 = r5
            r5 = r7
            r8 = 1
            r10 = 3
            r7 = r6
            r6 = 0
            goto L_0x0037
        L_0x01a3:
            int[] r6 = T0
            r8 = r3 & 255(0xff, float:3.57E-43)
            r8 = r6[r8]
            int r10 = r4 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r6[r10]
            int r10 = shift(r10, r13)
            r8 = r8 ^ r10
            int r10 = r5 >> 16
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r6[r10]
            int r10 = shift(r10, r12)
            r8 = r8 ^ r10
            int r10 = r1 >> 24
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r6[r10]
            int r10 = shift(r10, r14)
            r8 = r8 ^ r10
            r10 = r22[r7]
            r11 = 0
            r10 = r10[r11]
            r8 = r8 ^ r10
            r10 = r4 & 255(0xff, float:3.57E-43)
            r10 = r6[r10]
            int r11 = r5 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r6[r11]
            int r11 = shift(r11, r13)
            r10 = r10 ^ r11
            int r11 = r1 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r6[r11]
            int r11 = shift(r11, r12)
            r10 = r10 ^ r11
            int r11 = r3 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            r11 = r6[r11]
            int r11 = shift(r11, r14)
            r10 = r10 ^ r11
            r11 = r22[r7]
            r15 = 1
            r11 = r11[r15]
            r10 = r10 ^ r11
            r11 = r5 & 255(0xff, float:3.57E-43)
            r11 = r6[r11]
            int r15 = r1 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r6[r15]
            int r15 = shift(r15, r13)
            r11 = r11 ^ r15
            int r15 = r3 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r6[r15]
            int r15 = shift(r15, r12)
            r11 = r11 ^ r15
            int r15 = r4 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r6[r15]
            int r15 = shift(r15, r14)
            r11 = r11 ^ r15
            r15 = r22[r7]
            r15 = r15[r9]
            r11 = r11 ^ r15
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r6[r1]
            int r3 = r3 >> r14
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r6[r3]
            int r3 = shift(r3, r13)
            r1 = r1 ^ r3
            int r3 = r4 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r6[r3]
            int r3 = shift(r3, r12)
            r1 = r1 ^ r3
            int r3 = r5 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r6[r3]
            int r3 = shift(r3, r14)
            r1 = r1 ^ r3
            int r3 = r7 + 1
            r4 = r22[r7]
            r5 = 3
            r4 = r4[r5]
            r1 = r1 ^ r4
            byte[] r4 = S
            r5 = r8 & 255(0xff, float:3.57E-43)
            byte r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r10 >> 8
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = r4[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r14
            r5 = r5 ^ r6
            byte[] r6 = r0.f59150s
            int r7 = r11 >> 16
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r6[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r12
            r5 = r5 ^ r7
            int r7 = r1 >> 24
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r6[r7]
            int r7 = r7 << r13
            r5 = r5 ^ r7
            r7 = r22[r3]
            r15 = 0
            r7 = r7[r15]
            r5 = r5 ^ r7
            r7 = r10 & 255(0xff, float:3.57E-43)
            byte r7 = r6[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r15 = r11 >> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r4[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r14
            r7 = r7 ^ r15
            int r15 = r1 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r4[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r12
            r7 = r7 ^ r15
            int r15 = r8 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r6[r15]
            int r15 = r15 << r13
            r7 = r7 ^ r15
            r15 = r22[r3]
            r16 = 1
            r15 = r15[r16]
            r7 = r7 ^ r15
            r15 = r11 & 255(0xff, float:3.57E-43)
            byte r15 = r6[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r9 = r1 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = r4[r9]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r14
            r9 = r9 ^ r15
            int r15 = r8 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r4[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r12
            r9 = r9 ^ r15
            int r15 = r10 >> 24
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r4[r15]
            int r15 = r15 << r13
            r9 = r9 ^ r15
            r15 = r22[r3]
            r16 = 2
            r15 = r15[r16]
            r9 = r9 ^ r15
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = r6[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r8 = r8 >> r14
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = r6[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r14
            r1 = r1 ^ r8
            int r8 = r10 >> 16
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r6 = r6[r8]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r12
            r1 = r1 ^ r6
            int r6 = r11 >> 24
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r4 = r4[r6]
            int r4 = r4 << r13
            r1 = r1 ^ r4
            r3 = r22[r3]
            r4 = 3
            r3 = r3[r4]
            r1 = r1 ^ r3
            int r3 = r21 + 0
            org.bouncycastle.util.Pack.intToLittleEndian((int) r5, (byte[]) r2, (int) r3)
            int r3 = r21 + 4
            org.bouncycastle.util.Pack.intToLittleEndian((int) r7, (byte[]) r2, (int) r3)
            int r3 = r21 + 8
            org.bouncycastle.util.Pack.intToLittleEndian((int) r9, (byte[]) r2, (int) r3)
            int r3 = r21 + 12
            org.bouncycastle.util.Pack.intToLittleEndian((int) r1, (byte[]) r2, (int) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.AESEngine.encryptBlock(byte[], int, byte[], int, int[][]):void");
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z11) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i11 = length >>> 2;
        int i12 = i11 + 6;
        this.ROUNDS = i12;
        int[] iArr = new int[2];
        iArr[1] = 4;
        iArr[0] = i12 + 1;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i13 = 8;
        char c11 = 3;
        if (i11 == 4) {
            int littleEndianToInt = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt;
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt2;
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt3;
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt4;
            for (int i14 = 1; i14 <= 10; i14++) {
                littleEndianToInt ^= subWord(shift(littleEndianToInt4, 8)) ^ rcon[i14 - 1];
                iArr2[i14][0] = littleEndianToInt;
                littleEndianToInt2 ^= littleEndianToInt;
                iArr2[i14][1] = littleEndianToInt2;
                littleEndianToInt3 ^= littleEndianToInt2;
                iArr2[i14][2] = littleEndianToInt3;
                littleEndianToInt4 ^= littleEndianToInt3;
                iArr2[i14][3] = littleEndianToInt4;
            }
        } else if (i11 == 6) {
            int littleEndianToInt5 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt5;
            int littleEndianToInt6 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt6;
            int littleEndianToInt7 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt7;
            int littleEndianToInt8 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt8;
            int littleEndianToInt9 = Pack.littleEndianToInt(bArr2, 16);
            int littleEndianToInt10 = Pack.littleEndianToInt(bArr2, 20);
            int i15 = 1;
            int i16 = 1;
            while (true) {
                iArr2[i15][0] = littleEndianToInt9;
                iArr2[i15][1] = littleEndianToInt10;
                int subWord = subWord(shift(littleEndianToInt10, 8)) ^ i16;
                int i17 = i16 << 1;
                int i18 = littleEndianToInt5 ^ subWord;
                iArr2[i15][2] = i18;
                int i19 = littleEndianToInt6 ^ i18;
                iArr2[i15][3] = i19;
                int i21 = littleEndianToInt7 ^ i19;
                int i22 = i15 + 1;
                iArr2[i22][0] = i21;
                int i23 = littleEndianToInt8 ^ i21;
                iArr2[i22][1] = i23;
                int i24 = littleEndianToInt9 ^ i23;
                iArr2[i22][2] = i24;
                int i25 = littleEndianToInt10 ^ i24;
                iArr2[i22][3] = i25;
                int subWord2 = subWord(shift(i25, 8)) ^ i17;
                i16 = i17 << 1;
                littleEndianToInt5 = i18 ^ subWord2;
                int i26 = i15 + 2;
                iArr2[i26][0] = littleEndianToInt5;
                littleEndianToInt6 = i19 ^ littleEndianToInt5;
                iArr2[i26][1] = littleEndianToInt6;
                littleEndianToInt7 = i21 ^ littleEndianToInt6;
                iArr2[i26][2] = littleEndianToInt7;
                littleEndianToInt8 = i23 ^ littleEndianToInt7;
                iArr2[i26][3] = littleEndianToInt8;
                i15 += 3;
                if (i15 >= 13) {
                    break;
                }
                littleEndianToInt9 = i24 ^ littleEndianToInt8;
                littleEndianToInt10 = i25 ^ littleEndianToInt9;
            }
        } else if (i11 == 8) {
            int littleEndianToInt11 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt11;
            int littleEndianToInt12 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt12;
            int littleEndianToInt13 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt13;
            int littleEndianToInt14 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt14;
            int littleEndianToInt15 = Pack.littleEndianToInt(bArr2, 16);
            iArr2[1][0] = littleEndianToInt15;
            int littleEndianToInt16 = Pack.littleEndianToInt(bArr2, 20);
            iArr2[1][1] = littleEndianToInt16;
            int littleEndianToInt17 = Pack.littleEndianToInt(bArr2, 24);
            iArr2[1][2] = littleEndianToInt17;
            int littleEndianToInt18 = Pack.littleEndianToInt(bArr2, 28);
            iArr2[1][3] = littleEndianToInt18;
            int i27 = 2;
            int i28 = 1;
            while (true) {
                int subWord3 = subWord(shift(littleEndianToInt18, i13)) ^ i28;
                i28 <<= 1;
                littleEndianToInt11 ^= subWord3;
                iArr2[i27][0] = littleEndianToInt11;
                littleEndianToInt12 ^= littleEndianToInt11;
                iArr2[i27][1] = littleEndianToInt12;
                littleEndianToInt13 ^= littleEndianToInt12;
                iArr2[i27][2] = littleEndianToInt13;
                littleEndianToInt14 ^= littleEndianToInt13;
                iArr2[i27][c11] = littleEndianToInt14;
                int i29 = i27 + 1;
                if (i29 >= 15) {
                    break;
                }
                littleEndianToInt15 ^= subWord(littleEndianToInt14);
                iArr2[i29][0] = littleEndianToInt15;
                littleEndianToInt16 ^= littleEndianToInt15;
                iArr2[i29][1] = littleEndianToInt16;
                littleEndianToInt17 ^= littleEndianToInt16;
                iArr2[i29][2] = littleEndianToInt17;
                littleEndianToInt18 ^= littleEndianToInt17;
                iArr2[i29][3] = littleEndianToInt18;
                i27 = i29 + 1;
                i13 = 8;
                c11 = 3;
            }
        } else {
            throw new IllegalStateException("Should never get here");
        }
        if (!z11) {
            for (int i30 = 1; i30 < this.ROUNDS; i30++) {
                for (int i31 = 0; i31 < 4; i31++) {
                    iArr2[i30][i31] = inv_mcol(iArr2[i30][i31]);
                }
            }
        }
        return iArr2;
    }

    private static int inv_mcol(int i11) {
        int shift = shift(i11, 8) ^ i11;
        int FFmulX = i11 ^ FFmulX(shift);
        int FFmulX2 = shift ^ FFmulX2(FFmulX);
        return FFmulX ^ (FFmulX2 ^ shift(FFmulX2, 16));
    }

    private static int shift(int i11, int i12) {
        return (i11 << (-i12)) | (i11 >>> i12);
    }

    private static int subWord(int i11) {
        byte[] bArr = S;
        return (bArr[(i11 >> 24) & 255] << Ascii.CAN) | (bArr[i11 & 255] & 255) | ((bArr[(i11 >> 8) & 255] & 255) << 8) | ((bArr[(i11 >> 16) & 255] & 255) << 16);
    }

    public String getAlgorithmName() {
        return b.f40261d;
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z11);
            this.forEncryption = z11;
            if (z11) {
                this.f59150s = Arrays.clone(S);
            } else {
                this.f59150s = Arrays.clone(Si);
            }
        } else {
            throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
        }
    }

    public BlockCipher newInstance() {
        return new AESEngine();
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[][] iArr = this.WorkingKey;
        if (iArr == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i11 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 <= bArr2.length - 16) {
            if (this.forEncryption) {
                encryptBlock(bArr, i11, bArr2, i12, iArr);
            } else {
                decryptBlock(bArr, i11, bArr2, i12, iArr);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
