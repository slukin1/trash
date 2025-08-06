package androidx.camera.core.impl;

public interface EncoderProfilesProvider {
    public static final EncoderProfilesProvider EMPTY = new EncoderProfilesProvider() {
        public EncoderProfilesProxy getAll(int i11) {
            return null;
        }

        public boolean hasProfile(int i11) {
            return false;
        }
    };

    EncoderProfilesProxy getAll(int i11);

    boolean hasProfile(int i11);
}
