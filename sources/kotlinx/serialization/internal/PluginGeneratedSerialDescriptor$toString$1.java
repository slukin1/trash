package kotlinx.serialization.internal;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class PluginGeneratedSerialDescriptor$toString$1 extends Lambda implements l<Integer, CharSequence> {
    public final /* synthetic */ PluginGeneratedSerialDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PluginGeneratedSerialDescriptor$toString$1(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(1);
        this.this$0 = pluginGeneratedSerialDescriptor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final CharSequence invoke(int i11) {
        return this.this$0.f(i11) + com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b + this.this$0.d(i11).h();
    }
}
