package com.qihoo.stat;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import net.sf.scuba.smartcards.ISO7816;

public class b0 {
    public static byte[] a(byte[] bArr) {
        Deflater deflater = new Deflater();
        deflater.setLevel(9);
        deflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        deflater.finish();
        byte[] bArr2 = new byte[2048];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray[0] = (byte) (byteArray[0] ^ ISO7816.INS_CHANGE_CHV);
        byteArray[byteArray.length / 2] = (byte) (byteArray[byteArray.length / 2] ^ 17);
        byteArrayOutputStream.close();
        return byteArray;
    }
}
