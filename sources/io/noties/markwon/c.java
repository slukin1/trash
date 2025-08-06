package io.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import io.noties.markwon.Markwon;
import java.util.List;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

public class c extends Markwon {

    /* renamed from: a  reason: collision with root package name */
    public final TextView.BufferType f55284a;

    /* renamed from: b  reason: collision with root package name */
    public final Parser f55285b;

    /* renamed from: c  reason: collision with root package name */
    public final h f55286c;

    /* renamed from: d  reason: collision with root package name */
    public final b f55287d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d> f55288e;

    /* renamed from: f  reason: collision with root package name */
    public final Markwon.b f55289f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f55290g;

    public c(TextView.BufferType bufferType, Markwon.b bVar, Parser parser, h hVar, b bVar2, List<d> list, boolean z11) {
        this.f55284a = bufferType;
        this.f55289f = bVar;
        this.f55285b = parser;
        this.f55286c = hVar;
        this.f55287d = bVar2;
        this.f55288e = list;
        this.f55290g = z11;
    }

    public Spanned b(String str) {
        Spanned d11 = d(c(str));
        return (!TextUtils.isEmpty(d11) || !this.f55290g || TextUtils.isEmpty(str)) ? d11 : new SpannableStringBuilder(str);
    }

    public Node c(String str) {
        for (d processMarkdown : this.f55288e) {
            str = processMarkdown.processMarkdown(str);
        }
        return this.f55285b.b(str);
    }

    public Spanned d(Node node) {
        for (d beforeRender : this.f55288e) {
            beforeRender.beforeRender(node);
        }
        g a11 = this.f55286c.a();
        node.a(a11);
        for (d afterRender : this.f55288e) {
            afterRender.afterRender(node, a11);
        }
        return a11.builder().l();
    }
}
