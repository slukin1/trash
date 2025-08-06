package io.flutter.plugin.common;

import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;

public class MethodChannel {
    private static final String TAG = "MethodChannel#";
    /* access modifiers changed from: private */
    public final MethodCodec codec;
    private final BinaryMessenger messenger;
    /* access modifiers changed from: private */
    public final String name;
    private final BinaryMessenger.TaskQueue taskQueue;

    public final class IncomingMethodCallHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MethodCallHandler handler;

        public IncomingMethodCallHandler(MethodCallHandler methodCallHandler) {
            this.handler = methodCallHandler;
        }

        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMethodCall(MethodChannel.this.codec.decodeMethodCall(byteBuffer), new Result() {
                    public void error(String str, String str2, Object obj) {
                        binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelope(str, str2, obj));
                    }

                    public void notImplemented() {
                        binaryReply.reply((ByteBuffer) null);
                    }

                    public void success(Object obj) {
                        binaryReply.reply(MethodChannel.this.codec.encodeSuccessEnvelope(obj));
                    }
                });
            } catch (RuntimeException e11) {
                Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call", e11);
                binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelopeWithStacktrace("error", e11.getMessage(), (Object) null, Log.getStackTraceString(e11)));
            }
        }
    }

    public final class IncomingResultHandler implements BinaryMessenger.BinaryReply {
        private final Result callback;

        public IncomingResultHandler(Result result) {
            this.callback = result;
        }

        public void reply(ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                try {
                    this.callback.notImplemented();
                } catch (RuntimeException e11) {
                    Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call result", e11);
                }
            } else {
                try {
                    this.callback.success(MethodChannel.this.codec.decodeEnvelope(byteBuffer));
                } catch (FlutterException e12) {
                    this.callback.error(e12.code, e12.getMessage(), e12.details);
                }
            }
        }
    }

    public interface MethodCallHandler {
        void onMethodCall(MethodCall methodCall, Result result);
    }

    public interface Result {
        void error(String str, String str2, Object obj);

        void notImplemented();

        void success(Object obj);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    public void invokeMethod(String str, Object obj) {
        invokeMethod(str, obj, (Result) null);
    }

    public void resizeChannelBuffer(int i11) {
        BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, i11);
    }

    public void setMethodCallHandler(MethodCallHandler methodCallHandler) {
        IncomingMethodCallHandler incomingMethodCallHandler = null;
        if (this.taskQueue != null) {
            BinaryMessenger binaryMessenger = this.messenger;
            String str = this.name;
            if (methodCallHandler != null) {
                incomingMethodCallHandler = new IncomingMethodCallHandler(methodCallHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingMethodCallHandler, this.taskQueue);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.messenger;
        String str2 = this.name;
        if (methodCallHandler != null) {
            incomingMethodCallHandler = new IncomingMethodCallHandler(methodCallHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingMethodCallHandler);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this(binaryMessenger, str, methodCodec, (BinaryMessenger.TaskQueue) null);
    }

    public void invokeMethod(String str, Object obj, Result result) {
        IncomingResultHandler incomingResultHandler;
        BinaryMessenger binaryMessenger = this.messenger;
        String str2 = this.name;
        ByteBuffer encodeMethodCall = this.codec.encodeMethodCall(new MethodCall(str, obj));
        if (result == null) {
            incomingResultHandler = null;
        } else {
            incomingResultHandler = new IncomingResultHandler(result);
        }
        binaryMessenger.send(str2, encodeMethodCall, incomingResultHandler);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec, BinaryMessenger.TaskQueue taskQueue2) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = methodCodec;
        this.taskQueue = taskQueue2;
    }
}
