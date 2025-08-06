package androidx.camera.core.processing;

import java.util.Iterator;
import java.util.Objects;

public final /* synthetic */ class j0 {
    public static /* synthetic */ String a(CharSequence charSequence, Iterable iterable) {
        Objects.requireNonNull(charSequence, TtmlNode.RUBY_DELIMITER);
        StringBuilder sb2 = new StringBuilder();
        Iterator it2 = iterable.iterator();
        if (it2.hasNext()) {
            while (true) {
                sb2.append((CharSequence) it2.next());
                if (!it2.hasNext()) {
                    break;
                }
                sb2.append(charSequence);
            }
        }
        return sb2.toString();
    }
}
