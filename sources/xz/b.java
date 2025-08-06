package xz;

import android.text.TextUtils;
import io.noties.markwon.html.CssInlineStyleParser;
import io.noties.markwon.image.a;
import java.util.Map;
import xz.a;

public class b implements a.C0677a {

    /* renamed from: a  reason: collision with root package name */
    public final CssInlineStyleParser f60215a;

    public b(CssInlineStyleParser cssInlineStyleParser) {
        this.f60215a = cssInlineStyleParser;
    }

    public io.noties.markwon.image.a a(Map<String, String> map) {
        a.C0654a aVar;
        a.C0654a aVar2;
        String str = map.get("style");
        if (!TextUtils.isEmpty(str)) {
            aVar2 = null;
            aVar = null;
            for (uz.b next : this.f60215a.b(str)) {
                String a11 = next.a();
                if ("width".equals(a11)) {
                    aVar2 = b(next.c());
                } else if ("height".equals(a11)) {
                    aVar = b(next.c());
                }
                if (aVar2 != null && aVar != null) {
                    break;
                }
            }
        } else {
            aVar2 = null;
            aVar = null;
        }
        if (aVar2 != null && aVar != null) {
            return new io.noties.markwon.image.a(aVar2, aVar);
        }
        if (aVar2 == null) {
            aVar2 = b(map.get("width"));
        }
        if (aVar == null) {
            aVar = b(map.get("height"));
        }
        if (aVar2 == null && aVar == null) {
            return null;
        }
        return new io.noties.markwon.image.a(aVar2, aVar);
    }

    public a.C0654a b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        int i11 = length - 1;
        int i12 = i11;
        while (i12 > -1) {
            if (Character.isDigit(str.charAt(i12))) {
                int i13 = i12 + 1;
                try {
                    float parseFloat = Float.parseFloat(str.substring(0, i13));
                    if (i12 == i11) {
                        str2 = null;
                    } else {
                        str2 = str.substring(i13, length);
                    }
                    return new a.C0654a(parseFloat, str2);
                } catch (NumberFormatException unused) {
                    return null;
                }
            } else {
                i12--;
            }
        }
        return null;
    }
}
