package kotlinx.serialization.internal;

import d10.a;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.f;

public final class EnumSerializer$descriptor$2 extends Lambda implements a<f> {
    public final /* synthetic */ String $serialName;
    public final /* synthetic */ EnumSerializer<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumSerializer$descriptor$2(EnumSerializer<T> enumSerializer, String str) {
        super(0);
        this.this$0 = enumSerializer;
        this.$serialName = str;
    }

    public final f invoke() {
        f b11 = this.this$0.f57658b;
        return b11 == null ? this.this$0.c(this.$serialName) : b11;
    }
}
