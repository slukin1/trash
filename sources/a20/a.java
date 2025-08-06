package a20;

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
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

public interface a {
    void A(Paragraph paragraph);

    void B(StrongEmphasis strongEmphasis);

    void C(ListItem listItem);

    void E(Emphasis emphasis);

    void b(Code code);

    void d(Heading heading);

    void e(OrderedList orderedList);

    void i(HardLineBreak hardLineBreak);

    void j(CustomNode customNode);

    void k(BulletList bulletList);

    void m(Link link);

    void n(IndentedCodeBlock indentedCodeBlock);

    void o(CustomBlock customBlock);

    void p(SoftLineBreak softLineBreak);

    void q(Document document);

    void r(BlockQuote blockQuote);

    void s(FencedCodeBlock fencedCodeBlock);

    void u(HtmlBlock htmlBlock);

    void v(Text text);

    void w(HtmlInline htmlInline);

    void x(Image image);

    void y(LinkReferenceDefinition linkReferenceDefinition);

    void z(ThematicBreak thematicBreak);
}
