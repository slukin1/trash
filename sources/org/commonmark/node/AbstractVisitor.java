package org.commonmark.node;

import a20.a;

public abstract class AbstractVisitor implements a {
    public void A(Paragraph paragraph) {
        c(paragraph);
    }

    public void B(StrongEmphasis strongEmphasis) {
        c(strongEmphasis);
    }

    public void C(ListItem listItem) {
        c(listItem);
    }

    public void E(Emphasis emphasis) {
        c(emphasis);
    }

    public void b(Code code) {
        c(code);
    }

    public void c(Node node) {
        Node c11 = node.c();
        while (c11 != null) {
            Node e11 = c11.e();
            c11.a(this);
            c11 = e11;
        }
    }

    public void d(Heading heading) {
        c(heading);
    }

    public void e(OrderedList orderedList) {
        c(orderedList);
    }

    public void i(HardLineBreak hardLineBreak) {
        c(hardLineBreak);
    }

    public void j(CustomNode customNode) {
        c(customNode);
    }

    public void k(BulletList bulletList) {
        c(bulletList);
    }

    public void m(Link link) {
        c(link);
    }

    public void n(IndentedCodeBlock indentedCodeBlock) {
        c(indentedCodeBlock);
    }

    public void o(CustomBlock customBlock) {
        c(customBlock);
    }

    public void p(SoftLineBreak softLineBreak) {
        c(softLineBreak);
    }

    public void q(Document document) {
        c(document);
    }

    public void r(BlockQuote blockQuote) {
        c(blockQuote);
    }

    public void s(FencedCodeBlock fencedCodeBlock) {
        c(fencedCodeBlock);
    }

    public void u(HtmlBlock htmlBlock) {
        c(htmlBlock);
    }

    public void v(Text text) {
        c(text);
    }

    public void w(HtmlInline htmlInline) {
        c(htmlInline);
    }

    public void x(Image image) {
        c(image);
    }

    public void y(LinkReferenceDefinition linkReferenceDefinition) {
        c(linkReferenceDefinition);
    }

    public void z(ThematicBreak thematicBreak) {
        c(thematicBreak);
    }
}
