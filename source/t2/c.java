package t2;

import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.huochat.community.network.domain.DomainTool;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f16545a = DomainTool.DOMAIN_PREFIX_HTTP;

    /* renamed from: b  reason: collision with root package name */
    public String f16546b;

    /* renamed from: c  reason: collision with root package name */
    public int f16547c;

    /* renamed from: d  reason: collision with root package name */
    public String f16548d;

    /* renamed from: e  reason: collision with root package name */
    public int f16549e = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;

    public c(String str, String str2, int i11, String str3, int i12) {
        this.f16545a = str;
        this.f16546b = str2;
        this.f16547c = i11;
        this.f16548d = str3;
        this.f16549e = i12;
    }

    public String a() {
        return this.f16545a;
    }

    public int b() {
        return this.f16547c;
    }

    public int c() {
        return this.f16549e;
    }

    public String d() {
        return this.f16546b;
    }

    public String e() {
        return this.f16545a + this.f16546b + ":" + this.f16547c + this.f16548d;
    }

    public void f(String str) {
        this.f16546b = str;
    }

    public void g(int i11) {
        this.f16547c = i11;
    }
}
