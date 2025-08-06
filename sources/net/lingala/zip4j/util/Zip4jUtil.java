package net.lingala.zip4j.util;

import com.twitter.sdk.android.core.internal.network.UrlUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import net.lingala.zip4j.exception.ZipException;

public class Zip4jUtil {
    public static boolean a(File file) throws ZipException {
        if (file != null) {
            return file.exists();
        }
        throw new ZipException("cannot check if file exists: input file is null");
    }

    public static boolean b(String str) throws ZipException {
        if (h(str)) {
            return a(new File(str));
        }
        throw new ZipException("path is null");
    }

    public static boolean c(String str) throws ZipException {
        if (!h(str)) {
            throw new ZipException("path is null");
        } else if (b(str)) {
            try {
                return new File(str).canRead();
            } catch (Exception unused) {
                throw new ZipException("cannot read zip file");
            }
        } else {
            throw new ZipException("file does not exist: " + str);
        }
    }

    public static boolean d(String str) throws ZipException {
        if (h(str)) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                    if (!file.isDirectory()) {
                        throw new ZipException("output folder is not valid");
                    } else if (file.canWrite()) {
                        return true;
                    } else {
                        throw new ZipException("no write access to destination folder");
                    }
                } catch (Exception unused) {
                    throw new ZipException("Cannot create destination folder");
                }
            } else if (!file.isDirectory()) {
                throw new ZipException("output folder is not valid");
            } else if (file.canWrite()) {
                return true;
            } else {
                throw new ZipException("no write access to output folder");
            }
        } else {
            throw new ZipException((Throwable) new NullPointerException("output path is null"));
        }
    }

    public static String e(byte[] bArr, boolean z11) {
        if (!z11) {
            return g(bArr);
        }
        try {
            return new String(bArr, UrlUtils.UTF8);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static long f(int i11) {
        int i12 = (i11 & 31) * 2;
        int i13 = (i11 >> 5) & 63;
        int i14 = (i11 >> 11) & 31;
        int i15 = (i11 >> 16) & 31;
        int i16 = ((i11 >> 25) & 127) + 1980;
        Calendar instance = Calendar.getInstance();
        instance.set(i16, ((i11 >> 21) & 15) - 1, i15, i14, i13, i12);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static String g(byte[] bArr) {
        try {
            return new String(bArr, "Cp850");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static boolean h(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean i(String str) throws ZipException {
        if (h(str)) {
            try {
                new String("a".getBytes(), str);
                return true;
            } catch (UnsupportedEncodingException unused) {
                return false;
            } catch (Exception e11) {
                throw new ZipException((Throwable) e11);
            }
        } else {
            throw new ZipException("charset is null or empty, cannot check if it is supported");
        }
    }

    public static void j(File file) throws ZipException {
    }

    public static void k(File file) throws ZipException {
    }

    public static void l(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("input file is null. cannot set read only file attribute");
        } else if (file.exists()) {
            file.setReadOnly();
        }
    }

    public static void m(File file) throws ZipException {
    }
}
