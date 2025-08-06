package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.emoji2.text.EmojiCompat;
import t0.e;

public class a implements EmojiCompat.d {

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f9420b = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f9421a;

    public a() {
        TextPaint textPaint = new TextPaint();
        this.f9421a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f9420b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    public boolean a(CharSequence charSequence, int i11, int i12, int i13) {
        int i14 = Build.VERSION.SDK_INT;
        if (i14 < 23 && i13 > i14) {
            return false;
        }
        StringBuilder b11 = b();
        b11.setLength(0);
        while (i11 < i12) {
            b11.append(charSequence.charAt(i11));
            i11++;
        }
        return e.a(this.f9421a, b11.toString());
    }
}
