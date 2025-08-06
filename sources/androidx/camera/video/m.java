package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.video.StreamInfo;
import java.util.Objects;

public final class m extends StreamInfo {

    /* renamed from: d  reason: collision with root package name */
    public final int f6314d;

    /* renamed from: e  reason: collision with root package name */
    public final StreamInfo.StreamState f6315e;

    /* renamed from: f  reason: collision with root package name */
    public final SurfaceRequest.TransformationInfo f6316f;

    public m(int i11, StreamInfo.StreamState streamState, SurfaceRequest.TransformationInfo transformationInfo) {
        this.f6314d = i11;
        Objects.requireNonNull(streamState, "Null streamState");
        this.f6315e = streamState;
        this.f6316f = transformationInfo;
    }

    public int a() {
        return this.f6314d;
    }

    public SurfaceRequest.TransformationInfo b() {
        return this.f6316f;
    }

    public StreamInfo.StreamState c() {
        return this.f6315e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamInfo)) {
            return false;
        }
        StreamInfo streamInfo = (StreamInfo) obj;
        if (this.f6314d == streamInfo.a() && this.f6315e.equals(streamInfo.c())) {
            SurfaceRequest.TransformationInfo transformationInfo = this.f6316f;
            if (transformationInfo == null) {
                if (streamInfo.b() == null) {
                    return true;
                }
            } else if (transformationInfo.equals(streamInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.f6314d ^ 1000003) * 1000003) ^ this.f6315e.hashCode()) * 1000003;
        SurfaceRequest.TransformationInfo transformationInfo = this.f6316f;
        return hashCode ^ (transformationInfo == null ? 0 : transformationInfo.hashCode());
    }

    public String toString() {
        return "StreamInfo{id=" + this.f6314d + ", streamState=" + this.f6315e + ", inProgressTransformationInfo=" + this.f6316f + "}";
    }
}
