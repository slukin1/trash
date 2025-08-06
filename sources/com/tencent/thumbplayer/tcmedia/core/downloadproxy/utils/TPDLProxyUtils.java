package com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TPDLProxyUtils {
    private static final String FILE_NAME = "TPDLProxyUtils";

    public static String byteArrayToString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "byteArrayToString failed, error:" + th2.toString());
            return "";
        }
    }

    public static String losePackageCheck(int i11) {
        String str;
        String str2 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ping -c " + i11 + " www.qq.com").getInputStream()));
            str = str2;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.contains(" packet loss")) {
                        str2 = readLine.substring(10 + readLine.indexOf("received, "), readLine.indexOf("%") + 1);
                    }
                    if (readLine.contains("avg")) {
                        int indexOf = readLine.indexOf("/", 20);
                        str = readLine.substring(indexOf + 1, readLine.indexOf(InstructionFileId.DOT, indexOf));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    return str2 + ";" + str;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str = str2;
            th.printStackTrace();
            return str2 + ";" + str;
        }
        return str2 + ";" + str;
    }

    public static int objectToInt(Object obj, int i11) {
        if (obj == null) {
            return i11;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "object to int failed, error:" + th2.toString());
            return i11;
        }
    }

    public static long objectToLong(Object obj, long j11) {
        if (obj == null) {
            return j11;
        }
        try {
            return ((Long) obj).longValue();
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "object to long failed, error:" + th2.toString());
            return j11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c A[SYNTHETIC, Splitter:B:24:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String serialize(java.lang.Object r9) {
        /*
            java.lang.String r0 = "obj serialize to string byteArrayOutputStream close, error:"
            java.lang.String r1 = "obj serialize to string  objectOutputStream close, error:"
            java.lang.String r2 = "tpdlnative"
            java.lang.String r3 = "TPDLProxyUtils"
            r4 = 0
            r5 = 0
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0053 }
            r6.<init>()     // Catch:{ all -> 0x0053 }
            java.io.ObjectOutputStream r7 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0051 }
            r7.<init>(r6)     // Catch:{ all -> 0x0051 }
            r7.writeObject(r9)     // Catch:{ all -> 0x004e }
            java.lang.String r9 = "ISO-8859-1"
            java.lang.String r9 = r6.toString(r9)     // Catch:{ all -> 0x004e }
            r7.close()     // Catch:{ all -> 0x0021 }
            goto L_0x0035
        L_0x0021:
            r4 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r1)
            java.lang.String r1 = r4.toString()
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r1)
        L_0x0035:
            r6.close()     // Catch:{ all -> 0x0039 }
            goto L_0x004d
        L_0x0039:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = r1.toString()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r0)
        L_0x004d:
            return r9
        L_0x004e:
            r9 = move-exception
            r4 = r7
            goto L_0x0055
        L_0x0051:
            r9 = move-exception
            goto L_0x0055
        L_0x0053:
            r9 = move-exception
            r6 = r4
        L_0x0055:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            java.lang.String r8 = "serialize obj, error:"
            r7.<init>(r8)     // Catch:{ all -> 0x009f }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x009f }
            r7.append(r9)     // Catch:{ all -> 0x009f }
            java.lang.String r9 = r7.toString()     // Catch:{ all -> 0x009f }
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r9)     // Catch:{ all -> 0x009f }
            if (r4 == 0) goto L_0x0084
            r4.close()     // Catch:{ all -> 0x0070 }
            goto L_0x0084
        L_0x0070:
            r9 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r9 = r9.toString()
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r9)
        L_0x0084:
            r6.close()     // Catch:{ all -> 0x0088 }
            goto L_0x009c
        L_0x0088:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r9 = r9.toString()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r9)
        L_0x009c:
            java.lang.String r9 = ""
            return r9
        L_0x009f:
            r9 = move-exception
            if (r4 == 0) goto L_0x00ba
            r4.close()     // Catch:{ all -> 0x00a6 }
            goto L_0x00ba
        L_0x00a6:
            r4 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r1)
            java.lang.String r1 = r4.toString()
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r1)
        L_0x00ba:
            r6.close()     // Catch:{ all -> 0x00be }
            goto L_0x00d2
        L_0x00be:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = r1.toString()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r0)
        L_0x00d2:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyUtils.serialize(java.lang.Object):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e A[SYNTHETIC, Splitter:B:24:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088 A[SYNTHETIC, Splitter:B:29:0x0088] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object serializeToObject(java.lang.String r10) {
        /*
            java.lang.String r0 = "serialize to obj byteArrayInputStream close, error:"
            java.lang.String r1 = "serialize to obj objectInputStream close, error:"
            java.lang.String r2 = "tpdlnative"
            java.lang.String r3 = "TPDLProxyUtils"
            r4 = 0
            r5 = 0
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = "ISO-8859-1"
            byte[] r10 = r10.getBytes(r7)     // Catch:{ all -> 0x0054 }
            r6.<init>(r10)     // Catch:{ all -> 0x0054 }
            java.io.ObjectInputStream r10 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0051 }
            r10.<init>(r6)     // Catch:{ all -> 0x0051 }
            java.lang.Object r4 = r10.readObject()     // Catch:{ all -> 0x004f }
            r10.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0036
        L_0x0022:
            r10 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r1)
            java.lang.String r10 = r10.toString()
            r7.append(r10)
            java.lang.String r10 = r7.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r10)
        L_0x0036:
            r6.close()     // Catch:{ all -> 0x003a }
            goto L_0x004e
        L_0x003a:
            r10 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r10 = r10.toString()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r10)
        L_0x004e:
            return r4
        L_0x004f:
            r7 = move-exception
            goto L_0x0057
        L_0x0051:
            r7 = move-exception
            r10 = r4
            goto L_0x0057
        L_0x0054:
            r7 = move-exception
            r10 = r4
            r6 = r10
        L_0x0057:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            java.lang.String r9 = "serialize to obj , error:"
            r8.<init>(r9)     // Catch:{ all -> 0x00a1 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a1 }
            r8.append(r7)     // Catch:{ all -> 0x00a1 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x00a1 }
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r7)     // Catch:{ all -> 0x00a1 }
            if (r10 == 0) goto L_0x0086
            r10.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0086
        L_0x0072:
            r10 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r1)
            java.lang.String r10 = r10.toString()
            r7.append(r10)
            java.lang.String r10 = r7.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r10)
        L_0x0086:
            if (r6 == 0) goto L_0x00a0
            r6.close()     // Catch:{ all -> 0x008c }
            goto L_0x00a0
        L_0x008c:
            r10 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r10 = r10.toString()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r10)
        L_0x00a0:
            return r4
        L_0x00a1:
            r4 = move-exception
            if (r10 == 0) goto L_0x00bc
            r10.close()     // Catch:{ all -> 0x00a8 }
            goto L_0x00bc
        L_0x00a8:
            r10 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r1)
            java.lang.String r10 = r10.toString()
            r7.append(r10)
            java.lang.String r10 = r7.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r10)
        L_0x00bc:
            if (r6 == 0) goto L_0x00d6
            r6.close()     // Catch:{ all -> 0x00c2 }
            goto L_0x00d6
        L_0x00c2:
            r10 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r10 = r10.toString()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog.e(r3, r5, r2, r10)
        L_0x00d6:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyUtils.serializeToObject(java.lang.String):java.lang.Object");
    }
}
