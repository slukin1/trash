package io.noties.markwon.html.tag;

import com.facebook.appevents.UserDataStore;
import io.noties.markwon.b;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.node.Emphasis;
import rz.c;
import rz.e;

public class EmphasisHandler extends SimpleTagHandler {
    public Collection<String> b() {
        return Arrays.asList(new String[]{"i", UserDataStore.EMAIL, "cite", "dfn"});
    }

    public Object d(b bVar, c cVar, io.noties.markwon.html.b bVar2) {
        e eVar = bVar.e().get(Emphasis.class);
        if (eVar == null) {
            return null;
        }
        return eVar.a(bVar, cVar);
    }
}
