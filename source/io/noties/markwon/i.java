package io.noties.markwon;

import io.noties.markwon.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import rz.c;
import rz.e;

public class i implements g {

    /* renamed from: a  reason: collision with root package name */
    public final b f55399a;

    /* renamed from: b  reason: collision with root package name */
    public final c f55400b;

    /* renamed from: c  reason: collision with root package name */
    public final SpannableBuilder f55401c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Class<? extends Node>, g.c<? extends Node>> f55402d;

    /* renamed from: e  reason: collision with root package name */
    public final g.a f55403e;

    public static class a implements g.b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Class<? extends Node>, g.c<? extends Node>> f55404a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public g.a f55405b;

        public <N extends Node> g.b a(Class<N> cls, g.c<? super N> cVar) {
            if (cVar == null) {
                this.f55404a.remove(cls);
            } else {
                this.f55404a.put(cls, cVar);
            }
            return this;
        }

        public g b(b bVar, c cVar) {
            g.a aVar = this.f55405b;
            if (aVar == null) {
                aVar = new BlockHandlerDef();
            }
            return new i(bVar, cVar, new SpannableBuilder(), Collections.unmodifiableMap(this.f55404a), aVar);
        }
    }

    public i(b bVar, c cVar, SpannableBuilder spannableBuilder, Map<Class<? extends Node>, g.c<? extends Node>> map, g.a aVar) {
        this.f55399a = bVar;
        this.f55400b = cVar;
        this.f55401c = spannableBuilder;
        this.f55402d = map;
        this.f55403e = aVar;
    }

    public void A(Paragraph paragraph) {
        H(paragraph);
    }

    public void B(StrongEmphasis strongEmphasis) {
        H(strongEmphasis);
    }

    public void C(ListItem listItem) {
        H(listItem);
    }

    public void D(Node node) {
        this.f55403e.b(this, node);
    }

    public void E(Emphasis emphasis) {
        H(emphasis);
    }

    public void F() {
        this.f55401c.append(10);
    }

    public <N extends Node> void G(Class<N> cls, int i11) {
        e eVar = this.f55399a.e().get(cls);
        if (eVar != null) {
            a(i11, eVar.a(this.f55399a, this.f55400b));
        }
    }

    public final void H(Node node) {
        g.c cVar = this.f55402d.get(node.getClass());
        if (cVar != null) {
            cVar.a(this, node);
        } else {
            c(node);
        }
    }

    public void a(int i11, Object obj) {
        SpannableBuilder spannableBuilder = this.f55401c;
        SpannableBuilder.j(spannableBuilder, obj, i11, spannableBuilder.length());
    }

    public void b(Code code) {
        H(code);
    }

    public SpannableBuilder builder() {
        return this.f55401c;
    }

    public void c(Node node) {
        Node c11 = node.c();
        while (c11 != null) {
            Node e11 = c11.e();
            c11.a(this);
            c11 = e11;
        }
    }

    public b configuration() {
        return this.f55399a;
    }

    public void d(Heading heading) {
        H(heading);
    }

    public void e(OrderedList orderedList) {
        H(orderedList);
    }

    public void f(Node node) {
        this.f55403e.a(this, node);
    }

    public c g() {
        return this.f55400b;
    }

    public <N extends Node> void h(N n11, int i11) {
        G(n11.getClass(), i11);
    }

    public void i(HardLineBreak hardLineBreak) {
        H(hardLineBreak);
    }

    public void j(CustomNode customNode) {
        H(customNode);
    }

    public void k(BulletList bulletList) {
        H(bulletList);
    }

    public void l() {
        if (this.f55401c.length() > 0 && 10 != this.f55401c.h()) {
            this.f55401c.append(10);
        }
    }

    public int length() {
        return this.f55401c.length();
    }

    public void m(Link link) {
        H(link);
    }

    public void n(IndentedCodeBlock indentedCodeBlock) {
        H(indentedCodeBlock);
    }

    public void o(CustomBlock customBlock) {
        H(customBlock);
    }

    public void p(SoftLineBreak softLineBreak) {
        H(softLineBreak);
    }

    public void q(Document document) {
        H(document);
    }

    public void r(BlockQuote blockQuote) {
        H(blockQuote);
    }

    public void s(FencedCodeBlock fencedCodeBlock) {
        H(fencedCodeBlock);
    }

    public boolean t(Node node) {
        return node.e() != null;
    }

    public void u(HtmlBlock htmlBlock) {
        H(htmlBlock);
    }

    public void v(Text text) {
        H(text);
    }

    public void w(HtmlInline htmlInline) {
        H(htmlInline);
    }

    public void x(Image image) {
        H(image);
    }

    public void y(LinkReferenceDefinition linkReferenceDefinition) {
        H(linkReferenceDefinition);
    }

    public void z(ThematicBreak thematicBreak) {
        H(thematicBreak);
    }
}
