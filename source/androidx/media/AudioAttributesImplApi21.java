package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f10084a;

    /* renamed from: b  reason: collision with root package name */
    public int f10085b = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f10084a.equals(((AudioAttributesImplApi21) obj).f10084a);
    }

    public int hashCode() {
        return this.f10084a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f10084a;
    }
}
