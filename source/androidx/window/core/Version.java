package androidx.window.core;

import com.xiaomi.mipush.sdk.Constants;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB)\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0017\u0010\u000e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b¨\u0006 "}, d2 = {"Landroidx/window/core/Version;", "", "", "toString", "other", "", "b", "", "", "equals", "hashCode", "I", "e", "()I", "major", "c", "f", "minor", "d", "g", "patch", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "Ljava/math/BigInteger;", "Lkotlin/i;", "()Ljava/math/BigInteger;", "bigInteger", "<init>", "(IIILjava/lang/String;)V", "a", "window_release"}, k = 1, mv = {1, 6, 0})
public final class Version implements Comparable<Version> {

    /* renamed from: g  reason: collision with root package name */
    public static final a f12043g = new a((r) null);

    /* renamed from: h  reason: collision with root package name */
    public static final Version f12044h = new Version(0, 0, 0, "");

    /* renamed from: i  reason: collision with root package name */
    public static final Version f12045i = new Version(0, 1, 0, "");

    /* renamed from: j  reason: collision with root package name */
    public static final Version f12046j;

    /* renamed from: k  reason: collision with root package name */
    public static final Version f12047k;

    /* renamed from: b  reason: collision with root package name */
    public final int f12048b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12049c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12050d;

    /* renamed from: e  reason: collision with root package name */
    public final String f12051e;

    /* renamed from: f  reason: collision with root package name */
    public final i f12052f;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/window/core/Version$a;", "", "", "versionString", "Landroidx/window/core/Version;", "b", "VERSION_0_1", "Landroidx/window/core/Version;", "a", "()Landroidx/window/core/Version;", "VERSION_PATTERN_STRING", "Ljava/lang/String;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Version a() {
            return Version.f12045i;
        }

        public final Version b(String str) {
            if (str == null || StringsKt__StringsJVMKt.z(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String group = matcher.group(1);
            Integer valueOf = group == null ? null : Integer.valueOf(Integer.parseInt(group));
            if (valueOf == null) {
                return null;
            }
            int intValue = valueOf.intValue();
            String group2 = matcher.group(2);
            Integer valueOf2 = group2 == null ? null : Integer.valueOf(Integer.parseInt(group2));
            if (valueOf2 == null) {
                return null;
            }
            int intValue2 = valueOf2.intValue();
            String group3 = matcher.group(3);
            Integer valueOf3 = group3 == null ? null : Integer.valueOf(Integer.parseInt(group3));
            if (valueOf3 == null) {
                return null;
            }
            return new Version(intValue, intValue2, valueOf3.intValue(), matcher.group(4) != null ? matcher.group(4) : "", (r) null);
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        f12046j = version;
        f12047k = version;
    }

    public Version(int i11, int i12, int i13, String str) {
        this.f12048b = i11;
        this.f12049c = i12;
        this.f12050d = i13;
        this.f12051e = str;
        this.f12052f = LazyKt__LazyJVMKt.a(new Version$bigInteger$2(this));
    }

    public /* synthetic */ Version(int i11, int i12, int i13, String str, r rVar) {
        this(i11, i12, i13, str);
    }

    /* renamed from: b */
    public int compareTo(Version version) {
        return c().compareTo(version.c());
    }

    public final BigInteger c() {
        return (BigInteger) this.f12052f.getValue();
    }

    public final int e() {
        return this.f12048b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (this.f12048b == version.f12048b && this.f12049c == version.f12049c && this.f12050d == version.f12050d) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f12049c;
    }

    public final int g() {
        return this.f12050d;
    }

    public int hashCode() {
        return ((((527 + this.f12048b) * 31) + this.f12049c) * 31) + this.f12050d;
    }

    public String toString() {
        String i11 = StringsKt__StringsJVMKt.z(this.f12051e) ^ true ? x.i(Constants.ACCEPT_TIME_SEPARATOR_SERVER, this.f12051e) : "";
        return this.f12048b + '.' + this.f12049c + '.' + this.f12050d + i11;
    }
}
