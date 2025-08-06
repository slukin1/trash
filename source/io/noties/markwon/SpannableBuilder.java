package io.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class SpannableBuilder implements Appendable, CharSequence {

    /* renamed from: b  reason: collision with root package name */
    public final StringBuilder f55259b;

    /* renamed from: c  reason: collision with root package name */
    public final Deque<a> f55260c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f55261a;

        /* renamed from: b  reason: collision with root package name */
        public int f55262b;

        /* renamed from: c  reason: collision with root package name */
        public int f55263c;

        /* renamed from: d  reason: collision with root package name */
        public final int f55264d;

        public a(Object obj, int i11, int i12, int i13) {
            this.f55261a = obj;
            this.f55262b = i11;
            this.f55263c = i12;
            this.f55264d = i13;
        }
    }

    public static class b extends SpannableStringBuilder {
        public b(CharSequence charSequence) {
            super(charSequence);
        }
    }

    public SpannableBuilder() {
        this("");
    }

    public static boolean g(int i11, int i12, int i13) {
        return i13 > i12 && i12 >= 0 && i13 <= i11;
    }

    public static void j(SpannableBuilder spannableBuilder, Object obj, int i11, int i12) {
        if (obj != null && g(spannableBuilder.length(), i11, i12)) {
            k(spannableBuilder, obj, i11, i12);
        }
    }

    public static void k(SpannableBuilder spannableBuilder, Object obj, int i11, int i12) {
        if (obj == null) {
            return;
        }
        if (obj.getClass().isArray()) {
            for (Object k11 : (Object[]) obj) {
                k(spannableBuilder, k11, i11, i12);
            }
            return;
        }
        spannableBuilder.i(obj, i11, i12, 33);
    }

    /* renamed from: a */
    public SpannableBuilder append(char c11) {
        this.f55259b.append(c11);
        return this;
    }

    /* renamed from: b */
    public SpannableBuilder append(CharSequence charSequence) {
        e(length(), charSequence);
        this.f55259b.append(charSequence);
        return this;
    }

    /* renamed from: c */
    public SpannableBuilder append(CharSequence charSequence, int i11, int i12) {
        CharSequence subSequence = charSequence.subSequence(i11, i12);
        e(length(), subSequence);
        this.f55259b.append(subSequence);
        return this;
    }

    public char charAt(int i11) {
        return this.f55259b.charAt(i11);
    }

    public SpannableBuilder d(String str) {
        this.f55259b.append(str);
        return this;
    }

    public final void e(int i11, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z11 = spanned instanceof b;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length <= 0) {
                return;
            }
            if (z11) {
                for (int i12 = length - 1; i12 >= 0; i12--) {
                    Object obj = spans[i12];
                    i(obj, spanned.getSpanStart(obj) + i11, spanned.getSpanEnd(obj) + i11, spanned.getSpanFlags(obj));
                }
                return;
            }
            for (int i13 = 0; i13 < length; i13++) {
                Object obj2 = spans[i13];
                i(obj2, spanned.getSpanStart(obj2) + i11, spanned.getSpanEnd(obj2) + i11, spanned.getSpanFlags(obj2));
            }
        }
    }

    public List<a> f(int i11, int i12) {
        int i13;
        int length = length();
        if (!g(length, i11, i12)) {
            return Collections.emptyList();
        }
        if (i11 == 0 && length == i12) {
            ArrayList arrayList = new ArrayList(this.f55260c);
            Collections.reverse(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(0);
        Iterator<a> descendingIterator = this.f55260c.descendingIterator();
        while (descendingIterator.hasNext()) {
            a next = descendingIterator.next();
            int i14 = next.f55262b;
            if ((i14 >= i11 && i14 < i12) || (((i13 = next.f55263c) <= i12 && i13 > i11) || (i14 < i11 && i13 > i12))) {
                arrayList2.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public char h() {
        return this.f55259b.charAt(length() - 1);
    }

    public SpannableBuilder i(Object obj, int i11, int i12, int i13) {
        this.f55260c.push(new a(obj, i11, i12, i13));
        return this;
    }

    public SpannableStringBuilder l() {
        b bVar = new b(this.f55259b);
        for (a next : this.f55260c) {
            bVar.setSpan(next.f55261a, next.f55262b, next.f55263c, next.f55264d);
        }
        return bVar;
    }

    public int length() {
        return this.f55259b.length();
    }

    public CharSequence subSequence(int i11, int i12) {
        List<a> f11 = f(i11, i12);
        if (f11.isEmpty()) {
            return this.f55259b.subSequence(i11, i12);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f55259b.subSequence(i11, i12));
        int length = spannableStringBuilder.length();
        for (a next : f11) {
            int max = Math.max(0, next.f55262b - i11);
            spannableStringBuilder.setSpan(next.f55261a, max, Math.min(length, (next.f55263c - next.f55262b) + max), next.f55264d);
        }
        return spannableStringBuilder;
    }

    public String toString() {
        return this.f55259b.toString();
    }

    public SpannableBuilder(CharSequence charSequence) {
        this.f55260c = new ArrayDeque(8);
        this.f55259b = new StringBuilder(charSequence);
        e(0, charSequence);
    }
}
