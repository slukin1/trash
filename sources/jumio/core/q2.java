package jumio.core;

public final class q2 {
    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) (Character.digit(str.charAt(i12 + 1), 16) + (Character.digit(str.charAt(i12), 16) << 4));
        }
        return bArr;
    }
}
