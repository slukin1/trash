package net.lingala.zip4j.model;

import java.util.ArrayList;

public class LocalFileHeader {

    /* renamed from: a  reason: collision with root package name */
    public int f58380a;

    /* renamed from: b  reason: collision with root package name */
    public int f58381b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f58382c;

    /* renamed from: d  reason: collision with root package name */
    public int f58383d;

    /* renamed from: e  reason: collision with root package name */
    public int f58384e;

    /* renamed from: f  reason: collision with root package name */
    public long f58385f = 0;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f58386g;

    /* renamed from: h  reason: collision with root package name */
    public long f58387h;

    /* renamed from: i  reason: collision with root package name */
    public long f58388i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f58389j;

    /* renamed from: k  reason: collision with root package name */
    public int f58390k;

    /* renamed from: l  reason: collision with root package name */
    public String f58391l;

    /* renamed from: m  reason: collision with root package name */
    public long f58392m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f58393n;

    /* renamed from: o  reason: collision with root package name */
    public int f58394o = -1;

    /* renamed from: p  reason: collision with root package name */
    public char[] f58395p;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList f58396q;

    /* renamed from: r  reason: collision with root package name */
    public Zip64ExtendedInfo f58397r;

    /* renamed from: s  reason: collision with root package name */
    public AESExtraDataRecord f58398s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f58399t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f58400u = false;

    /* renamed from: v  reason: collision with root package name */
    public boolean f58401v;

    public void A(byte[] bArr) {
        this.f58382c = bArr;
    }

    public void B(int i11) {
        this.f58384e = i11;
    }

    public void C(long j11) {
        this.f58392m = j11;
    }

    public void D(char[] cArr) {
        this.f58395p = cArr;
    }

    public void E(int i11) {
        this.f58380a = i11;
    }

    public void F(long j11) {
        this.f58388i = j11;
    }

    public void G(int i11) {
        this.f58381b = i11;
    }

    public void H(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.f58397r = zip64ExtendedInfo;
    }

    public AESExtraDataRecord a() {
        return this.f58398s;
    }

    public long b() {
        return this.f58387h;
    }

    public int c() {
        return this.f58383d;
    }

    public long d() {
        return this.f58385f;
    }

    public int e() {
        return this.f58394o;
    }

    public ArrayList f() {
        return this.f58396q;
    }

    public int g() {
        return this.f58390k;
    }

    public String h() {
        return this.f58391l;
    }

    public long i() {
        return this.f58392m;
    }

    public char[] j() {
        return this.f58395p;
    }

    public long k() {
        return this.f58388i;
    }

    public boolean l() {
        return this.f58393n;
    }

    public boolean m() {
        return this.f58401v;
    }

    public void n(AESExtraDataRecord aESExtraDataRecord) {
        this.f58398s = aESExtraDataRecord;
    }

    public void o(long j11) {
        this.f58387h = j11;
    }

    public void p(int i11) {
        this.f58383d = i11;
    }

    public void q(long j11) {
        this.f58385f = j11;
    }

    public void r(byte[] bArr) {
        this.f58386g = bArr;
    }

    public void s(boolean z11) {
        this.f58399t = z11;
    }

    public void t(boolean z11) {
        this.f58393n = z11;
    }

    public void u(int i11) {
        this.f58394o = i11;
    }

    public void v(ArrayList arrayList) {
        this.f58396q = arrayList;
    }

    public void w(int i11) {
        this.f58390k = i11;
    }

    public void x(String str) {
        this.f58391l = str;
    }

    public void y(int i11) {
        this.f58389j = i11;
    }

    public void z(boolean z11) {
        this.f58401v = z11;
    }
}
