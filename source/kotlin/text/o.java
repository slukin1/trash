package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.x;
import kotlin.m;
import kotlin.q;
import kotlin.t;

public final class o {
    public static final byte a(String str) {
        m b11 = b(str);
        if (b11 != null) {
            return b11.g();
        }
        StringsKt__StringNumberConversionsKt.l(str);
        throw new KotlinNothingValueException();
    }

    public static final m b(String str) {
        return c(str, 10);
    }

    public static final m c(String str, int i11) {
        kotlin.o f11 = f(str, i11);
        if (f11 == null) {
            return null;
        }
        int g11 = f11.g();
        if (Integer.compare(g11 ^ Integer.MIN_VALUE, kotlin.o.b(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return m.a(m.b((byte) g11));
    }

    public static final int d(String str) {
        kotlin.o e11 = e(str);
        if (e11 != null) {
            return e11.g();
        }
        StringsKt__StringNumberConversionsKt.l(str);
        throw new KotlinNothingValueException();
    }

    public static final kotlin.o e(String str) {
        return f(str, 10);
    }

    public static final kotlin.o f(String str, int i11) {
        int unused = CharsKt__CharJVMKt.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char charAt = str.charAt(0);
        int i13 = 1;
        if (x.c(charAt, 48) >= 0) {
            i13 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int b11 = kotlin.o.b(i11);
        int i14 = 119304647;
        while (i13 < length) {
            int b12 = CharsKt__CharJVMKt.b(str.charAt(i13), i11);
            if (b12 < 0) {
                return null;
            }
            if (Integer.compare(i12 ^ Integer.MIN_VALUE, i14 ^ Integer.MIN_VALUE) > 0) {
                if (i14 == 119304647) {
                    i14 = l.a(-1, b11);
                    if (Integer.compare(i12 ^ Integer.MIN_VALUE, i14 ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int b13 = kotlin.o.b(i12 * b11);
            int b14 = kotlin.o.b(kotlin.o.b(b12) + b13);
            if (Integer.compare(b14 ^ Integer.MIN_VALUE, b13 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i13++;
            i12 = b14;
        }
        return kotlin.o.a(i12);
    }

    public static final long g(String str) {
        q h11 = h(str);
        if (h11 != null) {
            return h11.g();
        }
        StringsKt__StringNumberConversionsKt.l(str);
        throw new KotlinNothingValueException();
    }

    public static final q h(String str) {
        return i(str, 10);
    }

    public static final q i(String str, int i11) {
        String str2 = str;
        int i12 = i11;
        int unused = CharsKt__CharJVMKt.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        long j11 = -1;
        int i13 = 0;
        char charAt = str2.charAt(0);
        if (x.c(charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i13 = 1;
        }
        long b11 = q.b((long) i12);
        long j12 = 0;
        long j13 = 512409557603043100L;
        while (i13 < length) {
            int b12 = CharsKt__CharJVMKt.b(str2.charAt(i13), i12);
            if (b12 < 0) {
                return null;
            }
            if (Long.compare(j12 ^ Long.MIN_VALUE, j13 ^ Long.MIN_VALUE) > 0) {
                if (j13 == 512409557603043100L) {
                    j13 = n.a(j11, b11);
                    if (Long.compare(j12 ^ Long.MIN_VALUE, j13 ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long b13 = q.b(j12 * b11);
            long b14 = q.b(q.b(((long) kotlin.o.b(b12)) & 4294967295L) + b13);
            if (Long.compare(b14 ^ Long.MIN_VALUE, b13 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i13++;
            j12 = b14;
            j11 = -1;
        }
        return q.a(j12);
    }

    public static final short j(String str) {
        t k11 = k(str);
        if (k11 != null) {
            return k11.g();
        }
        StringsKt__StringNumberConversionsKt.l(str);
        throw new KotlinNothingValueException();
    }

    public static final t k(String str) {
        return l(str, 10);
    }

    public static final t l(String str, int i11) {
        kotlin.o f11 = f(str, i11);
        if (f11 == null) {
            return null;
        }
        int g11 = f11.g();
        if (Integer.compare(g11 ^ Integer.MIN_VALUE, kotlin.o.b(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return t.a(t.b((short) g11));
    }
}
