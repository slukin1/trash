package org.commonmark.internal;

import c20.d;
import c20.e;
import c20.f;
import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;

public class HtmlBlockParser extends AbstractBlockParser {

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern[][] f59648e = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};

    /* renamed from: a  reason: collision with root package name */
    public final HtmlBlock f59649a;

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f59650b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59651c;

    /* renamed from: d  reason: collision with root package name */
    public BlockContent f59652d;

    public static class Factory extends AbstractBlockParserFactory {
        public d a(f fVar, e eVar) {
            int d11 = fVar.d();
            CharSequence b11 = fVar.b();
            if (fVar.e() < 4 && b11.charAt(d11) == '<') {
                for (int i11 = 1; i11 <= 7; i11++) {
                    if (i11 != 7 || !(eVar.a().d() instanceof Paragraph)) {
                        Pattern pattern = HtmlBlockParser.f59648e[i11][0];
                        Pattern pattern2 = HtmlBlockParser.f59648e[i11][1];
                        if (pattern.matcher(b11.subSequence(d11, b11.length())).find()) {
                            return d.d(new HtmlBlockParser(pattern2)).b(fVar.getIndex());
                        }
                    }
                }
            }
            return d.c();
        }
    }

    public Block d() {
        return this.f59649a;
    }

    public void e(CharSequence charSequence) {
        this.f59652d.a(charSequence);
        Pattern pattern = this.f59650b;
        if (pattern != null && pattern.matcher(charSequence).find()) {
            this.f59651c = true;
        }
    }

    public c20.a g(f fVar) {
        if (this.f59651c) {
            return c20.a.d();
        }
        if (!fVar.a() || this.f59650b != null) {
            return c20.a.b(fVar.getIndex());
        }
        return c20.a.d();
    }

    public void h() {
        this.f59649a.o(this.f59652d.b());
        this.f59652d = null;
    }

    public HtmlBlockParser(Pattern pattern) {
        this.f59649a = new HtmlBlock();
        this.f59651c = false;
        this.f59652d = new BlockContent();
        this.f59650b = pattern;
    }
}
