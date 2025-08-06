package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;

public final /* synthetic */ class k implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.VideoPlayerApi f55244a;

    public /* synthetic */ k(Messages.VideoPlayerApi videoPlayerApi) {
        this.f55244a = videoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        l.s(this.f55244a, obj, reply);
    }
}
