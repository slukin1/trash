package uz;

public abstract class d {

    public static class a extends d {
        public <T extends Appendable & CharSequence> void a(T t11, String str) {
            int length;
            CharSequence charSequence = (CharSequence) t11;
            int length2 = charSequence.length();
            int length3 = str.length();
            boolean z11 = false;
            for (int i11 = 0; i11 < length3; i11++) {
                char charAt = str.charAt(i11);
                if (Character.isWhitespace(charAt)) {
                    z11 = true;
                } else {
                    if (z11 && (length = charSequence.length()) > 0 && !Character.isWhitespace(charSequence.charAt(length - 1))) {
                        a.a(t11, ' ');
                    }
                    a.a(t11, charAt);
                    z11 = false;
                }
            }
            if (z11 && length2 < charSequence.length()) {
                a.a(t11, ' ');
            }
        }
    }

    public static d b() {
        return new a();
    }

    public abstract <T extends Appendable & CharSequence> void a(T t11, String str);
}
