package androidx.camera.video.internal;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.a;

@AutoValue
public abstract class VideoValidatedEncoderProfilesProxy implements EncoderProfilesProxy {
    public static VideoValidatedEncoderProfilesProxy a(int i11, int i12, List<EncoderProfilesProxy.AudioProfileProxy> list, List<EncoderProfilesProxy.VideoProfileProxy> list2) {
        h.b(!list2.isEmpty(), "Should contain at least one VideoProfile.");
        return new a(i11, i12, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)), !list.isEmpty() ? list.get(0) : null, list2.get(0));
    }

    public static VideoValidatedEncoderProfilesProxy b(EncoderProfilesProxy encoderProfilesProxy) {
        return a(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), encoderProfilesProxy.getVideoProfiles());
    }

    public abstract EncoderProfilesProxy.AudioProfileProxy c();

    public abstract EncoderProfilesProxy.VideoProfileProxy d();
}
