package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Strings;

public class Base32 {
    private static final Encoder encoder = new Base32Encoder();

    public static int decode(String str, OutputStream outputStream) throws IOException {
        return encoder.decode(str, outputStream);
    }

    public static int decode(byte[] bArr, int i11, int i12, OutputStream outputStream) {
        try {
            return encoder.decode(bArr, i11, i12, outputStream);
        } catch (Exception e11) {
            throw new DecoderException("unable to decode base32 data: " + e11.getMessage(), e11);
        }
    }

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 8) * 5);
        try {
            encoder.decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e11) {
            throw new DecoderException("unable to decode base32 string: " + e11.getMessage(), e11);
        }
    }

    public static byte[] decode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((bArr.length / 8) * 5);
        try {
            encoder.decode(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e11) {
            throw new DecoderException("unable to decode base32 data: " + e11.getMessage(), e11);
        }
    }

    public static int encode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException {
        return encoder.encode(bArr, i11, i12, outputStream);
    }

    public static int encode(byte[] bArr, OutputStream outputStream) throws IOException {
        return encoder.encode(bArr, 0, bArr.length, outputStream);
    }

    public static byte[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static byte[] encode(byte[] bArr, int i11, int i12) {
        Encoder encoder2 = encoder;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(encoder2.getEncodedLength(i12));
        try {
            encoder2.encode(bArr, i11, i12, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e11) {
            throw new EncoderException("exception encoding base32 string: " + e11.getMessage(), e11);
        }
    }

    public static String toBase32String(byte[] bArr) {
        return toBase32String(bArr, 0, bArr.length);
    }

    public static String toBase32String(byte[] bArr, int i11, int i12) {
        return Strings.fromByteArray(encode(bArr, i11, i12));
    }
}
