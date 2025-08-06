package io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.b;
import io.noties.markwon.d;
import io.noties.markwon.e;
import io.noties.markwon.g;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import sz.a;

public abstract class AbstractMarkwonPlugin implements d {
    public void afterRender(Node node, g gVar) {
    }

    public void afterSetText(TextView textView) {
    }

    public void beforeRender(Node node) {
    }

    public void beforeSetText(TextView textView, Spanned spanned) {
    }

    public void configure(d.b bVar) {
    }

    public void configureConfiguration(b.C0649b bVar) {
    }

    public void configureParser(Parser.Builder builder) {
    }

    public void configureSpansFactory(e.a aVar) {
    }

    public void configureTheme(a.C0676a aVar) {
    }

    public void configureVisitor(g.b bVar) {
    }

    public String processMarkdown(String str) {
        return str;
    }
}
