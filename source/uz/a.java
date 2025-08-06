package uz;

import java.io.IOException;

public abstract class a {
    public static void a(Appendable appendable, char c11) {
        try {
            appendable.append(c11);
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static void b(Appendable appendable, CharSequence charSequence) {
        try {
            appendable.append(charSequence);
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
