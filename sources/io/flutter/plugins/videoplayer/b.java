package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;

public final /* synthetic */ class b implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.VideoPlayerApi f55235a;

    public /* synthetic */ b(Messages.VideoPlayerApi videoPlayerApi) {
        this.f55235a = videoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        l.v(this.f55235a, obj, reply);
    }
}
