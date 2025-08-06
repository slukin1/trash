package nz;

import creativemaybeno.wakelock.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.a f58711a;

    public /* synthetic */ a(Messages.a aVar) {
        this.f58711a = aVar;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        c.e(this.f58711a, obj, reply);
    }
}
