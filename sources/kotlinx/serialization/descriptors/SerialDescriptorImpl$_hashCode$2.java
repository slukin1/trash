package kotlinx.serialization.descriptors;

import d10.a;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.internal.i1;

public final class SerialDescriptorImpl$_hashCode$2 extends Lambda implements a<Integer> {
    public final /* synthetic */ SerialDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerialDescriptorImpl$_hashCode$2(SerialDescriptorImpl serialDescriptorImpl) {
        super(0);
        this.this$0 = serialDescriptorImpl;
    }

    public final Integer invoke() {
        SerialDescriptorImpl serialDescriptorImpl = this.this$0;
        return Integer.valueOf(i1.a(serialDescriptorImpl, serialDescriptorImpl.f57616k));
    }
}
