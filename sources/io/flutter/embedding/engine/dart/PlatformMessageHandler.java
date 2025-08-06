package io.flutter.embedding.engine.dart;

import java.nio.ByteBuffer;

public interface PlatformMessageHandler {
    void handleMessageFromDart(String str, ByteBuffer byteBuffer, int i11, long j11);

    void handlePlatformMessageResponse(int i11, ByteBuffer byteBuffer);
}
