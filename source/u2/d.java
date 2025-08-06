package u2;

import t2.c;
import t2.f;

public class d implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public b[] f16617a;

    /* renamed from: b  reason: collision with root package name */
    public int f16618b = 0;

    public d(b[] bVarArr) {
        this.f16617a = bVarArr;
    }

    public void a(c cVar, Throwable th2) {
        int i11 = this.f16618b + 1;
        this.f16618b = i11;
        b[] bVarArr = this.f16617a;
        if (i11 < bVarArr.length) {
            cVar.f(bVarArr[i11].b());
            cVar.g(this.f16617a[this.f16618b].a(cVar.a()));
        }
    }

    public void b(c cVar) {
    }

    public void c(c cVar, Object obj) {
    }
}
