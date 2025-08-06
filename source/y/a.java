package y;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.List;
import java.util.Objects;

public final class a extends VideoValidatedEncoderProfilesProxy {

    /* renamed from: a  reason: collision with root package name */
    public final int f16779a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16780b;

    /* renamed from: c  reason: collision with root package name */
    public final List<EncoderProfilesProxy.AudioProfileProxy> f16781c;

    /* renamed from: d  reason: collision with root package name */
    public final List<EncoderProfilesProxy.VideoProfileProxy> f16782d;

    /* renamed from: e  reason: collision with root package name */
    public final EncoderProfilesProxy.AudioProfileProxy f16783e;

    /* renamed from: f  reason: collision with root package name */
    public final EncoderProfilesProxy.VideoProfileProxy f16784f;

    public a(int i11, int i12, List<EncoderProfilesProxy.AudioProfileProxy> list, List<EncoderProfilesProxy.VideoProfileProxy> list2, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        this.f16779a = i11;
        this.f16780b = i12;
        Objects.requireNonNull(list, "Null audioProfiles");
        this.f16781c = list;
        Objects.requireNonNull(list2, "Null videoProfiles");
        this.f16782d = list2;
        this.f16783e = audioProfileProxy;
        Objects.requireNonNull(videoProfileProxy, "Null defaultVideoProfile");
        this.f16784f = videoProfileProxy;
    }

    public EncoderProfilesProxy.AudioProfileProxy c() {
        return this.f16783e;
    }

    public EncoderProfilesProxy.VideoProfileProxy d() {
        return this.f16784f;
    }

    public boolean equals(Object obj) {
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoValidatedEncoderProfilesProxy)) {
            return false;
        }
        VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy = (VideoValidatedEncoderProfilesProxy) obj;
        if (this.f16779a != videoValidatedEncoderProfilesProxy.getDefaultDurationSeconds() || this.f16780b != videoValidatedEncoderProfilesProxy.getRecommendedFileFormat() || !this.f16781c.equals(videoValidatedEncoderProfilesProxy.getAudioProfiles()) || !this.f16782d.equals(videoValidatedEncoderProfilesProxy.getVideoProfiles()) || ((audioProfileProxy = this.f16783e) != null ? !audioProfileProxy.equals(videoValidatedEncoderProfilesProxy.c()) : videoValidatedEncoderProfilesProxy.c() != null) || !this.f16784f.equals(videoValidatedEncoderProfilesProxy.d())) {
            return false;
        }
        return true;
    }

    public List<EncoderProfilesProxy.AudioProfileProxy> getAudioProfiles() {
        return this.f16781c;
    }

    public int getDefaultDurationSeconds() {
        return this.f16779a;
    }

    public int getRecommendedFileFormat() {
        return this.f16780b;
    }

    public List<EncoderProfilesProxy.VideoProfileProxy> getVideoProfiles() {
        return this.f16782d;
    }

    public int hashCode() {
        int hashCode = (((((((this.f16779a ^ 1000003) * 1000003) ^ this.f16780b) * 1000003) ^ this.f16781c.hashCode()) * 1000003) ^ this.f16782d.hashCode()) * 1000003;
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = this.f16783e;
        return ((hashCode ^ (audioProfileProxy == null ? 0 : audioProfileProxy.hashCode())) * 1000003) ^ this.f16784f.hashCode();
    }

    public String toString() {
        return "VideoValidatedEncoderProfilesProxy{defaultDurationSeconds=" + this.f16779a + ", recommendedFileFormat=" + this.f16780b + ", audioProfiles=" + this.f16781c + ", videoProfiles=" + this.f16782d + ", defaultAudioProfile=" + this.f16783e + ", defaultVideoProfile=" + this.f16784f + "}";
    }
}
