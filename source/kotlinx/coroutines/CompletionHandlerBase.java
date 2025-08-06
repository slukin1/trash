package kotlinx.coroutines;

import d10.l;
import kotlin.Unit;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

public abstract class CompletionHandlerBase extends LockFreeLinkedListNode implements l<Throwable, Unit> {
    public abstract void q(Throwable th2);
}
