package kotlinx.serialization.internal;

import d10.a;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;

public final class PluginGeneratedSerialDescriptor$typeParameterDescriptors$2 extends Lambda implements a<f[]> {
    public final /* synthetic */ PluginGeneratedSerialDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(0);
        this.this$0 = pluginGeneratedSerialDescriptor;
    }

    public final f[] invoke() {
        ArrayList arrayList;
        b[] typeParametersSerializers;
        d0 j11 = this.this$0.f57670b;
        if (j11 == null || (typeParametersSerializers = j11.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(typeParametersSerializers.length);
            for (b descriptor : typeParametersSerializers) {
                arrayList.add(descriptor.getDescriptor());
            }
        }
        return g1.b(arrayList);
    }
}
