package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f10086a = versionedParcel.p(audioAttributesImplBase.f10086a, 1);
        audioAttributesImplBase.f10087b = versionedParcel.p(audioAttributesImplBase.f10087b, 2);
        audioAttributesImplBase.f10088c = versionedParcel.p(audioAttributesImplBase.f10088c, 3);
        audioAttributesImplBase.f10089d = versionedParcel.p(audioAttributesImplBase.f10089d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.f10086a, 1);
        versionedParcel.F(audioAttributesImplBase.f10087b, 2);
        versionedParcel.F(audioAttributesImplBase.f10088c, 3);
        versionedParcel.F(audioAttributesImplBase.f10089d, 4);
    }
}
