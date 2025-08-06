package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Objects;

public class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final BigInteger f58928a;

    /* renamed from: b  reason: collision with root package name */
    public static final BigInteger f58929b;

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f58930c;

    /* renamed from: d  reason: collision with root package name */
    public static final BigInteger f58931d;

    /* renamed from: e  reason: collision with root package name */
    public static final BigInteger f58932e;

    /* renamed from: f  reason: collision with root package name */
    public static final BigInteger f58933f;

    /* renamed from: g  reason: collision with root package name */
    public static final BigInteger f58934g;

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f58935h;

    /* renamed from: i  reason: collision with root package name */
    public static final File[] f58936i = new File[0];

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        f58928a = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        f58929b = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        f58930c = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        f58931d = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        f58932e = multiply4;
        f58933f = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
        f58934g = multiply5;
        f58935h = valueOf.multiply(multiply5);
    }

    public static void a(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static boolean b(File file, long j11) {
        if (file == null) {
            throw new IllegalArgumentException("No specified file");
        } else if (file.exists() && file.lastModified() > j11) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean c(File file) throws IOException {
        Objects.requireNonNull(file, "File must not be null");
        return Files.isSymbolicLink(file.toPath());
    }

    public static long d(File file) {
        if (file.isDirectory()) {
            return f(file);
        }
        return file.length();
    }

    public static long e(File file) {
        a(file);
        return f(file);
    }

    public static long f(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        long j11 = 0;
        for (File file2 : listFiles) {
            try {
                if (!c(file2)) {
                    j11 += d(file2);
                    if (j11 < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return j11;
    }
}
