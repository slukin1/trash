package kotlinx.coroutines.internal;

import d10.l;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Lambda;

public final class ExceptionsConstructorKt$createConstructor$1$2 extends Lambda implements l<Throwable, Throwable> {
    public final /* synthetic */ Constructor<?> $constructor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstructorKt$createConstructor$1$2(Constructor<?> constructor) {
        super(1);
        this.$constructor = constructor;
    }

    public final Throwable invoke(Throwable th2) {
        Throwable th3 = (Throwable) this.$constructor.newInstance(new Object[]{th2.getMessage()});
        th3.initCause(th2);
        return th3;
    }
}
