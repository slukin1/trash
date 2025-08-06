package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.videoplayer.Messages;
import java.util.HashMap;

public final /* synthetic */ class l {
    public static /* synthetic */ void l(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.initialize();
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void m(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", videoPlayerApi.create(Messages.CreateMessage.fromMap((HashMap) obj)).toMap());
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void n(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.setMixWithOthers(Messages.MixWithOthersMessage.fromMap((HashMap) obj));
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void o(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.dispose(Messages.TextureMessage.fromMap((HashMap) obj));
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void p(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.setLooping(Messages.LoopingMessage.fromMap((HashMap) obj));
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void q(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.setVolume(Messages.VolumeMessage.fromMap((HashMap) obj));
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void r(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.setPlaybackSpeed(Messages.PlaybackSpeedMessage.fromMap((HashMap) obj));
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void s(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.play(Messages.TextureMessage.fromMap((HashMap) obj));
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void t(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", videoPlayerApi.position(Messages.TextureMessage.fromMap((HashMap) obj)).toMap());
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void u(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.seekTo(Messages.PositionMessage.fromMap((HashMap) obj));
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void v(Messages.VideoPlayerApi videoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            videoPlayerApi.pause(Messages.TextureMessage.fromMap((HashMap) obj));
            hashMap.put("result", (Object) null);
        } catch (Exception e11) {
            hashMap.put("error", Messages.wrapError(e11));
        }
        reply.reply(hashMap);
    }

    public static void w(BinaryMessenger binaryMessenger, Messages.VideoPlayerApi videoPlayerApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.initialize", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel.setMessageHandler(new i(videoPlayerApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.create", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel2.setMessageHandler(new h(videoPlayerApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.dispose", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel3.setMessageHandler(new a(videoPlayerApi));
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.setLooping", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel4.setMessageHandler(new d(videoPlayerApi));
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.setVolume", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel5.setMessageHandler(new g(videoPlayerApi));
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.setPlaybackSpeed", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel6.setMessageHandler(new f(videoPlayerApi));
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.play", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel7.setMessageHandler(new k(videoPlayerApi));
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.position", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel8.setMessageHandler(new j(videoPlayerApi));
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.seekTo", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel9.setMessageHandler(new e(videoPlayerApi));
        } else {
            basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.pause", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel10.setMessageHandler(new b(videoPlayerApi));
        } else {
            basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.VideoPlayerApi.setMixWithOthers", new StandardMessageCodec());
        if (videoPlayerApi != null) {
            basicMessageChannel11.setMessageHandler(new c(videoPlayerApi));
        } else {
            basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
