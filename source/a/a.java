package a;

import org.opencv.core.CvType;

public class a {
    public static String a(int i11, StringBuilder sb2, String str) {
        sb2.append(CvType.channels(i11));
        sb2.append(str);
        return sb2.toString();
    }

    public static String b(String str, int i11) {
        return str + i11;
    }

    public static StringBuilder c(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        return sb2;
    }
}
