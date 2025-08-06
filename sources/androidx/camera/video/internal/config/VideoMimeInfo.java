package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.MimeInfo;
import androidx.camera.video.internal.config.c;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class VideoMimeInfo extends MimeInfo {

    @AutoValue.Builder
    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        public abstract VideoMimeInfo b();

        public abstract Builder c(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy);
    }

    public static Builder c(String str) {
        return (Builder) new c.b().d(str).a(-1);
    }

    public abstract EncoderProfilesProxy.VideoProfileProxy d();
}
