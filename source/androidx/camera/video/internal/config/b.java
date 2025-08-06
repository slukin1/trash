package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.AudioMimeInfo;
import java.util.Objects;

public final class b extends AudioMimeInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f6093a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6094b;

    /* renamed from: c  reason: collision with root package name */
    public final EncoderProfilesProxy.AudioProfileProxy f6095c;

    /* renamed from: androidx.camera.video.internal.config.b$b  reason: collision with other inner class name */
    public static final class C0011b extends AudioMimeInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f6096a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f6097b;

        /* renamed from: c  reason: collision with root package name */
        public EncoderProfilesProxy.AudioProfileProxy f6098c;

        public AudioMimeInfo b() {
            String str = "";
            if (this.f6096a == null) {
                str = str + " mimeType";
            }
            if (this.f6097b == null) {
                str = str + " profile";
            }
            if (str.isEmpty()) {
                return new b(this.f6096a, this.f6097b.intValue(), this.f6098c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public AudioMimeInfo.Builder c(EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
            this.f6098c = audioProfileProxy;
            return this;
        }

        public AudioMimeInfo.Builder d(String str) {
            Objects.requireNonNull(str, "Null mimeType");
            this.f6096a = str;
            return this;
        }

        /* renamed from: e */
        public AudioMimeInfo.Builder a(int i11) {
            this.f6097b = Integer.valueOf(i11);
            return this;
        }
    }

    public String a() {
        return this.f6093a;
    }

    public int b() {
        return this.f6094b;
    }

    public EncoderProfilesProxy.AudioProfileProxy d() {
        return this.f6095c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioMimeInfo)) {
            return false;
        }
        AudioMimeInfo audioMimeInfo = (AudioMimeInfo) obj;
        if (this.f6093a.equals(audioMimeInfo.a()) && this.f6094b == audioMimeInfo.b()) {
            EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = this.f6095c;
            if (audioProfileProxy == null) {
                if (audioMimeInfo.d() == null) {
                    return true;
                }
            } else if (audioProfileProxy.equals(audioMimeInfo.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.f6093a.hashCode() ^ 1000003) * 1000003) ^ this.f6094b) * 1000003;
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = this.f6095c;
        return hashCode ^ (audioProfileProxy == null ? 0 : audioProfileProxy.hashCode());
    }

    public String toString() {
        return "AudioMimeInfo{mimeType=" + this.f6093a + ", profile=" + this.f6094b + ", compatibleAudioProfile=" + this.f6095c + "}";
    }

    public b(String str, int i11, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        this.f6093a = str;
        this.f6094b = i11;
        this.f6095c = audioProfileProxy;
    }
}
