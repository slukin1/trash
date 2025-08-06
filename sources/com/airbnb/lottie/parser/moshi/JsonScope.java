package com.airbnb.lottie.parser.moshi;

final class JsonScope {
    public static final int CLOSED = 8;
    public static final int DANGLING_NAME = 4;
    public static final int EMPTY_ARRAY = 1;
    public static final int EMPTY_DOCUMENT = 6;
    public static final int EMPTY_OBJECT = 3;
    public static final int NONEMPTY_ARRAY = 2;
    public static final int NONEMPTY_DOCUMENT = 7;
    public static final int NONEMPTY_OBJECT = 5;

    private JsonScope() {
    }

    public static String getPath(int i11, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(DecodedChar.FNC1);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = iArr[i12];
            if (i13 == 1 || i13 == 2) {
                sb2.append('[');
                sb2.append(iArr2[i12]);
                sb2.append(']');
            } else if (i13 == 3 || i13 == 4 || i13 == 5) {
                sb2.append('.');
                if (strArr[i12] != null) {
                    sb2.append(strArr[i12]);
                }
            }
        }
        return sb2.toString();
    }
}
