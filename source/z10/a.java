package z10;

import d20.b;
import org.commonmark.node.Emphasis;
import org.commonmark.node.Node;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;

public abstract class a implements d20.a {

    /* renamed from: a  reason: collision with root package name */
    public final char f60236a;

    public a(char c11) {
        this.f60236a = c11;
    }

    public char a() {
        return this.f60236a;
    }

    public int b() {
        return 1;
    }

    public int c(b bVar, b bVar2) {
        if ((bVar.a() || bVar2.c()) && bVar2.b() % 3 != 0 && (bVar.b() + bVar2.b()) % 3 == 0) {
            return 0;
        }
        return (bVar.length() < 2 || bVar2.length() < 2) ? 1 : 2;
    }

    public char d() {
        return this.f60236a;
    }

    public void e(Text text, Text text2, int i11) {
        Node node;
        String valueOf = String.valueOf(d());
        if (i11 == 1) {
            node = new Emphasis(valueOf);
        } else {
            node = new StrongEmphasis(valueOf + valueOf);
        }
        Node e11 = text.e();
        while (e11 != null && e11 != text2) {
            Node e12 = e11.e();
            node.b(e11);
            e11 = e12;
        }
        text.h(node);
    }
}
