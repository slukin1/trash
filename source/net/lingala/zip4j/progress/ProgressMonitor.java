package net.lingala.zip4j.progress;

import net.lingala.zip4j.exception.ZipException;

public class ProgressMonitor {

    /* renamed from: a  reason: collision with root package name */
    public int f58443a;

    /* renamed from: b  reason: collision with root package name */
    public long f58444b;

    /* renamed from: c  reason: collision with root package name */
    public long f58445c;

    /* renamed from: d  reason: collision with root package name */
    public int f58446d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f58447e;

    /* renamed from: f  reason: collision with root package name */
    public String f58448f;

    /* renamed from: g  reason: collision with root package name */
    public int f58449g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f58450h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58451i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58452j;

    public ProgressMonitor() {
        e();
    }

    public void a(Throwable th2) throws ZipException {
        e();
        this.f58449g = 2;
        this.f58450h = th2;
    }

    public void b() throws ZipException {
        e();
        this.f58449g = 0;
    }

    public int c() {
        return this.f58443a;
    }

    public boolean d() {
        return this.f58451i;
    }

    public void e() {
        this.f58447e = -1;
        this.f58443a = 0;
        this.f58448f = null;
        this.f58444b = 0;
        this.f58445c = 0;
        this.f58446d = 0;
    }

    public void f(int i11) {
        this.f58447e = i11;
    }

    public void g(String str) {
        this.f58448f = str;
    }

    public void h(int i11) {
        this.f58449g = i11;
    }

    public void i(int i11) {
        this.f58443a = i11;
    }

    public void j(long j11) {
        this.f58444b = j11;
    }

    public void k(long j11) {
        long j12 = this.f58445c + j11;
        this.f58445c = j12;
        long j13 = this.f58444b;
        if (j13 > 0) {
            int i11 = (int) ((j12 * 100) / j13);
            this.f58446d = i11;
            if (i11 > 100) {
                this.f58446d = 100;
            }
        }
        while (this.f58452j) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException unused) {
            }
        }
    }
}
