package z0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;

@SuppressLint({"InlinedApi"})
public final class a {

    /* renamed from: z0.a$a  reason: collision with other inner class name */
    public static class C0115a {
        public static Spanned a(String str, int i11) {
            return Html.fromHtml(str, i11);
        }

        public static Spanned b(String str, int i11, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i11, imageGetter, tagHandler);
        }

        public static String c(Spanned spanned, int i11) {
            return Html.toHtml(spanned, i11);
        }
    }

    public static Spanned a(String str, int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            return C0115a.a(str, i11);
        }
        return Html.fromHtml(str);
    }
}
