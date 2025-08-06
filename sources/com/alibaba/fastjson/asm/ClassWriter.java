package com.alibaba.fastjson.asm;

import e2.a;
import e2.b;
import e2.d;
import e2.e;

public class ClassWriter {

    /* renamed from: a  reason: collision with root package name */
    public int f14150a;

    /* renamed from: b  reason: collision with root package name */
    public int f14151b;

    /* renamed from: c  reason: collision with root package name */
    public final ByteVector f14152c;

    /* renamed from: d  reason: collision with root package name */
    public b[] f14153d;

    /* renamed from: e  reason: collision with root package name */
    public int f14154e;

    /* renamed from: f  reason: collision with root package name */
    public final b f14155f;

    /* renamed from: g  reason: collision with root package name */
    public final b f14156g;

    /* renamed from: h  reason: collision with root package name */
    public final b f14157h;

    /* renamed from: i  reason: collision with root package name */
    public int f14158i;

    /* renamed from: j  reason: collision with root package name */
    public int f14159j;

    /* renamed from: k  reason: collision with root package name */
    public String f14160k;

    /* renamed from: l  reason: collision with root package name */
    public int f14161l;

    /* renamed from: m  reason: collision with root package name */
    public int f14162m;

    /* renamed from: n  reason: collision with root package name */
    public int[] f14163n;

    /* renamed from: o  reason: collision with root package name */
    public a f14164o;

    /* renamed from: p  reason: collision with root package name */
    public a f14165p;

    /* renamed from: q  reason: collision with root package name */
    public d f14166q;

    /* renamed from: r  reason: collision with root package name */
    public d f14167r;

    public ClassWriter() {
        this(0);
    }

    public final b a(b bVar) {
        b[] bVarArr = this.f14153d;
        b bVar2 = bVarArr[bVar.f15651h % bVarArr.length];
        while (bVar2 != null && (bVar2.f15645b != bVar.f15645b || !bVar.a(bVar2))) {
            bVar2 = bVar2.f15652i;
        }
        return bVar2;
    }

    public b b(String str) {
        this.f14156g.c(7, str, (String) null, (String) null);
        b a11 = a(this.f14156g);
        if (a11 != null) {
            return a11;
        }
        this.f14152c.c(7, h(str));
        int i11 = this.f14151b;
        this.f14151b = i11 + 1;
        b bVar = new b(i11, this.f14156g);
        i(bVar);
        return bVar;
    }

