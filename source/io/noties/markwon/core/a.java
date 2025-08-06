package io.noties.markwon.core;

import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.factory.BlockQuoteSpanFactory;
import io.noties.markwon.core.factory.CodeBlockSpanFactory;
import io.noties.markwon.core.factory.CodeSpanFactory;
import io.noties.markwon.core.factory.EmphasisSpanFactory;
import io.noties.markwon.core.factory.HeadingSpanFactory;
import io.noties.markwon.core.factory.LinkSpanFactory;
import io.noties.markwon.core.factory.ListItemSpanFactory;
import io.noties.markwon.core.factory.StrongEmphasisSpanFactory;
import io.noties.markwon.core.factory.ThematicBreakSpanFactory;
import io.noties.markwon.e;
import io.noties.markwon.g;
import java.util.ArrayList;
import java.util.List;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

public class a extends AbstractMarkwonPlugin {

    /* renamed from: a  reason: collision with root package name */
    public final List<p> f55298a = new ArrayList(0);

    /* renamed from: b  reason: collision with root package name */
    public boolean f55299b;

    /* renamed from: io.noties.markwon.core.a$a  reason: collision with other inner class name */
    public class C0650a implements g.c<ThematicBreak> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, ThematicBreak thematicBreak) {
            gVar.f(thematicBreak);
            int length = gVar.length();
            gVar.builder().append(160);
            gVar.h(thematicBreak, length);
            gVar.D(thematicBreak);
        }
    }

    public class b implements g.c<Heading> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, Heading heading) {
            gVar.f(heading);
            int length = gVar.length();
            gVar.c(heading);
            CoreProps.f55294d.e(gVar.g(), Integer.valueOf(heading.n()));
            gVar.h(heading, length);
            gVar.D(heading);
        }
    }

    public class c implements g.c<SoftLineBreak> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, SoftLineBreak softLineBreak) {
            gVar.builder().append(' ');
        }
    }

    public class d implements g.c<HardLineBreak> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, HardLineBreak hardLineBreak) {
            gVar.l();
        }
    }

    public class e implements g.c<Paragraph> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, Paragraph paragraph) {
            boolean c11 = a.o(paragraph);
            if (!c11) {
                gVar.f(paragraph);
            }
            int length = gVar.length();
            gVar.c(paragraph);
            CoreProps.f55296f.e(gVar.g(), Boolean.valueOf(c11));
            gVar.h(paragraph, length);
            if (!c11) {
                gVar.D(paragraph);
            }
        }
    }

    public class f implements g.c<Link> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, Link link) {
            int length = gVar.length();
            gVar.c(link);
            CoreProps.f55295e.e(gVar.g(), link.m());
            gVar.h(link, length);
        }
    }

    public class g implements g.c<Text> {
        public g() {
        }

        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, Text text) {
            String m11 = text.m();
            gVar.builder().d(m11);
            if (!a.this.f55298a.isEmpty()) {
                int length = gVar.length() - m11.length();
                for (p a11 : a.this.f55298a) {
                    a11.a(gVar, m11, length);
                }
            }
        }
    }

    public class h implements g.c<StrongEmphasis> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, StrongEmphasis strongEmphasis) {
            int length = gVar.length();
            gVar.c(strongEmphasis);
            gVar.h(strongEmphasis, length);
        }
    }

    public class i implements g.c<Emphasis> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, Emphasis emphasis) {
            int length = gVar.length();
            gVar.c(emphasis);
            gVar.h(emphasis, length);
        }
    }

    public class j implements g.c<BlockQuote> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, BlockQuote blockQuote) {
            gVar.f(blockQuote);
            int length = gVar.length();
            gVar.c(blockQuote);
            gVar.h(blockQuote, length);
            gVar.D(blockQuote);
        }
    }

    public class k implements g.c<Code> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, Code code) {
            int length = gVar.length();
            gVar.builder().append(160).d(code.m()).append(160);
            gVar.h(code, length);
        }
    }

    public class l implements g.c<FencedCodeBlock> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, FencedCodeBlock fencedCodeBlock) {
            a.y(gVar, fencedCodeBlock.q(), fencedCodeBlock.r(), fencedCodeBlock);
        }
    }

    public class m implements g.c<IndentedCodeBlock> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, IndentedCodeBlock indentedCodeBlock) {
            a.y(gVar, (String) null, indentedCodeBlock.n(), indentedCodeBlock);
        }
    }

    public class n implements g.c<Image> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, Image image) {
            rz.e eVar = gVar.configuration().e().get(Image.class);
            if (eVar == null) {
                gVar.c(image);
                return;
            }
            int length = gVar.length();
            gVar.c(image);
            if (length == gVar.length()) {
                gVar.builder().append(65532);
            }
            io.noties.markwon.b configuration = gVar.configuration();
            String b11 = configuration.b().b(image.m());
            rz.c g11 = gVar.g();
            yz.e.f60233a.e(g11, b11);
            yz.e.f60234b.e(g11, Boolean.valueOf(image.f() instanceof Link));
            yz.e.f60235c.e(g11, null);
            gVar.a(length, eVar.a(configuration, g11));
        }
    }

    public class o implements g.c<ListItem> {
        /* renamed from: b */
        public void a(io.noties.markwon.g gVar, ListItem listItem) {
            int length = gVar.length();
            gVar.c(listItem);
            Block m11 = listItem.f();
            if (m11 instanceof OrderedList) {
                OrderedList orderedList = (OrderedList) m11;
                int q11 = orderedList.q();
                CoreProps.f55291a.e(gVar.g(), CoreProps.ListItemType.ORDERED);
                CoreProps.f55293c.e(gVar.g(), Integer.valueOf(q11));
                orderedList.s(orderedList.q() + 1);
            } else {
                CoreProps.f55291a.e(gVar.g(), CoreProps.ListItemType.BULLET);
                CoreProps.f55292b.e(gVar.g(), Integer.valueOf(a.r(listItem)));
            }
            gVar.h(listItem, length);
            if (gVar.t(listItem)) {
                gVar.l();
            }
        }
    }

    public interface p {
        void a(io.noties.markwon.g gVar, String str, int i11);
    }

    public static void e(g.b bVar) {
        bVar.a(BlockQuote.class, new j());
    }

    public static void f(g.b bVar) {
        bVar.a(BulletList.class, new SimpleBlockNodeVisitor());
    }

    public static void g(g.b bVar) {
        bVar.a(Code.class, new k());
    }

    public static a h() {
        return new a();
    }

    public static void i(g.b bVar) {
        bVar.a(Emphasis.class, new i());
    }

    public static void j(g.b bVar) {
        bVar.a(FencedCodeBlock.class, new l());
    }

    public static void k(g.b bVar) {
        bVar.a(HardLineBreak.class, new d());
    }

    public static void l(g.b bVar) {
        bVar.a(Heading.class, new b());
    }

    public static void m(g.b bVar) {
        bVar.a(Image.class, new n());
    }

    public static void n(g.b bVar) {
        bVar.a(IndentedCodeBlock.class, new m());
    }

    public static boolean o(Paragraph paragraph) {
        Block m11 = paragraph.f();
        if (m11 == null) {
            return false;
        }
        Node f11 = m11.f();
        if (f11 instanceof ListBlock) {
            return ((ListBlock) f11).n();
        }
        return false;
    }

    public static void p(g.b bVar) {
        bVar.a(Link.class, new f());
    }

    public static void q(g.b bVar) {
        bVar.a(ListItem.class, new o());
    }

    public static int r(Node node) {
        int i11 = 0;
        for (Node f11 = node.f(); f11 != null; f11 = f11.f()) {
            if (f11 instanceof ListItem) {
                i11++;
            }
        }
        return i11;
    }

    public static void s(g.b bVar) {
        bVar.a(OrderedList.class, new SimpleBlockNodeVisitor());
    }

    public static void t(g.b bVar) {
        bVar.a(Paragraph.class, new e());
    }

    public static void u(g.b bVar) {
        bVar.a(SoftLineBreak.class, new c());
    }

    public static void v(g.b bVar) {
        bVar.a(StrongEmphasis.class, new h());
    }

    public static void x(g.b bVar) {
        bVar.a(ThematicBreak.class, new C0650a());
    }

    public static void y(io.noties.markwon.g gVar, String str, String str2, Node node) {
        gVar.f(node);
        int length = gVar.length();
        gVar.builder().append(160).append(10).append(gVar.configuration().f().a(str, str2));
        gVar.l();
        gVar.builder().append(160);
        CoreProps.f55297g.e(gVar.g(), str);
        gVar.h(node, length);
        gVar.D(node);
    }

    public void afterSetText(TextView textView) {
        if (!this.f55299b && textView.getMovementMethod() == null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void beforeSetText(TextView textView, Spanned spanned) {
        tz.g.a(textView, spanned);
        if (spanned instanceof Spannable) {
            tz.i.a((Spannable) spanned, textView);
        }
    }

    public void configureSpansFactory(e.a aVar) {
        CodeBlockSpanFactory codeBlockSpanFactory = new CodeBlockSpanFactory();
        aVar.a(StrongEmphasis.class, new StrongEmphasisSpanFactory()).a(Emphasis.class, new EmphasisSpanFactory()).a(BlockQuote.class, new BlockQuoteSpanFactory()).a(Code.class, new CodeSpanFactory()).a(FencedCodeBlock.class, codeBlockSpanFactory).a(IndentedCodeBlock.class, codeBlockSpanFactory).a(ListItem.class, new ListItemSpanFactory()).a(Heading.class, new HeadingSpanFactory()).a(Link.class, new LinkSpanFactory()).a(ThematicBreak.class, new ThematicBreakSpanFactory());
    }

    public void configureVisitor(g.b bVar) {
        w(bVar);
        v(bVar);
        i(bVar);
        e(bVar);
        g(bVar);
        j(bVar);
        n(bVar);
        m(bVar);
        f(bVar);
        s(bVar);
        q(bVar);
        x(bVar);
        l(bVar);
        u(bVar);
        k(bVar);
        t(bVar);
        p(bVar);
    }

    public a d(p pVar) {
        this.f55298a.add(pVar);
        return this;
    }

    public final void w(g.b bVar) {
        bVar.a(Text.class, new g());
    }
}
