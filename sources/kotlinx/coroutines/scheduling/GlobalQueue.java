package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.internal.q;

public final class GlobalQueue extends q<Task> {
    public GlobalQueue() {
        super(false);
    }
}
