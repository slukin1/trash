package com.huobi.woodpecker.kalle.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class IOUtils {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static BufferedOutputStream b(OutputStream outputStream) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    public static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        j(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] d(CharSequence charSequence, Charset charset) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes(charset);
    }

    public static String e(InputStream inputStream) throws IOException {
        return new String(c(inputStream));
    }

    public static String f(InputStream inputStream, String str) throws IOException {
        return new String(c(inputStream), str);
    }

    public static String g(byte[] bArr) {
        return new String(bArr);
    }

    public static String h(byte[] bArr, String str) {
        return i(bArr, Charset.forName(str));
    }

    public static String i(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    public static void j(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                outputStream.flush();
            } else {
                return;
            }
        }
    }

    public static void k(OutputStream outputStream, CharSequence charSequence, Charset charset) throws IOException {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes(charset));
            outputStream.flush();
        }
    }
}
