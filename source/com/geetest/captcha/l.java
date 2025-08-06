package com.geetest.captcha;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final char f65233a = File.separatorChar;

    /* renamed from: b  reason: collision with root package name */
    public static String f65234b;

    static {
        try {
            StringWriter stringWriter = new StringWriter(4);
            new PrintWriter(stringWriter).println();
            f65234b = stringWriter.toString();
        } catch (Exception unused) {
        }
    }

    private static String a(InputStream inputStream, Charset charset) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            a((Reader) new InputStreamReader(inputStream, charset), (Writer) stringWriter);
            return stringWriter.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static long b(Reader reader, Writer writer) throws IOException {
        return a(reader, writer, new char[4096]);
    }

    public static String a(InputStream inputStream, String str) throws IOException {
        return a(inputStream, Charset.forName(str));
    }

    public static String a(Reader reader) {
        try {
            StringWriter stringWriter = new StringWriter();
            a(reader, (Writer) stringWriter);
            return stringWriter.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(byte[] bArr, String str) throws IOException {
        return new String(bArr, Charset.forName(str));
    }

    public static void a(String str, Writer writer) throws IOException {
        if (str != null) {
            writer.write(str);
        }
    }

    private static int a(Reader reader, Writer writer) throws IOException {
        long b11 = b(reader, writer);
        if (b11 > 2147483647L) {
            return -1;
        }
        return (int) b11;
    }

    private static long a(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j11 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j11;
            }
            writer.write(cArr, 0, read);
            j11 += (long) read;
        }
    }
}
