package kotlinx.serialization.descriptors;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class SerialDescriptorImpl$toString$1 extends Lambda implements l<Integer, CharSequence> {
    public final /* synthetic */ SerialDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerialDescriptorImpl$toString$1(SerialDescriptorImpl serialDescriptorImpl) {
        super(1);
        this.this$0 = serialDescriptorImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final CharSequence invoke(int i11) {
        return this.this$0.f(i11) + com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b + this.this$0.d(i11).h();
    }
}
