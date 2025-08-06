package com.tencent.liteav.base.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class f {
    public static File a(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        File file = new File(absolutePath + File.separator + str);
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e11) {
            LiteavLog.e("FileUtil", "mkdirs failed.", (Throwable) e11);
        }
        return file;
    }

    public static long a(File file, int i11) {
        long j11;
        long j12 = 0;
        if (i11 <= 0) {
            return 0;
        }
        try {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    j11 = a(file2, i11 - 1);
                } else {
                    j11 = file2.length();
                }
                j12 += j11;
            }
        } catch (Exception e11) {
            LiteavLog.i("FileUtil", "getFolderSize exception " + e11.toString());
        }
        return j12;
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
