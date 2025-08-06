package okhttp3.internal.concurrent;

import d10.a;
import kotlin.Unit;

public final class TaskQueue$execute$1 extends Task {
    public final /* synthetic */ a<Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(String str, boolean z11, a<Unit> aVar) {
        super(str, z11);
        this.$block = aVar;
    }

    public long runOnce() {
        this.$block.invoke();
        return -1;
    }
}
