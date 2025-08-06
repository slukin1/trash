package s10;

public class b {
    public static boolean a(char c11) {
        return Character.isJavaIdentifierPart(c11);
    }

    public static boolean b(char c11) {
        return a(c11) || c11 == ' ' || c11 == '?' || c11 == '@';
    }

    public static void c(String str) throws IllegalArgumentException {
        if (str != null) {
            int i11 = 0;
            if (str.length() == 1) {
                char charAt = str.charAt(0);
                if (!b(charAt)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("illegal option value '");
                    stringBuffer.append(charAt);
                    stringBuffer.append("'");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                return;
            }
            char[] charArray = str.toCharArray();
            while (i11 < charArray.length) {
                if (a(charArray[i11])) {
                    i11++;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("opt contains illegal character value '");
                    stringBuffer2.append(charArray[i11]);
                    stringBuffer2.append("'");
                    throw new IllegalArgumentException(stringBuffer2.toString());
                }
            }
        }
    }
}
