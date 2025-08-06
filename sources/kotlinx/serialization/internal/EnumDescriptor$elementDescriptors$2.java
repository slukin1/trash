package kotlinx.serialization.internal;

import d10.a;
import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

public final class EnumDescriptor$elementDescriptors$2 extends Lambda implements a<f[]> {
    public final /* synthetic */ int $elementsCount;
    public final /* synthetic */ String $name;
    public final /* synthetic */ EnumDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumDescriptor$elementDescriptors$2(int i11, String str, EnumDescriptor enumDescriptor) {
        super(0);
        this.$elementsCount = i11;
        this.$name = str;
        this.this$0 = enumDescriptor;
    }

    public final f[] invoke() {
        int i11 = this.$elementsCount;
        f[] fVarArr = new f[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            fVarArr[i12] = SerialDescriptorsKt.d(this.$name + '.' + this.this$0.f(i12), i.d.f57650a, new f[0], (l) null, 8, (Object) null);
        }
        return fVarArr;
    }
}
