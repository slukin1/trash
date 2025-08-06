package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;

public final /* synthetic */ class d implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.VideoPlayerApi f55237a;

    public /* synthetic */ d(Messages.VideoPlayerApi videoPlayerApi) {
        this.f55237a = videoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        l.p(this.f55237a, obj, reply);
    }
}
