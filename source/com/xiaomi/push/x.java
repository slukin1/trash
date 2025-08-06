package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f52620a = {"jpg", "png", "bmp", "gif", "webp"};

    public static void a(File file, File file2) {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file, false));
            try {
                a(zipOutputStream2, file2, (String) null, (FileFilter) null);
                a((Closeable) zipOutputStream2);
            } catch (FileNotFoundException unused) {
                zipOutputStream = zipOutputStream2;
                a((Closeable) zipOutputStream);
            } catch (IOException e11) {
                e = e11;
                zipOutputStream = zipOutputStream2;
                try {
                    b.a("zip file failure + " + e.getMessage());
                    a((Closeable) zipOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = zipOutputStream2;
                a((Closeable) zipOutputStream);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            a((Closeable) zipOutputStream);
        } catch (IOException e12) {
            e = e12;
            b.a("zip file failure + " + e.getMessage());
            a((Closeable) zipOutputStream);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.io.File r3, java.io.File r4) {
        /*
            java.lang.String r0 = r3.getAbsolutePath()
            java.lang.String r1 = r4.getAbsolutePath()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000f
            return
        L_0x000f:
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0036 }
            r1.<init>(r3)     // Catch:{ all -> 0x0036 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0032 }
            r3.<init>(r4)     // Catch:{ all -> 0x0032 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0030 }
        L_0x001e:
            int r0 = r1.read(r4)     // Catch:{ all -> 0x0030 }
            if (r0 < 0) goto L_0x0029
            r2 = 0
            r3.write(r4, r2, r0)     // Catch:{ all -> 0x0030 }
            goto L_0x001e
        L_0x0029:
            r1.close()
            r3.close()
            return
        L_0x0030:
            r4 = move-exception
            goto L_0x0034
        L_0x0032:
            r4 = move-exception
            r3 = r0
        L_0x0034:
            r0 = r1
            goto L_0x0038
        L_0x0036:
            r4 = move-exception
            r3 = r0
        L_0x0038:
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            if (r3 == 0) goto L_0x0042
            r3.close()
        L_0x0042:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.x.b(java.io.File, java.io.File):void");
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        File[] fileArr;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        FileInputStream fileInputStream = null;
        try {
            if (file.isDirectory()) {
                if (fileFilter != null) {
                    fileArr = file.listFiles(fileFilter);
                } else {
                    fileArr = file.listFiles();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                String str3 = File.separator;
                sb2.append(str3);
                zipOutputStream.putNextEntry(new ZipEntry(sb2.toString()));
                if (!TextUtils.isEmpty(str)) {
                    str2 = str + str3;
                }
                for (int i11 = 0; i11 < fileArr.length; i11++) {
                    a(zipOutputStream, fileArr[i11], str2 + fileArr[i11].getName(), (FileFilter) null);
                }
                File[] listFiles = file.listFiles(new FileFilter() {
                    public boolean accept(File file) {
                        return file.isDirectory();
                    }
                });
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                    }
                }
            } else {
                if (!TextUtils.isEmpty(str)) {
                    zipOutputStream.putNextEntry(new ZipEntry(str));
                } else {
                    Date date = new Date();
                    zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(date.getTime()) + ".txt"));
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream = fileInputStream2;
                } catch (IOException e11) {
                    e = e11;
                    fileInputStream = fileInputStream2;
                    try {
                        b.d("zipFiction failed with exception:" + e.toString());
                        a((Closeable) fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        a((Closeable) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    a((Closeable) fileInputStream);
                    throw th;
                }
            }
        } catch (IOException e12) {
            e = e12;
            b.d("zipFiction failed with exception:" + e.toString());
            a((Closeable) fileInputStream);
        }
        a((Closeable) fileInputStream);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String a(File file) {
        InputStreamReader inputStreamReader;
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        String stringWriter2 = stringWriter.toString();
                        a((Closeable) inputStreamReader);
                        a((Closeable) stringWriter);
                        return stringWriter2;
                    }
                }
            } catch (IOException e11) {
                e = e11;
                try {
                    b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a((Closeable) inputStreamReader);
                    a((Closeable) stringWriter);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader2 = inputStreamReader;
                    a((Closeable) inputStreamReader2);
                    a((Closeable) stringWriter);
                    throw th;
                }
            }
        } catch (IOException e12) {
            e = e12;
            inputStreamReader = null;
            b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            a((Closeable) inputStreamReader);
            a((Closeable) stringWriter);
            return null;
        } catch (Throwable th3) {
            th = th3;
            a((Closeable) inputStreamReader2);
            a((Closeable) stringWriter);
            throw th;
        }
    }

    public static void a(File file, String str) {
        if (!file.exists()) {
            b.c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                bufferedWriter2.write(str);
                a((Closeable) bufferedWriter2);
            } catch (IOException e11) {
                e = e11;
                bufferedWriter = bufferedWriter2;
                try {
                    b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a((Closeable) bufferedWriter);
                } catch (Throwable th2) {
                    th = th2;
                    a((Closeable) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                a((Closeable) bufferedWriter);
                throw th;
            }
        } catch (IOException e12) {
            e = e12;
            b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
            a((Closeable) bufferedWriter);
        }
    }

    public static byte[] a(InputStream inputStream) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr2, 0, 8192);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            } catch (Exception e11) {
                e11.printStackTrace();
                bArr = null;
            } catch (Throwable th2) {
                a((Closeable) inputStream);
                a((Closeable) byteArrayOutputStream);
                throw th2;
            }
        }
        bArr = byteArrayOutputStream.toByteArray();
        a((Closeable) inputStream);
        a((Closeable) byteArrayOutputStream);
        return bArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3069a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception unused) {
            return bArr;
        }
    }
}
