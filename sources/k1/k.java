package k1;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

public class k implements Spannable {

    /* renamed from: b  reason: collision with root package name */
    public boolean f16034b = false;

    /* renamed from: c  reason: collision with root package name */
    public Spannable f16035c;

    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    public static class b {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof z0.c;
        }
    }

    public static class c extends b {
        public boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof z0.c);
        }
    }

    public k(Spannable spannable) {
        this.f16035c = spannable;
    }

    public static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    public final void a() {
        Spannable spannable = this.f16035c;
        if (!this.f16034b && c().a(spannable)) {
            this.f16035c = new SpannableString(spannable);
        }
        this.f16034b = true;
    }

    public Spannable b() {
        return this.f16035c;
    }

    public char charAt(int i11) {
        return this.f16035c.charAt(i11);
    }

    public IntStream chars() {
        return a.a(this.f16035c);
    }

    public IntStream codePoints() {
        return a.b(this.f16035c);
    }

    public int getSpanEnd(Object obj) {
        return this.f16035c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f16035c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f16035c.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i11, int i12, Class<T> cls) {
        return this.f16035c.getSpans(i11, i12, cls);
    }

    public int length() {
        return this.f16035c.length();
    }

    public int nextSpanTransition(int i11, int i12, Class cls) {
        return this.f16035c.nextSpanTransition(i11, i12, cls);
    }

    public void removeSpan(Object obj) {
        a();
        this.f16035c.removeSpan(obj);
    }

    public void setSpan(Object obj, int i11, int i12, int i13) {
        a();
        this.f16035c.setSpan(obj, i11, i12, i13);
    }

    public CharSequence subSequence(int i11, int i12) {
        return this.f16035c.subSequence(i11, i12);
    }

    public String toString() {
        return this.f16035c.toString();
    }

    public k(CharSequence charSequence) {
        this.f16035c = new SpannableString(charSequence);
    }
}
