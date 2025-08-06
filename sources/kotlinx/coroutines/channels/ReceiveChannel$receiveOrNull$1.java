package kotlinx.coroutines.channels;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.ReceiveChannel;

@d(c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", f = "Channel.kt", l = {372}, m = "receiveOrNull")
public final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    public ReceiveChannel$receiveOrNull$1(c<? super ReceiveChannel$receiveOrNull$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReceiveChannel.DefaultImpls.b((ReceiveChannel) null, this);
    }
}
