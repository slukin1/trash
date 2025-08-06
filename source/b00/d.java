package b00;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.g;
import org.commonmark.parser.Parser;
import rz.e;

public class d extends AbstractMarkwonPlugin {

    /* renamed from: a  reason: collision with root package name */
    public final a f53454a = new a();

    public class a implements g.c<c> {
        public a() {
        }

        /* renamed from: b */
        public void a(g gVar, c cVar) {
            int length = gVar.length();
            gVar.c(cVar);
            SpannableBuilder.j(gVar.builder(), cVar.m().a(gVar.configuration(), gVar.g()), length, gVar.length());
        }
    }

    public static d b() {
        return new d();
    }

    public d a(int i11, char c11, char c12, e eVar) {
        this.f53454a.a(i11, c11, c12, eVar);
        return this;
    }

    public void configureParser(Parser.Builder builder) {
        for (d20.a g11 : this.f53454a.b()) {
            builder.g(g11);
        }
    }

    public void configureVisitor(g.b bVar) {
        bVar.a(c.class, new a());
    }
}
