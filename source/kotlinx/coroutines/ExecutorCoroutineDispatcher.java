package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.b;
import kotlin.jvm.internal.r;

public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    public static final Key f56955c = new Key((r) null);

    public static final class Key extends b<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public Key() {
            super(CoroutineDispatcher.f56941b, AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Key(r rVar) {
            this();
        }
    }

    public abstract void close();
}
