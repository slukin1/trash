package com.eclipsesource.v8;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.eclipsesource.v8.PlatformDetector;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;

class LibraryLoader {
    public static final String DELIMITER = System.getProperty("line.separator");
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String SWT_LIB_DIR = ".j2v8";

    public static void chmod(String str, String str2) {
        if (!PlatformDetector.OS.isWindows()) {
            try {
                Runtime.getRuntime().exec(new String[]{"chmod", str, str2}).waitFor();
            } catch (Throwable unused) {
            }
        }
    }

    public static String computeLibraryFullName(boolean z11) {
        return "lib" + computeLibraryShortName(z11) + InstructionFileId.DOT + PlatformDetector.OS.getLibFileExtension();
    }

    public static String computeLibraryShortName(boolean z11) {
        String str;
        String name = (!z11 || !PlatformDetector.OS.isLinux()) ? null : PlatformDetector.Vendor.getName();
        String name2 = PlatformDetector.OS.getName();
        String name3 = PlatformDetector.Arch.getName();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("j2v8");
        if (name != null) {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER + name;
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb2.append(name2);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb2.append(name3);
        return sb2.toString();
    }

    public static boolean extract(String str, boolean z11, StringBuffer stringBuffer) {
        String computeLibraryFullName = computeLibraryFullName(z11);
        return extract(str + SEPARATOR + computeLibraryFullName, computeLibraryFullName, stringBuffer);
    }

    public static boolean load(String str, StringBuffer stringBuffer) {
        try {
            if (str.indexOf(SEPARATOR) != -1) {
                System.load(str);
                return true;
            }
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e11) {
            if (stringBuffer.length() == 0) {
                stringBuffer.append(DELIMITER);
            }
            stringBuffer.append(9);
            stringBuffer.append(e11.getMessage());
            stringBuffer.append(DELIMITER);
            return false;
        }
    }

    public static void loadLibrary(String str) {
        if (PlatformDetector.OS.isAndroid()) {
            System.loadLibrary("j2v8");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (!tryLoad(true, stringBuffer) && !tryLoad(false, stringBuffer)) {
            if (str == null) {
                str = System.getProperty("java.io.tmpdir");
            }
            if (!extract(str, true, stringBuffer) && !extract(str, false, stringBuffer)) {
                throw new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + stringBuffer.toString());
            }
        }
    }

    public static boolean tryLoad(boolean z11, StringBuffer stringBuffer) {
        String computeLibraryShortName = computeLibraryShortName(z11);
        String computeLibraryFullName = computeLibraryFullName(z11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.getProperty("user.dir"));
        String str = SEPARATOR;
        sb2.append(str);
        sb2.append("jni");
        sb2.append(str);
        sb2.append(computeLibraryFullName);
        String sb3 = sb2.toString();
        if (load(computeLibraryFullName, stringBuffer) || load(computeLibraryShortName, stringBuffer)) {
            return true;
        }
        if (!new File(sb3).exists() || !load(sb3, stringBuffer)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A[SYNTHETIC, Splitter:B:23:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[SYNTHETIC, Splitter:B:27:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean extract(java.lang.String r7, java.lang.String r8, java.lang.StringBuffer r9) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r1 = 1
            r2 = 0
            r3 = 0
            boolean r4 = r0.exists()     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0011
            r0.delete()     // Catch:{ all -> 0x0052 }
        L_0x0011:
            java.lang.Class<com.eclipsesource.v8.LibraryLoader> r4 = com.eclipsesource.v8.LibraryLoader.class
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r5.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = "/"
            r5.append(r6)     // Catch:{ all -> 0x0052 }
            r5.append(r8)     // Catch:{ all -> 0x0052 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0052 }
            java.io.InputStream r8 = r4.getResourceAsStream(r8)     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x0069
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0054 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0054 }
            r5.<init>(r7)     // Catch:{ all -> 0x0054 }
        L_0x0033:
            int r2 = r8.read(r4)     // Catch:{ all -> 0x0050 }
            r6 = -1
            if (r2 == r6) goto L_0x003e
            r5.write(r4, r3, r2)     // Catch:{ all -> 0x0050 }
            goto L_0x0033
        L_0x003e:
            r5.close()     // Catch:{ all -> 0x0050 }
            r8.close()     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "755"
            chmod(r2, r7)     // Catch:{ all -> 0x0050 }
            boolean r7 = load(r7, r9)     // Catch:{ all -> 0x0050 }
            if (r7 == 0) goto L_0x0069
            return r1
        L_0x0050:
            r2 = r5
            goto L_0x0054
        L_0x0052:
            r8 = r2
            r1 = r3
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            if (r8 == 0) goto L_0x005e
            r8.close()     // Catch:{ IOException -> 0x005e }
        L_0x005e:
            if (r1 == 0) goto L_0x0069
            boolean r7 = r0.exists()
            if (r7 == 0) goto L_0x0069
            r0.delete()
        L_0x0069:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.LibraryLoader.extract(java.lang.String, java.lang.String, java.lang.StringBuffer):boolean");
    }
}
