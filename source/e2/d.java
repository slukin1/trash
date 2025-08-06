package e2;

import com.alibaba.fastjson.asm.ByteVector;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.Label;

public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public d f15653a;

    /* renamed from: b  reason: collision with root package name */
    public final ClassWriter f15654b;

    /* renamed from: c  reason: collision with root package name */
    public int f15655c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15656d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15657e;

    /* renamed from: f  reason: collision with root package name */
    public int f15658f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f15659g;

    /* renamed from: h  reason: collision with root package name */
    public ByteVector f15660h = new ByteVector();

    /* renamed from: i  reason: collision with root package name */
    public int f15661i;

    /* renamed from: j  reason: collision with root package name */
    public int f15662j;

    public d(ClassWriter classWriter, int i11, String str, String str2, String str3, String[] strArr) {
        if (classWriter.f14166q == null) {
            classWriter.f14166q = this;
        } else {
            classWriter.f14167r.f15653a = this;
        }
        classWriter.f14167r = this;
        this.f15654b = classWriter;
        this.f15655c = i11;
        this.f15656d = classWriter.h(str);
        this.f15657e = classWriter.h(str2);
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.f15658f = length;
            this.f15659g = new int[length];
            for (int i12 = 0; i12 < this.f15658f; i12++) {
                this.f15659g[i12] = classWriter.b(strArr[i12]).f15644a;
            }
        }
    }

    public void a(int i11, String str, String str2, String str3) {
        this.f15660h.c(i11, this.f15654b.d(str, str2, str3).f15644a);
    }

    public void b(Object obj) {
        b c11 = this.f15654b.c(obj);
        int i11 = c11.f15644a;
        int i12 = c11.f15645b;
        if (i12 == 5 || i12 == 6) {
            this.f15660h.c(20, i11);
        } else if (i11 >= 256) {
            this.f15660h.c(19, i11);
        } else {
            this.f15660h.b(18, i11);
        }
    }

    public void c(int i11, String str) {
        this.f15660h.c(i11, this.f15654b.b(str).f15644a);
    }

    public void d(Label label) {
        ByteVector byteVector = this.f15660h;
        label.c(this, byteVector.f14149b, byteVector.f14148a);
    }

    public void e(int i11, Label label) {
        if ((label.f14168a & 2) == 0 || label.f14169b - this.f15660h.f14149b >= -32768) {
            this.f15660h.d(i11);
            ByteVector byteVector = this.f15660h;
            label.b(this, byteVector, byteVector.f14149b - 1);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void f(int i11, int i12) {
        if (i12 < 4 && i11 != 169) {
            this.f15660h.d((i11 < 54 ? ((i11 - 21) << 2) + 26 : ((i11 - 54) << 2) + 59) + i12);
        } else if (i12 >= 256) {
            this.f15660h.d(196).c(i11, i12);
        } else {
            this.f15660h.b(i11, i12);
        }
    }

    public void g(int i11, int i12) {
        this.f15660h.d(132).b(i11, i12);
    }

    public void h(int i11, int i12) {
        this.f15660h.b(i11, i12);
    }

    public void i(int i11) {
        this.f15660h.d(i11);
    }

    public void j(int i11, int i12) {
        this.f15661i = i11;
        this.f15662j = i12;
    }

    public void k(int i11, String str, String str2, String str3) {
        boolean z11 = i11 == 185;
        b e11 = this.f15654b.e(str, str2, str3, z11);
        int i12 = e11.f15646c;
        if (z11) {
            if (i12 == 0) {
                i12 = e.a(str3);
                e11.f15646c = i12;
            }
            this.f15660h.c(185, e11.f15644a).b(i12 >> 2, 0);
            return;
        }
        this.f15660h.c(i11, e11.f15644a);
    }

    public void l() {
    }

    public final int m() {
        int i11;
        if (this.f15660h.f14149b > 0) {
            this.f15654b.h("Code");
            i11 = this.f15660h.f14149b + 18 + 0 + 8;
        } else {
            i11 = 8;
        }
        if (this.f15658f <= 0) {
            return i11;
        }
        this.f15654b.h("Exceptions");
        return i11 + (this.f15658f * 2) + 8;
    }

    public final void n(ByteVector byteVector) {
        byteVector.g(this.f15655c & -393217).g(this.f15656d).g(this.f15657e);
        int i11 = this.f15660h.f14149b > 0 ? 1 : 0;
        if (this.f15658f > 0) {
            i11++;
        }
        byteVector.g(i11);
        int i12 = this.f15660h.f14149b;
        if (i12 > 0) {
            byteVector.g(this.f15654b.h("Code")).f(i12 + 12 + 0);
            byteVector.g(this.f15661i).g(this.f15662j);
            ByteVector f11 = byteVector.f(this.f15660h.f14149b);
            ByteVector byteVector2 = this.f15660h;
            f11.e(byteVector2.f14148a, 0, byteVector2.f14149b);
            byteVector.g(0);
            byteVector.g(0);
        }
        if (this.f15658f > 0) {
            byteVector.g(this.f15654b.h("Exceptions")).f((this.f15658f * 2) + 2);
            byteVector.g(this.f15658f);
            for (int i13 = 0; i13 < this.f15658f; i13++) {
                byteVector.g(this.f15659g[i13]);
            }
        }
    }
}
