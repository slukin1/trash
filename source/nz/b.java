package nz;

import creativemaybeno.wakelock.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class b implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.a f58712a;

    public /* synthetic */ b(Messages.a aVar) {
        this.f58712a = aVar;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        c.d(this.f58712a, obj, reply);
    }
}
