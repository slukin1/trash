package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

public interface h extends AutoCloseable {
    void close();

    ByteBuffer d();

    MediaCodec.BufferInfo h();

    boolean i();

    long q();

    long size();
}
