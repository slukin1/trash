package kotlinx.coroutines;

import d10.l;
import kotlin.Unit;

public abstract class CancelHandlerBase implements l<Throwable, Unit> {
    public abstract void g(Throwable th2);
}
