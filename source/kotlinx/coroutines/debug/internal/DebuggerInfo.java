package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.g0;

public final class DebuggerInfo implements Serializable {
    private final Long coroutineId;
    private final String dispatcher;
    private final List<StackTraceElement> lastObservedStackTrace;
    private final String lastObservedThreadName;
    private final String lastObservedThreadState;
    private final String name;
    private final long sequenceNumber;
    private final String state;

    public DebuggerInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        Thread.State state2;
        f0 f0Var = (f0) coroutineContext.get(f0.f57119c);
        String str = null;
        this.coroutineId = f0Var != null ? Long.valueOf(f0Var.w()) : null;
        d dVar = (d) coroutineContext.get(d.f56672p0);
        this.dispatcher = dVar != null ? dVar.toString() : null;
        g0 g0Var = (g0) coroutineContext.get(g0.f57275c);
        this.name = g0Var != null ? g0Var.w() : null;
        this.state = debugCoroutineInfoImpl.g();
        Thread thread = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedThreadState = (thread == null || (state2 = thread.getState()) == null) ? null : state2.toString();
        Thread thread2 = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : str;
        this.lastObservedStackTrace = debugCoroutineInfoImpl.h();
        this.sequenceNumber = debugCoroutineInfoImpl.f57085b;
    }

    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    public final String getDispatcher() {
        return this.dispatcher;
    }

    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final String getState() {
        return this.state;
    }
}
