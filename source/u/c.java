package u;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.auto.value.AutoValue;
import com.xiaomi.mipush.sdk.Constants;
import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AutoValue
public abstract class c implements Comparable<c> {

    /* renamed from: b  reason: collision with root package name */
    public static final c f16566b = c(1, 0, 0, "");

    /* renamed from: c  reason: collision with root package name */
    public static final c f16567c = c(1, 1, 0, "");

    /* renamed from: d  reason: collision with root package name */
    public static final c f16568d = c(1, 2, 0, "");

    /* renamed from: e  reason: collision with root package name */
    public static final c f16569e = c(1, 3, 0, "");

    /* renamed from: f  reason: collision with root package name */
    public static final c f16570f = c(1, 4, 0, "");

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f16571g = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:\\-(.+))?");

    public static c c(int i11, int i12, int i13, String str) {
        return new a(i11, i12, i13, str);
    }

    public static BigInteger e(c cVar) {
        return BigInteger.valueOf((long) cVar.g()).shiftLeft(32).or(BigInteger.valueOf((long) cVar.h())).shiftLeft(32).or(BigInteger.valueOf((long) cVar.i()));
    }

    public static c j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = f16571g.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        return c(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), matcher.group(4) != null ? matcher.group(4) : "");
    }

    public int a(int i11, int i12) {
        if (g() == i11) {
            return Integer.compare(h(), i12);
        }
        return Integer.compare(g(), i11);
    }

    /* renamed from: b */
    public int compareTo(c cVar) {
        return e(this).compareTo(e(cVar));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!Objects.equals(Integer.valueOf(g()), Integer.valueOf(cVar.g())) || !Objects.equals(Integer.valueOf(h()), Integer.valueOf(cVar.h())) || !Objects.equals(Integer.valueOf(i()), Integer.valueOf(cVar.i()))) {
            return false;
        }
        return true;
    }

    public abstract String f();

    public abstract int g();

    public abstract int h();

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(g()), Integer.valueOf(h()), Integer.valueOf(i())});
    }

    public abstract int i();

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(g() + InstructionFileId.DOT + h() + InstructionFileId.DOT + i());
        if (!TextUtils.isEmpty(f())) {
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER + f());
        }
        return sb2.toString();
    }
}
