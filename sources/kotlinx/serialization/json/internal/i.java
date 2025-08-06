package kotlinx.serialization.json.internal;

import com.google.common.base.Ascii;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f57904a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f57905b = new char[117];

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f57906c = new byte[126];

    static {
        i iVar = new i();
        f57904a = iVar;
        iVar.f();
        iVar.e();
    }

    public final void a(char c11, char c12) {
        b(c11, c12);
    }

    public final void b(int i11, char c11) {
        if (c11 != 'u') {
            f57905b[c11] = (char) i11;
        }
    }

    public final void c(char c11, byte b11) {
        d(c11, b11);
    }

    public final void d(int i11, byte b11) {
        f57906c[i11] = b11;
    }

    public final void e() {
        for (int i11 = 0; i11 < 33; i11++) {
            d(i11, Ascii.DEL);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c('\\', (byte) 2);
    }

    public final void f() {
        for (int i11 = 0; i11 < 32; i11++) {
            b(i11, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a('\\', '\\');
    }
}
