package kotlinx.coroutines.flow;

import d10.l;
import kotlin.jvm.internal.Lambda;

final class FlowKt__MigrationKt$onErrorReturn$1 extends Lambda implements l<Throwable, Boolean> {
    public static final FlowKt__MigrationKt$onErrorReturn$1 INSTANCE = new FlowKt__MigrationKt$onErrorReturn$1();

    public FlowKt__MigrationKt$onErrorReturn$1() {
        super(1);
    }

    public final Boolean invoke(Throwable th2) {
        return Boolean.TRUE;
    }
}
