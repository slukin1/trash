package j;

import java.util.Arrays;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f15999a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f16000b;

    public a(int i11, CharSequence charSequence) {
        this.f15999a = i11;
        this.f16000b = charSequence;
    }

    public static String a(CharSequence charSequence) {
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public int b() {
        return this.f15999a;
    }

    public CharSequence c() {
        return this.f16000b;
    }

    public final boolean d(CharSequence charSequence) {
        String a11 = a(this.f16000b);
        String a12 = a(charSequence);
        return (a11 == null && a12 == null) || (a11 != null && a11.equals(a12));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f15999a != aVar.f15999a || !d(aVar.f16000b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f15999a), a(this.f16000b)});
    }
}
