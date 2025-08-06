package a00;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.a;
import io.noties.markwon.d;
import io.noties.markwon.g;
import org.commonmark.node.Link;
import rz.e;

public class a extends AbstractMarkwonPlugin {

    /* renamed from: a  reason: collision with root package name */
    public final int f53442a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f53443b;

    /* renamed from: a00.a$a  reason: collision with other inner class name */
    public class C0648a implements d.a<io.noties.markwon.core.a> {
        public C0648a() {
        }

        /* renamed from: b */
        public void a(io.noties.markwon.core.a aVar) {
            a.p pVar;
            if (a.this.f53443b) {
                pVar = new b(a.this.f53442a);
            } else {
                pVar = new c(a.this.f53442a);
            }
            aVar.d(pVar);
        }
    }

    public static class b extends c {
        public b(int i11) {
            super(i11);
        }

        public boolean b(Spannable spannable, int i11) {
            return a1.c.b(spannable, i11);
        }
    }

    public static class c implements a.p {

        /* renamed from: a  reason: collision with root package name */
        public final int f53445a;

        public c(int i11) {
            this.f53445a = i11;
        }

        public void a(g gVar, String str, int i11) {
            e eVar = gVar.configuration().e().get(Link.class);
            if (eVar != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                if (b(spannableStringBuilder, this.f53445a)) {
                    URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
                    if (uRLSpanArr != null && uRLSpanArr.length > 0) {
                        rz.c g11 = gVar.g();
                        SpannableBuilder builder = gVar.builder();
                        for (URLSpan uRLSpan : uRLSpanArr) {
                            CoreProps.f55295e.e(g11, uRLSpan.getURL());
                            SpannableBuilder.j(builder, eVar.a(gVar.configuration(), g11), spannableStringBuilder.getSpanStart(uRLSpan) + i11, spannableStringBuilder.getSpanEnd(uRLSpan) + i11);
                        }
                    }
                }
            }
        }

        public boolean b(Spannable spannable, int i11) {
            return Linkify.addLinks(spannable, i11);
        }
    }

    public a(int i11, boolean z11) {
        this.f53442a = i11;
        this.f53443b = z11;
    }

    public static a c() {
        return e(false);
    }

    public static a d(int i11, boolean z11) {
        return new a(i11, z11);
    }

    public static a e(boolean z11) {
        return d(7, z11);
    }

    public void configure(d.b bVar) {
        bVar.a(io.noties.markwon.core.a.class, new C0648a());
    }
}
