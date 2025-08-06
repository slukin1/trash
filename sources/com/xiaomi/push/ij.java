package com.xiaomi.push;

public class ij extends il {

    /* renamed from: a  reason: collision with root package name */
    private int f52366a;

    /* renamed from: a  reason: collision with other field name */
    private ht f3250a;

    public ij(int i11) {
        this.f3250a = new ht(i11);
    }

    public int a(byte[] bArr, int i11, int i12) {
        byte[] a11 = this.f3250a.a();
        if (i12 > this.f3250a.a() - this.f52366a) {
            i12 = this.f3250a.a() - this.f52366a;
        }
        if (i12 > 0) {
            System.arraycopy(a11, this.f52366a, bArr, i11, i12);
            this.f52366a += i12;
        }
        return i12;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2902a(byte[] bArr, int i11, int i12) {
        this.f3250a.write(bArr, i11, i12);
    }

    public int a() {
        return this.f3250a.size();
    }
}
