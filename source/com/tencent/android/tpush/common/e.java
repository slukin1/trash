package com.tencent.android.tpush.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class e {
    public static String a(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return "";
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th3;
                }
            }
            try {
                objectOutputStream.writeObject(serializable);
                String a11 = a(byteArrayOutputStream.toByteArray());
                objectOutputStream.close();
                byteArrayOutputStream.close();
                return a11;
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream2 = objectOutputStream;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            throw th;
        }
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < str.length(); i11 += 2) {
            char charAt = str.charAt(i11);
            int i12 = i11 / 2;
            if (i12 < length) {
                bArr[i12] = (byte) ((charAt - 'a') << 4);
                bArr[i12] = (byte) (bArr[i12] + (str.charAt(i11 + 1) - 'a'));
            }
        }
        return bArr;
    }

    public static Object a(String str) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th2;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(b(str));
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Throwable th3) {
                th2 = th3;
                objectInputStream = null;
                try {
                    throw th2;
                } catch (Throwable th4) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th4;
                }
            }
            try {
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th5) {
                th2 = th5;
                throw th2;
            }
        } catch (Throwable th6) {
            byteArrayInputStream = null;
            th2 = th6;
            objectInputStream = null;
            throw th2;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < bArr.length; i11++) {
            stringBuffer.append((char) (((bArr[i11] >> 4) & 15) + 97));
            stringBuffer.append((char) ((bArr[i11] & 15) + 97));
        }
        return stringBuffer.toString();
    }
}
