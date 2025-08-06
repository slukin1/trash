package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.videoplayer.Messages;

public final /* synthetic */ class j implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.VideoPlayerApi f55243a;

    public /* synthetic */ j(Messages.VideoPlayerApi videoPlayerApi) {
        this.f55243a = videoPlayerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        l.t(this.f55243a, obj, reply);
    }
}
