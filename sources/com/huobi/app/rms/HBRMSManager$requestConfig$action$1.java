package com.huobi.app.rms;

import com.huobi.app.rms.wrapper.PathFetchEvent;
import d10.a;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.greenrobot.eventbus.EventBus;

public final class HBRMSManager$requestConfig$action$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ a<Unit> $completion;
    public final /* synthetic */ Ref$BooleanRef $didCheck;
    public final /* synthetic */ ReentrantLock $lock;
    public final /* synthetic */ HBRMSManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$requestConfig$action$1(ReentrantLock reentrantLock, Ref$BooleanRef ref$BooleanRef, HBRMSManager hBRMSManager, a<Unit> aVar) {
        super(0);
        this.$lock = reentrantLock;
        this.$didCheck = ref$BooleanRef;
        this.this$0 = hBRMSManager;
        this.$completion = aVar;
    }

    public final void invoke() {
        this.$lock.lock();
        Ref$BooleanRef ref$BooleanRef = this.$didCheck;
        if (!ref$BooleanRef.element) {
            ref$BooleanRef.element = true;
            this.this$0.t();
        }
        EventBus.d().k(new PathFetchEvent());
        this.$completion.invoke();
        this.this$0.f42159m = true;
        this.$lock.unlock();
    }
}
