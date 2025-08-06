package d00;

import android.text.Spanned;

public abstract class c {
    public static boolean a(int i11, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(obj) == i11;
    }

    public static boolean b(int i11, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(obj) == i11;
    }
}
