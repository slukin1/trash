package com.huawei.hms.hatool;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

public final class k1 {
    public static String a(File file) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                h hVar = new h(1024);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    hVar.a(bArr, read);
                }
                if (hVar.b() == 0) {
                    a((Closeable) fileInputStream2);
                    return "";
                }
                String str = new String(hVar.a(), "UTF-8");
                a((Closeable) fileInputStream2);
                return str;
            } catch (FileNotFoundException unused) {
                fileInputStream = fileInputStream2;
                v.f("hmsSdk", "getInfoFromFile(): No files need to be read");
                a((Closeable) fileInputStream);
                return "";
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                try {
                    v.f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
                    a((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            v.f("hmsSdk", "getInfoFromFile(): No files need to be read");
            a((Closeable) fileInputStream);
            return "";
        } catch (IOException unused4) {
            v.f("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
            a((Closeable) fileInputStream);
            return "";
        }
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            a((Closeable) byteArrayOutputStream);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                v.f("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    public static void a(File file, String str) {
        FileOutputStream fileOutputStream;
        String str2;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
            } catch (FileNotFoundException unused) {
                fileOutputStream2 = fileOutputStream;
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                str2 = "saveInfoToFile(): io exc from write info to file!";
                fileOutputStream = fileOutputStream2;
                try {
                    v.f("hmsSdk", str2);
                    a((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    a((Closeable) fileOutputStream);
                    throw th2;
                }
            }
        } catch (FileNotFoundException unused3) {
            str2 = "saveInfoToFile(): No files need to be read";
            fileOutputStream = fileOutputStream2;
            v.f("hmsSdk", str2);
            a((Closeable) fileOutputStream);
        } catch (IOException unused4) {
            str2 = "saveInfoToFile(): io exc from write info to file!";
            fileOutputStream = fileOutputStream2;
            v.f("hmsSdk", str2);
            a((Closeable) fileOutputStream);
        }
        a((Closeable) fileOutputStream);
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                v.f("hmsSdk", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            v.f("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        v.a("hmsSdk", " connHttp disconnect");
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        a((OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
