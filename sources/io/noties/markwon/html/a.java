package io.noties.markwon.html;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.b;
import io.noties.markwon.g;
import io.noties.markwon.html.e;
import io.noties.markwon.html.tag.BlockquoteHandler;
import io.noties.markwon.html.tag.EmphasisHandler;
import io.noties.markwon.html.tag.HeadingHandler;
import io.noties.markwon.html.tag.LinkHandler;
import io.noties.markwon.html.tag.ListHandler;
import io.noties.markwon.html.tag.StrikeHandler;
import io.noties.markwon.html.tag.StrongEmphasisHandler;
import io.noties.markwon.html.tag.SubScriptHandler;
import io.noties.markwon.html.tag.SuperScriptHandler;
import io.noties.markwon.html.tag.UnderlineHandler;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;

public class a extends AbstractMarkwonPlugin {

    /* renamed from: a  reason: collision with root package name */
    public final e.c f55313a = new e.c();

    /* renamed from: b  reason: collision with root package name */
    public MarkwonHtmlParser f55314b;

    /* renamed from: c  reason: collision with root package name */
    public MarkwonHtmlRenderer f55315c;

    /* renamed from: d  reason: collision with root package name */
    public HtmlEmptyTagReplacement f55316d = new HtmlEmptyTagReplacement();

    /* renamed from: io.noties.markwon.html.a$a  reason: collision with other inner class name */
    public class C0652a implements g.c<HtmlInline> {
        public C0652a() {
        }

        /* renamed from: b */
        public void a(g gVar, HtmlInline htmlInline) {
            a.this.c(gVar, htmlInline.m());
        }
    }

    public class b implements g.c<HtmlBlock> {
        public b() {
        }

        /* renamed from: b */
        public void a(g gVar, HtmlBlock htmlBlock) {
            a.this.c(gVar, htmlBlock.n());
        }
    }

    public static a b() {
        return new a();
    }

    public void afterRender(Node node, g gVar) {
        MarkwonHtmlRenderer markwonHtmlRenderer = this.f55315c;
        if (markwonHtmlRenderer != null) {
            markwonHtmlRenderer.a(gVar, this.f55314b);
            return;
        }
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }

    public final void c(g gVar, String str) {
        if (str != null) {
            this.f55314b.c(gVar.builder(), str);
        }
    }

    public void configureConfiguration(b.C0649b bVar) {
        e.c cVar = this.f55313a;
        if (!cVar.d()) {
            cVar.a(xz.a.e());
            cVar.a(new LinkHandler());
            cVar.a(new BlockquoteHandler());
            cVar.a(new SubScriptHandler());
            cVar.a(new SuperScriptHandler());
            cVar.a(new StrongEmphasisHandler());
            cVar.a(new StrikeHandler());
            cVar.a(new UnderlineHandler());
            cVar.a(new ListHandler());
            cVar.a(new EmphasisHandler());
            cVar.a(new HeadingHandler());
        }
        this.f55314b = d.g(this.f55316d);
        this.f55315c = cVar.b();
    }

    public void configureVisitor(g.b bVar) {
        bVar.a(HtmlBlock.class, new b()).a(HtmlInline.class, new C0652a());
    }
}
