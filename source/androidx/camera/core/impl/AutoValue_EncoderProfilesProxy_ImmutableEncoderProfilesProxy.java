package androidx.camera.core.impl;

import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.List;
import java.util.Objects;

final class AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy extends EncoderProfilesProxy.ImmutableEncoderProfilesProxy {
    private final List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles;
    private final int defaultDurationSeconds;
    private final int recommendedFileFormat;
    private final List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;

    public AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy(int i11, int i12, List<EncoderProfilesProxy.AudioProfileProxy> list, List<EncoderProfilesProxy.VideoProfileProxy> list2) {
        this.defaultDurationSeconds = i11;
        this.recommendedFileFormat = i12;
        Objects.requireNonNull(list, "Null audioProfiles");
        this.audioProfiles = list;
        Objects.requireNonNull(list2, "Null videoProfiles");
        this.videoProfiles = list2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EncoderProfilesProxy.ImmutableEncoderProfilesProxy)) {
            return false;
        }
        EncoderProfilesProxy.ImmutableEncoderProfilesProxy immutableEncoderProfilesProxy = (EncoderProfilesProxy.ImmutableEncoderProfilesProxy) obj;
        if (this.defaultDurationSeconds != immutableEncoderProfilesProxy.getDefaultDurationSeconds() || this.recommendedFileFormat != immutableEncoderProfilesProxy.getRecommendedFileFormat() || !this.audioProfiles.equals(immutableEncoderProfilesProxy.getAudioProfiles()) || !this.videoProfiles.equals(immutableEncoderProfilesProxy.getVideoProfiles())) {
            return false;
        }
        return true;
    }

    public List<EncoderProfilesProxy.AudioProfileProxy> getAudioProfiles() {
        return this.audioProfiles;
    }

    public int getDefaultDurationSeconds() {
        return this.defaultDurationSeconds;
    }

    public int getRecommendedFileFormat() {
        return this.recommendedFileFormat;
    }

    public List<EncoderProfilesProxy.VideoProfileProxy> getVideoProfiles() {
        return this.videoProfiles;
    }

    public int hashCode() {
        return ((((((this.defaultDurationSeconds ^ 1000003) * 1000003) ^ this.recommendedFileFormat) * 1000003) ^ this.audioProfiles.hashCode()) * 1000003) ^ this.videoProfiles.hashCode();
    }

    public String toString() {
        return "ImmutableEncoderProfilesProxy{defaultDurationSeconds=" + this.defaultDurationSeconds + ", recommendedFileFormat=" + this.recommendedFileFormat + ", audioProfiles=" + this.audioProfiles + ", videoProfiles=" + this.videoProfiles + "}";
    }
}
