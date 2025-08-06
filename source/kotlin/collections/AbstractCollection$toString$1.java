package kotlin.collections;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class AbstractCollection$toString$1 extends Lambda implements l<E, CharSequence> {
    public final /* synthetic */ AbstractCollection<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractCollection$toString$1(AbstractCollection<? extends E> abstractCollection) {
        super(1);
        this.this$0 = abstractCollection;
    }

    public final CharSequence invoke(E e11) {
        return e11 == this.this$0 ? "(this Collection)" : String.valueOf(e11);
    }
}
