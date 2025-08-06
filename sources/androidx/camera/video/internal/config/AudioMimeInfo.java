package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.MimeInfo;
import androidx.camera.video.internal.config.b;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AudioMimeInfo extends MimeInfo {

    @AutoValue.Builder
    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        public abstract AudioMimeInfo b();

        public abstract Builder c(EncoderProfilesProxy.AudioProfileProxy audioProfileProxy);
    }

    public static Builder c(String str) {
        return (Builder) new b.C0011b().d(str).a(-1);
    }

    public abstract EncoderProfilesProxy.AudioProfileProxy d();
}
