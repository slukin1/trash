package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.h;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class EditorInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f8649a = new String[0];

    public static class a {
        public static void a(EditorInfo editorInfo, CharSequence charSequence, int i11) {
            editorInfo.setInitialSurroundingSubText(charSequence, i11);
        }
    }

    public static String[] a(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : f8649a;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f8649a;
        }
        String[] stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        return stringArray != null ? stringArray : f8649a;
    }

    public static boolean b(CharSequence charSequence, int i11, int i12) {
        if (i12 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i11));
        }
        if (i12 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i11));
    }

    public static boolean c(int i11) {
        int i12 = i11 & 4095;
        return i12 == 129 || i12 == 225 || i12 == 18;
    }

    public static void d(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static void e(EditorInfo editorInfo, CharSequence charSequence, int i11) {
        h.g(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, i11);
            return;
        }
        int i12 = editorInfo.initialSelStart;
        int i13 = editorInfo.initialSelEnd;
        int i14 = i12 > i13 ? i13 - i11 : i12 - i11;
        int i15 = i12 > i13 ? i12 - i11 : i13 - i11;
        int length = charSequence.length();
        if (i11 < 0 || i14 < 0 || i15 > length) {
            g(editorInfo, (CharSequence) null, 0, 0);
        } else if (c(editorInfo.inputType)) {
            g(editorInfo, (CharSequence) null, 0, 0);
        } else if (length <= 2048) {
            g(editorInfo, charSequence, i14, i15);
        } else {
            h(editorInfo, charSequence, i14, i15);
        }
    }

    public static void f(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, 0);
        } else {
            e(editorInfo, charSequence, 0);
        }
    }

    public static void g(EditorInfo editorInfo, CharSequence charSequence, int i11, int i12) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i11);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i12);
    }

    public static void h(EditorInfo editorInfo, CharSequence charSequence, int i11, int i12) {
        CharSequence charSequence2;
        int i13 = i12 - i11;
        int i14 = i13 > 1024 ? 0 : i13;
        int i15 = 2048 - i14;
        int min = Math.min(charSequence.length() - i12, i15 - Math.min(i11, (int) (((double) i15) * 0.8d)));
        int min2 = Math.min(i11, i15 - min);
        int i16 = i11 - min2;
        if (b(charSequence, i16, 0)) {
            i16++;
            min2--;
        }
        if (b(charSequence, (i12 + min) - 1, 1)) {
            min--;
        }
        int i17 = min2 + i14 + min;
        if (i14 != i13) {
            charSequence2 = TextUtils.concat(new CharSequence[]{charSequence.subSequence(i16, i16 + min2), charSequence.subSequence(i12, min + i12)});
        } else {
            charSequence2 = charSequence.subSequence(i16, i17 + i16);
        }
        int i18 = min2 + 0;
        g(editorInfo, charSequence2, i18, i14 + i18);
    }
}