    public b c(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            this.f14155f.b(intValue);
            b a11 = a(this.f14155f);
            if (a11 != null) {
                return a11;
            }
            this.f14152c.d(3).f(intValue);
            int i11 = this.f14151b;
            this.f14151b = i11 + 1;
            b bVar = new b(i11, this.f14155f);
            i(bVar);
            return bVar;
        } else if (obj instanceof String) {
            return g((String) obj);
        } else {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return b(eVar.f15672a == 10 ? eVar.c() : eVar.b());
            }
            throw new IllegalArgumentException("value " + obj);
        }
    }

    public b d(String str, String str2, String str3) {
        this.f14157h.c(9, str, str2, str3);
        b a11 = a(this.f14157h);
        if (a11 != null) {
            return a11;
        }
        int i11 = b(str).f15644a;
        this.f14152c.c(9, i11).g(f(str2, str3).f15644a);
        int i12 = this.f14151b;
        this.f14151b = i12 + 1;
        b bVar = new b(i12, this.f14157h);
        i(bVar);
        return bVar;
    }

    public b e(String str, String str2, String str3, boolean z11) {
        int i11 = z11 ? 11 : 10;
        this.f14157h.c(i11, str, str2, str3);
        b a11 = a(this.f14157h);
        if (a11 != null) {
            return a11;
        }
        this.f14152c.c(i11, b(str).f15644a).g(f(str2, str3).f15644a);
        int i12 = this.f14151b;
        this.f14151b = i12 + 1;
        b bVar = new b(i12, this.f14157h);
        i(bVar);
        return bVar;
    }

    public b f(String str, String str2) {
        this.f14156g.c(12, str, str2, (String) null);
        b a11 = a(this.f14156g);
        if (a11 != null) {
            return a11;
        }
        int h11 = h(str);
        this.f14152c.c(12, h11).g(h(str2));
        int i11 = this.f14151b;
        this.f14151b = i11 + 1;
        b bVar = new b(i11, this.f14156g);
        i(bVar);
        return bVar;
    }

    public final b g(String str) {
        this.f14156g.c(8, str, (String) null, (String) null);
        b a11 = a(this.f14156g);
        if (a11 != null) {
            return a11;
        }
        this.f14152c.c(8, h(str));
        int i11 = this.f14151b;
        this.f14151b = i11 + 1;
        b bVar = new b(i11, this.f14156g);
        i(bVar);
        return bVar;
    }

    public int h(String str) {
        this.f14155f.c(1, str, (String) null, (String) null);
        b a11 = a(this.f14155f);
        if (a11 == null) {
            this.f14152c.d(1).h(str);
            int i11 = this.f14151b;
            this.f14151b = i11 + 1;
            a11 = new b(i11, this.f14155f);
            i(a11);
        }
        return a11.f15644a;
    }

    public final void i(b bVar) {
        if (this.f14151b > this.f14154e) {
            int length = this.f14153d.length;
            int i11 = (length * 2) + 1;
            b[] bVarArr = new b[i11];
            for (int i12 = length - 1; i12 >= 0; i12--) {
                b bVar2 = this.f14153d[i12];
                while (bVar2 != null) {
                    int i13 = bVar2.f15651h % i11;
                    b bVar3 = bVar2.f15652i;
                    bVar2.f15652i = bVarArr[i13];
                    bVarArr[i13] = bVar2;
                    bVar2 = bVar3;
                }
            }
            this.f14153d = bVarArr;
            this.f14154e = (int) (((double) i11) * 0.75d);
        }
        int i14 = bVar.f15651h;
        b[] bVarArr2 = this.f14153d;
        int length2 = i14 % bVarArr2.length;
        bVar.f15652i = bVarArr2[length2];
        bVarArr2[length2] = bVar;
    }

    public byte[] j() {
        int i11 = (this.f14162m * 2) + 24;
        int i12 = 0;
        for (a aVar = this.f14164o; aVar != null; aVar = aVar.f15640a) {
            i12++;
            i11 += aVar.a();
        }
        int i13 = 0;
        for (d dVar = this.f14166q; dVar != null; dVar = dVar.f15653a) {
            i13++;
            i11 += dVar.m();
        }
        ByteVector byteVector = new ByteVector(i11 + this.f14152c.f14149b);
        byteVector.f(-889275714).f(this.f14150a);
        ByteVector g11 = byteVector.g(this.f14151b);
        ByteVector byteVector2 = this.f14152c;
        g11.e(byteVector2.f14148a, 0, byteVector2.f14149b);
        byteVector.g(this.f14158i & -393217).g(this.f14159j).g(this.f14161l);
        byteVector.g(this.f14162m);
        for (int i14 = 0; i14 < this.f14162m; i14++) {
            byteVector.g(this.f14163n[i14]);
        }
        byteVector.g(i12);
        for (a aVar2 = this.f14164o; aVar2 != null; aVar2 = aVar2.f15640a) {
            aVar2.b(byteVector);
        }
        byteVector.g(i13);
        for (d dVar2 = this.f14166q; dVar2 != null; dVar2 = dVar2.f15653a) {
            dVar2.n(byteVector);
        }
        byteVector.g(0);
        return byteVector.f14148a;
    }

    public void k(int i11, int i12, String str, String str2, String[] strArr) {
        int i13;
        this.f14150a = i11;
        this.f14158i = i12;
        this.f14159j = b(str).f15644a;
        this.f14160k = str;
        if (str2 == null) {
            i13 = 0;
        } else {
            i13 = b(str2).f15644a;
        }
        this.f14161l = i13;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f14162m = length;
            this.f14163n = new int[length];
            for (int i14 = 0; i14 < this.f14162m; i14++) {
                this.f14163n[i14] = b(strArr[i14]).f15644a;
            }
        }
    }

    public ClassWriter(int i11) {
        this.f14151b = 1;
        this.f14152c = new ByteVector();
        b[] bVarArr = new b[256];
        this.f14153d = bVarArr;
        this.f14154e = (int) (((double) bVarArr.length) * 0.75d);
        this.f14155f = new b();
        this.f14156g = new b();
        this.f14157h = new b();
    }
}
