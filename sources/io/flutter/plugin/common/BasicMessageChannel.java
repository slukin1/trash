package io.flutter.plugin.common;

import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    private static final String TAG = "BasicMessageChannel#";
    /* access modifiers changed from: private */
    public final MessageCodec<T> codec;
    private final BinaryMessenger messenger;
    /* access modifiers changed from: private */
    public final String name;
    private final BinaryMessenger.TaskQueue taskQueue;

    public final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MessageHandler<T> handler;

        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(byteBuffer), new Reply<T>() {
                    public void reply(T t11) {
                        binaryReply.reply(BasicMessageChannel.this.codec.encodeMessage(t11));
                    }
                });
            } catch (RuntimeException e11) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message", e11);
                binaryReply.reply((ByteBuffer) null);
            }
        }

        private IncomingMessageHandler(MessageHandler<T> messageHandler) {
            this.handler = messageHandler;
        }
    }

    public final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        private final Reply<T> callback;

        public void reply(ByteBuffer byteBuffer) {
            try {
                this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(byteBuffer));
            } catch (RuntimeException e11) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message reply", e11);
            }
        }

        private IncomingReplyHandler(Reply<T> reply) {
            this.callback = reply;
        }
    }

    public interface MessageHandler<T> {
        void onMessage(T t11, Reply<T> reply);
    }

    public interface Reply<T> {
        void reply(T t11);
    }

    public BasicMessageChannel(BinaryMessenger binaryMessenger, String str, MessageCodec<T> messageCodec) {
        this(binaryMessenger, str, messageCodec, (BinaryMessenger.TaskQueue) null);
    }

    public void resizeChannelBuffer(int i11) {
        resizeChannelBuffer(this.messenger, this.name, i11);
    }

    public void send(T t11) {
        send(t11, (Reply) null);
    }

    public void setMessageHandler(MessageHandler<T> messageHandler) {
        IncomingMessageHandler incomingMessageHandler = null;
        if (this.taskQueue != null) {
            BinaryMessenger binaryMessenger = this.messenger;
            String str = this.name;
            if (messageHandler != null) {
                incomingMessageHandler = new IncomingMessageHandler(messageHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingMessageHandler, this.taskQueue);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.messenger;
        String str2 = this.name;
        if (messageHandler != null) {
            incomingMessageHandler = new IncomingMessageHandler(messageHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingMessageHandler);
    }

    public BasicMessageChannel(BinaryMessenger binaryMessenger, String str, MessageCodec<T> messageCodec, BinaryMessenger.TaskQueue taskQueue2) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = messageCodec;
        this.taskQueue = taskQueue2;
    }

    public static void resizeChannelBuffer(BinaryMessenger binaryMessenger, String str, int i11) {
        binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", new Object[]{str, Integer.valueOf(i11)}).getBytes(Charset.forName("UTF-8"))));
    }

    public void send(T t11, Reply<T> reply) {
        BinaryMessenger binaryMessenger = this.messenger;
        String str = this.name;
        ByteBuffer encodeMessage = this.codec.encodeMessage(t11);
        IncomingReplyHandler incomingReplyHandler = null;
        if (reply != null) {
            incomingReplyHandler = new IncomingReplyHandler(reply);
        }
        binaryMessenger.send(str, encodeMessage, incomingReplyHandler);
    }
}
