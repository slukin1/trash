package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioStream;

public final class t extends AudioStream.PacketInfo {

    /* renamed from: a  reason: collision with root package name */
    public final int f6074a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6075b;

    public t(int i11, long j11) {
        this.f6074a = i11;
        this.f6075b = j11;
    }

    public int a() {
        return this.f6074a;
    }

    public long b() {
        return this.f6075b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioStream.PacketInfo)) {
            return false;
        }
        AudioStream.PacketInfo packetInfo = (AudioStream.PacketInfo) obj;
        if (this.f6074a == packetInfo.a() && this.f6075b == packetInfo.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j11 = this.f6075b;
        return ((this.f6074a ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "PacketInfo{sizeInBytes=" + this.f6074a + ", timestampNs=" + this.f6075b + "}";
    }
}
