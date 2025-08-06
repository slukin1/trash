package kotlinx.serialization.json.internal;

import java.util.Arrays;

public final class JsonToStringWriter implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public char[] f57878a = h.f57903c.d();

    /* renamed from: b  reason: collision with root package name */
    public int f57879b;

    public void a(char c11) {
        e(1);
        char[] cArr = this.f57878a;
        int i11 = this.f57879b;
        this.f57879b = i11 + 1;
        cArr[i11] = c11;
    }

    public void b(String str) {
        e(str.length() + 2);
        char[] cArr = this.f57878a;
        int i11 = this.f57879b;
        int i12 = i11 + 1;
        cArr[i11] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i12);
        int i13 = length + i12;
        int i14 = i12;
        while (i14 < i13) {
            char c11 = cArr[i14];
            if (c11 >= n0.a().length || n0.a()[c11] == 0) {
                i14++;
            } else {
                d(i14 - i12, i14, str);
                return;
            }
        }
        cArr[i13] = '\"';
        this.f57879b = i13 + 1;
    }

    public void c(String str) {
        int length = str.length();
        if (length != 0) {
            e(length);
            str.getChars(0, str.length(), this.f57878a, this.f57879b);
            this.f57879b += length;
        }
    }

    public final void d(int i11, int i12, String str) {
        int i13;
        int length = str.length();
        while (i11 < length) {
            int f11 = f(i12, 2);
            char charAt = str.charAt(i11);
            if (charAt < n0.a().length) {
                byte b11 = n0.a()[charAt];
                if (b11 == 0) {
                    i13 = f11 + 1;
                    this.f57878a[f11] = (char) charAt;
                } else {
                    if (b11 == 1) {
                        String str2 = n0.b()[charAt];
                        int f12 = f(f11, str2.length());
                        str2.getChars(0, str2.length(), this.f57878a, f12);
                        i12 = f12 + str2.length();
                        this.f57879b = i12;
                    } else {
                        char[] cArr = this.f57878a;
                        cArr[f11] = '\\';
                        cArr[f11 + 1] = (char) b11;
                        i12 = f11 + 2;
                        this.f57879b = i12;
                    }
                    i11++;
                }
            } else {
                i13 = f11 + 1;
                this.f57878a[f11] = (char) charAt;
            }
            i12 = i13;
            i11++;
        }
        int f13 = f(i12, 1);
        this.f57878a[f13] = '\"';
        this.f57879b = f13 + 1;
    }

    public final void e(int i11) {
        f(this.f57879b, i11);
    }

    public final int f(int i11, int i12) {
        int i13 = i12 + i11;
        char[] cArr = this.f57878a;
        if (cArr.length <= i13) {
            this.f57878a = Arrays.copyOf(cArr, RangesKt___RangesKt.d(i13, i11 * 2));
        }
        return i11;
    }

    public void g() {
        h.f57903c.c(this.f57878a);
    }

    public String toString() {
        return new String(this.f57878a, 0, this.f57879b);
    }

    public void writeLong(long j11) {
        c(String.valueOf(j11));
    }
}
