package androidx.camera.core.resolutionselector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ResolutionSelector {
    public static final int PREFER_CAPTURE_RATE_OVER_HIGHER_RESOLUTION = 0;
    public static final int PREFER_HIGHER_RESOLUTION_OVER_CAPTURE_RATE = 1;
    private final int mAllowedResolutionMode;
    private final AspectRatioStrategy mAspectRatioStrategy;
    private final ResolutionFilter mResolutionFilter;
    private final ResolutionStrategy mResolutionStrategy;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AllowedResolutionMode {
    }

    public ResolutionSelector(AspectRatioStrategy aspectRatioStrategy, ResolutionStrategy resolutionStrategy, ResolutionFilter resolutionFilter, int i11) {
        this.mAspectRatioStrategy = aspectRatioStrategy;
        this.mResolutionStrategy = resolutionStrategy;
        this.mResolutionFilter = resolutionFilter;
        this.mAllowedResolutionMode = i11;
    }

    public int getAllowedResolutionMode() {
        return this.mAllowedResolutionMode;
    }

    public AspectRatioStrategy getAspectRatioStrategy() {
        return this.mAspectRatioStrategy;
    }

    public ResolutionFilter getResolutionFilter() {
        return this.mResolutionFilter;
    }

    public ResolutionStrategy getResolutionStrategy() {
        return this.mResolutionStrategy;
    }

    public static final class Builder {
        private int mAllowedResolutionMode = 0;
        private AspectRatioStrategy mAspectRatioStrategy = AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY;
        private ResolutionFilter mResolutionFilter = null;
        private ResolutionStrategy mResolutionStrategy = null;

        public Builder() {
        }

        public static Builder fromResolutionSelector(ResolutionSelector resolutionSelector) {
            return new Builder(resolutionSelector);
        }

        public ResolutionSelector build() {
            return new ResolutionSelector(this.mAspectRatioStrategy, this.mResolutionStrategy, this.mResolutionFilter, this.mAllowedResolutionMode);
        }

        public Builder setAllowedResolutionMode(int i11) {
            this.mAllowedResolutionMode = i11;
            return this;
        }

        public Builder setAspectRatioStrategy(AspectRatioStrategy aspectRatioStrategy) {
            this.mAspectRatioStrategy = aspectRatioStrategy;
            return this;
        }

        public Builder setResolutionFilter(ResolutionFilter resolutionFilter) {
            this.mResolutionFilter = resolutionFilter;
            return this;
        }

        public Builder setResolutionStrategy(ResolutionStrategy resolutionStrategy) {
            this.mResolutionStrategy = resolutionStrategy;
            return this;
        }

        private Builder(ResolutionSelector resolutionSelector) {
            this.mAspectRatioStrategy = resolutionSelector.getAspectRatioStrategy();
            this.mResolutionStrategy = resolutionSelector.getResolutionStrategy();
            this.mResolutionFilter = resolutionSelector.getResolutionFilter();
            this.mAllowedResolutionMode = resolutionSelector.getAllowedResolutionMode();
        }
    }
}
