package io.noties.markwon.html;

import io.noties.markwon.g;
import io.noties.markwon.html.MarkwonHtmlParser;
import io.noties.markwon.html.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e extends MarkwonHtmlRenderer {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f55335a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, TagHandler> f55336b;

    public class a implements MarkwonHtmlParser.a<b.C0653b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f55337a;

        public a(g gVar) {
            this.f55337a = gVar;
        }

        public void a(List<b.C0653b> list) {
            TagHandler b11;
            for (b.C0653b next : list) {
                if (next.isClosed() && (b11 = e.this.b(next.name())) != null) {
                    b11.a(this.f55337a, e.this, next);
                }
            }
        }
    }

    public class b implements MarkwonHtmlParser.a<b.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f55339a;

        public b(g gVar) {
            this.f55339a = gVar;
        }

        public void a(List<b.a> list) {
            for (b.a next : list) {
                if (next.isClosed()) {
                    TagHandler b11 = e.this.b(next.name());
                    if (b11 != null) {
                        b11.a(this.f55339a, e.this, next);
                    } else {
                        a(next.f());
                    }
                }
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, TagHandler> f55341a = new HashMap(2);

        /* renamed from: b  reason: collision with root package name */
        public boolean f55342b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f55343c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f55344d;

        public void a(TagHandler tagHandler) {
            for (String next : tagHandler.b()) {
                if (!this.f55341a.containsKey(next)) {
                    this.f55341a.put(next, tagHandler);
                }
            }
        }

        public MarkwonHtmlRenderer b() {
            c();
            this.f55344d = true;
            if (this.f55341a.size() > 0) {
                return new e(this.f55342b, Collections.unmodifiableMap(this.f55341a));
            }
            return new uz.c();
        }

        public final void c() {
            if (this.f55344d) {
                throw new IllegalStateException("Builder has been already built");
            }
        }

        public boolean d() {
            return this.f55343c;
        }
    }

    public e(boolean z11, Map<String, TagHandler> map) {
        this.f55335a = z11;
        this.f55336b = map;
    }

    public void a(g gVar, MarkwonHtmlParser markwonHtmlParser) {
        int i11;
        if (!this.f55335a) {
            i11 = -1;
        } else {
            i11 = gVar.length();
        }
        markwonHtmlParser.b(i11, new a(gVar));
        markwonHtmlParser.a(i11, new b(gVar));
        markwonHtmlParser.d();
    }

    public TagHandler b(String str) {
        return this.f55336b.get(str);
    }
}
