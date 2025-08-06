package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;

public final /* synthetic */ class f implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.VideoPlayerApi f55239a;

    public /* synthetic */ f(Messages.VideoPlayerApi videoPlayerApi) {
        this.f55239a = videoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        l.r(this.f55239a, obj, reply);
    }
}
