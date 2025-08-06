package net.lingala.zip4j.model;

import java.util.ArrayList;

public class FileHeader {
    public boolean A;

    /* renamed from: a  reason: collision with root package name */
    public int f58354a;

    /* renamed from: b  reason: collision with root package name */
    public int f58355b;

    /* renamed from: c  reason: collision with root package name */
    public int f58356c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f58357d;

    /* renamed from: e  reason: collision with root package name */
    public int f58358e;

    /* renamed from: f  reason: collision with root package name */
    public int f58359f;

    /* renamed from: g  reason: collision with root package name */
    public long f58360g = 0;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f58361h;

    /* renamed from: i  reason: collision with root package name */
    public long f58362i;

    /* renamed from: j  reason: collision with root package name */
    public long f58363j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f58364k;

    /* renamed from: l  reason: collision with root package name */
    public int f58365l;

    /* renamed from: m  reason: collision with root package name */
    public int f58366m;

    /* renamed from: n  reason: collision with root package name */
    public byte[] f58367n;

    /* renamed from: o  reason: collision with root package name */
    public byte[] f58368o;

    /* renamed from: p  reason: collision with root package name */
    public long f58369p;

    /* renamed from: q  reason: collision with root package name */
    public String f58370q;

    /* renamed from: r  reason: collision with root package name */
    public String f58371r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f58372s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f58373t;

    /* renamed from: u  reason: collision with root package name */
    public int f58374u = -1;

    /* renamed from: v  reason: collision with root package name */
    public char[] f58375v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f58376w;

    /* renamed from: x  reason: collision with root package name */
    public Zip64ExtendedInfo f58377x;

    /* renamed from: y  reason: collision with root package name */
    public AESExtraDataRecord f58378y;

    /* renamed from: z  reason: collision with root package name */
    public ArrayList f58379z;

    public void A(int i11) {
        this.f58366m = i11;
    }

    public void B(boolean z11) {
        this.f58373t = z11;
    }

    public void C(int i11) {
        this.f58374u = i11;
    }

    public void D(byte[] bArr) {
        this.f58368o = bArr;
    }

    public void E(ArrayList arrayList) {
        this.f58379z = arrayList;
    }

    public void F(int i11) {
        this.f58365l = i11;
    }

    public void G(String str) {
        this.f58371r = str;
    }

    public void H(String str) {
        this.f58370q = str;
    }

    public void I(int i11) {
        this.f58364k = i11;
    }

    public void J(boolean z11) {
        this.A = z11;
    }

    public void K(byte[] bArr) {
        this.f58357d = bArr;
    }

    public void L(byte[] bArr) {
        this.f58367n = bArr;
    }

    public void M(int i11) {
        this.f58359f = i11;
    }

    public void N(long j11) {
        this.f58369p = j11;
    }

    public void O(char[] cArr) {
        this.f58375v = cArr;
    }

    public void P(int i11) {
        this.f58354a = i11;
    }

    public void Q(long j11) {
        this.f58363j = j11;
    }

    public void R(int i11) {
        this.f58355b = i11;
    }

    public void S(int i11) {
        this.f58356c = i11;
    }

    public void T(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.f58377x = zip64ExtendedInfo;
    }

    public AESExtraDataRecord a() {
        return this.f58378y;
    }

    public long b() {
        return this.f58362i;
    }

    public int c() {
        return this.f58358e;
    }

    public long d() {
        return this.f58360g & 4294967295L;
    }

    public byte[] e() {
        return this.f58361h;
    }

    public int f() {
        return this.f58366m;
    }

    public int g() {
        return this.f58374u;
    }

    public byte[] h() {
        return this.f58368o;
    }

    public ArrayList i() {
        return this.f58379z;
    }

    public int j() {
        return this.f58365l;
    }

    public String k() {
        return this.f58370q;
    }

    public int l() {
        return this.f58359f;
    }

    public long m() {
        return this.f58369p;
    }

    public char[] n() {
        return this.f58375v;
    }

    public long o() {
        return this.f58363j;
    }

    public Zip64ExtendedInfo p() {
        return this.f58377x;
    }

    public boolean q() {
        return this.f58372s;
    }

    public boolean r() {
        return this.f58373t;
    }

    public boolean s() {
        return this.A;
    }

    public void t(AESExtraDataRecord aESExtraDataRecord) {
        this.f58378y = aESExtraDataRecord;
    }

    public void u(long j11) {
        this.f58362i = j11;
    }

    public void v(int i11) {
        this.f58358e = i11;
    }

    public void w(long j11) {
        this.f58360g = j11;
    }

    public void x(byte[] bArr) {
        this.f58361h = bArr;
    }

    public void y(boolean z11) {
        this.f58376w = z11;
    }

    public void z(boolean z11) {
        this.f58372s = z11;
    }
}
