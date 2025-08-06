package io.noties.markwon.html.tag;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import io.noties.markwon.b;
import io.noties.markwon.core.CoreProps;
import java.util.Collection;
import java.util.Collections;
import org.commonmark.node.Link;
import rz.c;
import rz.e;

public class LinkHandler extends SimpleTagHandler {
    public Collection<String> b() {
        return Collections.singleton("a");
    }

    public Object d(b bVar, c cVar, io.noties.markwon.html.b bVar2) {
        e eVar;
        String str = bVar2.b().get(ShareConstants.WEB_DIALOG_PARAM_HREF);
        if (TextUtils.isEmpty(str) || (eVar = bVar.e().get(Link.class)) == null) {
            return null;
        }
        CoreProps.f55295e.e(cVar, str);
        return eVar.a(bVar, cVar);
    }
}
