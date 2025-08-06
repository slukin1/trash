package kotlinx.serialization.internal;

import d10.a;
import kotlin.jvm.internal.Lambda;

public final class TaggedDecoder$decodeNullableSerializableElement$1 extends Lambda implements a<T> {
    public final /* synthetic */ kotlinx.serialization.a<T> $deserializer;
    public final /* synthetic */ T $previousValue;
    public final /* synthetic */ TaggedDecoder<Tag> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaggedDecoder$decodeNullableSerializableElement$1(TaggedDecoder<Tag> taggedDecoder, kotlinx.serialization.a<? extends T> aVar, T t11) {
        super(0);
        this.this$0 = taggedDecoder;
        this.$deserializer = aVar;
        this.$previousValue = t11;
    }

    public final T invoke() {
        if (this.this$0.D()) {
            return this.this$0.I(this.$deserializer, this.$previousValue);
        }
        return this.this$0.g();
    }
}
