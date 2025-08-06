package com.hbg.lib.common.dynamic.downloader;

import android.util.Log;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huochat.community.util.FileTool;
import i10.b;
import java.io.File;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import jv.a;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class Util {
    public static boolean a() {
        return false;
    }

    public static void b(String str, long j11, String str2) {
        if (a()) {
            Log.e("event", "eventReport() called with: event = [dy_" + str + "], num = [" + j11 + "], tag = [" + str2 + "]");
        }
        a g11 = WoodPeckerSDK.f().g();
        g11.d("dy_" + str, (double) j11, str2);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.io.File r4) {
        /*
            r0 = 0
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0050 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
            r2.<init>(r4)     // Catch:{  }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]
        L_0x0010:
            int r0 = r2.read(r4)     // Catch:{ IOException -> 0x0043 }
            r3 = 0
            if (r0 <= 0) goto L_0x001b
            r1.update(r4, r3, r0)     // Catch:{ IOException -> 0x0043 }
            goto L_0x0010
        L_0x001b:
            byte[] r4 = r1.digest()     // Catch:{ IOException -> 0x0043 }
            java.math.BigInteger r0 = new java.math.BigInteger     // Catch:{ IOException -> 0x0043 }
            r1 = 1
            r0.<init>(r1, r4)     // Catch:{ IOException -> 0x0043 }
            r4 = 16
            java.lang.String r4 = r0.toString(r4)     // Catch:{ IOException -> 0x0043 }
            java.lang.String r0 = "%32s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x0043 }
            r1[r3] = r4     // Catch:{ IOException -> 0x0043 }
            java.lang.String r4 = java.lang.String.format(r0, r1)     // Catch:{ IOException -> 0x0043 }
            r0 = 32
            r1 = 48
            java.lang.String r4 = r4.replace(r0, r1)     // Catch:{ IOException -> 0x0043 }
            r2.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            return r4
        L_0x0041:
            r4 = move-exception
            goto L_0x004c
        L_0x0043:
            r4 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "Unable to process file for MD5"
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0041 }
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x004c:
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            throw r4
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.dynamic.downloader.Util.c(java.io.File):java.lang.String");
    }

    public static String d(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(bArr);
            StringBuilder sb2 = new StringBuilder();
            byte[] digest = instance.digest();
            for (byte b11 : digest) {
                sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static void e(File file, File file2, String str) {
        try {
            b bVar = new b(file);
            bVar.f("utf-8");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (bVar.d()) {
                bVar.g(str.toCharArray());
            }
            bVar.a(file2.getPath());
            List<FileHeader> c11 = bVar.c();
            ArrayList<File> arrayList = new ArrayList<>();
            for (FileHeader fileHeader : c11) {
                if (!fileHeader.q()) {
                    arrayList.add(new File(file2, fileHeader.k()));
                }
            }
            arrayList.toArray(new File[arrayList.size()]);
            for (File absolutePath : arrayList) {
                PrintStream printStream = System.out;
                printStream.println(absolutePath.getAbsolutePath() + "文件解压成功!");
            }
        } catch (ZipException e11) {
            e11.printStackTrace();
        }
    }
}
