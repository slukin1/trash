package androidx.camera.core.impl;

import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;

public class ResolutionValidatedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final EncoderProfilesResolutionValidator mEncoderProfilesResolutionValidator;
    private final EncoderProfilesProvider mProvider;

    public ResolutionValidatedEncoderProfilesProvider(EncoderProfilesProvider encoderProfilesProvider, Quirks quirks) {
        this.mProvider = encoderProfilesProvider;
        this.mEncoderProfilesResolutionValidator = new EncoderProfilesResolutionValidator(quirks.getAll(ProfileResolutionQuirk.class));
    }

    public EncoderProfilesProxy getAll(int i11) {
        if (!this.mProvider.hasProfile(i11)) {
            return null;
        }
        EncoderProfilesProxy all = this.mProvider.getAll(i11);
        return this.mEncoderProfilesResolutionValidator.hasQuirk() ? this.mEncoderProfilesResolutionValidator.filterInvalidVideoResolution(all) : all;
    }

    public boolean hasProfile(int i11) {
        if (!this.mProvider.hasProfile(i11)) {
            return false;
        }
        if (!this.mEncoderProfilesResolutionValidator.hasQuirk()) {
            return true;
        }
        return this.mEncoderProfilesResolutionValidator.hasValidVideoResolution(this.mProvider.getAll(i11));
    }
}
