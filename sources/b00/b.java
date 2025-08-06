package b00;

import d20.a;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import rz.e;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final char f53449a;

    /* renamed from: b  reason: collision with root package name */
    public final char f53450b;

    /* renamed from: c  reason: collision with root package name */
    public final int f53451c;

    /* renamed from: d  reason: collision with root package name */
    public final e f53452d;

    public b(char c11, char c12, int i11, e eVar) {
        this.f53449a = c11;
        this.f53450b = c12;
        this.f53451c = i11;
        this.f53452d = eVar;
    }

    public char a() {
        return this.f53450b;
    }

    public int b() {
        return this.f53451c;
    }

    public int c(d20.b bVar, d20.b bVar2) {
        int i11;
        if (bVar.length() < this.f53451c || bVar2.length() < (i11 = this.f53451c)) {
            return 0;
        }
        return i11;
    }

    public char d() {
        return this.f53449a;
    }

    public void e(Text text, Text text2, int i11) {
        c cVar = new c(this.f53452d);
        Node e11 = text.e();
        while (e11 != null && e11 != text2) {
            Node e12 = e11.e();
            cVar.b(e11);
            e11 = e12;
        }
        text.h(cVar);
    }
}
