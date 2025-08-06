package kotlin.ranges;

import a10.b;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.r;

public class a implements Iterable<Character>, e10.a {

    /* renamed from: e  reason: collision with root package name */
    public static final C0665a f56824e = new C0665a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public final char f56825b;

    /* renamed from: c  reason: collision with root package name */
    public final char f56826c;

    /* renamed from: d  reason: collision with root package name */
    public final int f56827d;

    /* renamed from: kotlin.ranges.a$a  reason: collision with other inner class name */
    public static final class C0665a {
        public C0665a() {
        }

        public /* synthetic */ C0665a(r rVar) {
            this();
        }
    }

    public a(char c11, char c12, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i11 != Integer.MIN_VALUE) {
            this.f56825b = c11;
            this.f56826c = (char) b.c(c11, c12, i11);
            this.f56827d = i11;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final char a() {
        return this.f56825b;
    }

    public final char b() {
        return this.f56826c;
    }

    /* renamed from: c */
    public CharIterator iterator() {
        return new b(this.f56825b, this.f56826c, this.f56827d);
    }
}
