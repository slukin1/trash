package jumio.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import java.io.File;
import java.util.HashMap;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.jmrtd.lds.CVCAFile;

public final class m2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f56279a = {StringDeobfuscator.deobfuscate(new byte[]{-112, -24, 54, 21, -60, -21, 55, -112, 4, 6, 53, 99, 14, -90, ISO7816.INS_PSO, -126, -120, -6, Framer.STDIN_FRAME_PREFIX, -57, -108, ISO7816.INS_APPEND_RECORD, ISOFileInfo.SECURITY_ATTR_EXP}, -8487608571793451177L), StringDeobfuscator.deobfuscate(new byte[]{32, 115, 53, 117, 114, 13, 78, -113, 58, Framer.EXIT_FRAME_PREFIX, 110, 99, 81, ISOFileInfo.SECURITY_ATTR_COMPACT, 7, -5, Byte.MIN_VALUE, Byte.MIN_VALUE, 78, ISO7816.INS_READ_BINARY, ISOFileInfo.LCS_BYTE, ISO7816.INS_MSE, ISO7816.INS_READ_BINARY2, 79, 100, -2, 41, 82, ISOFileInfo.LCS_BYTE}, -8029906233449326913L), StringDeobfuscator.deobfuscate(new byte[]{-94, 12, Ascii.DEL, Ascii.DEL, Ascii.DEL, -88, -97, -50, 20, 85, ISOFileInfo.A5, ISO7816.INS_UPDATE_RECORD, -110, 40, 117, 38, 104, -17, 87, -61}, -3261248787677980597L), StringDeobfuscator.deobfuscate(new byte[]{ISOFileInfo.FILE_IDENTIFIER, Ascii.DEL, 1, -92, Ascii.ESC, 60, 18, 99, -45, 101, -23, -60, -126, 91, -122, -69, 115, -14, ISO7816.INS_CHANGE_CHV, 54, ISOFileInfo.FCI_BYTE, 7, -19, -1, -108, -103}, -8395865714933300392L), StringDeobfuscator.deobfuscate(new byte[]{ISO7816.INS_GET_DATA, ISO7816.INS_MSE, -83, ISO7816.INS_WRITE_RECORD, -78, -104, -4, -81, -17, -4, -58, 75, ISO7816.INS_PSO, 119, ISOFileInfo.FCI_EXT, 74, ISO7816.INS_DECREASE_STAMPED, ISO7816.INS_READ_BINARY2, ISOFileInfo.DATA_BYTES2, -5, 29, -122, 43, Framer.STDIN_FRAME_PREFIX}, -6153163343165779037L), StringDeobfuscator.deobfuscate(new byte[]{57, Framer.STDOUT_FRAME_PREFIX, 5, 94, -124, -34, -63, 17, -15, SignedBytes.MAX_POWER_OF_TWO, 116, -51, ISOFileInfo.FILE_IDENTIFIER, Ascii.ESC, 32}, 8911359989896711776L)};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f56280b = {StringDeobfuscator.deobfuscate(new byte[]{-55, -100, 54, -110, -99, 104, ISO7816.INS_APPEND_RECORD, -88, ISOFileInfo.SECURITY_ATTR_EXP, 85, 125, ISO7816.INS_WRITE_RECORD, 104, ISO7816.INS_GET_RESPONSE, ISOFileInfo.SECURITY_ATTR_EXP, 55, Ascii.CAN, -4, 96, 43, -111, 54, -9, 110, -66, 61, 13}, 9151558827609761157L), StringDeobfuscator.deobfuscate(new byte[]{80, -66, ISO7816.INS_GET_RESPONSE, ISOFileInfo.DATA_BYTES2, -18, -35, 29, 70, -60, 11, 22, 14, 93, -24, ISOFileInfo.A5, 71, 121, -31, 105, -5, ISOFileInfo.CHANNEL_SECURITY, 116, ISO7816.INS_LOAD_KEY_FILE, ISO7816.INS_PSO, ISOFileInfo.A0, -108, -58}, 7367759678796982280L), StringDeobfuscator.deobfuscate(new byte[]{-84, -66, 35, -31, -25, -120, 86, 73, -17, 12, 37, -78, -29, -124, 1, -55, 99, ISO7816.INS_MSE, -23, -7, 8, ISO7816.INS_READ_BINARY_STAMPED}, -5465061677096261914L), StringDeobfuscator.deobfuscate(new byte[]{39, ISO7816.INS_REHABILITATE_CHV, -78, -17, 109, -6, -20, -35, 94, 74, -20, 60, -47, -101, 124, 77, -52, -2, Framer.EXIT_FRAME_PREFIX, 97, -113, ISO7816.INS_READ_BINARY_STAMPED, -13, 80, 74, ISO7816.INS_UPDATE_BINARY}, 7767155038365976375L)};

    public static boolean a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(StringDeobfuscator.deobfuscate(new byte[]{CVCAFile.CAR_TAG, -7, 92, -66, -25, 92, 17, -43, ISOFileInfo.FCI_BYTE, -16, 54, 51, 76}, 7072531674044459636L), "1");
        hashMap.put(StringDeobfuscator.deobfuscate(new byte[]{55, 59, -108, -12, -98, 75, 73, ISO7816.INS_READ_BINARY2, -34}, -2033597383599115943L), "0");
        boolean z11 = false;
        boolean a11 = a(context, f56280b) | a(context, f56279a) | false | (a(StringDeobfuscator.deobfuscate(new byte[]{76, Byte.MIN_VALUE}, -602338539832695767L)) || b(StringDeobfuscator.deobfuscate(new byte[]{60, ISOFileInfo.A1}, -19473538672391723L))) | a(hashMap);
        String str = Build.TAGS;
        if (str != null && str.contains(StringDeobfuscator.deobfuscate(new byte[]{Framer.STDIN_FRAME_PREFIX, -7, -106, -107, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_PUT_DATA, -107, 37, -97}, 948885450557109957L))) {
            z11 = true;
        }
        return a11 | z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[SYNTHETIC, Splitter:B:21:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060 A[Catch:{ Exception -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067 A[SYNTHETIC, Splitter:B:31:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c A[Catch:{ Exception -> 0x006f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r10) {
        /*
            r0 = 0
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r5 = 5
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r6 = 113(0x71, float:1.58E-43)
            r5[r1] = r6     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r6 = -68
            r7 = 1
            r5[r7] = r6     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r6 = -4
            r5[r3] = r6     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r3 = 3
            r6 = -3
            r5[r3] = r6     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r3 = 4
            r6 = 41
            r5[r3] = r6     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r8 = -3585060780676057064(0xce3f4e36e59e7818, double:-8.4399528872688E68)
            java.lang.String r3 = com.jumio.commons.obfuscate.StringDeobfuscator.deobfuscate(r5, r8)     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r4[r1] = r3     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            r4[r7] = r10     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            java.lang.Process r10 = r2.exec(r4)     // Catch:{ Exception -> 0x0064, all -> 0x0056 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0065, all -> 0x0054 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0065, all -> 0x0054 }
            java.io.InputStream r4 = r10.getInputStream()     // Catch:{ Exception -> 0x0065, all -> 0x0054 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0065, all -> 0x0054 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0065, all -> 0x0054 }
            java.lang.String r0 = r2.readLine()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            if (r0 == 0) goto L_0x0047
            r1 = r7
        L_0x0047:
            r10.destroy()     // Catch:{ Exception -> 0x004d }
            r2.close()     // Catch:{ Exception -> 0x004d }
        L_0x004d:
            return r1
        L_0x004e:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L_0x0059
        L_0x0052:
            r0 = r2
            goto L_0x0065
        L_0x0054:
            r1 = move-exception
            goto L_0x0059
        L_0x0056:
            r10 = move-exception
            r1 = r10
            r10 = r0
        L_0x0059:
            if (r10 == 0) goto L_0x005e
            r10.destroy()     // Catch:{ Exception -> 0x0063 }
        L_0x005e:
            if (r0 == 0) goto L_0x0063
            r0.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            throw r1
        L_0x0064:
            r10 = r0
        L_0x0065:
            if (r10 == 0) goto L_0x006a
            r10.destroy()     // Catch:{ Exception -> 0x006f }
        L_0x006a:
            if (r0 == 0) goto L_0x006f
            r0.close()     // Catch:{ Exception -> 0x006f }
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.m2.b(java.lang.String):boolean");
    }

    public static boolean a(String str) {
        boolean z11 = false;
        for (String str2 : System.getenv(StringDeobfuscator.deobfuscate(new byte[]{15, 77, 96, -6}, 5148579034595742065L)).split(":")) {
            z11 |= new File(str2 + File.separator + str).exists();
        }
        return z11;
    }

    public static boolean a(Context context, String[] strArr) {
        PackageManager packageManager = context.getPackageManager();
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            try {
                packageManager.getPackageInfo(strArr[i11], 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                i11++;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bb A[SYNTHETIC, Splitter:B:29:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c0 A[Catch:{ Exception -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7 A[SYNTHETIC, Splitter:B:39:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cc A[Catch:{ Exception -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.util.HashMap r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "\\[("
            r0.append(r1)
            java.util.Set r1 = r10.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0027
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r0.append(r2)
            java.lang.String r2 = "|"
            r0.append(r2)
            goto L_0x0012
        L_0x0027:
            int r1 = r0.length()
            r2 = 1
            int r1 = r1 - r2
            r0.deleteCharAt(r1)
            java.lang.String r1 = ")\\]: \\[(.*)\\]"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = 0
            r3 = 0
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r5 = 7
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r6 = 57
            r5[r3] = r6     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r6 = -55
            r5[r2] = r6     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r6 = -61
            r7 = 2
            r5[r7] = r6     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r6 = 3
            r8 = -20
            r5[r6] = r8     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r6 = 4
            r8 = -93
            r5[r6] = r8     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r6 = 5
            r8 = 11
            r5[r6] = r8     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r6 = 6
            r8 = 46
            r5[r6] = r8     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            r8 = 9000845540372033634(0x7ce96d549808b062, double:5.074837535125339E293)
            java.lang.String r5 = com.jumio.commons.obfuscate.StringDeobfuscator.deobfuscate(r5, r8)     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            java.lang.Process r4 = r4.exec(r5)     // Catch:{ Exception -> 0x00c4, all -> 0x00b7 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00c5, all -> 0x00b5 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00c5, all -> 0x00b5 }
            java.io.InputStream r8 = r4.getInputStream()     // Catch:{ Exception -> 0x00c5, all -> 0x00b5 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x00c5, all -> 0x00b5 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00c5, all -> 0x00b5 }
        L_0x0082:
            java.lang.String r1 = r5.readLine()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            if (r1 == 0) goto L_0x00a7
            java.util.regex.Matcher r1 = r0.matcher(r1)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            boolean r6 = r1.find()     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            if (r6 == 0) goto L_0x0082
            java.lang.String r6 = r1.group(r2)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.Object r6 = r10.get(r6)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            java.lang.String r1 = r1.group(r7)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x00b3, all -> 0x00b0 }
            if (r1 == 0) goto L_0x0082
            goto L_0x00a8
        L_0x00a7:
            r2 = r3
        L_0x00a8:
            r4.destroy()     // Catch:{ Exception -> 0x00ae }
            r5.close()     // Catch:{ Exception -> 0x00ae }
        L_0x00ae:
            r3 = r2
            goto L_0x00cf
        L_0x00b0:
            r10 = move-exception
            r1 = r5
            goto L_0x00b9
        L_0x00b3:
            r1 = r5
            goto L_0x00c5
        L_0x00b5:
            r10 = move-exception
            goto L_0x00b9
        L_0x00b7:
            r10 = move-exception
            r4 = r1
        L_0x00b9:
            if (r4 == 0) goto L_0x00be
            r4.destroy()     // Catch:{ Exception -> 0x00c3 }
        L_0x00be:
            if (r1 == 0) goto L_0x00c3
            r1.close()     // Catch:{ Exception -> 0x00c3 }
        L_0x00c3:
            throw r10
        L_0x00c4:
            r4 = r1
        L_0x00c5:
            if (r4 == 0) goto L_0x00ca
            r4.destroy()     // Catch:{ Exception -> 0x00cf }
        L_0x00ca:
            if (r1 == 0) goto L_0x00cf
            r1.close()     // Catch:{ Exception -> 0x00cf }
        L_0x00cf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.m2.a(java.util.HashMap):boolean");
    }
}
