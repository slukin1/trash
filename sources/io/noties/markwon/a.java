package io.noties.markwon;

import android.content.Context;
import android.widget.TextView;
import io.noties.markwon.Markwon;
import io.noties.markwon.b;
import io.noties.markwon.f;
import io.noties.markwon.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.commonmark.parser.Parser;
import sz.a;

public class a implements Markwon.a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f55265a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d> f55266b = new ArrayList(3);

    /* renamed from: c  reason: collision with root package name */
    public TextView.BufferType f55267c = TextView.BufferType.SPANNABLE;

    /* renamed from: d  reason: collision with root package name */
    public Markwon.b f55268d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55269e = true;

    public a(Context context) {
        this.f55265a = context;
    }

    public static List<d> b(List<d> list) {
        return new j(list).e();
    }

    public Markwon.a a(d dVar) {
        this.f55266b.add(dVar);
        return this;
    }

    public Markwon build() {
        if (!this.f55266b.isEmpty()) {
            List<d> b11 = b(this.f55266b);
            Parser.Builder builder = new Parser.Builder();
            a.C0676a j11 = sz.a.j(this.f55265a);
            b.C0649b bVar = new b.C0649b();
            i.a aVar = new i.a();
            f.a aVar2 = new f.a();
            for (d next : b11) {
                next.configureParser(builder);
                next.configureTheme(j11);
                next.configureConfiguration(bVar);
                next.configureVisitor(aVar);
                next.configureSpansFactory(aVar2);
            }
            b h11 = bVar.h(j11.z(), aVar2.build());
            return new c(this.f55267c, this.f55268d, builder.f(), h.b(aVar, h11), h11, Collections.unmodifiableList(b11), this.f55269e);
        }
        throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
    }
}
