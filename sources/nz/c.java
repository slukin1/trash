package nz;

import creativemaybeno.wakelock.Messages;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.ArrayList;
import java.util.HashMap;

public final /* synthetic */ class c {
    public static MessageCodec<Object> c() {
        return Messages.b.f53467a;
    }

    public static /* synthetic */ void d(Messages.a aVar, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Messages.ToggleMessage toggleMessage = (Messages.ToggleMessage) ((ArrayList) obj).get(0);
            if (toggleMessage != null) {
                aVar.a(toggleMessage);
                hashMap.put("result", (Object) null);
                reply.reply(hashMap);
                return;
            }
            throw new NullPointerException("msgArg unexpectedly null.");
        } catch (Error | RuntimeException e11) {
            hashMap.put("error", Messages.b(e11));
        }
    }

    public static /* synthetic */ void e(Messages.a aVar, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", aVar.isEnabled());
        } catch (Error | RuntimeException e11) {
            hashMap.put("error", Messages.b(e11));
        }
        reply.reply(hashMap);
    }

    public static void f(BinaryMessenger binaryMessenger, Messages.a aVar) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WakelockApi.toggle", c());
        if (aVar != null) {
            basicMessageChannel.setMessageHandler(new b(aVar));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.WakelockApi.isEnabled", c());
        if (aVar != null) {
            basicMessageChannel2.setMessageHandler(new a(aVar));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
