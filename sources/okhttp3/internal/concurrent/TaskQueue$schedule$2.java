package okhttp3.internal.concurrent;

import d10.a;
import kotlin.jvm.internal.r;

public final class TaskQueue$schedule$2 extends Task {
    public final /* synthetic */ a<Long> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(String str, a<Long> aVar) {
        super(str, false, 2, (r) null);
        this.$block = aVar;
    }

    public long runOnce() {
        return this.$block.invoke().longValue();
    }
}
