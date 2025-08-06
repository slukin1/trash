package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.camera.core.impl.Timebase;

public interface n {
    Timebase a();

    MediaFormat b() throws InvalidConfigException;

    String getMimeType();
}
