package net.lingala.zip4j.model;

public class ZipModel implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public CentralDirectory f58427b;

    /* renamed from: c  reason: collision with root package name */
    public EndCentralDirRecord f58428c;

    /* renamed from: d  reason: collision with root package name */
    public Zip64EndCentralDirLocator f58429d;

    /* renamed from: e  reason: collision with root package name */
    public Zip64EndCentralDirRecord f58430e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58431f;

    /* renamed from: g  reason: collision with root package name */
    public long f58432g = -1;

    /* renamed from: h  reason: collision with root package name */
    public String f58433h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58434i;

    /* renamed from: j  reason: collision with root package name */
    public String f58435j;

    public CentralDirectory b() {
        return this.f58427b;
    }

    public EndCentralDirRecord c() {
        return this.f58428c;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String d() {
        return this.f58435j;
    }

    public Zip64EndCentralDirLocator e() {
        return this.f58429d;
    }

    public Zip64EndCentralDirRecord f() {
        return this.f58430e;
    }

    public String g() {
        return this.f58433h;
    }

    public boolean h() {
        return this.f58431f;
    }

    public boolean i() {
        return this.f58434i;
    }

    public void j(CentralDirectory centralDirectory) {
        this.f58427b = centralDirectory;
    }

    public void k(EndCentralDirRecord endCentralDirRecord) {
        this.f58428c = endCentralDirRecord;
    }

    public void l(String str) {
        this.f58435j = str;
    }

    public void m(boolean z11) {
        this.f58431f = z11;
    }

    public void n(Zip64EndCentralDirLocator zip64EndCentralDirLocator) {
        this.f58429d = zip64EndCentralDirLocator;
    }

    public void o(Zip64EndCentralDirRecord zip64EndCentralDirRecord) {
        this.f58430e = zip64EndCentralDirRecord;
    }

    public void p(boolean z11) {
        this.f58434i = z11;
    }

    public void q(String str) {
        this.f58433h = str;
    }
}
