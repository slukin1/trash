package kotlin.collections;

import d10.l;
import java.util.Map;
import kotlin.jvm.internal.Lambda;

final class AbstractMap$toString$1 extends Lambda implements l<Map.Entry<Object, Object>, CharSequence> {
    public final /* synthetic */ b<Object, Object> this$0;

    public AbstractMap$toString$1(b<Object, Object> bVar) {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<Object, Object> entry) {
        return b.a(this.this$0, entry);
    }
}
