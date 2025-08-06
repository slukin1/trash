package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoMimeInfo;
import java.util.Objects;

public final class c extends VideoMimeInfo {

    /* renamed from: a  reason: collision with root package name */
    public final String f6099a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6100b;

    /* renamed from: c  reason: collision with root package name */
    public final EncoderProfilesProxy.VideoProfileProxy f6101c;

    public static final class b extends VideoMimeInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f6102a;

        /* renamed from: b  reason: collision with root package name */
        public Integer f6103b;

        /* renamed from: c  reason: collision with root package name */
        public EncoderProfilesProxy.VideoProfileProxy f6104c;

        public VideoMimeInfo b() {
            String str = "";
            if (this.f6102a == null) {
                str = str + " mimeType";
            }
            if (this.f6103b == null) {
                str = str + " profile";
            }
            if (str.isEmpty()) {
                return new c(this.f6102a, this.f6103b.intValue(), this.f6104c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public VideoMimeInfo.Builder c(EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
            this.f6104c = videoProfileProxy;
            return this;
        }

        public VideoMimeInfo.Builder d(String str) {
            Objects.requireNonNull(str, "Null mimeType");
            this.f6102a = str;
            return this;
        }

        /* renamed from: e */
        public VideoMimeInfo.Builder a(int i11) {
            this.f6103b = Integer.valueOf(i11);
            return this;
        }
    }

    public String a() {
        return this.f6099a;
    }

    public int b() {
        return this.f6100b;
    }

    public EncoderProfilesProxy.VideoProfileProxy d() {
        return this.f6101c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoMimeInfo)) {
            return false;
        }
        VideoMimeInfo videoMimeInfo = (VideoMimeInfo) obj;
        if (this.f6099a.equals(videoMimeInfo.a()) && this.f6100b == videoMimeInfo.b()) {
            EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = this.f6101c;
            if (videoProfileProxy == null) {
                if (videoMimeInfo.d() == null) {
                    return true;
                }
            } else if (videoProfileProxy.equals(videoMimeInfo.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.f6099a.hashCode() ^ 1000003) * 1000003) ^ this.f6100b) * 1000003;
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = this.f6101c;
        return hashCode ^ (videoProfileProxy == null ? 0 : videoProfileProxy.hashCode());
    }

    public String toString() {
        return "VideoMimeInfo{mimeType=" + this.f6099a + ", profile=" + this.f6100b + ", compatibleVideoProfile=" + this.f6101c + "}";
    }

    public c(String str, int i11, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        this.f6099a = str;
        this.f6100b = i11;
        this.f6101c = videoProfileProxy;
    }
}
