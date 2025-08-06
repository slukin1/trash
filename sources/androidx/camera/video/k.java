package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class k extends Recorder.i {

    /* renamed from: h  reason: collision with root package name */
    public final t f6299h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f6300i;

    /* renamed from: j  reason: collision with root package name */
    public final Consumer<v1> f6301j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f6302k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f6303l;

    /* renamed from: m  reason: collision with root package name */
    public final long f6304m;

    public k(t tVar, Executor executor, Consumer<v1> consumer, boolean z11, boolean z12, long j11) {
        Objects.requireNonNull(tVar, "Null getOutputOptions");
        this.f6299h = tVar;
        this.f6300i = executor;
        this.f6301j = consumer;
        this.f6302k = z11;
        this.f6303l = z12;
        this.f6304m = j11;
    }

    public boolean equals(Object obj) {
        Executor executor;
        Consumer<v1> consumer;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Recorder.i)) {
            return false;
        }
        Recorder.i iVar = (Recorder.i) obj;
        if (!this.f6299h.equals(iVar.r()) || ((executor = this.f6300i) != null ? !executor.equals(iVar.o()) : iVar.o() != null) || ((consumer = this.f6301j) != null ? !consumer.equals(iVar.p()) : iVar.p() != null) || this.f6302k != iVar.t() || this.f6303l != iVar.w() || this.f6304m != iVar.s()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (this.f6299h.hashCode() ^ 1000003) * 1000003;
        Executor executor = this.f6300i;
        int i11 = 0;
        int hashCode2 = (hashCode ^ (executor == null ? 0 : executor.hashCode())) * 1000003;
        Consumer<v1> consumer = this.f6301j;
        if (consumer != null) {
            i11 = consumer.hashCode();
        }
        int i12 = (hashCode2 ^ i11) * 1000003;
        int i13 = 1231;
        int i14 = (i12 ^ (this.f6302k ? 1231 : 1237)) * 1000003;
        if (!this.f6303l) {
            i13 = 1237;
        }
        long j11 = this.f6304m;
        return ((i14 ^ i13) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public Executor o() {
        return this.f6300i;
    }

    public Consumer<v1> p() {
        return this.f6301j;
    }

    public t r() {
        return this.f6299h;
    }

    public long s() {
        return this.f6304m;
    }

    public boolean t() {
        return this.f6302k;
    }

    public String toString() {
        return "RecordingRecord{getOutputOptions=" + this.f6299h + ", getCallbackExecutor=" + this.f6300i + ", getEventListener=" + this.f6301j + ", hasAudioEnabled=" + this.f6302k + ", isPersistent=" + this.f6303l + ", getRecordingId=" + this.f6304m + "}";
    }

    public boolean w() {
        return this.f6303l;
    }
}
