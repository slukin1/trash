package vy;

public class d {
    public static byte[] a(int i11) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i11 % 256);
        int i12 = i11 >> 8;
        bArr[2] = (byte) (i12 % 256);
        int i13 = i12 >> 8;
        bArr[1] = (byte) (i13 % 256);
        bArr[0] = (byte) ((i13 >> 8) % 256);
        return bArr;
    }
}
