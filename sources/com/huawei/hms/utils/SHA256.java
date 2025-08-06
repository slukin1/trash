package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SHA256 {
    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e11) {
            HMSLog.e("SHA256", "NoSuchAlgorithmException" + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] digest(File file) {
        BufferedInputStream bufferedInputStream = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] bArr = new byte[4096];
                int i11 = 0;
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    i11 += read;
                    instance.update(bArr, 0, read);
                }
                if (i11 > 0) {
                    byte[] digest = instance.digest();
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    return digest;
                }
                IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                return new byte[0];
            } catch (IOException | NoSuchAlgorithmException unused) {
                bufferedInputStream = bufferedInputStream2;
                try {
                    HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    return new byte[0];
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                throw th;
            }
        } catch (IOException | NoSuchAlgorithmException unused2) {
            HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
            IOUtils.closeQuietly((InputStream) bufferedInputStream);
            return new byte[0];
        }
    }
}
