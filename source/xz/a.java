package xz;

import android.text.TextUtils;
import io.noties.markwon.b;
import io.noties.markwon.html.CssInlineStyleParser;
import io.noties.markwon.html.tag.SimpleTagHandler;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.commonmark.node.Image;
import rz.c;
import rz.e;

public class a extends SimpleTagHandler {

    /* renamed from: a  reason: collision with root package name */
    public final C0677a f60214a;

    /* renamed from: xz.a$a  reason: collision with other inner class name */
    public interface C0677a {
        io.noties.markwon.image.a a(Map<String, String> map);
    }

    public a(C0677a aVar) {
        this.f60214a = aVar;
    }

    public static a e() {
        return new a(new b(CssInlineStyleParser.a()));
    }

    public Collection<String> b() {
        return Collections.singleton("img");
    }

    public Object d(b bVar, c cVar, io.noties.markwon.html.b bVar2) {
        e eVar;
        String str = bVar2.b().get("src");
        if (TextUtils.isEmpty(str) || (eVar = bVar.e().get(Image.class)) == null) {
            return null;
        }
        String b11 = bVar.b().b(str);
        io.noties.markwon.image.a a11 = this.f60214a.a(bVar2.b());
        yz.e.f60233a.e(cVar, b11);
        yz.e.f60235c.e(cVar, a11);
        yz.e.f60234b.e(cVar, Boolean.FALSE);
        return eVar.a(bVar, cVar);
    }
}
