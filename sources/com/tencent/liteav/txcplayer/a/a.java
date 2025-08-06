package com.tencent.liteav.txcplayer.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.liteav.base.util.LiteavLog;
import java.net.URLDecoder;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x002c
            r0 = 63
            int r0 = r3.indexOf(r0)
            if (r0 <= 0) goto L_0x0015
            r2 = 0
            java.lang.String r3 = r3.substring(r2, r0)
        L_0x0015:
            r0 = 46
            int r0 = r3.lastIndexOf(r0)
            if (r0 < 0) goto L_0x002c
            int r2 = r3.length()
            int r2 = r2 + -1
            if (r0 >= r2) goto L_0x002c
            int r0 = r0 + 1
            java.lang.String r3 = r3.substring(r0)
            goto L_0x002d
        L_0x002c:
            r3 = r1
        L_0x002d:
            java.lang.String r0 = "/"
            boolean r0 = r3.contains(r0)
            if (r0 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r1 = r3
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcplayer.a.a.a(java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r5) {
        /*
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ Exception -> 0x0039 }
            byte[] r1 = r5.getBytes()     // Catch:{ Exception -> 0x0039 }
            r0.update(r1)     // Catch:{ Exception -> 0x0039 }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x0039 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = ""
            r1.<init>(r2)     // Catch:{ Exception -> 0x0039 }
            r2 = 0
        L_0x0019:
            int r3 = r0.length     // Catch:{ Exception -> 0x0039 }
            if (r2 >= r3) goto L_0x0035
            byte r3 = r0[r2]     // Catch:{ Exception -> 0x0039 }
            if (r3 >= 0) goto L_0x0022
            int r3 = r3 + 256
        L_0x0022:
            r4 = 16
            if (r3 >= r4) goto L_0x002b
            java.lang.String r4 = "0"
            r1.append(r4)     // Catch:{ Exception -> 0x0039 }
        L_0x002b:
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ Exception -> 0x0039 }
            r1.append(r3)     // Catch:{ Exception -> 0x0039 }
            int r2 = r2 + 1
            goto L_0x0019
        L_0x0035:
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcplayer.a.a.b(java.lang.String):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r8) {
        /*
            java.lang.String r0 = "CommonUtil"
            boolean r1 = f(r8)     // Catch:{ Exception -> 0x0082 }
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = "URL has been encoded"
            com.tencent.liteav.base.util.LiteavLog.w(r0, r1)     // Catch:{ Exception -> 0x0082 }
            return r8
        L_0x000e:
            java.lang.String r1 = "UTF-8"
            byte[] r1 = r8.getBytes(r1)     // Catch:{ Exception -> 0x0082 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0082 }
            int r3 = r1.length     // Catch:{ Exception -> 0x0082 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0082 }
            r3 = 0
            r4 = r3
        L_0x001c:
            int r5 = r1.length     // Catch:{ Exception -> 0x0082 }
            if (r4 >= r5) goto L_0x007d
            byte r5 = r1[r4]     // Catch:{ Exception -> 0x0082 }
            if (r5 >= 0) goto L_0x0028
            byte r5 = r1[r4]     // Catch:{ Exception -> 0x0082 }
            int r5 = r5 + 256
            goto L_0x002a
        L_0x0028:
            byte r5 = r1[r4]     // Catch:{ Exception -> 0x0082 }
        L_0x002a:
            r6 = 32
            if (r5 <= r6) goto L_0x0068
            r6 = 127(0x7f, float:1.78E-43)
            if (r5 >= r6) goto L_0x0068
            r6 = 34
            if (r5 == r6) goto L_0x0068
            r6 = 37
            if (r5 == r6) goto L_0x0068
            r6 = 60
            if (r5 == r6) goto L_0x0068
            r6 = 62
            if (r5 == r6) goto L_0x0068
            r6 = 91
            if (r5 == r6) goto L_0x0068
            r6 = 125(0x7d, float:1.75E-43)
            if (r5 == r6) goto L_0x0068
            r6 = 92
            if (r5 == r6) goto L_0x0068
            r6 = 93
            if (r5 == r6) goto L_0x0068
            r6 = 94
            if (r5 == r6) goto L_0x0068
            r6 = 96
            if (r5 == r6) goto L_0x0068
            r6 = 123(0x7b, float:1.72E-43)
            if (r5 == r6) goto L_0x0068
            r6 = 124(0x7c, float:1.74E-43)
            if (r5 != r6) goto L_0x0063
            goto L_0x0068
        L_0x0063:
            char r5 = (char) r5     // Catch:{ Exception -> 0x0082 }
            r2.append(r5)     // Catch:{ Exception -> 0x0082 }
            goto L_0x007a
        L_0x0068:
            java.lang.String r6 = "%%%02X"
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0082 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0082 }
            r7[r3] = r5     // Catch:{ Exception -> 0x0082 }
            java.lang.String r5 = java.lang.String.format(r6, r7)     // Catch:{ Exception -> 0x0082 }
            r2.append(r5)     // Catch:{ Exception -> 0x0082 }
        L_0x007a:
            int r4 = r4 + 1
            goto L_0x001c
        L_0x007d:
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x0082 }
            goto L_0x0088
        L_0x0082:
            r1 = move-exception
            java.lang.String r2 = "tryEncodeUrl failed."
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r0, (java.lang.String) r2, (java.lang.Throwable) r1)
        L_0x0088:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcplayer.a.a.c(java.lang.String):java.lang.String");
    }

    public static String d(String str) {
        String b11 = b(str);
        String a11 = a(str);
        if (TextUtils.isEmpty(a11)) {
            return b11 + ".auto";
        } else if (a11.toLowerCase().endsWith("m3u8")) {
            return b11 + ".hls";
        } else {
            if (a11.toLowerCase().endsWith("mp4")) {
                b11 = b(g(str));
            }
            return b11 + InstructionFileId.DOT + a11;
        }
    }

    public static String e(String str) {
        return new String(Base64.decode(str, 0));
    }

    private static boolean f(String str) {
        if (str == null) {
            return true;
        }
        try {
            return !str.replace("+", " ").equals(URLDecoder.decode(str, "UTF-8").replace("+", " "));
        } catch (Exception e11) {
            LiteavLog.e("CommonUtil", "isUrlEncoded error : ", (Throwable) e11);
            return false;
        }
    }

    private static String g(String str) {
        int indexOf;
        int indexOf2 = str.indexOf("voddrm.token.");
        if (indexOf2 >= 0 && (indexOf = str.indexOf(InstructionFileId.DOT, indexOf2 + 13)) >= 0 && indexOf < str.length() - 1) {
            str = str.substring(0, indexOf2) + str.substring(indexOf + 1);
        }
        int indexOf3 = str.indexOf("?");
        return indexOf3 >= 0 ? str.substring(0, indexOf3) : str;
    }

    public static String a(String str, String str2) {
        String path;
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2) || (path = Uri.parse(str).getPath()) == null) {
            return str;
        }
        String[] split = path.split("/");
        if (split.length <= 0 || (lastIndexOf = str.lastIndexOf(split[split.length - 1])) <= 0) {
            return str;
        }
        return str.substring(0, lastIndexOf) + "voddrm.token." + str2 + InstructionFileId.DOT + str.substring(lastIndexOf);
    }

    public static String a(String str, String str2, String str3, int i11) {
        String str4;
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        if (TextUtils.isEmpty(query)) {
            str4 = "";
        } else {
            str4 = query + ContainerUtils.FIELD_DELIMITER;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = ChainInfo.CHAIN_TYPE_PLAIN;
        }
        return Uri.decode(parse.buildUpon().query(str4 + "spfileid=" + str2 + "&spdrmtype=" + str3 + "&spappid=" + i11).build().toString());
    }
}
